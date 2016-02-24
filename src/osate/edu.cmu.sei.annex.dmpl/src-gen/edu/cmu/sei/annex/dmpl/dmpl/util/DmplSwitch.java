/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.util;

import edu.cmu.sei.annex.dmpl.dmpl.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage
 * @generated
 */
public class DmplSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static DmplPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DmplSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = DmplPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case DmplPackage.PROGRAM:
      {
        Program program = (Program)theEObject;
        T result = caseProgram(program);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.DMPL_SUBCLAUSE:
      {
        DmplSubclause dmplSubclause = (DmplSubclause)theEObject;
        T result = caseDmplSubclause(dmplSubclause);
        if (result == null) result = caseAnnexSubclause(dmplSubclause);
        if (result == null) result = caseModalElement(dmplSubclause);
        if (result == null) result = caseNamedElement(dmplSubclause);
        if (result == null) result = caseElement(dmplSubclause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.PROGRAM_ELEMENT:
      {
        ProgramElement programElement = (ProgramElement)theEObject;
        T result = caseProgramElement(programElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.CONSTANT:
      {
        Constant constant = (Constant)theEObject;
        T result = caseConstant(constant);
        if (result == null) result = caseProgramElement(constant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.NUMBER_CONST:
      {
        NumberConst numberConst = (NumberConst)theEObject;
        T result = caseNumberConst(numberConst);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.INT_CONST:
      {
        IntConst intConst = (IntConst)theEObject;
        T result = caseIntConst(intConst);
        if (result == null) result = caseNumberConst(intConst);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.DOUBLE_CONST:
      {
        DoubleConst doubleConst = (DoubleConst)theEObject;
        T result = caseDoubleConst(doubleConst);
        if (result == null) result = caseNumberConst(doubleConst);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.VAR:
      {
        Var var = (Var)theEObject;
        T result = caseVar(var);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.DIMENSION:
      {
        Dimension dimension = (Dimension)theEObject;
        T result = caseDimension(dimension);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.TYPE:
      {
        Type type = (Type)theEObject;
        T result = caseType(type);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.PROCEDURE:
      {
        Procedure procedure = (Procedure)theEObject;
        T result = caseProcedure(procedure);
        if (result == null) result = caseProgramElement(procedure);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.PROC_NO_ATTR:
      {
        ProcNoAttr procNoAttr = (ProcNoAttr)theEObject;
        T result = caseProcNoAttr(procNoAttr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.FN_PROTOTYPE:
      {
        FnPrototype fnPrototype = (FnPrototype)theEObject;
        T result = caseFnPrototype(fnPrototype);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.FN_PROTOTYPE_NO_DECORS:
      {
        FnPrototypeNoDecors fnPrototypeNoDecors = (FnPrototypeNoDecors)theEObject;
        T result = caseFnPrototypeNoDecors(fnPrototypeNoDecors);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.PARAM:
      {
        Param param = (Param)theEObject;
        T result = caseParam(param);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.INT_DIMENSION:
      {
        IntDimension intDimension = (IntDimension)theEObject;
        T result = caseIntDimension(intDimension);
        if (result == null) result = caseDimension(intDimension);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.NODE_NUM_DIMENSION:
      {
        NodeNumDimension nodeNumDimension = (NodeNumDimension)theEObject;
        T result = caseNodeNumDimension(nodeNumDimension);
        if (result == null) result = caseDimension(nodeNumDimension);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.ID_DIMENSION:
      {
        IdDimension idDimension = (IdDimension)theEObject;
        T result = caseIdDimension(idDimension);
        if (result == null) result = caseDimension(idDimension);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.THREAD_DECLARATION:
      {
        ThreadDeclaration threadDeclaration = (ThreadDeclaration)theEObject;
        T result = caseThreadDeclaration(threadDeclaration);
        if (result == null) result = caseFnPrototypeNoDecors(threadDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.FN_PROTOTYPE_DECLARATION:
      {
        FnPrototypeDeclaration fnPrototypeDeclaration = (FnPrototypeDeclaration)theEObject;
        T result = caseFnPrototypeDeclaration(fnPrototypeDeclaration);
        if (result == null) result = caseFnPrototypeNoDecors(fnPrototypeDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Program</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Program</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProgram(Program object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subclause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subclause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDmplSubclause(DmplSubclause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Program Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Program Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProgramElement(ProgramElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstant(Constant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Number Const</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Number Const</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumberConst(NumberConst object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Int Const</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Int Const</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntConst(IntConst object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Double Const</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Double Const</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDoubleConst(DoubleConst object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Var</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVar(Var object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Dimension</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dimension</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDimension(Dimension object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType(Type object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Procedure</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Procedure</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProcedure(Procedure object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Proc No Attr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Proc No Attr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProcNoAttr(ProcNoAttr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fn Prototype</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fn Prototype</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFnPrototype(FnPrototype object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fn Prototype No Decors</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fn Prototype No Decors</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFnPrototypeNoDecors(FnPrototypeNoDecors object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Param</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Param</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParam(Param object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Int Dimension</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Int Dimension</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntDimension(IntDimension object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Node Num Dimension</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node Num Dimension</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNodeNumDimension(NodeNumDimension object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Id Dimension</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Id Dimension</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIdDimension(IdDimension object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Thread Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Thread Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThreadDeclaration(ThreadDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fn Prototype Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fn Prototype Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFnPrototypeDeclaration(FnPrototypeDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElement(Element object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedElement(NamedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Modal Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Modal Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModalElement(ModalElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Annex Subclause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annex Subclause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnnexSubclause(AnnexSubclause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //DmplSwitch
