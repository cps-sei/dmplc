/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.SimpleStmt#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getSimpleStmt()
 * @model
 * @generated
 */
public interface SimpleStmt extends Stmt
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * The literals are from the enumeration {@link edu.cmu.sei.annex.dmpl.dmpl.SimpleStmtKeywordEnum}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.SimpleStmtKeywordEnum
   * @see #setName(SimpleStmtKeywordEnum)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getSimpleStmt_Name()
   * @model
   * @generated
   */
  SimpleStmtKeywordEnum getName();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.SimpleStmt#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.SimpleStmtKeywordEnum
   * @see #getName()
   * @generated
   */
  void setName(SimpleStmtKeywordEnum value);

} // SimpleStmt
