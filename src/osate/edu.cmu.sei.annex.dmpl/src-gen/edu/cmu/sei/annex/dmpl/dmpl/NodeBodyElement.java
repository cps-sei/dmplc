/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Body Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.NodeBodyElement#isOverride <em>Override</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getNodeBodyElement()
 * @model
 * @generated
 */
public interface NodeBodyElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Override</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Override</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Override</em>' attribute.
   * @see #setOverride(boolean)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getNodeBodyElement_Override()
   * @model
   * @generated
   */
  boolean isOverride();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.NodeBodyElement#isOverride <em>Override</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Override</em>' attribute.
   * @see #isOverride()
   * @generated
   */
  void setOverride(boolean value);

} // NodeBodyElement
