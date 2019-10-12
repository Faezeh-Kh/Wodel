/**
 */
package anatlyzer.atl.errors.util;

import anatlyzer.atl.errors.*;

import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see anatlyzer.atl.errors.AnalysisResultPackage
 * @generated
 */
public class AnalysisResultAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AnalysisResultPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisResultAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AnalysisResultPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnalysisResultSwitch<Adapter> modelSwitch =
		new AnalysisResultSwitch<Adapter>() {
			@Override
			public Adapter caseAnalysisResult(AnalysisResult object) {
				return createAnalysisResultAdapter();
			}
			@Override
			public Adapter caseAnalysisInfo(AnalysisInfo object) {
				return createAnalysisInfoAdapter();
			}
			@Override
			public Adapter caseProblem(Problem object) {
				return createProblemAdapter();
			}
			@Override
			public Adapter caseStringToObjectMap(Map.Entry<String, Object> object) {
				return createStringToObjectMapAdapter();
			}
			@Override
			public Adapter caseBatchAnalysis(BatchAnalysis object) {
				return createBatchAnalysisAdapter();
			}
			@Override
			public Adapter caseRecovery(Recovery object) {
				return createRecoveryAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link anatlyzer.atl.errors.AnalysisResult <em>Analysis Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see anatlyzer.atl.errors.AnalysisResult
	 * @generated
	 */
	public Adapter createAnalysisResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link anatlyzer.atl.errors.AnalysisInfo <em>Analysis Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see anatlyzer.atl.errors.AnalysisInfo
	 * @generated
	 */
	public Adapter createAnalysisInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link anatlyzer.atl.errors.Problem <em>Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see anatlyzer.atl.errors.Problem
	 * @generated
	 */
	public Adapter createProblemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>String To Object Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createStringToObjectMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link anatlyzer.atl.errors.BatchAnalysis <em>Batch Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see anatlyzer.atl.errors.BatchAnalysis
	 * @generated
	 */
	public Adapter createBatchAnalysisAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link anatlyzer.atl.errors.Recovery <em>Recovery</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see anatlyzer.atl.errors.Recovery
	 * @generated
	 */
	public Adapter createRecoveryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AnalysisResultAdapterFactory
