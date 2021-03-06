/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xor Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.XorExpr#getLeft <em>Left</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.XorExpr#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getXorExpr()
 * @model
 * @generated
 */
public interface XorExpr extends Expr
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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getXorExpr_Left()
   * @model containment="true"
   * @generated
   */
  Expr getLeft();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.XorExpr#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expr value);

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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getXorExpr_Right()
   * @model containment="true"
   * @generated
   */
  Expr getRight();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.XorExpr#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Expr value);

} // XorExpr
