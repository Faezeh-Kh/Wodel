/*
 * generated by Xtext
 */
grammar InternalModelText;

options {
	superClass=AbstractInternalContentAssistParser;
	
}

@lexer::header {
package wodeledu.dsls.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package wodeledu.dsls.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import wodeledu.dsls.services.ModelTextGrammarAccess;

}

@parser::members {
 
 	private ModelTextGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(ModelTextGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }
    
    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuleIdentifyElements
entryRuleIdentifyElements 
:
{ before(grammarAccess.getIdentifyElementsRule()); }
	 ruleIdentifyElements
{ after(grammarAccess.getIdentifyElementsRule()); } 
	 EOF 
;

// Rule IdentifyElements
ruleIdentifyElements
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getIdentifyElementsAccess().getGroup()); }
(rule__IdentifyElements__Group__0)
{ after(grammarAccess.getIdentifyElementsAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleElement
entryRuleElement 
:
{ before(grammarAccess.getElementRule()); }
	 ruleElement
{ after(grammarAccess.getElementRule()); } 
	 EOF 
;

// Rule Element
ruleElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getElementAccess().getGroup()); }
(rule__Element__Group__0)
{ after(grammarAccess.getElementAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAttribute
entryRuleAttribute 
:
{ before(grammarAccess.getAttributeRule()); }
	 ruleAttribute
{ after(grammarAccess.getAttributeRule()); } 
	 EOF 
;

// Rule Attribute
ruleAttribute
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAttributeAccess().getGroup()); }
(rule__Attribute__Group__0)
{ after(grammarAccess.getAttributeAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleWord
entryRuleWord 
:
{ before(grammarAccess.getWordRule()); }
	 ruleWord
{ after(grammarAccess.getWordRule()); } 
	 EOF 
;

// Rule Word
ruleWord
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getWordAccess().getAlternatives()); }
(rule__Word__Alternatives)
{ after(grammarAccess.getWordAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleConstant
entryRuleConstant 
:
{ before(grammarAccess.getConstantRule()); }
	 ruleConstant
{ after(grammarAccess.getConstantRule()); } 
	 EOF 
;

// Rule Constant
ruleConstant
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getConstantAccess().getGroup()); }
(rule__Constant__Group__0)
{ after(grammarAccess.getConstantAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleVariable
entryRuleVariable 
:
{ before(grammarAccess.getVariableRule()); }
	 ruleVariable
{ after(grammarAccess.getVariableRule()); } 
	 EOF 
;

// Rule Variable
ruleVariable
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getVariableAccess().getGroup()); }
(rule__Variable__Group__0)
{ after(grammarAccess.getVariableAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEString
entryRuleEString 
:
{ before(grammarAccess.getEStringRule()); }
	 ruleEString
{ after(grammarAccess.getEStringRule()); } 
	 EOF 
;

// Rule EString
ruleEString
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEStringAccess().getAlternatives()); }
(rule__EString__Alternatives)
{ after(grammarAccess.getEStringAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__Attribute__Alternatives_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeAccess().getNegationAssignment_1_0()); }
(rule__Attribute__NegationAssignment_1_0)
{ after(grammarAccess.getAttributeAccess().getNegationAssignment_1_0()); }
)

    |(
{ before(grammarAccess.getAttributeAccess().getNotKeyword_1_1()); }

	'not' 

{ after(grammarAccess.getAttributeAccess().getNotKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Word__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getWordAccess().getConstantParserRuleCall_0()); }
	ruleConstant
{ after(grammarAccess.getWordAccess().getConstantParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getWordAccess().getVariableParserRuleCall_1()); }
	ruleVariable
{ after(grammarAccess.getWordAccess().getVariableParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__EString__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); }
	RULE_STRING
{ after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); }
)

    |(
{ before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); }
	RULE_ID
{ after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__IdentifyElements__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IdentifyElements__Group__0__Impl
	rule__IdentifyElements__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IdentifyElements__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIdentifyElementsAccess().getIdentifyElementsAction_0()); }
(

)
{ after(grammarAccess.getIdentifyElementsAccess().getIdentifyElementsAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IdentifyElements__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IdentifyElements__Group__1__Impl
	rule__IdentifyElements__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__IdentifyElements__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIdentifyElementsAccess().getMetamodelKeyword_1()); }

	'metamodel' 

{ after(grammarAccess.getIdentifyElementsAccess().getMetamodelKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IdentifyElements__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IdentifyElements__Group__2__Impl
	rule__IdentifyElements__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__IdentifyElements__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIdentifyElementsAccess().getMetamodelAssignment_2()); }
(rule__IdentifyElements__MetamodelAssignment_2)
{ after(grammarAccess.getIdentifyElementsAccess().getMetamodelAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IdentifyElements__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IdentifyElements__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IdentifyElements__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIdentifyElementsAccess().getGroup_3()); }
(rule__IdentifyElements__Group_3__0)?
{ after(grammarAccess.getIdentifyElementsAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__IdentifyElements__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IdentifyElements__Group_3__0__Impl
	rule__IdentifyElements__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IdentifyElements__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIdentifyElementsAccess().getElementsAssignment_3_0()); }
