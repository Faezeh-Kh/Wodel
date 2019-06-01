/**
 *
 * $Id$
 */
package mutatorenvironment.validation;

import mutatorenvironment.ObjectEmitter;
import mutatorenvironment.Operator;

import org.eclipse.emf.ecore.EAttribute;

/**
 * A sample validator interface for {@link mutatorenvironment.ObjectAttributeType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ObjectAttributeTypeValidator {
	boolean validate();

	boolean validateObjSel(ObjectEmitter value);
	boolean validateAttribute(EAttribute value);
	boolean validateOperator(Operator value);
}
