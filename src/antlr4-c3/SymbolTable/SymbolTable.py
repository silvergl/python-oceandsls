#!/usr/bin/env python
# TODO check source
from __future__ import annotations

__author__ = 'sgu'

# TODO license

#
#  Port of antlr-c3 typescript symbol table implementation to python
#

import asyncio
from enum import Enum
from dataclasses import dataclass
from typing import Optional, List, TypeVar, Generic, Callable, ParamSpec, Set

from antlr4.tree.Tree import ParseTree

P = ParamSpec("P")

# TODO check raise Exception
# class DuplicateSymbolError(Error):

class MemberVisibility(Enum):
    # Not specified, default depends on the language and type.
    Unknown = 0
    # Used in Swift, member can be accessed outside of the defining module and extended.
    Open = 1
    # Like Open, but in Swift such a type cannot be extended.
    Public = 2
    # Member is only accessible in the defining class and any derived class.
    Protected = 3
    # Member can only be accessed from the defining class.
    Private = 4
    # Used in Swift, member can be accessed from everywhere in a defining module, not outside however.
    FilePrivate = 5
    # Custom enum for special usage.
    Library = 6

class Modifier(Enum):
    Static = 0
    Final = 1
    Sealed = 2
    Abstract = 3
    Deprecated = 4
    Virtual = 5
    Const = 6
    Overwritten = 7

# Rough categorization of a type.
class TypeKind(Enum):
    Unknown = 0
    Integer = 1
    Float = 2
    int = 3
    str = 4
    Char = 5
    bool = 6
    Class = 7
    Interface = 8
    Array = 9
    Map = 10
    Enum = 11
    Alias = 12

class ReferenceKind(Enum):
    Irrelevant = 0
    # Default for most languages for dynamically allocated memory ('Type*' in C++).
    Pointer = 1
    # 'Type&' in C++
    Reference = 2
    # 'Type' as such and default for all value types.
    Instance = 3

# The root type interface. Used for typed symbols and type aliases.
@dataclass
class Type:
    name: str

    # The super type of this type or empty if this is a fundamental type.
    # Also used as the target type for type aliases.
    baseTypes: List[Type]
    kind: TypeKind
    reference: ReferenceKind

# TODO https://stackoverflow.com/q/70809438
class SymbolTableOptions:
    allowDuplicateSymbols: Optional[bool] = None

# A single class for all fundamental types. They are distinguished via the kind field.
class FundamentalType(Type):
    @property
    def integerType(self) -> FundamentalType:
        return FundamentalType("int", TypeKind.Integer, ReferenceKind.Instance)
    @property
    def floatType(self) -> FundamentalType:
        return FundamentalType("float", TypeKind.Float, ReferenceKind.Instance)
    @property
    def stringType(self) -> FundamentalType:
        return FundamentalType("string", TypeKind.String, ReferenceKind.Instance)
    @property
    def boolType(self) -> FundamentalType:
        return FundamentalType("bool", TypeKind.Boolean, ReferenceKind.Instance)

    name: str

    typeKind: TypeKind
    referenceKind: ReferenceKind

    def __init__(self, name: str, typeKind = TypeKind.Unknown, referenceKind = ReferenceKind.Irrelevant):
        self.name = name
        self.typeKind = typeKind
        self.referenceKind = referenceKind

    def baseTypes(self) -> List[Type]:
        return []

    def kind(self) -> TypeKind:
        return self.typeKind

    def reference(self) -> ReferenceKind:
        return self.referenceKind

