/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Procedure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure#isOverride <em>Override</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure#getPrototype <em>Prototype</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure#getFnBody <em>Fn Body</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getProcedure()
 * @model
 * @generated
 */
public interface Procedure extends AttributableNodeOrProcedure, AttributableElement, AttributableNoRoleElement
{
  /**
   * Returns the value of the '<em><b>Override</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Override</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Override</em>' attribute.
   * @see #setOverride(boolean)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getProcedure_Override()
   * @model
   * @generated
   */
  boolean isOverride();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure#isOverride <em>Override</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Override</em>' attribute.
   * @see #isOverride()
   * @generated
   */
  void setOverride(boolean value);

  /**
   * Returns the value of the '<em><b>Prototype</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Prototype</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Prototype</em>' containment reference.
   * @see #setPrototype(FnPrototype)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getProcedure_Prototype()
   * @model containment="true"
   * @generated
   */
  FnPrototype getPrototype();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure#getPrototype <em>Prototype</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prototype</em>' containment reference.
   * @see #getPrototype()
   * @generated
   */
  void setPrototype(FnPrototype value);

  /**
   * Returns the value of the '<em><b>Fn Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fn Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fn Body</em>' containment reference.
   * @see #setFnBody(FnBody)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getProcedure_FnBody()
   * @model containment="true"
   * @generated
   */
  FnBody getFnBody();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure#getFnBody <em>Fn Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fn Body</em>' containment reference.
   * @see #getFnBody()
   * @generated
   */
  void setFnBody(FnBody value);

} // Procedure
