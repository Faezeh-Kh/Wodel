
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import manager.ModelManager;
import metrics.MutatorMetrics;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import commands.*;
import commands.selection.strategies.*;
import commands.strategies.*;

import exceptions.*;

import appliedMutations.*;

import mutatorenvironment.MutatorEnvironment;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.EList;
import org.osgi.framework.Bundle;

import org.eclipse.core.runtime.IProgressMonitor;

public class was2g extends mutator.MutatorUtils implements manager.IMutatorExecutor {
	
   	//RESET COUNTER: 0
   	//RESET COUNTER: 0
   	//RESET COUNTER: 0
   	//RESET COUNTER: 0
   	//RESET COUNTER: 0
   	//RESET COUNTER: 0
	//RESET COUNTER: 0
//COUNTER: 1
//METHOD NAME:mutation1
	private ArrayList<Mutator> mutation1(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
//SELECT OBJECT mutation1
	ObSelectionStrategy containerSelection = null;
	SpecificReferenceSelection referenceSelection = null;
	//
	//true
	RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Aggregation");
	EObject object = rts.getObject();
	
	ObSelectionStrategy objectSelection = null; 
	if (object != null) {
		objectSelection = new SpecificObjectSelection(packages, model, object);
	}
		SelectObjectMutator mut = new SelectObjectMutator(model, packages, referenceSelection, containerSelection, objectSelection);
		//INC COUNTER: 0
		if (mut != null) {
			mut.setId("m1");
			mutations.add(mut);
		}
		//END SELECT OBJECT mutation1
		return mutations;	
	}
//COUNTER: 1
//METHOD NAME:registry1
//REGISTRY COUNTER: 0
private AppMutation registry1(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
	AppMutation appMut = null;
appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
appMut.setDef(hmMutator.get("m1"));
	return appMut;
}
//COUNTER: 2
//METHOD NAME:mutation2
	private ArrayList<Mutator> mutation2(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
//CREATE OBJECT mutation2
ArrayList<EObject> containers = ModelManager.getParentObjects(packages, model, "Composition");
EObject container = containers.get(ModelManager.getRandomIndex(containers));
ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
HashMap<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
ObSelectionStrategy objectSelection = null;
HashMap<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
//NAME:src
  		//REFERENCES COMPILES	35
ObSelectionStrategy refSelection35 = null;
if (hmObjects.get("ag") != null) {
refSelection35 = new SpecificObjectSelection(packages, model, hmObjects.get("ag"), "src");
} else {
	if (hmList.get("ag") != null) {
	refSelection35 = new SpecificObjectSelection(packages, model, hmList.get("ag"), "src");
	}
	else {
		return mutations;
	}
}
   		refs.put("src", refSelection35);
//NAME:tar
  		//REFERENCES COMPILES	36
ObSelectionStrategy refSelection36 = null;
if (hmObjects.get("ag") != null) {
refSelection36 = new SpecificObjectSelection(packages, model, hmObjects.get("ag"), "tar");
} else {
	if (hmList.get("ag") != null) {
	refSelection36 = new SpecificObjectSelection(packages, model, hmList.get("ag"), "tar");
	}
	else {
		return mutations;
	}
}
   		refs.put("tar", refSelection36);
CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts, refs, "Composition");
//INC COUNTER: 1
if (mut != null) {
	mut.setId("m2");
	mutations.add(mut);
}
//END CREATE OBJECT mutation2
		return mutations;	
	}
