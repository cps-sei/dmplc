/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ternary Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr#getCondition <em>Condition</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr#getThen <em>Then</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getTernaryExpr()
 * @model
 * @generated
 */
public interface TernaryExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Expr)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getTernaryExpr_Condition()
   * @model containment="true"
   * @generated
   */
  Expr getCondition();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Expr value);

  /**
   * Returns the value of the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then</em>' containment reference.
   * @see #setThen(Expr)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getTernaryExpr_Then()
   * @model containment="true"
   * @generated
   */
  Expr getThen();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr#getThen <em>Then</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then</em>' containment reference.
   * @see #getThen()
   * @generated
   */
  void setThen(Expr value);

  /**
   * Returns the value of the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else</em>' containment reference.
   * @see #setElse(Expr)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getTernaryExpr_Else()
   * @model containment="true"
   * @generated
   */
  Expr getElse();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr#getElse <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else</em>' containment reference.
   * @see #getElse()
   * @generated
   */
  void setElse(Expr value);

} // TernaryExpr
