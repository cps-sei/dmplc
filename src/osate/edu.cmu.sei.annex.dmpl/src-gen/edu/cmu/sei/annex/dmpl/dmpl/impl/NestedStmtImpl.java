/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.NestedStmt;
import edu.cmu.sei.annex.dmpl.dmpl.StmtList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nested Stmt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.NestedStmtImpl#getStmtList <em>Stmt List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NestedStmtImpl extends StmtImpl implements NestedStmt
{
  /**
   * The cached value of the '{@link #getStmtList() <em>Stmt List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStmtList()
   * @generated
   * @ordered
   */
  protected StmtList stmtList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NestedStmtImpl()
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
    return DmplPackage.Literals.NESTED_STMT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StmtList getStmtList()
  {
    return stmtList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStmtList(StmtList newStmtList, NotificationChain msgs)
  {
    StmtList oldStmtList = stmtList;
    stmtList = newStmtList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.NESTED_STMT__STMT_LIST, oldStmtList, newStmtList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStmtList(StmtList newStmtList)
  {
    if (newStmtList != stmtList)
    {
      NotificationChain msgs = null;
      if (stmtList != null)
        msgs = ((InternalEObject)stmtList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.NESTED_STMT__STMT_LIST, null, msgs);
      if (newStmtList != null)
        msgs = ((InternalEObject)newStmtList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.NESTED_STMT__STMT_LIST, null, msgs);
      msgs = basicSetStmtList(newStmtList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.NESTED_STMT__STMT_LIST, newStmtList, newStmtList));
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
      case DmplPackage.NESTED_STMT__STMT_LIST:
        return basicSetStmtList(null, msgs);
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
      case DmplPackage.NESTED_STMT__STMT_LIST:
        return getStmtList();
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
      case DmplPackage.NESTED_STMT__STMT_LIST:
        setStmtList((StmtList)newValue);
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
      case DmplPackage.NESTED_STMT__STMT_LIST:
        setStmtList((StmtList)null);
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
      case DmplPackage.NESTED_STMT__STMT_LIST:
        return stmtList != null;
    }
    return super.eIsSet(featureID);
  }

} //NestedStmtImpl
