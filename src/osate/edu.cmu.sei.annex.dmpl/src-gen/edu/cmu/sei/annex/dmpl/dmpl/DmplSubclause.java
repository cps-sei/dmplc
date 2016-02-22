/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.AnnexSubclause;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subclause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.DmplSubclause#getFunctionCalls <em>Function Calls</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getDmplSubclause()
 * @model
 * @generated
 */
public interface DmplSubclause extends EObject, AnnexSubclause
{
  /**
   * Returns the value of the '<em><b>Function Calls</b></em>' containment reference list.
   * The list contents are of type {@link edu.cmu.sei.annex.dmpl.dmpl.FunctionCall}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function Calls</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function Calls</em>' containment reference list.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getDmplSubclause_FunctionCalls()
   * @model containment="true"
   * @generated
   */
  EList<FunctionCall> getFunctionCalls();

} // DmplSubclause
