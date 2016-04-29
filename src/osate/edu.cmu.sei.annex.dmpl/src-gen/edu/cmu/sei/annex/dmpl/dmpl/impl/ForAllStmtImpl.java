/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.ForAllFunctionEnum;
import edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt;
import edu.cmu.sei.annex.dmpl.dmpl.Stmt;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For All Stmt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ForAllStmtImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ForAllStmtImpl#getNode <em>Node</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ForAllStmtImpl#getStmt <em>Stmt</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForAllStmtImpl extends StmtImpl implements ForAllStmt
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final ForAllFunctionEnum NAME_EDEFAULT = ForAllFunctionEnum.FORALL_NODE;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected ForAllFunctionEnum name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getNode() <em>Node</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNode()
   * @generated
   * @ordered
   */
  protected static final String NODE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNode() <em>Node</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNode()
   * @generated
   * @ordered
   */
  protected String node = NODE_EDEFAULT;

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
  protected ForAllStmtImpl()
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
    return DmplPackage.Literals.FOR_ALL_STMT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForAllFunctionEnum getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(ForAllFunctionEnum newName)
  {
    ForAllFunctionEnum oldName = name;
    name = newName == null ? NAME_EDEFAULT : newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.FOR_ALL_STMT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNode()
  {
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNode(String newNode)
  {
    String oldNode = node;
    node = newNode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.FOR_ALL_STMT__NODE, oldNode, node));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.FOR_ALL_STMT__STMT, oldStmt, newStmt);
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
        msgs = ((InternalEObject)stmt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.FOR_ALL_STMT__STMT, null, msgs);
      if (newStmt != null)
        msgs = ((InternalEObject)newStmt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.FOR_ALL_STMT__STMT, null, msgs);
      msgs = basicSetStmt(newStmt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.FOR_ALL_STMT__STMT, newStmt, newStmt));
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
      case DmplPackage.FOR_ALL_STMT__STMT:
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
      case DmplPackage.FOR_ALL_STMT__NAME:
        return getName();
      case DmplPackage.FOR_ALL_STMT__NODE:
        return getNode();
      case DmplPackage.FOR_ALL_STMT__STMT:
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
      case DmplPackage.FOR_ALL_STMT__NAME:
        setName((ForAllFunctionEnum)newValue);
        return;
      case DmplPackage.FOR_ALL_STMT__NODE:
        setNode((String)newValue);
        return;
      case DmplPackage.FOR_ALL_STMT__STMT:
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
      case DmplPackage.FOR_ALL_STMT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case DmplPackage.FOR_ALL_STMT__NODE:
        setNode(NODE_EDEFAULT);
        return;
      case DmplPackage.FOR_ALL_STMT__STMT:
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
      case DmplPackage.FOR_ALL_STMT__NAME:
        return name != NAME_EDEFAULT;
      case DmplPackage.FOR_ALL_STMT__NODE:
        return NODE_EDEFAULT == null ? node != null : !NODE_EDEFAULT.equals(node);
      case DmplPackage.FOR_ALL_STMT__STMT:
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
    result.append(" (name: ");
    result.append(name);
    result.append(", node: ");
    result.append(node);
    result.append(')');
    return result.toString();
  }

} //ForAllStmtImpl
