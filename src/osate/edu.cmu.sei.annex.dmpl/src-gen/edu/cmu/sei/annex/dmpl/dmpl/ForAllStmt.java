/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For All Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt#getName <em>Name</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt#getNode <em>Node</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt#getStmt <em>Stmt</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getForAllStmt()
 * @model
 * @generated
 */
public interface ForAllStmt extends Stmt
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * The literals are from the enumeration {@link edu.cmu.sei.annex.dmpl.dmpl.ForAllFunctionEnum}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ForAllFunctionEnum
   * @see #setName(ForAllFunctionEnum)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getForAllStmt_Name()
   * @model
   * @generated
   */
  ForAllFunctionEnum getName();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ForAllFunctionEnum
   * @see #getName()
   * @generated
   */
  void setName(ForAllFunctionEnum value);

  /**
   * Returns the value of the '<em><b>Node</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node</em>' attribute.
   * @see #setNode(String)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getForAllStmt_Node()
   * @model
   * @generated
   */
  String getNode();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt#getNode <em>Node</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node</em>' attribute.
   * @see #getNode()
   * @generated
   */
  void setNode(String value);

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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getForAllStmt_Stmt()
   * @model containment="true"
   * @generated
   */
  Stmt getStmt();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt#getStmt <em>Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stmt</em>' containment reference.
   * @see #getStmt()
   * @generated
   */
  void setStmt(Stmt value);

} // ForAllStmt
