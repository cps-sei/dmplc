/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.FnBody#getVarInits <em>Var Inits</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.FnBody#getStmts <em>Stmts</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFnBody()
 * @model
 * @generated
 */
public interface FnBody extends EObject
{
  /**
   * Returns the value of the '<em><b>Var Inits</b></em>' containment reference list.
   * The list contents are of type {@link edu.cmu.sei.annex.dmpl.dmpl.VarInit}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var Inits</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var Inits</em>' containment reference list.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFnBody_VarInits()
   * @model containment="true"
   * @generated
   */
  EList<VarInit> getVarInits();

  /**
   * Returns the value of the '<em><b>Stmts</b></em>' containment reference list.
   * The list contents are of type {@link edu.cmu.sei.annex.dmpl.dmpl.Stmt}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stmts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stmts</em>' containment reference list.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFnBody_Stmts()
   * @model containment="true"
   * @generated
   */
  EList<Stmt> getStmts();

} // FnBody
