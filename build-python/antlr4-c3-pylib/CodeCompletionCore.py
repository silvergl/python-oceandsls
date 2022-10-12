#!/usr/bin/env python
__author__ = 'sgu'

from dataclasses import dataclass
from typing import Deque, Set

from antlr4.atn.ATNState import ATNState

#
#  * Copyright 2017 VMware, Inc. All Rights Reserved.
#  *
#  * SPDX-License-Identifier: MIT
#  *
#  * See LICENSE file for more info.
#

# TODO configure module
# package: com.vmware.antlr4c3

# TODO add util imports
# import java.util.Arrays
# import java.util.Collections
# import java.util.HashMap
# import java.util.HashSet
# import java.util.LinkedList
# import java.util.List
# import java.util.Map
# import java.util.Set
# import java.util.logging.Level
# import java.util.logging.Logger

import collections
import logging

# TODO add antlr imports
# TODO check range structure
#  https://stackoverflow.com/q/57356723/
from antlr4.IntervalSet import IntervalSet
from antlr4.Parser import Parser
from antlr4.Token import Token
from antlr4.ParserRuleContext import ParserRuleContext
from antlr4.atn.ATN import ATN
from antlr4.atn.ATNState import ATNState
from antlr4.atn.Transition import Transition


# import org.antlr.v4.runtime.Parser
# import org.antlr.v4.runtime.ParserRuleContext
# import org.antlr.v4.runtime.Token
# import org.antlr.v4.runtime.TokenStream
# import org.antlr.v4.runtime.Vocabulary
# import org.antlr.v4.runtime.atn.ATN
# import org.antlr.v4.runtime.atn.ATNState
# import org.antlr.v4.runtime.atn.PredicateTransition
# import org.antlr.v4.runtime.atn.RuleStopState
# import org.antlr.v4.runtime.atn.RuleTransition
# import org.antlr.v4.runtime.atn.Transition
# import org.antlr.v4.runtime.misc.IntervalSet

# TODO add dataclass
#  https://stackoverflow.com/q/48254562/
@dataclass
class RuleWithStartToken:
    startTokenIndex: int
    ruleIndex: int

    # def __init__(self, startTokenIndex: int, ruleIndex: int) -> None:
    #     self.startTokenIndex = startTokenIndex
    #     self.ruleIndex = ruleIndex

# TODO assure RuleWithStartToken objects
#  https://stackoverflow.com/q/51944520/
RuleWithStartTokenList = Deque['RuleWithStartToken']

RuleEndStatus = Set[int]

# A record for a follow set along with the path at which this set was found.
# If there is only a single symbol in the interval set then we also collect and store tokens which follow
# this symbol directly in its rule (i.e. there is no intermediate rule transition). Only single label transitions
# are considered. This is useful if you have a chain of tokens which can be suggested as a whole, because there is
# a fixed sequence in the grammar.
@dataclass
class FollowSetWithPath(object):
    intervals = IntervalSet()
    path = []
    following = []

