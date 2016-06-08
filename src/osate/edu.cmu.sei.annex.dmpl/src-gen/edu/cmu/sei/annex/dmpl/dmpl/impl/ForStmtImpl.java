/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.AssignmentOrIncrementStmt;
import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.Expr;
import edu.cmu.sei.annex.dmpl.dmpl.ForStmt;
import edu.cmu.sei.annex.dmpl.dmpl.InitAssignmentStmt;
import edu.cmu.sei.annex.dmpl.dmpl.Stmt;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Stmt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ForStmtImpl#getInits <em>Inits</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ForStmtImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ForStmtImpl#getUpdate <em>Update</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ForStmtImpl#getStmt <em>Stmt</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForStmtImpl extends StmtImpl implements ForStmt
{
  /**
   * The cached value of the '{@link #getInits() <em>Inits</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInits()
   * @generated
   * @ordered
   */
  protected EList<InitAssignmentStmt> inits;

  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected Expr condition;

  /**
   * The cached value of the '{@link #getUpdate() <em>Update</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpdate()
   * @generated
   * @ordered
   */
  protected AssignmentOrIncrementStmt update;

  /**
   * The cached value of the '{@link #getStmt() <em>Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStmt()
   * @generated
   * @ordered
   */
  protected Stmt stmt;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ForStmtImpl()
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
    return DmplPackage.Literals.FOR_STMT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InitAssignmentStmt> getInits()
  {
    if (inits == null)
    {
      inits = new EObjectContainmentEList<InitAssignmentStmt>(InitAssignmentStmt.class, this, DmplPackage.FOR_STMT__INITS);
    }
    return inits;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(Expr newCondition, NotificationChain msgs)
  {
    Expr oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.FOR_STMT__CONDITION, oldCondition, newCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondition(Expr newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.FOR_STMT__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.FOR_STMT__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.FOR_STMT__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentOrIncrementStmt getUpdate()
  {
    return update;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUpdate(AssignmentOrIncrementStmt newUpdate, NotificationChain msgs)
  {
    AssignmentOrIncrementStmt oldUpdate = update;
    update = newUpdate;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.FOR_STMT__UPDATE, oldUpdate, newUpdate);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpdate(AssignmentOrIncrementStmt newUpdate)
  {
    if (newUpdate != update)
    {
      NotificationChain msgs = null;
      if (update != null)
        msgs = ((InternalEObject)update).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.FOR_STMT__UPDATE, null, msgs);
      if (newUpdate != null)
        msgs = ((InternalEObject)newUpdate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.FOR_STMT__UPDATE, null, msgs);
      msgs = basicSetUpdate(newUpdate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.FOR_STMT__UPDATE, newUpdate, newUpdate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Stmt getStmt()
  {
    return stmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStmt(Stmt newStmt, NotificationChain msgs)
  {
    Stmt oldStmt = stmt;
    stmt = newStmt;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.FOR_STMT__STMT, oldStmt, newStmt);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStmt(Stmt newStmt)
  {
    if (newStmt != stmt)
    {
      NotificationChain msgs = null;
      if (stmt != null)
        msgs = ((InternalEObject)stmt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.FOR_STMT__STMT, null, msgs);
      if (newStmt != null)
        msgs = ((InternalEObject)newStmt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.FOR_STMT__STMT, null, msgs);
      msgs = basicSetStmt(newStmt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.FOR_STMT__STMT, newStmt, newStmt));
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
      case DmplPackage.FOR_STMT__INITS:
        return ((InternalEList<?>)getInits()).basicRemove(otherEnd, msgs);
      case DmplPackage.FOR_STMT__CONDITION:
        return basicSetCondition(null, msgs);
      case DmplPackage.FOR_STMT__UPDATE:
        return basicSetUpdate(null, msgs);
      case DmplPackage.FOR_STMT__STMT:
        return basicSetStmt(null, msgs);
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
      case DmplPackage.FOR_STMT__INITS:
        return getInits();
      case DmplPackage.FOR_STMT__CONDITION:
        return getCondition();
      case DmplPackage.FOR_STMT__UPDATE:
        return getUpdate();
      case DmplPackage.FOR_STMT__STMT:
        return getStmt();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DmplPackage.FOR_STMT__INITS:
        getInits().clear();
        getInits().addAll((Collection<? extends InitAssignmentStmt>)newValue);
        return;
      case DmplPackage.FOR_STMT__CONDITION:
        setCondition((Expr)newValue);
        return;
      case DmplPackage.FOR_STMT__UPDATE:
        setUpdate((AssignmentOrIncrementStmt)newValue);
        return;
      case DmplPackage.FOR_STMT__STMT:
        setStmt((Stmt)newValue);
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
      case DmplPackage.FOR_STMT__INITS:
        getInits().clear();
        return;
      case DmplPackage.FOR_STMT__CONDITION:
        setCondition((Expr)null);
        return;
      case DmplPackage.FOR_STMT__UPDATE:
        setUpdate((AssignmentOrIncrementStmt)null);
        return;
      case DmplPackage.FOR_STMT__STMT:
        setStmt((Stmt)null);
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
      case DmplPackage.FOR_STMT__INITS:
        return inits != null && !inits.isEmpty();
      case DmplPackage.FOR_STMT__CONDITION:
        return condition != null;
      case DmplPackage.FOR_STMT__UPDATE:
        return update != null;
      case DmplPackage.FOR_STMT__STMT:
        return stmt != null;
    }
    return super.eIsSet(featureID);
  }

} //ForStmtImpl
