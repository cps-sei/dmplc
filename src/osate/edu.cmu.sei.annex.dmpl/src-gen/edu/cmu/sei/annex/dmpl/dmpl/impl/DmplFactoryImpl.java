/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DmplFactoryImpl extends EFactoryImpl implements DmplFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static DmplFactory init()
  {
    try
    {
      DmplFactory theDmplFactory = (DmplFactory)EPackage.Registry.INSTANCE.getEFactory(DmplPackage.eNS_URI);
      if (theDmplFactory != null)
      {
        return theDmplFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new DmplFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DmplFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case DmplPackage.PROGRAM: return createProgram();
      case DmplPackage.DMPL_SUBCLAUSE: return createDmplSubclause();
      case DmplPackage.PROGRAM_ELEMENT: return createProgramElement();
      case DmplPackage.CONSTANT: return createConstant();
      case DmplPackage.NUMBER_CONST: return createNumberConst();
      case DmplPackage.INT_CONST: return createIntConst();
      case DmplPackage.DOUBLE_CONST: return createDoubleConst();
      case DmplPackage.VAR: return createVar();
      case DmplPackage.DIMENSION: return createDimension();
      case DmplPackage.TYPE: return createType();
      case DmplPackage.PROCEDURE: return createProcedure();
      case DmplPackage.PROC_NO_ATTR: return createProcNoAttr();
      case DmplPackage.FN_PROTOTYPE: return createFnPrototype();
      case DmplPackage.FN_PROTOTYPE_NO_DECORS: return createFnPrototypeNoDecors();
      case DmplPackage.PARAM: return createParam();
      case DmplPackage.INT_DIMENSION: return createIntDimension();
      case DmplPackage.NODE_NUM_DIMENSION: return createNodeNumDimension();
      case DmplPackage.ID_DIMENSION: return createIdDimension();
      case DmplPackage.THREAD_DECLARATION: return createThreadDeclaration();
      case DmplPackage.FN_PROTOTYPE_DECLARATION: return createFnPrototypeDeclaration();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case DmplPackage.SIGN_ENUM:
        return createSignEnumFromString(eDataType, initialValue);
      case DmplPackage.SIMP_TYPE_ENUM:
        return createSimpTypeEnumFromString(eDataType, initialValue);
      case DmplPackage.SIGNED_ENUM:
        return createSignedEnumFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case DmplPackage.SIGN_ENUM:
        return convertSignEnumToString(eDataType, instanceValue);
      case DmplPackage.SIMP_TYPE_ENUM:
        return convertSimpTypeEnumToString(eDataType, instanceValue);
      case DmplPackage.SIGNED_ENUM:
        return convertSignedEnumToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Program createProgram()
  {
    ProgramImpl program = new ProgramImpl();
    return program;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DmplSubclause createDmplSubclause()
  {
    DmplSubclauseImpl dmplSubclause = new DmplSubclauseImpl();
    return dmplSubclause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProgramElement createProgramElement()
  {
    ProgramElementImpl programElement = new ProgramElementImpl();
    return programElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constant createConstant()
  {
    ConstantImpl constant = new ConstantImpl();
    return constant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumberConst createNumberConst()
  {
    NumberConstImpl numberConst = new NumberConstImpl();
    return numberConst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntConst createIntConst()
  {
    IntConstImpl intConst = new IntConstImpl();
    return intConst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DoubleConst createDoubleConst()
  {
    DoubleConstImpl doubleConst = new DoubleConstImpl();
    return doubleConst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Var createVar()
  {
    VarImpl var = new VarImpl();
    return var;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Dimension createDimension()
  {
    DimensionImpl dimension = new DimensionImpl();
    return dimension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createType()
  {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Procedure createProcedure()
  {
    ProcedureImpl procedure = new ProcedureImpl();
    return procedure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcNoAttr createProcNoAttr()
  {
    ProcNoAttrImpl procNoAttr = new ProcNoAttrImpl();
    return procNoAttr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FnPrototype createFnPrototype()
  {
    FnPrototypeImpl fnPrototype = new FnPrototypeImpl();
    return fnPrototype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FnPrototypeNoDecors createFnPrototypeNoDecors()
  {
    FnPrototypeNoDecorsImpl fnPrototypeNoDecors = new FnPrototypeNoDecorsImpl();
    return fnPrototypeNoDecors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Param createParam()
  {
    ParamImpl param = new ParamImpl();
    return param;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntDimension createIntDimension()
  {
    IntDimensionImpl intDimension = new IntDimensionImpl();
    return intDimension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeNumDimension createNodeNumDimension()
  {
    NodeNumDimensionImpl nodeNumDimension = new NodeNumDimensionImpl();
    return nodeNumDimension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdDimension createIdDimension()
  {
    IdDimensionImpl idDimension = new IdDimensionImpl();
    return idDimension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ThreadDeclaration createThreadDeclaration()
  {
    ThreadDeclarationImpl threadDeclaration = new ThreadDeclarationImpl();
    return threadDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FnPrototypeDeclaration createFnPrototypeDeclaration()
  {
    FnPrototypeDeclarationImpl fnPrototypeDeclaration = new FnPrototypeDeclarationImpl();
    return fnPrototypeDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignEnum createSignEnumFromString(EDataType eDataType, String initialValue)
  {
    SignEnum result = SignEnum.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSignEnumToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpTypeEnum createSimpTypeEnumFromString(EDataType eDataType, String initialValue)
  {
    SimpTypeEnum result = SimpTypeEnum.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSimpTypeEnumToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignedEnum createSignedEnumFromString(EDataType eDataType, String initialValue)
  {
    SignedEnum result = SignedEnum.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSignedEnumToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DmplPackage getDmplPackage()
  {
    return (DmplPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static DmplPackage getPackage()
  {
    return DmplPackage.eINSTANCE;
  }

} //DmplFactoryImpl
