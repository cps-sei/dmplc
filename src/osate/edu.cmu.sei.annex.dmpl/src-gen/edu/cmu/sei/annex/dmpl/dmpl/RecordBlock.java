/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.RecordBlock#getName <em>Name</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.RecordBlock#getVars <em>Vars</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.RecordBlock#getEqualsBody <em>Equals Body</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.RecordBlock#getComplementBody <em>Complement Body</em>}</li>
 * </ul>
 *
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getRecordBlock()
 * @model
 * @generated
 */
public interface RecordBlock extends NodeBodyElement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getRecordBlock_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.RecordBlock#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Vars</b></em>' containment reference list.
   * The list contents are of type {@link edu.cmu.sei.annex.dmpl.dmpl.NodeVarInit}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vars</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vars</em>' containment reference list.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getRecordBlock_Vars()
   * @model containment="true"
   * @generated
   */
  EList<NodeVarInit> getVars();

  /**
   * Returns the value of the '<em><b>Equals Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Equals Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Equals Body</em>' containment reference.
   * @see #setEqualsBody(FnBody)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getRecordBlock_EqualsBody()
   * @model containment="true"
   * @generated
   */
  FnBody getEqualsBody();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.RecordBlock#getEqualsBody <em>Equals Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Equals Body</em>' containment reference.
   * @see #getEqualsBody()
   * @generated
   */
  void setEqualsBody(FnBody value);

  /**
   * Returns the value of the '<em><b>Complement Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Complement Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Complement Body</em>' containment reference.
   * @see #setComplementBody(FnBody)
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#getRecordBlock_ComplementBody()
   * @model containment="true"
   * @generated
   */
  FnBody getComplementBody();

  /**
   * Sets the value of the '{@link edu.cmu.sei.annex.dmpl.dmpl.RecordBlock#getComplementBody <em>Complement Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Complement Body</em>' containment reference.
   * @see #getComplementBody()
   * @generated
   */
  void setComplementBody(FnBody value);

} // RecordBlock
