/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.Expr#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getExpr()
 * @model
 * @generated
 */
public interface Expr extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(int)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getExpr_Value()
   * @model
   * @generated
   */
  int getValue();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.Expr#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(int value);

} // Expr
