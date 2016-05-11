/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cond Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmt#getAttrs <em>Attrs</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmt#getCondition <em>Condition</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmt#getThen <em>Then</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmt#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCondStmt()
 * @model
 * @generated
 */
public interface CondStmt extends Stmt
{
  /**
   * Returns the value of the '<em><b>Attrs</b></em>' containment reference list.
   * The list contents are of type {@link edu.cmu.sei.annex.dmpl.dmpl.Attr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attrs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attrs</em>' containment reference list.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCondStmt_Attrs()
   * @model containment="true"
   * @generated
   */
  EList<Attr> getAttrs();

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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCondStmt_Condition()
   * @model containment="true"
   * @generated
   */
  Expr getCondition();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmt#getCondition <em>Condition</em>}' containment reference.
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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCondStmt_Then()
   * @model containment="true"
   * @generated
   */
  Stmt getThen();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmt#getThen <em>Then</em>}' containment reference.
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
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getCondStmt_Else()
   * @model containment="true"
   * @generated
   */
  Stmt getElse();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmt#getElse <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else</em>' containment reference.
   * @see #getElse()
   * @generated
   */
  void setElse(Stmt value);

} // CondStmt
