/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arg List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.ArgList#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getArgList()
 * @model
 * @generated
 */
public interface ArgList extends EObject
{
  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link edu.cmu.sei.annex.dmpl.dmpl.Expr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getArgList_Args()
   * @model containment="true"
   * @generated
   */
  EList<Expr> getArgs();

} // ArgList
