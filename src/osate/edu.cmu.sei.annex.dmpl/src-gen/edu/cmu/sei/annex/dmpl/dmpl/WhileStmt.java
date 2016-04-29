/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.WhileStmt#getCondition <em>Condition</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.WhileStmt#getStmt <em>Stmt</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getWhileStmt()
 * @model
 * @generated
 */
public interface WhileStmt extends Stmt
{
  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Expr)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getWhileStmt_Condition()
   * @model containment="true"
   * @generated
   */
  Expr getCondition();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.WhileStmt#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Expr value);

  /**
   * Returns the value of the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stmt</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stmt</em>' containment reference.
   * @see #setStmt(Stmt)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getWhileStmt_Stmt()
   * @model containment="true"
   * @generated
   */
  Stmt getStmt();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.WhileStmt#getStmt <em>Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stmt</em>' containment reference.
   * @see #getStmt()
   * @generated
   */
  void setStmt(Stmt value);

} // WhileStmt
