/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.Type#getSigned <em>Signed</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.Type#getSimpType <em>Simp Type</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getType()
 * @model
 * @generated
 */
public interface Type extends EObject
{
  /**
   * Returns the value of the '<em><b>Signed</b></em>' attribute.
   * The literals are from the enumeration {@link edu.cmu.sei.annex.dmpl.dmpl.SignedEnum}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Signed</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signed</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.SignedEnum
   * @see #setSigned(SignedEnum)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getType_Signed()
   * @model
   * @generated
   */
  SignedEnum getSigned();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.Type#getSigned <em>Signed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Signed</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.SignedEnum
   * @see #getSigned()
   * @generated
   */
  void setSigned(SignedEnum value);

  /**
   * Returns the value of the '<em><b>Simp Type</b></em>' attribute.
   * The literals are from the enumeration {@link edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Simp Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Simp Type</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum
   * @see #setSimpType(SimpTypeEnum)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getType_SimpType()
   * @model
   * @generated
   */
  SimpTypeEnum getSimpType();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.Type#getSimpType <em>Simp Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Simp Type</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum
   * @see #getSimpType()
   * @generated
   */
  void setSimpType(SimpTypeEnum value);

} // Type
