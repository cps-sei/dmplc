/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>At Least Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.AtLeastSpec#getThreshold <em>Threshold</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getAtLeastSpec()
 * @model
 * @generated
 */
public interface AtLeastSpec extends Specification
{
  /**
   * Returns the value of the '<em><b>Threshold</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Threshold</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Threshold</em>' containment reference.
   * @see #setThreshold(DoubleConst)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getAtLeastSpec_Threshold()
   * @model containment="true"
   * @generated
   */
  DoubleConst getThreshold();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.AtLeastSpec#getThreshold <em>Threshold</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Threshold</em>' containment reference.
   * @see #getThreshold()
   * @generated
   */
  void setThreshold(DoubleConst value);

} // AtLeastSpec
