import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import manager.ModelManager;
import manager.MutatorMetricsGenerator;
import manager.DebugMutatorMetricsGenerator;
import manager.NetMutatorMetricsGenerator;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import commands.*;
import commands.selection.strategies.*;
import commands.strategies.*;
import exceptions.*;
import appliedMutations.*;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.EList;
import org.osgi.framework.Bundle;
import org.eclipse.core.runtime.IProgressMonitor;

public class ppr extends manager.MutatorUtils implements manager.IMutatorExecutor {
	private ArrayList<Mutator> mutation1(List<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects,
			HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Rule");
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "parameters";
		((ReferenceEvaluation) exp0.first).refName = "children";
		((ReferenceEvaluation) exp0.first).operator = "different";
		((ReferenceEvaluation) exp0.first).value = null;
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		List<EObject> selectedObjects = evaluate(objects, exp0);
		EObject object = null;
		if (selectedObjects.size() > 0) {
			object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
		}
		ObSelectionStrategy objectSelection = null;
		if (object != null) {
			objectSelection = new SpecificObjectSelection(packages, model, object);
		}
		SelectObjectMutator mut = new SelectObjectMutator(model, packages, referenceSelection, containerSelection,
				objectSelection);
		if (mut != null) {
			mut.setId("m1");
			mutations.add(mut);
		}
		return mutations;
	}

	private AppMutation registry1(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
		appMut.setDef(hmMutator.get("m1"));
		return appMut;
	}