(rule__IdentifyElements__ElementsAssignment_3_0)
{ after(grammarAccess.getIdentifyElementsAccess().getElementsAssignment_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IdentifyElements__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IdentifyElements__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IdentifyElements__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIdentifyElementsAccess().getElementsAssignment_3_1()); }
(rule__IdentifyElements__ElementsAssignment_3_1)*
{ after(grammarAccess.getIdentifyElementsAccess().getElementsAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Element__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Element__Group__0__Impl
	rule__Element__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Element__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getElementAction_0()); }
(

)
{ after(grammarAccess.getElementAccess().getElementAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Element__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Element__Group__1__Impl
	rule__Element__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Element__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getGreaterThanSignKeyword_1()); }

	'>' 

{ after(grammarAccess.getElementAccess().getGreaterThanSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Element__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Element__Group__2__Impl
	rule__Element__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Element__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getTypeAssignment_2()); }
(rule__Element__TypeAssignment_2)
{ after(grammarAccess.getElementAccess().getTypeAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Element__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Element__Group__3__Impl
	rule__Element__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Element__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getGroup_3()); }
(rule__Element__Group_3__0)?
{ after(grammarAccess.getElementAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Element__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Element__Group__4__Impl
	rule__Element__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Element__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getGroup_4()); }
(rule__Element__Group_4__0)?
{ after(grammarAccess.getElementAccess().getGroup_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Element__Group__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Element__Group__5__Impl
	rule__Element__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Element__Group__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getColonKeyword_5()); }

	':' 

{ after(grammarAccess.getElementAccess().getColonKeyword_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Element__Group__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Element__Group__6__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Element__Group__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getGroup_6()); }
(rule__Element__Group_6__0)?
{ after(grammarAccess.getElementAccess().getGroup_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}
















rule__Element__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Element__Group_3__0__Impl
	rule__Element__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Element__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getFullStopKeyword_3_0()); }

	'.' 

{ after(grammarAccess.getElementAccess().getFullStopKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Element__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Element__Group_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Element__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getRefAssignment_3_1()); }
(rule__Element__RefAssignment_3_1)
{ after(grammarAccess.getElementAccess().getRefAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Element__Group_4__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Element__Group_4__0__Impl
	rule__Element__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Element__Group_4__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getLeftParenthesisKeyword_4_0()); }

	'(' 

{ after(grammarAccess.getElementAccess().getLeftParenthesisKeyword_4_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Element__Group_4__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Element__Group_4__1__Impl
	rule__Element__Group_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Element__Group_4__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getAttAssignment_4_1()); }
(rule__Element__AttAssignment_4_1)
{ after(grammarAccess.getElementAccess().getAttAssignment_4_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Element__Group_4__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Element__Group_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Element__Group_4__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getRightParenthesisKeyword_4_2()); }

	')' 

{ after(grammarAccess.getElementAccess().getRightParenthesisKeyword_4_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Element__Group_6__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Element__Group_6__0__Impl
	rule__Element__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Element__Group_6__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getWordsAssignment_6_0()); }
(rule__Element__WordsAssignment_6_0)
{ after(grammarAccess.getElementAccess().getWordsAssignment_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Element__Group_6__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Element__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Element__Group_6__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getWordsAssignment_6_1()); }
(rule__Element__WordsAssignment_6_1)*
{ after(grammarAccess.getElementAccess().getWordsAssignment_6_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Attribute__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Attribute__Group__0__Impl
	rule__Attribute__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeAccess().getAttributeAction_0()); }
(

)
{ after(grammarAccess.getAttributeAccess().getAttributeAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Attribute__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Attribute__Group__1__Impl
	rule__Attribute__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeAccess().getAlternatives_1()); }
(rule__Attribute__Alternatives_1)?
{ after(grammarAccess.getAttributeAccess().getAlternatives_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Attribute__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Attribute__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeAccess().getAttAssignment_2()); }
(rule__Attribute__AttAssignment_2)
{ after(grammarAccess.getAttributeAccess().getAttAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Constant__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Constant__Group__0__Impl
	rule__Constant__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Constant__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConstantAccess().getConstantAction_0()); }
(

)
{ after(grammarAccess.getConstantAccess().getConstantAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Constant__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Constant__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Constant__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConstantAccess().getValueAssignment_1()); }
(rule__Constant__ValueAssignment_1)
{ after(grammarAccess.getConstantAccess().getValueAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Variable__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Variable__Group__0__Impl
	rule__Variable__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Variable__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVariableAccess().getVariableAction_0()); }
(

)
{ after(grammarAccess.getVariableAccess().getVariableAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Variable__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Variable__Group__1__Impl
	rule__Variable__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Variable__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVariableAccess().getPercentSignKeyword_1()); }

	'%' 

