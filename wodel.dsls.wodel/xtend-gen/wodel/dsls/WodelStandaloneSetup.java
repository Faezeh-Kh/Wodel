/**
 * generated by Xtext 2.13.0
 */
package wodel.dsls;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class WodelStandaloneSetup extends WodelStandaloneSetupGenerated {
  public static void doSetup() {
    new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}
