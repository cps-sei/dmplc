/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.FnBody;
import edu.cmu.sei.annex.dmpl.dmpl.VarInitList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fn Body</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FnBodyImpl#getVarInitList <em>Var Init List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FnBodyImpl extends MinimalEObjectImpl.Container implements FnBody
{
  /**
   * The cached value of the '{@link #getVarInitList() <em>Var Init List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVarInitList()
   * @generated
   * @ordered
   */
  protected VarInitList varInitList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FnBodyImpl()
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
    return DmplPackage.Literals.FN_BODY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarInitList getVarInitList()
  {
    return varInitList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVarInitList(VarInitList newVarInitList, NotificationChain msgs)
  {
    VarInitList oldVarInitList = varInitList;
    varInitList = newVarInitList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.FN_BODY__VAR_INIT_LIST, oldVarInitList, newVarInitList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVarInitList(VarInitList newVarInitList)
  {
    if (newVarInitList != varInitList)
    {
      NotificationChain msgs = null;
      if (varInitList != null)
        msgs = ((InternalEObject)varInitList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.FN_BODY__VAR_INIT_LIST, null, msgs);
      if (newVarInitList != null)
        msgs = ((InternalEObject)newVarInitList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.FN_BODY__VAR_INIT_LIST, null, msgs);
      msgs = basicSetVarInitList(newVarInitList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.FN_BODY__VAR_INIT_LIST, newVarInitList, newVarInitList));
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
      case DmplPackage.FN_BODY__VAR_INIT_LIST:
        return basicSetVarInitList(null, msgs);
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
      case DmplPackage.FN_BODY__VAR_INIT_LIST:
        return getVarInitList();
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
      case DmplPackage.FN_BODY__VAR_INIT_LIST:
        setVarInitList((VarInitList)newValue);
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
      case DmplPackage.FN_BODY__VAR_INIT_LIST:
        setVarInitList((VarInitList)null);
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
      case DmplPackage.FN_BODY__VAR_INIT_LIST:
        return varInitList != null;
    }
    return super.eIsSet(featureID);
  }

} //FnBodyImpl
