/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.ForStmt#getInits <em>Inits</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.ForStmt#getCondition <em>Condition</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.ForStmt#getUpdate <em>Update</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.ForStmt#getStmt <em>Stmt</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getForStmt()
 * @model
 * @generated
 */
public interface ForStmt extends Stmt
{
  /**
   * Returns the value of the '<em><b>Inits</b></em>' containment reference list.
   * The list contents are of type {@link edu.cmu.sei.annex.dmpl.dmpl.AssignmentStmt}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inits</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inits</em>' containment reference list.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getForStmt_Inits()
   * @model containment="true"
   * @generated
   */
  EList<AssignmentStmt> getInits();

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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getForStmt_Condition()
   * @model containment="true"
   * @generated
   */
  Expr getCondition();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.ForStmt#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Expr value);

  /**
   * Returns the value of the '<em><b>Update</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Update</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Update</em>' containment reference.
   * @see #setUpdate(AssignmentStmt)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getForStmt_Update()
   * @model containment="true"
   * @generated
   */
  AssignmentStmt getUpdate();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.ForStmt#getUpdate <em>Update</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Update</em>' containment reference.
   * @see #getUpdate()
   * @generated
   */
  void setUpdate(AssignmentStmt value);

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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getForStmt_Stmt()
   * @model containment="true"
   * @generated
   */
  Stmt getStmt();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.ForStmt#getStmt <em>Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stmt</em>' containment reference.
   * @see #getStmt()
   * @generated
   */
  void setStmt(Stmt value);

} // ForStmt
