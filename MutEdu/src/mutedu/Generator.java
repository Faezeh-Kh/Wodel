package mutedu;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.configureoptions.ConfigureOptionsUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.identifyelements.IdentifyElementsUtils;
import org.osgi.framework.Bundle;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

import exceptions.MetaModelNotFoundException;
import manager.ModelManager;
import mutextension.generator.IGenerator;

public class Generator implements IGenerator {


	public static void copyFolder(File src, File dest) throws IOException {
		
		if (src.isDirectory()) {

			// if directory not exists, create it
			if (!dest.exists()) {
				dest.mkdir();
			}

			// list all the directory contents
			String files[] = src.list();

			for (String file : files) {
				// construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFolder(srcFile, destFile);
			}

		} else {
			// if file, then copy it
			// Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Wodel-Edu: Generation of a web environment with test exercises for education";
	}

	@Override
	public boolean doGenerate(String fileName, String metamodel, String project, String outputPath, IProject mutProject, IFolder srcPath, IFolder configPath, 
			IProgressMonitor monitor) {
		Path filePath = new Path(fileName);
		String fileExtension = filePath.getFileExtension();
		String graphFileName = fileName.replace(fileExtension, "graph");
		// create a sample file
		monitor.beginTask("Creating " + graphFileName, 2);
		String testsFileName = fileName.replace(fileExtension, "tests");
		String idelemsFileName = fileName.replace(fileExtension, "idelems");
		String cfgoptsFileName = fileName.replace(fileExtension, "cfgopts");
		final IFile graphFile = srcPath.getFile(new Path(graphFileName));
		try {
			InputStream stream = openContentStream();
			String def = "";
			if (metamodel != null) {
				def += "metamodel \"" + ModelManager.getMetaModelPath(project) + "/" + metamodel + "\"\n\n";
			}
			else {
				def = "metamodel \"\" //fill this with the path to the meta-model\n\n";
			}
			
			if (metamodel != null) {
				ArrayList<EPackage> packages = ModelManager.loadMetaModel(ModelManager.getMetaModelPath(project) + "/" + metamodel);
				ArrayList<EClass> eclasses = ModelManager.getEClasses(packages);
				EClass eclass = eclasses.get(1);
				EList<EAttribute> eatts = eclass.getEAllAttributes();
				EAttribute eatt = null;
				if (eatts != null) {
					if (eatts.size() > 0) {
						eatt = eatts.get(0);
					}
				}
				EClass rooteclass = eclasses.get(0);
				def += rooteclass.getName() + ": diagram {\n";
				if (eatt != null) {
					def += "\t" + eclass.getName() + "(" + eatt.getName() + "): node, shape=circle\n";
				}
			}
			else {
				def += "//RootNode: diagram {\n";
			}
			def += "\t//InitialNode(isInitial): markednode\n"
				+ "\t//SimpleNode(not isFinal): node, shape=circle\n"
				+ "\t//EndingNode(isFinal): node, shape=doublecircle\n"
				+ "\t//Relation(source, target): edge, label=symbol\n"
			+ "}";
			if (graphFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				graphFile.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(Charsets.UTF_8));
				graphFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		final IFile testsFile = srcPath.getFile(new Path(testsFileName));
		try {
			InputStream stream = openContentStream();
			String def = "navigation=free\n"
					+ "AlternativeResponse {\n"
					+ "\tretry=yes"
					+ "\t//description for 'model1-name.model' = 'Description for model1'\n"
					+ "\t//other descriptions...\n"
					+ "}\n"
					+ "\tMultiChoiceDiagram {\n"
					+ "\tretry=no"
					+ "\t//description for 'model1-name.model' = 'Description for model1'\n"
					+ "\t//other descriptions...\n"
					+ "}\n"
					+ "MultiChoiceEmendation {\n"
					+ "\tretry=yes, weighted=no, penalty=0.0, order=options-descending, mode=checkbox\n"
					+ "\t//description for 'model2-name.model' = 'Description for model2'\n"
					+ "\t//other descriptions...\n"
					+ "}";
			if (testsFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				testsFile.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(Charsets.UTF_8));
				testsFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		final IFile idelemsFile = srcPath.getFile(new Path(idelemsFileName));
		try {
			InputStream stream = openContentStream();
			String def = "";
			if (metamodel != null) {
				def += "metamodel \"" + ModelManager.getMetaModelPath(project) + "/" + metamodel + "\"\n\n";
			}
			else {
				def = "metamodel \"\" //fill this with the path to the meta-model\n\n";
			}
			
			if (metamodel != null) {
				ArrayList<EPackage> packages = ModelManager.loadMetaModel(ModelManager.getMetaModelPath(project) + "/" + metamodel);
				ArrayList<EClass> eclasses = ModelManager.getEClasses(packages);
				EClass eclass = eclasses.get(0);
				EList<EAttribute> eatts = eclass.getEAllAttributes();
				EAttribute eatt1 = null;
				EAttribute eatt2 = null;
				if (eatts != null) {
					if (eatts.size() > 0) {
						eatt1 = eatts.get(0);
					}
					if (eatts.size() > 1) {
						eatt2 = eatts.get(1);
					}
				}
				if ((eatt1 != null) && (eatt2 != null)) {
					def += ">" + eclass.getName() + "(" + eatt2.getName() + "): " + eclass.getName() + " %" + eatt1.getName() + "\n";
				}
				if (eatt1 != null) {
					def += ">" + eclass.getName() + ": " + eclass.getName() + " %" + eatt1.getName() + "\n";
				}
			}
			def += "//>ClassName(attName): (LeftText %AttributeName|%ReferenceName.AttributeName RightText)+\n";
			if (idelemsFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				idelemsFile.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(Charsets.UTF_8));
				idelemsFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		String xTextFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() +'/' + mutProject.getFolder(new Path("/src/" + idelemsFileName)).getFullPath();
		String xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + '/' + mutProject.getFolder(new Path('/' + outputPath + '/' + idelemsFileName.replaceAll(".idelems", "_idelems.model"))).getFullPath();
		IdentifyElementsUtils.serialize(xTextFileName, xmiFileName);

		final IFile cfgoptsFile = srcPath.getFile(new Path(cfgoptsFileName));
		try {
			InputStream stream = openContentStream();
			String def = "";
			if (metamodel != null) {
				def += "metamodel \"" + ModelManager.getMetaModelPath(project) + "/" + metamodel + "\"\n\n";
			}
			else {
				def = "metamodel \"\" //fill this with the path to the meta-model\n\n";
			}
			
			if (metamodel != null) {
				ArrayList<EPackage> packages = ModelManager.loadMetaModel(ModelManager.getMetaModelPath(project) + "/" + metamodel);
				ArrayList<EClass> eclasses = ModelManager.getEClasses(packages);
				EClass eclass = eclasses.get(0);
				Bundle bundle = Platform.getBundle("MutProgram");
				URL fileURL = bundle.getEntry("/models/AppliedMutations.ecore");
				ArrayList<EPackage> registrypackages = ModelManager.loadMetaModel(FileLocator.resolve(fileURL).getFile());
				ArrayList<EClass> registryeclasses = ModelManager.getEClasses(registrypackages);
				EClass registryeclass = registryeclasses.get(0);
				EList<EAttribute> registryeatts = registryeclass.getEAllAttributes();
				EAttribute registryeatt = null;
				if (registryeatts != null) {
					if (registryeatts.size() > 0) {
						registryeatt = registryeatts.get(0);
					}
				}
				EList<EReference> registryerefs = registryeclass.getEAllReferences();
				EReference registryeref = null;
				if (registryerefs != null) {
					if (registryerefs.size() > 0) {
						registryeref = registryerefs.get(0);
					}
				}
				if ((registryeatt != null) && (registryeref != null)) {
					def += ">" + registryeclass.getName() + "(" + eclass.getName() + "): This is the text for the right options of the mutation on the attribute %attName and on the reference %refName /\n";
					def += "\t\tThis is the text for the wrong options of the mutation on the attribute %attName and on the reference %refName\n";
				}
				if (registryeatt != null) {
					def += ">" + registryeclass.getName() + "(" + eclass.getName() + "): This is the text for the right options of the mutation on the attribute %attName /\n";
					def += "\t\tThis is the text for the wrong options of the mutation on the attribute %attName\n";
				}
				if (registryeref != null) {
					def += ">" + registryeclass.getName() + "(" + eclass.getName() + "): This is the text for the right options of the mutation on the reference %refName /\n";
					def += "\t\tThis is the text for the wrong options of the mutation on the reference %refName\n";
				}
			}
			def += "//>RegistryClassName(ClassName): (LeftOptionOkText %variable RightOptionOkText)+ /\n";
			def += "//\t\t(LeftOptionWrongText %variable RightOptionWrongText)+";
			if (cfgoptsFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				cfgoptsFile.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(Charsets.UTF_8));
				cfgoptsFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		
		xTextFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() +'/' + mutProject.getFolder(new Path("/src/" + cfgoptsFileName)).getFullPath();
		xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + '/' + mutProject.getFolder(new Path('/' + outputPath + '/' + cfgoptsFileName.replaceAll(".cfgopts", "_cfgopts.model"))).getFullPath();
		ConfigureOptionsUtils.serialize(xTextFileName, xmiFileName);
		
		final IFile configFile = configPath.getFile(new Path("config.txt"));
		try {
			InputStream stream = configFile.getContents();
			if (configFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += "\n" + this.getName();
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				configFile.setContents(stream, true, true, monitor);
			}
			else {
				configFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
		
		final IFolder srcgenFolder = mutProject.getFolder(new Path("src-gen"));
		try {
			srcgenFolder.create(true, true, monitor);
		} catch (CoreException e) {
		}
		final IFolder htmlFolder = srcgenFolder.getFolder(new Path("html"));
		try {
			htmlFolder.create(true, true, monitor);
		} catch (CoreException e) {
		}
		String srcName = Generator.class.getProtectionDomain().getCodeSource().getLocation().getFile() + "content/";
		final File src = new Path(srcName).toFile();
		final File dest = htmlFolder.getRawLocation().makeAbsolute().toFile();
		
		if ((src != null) && (dest != null)) {
			try {
				copyFolder(src, dest);
			} catch (IOException e) {
			}
		}
		
		return false;
	}
	
	@Override
	public void doRun(IFile file) {
		Class<?> cls = null;
		String fileName = file.getName();
		String classname = fileName.replaceAll(".mutator", "") + "_Graph";
		
		try {
			cls = Class.forName(classname);
		} catch (ClassNotFoundException e) {
		}
		
		if (cls == null) {
			try {
				IProject project = file.getProject();
				if (project.hasNature(JavaCore.NATURE_ID)) {
					IJavaProject javaProject = JavaCore.create(project);
					// read class path entries of the project
					String[] classPathEntries = JavaRuntime
							.computeDefaultRuntimeClassPath(javaProject);
					List<URL> urlList = new ArrayList<URL>();
					for (String classPathEntry : classPathEntries) {
						Path path = new Path(classPathEntry);
						urlList.add(path.toFile().toURI().toURL());
					}
					// create url class loader whose parent is the class loader
					// of the project
					// and containing the class path entries of the project
					ClassLoader parentClassLoader = project.getClass()
							.getClassLoader();
					URL[] urls = (URL[]) urlList
							.toArray(new URL[urlList.size()]);
					URLClassLoader classLoader = new URLClassLoader(urls,
							parentClassLoader);
					// load class
					cls = classLoader.loadClass(classname);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Object ob = null;
		try {
			ob = cls.newInstance();
			Method m = cls.getMethod("generate");
			m.invoke(ob);
			// ime = (IMutatorExecutor)ob;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		final IFile testsFile = file.getParent().getFile(new Path(file.getName().replace(".mutator", ".tests")));
		try {
			InputStream stream = testsFile.getContents();
			if (testsFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				testsFile.setContents(stream, true, true, null);
			}
			else {
				testsFile.create(stream, true, null);
			}
			stream.close();
		} catch (CoreException e) {
		} catch (IOException e) {
		}

	}

	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		// TODO Auto-generated method stub

	}

	/**
	 * We will initialize file contents with a sample text.
	 */

	private InputStream openContentStream() {
		String contents = "";
		return new ByteArrayInputStream(contents.getBytes());
	}
}
