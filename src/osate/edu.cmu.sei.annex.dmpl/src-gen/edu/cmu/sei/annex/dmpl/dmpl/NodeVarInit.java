/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Var Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.NodeVarInit#getScope <em>Scope</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.NodeVarInit#getVar <em>Var</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getNodeVarInit()
 * @model
 * @generated
 */
public interface NodeVarInit extends EObject
{
  /**
   * Returns the value of the '<em><b>Scope</b></em>' attribute.
   * The literals are from the enumeration {@link edu.cmu.sei.annex.dmpl.dmpl.NodeVarScopeEnum}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scope</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scope</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.NodeVarScopeEnum
   * @see #setScope(NodeVarScopeEnum)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getNodeVarInit_Scope()
   * @model
   * @generated
   */
  NodeVarScopeEnum getScope();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.NodeVarInit#getScope <em>Scope</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scope</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.NodeVarScopeEnum
   * @see #getScope()
   * @generated
   */
  void setScope(NodeVarScopeEnum value);

  /**
   * Returns the value of the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var</em>' containment reference.
   * @see #setVar(VarInit)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getNodeVarInit_Var()
   * @model containment="true"
   * @generated
   */
  VarInit getVar();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.NodeVarInit#getVar <em>Var</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var</em>' containment reference.
   * @see #getVar()
   * @generated
   */
  void setVar(VarInit value);

} // NodeVarInit
