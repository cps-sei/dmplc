/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Asgn</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgn#getVar <em>Var</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgn#getFnBody <em>Fn Body</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgn#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getVarAsgn()
 * @model
 * @generated
 */
public interface VarAsgn extends EObject
{
  /**
   * Returns the value of the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var</em>' containment reference.
   * @see #setVar(Var)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getVarAsgn_Var()
   * @model containment="true"
   * @generated
   */
  Var getVar();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgn#getVar <em>Var</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var</em>' containment reference.
   * @see #getVar()
   * @generated
   */
  void setVar(Var value);

  /**
   * Returns the value of the '<em><b>Fn Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fn Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fn Body</em>' containment reference.
   * @see #setFnBody(FnBody)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getVarAsgn_FnBody()
   * @model containment="true"
   * @generated
   */
  FnBody getFnBody();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgn#getFnBody <em>Fn Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fn Body</em>' containment reference.
   * @see #getFnBody()
   * @generated
   */
  void setFnBody(FnBody value);

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expr)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getVarAsgn_Expr()
   * @model containment="true"
   * @generated
   */
  Expr getExpr();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgn#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expr value);

} // VarAsgn