//COUNTER: 2
//METHOD NAME:registry2
//REGISTRY COUNTER: 1
private AppMutation registry2(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
	AppMutation appMut = null;
ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();
if ((mutPaths != null) && (packages != null)) {
	try {
		Resource mutant = null;
		EObject object = null;
		for (String mutatorPath : mutPaths) {
			mutant = ModelManager.loadModel(packages, mutatorPath);
			object = ModelManager.getObject(mutant, mut.getObject());
			if (object != null) {
				System.out.println("FOUND!!!");
				break;
			}
			//Reload input
	    			try {
				mutant.unload();
				mutant.load(null); 
			} catch (Exception e) {}
		}
		if (object != null) {
			cMut.getObject().add(object);
		}
		else {
			cMut.getObject().add(mut.getObject());
		}
	} catch (ModelNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
cMut.setDef(hmMutator.get("m2"));
appMut = cMut;
	return appMut;
}
//COUNTER: 3
//METHOD NAME:mutation3
	private ArrayList<Mutator> mutation3(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
	//MODIFY INFORMATION mutation3
	ObSelectionStrategy objectSelection = null;
	if (hmObjects.get("rel") != null) {
		objectSelection = new SpecificObjectSelection(packages, model, hmObjects.get("rel"));
	} else {
		if (hmList.get("rel") != null) {
			objectSelection = new SpecificObjectSelection(packages, model, hmList.get("rel"));
		}
		else {
			return mutations;
		}
	}
			
	HashMap<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
	//COUNTER:
	//COUNTER:0
	//NAME:name
if (objectSelection != null && objectSelection.getObject() != null) {
	if (hmObjects.get("ag") != null) {
	   							List<AttributeConfigurationStrategy> atts = null;
	   							if (attsList.get("name") != null) {
				   					atts = attsList.get("name");
		   						}
					   			else {
		   							atts = new ArrayList<AttributeConfigurationStrategy>();
					   			}
			   					atts.add(new CopyAttributeConfigurationStrategy(objectSelection.getObject(), hmObjects.get("ag"), "name", "name"));
				   				attsList.put("name", atts);
	} else {
		return mutations;
	}
}
	   				
	HashMap<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
	HashMap<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
	ArrayList<EObject> objsAttRef = new ArrayList<EObject>();
	//COUNTER:0
if (objectSelection != null) {
	ModifyInformationMutator mut = new ModifyInformationMutator(model, packages, objectSelection, attsList, refsList, objsAttRef, attsRefList);
	//INC COUNTER: 2
	if (mut != null) {
		mut.setId("m3");
				mutations.add(mut);
			}
}
	//END MODIFY INFORMATION mutation3
		return mutations;	
	}
//COUNTER: 3
//METHOD NAME:registry3
//REGISTRY COUNTER: 2
private AppMutation registry3(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
	AppMutation appMut = null;
	InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
	icMut.setObject(mut.getObject());
	EList<AttributeChanged> attsMut = icMut.getAttChanges();
	Object oldAttVal = null;
	Object newAttVal = null;
	//ATTRIBUTE COUNTER: 
//
//
//org.eclipse.emf.ecore.impl.EAttributeImpl@2fe46740 (name: name) (ordered: true, unique: true, lowerBound: 1, upperBound: 1) (changeable: true, volatile: false, transient: false, defaultValueLiteral: null, unsettable: false, derived: false) (iD: false)
AttributeChanged attMut0 = null;
attMut0 = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
attMut0.setAttName("name");
oldAttVal = ((ModifyInformationMutator) mut).getOldAttValue("name");
newAttVal = ((ModifyInformationMutator) mut).getNewAttValue("name");
if (oldAttVal != null) {
	attMut0.setOldVal(oldAttVal.toString());
}
if (newAttVal != null) {
	attMut0.setNewVal(newAttVal.toString());
}
attMut0.setDef(hmMutator.get("m3"));
attsMut.add(attMut0);
icMut.setDef(hmMutator.get("m3"));
//ATTRIBUTE COUNTER INC: 0
	appMut = icMut;
	return appMut;
}
//COUNTER: 4
//METHOD NAME:mutation4
	private ArrayList<Mutator> mutation4(ArrayList<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects, HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
	// REMOVE OBJECT mutation4
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		//
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("ag") != null) {
			objectSelection = new SpecificObjectSelection(packages, model, hmObjects.get("ag"));
	   			} else {
			return mutations;
		}
			RemoveObjectMutator mut = new RemoveObjectMutator(model, packages, objectSelection, referenceSelection, containerSelection);
			   		//INC COUNTER: 3
			   		if (mut != null) {
				   		mut.setId("m4");
				mutations.add(mut);
			}
		//END REMOVE OBJECT mutation4
		return mutations;	
	}
//COUNTER: 4
//METHOD NAME:registry4
//REGISTRY COUNTER: 3
private AppMutation registry4(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths, ArrayList<EPackage> packages) {
	AppMutation appMut = null;
ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
System.out.println("ModelManager.getObject(seed, mut.getObject()): " + ModelManager.getObject(seed, mut.getObject()));
if (ModelManager.getObject(seed, mut.getObject()) != null) {
	rMut.getObject().add(ModelManager.getObject(seed, mut.getObject()));
}
else {
	if ((mutPaths != null) && (packages != null)) {
		try {
			Resource mutant = null;
			EObject object = null;
			for (String mutatorPath : mutPaths) {
				mutant = ModelManager.loadModel(packages, mutatorPath);
				object = ModelManager.getObject(mutant, mut.getObject());
				if (object != null) {
					System.out.println("FOUND!!!");
					break;
				}
				//Reload input
	    				try {
					mutant.unload();
					mutant.load(null); 
				} catch (Exception e) {}
			}
			if (object != null) {
				rMut.getObject().add(object);
			}
			else {
				rMut.getObject().add(mut.getObject());
			}
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
rMut.setDef(hmMutator.get("m4"));
appMut = rMut;
	return appMut;
}
public void execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, IProgressMonitor monitor) throws ReferenceNonExistingException, WrongAttributeTypeException, 
											  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
 												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
 		
	if (maxAttempts <= 0) {
		maxAttempts = 1;
	}
	int totalTasks = 0;
	if (metrics == true) {
		totalTasks++;
	}
	if (debugMetrics == true) {
		totalTasks++;
	}
	//2
   	numMutants = 2;

   	int totalMutants = numMutants * 1;
	totalTasks += totalMutants;
	monitor.beginTask("Generating mutants", totalTasks);
	HashMap<String, List<String>> hashmapMutVersions = new HashMap<String, List<String>>();
	
	
	    String ecoreURI = "C:/eclipse/runtime-EclipseApplication/was2g/data/model/UMLClassDiagram.ecore";
	    
	    String modelURI = "C:/eclipse/runtime-EclipseApplication/was2g/data/model/";
	    String modelsURI = "C:/eclipse/runtime-EclipseApplication/was2g/data/out/";
	    //String resourcesURI = "C:/eclipse/runtime-EclipseApplication/was2g/resources/";
	    
	    HashMap<String, String> hashmapModelFilenames = new HashMap<String, String>();
	    File[] files = new File(modelURI).listFiles();
	    for (int i = 0; i < files.length; i++) {
	    	if (files[i].isFile() == true) {
	    		String pathfile = files[i].getPath();
	    		if (pathfile.endsWith(".model") == true) {
	    			hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
	    		}
	    	}
	    }
	    
	    //Load MetaModel
	    ArrayList<EPackage> packages = ModelManager.loadMetaModel(ecoreURI);
	    
	    //Load Model
	    Set<String> modelFilenames = hashmapModelFilenames.keySet();
	    int count = 0;
	    for (String modelFilename : modelFilenames) {
	    	HashSet<String> hashsetMutants = new HashSet<String>();
	    	hashsetMutants.add(modelFilename);
	    	Resource model = ModelManager.loadModel(packages, modelFilename);
	    	Resource seed = ModelManager.loadModel(packages, modelFilename);
	    
	   	   		//Generate metrics model
	   	Bundle bundle = Platform.getBundle("wodel.models");
	   		   	URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
	   		   	String mutatorecore = FileLocator.resolve(fileURL).getFile();
	   	
	   	//Load MetaModel
	   	ArrayList<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
	   	Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/C:/eclipse/runtime-EclipseApplication/was2g/data/out/was2g.model").toFileString());
	   	
	   	HashMap<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
	   			
	   	   	   	for (int i = 0; i < numMutants; i++) {
	   	   	   		HashMap<String, EObject> hashmapEObject = new HashMap<String, EObject>();
	   		HashMap<String, List<EObject>> hashmapList = new HashMap<String, List<EObject>>();
	   	   	   		String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + i + ".model";
	   	   	   		monitor.subTask("Mutant " + (count * numMutants + i + 1) + "/" + totalMutants + ": " + mutFilename);
	   	   	   		String mutPath = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + i + "vs";
	   	   	   		boolean isRepeated = true;
	   	   			int attempts = 0;
	   	   			int max = 0;
	   	   			while ((isRepeated == true) && (attempts < maxAttempts)) {
	   			List<String> mutPaths = new ArrayList<String>();
	   			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
	   	   				attempts++;
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	   				//RESET COUNTER: 0
	   	
	   	   	   			   	   	//COUNTER: 1	
	   	   	   			//COMMAND: 69
	   	   	   			//REGISTRY COUNTER: 1
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:ag69
	   	   	   			//METHOD NAME:mutation1
	   	   	   			
	   	   	   			ArrayList<Mutator> lag69 = mutation1(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 1
	   	   	   			//REGISTRY METHOD NAME:registry1
	   	   	   			
	   	   	   			if (lag69 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : lag69) {
	   	   	   					if (mut != null) {
	   	   	   						Object mutated = mut.mutate();
	   	   	   						if (mutated != null) {
	   	   	   							if (mutated instanceof EObject) {
	   	   	   							hashmapEObject.put("ag", mut.getObject());
	   	   	   							}
	   	   	   							AppMutation appMut = registry1(mut, hmMutator, seed, mutPaths, packages);
	   	   	   							if (appMut != null) {
	   	   	   								muts.getMuts().add(appMut);
	   	   	   							}
	   	   	   						}
	   	   	   					}
	   	   	   					k++;
	   	   	   				}
	   	   	   			}
	   	   	   			}
	   	   	   			   	   	//COUNTER: 2	
	   	   	   			//COMMAND: 70
	   	   	   			//REGISTRY COUNTER: 2
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:rel70
	   	   	   			//METHOD NAME:mutation2
	   	   	   			
	   	   	   			ArrayList<Mutator> lrel70 = mutation2(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 2
	   	   	   			//REGISTRY METHOD NAME:registry2
	   	   	   			
	   	   	   			if (lrel70 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : lrel70) {
	   	   	   					if (mut != null) {
	   	   	   						Object mutated = mut.mutate();
	   	   	   						if (mutated != null) {
	   	   	   							if (mutated instanceof EObject) {
	   	   	   							hashmapEObject.put("rel", mut.getObject());
	   	   	   							}
	   	   	   							String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_2.model";
	   	   	   							ModelManager.saveOutModel(model, mutatorPath);
	   	   	   							if (mutPaths.contains(mutatorPath) == false) {
	   	   	   								mutPaths.add(mutatorPath);
	   	   	   							}
	   	   	   							AppMutation appMut = registry2(mut, hmMutator, seed, mutPaths, packages);
	   	   	   							if (appMut != null) {
	   	   	   								muts.getMuts().add(appMut);
	   	   	   							}
	   	   	   						}
	   	   	   					}
	   	   	   					k++;
	   	   	   				}
	   	   	   			}
	   	   	   			}
	   	   	   			   	   	//COUNTER: 3	
	   	   	   			//COMMAND: 71
	   	   	   			//REGISTRY COUNTER: 3
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:71
	   	   	   			//METHOD NAME:mutation3
	   	   	   			
	   	   	   			ArrayList<Mutator> l71 = mutation3(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 3
	   	   	   			//REGISTRY METHOD NAME:registry3
	   	   	   			
	   	   	   			if (l71 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : l71) {
	   	   	   					if (mut != null) {
	   	   	   						Object mutated = mut.mutate();
	   	   	   						if (mutated != null) {
	   	   	   							String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_3.model";
	   	   	   							ModelManager.saveOutModel(model, mutatorPath);
	   	   	   							if (mutPaths.contains(mutatorPath) == false) {
	   	   	   								mutPaths.add(mutatorPath);
	   	   	   							}
	   	   	   							AppMutation appMut = registry3(mut, hmMutator, seed, mutPaths, packages);
	   	   	   							if (appMut != null) {
	   	   	   								muts.getMuts().add(appMut);
	   	   	   							}
	   	   	   						}
	   	   	   					}
	   	   	   					k++;
	   	   	   				}
	   	   	   			}
	   	   	   			}
	   	   	   			   	   	//COUNTER: 4	
	   	   	   			//COMMAND: 72
	   	   	   			//REGISTRY COUNTER: 4
	   	   	   			max = 1;
	   	   	   			for (int j = 0; j < max; j++) {
	   	   	   			//NAME:72
	   	   	   			//METHOD NAME:mutation4
	   	   	   			
	   	   	   			ArrayList<Mutator> l72 = mutation4(packages, model, hashmapEObject, hashmapList);
	   	   	   			//COUNTER: 4
	   	   	   			//REGISTRY METHOD NAME:registry4
	   	   	   			
	   	   	   			if (l72 != null) {
	   	   	   				int k = 0;
	   	   	   				for (Mutator mut : l72) {
	   	   	   					if (mut != null) {
	   	   	   						Object mutated = mut.mutate();
	   	   	   						if (mutated != null) {
	   	   	   							String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k + "_4.model";
	   	   	   							ModelManager.saveOutModel(model, mutatorPath);
	   	   	   							if (mutPaths.contains(mutatorPath) == false) {
	   	   	   								mutPaths.add(mutatorPath);
	   	   	   							}
	   	   	   							AppMutation appMut = registry4(mut, hmMutator, seed, mutPaths, packages);
	   	   	   							if (appMut != null) {
	   	   	   								muts.getMuts().add(appMut);
	   	   	   							}
	   	   	   						}
	   	   	   					}
	   	   	   					k++;
	   	   	   				}
	   	   	   			}
	   	   	   			}
	   	      
	   	      
	   	      			//MUTANT COMPLETION AND REGISTRY
	   	       			HashMap<String, ArrayList<String>> rules = new HashMap<String, ArrayList<String>>();
	   	      			
	   	      			
	   			isRepeated = registryMutant(ecoreURI, packages, seed, model, rules, muts, modelFilename, mutFilename, registry, hashsetMutants, hashmapModelFilenames, i, mutPaths, hashmapMutVersions);
	   	
	   		    		//Reload input
	   		    		try {
	   				model.unload();
	   				model.load(null); 
	   			} catch (Exception e) {}
	   	   			}
	   		monitor.worked(1);
	   	   		}
	   	count++;
	
	}

	//Generate metrics model
	Bundle bundle = Platform.getBundle("wodel.models");
   	URL fileURL = bundle.getEntry("/models/MutatorMetrics.ecore");
   	String metricsecore = FileLocator.resolve(fileURL).getFile();
   		//String metricsecore = "C:/eclipse/runtime-EclipseApplication/was2g/resources/MutatorMetrics.ecore";
   		
   		if (metrics == true) {
   			ArrayList<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
   			monitor.subTask("Generating dynamic net metrics");
   			MutatorMetrics.generateMetrics(metricspackages, "C:/eclipse/runtime-EclipseApplication/was2g/data/out/", "C:/eclipse/runtime-EclipseApplication/was2g/data/model/UMLClassDiagram.ecore", "C:/eclipse/runtime-EclipseApplication/was2g/data/model/", "was2g", "C:/eclipse/runtime-EclipseApplication/was2g", hashmapMutVersions);
   			monitor.worked(1);
   		}
   		if (debugMetrics == true) {
		ArrayList<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
   			monitor.subTask("Generating dynamic debug metrics");
   			MutatorMetrics.generateDebugMetrics(metricspackages, "C:/eclipse/runtime-EclipseApplication/was2g/data/out/", "C:/eclipse/runtime-EclipseApplication/was2g/data/model/UMLClassDiagram.ecore", "C:/eclipse/runtime-EclipseApplication/was2g/data/model/", "was2g", "C:/eclipse/runtime-EclipseApplication/was2g", hashmapMutVersions);
   			monitor.worked(1);   			
   		}
   	}
}

