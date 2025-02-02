package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import commands.selection.strategies.ObSelectionStrategy;
import commands.strategies.AttributeConfigurationStrategy;
import commands.strategies.ReferenceConfigurationStrategy;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * ModelManager static methods to get information of
 * the models
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class ModelManager {

	public static Random rn = new Random((int) System.currentTimeMillis());
	public static IProject wodelProject = null;
	
	public static boolean isRegistered(List<EPackage> packages) {
		for (EPackage pack : packages) {
			if(EPackage.Registry.INSTANCE.containsKey(pack.getNsURI())) {
				return true;
			}
		}
		return false;
	}

	public static Map<String, EPackage> unregisterMetaModel (List<EPackage> packages) {
		Map<String, EPackage> packs = new HashMap<String, EPackage>(); 
		for (EPackage pack : packages) {
			if (EPackage.Registry.INSTANCE.containsKey(pack.getNsURI())) {
				packs.put(pack.getNsURI(), EPackage.Registry.INSTANCE.getEPackage(pack.getNsURI()));
				EPackage.Registry.INSTANCE.remove(pack.getNsURI());
			}
		}
		return packs;
	}

	public static void registerMetaModel (Map<String, EPackage> packages) {
		for (String nsURI : packages.keySet()) {
			EPackage.Registry.INSTANCE.put(nsURI, packages.get(nsURI));
		}
	}

	public static Map<String, EPackage> registeredMetaModels (List<EPackage> packages) {
		Map<String, EPackage> packs = new HashMap<String, EPackage>(); 
		for (EPackage pack : packages) {
			if (EPackage.Registry.INSTANCE.containsKey(pack.getNsURI())) {
				packs.put(pack.getNsURI(), EPackage.Registry.INSTANCE.getEPackage(pack.getNsURI()));
			}
		}
		return packs;
	}

	public static List<EPackage> loadMetaModel (String uri) throws MetaModelNotFoundException {
		List<EPackage> metamodel = null;
		try {
			metamodel = new ArrayList<EPackage>();
			
			String mmURI = uri;
			
			File fmm = new File(uri);
			if (fmm.exists() == false && uri.indexOf("/") != -1) {
				mmURI = getMetaModelPath() + "/" + uri.substring(uri.lastIndexOf("/") + 1, uri.length());
			}
			if (fmm.exists() == false && uri.indexOf("/") == -1) {
				mmURI = getMetaModelPath() + "/" + uri;
			}
			
			// check if it is already registered
			EPackage pck = EPackage.Registry.INSTANCE.getEPackage(mmURI);
			
			// otherwise
			if (pck == null) {
				EPackage.Registry.INSTANCE.put(uri, EPackage.class);
				if (Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().size() == 0)
					Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
				
				ResourceSetImpl resourceSet = new ResourceSetImpl();
				Resource        resource    = resourceSet.getResource(URI.createFileURI(mmURI), true);
				for (EObject obj : resource.getContents()) {
					if (obj instanceof EPackage) {
						resourceSet.getPackageRegistry().put(((EPackage)obj).getNsURI(), ((EPackage)obj).getEFactoryInstance().getEPackage());
						metamodel.add((EPackage)obj);
					}
				}
			}
			else metamodel.add(pck);

			
		}
		catch (Exception e) {
			throw new MetaModelNotFoundException(uri);
		}
		
		return metamodel;
	}


	public static List<EPackage> loadMetaModel (String uri, Class<?> cls) throws MetaModelNotFoundException {
		List<EPackage> metamodel = null;
		try {
			metamodel = new ArrayList<EPackage>();
			
			String mmURI = uri;
			
			// check if it is already registered
			File fmm = new File(uri);
			if (fmm.exists() == false && mmURI.indexOf("/") != -1) {
				mmURI = getMetaModelPath(cls) + "/" + mmURI.substring(mmURI.lastIndexOf("/") + 1, mmURI.length());
			}
			if (fmm.exists() == false && mmURI.indexOf("/") == -1) {
				mmURI = getMetaModelPath(cls) + "/" + mmURI;
			}
			EPackage pck = EPackage.Registry.INSTANCE.getEPackage(mmURI);
			
			// otherwise
			if (pck==null) {
				EPackage.Registry.INSTANCE.put(uri, EPackage.class);
				if (Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().size() == 0)
					Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
				
				ResourceSetImpl resourceSet = new ResourceSetImpl();
				Resource        resource    = resourceSet.getResource(URI.createFileURI(mmURI), true);
				for (EObject obj : resource.getContents()) {
					if (obj instanceof EPackage) {
						resourceSet.getPackageRegistry().put(((EPackage)obj).getNsURI(), ((EPackage)obj).getEFactoryInstance().getEPackage());
						metamodel.add((EPackage)obj);
					}
				}
			}
			else metamodel.add(pck);

			
		}
		catch (Exception e) {
			throw new MetaModelNotFoundException(uri);
		}
		
		return metamodel;
	}

	public static URI createURI(String path) {
		return createURI(path, null);
	}

	public static URI createURI(String path, String cwd) {
		String uriString = path;
		if (uriString.startsWith("platform:/resource/")) {
			// this option depends on org.eclipse.resources
			// return
			// URI.createPlatformResourceURI(ResourcesPlugin.getWorkspace().getRoot().getFile(new
			// Path(uriString)), true);
			return URI.createPlatformResourceURI(
					extract(uriString, "platform:/resource/"), true);
		} else if (uriString.startsWith("platform:/plugin/")) {
			return URI.createPlatformPluginURI(
					extract(uriString, "platform:/plugin/"), true);
		} else if (uriString.startsWith("http:/")) { // to allow loading
														// http:/www.eclipse.org/emf/2002/Ecore,
														// but this is not the
														// general case
			URI u = URI.createURI(path);
			return u;
		}

		if (cwd == null) {
			return URI.createURI(path);
		} else {
			URI uri = URI.createFileURI(new File(path).getAbsolutePath());
			return uri;
		}
	}

	private static String extract(String s, String extract) {
		return s.replaceFirst("^" + extract, "");
	}
	
	public static void setProjectNameByResource(Resource resource) {
		String projectName = resource.getURI().devicePath();
		if (projectName.startsWith("/resource/")) {
			projectName = projectName.substring("/resource/".length(), projectName.length());
		}
		else {
			projectName = projectName.substring(ModelManager.getWorkspaceAbsolutePath().length() + 1, projectName.length());
		}
		projectName = projectName.substring(0, projectName.indexOf("/"));
		WodelContext.setProject(projectName);
	}

	public static String getWorkspaceAbsolutePath() {
		IPath path = Platform.getLocation().makeAbsolute();
		URI uri = URI.createFileURI(path.toString());
		String ret = uri.toString();
		ret = ret.replaceFirst("file:/", "/");
		if (ret.indexOf(":") != -1) {
			ret = ret.replaceFirst("/", "");
		}
		return ret;
	}

	public static URI getModelWithFolder(String model) {
		IPath path = Platform.getLocation().makeAbsolute();

		URI uri = URI.createFileURI(model);
		if (wodelProject != null) {
			// The URI is relative so we have to complete it
			if (uri.hasAbsolutePath() != true) {
				uri = URI.createFileURI(path.toString() + "/"
						+ wodelProject.getName() + "/" + model);
			}
		}

		return uri;
	}

	public static String getMetaModel() {
		try {
			String path = getWorkspaceAbsolutePath() + '/'
					+ ProjectUtils.getProject().getName();

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String modelName = br.readLine();
			File[] files = new File(path + '/' + modelName).listFiles();
			for (File file : files) {
				if (file.isFile() == true) {
					String modelpath = file.getPath().replaceAll("\\\\", "/");
					if (modelpath.endsWith(".ecore") == true) {
						br.close();
						return modelpath;
					}
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getMetaModel(Class<?> cls) {
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			path = path.substring(0, path.lastIndexOf("/")).replaceAll("\\\\", "/");
			if (path.contains("/bin")) {
				path = path.substring(0, path.lastIndexOf("/bin"));
			}

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String modelName = br.readLine();
			File[] files = new File(path + '/' + modelName).listFiles();
			for (File file : files) {
				if (file.isFile() == true) {
					String modelpath = file.getPath().replaceAll("\\\\", "/");
					if (modelpath.endsWith(".ecore") == true) {
						br.close();
						return modelpath;
					}
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getMetaModelPath() {
		IProject project = ProjectUtils.getProject();
		if (project != null) {
			wodelProject = project;
		}
		try {
			String path = getWorkspaceAbsolutePath() + '/'
					+ wodelProject.getName();

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = path + '/' + br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getMetaModelPath(Class<?> cls) {
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			path = path.substring(0, path.lastIndexOf("/")).replaceAll("\\\\", "/");
			if (path.contains("/bin")) {
				path = path.substring(0, path.lastIndexOf("/bin"));
			}

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = path + '/' + br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getDifferentRatioPath(String mutatorName) {
		String path = getWorkspaceAbsolutePath() + '/'
				+ ProjectUtils.getProject().getName();
		String ret = path.replaceAll("\\\\", "/") + "/data/config/" + mutatorName + ".different.txt";
		return ret;
	}

	public static String getDifferentRatioPath(String mutatorName, IProject project) {
		String path = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getFullPath().toFile().getPath().toString();
		String ret = path + "/data/" + mutatorName + ".different.txt";
		return ret;
	}
	
	public static String getGeneratedMutantsPath(String mutatorName) {
		String path = getWorkspaceAbsolutePath() + '/'
				+ ProjectUtils.getProject().getName();
		String ret = path.replaceAll("\\\\", "/") + "/data/config/" + mutatorName + ".generated.txt";
		return ret;
	}
	
	public static String getGeneratedMutantsPath(String mutatorName, IProject project) {
		String path = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getFullPath().toFile().getPath().toString();
		String ret = path + "/data/" + mutatorName + ".generated.txt";
		return ret;
	}

	public static String getMetaModelPath(String project) {
		try {
			String path = getWorkspaceAbsolutePath() + '/' + project;

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = path + '/' + br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static HashSet<String> getExtensions() {
		HashSet<String> extensions = new HashSet<String>();
		try {
			String path = getWorkspaceAbsolutePath() + '/'
					+ ProjectUtils.getProject().getName();

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			br.readLine();
			String ext = null;
			while ((ext = br.readLine()) != null) {
				extensions.add(ext);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return extensions;
	}
	
	public static HashSet<String> getExtensions(Class<?> cls) {
		HashSet<String> extensions = new HashSet<String>();
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			int index = path.lastIndexOf("/bin");
			if (index == -1) {
				index = path.lastIndexOf("/");
			}
			path = path.substring(0, index);

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			br.readLine();
			String ext = null;
			while ((ext = br.readLine()) != null) {
				extensions.add(ext);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return extensions;
	}

	public static List<String> getModels() {
		List<String> modelpaths = null;
		try {
			String path = getWorkspaceAbsolutePath() + '/'
					+ ProjectUtils.getProject().getName();

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String modelName = br.readLine();
			File[] files = new File(path + '/' + modelName).listFiles();
			modelpaths = new ArrayList<String>();
			for (File file : files) {
				if (file.isFile() == true) {
					String modelpath = file.getPath();
					if (modelpath.endsWith(".model") == true) {
						modelpaths.add(modelpath);
					}
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelpaths;
	}

	public static List<String> getModels(Class<?> cls) {
		List<String> modelpaths = null;
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			int index = path.lastIndexOf("/bin");
			if (index == -1) {
				index = path.lastIndexOf("/");
			}
			path = path.substring(0, index);
			
			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String modelName = br.readLine();
			File[] files = new File(path + '/' + modelName).listFiles();
			modelpaths = new ArrayList<String>();
			for (File file : files) {
				if (file.isFile() == true) {
					String modelpath = file.getPath();
					if (modelpath.endsWith(".model") == true) {
						modelpaths.add(modelpath);
					}
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelpaths;
	}

	public static String getModelsFolder() {
		try {
			IProject project = ProjectUtils.getProject();
			String path = getWorkspaceAbsolutePath() + '/'
					+ project.getName();

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = getWorkspaceAbsolutePath() + '/' + project.getName()
				+ '/' + br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getModelsFolder(Class<?> cls) {
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			int index = path.lastIndexOf("/bin");
			if (index == -1) {
				index = path.lastIndexOf("/");
			}
			path = path.substring(0, index);

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = path
				+ '/' + br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getOutputPath() {
		IProject project = ProjectUtils.getProject();
		if (project != null) {
			wodelProject = project;
		}
		try {
			String path = getWorkspaceAbsolutePath() + "/" + wodelProject.getName();

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			String mutatorName = br.readLine();
			br.close();
			return getWorkspaceAbsolutePath() + '/' + wodelProject.getName() + "/" + mutatorName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getOutputPath(Class<?> cls) {
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			int index = path.lastIndexOf("/bin");
			if (index == -1) {
				index = path.lastIndexOf("/");
			}
			path = path.substring(0, index);

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			String mutantName = br.readLine();
			br.close();
			return path	+ '/' + mutantName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getOutputFolder() {
		try {
			String path = getWorkspaceAbsolutePath() + '/'
					+ ProjectUtils.getProject().getName();

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getMutatorName(Class<?> cls) {
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			int index = path.lastIndexOf("/bin");
			if (index == -1) {
				index = path.lastIndexOf("/");
			}
			path = path.substring(0, index);

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			br.readLine();
			String mutantName = br.readLine();
			br.close();
			return mutantName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getMutatorName() {
		try {
			String path = getWorkspaceAbsolutePath() + '/'
					+ ProjectUtils.getProject().getName();

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			br.readLine();
			br.readLine();
			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getModelName() {
		try {
			String path = getWorkspaceAbsolutePath() + '/'
					+ ProjectUtils.getProject().getName();

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getModelName(String project) {
		try {
			String path = getWorkspaceAbsolutePath() + '/'
					+ project;

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String getModelName(Class<?> cls) {
		try {
			String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
			int index = path.lastIndexOf("/bin");
			if (index == -1) {
				index = path.lastIndexOf("/");
			}
			path = path.substring(0, index);

			BufferedReader br = new BufferedReader(new FileReader(path
					+ "/data/config/config.txt"));

			String ret = br.readLine();
			br.close();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static ResourceSet initializeResource(String modelURI) {
		ResourceSet resourceSet = new ResourceSetImpl();

		int i = modelURI.lastIndexOf('.');
		if (i > 0) {
			String ext = modelURI.substring(i + 1);
			if (!resourceSet.getResourceFactoryRegistry()
					.getExtensionToFactoryMap().containsKey(ext)) {
				resourceSet.getResourceFactoryRegistry()
						.getExtensionToFactoryMap()
						.put(ext, new XMIResourceFactoryImpl());
			}
		}
		return resourceSet;
	}
	
	/**
	 * @param packages
	 *            MetaModel
	 * @param modelURI
	 *            URI of the Model
	 * @return Resource Loaded Model
	 * @throws
	 */
	public static Resource loadModelWithoutOptions(List<EPackage> packages,
			String modelURI) throws ModelNotFoundException {
		if (new File(modelURI).exists() == false) {
			throw new ModelNotFoundException(modelURI);
		}
		ResourceSet resourceSet = ModelManager.initializeResource(modelURI);
		URI uri = ModelManager.getModelWithFolder(modelURI);
		for (EPackage p : packages) {
			// Add packages to package registry
			if (!resourceSet.getPackageRegistry().containsKey(p.getNsURI()))
				resourceSet.getPackageRegistry().put(p.getNsURI(), p);
			// nested packages
		}
		Resource model = null;
		try {
			model = resourceSet.createResource(uri);
			model.load(null);
			// model = resourceSet.getResource(URI.createURI(modelURI),true); //
			// load model using the URI
		} catch (IOException r) {
			r.printStackTrace();
			throw new ModelNotFoundException(modelURI);
		}

		return model;
	}

	/**
	 * @param packages
	 *            MetaModel
	 * @param modelURI
	 *            URI of the Model
	 * @return Resource Loaded Model
	 * @throws
	 */
	public static Resource loadModel(List<EPackage> packages,
			String modelURI) throws ModelNotFoundException {
		if (new File(modelURI).exists() == false) {
			throw new ModelNotFoundException(modelURI);
		}
		ResourceSet resourceSet = ModelManager.initializeResource(modelURI);
		URI uri = ModelManager.getModelWithFolder(modelURI);
		for (EPackage p : packages) {
			// Add packages to package registry
			if (!resourceSet.getPackageRegistry().containsKey(p.getNsURI()))
				resourceSet.getPackageRegistry().put(p.getNsURI(), p);
			// nested packages
		}
		final Map<Object, Object> options = resourceSet.getLoadOptions();
		options.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
		options.put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.FALSE);
		options.put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, new HashMap<Object, Object>());
		options.put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.TRUE);
		options.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		Resource model = null;
		try {
			model = resourceSet.createResource(uri);
			model.load(options);
			// model = resourceSet.getResource(URI.createURI(modelURI),true); //
			// load model using the URI
		} catch (IOException r) {
			r.printStackTrace();
			throw new ModelNotFoundException(modelURI);
		}

		return model;
	}
	
	/**
	 * @param packages
	 *            MetaModel
	 * @param modelURI
	 *            URI of the Model
	 * @return Resource Loaded Model
	 * @throws
	 */
	public static List<Resource> loadModels(List<EPackage> packages,
			String path) throws ModelNotFoundException {
		List<Resource> models = new ArrayList<Resource>();
		File filePath = new File(path);
		for (File file : filePath.listFiles()) {
			if (file.getName().endsWith(".model")) {
				String modelURI = file.getPath();
				Resource model = loadModel(packages, modelURI);
				models.add(model);
			}
		}
		return models;
	}

	/**
	 * @param packages
	 *            MetaModel
	 * @param modelURI
	 *            URI of the Model
	 * @return Resource Loaded Model
	 * @throws
	 */
	public static Resource loadMetaModelAsResource(List<EPackage> packages,
			String modelURI) throws ModelNotFoundException {

		ResourceSet resourceSet = ModelManager.initializeResource(modelURI);
		URI uri = ModelManager.getModelWithFolder(modelURI);
		for (EPackage p : packages) {
			// Add packages to package registry
			if (!resourceSet.getPackageRegistry().containsKey(p.getNsURI()))
				resourceSet.getPackageRegistry().put(p.getNsURI(), p);
			// nested packages
		}
		final Map<Object, Object> options = resourceSet.getLoadOptions();
		options.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
		options.put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.FALSE);
		options.put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, new HashMap<Object, Object>());
		options.put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.TRUE);
		options.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		Resource model = null;
		try {
			model = resourceSet.createResource(uri);
			model.load(options);
			// model = resourceSet.getResource(URI.createURI(modelURI),true); //
			// load model using the URI
		} catch (IOException r) {
			throw new ModelNotFoundException(modelURI);
		}

		return model;
	}

	/**
	 * @param metamodel
	 *            : path of the MetaModel
	 * @return boolean True if the MetaModel is validated
	 * @throws MetaModelNotFoundException, ModelNotFoundException
	 */
	public static boolean validateMetaModel(String metamodel)
			throws MetaModelNotFoundException, ModelNotFoundException {
		
		List<EPackage> packages = loadMetaModel(metamodel);
		Resource rs = loadMetaModelAsResource(packages, metamodel);
		
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(rs.getContents().get(0));
		if (diagnostic.getSeverity() == Diagnostic.OK || diagnostic.getSeverity() == Diagnostic.WARNING || diagnostic.getSeverity() == Diagnostic.ERROR) {
			return true;
		}
		return false;
	}
	
	public static boolean validateModel(String metamodel, String model)
			throws MetaModelNotFoundException, ModelNotFoundException {
		
		List<EPackage> packages = loadMetaModel(metamodel);
		Resource rs = loadModel(packages, model);
		
		for (EObject eObject : rs.getContents()) {
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
			if (diagnostic.getSeverity() == Diagnostic.ERROR) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean validateModel(Resource model)
			throws MetaModelNotFoundException, ModelNotFoundException {
		for (EObject eObject : model.getContents()) {
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
			if (diagnostic.getSeverity() == Diagnostic.ERROR) {
				return false;
			}
		}
		return true;		
	}

	/**
	 * Checks whether a certain model exists or not
	 * 
	 * @return
	 */
	public static boolean checkModel(String model) {
		return true;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return ArrayList<EObject> All the objects except root
	 */
	public static ArrayList<EObject> getObjects(Resource model) {

		ArrayList<EObject> objs = new ArrayList<EObject>();

		Iterator<EObject> objects = model.getAllContents();

		while (objects.hasNext()) {
			EObject obj = objects.next();
			if (obj.eContainer() == null) {
				continue;
			} else {
				objs.add(obj);
			}
		}
		return objs;
	}

	/**
	 * @param type
	 *            Name of the wanted object
	 * @param model
	 *            Loaded Model
	 * @return ArrayList<EObject> All the classes or objects of the specified
	 *         type
	 */
	public static ArrayList<EObject> getObjectsOfType(String type,
			Resource model) {

		ArrayList<EObject> objs = new ArrayList<EObject>();
		for (EObject obj : model.getContents()) {
			List<EClass> types = new ArrayList<EClass>();
			types.add(obj.eClass());
			types.addAll(obj.eClass().getEAllSuperTypes());
			for (EClass t : types) { 
				if (type.equals(t.getName())) {
					objs.add(obj);
				}
			}
			
			Iterator<EObject> it = obj.eAllContents();

			while (it.hasNext()) {
				EObject object = it.next();
				// Check the type
				types = new ArrayList<EClass>();
				types.add(object.eClass());
				types.addAll(object.eClass().getEAllSuperTypes());
				for (EClass t : types) { 
					if (type.equals(t.getName())) {
						objs.add(object);
					}
				}
			}
		}
		return objs;
	}
	
	/**
	 * @param refName
	 *            Name of the reference to the target object
	 * @param source
	 *            Source object
	 * @return Object Refered object
	 */
	public static Object getReferredObject(String refName, EObject source) {

		for (EReference ref : source.eClass().getEAllReferences()) {
			if (ref.getName().equals(refName)) {
				//return ReferenceUtil.safeEGet(source, ref);
				return source.eGet(ref);
			}
		}
		return null;
	}

	/**
	 * @param refNames
	 *            Names of the references to the target object
	 * @param sources
	 *            Source candidate objects
	 * @param targets
	 *            Target referenced objects
	 * @return ArrayList<EObject> Refered objects
	 */
	public static ArrayList<EObject> getReferredObjects(List<String> refNames, List<EObject> sources, List<EObject> targets) {

		ArrayList<EObject> objs = new ArrayList<EObject>();
		for (EObject src : sources) {
			EObject refObject = src;
			for (String refName : refNames) {
				EObject currentObject = refObject;
				try {
					refObject = ModelManager.getReference(refName, currentObject);
				} catch (ReferenceNonExistingException e) {
					break;
				}
				if (refObject == null) {
					break;
				}
			}
			if (refObject != null) {
				for (EObject tar : targets) {
					if (EcoreUtil.equals(tar, refObject)) {
						boolean found = false;
						for (EObject obj : objs) {
							if (EcoreUtil.equals(obj, src)) {
								found = true;
								break;
							}
						}
						if (!found) {
							objs.add(src);
						}
					}
				}
			}
		}
		return objs;
	}

	/**
	 * @param type
	 *            Name of the type
	 * @param metaModel
	 *            Loaded MetaModel
	 * @return EObject Class or reference of the specified type
	 */
	public static EObject getObjectOfType(String type, List<EPackage> metaModel) {

		for (EPackage p : metaModel) {
			// For each classifier
			for (EClassifier c : p.getEClassifiers()) {
				// If we are looking for a Class, check its name
				if (c.getName().equals(type)) {
					return c;
				}
				// If we are looking for a Reference, check all references of
				// the classifier
				else {
					if (c instanceof EClass) {
						for (EReference r : ((EClass) c).getEAllReferences()) {
							if (r.getName().equals(type)) {
								return r;
							}
						}
					}
				}
			}
			if (p.getESubpackages() != null) {
				EObject object = getObjectOfType(type, p.getESubpackages());
				if (object != null) {
					return object;
				}
			}
		}

		return null;
	}
	
	/**
	 * @param uri
	 *            uri of the eClass
	 * @param metaModel
	 *            Loaded MetaModel
	 * @return EObject Class or reference of the specified type
	 */
	public static EObject getObjectOfURI(URI uri, List<EPackage> metaModel) {

		for (EPackage p : metaModel) {
			// For each classifier
			for (EClassifier c : p.getEClassifiers()) {
				// If we are looking for a Class, check its name
				if (EcoreUtil.getURI(c).equals(uri)) {
					return c;
				}
				// If we are looking for a Reference, check all references of
				// the classifier
				else {
					if (c instanceof EClass) {
						for (EReference r : ((EClass) c).getEAllReferences()) {
							if (EcoreUtil.getURI(r).equals(uri)) {
								return r;
							}
						}
					}
				}
			}
			if (p.getESubpackages() != null) {
				EObject object = getObjectOfURI(uri, p.getESubpackages());
				if (object != null) {
					return object;
				}
			}
		}

		return null;
	}

	/**
	 * @param metaModel
	 *            Loaded MetaModel
	 * @return EObject Classes
	 */
	public static ArrayList<EObject> getObjectFromMetamodel(
			List<EPackage> metaModel) {

		ArrayList<EObject> ret = new ArrayList<EObject>();

		for (EPackage p : metaModel) {
			// For each classifier
			for (EClassifier c : p.getEClassifiers()) {
				ret.add(c);
			}
			if (p.getESubpackages() != null) {
				ret.addAll(getObjectFromMetamodel(p.getESubpackages()));
			}
		}

		return ret;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return ArrayList<EObject> All the classes or objects
	 */
	public static ArrayList<EObject> getAllObjects(Resource model) {

		ArrayList<EObject> objs = new ArrayList<EObject>();

		for (EObject obj : model.getContents()) {
			objs.add(obj);
			
			Iterator<EObject> it = obj.eAllContents();

			while (it.hasNext()) {
				EObject object = it.next();
				objs.add(object);
			}
		}
		return objs;
	}
	
		
	/**
	 * @param metamodel
	 *            Loaded Metamodel
	 * @return ArrayList<EObject> All the classes or objects
	 */
	public static ArrayList<EObject> getAllObjects(List<EPackage> metamodel) {

		ArrayList<EObject> objs = new ArrayList<EObject>();

		for (EPackage p : metamodel) {
			EList<EObject> objects = p.eContents();

			for (EObject object : objects) {
				objs.add(object);
			}
			if (p.getESubpackages() != null) {
				objs.addAll(getAllObjects(p.getESubpackages()));
			}
		}
		return objs;
	}
	
	/**
	 * @param packages
	 *            Loaded Metamodel
	 * @param model
	 *            Loaded Model
	 * @param containing
	 *            Name of the containing Class
	 * @return Parents
	 */
	public static ArrayList<EObject> getParentObjects(List<EPackage> packages, Resource model,
			String containing) {

		ArrayList<EObject> mmobjs = new ArrayList<EObject>();
		ArrayList<EObject> mmparents = new ArrayList<EObject>();
		ArrayList<EObject> parents = new ArrayList<EObject>();
		EObject obj = getObjectOfType(containing, packages);

		if ((containing.equals("EAttribute")
				|| containing.equals("EReference")
				|| containing.equals("EStructuralFeature"))) {
			mmobjs.add(getObjectOfType("EClass", packages));
		}
		else {
			mmobjs = getAllObjects(packages);

		}

		for (EObject mmo : mmobjs) {
			// We search inside the object
			for (EObject mmcont : mmo.eContents()) {
				if (mmcont.eClass().getName().equals(containing)) {
					mmparents.add(mmo);
					break;
				}
				if (mmcont instanceof EReference) {
					EReference ref = (EReference) mmcont;
					ArrayList<EClass> classes = new ArrayList<EClass>();
					classes.add((EClass) obj);
					classes.addAll(((EClass) obj).getEAllSuperTypes());
					for (EClass c : classes) {
						if (ref.getEType().getName().equals(c.getName()) && (ref.isContainment() == true)) {
							mmparents.add(mmo);
							break;
						}
					}
				}
			}
		}

		for (EObject mmp : mmparents) {
			parents.addAll(getObjectsOfType(((EClass) mmp).getName(), model));
		}
		if (parents.size() == 0) {
			parents.add(getRoot(model));
		}

		return parents;

	}

	/**
	 * @param model
	 *            Loaded Model
	 * @param containing
	 *            Name of the containing Class
	 * @return Parents
	 */
	public static EObject getContainer(Resource model, EObject object) {

		ArrayList<EObject> objs = new ArrayList<EObject>();
		EObject parent = null;
		objs = getAllObjects(model);

		for (EObject obj : objs) {
			// We search inside the object
			for (EObject cont : obj.eContents()) {
				if (EcoreUtil.getURI(cont).equals(EcoreUtil.getURI(object))) {
					parent = obj;
					break;
				}
			}
			if (parent != null) {
				break;
			}
		}

		return parent;

	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @param containment
	 *            Name of the containment Class
	 * @return Containers
	 */
	public static List<EClass> getContainersList(List<EPackage> packages,
			URI uri, EClass rootClass, Map<EClass, Boolean> map) {

		List<EClass> containers = new ArrayList<EClass>();
		List<EClassifier> classifiers = getContainerTypes(packages, uri);
		if (classifiers.size() > 0) {
			for (EClassifier classifier : classifiers) {
				EClass eClass = (EClass) classifier;
				if (!map.get(eClass)) {
					map.put(eClass, true);
					containers.add(eClass);
					List<EClass> result = getContainersList(packages, EcoreUtil.getURI(eClass), rootClass, map);
					if (result != null) {
						for (EClass ec : result) {
							map.put(ec, true);
							if (!containers.contains(ec)) {
								containers.add(ec);
							}
						}
					}
					if (containers.contains(rootClass)) {
						break;
					}
				}
			}
		}
		return containers;

	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @param containment
	 *            Name of the containment Class
	 * @return Containers
	 */
	public static ArrayList<EObject> getContainerObjects(Resource model,
			String containment) {

		ArrayList<EObject> objs = new ArrayList<EObject>();
		ArrayList<EObject> containers = new ArrayList<EObject>();

		objs = getAllObjects(model);

		for (EObject o : objs) {
			// We search the references inside the objects
			for (EObject cont : o.eContents()) {
				if (cont instanceof EReference) {
					EReference ref = (EReference) cont;
					if (ref.getEType().getName().equals(containment)) {
						containers.add(o);
						containers.addAll(getContainerObjects(model, ((EClass) o).getName()));
					}
				}
			}
		}

		return containers;

	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @param container
	 *            Container object
	 * @return Containers
	 */
	public static EObject getContainerObject(Resource model,
			EObject object) {
		
		ArrayList<EObject> objs = getAllObjects(model);
		ArrayList<EClass> types = new ArrayList<EClass>();
		types.add(object.eClass());
		types.addAll(object.eClass().getEAllSuperTypes());
		for (EObject obj : objs) {
			for (EReference ref : obj.eClass().getEAllReferences()) {
				if (ref.isContainment()) {
					for (EClass type : types) {
						if (EcoreUtil.equals(ref.getEReferenceType(), type)) {
							return obj;
						}
					}
				}
			}
		}

		return null;

	}

	/**
	 * @param model
	 *            Loaded Model
	 * @param container
	 *            Container object
	 * @return Containers
	 */
	public static EObject getContainerObject(EObject container,
			EObject object) {
		ArrayList<EClass> types = new ArrayList<EClass>();
		types.add(object.eClass());
		types.addAll(object.eClass().getEAllSuperTypes());

		for (EReference ref : container.eClass().getEAllReferences()) {
			if (ref.isContainment()) {
				for (EClass type : types) {
					if (EcoreUtil.equals(ref.getEReferenceType(), type)) {
						return container;
					}
					else {
						if (container.eGet(ref) != null) {
							EObject nextContainer = null;
							if (container.eGet(ref) instanceof List<?>) {
								List<EObject> list = (List<EObject>) container.eGet(ref);
								if (list.size() > 0) {
									nextContainer = list.get(0);
								}
							}
							else {
								nextContainer = (EObject) container.eGet(ref);
							}
							if (nextContainer != null) {
								EObject ret = getContainerObject(nextContainer, object);
								if (ret != null) {
									return ret;
								}
							}
						}
					}
				}
			}
		}

		return null;

	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return Root object
	 */
	public static EObject getRoot(Resource model) {
		Iterator<EObject> objects = model.getAllContents();

		if (objects.hasNext()) {
			EObject obj = objects.next();
			return obj;
		}
		return null;
	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getObject(Resource model, EObject eobj) {
		ArrayList<EObject> objs = getAllObjects(model);

		for (EObject obj : objs) {
			if (EcoreUtil.equals(eobj, obj)) {
				return obj;
			}
		}
		return null;
	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getObjectByID(Resource model, String identification) {
		List<EObject> objs = getAllObjects(model);

		for (EObject obj : objs) {
			if (EcoreUtil.getIdentification(obj).equals(identification)) {
				return obj;
			}
		}
		return null;
	}
	
	private static String getURIToFind(String objectURI) {
		String uriToFind = "";
		int index = objectURI.indexOf(".");
		String tmpURIToFind = objectURI.substring(objectURI.indexOf("/@") + 1, objectURI.length());
//		int k = 0;
		while (index >= 0) {
			String featureURI = tmpURIToFind.substring(1, tmpURIToFind.indexOf("."));
			int value = 0;
			String newFeatureURI = "";
			if (tmpURIToFind.indexOf("/") >= 0 && tmpURIToFind.indexOf(".") >= 0 && tmpURIToFind.indexOf("/") > tmpURIToFind.indexOf(".")) {
				String str = tmpURIToFind.substring(tmpURIToFind.indexOf(".") + 1, tmpURIToFind.indexOf("/"));
				if (!JavaUtils.isNumeric(str)) {
					break;
				}
				value = Integer.valueOf(str);
				newFeatureURI = featureURI + "." + String.format("%d", value);
			}
			else {
				newFeatureURI = featureURI;
			}
//			if (tmpURIToFind.indexOf("/@") < 0 && k != 0) {
//				value = value - 1;
//			}
//			k++;
			uriToFind += "/@" + newFeatureURI;
			if (tmpURIToFind.indexOf("/@") < 0) {
				break;
			}
			tmpURIToFind = tmpURIToFind.substring(tmpURIToFind.indexOf("/@") + 1, tmpURIToFind.length());
			index = tmpURIToFind.indexOf(".");
		}
		if (uriToFind.isEmpty()) {
			uriToFind = objectURI;
		}
		return uriToFind;
	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getObjectByPartialID(Resource model, String identification) {
		List<EObject> objs = getAllObjects(model);

		String objectType = identification.substring(identification.indexOf("#"), identification.indexOf("@"));
		String objectURI = identification.substring(identification.lastIndexOf("#/") + 2, identification.indexOf("}"));
		String uriToFind = getURIToFind(objectURI);
		//String partialID = identification.substring(identification.indexOf("#"), identification.indexOf("{"));
		for (EObject obj : objs) {
			String objID = EcoreUtil.getIdentification(obj);
			String objType = objID.substring(objID.indexOf("#"), objID.indexOf("@"));
			String objURI = objID.substring(objID.lastIndexOf("#/") + 2, objID.indexOf("}"));
			if (objURI.equals(uriToFind) && objType.equals(objectType)) {
				return obj;
			}
			//partialObjID = partialObjID.substring(partialObjID.indexOf("#"), partialObjID.indexOf("{"));
			//if (partialID.equals(partialObjID)) {
			//	return obj;
			//}
		}
		return null;
	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getObjectByURI(Resource model, URI uri) {
		ArrayList<EObject> objs = getAllObjects(model);

		for (EObject obj : objs) {
			if (EcoreUtil.getURI(obj).equals(uri)) {
				return obj;
			}
		}
		return null;
	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getObjectByURIEnding(Resource model, URI uri) {
		List<EObject> objs = getAllObjects(model);

		String partialURI = uri.toString();
		partialURI = partialURI.substring(partialURI.indexOf("#"), partialURI.length());
		for (EObject obj : objs) {
			String partialObjURI = EcoreUtil.getURI(obj).toString();
			partialObjURI = partialObjURI.substring(partialObjURI.indexOf("#"), partialObjURI.length());
			if (partialURI.equals(partialObjURI)) {
				return obj;
			}
		}
		return null;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EObject getObjectByName(Resource model, EObject object) {
		List<EObject> objs = getAllObjects(model);
		
		EStructuralFeature nameFeature = null;
		for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
			if (feature.getName().toLowerCase().equals("name")) {
				nameFeature = feature;
				break;
			}
		}
		if (nameFeature == null) {
			return null;
		}
		Object ob = object.eGet(nameFeature);
		if (ob == null) {
			return null;
		}
		String name = null;
		if (ob instanceof String) {
			name = (String) ob;
		}
		if (name == null) {
			return null;
		}
		for (EObject obj : objs) {
			if (EcoreUtil.equals(obj.eClass(), object.eClass())) {
				ob = obj.eGet(nameFeature);
				if (ob == null) {
					continue;
				}
				String currentName = null;
				if (ob instanceof String) {
					currentName = (String) ob;
				}
				if (currentName == null) {
					continue;
				}
				if (name.equals(currentName)) {
					return obj;
				}
			}
		}
		return null;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static List<EObject> getObjects(Resource model, List<EObject> objects) {
		List<EObject> objs = new ArrayList<EObject>();
		
		for (EObject obj : objects) {
			EObject ob = getObject(model, obj);
			if (ob == null) {
				 ob = getObjectByURI(model, EcoreUtil.getURI(obj));
			}
			if (ob == null) {
				 ob = getObjectByURIEnding(model, EcoreUtil.getURI(obj));
			}
			if (ob == null) {
				 ob = getObjectByID(model, EcoreUtil.getIdentification(obj));
			}
			if (ob == null) {
				 ob = getObjectByPartialID(model, EcoreUtil.getIdentification(obj));
			}
			if (ob != null) {
				objs.add(ob);
			}
		}
		return objs;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static EReference getReference(Resource model, EReference eref) {
		ArrayList<EReference> refs = getAllReferences(model);

		for (EReference ref : refs) {
			if (EcoreUtil.equals(eref, ref)) {
				return ref;
			}
		}
		return null;
	}
	
	/**
	 * @param model
	 *            Loaded Model
	 * @return EObject
	 */
	public static List<EReference> getContainmentReferencesOfType(List<EPackage> packages, EObject container, EObject obj) {
		
		List<EReference> refs = new ArrayList<EReference>();
		List<EClass> superTypes = new ArrayList<EClass>();
		superTypes.add(obj.eClass());
		superTypes.addAll(obj.eClass().getEAllSuperTypes());
		for (EReference ref : container.eClass().getEAllReferences()) {
			if (ref.isContainment()) {
				List<EClass> subTypes = new ArrayList<EClass>();
				subTypes.add(ref.getEReferenceType());
				subTypes.addAll(getESubClasses(packages, ref.getEReferenceType()));
				for (EClass subType : subTypes) {
					for (EClass superType : superTypes) {
						if (EcoreUtil.equals(subType, superType)) {
							if (!refs.contains(ref)) refs.add(ref);
						}
					}
				}
			}
		}
		return refs;
	}

	/**
	 * @param object
	 *            Object one wants to explore
	 * @return EList<EAttribute> Attributes of the object
	 */
	public static EList<EAttribute> getAttributes(EObject object) {

		EClass tipo = object.eClass();

		return tipo.getEAllAttributes();
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @return List<String> Values of the attribute named by -att-
	 */
	public static List<String> getListStringAttribute(String att, EObject object) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				return (List<String>) object.eGet(sf, true);
			}
		}
		return null;
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @return String Value of the attribute named by -att-
	 */
	public static String getStringAttribute(String att, EObject object) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				return (String) object.eGet(sf, true);
			}
		}
		return null;
	}
	
	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @return String Value of the attribute named by -att-
	 */
	public static List<String> getStringListAttribute(String att, EObject object) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				return (List<String>) object.eGet(sf, true);
			}
		}
		return null;
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @throws WrongAttributeTypeException
	 */
	public static boolean hasAttribute(String att, EObject object) {
		if (object != null) {
			EClass tipo = object.eClass();

			for (EStructuralFeature sf : tipo.getEAllAttributes()) {
				if (sf != null) {
					if (sf.getName().equals(att)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @throws WrongAttributeTypeException
	 */
	public static Object getAttribute(String att, EObject object) {
		if (object != null) {
			EClass tipo = object.eClass();

			for (EStructuralFeature sf : tipo.getEAllAttributes()) {
				if (sf != null) {
					if (sf.getName().equals(att)) {
						return object.eGet(sf);
					}
				}
			}
		}
		return null;
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @param acs
	 *            Value of the new attribute
	 * @throws WrongAttributeTypeException
	 */
	public static void setAttribute(String att, EObject object,
			AttributeConfigurationStrategy acs)
			throws WrongAttributeTypeException {
		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf != null) {
				if (sf.getName().equals(att)) {
					Object value = acs.getValue(object);
					if (sf.getEType() instanceof EEnum && value.getClass().getSimpleName().toLowerCase().equals("string")) {
						EList<EEnumLiteral> literals = ((EEnum) sf.getEType()).getELiterals();
						for (EEnumLiteral lit : literals) {
							if (lit.getLiteral().equals((String) value)) {
								object.eSet(sf, lit.getInstance());
								break;
							}
						}
					}
					else {
						if (acs.sameType(sf.getEType())) {
							object.eSet(sf, acs.getValue(object));
						} else {
							throw new WrongAttributeTypeException("The attribute '"
									+ att + "' is not of the type '"
									+ acs.getValue().getClass().getSimpleName()
									+ "'");
						}
					}
				}
			}
		}
	}

	/**
	 * @throws ReferenceNonExistingException
	 */
	public static EObject getReference(String ref, EObject object) throws
		ReferenceNonExistingException {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllReferences()) {
			if (sf != null) {
				if (sf.getName().equals(ref)) {
					return (EObject) object.eGet(sf);
				}
			}
		}
		return null;
	}

	/**
	 * @throws ReferenceNonExistingException
	 */
	public static Object getReferenced(String ref, EObject object) throws
		ReferenceNonExistingException {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllReferences()) {
			if (sf != null) {
				if (sf.getName().equals(ref)) {
					return object.eGet(sf);
				}
			}
		}
		return null;
	}
	
	/**
	 * @throws ReferenceNonExistingException
	 */
	public static List<EObject> getReferences(String ref, EObject object) throws
		ReferenceNonExistingException {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllReferences()) {
			if (sf != null) {
				if (sf.getName().equals(ref)) {
					return (List<EObject>) object.eGet(sf);
				}
			}
		}
		return null;
	}

	public static void setReference(String ref, EObject object,
			EObject newObject) throws WrongAttributeTypeException,
			ReferenceNonExistingException {

		EClass tipo = object.eClass();
		EObject tarObj = newObject;

		for (EStructuralFeature sf : tipo.getEAllReferences()) {
			if (sf != null) {
				if (sf.getName().equals(ref)) {
					if (tarObj != null) {
						boolean b = false;
						for (EStructuralFeature sfTar : tarObj.eClass()
								.getEAllReferences()) {
							if (sfTar != null) {
								Object ob = tarObj.eGet(sfTar);
								if (ob instanceof EObject) {
									EObject value = (EObject) ob;
									if (EcoreUtil.getURI(value.eClass()).equals(EcoreUtil.getURI(sf.getEType())) && sf.isChangeable()) {
										object.eSet(sf, value);
										b = true;
										break;
									}
								}
//								if (sfTar.getName().equals(ref) && sf.isChangeable()) {
//								}
							}
						}
						if (b == false) {
							try {
								if (((EClass) sf.getEType()).isSuperTypeOf(tarObj.eClass()) && sf.isChangeable()) {
									if (object.eGet(sf) instanceof List<?>) {
										List<EObject> objects = (List<EObject>) object.eGet(sf);
										objects.add(tarObj);
									}
									else {
										object.eSet(sf, tarObj);
									}
								}
							} catch (ClassCastException ex) {
								throw new WrongAttributeTypeException(
										"The reference '"
												+ ref
												+ "' is not of the type '"
												+ tarObj.eClass().getName() + "'");
							}
						}
					} else {
						throw new ReferenceNonExistingException(
								"There is no object for the reference '" + ref
										+ "'");

					}
					// object.eSet(sf, tarObj);
				}
			}
		}
	}

	
	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @param acs
	 *            Value of the new attribute
	 * @throws WrongAttributeTypeException
	 * @throws ReferenceNonExistingException
	 */
	public static void setReference(String ref, EObject object,
			ObSelectionStrategy oss) throws WrongAttributeTypeException,
			ReferenceNonExistingException {

		EClass tipo = object.eClass();
		if (oss == null) {
			unsetReference(ref, object);
			return;
		}
		EObject tarObj = oss.getObject();
		// EClass tipo = tarObj.eClass();

		if (tarObj != null) {
			for (EStructuralFeature sf : tipo.getEAllReferences()) {
				if (sf != null) {
					if (sf.getName().equals(ref)) {
						if (tarObj != null) {
							boolean b = false;
							for (EStructuralFeature sfTar : tarObj.eClass()
									.getEAllReferences()) {
								if (sfTar != null) {
									if (sfTar.getName().equals(ref)) {
										object.eSet(sf, tarObj.eGet(sfTar));
										b = true;
										break;
									}
								}
							}
							if (b == false) {
								try {
									if (((EClass) sf.getEType()).isSuperTypeOf(tarObj.eClass()) && sf.isChangeable()) {
										if (sf.getUpperBound() == 1) {
											object.eSet(sf, tarObj);
										}
										else {
											List<EObject> objects = (List<EObject>) object.eGet(sf);
											objects.add(tarObj);
										}
									}
								} catch (ClassCastException ex) {
									throw new WrongAttributeTypeException(
											"The reference '"
													+ ref
													+ "' is not of the type '"
													+ tarObj.getClass()
															.getSimpleName() + "'");
								}
							}
						} else {
							throw new ReferenceNonExistingException(
									"There is no object for the reference '" + ref
											+ "'");
						}
					}
				}
			}
			return;
		}
		List<EObject> tarObjs =  oss.getObjects();
		if (tarObjs != null) {
			for (EStructuralFeature sf : tipo.getEAllReferences()) {
				if (sf != null) {
					if (sf.getName().equals(ref)) {
						List<EObject> objects = (List<EObject>) object.eGet(sf);
						objects.addAll(tarObjs);
					}
				}
			}
			return;
		}
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @param acs
	 *            Value of the new attribute
	 * @throws WrongAttributeTypeException
	 * @throws ReferenceNonExistingException
	 */
	public static void setReference(String ref, EObject object,
			ReferenceConfigurationStrategy rcs)
			throws WrongAttributeTypeException, ReferenceNonExistingException {
		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllReferences()) {
			if (sf != null) {
				if (sf.getName().equals(ref)) {
					if (rcs.sameType()) {
						if (sf.isChangeable()) {
							if (rcs.getValue(object) instanceof List<?>) {
								List<EObject> o = (List<EObject>) object.eGet(sf, true);
								o.addAll((List<EObject>) rcs.getValue(object));
							}
							if (rcs.getValue(object) instanceof EObject) {
								object.eSet(sf, rcs.getValue(object));
							}
						}
					} else {
						if (rcs.getValue(object) != null) {
							throw new WrongAttributeTypeException("The reference '"
									+ ref
									+ "' is not of the type "
									+ "'" + rcs.getValue(object).getClass().getSimpleName() + "'");
						}
					}
				}
			}
		}
	}
	
	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 */
	public static void unsetAttribute(String att, EObject object) {
		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				object.eUnset(sf);
			}
		}
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 */
	public static void unsetReference(String ref, EObject object) {
		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllReferences()) {
			if (sf.getName().equals(ref)) {
				object.eUnset(sf);
			}
		}
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @param newValue
	 *            Value of the new attribute
	 */
	public static void setStringAttribute(String att, EObject object,
			String newValue) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				object.eSet(sf, newValue);
			}
		}
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @param newValue
	 *            Value of the new attribute
	 */
	public static void setIntAttribute(String att, EObject object,
			int newValue) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				object.eSet(sf, newValue);
			}
		}
	}
	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @return Integer Value of the attribute named by -att-
	 */
	public static Integer getIntAttribute(String att, EObject object) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				return (Integer) object.eGet(sf, true);
			}
		}
		return null;
	}
	
	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @param newValue
	 *            Value of the new attribute
	 */
	public static void setEEnumAttribute(String att, EObject object,
			EEnum eenum, int newValue) {

		if (newValue < 0) {
			newValue = -newValue;
		}

		EClass tipo = object.eClass();
		
		EEnumLiteral literal = eenum.getELiterals().get(newValue % eenum.getELiterals().size());

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				object.eSet(sf, literal);
			}
		}
	}
	
	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @return Integer Value of the attribute named by -att-
	 */
	public static Object getEEnumAttribute(String att, EObject object) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				return object.eGet(sf, true);
			}
		}
		return null;
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @param newValue
	 *            Value of the new attribute
	 */
	public static void setDoubleAttribute(String att, EObject object,
			double newValue) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				object.eSet(sf, newValue);
			}
		}
	}
	
	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @return Double Value of the attribute named by -att-
	 */
	public static Double getDoubleAttribute(String att, EObject object) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				return (Double) object.eGet(sf, true);
			}
		}
		return null;
	}
	
	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @param newValue
	 *            Value of the new attribute
	 */
	public static void setBooleanAttribute(String att, EObject object,
			boolean newValue) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				object.eSet(sf, newValue);
			}
		}
	}

	/**
	 * @param att
	 *            Name of the attribute
	 * @param object
	 *            Object one wants to explore
	 * @return Boolean Value of the attribute named by -att-
	 */
	public static Boolean getBooleanAttribute(String att, EObject object) {

		EClass tipo = object.eClass();

		for (EStructuralFeature sf : tipo.getEAllAttributes()) {
			if (sf.getName().equals(att)) {
				return (Boolean) object.eGet(sf, true);
			}
		}
		return null;
	}

	/**
	 * @param object
	 *            Object one wants to explore
	 * @return List<EReference> References of the object
	 */
	public static List<EReference> getReferences(EObject object) {

		EClass tipo = object.eClass();

		return tipo.getEAllReferences();
	}

	/**
	 * @param container
	 *            Container object
	 * @param containing
	 *            Name of the containing Object
	 * @return References that contains the containing object
	 * @throws ReferenceNonExistingException
	 */
 	public static ArrayList<EReference> getContainingReferences(
			List<EPackage> metaModel, EObject container, String containing)
			throws ReferenceNonExistingException {
		ArrayList<EReference> contRefs = new ArrayList<EReference>();
		List<EReference> refs = getReferences(container);
		EClass obj = (EClass) getObjectOfType(containing, metaModel);

		for (EReference r : refs) {
			if (r.isChangeable()) {
				if (r.getEType().getName().equals(containing)) {
					if (!contRefs.contains(r)) {
						contRefs.add(r);
					}
				}
				for (EClass c : obj.getEAllSuperTypes()) {
					if (c.getName().equals(r.getEType().getName())) {
						if (!contRefs.contains(r)) {
							contRefs.add(r);
						}
					}
				}
			}
		}

		return contRefs;
	}
 	
 	public static EReference getContainingReference(EClass container, EClass containing)
			throws ReferenceNonExistingException {
		EReference contRef = null;
		List<EReference> refs = container.getEAllReferences();

		for (EReference r : refs) {
			if (r.isChangeable()) {
				if (r.getEType().getName().equals(containing.getName())
						|| containing.getEAllSuperTypes().contains(r.getEType())) {
					contRef = r;
					break;
				}
			}
		}

		return contRef;
	}

	/**
	 * @param name
	 *            Name of the reference
	 * @param model
	 *            Loaded Model
	 * @return ArrayList<EStructuralFeature> Specified references of the model
	 */
	public static ArrayList<EStructuralFeature> getAllReferencesByName(
			String name, Resource model) {
		ArrayList<EStructuralFeature> ret = new ArrayList<EStructuralFeature>();
		Iterator<EObject> objetos = model.getAllContents();
		EStructuralFeature sf = null;
		while (objetos.hasNext()) {
			EObject objeto = objetos.next();
			if ((sf = getReferenceByName(name, objeto)) != null)
				ret.add(sf);
		}
		return ret;
	}

	/**
	 * @param model
	 *            Loaded Model
	 * @return ArrayList<EStructuralFeature> References of the model
	 */
	public static ArrayList<EReference> getAllReferences(Resource model) {
		ArrayList<EReference> ret = new ArrayList<EReference>();
		Iterator<EObject> objetos = model.getAllContents();
		while (objetos.hasNext()) {
			EObject objeto = objetos.next();
			List<EReference> refs = getReferences(objeto);
			for (EReference r : refs) {
				if (!ret.contains(r)) {
					ret.add(r);
				}
			}
		}
		return ret;
	}

	/**
	 * @param source
	 *            Source object
	 * @param target
	 *            Target object
	 * @return EReference Specified reference
	 */
	public static EReference getReferenceBetweenObjects(EObject source,
			EObject target) {
		List<EReference> refs = source.eClass().getEAllReferences();

		for (EReference r : refs) {
			if (r.getUpperBound() == 1) {
				if (source.eGet(r, true) != null) {
					if (source.eGet(r, true).equals(target))
						return r;
				}
			} else {
				if (source.eGet(r, true) != null) {
					for (EObject aux : (List<EObject>) source.eGet(r, true)) {
						if (aux != null && target.equals(aux)) {
							return r;
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * @param name
	 *            Name of the reference
	 * @param object
	 *            Object one wants to explore
	 * @return EStructuralFeature Specified reference
	 */
	public static EStructuralFeature getReferenceByName(String name,
			EObject object) {
		EStructuralFeature sf = null;

		List<EReference> refs = getReferences(object);

		for (EStructuralFeature sf2 : refs) {
			if (sf2.getName().equals(name)) {
				sf = sf2;
			}
		}
		return sf;
	}
	
	/**
	 * @param name
	 *            Name of the reference
	 * @param object
	 *            Object one wants to explore
	 * @return EStructuralFeature Specified reference
	 */
	public static EReference getReferenceByURI(URI uri,
			EClass eClass) {
		List<EReference> refs = eClass.getEAllReferences();
		
		EReference ret = null;

		for (EReference ref : refs) {
			if (EcoreUtil.getURI(ref).equals(uri)) {
				ret = ref;
				break;
			}
		}
		return ret;
	}

	/**
	 * @param name
	 *            Name of the reference
	 * @param object
	 *            Object one wants to explore
	 * @return EStructuralFeature Specified reference
	 */
	public static EStructuralFeature getAttributeByName(String name,
			EObject object) {
		EStructuralFeature sf = null;

		List<EAttribute> atts = getAttributes(object);

		for (EStructuralFeature sf2 : atts) {
			if (sf2.getName().equals(name)) {
				sf = sf2;
			}
		}
		return sf;
	}

	/**
	 * @param model
	 *            Model one wants to output
	 * @param outputURI
	 *            URI of the new created Model
	 */
	public static void saveModel(Resource model, String outputURI) {
		ResourceSet rs = new ResourceSetImpl();
		ResourceSet rs2 = new ResourceSetImpl();
		rs2.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new XMLResourceFactoryImpl());
		Resource resource = rs.createResource(URI.createURI(outputURI));
		resource.getContents().addAll(model.getContents());
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		try {
			resource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param model
	 *            Model one wants to output
	 * @param outputURI
	 *            URI of the new created Model
	 */
	public static Resource createModel(String outputURI) {
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new XMLResourceFactoryImpl());
		URI uri = URI.createFileURI(outputURI);
		Resource resource = rs.createResource(uri);
		return resource;
	}

	/**
	 * @param model
	 *            Model one wants to output
	 * @param outputURI
	 *            URI of the new created Model
	 */
	public static void createModel(EObject eobj, String outputURI) {
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new XMLResourceFactoryImpl());
		URI uri = URI.createFileURI(outputURI);
		Resource resource = rs.createResource(uri);
		Map<Object, Object> saveOptions = ((XMLResource) resource)
				.getDefaultSaveOptions();
		saveOptions.put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_USE_CACHED_LOOKUP_TABLE,	new ArrayList<Object>());
		saveOptions.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, "DISCARD");
		resource.getContents().add(eobj);
		try {
			resource.save(saveOptions);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * @param model
	 *            Model one wants to output
	 * @param outputURI
	 *            URI of the new created Model
	 */
	public static Resource createAndLoadModel(EObject eobj, String outputURI) {
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new XMLResourceFactoryImpl());
		URI uri = URI.createFileURI(outputURI);
		Resource resource = rs.createResource(uri);
		Map<Object, Object> saveOptions = ((XMLResource) resource)
				.getDefaultSaveOptions();
		saveOptions.put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_USE_CACHED_LOOKUP_TABLE,
				new ArrayList<Object>());
		resource.getContents().add(eobj);
		try {
			resource.save(saveOptions);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return resource;
	}

	/**
	 * @param model
	 *            Model one wants to clone
	 * @param outputURI
	 *            URI of the new created Model
	 */
	public static Resource cloneModel(Resource model, String outputURI) {
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new XMLResourceFactoryImpl());
		URI uri = URI.createFileURI(outputURI);
		Resource resource = rs.createResource(uri);
//		EMFCopier.copy(model, resource);
		List<EObject> clonedModel = EMFCopier.copy(model);
		resource.getContents().addAll(clonedModel);
		return resource;
	}
	
	/**
	 * @param l
	 *            List in order to get the size and index
	 * @return Random number
	 */
	public static int getRandomIndex(List<?> l) {
		if (l.size() <= 1)
			return 0;

		int index = rn.nextInt() % l.size();
		if (index < 0)
			index = index * -1;

		return index;
	}

	public static void saveOutModel(Resource model, String outputURI) {
		URI uri = model.getURI();
		model.setURI(URI.createFileURI(outputURI));
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, "DISCARD");
		try {
			model.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			model.setURI(uri);
		}
	}

	// ESTHER -----------------------------

	/**
	 * It returns the types that declare some containment reference to the received type.
	 * 
	 * @param List
	 *            <EPackage> metaModel
	 * @param String
	 *            type
	 */
	public static List<EClassifier> getContainerTypes(List<EPackage> metaModel, URI uri) {
		List<EClassifier> classifiers = new ArrayList<EClassifier>();
		EObject object = getObjectOfURI(uri, metaModel);
		if (object instanceof EClass) {
			EClass classifier = (EClass) object;
			if (classifier != null) {
				for (EPackage p : metaModel) {
					for (EClassifier c : p.getEClassifiers()) {
						if (c instanceof EClass) {
							for (EReference r : ((EClass) c).getEAllReferences()) {
								if (r.isContainment()) { // only containment
									// relations!
									if (r.getEReferenceType().isSuperTypeOf(
											classifier)
											&& !classifiers.contains(c)) {
										classifiers.add(c);
										break;
									}
								}
							}
						}

					}
					for (EPackage sp : p.getESubpackages()) {
						List<EPackage> packages = new ArrayList<EPackage>();
						packages.add(sp);
						List<EClassifier> containerTypes = getContainerTypes(packages, uri);
						for (EClassifier containerType : containerTypes) {
							if (!classifiers.contains(containerType)) {
								classifiers.add(containerType);
							}
						}
					}
				}
			}
		}
		return classifiers;
	}
	
	/**
	 * It returns the types that declare some reference to the received type.
	 * 
	 * @param List
	 *            <EPackage> metaModel
	 * @param String
	 *            type
	 */
	public static List<EClassifier> getReferringTypes(List<EPackage> metaModel, URI uri) {
		List<EClassifier> classifiers = new ArrayList<EClassifier>();
		EObject object = getObjectOfURI(uri, metaModel);
		if (object instanceof EClass) {
			EClass classifier = (EClass) object;
			if (classifier != null) {
				for (EPackage p : metaModel) {
					for (EClassifier c : p.getEClassifiers()) {
						if (c instanceof EClass) {
							for (EReference r : ((EClass) c).getEAllReferences()) {
								// relations!
								if (r.getEReferenceType().isSuperTypeOf(
										classifier)
										&& !classifiers.contains(c)) {
									classifiers.add(c);
									break;
								}
							}
						}
					}
					for (EPackage sp : p.getESubpackages()) {
						List<EPackage> packages = new ArrayList<EPackage>();
						packages.add(sp);
						List<EClassifier> containerTypes = getContainerTypes(packages, uri);
						for (EClassifier containerType : containerTypes) {
							if (!classifiers.contains(containerType)) {
								classifiers.add(containerType);
							}
						}
					}
				}
			}
		}
		return classifiers;
	}

	/**
	 * It returns the containment referenced types for the given type
	 * 
	 * @param List
	 *            <EPackage> metaModel
	 * @param String
	 *            type
	 */
	public static List<EClass> getContainmentTypes(List<EPackage> metaModel, URI uri) {
		List<EClass> classifiers = new ArrayList<EClass>();
		EObject object = getObjectOfURI(uri, metaModel);
		if (object instanceof EClass) {
			EClass classifier = (EClass) object;
			if (classifier != null) {
				for (EReference r : classifier.getEAllReferences()) {
					if (r.isContainment()) { // only containment
						// relations!
						EClass c = r.getEReferenceType();
						List<EClass> types = new ArrayList<EClass>();
						types.add(c);
						types.addAll(ModelManager.getESubClasses(metaModel, c));
						for (EClass type : types) {
							if (!classifiers.contains(type)) {
								classifiers.add(type);
							}
						}

					}
				}
			}
		}
		return classifiers;
	}
	
	public static boolean compareModels(Resource model1, Resource model2) {
		IComparisonScope scope = new DefaultComparisonScope(model1, model2, null);
		Comparison comparison = EMFCompare.builder().build().compare(scope);

		List<Diff> differences = comparison.getDifferences();

		if (differences.size() == 0) {
			return true;
		}

		return false;
	}
	
	public static boolean compareObjects(EObject ob1, EObject ob2) {
		// note it is necessary to put the resources in a resourceset
		// cause EMF uses the resourceset to compute id's etc.
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource resource1 = new XMLResourceImpl(URI.createURI("resource1.xml")); //$NON-NLS-1$
		final Resource resource2 = new XMLResourceImpl(URI.createURI("resource2.xml")); //$NON-NLS-1$
		resourceSet.getResources().add(resource1);
		resourceSet.getResources().add(resource2);
		resource1.getContents().add(ob1);
		resource2.getContents().add(ob2);

		final IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		final IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		final IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
		matchEngineFactory.setRanking(20);
		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add(matchEngineFactory);
		final EMFCompare comparator = EMFCompare.builder().setMatchEngineFactoryRegistry(matchEngineRegistry).build();

		// Compare the two models
		final IComparisonScope scope = new DefaultComparisonScope(resource1, resource2, null);
		final Comparison comparison = comparator.compare(scope);
		final EList<Diff> differences = comparison.getDifferences();
		if (differences.size() == 0) {
			return true;
		}

		return false;
	}

	public static boolean compareListObjects(List<EObject> lob1, List<EObject> lob2) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource resource1 = new XMLResourceImpl(URI.createURI("resource1.xml")); //$NON-NLS-1$
		final Resource resource2 = new XMLResourceImpl(URI.createURI("resource2.xml")); //$NON-NLS-1$
		resourceSet.getResources().add(resource1);
		resourceSet.getResources().add(resource2);
		resource1.getContents().addAll(lob1);
		resource2.getContents().addAll(lob2);

		final IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		final IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		final IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
		matchEngineFactory.setRanking(20);
		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add(matchEngineFactory);
		final EMFCompare comparator = EMFCompare.builder().setMatchEngineFactoryRegistry(matchEngineRegistry).build();

		// Compare the two models
		final IComparisonScope scope = new DefaultComparisonScope(resource1, resource2,	null);
		final Comparison comparison = comparator.compare(scope);
		final EList<Diff> differences = comparison.getDifferences();
		if (differences.size() == 0) {
			return true;
		}

		return false;
	}
	
	/**
	 * It returns the list of classes defined in a meta-model.
	 */
	public static ArrayList<EClass> getEClasses(List<EPackage> packages) {
		return getEClasses(packages, new ArrayList<EPackage>());
	}

	/**
	 * It returns the list of classes defined in a meta-model.
	 */
	private static ArrayList<EClass> getEClasses(List<EPackage> packages, List<EPackage> processed) {
		ArrayList<EClass> classes = new ArrayList<EClass>();
		for (EPackage pck : packages) {
			if (!processed.contains(pck)) {
				for (EClassifier cl : pck.getEClassifiers()) {
					if (cl instanceof EClass) {
						if (!classes.contains((EClass) cl)) {
							classes.add((EClass) cl);
						}
					}
				}
				processed.add(pck);
				if (pck.getESubpackages() != null) {
					List<EClass> subpackageClasses = getEClasses(pck.getESubpackages(), processed);
					for (EClass cl : subpackageClasses) {
						if (!classes.contains(cl)) {
							classes.add(cl);
						}
					}
				}
			}
		}
		return classes;
	}
	
	/**
	 * It returns the list of the given class subclasses defined in a meta-model.
	 */
	public static ArrayList<EClass> getESubClasses(List<EPackage> packages, EClass eClass) {
		ArrayList<EClass> subclasses = new ArrayList<EClass>();
		List<EClass> classes = ModelManager.getEClasses(packages);
		for (EClass cl : classes) {
			List<EClass> superTypes = cl.getEAllSuperTypes();
			for (EClass superType : superTypes) {
				if (EcoreUtil.getURI(superType).equals(EcoreUtil.getURI(eClass))) {
					subclasses.add(cl);
				}
			}
		}
		return subclasses;
	}

	/**
	 * It returns the class identified by the name defined in a meta-model.
	 */
	public static EClass getEClassByName(List<EPackage> packages, String name) {
		for (EPackage pck : packages) {
			for (EClassifier cl : pck.getEClassifiers()) {
				if (cl instanceof EClass) {
					if (cl.getName().equals(name) == true) {
						return (EClass) cl;
					}
				}
			}
			if (pck.getESubpackages() != null) {
				EClass cl = getEClassByName(pck.getESubpackages(), name);
				if (cl != null) {
					return cl;
				}
			}
		}
		return null;
	}
	
	/**
	 * It returns the class identified by the uri defined in a meta-model.
	 */
	public static EClass getEClassByURI(List<EPackage> packages, URI uri) {
		for (EPackage pck : packages) {
			for (EClassifier cl : pck.getEClassifiers()) {
				if (cl instanceof EClass) {
					if (EcoreUtil.getURI(cl).equals(uri)) {
						return (EClass) cl;
					}
				}
			}
			if (pck.getESubpackages() != null) {
				EClass cl = getEClassByURI(pck.getESubpackages(), uri);
				if (cl != null) {
					return cl;
				}
			}
		}
		return null;
	}

	/**
	 * It returns the list of classes defined in a meta-model package.
	 */
	public static EClass getEClassFromEPackage(EPackage pck, String name) {
		for (EClassifier cl : pck.getEClassifiers()) {
			if (cl instanceof EClass) {
				if (cl.getName().equals(name) == true) {
					return (EClass) cl;
				}
			}
		}
		if (pck.getESubpackages() != null) {
			for (EPackage spck : pck.getESubpackages()) {
				EClass cl = getEClassFromEPackage(spck, name);
				if (cl != null) {
					return cl;
				}
			}
		}
		return null;
	}

	/**
	 * It returns the reference by identified its uri defined in a meta-model.
	 */
	public static EReference getEReferenceByURI(EClass eClass, URI uri) {
		for (EReference ref : eClass.getEAllReferences()) {
			if (EcoreUtil.getURI(ref).equals(uri)) {
				return ref;
			}
		}
		return null;
	}
	
	/**
	 * Returns the corresponding object checking whether it is
	 * a proxy object
	 */
	public static EObject getEObject(EObject object, Resource seed) {
		if (object.eIsProxy()) {
			return EcoreUtil.resolve(object, seed);
		}
		return object;
	}
	
	/**
	 * Gets the root EClass
	 */
	public static EClass getRootEClass(List<EPackage> packages) {
		EClass root = null;
		ArrayList<EClass> eclasses = ModelManager.getEClasses(packages);
		for (EClass eclass : eclasses) {
			List<EClassifier> containerTypes = ModelManager.getContainerTypes(packages, EcoreUtil.getURI(eclass));
			if (containerTypes.size() == 0) {
				root = eclass;
				break;
			}
		}
		return root;
	}
	
	/**
	 * Gets the corresponding EPackage
	 */
	public static EPackage getEPackage(List<EPackage> packages, EClass eClass) {
		for (EPackage pck : packages) {
			for (EClassifier cl : pck.getEClassifiers()) {
				if (cl instanceof EClass) {
					if (EcoreUtil.equals((EClass) cl, eClass)) {
						return pck;
					}
				}
			}
			if (pck.getESubpackages() != null) {
				EPackage subpck = getEPackage(pck.getESubpackages(), eClass);
				if (subpck != null) {
					return subpck;
				}
			}
		}
		return null;
	}
	
	/**
	 * Gets the EPackage by its name 
	 */
	public static EPackage getEPackage(List<EPackage> packages, String name) {
		for (EPackage pck : packages) {
			if (pck.getName().equals(name)) {
				return pck;
			}
			if (pck.getESubpackages() != null) {
				EPackage subpck = getEPackage(pck.getESubpackages(), name);
				if (subpck != null) {
					return subpck;
				}
			}
		}
		return null;
	}
	
	/**
	 * Gets the compatible list of EClass for the given type
	 */
	public static List<EClass> getSiblingEClasses(String metamodel, EClass type) {
		List<EClass> sibling = new ArrayList<EClass>();
		try {
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);

			List<EClass> superTypes = type.getESuperTypes();
			sibling.addAll(ModelManager.getESubClasses(packages, type));
			List<EClass> classes = ModelManager.getEClasses(packages);
			for (EClass superType : superTypes) {
				for (EClass cl : classes) {
					List<EClass> clSuperTypes = cl.getESuperTypes();
					for (EClass clSuperType : clSuperTypes) {
						if (EcoreUtil.equals(superType, clSuperType)) {
							if (!sibling.contains(cl) && !EcoreUtil.equals(cl, type)) {
								sibling.add(cl);
								List<EClass> clSubClasses = ModelManager.getESubClasses(packages, cl);
								for (EClass clSubClass : clSubClasses) {
									if (!sibling.contains(clSubClass) && !EcoreUtil.equals(clSubClass, type)) {
										sibling.add(clSubClass);
									}
								}
							}
						}
					}
				}
			}
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sibling;
	}
	
	/**
	 * Gets the compatible list of EClass for the given type
	 */
	public static List<EClass> getSiblingEClasses(String metamodel, List<EClass> types) {
		List<EClass> sibling = new ArrayList<EClass>();
		try {
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);

			for (EClass type : types) {
				List<EClass> superTypes = type.getESuperTypes();
				sibling.addAll(ModelManager.getESubClasses(packages, type));
				List<EClass> classes = ModelManager.getEClasses(packages);
				for (EClass superType : superTypes) {
					for (EClass cl : classes) {
						List<EClass> clSuperTypes = cl.getESuperTypes();
						for (EClass clSuperType : clSuperTypes) {
							if (EcoreUtil.equals(superType, clSuperType)) {
								if (!sibling.contains(cl) && !EcoreUtil.equals(cl, type)) {
									sibling.add(cl);
									List<EClass> clSubClasses = ModelManager.getESubClasses(packages, cl);
									for (EClass clSubClass : clSubClasses) {
										if (!sibling.contains(clSubClass) && !EcoreUtil.equals(clSubClass, type)) {
											sibling.add(clSubClass);
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sibling;
	}

	/**
	 * Removes an eobject list from an eobject list by its URI ending
	 */
	public static void removeEObjects(List<EObject> target, List<EObject> objectsToRemove) {
		List<EObject> tmpList = new ArrayList<EObject>();
		tmpList.addAll(target);
		
		for (EObject obj : objectsToRemove) {
			String partialObjURI = EcoreUtil.getURI(obj).toString();
			partialObjURI = partialObjURI.substring(partialObjURI.indexOf("#"), partialObjURI.length());
			for (EObject tar : target) {
				String partialURI = EcoreUtil.getURI(tar).toString();
				partialURI = partialURI.substring(partialURI.indexOf("#"), partialURI.length());
				if (partialURI.equals(partialObjURI)) {
					tmpList.remove(tar);
					break;
				}	
			}
		}
		target.clear();
		target.addAll(tmpList);
	}
	
	public static boolean isBigInteger (String type) { return type.equals("EBigInteger"); }	
	public static boolean isInteger  (String type)   { return type.equals("EInt") || type.equals("Integer") || type.equals("IntegerObject") || type.endsWith("Integer"); }	
	public static boolean isString   (String type)   { return type.equals("EString") || type.equals("String") || type.endsWith("String"); }	
	public static boolean isBoolean  (String type)   { return type.equals("EBoolean") || type.equals("boolean") || type.equals("EBooleanObject") || type.equals("Boolean") || type.endsWith("Boolean"); }
	public static boolean isFloating (String type)   { return type.equals("EFloat")  || type.equals("float")  || type.equals("EFloatObject")  || type.equals("Float")  || type.endsWith("Float") ||
	                                                          type.equals("EDouble") || type.equals("double") || type.equals("EDoubleObject") || type.equals("Double") || type.endsWith("Double"); }
}