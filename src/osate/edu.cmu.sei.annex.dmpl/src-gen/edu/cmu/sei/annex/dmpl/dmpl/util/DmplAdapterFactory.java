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
      public Adapter caseVarInit(VarInit object)
      {
        return createVarInitAdapter();
      }
      @Override
      public Adapter caseVarAsgnList(VarAsgnList object)
      {
        return createVarAsgnListAdapter();
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
      public Adapter caseProcNoAttr(ProcNoAttr object)
      {
        return createProcNoAttrAdapter();
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
      public Adapter caseParam(Param object)
      {
        return createParamAdapter();
      }
      @Override
      public Adapter caseVarInitList(VarInitList object)
      {
        return createVarInitListAdapter();
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
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgnList <em>Var Asgn List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.VarAsgnList
   * @generated
   */
  public Adapter createVarAsgnListAdapter()
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
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.ProcNoAttr <em>Proc No Attr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ProcNoAttr
   * @generated
   */
  public Adapter createProcNoAttrAdapter()
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
   * Creates a new adapter for an object of class '{@link edu.cmu.sei.annex.dmpl.dmpl.VarInitList <em>Var Init List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.cmu.sei.annex.dmpl.dmpl.VarInitList
   * @generated
   */
  public Adapter createVarInitListAdapter()
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
