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
      case DmplPackage.VAR_INIT: return createVarInit();
      case DmplPackage.VAR_ASGN: return createVarAsgn();
      case DmplPackage.VAR: return createVar();
      case DmplPackage.DIMENSION: return createDimension();
      case DmplPackage.TYPE: return createType();
      case DmplPackage.PROCEDURE: return createProcedure();
      case DmplPackage.PROC_NO_ATTR: return createProcNoAttr();
      case DmplPackage.FN_BODY: return createFnBody();
      case DmplPackage.FN_PROTOTYPE: return createFnPrototype();
      case DmplPackage.ATTR_LIST: return createAttrList();
      case DmplPackage.ATTR: return createAttr();
      case DmplPackage.PARAM: return createParam();
      case DmplPackage.VAR_INIT_LIST: return createVarInitList();
      case DmplPackage.STMT_LIST: return createStmtList();
      case DmplPackage.COND_STMT: return createCondStmt();
      case DmplPackage.STMT: return createStmt();
      case DmplPackage.ASSIGNMENT_STMT: return createAssignmentStmt();
      case DmplPackage.LVAL: return createLVal();
      case DmplPackage.EXPR: return createExpr();
      case DmplPackage.CALL_EXPR: return createCallExpr();
      case DmplPackage.EXPR_VAR_ASGN: return createExprVarAsgn();
      case DmplPackage.FN_VAR_ASGN: return createFnVarAsgn();
      case DmplPackage.INT_DIMENSION: return createIntDimension();
      case DmplPackage.NODE_NUM_DIMENSION: return createNodeNumDimension();
      case DmplPackage.ID_DIMENSION: return createIdDimension();
      case DmplPackage.THREAD_DECLARATION: return createThreadDeclaration();
      case DmplPackage.FN_PROTOTYPE_DECLARATION: return createFnPrototypeDeclaration();
      case DmplPackage.NESTED_STMT: return createNestedStmt();
      case DmplPackage.WHILE_STMT: return createWhileStmt();
      case DmplPackage.FOR_STMT: return createForStmt();
      case DmplPackage.SIMPLE_STMT: return createSimpleStmt();
      case DmplPackage.RETURN_VALUE_STMT: return createReturnValueStmt();
      case DmplPackage.FOR_ALL_STMT: return createForAllStmt();
      case DmplPackage.FADNP_STMT: return createFadnpStmt();
      case DmplPackage.TERNARY_EXPR: return createTernaryExpr();
      case DmplPackage.OR_EXPR: return createOrExpr();
      case DmplPackage.AND_EXPR: return createAndExpr();
      case DmplPackage.BITWISE_OR_EXPR: return createBitwiseOrExpr();
      case DmplPackage.XOR_EXPR: return createXorExpr();
      case DmplPackage.BITWISE_AND_EXPR: return createBitwiseAndExpr();
      case DmplPackage.EQUALITY_EXPR: return createEqualityExpr();
      case DmplPackage.COMPARE_EXPR: return createCompareExpr();
      case DmplPackage.SHIFT_EXPR: return createShiftExpr();
      case DmplPackage.ADDITIVE_EXPR: return createAdditiveExpr();
      case DmplPackage.MULTIPLICATIVE_EXPR: return createMultiplicativeExpr();
      case DmplPackage.ID_EXPR: return createIdExpr();
      case DmplPackage.INT_EXPR: return createIntExpr();
      case DmplPackage.DOUBLE_EXPR: return createDoubleExpr();
      case DmplPackage.NODE_NUM_EXPR: return createNodeNumExpr();
      case DmplPackage.UNARY_EXPR: return createUnaryExpr();
      case DmplPackage.BUILT_IN_EXPR: return createBuiltInExpr();
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
      case DmplPackage.SIMPLE_STMT_KEYWORD_ENUM:
        return createSimpleStmtKeywordEnumFromString(eDataType, initialValue);
      case DmplPackage.FOR_ALL_FUNCTION_ENUM:
        return createForAllFunctionEnumFromString(eDataType, initialValue);
      case DmplPackage.EQUALITY_OPERATOR:
        return createEqualityOperatorFromString(eDataType, initialValue);
      case DmplPackage.COMPARE_OPERATOR:
        return createCompareOperatorFromString(eDataType, initialValue);
      case DmplPackage.SHIFT_OPERATOR:
        return createShiftOperatorFromString(eDataType, initialValue);
      case DmplPackage.ADDITIVE_OPERATOR:
        return createAdditiveOperatorFromString(eDataType, initialValue);
      case DmplPackage.MULTIPLICATIVE_OPERATOR:
        return createMultiplicativeOperatorFromString(eDataType, initialValue);
      case DmplPackage.UNARY_OPERATOR:
        return createUnaryOperatorFromString(eDataType, initialValue);
      case DmplPackage.BUILT_IN_FUNCTION_ENUM:
        return createBuiltInFunctionEnumFromString(eDataType, initialValue);
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
      case DmplPackage.SIMPLE_STMT_KEYWORD_ENUM:
        return convertSimpleStmtKeywordEnumToString(eDataType, instanceValue);
      case DmplPackage.FOR_ALL_FUNCTION_ENUM:
        return convertForAllFunctionEnumToString(eDataType, instanceValue);
      case DmplPackage.EQUALITY_OPERATOR:
        return convertEqualityOperatorToString(eDataType, instanceValue);
      case DmplPackage.COMPARE_OPERATOR:
        return convertCompareOperatorToString(eDataType, instanceValue);
      case DmplPackage.SHIFT_OPERATOR:
        return convertShiftOperatorToString(eDataType, instanceValue);
      case DmplPackage.ADDITIVE_OPERATOR:
        return convertAdditiveOperatorToString(eDataType, instanceValue);
      case DmplPackage.MULTIPLICATIVE_OPERATOR:
        return convertMultiplicativeOperatorToString(eDataType, instanceValue);
      case DmplPackage.UNARY_OPERATOR:
        return convertUnaryOperatorToString(eDataType, instanceValue);
      case DmplPackage.BUILT_IN_FUNCTION_ENUM:
        return convertBuiltInFunctionEnumToString(eDataType, instanceValue);
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
  public VarInit createVarInit()
  {
    VarInitImpl varInit = new VarInitImpl();
    return varInit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarAsgn createVarAsgn()
  {
    VarAsgnImpl varAsgn = new VarAsgnImpl();
    return varAsgn;
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
  public FnBody createFnBody()
  {
    FnBodyImpl fnBody = new FnBodyImpl();
    return fnBody;
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
  public AttrList createAttrList()
  {
    AttrListImpl attrList = new AttrListImpl();
    return attrList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attr createAttr()
  {
    AttrImpl attr = new AttrImpl();
    return attr;
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
  public VarInitList createVarInitList()
  {
    VarInitListImpl varInitList = new VarInitListImpl();
    return varInitList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StmtList createStmtList()
  {
    StmtListImpl stmtList = new StmtListImpl();
    return stmtList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CondStmt createCondStmt()
  {
    CondStmtImpl condStmt = new CondStmtImpl();
    return condStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Stmt createStmt()
  {
    StmtImpl stmt = new StmtImpl();
    return stmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentStmt createAssignmentStmt()
  {
    AssignmentStmtImpl assignmentStmt = new AssignmentStmtImpl();
    return assignmentStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LVal createLVal()
  {
    LValImpl lVal = new LValImpl();
    return lVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr createExpr()
  {
    ExprImpl expr = new ExprImpl();
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CallExpr createCallExpr()
  {
    CallExprImpl callExpr = new CallExprImpl();
    return callExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExprVarAsgn createExprVarAsgn()
  {
    ExprVarAsgnImpl exprVarAsgn = new ExprVarAsgnImpl();
    return exprVarAsgn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FnVarAsgn createFnVarAsgn()
  {
    FnVarAsgnImpl fnVarAsgn = new FnVarAsgnImpl();
    return fnVarAsgn;
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
  public NestedStmt createNestedStmt()
  {
    NestedStmtImpl nestedStmt = new NestedStmtImpl();
    return nestedStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhileStmt createWhileStmt()
  {
    WhileStmtImpl whileStmt = new WhileStmtImpl();
    return whileStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForStmt createForStmt()
  {
    ForStmtImpl forStmt = new ForStmtImpl();
    return forStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleStmt createSimpleStmt()
  {
    SimpleStmtImpl simpleStmt = new SimpleStmtImpl();
    return simpleStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReturnValueStmt createReturnValueStmt()
  {
    ReturnValueStmtImpl returnValueStmt = new ReturnValueStmtImpl();
    return returnValueStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForAllStmt createForAllStmt()
  {
    ForAllStmtImpl forAllStmt = new ForAllStmtImpl();
    return forAllStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FadnpStmt createFadnpStmt()
  {
    FadnpStmtImpl fadnpStmt = new FadnpStmtImpl();
    return fadnpStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TernaryExpr createTernaryExpr()
  {
    TernaryExprImpl ternaryExpr = new TernaryExprImpl();
    return ternaryExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrExpr createOrExpr()
  {
    OrExprImpl orExpr = new OrExprImpl();
    return orExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndExpr createAndExpr()
  {
    AndExprImpl andExpr = new AndExprImpl();
    return andExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitwiseOrExpr createBitwiseOrExpr()
  {
    BitwiseOrExprImpl bitwiseOrExpr = new BitwiseOrExprImpl();
    return bitwiseOrExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XorExpr createXorExpr()
  {
    XorExprImpl xorExpr = new XorExprImpl();
    return xorExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitwiseAndExpr createBitwiseAndExpr()
  {
    BitwiseAndExprImpl bitwiseAndExpr = new BitwiseAndExprImpl();
    return bitwiseAndExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityExpr createEqualityExpr()
  {
    EqualityExprImpl equalityExpr = new EqualityExprImpl();
    return equalityExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompareExpr createCompareExpr()
  {
    CompareExprImpl compareExpr = new CompareExprImpl();
    return compareExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftExpr createShiftExpr()
  {
    ShiftExprImpl shiftExpr = new ShiftExprImpl();
    return shiftExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveExpr createAdditiveExpr()
  {
    AdditiveExprImpl additiveExpr = new AdditiveExprImpl();
    return additiveExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeExpr createMultiplicativeExpr()
  {
    MultiplicativeExprImpl multiplicativeExpr = new MultiplicativeExprImpl();
    return multiplicativeExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdExpr createIdExpr()
  {
    IdExprImpl idExpr = new IdExprImpl();
    return idExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntExpr createIntExpr()
  {
    IntExprImpl intExpr = new IntExprImpl();
    return intExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DoubleExpr createDoubleExpr()
  {
    DoubleExprImpl doubleExpr = new DoubleExprImpl();
    return doubleExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeNumExpr createNodeNumExpr()
  {
    NodeNumExprImpl nodeNumExpr = new NodeNumExprImpl();
    return nodeNumExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryExpr createUnaryExpr()
  {
    UnaryExprImpl unaryExpr = new UnaryExprImpl();
    return unaryExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BuiltInExpr createBuiltInExpr()
  {
    BuiltInExprImpl builtInExpr = new BuiltInExprImpl();
    return builtInExpr;
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
  public SimpleStmtKeywordEnum createSimpleStmtKeywordEnumFromString(EDataType eDataType, String initialValue)
  {
    SimpleStmtKeywordEnum result = SimpleStmtKeywordEnum.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSimpleStmtKeywordEnumToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForAllFunctionEnum createForAllFunctionEnumFromString(EDataType eDataType, String initialValue)
  {
    ForAllFunctionEnum result = ForAllFunctionEnum.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertForAllFunctionEnumToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityOperator createEqualityOperatorFromString(EDataType eDataType, String initialValue)
  {
    EqualityOperator result = EqualityOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEqualityOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompareOperator createCompareOperatorFromString(EDataType eDataType, String initialValue)
  {
    CompareOperator result = CompareOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCompareOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftOperator createShiftOperatorFromString(EDataType eDataType, String initialValue)
  {
    ShiftOperator result = ShiftOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertShiftOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveOperator createAdditiveOperatorFromString(EDataType eDataType, String initialValue)
  {
    AdditiveOperator result = AdditiveOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAdditiveOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeOperator createMultiplicativeOperatorFromString(EDataType eDataType, String initialValue)
  {
    MultiplicativeOperator result = MultiplicativeOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMultiplicativeOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryOperator createUnaryOperatorFromString(EDataType eDataType, String initialValue)
  {
    UnaryOperator result = UnaryOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertUnaryOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BuiltInFunctionEnum createBuiltInFunctionEnumFromString(EDataType eDataType, String initialValue)
  {
    BuiltInFunctionEnum result = BuiltInFunctionEnum.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertBuiltInFunctionEnumToString(EDataType eDataType, Object instanceValue)
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
