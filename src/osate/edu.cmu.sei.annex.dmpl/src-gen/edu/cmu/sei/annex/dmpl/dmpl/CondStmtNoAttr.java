/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cond Stmt No Attr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmtNoAttr#getCondition <em>Condition</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmtNoAttr#getThen <em>Then</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmtNoAttr#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCondStmtNoAttr()
 * @model
 * @generated
 */
public interface CondStmtNoAttr extends EObject
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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCondStmtNoAttr_Condition()
   * @model containment="true"
   * @generated
   */
  Expr getCondition();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmtNoAttr#getCondition <em>Condition</em>}' containment reference.
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
   * @see #setThen(Stmt)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCondStmtNoAttr_Then()
   * @model containment="true"
   * @generated
   */
  Stmt getThen();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmtNoAttr#getThen <em>Then</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then</em>' containment reference.
   * @see #getThen()
   * @generated
   */
  void setThen(Stmt value);

  /**
   * Returns the value of the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else</em>' containment reference.
   * @see #setElse(Stmt)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCondStmtNoAttr_Else()
   * @model containment="true"
   * @generated
   */
  Stmt getElse();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmtNoAttr#getElse <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else</em>' containment reference.
   * @see #getElse()
   * @generated
   */
  void setElse(Stmt value);

} // CondStmtNoAttr
