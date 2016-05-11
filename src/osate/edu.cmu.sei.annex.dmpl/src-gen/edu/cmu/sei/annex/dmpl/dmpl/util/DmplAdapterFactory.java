/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.util;

import edu.cmu.sei.annex.dmpl.dmpl.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage
 * @generated
 */
public class DmplAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static DmplPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DmplAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = DmplPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DmplSwitch<Adapter> modelSwitch =
    new DmplSwitch<Adapter>()
    {
      @Override
      public Adapter caseProgram(Program object)
      {
        return createProgramAdapter();
      }
      @Override
      public Adapter caseDmplSubclause(DmplSubclause object)
      {
        return createDmplSubclauseAdapter();
      }
      @Override
      public Adapter caseProgramElement(ProgramElement object)
      {
        return createProgramElementAdapter();
      }
      @Override
      public Adapter caseConstant(Constant object)
      {
        return createConstantAdapter();
      }
      @Override
      public Adapter caseNumberConst(NumberConst object)
      {
        return createNumberConstAdapter();
      }
      @Override
      public Adapter caseIntConst(IntConst object)
      {
        return createIntConstAdapter();
      }
      @Override
      public Adapter caseDoubleConst(DoubleConst object)
      {
        return createDoubleConstAdapter();
      }
      @Override
      public Adapter caseNode(Node object)
      {
        return createNodeAdapter();
      }
      @Override
      public Adapter caseNodeNoAttr(NodeNoAttr object)
      {
        return createNodeNoAttrAdapter();
      }
      @Override
      public Adapter caseNodeBody(NodeBody object)
      {
        return createNodeBodyAdapter();
      }
      @Override
      public Adapter caseNodeBodyElement(NodeBodyElement object)
      {
        return createNodeBodyElementAdapter();
      }
      @Override
      public Adapter caseVarBlock(VarBlock object)
      {
        return createVarBlockAdapter();
      }
      @Override
      public Adapter caseRecordBlock(RecordBlock object)
      {
        return createRecordBlockAdapter();
      }
      @Override
      public Adapter caseNodeVarInit(NodeVarInit object)
      {
        return createNodeVarInitAdapter();
      }
      @Override
      public Adapter caseRecord(Record object)
      {
        return createRecordAdapter();
      }
      @Override
      public Adapter caseVarInit(VarInit object)
      {
        return createVarInitAdapter();
      }
      @Override
      public Adapter caseVarAsgn(VarAsgn object)
      {
        return createVarAsgnAdapter();
      }
      @Override
      public Adapter caseVar(Var object)
      {
        return createVarAdapter();
      }
      @Override
      public Adapter caseDimension(Dimension object)
      {
        return createDimensionAdapter();
      }
      @Override
      public Adapter caseType(Type object)
      {
        return createTypeAdapter();
      }
      @Override
      public Adapter caseProcedure(Procedure object)
      {
        return createProcedureAdapter();
      }
      @Override
      public Adapter caseFnBody(FnBody object)
      {
        return createFnBodyAdapter();
      }
      @Override
      public Adapter caseFnPrototype(FnPrototype object)
      {
        return createFnPrototypeAdapter();
      }
      @Override
      public Adapter caseAttrList(AttrList object)
      {
        return createAttrListAdapter();
      }
      @Override
      public Adapter caseAttr(Attr object)
      {
        return createAttrAdapter();
      }
      @Override
      public Adapter caseParam(Param object)
      {
        return createParamAdapter();
      }
      @Override
      public Adapter caseStmt(Stmt object)
      {
        return createStmtAdapter();
      }
      @Override
      public Adapter caseAssignmentStmt(AssignmentStmt object)
      {
        return createAssignmentStmtAdapter();
      }
      @Override
      public Adapter caseLVal(LVal object)
      {
        return createLValAdapter();
      }
      @Override
      public Adapter caseExpr(Expr object)
      {
        return createExprAdapter();
      }
      @Override
      public Adapter caseCallExpr(CallExpr object)
      {
        return createCallExprAdapter();
      }
      @Override
      public Adapter caseExprVarAsgn(ExprVarAsgn object)
      {
        return createExprVarAsgnAdapter();
      }
      @Override
      public Adapter caseFnVarAsgn(FnVarAsgn object)
      {
        return createFnVarAsgnAdapter();
      }
      @Override
      public Adapter caseIntDimension(IntDimension object)
      {
        return createIntDimensionAdapter();
      }
      @Override
      public Adapter caseNodeNumDimension(NodeNumDimension object)
      {
        return createNodeNumDimensionAdapter();
      }
      @Override
      public Adapter caseIdDimension(IdDimension object)
      {
        return createIdDimensionAdapter();
      }
      @Override
      public Adapter caseThreadDeclaration(ThreadDeclaration object)
      {
        return createThreadDeclarationAdapter();
      }
      @Override
      public Adapter caseFnPrototypeDeclaration(FnPrototypeDeclaration object)
      {
        return createFnPrototypeDeclarationAdapter();
      }
      @Override
      public Adapter caseNestedStmt(NestedStmt object)
      {
        return createNestedStmtAdapter();
      }
      @Override
      public Adapter caseWhileStmt(WhileStmt object)
      {
        return createWhileStmtAdapter();
      }
      @Override
      public Adapter caseForStmt(ForStmt object)
      {
        return createForStmtAdapter();
      }
      @Override
      public Adapter caseCondStmt(CondStmt object)
      {
        return createCondStmtAdapter();
      }
      @Override
      public Adapter caseSimpleStmt(SimpleStmt object)
      {
        return createSimpleStmtAdapter();
      }
      @Override
      public Adapter caseReturnValueStmt(ReturnValueStmt object)
      {
        return createReturnValueStmtAdapter();
      }
      @Override
      public Adapter caseForAllStmt(ForAllStmt object)
      {
        return createForAllStmtAdapter();
      }
      @Override
      public Adapter caseFadnpStmt(FadnpStmt object)
      {
        return createFadnpStmtAdapter();
      }
      @Override
      public Adapter caseTernaryExpr(TernaryExpr object)
      {
        return createTernaryExprAdapter();
      }
      @Override
      public Adapter caseOrExpr(OrExpr object)
      {
        return createOrExprAdapter();
      }
      @Override
      public Adapter caseAndExpr(AndExpr object)
      {
        return createAndExprAdapter();
      }
      @Override
      public Adapter caseBitwiseOrExpr(BitwiseOrExpr object)
      {
        return createBitwiseOrExprAdapter();
      }
      @Override
      public Adapter caseXorExpr(XorExpr object)
      {
        return createXorExprAdapter();
      }
      @Override
      public Adapter caseBitwiseAndExpr(BitwiseAndExpr object)
      {
        return createBitwiseAndExprAdapter();
      }
      @Override
      public Adapter caseEqualityExpr(EqualityExpr object)
      {
        return createEqualityExprAdapter();
      }
      @Override
      public Adapter caseCompareExpr(CompareExpr object)
      {
        return createCompareExprAdapter();
      }
      @Override
      public Adapter caseShiftExpr(ShiftExpr object)
      {
        return createShiftExprAdapter();
      }
      @Override
      public Adapter caseAdditiveExpr(AdditiveExpr object)
      {
        return createAdditiveExprAdapter();
      }
      @Override
      public Adapter caseMultiplicativeExpr(MultiplicativeExpr object)
      {
        return createMultiplicativeExprAdapter();
      }
      @Override
      public Adapter caseIdExpr(IdExpr object)
      {
        return createIdExprAdapter();
      }
      @Override
      public Adapter caseIntExpr(IntExpr object)
      {
        return createIntExprAdapter();
      }
      @Override
      public Adapter caseDoubleExpr(DoubleExpr object)
      {
        return createDoubleExprAdapter();
      }
      @Override
      public Adapter caseNodeNumExpr(NodeNumExpr object)
      {
        return createNodeNumExprAdapter();
      }
      @Override
      public Adapter caseUnaryExpr(UnaryExpr object)
      {
        return createUnaryExprAdapter();
      }
      @Override
      public Adapter caseBuiltInExpr(BuiltInExpr object)
      {
        return createBuiltInExprAdapter();
      }
      @Override
      public Adapter caseElement(Element object)
      {
        return createElementAdapter();
      }
      @Override
      public Adapter caseNamedElement(NamedElement object)
      {
        return createNamedElementAdapter();
      }
      @Override
      public Adapter caseModalElement(ModalElement object)
      {
        return createModalElementAdapter();
      }
      @Override
      public Adapter caseAnnexSubclause(AnnexSubclause object)
      {
        return createAnnexSubclauseAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.Program <em>Program</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Program
   * @generated
   */
  public Adapter createProgramAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.DmplSubclause <em>Subclause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplSubclause
   * @generated
   */
  public Adapter createDmplSubclauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.ProgramElement <em>Program Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ProgramElement
   * @generated
   */
  public Adapter createProgramElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Constant
   * @generated
   */
  public Adapter createConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.NumberConst <em>Number Const</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.NumberConst
   * @generated
   */
  public Adapter createNumberConstAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.IntConst <em>Int Const</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.IntConst
   * @generated
   */
  public Adapter createIntConstAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.DoubleConst <em>Double Const</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DoubleConst
   * @generated
   */
  public Adapter createDoubleConstAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.Node <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Node
   * @generated
   */
  public Adapter createNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.NodeNoAttr <em>Node No Attr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.NodeNoAttr
   * @generated
   */
  public Adapter createNodeNoAttrAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.NodeBody <em>Node Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.NodeBody
   * @generated
   */
  public Adapter createNodeBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.NodeBodyElement <em>Node Body Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.NodeBodyElement
   * @generated
   */
  public Adapter createNodeBodyElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.VarBlock <em>Var Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.VarBlock
   * @generated
   */
  public Adapter createVarBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.RecordBlock <em>Record Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.RecordBlock
   * @generated
   */
  public Adapter createRecordBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.NodeVarInit <em>Node Var Init</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.NodeVarInit
   * @generated
   */
  public Adapter createNodeVarInitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.Record <em>Record</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Record
   * @generated
   */
  public Adapter createRecordAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.VarInit <em>Var Init</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.VarInit
   * @generated
   */
  public Adapter createVarInitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgn <em>Var Asgn</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.VarAsgn
   * @generated
   */
  public Adapter createVarAsgnAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.Var <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Var
   * @generated
   */
  public Adapter createVarAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.Dimension <em>Dimension</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Dimension
   * @generated
   */
  public Adapter createDimensionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Type
   * @generated
   */
  public Adapter createTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure <em>Procedure</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Procedure
   * @generated
   */
  public Adapter createProcedureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.FnBody <em>Fn Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnBody
   * @generated
   */
  public Adapter createFnBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototype <em>Fn Prototype</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnPrototype
   * @generated
   */
  public Adapter createFnPrototypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.AttrList <em>Attr List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.AttrList
   * @generated
   */
  public Adapter createAttrListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.Attr <em>Attr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Attr
   * @generated
   */
  public Adapter createAttrAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.Param <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Param
   * @generated
   */
  public Adapter createParamAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.Stmt <em>Stmt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Stmt
   * @generated
   */
  public Adapter createStmtAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.AssignmentStmt <em>Assignment Stmt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.AssignmentStmt
   * @generated
   */
  public Adapter createAssignmentStmtAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.LVal <em>LVal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.LVal
   * @generated
   */
  public Adapter createLValAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.Expr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Expr
   * @generated
   */
  public Adapter createExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.CallExpr <em>Call Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.CallExpr
   * @generated
   */
  public Adapter createCallExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.ExprVarAsgn <em>Expr Var Asgn</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ExprVarAsgn
   * @generated
   */
  public Adapter createExprVarAsgnAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.FnVarAsgn <em>Fn Var Asgn</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnVarAsgn
   * @generated
   */
  public Adapter createFnVarAsgnAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.IntDimension <em>Int Dimension</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.IntDimension
   * @generated
   */
  public Adapter createIntDimensionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.NodeNumDimension <em>Node Num Dimension</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.NodeNumDimension
   * @generated
   */
  public Adapter createNodeNumDimensionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.IdDimension <em>Id Dimension</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.IdDimension
   * @generated
   */
  public Adapter createIdDimensionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.ThreadDeclaration <em>Thread Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ThreadDeclaration
   * @generated
   */
  public Adapter createThreadDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeDeclaration <em>Fn Prototype Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeDeclaration
   * @generated
   */
  public Adapter createFnPrototypeDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.NestedStmt <em>Nested Stmt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.NestedStmt
   * @generated
   */
  public Adapter createNestedStmtAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.WhileStmt <em>While Stmt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.WhileStmt
   * @generated
   */
  public Adapter createWhileStmtAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.ForStmt <em>For Stmt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ForStmt
   * @generated
   */
  public Adapter createForStmtAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.CondStmt <em>Cond Stmt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.CondStmt
   * @generated
   */
  public Adapter createCondStmtAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.SimpleStmt <em>Simple Stmt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.SimpleStmt
   * @generated
   */
  public Adapter createSimpleStmtAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.ReturnValueStmt <em>Return Value Stmt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ReturnValueStmt
   * @generated
   */
  public Adapter createReturnValueStmtAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt <em>For All Stmt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt
   * @generated
   */
  public Adapter createForAllStmtAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt <em>Fadnp Stmt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt
   * @generated
   */
  public Adapter createFadnpStmtAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr <em>Ternary Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr
   * @generated
   */
  public Adapter createTernaryExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.OrExpr <em>Or Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.OrExpr
   * @generated
   */
  public Adapter createOrExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.AndExpr <em>And Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.AndExpr
   * @generated
   */
  public Adapter createAndExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.BitwiseOrExpr <em>Bitwise Or Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.BitwiseOrExpr
   * @generated
   */
  public Adapter createBitwiseOrExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.XorExpr <em>Xor Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.XorExpr
   * @generated
   */
  public Adapter createXorExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.BitwiseAndExpr <em>Bitwise And Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.BitwiseAndExpr
   * @generated
   */
  public Adapter createBitwiseAndExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.EqualityExpr <em>Equality Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.EqualityExpr
   * @generated
   */
  public Adapter createEqualityExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.CompareExpr <em>Compare Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.CompareExpr
   * @generated
   */
  public Adapter createCompareExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.ShiftExpr <em>Shift Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ShiftExpr
   * @generated
   */
  public Adapter createShiftExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.AdditiveExpr <em>Additive Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.AdditiveExpr
   * @generated
   */
  public Adapter createAdditiveExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr <em>Multiplicative Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr
   * @generated
   */
  public Adapter createMultiplicativeExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.IdExpr <em>Id Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.IdExpr
   * @generated
   */
  public Adapter createIdExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.IntExpr <em>Int Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.IntExpr
   * @generated
   */
  public Adapter createIntExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.DoubleExpr <em>Double Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DoubleExpr
   * @generated
   */
  public Adapter createDoubleExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.NodeNumExpr <em>Node Num Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.NodeNumExpr
   * @generated
   */
  public Adapter createNodeNumExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.UnaryExpr <em>Unary Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.UnaryExpr
   * @generated
   */
  public Adapter createUnaryExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr <em>Built In Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr
   * @generated
   */
  public Adapter createBuiltInExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.Element
   * @generated
   */
  public Adapter createElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.NamedElement
   * @generated
   */
  public Adapter createNamedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.ModalElement <em>Modal Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.ModalElement
   * @generated
   */
  public Adapter createModalElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.AnnexSubclause <em>Annex Subclause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.AnnexSubclause
   * @generated
   */
  public Adapter createAnnexSubclauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //DmplAdapterFactory
