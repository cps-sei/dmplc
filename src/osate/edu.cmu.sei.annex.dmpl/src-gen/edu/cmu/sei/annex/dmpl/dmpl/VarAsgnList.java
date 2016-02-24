/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Asgn List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgnList#getVar <em>Var</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgnList#getVarAsgn <em>Var Asgn</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getVarAsgnList()
 * @model
 * @generated
 */
public interface VarAsgnList extends EObject
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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getVarAsgnList_Var()
   * @model containment="true"
   * @generated
   */
  Var getVar();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgnList#getVar <em>Var</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var</em>' containment reference.
   * @see #getVar()
   * @generated
   */
  void setVar(Var value);

  /**
   * Returns the value of the '<em><b>Var Asgn</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var Asgn</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var Asgn</em>' containment reference.
   * @see #setVarAsgn(VarAsgn)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getVarAsgnList_VarAsgn()
   * @model containment="true"
   * @generated
   */
  VarAsgn getVarAsgn();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgnList#getVarAsgn <em>Var Asgn</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var Asgn</em>' containment reference.
   * @see #getVarAsgn()
   * @generated
   */
  void setVarAsgn(VarAsgn value);

} // VarAsgnList
