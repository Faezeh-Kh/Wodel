package wodel.dsls.ui.customize;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;
import org.eclipse.xtext.ui.editor.preferences.fields.LabelFieldEditor;

import exceptions.MetaModelNotFoundException;
import manager.ModelManager;
import postprocessor.run.IPostprocessor;
import registry.run.IRegistryPostprocessor;

/**
 * @author Pablo Gomez-Abajo - Wodel General preferences page
 *
 */

public class WodelGeneralPreferencePage extends LanguageRootPreferencePage {
	
	public List<String> selectedValidationNames = new ArrayList<String>();
	
    @Override
    protected void createFieldEditors() {
    	Composite composite = getFieldEditorParent();
    	new LabelFieldEditor(" ", composite);
    	addField(new BooleanFieldEditor("Generate registry", "Generate registry", composite));
    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor(
							"wodel.registry.MutRegistryPostprocessor");
			for (int j = 0; j < extensions.length; j++) {
				IRegistryPostprocessor src = null;
				try {
					src = (IRegistryPostprocessor) extensions[j]
							.createExecutableExtension("class");
				} catch (CoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				addField(new BooleanFieldEditor(src.getName(), src.getName(), composite));
			}
		}

    	new LabelFieldEditor(" ", composite);
    	addField(new BooleanFieldEditor("Serialize models", "Serialize models", composite));
    	
    	HashMap<String, String> valueMap = new HashMap<String, String>();
    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor(
							"wodel.postprocessor.MutPostprocessor");
			for (int j = 0; j < extensions.length; j++) {
				String value = "";
				String uri = "";
				try {
					Class<?> extensionClass = Platform.getBundle(extensions[j].getDeclaringExtension().getContributor().getName()).loadClass(extensions[j].getAttribute("class"));
					Object comparison =  extensionClass.newInstance();
					Method method = extensionClass.getDeclaredMethod("getName");
					value = (String) method.invoke(comparison);
					method = extensionClass.getDeclaredMethod("getURI");
					uri = (String) method.invoke(comparison);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidRegistryObjectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (value.length() > 0) {
					valueMap.put(value, uri);
				}
			}
			List<String> valueList = new ArrayList<String>();
			valueList.add("");
			String metamodel = ModelManager.getMetaModel();
			try {
				List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
				String uri = packages.get(0).getNsURI();
				for (String value : valueMap.keySet()) {
					String uriValue = valueMap.get(value);
					if (uriValue.equals("")) {
						valueList.add(value);
					}
					if (uriValue.equals(uri)) {
						valueList.add(value);
					}
				}
				
			} catch (MetaModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String[][] values = new String[valueList.size()][2];
			int index = 0;
			for (String value : valueList) {
				values[index][0] = value;
				values[index][1] = value;
				index++;
			}
	    	
	    	new LabelFieldEditor("\n\nMutants postprocessing extension", composite);
	    	ComboFieldEditor combo = new ComboFieldEditor("Mutants postprocessing extension", "", values, composite);
	    	addField(combo);
    	}
    	new LabelFieldEditor(" \n\n", composite);
    	new LabelFieldEditor("\n\nWrite which number of attempts will be executed until assuring mutant is unique", composite);
    	StringFieldEditor field = new StringFieldEditor("Number of attempts", "", 8, composite);
    	IPreferenceStore preferenceStore = doGetPreferenceStore();
    	preferenceStore.setDefault("Number of attempts", "0");
    	addField(field);
    	new LabelFieldEditor("\n\n", composite);
    	new LabelFieldEditor("Top number of mutants that will be generated by default", composite);
    	field = new StringFieldEditor("Number of mutants", "", 8, composite);
    	preferenceStore.setDefault("Number of mutants", "3");
    	addField(field);
    	new LabelFieldEditor("\n\n", composite);

    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor(
							"wodel.validation.MutValidation");
			List<String> valueList = new ArrayList<String>();
			valueList.add("");
			for (int j = 0; j < extensions.length; j++) {
				String value = "";
				String uri = "";
				try {
					Class<?> extensionClass = Platform.getBundle(extensions[j].getDeclaringExtension().getContributor().getName()).loadClass(extensions[j].getAttribute("class"));
					Object validation =  extensionClass.newInstance();
					Method method = extensionClass.getDeclaredMethod("getName");
					value = (String) method.invoke(validation);
					valueList.add(value);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidRegistryObjectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (value.length() > 0) {
					valueMap.put(value, uri);
				}
			}
			String[][] values = new String[valueList.size()][2];
			int index = 0;
			for (String value : valueList) {
				values[index][0] = value;
				values[index][1] = value;
				index++;
			}
//			String[][] values = new String[valueList.size() + 1][2];
//			int index = 0;
//			for (String value : valueList) {
//				values[index][0] = value;
//				values[index][1] = value;
//				index++;
//			}
//			values[index][0] = "Java Program Validation";
//			values[index][1] = "Java Program Validation";

    		new LabelFieldEditor(" ", composite);
        	addField(new BooleanFieldEditor("Discard invalid mutants", "Discard invalid mutants", composite));

        	new LabelFieldEditor("Mutants validation extensions", composite);
			ComboFieldEditor combo = new ComboFieldEditor("Mutants validation extension", "", values, composite);
			addField(combo);
//        	new LabelFieldEditor(" ", composite);
//        	org.eclipse.swt.widgets.List comboList = new org.eclipse.swt.widgets.List(composite, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
//        	for (String[] value : values) {
//        		comboList.add(value[0]);
//        	}
//        	comboList.addSelectionListener(new SelectionAdapter() {
//        		@Override
//    		    public void widgetSelected(SelectionEvent e)
//    		    {
//        			org.eclipse.swt.widgets.List list = (org.eclipse.swt.widgets.List) e.widget;
//        			int[] selectionIndices = list.getSelectionIndices();
//        			if (selectionIndices[0] == 0) {
//        				selectedValidationNames.add(values[0][0]);
//        			}
//        			else {
//        				for (int i = 0; i < selectionIndices.length; i++) {
//        					selectedValidationNames.add(values[selectionIndices[i]][0]);
//        				}
//        			}
//    		    }
//        	});
    	}
    	
    	new LabelFieldEditor("\n\n", composite);
    	valueMap = new HashMap<String, String>();
    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor(
							"wodel.comparison.MutComparison");
			for (int j = 0; j < extensions.length; j++) {
				String value = "";
				String uri = "";
				try {
					Class<?> extensionClass = Platform.getBundle(extensions[j].getDeclaringExtension().getContributor().getName()).loadClass(extensions[j].getAttribute("class"));
					Object comparison =  extensionClass.newInstance();
					Method method = extensionClass.getDeclaredMethod("getName");
					value = (String) method.invoke(comparison);
					method = extensionClass.getDeclaredMethod("getURI");
					uri = (String) method.invoke(comparison);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidRegistryObjectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (value.length() > 0) {
					valueMap.put(value, uri);
				}
			}
			List<String> valueList = new ArrayList<String>();
			valueList.add("");
			String metamodel = ModelManager.getMetaModel();
			try {
				List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
				String uri = packages.get(0).getNsURI();
				for (String value : valueMap.keySet()) {
					String uriValue = valueMap.get(value);
					if (uriValue.equals("")) {
						valueList.add(value);
					}
					if (uriValue.equals(uri)) {
						valueList.add(value);
					}
				}
				
			} catch (MetaModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String[][] values = new String[valueList.size()][2];
			int index = 0;
			for (String value : valueList) {
				values[index][0] = value;
				values[index][1] = value;
				index++;
			}

    		new LabelFieldEditor(" ", composite);
        	addField(new BooleanFieldEditor("Discard syntactic duplicate mutants", "Discard syntactic duplicate mutants", composite));

        	new LabelFieldEditor("Duplicate mutants detection extension", composite);
			ComboFieldEditor combo = new ComboFieldEditor("Duplicate mutants detection extension", "", values, composite);
			addField(combo);
    	}

    	new LabelFieldEditor("\n\n", composite);
    	valueMap = new HashMap<String, String>();
    	if (Platform.getExtensionRegistry() != null) {
    		IConfigurationElement[] extensions = Platform
    				.getExtensionRegistry()
    				.getConfigurationElementsFor(
    						"wodel.equivalence.MutEquivalence");
    		for (int j = 0; j < extensions.length; j++) {
    			String value = "";
    			String uri = "";
    			try {
    				Class<?> extensionClass = Platform.getBundle(extensions[j].getDeclaringExtension().getContributor().getName()).loadClass(extensions[j].getAttribute("class"));
    				Object comparison =  extensionClass.newInstance();
    				Method method = extensionClass.getDeclaredMethod("getName");
    				value = (String) method.invoke(comparison);
    				method = extensionClass.getDeclaredMethod("getURI");
    				uri = (String) method.invoke(comparison);
    			} catch (InstantiationException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (IllegalAccessException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (ClassNotFoundException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (InvalidRegistryObjectException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (NoSuchMethodException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (SecurityException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (IllegalArgumentException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (InvocationTargetException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			if (value.length() > 0) {
    				valueMap.put(value, uri);
    			}
    		}
    		List<String> valueList = new ArrayList<String>();
			valueList.add("");
    		String metamodel = ModelManager.getMetaModel();
    		try {
    			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
    			String uri = packages.get(0).getNsURI();
    			for (String value : valueMap.keySet()) {
    				String uriValue = valueMap.get(value);
    				if (uriValue.equals("")) {
    					valueList.add(value);
    				}
    				if (uriValue.equals(uri)) {
    					valueList.add(value);
    				}
    			}

    		} catch (MetaModelNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    		String[][] values = new String[valueList.size()][2];
    		int index = 0;
    		for (String value : valueList) {
    			values[index][0] = value;
    			values[index][1] = value;
    			index++;
    		}

//    		String[][] values = new String[1][2];
//   			values[0][0] = "Java Program Equivalence";
//   			values[0][1] = "Java Program Equivalence";

    		new LabelFieldEditor(" ", composite);
        	addField(new BooleanFieldEditor("Discard semantic equivalent mutants", "Discard semantic equivalent mutants", composite));

        	new LabelFieldEditor("Semantic equivalent mutants detection extension", composite);
    		ComboFieldEditor combo = new ComboFieldEditor("Semantic equivalent mutants detection extension", "", values, composite);
    		addField(combo);
    	}
    	
    	new LabelFieldEditor("\n\n", composite);

    	valueMap = new HashMap<String, String>();
    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor(
							"wodel.validate.MutValidate");
			for (int j = 0; j < extensions.length; j++) {
				String value = "";
				String uri = "";
				try {
					Class<?> extensionClass = Platform.getBundle(extensions[j].getDeclaringExtension().getContributor().getName()).loadClass(extensions[j].getAttribute("class"));
					Object comparison =  extensionClass.newInstance();
					Method method = extensionClass.getDeclaredMethod("getName");
					value = (String) method.invoke(comparison);
					method = extensionClass.getDeclaredMethod("getURI");
					uri = (String) method.invoke(comparison);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidRegistryObjectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (value.length() > 0) {
					valueMap.put(value, uri);
				}
			}
			List<String> valueList = new ArrayList<String>();
			valueList.add("");
			String metamodel = ModelManager.getMetaModel();
			try {
				List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
				String uri = packages.get(0).getNsURI();
				for (String value : valueMap.keySet()) {
					String uriValue = valueMap.get(value);
					if (uriValue.equals("")) {
						valueList.add(value);
					}
					if (uriValue.equals(uri)) {
						valueList.add(value);
					}
				}
				
			} catch (MetaModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String[][] values = new String[valueList.size()][2];
			int index = 0;
			for (String value : valueList) {
				values[index][0] = value;
				values[index][1] = value;
				index++;
			}
	    	
	    	new LabelFieldEditor("Mutants valid programs extension", composite);
	    	ComboFieldEditor combo = new ComboFieldEditor("Mutants valid programs extension", "", values, composite);
	    	addField(combo);
    	}
    	
    	new LabelFieldEditor("\n\n", composite);

    	valueMap = new HashMap<String, String>();
    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor(
							"wodel.optimize.MutOptimize");
			for (int j = 0; j < extensions.length; j++) {
				String value = "";
				String uri = "";
				try {
					Class<?> extensionClass = Platform.getBundle(extensions[j].getDeclaringExtension().getContributor().getName()).loadClass(extensions[j].getAttribute("class"));
					Object comparison =  extensionClass.newInstance();
					Method method = extensionClass.getDeclaredMethod("getName");
					value = (String) method.invoke(comparison);
					method = extensionClass.getDeclaredMethod("getURI");
					uri = (String) method.invoke(comparison);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidRegistryObjectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (value.length() > 0) {
					valueMap.put(value, uri);
				}
			}
			List<String> valueList = new ArrayList<String>();
			valueList.add("");
			String metamodel = ModelManager.getMetaModel();
			try {
				List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
				String uri = packages.get(0).getNsURI();
				for (String value : valueMap.keySet()) {
					String uriValue = valueMap.get(value);
					if (uriValue.equals("")) {
						valueList.add(value);
					}
					if (uriValue.equals(uri)) {
						valueList.add(value);
					}
				}
				
			} catch (MetaModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String[][] values = new String[valueList.size()][2];
			int index = 0;
			for (String value : valueList) {
				values[index][0] = value;
				values[index][1] = value;
				index++;
			}
	    	
    		new LabelFieldEditor(" ", composite);
        	addField(new BooleanFieldEditor("Optimize mutants", "Optimize mutants", composite));

        	new LabelFieldEditor("Mutants optimizer extension", composite);
	    	ComboFieldEditor combo = new ComboFieldEditor("Mutants optimizer extension", "", values, composite);
	    	addField(combo);
    	}
    }
    @Override
    public void init(IWorkbench workbench) {
    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor(
							"wodel.postprocessor.MutPostprocessor");
			for (int j = 0; j < extensions.length; j++) {
				IPostprocessor src = null;
				try {
					src = (IPostprocessor) extensions[j]
							.createExecutableExtension("class");
				} catch (CoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				getPreferenceStore().setDefault(src.getName(), false);
			}
		}
    	getPreferenceStore().setDefault("Discard semantic equivalent mutants", false);
    	getPreferenceStore().setDefault("Serialize models", true);
    }
}
