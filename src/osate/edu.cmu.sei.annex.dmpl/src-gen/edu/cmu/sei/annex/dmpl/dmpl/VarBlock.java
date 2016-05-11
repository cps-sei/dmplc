/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.VarBlock#getVar <em>Var</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getVarBlock()
 * @model
 * @generated
 */
public interface VarBlock extends NodeBodyElement
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
   * @see #setVar(NodeVarInit)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getVarBlock_Var()
   * @model containment="true"
   * @generated
   */
  NodeVarInit getVar();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.VarBlock#getVar <em>Var</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var</em>' containment reference.
   * @see #getVar()
   * @generated
   */
  void setVar(NodeVarInit value);

} // VarBlock
