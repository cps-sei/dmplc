/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fn Var Asgn</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.FnVarAsgn#getFnBody <em>Fn Body</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFnVarAsgn()
 * @model
 * @generated
 */
public interface FnVarAsgn extends VarAsgn
{
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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFnVarAsgn_FnBody()
   * @model containment="true"
   * @generated
   */
  FnBody getFnBody();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.FnVarAsgn#getFnBody <em>Fn Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fn Body</em>' containment reference.
   * @see #getFnBody()
   * @generated
   */
  void setFnBody(FnBody value);

} // FnVarAsgn
