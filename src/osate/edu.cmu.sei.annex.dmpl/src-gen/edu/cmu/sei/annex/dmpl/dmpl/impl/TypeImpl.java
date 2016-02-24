/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.SignedEnum;
import edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum;
import edu.cmu.sei.annex.dmpl.dmpl.Type;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.TypeImpl#getSigned <em>Signed</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.TypeImpl#getSimpType <em>Simp Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeImpl extends MinimalEObjectImpl.Container implements Type
{
  /**
   * The default value of the '{@link #getSigned() <em>Signed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSigned()
   * @generated
   * @ordered
   */
  protected static final SignedEnum SIGNED_EDEFAULT = SignedEnum.UNSET;

  /**
   * The cached value of the '{@link #getSigned() <em>Signed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSigned()
   * @generated
   * @ordered
   */
  protected SignedEnum signed = SIGNED_EDEFAULT;

  /**
   * The default value of the '{@link #getSimpType() <em>Simp Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSimpType()
   * @generated
   * @ordered
   */
  protected static final SimpTypeEnum SIMP_TYPE_EDEFAULT = SimpTypeEnum.BOOL;

  /**
   * The cached value of the '{@link #getSimpType() <em>Simp Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSimpType()
   * @generated
   * @ordered
   */
  protected SimpTypeEnum simpType = SIMP_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DmplPackage.Literals.TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignedEnum getSigned()
  {
    return signed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSigned(SignedEnum newSigned)
  {
    SignedEnum oldSigned = signed;
    signed = newSigned == null ? SIGNED_EDEFAULT : newSigned;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.TYPE__SIGNED, oldSigned, signed));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpTypeEnum getSimpType()
  {
    return simpType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSimpType(SimpTypeEnum newSimpType)
  {
    SimpTypeEnum oldSimpType = simpType;
    simpType = newSimpType == null ? SIMP_TYPE_EDEFAULT : newSimpType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.TYPE__SIMP_TYPE, oldSimpType, simpType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case DmplPackage.TYPE__SIGNED:
        return getSigned();
      case DmplPackage.TYPE__SIMP_TYPE:
        return getSimpType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DmplPackage.TYPE__SIGNED:
        setSigned((SignedEnum)newValue);
        return;
      case DmplPackage.TYPE__SIMP_TYPE:
        setSimpType((SimpTypeEnum)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case DmplPackage.TYPE__SIGNED:
        setSigned(SIGNED_EDEFAULT);
        return;
      case DmplPackage.TYPE__SIMP_TYPE:
        setSimpType(SIMP_TYPE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case DmplPackage.TYPE__SIGNED:
        return signed != SIGNED_EDEFAULT;
      case DmplPackage.TYPE__SIMP_TYPE:
        return simpType != SIMP_TYPE_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (signed: ");
    result.append(signed);
    result.append(", simpType: ");
    result.append(simpType);
    result.append(')');
    return result.toString();
  }

} //TypeImpl