{ after(grammarAccess.getVariableAccess().getPercentSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Variable__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Variable__Group__2__Impl
	rule__Variable__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Variable__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVariableAccess().getGroup_2()); }
(rule__Variable__Group_2__0)?
{ after(grammarAccess.getVariableAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Variable__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Variable__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Variable__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVariableAccess().getIdAssignment_3()); }
(rule__Variable__IdAssignment_3)
{ after(grammarAccess.getVariableAccess().getIdAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__Variable__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Variable__Group_2__0__Impl
	rule__Variable__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Variable__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVariableAccess().getRefAssignment_2_0()); }
(rule__Variable__RefAssignment_2_0)
{ after(grammarAccess.getVariableAccess().getRefAssignment_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Variable__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Variable__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Variable__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVariableAccess().getFullStopKeyword_2_1()); }

	'.' 

{ after(grammarAccess.getVariableAccess().getFullStopKeyword_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}







rule__IdentifyElements__MetamodelAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIdentifyElementsAccess().getMetamodelEStringParserRuleCall_2_0()); }
	ruleEString{ after(grammarAccess.getIdentifyElementsAccess().getMetamodelEStringParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IdentifyElements__ElementsAssignment_3_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIdentifyElementsAccess().getElementsElementParserRuleCall_3_0_0()); }
	ruleElement{ after(grammarAccess.getIdentifyElementsAccess().getElementsElementParserRuleCall_3_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IdentifyElements__ElementsAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIdentifyElementsAccess().getElementsElementParserRuleCall_3_1_0()); }
	ruleElement{ after(grammarAccess.getIdentifyElementsAccess().getElementsElementParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Element__TypeAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getTypeEClassCrossReference_2_0()); }
(
{ before(grammarAccess.getElementAccess().getTypeEClassEStringParserRuleCall_2_0_1()); }
	ruleEString{ after(grammarAccess.getElementAccess().getTypeEClassEStringParserRuleCall_2_0_1()); }
)
{ after(grammarAccess.getElementAccess().getTypeEClassCrossReference_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Element__RefAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getRefEReferenceCrossReference_3_1_0()); }
(
{ before(grammarAccess.getElementAccess().getRefEReferenceIDTerminalRuleCall_3_1_0_1()); }
	RULE_ID{ after(grammarAccess.getElementAccess().getRefEReferenceIDTerminalRuleCall_3_1_0_1()); }
)
{ after(grammarAccess.getElementAccess().getRefEReferenceCrossReference_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Element__AttAssignment_4_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getAttAttributeParserRuleCall_4_1_0()); }
	ruleAttribute{ after(grammarAccess.getElementAccess().getAttAttributeParserRuleCall_4_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Element__WordsAssignment_6_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getWordsWordParserRuleCall_6_0_0()); }
	ruleWord{ after(grammarAccess.getElementAccess().getWordsWordParserRuleCall_6_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Element__WordsAssignment_6_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getElementAccess().getWordsWordParserRuleCall_6_1_0()); }
	ruleWord{ after(grammarAccess.getElementAccess().getWordsWordParserRuleCall_6_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__NegationAssignment_1_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeAccess().getNegationYesKeyword_1_0_0()); }
(
{ before(grammarAccess.getAttributeAccess().getNegationYesKeyword_1_0_0()); }

	'yes' 

{ after(grammarAccess.getAttributeAccess().getNegationYesKeyword_1_0_0()); }
)

{ after(grammarAccess.getAttributeAccess().getNegationYesKeyword_1_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__AttAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeAccess().getAttEAttributeCrossReference_2_0()); }
(
{ before(grammarAccess.getAttributeAccess().getAttEAttributeIDTerminalRuleCall_2_0_1()); }
	RULE_ID{ after(grammarAccess.getAttributeAccess().getAttEAttributeIDTerminalRuleCall_2_0_1()); }
)
{ after(grammarAccess.getAttributeAccess().getAttEAttributeCrossReference_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Constant__ValueAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConstantAccess().getValueEStringParserRuleCall_1_0()); }
	ruleEString{ after(grammarAccess.getConstantAccess().getValueEStringParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Variable__RefAssignment_2_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVariableAccess().getRefEReferenceCrossReference_2_0_0()); }
(
{ before(grammarAccess.getVariableAccess().getRefEReferenceIDTerminalRuleCall_2_0_0_1()); }
	RULE_ID{ after(grammarAccess.getVariableAccess().getRefEReferenceIDTerminalRuleCall_2_0_0_1()); }
)
{ after(grammarAccess.getVariableAccess().getRefEReferenceCrossReference_2_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Variable__IdAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getVariableAccess().getIdEAttributeCrossReference_3_0()); }
(
{ before(grammarAccess.getVariableAccess().getIdEAttributeIDTerminalRuleCall_3_0_1()); }
	RULE_ID{ after(grammarAccess.getVariableAccess().getIdEAttributeIDTerminalRuleCall_3_0_1()); }
)
{ after(grammarAccess.getVariableAccess().getIdEAttributeCrossReference_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


