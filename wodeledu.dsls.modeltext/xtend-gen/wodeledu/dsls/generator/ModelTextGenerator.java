/**
 * generated by Xtext 2.13.0
 */
package wodeledu.dsls.generator;

import com.google.common.collect.Iterables;
import manager.ModelManager;
import manager.WodelContext;
import modeltext.IdentifyElements;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import wodeledu.dsls.ModelTextUtils;

/**
 * @author Pablo Gomez-Abajo - modelText code generator.
 * 
 * Serialization of the modelText code into an EMF XMI model
 */
@SuppressWarnings("all")
public class ModelTextGenerator extends AbstractGenerator {
  private String fileName;
  
  private String path;
  
  private String xmiFileName;
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    WodelContext.setProject(null);
    ModelManager.setProjectNameByResource(resource);
    String _workspaceAbsolutePath = ModelManager.getWorkspaceAbsolutePath();
    String _plus = (_workspaceAbsolutePath + "/");
    String _project = WodelContext.getProject();
    String _plus_1 = (_plus + _project);
    this.path = _plus_1;
    Iterable<IdentifyElements> _filter = Iterables.<IdentifyElements>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), IdentifyElements.class);
    for (final IdentifyElements e : _filter) {
      {
        this.fileName = resource.getURI().lastSegment();
        String xTextFileName = ((("file:/" + this.path) + "/src/") + this.fileName);
        String _outputFolder = ModelManager.getOutputFolder();
        String _plus_2 = ((("file:/" + this.path) + "/") + _outputFolder);
        String _plus_3 = (_plus_2 + "/");
        String _replaceAll = this.fileName.replaceAll(".modeltext", "_modeltext.model");
        String _plus_4 = (_plus_3 + _replaceAll);
        this.xmiFileName = _plus_4;
        ModelTextUtils.serialize(xTextFileName, this.xmiFileName);
      }
    }
  }
}
