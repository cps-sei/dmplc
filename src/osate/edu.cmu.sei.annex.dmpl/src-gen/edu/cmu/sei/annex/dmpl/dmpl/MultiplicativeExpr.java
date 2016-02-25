/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicative Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr#getLeft <em>Left</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr#getOperator <em>Operator</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getMultiplicativeExpr()
 * @model
 * @generated
 */
public interface MultiplicativeExpr extends Expr
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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getMultiplicativeExpr_Left()
   * @model containment="true"
   * @generated
   */
  Expr getLeft();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expr value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeOperator
   * @see #setOperator(MultiplicativeOperator)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getMultiplicativeExpr_Operator()
   * @model
   * @generated
   */
  MultiplicativeOperator getOperator();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(MultiplicativeOperator value);

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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getMultiplicativeExpr_Right()
   * @model containment="true"
   * @generated
   */
  Expr getRight();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Expr value);

} // MultiplicativeExpr
