/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.CallExpr;
import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.Expr;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.CallExprImpl#getNamespaces <em>Namespaces</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.CallExprImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.CallExprImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.CallExprImpl#getAt <em>At</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CallExprImpl extends StmtImpl implements CallExpr
{
  /**
   * The cached value of the '{@link #getNamespaces() <em>Namespaces</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamespaces()
   * @generated
   * @ordered
   */
  protected EList<String> namespaces;

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
   * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs()
   * @generated
   * @ordered
   */
  protected EList<Expr> args;

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
  public EList<String> getNamespaces()
  {
    if (namespaces == null)
    {
      namespaces = new EDataTypeEList<String>(String.class, this, DmplPackage.CALL_EXPR__NAMESPACES);
    }
    return namespaces;
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
  public EList<Expr> getArgs()
  {
    if (args == null)
    {
      args = new EObjectContainmentEList<Expr>(Expr.class, this, DmplPackage.CALL_EXPR__ARGS);
    }
    return args;
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
      case DmplPackage.CALL_EXPR__ARGS:
        return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
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
      case DmplPackage.CALL_EXPR__NAMESPACES:
        return getNamespaces();
      case DmplPackage.CALL_EXPR__NAME:
        return getName();
      case DmplPackage.CALL_EXPR__ARGS:
        return getArgs();
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
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DmplPackage.CALL_EXPR__NAMESPACES:
        getNamespaces().clear();
        getNamespaces().addAll((Collection<? extends String>)newValue);
        return;
      case DmplPackage.CALL_EXPR__NAME:
        setName((String)newValue);
        return;
      case DmplPackage.CALL_EXPR__ARGS:
        getArgs().clear();
        getArgs().addAll((Collection<? extends Expr>)newValue);
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
      case DmplPackage.CALL_EXPR__NAMESPACES:
        getNamespaces().clear();
        return;
      case DmplPackage.CALL_EXPR__NAME:
        setName(NAME_EDEFAULT);
        return;
      case DmplPackage.CALL_EXPR__ARGS:
        getArgs().clear();
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
      case DmplPackage.CALL_EXPR__NAMESPACES:
        return namespaces != null && !namespaces.isEmpty();
      case DmplPackage.CALL_EXPR__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case DmplPackage.CALL_EXPR__ARGS:
        return args != null && !args.isEmpty();
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
    result.append(" (namespaces: ");
    result.append(namespaces);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //CallExprImpl