#
# The root of the symbol table class hierarchy: a symbol can be any manageable entity (like a block), not only
# things like variables or classes.
# We are using a class hierarchy here, instead of an enum or similar, to allow for easy extension and certain
# symbols can so provide additional APIs for simpler access to their sub elements, if needed.
#
class Symbol:
    # The name of the scopeor empty if anonymous.
    name: str = ''

    # Reference to the parse tree which contains this symbol.
    context: Optional[ParseTree] = None

    @property
    def modifiers(self) -> Set[int]:
        return set()

    visibility: MemberVisibility = MemberVisibility.Unknown

    # eslint-disable-next-line no-use-before-define
    theParent: Optional[Symbol] = None

    def __init__(self, name: str = ''):
        self.name = name

    def parent(self) -> Optional[Symbol]:
        return self.theParent

    def firstSibling(self) -> Symbol:
        if isinstance(self.theParent, ScopedSymbol):
            return self.theParent.firstChild

        return self

    # @returns the symbol before this symbol in its scope.
    def previousSibling(self) -> Optional[Symbol]:
        if not isinstance(self.theParent, ScopedSymbol):
            return self

        return self.theParent.previousSiblingOf(self)

    # @returns the symbol following this symbol in its scope.
    def nextSibling(self) -> Optional[Symbol]:
        if not isinstance(self.theParent, ScopedSymbol):
            return self

        return self.theParent.nextSiblingOf(self)

    def lastSibling(self) -> Symbol:
        if isinstance(self.theParent, ScopedSymbol):
            return self.theParent.lastChild

        return self

    # @returns the next symbol in definition order, regardless of the scope.
    def next(self) -> Optional[Symbol]:
        if isinstance(self.theParent, ScopedSymbol):
            return self.theParent.nextOf(self)

        return None

    # @returns the outermost entity (below the symbol table) that holds us.
    def root(self) -> Optional[Symbol]:
        run: bool = self.theParent
        while (run):
            if not run.theParent or isinstance(run.theParent, SymbolTable):
                return run
            run = run.theParent

        return run

    # @returns the symbol table we belong too or undefined if we are not yet assigned.
    def symbolTable(self) -> Optional[Symbol]:
        if isinstance(self, SymbolTable):
            return self

        run: bool = self.theParent
        while (run):
            if isinstance(run, SymbolTable):
                return run
            run = run.theParent

        return None

    # @returns the list of symbols from this one up to root.
    def symbolPath(self) -> List[Symbol]:
        result: List[Symbol] = []

        # eslint-disable-next-line @typescript-eslint/no-this-alias
        run: Symbol = self
        while (run):
            result.append(run)
            if not run.theParent:
                break
            run = run.theParent

        return result

    #
    # The parent is usually a scoped symbol as only those can have children, but we allow
    # any symbol here for special scenarios.
    # This is rather an internal method and should rarely be used by external code.
    #
    # @param parent The new parent to use.
    #
    def setParent(self, parent: Optional[Symbol]) -> None:
        self.theParent = parent

    def removeFromParent(self) -> None:
        if isinstance(self.theParent, ScopedSymbol):
            self.theParent.removeSymbol(self)
            self.theParent = None

    #
    # Asynchronously looks up a symbol with a given name, in a bottom-up manner.
    #
    # @param name The name of the symbol to find.
    # @param localOnly If true only child symbols are returned, otherwise also symbols from the parent of this symbol
    #                  (recursively).
    #
    # @returns A promise resolving to the first symbol with a given name, in the order of appearance in this scope
    #          or any of the parent scopes (conditionally).
    # TODO https://stackoverflow.com/q/42009202/
    async def resolve(self, name: str, localOnly: bool = False) -> Optional[Symbol]:
        if isinstance(self.theParent, ScopedSymbol):
            return self.theParent.resolve(name, localOnly)

        return resolve(None)

    #
    # Synchronously looks up a symbol with a given name, in a bottom-up manner.
    #
    # @param name The name of the symbol to find.
    # @param localOnly If true only child symbols are returned, otherwise also symbols from the parent of this symbol
    #                  (recursively).
    #
    # @returns the first symbol with a given name, in the order of appearance in this scope
    #          or any of the parent scopes (conditionally).
    def resolveSync(self, name: str, localOnly = False) -> Optional[Symbol]:
        if isinstance(self.theParent, ScopedSymbol):
            return self.theParent.resolveSync(name, localOnly)

        return None

    #
    # @param t The type of objects to return.
    #
    #
    # @returns the next enclosing parent of the given type.
    # TODO check function argument type of List https://stackoverflow.com/q/46105206/
    T = TypeVar('T', bound=Symbol)
    def getParentOfType(self, t: Callable[P, T]) -> tuple[T, None]:
        run = self.theParent
        while (run):
            if isinstance(run,  t):
                return run
            run = run.theParent

        return None

    #
    # Creates a qualified identifier from this symbol and its parent.
    # If `full` is true then all parents are traversed in addition to this instance.
    #
    # @param separator The string to be used between the parts.
    # @param full A flag indicating if the full path is to be returned.
    # @param includeAnonymous Use a special string for empty scope names.
    #
    # @returns the constructed qualified identifier.
    # TODO special string for empty scope names
    def qualifiedName(self, separator = ".", full = False, includeAnonymous = False) -> str:
        if not includeAnonymous and len(self.name) == 0:
            return ''

        result: str = "<anonymous>" if len(self.name) == 0 else self.name
        run = self.theParent
        while (run):
            if includeAnonymous or len(run.name) > 0:
                result = ("<anonymous>" if len(run.name) == 0 else run.name) + separator + result

            if full is not None or run.theParent is not None:
                break

            run = run.theParent

        return result

