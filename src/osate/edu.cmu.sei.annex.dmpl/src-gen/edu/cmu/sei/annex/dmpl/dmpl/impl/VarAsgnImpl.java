/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.FnBody;
import edu.cmu.sei.annex.dmpl.dmpl.Var;
import edu.cmu.sei.annex.dmpl.dmpl.VarAsgn;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Var Asgn</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.VarAsgnImpl#getVar <em>Var</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.VarAsgnImpl#getFnBody <em>Fn Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VarAsgnImpl extends MinimalEObjectImpl.Container implements VarAsgn
{
  /**
   * The cached value of the '{@link #getVar() <em>Var</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVar()
   * @generated
   * @ordered
   */
  protected Var var;

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
  protected VarAsgnImpl()
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
    return DmplPackage.Literals.VAR_ASGN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Var getVar()
  {
    return var;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVar(Var newVar, NotificationChain msgs)
  {
    Var oldVar = var;
    var = newVar;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.VAR_ASGN__VAR, oldVar, newVar);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVar(Var newVar)
  {
    if (newVar != var)
    {
      NotificationChain msgs = null;
      if (var != null)
        msgs = ((InternalEObject)var).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.VAR_ASGN__VAR, null, msgs);
      if (newVar != null)
        msgs = ((InternalEObject)newVar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.VAR_ASGN__VAR, null, msgs);
      msgs = basicSetVar(newVar, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.VAR_ASGN__VAR, newVar, newVar));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.VAR_ASGN__FN_BODY, oldFnBody, newFnBody);
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
        msgs = ((InternalEObject)fnBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.VAR_ASGN__FN_BODY, null, msgs);
      if (newFnBody != null)
        msgs = ((InternalEObject)newFnBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.VAR_ASGN__FN_BODY, null, msgs);
      msgs = basicSetFnBody(newFnBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.VAR_ASGN__FN_BODY, newFnBody, newFnBody));
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
      case DmplPackage.VAR_ASGN__VAR:
        return basicSetVar(null, msgs);
      case DmplPackage.VAR_ASGN__FN_BODY:
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
      case DmplPackage.VAR_ASGN__VAR:
        return getVar();
      case DmplPackage.VAR_ASGN__FN_BODY:
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
      case DmplPackage.VAR_ASGN__VAR:
        setVar((Var)newValue);
        return;
      case DmplPackage.VAR_ASGN__FN_BODY:
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
      case DmplPackage.VAR_ASGN__VAR:
        setVar((Var)null);
        return;
      case DmplPackage.VAR_ASGN__FN_BODY:
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
      case DmplPackage.VAR_ASGN__VAR:
        return var != null;
      case DmplPackage.VAR_ASGN__FN_BODY:
        return fnBody != null;
    }
    return super.eIsSet(featureID);
  }

} //VarAsgnImpl
