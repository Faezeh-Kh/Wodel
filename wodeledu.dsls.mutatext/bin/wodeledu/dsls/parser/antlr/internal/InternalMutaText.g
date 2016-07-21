/*
 * generated by Xtext
 */
grammar InternalMutaText;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package wodeledu.dsls.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package wodeledu.dsls.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import wodeledu.dsls.services.MutaTextGrammarAccess;

}

@parser::members {

 	private MutaTextGrammarAccess grammarAccess;
 	
    public InternalMutaTextParser(TokenStream input, MutaTextGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Configuration";	
   	}
   	
   	@Override
   	protected MutaTextGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleConfiguration
entryRuleConfiguration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getConfigurationRule()); }
	 iv_ruleConfiguration=ruleConfiguration 
	 { $current=$iv_ruleConfiguration.current; } 
	 EOF 
;

// Rule Configuration
ruleConfiguration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getConfigurationAccess().getConfigurationAction_0(),
            $current);
    }
)	otherlv_1='metamodel' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getConfigurationAccess().getMetamodelKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getConfigurationAccess().getMetamodelEStringParserRuleCall_2_0()); 
	    }
		lv_metamodel_2_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConfigurationRule());
	        }
       		set(
       			$current, 
       			"metamodel",
        		lv_metamodel_2_0, 
        		"EString");
	        afterParserOrEnumRuleCall();
	    }

)
)((
(
		{ 
	        newCompositeNode(grammarAccess.getConfigurationAccess().getOptionsOptionParserRuleCall_3_0_0()); 
	    }
		lv_options_3_0=ruleOption		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConfigurationRule());
	        }
       		add(
       			$current, 
       			"options",
        		lv_options_3_0, 
        		"Option");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getConfigurationAccess().getOptionsOptionParserRuleCall_3_1_0()); 
	    }
		lv_options_4_0=ruleOption		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConfigurationRule());
	        }
       		add(
       			$current, 
       			"options",
        		lv_options_4_0, 
        		"Option");
	        afterParserOrEnumRuleCall();
	    }

)
)*)?)
;





// Entry rule entryRuleOption
entryRuleOption returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getOptionRule()); }
	 iv_ruleOption=ruleOption 
	 { $current=$iv_ruleOption.current; } 
	 EOF 
;

// Rule Option
ruleOption returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getOptionAccess().getOptionAction_0(),
            $current);
    }
)	otherlv_1='>' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getOptionAccess().getGreaterThanSignKeyword_1());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getOptionRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getOptionAccess().getTypeEClassCrossReference_2_0()); 
	    }
		ruleEString		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3='(' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getOptionAccess().getLeftParenthesisKeyword_3_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getOptionRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getOptionAccess().getObjectEObjectCrossReference_3_1_0()); 
	    }
		ruleEString		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_5=')' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getOptionAccess().getRightParenthesisKeyword_3_2());
    }
)?	otherlv_6=':' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getOptionAccess().getColonKeyword_4());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getOptionAccess().getValidTextParserRuleCall_5_0()); 
	    }
		lv_valid_7_0=ruleText		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOptionRule());
	        }
       		set(
       			$current, 
       			"valid",
        		lv_valid_7_0, 
        		"Text");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_8='/' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getOptionAccess().getSolidusKeyword_6());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getOptionAccess().getInvalidTextParserRuleCall_7_0()); 
	    }
		lv_invalid_9_0=ruleText		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getOptionRule());
	        }
       		set(
       			$current, 
       			"invalid",
        		lv_invalid_9_0, 
        		"Text");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleText
entryRuleText returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTextRule()); }
	 iv_ruleText=ruleText 
	 { $current=$iv_ruleText.current; } 
	 EOF 
;

