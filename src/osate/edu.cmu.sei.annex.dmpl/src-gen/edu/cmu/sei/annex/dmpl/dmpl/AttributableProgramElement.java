/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attributable Program Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.AttributableProgramElement#getAttrs <em>Attrs</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.AttributableProgramElement#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getAttributableProgramElement()
 * @model
 * @generated
 */
public interface AttributableProgramElement extends ProgramElement
{
  /**
   * Returns the value of the '<em><b>Attrs</b></em>' containment reference list.
   * The list contents are of type {@link edu.cmu.sei.annex.dmpl.dmpl.Attr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attrs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attrs</em>' containment reference list.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getAttributableProgramElement_Attrs()
   * @model containment="true"
   * @generated
   */
  EList<Attr> getAttrs();

  /**
   * Returns the value of the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference.
   * @see #setElement(AttributableNodeOrProcedure)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getAttributableProgramElement_Element()
   * @model containment="true"
   * @generated
   */
  AttributableNodeOrProcedure getElement();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.AttributableProgramElement#getElement <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' containment reference.
   * @see #getElement()
   * @generated
   */
  void setElement(AttributableNodeOrProcedure value);

} // AttributableProgramElement
