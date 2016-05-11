/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.AttrList;
import edu.cmu.sei.annex.dmpl.dmpl.AttributableNoRole;
import edu.cmu.sei.annex.dmpl.dmpl.AttributableNoRoleElement;
import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attributable No Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.AttributableNoRoleImpl#getAttrList <em>Attr List</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.AttributableNoRoleImpl#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributableNoRoleImpl extends RoleBodyElementImpl implements AttributableNoRole
{
  /**
   * The cached value of the '{@link #getAttrList() <em>Attr List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttrList()
   * @generated
   * @ordered
   */
  protected AttrList attrList;

  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected AttributableNoRoleElement element;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributableNoRoleImpl()
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
    return DmplPackage.Literals.ATTRIBUTABLE_NO_ROLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttrList getAttrList()
  {
    return attrList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAttrList(AttrList newAttrList, NotificationChain msgs)
  {
    AttrList oldAttrList = attrList;
    attrList = newAttrList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.ATTRIBUTABLE_NO_ROLE__ATTR_LIST, oldAttrList, newAttrList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAttrList(AttrList newAttrList)
  {
    if (newAttrList != attrList)
    {
      NotificationChain msgs = null;
      if (attrList != null)
        msgs = ((InternalEObject)attrList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.ATTRIBUTABLE_NO_ROLE__ATTR_LIST, null, msgs);
      if (newAttrList != null)
        msgs = ((InternalEObject)newAttrList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.ATTRIBUTABLE_NO_ROLE__ATTR_LIST, null, msgs);
      msgs = basicSetAttrList(newAttrList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.ATTRIBUTABLE_NO_ROLE__ATTR_LIST, newAttrList, newAttrList));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributableNoRoleElement getElement()
  {
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElement(AttributableNoRoleElement newElement, NotificationChain msgs)
  {
    AttributableNoRoleElement oldElement = element;
    element = newElement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.ATTRIBUTABLE_NO_ROLE__ELEMENT, oldElement, newElement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElement(AttributableNoRoleElement newElement)
  {
    if (newElement != element)
    {
      NotificationChain msgs = null;
      if (element != null)
        msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.ATTRIBUTABLE_NO_ROLE__ELEMENT, null, msgs);
      if (newElement != null)
        msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.ATTRIBUTABLE_NO_ROLE__ELEMENT, null, msgs);
      msgs = basicSetElement(newElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.ATTRIBUTABLE_NO_ROLE__ELEMENT, newElement, newElement));
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
      case DmplPackage.ATTRIBUTABLE_NO_ROLE__ATTR_LIST:
        return basicSetAttrList(null, msgs);
      case DmplPackage.ATTRIBUTABLE_NO_ROLE__ELEMENT:
        return basicSetElement(null, msgs);
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
      case DmplPackage.ATTRIBUTABLE_NO_ROLE__ATTR_LIST:
        return getAttrList();
      case DmplPackage.ATTRIBUTABLE_NO_ROLE__ELEMENT:
        return getElement();
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
      case DmplPackage.ATTRIBUTABLE_NO_ROLE__ATTR_LIST:
        setAttrList((AttrList)newValue);
        return;
      case DmplPackage.ATTRIBUTABLE_NO_ROLE__ELEMENT:
        setElement((AttributableNoRoleElement)newValue);
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
      case DmplPackage.ATTRIBUTABLE_NO_ROLE__ATTR_LIST:
        setAttrList((AttrList)null);
        return;
      case DmplPackage.ATTRIBUTABLE_NO_ROLE__ELEMENT:
        setElement((AttributableNoRoleElement)null);
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
      case DmplPackage.ATTRIBUTABLE_NO_ROLE__ATTR_LIST:
        return attrList != null;
      case DmplPackage.ATTRIBUTABLE_NO_ROLE__ELEMENT:
        return element != null;
    }
    return super.eIsSet(featureID);
  }

} //AttributableNoRoleImpl
