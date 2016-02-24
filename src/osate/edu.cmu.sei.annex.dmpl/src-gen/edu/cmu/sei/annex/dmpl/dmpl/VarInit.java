/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.VarInit#getType <em>Type</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.VarInit#getVarAsgnList <em>Var Asgn List</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getVarInit()
 * @model
 * @generated
 */
public interface VarInit extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(Type)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getVarInit_Type()
   * @model containment="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.VarInit#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

  /**
   * Returns the value of the '<em><b>Var Asgn List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var Asgn List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var Asgn List</em>' containment reference.
   * @see #setVarAsgnList(VarAsgnList)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getVarInit_VarAsgnList()
   * @model containment="true"
   * @generated
   */
  VarAsgnList getVarAsgnList();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.VarInit#getVarAsgnList <em>Var Asgn List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var Asgn List</em>' containment reference.
   * @see #getVarAsgnList()
   * @generated
   */
  void setVarAsgnList(VarAsgnList value);

} // VarInit
