/**
 * generated by Xtext
 */
package wodeledu.dsls.scoping;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import manager.ModelManager;
import modeltext.Attribute;
import modeltext.Element;
import modeltext.IdentifyElements;
import modeltext.Variable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
@SuppressWarnings("all")
public class ModelTextScopeProvider extends AbstractDeclarativeScopeProvider {
  public IScope scope_Element_type(final Element element, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final ArrayList<EClass> scope = new ArrayList<EClass>();
      EObject _eContainer = element.eContainer();
      String _metamodel = ((IdentifyElements) _eContainer).getMetamodel();
      List<EClass> _eClasses = this.getEClasses(_metamodel);
      scope.addAll(_eClasses);
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }
  
  public IScope scope_Element_ref(final Element element, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final ArrayList<EReference> scope = new ArrayList<EReference>();
      EClass _type = element.getType();
      boolean _notEquals = (!Objects.equal(_type, null));
      if (_notEquals) {
        EObject _eContainer = element.eContainer();
        String _metamodel = ((IdentifyElements) _eContainer).getMetamodel();
        EClass _type_1 = element.getType();
        String _name = _type_1.getName();
        List<EReference> _eReferences = this.getEReferences(_metamodel, _name);
        scope.addAll(_eReferences);
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }
  
  public IScope scope_Variable_id(final Variable variable, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final ArrayList<EAttribute> scope = new ArrayList<EAttribute>();
      EReference _ref = variable.getRef();
      boolean _equals = Objects.equal(_ref, null);
      if (_equals) {
        EObject _eContainer = variable.eContainer();
        EObject _eContainer_1 = _eContainer.eContainer();
        String _metamodel = ((IdentifyElements) _eContainer_1).getMetamodel();
        EObject _eContainer_2 = variable.eContainer();
        EClass _type = ((Element) _eContainer_2).getType();
        String _name = _type.getName();
        List<EAttribute> _eAttributes = this.getEAttributes(_metamodel, _name);
        scope.addAll(_eAttributes);
      }
      EReference _ref_1 = variable.getRef();
      boolean _notEquals = (!Objects.equal(_ref_1, null));
      if (_notEquals) {
        EObject _eContainer_3 = variable.eContainer();
        EObject _eContainer_4 = _eContainer_3.eContainer();
        String _metamodel_1 = ((IdentifyElements) _eContainer_4).getMetamodel();
        EReference _ref_2 = variable.getRef();
        EClassifier _eType = ((EReference) _ref_2).getEType();
        String _name_1 = _eType.getName();
        List<EAttribute> _eAttributes_1 = this.getEAttributes(_metamodel_1, _name_1);
        scope.addAll(_eAttributes_1);
      }
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }
  
  public IScope scope_Variable_ref(final Variable variable, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final ArrayList<EReference> scope = new ArrayList<EReference>();
      EObject _eContainer = variable.eContainer();
      EObject _eContainer_1 = _eContainer.eContainer();
      String _metamodel = ((IdentifyElements) _eContainer_1).getMetamodel();
      EObject _eContainer_2 = variable.eContainer();
      EClass _type = ((Element) _eContainer_2).getType();
      String _name = _type.getName();
      List<EReference> _eReferences = this.getEReferences(_metamodel, _name);
      scope.addAll(_eReferences);
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }
  
  public IScope scope_Attribute_att(final Attribute att, final EReference ref) {
    IScope _xblockexpression = null;
    {
      final ArrayList<EAttribute> scope = new ArrayList<EAttribute>();
      EObject _eContainer = att.eContainer();
      EObject _eContainer_1 = _eContainer.eContainer();
      String _metamodel = ((IdentifyElements) _eContainer_1).getMetamodel();
      EObject _eContainer_2 = att.eContainer();
      EClass _type = ((Element) _eContainer_2).getType();
      String _name = _type.getName();
      List<EAttribute> _eAttributes = this.getEAttributes(_metamodel, _name);
      scope.addAll(_eAttributes);
      _xblockexpression = Scopes.scopeFor(scope);
    }
    return _xblockexpression;
  }
  
  /**
   * It returns the list of classes defined in a meta-model.
   * @param String file containing the metamodel
   * @return List<EClass>
   */
  private List<EClass> getEClasses(final String metamodelFile) {
    try {
      final List<EPackage> metamodel = ModelManager.loadMetaModel(metamodelFile);
      final List<EClass> classes = new ArrayList<EClass>();
      for (final EPackage pck : metamodel) {
        EList<EClassifier> _eClassifiers = pck.getEClassifiers();
        for (final EClassifier cl : _eClassifiers) {
          if ((cl instanceof EClass)) {
            classes.add(((EClass) cl));
          }
        }
      }
      return classes;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * It return the list of attributes of a class.
   * @param String file containing the metamodel
   * @param String class name
   * @return List<EAttribute> list of attributes
   */
  private List<EAttribute> getEAttributes(final String metamodelFile, final String eclassName) {
    try {
      System.out.println((((("def private List<EAttribute> getEAttributes (String metamodelFile=" + metamodelFile) + ", String eclassName=") + eclassName) + ")"));
      final List<EPackage> metamodel = ModelManager.loadMetaModel(metamodelFile);
      EObject _objectOfType = ModelManager.getObjectOfType(eclassName, metamodel);
      final EClass eclass = ((EClass) _objectOfType);
      boolean _notEquals = (!Objects.equal(eclass, null));
      if (_notEquals) {
        return eclass.getEAllAttributes();
      } else {
        return new ArrayList<EAttribute>();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * It returns the list of references of a class.
   * @param String file containing the metamodel
   * @param String class name
   * @return List<EReference>
   */
  private List<EReference> getEReferences(final String metamodelFile, final String eclassName) {
    try {
      final List<EPackage> metamodel = ModelManager.loadMetaModel(metamodelFile);
      EObject _objectOfType = ModelManager.getObjectOfType(eclassName, metamodel);
      final EClass eclass = ((EClass) _objectOfType);
      boolean _notEquals = (!Objects.equal(eclass, null));
      if (_notEquals) {
        return eclass.getEAllReferences();
      } else {
        return new ArrayList<EReference>();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
