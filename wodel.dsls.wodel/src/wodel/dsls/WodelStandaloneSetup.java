/*
 * generated by Xtext
 */
package wodel.dsls;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class WodelStandaloneSetup extends WodelStandaloneSetupGenerated{

	public static void doSetup() {
		new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

