/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.ArgList;
import edu.cmu.sei.annex.dmpl.dmpl.CallExpr;
import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.Expr;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.CallExprImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.CallExprImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.CallExprImpl#getArgList <em>Arg List</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.CallExprImpl#getAt <em>At</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CallExprImpl extends StmtImpl implements CallExpr
{
  /**
   * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamespace()
   * @generated
   * @ordered
   */
  protected static final String NAMESPACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamespace()
   * @generated
   * @ordered
   */
  protected String namespace = NAMESPACE_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getArgList() <em>Arg List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgList()
   * @generated
   * @ordered
   */
  protected ArgList argList;

  /**
   * The cached value of the '{@link #getAt() <em>At</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAt()
   * @generated
   * @ordered
   */
  protected Expr at;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CallExprImpl()
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
    return DmplPackage.Literals.CALL_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNamespace()
  {
    return namespace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNamespace(String newNamespace)
  {
    String oldNamespace = namespace;
    namespace = newNamespace;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.CALL_EXPR__NAMESPACE, oldNamespace, namespace));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.CALL_EXPR__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArgList getArgList()
  {
    return argList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArgList(ArgList newArgList, NotificationChain msgs)
  {
    ArgList oldArgList = argList;
    argList = newArgList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.CALL_EXPR__ARG_LIST, oldArgList, newArgList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArgList(ArgList newArgList)
  {
    if (newArgList != argList)
    {
      NotificationChain msgs = null;
      if (argList != null)
        msgs = ((InternalEObject)argList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.CALL_EXPR__ARG_LIST, null, msgs);
      if (newArgList != null)
        msgs = ((InternalEObject)newArgList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.CALL_EXPR__ARG_LIST, null, msgs);
      msgs = basicSetArgList(newArgList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.CALL_EXPR__ARG_LIST, newArgList, newArgList));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getAt()
  {
    return at;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAt(Expr newAt, NotificationChain msgs)
  {
    Expr oldAt = at;
    at = newAt;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.CALL_EXPR__AT, oldAt, newAt);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAt(Expr newAt)
  {
    if (newAt != at)
    {
      NotificationChain msgs = null;
      if (at != null)
        msgs = ((InternalEObject)at).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.CALL_EXPR__AT, null, msgs);
      if (newAt != null)
        msgs = ((InternalEObject)newAt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.CALL_EXPR__AT, null, msgs);
      msgs = basicSetAt(newAt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.CALL_EXPR__AT, newAt, newAt));
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
      case DmplPackage.CALL_EXPR__ARG_LIST:
        return basicSetArgList(null, msgs);
      case DmplPackage.CALL_EXPR__AT:
        return basicSetAt(null, msgs);
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
      case DmplPackage.CALL_EXPR__NAMESPACE:
        return getNamespace();
      case DmplPackage.CALL_EXPR__NAME:
        return getName();
      case DmplPackage.CALL_EXPR__ARG_LIST:
        return getArgList();
      case DmplPackage.CALL_EXPR__AT:
        return getAt();
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
      case DmplPackage.CALL_EXPR__NAMESPACE:
        setNamespace((String)newValue);
        return;
      case DmplPackage.CALL_EXPR__NAME:
        setName((String)newValue);
        return;
      case DmplPackage.CALL_EXPR__ARG_LIST:
        setArgList((ArgList)newValue);
        return;
      case DmplPackage.CALL_EXPR__AT:
        setAt((Expr)newValue);
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
      case DmplPackage.CALL_EXPR__NAMESPACE:
        setNamespace(NAMESPACE_EDEFAULT);
        return;
      case DmplPackage.CALL_EXPR__NAME:
        setName(NAME_EDEFAULT);
        return;
      case DmplPackage.CALL_EXPR__ARG_LIST:
        setArgList((ArgList)null);
        return;
      case DmplPackage.CALL_EXPR__AT:
        setAt((Expr)null);
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
      case DmplPackage.CALL_EXPR__NAMESPACE:
        return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
      case DmplPackage.CALL_EXPR__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case DmplPackage.CALL_EXPR__ARG_LIST:
        return argList != null;
      case DmplPackage.CALL_EXPR__AT:
        return at != null;
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
    result.append(" (namespace: ");
    result.append(namespace);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //CallExprImpl
