/**
 * generated by Xtext 2.13.0
 */
package wodel.dsls.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;
import wodel.dsls.AspleRuntimeModule;
import wodel.dsls.AspleStandaloneSetup;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class AspleIdeSetup extends AspleStandaloneSetup {
  @Override
  public Injector createInjector() {
    AspleRuntimeModule _aspleRuntimeModule = new AspleRuntimeModule();
    AspleIdeModule _aspleIdeModule = new AspleIdeModule();
    return Guice.createInjector(Modules2.mixin(_aspleRuntimeModule, _aspleIdeModule));
  }
}
