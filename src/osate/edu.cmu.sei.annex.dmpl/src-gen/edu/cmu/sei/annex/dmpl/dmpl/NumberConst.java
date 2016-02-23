/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Number Const</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.NumberConst#getSign <em>Sign</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getNumberConst()
 * @model
 * @generated
 */
public interface NumberConst extends EObject
{
  /**
   * Returns the value of the '<em><b>Sign</b></em>' attribute.
   * The literals are from the enumeration {@link edu.cmu.sei.annex.dmpl.dmpl.SignEnum}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sign</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sign</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.SignEnum
   * @see #setSign(SignEnum)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getNumberConst_Sign()
   * @model
   * @generated
   */
  SignEnum getSign();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.NumberConst#getSign <em>Sign</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sign</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.SignEnum
   * @see #getSign()
   * @generated
   */
  void setSign(SignEnum value);

} // NumberConst
