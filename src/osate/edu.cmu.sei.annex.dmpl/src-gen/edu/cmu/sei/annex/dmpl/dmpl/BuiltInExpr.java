/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Built In Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr#getFunction <em>Function</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr#getFirstArg <em>First Arg</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr#getSecondArg <em>Second Arg</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getBuiltInExpr()
 * @model
 * @generated
 */
public interface BuiltInExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Function</b></em>' attribute.
   * The literals are from the enumeration {@link edu.cmu.sei.annex.dmpl.dmpl.BuiltInFunctionEnum}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.BuiltInFunctionEnum
   * @see #setFunction(BuiltInFunctionEnum)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getBuiltInExpr_Function()
   * @model
   * @generated
   */
  BuiltInFunctionEnum getFunction();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr#getFunction <em>Function</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function</em>' attribute.
   * @see edu.cmu.sei.annex.dmpl.dmpl.BuiltInFunctionEnum
   * @see #getFunction()
   * @generated
   */
  void setFunction(BuiltInFunctionEnum value);

  /**
   * Returns the value of the '<em><b>First Arg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First Arg</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First Arg</em>' attribute.
   * @see #setFirstArg(String)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getBuiltInExpr_FirstArg()
   * @model
   * @generated
   */
  String getFirstArg();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr#getFirstArg <em>First Arg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First Arg</em>' attribute.
   * @see #getFirstArg()
   * @generated
   */
  void setFirstArg(String value);

  /**
   * Returns the value of the '<em><b>Second Arg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second Arg</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second Arg</em>' containment reference.
   * @see #setSecondArg(Expr)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getBuiltInExpr_SecondArg()
   * @model containment="true"
   * @generated
   */
  Expr getSecondArg();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr#getSecondArg <em>Second Arg</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Second Arg</em>' containment reference.
   * @see #getSecondArg()
   * @generated
   */
  void setSecondArg(Expr value);

} // BuiltInExpr
