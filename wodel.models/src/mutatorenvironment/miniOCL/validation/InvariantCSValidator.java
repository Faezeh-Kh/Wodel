/**
 *
 * $Id$
 */
package mutatorenvironment.miniOCL.validation;

import mutatorenvironment.miniOCL.ExpCS;

/**
 * A sample validator interface for {@link mutatorenvironment.miniOCL.InvariantCS}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface InvariantCSValidator {
	boolean validate();

	boolean validateExp(ExpCS value);
}
