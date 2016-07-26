/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.Target#getNames <em>Names</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.Target#getThunk <em>Thunk</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getTarget()
 * @model
 * @generated
 */
public interface Target extends ProgramElement
{
  /**
   * Returns the value of the '<em><b>Names</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Names</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Names</em>' attribute list.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getTarget_Names()
   * @model unique="false"
   * @generated
   */
  EList<String> getNames();

  /**
   * Returns the value of the '<em><b>Thunk</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Thunk</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Thunk</em>' attribute.
   * @see #setThunk(String)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getTarget_Thunk()
   * @model
   * @generated
   */
  String getThunk();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.Target#getThunk <em>Thunk</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Thunk</em>' attribute.
   * @see #getThunk()
   * @generated
   */
  void setThunk(String value);

} // Target
