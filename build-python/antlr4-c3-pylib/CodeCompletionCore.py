#!/usr/bin/env python
from __future__ import annotations

__author__ = 'sgu'

# TODO license

#
#  Port of antlr-c3 javascript library to python
#  <p>
#  The c3 engine is able to provide code completion candidates useful for
#  editors with ANTLR generated parsers, independent of the actual
#  language/grammar used for the generation.
#

# TODO configure module
# package: com.vmware.antlr4c3

# TODO add util imports
import logging, itertools
from collections import deque
logging.basicConfig(level=logging.DEBUG)

from dataclasses import dataclass, field
from typing import Deque, Set, List, Dict

# TODO add antlr imports
# TODO check range structure
#  https://stackoverflow.com/q/57356723/
from antlr4.IntervalSet import IntervalSet
from antlr4.Parser import Parser
from antlr4.Token import Token
from antlr4.BufferedTokenStream import TokenStream
from antlr4.ParserRuleContext import ParserRuleContext
from antlr4.atn.ATN import ATN
from antlr4.atn.ATNState import ATNState
from antlr4.atn.Transition import Transition, PredicateTransition

TokenList = List[int]
RuleList = List[int]


@dataclass
class CandidateRule:
    startTokenIndex: int
    ruleList: RuleList


# TODO add dataclass
#  https://stackoverflow.com/q/48254562/
@dataclass
class RuleWithStartToken:
    startTokenIndex: int
    ruleIndex: int


# TODO assure RuleWithStartToken objects
#  https://stackoverflow.com/q/51944520/
RuleWithStartTokenList = Deque[RuleWithStartToken]


# JDO returning information about matching tokens and rules
#
# All the candidates which have been found. Tokens and rules are separated.
# Token entries include a list of tokens that directly follow them (see also the "following" member in the FollowSetWithPath class).
# Rule entries include the index of the starting token within the evaluated rule, along with a call stack of rules found during evaluation.
@dataclass
class CandidatesCollection:
    # TODO implement HashMap as dictionaries
    #         https://www.edureka.co/blog/hash-tables-and-hashmaps-in-python/
    #         https://stackoverflow.com/q/1540673/
    #         https://stackoverflow.com/q/17097985/
    # TODO never use class variables to set default values to object variables. Use __init__ for that.
    #   https://stackoverflow.com/q/3434581/

    # Collection of Token ID candidates, each with a follow-on List of subsequent tokens
    tokens: dict[int, TokenList] = field( default_factory=dict )
    # Collection of Rule candidates, each with the callstack of rules to reach the candidate
    rules: dict[int, CandidateRule] = field( default_factory=dict )

    def __str__(self):
        # TODO src
        #  https://nygeek.wordpress.com/2015/07/18/simple-python-__str__self-method-for-use-during-development/
        return str( 'CandidatesCollection{' + str( self.__dict__ ) + '}' )


# A record for a follow set along with the path at which this set was found.
# If there is only a single symbol in the interval set then we also collect and store tokens which follow
# this symbol directly in its rule (i.e. there is no intermediate rule transition). Only single label transitions
# are considered. This is useful if you have a chain of tokens which can be suggested as a whole, because there is
# a fixed sequence in the grammar.
@dataclass
class FollowSetWithPath:
    intervals: IntervalSet = IntervalSet()
    path: RuleList = field( default_factory=list )
    following: TokenList = field( default_factory=list )


FollowSetWithPathSet = Set[FollowSetWithPath]


# A list of follow sets (for a given state number) + all of them combined for quick hit tests.
# This data is static in nature (because the used ATN states are part of a static struct: the ATN).
# Hence it can be shared between all C3 instances, however it depends on the actual parser class (type).
@dataclass
class FollowSetsHolder:
    sets: FollowSetWithPathSet = field( default_factory=set )
    combined: IntervalSet = IntervalSet()


FollowSetsPerState = Dict[int, FollowSetsHolder]

# Token stream position info after a rule was processed.
RuleEndStatus = Set[int]


@dataclass
class PipelineEntry:
    state: ATNState
    tokenListIndex: int

#
#  Extract elements from deque without altering it.
#
def slice_deque(deq: deque, start: int, stop: int) -> list:
    deq.rotate(-start)
    slice = list(itertools.islice(deq, 0, stop-start))
    deq.rotate(start)
    return slice

