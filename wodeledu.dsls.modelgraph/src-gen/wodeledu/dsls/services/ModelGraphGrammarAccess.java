/*
 * generated by Xtext
 */
package wodeledu.dsls.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class ModelGraphGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class MutatorGraphElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MutatorGraph");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMutatorGraphAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cMetamodelKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cMetamodelAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cMetamodelEStringParserRuleCall_2_0 = (RuleCall)cMetamodelAssignment_2.eContents().get(0);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cNameEClassCrossReference_3_0 = (CrossReference)cNameAssignment_3.eContents().get(0);
		private final RuleCall cNameEClassIDTerminalRuleCall_3_0_1 = (RuleCall)cNameEClassCrossReference_3_0.eContents().get(1);
		private final Keyword cColonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cTypeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cTypeGraphTypeEnumRuleCall_5_0 = (RuleCall)cTypeAssignment_5.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cNodesAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cNodesNodeParserRuleCall_7_0 = (RuleCall)cNodesAssignment_7.eContents().get(0);
		private final Assignment cEdgesAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cEdgesEdgeParserRuleCall_8_0 = (RuleCall)cEdgesAssignment_8.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_9 = (Keyword)cGroup.eContents().get(9);
		
		//MutatorGraph:
		//	{MutatorGraph} "metamodel" metamodel=EString name=[ecore::EClass] ":" type=GraphType "{" nodes+=Node* edges+=Edge*
		//	"}";
		@Override public ParserRule getRule() { return rule; }

		//{MutatorGraph} "metamodel" metamodel=EString name=[ecore::EClass] ":" type=GraphType "{" nodes+=Node* edges+=Edge* "}"
		public Group getGroup() { return cGroup; }

		//{MutatorGraph}
		public Action getMutatorGraphAction_0() { return cMutatorGraphAction_0; }

		//"metamodel"
		public Keyword getMetamodelKeyword_1() { return cMetamodelKeyword_1; }

		//metamodel=EString
		public Assignment getMetamodelAssignment_2() { return cMetamodelAssignment_2; }

		//EString
		public RuleCall getMetamodelEStringParserRuleCall_2_0() { return cMetamodelEStringParserRuleCall_2_0; }

		//name=[ecore::EClass]
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }

		//[ecore::EClass]
		public CrossReference getNameEClassCrossReference_3_0() { return cNameEClassCrossReference_3_0; }

		//ID
		public RuleCall getNameEClassIDTerminalRuleCall_3_0_1() { return cNameEClassIDTerminalRuleCall_3_0_1; }

		//":"
		public Keyword getColonKeyword_4() { return cColonKeyword_4; }

		//type=GraphType
		public Assignment getTypeAssignment_5() { return cTypeAssignment_5; }

		//GraphType
		public RuleCall getTypeGraphTypeEnumRuleCall_5_0() { return cTypeGraphTypeEnumRuleCall_5_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_6() { return cLeftCurlyBracketKeyword_6; }

		//nodes+=Node*
		public Assignment getNodesAssignment_7() { return cNodesAssignment_7; }

		//Node
		public RuleCall getNodesNodeParserRuleCall_7_0() { return cNodesNodeParserRuleCall_7_0; }

		//edges+=Edge*
		public Assignment getEdgesAssignment_8() { return cEdgesAssignment_8; }

		//Edge
		public RuleCall getEdgesEdgeParserRuleCall_8_0() { return cEdgesEdgeParserRuleCall_8_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_9() { return cRightCurlyBracketKeyword_9; }
	}

	public class EStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EString");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSTRINGTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//EString returns ecore::EString:
		//	STRING | ID;
		@Override public ParserRule getRule() { return rule; }

		//STRING | ID
		public Alternatives getAlternatives() { return cAlternatives; }

		//STRING
		public RuleCall getSTRINGTerminalRuleCall_0() { return cSTRINGTerminalRuleCall_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }
	}

	public class NodeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Node");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cNodeAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cNameEClassCrossReference_1_0 = (CrossReference)cNameAssignment_1.eContents().get(0);
		private final RuleCall cNameEClassIDTerminalRuleCall_1_0_1 = (RuleCall)cNameEClassCrossReference_1_0.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Assignment cNegationAssignment_3_0 = (Assignment)cAlternatives_3.eContents().get(0);
		private final Keyword cNegationNotKeyword_3_0_0 = (Keyword)cNegationAssignment_3_0.eContents().get(0);
		private final Keyword cYesKeyword_3_1 = (Keyword)cAlternatives_3.eContents().get(1);
		private final Assignment cAttributeAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cAttributeEAttributeCrossReference_4_0 = (CrossReference)cAttributeAssignment_4.eContents().get(0);
		private final RuleCall cAttributeEAttributeIDTerminalRuleCall_4_0_1 = (RuleCall)cAttributeEAttributeCrossReference_4_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Keyword cColonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cTypeAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cTypeNodeTypeEnumRuleCall_7_0 = (RuleCall)cTypeAssignment_7.eContents().get(0);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cCommaKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Keyword cShapeKeyword_8_1 = (Keyword)cGroup_8.eContents().get(1);
		private final Keyword cEqualsSignKeyword_8_2 = (Keyword)cGroup_8.eContents().get(2);
		private final Assignment cShapeAssignment_8_3 = (Assignment)cGroup_8.eContents().get(3);
		private final RuleCall cShapeNodeShapeEnumRuleCall_8_3_0 = (RuleCall)cShapeAssignment_8_3.eContents().get(0);
		
		//Node:
		//	{Node} name=[ecore::EClass] "(" (negation?="not" | "yes")? attribute=[ecore::EAttribute] ")" ":" type=NodeType (","
		//	"shape" "=" shape=NodeShape)?;
		@Override public ParserRule getRule() { return rule; }

		//{Node} name=[ecore::EClass] "(" (negation?="not" | "yes")? attribute=[ecore::EAttribute] ")" ":" type=NodeType (","
		//"shape" "=" shape=NodeShape)?
		public Group getGroup() { return cGroup; }

		//{Node}
		public Action getNodeAction_0() { return cNodeAction_0; }

		//name=[ecore::EClass]
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//[ecore::EClass]
		public CrossReference getNameEClassCrossReference_1_0() { return cNameEClassCrossReference_1_0; }

		//ID
		public RuleCall getNameEClassIDTerminalRuleCall_1_0_1() { return cNameEClassIDTerminalRuleCall_1_0_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }

		//(negation?="not" | "yes")?
		public Alternatives getAlternatives_3() { return cAlternatives_3; }

		//negation?="not"
		public Assignment getNegationAssignment_3_0() { return cNegationAssignment_3_0; }

		//"not"
		public Keyword getNegationNotKeyword_3_0_0() { return cNegationNotKeyword_3_0_0; }

		//"yes"
		public Keyword getYesKeyword_3_1() { return cYesKeyword_3_1; }

		//attribute=[ecore::EAttribute]
		public Assignment getAttributeAssignment_4() { return cAttributeAssignment_4; }

		//[ecore::EAttribute]
		public CrossReference getAttributeEAttributeCrossReference_4_0() { return cAttributeEAttributeCrossReference_4_0; }

		//ID
		public RuleCall getAttributeEAttributeIDTerminalRuleCall_4_0_1() { return cAttributeEAttributeIDTerminalRuleCall_4_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }

		//":"
		public Keyword getColonKeyword_6() { return cColonKeyword_6; }

		//type=NodeType
		public Assignment getTypeAssignment_7() { return cTypeAssignment_7; }

		//NodeType
		public RuleCall getTypeNodeTypeEnumRuleCall_7_0() { return cTypeNodeTypeEnumRuleCall_7_0; }

		//("," "shape" "=" shape=NodeShape)?
		public Group getGroup_8() { return cGroup_8; }

		//","
		public Keyword getCommaKeyword_8_0() { return cCommaKeyword_8_0; }

		//"shape"
		public Keyword getShapeKeyword_8_1() { return cShapeKeyword_8_1; }

		//"="
		public Keyword getEqualsSignKeyword_8_2() { return cEqualsSignKeyword_8_2; }

		//shape=NodeShape
		public Assignment getShapeAssignment_8_3() { return cShapeAssignment_8_3; }

		//NodeShape
		public RuleCall getShapeNodeShapeEnumRuleCall_8_3_0() { return cShapeNodeShapeEnumRuleCall_8_3_0; }
	}

	public class EdgeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Edge");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cEdgeAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cNameEClassCrossReference_1_0 = (CrossReference)cNameAssignment_1.eContents().get(0);
		private final RuleCall cNameEClassIDTerminalRuleCall_1_0_1 = (RuleCall)cNameEClassCrossReference_1_0.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cSourceAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cSourceEReferenceCrossReference_3_0 = (CrossReference)cSourceAssignment_3.eContents().get(0);
		private final RuleCall cSourceEReferenceIDTerminalRuleCall_3_0_1 = (RuleCall)cSourceEReferenceCrossReference_3_0.eContents().get(1);
		private final Keyword cCommaKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cTargetAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cTargetEReferenceCrossReference_5_0 = (CrossReference)cTargetAssignment_5.eContents().get(0);
		private final RuleCall cTargetEReferenceIDTerminalRuleCall_5_0_1 = (RuleCall)cTargetEReferenceCrossReference_5_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Keyword cColonKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Keyword cEdgeKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Keyword cCommaKeyword_9 = (Keyword)cGroup.eContents().get(9);
		private final Keyword cLabelKeyword_10 = (Keyword)cGroup.eContents().get(10);
		private final Keyword cEqualsSignKeyword_11 = (Keyword)cGroup.eContents().get(11);
		private final Assignment cLabelAssignment_12 = (Assignment)cGroup.eContents().get(12);
		private final CrossReference cLabelEReferenceCrossReference_12_0 = (CrossReference)cLabelAssignment_12.eContents().get(0);
		private final RuleCall cLabelEReferenceIDTerminalRuleCall_12_0_1 = (RuleCall)cLabelEReferenceCrossReference_12_0.eContents().get(1);
		
		//Edge:
		//	{Edge} name=[ecore::EClass] "(" source=[ecore::EReference] "," target=[ecore::EReference] ")" ":" "edge" "," "label"
		//	"=" label=[ecore::EReference];
		@Override public ParserRule getRule() { return rule; }

		//{Edge} name=[ecore::EClass] "(" source=[ecore::EReference] "," target=[ecore::EReference] ")" ":" "edge" "," "label" "="
		//label=[ecore::EReference]
		public Group getGroup() { return cGroup; }

		//{Edge}
		public Action getEdgeAction_0() { return cEdgeAction_0; }

		//name=[ecore::EClass]
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//[ecore::EClass]
		public CrossReference getNameEClassCrossReference_1_0() { return cNameEClassCrossReference_1_0; }

		//ID
		public RuleCall getNameEClassIDTerminalRuleCall_1_0_1() { return cNameEClassIDTerminalRuleCall_1_0_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }

		//source=[ecore::EReference]
		public Assignment getSourceAssignment_3() { return cSourceAssignment_3; }

		//[ecore::EReference]
		public CrossReference getSourceEReferenceCrossReference_3_0() { return cSourceEReferenceCrossReference_3_0; }

		//ID
		public RuleCall getSourceEReferenceIDTerminalRuleCall_3_0_1() { return cSourceEReferenceIDTerminalRuleCall_3_0_1; }

		//","
		public Keyword getCommaKeyword_4() { return cCommaKeyword_4; }

		//target=[ecore::EReference]
		public Assignment getTargetAssignment_5() { return cTargetAssignment_5; }

		//[ecore::EReference]
		public CrossReference getTargetEReferenceCrossReference_5_0() { return cTargetEReferenceCrossReference_5_0; }

		//ID
		public RuleCall getTargetEReferenceIDTerminalRuleCall_5_0_1() { return cTargetEReferenceIDTerminalRuleCall_5_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_6() { return cRightParenthesisKeyword_6; }

		//":"
		public Keyword getColonKeyword_7() { return cColonKeyword_7; }

		//"edge"
		public Keyword getEdgeKeyword_8() { return cEdgeKeyword_8; }

		//","
		public Keyword getCommaKeyword_9() { return cCommaKeyword_9; }

		//"label"
		public Keyword getLabelKeyword_10() { return cLabelKeyword_10; }

		//"="
		public Keyword getEqualsSignKeyword_11() { return cEqualsSignKeyword_11; }

		//label=[ecore::EReference]
		public Assignment getLabelAssignment_12() { return cLabelAssignment_12; }

		//[ecore::EReference]
		public CrossReference getLabelEReferenceCrossReference_12_0() { return cLabelEReferenceCrossReference_12_0; }

		//ID
		public RuleCall getLabelEReferenceIDTerminalRuleCall_12_0_1() { return cLabelEReferenceIDTerminalRuleCall_12_0_1; }
	}
	
	
	public class GraphTypeElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "GraphType");
		private final EnumLiteralDeclaration cDiagramEnumLiteralDeclaration = (EnumLiteralDeclaration)rule.eContents().get(1);
		private final Keyword cDiagramDiagramKeyword_0 = (Keyword)cDiagramEnumLiteralDeclaration.eContents().get(0);
		
		//enum GraphType:
		//	diagram;
		public EnumRule getRule() { return rule; }

		//diagram
		public EnumLiteralDeclaration getDiagramEnumLiteralDeclaration() { return cDiagramEnumLiteralDeclaration; }

		//"diagram"
		public Keyword getDiagramDiagramKeyword_0() { return cDiagramDiagramKeyword_0; }
	}

	public class NodeTypeElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "NodeType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cNodeEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cNodeNodeKeyword_0_0 = (Keyword)cNodeEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cMarkednodeEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cMarkednodeMarkednodeKeyword_1_0 = (Keyword)cMarkednodeEnumLiteralDeclaration_1.eContents().get(0);
		
		//enum NodeType:
		//	node | markednode;
		public EnumRule getRule() { return rule; }

		//node | markednode
		public Alternatives getAlternatives() { return cAlternatives; }

		//node
		public EnumLiteralDeclaration getNodeEnumLiteralDeclaration_0() { return cNodeEnumLiteralDeclaration_0; }

		//"node"
		public Keyword getNodeNodeKeyword_0_0() { return cNodeNodeKeyword_0_0; }

		//markednode
		public EnumLiteralDeclaration getMarkednodeEnumLiteralDeclaration_1() { return cMarkednodeEnumLiteralDeclaration_1; }

		//"markednode"
		public Keyword getMarkednodeMarkednodeKeyword_1_0() { return cMarkednodeMarkednodeKeyword_1_0; }
	}

	public class NodeShapeElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "NodeShape");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cCircleEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cCircleCircleKeyword_0_0 = (Keyword)cCircleEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cDoublecircleEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cDoublecircleDoublecircleKeyword_1_0 = (Keyword)cDoublecircleEnumLiteralDeclaration_1.eContents().get(0);
		
		//enum NodeShape:
		//	circle | doublecircle;
		public EnumRule getRule() { return rule; }

		//circle | doublecircle
		public Alternatives getAlternatives() { return cAlternatives; }

		//circle
		public EnumLiteralDeclaration getCircleEnumLiteralDeclaration_0() { return cCircleEnumLiteralDeclaration_0; }

		//"circle"
		public Keyword getCircleCircleKeyword_0_0() { return cCircleCircleKeyword_0_0; }

		//doublecircle
		public EnumLiteralDeclaration getDoublecircleEnumLiteralDeclaration_1() { return cDoublecircleEnumLiteralDeclaration_1; }

		//"doublecircle"
		public Keyword getDoublecircleDoublecircleKeyword_1_0() { return cDoublecircleDoublecircleKeyword_1_0; }
	}
	
	private final MutatorGraphElements pMutatorGraph;
	private final EStringElements pEString;
	private final GraphTypeElements unknownRuleGraphType;
	private final NodeElements pNode;
	private final EdgeElements pEdge;
	private final NodeTypeElements unknownRuleNodeType;
	private final NodeShapeElements unknownRuleNodeShape;
	
	private final Grammar grammar;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public ModelGraphGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pMutatorGraph = new MutatorGraphElements();
		this.pEString = new EStringElements();
		this.unknownRuleGraphType = new GraphTypeElements();
		this.pNode = new NodeElements();
		this.pEdge = new EdgeElements();
		this.unknownRuleNodeType = new NodeTypeElements();
		this.unknownRuleNodeShape = new NodeShapeElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("wodeledu.dsls.ModelGraph".equals(grammar.getName())) {
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

	
	//MutatorGraph:
	//	{MutatorGraph} "metamodel" metamodel=EString name=[ecore::EClass] ":" type=GraphType "{" nodes+=Node* edges+=Edge*
	//	"}";
	public MutatorGraphElements getMutatorGraphAccess() {
		return pMutatorGraph;
	}
	
	public ParserRule getMutatorGraphRule() {
		return getMutatorGraphAccess().getRule();
	}

	//EString returns ecore::EString:
	//	STRING | ID;
	public EStringElements getEStringAccess() {
		return pEString;
	}
	
	public ParserRule getEStringRule() {
		return getEStringAccess().getRule();
	}

	//enum GraphType:
	//	diagram;
	public GraphTypeElements getGraphTypeAccess() {
		return unknownRuleGraphType;
	}
	
	public EnumRule getGraphTypeRule() {
		return getGraphTypeAccess().getRule();
	}

	//Node:
	//	{Node} name=[ecore::EClass] "(" (negation?="not" | "yes")? attribute=[ecore::EAttribute] ")" ":" type=NodeType (","
	//	"shape" "=" shape=NodeShape)?;
	public NodeElements getNodeAccess() {
		return pNode;
	}
	
	public ParserRule getNodeRule() {
		return getNodeAccess().getRule();
	}

	//Edge:
	//	{Edge} name=[ecore::EClass] "(" source=[ecore::EReference] "," target=[ecore::EReference] ")" ":" "edge" "," "label"
	//	"=" label=[ecore::EReference];
	public EdgeElements getEdgeAccess() {
		return pEdge;
	}
	
	public ParserRule getEdgeRule() {
		return getEdgeAccess().getRule();
	}

	//enum NodeType:
	//	node | markednode;
	public NodeTypeElements getNodeTypeAccess() {
		return unknownRuleNodeType;
	}
	
	public EnumRule getNodeTypeRule() {
		return getNodeTypeAccess().getRule();
	}

	//enum NodeShape:
	//	circle | doublecircle;
	public NodeShapeElements getNodeShapeAccess() {
		return unknownRuleNodeShape;
	}
	
	public EnumRule getNodeShapeRule() {
		return getNodeShapeAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" . / * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\""))* "\"" | "\'" ("\\" .
	//	/ * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