#
#  Port of antlr-c3 javascript library to java
#  <p>
#  The c3 engine is able to provide code completion candidates useful for
#  editors with ANTLR generated parsers, independent of the actual
#  language/grammar used for the generation.
#
#  The main class for doing the collection process.
#
class CodeCompletionCore(object):

    # TODO implement HashMap as dictionaries
    #     private final static Map<String, Map<Integer, FollowSetsHolder>> followSetsByATN = new HashMap<>();
    followSetsByATN = {}

    # TODO check private
    atnStateTypeMap = [
        "invalid",
        "basic",
        "rule start",
        "block start",
        "plus block start",
        "star block start",
        "token start",
        "rule stop",
        "block end",
        "star loop back",
        "star loop entry",
        "plus loop back",
        "loop end"
    ]

    # Debugging options. Print human readable ATN state and other info.

    # Not dependent on showDebugOutput. Prints the collected rules + tokens to terminal.
    showResult = True
    # Enables printing ATN state info to terminal.
    showDebugOutput = True
    # Only relevant when showDebugOutput is true. Enables transition printing for a state.
    debugOutputWithTransitions = True
    # Also depends on showDebugOutput. Enables call stack printing for each rule recursion.
    showRuleStack = True

    def __init__(self, parser:Parser, preferredRules:tuple=None, ignoredTokens:tuple=None):
        """ generated source for method __init__ """
        self.parser = parser
        self.atn = parser.atn
        # TODO replace Vocabulary.getDisplayName with IntervalSet.elementName()
        #  self.vocabulary = parser.getVocabulary()
        self.literalNames = parser.literalNames
        self.symbolicNames = parser.symbolicNames
        self.ruleNames = parser.ruleNames
        self.tokens = None
        self.precedenceStack = None


        # TODO implement HashSet as tuple to be immutable
        #  https://www.geeksforgeeks.org/mutable-vs-immutable-objects-in-python/
        #  Alternative use set()
        #   https://stackoverflow.com/q/26724002/

        # Tailoring of the result:
        # Tokens which should not appear in the candidates set.
        self.ignoredTokens = ignoredTokens if ignoredTokens is not None else ()

        # Rules which replace any candidate token they contain.
        # This allows to return descriptive rules (e.g. className, instead of ID/identifier).
        self.preferredRules = preferredRules if preferredRules is not None else ()

    # TODO public final static Logger logger = Logger.getLogger(CodeCompletionCore.class.getName());
    #  https://www.machinelearningplus.com/python/python-logging-guide/
    #  check name
    #  CodeCompletionCore.logger = Logger.getLogger(CodeCompletionCore.__class__.__name__)
    logger = logging.getLogger(__name__)

    #
    # JDO returning information about matching tokens and rules
    #
    # All the candidates which have been found. Tokens and rules are separated.
    # Token entries include a list of tokens that directly follow them (see also the "following" member in the FollowSetWithPath class).
    # Rule entries include the index of the starting token within the evaluated rule, along with a call stack of rules found during evaluation.
    #
    class CandidatesCollection(object):

        # TODO implement HashMap as dictionaries
        #
        #         https://www.edureka.co/blog/hash-tables-and-hashmaps-in-python/
        #         https://stackoverflow.com/q/1540673/
        #         https://stackoverflow.com/q/17097985/
        # TODO never use class variables to set default values to object variables. Use __init__ for that.
        #   https://stackoverflow.com/q/3434581/

        def __init__(self):
            # Collection of Token ID candidates, each with a follow-on List of subsequent tokens
            # TODO public Map<Integer, List<Integer>> tokens = new HashMap<>();
            self.tokens = {}
            # Collection of Rule candidates, each with the callstack of rules to reach the candidate
            # TODO public Map<Integer, List<Integer>> rules = new HashMap<>();
            self.rules = {}
            # Collection of matched Preferred Rules each with their start and end offsets
            # TODO public Map<Integer, List<Integer>> rulePositions = new HashMap<>();
            self.rulePositions = {}

        def __str__(self):
            # TODO
            #  https://nygeek.wordpress.com/2015/07/18/simple-python-__str__self-method-for-use-during-development/
            return str('CandidatesCollection{' + str(self.__dict__) + '}')
            # return "CandidatesCollection{" + "tokens=" + str(self.tokens) + ", rules=" + str(self.rules) + ", ruleStrings=" + str(self.rulePositions) + '}'



    # A list of follow sets (for a given state number) + all of them combined for quick hit tests.
    # This data is static in nature (because the used ATN states are part of a static struct: the ATN).
    # Hence it can be shared between all C3 instances, however it depends on the actual parser class (type).
    class FollowSetsHolder(object):
        """ generated source for class FollowSetsHolder """
        sets = []
        combined = IntervalSet()

    class PipelineEntry(object):

        def __init__(self, state:ATNState, tokenIndex:int):
            self.state = state
            self.tokenIndex = tokenIndex

        # state = ATNState()
        # tokenIndex = int()

    # TODO implement HashSet as set()
    #     private Set<Integer> ignoredTokens = new HashSet<>();
    #     https://stackoverflow.com/q/26724002/
    # ignoredTokens = set()
    # TODO implement HashSet as tuple to be immutable
    #  https://www.geeksforgeeks.org/mutable-vs-immutable-objects-in-python/
    #  private Set<Integer> preferredRules = new HashSet<>();
    # preferredRules = ()
    # parser = Parser()
    # atn = ATN()
    # TODO replace Vocabulary.getDisplayName with IntervalSet.elementName()
    #  vocabulary = Vocabulary()
    # literalNames = []
    # symbolicNames = []
    # ruleNames = []
    # tokens = []
    tokenStartIndex = 0
    statesProcessed = 0

    # A mapping of rule index to token stream position to end token positions.
    # A rule which has been visited before with the same input position will always produce the same output positions.
    # TODO implement HashMap as dictionaries
    #     private final Map<Integer, Map<Integer, Set<Integer>>> shortcutMap = new HashMap<>();
    shortcutMap = {}
    # The collected candidates (rules and tokens).
    candidates = CandidatesCollection()

    # TODO remove getter setter
    #  https://stackoverflow.com/questions/2627002/whats-the-pythonic-way-to-use-getters-and-setters
    # def getPreferredRules(self):
    #     """ generated source for method getPreferredRules """
    #     return self.preferredRules
    #
    # def setPreferredRules(self, preferredRules:tuple):
    #     """ generated source for method setPreferredRules """
    #     # TODO implement HashSet as set()
    #     #  this.preferredRules = new HashSet<>(preferredRules);
    #     self.preferredRules = preferredRules

    #
    # This is the main entry point. The caret token index specifies the token stream index for the token which currently
    # covers the caret (or any other position you want to get code completion candidates for).
    # Optionally you can pass in a parser rule context which limits the ATN walk to only that or called rules. This can significantly
    # speed up the retrieval process but might miss some candidates (if they are outside the given context).
    #
    def collectCandidates(self, caretTokenIndex:int, context:ParserRuleContext=None):
        """ generated source for method collectCandidates """
        self.shortcutMap.clear()
        self.candidates.rules.clear()
        self.candidates.tokens.clear()
        self.statesProcessed = 0
        self.precedenceStack = []

        self.tokenStartIndex = context.start.tokenIndex if context is not None else 0
        tokenStream = self.parser.getInputStream()

        # TODO implement LinkedList as deque()
        #  https://www.geeksforgeeks.org/python-library-for-linked-list/
        #         this.tokens = new LinkedList<>();
        self.tokens = collections.deque()
        # TODO undo ts changes
        #  offset = 0
        offset = self.tokenStartIndex

        # TODO java versions
        # currentIndex = tokenStream.index
        # tokenStream.seek(self.tokenStartIndex)

        while True:
            # TODO undo ts changes
            #  token = tokenStream.LT(offset)
            token = tokenStream.get(offset)
            offset += 1
            if token.channel == Token.DEFAULT_CHANNEL:
                self.tokens.append(token)

                if token.tokenIndex >= caretTokenIndex or token.type == Token.EOF:
                    break

            # Do not check for the token index here, as we want to end with the first unhidden token on or after the caret.
            if token.type == Token.EOF:
                break
        # TODO undo ts changes
        #  tokenStream.seek(currentIndex)

        # TODO implement LinkedList as deque()
        #         LinkedList<Integer> callStack = new LinkedList<>();
        callStack: RuleWithStartTokenList = collections.deque()
        startRule = context.ruleIndex if context is not None else 0
        # TODO undo ts changes
        #  self.processRule(self.atn.ruleToStartState[startRule], 0, callStack, "\n")
        self.processRule(self.atn.ruleToStartState[startRule], 0, callStack, 0, 0)

        # TODO undo ts changes
        # tokenStream.seek(currentIndex)
        # #  now post-process the rule candidates and find the last occurrences
        # #  of each preferred rule and extract its start and end in the input stream
        # for ruleId in self.preferredRules:
        #     # TODO implement Map as dictionaries
        #     #  test final
        #     #  final Map<Integer, Set<Integer>> shortcut = shortcutMap.get(ruleId);
        #     shortcut = self.shortcutMap.get(ruleId)
        #     if shortcut is None or shortcut.isEmpty():
        #         continue
        #     #  select the right-most occurrence
        #     # TODO final int startToken = Collections.max(shortcut.keySet());
        #     startToken = collections.max(shortcut.keySet())
        #     # TODO final Set<Integer> endSet = shortcut.get(startToken);
        #     endSet = shortcut.get(startToken)
        #     # TODO final int endToken;
        #     if endSet.isEmpty():
        #         endToken = len(self.tokens) - 1
        #     else:
        #         endToken = collections.max(shortcut.get(startToken))
        #     # TODO final int startOffset = tokens.get(startToken).getStartIndex();
        #     startOffset = tokens.get(startToken).getStartIndex()
        #     # TODO final int endOffset;
        #     if self.tokens.get(endToken).getType() == Token.EOF:
        #         #  if last token is EOF, include trailing whitespace
        #         endOffset = self.tokens.get(endToken).getStartIndex()
        #     else:
        #         #  if last token is not EOF, limit to matching tokens which excludes trailing whitespace
        #         endOffset = self.tokens.get(endToken - 1).getStopIndex() + 1
        #     # TODO check Arrays.asList
        #     #  https://medium.com/swlh/collections-in-python-d8954b006bb7
        #     #  final List<Integer> ruleStartStop = Arrays.asList(startOffset, endOffset);
        #     ruleStartStop = [startOffset, endOffset]
        #     self.candidates.rulePositions.put(ruleId, ruleStartStop)
        # # TODO logger.isLoggable(Level.FINE)

        if self.showResult and self.logger.isEnabledFor(logging.DEBUG):
            # TODO StringBuilder logMessage = new StringBuilder();
            #  https://waymoot.org/home/python_string/
            logMessage_list = ["States processed: " , self.statesProcessed , "\n\n", "Collected rules:\n"]
            for rule in self.candidates.rules:
                logMessage_list.append(" " + rule.getKey() + ", path: ")
                for token in rule.getValue():
                    logMessage_list.append(self.ruleNames[token]).append(" ")
                logMessage_list.append("\n")

            logMessage_list.append("Collected Tokens:\n")
            for entry in self.candidates.tokens.entrySet():
                # TODO replace Vocabulary.getDisplayName() vs Intervalset.elementName()
                #  logMessage_list.append("  ").append(self.vocabulary.getDisplayName(entry.getKey()))
                logMessage_list.append(" ").append(IntervalSet.elementName(self.literalNames, self.symbolicNames, entry.getKey()))

                for following in entry.getValue():
                    # TODO replace Vocabulary.getDisplayName() vs Intervalset.elementName()
                    #  logMessage_list.append(" ").append(self.vocabulary.getDisplayName(following))
                    logMessage_list.append(" ").append(IntervalSet.elementName(self.literalNames, self.symbolicNames, following))
                logMessage_list.append("\n")
            # TODO self.logger.log(Level.FINE, logMessage_list.__str__())
            self.logger.debug(''.join(logMessage_list))
        return self.candidates

    # Check if the predicate associated with the given transition evaluates to true.
    def checkPredicate(self, transition):
        """ generated source for method checkPredicate """
        return transition.getPredicate().eval(self.parser, ParserRuleContext.EMPTY)

    # Walks the rule chain upwards to see if that matches any of the preferred rules.
    # If found, that rule is added to the collection candidates and true is returned.
    def translateToRuleIndex(self, ruleStack):
        """ generated source for method translateToRuleIndex """
        if not self.preferredRules:
            return False

        # Loop over the rule stack from highest to lowest rule level. This way we properly handle the higher rule
        # if it contains a lower one that is also a preferred rule.
        i = 0
        while i < len(ruleStack):
            # if self.preferredRules.contains(ruleStack.get(i)):
            if ruleStack.get(i) in self.preferredRules:
                # Add the rule to our candidates list along with the current rule path,
                # but only if there isn't already an entry like that.
                # TODO fix loop
                # TODO implement LinkedList as deque()
                #  List<Integer> path = new LinkedList<>(ruleStack.subList(0, i));
                path = collections.deque(ruleStack.subList(0, i))
                addNew = True
                for entry in self.candidates.rules.entrySet():
                    if not entry.getKey() == ruleStack.get(i) or entry.getValue().size() != len(path):
                        continue
                    # Found an entry for this rule. Same path? If so don't add a new (duplicate) entry.
                    if path == entry.getValue():
                        addNew = False
                        break

                if addNew:
                    self.candidates.rules[ruleStack.get(i)] = path
                    # TODO if self.showDebugOutput and self.logger.isLoggable(Level.FINE):
                    if self.showDebugOutput and self.logger.isEnabledFor(logging.DEBUG):
                        self.logger.debug("=====> collected: " + self.ruleNames[i])
                return True
            i += 1
        return False

    # This method follows the given transition and collects all symbols within the same rule that directly follow it
    # without intermediate transitions to other rules and only if there is a single symbol for a transition.
    def getFollowingTokens(self, initialTransition):
        # TODO implement LinkedList as deque()
        # LinkedList<Integer> result = new LinkedList<>();
        result = collections.deque()
        # LinkedList<ATNState> seen = new LinkedList<>(); // unused but in orig
        seen = collections.deque()  # unused but in orig
        # LinkedList<ATNState> pipeline = new LinkedList<>();
        pipeline = collections.deque()
        pipeline.append(initialTransition.target)
        while pipeline:
            # pipeline not empty
            state = pipeline.pop()

            for transition in state.transitions:
                if transition.serializationType == Transition.ATOM:
                    if not transition.isEpsilon:
                        list_ = list(transition.label)
                        if len(list_) == 1 and not list_[0] in self.ignoredTokens:
                            result.append(list_[0])
                            pipeline.append(transition.target)
                    else:
                        pipeline.append(transition.target)
        return result

    # Entry point for the recursive follow set collection function.
    def determineFollowSets(self, start, stop):
        # TODO implement LinkedList as deque()
        #  LinkedList<FollowSetWithPath> result = new LinkedList<>();
        result = collections.deque()
        # TODO implement HashSet as set()
        #  Set<ATNState> seen = new HashSet<>();
        seen = set()
        # TODO implement LinkedList as deque()
        #  LinkedList<Integer> ruleStack = new LinkedList<>();
        ruleStack = collections.deque()
        self.collectFollowSets(start, stop, result, seen, ruleStack)
        return result

    # Collects possible tokens which could be matched following the given ATN state. This is essentially the same
    # algorithm as used in the LL1Analyzer class, but here we consider predicates also and use no parser rule context.
    def collectFollowSets(self, s, stopState, followSets, seen, ruleStack):
        """ generated source for method collectFollowSets """
        # TODO use in operator
        #  if seen.contains(s):
        if s in seen:
            return

        seen.add(s)

        if s == stopState or s.stateType == ATNState.RULE_STOP:
            followSet: FollowSetWithPath = FollowSetWithPath()
            followSet.intervals = IntervalSet.of(Token.EPSILON)
            # TODO implement LinkedList as deque()
            #  set.path = new LinkedList<Integer>(ruleStack);
            followSet.path = collections.deque(ruleStack)
            followSets.append(followSet)
            return

        for transition in s.transitions:
            if transition.serializationType == Transition.RULE:
                ruleTransition = transition
                # TODO check semantic eg skip the current iteration
                #  if ruleStack.index(ruleTransition.target.ruleIndex) != -1:
                if ruleTransition.target.ruleIndex in ruleStack:
                    continue
                ruleStack.append(ruleTransition.target.ruleIndex)
                self.collectFollowSets(transition.target, stopState, followSets, seen, ruleStack)
                ruleStack.pop()
            elif transition.serializationType == Transition.PREDICATE:
                if self.checkPredicate(transition):
                    self.collectFollowSets(transition.target, stopState, followSets, seen, ruleStack)
            elif transition.isEpsilon:
                self.collectFollowSets(transition.target, stopState, followSets, seen, ruleStack)
            elif transition.serializationType == Transition.WILDCARD:
                followSet: FollowSetWithPath = FollowSetWithPath()
                followSet.intervals = IntervalSet.of(Token.MIN_USER_TOKEN_TYPE, self.atn.maxTokenType)
                # TODO implement LinkedList as deque()
                #  set.path = new LinkedList<Integer>(ruleStack);
                followSet.path = collections.deque(ruleStack)
                followSets.append(followSet)
            else:
                label = transition.label
                if label is not None and len(label) > 0:
                    if transition.serializationType == Transition.NOT_SET:
                        label = label.complement(IntervalSet.of(Token.MIN_USER_TOKEN_TYPE, self.atn.maxTokenType))
                    followSet: FollowSetWithPath = FollowSetWithPath()
                    followSet.intervals = label
                    # TODO implement LinkedList as deque()
                    #  set.path = new LinkedList<Integer>(ruleStack);
                    followSet.path = collections.deque(ruleStack)
                    followSet.following = self.getFollowingTokens(transition)
                    followSets.append(followSet)

    # Walks the ATN for a single rule only. It returns the token stream position for each path that could be matched in this rule.
    # The result can be empty in case we hit only non-epsilon transitions that didn't match the current input or if we
    # hit the caret position.
    def processRule(self, startState:ATNState, tokenListIndex:int, callStack:collections.deque, precedence:int, indentation:int) -> RuleEndStatus :

        # Start with rule specific handling before going into the ATN walk.

        # Check first if we've taken this path with the same input before.
        positionMap = self.shortcutMap.get(startState.ruleIndex)
        if positionMap is None:
            # TODO implement HashMap as dictionaries
            #  positionMap = new HashMap<>();
            positionMap ={}
            self.shortcutMap[startState.ruleIndex] = positionMap
        else:
            if positionMap.containsKey(tokenListIndex):
                if self.showDebugOutput:
                    # TODO set fine to debug
                    self.logger.debug("=====> shortcut")
                return positionMap.get(tokenListIndex)

        # TODO implement HashSet as set()
        #  Set<Integer> result = new HashSet<>();
        result: RuleEndStatus = set()

        #  For rule start states we determine and cache the follow set, which gives us 3 advantages:
        #  1) We can quickly check if a symbol would be matched when we follow that rule. We can so check in advance
        #     and can save us all the intermediate steps if there is no match.
        #  2) We'll have all symbols that are collectable already together when we are at the caret on rule enter.
        #  3) We get this lookup for free with any 2nd or further visit of the same rule, which often happens
        #     in non-trivial grammars, especially with (recursive) expressions and of course when invoking code
        #     completion multiple times.
        setsPerState = self.followSetsByATN.get(self.parser.__class__.__name__)
        if setsPerState is None:
            # TODO implement HashMap as dictionaries
            #  positionMap = new HashMap<>();
            setsPerState ={}
            self.followSetsByATN[self.parser.__class__.__name__] = setsPerState

        followSets = setsPerState.get(startState.stateNumber)
        if followSets is None:
            followSets = self.FollowSetsHolder()
            setsPerState[startState.stateNumber] = followSets
            stop = self.atn.ruleToStopState[startState.ruleIndex]
            followSets.sets = self.determineFollowSets(startState, stop)

            # Sets are split by path to allow translating them to preferred rules. But for quick hit tests
            # it is also useful to have a set with all symbols combined.
            combined = IntervalSet()
            for followSet in followSets.sets:
                combined.addSet(followSet.intervals)
            followSets.combined = combined

        # TODO next
        # Get the token index where our rule starts from our (possibly filtered) token list
        startTokenIndex = self.tokens[tokenListIndex].tokenIndex

        callStack.append({
            startTokenIndex,
            startState.ruleIndex,
        })

        currentSymbol = self.tokens[tokenListIndex].type
        if tokenListIndex >= len(self.tokens) - 1:
            if startState.ruleIndex in self.preferredRules:
                self.translateToRuleIndex(callStack)
            else:
                for followSet in followSets.sets:
                    # TODO implement LinkedList as deque()
                    #  LinkedList<Integer> fullPath = new LinkedList<>(callStack);
                    fullPath = collections.deque(callStack)
                    fullPath.extend(followSet.path)
                    if not self.translateToRuleIndex(fullPath):
                        for symbol in list(followSet.intervals):
                            if not symbol in self.ignoredTokens:
                                # TODO set logger to debug
                                #  logger.isLoggable(Level.FINE)
                                if self.showDebugOutput and self.logger.isEnabledFor(logging.DEBUG):
                                    # TODO replace Vocabulary.getDisplayName() vs Intervalset.elementName()
                                    #  self.logger.debug("=====> collected: " + self.vocabulary.getDisplayName(symbol))
                                    self.logger.debug("=====> collected: " + IntervalSet.elementName(self.literalNames, self.symbolicNames, symbol))
                                if not symbol in self.candidates.tokens:
                                    self.candidates.tokens[symbol] = followSet.following
                                else:
                                    if not self.candidates.tokens[symbol] == followSet.following:
                                        # TODO implement LinkedList as deque()
                                        self.candidates.tokens[symbol] = collections.deque()
                            else:
                                self.logger.fine("====> collection: Ignoring token: " + symbol)
            # callStack.removeLast()
            callStack.pop()
            return result
        else:
            if not followSets.combined.contains(Token.EPSILON) and not followSets.combined.contains(currentSymbol):
                # callStack.removeLast()
                callStack.pop()
                return result

        # TODO implement LinkedList as deque()
        #  LinkedList<PipelineEntry> statePipeline = new LinkedList<>();
        statePipeline = collections.deque()
        currentEntry = self.PipelineEntry()
        statePipeline.add(self.PipelineEntry(startState, tokenListIndex))
        while not statePipeline.isEmpty():
            currentEntry = statePipeline.removeLast()
            self.statesProcessed += 1
            currentSymbol = self.tokens.get(currentEntry.tokenIndex).getType()

            atCaret = currentEntry.tokenIndex >= self.tokens.size() - 1
            # TODO set logger to debug
            #  logger.isLoggable(Level.FINE)
            if self.logger.isEnabledFor(logging.DEBUG):
                self.printDescription(indentation, currentEntry.state, self.generateBaseDescription(currentEntry.state), currentEntry.tokenIndex)
                if self.showRuleStack:
                    self.printRuleState(callStack)
            if currentEntry.state.getStateType() == ATNState.RULE_START:
                indentation += "  "
            elif currentEntry.state.getStateType() == ATNState.RULE_STOP:
                result.add(currentEntry.tokenIndex)
                continue
            else:
                # TODO fix default case
                # TODO
                #  Transition[] transitions = currentEntry.state.getTransitions();
                transitions = currentEntry.state.getTransitions()
                for transition in transitions:
                    if transition.getSerializationType() == Transition.RULE:
                        # TODO as set
                        #  Set<Integer> endStatus = this.processRule(transition.target, currentEntry.tokenIndex, callStack, indentation);
                        endStatus = self.processRule(transition.target, currentEntry.tokenIndex, callStack, indentation)
                        for position in endStatus:
                            statePipeline.append(self.PipelineEntry((transition).followState, position))
                    elif transition.getSerializationType() == Transition.PREDICATE:
                        if self.checkPredicate(transition):
                            statePipeline.append(self.PipelineEntry(transition.target, currentEntry.tokenIndex))
                    elif transition.getSerializationType() == Transition.WILDCARD:
                        if atCaret:
                            if not self.translateToRuleIndex(callStack):
                                for token in IntervalSet.of(Token.MIN_USER_TOKEN_TYPE, self.atn.maxTokenType).toList():
                                    if not self.ignoredTokens.contains(token):
                                        # TODO implement LinkedList as deque()
                                        #  this.candidates.tokens.put(token, new LinkedList<Integer>());
                                        self.candidates.tokens[token] = collections.deque()
                        else:
                            statePipeline.append(self.PipelineEntry(transition.target, currentEntry.tokenIndex + 1))
                    else:
                        if transition.isEpsilon():
                            statePipeline.append(self.PipelineEntry(transition.target, currentEntry.tokenIndex))
                            continue
                        if followSet != None and len(followSet) > 0:
                            if transition.getSerializationType() == Transition.NOT_SET:
                                followSet = followSet.complement(IntervalSet.of(Token.MIN_USER_TOKEN_TYPE, self.atn.maxTokenType))
                            if atCaret:
                                if not self.translateToRuleIndex(callStack):
                                    # TODO
                                    #  List<Integer> list = set.toList();
                                    list_ = list(followSet)
                                    # TODO check length of list
                                    #  boolean addFollowing = list.size() == 1;
                                    addFollowing = list.size() == 1;
                                    for symbol in list_:
                                        if not self.ignoredTokens.contains(symbol):
                                            # TODO set logger to debug
                                            #  logger.isLoggable(Level.FINE)
                                            if self.showDebugOutput and self.logger.isEnabledFor(logging.DEBUG):
                                                # TODO replace Vocabulary.getDisplayName() vs Intervalset.elementName()
                                                #  self.logger.debug("=====> collected: " + self.vocabulary.getDisplayName(symbol))
                                                self.logger.debug("=====> collected: " + IntervalSet.elementName(self.literalNames, self.symbolicNames, symbol))
                                            if addFollowing:
                                                self.candidates.tokens[symbol] = self.getFollowingTokens(transition)
                                            else:
                                                pass
                                        else:
                                            # TODO set logger to debug
                                            self.logger.debug("====> collected: Ignoring token: " + symbol)
                            else:
                                if followSet.contains(currentSymbol):
                                    # TODO set logger to debug
                                    #  logger.isLoggable(Level.FINE)
                                    if self.showDebugOutput and self.logger.isEnabledFor(logging.DEBUG):
                                        # TODO set logger to debug
                                        # TODO replace Vocabulary.getDisplayName() vs Intervalset.elementName()
                                        #  self.logger.debug("=====> consumed: " + self.vocabulary.getDisplayName(currentSymbol))
                                        self.logger.debug("=====> consumed: " + IntervalSet.elementName(self.literalNames, self.symbolicNames, currentSymbol))
                                    statePipeline.append(self.PipelineEntry(transition.target, currentEntry.tokenIndex + 1))
        callStack.removeLast()
        positionMap[tokenListIndex] = result
        return result

    def generateBaseDescription(self, state):
        """ generated source for method generateBaseDescription """
        # TODO implement Integer.toString as str()
        stateValue = "Invalid" if (state.stateNumber == ATNState.INVALID_STATE_NUMBER) else str(state.stateNumber)
        return "[" + stateValue + " " + self.atnStateTypeMap[state.getStateType()] + "] in " + self.ruleNames[state.ruleIndex]

    def printDescription(self, currentIndent, state, baseDescription, tokenIndex):
        """ generated source for method printDescription """
        # TODO implement as string list
        #  StringBuilder output = new StringBuilder(currentIndent);
        output_list = [currentIndent]
        # TODO implement as string list
        #  StringBuilder transitionDescription = new StringBuilder();
        transitionDescription_list = []
        # TODO set logger to debug
        #  set new FINER level
        #  check levels
        #  logger.isLoggable(Level.FINER)
        if self.debugOutputWithTransitions and self.logger.isEnabledFor(logging.DEBUG):
            for transition in state.getTransitions():
                # TODO implement as list of strings
                #  StringBuilder labels = new StringBuilder();
                labels_list = []
                # TODO implement as collections.deque()
                #  List<Integer> symbols = (transition.label() != null) ? transition.label().toList() : new LinkedList<>();
                # TODO check toList
                symbols = transition.label().toList() if (transition.label() != None) else collections.deque()
                if len(symbols) > 2:
                    # TODO replace Vocabulary.getDisplayName() vs Intervalset.elementName()
                    #  labels_list.append(self.vocabulary.getDisplayName(symbols.get(0)) + " .. " + self.vocabulary.getDisplayName(symbols.get(len(symbols) - 1)))
                    labels_list.append(IntervalSet.elementName(self.literalNames, self.symbolicNames, symbols.get(0)) + " .. " + IntervalSet.elementName(self.literalNames, self.symbolicNames, symbols.get(len(symbols) - 1)))
                else:
                    for symbol in symbols:
                        if 0 > len(labels_list):
                            labels_list.append(", ")
                        # TODO replace Vocabulary.getDisplayName() vs Intervalset.elementName()
                        #  labels_list.append(self.vocabulary.getDisplayName(symbol))
                        labels_list.append(IntervalSet.elementName(self.literalNames, self.symbolicNames, symbol))
                if 0 == len(labels_list):
                    labels_list.append("E")
                transitionDescription_list.append("\n").append(currentIndent).append("\t(").append(''.join(labels_list)).append(") [").append(transition.target.stateNumber).append(" ").append(self.atnStateTypeMap[transition.target.getStateType()]).append("] in ").append(self.ruleNames[transition.target.ruleIndex])
            if tokenIndex >= len(self.tokens) - 1:
                output_list.append("<<").append(self.tokenStartIndex + tokenIndex).append(">> ")
            else:
                output_list.append("<").append(self.tokenStartIndex + tokenIndex).append("> ")
            self.logger.finer(''.join(output_list) + "Current state: " + baseDescription + ''.join(transitionDescription_list))

    def printRuleState(self, stack):
        """ generated source for method printRuleState """
        if stack.isEmpty():
            self.logger.fine("<empty stack>")
            return
        # TODO set logger to debug
        #  set new FINER level
        #  check levels
        #  logger.isLoggable(Level.FINER)
        if self.logger.isEnabledFor(logging.DEBUG):
            # TODO implement as list of strings
            #  StringBuilder sb = new StringBuilder();
            sb_list = []
            for rule in stack:
                sb_list.append("  ").append(self.ruleNames[rule]).append("\n")
            self.logger.debug(''.join(sb_list))
