/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt;
import edu.cmu.sei.annex.dmpl.dmpl.Stmt;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fadnp Stmt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FadnpStmtImpl#getNode1 <em>Node1</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FadnpStmtImpl#getNode2 <em>Node2</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FadnpStmtImpl#getStmt <em>Stmt</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FadnpStmtImpl extends StmtImpl implements FadnpStmt
{
  /**
   * The default value of the '{@link #getNode1() <em>Node1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNode1()
   * @generated
   * @ordered
   */
  protected static final String NODE1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNode1() <em>Node1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNode1()
   * @generated
   * @ordered
   */
  protected String node1 = NODE1_EDEFAULT;

  /**
   * The default value of the '{@link #getNode2() <em>Node2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNode2()
   * @generated
   * @ordered
   */
  protected static final String NODE2_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNode2() <em>Node2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNode2()
   * @generated
   * @ordered
   */
  protected String node2 = NODE2_EDEFAULT;

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
  protected FadnpStmtImpl()
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
    return DmplPackage.Literals.FADNP_STMT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNode1()
  {
    return node1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNode1(String newNode1)
  {
    String oldNode1 = node1;
    node1 = newNode1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.FADNP_STMT__NODE1, oldNode1, node1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNode2()
  {
    return node2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNode2(String newNode2)
  {
    String oldNode2 = node2;
    node2 = newNode2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.FADNP_STMT__NODE2, oldNode2, node2));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.FADNP_STMT__STMT, oldStmt, newStmt);
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
        msgs = ((InternalEObject)stmt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.FADNP_STMT__STMT, null, msgs);
      if (newStmt != null)
        msgs = ((InternalEObject)newStmt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.FADNP_STMT__STMT, null, msgs);
      msgs = basicSetStmt(newStmt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.FADNP_STMT__STMT, newStmt, newStmt));
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
      case DmplPackage.FADNP_STMT__STMT:
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
      case DmplPackage.FADNP_STMT__NODE1:
        return getNode1();
      case DmplPackage.FADNP_STMT__NODE2:
        return getNode2();
      case DmplPackage.FADNP_STMT__STMT:
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
      case DmplPackage.FADNP_STMT__NODE1:
        setNode1((String)newValue);
        return;
      case DmplPackage.FADNP_STMT__NODE2:
        setNode2((String)newValue);
        return;
      case DmplPackage.FADNP_STMT__STMT:
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
      case DmplPackage.FADNP_STMT__NODE1:
        setNode1(NODE1_EDEFAULT);
        return;
      case DmplPackage.FADNP_STMT__NODE2:
        setNode2(NODE2_EDEFAULT);
        return;
      case DmplPackage.FADNP_STMT__STMT:
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
      case DmplPackage.FADNP_STMT__NODE1:
        return NODE1_EDEFAULT == null ? node1 != null : !NODE1_EDEFAULT.equals(node1);
      case DmplPackage.FADNP_STMT__NODE2:
        return NODE2_EDEFAULT == null ? node2 != null : !NODE2_EDEFAULT.equals(node2);
      case DmplPackage.FADNP_STMT__STMT:
        return stmt != null;
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
    result.append(" (node1: ");
    result.append(node1);
    result.append(", node2: ");
    result.append(node2);
    result.append(')');
    return result.toString();
  }

} //FadnpStmtImpl
