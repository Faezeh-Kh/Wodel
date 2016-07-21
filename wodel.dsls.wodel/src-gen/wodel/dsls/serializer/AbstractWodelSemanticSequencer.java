/*
 * generated by Xtext
 */
package wodel.dsls.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import mutatorenvironment.AttributeCopy;
import mutatorenvironment.AttributeEvaluation;
import mutatorenvironment.AttributeInit;
import mutatorenvironment.AttributeReverse;
import mutatorenvironment.AttributeSwap;
import mutatorenvironment.AttributeUnset;
import mutatorenvironment.BinaryOperator;
import mutatorenvironment.Block;
import mutatorenvironment.CatEndStringType;
import mutatorenvironment.CatStartStringType;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.CompositeMutator;
import mutatorenvironment.Constraint;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.CreateReferenceMutator;
import mutatorenvironment.Expression;
import mutatorenvironment.Library;
import mutatorenvironment.ListStringType;
import mutatorenvironment.Load;
import mutatorenvironment.LowerStringType;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.ModifySourceReferenceMutator;
import mutatorenvironment.ModifyTargetReferenceMutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.OtherTypeSelection;
import mutatorenvironment.Program;
import mutatorenvironment.RandomBooleanType;
import mutatorenvironment.RandomDoubleType;
import mutatorenvironment.RandomIntegerType;
import mutatorenvironment.RandomStringType;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.ReferenceEvaluation;
import mutatorenvironment.ReferenceInit;
import mutatorenvironment.ReferenceSwap;
import mutatorenvironment.RemoveCompleteReferenceMutator;
import mutatorenvironment.RemoveObjectMutator;
import mutatorenvironment.RemoveRandomReferenceMutator;
import mutatorenvironment.RemoveSpecificReferenceMutator;
import mutatorenvironment.ReplaceStringType;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.Source;
import mutatorenvironment.SpecificBooleanType;
import mutatorenvironment.SpecificDoubleType;
import mutatorenvironment.SpecificIntegerType;
import mutatorenvironment.SpecificObjectSelection;
import mutatorenvironment.SpecificStringType;
import mutatorenvironment.UpperStringType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import wodel.dsls.services.WodelGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractWodelSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private WodelGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == MutatorenvironmentPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case MutatorenvironmentPackage.ATTRIBUTE_COPY:
				sequence_AttributeCopy(context, (AttributeCopy) semanticObject); 
				return; 
			case MutatorenvironmentPackage.ATTRIBUTE_EVALUATION:
				sequence_AttributeEvaluation(context, (AttributeEvaluation) semanticObject); 
				return; 
			case MutatorenvironmentPackage.ATTRIBUTE_INIT:
				sequence_AttributeInit(context, (AttributeInit) semanticObject); 
				return; 
			case MutatorenvironmentPackage.ATTRIBUTE_REVERSE:
				sequence_AttributeReverse(context, (AttributeReverse) semanticObject); 
				return; 
			case MutatorenvironmentPackage.ATTRIBUTE_SWAP:
				sequence_AttributeSwap(context, (AttributeSwap) semanticObject); 
				return; 
			case MutatorenvironmentPackage.ATTRIBUTE_UNSET:
				sequence_AttributeUnset(context, (AttributeUnset) semanticObject); 
				return; 
			case MutatorenvironmentPackage.BINARY_OPERATOR:
				sequence_BinaryOperator(context, (BinaryOperator) semanticObject); 
				return; 
			case MutatorenvironmentPackage.BLOCK:
				sequence_Block(context, (Block) semanticObject); 
				return; 
			case MutatorenvironmentPackage.CAT_END_STRING_TYPE:
				sequence_CatEndStringType(context, (CatEndStringType) semanticObject); 
				return; 
			case MutatorenvironmentPackage.CAT_START_STRING_TYPE:
				sequence_CatStartStringType(context, (CatStartStringType) semanticObject); 
				return; 
			case MutatorenvironmentPackage.COMPLETE_TYPE_SELECTION:
				sequence_CompleteTypeSelection(context, (CompleteTypeSelection) semanticObject); 
				return; 
			case MutatorenvironmentPackage.COMPOSITE_MUTATOR:
				sequence_CompositeMutator(context, (CompositeMutator) semanticObject); 
				return; 
			case MutatorenvironmentPackage.CONSTRAINT:
				sequence_Constraint(context, (Constraint) semanticObject); 
				return; 
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR:
				sequence_CreateObjectMutator(context, (CreateObjectMutator) semanticObject); 
				return; 
			case MutatorenvironmentPackage.CREATE_REFERENCE_MUTATOR:
				sequence_CreateReferenceMutator(context, (CreateReferenceMutator) semanticObject); 
				return; 
			case MutatorenvironmentPackage.EXPRESSION:
				sequence_Expression(context, (Expression) semanticObject); 
				return; 
			case MutatorenvironmentPackage.LIBRARY:
				sequence_Library(context, (Library) semanticObject); 
				return; 
			case MutatorenvironmentPackage.LIST_STRING_TYPE:
				sequence_ListStringType(context, (ListStringType) semanticObject); 
				return; 
			case MutatorenvironmentPackage.LOAD:
				sequence_Load(context, (Load) semanticObject); 
				return; 
			case MutatorenvironmentPackage.LOWER_STRING_TYPE:
				sequence_LowerStringType(context, (LowerStringType) semanticObject); 
				return; 
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR:
				sequence_ModifyInformationMutator(context, (ModifyInformationMutator) semanticObject); 
				return; 
			case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR:
				sequence_ModifySourceReferenceMutator(context, (ModifySourceReferenceMutator) semanticObject); 
				return; 
			case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR:
				sequence_ModifyTargetReferenceMutator(context, (ModifyTargetReferenceMutator) semanticObject); 
				return; 
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT:
				sequence_MutatorEnvironment(context, (MutatorEnvironment) semanticObject); 
				return; 
			case MutatorenvironmentPackage.OTHER_TYPE_SELECTION:
				sequence_OtherTypeSelection(context, (OtherTypeSelection) semanticObject); 
				return; 
			case MutatorenvironmentPackage.PROGRAM:
				sequence_Program(context, (Program) semanticObject); 
				return; 
			case MutatorenvironmentPackage.RANDOM_BOOLEAN_TYPE:
				sequence_RandomBooleanType(context, (RandomBooleanType) semanticObject); 
				return; 
			case MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE:
				sequence_RandomDoubleType(context, (RandomDoubleType) semanticObject); 
				return; 
			case MutatorenvironmentPackage.RANDOM_INTEGER_TYPE:
				sequence_RandomIntegerType(context, (RandomIntegerType) semanticObject); 
				return; 
			case MutatorenvironmentPackage.RANDOM_STRING_TYPE:
				sequence_RandomStringType(context, (RandomStringType) semanticObject); 
				return; 
			case MutatorenvironmentPackage.RANDOM_TYPE_SELECTION:
				sequence_RandomTypeSelection(context, (RandomTypeSelection) semanticObject); 
				return; 
			case MutatorenvironmentPackage.REFERENCE_EVALUATION:
				sequence_ReferenceEvaluation(context, (ReferenceEvaluation) semanticObject); 
				return; 
			case MutatorenvironmentPackage.REFERENCE_INIT:
				sequence_ReferenceInit(context, (ReferenceInit) semanticObject); 
				return; 
			case MutatorenvironmentPackage.REFERENCE_SWAP:
				sequence_ReferenceSwap(context, (ReferenceSwap) semanticObject); 
				return; 
			case MutatorenvironmentPackage.REMOVE_COMPLETE_REFERENCE_MUTATOR:
				sequence_RemoveCompleteReferenceMutator(context, (RemoveCompleteReferenceMutator) semanticObject); 
				return; 
			case MutatorenvironmentPackage.REMOVE_OBJECT_MUTATOR:
				sequence_RemoveObjectMutator(context, (RemoveObjectMutator) semanticObject); 
				return; 
			case MutatorenvironmentPackage.REMOVE_RANDOM_REFERENCE_MUTATOR:
				sequence_RemoveRandomReferenceMutator(context, (RemoveRandomReferenceMutator) semanticObject); 
				return; 
			case MutatorenvironmentPackage.REMOVE_SPECIFIC_REFERENCE_MUTATOR:
				sequence_RemoveSpecificReferenceMutator(context, (RemoveSpecificReferenceMutator) semanticObject); 
				return; 
			case MutatorenvironmentPackage.REPLACE_STRING_TYPE:
				sequence_ReplaceStringType(context, (ReplaceStringType) semanticObject); 
				return; 
			case MutatorenvironmentPackage.SELECT_OBJECT_MUTATOR:
				sequence_SelectObjectMutator(context, (SelectObjectMutator) semanticObject); 
				return; 
			case MutatorenvironmentPackage.SOURCE:
				sequence_Source(context, (Source) semanticObject); 
				return; 
			case MutatorenvironmentPackage.SPECIFIC_BOOLEAN_TYPE:
				sequence_SpecificBooleanType(context, (SpecificBooleanType) semanticObject); 
				return; 
			case MutatorenvironmentPackage.SPECIFIC_DOUBLE_TYPE:
				sequence_SpecificDoubleType(context, (SpecificDoubleType) semanticObject); 
				return; 
			case MutatorenvironmentPackage.SPECIFIC_INTEGER_TYPE:
				sequence_SpecificIntegerType(context, (SpecificIntegerType) semanticObject); 
				return; 
			case MutatorenvironmentPackage.SPECIFIC_OBJECT_SELECTION:
				sequence_SpecificObjectSelection(context, (SpecificObjectSelection) semanticObject); 
				return; 
			case MutatorenvironmentPackage.SPECIFIC_STRING_TYPE:
				sequence_SpecificStringType(context, (SpecificStringType) semanticObject); 
				return; 
			case MutatorenvironmentPackage.UPPER_STRING_TYPE:
				sequence_UpperStringType(context, (UpperStringType) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (attribute+=[EAttribute|ID] object=ObSelectionStrategy? attribute+=[EAttribute|ID])
	 */
	protected void sequence_AttributeCopy(EObject context, AttributeCopy semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=[EAttribute|ID] operator=Operator value=AttributeType)
	 */
	protected void sequence_AttributeEvaluation(EObject context, AttributeEvaluation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.ATTRIBUTE_EVALUATION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.ATTRIBUTE_EVALUATION__NAME));
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.ATTRIBUTE_EVALUATION__OPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.ATTRIBUTE_EVALUATION__OPERATOR));
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.ATTRIBUTE_EVALUATION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.ATTRIBUTE_EVALUATION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAttributeEvaluationAccess().getNameEAttributeIDTerminalRuleCall_1_0_1(), semanticObject.getName());
		feeder.accept(grammarAccess.getAttributeEvaluationAccess().getOperatorOperatorEnumRuleCall_2_0(), semanticObject.getOperator());
		feeder.accept(grammarAccess.getAttributeEvaluationAccess().getValueAttributeTypeParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (attribute+=[EAttribute|ID] value=AttributeType)
	 */
	protected void sequence_AttributeInit(EObject context, AttributeInit semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     attribute+=[EAttribute|ID]
	 */
	protected void sequence_AttributeReverse(EObject context, AttributeReverse semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (attribute+=[EAttribute|ID] object=ObSelectionStrategy? attribute+=[EAttribute|ID])
	 */
	protected void sequence_AttributeSwap(EObject context, AttributeSwap semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     attribute+=[EAttribute|ID]
	 */
	protected void sequence_AttributeUnset(EObject context, AttributeUnset semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     type=LogicOperator
	 */
	protected void sequence_BinaryOperator(EObject context, BinaryOperator semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.BINARY_OPERATOR__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.BINARY_OPERATOR__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBinaryOperatorAccess().getTypeLogicOperatorEnumRuleCall_1_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (from+=[Block|ID] from+=[Block|ID]*)? 
	 *         repeat=Repeat? 
	 *         commands+=Mutator 
	 *         commands+=Mutator* 
	 *         ((min=EInt max=MaxCardinality) | fixed=EInt)?
	 *     )
	 */
	protected void sequence_Block(EObject context, Block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=EString
	 */
	protected void sequence_CatEndStringType(EObject context, CatEndStringType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.CAT_END_STRING_TYPE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.CAT_END_STRING_TYPE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCatEndStringTypeAccess().getValueEStringParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=EString
	 */
	protected void sequence_CatStartStringType(EObject context, CatStartStringType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.CAT_START_STRING_TYPE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.CAT_START_STRING_TYPE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCatStartStringTypeAccess().getValueEStringParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type=[EClass|ID] expression=Expression?)
	 */
	protected void sequence_CompleteTypeSelection(EObject context, CompleteTypeSelection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID? commands+=Mutator commands+=Mutator* ((min=EInt max=MaxCardinality) | fixed=EInt)?)
	 */
	protected void sequence_CompositeMutator(EObject context, CompositeMutator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=[EClass|ID] id=EString rule=EString)
	 */
	protected void sequence_Constraint(EObject context, Constraint semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.CONSTRAINT__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.CONSTRAINT__ID));
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.CONSTRAINT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.CONSTRAINT__TYPE));
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.CONSTRAINT__RULE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.CONSTRAINT__RULE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getConstraintAccess().getTypeEClassIDTerminalRuleCall_1_0_1(), semanticObject.getType());
		feeder.accept(grammarAccess.getConstraintAccess().getIdEStringParserRuleCall_2_0(), semanticObject.getId());
		feeder.accept(grammarAccess.getConstraintAccess().getRuleEStringParserRuleCall_4_0(), semanticObject.getRule());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID? 
	 *         type=[EClass|ID] 
	 *         (container=ObSelectionStrategy refType=[EReference|ID]?)? 
	 *         ((attributes+=AttributeSet | references+=ReferenceSet)? (attributes+=AttributeSet | references+=ReferenceSet)*)? 
	 *         (min=EInt? max=MaxCardinality)?
	 *     )
	 */
	protected void sequence_CreateObjectMutator(EObject context, CreateObjectMutator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID? refType=[EReference|ID] target=ObSelectionStrategy? source=ObSelectionStrategy? (min=EInt? max=MaxCardinality)?)
	 */
	protected void sequence_CreateReferenceMutator(EObject context, CreateReferenceMutator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (first=Evaluation (operator+=BinaryOperator second+=Evaluation)*)
	 */
	protected void sequence_Expression(EObject context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     metamodel=EString
	 */
	protected void sequence_Library(EObject context, Library semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.DEFINITION__METAMODEL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.DEFINITION__METAMODEL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLibraryAccess().getMetamodelEStringParserRuleCall_4_0(), semanticObject.getMetamodel());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (value+=EString value+=EString*)
	 */
	protected void sequence_ListStringType(EObject context, ListStringType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     file=EString
	 */
	protected void sequence_Load(EObject context, Load semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.LOAD__FILE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.LOAD__FILE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLoadAccess().getFileEStringParserRuleCall_2_0(), semanticObject.getFile());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {LowerStringType}
	 */
	protected void sequence_LowerStringType(EObject context, LowerStringType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID? 
	 *         object=ObSelectionStrategy 
	 *         ((attributes+=AttributeSet | references+=ReferenceSet)? (attributes+=AttributeSet | references+=ReferenceSet)*)? 
	 *         (min=EInt? max=MaxCardinality)?
	 *     )
	 */
	protected void sequence_ModifyInformationMutator(EObject context, ModifyInformationMutator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (refType=[EReference|ID] source=ObSelectionStrategy? newSource=ObSelectionStrategy? (min=EInt? max=MaxCardinality)?)
	 */
	protected void sequence_ModifySourceReferenceMutator(EObject context, ModifySourceReferenceMutator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (refType=[EReference|ID] source=ObSelectionStrategy? newTarget=ObSelectionStrategy? (min=EInt? max=MaxCardinality)?)
	 */
	protected void sequence_ModifyTargetReferenceMutator(EObject context, ModifyTargetReferenceMutator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         load+=Load* 
	 *         definition=Definition 
	 *         ((blocks+=Block blocks+=Block*) | (commands+=Mutator commands+=Mutator*)) 
	 *         (constraints+=Constraint constraints+=Constraint*)?
	 *     )
	 */
	protected void sequence_MutatorEnvironment(EObject context, MutatorEnvironment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=[EClass|ID] expression=Expression?)
	 */
	protected void sequence_OtherTypeSelection(EObject context, OtherTypeSelection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (num=EInt? output=EString source=Source metamodel=EString)
	 */
	protected void sequence_Program(EObject context, Program semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {RandomBooleanType}
	 */
	protected void sequence_RandomBooleanType(EObject context, RandomBooleanType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((min=EDouble max=EDouble)?)
	 */
	protected void sequence_RandomDoubleType(EObject context, RandomDoubleType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((min=EInt max=EInt)?)
	 */
	protected void sequence_RandomIntegerType(EObject context, RandomIntegerType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (min=EInt max=EInt)
	 */
	protected void sequence_RandomStringType(EObject context, RandomStringType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=[EClass|ID] expression=Expression?)
	 */
	protected void sequence_RandomTypeSelection(EObject context, RandomTypeSelection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=[EReference|ID]? operator=Operator (value=ObSelectionStrategy refType=[EReference|ID]?)?)
	 */
	protected void sequence_ReferenceEvaluation(EObject context, ReferenceEvaluation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (reference+=[EReference|ID] object=ObSelectionStrategy refType=[EReference|ID]?)
	 */
	protected void sequence_ReferenceInit(EObject context, ReferenceInit semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (reference+=[EReference|ID] object=ObSelectionStrategy? reference+=[EReference|ID])
	 */
	protected void sequence_ReferenceSwap(EObject context, ReferenceSwap semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (refType=[EReference|ID] type=[EClass|ID])
	 */
	protected void sequence_RemoveCompleteReferenceMutator(EObject context, RemoveCompleteReferenceMutator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (object=ObSelectionStrategy (min=EInt? max=MaxCardinality)?)
	 */
	protected void sequence_RemoveObjectMutator(EObject context, RemoveObjectMutator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (refType=[EReference|ID] type=[EClass|ID] (min=EInt? max=MaxCardinality)?)
	 */
	protected void sequence_RemoveRandomReferenceMutator(EObject context, RemoveRandomReferenceMutator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (refType=[EReference|ID] container=ObSelectionStrategy (min=EInt? max=MaxCardinality)?)
	 */
	protected void sequence_RemoveSpecificReferenceMutator(EObject context, RemoveSpecificReferenceMutator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (oldstring=EString newstring=EString)
	 */
	protected void sequence_ReplaceStringType(EObject context, ReplaceStringType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.REPLACE_STRING_TYPE__OLDSTRING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.REPLACE_STRING_TYPE__OLDSTRING));
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.REPLACE_STRING_TYPE__NEWSTRING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.REPLACE_STRING_TYPE__NEWSTRING));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getReplaceStringTypeAccess().getOldstringEStringParserRuleCall_3_0(), semanticObject.getOldstring());
		feeder.accept(grammarAccess.getReplaceStringTypeAccess().getNewstringEStringParserRuleCall_5_0(), semanticObject.getNewstring());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID object=ObSelectionStrategy (container=ObSelectionStrategy refType=[EReference|ID]?)?)
	 */
	protected void sequence_SelectObjectMutator(EObject context, SelectObjectMutator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     path=EString
	 */
	protected void sequence_Source(EObject context, Source semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.SOURCE__PATH) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.SOURCE__PATH));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSourceAccess().getPathEStringParserRuleCall_1_0(), semanticObject.getPath());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=EBoolean
	 */
	protected void sequence_SpecificBooleanType(EObject context, SpecificBooleanType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.SPECIFIC_BOOLEAN_TYPE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.SPECIFIC_BOOLEAN_TYPE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSpecificBooleanTypeAccess().getValueEBooleanParserRuleCall_1_0(), semanticObject.isValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=EDouble
	 */
	protected void sequence_SpecificDoubleType(EObject context, SpecificDoubleType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.SPECIFIC_DOUBLE_TYPE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.SPECIFIC_DOUBLE_TYPE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSpecificDoubleTypeAccess().getValueEDoubleParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=EInt
	 */
	protected void sequence_SpecificIntegerType(EObject context, SpecificIntegerType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.SPECIFIC_INTEGER_TYPE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.SPECIFIC_INTEGER_TYPE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSpecificIntegerTypeAccess().getValueEIntParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (objSel=[ObjectEmitter|ID] expression=Expression?)
	 */
	protected void sequence_SpecificObjectSelection(EObject context, SpecificObjectSelection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_SpecificStringType(EObject context, SpecificStringType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MutatorenvironmentPackage.Literals.SPECIFIC_STRING_TYPE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatorenvironmentPackage.Literals.SPECIFIC_STRING_TYPE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSpecificStringTypeAccess().getValueSTRINGTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {UpperStringType}
	 */
	protected void sequence_UpperStringType(EObject context, UpperStringType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
