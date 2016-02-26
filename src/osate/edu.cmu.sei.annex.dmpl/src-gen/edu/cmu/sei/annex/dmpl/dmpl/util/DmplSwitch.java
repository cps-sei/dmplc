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
      case DmplPackage.VAR_INIT:
      {
        VarInit varInit = (VarInit)theEObject;
        T result = caseVarInit(varInit);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.VAR_ASGN_LIST:
      {
        VarAsgnList varAsgnList = (VarAsgnList)theEObject;
        T result = caseVarAsgnList(varAsgnList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.VAR_ASGN:
      {
        VarAsgn varAsgn = (VarAsgn)theEObject;
        T result = caseVarAsgn(varAsgn);
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
      case DmplPackage.FN_BODY:
      {
        FnBody fnBody = (FnBody)theEObject;
        T result = caseFnBody(fnBody);
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
      case DmplPackage.PARAM:
      {
        Param param = (Param)theEObject;
        T result = caseParam(param);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.VAR_INIT_LIST:
      {
        VarInitList varInitList = (VarInitList)theEObject;
        T result = caseVarInitList(varInitList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.LVAL:
      {
        LVal lVal = (LVal)theEObject;
        T result = caseLVal(lVal);
        if (result == null) result = caseExpr(lVal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.EXPR:
      {
        Expr expr = (Expr)theEObject;
        T result = caseExpr(expr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.CALL_EXPR:
      {
        CallExpr callExpr = (CallExpr)theEObject;
        T result = caseCallExpr(callExpr);
        if (result == null) result = caseExpr(callExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.ARG_LIST:
      {
        ArgList argList = (ArgList)theEObject;
        T result = caseArgList(argList);
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
        if (result == null) result = caseFnPrototype(threadDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.FN_PROTOTYPE_DECLARATION:
      {
        FnPrototypeDeclaration fnPrototypeDeclaration = (FnPrototypeDeclaration)theEObject;
        T result = caseFnPrototypeDeclaration(fnPrototypeDeclaration);
        if (result == null) result = caseFnPrototype(fnPrototypeDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.SHIFT_EXPR:
      {
        ShiftExpr shiftExpr = (ShiftExpr)theEObject;
        T result = caseShiftExpr(shiftExpr);
        if (result == null) result = caseExpr(shiftExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.ADDITIVE_EXPR:
      {
        AdditiveExpr additiveExpr = (AdditiveExpr)theEObject;
        T result = caseAdditiveExpr(additiveExpr);
        if (result == null) result = caseExpr(additiveExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.MULTIPLICATIVE_EXPR:
      {
        MultiplicativeExpr multiplicativeExpr = (MultiplicativeExpr)theEObject;
        T result = caseMultiplicativeExpr(multiplicativeExpr);
        if (result == null) result = caseExpr(multiplicativeExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.ID_EXPR:
      {
        IdExpr idExpr = (IdExpr)theEObject;
        T result = caseIdExpr(idExpr);
        if (result == null) result = caseExpr(idExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.INT_EXPR:
      {
        IntExpr intExpr = (IntExpr)theEObject;
        T result = caseIntExpr(intExpr);
        if (result == null) result = caseExpr(intExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.DOUBLE_EXPR:
      {
        DoubleExpr doubleExpr = (DoubleExpr)theEObject;
        T result = caseDoubleExpr(doubleExpr);
        if (result == null) result = caseExpr(doubleExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.NODE_NUM_EXPR:
      {
        NodeNumExpr nodeNumExpr = (NodeNumExpr)theEObject;
        T result = caseNodeNumExpr(nodeNumExpr);
        if (result == null) result = caseExpr(nodeNumExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.UNARY_EXPR:
      {
        UnaryExpr unaryExpr = (UnaryExpr)theEObject;
        T result = caseUnaryExpr(unaryExpr);
        if (result == null) result = caseExpr(unaryExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DmplPackage.BUILT_IN_EXPR:
      {
        BuiltInExpr builtInExpr = (BuiltInExpr)theEObject;
        T result = caseBuiltInExpr(builtInExpr);
        if (result == null) result = caseExpr(builtInExpr);
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
   * Returns the result of interpreting the object as an instance of '<em>Var Init</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Init</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVarInit(VarInit object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Var Asgn List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Asgn List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVarAsgnList(VarAsgnList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Var Asgn</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Asgn</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVarAsgn(VarAsgn object)
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
   * Returns the result of interpreting the object as an instance of '<em>Fn Body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fn Body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFnBody(FnBody object)
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
   * Returns the result of interpreting the object as an instance of '<em>Var Init List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Init List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVarInitList(VarInitList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>LVal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LVal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLVal(LVal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpr(Expr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Call Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Call Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCallExpr(CallExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arg List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arg List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArgList(ArgList object)
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
   * Returns the result of interpreting the object as an instance of '<em>Shift Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Shift Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseShiftExpr(ShiftExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Additive Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Additive Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdditiveExpr(AdditiveExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicative Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicative Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiplicativeExpr(MultiplicativeExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Id Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Id Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIdExpr(IdExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Int Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Int Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntExpr(IntExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Double Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Double Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDoubleExpr(DoubleExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Node Num Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node Num Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNodeNumExpr(NodeNumExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryExpr(UnaryExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Built In Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Built In Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBuiltInExpr(BuiltInExpr object)
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
