/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cond Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmt#getAttrList <em>Attr List</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmt#getStmt <em>Stmt</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCondStmt()
 * @model
 * @generated
 */
public interface CondStmt extends Stmt
{
  /**
   * Returns the value of the '<em><b>Attr List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attr List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attr List</em>' containment reference.
   * @see #setAttrList(AttrList)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCondStmt_AttrList()
   * @model containment="true"
   * @generated
   */
  AttrList getAttrList();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmt#getAttrList <em>Attr List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attr List</em>' containment reference.
   * @see #getAttrList()
   * @generated
   */
  void setAttrList(AttrList value);

  /**
   * Returns the value of the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stmt</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stmt</em>' containment reference.
   * @see #setStmt(CondStmtNoAttr)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCondStmt_Stmt()
   * @model containment="true"
   * @generated
   */
  CondStmtNoAttr getStmt();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmt#getStmt <em>Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stmt</em>' containment reference.
   * @see #getStmt()
   * @generated
   */
  void setStmt(CondStmtNoAttr value);

} // CondStmt
