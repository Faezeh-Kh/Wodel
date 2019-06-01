/*
 * generated by Xtext 2.13.0
 */
package wodeledu.dsls.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractEnumRuleElementFinder;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class EduTestGrammarAccess extends AbstractGrammarElementFinder {
	
	public class ProgramElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.EduTest.Program");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cProgramAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cConfigAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cConfigProgramConfigurationParserRuleCall_1_0 = (RuleCall)cConfigAssignment_1.eContents().get(0);
		private final Assignment cExercisesAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExercisesMutatorTestsParserRuleCall_2_0 = (RuleCall)cExercisesAssignment_2.eContents().get(0);
		
		//Program:
		//	{Program} config=ProgramConfiguration?
		//	exercises+=MutatorTests+;
		@Override public ParserRule getRule() { return rule; }
		
		//{Program} config=ProgramConfiguration? exercises+=MutatorTests+
		public Group getGroup() { return cGroup; }
		
		//{Program}
		public Action getProgramAction_0() { return cProgramAction_0; }
		
		//config=ProgramConfiguration?
		public Assignment getConfigAssignment_1() { return cConfigAssignment_1; }
		
		//ProgramConfiguration
		public RuleCall getConfigProgramConfigurationParserRuleCall_1_0() { return cConfigProgramConfigurationParserRuleCall_1_0; }
		
		//exercises+=MutatorTests+
		public Assignment getExercisesAssignment_2() { return cExercisesAssignment_2; }
		
		//MutatorTests
		public RuleCall getExercisesMutatorTestsParserRuleCall_2_0() { return cExercisesMutatorTestsParserRuleCall_2_0; }
	}
	public class MutatorTestsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.EduTest.MutatorTests");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAlternativeResponseParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cMultiChoiceDiagramParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cMultiChoiceEmendationParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//MutatorTests:
		//	AlternativeResponse | MultiChoiceDiagram | MultiChoiceEmendation;
		@Override public ParserRule getRule() { return rule; }
		
		//AlternativeResponse | MultiChoiceDiagram | MultiChoiceEmendation
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//AlternativeResponse
		public RuleCall getAlternativeResponseParserRuleCall_0() { return cAlternativeResponseParserRuleCall_0; }
		
		//MultiChoiceDiagram
		public RuleCall getMultiChoiceDiagramParserRuleCall_1() { return cMultiChoiceDiagramParserRuleCall_1; }
		
		//MultiChoiceEmendation
		public RuleCall getMultiChoiceEmendationParserRuleCall_2() { return cMultiChoiceEmendationParserRuleCall_2; }
	}
	public class AlternativeResponseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.EduTest.AlternativeResponse");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAlternativeResponseKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cBlockAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cBlockBlockCrossReference_1_0 = (CrossReference)cBlockAssignment_1.eContents().get(0);
		private final RuleCall cBlockBlockIDTerminalRuleCall_1_0_1 = (RuleCall)cBlockBlockCrossReference_1_0.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cConfigAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cConfigTestConfigurationParserRuleCall_3_0 = (RuleCall)cConfigAssignment_3.eContents().get(0);
		private final Assignment cTestsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cTestsTestParserRuleCall_4_0 = (RuleCall)cTestsAssignment_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//AlternativeResponse:
		//	'AlternativeResponse' block=[mutatorenvironment::Block]? '{'
		//	config=TestConfiguration
		//	tests+=Test*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'AlternativeResponse' block=[mutatorenvironment::Block]? '{' config=TestConfiguration tests+=Test* '}'
		public Group getGroup() { return cGroup; }
		
		//'AlternativeResponse'
		public Keyword getAlternativeResponseKeyword_0() { return cAlternativeResponseKeyword_0; }
		
		//block=[mutatorenvironment::Block]?
		public Assignment getBlockAssignment_1() { return cBlockAssignment_1; }
		
		//[mutatorenvironment::Block]
		public CrossReference getBlockBlockCrossReference_1_0() { return cBlockBlockCrossReference_1_0; }
		
		//ID
		public RuleCall getBlockBlockIDTerminalRuleCall_1_0_1() { return cBlockBlockIDTerminalRuleCall_1_0_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//config=TestConfiguration
		public Assignment getConfigAssignment_3() { return cConfigAssignment_3; }
		
		//TestConfiguration
		public RuleCall getConfigTestConfigurationParserRuleCall_3_0() { return cConfigTestConfigurationParserRuleCall_3_0; }
		
		//tests+=Test*
		public Assignment getTestsAssignment_4() { return cTestsAssignment_4; }
		
		//Test
		public RuleCall getTestsTestParserRuleCall_4_0() { return cTestsTestParserRuleCall_4_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class MultiChoiceDiagramElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.EduTest.MultiChoiceDiagram");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cMultiChoiceDiagramKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cBlockAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cBlockBlockCrossReference_1_0 = (CrossReference)cBlockAssignment_1.eContents().get(0);
		private final RuleCall cBlockBlockIDTerminalRuleCall_1_0_1 = (RuleCall)cBlockBlockCrossReference_1_0.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cConfigAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cConfigTestConfigurationParserRuleCall_3_0 = (RuleCall)cConfigAssignment_3.eContents().get(0);
		private final Assignment cTestsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cTestsTestParserRuleCall_4_0 = (RuleCall)cTestsAssignment_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//MultiChoiceDiagram:
		//	'MultiChoiceDiagram' block=[mutatorenvironment::Block]? '{'
		//	config=TestConfiguration
		//	tests+=Test*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'MultiChoiceDiagram' block=[mutatorenvironment::Block]? '{' config=TestConfiguration tests+=Test* '}'
		public Group getGroup() { return cGroup; }
		
		//'MultiChoiceDiagram'
		public Keyword getMultiChoiceDiagramKeyword_0() { return cMultiChoiceDiagramKeyword_0; }
		
		//block=[mutatorenvironment::Block]?
		public Assignment getBlockAssignment_1() { return cBlockAssignment_1; }
		
		//[mutatorenvironment::Block]
		public CrossReference getBlockBlockCrossReference_1_0() { return cBlockBlockCrossReference_1_0; }
		
		//ID
		public RuleCall getBlockBlockIDTerminalRuleCall_1_0_1() { return cBlockBlockIDTerminalRuleCall_1_0_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//config=TestConfiguration
		public Assignment getConfigAssignment_3() { return cConfigAssignment_3; }
		
		//TestConfiguration
		public RuleCall getConfigTestConfigurationParserRuleCall_3_0() { return cConfigTestConfigurationParserRuleCall_3_0; }
		
		//tests+=Test*
		public Assignment getTestsAssignment_4() { return cTestsAssignment_4; }
		
		//Test
		public RuleCall getTestsTestParserRuleCall_4_0() { return cTestsTestParserRuleCall_4_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class MultiChoiceEmendationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.EduTest.MultiChoiceEmendation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cMultiChoiceEmendationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cBlockAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cBlockBlockCrossReference_1_0 = (CrossReference)cBlockAssignment_1.eContents().get(0);
		private final RuleCall cBlockBlockIDTerminalRuleCall_1_0_1 = (RuleCall)cBlockBlockCrossReference_1_0.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cConfigAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cConfigMultiChoiceEmConfigParserRuleCall_3_0 = (RuleCall)cConfigAssignment_3.eContents().get(0);
		private final Assignment cTestsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cTestsTestParserRuleCall_4_0 = (RuleCall)cTestsAssignment_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//MultiChoiceEmendation:
		//	'MultiChoiceEmendation' block=[mutatorenvironment::Block]? '{'
		//	config=MultiChoiceEmConfig
		//	tests+=Test*
		//	'}';
		@Override public ParserRule getRule() { return rule; }
		
		//'MultiChoiceEmendation' block=[mutatorenvironment::Block]? '{' config=MultiChoiceEmConfig tests+=Test* '}'
		public Group getGroup() { return cGroup; }
		
		//'MultiChoiceEmendation'
		public Keyword getMultiChoiceEmendationKeyword_0() { return cMultiChoiceEmendationKeyword_0; }
		
		//block=[mutatorenvironment::Block]?
		public Assignment getBlockAssignment_1() { return cBlockAssignment_1; }
		
		//[mutatorenvironment::Block]
		public CrossReference getBlockBlockCrossReference_1_0() { return cBlockBlockCrossReference_1_0; }
		
		//ID
		public RuleCall getBlockBlockIDTerminalRuleCall_1_0_1() { return cBlockBlockIDTerminalRuleCall_1_0_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//config=MultiChoiceEmConfig
		public Assignment getConfigAssignment_3() { return cConfigAssignment_3; }
		
		//MultiChoiceEmConfig
		public RuleCall getConfigMultiChoiceEmConfigParserRuleCall_3_0() { return cConfigMultiChoiceEmConfigParserRuleCall_3_0; }
		
		//tests+=Test*
		public Assignment getTestsAssignment_4() { return cTestsAssignment_4; }
		
		//Test
		public RuleCall getTestsTestParserRuleCall_4_0() { return cTestsTestParserRuleCall_4_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class ProgramConfigurationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.EduTest.ProgramConfiguration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cNavigationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNavigationAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNavigationNavigationEnumRuleCall_2_0 = (RuleCall)cNavigationAssignment_2.eContents().get(0);
		
		//ProgramConfiguration:
		//	'navigation' '=' navigation=Navigation;
		@Override public ParserRule getRule() { return rule; }
		
		//'navigation' '=' navigation=Navigation
		public Group getGroup() { return cGroup; }
		
		//'navigation'
		public Keyword getNavigationKeyword_0() { return cNavigationKeyword_0; }
		
		//'='
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }
		
		//navigation=Navigation
		public Assignment getNavigationAssignment_2() { return cNavigationAssignment_2; }
		
		//Navigation
		public RuleCall getNavigationNavigationEnumRuleCall_2_0() { return cNavigationNavigationEnumRuleCall_2_0; }
	}
	public class TestConfigurationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.EduTest.TestConfiguration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cTestConfigurationAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cRetryKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cRetryAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final Alternatives cRetryAlternatives_3_0 = (Alternatives)cRetryAssignment_3.eContents().get(0);
		private final Keyword cRetryYesKeyword_3_0_0 = (Keyword)cRetryAlternatives_3_0.eContents().get(0);
		private final Keyword cRetryNoKeyword_3_0_1 = (Keyword)cRetryAlternatives_3_0.eContents().get(1);
		
		//TestConfiguration:
		//	{TestConfiguration}
		//	'retry' '=' retry?=('yes' | 'no');
		@Override public ParserRule getRule() { return rule; }
		
		//{TestConfiguration} 'retry' '=' retry?=('yes' | 'no')
		public Group getGroup() { return cGroup; }
		
		//{TestConfiguration}
		public Action getTestConfigurationAction_0() { return cTestConfigurationAction_0; }
		
		//'retry'
		public Keyword getRetryKeyword_1() { return cRetryKeyword_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }
		
		//retry?=('yes' | 'no')
		public Assignment getRetryAssignment_3() { return cRetryAssignment_3; }
		
		//('yes' | 'no')
		public Alternatives getRetryAlternatives_3_0() { return cRetryAlternatives_3_0; }
		
		//'yes'
		public Keyword getRetryYesKeyword_3_0_0() { return cRetryYesKeyword_3_0_0; }
		
		//'no'
		public Keyword getRetryNoKeyword_3_0_1() { return cRetryNoKeyword_3_0_1; }
	}
	public class MultiChoiceEmConfigElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.EduTest.MultiChoiceEmConfig");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMultiChoiceEmConfigAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cRetryKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cRetryAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final Alternatives cRetryAlternatives_3_0 = (Alternatives)cRetryAssignment_3.eContents().get(0);
		private final Keyword cRetryYesKeyword_3_0_0 = (Keyword)cRetryAlternatives_3_0.eContents().get(0);
		private final Keyword cRetryNoKeyword_3_0_1 = (Keyword)cRetryAlternatives_3_0.eContents().get(1);
		private final Keyword cCommaKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Keyword cWeightedKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cEqualsSignKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cWeightedAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final Alternatives cWeightedAlternatives_7_0 = (Alternatives)cWeightedAssignment_7.eContents().get(0);
		private final Keyword cWeightedYesKeyword_7_0_0 = (Keyword)cWeightedAlternatives_7_0.eContents().get(0);
		private final Keyword cWeightedNoKeyword_7_0_1 = (Keyword)cWeightedAlternatives_7_0.eContents().get(1);
		private final Keyword cCommaKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Keyword cPenaltyKeyword_9 = (Keyword)cGroup.eContents().get(9);
		private final Keyword cEqualsSignKeyword_10 = (Keyword)cGroup.eContents().get(10);
		private final Assignment cPenaltyAssignment_11 = (Assignment)cGroup.eContents().get(11);
		private final RuleCall cPenaltyEDoubleParserRuleCall_11_0 = (RuleCall)cPenaltyAssignment_11.eContents().get(0);
		private final Keyword cCommaKeyword_12 = (Keyword)cGroup.eContents().get(12);
		private final Keyword cOrderKeyword_13 = (Keyword)cGroup.eContents().get(13);
		private final Keyword cEqualsSignKeyword_14 = (Keyword)cGroup.eContents().get(14);
		private final Assignment cOrderAssignment_15 = (Assignment)cGroup.eContents().get(15);
		private final RuleCall cOrderOrderEnumRuleCall_15_0 = (RuleCall)cOrderAssignment_15.eContents().get(0);
		private final Keyword cCommaKeyword_16 = (Keyword)cGroup.eContents().get(16);
		private final Keyword cModeKeyword_17 = (Keyword)cGroup.eContents().get(17);
		private final Keyword cEqualsSignKeyword_18 = (Keyword)cGroup.eContents().get(18);
		private final Assignment cModeAssignment_19 = (Assignment)cGroup.eContents().get(19);
		private final RuleCall cModeModeEnumRuleCall_19_0 = (RuleCall)cModeAssignment_19.eContents().get(0);
		
		//MultiChoiceEmConfig:
		//	{MultiChoiceEmConfig}
		//	'retry' '=' retry?=('yes' | 'no') ',' 'weighted' '=' weighted?=('yes' | 'no') ',' 'penalty' '=' penalty=EDouble ','
		//	'order' '=' order=Order ',' 'mode' '=' mode=Mode;
		@Override public ParserRule getRule() { return rule; }
		
		//{MultiChoiceEmConfig} 'retry' '=' retry?=('yes' | 'no') ',' 'weighted' '=' weighted?=('yes' | 'no') ',' 'penalty' '='
		//penalty=EDouble ',' 'order' '=' order=Order ',' 'mode' '=' mode=Mode
		public Group getGroup() { return cGroup; }
		
		//{MultiChoiceEmConfig}
		public Action getMultiChoiceEmConfigAction_0() { return cMultiChoiceEmConfigAction_0; }
		
		//'retry'
		public Keyword getRetryKeyword_1() { return cRetryKeyword_1; }
		
		//'='
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }
		
		//retry?=('yes' | 'no')
		public Assignment getRetryAssignment_3() { return cRetryAssignment_3; }
		
		//('yes' | 'no')
		public Alternatives getRetryAlternatives_3_0() { return cRetryAlternatives_3_0; }
		
		//'yes'
		public Keyword getRetryYesKeyword_3_0_0() { return cRetryYesKeyword_3_0_0; }
		
		//'no'
		public Keyword getRetryNoKeyword_3_0_1() { return cRetryNoKeyword_3_0_1; }
		
		//','
		public Keyword getCommaKeyword_4() { return cCommaKeyword_4; }
		
		//'weighted'
		public Keyword getWeightedKeyword_5() { return cWeightedKeyword_5; }
		
		//'='
		public Keyword getEqualsSignKeyword_6() { return cEqualsSignKeyword_6; }
		
		//weighted?=('yes' | 'no')
		public Assignment getWeightedAssignment_7() { return cWeightedAssignment_7; }
		
		//('yes' | 'no')
		public Alternatives getWeightedAlternatives_7_0() { return cWeightedAlternatives_7_0; }
		
		//'yes'
		public Keyword getWeightedYesKeyword_7_0_0() { return cWeightedYesKeyword_7_0_0; }
		
		//'no'
		public Keyword getWeightedNoKeyword_7_0_1() { return cWeightedNoKeyword_7_0_1; }
		
		//','
		public Keyword getCommaKeyword_8() { return cCommaKeyword_8; }
		
		//'penalty'
		public Keyword getPenaltyKeyword_9() { return cPenaltyKeyword_9; }
		
		//'='
		public Keyword getEqualsSignKeyword_10() { return cEqualsSignKeyword_10; }
		
		//penalty=EDouble
		public Assignment getPenaltyAssignment_11() { return cPenaltyAssignment_11; }
		
		//EDouble
		public RuleCall getPenaltyEDoubleParserRuleCall_11_0() { return cPenaltyEDoubleParserRuleCall_11_0; }
		
		//','
		public Keyword getCommaKeyword_12() { return cCommaKeyword_12; }
		
		//'order'
		public Keyword getOrderKeyword_13() { return cOrderKeyword_13; }
		
		//'='
		public Keyword getEqualsSignKeyword_14() { return cEqualsSignKeyword_14; }
		
		//order=Order
		public Assignment getOrderAssignment_15() { return cOrderAssignment_15; }
		
		//Order
		public RuleCall getOrderOrderEnumRuleCall_15_0() { return cOrderOrderEnumRuleCall_15_0; }
		
		//','
		public Keyword getCommaKeyword_16() { return cCommaKeyword_16; }
		
		//'mode'
		public Keyword getModeKeyword_17() { return cModeKeyword_17; }
		
		//'='
		public Keyword getEqualsSignKeyword_18() { return cEqualsSignKeyword_18; }
		
		//mode=Mode
		public Assignment getModeAssignment_19() { return cModeAssignment_19; }
		
		//Mode
		public RuleCall getModeModeEnumRuleCall_19_0() { return cModeModeEnumRuleCall_19_0; }
	}
	public class TestElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.EduTest.Test");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cDescriptionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cForKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cSourceAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cSourceEStringParserRuleCall_2_0 = (RuleCall)cSourceAssignment_2.eContents().get(0);
		private final Keyword cEqualsSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cQuestionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cQuestionEStringParserRuleCall_4_0 = (RuleCall)cQuestionAssignment_4.eContents().get(0);
		
		//Test:
		//	'description' 'for' source=EString '=' question=EString;
		@Override public ParserRule getRule() { return rule; }
		
		//'description' 'for' source=EString '=' question=EString
		public Group getGroup() { return cGroup; }
		
		//'description'
		public Keyword getDescriptionKeyword_0() { return cDescriptionKeyword_0; }
		
		//'for'
		public Keyword getForKeyword_1() { return cForKeyword_1; }
		
		//source=EString
		public Assignment getSourceAssignment_2() { return cSourceAssignment_2; }
		
		//EString
		public RuleCall getSourceEStringParserRuleCall_2_0() { return cSourceEStringParserRuleCall_2_0; }
		
		//'='
		public Keyword getEqualsSignKeyword_3() { return cEqualsSignKeyword_3; }
		
		//question=EString
		public Assignment getQuestionAssignment_4() { return cQuestionAssignment_4; }
		
		//EString
		public RuleCall getQuestionEStringParserRuleCall_4_0() { return cQuestionEStringParserRuleCall_4_0; }
	}
	public class EStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.EduTest.EString");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSTRINGTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//EString:
		//	STRING | ID;
		@Override public ParserRule getRule() { return rule; }
		
		//STRING | ID
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//STRING
		public RuleCall getSTRINGTerminalRuleCall_0() { return cSTRINGTerminalRuleCall_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }
	}
	public class EDoubleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.EduTest.EDouble");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final RuleCall cINTTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Alternatives cAlternatives_4_0 = (Alternatives)cGroup_4.eContents().get(0);
		private final Keyword cEKeyword_4_0_0 = (Keyword)cAlternatives_4_0.eContents().get(0);
		private final Keyword cEKeyword_4_0_1 = (Keyword)cAlternatives_4_0.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_4_1 = (Keyword)cGroup_4.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_4_2 = (RuleCall)cGroup_4.eContents().get(2);
		
		//EDouble ecore::EDouble:
		//	'-'? INT? '.' INT (('E' | 'e') '-'? INT)?;
		@Override public ParserRule getRule() { return rule; }
		
		//'-'? INT? '.' INT (('E' | 'e') '-'? INT)?
		public Group getGroup() { return cGroup; }
		
		//'-'?
		public Keyword getHyphenMinusKeyword_0() { return cHyphenMinusKeyword_0; }
		
		//INT?
		public RuleCall getINTTerminalRuleCall_1() { return cINTTerminalRuleCall_1; }
		
		//'.'
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_3() { return cINTTerminalRuleCall_3; }
		
		//(('E' | 'e') '-'? INT)?
		public Group getGroup_4() { return cGroup_4; }
		
		//'E' | 'e'
		public Alternatives getAlternatives_4_0() { return cAlternatives_4_0; }
		
		//'E'
		public Keyword getEKeyword_4_0_0() { return cEKeyword_4_0_0; }
		
		//'e'
		public Keyword getEKeyword_4_0_1() { return cEKeyword_4_0_1; }
		
		//'-'?
		public Keyword getHyphenMinusKeyword_4_1() { return cHyphenMinusKeyword_4_1; }
		
		//INT
		public RuleCall getINTTerminalRuleCall_4_2() { return cINTTerminalRuleCall_4_2; }
	}
	
	public class OrderElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.EduTest.Order");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cFixedEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cFixedFixedKeyword_0_0 = (Keyword)cFixedEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cRandomEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cRandomRandomKeyword_1_0 = (Keyword)cRandomEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cAscendingEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cAscendingOptionsAscendingKeyword_2_0 = (Keyword)cAscendingEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cDescendingEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cDescendingOptionsDescendingKeyword_3_0 = (Keyword)cDescendingEnumLiteralDeclaration_3.eContents().get(0);
		
		//enum Order:
		//	fixed | random | ascending='options-ascending' | descending='options-descending';
		public EnumRule getRule() { return rule; }
		
		//fixed | random | ascending='options-ascending' | descending='options-descending'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//fixed
		public EnumLiteralDeclaration getFixedEnumLiteralDeclaration_0() { return cFixedEnumLiteralDeclaration_0; }
		
		//'fixed'
		public Keyword getFixedFixedKeyword_0_0() { return cFixedFixedKeyword_0_0; }
		
		//random
		public EnumLiteralDeclaration getRandomEnumLiteralDeclaration_1() { return cRandomEnumLiteralDeclaration_1; }
		
		//'random'
		public Keyword getRandomRandomKeyword_1_0() { return cRandomRandomKeyword_1_0; }
		
		//ascending='options-ascending'
		public EnumLiteralDeclaration getAscendingEnumLiteralDeclaration_2() { return cAscendingEnumLiteralDeclaration_2; }
		
		//'options-ascending'
		public Keyword getAscendingOptionsAscendingKeyword_2_0() { return cAscendingOptionsAscendingKeyword_2_0; }
		
		//descending='options-descending'
		public EnumLiteralDeclaration getDescendingEnumLiteralDeclaration_3() { return cDescendingEnumLiteralDeclaration_3; }
		
		//'options-descending'
		public Keyword getDescendingOptionsDescendingKeyword_3_0() { return cDescendingOptionsDescendingKeyword_3_0; }
	}
	public class ModeElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.EduTest.Mode");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cRadiobuttonEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cRadiobuttonRadiobuttonKeyword_0_0 = (Keyword)cRadiobuttonEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cCheckboxEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cCheckboxCheckboxKeyword_1_0 = (Keyword)cCheckboxEnumLiteralDeclaration_1.eContents().get(0);
		
		//enum Mode:
		//	radiobutton | checkbox;
		public EnumRule getRule() { return rule; }
		
		//radiobutton | checkbox
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//radiobutton
		public EnumLiteralDeclaration getRadiobuttonEnumLiteralDeclaration_0() { return cRadiobuttonEnumLiteralDeclaration_0; }
		
		//'radiobutton'
		public Keyword getRadiobuttonRadiobuttonKeyword_0_0() { return cRadiobuttonRadiobuttonKeyword_0_0; }
		
		//checkbox
		public EnumLiteralDeclaration getCheckboxEnumLiteralDeclaration_1() { return cCheckboxEnumLiteralDeclaration_1; }
		
		//'checkbox'
		public Keyword getCheckboxCheckboxKeyword_1_0() { return cCheckboxCheckboxKeyword_1_0; }
	}
	public class NavigationElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.EduTest.Navigation");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cFreeEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cFreeFreeKeyword_0_0 = (Keyword)cFreeEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cLockedEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cLockedLockedKeyword_1_0 = (Keyword)cLockedEnumLiteralDeclaration_1.eContents().get(0);
		
		//enum Navigation:
		//	free | locked;
		public EnumRule getRule() { return rule; }
		
		//free | locked
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//free
		public EnumLiteralDeclaration getFreeEnumLiteralDeclaration_0() { return cFreeEnumLiteralDeclaration_0; }
		
		//'free'
		public Keyword getFreeFreeKeyword_0_0() { return cFreeFreeKeyword_0_0; }
		
		//locked
		public EnumLiteralDeclaration getLockedEnumLiteralDeclaration_1() { return cLockedEnumLiteralDeclaration_1; }
		
		//'locked'
		public Keyword getLockedLockedKeyword_1_0() { return cLockedLockedKeyword_1_0; }
	}
	
	private final ProgramElements pProgram;
	private final MutatorTestsElements pMutatorTests;
	private final AlternativeResponseElements pAlternativeResponse;
	private final MultiChoiceDiagramElements pMultiChoiceDiagram;
	private final MultiChoiceEmendationElements pMultiChoiceEmendation;
	private final ProgramConfigurationElements pProgramConfiguration;
	private final TestConfigurationElements pTestConfiguration;
	private final MultiChoiceEmConfigElements pMultiChoiceEmConfig;
	private final TestElements pTest;
	private final EStringElements pEString;
	private final EDoubleElements pEDouble;
	private final OrderElements eOrder;
	private final ModeElements eMode;
	private final NavigationElements eNavigation;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public EduTestGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pProgram = new ProgramElements();
		this.pMutatorTests = new MutatorTestsElements();
		this.pAlternativeResponse = new AlternativeResponseElements();
		this.pMultiChoiceDiagram = new MultiChoiceDiagramElements();
		this.pMultiChoiceEmendation = new MultiChoiceEmendationElements();
		this.pProgramConfiguration = new ProgramConfigurationElements();
		this.pTestConfiguration = new TestConfigurationElements();
		this.pMultiChoiceEmConfig = new MultiChoiceEmConfigElements();
		this.pTest = new TestElements();
		this.pEString = new EStringElements();
		this.pEDouble = new EDoubleElements();
		this.eOrder = new OrderElements();
		this.eMode = new ModeElements();
		this.eNavigation = new NavigationElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("wodeledu.dsls.EduTest".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Program:
	//	{Program} config=ProgramConfiguration?
	//	exercises+=MutatorTests+;
	public ProgramElements getProgramAccess() {
		return pProgram;
	}
	
	public ParserRule getProgramRule() {
		return getProgramAccess().getRule();
	}
	
	//MutatorTests:
	//	AlternativeResponse | MultiChoiceDiagram | MultiChoiceEmendation;
	public MutatorTestsElements getMutatorTestsAccess() {
		return pMutatorTests;
	}
	
	public ParserRule getMutatorTestsRule() {
		return getMutatorTestsAccess().getRule();
	}
	
	//AlternativeResponse:
	//	'AlternativeResponse' block=[mutatorenvironment::Block]? '{'
	//	config=TestConfiguration
	//	tests+=Test*
	//	'}';
	public AlternativeResponseElements getAlternativeResponseAccess() {
		return pAlternativeResponse;
	}
	
	public ParserRule getAlternativeResponseRule() {
		return getAlternativeResponseAccess().getRule();
	}
	
	//MultiChoiceDiagram:
	//	'MultiChoiceDiagram' block=[mutatorenvironment::Block]? '{'
	//	config=TestConfiguration
	//	tests+=Test*
	//	'}';
	public MultiChoiceDiagramElements getMultiChoiceDiagramAccess() {
		return pMultiChoiceDiagram;
	}
	
	public ParserRule getMultiChoiceDiagramRule() {
		return getMultiChoiceDiagramAccess().getRule();
	}
	
	//MultiChoiceEmendation:
	//	'MultiChoiceEmendation' block=[mutatorenvironment::Block]? '{'
	//	config=MultiChoiceEmConfig
	//	tests+=Test*
	//	'}';
	public MultiChoiceEmendationElements getMultiChoiceEmendationAccess() {
		return pMultiChoiceEmendation;
	}
	
	public ParserRule getMultiChoiceEmendationRule() {
		return getMultiChoiceEmendationAccess().getRule();
	}
	
	//ProgramConfiguration:
	//	'navigation' '=' navigation=Navigation;
	public ProgramConfigurationElements getProgramConfigurationAccess() {
		return pProgramConfiguration;
	}
	
	public ParserRule getProgramConfigurationRule() {
		return getProgramConfigurationAccess().getRule();
	}
	
	//TestConfiguration:
	//	{TestConfiguration}
	//	'retry' '=' retry?=('yes' | 'no');
	public TestConfigurationElements getTestConfigurationAccess() {
		return pTestConfiguration;
	}
	
	public ParserRule getTestConfigurationRule() {
		return getTestConfigurationAccess().getRule();
	}
	
	//MultiChoiceEmConfig:
	//	{MultiChoiceEmConfig}
	//	'retry' '=' retry?=('yes' | 'no') ',' 'weighted' '=' weighted?=('yes' | 'no') ',' 'penalty' '=' penalty=EDouble ','
	//	'order' '=' order=Order ',' 'mode' '=' mode=Mode;
	public MultiChoiceEmConfigElements getMultiChoiceEmConfigAccess() {
		return pMultiChoiceEmConfig;
	}
	
	public ParserRule getMultiChoiceEmConfigRule() {
		return getMultiChoiceEmConfigAccess().getRule();
	}
	
	//Test:
	//	'description' 'for' source=EString '=' question=EString;
	public TestElements getTestAccess() {
		return pTest;
	}
	
	public ParserRule getTestRule() {
		return getTestAccess().getRule();
	}
	
	//EString:
	//	STRING | ID;
	public EStringElements getEStringAccess() {
		return pEString;
	}
	
	public ParserRule getEStringRule() {
		return getEStringAccess().getRule();
	}
	
	//EDouble ecore::EDouble:
	//	'-'? INT? '.' INT (('E' | 'e') '-'? INT)?;
	public EDoubleElements getEDoubleAccess() {
		return pEDouble;
	}
	
	public ParserRule getEDoubleRule() {
		return getEDoubleAccess().getRule();
	}
	
	//enum Order:
	//	fixed | random | ascending='options-ascending' | descending='options-descending';
	public OrderElements getOrderAccess() {
		return eOrder;
	}
	
	public EnumRule getOrderRule() {
		return getOrderAccess().getRule();
	}
	
	//enum Mode:
	//	radiobutton | checkbox;
	public ModeElements getModeAccess() {
		return eMode;
	}
	
	public EnumRule getModeRule() {
		return getModeAccess().getRule();
	}
	
	//enum Navigation:
	//	free | locked;
	public NavigationElements getNavigationAccess() {
		return eNavigation;
	}
	
	public EnumRule getNavigationRule() {
		return getNavigationAccess().getRule();
	}
	
	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' | "'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
