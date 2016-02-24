/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proc No Attr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.ProcNoAttr#getPrototype <em>Prototype</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.ProcNoAttr#getFnBody <em>Fn Body</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getProcNoAttr()
 * @model
 * @generated
 */
public interface ProcNoAttr extends EObject
{
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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getProcNoAttr_Prototype()
   * @model containment="true"
   * @generated
   */
  FnPrototype getPrototype();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.ProcNoAttr#getPrototype <em>Prototype</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prototype</em>' containment reference.
   * @see #getPrototype()
   * @generated
   */
  void setPrototype(FnPrototype value);

  /**
   * Returns the value of the '<em><b>Fn Body</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fn Body</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fn Body</em>' attribute.
   * @see #setFnBody(String)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getProcNoAttr_FnBody()
   * @model
   * @generated
   */
  String getFnBody();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.ProcNoAttr#getFnBody <em>Fn Body</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fn Body</em>' attribute.
   * @see #getFnBody()
   * @generated
   */
  void setFnBody(String value);

} // ProcNoAttr
