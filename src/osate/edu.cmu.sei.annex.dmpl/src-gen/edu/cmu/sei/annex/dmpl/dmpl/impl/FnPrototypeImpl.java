/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.FnPrototype;
import edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeNoDecors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fn Prototype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeImpl#isExtern <em>Extern</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeImpl#isPure <em>Pure</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeImpl#getPrototype <em>Prototype</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FnPrototypeImpl extends MinimalEObjectImpl.Container implements FnPrototype
{
  /**
   * The default value of the '{@link #isExtern() <em>Extern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExtern()
   * @generated
   * @ordered
   */
  protected static final boolean EXTERN_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isExtern() <em>Extern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExtern()
   * @generated
   * @ordered
   */
  protected boolean extern = EXTERN_EDEFAULT;

  /**
   * The default value of the '{@link #isPure() <em>Pure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPure()
   * @generated
   * @ordered
   */
  protected static final boolean PURE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPure() <em>Pure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPure()
   * @generated
   * @ordered
   */
  protected boolean pure = PURE_EDEFAULT;

  /**
   * The cached value of the '{@link #getPrototype() <em>Prototype</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrototype()
   * @generated
   * @ordered
   */
  protected FnPrototypeNoDecors prototype;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FnPrototypeImpl()
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
    return DmplPackage.Literals.FN_PROTOTYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isExtern()
  {
    return extern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtern(boolean newExtern)
  {
    boolean oldExtern = extern;
    extern = newExtern;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.FN_PROTOTYPE__EXTERN, oldExtern, extern));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPure()
  {
    return pure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPure(boolean newPure)
  {
    boolean oldPure = pure;
    pure = newPure;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.FN_PROTOTYPE__PURE, oldPure, pure));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FnPrototypeNoDecors getPrototype()
  {
    return prototype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrototype(FnPrototypeNoDecors newPrototype, NotificationChain msgs)
  {
    FnPrototypeNoDecors oldPrototype = prototype;
    prototype = newPrototype;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.FN_PROTOTYPE__PROTOTYPE, oldPrototype, newPrototype);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrototype(FnPrototypeNoDecors newPrototype)
  {
    if (newPrototype != prototype)
    {
      NotificationChain msgs = null;
      if (prototype != null)
        msgs = ((InternalEObject)prototype).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.FN_PROTOTYPE__PROTOTYPE, null, msgs);
      if (newPrototype != null)
        msgs = ((InternalEObject)newPrototype).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.FN_PROTOTYPE__PROTOTYPE, null, msgs);
      msgs = basicSetPrototype(newPrototype, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.FN_PROTOTYPE__PROTOTYPE, newPrototype, newPrototype));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case DmplPackage.FN_PROTOTYPE__PROTOTYPE:
        return basicSetPrototype(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case DmplPackage.FN_PROTOTYPE__EXTERN:
        return isExtern();
      case DmplPackage.FN_PROTOTYPE__PURE:
        return isPure();
      case DmplPackage.FN_PROTOTYPE__PROTOTYPE:
        return getPrototype();
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
      case DmplPackage.FN_PROTOTYPE__EXTERN:
        setExtern((Boolean)newValue);
        return;
      case DmplPackage.FN_PROTOTYPE__PURE:
        setPure((Boolean)newValue);
        return;
      case DmplPackage.FN_PROTOTYPE__PROTOTYPE:
        setPrototype((FnPrototypeNoDecors)newValue);
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
      case DmplPackage.FN_PROTOTYPE__EXTERN:
        setExtern(EXTERN_EDEFAULT);
        return;
      case DmplPackage.FN_PROTOTYPE__PURE:
        setPure(PURE_EDEFAULT);
        return;
      case DmplPackage.FN_PROTOTYPE__PROTOTYPE:
        setPrototype((FnPrototypeNoDecors)null);
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
      case DmplPackage.FN_PROTOTYPE__EXTERN:
        return extern != EXTERN_EDEFAULT;
      case DmplPackage.FN_PROTOTYPE__PURE:
        return pure != PURE_EDEFAULT;
      case DmplPackage.FN_PROTOTYPE__PROTOTYPE:
        return prototype != null;
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
    result.append(" (extern: ");
    result.append(extern);
    result.append(", pure: ");
    result.append(pure);
    result.append(')');
    return result.toString();
  }

} //FnPrototypeImpl
