/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.Role#getRole <em>Role</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getRole()
 * @model
 * @generated
 */
public interface Role extends AttributableElement
{
  /**
   * Returns the value of the '<em><b>Role</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Role</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Role</em>' containment reference.
   * @see #setRole(RoleNoAttr)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getRole_Role()
   * @model containment="true"
   * @generated
   */
  RoleNoAttr getRole();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.Role#getRole <em>Role</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Role</em>' containment reference.
   * @see #getRole()
   * @generated
   */
  void setRole(RoleNoAttr value);

} // Role
