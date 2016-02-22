/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.DmplSubclause;
import edu.cmu.sei.annex.dmpl.dmpl.FunctionCall;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.impl.AnnexSubclauseImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subclause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.DmplSubclauseImpl#getFunctionCalls <em>Function Calls</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DmplSubclauseImpl extends AnnexSubclauseImpl implements DmplSubclause
{
  /**
   * The cached value of the '{@link #getFunctionCalls() <em>Function Calls</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctionCalls()
   * @generated
   * @ordered
   */
  protected EList<FunctionCall> functionCalls;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DmplSubclauseImpl()
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
    return DmplPackage.Literals.DMPL_SUBCLAUSE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FunctionCall> getFunctionCalls()
  {
    if (functionCalls == null)
    {
      functionCalls = new EObjectContainmentEList<FunctionCall>(FunctionCall.class, this, DmplPackage.DMPL_SUBCLAUSE__FUNCTION_CALLS);
    }
    return functionCalls;
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
      case DmplPackage.DMPL_SUBCLAUSE__FUNCTION_CALLS:
        return ((InternalEList<?>)getFunctionCalls()).basicRemove(otherEnd, msgs);
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
      case DmplPackage.DMPL_SUBCLAUSE__FUNCTION_CALLS:
        return getFunctionCalls();
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
      case DmplPackage.DMPL_SUBCLAUSE__FUNCTION_CALLS:
        getFunctionCalls().clear();
        getFunctionCalls().addAll((Collection<? extends FunctionCall>)newValue);
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
      case DmplPackage.DMPL_SUBCLAUSE__FUNCTION_CALLS:
        getFunctionCalls().clear();
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
      case DmplPackage.DMPL_SUBCLAUSE__FUNCTION_CALLS:
        return functionCalls != null && !functionCalls.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //DmplSubclauseImpl
