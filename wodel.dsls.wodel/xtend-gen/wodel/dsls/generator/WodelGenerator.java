/**
 * generated by Xtext 2.13.0
 */
package wodel.dsls.generator;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import wodel.dsls.generator.WodelMutatorGenerator;

/**
 * @author Pablo Gomez-Abajo - Main Wodel code generator.
 * 
 * It calls WodelMutatorGenerator to generate the Java code for the mutations,
 * and WodelUseGenerator to generate the USE code for the seeds synthesizer.
 */
@SuppressWarnings("all")
public class WodelGenerator extends AbstractGenerator {
  @Inject
  private WodelMutatorGenerator mutatorGenerator;
  
  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.mutatorGenerator.doGenerate(input, fsa, context);
  }
}
