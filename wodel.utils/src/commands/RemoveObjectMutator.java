package commands;

import java.util.ArrayList;
import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import commands.selection.strategies.ObSelectionStrategy;
import exceptions.ReferenceNonExistingException;

/**
 * @author Victor Lopez Rivero RemoveObjectMutator removes objects from the
 *         diagram
 */
public class RemoveObjectMutator extends Mutator {

	/**
	 * Object to delete
	 */
	private ObSelectionStrategy objSelection;

	/**
	 * Object to delete
	 */
	private EObject obj;

	/**
	 * Deleted object
	 */
	private EObject result;

	/**
	 * Saved object
	 */
	private EObject saved;
	
	/**
	 * @param model
	 * @param metaModel
	 * @param objSelection
	 *            Normal constructor
	 */
	public RemoveObjectMutator(Resource model, ArrayList<EPackage> metaModel,
			ObSelectionStrategy objSelection) {
		super(model, metaModel, "ObjectRemoved");
		this.objSelection = objSelection;
	}

	/**
	 * @param model
	 * @param metaModel
	 * @param objSelection
	 *            Normal constructor
	 */
	public RemoveObjectMutator(Resource model, ArrayList<EPackage> metaModel,
			EObject obj) {
		super(model, metaModel, "ObjectRemoved");
		this.obj = obj;
	}

	@Override
	public Object mutate() throws ReferenceNonExistingException {
		// All the references of each object
		List<EReference> refList = new ArrayList<EReference>();

		EObject deletedObj = null;

		if (this.obj == null) {
			if (this.objSelection == null) {
				return null;
			}
			deletedObj = this.objSelection.getObject();
		} else {
			deletedObj = this.obj;
		}

		if (deletedObj == null) {
			result = null;
			return null;
		}

		saved = EcoreUtil.copy(deletedObj);
		
		EcoreUtil.remove(deletedObj);

		// For each object of the model
		for (EObject o : ModelManager.getAllObjects(this.getModel())) {
			// We check their references looking for the deleted object
			for (EReference r : ModelManager.getReferences(o)) {
				// Multivalued
				if (r.getUpperBound() > 1 || r.getUpperBound() < 0) {
					// We save the referenced objects of the reference
					List<EObject> referenced = (List<EObject>) o.eGet(r, true);
					List<EObject> auxList = new ArrayList<EObject>();
					for (EObject aux : referenced) {
						// If the object pointed is the selected
						if (deletedObj.equals(aux)) {
							// We save what we want to delete (cannot do it in
							// this for)
							auxList.add(aux);
						}
					}
					// And then we delete what we saved (outside the for)
					for (EObject aux : auxList) {
						referenced.remove(aux);
					}
				}
				// Monovalued
				else {
					EObject auxObj = (EObject) o.eGet(r, true);
					if (auxObj == null) {
						return null;
					}

					// If the object pointed is the selected
					if (deletedObj.equals(auxObj)) {
						// We delete the reference
						o.eSet(r, null);
					}
				}
			}
		}
		result = deletedObj;

		return this.result;
	}

	// GETTERS AND SETTERS
	public EObject getObject() {
		return saved;
	}
	// END GETTERS AND SETTERS
}
