/*
 * generated by Xtext 2.13.0
 */
package wodeledu.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import manager.ModelManager
import mutatext.Configuration
import wodeledu.dsls.MutaTextUtils
import org.eclipse.core.resources.IProject
import manager.ProjectUtils

/**
 * @author Pablo Gomez-Abajo - mutaText code generator.
 * 
 * Serialization of the mutaText code into an EMF XMI model
 *  
 */

class MutaTextGenerator extends AbstractGenerator {

	protected IProject project = null
	
	private String fileName;
	private String path;
	private String xmiFileName;
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		ProjectUtils.resetProject()
		project = ProjectUtils.getProject()
		path = ModelManager.getWorkspaceAbsolutePath+'/'+manager.WodelContext.getProject		

		for(e: resource.allContents.toIterable.filter(Configuration)) {
			
			fileName = resource.URI.lastSegment
			var xTextFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath + '/' + project.name + "/src/" + fileName
			xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath + '/' + project.name + '/' + ModelManager.outputFolder + '/' + fileName.replaceAll(".mutatext", "_mutatext.model")
			MutaTextUtils.serialize(xTextFileName, xmiFileName)
			/* Write the EObject into a file */
		}
	}
}