// Rule Text
ruleText returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getTextAccess().getTextAction_0(),
            $current);
    }
)((
(
		{ 
	        newCompositeNode(grammarAccess.getTextAccess().getWordsWordParserRuleCall_1_0_0()); 
	    }
		lv_words_1_0=ruleWord		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTextRule());
	        }
       		add(
       			$current, 
       			"words",
        		lv_words_1_0, 
        		"Word");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getTextAccess().getWordsWordParserRuleCall_1_1_0()); 
	    }
		lv_words_2_0=ruleWord		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTextRule());
	        }
       		add(
       			$current, 
       			"words",
        		lv_words_2_0, 
        		"Word");
	        afterParserOrEnumRuleCall();
	    }

)
)*)?)
;





// Entry rule entryRuleWord
entryRuleWord returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getWordRule()); }
	 iv_ruleWord=ruleWord 
	 { $current=$iv_ruleWord.current; } 
	 EOF 
;

// Rule Word
ruleWord returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getWordAccess().getConstantParserRuleCall_0()); 
    }
    this_Constant_0=ruleConstant
    { 
        $current = $this_Constant_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getWordAccess().getVariableParserRuleCall_1()); 
    }
    this_Variable_1=ruleVariable
    { 
        $current = $this_Variable_1.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleConstant
entryRuleConstant returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getConstantRule()); }
	 iv_ruleConstant=ruleConstant 
	 { $current=$iv_ruleConstant.current; } 
	 EOF 
;

// Rule Constant
ruleConstant returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getConstantAccess().getConstantAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getConstantAccess().getValueEStringParserRuleCall_1_0()); 
	    }
		lv_value_1_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConstantRule());
	        }
       		set(
       			$current, 
       			"value",
        		lv_value_1_0, 
        		"EString");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleVariable
entryRuleVariable returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVariableRule()); }
	 iv_ruleVariable=ruleVariable 
	 { $current=$iv_ruleVariable.current; } 
	 EOF 
;

// Rule Variable
ruleVariable returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getVariableAccess().getVariableAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getVariableAccess().getTypeVariableTypeEnumRuleCall_1_0()); 
	    }
		lv_type_1_0=ruleVariableType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVariableRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_1_0, 
        		"VariableType");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleEString
entryRuleEString returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getEStringRule()); } 
	 iv_ruleEString=ruleEString 
	 { $current=$iv_ruleEString.current.getText(); }  
	 EOF 
;

// Rule EString
ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_STRING_0=RULE_STRING    {
		$current.merge(this_STRING_0);
    }

    { 
    newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
    }

    |    this_ID_1=RULE_ID    {
		$current.merge(this_ID_1);
    }

    { 
    newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
    }
)
    ;





