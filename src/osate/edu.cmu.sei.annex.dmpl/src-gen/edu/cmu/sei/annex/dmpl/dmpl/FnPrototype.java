/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fn Prototype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototype#isExtern <em>Extern</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototype#isPure <em>Pure</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototype#getPrototype <em>Prototype</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFnPrototype()
 * @model
 * @generated
 */
public interface FnPrototype extends EObject
{
  /**
   * Returns the value of the '<em><b>Extern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extern</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extern</em>' attribute.
   * @see #setExtern(boolean)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFnPrototype_Extern()
   * @model
   * @generated
   */
  boolean isExtern();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototype#isExtern <em>Extern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extern</em>' attribute.
   * @see #isExtern()
   * @generated
   */
  void setExtern(boolean value);

  /**
   * Returns the value of the '<em><b>Pure</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pure</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pure</em>' attribute.
   * @see #setPure(boolean)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFnPrototype_Pure()
   * @model
   * @generated
   */
  boolean isPure();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototype#isPure <em>Pure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pure</em>' attribute.
   * @see #isPure()
   * @generated
   */
  void setPure(boolean value);

  /**
   * Returns the value of the '<em><b>Prototype</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Prototype</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Prototype</em>' containment reference.
   * @see #setPrototype(FnPrototypeNoDecors)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFnPrototype_Prototype()
   * @model containment="true"
   * @generated
   */
  FnPrototypeNoDecors getPrototype();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototype#getPrototype <em>Prototype</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prototype</em>' containment reference.
   * @see #getPrototype()
   * @generated
   */
  void setPrototype(FnPrototypeNoDecors value);

} // FnPrototype
