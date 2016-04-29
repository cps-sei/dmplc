/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Return Value Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.ReturnValueStmt#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getReturnValueStmt()
 * @model
 * @generated
 */
public interface ReturnValueStmt extends Stmt
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Expr)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getReturnValueStmt_Value()
   * @model containment="true"
   * @generated
   */
  Expr getValue();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.ReturnValueStmt#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Expr value);

} // ReturnValueStmt
