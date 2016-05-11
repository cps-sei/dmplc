/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.AttrList;
import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.ProcNoAttr;
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
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProcedureImpl#getAttrList <em>Attr List</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProcedureImpl#getProc <em>Proc</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcedureImpl extends ProgramElementImpl implements Procedure
{
  /**
   * The cached value of the '{@link #getAttrList() <em>Attr List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttrList()
   * @generated
   * @ordered
   */
  protected AttrList attrList;

  /**
   * The cached value of the '{@link #getProc() <em>Proc</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProc()
   * @generated
   * @ordered
   */
  protected ProcNoAttr proc;

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
  public AttrList getAttrList()
  {
    return attrList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAttrList(AttrList newAttrList, NotificationChain msgs)
  {
    AttrList oldAttrList = attrList;
    attrList = newAttrList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.PROCEDURE__ATTR_LIST, oldAttrList, newAttrList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAttrList(AttrList newAttrList)
  {
    if (newAttrList != attrList)
    {
      NotificationChain msgs = null;
      if (attrList != null)
        msgs = ((InternalEObject)attrList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.PROCEDURE__ATTR_LIST, null, msgs);
      if (newAttrList != null)
        msgs = ((InternalEObject)newAttrList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.PROCEDURE__ATTR_LIST, null, msgs);
      msgs = basicSetAttrList(newAttrList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.PROCEDURE__ATTR_LIST, newAttrList, newAttrList));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcNoAttr getProc()
  {
    return proc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProc(ProcNoAttr newProc, NotificationChain msgs)
  {
    ProcNoAttr oldProc = proc;
    proc = newProc;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.PROCEDURE__PROC, oldProc, newProc);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProc(ProcNoAttr newProc)
  {
    if (newProc != proc)
    {
      NotificationChain msgs = null;
      if (proc != null)
        msgs = ((InternalEObject)proc).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.PROCEDURE__PROC, null, msgs);
      if (newProc != null)
        msgs = ((InternalEObject)newProc).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.PROCEDURE__PROC, null, msgs);
      msgs = basicSetProc(newProc, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.PROCEDURE__PROC, newProc, newProc));
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
      case DmplPackage.PROCEDURE__ATTR_LIST:
        return basicSetAttrList(null, msgs);
      case DmplPackage.PROCEDURE__PROC:
        return basicSetProc(null, msgs);
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
      case DmplPackage.PROCEDURE__ATTR_LIST:
        return getAttrList();
      case DmplPackage.PROCEDURE__PROC:
        return getProc();
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
      case DmplPackage.PROCEDURE__ATTR_LIST:
        setAttrList((AttrList)newValue);
        return;
      case DmplPackage.PROCEDURE__PROC:
        setProc((ProcNoAttr)newValue);
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
      case DmplPackage.PROCEDURE__ATTR_LIST:
        setAttrList((AttrList)null);
        return;
      case DmplPackage.PROCEDURE__PROC:
        setProc((ProcNoAttr)null);
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
      case DmplPackage.PROCEDURE__ATTR_LIST:
        return attrList != null;
      case DmplPackage.PROCEDURE__PROC:
        return proc != null;
    }
    return super.eIsSet(featureID);
  }

} //ProcedureImpl
