/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.Var;
import edu.cmu.sei.annex.dmpl.dmpl.VarAsgn;
import edu.cmu.sei.annex.dmpl.dmpl.VarAsgnList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Var Asgn List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.VarAsgnListImpl#getVar <em>Var</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.VarAsgnListImpl#getVarAsgn <em>Var Asgn</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VarAsgnListImpl extends MinimalEObjectImpl.Container implements VarAsgnList
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
   * The cached value of the '{@link #getVarAsgn() <em>Var Asgn</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVarAsgn()
   * @generated
   * @ordered
   */
  protected VarAsgn varAsgn;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VarAsgnListImpl()
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
    return DmplPackage.Literals.VAR_ASGN_LIST;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.VAR_ASGN_LIST__VAR, oldVar, newVar);
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
        msgs = ((InternalEObject)var).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.VAR_ASGN_LIST__VAR, null, msgs);
      if (newVar != null)
        msgs = ((InternalEObject)newVar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.VAR_ASGN_LIST__VAR, null, msgs);
      msgs = basicSetVar(newVar, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.VAR_ASGN_LIST__VAR, newVar, newVar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarAsgn getVarAsgn()
  {
    return varAsgn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVarAsgn(VarAsgn newVarAsgn, NotificationChain msgs)
  {
    VarAsgn oldVarAsgn = varAsgn;
    varAsgn = newVarAsgn;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.VAR_ASGN_LIST__VAR_ASGN, oldVarAsgn, newVarAsgn);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVarAsgn(VarAsgn newVarAsgn)
  {
    if (newVarAsgn != varAsgn)
    {
      NotificationChain msgs = null;
      if (varAsgn != null)
        msgs = ((InternalEObject)varAsgn).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.VAR_ASGN_LIST__VAR_ASGN, null, msgs);
      if (newVarAsgn != null)
        msgs = ((InternalEObject)newVarAsgn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.VAR_ASGN_LIST__VAR_ASGN, null, msgs);
      msgs = basicSetVarAsgn(newVarAsgn, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.VAR_ASGN_LIST__VAR_ASGN, newVarAsgn, newVarAsgn));
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
      case DmplPackage.VAR_ASGN_LIST__VAR:
        return basicSetVar(null, msgs);
      case DmplPackage.VAR_ASGN_LIST__VAR_ASGN:
        return basicSetVarAsgn(null, msgs);
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
      case DmplPackage.VAR_ASGN_LIST__VAR:
        return getVar();
      case DmplPackage.VAR_ASGN_LIST__VAR_ASGN:
        return getVarAsgn();
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
      case DmplPackage.VAR_ASGN_LIST__VAR:
        setVar((Var)newValue);
        return;
      case DmplPackage.VAR_ASGN_LIST__VAR_ASGN:
        setVarAsgn((VarAsgn)newValue);
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
      case DmplPackage.VAR_ASGN_LIST__VAR:
        setVar((Var)null);
        return;
      case DmplPackage.VAR_ASGN_LIST__VAR_ASGN:
        setVarAsgn((VarAsgn)null);
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
      case DmplPackage.VAR_ASGN_LIST__VAR:
        return var != null;
      case DmplPackage.VAR_ASGN_LIST__VAR_ASGN:
        return varAsgn != null;
    }
    return super.eIsSet(featureID);
  }

} //VarAsgnListImpl
