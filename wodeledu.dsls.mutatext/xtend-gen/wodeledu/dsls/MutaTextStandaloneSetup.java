/**
 * generated by Xtext 2.13.0
 */
package wodeledu.dsls;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class MutaTextStandaloneSetup extends MutaTextStandaloneSetupGenerated {
  public static void doSetup() {
    new MutaTextStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}
