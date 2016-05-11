/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.FnBody;
import edu.cmu.sei.annex.dmpl.dmpl.NodeVarInit;
import edu.cmu.sei.annex.dmpl.dmpl.RecordBlock;

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
 * An implementation of the model object '<em><b>Record Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.RecordBlockImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.RecordBlockImpl#getVars <em>Vars</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.RecordBlockImpl#getEqualsBody <em>Equals Body</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.RecordBlockImpl#getComplementBody <em>Complement Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecordBlockImpl extends NodeBodyElementImpl implements RecordBlock
{
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
   * The cached value of the '{@link #getVars() <em>Vars</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVars()
   * @generated
   * @ordered
   */
  protected EList<NodeVarInit> vars;

  /**
   * The cached value of the '{@link #getEqualsBody() <em>Equals Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEqualsBody()
   * @generated
   * @ordered
   */
  protected FnBody equalsBody;

  /**
   * The cached value of the '{@link #getComplementBody() <em>Complement Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComplementBody()
   * @generated
   * @ordered
   */
  protected FnBody complementBody;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RecordBlockImpl()
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
    return DmplPackage.Literals.RECORD_BLOCK;
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
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.RECORD_BLOCK__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NodeVarInit> getVars()
  {
    if (vars == null)
    {
      vars = new EObjectContainmentEList<NodeVarInit>(NodeVarInit.class, this, DmplPackage.RECORD_BLOCK__VARS);
    }
    return vars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FnBody getEqualsBody()
  {
    return equalsBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEqualsBody(FnBody newEqualsBody, NotificationChain msgs)
  {
    FnBody oldEqualsBody = equalsBody;
    equalsBody = newEqualsBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.RECORD_BLOCK__EQUALS_BODY, oldEqualsBody, newEqualsBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEqualsBody(FnBody newEqualsBody)
  {
    if (newEqualsBody != equalsBody)
    {
      NotificationChain msgs = null;
      if (equalsBody != null)
        msgs = ((InternalEObject)equalsBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.RECORD_BLOCK__EQUALS_BODY, null, msgs);
      if (newEqualsBody != null)
        msgs = ((InternalEObject)newEqualsBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.RECORD_BLOCK__EQUALS_BODY, null, msgs);
      msgs = basicSetEqualsBody(newEqualsBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.RECORD_BLOCK__EQUALS_BODY, newEqualsBody, newEqualsBody));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FnBody getComplementBody()
  {
    return complementBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetComplementBody(FnBody newComplementBody, NotificationChain msgs)
  {
    FnBody oldComplementBody = complementBody;
    complementBody = newComplementBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.RECORD_BLOCK__COMPLEMENT_BODY, oldComplementBody, newComplementBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComplementBody(FnBody newComplementBody)
  {
    if (newComplementBody != complementBody)
    {
      NotificationChain msgs = null;
      if (complementBody != null)
        msgs = ((InternalEObject)complementBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.RECORD_BLOCK__COMPLEMENT_BODY, null, msgs);
      if (newComplementBody != null)
        msgs = ((InternalEObject)newComplementBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.RECORD_BLOCK__COMPLEMENT_BODY, null, msgs);
      msgs = basicSetComplementBody(newComplementBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.RECORD_BLOCK__COMPLEMENT_BODY, newComplementBody, newComplementBody));
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
      case DmplPackage.RECORD_BLOCK__VARS:
        return ((InternalEList<?>)getVars()).basicRemove(otherEnd, msgs);
      case DmplPackage.RECORD_BLOCK__EQUALS_BODY:
        return basicSetEqualsBody(null, msgs);
      case DmplPackage.RECORD_BLOCK__COMPLEMENT_BODY:
        return basicSetComplementBody(null, msgs);
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
      case DmplPackage.RECORD_BLOCK__NAME:
        return getName();
      case DmplPackage.RECORD_BLOCK__VARS:
        return getVars();
      case DmplPackage.RECORD_BLOCK__EQUALS_BODY:
        return getEqualsBody();
      case DmplPackage.RECORD_BLOCK__COMPLEMENT_BODY:
        return getComplementBody();
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
      case DmplPackage.RECORD_BLOCK__NAME:
        setName((String)newValue);
        return;
      case DmplPackage.RECORD_BLOCK__VARS:
        getVars().clear();
        getVars().addAll((Collection<? extends NodeVarInit>)newValue);
        return;
      case DmplPackage.RECORD_BLOCK__EQUALS_BODY:
        setEqualsBody((FnBody)newValue);
        return;
      case DmplPackage.RECORD_BLOCK__COMPLEMENT_BODY:
        setComplementBody((FnBody)newValue);
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
      case DmplPackage.RECORD_BLOCK__NAME:
        setName(NAME_EDEFAULT);
        return;
      case DmplPackage.RECORD_BLOCK__VARS:
        getVars().clear();
        return;
      case DmplPackage.RECORD_BLOCK__EQUALS_BODY:
        setEqualsBody((FnBody)null);
        return;
      case DmplPackage.RECORD_BLOCK__COMPLEMENT_BODY:
        setComplementBody((FnBody)null);
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
      case DmplPackage.RECORD_BLOCK__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case DmplPackage.RECORD_BLOCK__VARS:
        return vars != null && !vars.isEmpty();
      case DmplPackage.RECORD_BLOCK__EQUALS_BODY:
        return equalsBody != null;
      case DmplPackage.RECORD_BLOCK__COMPLEMENT_BODY:
        return complementBody != null;
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
    result.append(')');
    return result.toString();
  }

} //RecordBlockImpl
