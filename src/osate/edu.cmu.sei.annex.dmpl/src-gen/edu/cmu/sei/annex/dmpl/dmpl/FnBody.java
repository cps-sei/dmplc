/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fn Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.FnBody#getVarInitList <em>Var Init List</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.FnBody#getStmtList <em>Stmt List</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFnBody()
 * @model
 * @generated
 */
public interface FnBody extends EObject
{
  /**
   * Returns the value of the '<em><b>Var Init List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var Init List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var Init List</em>' containment reference.
   * @see #setVarInitList(VarInitList)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFnBody_VarInitList()
   * @model containment="true"
   * @generated
   */
  VarInitList getVarInitList();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.FnBody#getVarInitList <em>Var Init List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var Init List</em>' containment reference.
   * @see #getVarInitList()
   * @generated
   */
  void setVarInitList(VarInitList value);

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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFnBody_StmtList()
   * @model containment="true"
   * @generated
   */
  StmtList getStmtList();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.FnBody#getStmtList <em>Stmt List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stmt List</em>' containment reference.
   * @see #getStmtList()
   * @generated
   */
  void setStmtList(StmtList value);

} // FnBody