// Rule VariableType
ruleVariableType returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='%object' 
	{
        $current = grammarAccess.getVariableTypeAccess().getObjectEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getVariableTypeAccess().getObjectEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='%attName' 
	{
        $current = grammarAccess.getVariableTypeAccess().getAttNameEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getVariableTypeAccess().getAttNameEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='%oldValue' 
	{
        $current = grammarAccess.getVariableTypeAccess().getOldValueEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getVariableTypeAccess().getOldValueEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='%newValue' 
	{
        $current = grammarAccess.getVariableTypeAccess().getNewValueEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getVariableTypeAccess().getNewValueEnumLiteralDeclaration_3()); 
    }
)
    |(	enumLiteral_4='%refName' 
	{
        $current = grammarAccess.getVariableTypeAccess().getRefNameEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getVariableTypeAccess().getRefNameEnumLiteralDeclaration_4()); 
    }
)
    |(	enumLiteral_5='%fromObject' 
	{
        $current = grammarAccess.getVariableTypeAccess().getFromObjectEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_5, grammarAccess.getVariableTypeAccess().getFromObjectEnumLiteralDeclaration_5()); 
    }
)
    |(	enumLiteral_6='%oldFromObject' 
	{
        $current = grammarAccess.getVariableTypeAccess().getOldFromObjectEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_6, grammarAccess.getVariableTypeAccess().getOldFromObjectEnumLiteralDeclaration_6()); 
    }
)
    |(	enumLiteral_7='%srcRefName' 
	{
        $current = grammarAccess.getVariableTypeAccess().getSrcRefNameEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_7, grammarAccess.getVariableTypeAccess().getSrcRefNameEnumLiteralDeclaration_7()); 
    }
)
    |(	enumLiteral_8='%toObject' 
	{
        $current = grammarAccess.getVariableTypeAccess().getToObjectEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_8, grammarAccess.getVariableTypeAccess().getToObjectEnumLiteralDeclaration_8()); 
    }
)
    |(	enumLiteral_9='%oldToObject' 
	{
        $current = grammarAccess.getVariableTypeAccess().getOldToObjectEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_9, grammarAccess.getVariableTypeAccess().getOldToObjectEnumLiteralDeclaration_9()); 
    }
)
    |(	enumLiteral_10='%firstRefName' 
	{
        $current = grammarAccess.getVariableTypeAccess().getFirstRefNameEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_10, grammarAccess.getVariableTypeAccess().getFirstRefNameEnumLiteralDeclaration_10()); 
    }
)
    |(	enumLiteral_11='%firstObject' 
	{
        $current = grammarAccess.getVariableTypeAccess().getFirstObjectEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_11, grammarAccess.getVariableTypeAccess().getFirstObjectEnumLiteralDeclaration_11()); 
    }
)
    |(	enumLiteral_12='%firstFromObject' 
	{
        $current = grammarAccess.getVariableTypeAccess().getFirstFromObjectEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_12, grammarAccess.getVariableTypeAccess().getFirstFromObjectEnumLiteralDeclaration_12()); 
    }
)
    |(	enumLiteral_13='%firstToObject' 
	{
        $current = grammarAccess.getVariableTypeAccess().getFirstToObjectEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_13, grammarAccess.getVariableTypeAccess().getFirstToObjectEnumLiteralDeclaration_13()); 
    }
)
    |(	enumLiteral_14='%secondRefName' 
	{
        $current = grammarAccess.getVariableTypeAccess().getSecondRefNameEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_14, grammarAccess.getVariableTypeAccess().getSecondRefNameEnumLiteralDeclaration_14()); 
    }
)
    |(	enumLiteral_15='%secondObject' 
	{
        $current = grammarAccess.getVariableTypeAccess().getSecondObjectEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_15, grammarAccess.getVariableTypeAccess().getSecondObjectEnumLiteralDeclaration_15()); 
    }
)
    |(	enumLiteral_16='%secondFromObject' 
	{
        $current = grammarAccess.getVariableTypeAccess().getSecondFromObjectEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_16, grammarAccess.getVariableTypeAccess().getSecondFromObjectEnumLiteralDeclaration_16()); 
    }
)
    |(	enumLiteral_17='%secondToObject' 
	{
        $current = grammarAccess.getVariableTypeAccess().getSecondToObjectEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_17, grammarAccess.getVariableTypeAccess().getSecondToObjectEnumLiteralDeclaration_17()); 
    }
)
    |(	enumLiteral_18='%firstAttName' 
	{
        $current = grammarAccess.getVariableTypeAccess().getFirstAttNameEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_18, grammarAccess.getVariableTypeAccess().getFirstAttNameEnumLiteralDeclaration_18()); 
    }
)
    |(	enumLiteral_19='%firstValue' 
	{
        $current = grammarAccess.getVariableTypeAccess().getFirstValueEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_19, grammarAccess.getVariableTypeAccess().getFirstValueEnumLiteralDeclaration_19()); 
    }
)
    |(	enumLiteral_20='%secondAttName' 
	{
        $current = grammarAccess.getVariableTypeAccess().getSecondAttNameEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_20, grammarAccess.getVariableTypeAccess().getSecondAttNameEnumLiteralDeclaration_20()); 
    }
)
    |(	enumLiteral_21='%secondValue' 
	{
        $current = grammarAccess.getVariableTypeAccess().getSecondValueEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_21, grammarAccess.getVariableTypeAccess().getSecondValueEnumLiteralDeclaration_21()); 
    }
));



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


