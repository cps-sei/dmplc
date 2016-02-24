/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fn Prototype Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeDeclaration#getType <em>Type</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeDeclaration#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFnPrototypeDeclaration()
 * @model
 * @generated
 */
public interface FnPrototypeDeclaration extends FnPrototypeNoDecors
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(Type)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFnPrototypeDeclaration_Type()
   * @model containment="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeDeclaration#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference list.
   * The list contents are of type {@link edu.cmu.sei.annex.dmpl.dmpl.Param}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference list.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFnPrototypeDeclaration_Params()
   * @model containment="true"
   * @generated
   */
  EList<Param> getParams();

} // FnPrototypeDeclaration
