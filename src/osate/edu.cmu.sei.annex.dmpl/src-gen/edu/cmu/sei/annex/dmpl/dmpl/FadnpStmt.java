/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fadnp Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt#getNode1 <em>Node1</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt#getNode2 <em>Node2</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt#getStmt <em>Stmt</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFadnpStmt()
 * @model
 * @generated
 */
public interface FadnpStmt extends Stmt
{
  /**
   * Returns the value of the '<em><b>Node1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node1</em>' attribute.
   * @see #setNode1(String)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFadnpStmt_Node1()
   * @model
   * @generated
   */
  String getNode1();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt#getNode1 <em>Node1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node1</em>' attribute.
   * @see #getNode1()
   * @generated
   */
  void setNode1(String value);

  /**
   * Returns the value of the '<em><b>Node2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node2</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node2</em>' attribute.
   * @see #setNode2(String)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFadnpStmt_Node2()
   * @model
   * @generated
   */
  String getNode2();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt#getNode2 <em>Node2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node2</em>' attribute.
   * @see #getNode2()
   * @generated
   */
  void setNode2(String value);

  /**
   * Returns the value of the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stmt</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stmt</em>' containment reference.
   * @see #setStmt(Stmt)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getFadnpStmt_Stmt()
   * @model containment="true"
   * @generated
   */
  Stmt getStmt();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt#getStmt <em>Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stmt</em>' containment reference.
   * @see #getStmt()
   * @generated
   */
  void setStmt(Stmt value);

} // FadnpStmt
