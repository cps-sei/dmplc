/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Procedure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure#getProcedure <em>Procedure</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getProcedure()
 * @model
 * @generated
 */
public interface Procedure extends ProgramElement
{
  /**
   * Returns the value of the '<em><b>Procedure</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Procedure</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Procedure</em>' containment reference.
   * @see #setProcedure(ProcNoAttr)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getProcedure_Procedure()
   * @model containment="true"
   * @generated
   */
  ProcNoAttr getProcedure();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure#getProcedure <em>Procedure</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Procedure</em>' containment reference.
   * @see #getProcedure()
   * @generated
   */
  void setProcedure(ProcNoAttr value);

} // Procedure
