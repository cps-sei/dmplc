/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attributable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.Attributable#getAttrList <em>Attr List</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.Attributable#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getAttributable()
 * @model
 * @generated
 */
public interface Attributable extends NodeBodyElement
{
  /**
   * Returns the value of the '<em><b>Attr List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attr List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attr List</em>' containment reference.
   * @see #setAttrList(AttrList)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getAttributable_AttrList()
   * @model containment="true"
   * @generated
   */
  AttrList getAttrList();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.Attributable#getAttrList <em>Attr List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attr List</em>' containment reference.
   * @see #getAttrList()
   * @generated
   */
  void setAttrList(AttrList value);

  /**
   * Returns the value of the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference.
   * @see #setElement(AttributableElement)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getAttributable_Element()
   * @model containment="true"
   * @generated
   */
  AttributableElement getElement();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.Attributable#getElement <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' containment reference.
   * @see #getElement()
   * @generated
   */
  void setElement(AttributableElement value);

} // Attributable
