/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.CallExpr#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.CallExpr#getName <em>Name</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.CallExpr#getArgList <em>Arg List</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.CallExpr#getAt <em>At</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCallExpr()
 * @model
 * @generated
 */
public interface CallExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Namespace</em>' attribute.
   * @see #setNamespace(String)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCallExpr_Namespace()
   * @model
   * @generated
   */
  String getNamespace();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.CallExpr#getNamespace <em>Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Namespace</em>' attribute.
   * @see #getNamespace()
   * @generated
   */
  void setNamespace(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCallExpr_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.CallExpr#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Arg List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arg List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arg List</em>' containment reference.
   * @see #setArgList(ArgList)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCallExpr_ArgList()
   * @model containment="true"
   * @generated
   */
  ArgList getArgList();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.CallExpr#getArgList <em>Arg List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arg List</em>' containment reference.
   * @see #getArgList()
   * @generated
   */
  void setArgList(ArgList value);

  /**
   * Returns the value of the '<em><b>At</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>At</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>At</em>' containment reference.
   * @see #setAt(Expr)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCallExpr_At()
   * @model containment="true"
   * @generated
   */
  Expr getAt();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.CallExpr#getAt <em>At</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>At</em>' containment reference.
   * @see #getAt()
   * @generated
   */
  void setAt(Expr value);

} // CallExpr
