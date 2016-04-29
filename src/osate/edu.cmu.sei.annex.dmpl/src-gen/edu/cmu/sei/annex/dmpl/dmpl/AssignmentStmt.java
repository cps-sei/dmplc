/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.AssignmentStmt#getVariable <em>Variable</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.AssignmentStmt#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getAssignmentStmt()
 * @model
 * @generated
 */
public interface AssignmentStmt extends Stmt
{
  /**
   * Returns the value of the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' containment reference.
   * @see #setVariable(LVal)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getAssignmentStmt_Variable()
   * @model containment="true"
   * @generated
   */
  LVal getVariable();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.AssignmentStmt#getVariable <em>Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' containment reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(LVal value);

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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getAssignmentStmt_Value()
   * @model containment="true"
   * @generated
   */
  Expr getValue();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.AssignmentStmt#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Expr value);

} // AssignmentStmt