	private ArrayList<Mutator> mutation2(List<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects,
			HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		if (hmObjects.get("r") != null) {
			containerSelection = new SpecificObjectSelection(packages, model, hmObjects.get("r"));
		} else {
			if (hmList.get("r") != null) {
				containerSelection = new SpecificObjectSelection(packages, model, hmList.get("r"));
			} else {
				return mutations;
			}
		}
		if (hmObjects.get("r") != null) {
			referenceSelection = new SpecificReferenceSelection(packages, model, "parameters", hmObjects.get("r"));
		} else {
			return mutations;
		}
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Parameter", referenceSelection,
				containerSelection);
		List<EObject> objects = rts.getObjects();
		Expression exp0 = new Expression();
		exp0.first = new ReferenceEvaluation();
		((ReferenceEvaluation) exp0.first).name = "children";
		((ReferenceEvaluation) exp0.first).refName = null;
		((ReferenceEvaluation) exp0.first).operator = "different";
		((ReferenceEvaluation) exp0.first).value = null;
		exp0.operator = new ArrayList<Operator>();
		exp0.second = new ArrayList<Evaluation>();
		List<EObject> selectedObjects = evaluate(objects, exp0);
		EObject object = null;
		if (selectedObjects.size() > 0) {
			object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
		}
		ObSelectionStrategy objectSelection = null;
		if (object != null) {
			objectSelection = new SpecificObjectSelection(packages, model, object);
		}
		SelectObjectMutator mut = new SelectObjectMutator(model, packages, referenceSelection, containerSelection,
				objectSelection);
		if (mut != null) {
			mut.setId("m2");
			mutations.add(mut);
		}
		return mutations;
	}

	private AppMutation registry2(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
		appMut.setDef(hmMutator.get("m2"));
		return appMut;
	}

	private ArrayList<Mutator> mutation3(List<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects,
			HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		if (hmObjects.get("p") != null) {
			containerSelection = new SpecificClosureSelection(packages, model, hmObjects.get("p"), "children");
		} else {
			return mutations;
		}
		if (hmObjects.get("p") != null) {
			referenceSelection = new SpecificReferenceSelection(packages, model, "children", hmObjects.get("p"));
		} else {
			return mutations;
		}
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "Parameter", referenceSelection,
				containerSelection);
		EObject object = rts.getObject();
		ObSelectionStrategy objectSelection = null;
		if (object != null) {
			objectSelection = new SpecificObjectSelection(packages, model, object);
		}
		SelectObjectMutator mut = new SelectObjectMutator(model, packages, referenceSelection, containerSelection,
				objectSelection);
		if (mut != null) {
			mut.setId("m3");
			mutations.add(mut);
		}
		return mutations;
	}

	private AppMutation registry3(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
		appMut.setDef(hmMutator.get("m3"));
		return appMut;
	}

	private ArrayList<Mutator> mutation4(List<EPackage> packages, Resource model, HashMap<String, EObject> hmObjects,
			HashMap<String, List<EObject>> hmList) throws ReferenceNonExistingException {
		ArrayList<Mutator> mutations = new ArrayList<Mutator>();
		ObSelectionStrategy objectSelection = null;
		if (hmObjects.get("r") != null) {
			objectSelection = new SpecificObjectSelection(packages, model, hmObjects.get("r"));
		} else {
			if (hmList.get("r") != null) {
				objectSelection = new SpecificObjectSelection(packages, model, hmList.get("r"));
			} else {
				return mutations;
			}
		}
		HashMap<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		HashMap<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
		HashMap<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		ArrayList<EObject> objsAttRef = new ArrayList<EObject>();
		if (objectSelection != null && objectSelection.getObject() != null) {
			if (hmObjects.get("p") != null) {
				List<ReferenceConfigurationStrategy> refs = null;
				if (refsList.get("parameters") != null) {
					refs = refsList.get("parameters");
				} else {
					refs = new ArrayList<ReferenceConfigurationStrategy>();
				}
				refs.add(new SpecificReferenceConfigurationStrategy(model, objectSelection.getObject(),
						hmObjects.get("p"), "parameters", true));
				refsList.put("parameters", refs);
			} else {
				return mutations;
			}
		}
		if (objectSelection != null && objectSelection.getObject() != null) {
			if (hmObjects.get("c") != null) {
				List<ReferenceConfigurationStrategy> refs = null;
				if (refsList.get("parameters") != null) {
					refs = refsList.get("parameters");
				} else {
					refs = new ArrayList<ReferenceConfigurationStrategy>();
				}
				refs.add(new SpecificReferenceConfigurationStrategy(model, objectSelection.getObject(),
						hmObjects.get("c"), "parameters", false));
				refsList.put("parameters", refs);
			} else {
				return mutations;
			}
		}
		if (objectSelection != null) {
			ModifyInformationMutator mut = new ModifyInformationMutator(model, packages, objectSelection, attsList,
					refsList, objsAttRef, attsRefList);
			if (mut != null) {
				mut.setId("m4");
				mutations.add(mut);
			}
		}
		return mutations;
	}

	private AppMutation registry4(Mutator mut, HashMap<String, EObject> hmMutator, Resource seed, List<String> mutPaths,
			List<EPackage> packages) {
		AppMutation appMut = null;
		InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
		icMut.setObject(mut.getObject());
		EList<ReferenceChanged> refsMut = icMut.getRefChanges();
		EObject previous = null;
		EObject next = null;
		ReferenceChanged refMut0 = null;
		refMut0 = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();
		refMut0.setRefName("parameters");
		refMut0.getObject().add(((ModifyInformationMutator) mut).getObject());
		previous = ((ModifyInformationMutator) mut).getPrevious();
		next = ((ModifyInformationMutator) mut).getNext();
		if (previous != null) {
			refMut0.setFrom(previous);
		}
		if (next != null) {
			refMut0.setTo(next);
		}
		refMut0.setSrcRefName(((ModifyInformationMutator) mut).getSrcRefType());
		refMut0.setDef(hmMutator.get("m4"));
		refsMut.add(refMut0);
		icMut.setDef(hmMutator.get("m4"));
		ReferenceChanged refMut1 = null;
		refMut1 = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();
		refMut1.setRefName("parameters");
		refMut1.getObject().add(((ModifyInformationMutator) mut).getObject());
		previous = ((ModifyInformationMutator) mut).getPrevious();
		next = ((ModifyInformationMutator) mut).getNext();
		if (previous != null) {
			refMut1.setFrom(previous);
		}
		if (next != null) {
			refMut1.setTo(next);
		}
		refMut1.setSrcRefName(((ModifyInformationMutator) mut).getSrcRefType());
		refMut1.setDef(hmMutator.get("m4"));
		refsMut.add(refMut1);
		icMut.setDef(hmMutator.get("m4"));
		appMut = icMut;
		return appMut;
	}

	public void execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics,
			IProgressMonitor monitor) throws ReferenceNonExistingException, WrongAttributeTypeException,
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
		numMutants = 2;
		int totalMutants = numMutants * 2;
		totalTasks += totalMutants;
		monitor.beginTask("Generating mutants", totalTasks);
		HashMap<String, List<String>> hashmapMutVersions = new HashMap<String, List<String>>();
		String ecoreURI = "C:/eclipse/workspace/ppr/data/model/SecurityPolicy.ecore";
		String modelURI = "C:/eclipse/workspace/ppr/data/model/";
		String modelsURI = "C:/eclipse/workspace/ppr/data/out/";
		HashMap<String, String> hashmapModelFilenames = new HashMap<String, String>();
		File[] files = new File(modelURI).listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() == true) {
				String pathfile = files[i].getPath();
				if (pathfile.endsWith(".model") == true) {
					hashmapModelFilenames.put(pathfile, modelsURI
							+ files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
				}
			}
		}
		List<EPackage> packages = ModelManager.loadMetaModel(ecoreURI);
		Set<String> modelFilenames = hashmapModelFilenames.keySet();
		int count = 0;
		for (String modelFilename : modelFilenames) {
			HashSet<String> hashsetMutants = new HashSet<String>();
			hashsetMutants.add(modelFilename);
			Bundle bundle = Platform.getBundle("wodel.models");
			URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
			String mutatorecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages,
					URI.createURI("file:/C:/eclipse/workspace/ppr/data/out/ppr.model").toFileString());
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
					Resource model = ModelManager.loadModel(packages, modelFilename);
					Resource seed = ModelManager.loadModel(packages, modelFilename);
					List<String> mutPaths = new ArrayList<String>();
					Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					attempts++;
					max = 1;
					for (int j = 0; j < max; j++) {
						ArrayList<Mutator> lr100 = mutation1(packages, model, hashmapEObject, hashmapList);
						if (lr100 != null) {
							int k = 0;
							for (Mutator mut : lr100) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											hashmapEObject.put("r", mut.getObject());
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
					max = 1;
					for (int j = 0; j < max; j++) {
						ArrayList<Mutator> lp101 = mutation2(packages, model, hashmapEObject, hashmapList);
						if (lp101 != null) {
							int k = 0;
							for (Mutator mut : lp101) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											hashmapEObject.put("p", mut.getObject());
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
					max = 1;
					for (int j = 0; j < max; j++) {
						ArrayList<Mutator> lc102 = mutation3(packages, model, hashmapEObject, hashmapList);
						if (lc102 != null) {
							int k = 0;
							for (Mutator mut : lc102) {
								if (mut != null) {
									Object mutated = mut.mutate();
									if (mutated != null) {
										if (mutated instanceof EObject) {
											hashmapEObject.put("c", mut.getObject());
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
					max = 1;
					for (int j = 0; j < max; j++) {
						ArrayList<Mutator> l103 = mutation4(packages, model, hashmapEObject, hashmapList);
						if (l103 != null) {
							int k = 0;
							for (Mutator mut : l103) {
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
					HashMap<String, ArrayList<String>> rules = new HashMap<String, ArrayList<String>>();
					isRepeated = registryMutant(ecoreURI, packages, seed, model, rules, muts, modelFilename,
							mutFilename, registry, hashsetMutants, hashmapModelFilenames, i, mutPaths,
							hashmapMutVersions);
					try {
						model.unload();
						model.load(null);
						seed.unload();
						seed.load(null);
					} catch (Exception e) {
					}
				}
				monitor.worked(1);
			}
			count++;
		}
		Bundle bundle = Platform.getBundle("wodel.models");
		URL fileURL = bundle.getEntry("/models/MutatorMetrics.ecore");
		String metricsecore = FileLocator.resolve(fileURL).getFile();
		MutatorMetricsGenerator metricsGenerator = null;
		if (metrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic net metrics");
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, "C:/eclipse/workspace/ppr/data/out/",
					"C:/eclipse/workspace/ppr/data/model/SecurityPolicy.ecore", "C:/eclipse/workspace/ppr/data/model/",
					"ppr.java", hashmapMutVersions);
			metricsGenerator.run();
			monitor.worked(1);
		}
		if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic debug metrics");
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, "C:/eclipse/workspace/ppr/data/out/",
					"C:/eclipse/workspace/ppr/data/model/SecurityPolicy.ecore", "C:/eclipse/workspace/ppr/data/model/",
					"ppr.java", hashmapMutVersions);
			metricsGenerator.run();
			monitor.worked(1);
		}
	}
}
