/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.Expr;
import edu.cmu.sei.annex.dmpl.dmpl.Stmt;
import edu.cmu.sei.annex.dmpl.dmpl.WhileStmt;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>While Stmt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.WhileStmtImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.WhileStmtImpl#getStmt <em>Stmt</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WhileStmtImpl extends StmtImpl implements WhileStmt
{
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
  protected WhileStmtImpl()
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
    return DmplPackage.Literals.WHILE_STMT;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.WHILE_STMT__CONDITION, oldCondition, newCondition);
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
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.WHILE_STMT__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.WHILE_STMT__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.WHILE_STMT__CONDITION, newCondition, newCondition));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.WHILE_STMT__STMT, oldStmt, newStmt);
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
        msgs = ((InternalEObject)stmt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.WHILE_STMT__STMT, null, msgs);
      if (newStmt != null)
        msgs = ((InternalEObject)newStmt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.WHILE_STMT__STMT, null, msgs);
      msgs = basicSetStmt(newStmt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.WHILE_STMT__STMT, newStmt, newStmt));
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
      case DmplPackage.WHILE_STMT__CONDITION:
        return basicSetCondition(null, msgs);
      case DmplPackage.WHILE_STMT__STMT:
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
      case DmplPackage.WHILE_STMT__CONDITION:
        return getCondition();
      case DmplPackage.WHILE_STMT__STMT:
        return getStmt();
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
      case DmplPackage.WHILE_STMT__CONDITION:
        setCondition((Expr)newValue);
        return;
      case DmplPackage.WHILE_STMT__STMT:
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
      case DmplPackage.WHILE_STMT__CONDITION:
        setCondition((Expr)null);
        return;
      case DmplPackage.WHILE_STMT__STMT:
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
      case DmplPackage.WHILE_STMT__CONDITION:
        return condition != null;
      case DmplPackage.WHILE_STMT__STMT:
        return stmt != null;
    }
    return super.eIsSet(featureID);
  }

} //WhileStmtImpl