# A symbol with an attached type (variables, fields etc.).
class TypedSymbol(Symbol):
    type: tuple[Type, None]

    # TODO check super call
    def __init__(self, name: str, type: Type = None):
        super().__init__(name)
        self.type = type

# An alias for another type.
class TypeAlias(Symbol, Type):
    targetType: Type

    def __init__(self, name: str, target: Type):
        super().__init__(name)
        self.targetType = target

    def baseTypes(self) -> List[Type]:
        return [self.targetType]

    def kind(self) -> TypeKind:
        return TypeKind.Alias

    def reference(self) -> ReferenceKind:
        return ReferenceKind.Irrelevant

# A symbol with a scope (so it can have child symbols).
class ScopedSymbol(Symbol):

    # All child symbols in definition order.
    childSymbols: List[Symbol] = []

    def __init__(name: str = ""):
        super().__init__(name)

    #
    # @returns A promise resolving to all direct child symbols with a scope (e.g. classes in a module).
    def directScopes(self) -> List[ScopedSymbol]:
        return self.getSymbolsOfType(ScopedSymbol)

    def children(self) -> List[Symbol]:
        return self.childSymbols

    def firstChild(self) -> Optional[Symbol]:
        if len(self.children) > 0:
            return self.children()[0]

        return None

    def lastChild(self) -> Optional[Symbol]:
        if len(self.children) > 0:
            return self.children()[len(self.children) - 1]

        return None

    def clear(self) -> None:
        self.childSymbols = []

    #
    # Adds the given symbol to this scope. If it belongs already to a different scope
    # it is removed from that before adding it here.
    #
    # @param symbol The symbol to add as a child.

    def addSymbol(self, symbol: Symbol) -> None:
        symbol.removeFromParent()

        # Check for duplicates first.
        symbolTable = self.symbolTable
        if symbolTable is not None or symbolTable.options.allowDuplicateSymbols is not None:
            for child in self.children():
                if child == symbol or (len(symbol.name) > 0 and child.name == symbol.name):
                    name = symbol.name
                    if len(name) == 0:
                        name = "<anonymous>"

                    raise Exception("ERROR: Attempt to add duplicate symbol %d'" % (name))

        self.children.append(symbol)
        symbol.setParent(self)

    def removeSymbol(self, symbol: Symbol) -> None:
        if symbol in self.children:
            self.children.remove(symbol)
            symbol.setParent(None)

    #
    # Asynchronously retrieves child symbols of a given type from this symbol.
    #
    # @param t The type of of the objects to return.
    #
    # @returns A promise resolving to all (nested) children of the given type.
    async def getNestedSymbolsOfType(self, t: Callable[P, T]) -> List[T]:
        result: List[T] = []

        childPromises: List[T] = []
        for child in self.children:
            if isinstance(child, t):
                result.append(child)

            if isinstance(child, ScopedSymbol):
                childPromises.append(child.getNestedSymbolsOfType(t))

        # TODO check await https://stackoverflow.com/q/42009202/
        childSymbols = await Promise.all(childPromises)
        for entry in childSymbols:
            result.append(entry)

        return result

    #
    # Synchronously retrieves child symbols of a given type from this symbol.
    #
    # @param t The type of of the objects to return.
    #
    # @returns A list of all (nested) children of the given type.
    def getNestedSymbolsOfTypeSync(self, t: Callable[P, T]) -> List[T]:
        result: List[T] = []

        for child in self.children:
            if isinstance(child, t):
                result.append(child)

            if isinstance(child, ScopedSymbol):
                result.appendchild.getNestedSymbolsOfTypeSync(t)

        return result

    #
    # @param name If given only returns symbols with that name.
    #
    # @returns A promise resolving to symbols from this and all nested scopes in the order they were defined.
    async def getAllNestedSymbols(self, name: str = None) -> List[Symbol]:
        result: List[Symbol] = []

        childPromises: List[List[Symbol]] = []
        for child in self.children:
            if name is not None or child.name == name:
                result.append(child)

            if isinstance(child, ScopedSymbol):
                childPromises.append(child.getAllNestedSymbols(name))

        # TODO check await https://stackoverflow.com/q/42009202/
        childSymbols = await childPromises
        for entry in childSymbols:
            result.append(entry)

        return result

    #
    # @param name If given only returns symbols with that name.
    #
    # @returns A list of all symbols from this and all nested scopes in the order they were defined.
    def getAllNestedSymbolsSync(self, name: str = None) -> List[Symbol]:
        result: List[Symbol] = []

        for child in self.children:
            if name is not None or child.name == name:
                result.append(child)

            if isinstance(child, ScopedSymbol):
                result.append(child.getAllNestedSymbolsSync(name))

        return result

    #
    # @param t The type of of the objects to return.
    #
    # @returns A promise resolving to direct children of a given type.
    def getSymbolsOfType(self, t: Callable[P, T]) -> List[T]:
        return lambda t :
            result: List[T] = []
            for child in self.children:
                if isinstance(child, t):
                    result.append(child)

            result

        #
        # TODO: add optional position dependency (only symbols defined before a given caret pos are viable).
        #
        # @param t The type of the objects to return.
        # @param localOnly If true only child symbols are returned, otherwise also symbols from the parent of this symbol
        #                  (recursively).
        #
        # @returns A promise resolving to all symbols of the the given type, accessible from this scope (if localOnly is
        #          false), within the owning symbol table.

        async def getAllSymbols(self, t: Callable[P, T], localOnly = False) -> List[T]:
            result: List[T] = []

            # Special handling for namespaces, which act like grouping symbols in this scope,
            # so we show them as available in this scope.
            for child in self.children:
                if isinstance(child, t):
                    result.append(child)

                if isinstance(child, NamespaceSymbol):
                    childSymbols = await child.getAllSymbols(t, True)
                    result.append(childSymbols)

            if not localOnly:
                if isinstance(self.parent, ScopedSymbol):
                    childSymbols = await self.getAllSymbols(t, True)
                    result.append(childSymbols)

            return result

        #
        # TODO: add optional position dependency (only symbols defined before a given caret pos are viable).
        #
        # @param t The type of the objects to return.
        # @param localOnly If true only child symbols are returned, otherwise also symbols from the parent of this symbol
        #                  (recursively).
        #
        # @returns A list with all symbols of the the given type, accessible from this scope (if localOnly is
        #          false), within the owning symbol table.
        def getAllSymbolsSync(self, t: Callable[P, T], localOnly: bool = False) -> List[T]:
            result: List[T] = []

            # Special handling for namespaces, which act like grouping symbols in this scope,
            # so we show them as available in this scope.
            for child in self.children:
                if isinstance(child, t):
                    result.append(child)

                if isinstance(child, NamespaceSymbol):
                    childSymbols = child.getAllSymbolsSync(t, True)
                    result.append(childSymbols)

            if not localOnly:
                if isinstance(self.parent, ScopedSymbol):
                    childSymbols = self.getAllSymbolsSync(t, True)
                    result.append(childSymbols)

            return result

        #
        # @param name The name of the symbol to resolve.
        # @param localOnly If true only child symbols are returned, otherwise also symbols from the parent of this symbol
        #                  (recursively).
        #
        # @returns A promise resolving to the first symbol with a given name, in the order of appearance in this scope
        #          or any of the parent scopes (conditionally).
        def resolve(self, name: str, localOnly = False) -> Optional[Symbol]:
            # create a future
            future = asyncio.Future()

            @asyncio.create_task
            async def find():
                for child in self.children:
                    if child.name == name:
                        future.set_result(child)

                # Nothing found locally. Let the parent continue.
                if not (future.done() or localOnly):
                    if isinstance(self.parent, ScopedSymbol):
                        future.set_result(self.parent.resolve(name, False))

                if not future.done()
                    future.set_result(None)

            # return the future
            return future

        #
        # @param name The name of the symbol to resolve.
        # @param localOnly If true only child symbols are returned, otherwise also symbols from the parent of this symbol
        #                  (recursively).
        #
        # @returns the first symbol with a given name, in the order of appearance in this scope
        #          or any of the parent scopes (conditionally).
        def resolveSync(self, name: str, localOnly = False) -> Optional[Symbol]:
            for child in self.children:
                if child.name == name:
                    return child

            # Nothing found locally. the parent continues.
            if not localOnly:
                if isinstance(self.parent, ScopedSymbol):
                    return self.parent.resolveSync(name, False)

            return None

        #
        # @param localOnly If true only child symbols are returned, otherwise also symbols from the parent of this symbol
        #                  (recursively).
        #
        # @returns all accessible symbols that have a type assigned.
        def getTypedSymbols(self, localOnly = True) -> List[TypedSymbol]:
            result: List[TypedSymbol] = []

            for child in self.children:
                if isinstance(child, TypedSymbol):
                    result.append(child)

            if not localOnly:
                if isinstance(self.parent, ScopedSymbol):
                    localList = self.parent.getTypedSymbols(True)
                    result.append(localList)

            return result

        #
        # The names of all accessible symbols with a type.
        #
        # @param localOnly If true only child symbols are returned, otherwise also symbols from the parent of this symbol
        #                  (recursively).
        #
        # @returns A list of names.
        def getTypedSymbolNames(self, localOnly = True) -> List[str]:
            result: List[str] = []
            for child in self.children:
                if isinstance(child, TypedSymbol):
                    result.append(child.name)

            if not localOnly:
                if isinstance(self.parent, ScopedSymbol):
                    localList = self.parent.getTypedSymbolNames(True)
                    result.append(localList)

            return result

        #
        # @param path The path consisting of symbol names separator by `separator`.
        # @param separator The character to separate path segments.
        #
        # @returns the symbol located at the given path through the symbol hierarchy.
        def symbolFromPath(self, path: str, separator = ".") -> Optional[Symbol]:
            elements = path.split(separator)
            index = 0
            if elements[0] == self.name or len(elements[0]) == 0:
                index += 1

            # eslint-disable-next-line @typescript-eslint/no-this-alias
            result: Symbol = self
            while (index < len(elements)):
                if not isinstance(result, ScopedSymbol):
                    return None

                # eslint-disable-next-line no-loop-func
                child = next(filter(lambda candidate: candidate.name == elements[index], result.children), None)
                if child is not None:
                    return None

                result = child
                index += 1

            return result

        #
        # @param child The child to search for.
        #
        # @returns the index of the given child symbol in the child list or -1 if it couldn't be found.
        def indexOfChild(self, child: Symbol) -> int:
            # two pass org
            # return lambda child,self.children : self.children.index(child) if child in self.children else -1
            try:
                return self.children.index(child)
            except ValueError:
                return -1

        #
        # @param child The reference node.
        #
        # @returns the sibling symbol after the given child symbol, if one exists.
        def nextSiblingOf(self, child: Symbol) -> Optional[Symbol]:
            index = self.indexOfChild(child)
            if index == -1 or index >= len(self.children) - 1:
                return None

            return self.children[index + 1]

        #
        # @param child The reference node.
        #
        # @returns the sibling symbol before the given child symbol, if one exists.
        def previousSiblingOf(self, child: Symbol) -> Optional[Symbol]:
            index = self.indexOfChild(child)
            if index < 1:
                return None

            return self.children[index - 1]

        #
        # @param child The reference node.
        #
        # @returns the next symbol in definition order, regardless of the scope.
        def nextOf(self, child: Symbol) -> Optional[Symbol]:
            if not isinstance(child.parent, ScopedSymbol):
                return None

            if child.parent is not self:
                return child.parent.nextOf(child)

            if isinstance(child, ScopedSymbol) and len(child.children) > 0:
                return child.children[0]

            sibling = self.nextSiblingOf(child)
            if sibling is not None:
                return sibling

            return self.parent.nextOf(self)

    class NamespaceSymbol(ScopedSymbol):

    class BlockSymbol(ScopedSymbol):

    class VariableSymbol(TypedSymbol):

        def __init__(self, name: str, value, type: Type = None):
            super().__init__(name, type)

            # eslint-disable-next-line @typescript-eslint/no-unsafe-assignment
            self.value = value

    class LiteralSymbol(TypedSymbol):

        def __init__(self, name: str, value, type: Type = None):
            super().__init__(name, type)

            # eslint-disable-next-line @typescript-eslint/no-unsafe-assignment
            self._value = value

        @property
        def value(self):
            return self._value

    class ParameterSymbol(VariableSymbol):

    # A standalone function/procedure/rule.
    class RoutineSymbol(ScopedSymbol):
        returnType: Optional[Type] = None # Can be null if result is void.

        def __init__(self, name: str, returnType: Type):
            super().__init__(name)
            self.returnType = returnType

        def getVariables(self, localOnly = True) -> List[VariableSymbol]:
            return self.getSymbolsOfType(VariableSymbol)

        def getParameters(self, localOnly = True) -> List[ParameterSymbol]:
            return self.getSymbolsOfType(ParameterSymbol)

    class MethodFlags(Enum):
        None = 0
        Virtual = 1
        Const = 2
        Overwritten = 4

        # Distinguished by the return type.
        SetterOrGetter = 8

        # Special flag used e.g. in C++ for explicit c-tors.
        Explicit = 16

    # A function which belongs to a class or other outer container structure.
    class MethodSymbol(RoutineSymbol):
        methodFlags = MethodFlags.None

    # A field which belongs to a class or other outer container structure.
    class FieldSymbol(VariableSymbol):
        setter: Optional[MethodSymbol] = None
        getter: Optional[MethodSymbol] = None

    # Classes and structs.
    class ClassSymbol(ScopedSymbol, Type):
        isStruct = False
        reference = ReferenceKind.Irrelevant

        # Usually only one member, unless the language supports multiple inheritance (like C++).
        # eslint-disable-next-line no-use-before-define
        @property
        def extends(self) -> List[ClassSymbol]:
            return self._extends


        # Typescript allows a class to implement a class, not only interfaces.
        # eslint-disable-next-line no-use-before-define
        @property
        def implements(self) -> List[tuple[ClassSymbol, InterfaceSymbol]]:
            return self._implements

        def __init__(self, name: str, ext: List[ClassSymbol], impl: List[tuple[ClassSymbol, InterfaceSymbol]]):
            super().__init__(name)
            self._extends = ext
            self._implements = impl

        def baseTypes(self) -> List[Type]:
            return self._extends

        def kind(self) -> TypeKind:
            return TypeKind.Class

        #
        # @param includeInherited Not used.
        #
        # @returns a list of all methods.
        def getMethods(self, includeInherited = False) -> List[MethodSymbol]:
            return self.getSymbolsOfType(MethodSymbol)

        #
        # @param includeInherited Not used.
        #
        # @returns all fields.
        def getFields(self, includeInherited = False) -> List[FieldSymbol]:
            return self.getSymbolsOfType(FieldSymbol)

    class InterfaceSymbol(ScopedSymbol, Type):
        reference = ReferenceKind.Irrelevant

        # Typescript allows an interface to extend a class, not only interfaces.
        # eslint-disable-next-line no-use-before-define

        def __init__(self, name: str, ext: List[tuple[ClassSymbol, InterfaceSymbol]]):
            super().__init__(name)
            self._extends = ext

        @property
        def extends(self) -> List[tuple[ClassSymbol, InterfaceSymbol]]:
            self._extends

        def baseTypes(self) -> List[Type]:
            return self._extends

        def kind(self) -> TypeKind:
            return TypeKind.Interface

        #
        # @param includeInherited Not used.
        #
        # @returns a list of all methods.
        def getMethods(self, includeInherited = False) -> List[MethodSymbol]:
            return self.getSymbolsOfType(MethodSymbol)

        #
        # @param includeInherited Not used.
        #
        # @returns all fields.
        def getFields(self, includeInherited = False) -> List[FieldSymbol]:
            return self.getSymbolsOfType(FieldSymbol)

    class ArrayType(Symbol, Type):
        referenceKind: ReferenceKind

        def __init__(self, name: str, referenceKind: ReferenceKind, elemType: Type, size = 0):
            super().__init__(name)
            self.referenceKind = referenceKind
            self._elementType = elemType
            self._size = size

        @property
        def elementType(self) -> Type:
            return self._elementType
        @property
        def size(self) -> int:
            return self._size # > 0 if fixed length.

        def baseTypes(self) -> List[Type]:
            return []

        def kind(self) -> TypeKind:
            return TypeKind.Array

        def reference(self) -> ReferenceKind:
            return self.referenceKind

    @dataclass
    class SymbolTableInfo:
        dependencyCount: int
        symbolCount: int

    # The main class managing all the symbols for a top level entity like a file, library or similar.
    class SymbolTable(ScopedSymbol):
        #  Other symbol information available to this instance.
        # eslint-disable-next-line no-use-before-define
        dependencies: Set[SymbolTable] = field( default_factory = set )


        def __init__(name: str, options: SymbolTableOptions):
            super().__init__(name)

        #
        # @returns instance information, mostly relevant for unit testing.
        def info(self):
            return SymbolTableInfo(self.dependencies.size,len(self.children))

        def clear(self):
            super().clear()
            self.dependencies.clear()

        def addDependencies(self, tables: List[SymbolTable]):
            for table in tables
                self.dependencies.add(table)

        def removeDependency(self, table: SymbolTable):
            if table in self.dependencies:
                self.dependencies.remove(table)

        def addNewSymbolOfType(self, t: Callable[P, T], parent: tuple[ScopedSymbol, None], *my_args: P.args, **my_kwargs: P.kwargs) -> T:

            # eslint-disable-next-line @typescript-eslint/no-unsafe-argument
            result = t(*my_args, **my_kwargs)
            if parent is not None or parent is self:
                self.addSymbol(result)
            else:
                parent.addSymbol(result)

            return result

        #
        # Asynchronously adds a new namespace to the symbol table or the given parent. The path parameter specifies a
        # single namespace name or a chain of namespaces (which can be e.g. "outer.intermittent.inner.final").
        # If any of the parent namespaces is missing they are created implicitly. The final part must not exist however
        # or you'll get a duplicate symbol error.
        #
        # @param parent The parent to add the namespace to.
        # @param path The namespace path.
        # @param delimiter The delimiter used in the path.
        #
        # @returns The new symbol.
        async def addNewNamespaceFromPath(self, parent: Optional[ScopedSymbol], path: str, delimiter = ".") -> NamespaceSymbol:
            parts = path.split(delimiter)
            i = 0
            currentParent = self if parent is None else parent
            while (i < len(parts) - 1):
                namespace: NamespaceSymbol = await currentParent.resolve(parts[i], True)
                if namespace is None:
                    namespace = self.addNewSymbolOfType(NamespaceSymbol, currentParent, parts[i])

                currentParent = namespace
                i += 1

            return self.addNewSymbolOfType(NamespaceSymbol, currentParent, parts[len(parts) - 1])

        #
        # Synchronously adds a new namespace to the symbol table or the given parent. The path parameter specifies a
        # single namespace name or a chain of namespaces (which can be e.g. "outer.intermittent.inner.final").
        # If any of the parent namespaces is missing they are created implicitly. The final part must not exist however
        # or you'll get a duplicate symbol error.
        #
        # @param parent The parent to add the namespace to.
        # @param path The namespace path.
        # @param delimiter The delimiter used in the path.
        #
        # @returns The new symbol.
        def addNewNamespaceFromPathSync(self, parent: Optional[ScopedSymbol], path: str, delimiter = ".") -> NamespaceSymbol:
            parts = path.split(delimiter)
            i = 0
            currentParent = self if parent is None else parent

            while (i < len(parts) - 1):
                namespace: NamespaceSymbol = currentParent.resolveSync(parts[i], True)
                if namespace is None:
                    namespace = self.addNewSymbolOfType(NamespaceSymbol, currentParent, parts[i])

                currentParent = namespace
                i += 1

            return self.addNewSymbolOfType(NamespaceSymbol, currentParent, parts[len(parts) - 1])

        #
        # Asynchronously returns all symbols from this scope (and optionally those from dependencies) of a specific type.
        #
        # @param t The type of the symbols to return.
        # @param localOnly If true do not search dependencies.
        #
        # @returns A promise which resolves when all symbols are collected.
        async def getAllSymbols(self, t: Callable[P, T], localOnly = False) -> List[T]:
            result: List[T] = await super().getAllSymbols(t, localOnly)

            if not localOnly:
                dependencyResults = await map( (lambda x: x.getAllSymbols(t, localOnly)), self.dependencies )

                for value in dependencyResults:
                    result.append(value)

            return result

        #
        # Synchronously returns all symbols from this scope (and optionally those from dependencies) of a specific type.
        #
        # @param t The type of the symbols to return.
        # @param localOnly If true do not search dependencies.
        #
        # @returns A list with all symbols.
        def getAllSymbolsSync(self, t: Callable[P, T], localOnly = False) -> List[T]:
            result: List[T] = super().getAllSymbolsSync(t, localOnly)

            if not localOnly:
                for dependency in self.dependencies:
                    result.append(dependency.getAllSymbolsSync(t, localOnly))

            return result

        #
        # Asynchronously looks for a symbol which is connected with a given parse tree context.
        #
        # @param context The context to search for.
        #
        # @returns A promise resolving to the found symbol or undefined.
        async def symbolWithContext(self, context: ParseTree) -> Optional[Symbol]:

            # Local function to find a symbol recursively.
            # @param symbol The symbol to search through.
            # @returns The symbol with the given context, if found.
            def findRecursive (self, symbol: Symbol) -> Optional[Symbol]:
                if symbol.context == context:
                    return symbol

                if isinstance(symbol, ScopedSymbol):
                    for child in symbol.children:
                        result = findRecursive(child)
                        if result is not None:
                            return result

                return None

            symbols = await self.getAllSymbols(Symbol)
            for symbol in symbols:
                result = findRecursive(symbol)
                if result is not None:
                    return result

            for dependency in self.dependencies:
                symbols = await dependency.getAllSymbols(Symbol)
                for symbol in symbols:
                    result = findRecursive(symbol)
                    if result is not None:
                        return result

            return None

        #
        # Synchronously looks for a symbol which is connected with a given parse tree context.
        #
        # @param context The context to search for.
        #
        # @returns The found symbol or undefined.
        def symbolWithContextSync(self, context: ParseTree) -> Optional[Symbol]:

            # Local function to find a symbol recursively.
            # @param symbol The symbol to search through.
            # @returns The symbol with the given context, if found.
            def findRecursive (symbol: Symbol) -> Optional[Symbol]:
                if symbol.context is context:
                    return symbol

                if isinstance(symbol, ScopedSymbol):
                    for child in symbol.children:
                        result = findRecursive(child)
                        if result is not None:
                            return result

                return None

            symbols = self.getAllSymbolsSync(Symbol)
            for symbol in symbols:
                result = findRecursive(symbol)
                if result is not None:
                    return result

            for dependency in self.dependencies:
                symbols = dependency.getAllSymbolsSync(Symbol)
                for symbol in symbols:
                    result = findRecursive(symbol)
                    if result is not None:
                        return result

            return None

        #
        # Asynchronously resolves a name to a symbol.
        #
        # @param name The name of the symbol to find.
        # @param localOnly A flag indicating if only this symbol table should be used or also its dependencies.
        #
        # @returns A promise resolving to the found symbol or undefined.
        async def resolve(self, name: str, localOnly = False) -> Optional[Symbol]:
            result = await super().resolve(name, localOnly)
            if not result and not localOnly:
                for dependency in self.dependencies:
                    result = await dependency.resolve(name, False)
                    if result is not None:
                        return result

            return result

        #
        # Synchronously resolves a name to a symbol.
        #
        # @param name The name of the symbol to find.
        # @param localOnly A flag indicating if only this symbol table should be used or also its dependencies.
        #
        # @returns The found symbol or undefined.
        def resolveSync(self, name: str, localOnly = False) -> Optional[Symbol]:
            result = super().resolveSync(name, localOnly)
            if not result and not localOnly:
                for dependency in self.dependencies:
                    result = dependency.resolveSync(name, False)
                    if result is not None:
                        return result

            return result