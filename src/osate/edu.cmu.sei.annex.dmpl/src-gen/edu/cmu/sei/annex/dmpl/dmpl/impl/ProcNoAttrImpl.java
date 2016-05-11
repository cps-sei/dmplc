/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.FnBody;
import edu.cmu.sei.annex.dmpl.dmpl.FnPrototype;
import edu.cmu.sei.annex.dmpl.dmpl.ProcNoAttr;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proc No Attr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProcNoAttrImpl#isOverride <em>Override</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProcNoAttrImpl#getPrototype <em>Prototype</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProcNoAttrImpl#getFnBody <em>Fn Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcNoAttrImpl extends AttributableElementImpl implements ProcNoAttr
{
  /**
   * The default value of the '{@link #isOverride() <em>Override</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOverride()
   * @generated
   * @ordered
   */
  protected static final boolean OVERRIDE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isOverride() <em>Override</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOverride()
   * @generated
   * @ordered
   */
  protected boolean override = OVERRIDE_EDEFAULT;

  /**
   * The cached value of the '{@link #getPrototype() <em>Prototype</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrototype()
   * @generated
   * @ordered
   */
  protected FnPrototype prototype;

  /**
   * The cached value of the '{@link #getFnBody() <em>Fn Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFnBody()
   * @generated
   * @ordered
   */
  protected FnBody fnBody;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProcNoAttrImpl()
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
    return DmplPackage.Literals.PROC_NO_ATTR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isOverride()
  {
    return override;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOverride(boolean newOverride)
  {
    boolean oldOverride = override;
    override = newOverride;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.PROC_NO_ATTR__OVERRIDE, oldOverride, override));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FnPrototype getPrototype()
  {
    return prototype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrototype(FnPrototype newPrototype, NotificationChain msgs)
  {
    FnPrototype oldPrototype = prototype;
    prototype = newPrototype;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.PROC_NO_ATTR__PROTOTYPE, oldPrototype, newPrototype);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrototype(FnPrototype newPrototype)
  {
    if (newPrototype != prototype)
    {
      NotificationChain msgs = null;
      if (prototype != null)
        msgs = ((InternalEObject)prototype).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.PROC_NO_ATTR__PROTOTYPE, null, msgs);
      if (newPrototype != null)
        msgs = ((InternalEObject)newPrototype).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.PROC_NO_ATTR__PROTOTYPE, null, msgs);
      msgs = basicSetPrototype(newPrototype, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.PROC_NO_ATTR__PROTOTYPE, newPrototype, newPrototype));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FnBody getFnBody()
  {
    return fnBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFnBody(FnBody newFnBody, NotificationChain msgs)
  {
    FnBody oldFnBody = fnBody;
    fnBody = newFnBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.PROC_NO_ATTR__FN_BODY, oldFnBody, newFnBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFnBody(FnBody newFnBody)
  {
    if (newFnBody != fnBody)
    {
      NotificationChain msgs = null;
      if (fnBody != null)
        msgs = ((InternalEObject)fnBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.PROC_NO_ATTR__FN_BODY, null, msgs);
      if (newFnBody != null)
        msgs = ((InternalEObject)newFnBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.PROC_NO_ATTR__FN_BODY, null, msgs);
      msgs = basicSetFnBody(newFnBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.PROC_NO_ATTR__FN_BODY, newFnBody, newFnBody));
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
      case DmplPackage.PROC_NO_ATTR__PROTOTYPE:
        return basicSetPrototype(null, msgs);
      case DmplPackage.PROC_NO_ATTR__FN_BODY:
        return basicSetFnBody(null, msgs);
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
      case DmplPackage.PROC_NO_ATTR__OVERRIDE:
        return isOverride();
      case DmplPackage.PROC_NO_ATTR__PROTOTYPE:
        return getPrototype();
      case DmplPackage.PROC_NO_ATTR__FN_BODY:
        return getFnBody();
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
      case DmplPackage.PROC_NO_ATTR__OVERRIDE:
        setOverride((Boolean)newValue);
        return;
      case DmplPackage.PROC_NO_ATTR__PROTOTYPE:
        setPrototype((FnPrototype)newValue);
        return;
      case DmplPackage.PROC_NO_ATTR__FN_BODY:
        setFnBody((FnBody)newValue);
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
      case DmplPackage.PROC_NO_ATTR__OVERRIDE:
        setOverride(OVERRIDE_EDEFAULT);
        return;
      case DmplPackage.PROC_NO_ATTR__PROTOTYPE:
        setPrototype((FnPrototype)null);
        return;
      case DmplPackage.PROC_NO_ATTR__FN_BODY:
        setFnBody((FnBody)null);
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
      case DmplPackage.PROC_NO_ATTR__OVERRIDE:
        return override != OVERRIDE_EDEFAULT;
      case DmplPackage.PROC_NO_ATTR__PROTOTYPE:
        return prototype != null;
      case DmplPackage.PROC_NO_ATTR__FN_BODY:
        return fnBody != null;
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
    result.append(" (override: ");
    result.append(override);
    result.append(')');
    return result.toString();
  }

} //ProcNoAttrImpl
