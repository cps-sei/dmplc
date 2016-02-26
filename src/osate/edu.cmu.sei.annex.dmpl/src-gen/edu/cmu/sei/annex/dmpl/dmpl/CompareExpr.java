/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compare Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.CompareExpr#getLeft <em>Left</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.CompareExpr#getOperator <em>Operator</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.CompareExpr#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCompareExpr()
 * @model
 * @generated
 */
public interface CompareExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Expr)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCompareExpr_Left()
   * @model containment="true"
   * @generated
   */
  Expr getLeft();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.CompareExpr#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expr value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link edu.cmu.sei.annex.dmpl.dmpl.CompareOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.CompareOperator
   * @see #setOperator(CompareOperator)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCompareExpr_Operator()
   * @model
   * @generated
   */
  CompareOperator getOperator();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.CompareExpr#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.CompareOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(CompareOperator value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Expr)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCompareExpr_Right()
   * @model containment="true"
   * @generated
   */
  Expr getRight();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.CompareExpr#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Expr value);

} // CompareExpr
