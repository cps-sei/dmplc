/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr;
import edu.cmu.sei.annex.dmpl.dmpl.BuiltInFunctionEnum;
import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.Expr;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Built In Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.BuiltInExprImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.BuiltInExprImpl#getFirstArg <em>First Arg</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.BuiltInExprImpl#getSecondArg <em>Second Arg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BuiltInExprImpl extends ExprImpl implements BuiltInExpr
{
  /**
   * The default value of the '{@link #getFunction() <em>Function</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunction()
   * @generated
   * @ordered
   */
  protected static final BuiltInFunctionEnum FUNCTION_EDEFAULT = BuiltInFunctionEnum.EXISTS_OTHER;

  /**
   * The cached value of the '{@link #getFunction() <em>Function</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunction()
   * @generated
   * @ordered
   */
  protected BuiltInFunctionEnum function = FUNCTION_EDEFAULT;

  /**
   * The default value of the '{@link #getFirstArg() <em>First Arg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstArg()
   * @generated
   * @ordered
   */
  protected static final String FIRST_ARG_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFirstArg() <em>First Arg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstArg()
   * @generated
   * @ordered
   */
  protected String firstArg = FIRST_ARG_EDEFAULT;

  /**
   * The cached value of the '{@link #getSecondArg() <em>Second Arg</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecondArg()
   * @generated
   * @ordered
   */
  protected Expr secondArg;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BuiltInExprImpl()
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
    return DmplPackage.Literals.BUILT_IN_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BuiltInFunctionEnum getFunction()
  {
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunction(BuiltInFunctionEnum newFunction)
  {
    BuiltInFunctionEnum oldFunction = function;
    function = newFunction == null ? FUNCTION_EDEFAULT : newFunction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.BUILT_IN_EXPR__FUNCTION, oldFunction, function));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFirstArg()
  {
    return firstArg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirstArg(String newFirstArg)
  {
    String oldFirstArg = firstArg;
    firstArg = newFirstArg;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.BUILT_IN_EXPR__FIRST_ARG, oldFirstArg, firstArg));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getSecondArg()
  {
    return secondArg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSecondArg(Expr newSecondArg, NotificationChain msgs)
  {
    Expr oldSecondArg = secondArg;
    secondArg = newSecondArg;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.BUILT_IN_EXPR__SECOND_ARG, oldSecondArg, newSecondArg);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSecondArg(Expr newSecondArg)
  {
    if (newSecondArg != secondArg)
    {
      NotificationChain msgs = null;
      if (secondArg != null)
        msgs = ((InternalEObject)secondArg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.BUILT_IN_EXPR__SECOND_ARG, null, msgs);
      if (newSecondArg != null)
        msgs = ((InternalEObject)newSecondArg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.BUILT_IN_EXPR__SECOND_ARG, null, msgs);
      msgs = basicSetSecondArg(newSecondArg, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.BUILT_IN_EXPR__SECOND_ARG, newSecondArg, newSecondArg));
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
      case DmplPackage.BUILT_IN_EXPR__SECOND_ARG:
        return basicSetSecondArg(null, msgs);
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
      case DmplPackage.BUILT_IN_EXPR__FUNCTION:
        return getFunction();
      case DmplPackage.BUILT_IN_EXPR__FIRST_ARG:
        return getFirstArg();
      case DmplPackage.BUILT_IN_EXPR__SECOND_ARG:
        return getSecondArg();
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
      case DmplPackage.BUILT_IN_EXPR__FUNCTION:
        setFunction((BuiltInFunctionEnum)newValue);
        return;
      case DmplPackage.BUILT_IN_EXPR__FIRST_ARG:
        setFirstArg((String)newValue);
        return;
      case DmplPackage.BUILT_IN_EXPR__SECOND_ARG:
        setSecondArg((Expr)newValue);
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
      case DmplPackage.BUILT_IN_EXPR__FUNCTION:
        setFunction(FUNCTION_EDEFAULT);
        return;
      case DmplPackage.BUILT_IN_EXPR__FIRST_ARG:
        setFirstArg(FIRST_ARG_EDEFAULT);
        return;
      case DmplPackage.BUILT_IN_EXPR__SECOND_ARG:
        setSecondArg((Expr)null);
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
      case DmplPackage.BUILT_IN_EXPR__FUNCTION:
        return function != FUNCTION_EDEFAULT;
      case DmplPackage.BUILT_IN_EXPR__FIRST_ARG:
        return FIRST_ARG_EDEFAULT == null ? firstArg != null : !FIRST_ARG_EDEFAULT.equals(firstArg);
      case DmplPackage.BUILT_IN_EXPR__SECOND_ARG:
        return secondArg != null;
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
    result.append(" (function: ");
    result.append(function);
    result.append(", firstArg: ");
    result.append(firstArg);
    result.append(')');
    return result.toString();
  }

} //BuiltInExprImpl
