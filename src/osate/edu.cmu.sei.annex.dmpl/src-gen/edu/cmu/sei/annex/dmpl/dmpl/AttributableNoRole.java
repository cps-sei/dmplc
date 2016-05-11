/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attributable No Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.AttributableNoRole#getAttrList <em>Attr List</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.AttributableNoRole#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getAttributableNoRole()
 * @model
 * @generated
 */
public interface AttributableNoRole extends RoleBodyElement
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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getAttributableNoRole_AttrList()
   * @model containment="true"
   * @generated
   */
  AttrList getAttrList();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.AttributableNoRole#getAttrList <em>Attr List</em>}' containment reference.
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
   * @see #setElement(AttributableNoRoleElement)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getAttributableNoRole_Element()
   * @model containment="true"
   * @generated
   */
  AttributableNoRoleElement getElement();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.AttributableNoRole#getElement <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' containment reference.
   * @see #getElement()
   * @generated
   */
  void setElement(AttributableNoRoleElement value);

} // AttributableNoRole
