/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.UnaryExpr#getOperator <em>Operator</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.UnaryExpr#getOperand <em>Operand</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getUnaryExpr()
 * @model
 * @generated
 */
public interface UnaryExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link edu.cmu.sei.annex.dmpl.dmpl.UnaryOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.UnaryOperator
   * @see #setOperator(UnaryOperator)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getUnaryExpr_Operator()
   * @model
   * @generated
   */
  UnaryOperator getOperator();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.UnaryExpr#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.UnaryOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(UnaryOperator value);

  /**
   * Returns the value of the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand</em>' containment reference.
   * @see #setOperand(Expr)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getUnaryExpr_Operand()
   * @model containment="true"
   * @generated
   */
  Expr getOperand();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.UnaryExpr#getOperand <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' containment reference.
   * @see #getOperand()
   * @generated
   */
  void setOperand(Expr value);

} // UnaryExpr
