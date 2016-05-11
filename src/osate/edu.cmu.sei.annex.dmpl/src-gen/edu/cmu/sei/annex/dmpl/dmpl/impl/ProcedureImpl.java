/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.FnBody;
import edu.cmu.sei.annex.dmpl.dmpl.Procedure;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Procedure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProcedureImpl#isOverride <em>Override</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProcedureImpl#isExtern <em>Extern</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProcedureImpl#isPure <em>Pure</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProcedureImpl#getFnBody <em>Fn Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcedureImpl extends AttributableNodeOrProcedureImpl implements Procedure
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
  protected ProcedureImpl()
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
    return DmplPackage.Literals.PROCEDURE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.PROCEDURE__OVERRIDE, oldOverride, override));
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
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.PROCEDURE__EXTERN, oldExtern, extern));
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
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.PROCEDURE__PURE, oldPure, pure));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.PROCEDURE__FN_BODY, oldFnBody, newFnBody);
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
        msgs = ((InternalEObject)fnBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.PROCEDURE__FN_BODY, null, msgs);
      if (newFnBody != null)
        msgs = ((InternalEObject)newFnBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.PROCEDURE__FN_BODY, null, msgs);
      msgs = basicSetFnBody(newFnBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.PROCEDURE__FN_BODY, newFnBody, newFnBody));
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
      case DmplPackage.PROCEDURE__FN_BODY:
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
      case DmplPackage.PROCEDURE__OVERRIDE:
        return isOverride();
      case DmplPackage.PROCEDURE__EXTERN:
        return isExtern();
      case DmplPackage.PROCEDURE__PURE:
        return isPure();
      case DmplPackage.PROCEDURE__FN_BODY:
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
      case DmplPackage.PROCEDURE__OVERRIDE:
        setOverride((Boolean)newValue);
        return;
      case DmplPackage.PROCEDURE__EXTERN:
        setExtern((Boolean)newValue);
        return;
      case DmplPackage.PROCEDURE__PURE:
        setPure((Boolean)newValue);
        return;
      case DmplPackage.PROCEDURE__FN_BODY:
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
      case DmplPackage.PROCEDURE__OVERRIDE:
        setOverride(OVERRIDE_EDEFAULT);
        return;
      case DmplPackage.PROCEDURE__EXTERN:
        setExtern(EXTERN_EDEFAULT);
        return;
      case DmplPackage.PROCEDURE__PURE:
        setPure(PURE_EDEFAULT);
        return;
      case DmplPackage.PROCEDURE__FN_BODY:
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
      case DmplPackage.PROCEDURE__OVERRIDE:
        return override != OVERRIDE_EDEFAULT;
      case DmplPackage.PROCEDURE__EXTERN:
        return extern != EXTERN_EDEFAULT;
      case DmplPackage.PROCEDURE__PURE:
        return pure != PURE_EDEFAULT;
      case DmplPackage.PROCEDURE__FN_BODY:
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
    result.append(", extern: ");
    result.append(extern);
    result.append(", pure: ");
    result.append(pure);
    result.append(')');
    return result.toString();
  }

} //ProcedureImpl
