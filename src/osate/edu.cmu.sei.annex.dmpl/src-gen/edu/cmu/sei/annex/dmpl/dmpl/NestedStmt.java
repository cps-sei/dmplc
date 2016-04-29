/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nested Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.NestedStmt#getStmtList <em>Stmt List</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getNestedStmt()
 * @model
 * @generated
 */
public interface NestedStmt extends Stmt
{
  /**
   * Returns the value of the '<em><b>Stmt List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stmt List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stmt List</em>' containment reference.
   * @see #setStmtList(StmtList)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getNestedStmt_StmtList()
   * @model containment="true"
   * @generated
   */
  StmtList getStmtList();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.NestedStmt#getStmtList <em>Stmt List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stmt List</em>' containment reference.
   * @see #getStmtList()
   * @generated
   */
  void setStmtList(StmtList value);

} // NestedStmt
