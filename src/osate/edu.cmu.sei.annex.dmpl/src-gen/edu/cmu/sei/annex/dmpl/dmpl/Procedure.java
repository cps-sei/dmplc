/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Procedure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure#getAttrList <em>Attr List</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure#getPrototype <em>Prototype</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure#getFnBody <em>Fn Body</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getProcedure()
 * @model
 * @generated
 */
public interface Procedure extends ProgramElement, NodeBodyElement
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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getProcedure_AttrList()
   * @model containment="true"
   * @generated
   */
  AttrList getAttrList();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure#getAttrList <em>Attr List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attr List</em>' containment reference.
   * @see #getAttrList()
   * @generated
   */
  void setAttrList(AttrList value);

  /**
   * Returns the value of the '<em><b>Prototype</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Prototype</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Prototype</em>' containment reference.
   * @see #setPrototype(FnPrototype)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getProcedure_Prototype()
   * @model containment="true"
   * @generated
   */
  FnPrototype getPrototype();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure#getPrototype <em>Prototype</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prototype</em>' containment reference.
   * @see #getPrototype()
   * @generated
   */
  void setPrototype(FnPrototype value);

  /**
   * Returns the value of the '<em><b>Fn Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fn Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fn Body</em>' containment reference.
   * @see #setFnBody(FnBody)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getProcedure_FnBody()
   * @model containment="true"
   * @generated
   */
  FnBody getFnBody();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure#getFnBody <em>Fn Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fn Body</em>' containment reference.
   * @see #getFnBody()
   * @generated
   */
  void setFnBody(FnBody value);

} // Procedure
