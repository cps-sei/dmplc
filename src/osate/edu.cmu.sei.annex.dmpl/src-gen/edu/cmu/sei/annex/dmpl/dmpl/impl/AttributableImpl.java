/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.Attr;
import edu.cmu.sei.annex.dmpl.dmpl.Attributable;
import edu.cmu.sei.annex.dmpl.dmpl.AttributableElement;
import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;

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
 * An implementation of the model object '<em><b>Attributable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.AttributableImpl#getAttrs <em>Attrs</em>}</li>
 *   <li>{@link edu.cmu.sei.annex.dmpl.dmpl.impl.AttributableImpl#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributableImpl extends NodeBodyElementImpl implements Attributable
{
  /**
   * The cached value of the '{@link #getAttrs() <em>Attrs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttrs()
   * @generated
   * @ordered
   */
  protected EList<Attr> attrs;

  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected AttributableElement element;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributableImpl()
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
    return DmplPackage.Literals.ATTRIBUTABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Attr> getAttrs()
  {
    if (attrs == null)
    {
      attrs = new EObjectContainmentEList<Attr>(Attr.class, this, DmplPackage.ATTRIBUTABLE__ATTRS);
    }
    return attrs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributableElement getElement()
  {
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElement(AttributableElement newElement, NotificationChain msgs)
  {
    AttributableElement oldElement = element;
    element = newElement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DmplPackage.ATTRIBUTABLE__ELEMENT, oldElement, newElement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElement(AttributableElement newElement)
  {
    if (newElement != element)
    {
      NotificationChain msgs = null;
      if (element != null)
        msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DmplPackage.ATTRIBUTABLE__ELEMENT, null, msgs);
      if (newElement != null)
        msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DmplPackage.ATTRIBUTABLE__ELEMENT, null, msgs);
      msgs = basicSetElement(newElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DmplPackage.ATTRIBUTABLE__ELEMENT, newElement, newElement));
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
      case DmplPackage.ATTRIBUTABLE__ATTRS:
        return ((InternalEList<?>)getAttrs()).basicRemove(otherEnd, msgs);
      case DmplPackage.ATTRIBUTABLE__ELEMENT:
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
      case DmplPackage.ATTRIBUTABLE__ATTRS:
        return getAttrs();
      case DmplPackage.ATTRIBUTABLE__ELEMENT:
        return getElement();
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
      case DmplPackage.ATTRIBUTABLE__ATTRS:
        getAttrs().clear();
        getAttrs().addAll((Collection<? extends Attr>)newValue);
        return;
      case DmplPackage.ATTRIBUTABLE__ELEMENT:
        setElement((AttributableElement)newValue);
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
      case DmplPackage.ATTRIBUTABLE__ATTRS:
        getAttrs().clear();
        return;
      case DmplPackage.ATTRIBUTABLE__ELEMENT:
        setElement((AttributableElement)null);
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
      case DmplPackage.ATTRIBUTABLE__ATTRS:
        return attrs != null && !attrs.isEmpty();
      case DmplPackage.ATTRIBUTABLE__ELEMENT:
        return element != null;
    }
    return super.eIsSet(featureID);
  }

} //AttributableImpl