#
#  The main class for doing the collection process.
#
class CodeCompletionCore:
    # TODO implement HashMap as dictionaries
    #     private final static Map<String, Map<Integer, FollowSetsHolder>> followSetsByATN = new HashMap<>();
    followSetsByATN: dict[str, FollowSetsPerState] = {}

    atnStateTypeMap = ["invalid", "basic", "rule start", "block start", "plus block start", "star block start",
                       "token start", "rule stop", "block end", "star loop back", "star loop entry", "plus loop back",
                       "loop end"]

    # Debugging options. Print human readable ATN state and other info.

    # Not dependent on showDebugOutput. Prints the collected rules + tokens to terminal.
    showResult = True
    # Enables printing ATN state info to terminal.
    showDebugOutput = True
    # Only relevant when showDebugOutput is true. Enables transition printing for a state.
    debugOutputWithTransitions = True
    # Also depends on showDebugOutput. Enables call stack printing for each rule recursion.
    showRuleStack = True
    # Specify if preferred rules should be translated top-down (higher index rule returns first) or
    # bottom-up (lower index rule returns first).
    translateRulesTopDown = True

    tokenStartIndex = 0
    statesProcessed = 0

    # A mapping of rule index to token stream position to end token positions.
    # A rule which has been visited before with the same input position will always produce the same output positions.
    # TODO implement HashMap as dictionaries
    #     private final Map<Integer, Map<Integer, Set<Integer>>> shortcutMap = new HashMap<>();
    shortcutMap = {}

    # The collected candidates (rules and tokens).
    candidates = CandidatesCollection()

    def __init__(self, parser: Parser, preferredRules: tuple = None, ignoredTokens: tuple = None):
        self.parser: Parser = parser
        self.atn: ATN = parser.atn
        # TODO replace Vocabulary.getDisplayName with IntervalSet.elementName()
        #  self.vocabulary: Vocabulary = parser.getVocabulary()
        self.literalNames: List[str] = parser.literalNames
        self.symbolicNames: List[str] = parser.symbolicNames
        self.ruleNames: List[str] = parser.ruleNames
        self.tokens: Deque[Token] = None
        self.precedenceStack: Deque[int] = None

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
    logger = logging.getLogger( __name__ )

    # TODO remove getter setter
    #  https://stackoverflow.com/questions/2627002/whats-the-pythonic-way-to-use-getters-and-setters

    #
    # This is the main entry point. The caret token index specifies the token stream index for the token which currently
    # covers the caret (or any other position you want to get code completion candidates for).
    # Optionally you can pass in a parser rule context which limits the ATN walk to only that or called rules. This can significantly
    # speed up the retrieval process but might miss some candidates (if they are outside the given context).
    #
    def collectCandidates(self, caretTokenIndex: int, context: ParserRuleContext = None) -> CandidatesCollection:
        self.shortcutMap.clear()
        self.candidates.rules.clear()
        self.candidates.tokens.clear()
        self.statesProcessed = 0
        self.precedenceStack = []

        self.tokenStartIndex = context.start.tokenListIndex if context is not None else 0
        tokenStream: TokenStream = self.parser.getInputStream()

        # TODO implement LinkedList as deque()
        #  https://www.geeksforgeeks.org/python-library-for-linked-list/
        #         this.tokens = new LinkedList<>();
        self.tokens = deque()
        offset: int = self.tokenStartIndex
        while True:
            token: Token = tokenStream.get( offset )
            offset += 1
            if token.channel == Token.DEFAULT_CHANNEL:
                self.tokens.append( token )

                if token.tokenIndex >= caretTokenIndex or token.type == Token.EOF:
                    break

            # Do not check for the token index here, as we want to end with the first unhidden token on or after the caret.
            if token.type == Token.EOF:
                break

        # TODO implement LinkedList as deque()
        #         LinkedList<Integer> callStack = new LinkedList<>();
        callStack: RuleWithStartTokenList = deque()
        startRule = context.ruleIndex if context is not None else 0
        self.processRule( self.atn.ruleToStartState[startRule], 0, callStack, 0, 0 )

        if self.showResult and self.logger.isEnabledFor( logging.DEBUG ):
            # TODO src
            #  https://waymoot.org/home/python_string/
            logMessage_list = ["States processed: ", str(self.statesProcessed), "\n\n", "Collected rules:\n"]
            for rule in self.candidates.rules:
                logMessage_list.append( " " + rule.getKey() + ", path: " )

                for token in rule.getValue():
                    logMessage_list.append( self.ruleNames[token] ).append( " " )
                logMessage_list.append( "\n" )

            logMessage_list.append( "Collected Tokens:\n" )
            for key, value in self.candidates.tokens.items():
                logMessage_list.extend( [ " " , IntervalSet.elementName( IntervalSet, self.literalNames, self.symbolicNames, key ) ] )

                for following in value:
                    logMessage_list.extend( [ " " , IntervalSet.elementName( IntervalSet, self.literalNames, self.symbolicNames, following ) ] )
                logMessage_list.append( "\n" )

            self.logger.debug( ''.join( logMessage_list ) )

        return self.candidates

    #
    # Check if the predicate associated with the given transition evaluates to true.
    #
    def checkPredicate(self, transition: PredicateTransition) -> bool:
        return transition.getPredicate().eval( self.parser, ParserRuleContext.EMPTY )

    #
    # Walks the rule chain upwards or downwards (depending on translateRulesTopDown) to see if that matches any of the
    # preferred rules. If found, that rule is added to the collection candidates and true is returned.
    #
    def translateStackToRuleIndex(self, ruleWithStartTokenList: RuleWithStartTokenList) -> bool:
        # if not self.preferredRules:
        #     return False

        # Change the direction we iterate over the rule stack
        if self.translateRulesTopDown:
            #  Loop over the rule stack from lowest to highest rule level. This will prioritize a lower preferred rule
            #  if it is a child of a higher one that is also a preferred rule.
            i = len( ruleWithStartTokenList ) - 1
            while i >= 0:
                if self.translateToRuleIndex(i, ruleWithStartTokenList):
                    return True
                i -= 1
        else:
            #  Loop over the rule stack from highest to lowest rule level. This will prioritize a higher preferred rule
            #  if it contains a lower one that is also a preferred rule.
            i = 0
            while i < len( ruleWithStartTokenList ):
                if self.translateToRuleIndex(i, ruleWithStartTokenList):
                    return True
                i += 1

        return False

    #
    # Walks the rule chain upwards to see if that matches any of the preferred rules.
    # If found, that rule is added to the collection candidates and true is returned.
    #
    def translateToRuleIndex(self, i: int, ruleStack: RuleWithStartTokenList) -> bool:
        ruleIndex = ruleStack[i].ruleIndex
        startTokenIndex = ruleStack[i].startTokenIndex

        if ruleIndex in self.preferredRules:
            # Add the rule to our candidates list along with the current rule path,
            # but only if there isn't already an entry like that.
            tmp = slice_deque( ruleStack, 0, i)
            path = list(map((lambda x: x.ruleIndex), slice_deque( ruleStack, 0, i)))
            addNew = True
            for key, value in self.candidates.rules.items():
                if not key == ruleIndex or len( value.ruleList ) != len( path ):
                    continue
                # Found an entry for this rule. Same path? If so don't add a new (duplicate) entry.
                if path == value:
                    addNew = False
                    break

        if not self.preferredRules:
            return False

        # Loop over the rule stack from highest to lowest rule level. This way we properly handle the higher rule
        # if it contains a lower one that is also a preferred rule.
        i = 0
        while i < len( ruleStack ):
            # if self.preferredRules.contains(ruleStack.get(i)):
            if ruleStack.get( i ) in self.preferredRules:
                # Add the rule to our candidates list along with the current rule path,
                # but only if there isn't already an entry like that.
                # TODO implement LinkedList as deque()
                #  List<Integer> path = new LinkedList<>(ruleStack.subList(0, i));
                path = deque( ruleStack.subList( 0, i ) )
                addNew = True
                for key, value in self.candidates.rules.items():
                    if not key == ruleStack.get( i ) or value.size() != len( path ):
                        continue
                    # Found an entry for this rule. Same path? If so don't add a new (duplicate) entry.
                    if path == value:
                        addNew = False
                        break

                if addNew:
                    self.candidates.rules[ruleStack.get( i )] = path
                    # TODO if self.showDebugOutput and self.logger.isLoggable(Level.FINE):
                    if self.showDebugOutput and self.logger.isEnabledFor( logging.DEBUG ):
                        self.logger.debug( "=====> collected: " + self.ruleNames[i] )
                return True
            i += 1
        return False

    # This method follows the given transition and collects all symbols within the same rule that directly follow it
    # without intermediate transitions to other rules and only if there is a single symbol for a transition.
    def getFollowingTokens(self, initialTransition):
        # TODO implement LinkedList as deque()
        # LinkedList<Integer> result = new LinkedList<>();
        result = deque()
        # LinkedList<ATNState> seen = new LinkedList<>(); // unused but in orig
        seen = deque()  # unused but in orig
        # LinkedList<ATNState> pipeline = new LinkedList<>();
        pipeline = deque()
        pipeline.append( initialTransition.target )
        while pipeline:
            # pipeline not empty
            state = pipeline.pop()

            for transition in state.transitions:
                if transition.serializationType == Transition.ATOM:
                    if not transition.isEpsilon:
                        list_ = list( transition.label )
                        if len( list_ ) == 1 and not list_[0] in self.ignoredTokens:
                            result.append( list_[0] )
                            pipeline.append( transition.target )
                    else:
                        pipeline.append( transition.target )
        return result

    # Entry point for the recursive follow set collection function.
    def determineFollowSets(self, start, stop):
        # TODO implement LinkedList as deque()
        #  LinkedList<FollowSetWithPath> result = new LinkedList<>();
        result = deque()
        # TODO implement HashSet as set()
        #  Set<ATNState> seen = new HashSet<>();
        seen = set()
        # TODO implement LinkedList as deque()
        #  LinkedList<Integer> ruleStack = new LinkedList<>();
        ruleStack = deque()
        self.collectFollowSets( start, stop, result, seen, ruleStack )
        return result

    # Collects possible tokens which could be matched following the given ATN state. This is essentially the same
    # algorithm as used in the LL1Analyzer class, but here we consider predicates also and use no parser rule context.
    def collectFollowSets(self, s, stopState, followSets, seen, ruleStack):
        """ generated source for method collectFollowSets """
        # TODO use in operator
        #  if seen.contains(s):
        if s in seen:
            return

        seen.add( s )

        if s == stopState or s.stateType == ATNState.RULE_STOP:
            followSet: FollowSetWithPath = FollowSetWithPath()
            followSet.intervals = IntervalSet.of( Token.EPSILON )
            # TODO implement LinkedList as deque()
            #  set.path = new LinkedList<Integer>(ruleStack);
            followSet.path = deque( ruleStack )
            followSets.append( followSet )
            return

        for transition in s.transitions:
            if transition.serializationType == Transition.RULE:
                ruleTransition = transition
                # TODO check semantic eg skip the current iteration
                #  if ruleStack.index(ruleTransition.target.ruleIndex) != -1:
                if ruleTransition.target.ruleIndex in ruleStack:
                    continue
                ruleStack.append( ruleTransition.target.ruleIndex )
                self.collectFollowSets( transition.target, stopState, followSets, seen, ruleStack )
                ruleStack.pop()
            elif transition.serializationType == Transition.PREDICATE:
                if self.checkPredicate( transition ):
                    self.collectFollowSets( transition.target, stopState, followSets, seen, ruleStack )
            elif transition.isEpsilon:
                self.collectFollowSets( transition.target, stopState, followSets, seen, ruleStack )
            elif transition.serializationType == Transition.WILDCARD:
                followSet: FollowSetWithPath = FollowSetWithPath()
                followSet.intervals = IntervalSet.of( Token.MIN_USER_TOKEN_TYPE, self.atn.maxTokenType )
                # TODO implement LinkedList as deque()
                #  set.path = new LinkedList<Integer>(ruleStack);
                followSet.path = deque( ruleStack )
                followSets.append( followSet )
            else:
                label = transition.label
                if label is not None and len( label ) > 0:
                    if transition.serializationType == Transition.NOT_SET:
                        label = label.complement( IntervalSet.of( Token.MIN_USER_TOKEN_TYPE, self.atn.maxTokenType ) )
                    followSet: FollowSetWithPath = FollowSetWithPath()
                    followSet.intervals = label
                    # TODO implement LinkedList as deque()
                    #  set.path = new LinkedList<Integer>(ruleStack);
                    followSet.path = deque( ruleStack )
                    followSet.following = self.getFollowingTokens( transition )
                    followSets.append( followSet )

    # Walks the ATN for a single rule only. It returns the token stream position for each path that could be matched in this rule.
    # The result can be empty in case we hit only non-epsilon transitions that didn't match the current input or if we
    # hit the caret position.
    def processRule(self, startState: ATNState, tokenListIndex: int, callStack: RuleWithStartTokenList, precedence: int, indentation: int) -> RuleEndStatus:

        # Start with rule specific handling before going into the ATN walk.

        # Check first if we've taken this path with the same input before.
        positionMap = self.shortcutMap.get( startState.ruleIndex )
        if positionMap is None:
            # TODO implement HashMap as dictionaries
            #  positionMap = new HashMap<>();
            positionMap = {}
            self.shortcutMap[startState.ruleIndex] = positionMap
        else:
            if positionMap.containsKey( tokenListIndex ):
                if self.showDebugOutput:
                    # TODO set fine to debug
                    self.logger.debug( "=====> shortcut" )
                return positionMap.get( tokenListIndex )

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
        setsPerState = self.followSetsByATN.get( self.parser.__class__.__name__ )
        if setsPerState is None:
            # TODO implement HashMap as dictionaries
            #  positionMap = new HashMap<>();
            setsPerState = {}
            self.followSetsByATN[self.parser.__class__.__name__] = setsPerState

        followSets = setsPerState.get( startState.stateNumber )
        if followSets is None:
            followSets = FollowSetsHolder()
            setsPerState[startState.stateNumber] = followSets
            stop = self.atn.ruleToStopState[startState.ruleIndex]
            followSets.sets = self.determineFollowSets( startState, stop )

            # Sets are split by path to allow translating them to preferred rules. But for quick hit tests
            # it is also useful to have a set with all symbols combined.
            combined = IntervalSet()
            for followSet in followSets.sets:
                combined.addSet( followSet.intervals )
            followSets.combined = combined

        # TODO next
        # Get the token index where our rule starts from our (possibly filtered) token list
        startTokenIndex = self.tokens[tokenListIndex].tokenIndex

        callStack.append( RuleWithStartToken(startTokenIndex, startState.ruleIndex) )

        currentSymbol = self.tokens[tokenListIndex].type
        if tokenListIndex >= len( self.tokens ) - 1:
            if startState.ruleIndex in self.preferredRules:
                # No need to go deeper when collecting entries and we reach a rule that we want to collect anyway.
                self.translateStackToRuleIndex( callStack )
            else:
                # Convert all follow sets to either single symbols or their associated preferred rule and add
                # the result to our candidates list.
                for followSet in followSets.sets:
                    # TODO implement LinkedList as deque()
                    #  LinkedList<Integer> fullPath = new LinkedList<>(callStack);
                    fullPath = deque( callStack )
                    fullPath.extend( followSet.path )
                    if not self.translateStackToRuleIndex( fullPath ):
                        for symbol in list( followSet.intervals ):
                            if not symbol in self.ignoredTokens:
                                # TODO set logger to debug
                                #  logger.isLoggable(Level.FINE)
                                if self.showDebugOutput and self.logger.isEnabledFor( logging.DEBUG ):
                                    # TODO replace Vocabulary.getDisplayName() vs Intervalset.elementName()
                                    #  self.logger.debug("=====> collected: " + self.vocabulary.getDisplayName(symbol))
                                    self.logger.debug( "=====> collected: " + IntervalSet.elementName( IntervalSet, self.literalNames, self.symbolicNames, symbol) )
                                if not symbol in self.candidates.tokens:
                                    self.candidates.tokens[symbol] = followSet.following
                                else:
                                    if not self.candidates.tokens[symbol] == followSet.following:
                                        # TODO implement LinkedList as deque()
                                        self.candidates.tokens[symbol] = deque()
                            else:
                                self.logger.fine( "====> collection: Ignoring token: " + symbol )
            # callStack.removeLast()
            callStack.pop()
            return result
        else:
            if not followSets.combined.contains( Token.EPSILON ) and not followSets.combined.contains( currentSymbol ):
                # callStack.removeLast()
                callStack.pop()
                return result

        # TODO implement LinkedList as deque()
        #  LinkedList<PipelineEntry> statePipeline = new LinkedList<>();
        statePipeline = deque()
        currentEntry = self.PipelineEntry()
        statePipeline.add( self.PipelineEntry( startState, tokenListIndex ) )
        while not statePipeline.isEmpty():
            currentEntry = statePipeline.removeLast()
            self.statesProcessed += 1
            currentSymbol = self.tokens.get( currentEntry.tokenListIndex ).getType()

            atCaret = currentEntry.tokenListIndex >= self.tokens.size() - 1
            # TODO set logger to debug
            #  logger.isLoggable(Level.FINE)
            if self.logger.isEnabledFor( logging.DEBUG ):
                self.printDescription( indentation, currentEntry.state,
                                       self.generateBaseDescription( currentEntry.state ),
                                       currentEntry.tokenListIndex )
                if self.showRuleStack:
                    self.printRuleState( callStack )
            if currentEntry.state.getStateType() == ATNState.RULE_START:
                indentation += "  "
            elif currentEntry.state.getStateType() == ATNState.RULE_STOP:
                result.add( currentEntry.tokenListIndex )
                continue
            else:
                # TODO fix default case
                # TODO
                #  Transition[] transitions = currentEntry.state.getTransitions();
                transitions = currentEntry.state.getTransitions()
                for transition in transitions:
                    if transition.getSerializationType() == Transition.RULE:
                        # TODO as set
                        #  Set<Integer> endStatus = this.processRule(transition.target, currentEntry.tokenListIndex, callStack, indentation);
                        endStatus = self.processRule( transition.target, currentEntry.tokenListIndex, callStack, indentation )
                        for position in endStatus:
                            statePipeline.append( self.PipelineEntry( (transition).followState, position ) )
                    elif transition.getSerializationType() == Transition.PREDICATE:
                        if self.checkPredicate( transition ):
                            statePipeline.append( self.PipelineEntry( transition.target, currentEntry.tokenListIndex ) )
                    elif transition.getSerializationType() == Transition.WILDCARD:
                        if atCaret:
                            if not self.translateStackToRuleIndex( callStack ):
                                for token in IntervalSet.of( Token.MIN_USER_TOKEN_TYPE,
                                                             self.atn.maxTokenType ).toList():
                                    if not self.ignoredTokens.contains( token ):
                                        # TODO implement LinkedList as deque()
                                        #  this.candidates.tokens.put(token, new LinkedList<Integer>());
                                        self.candidates.tokens[token] = deque()
                        else:
                            statePipeline.append(
                                self.PipelineEntry( transition.target, currentEntry.tokenListIndex + 1 ) )
                    else:
                        if transition.isEpsilon():
                            statePipeline.append( self.PipelineEntry( transition.target, currentEntry.tokenListIndex ) )
                            continue
                        if followSet != None and len( followSet ) > 0:
                            if transition.getSerializationType() == Transition.NOT_SET:
                                followSet = followSet.complement(
                                    IntervalSet.of( Token.MIN_USER_TOKEN_TYPE, self.atn.maxTokenType ) )
                            if atCaret:
                                if not self.translateStackToRuleIndex( callStack ):
                                    # TODO
                                    #  List<Integer> list = set.toList();
                                    list_ = list( followSet )
                                    # TODO check length of list
                                    #  boolean addFollowing = list.size() == 1;
                                    addFollowing = list.size() == 1;
                                    for symbol in list_:
                                        if not self.ignoredTokens.contains( symbol ):
                                            # TODO set logger to debug
                                            #  logger.isLoggable(Level.FINE)
                                            if self.showDebugOutput and self.logger.isEnabledFor( logging.DEBUG ):
                                                # TODO replace Vocabulary.getDisplayName() vs Intervalset.elementName()
                                                #  self.logger.debug("=====> collected: " + self.vocabulary.getDisplayName(symbol))
                                                self.logger.debug( "=====> collected: " + IntervalSet.elementName( IntervalSet, self.literalNames, self.symbolicNames, symbol ) )
                                            if addFollowing:
                                                self.candidates.tokens[symbol] = self.getFollowingTokens( transition )
                                            else:
                                                pass
                                        else:
                                            # TODO set logger to debug
                                            self.logger.debug( "====> collected: Ignoring token: " + symbol )
                            else:
                                if followSet.contains( currentSymbol ):
                                    # TODO set logger to debug
                                    #  logger.isLoggable(Level.FINE)
                                    if self.showDebugOutput and self.logger.isEnabledFor( logging.DEBUG ):
                                        # TODO set logger to debug
                                        # TODO replace Vocabulary.getDisplayName() vs Intervalset.elementName()
                                        #  self.logger.debug("=====> consumed: " + self.vocabulary.getDisplayName(currentSymbol))
                                        self.logger.debug( "=====> consumed: " + IntervalSet.elementName( IntervalSet, self.literalNames, self.symbolicNames, currentSymbol ) )
                                    statePipeline.append(
                                        self.PipelineEntry( transition.target, currentEntry.tokenListIndex + 1 ) )
        callStack.removeLast()
        positionMap[tokenListIndex] = result
        return result

    def generateBaseDescription(self, state):
        """ generated source for method generateBaseDescription """
        # TODO implement Integer.toString as str()
        stateValue = "Invalid" if (state.stateNumber == ATNState.INVALID_STATE_NUMBER) else str( state.stateNumber )
        return "[" + stateValue + " " + self.atnStateTypeMap[state.getStateType()] + "] in " + self.ruleNames[
            state.ruleIndex]

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
        if self.debugOutputWithTransitions and self.logger.isEnabledFor( logging.DEBUG ):
            for transition in state.getTransitions():
                # TODO implement as list of strings
                #  StringBuilder labels = new StringBuilder();
                labels_list = []
                # TODO implement as deque()
                #  List<Integer> symbols = (transition.label() != null) ? transition.label().toList() : new LinkedList<>();
                # TODO check toList
                symbols = transition.label().toList() if (transition.label() != None) else deque()
                if len( symbols ) > 2:
                    # TODO replace Vocabulary.getDisplayName() vs Intervalset.elementName()
                    #  labels_list.append(self.vocabulary.getDisplayName(symbols.get(0)) + " .. " + self.vocabulary.getDisplayName(symbols.get(len(symbols) - 1)))
                    labels_list.append(
                        IntervalSet.elementName( IntervalSet, self.literalNames, self.symbolicNames, symbols.get( 0 ) ) +
                        " .. " +
                        IntervalSet.elementName( IntervalSet, self.literalNames, self.symbolicNames, symbols.get( len( symbols ) - 1 ) )
                    )
                else:
                    for symbol in symbols:
                        if 0 > len( labels_list ):
                            labels_list.append( ", " )
                        # TODO replace Vocabulary.getDisplayName() vs Intervalset.elementName()
                        #  labels_list.append(self.vocabulary.getDisplayName(symbol))
                        labels_list.append( IntervalSet.elementName( IntervalSet, self.literalNames, self.symbolicNames, symbol ) )
                if 0 == len( labels_list ):
                    labels_list.append( "E" )
                transitionDescription_list.append( "\n" ).append( currentIndent ).append( "\t(" ).append(
                    ''.join( labels_list ) ).append( ") [" ).append( transition.target.stateNumber ).append(
                    " " ).append(
                    self.atnStateTypeMap[transition.target.getStateType()] ).append( "] in " ).append(
                    self.ruleNames[transition.target.ruleIndex] )
            if tokenIndex >= len( self.tokens ) - 1:
                output_list.append( "<<" ).append( self.tokenStartIndex + tokenIndex ).append( ">> " )
            else:
                output_list.append( "<" ).append( self.tokenStartIndex + tokenIndex ).append( "> " )
            self.logger.finer(
                ''.join( output_list ) + "Current state: " + baseDescription + ''.join( transitionDescription_list ) )

    def printRuleState(self, stack):
        """ generated source for method printRuleState """
        if stack.isEmpty():
            self.logger.fine( "<empty stack>" )
            return
        # TODO set logger to debug
        #  set new FINER level
        #  check levels
        #  logger.isLoggable(Level.FINER)
        if self.logger.isEnabledFor( logging.DEBUG ):
            # TODO implement as list of strings
            #  StringBuilder sb = new StringBuilder();
            sb_list = []
            for rule in stack:
                sb_list.append( "  " ).append( self.ruleNames[rule] ).append( "\n" )
            self.logger.debug( ''.join( sb_list ) )
