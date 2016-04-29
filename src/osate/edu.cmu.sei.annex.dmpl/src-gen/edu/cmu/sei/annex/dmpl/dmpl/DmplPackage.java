/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.osate.aadl2.Aadl2Package;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplFactory
 * @model kind="package"
 * @generated
 */
public interface DmplPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "dmpl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.cmu.edu/sei/annex/dmpl/Dmpl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "dmpl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DmplPackage eINSTANCE = edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProgramImpl <em>Program</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ProgramImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getProgram()
   * @generated
   */
  int PROGRAM = 0;

  /**
   * The feature id for the '<em><b>Program Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM__PROGRAM_ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Program</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.DmplSubclauseImpl <em>Subclause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplSubclauseImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getDmplSubclause()
   * @generated
   */
  int DMPL_SUBCLAUSE = 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DMPL_SUBCLAUSE__OWNED_ELEMENT = Aadl2Package.ANNEX_SUBCLAUSE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DMPL_SUBCLAUSE__OWNED_COMMENT = Aadl2Package.ANNEX_SUBCLAUSE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DMPL_SUBCLAUSE__NAME = Aadl2Package.ANNEX_SUBCLAUSE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DMPL_SUBCLAUSE__QUALIFIED_NAME = Aadl2Package.ANNEX_SUBCLAUSE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DMPL_SUBCLAUSE__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.ANNEX_SUBCLAUSE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>In Mode</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DMPL_SUBCLAUSE__IN_MODE = Aadl2Package.ANNEX_SUBCLAUSE__IN_MODE;

  /**
   * The feature id for the '<em><b>Program</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DMPL_SUBCLAUSE__PROGRAM = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Subclause</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DMPL_SUBCLAUSE_FEATURE_COUNT = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProgramElementImpl <em>Program Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ProgramElementImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getProgramElement()
   * @generated
   */
  int PROGRAM_ELEMENT = 2;

  /**
   * The number of structural features of the '<em>Program Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ConstantImpl <em>Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ConstantImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getConstant()
   * @generated
   */
  int CONSTANT = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__NAME = PROGRAM_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__VALUE = PROGRAM_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_FEATURE_COUNT = PROGRAM_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.NumberConstImpl <em>Number Const</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.NumberConstImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getNumberConst()
   * @generated
   */
  int NUMBER_CONST = 4;

  /**
   * The feature id for the '<em><b>Sign</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_CONST__SIGN = 0;

  /**
   * The number of structural features of the '<em>Number Const</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_CONST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.IntConstImpl <em>Int Const</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.IntConstImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getIntConst()
   * @generated
   */
  int INT_CONST = 5;

  /**
   * The feature id for the '<em><b>Sign</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_CONST__SIGN = NUMBER_CONST__SIGN;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_CONST__VALUE = NUMBER_CONST_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Int Const</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_CONST_FEATURE_COUNT = NUMBER_CONST_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.DoubleConstImpl <em>Double Const</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DoubleConstImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getDoubleConst()
   * @generated
   */
  int DOUBLE_CONST = 6;

  /**
   * The feature id for the '<em><b>Sign</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_CONST__SIGN = NUMBER_CONST__SIGN;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_CONST__VALUE = NUMBER_CONST_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Double Const</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_CONST_FEATURE_COUNT = NUMBER_CONST_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.VarInitImpl <em>Var Init</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.VarInitImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getVarInit()
   * @generated
   */
  int VAR_INIT = 7;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_INIT__TYPE = 0;

  /**
   * The feature id for the '<em><b>Var Asgns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_INIT__VAR_ASGNS = 1;

  /**
   * The number of structural features of the '<em>Var Init</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_INIT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.VarAsgnImpl <em>Var Asgn</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.VarAsgnImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getVarAsgn()
   * @generated
   */
  int VAR_ASGN = 8;

  /**
   * The feature id for the '<em><b>Input</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_ASGN__INPUT = 0;

  /**
   * The feature id for the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_ASGN__VAR = 1;

  /**
   * The number of structural features of the '<em>Var Asgn</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_ASGN_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.VarImpl <em>Var</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.VarImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getVar()
   * @generated
   */
  int VAR = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR__NAME = 0;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR__DIMENSIONS = 1;

  /**
   * The number of structural features of the '<em>Var</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.DimensionImpl <em>Dimension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DimensionImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getDimension()
   * @generated
   */
  int DIMENSION = 10;

  /**
   * The number of structural features of the '<em>Dimension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIMENSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.TypeImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getType()
   * @generated
   */
  int TYPE = 11;

  /**
   * The feature id for the '<em><b>Signed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__SIGNED = 0;

  /**
   * The feature id for the '<em><b>Simp Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__SIMP_TYPE = 1;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProcedureImpl <em>Procedure</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ProcedureImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getProcedure()
   * @generated
   */
  int PROCEDURE = 12;

  /**
   * The feature id for the '<em><b>Procedure</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCEDURE__PROCEDURE = PROGRAM_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Procedure</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCEDURE_FEATURE_COUNT = PROGRAM_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProcNoAttrImpl <em>Proc No Attr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ProcNoAttrImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getProcNoAttr()
   * @generated
   */
  int PROC_NO_ATTR = 13;

  /**
   * The feature id for the '<em><b>Prototype</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROC_NO_ATTR__PROTOTYPE = 0;

  /**
   * The feature id for the '<em><b>Fn Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROC_NO_ATTR__FN_BODY = 1;

  /**
   * The number of structural features of the '<em>Proc No Attr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROC_NO_ATTR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FnBodyImpl <em>Fn Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.FnBodyImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getFnBody()
   * @generated
   */
  int FN_BODY = 14;

  /**
   * The feature id for the '<em><b>Var Init List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_BODY__VAR_INIT_LIST = 0;

  /**
   * The feature id for the '<em><b>Stmt List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_BODY__STMT_LIST = 1;

  /**
   * The number of structural features of the '<em>Fn Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_BODY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeImpl <em>Fn Prototype</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getFnPrototype()
   * @generated
   */
  int FN_PROTOTYPE = 15;

  /**
   * The feature id for the '<em><b>Extern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE__EXTERN = 0;

  /**
   * The feature id for the '<em><b>Pure</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE__PURE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE__NAME = 2;

  /**
   * The number of structural features of the '<em>Fn Prototype</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ParamImpl <em>Param</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ParamImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getParam()
   * @generated
   */
  int PARAM = 16;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM__TYPE = 0;

  /**
   * The feature id for the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM__VAR = 1;

  /**
   * The number of structural features of the '<em>Param</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.VarInitListImpl <em>Var Init List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.VarInitListImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getVarInitList()
   * @generated
   */
  int VAR_INIT_LIST = 17;

  /**
   * The feature id for the '<em><b>Var Inits</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_INIT_LIST__VAR_INITS = 0;

  /**
   * The number of structural features of the '<em>Var Init List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_INIT_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.StmtListImpl <em>Stmt List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.StmtListImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getStmtList()
   * @generated
   */
  int STMT_LIST = 18;

  /**
   * The feature id for the '<em><b>Stmts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_LIST__STMTS = 0;

  /**
   * The number of structural features of the '<em>Stmt List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.StmtImpl <em>Stmt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.StmtImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getStmt()
   * @generated
   */
  int STMT = 19;

  /**
   * The number of structural features of the '<em>Stmt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ExprImpl <em>Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getExpr()
   * @generated
   */
  int EXPR = 21;

  /**
   * The number of structural features of the '<em>Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.LValImpl <em>LVal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.LValImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getLVal()
   * @generated
   */
  int LVAL = 20;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LVAL__NAME = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Indices</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LVAL__INDICES = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>At</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LVAL__AT = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>LVal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LVAL_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.CallExprImpl <em>Call Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.CallExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getCallExpr()
   * @generated
   */
  int CALL_EXPR = 22;

  /**
   * The feature id for the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_EXPR__NAMESPACE = STMT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_EXPR__NAME = STMT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Arg List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_EXPR__ARG_LIST = STMT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>At</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_EXPR__AT = STMT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Call Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_EXPR_FEATURE_COUNT = STMT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ArgListImpl <em>Arg List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ArgListImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getArgList()
   * @generated
   */
  int ARG_LIST = 23;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARG_LIST__ARGS = 0;

  /**
   * The number of structural features of the '<em>Arg List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARG_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ExprVarAsgnImpl <em>Expr Var Asgn</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ExprVarAsgnImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getExprVarAsgn()
   * @generated
   */
  int EXPR_VAR_ASGN = 24;

  /**
   * The feature id for the '<em><b>Input</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_VAR_ASGN__INPUT = VAR_ASGN__INPUT;

  /**
   * The feature id for the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_VAR_ASGN__VAR = VAR_ASGN__VAR;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_VAR_ASGN__EXPR = VAR_ASGN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expr Var Asgn</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_VAR_ASGN_FEATURE_COUNT = VAR_ASGN_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FnVarAsgnImpl <em>Fn Var Asgn</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.FnVarAsgnImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getFnVarAsgn()
   * @generated
   */
  int FN_VAR_ASGN = 25;

  /**
   * The feature id for the '<em><b>Input</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_VAR_ASGN__INPUT = VAR_ASGN__INPUT;

  /**
   * The feature id for the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_VAR_ASGN__VAR = VAR_ASGN__VAR;

  /**
   * The feature id for the '<em><b>Fn Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_VAR_ASGN__FN_BODY = VAR_ASGN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Fn Var Asgn</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_VAR_ASGN_FEATURE_COUNT = VAR_ASGN_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.IntDimensionImpl <em>Int Dimension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.IntDimensionImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getIntDimension()
   * @generated
   */
  int INT_DIMENSION = 26;

  /**
   * The feature id for the '<em><b>Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_DIMENSION__INDEX = DIMENSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Int Dimension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_DIMENSION_FEATURE_COUNT = DIMENSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.NodeNumDimensionImpl <em>Node Num Dimension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.NodeNumDimensionImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getNodeNumDimension()
   * @generated
   */
  int NODE_NUM_DIMENSION = 27;

  /**
   * The number of structural features of the '<em>Node Num Dimension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_NUM_DIMENSION_FEATURE_COUNT = DIMENSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.IdDimensionImpl <em>Id Dimension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.IdDimensionImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getIdDimension()
   * @generated
   */
  int ID_DIMENSION = 28;

  /**
   * The feature id for the '<em><b>Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_DIMENSION__INDEX = DIMENSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Id Dimension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_DIMENSION_FEATURE_COUNT = DIMENSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ThreadDeclarationImpl <em>Thread Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ThreadDeclarationImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getThreadDeclaration()
   * @generated
   */
  int THREAD_DECLARATION = 29;

  /**
   * The feature id for the '<em><b>Extern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAD_DECLARATION__EXTERN = FN_PROTOTYPE__EXTERN;

  /**
   * The feature id for the '<em><b>Pure</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAD_DECLARATION__PURE = FN_PROTOTYPE__PURE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAD_DECLARATION__NAME = FN_PROTOTYPE__NAME;

  /**
   * The number of structural features of the '<em>Thread Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAD_DECLARATION_FEATURE_COUNT = FN_PROTOTYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeDeclarationImpl <em>Fn Prototype Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeDeclarationImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getFnPrototypeDeclaration()
   * @generated
   */
  int FN_PROTOTYPE_DECLARATION = 30;

  /**
   * The feature id for the '<em><b>Extern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE_DECLARATION__EXTERN = FN_PROTOTYPE__EXTERN;

  /**
   * The feature id for the '<em><b>Pure</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE_DECLARATION__PURE = FN_PROTOTYPE__PURE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE_DECLARATION__NAME = FN_PROTOTYPE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE_DECLARATION__TYPE = FN_PROTOTYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE_DECLARATION__PARAMS = FN_PROTOTYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Fn Prototype Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE_DECLARATION_FEATURE_COUNT = FN_PROTOTYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.NestedStmtImpl <em>Nested Stmt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.NestedStmtImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getNestedStmt()
   * @generated
   */
  int NESTED_STMT = 31;

  /**
   * The feature id for the '<em><b>Stmt List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_STMT__STMT_LIST = STMT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Nested Stmt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_STMT_FEATURE_COUNT = STMT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.AssignmentStmtImpl <em>Assignment Stmt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.AssignmentStmtImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getAssignmentStmt()
   * @generated
   */
  int ASSIGNMENT_STMT = 32;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_STMT__VARIABLE = STMT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_STMT__VALUE = STMT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Assignment Stmt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_STMT_FEATURE_COUNT = STMT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.WhileStmtImpl <em>While Stmt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.WhileStmtImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getWhileStmt()
   * @generated
   */
  int WHILE_STMT = 33;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STMT__CONDITION = STMT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STMT__STMT = STMT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>While Stmt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STMT_FEATURE_COUNT = STMT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.SimpleStmtImpl <em>Simple Stmt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.SimpleStmtImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSimpleStmt()
   * @generated
   */
  int SIMPLE_STMT = 34;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_STMT__NAME = STMT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Simple Stmt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_STMT_FEATURE_COUNT = STMT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ReturnValueStmtImpl <em>Return Value Stmt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ReturnValueStmtImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getReturnValueStmt()
   * @generated
   */
  int RETURN_VALUE_STMT = 35;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_VALUE_STMT__VALUE = STMT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Return Value Stmt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_VALUE_STMT_FEATURE_COUNT = STMT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ForAllStmtImpl <em>For All Stmt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ForAllStmtImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getForAllStmt()
   * @generated
   */
  int FOR_ALL_STMT = 36;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_ALL_STMT__NAME = STMT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Node</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_ALL_STMT__NODE = STMT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_ALL_STMT__STMT = STMT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>For All Stmt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_ALL_STMT_FEATURE_COUNT = STMT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FadnpStmtImpl <em>Fadnp Stmt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.FadnpStmtImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getFadnpStmt()
   * @generated
   */
  int FADNP_STMT = 37;

  /**
   * The feature id for the '<em><b>Node1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FADNP_STMT__NODE1 = STMT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Node2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FADNP_STMT__NODE2 = STMT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FADNP_STMT__STMT = STMT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Fadnp Stmt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FADNP_STMT_FEATURE_COUNT = STMT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.TernaryExprImpl <em>Ternary Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.TernaryExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getTernaryExpr()
   * @generated
   */
  int TERNARY_EXPR = 38;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERNARY_EXPR__CONDITION = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERNARY_EXPR__THEN = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERNARY_EXPR__ELSE = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Ternary Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERNARY_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.OrExprImpl <em>Or Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.OrExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getOrExpr()
   * @generated
   */
  int OR_EXPR = 39;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPR__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPR__RIGHT = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Or Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.AndExprImpl <em>And Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.AndExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getAndExpr()
   * @generated
   */
  int AND_EXPR = 40;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPR__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPR__RIGHT = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>And Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.BitwiseOrExprImpl <em>Bitwise Or Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.BitwiseOrExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getBitwiseOrExpr()
   * @generated
   */
  int BITWISE_OR_EXPR = 41;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_OR_EXPR__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_OR_EXPR__RIGHT = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Bitwise Or Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_OR_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.XorExprImpl <em>Xor Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.XorExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getXorExpr()
   * @generated
   */
  int XOR_EXPR = 42;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_EXPR__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_EXPR__RIGHT = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Xor Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.BitwiseAndExprImpl <em>Bitwise And Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.BitwiseAndExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getBitwiseAndExpr()
   * @generated
   */
  int BITWISE_AND_EXPR = 43;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_AND_EXPR__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_AND_EXPR__RIGHT = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Bitwise And Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_AND_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.EqualityExprImpl <em>Equality Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.EqualityExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getEqualityExpr()
   * @generated
   */
  int EQUALITY_EXPR = 44;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPR__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPR__OPERATOR = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPR__RIGHT = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Equality Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.CompareExprImpl <em>Compare Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.CompareExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getCompareExpr()
   * @generated
   */
  int COMPARE_EXPR = 45;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARE_EXPR__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARE_EXPR__OPERATOR = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARE_EXPR__RIGHT = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Compare Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ShiftExprImpl <em>Shift Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ShiftExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getShiftExpr()
   * @generated
   */
  int SHIFT_EXPR = 46;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPR__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPR__OPERATOR = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPR__RIGHT = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Shift Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.AdditiveExprImpl <em>Additive Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.AdditiveExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getAdditiveExpr()
   * @generated
   */
  int ADDITIVE_EXPR = 47;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPR__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPR__OPERATOR = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPR__RIGHT = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Additive Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.MultiplicativeExprImpl <em>Multiplicative Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.MultiplicativeExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getMultiplicativeExpr()
   * @generated
   */
  int MULTIPLICATIVE_EXPR = 48;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPR__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPR__OPERATOR = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPR__RIGHT = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Multiplicative Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.IdExprImpl <em>Id Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.IdExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getIdExpr()
   * @generated
   */
  int ID_EXPR = 49;

  /**
   * The number of structural features of the '<em>Id Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.IntExprImpl <em>Int Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.IntExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getIntExpr()
   * @generated
   */
  int INT_EXPR = 50;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_EXPR__VALUE = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Int Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.DoubleExprImpl <em>Double Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DoubleExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getDoubleExpr()
   * @generated
   */
  int DOUBLE_EXPR = 51;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_EXPR__VALUE = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Double Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.NodeNumExprImpl <em>Node Num Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.NodeNumExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getNodeNumExpr()
   * @generated
   */
  int NODE_NUM_EXPR = 52;

  /**
   * The number of structural features of the '<em>Node Num Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_NUM_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.UnaryExprImpl <em>Unary Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.UnaryExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getUnaryExpr()
   * @generated
   */
  int UNARY_EXPR = 53;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__OPERATOR = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__OPERAND = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unary Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.BuiltInExprImpl <em>Built In Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.BuiltInExprImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getBuiltInExpr()
   * @generated
   */
  int BUILT_IN_EXPR = 54;

  /**
   * The feature id for the '<em><b>Function</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUILT_IN_EXPR__FUNCTION = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>First Arg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUILT_IN_EXPR__FIRST_ARG = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Second Arg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUILT_IN_EXPR__SECOND_ARG = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Built In Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUILT_IN_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.SignEnum <em>Sign Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.SignEnum
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSignEnum()
   * @generated
   */
  int SIGN_ENUM = 55;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum <em>Simp Type Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSimpTypeEnum()
   * @generated
   */
  int SIMP_TYPE_ENUM = 56;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.SignedEnum <em>Signed Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.SignedEnum
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSignedEnum()
   * @generated
   */
  int SIGNED_ENUM = 57;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.SimpleStmtKeywordEnum <em>Simple Stmt Keyword Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.SimpleStmtKeywordEnum
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSimpleStmtKeywordEnum()
   * @generated
   */
  int SIMPLE_STMT_KEYWORD_ENUM = 58;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.ForAllFunctionEnum <em>For All Function Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.ForAllFunctionEnum
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getForAllFunctionEnum()
   * @generated
   */
  int FOR_ALL_FUNCTION_ENUM = 59;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.EqualityOperator <em>Equality Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.EqualityOperator
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getEqualityOperator()
   * @generated
   */
  int EQUALITY_OPERATOR = 60;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.CompareOperator <em>Compare Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.CompareOperator
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getCompareOperator()
   * @generated
   */
  int COMPARE_OPERATOR = 61;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.ShiftOperator <em>Shift Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.ShiftOperator
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getShiftOperator()
   * @generated
   */
  int SHIFT_OPERATOR = 62;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.AdditiveOperator <em>Additive Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.AdditiveOperator
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getAdditiveOperator()
   * @generated
   */
  int ADDITIVE_OPERATOR = 63;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeOperator
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getMultiplicativeOperator()
   * @generated
   */
  int MULTIPLICATIVE_OPERATOR = 64;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.UnaryOperator <em>Unary Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.UnaryOperator
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getUnaryOperator()
   * @generated
   */
  int UNARY_OPERATOR = 65;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.BuiltInFunctionEnum <em>Built In Function Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.BuiltInFunctionEnum
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getBuiltInFunctionEnum()
   * @generated
   */
  int BUILT_IN_FUNCTION_ENUM = 66;


  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.Program <em>Program</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Program</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Program
   * @generated
   */
  EClass getProgram();

  /**
   * Returns the meta object for the containment reference list '{@link edu.cmu.sei.annex.dmpl.dmpl.Program#getProgramElements <em>Program Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Program Elements</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Program#getProgramElements()
   * @see #getProgram()
   * @generated
   */
  EReference getProgram_ProgramElements();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.DmplSubclause <em>Subclause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subclause</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplSubclause
   * @generated
   */
  EClass getDmplSubclause();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.DmplSubclause#getProgram <em>Program</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Program</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplSubclause#getProgram()
   * @see #getDmplSubclause()
   * @generated
   */
  EReference getDmplSubclause_Program();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.ProgramElement <em>Program Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Program Element</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ProgramElement
   * @generated
   */
  EClass getProgramElement();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Constant
   * @generated
   */
  EClass getConstant();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.Constant#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Constant#getName()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_Name();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.Constant#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Constant#getValue()
   * @see #getConstant()
   * @generated
   */
  EReference getConstant_Value();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.NumberConst <em>Number Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number Const</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.NumberConst
   * @generated
   */
  EClass getNumberConst();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.NumberConst#getSign <em>Sign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sign</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.NumberConst#getSign()
   * @see #getNumberConst()
   * @generated
   */
  EAttribute getNumberConst_Sign();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.IntConst <em>Int Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Const</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.IntConst
   * @generated
   */
  EClass getIntConst();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.IntConst#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.IntConst#getValue()
   * @see #getIntConst()
   * @generated
   */
  EAttribute getIntConst_Value();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.DoubleConst <em>Double Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Double Const</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DoubleConst
   * @generated
   */
  EClass getDoubleConst();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.DoubleConst#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DoubleConst#getValue()
   * @see #getDoubleConst()
   * @generated
   */
  EAttribute getDoubleConst_Value();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.VarInit <em>Var Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Init</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.VarInit
   * @generated
   */
  EClass getVarInit();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.VarInit#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.VarInit#getType()
   * @see #getVarInit()
   * @generated
   */
  EReference getVarInit_Type();

  /**
   * Returns the meta object for the containment reference list '{@link edu.cmu.sei.annex.dmpl.dmpl.VarInit#getVarAsgns <em>Var Asgns</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Var Asgns</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.VarInit#getVarAsgns()
   * @see #getVarInit()
   * @generated
   */
  EReference getVarInit_VarAsgns();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgn <em>Var Asgn</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Asgn</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.VarAsgn
   * @generated
   */
  EClass getVarAsgn();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgn#isInput <em>Input</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Input</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.VarAsgn#isInput()
   * @see #getVarAsgn()
   * @generated
   */
  EAttribute getVarAsgn_Input();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgn#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.VarAsgn#getVar()
   * @see #getVarAsgn()
   * @generated
   */
  EReference getVarAsgn_Var();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.Var <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Var
   * @generated
   */
  EClass getVar();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.Var#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Var#getName()
   * @see #getVar()
   * @generated
   */
  EAttribute getVar_Name();

  /**
   * Returns the meta object for the containment reference list '{@link edu.cmu.sei.annex.dmpl.dmpl.Var#getDimensions <em>Dimensions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Dimensions</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Var#getDimensions()
   * @see #getVar()
   * @generated
   */
  EReference getVar_Dimensions();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.Dimension <em>Dimension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dimension</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Dimension
   * @generated
   */
  EClass getDimension();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.Type#getSigned <em>Signed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Signed</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Type#getSigned()
   * @see #getType()
   * @generated
   */
  EAttribute getType_Signed();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.Type#getSimpType <em>Simp Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Simp Type</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Type#getSimpType()
   * @see #getType()
   * @generated
   */
  EAttribute getType_SimpType();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure <em>Procedure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Procedure</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Procedure
   * @generated
   */
  EClass getProcedure();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.Procedure#getProcedure <em>Procedure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Procedure</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Procedure#getProcedure()
   * @see #getProcedure()
   * @generated
   */
  EReference getProcedure_Procedure();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.ProcNoAttr <em>Proc No Attr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Proc No Attr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ProcNoAttr
   * @generated
   */
  EClass getProcNoAttr();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.ProcNoAttr#getPrototype <em>Prototype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Prototype</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ProcNoAttr#getPrototype()
   * @see #getProcNoAttr()
   * @generated
   */
  EReference getProcNoAttr_Prototype();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.ProcNoAttr#getFnBody <em>Fn Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fn Body</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ProcNoAttr#getFnBody()
   * @see #getProcNoAttr()
   * @generated
   */
  EReference getProcNoAttr_FnBody();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.FnBody <em>Fn Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fn Body</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnBody
   * @generated
   */
  EClass getFnBody();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.FnBody#getVarInitList <em>Var Init List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var Init List</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnBody#getVarInitList()
   * @see #getFnBody()
   * @generated
   */
  EReference getFnBody_VarInitList();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.FnBody#getStmtList <em>Stmt List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Stmt List</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnBody#getStmtList()
   * @see #getFnBody()
   * @generated
   */
  EReference getFnBody_StmtList();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototype <em>Fn Prototype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fn Prototype</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnPrototype
   * @generated
   */
  EClass getFnPrototype();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototype#isExtern <em>Extern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Extern</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnPrototype#isExtern()
   * @see #getFnPrototype()
   * @generated
   */
  EAttribute getFnPrototype_Extern();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototype#isPure <em>Pure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pure</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnPrototype#isPure()
   * @see #getFnPrototype()
   * @generated
   */
  EAttribute getFnPrototype_Pure();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototype#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnPrototype#getName()
   * @see #getFnPrototype()
   * @generated
   */
  EAttribute getFnPrototype_Name();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.Param <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Param</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Param
   * @generated
   */
  EClass getParam();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.Param#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Param#getType()
   * @see #getParam()
   * @generated
   */
  EReference getParam_Type();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.Param#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Param#getVar()
   * @see #getParam()
   * @generated
   */
  EReference getParam_Var();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.VarInitList <em>Var Init List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Init List</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.VarInitList
   * @generated
   */
  EClass getVarInitList();

  /**
   * Returns the meta object for the containment reference list '{@link edu.cmu.sei.annex.dmpl.dmpl.VarInitList#getVarInits <em>Var Inits</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Var Inits</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.VarInitList#getVarInits()
   * @see #getVarInitList()
   * @generated
   */
  EReference getVarInitList_VarInits();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.StmtList <em>Stmt List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stmt List</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.StmtList
   * @generated
   */
  EClass getStmtList();

  /**
   * Returns the meta object for the containment reference list '{@link edu.cmu.sei.annex.dmpl.dmpl.StmtList#getStmts <em>Stmts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Stmts</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.StmtList#getStmts()
   * @see #getStmtList()
   * @generated
   */
  EReference getStmtList_Stmts();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.Stmt <em>Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stmt</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Stmt
   * @generated
   */
  EClass getStmt();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.LVal <em>LVal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LVal</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.LVal
   * @generated
   */
  EClass getLVal();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.LVal#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.LVal#getName()
   * @see #getLVal()
   * @generated
   */
  EAttribute getLVal_Name();

  /**
   * Returns the meta object for the containment reference list '{@link edu.cmu.sei.annex.dmpl.dmpl.LVal#getIndices <em>Indices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Indices</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.LVal#getIndices()
   * @see #getLVal()
   * @generated
   */
  EReference getLVal_Indices();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.LVal#getAt <em>At</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>At</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.LVal#getAt()
   * @see #getLVal()
   * @generated
   */
  EReference getLVal_At();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.Expr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.Expr
   * @generated
   */
  EClass getExpr();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.CallExpr <em>Call Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Call Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.CallExpr
   * @generated
   */
  EClass getCallExpr();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.CallExpr#getNamespace <em>Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Namespace</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.CallExpr#getNamespace()
   * @see #getCallExpr()
   * @generated
   */
  EAttribute getCallExpr_Namespace();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.CallExpr#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.CallExpr#getName()
   * @see #getCallExpr()
   * @generated
   */
  EAttribute getCallExpr_Name();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.CallExpr#getArgList <em>Arg List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Arg List</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.CallExpr#getArgList()
   * @see #getCallExpr()
   * @generated
   */
  EReference getCallExpr_ArgList();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.CallExpr#getAt <em>At</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>At</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.CallExpr#getAt()
   * @see #getCallExpr()
   * @generated
   */
  EReference getCallExpr_At();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.ArgList <em>Arg List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Arg List</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ArgList
   * @generated
   */
  EClass getArgList();

  /**
   * Returns the meta object for the containment reference list '{@link edu.cmu.sei.annex.dmpl.dmpl.ArgList#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ArgList#getArgs()
   * @see #getArgList()
   * @generated
   */
  EReference getArgList_Args();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.ExprVarAsgn <em>Expr Var Asgn</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Var Asgn</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ExprVarAsgn
   * @generated
   */
  EClass getExprVarAsgn();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.ExprVarAsgn#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ExprVarAsgn#getExpr()
   * @see #getExprVarAsgn()
   * @generated
   */
  EReference getExprVarAsgn_Expr();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.FnVarAsgn <em>Fn Var Asgn</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fn Var Asgn</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnVarAsgn
   * @generated
   */
  EClass getFnVarAsgn();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.FnVarAsgn#getFnBody <em>Fn Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fn Body</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnVarAsgn#getFnBody()
   * @see #getFnVarAsgn()
   * @generated
   */
  EReference getFnVarAsgn_FnBody();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.IntDimension <em>Int Dimension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Dimension</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.IntDimension
   * @generated
   */
  EClass getIntDimension();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.IntDimension#getIndex <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Index</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.IntDimension#getIndex()
   * @see #getIntDimension()
   * @generated
   */
  EAttribute getIntDimension_Index();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.NodeNumDimension <em>Node Num Dimension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Num Dimension</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.NodeNumDimension
   * @generated
   */
  EClass getNodeNumDimension();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.IdDimension <em>Id Dimension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Id Dimension</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.IdDimension
   * @generated
   */
  EClass getIdDimension();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.IdDimension#getIndex <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Index</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.IdDimension#getIndex()
   * @see #getIdDimension()
   * @generated
   */
  EAttribute getIdDimension_Index();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.ThreadDeclaration <em>Thread Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Thread Declaration</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ThreadDeclaration
   * @generated
   */
  EClass getThreadDeclaration();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeDeclaration <em>Fn Prototype Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fn Prototype Declaration</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeDeclaration
   * @generated
   */
  EClass getFnPrototypeDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeDeclaration#getType()
   * @see #getFnPrototypeDeclaration()
   * @generated
   */
  EReference getFnPrototypeDeclaration_Type();

  /**
   * Returns the meta object for the containment reference list '{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeDeclaration#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Params</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeDeclaration#getParams()
   * @see #getFnPrototypeDeclaration()
   * @generated
   */
  EReference getFnPrototypeDeclaration_Params();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.NestedStmt <em>Nested Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Stmt</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.NestedStmt
   * @generated
   */
  EClass getNestedStmt();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.NestedStmt#getStmtList <em>Stmt List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Stmt List</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.NestedStmt#getStmtList()
   * @see #getNestedStmt()
   * @generated
   */
  EReference getNestedStmt_StmtList();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.AssignmentStmt <em>Assignment Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment Stmt</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.AssignmentStmt
   * @generated
   */
  EClass getAssignmentStmt();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.AssignmentStmt#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.AssignmentStmt#getVariable()
   * @see #getAssignmentStmt()
   * @generated
   */
  EReference getAssignmentStmt_Variable();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.AssignmentStmt#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.AssignmentStmt#getValue()
   * @see #getAssignmentStmt()
   * @generated
   */
  EReference getAssignmentStmt_Value();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.WhileStmt <em>While Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>While Stmt</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.WhileStmt
   * @generated
   */
  EClass getWhileStmt();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.WhileStmt#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.WhileStmt#getCondition()
   * @see #getWhileStmt()
   * @generated
   */
  EReference getWhileStmt_Condition();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.WhileStmt#getStmt <em>Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Stmt</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.WhileStmt#getStmt()
   * @see #getWhileStmt()
   * @generated
   */
  EReference getWhileStmt_Stmt();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.SimpleStmt <em>Simple Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Stmt</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.SimpleStmt
   * @generated
   */
  EClass getSimpleStmt();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.SimpleStmt#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.SimpleStmt#getName()
   * @see #getSimpleStmt()
   * @generated
   */
  EAttribute getSimpleStmt_Name();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.ReturnValueStmt <em>Return Value Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Return Value Stmt</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ReturnValueStmt
   * @generated
   */
  EClass getReturnValueStmt();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.ReturnValueStmt#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ReturnValueStmt#getValue()
   * @see #getReturnValueStmt()
   * @generated
   */
  EReference getReturnValueStmt_Value();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt <em>For All Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>For All Stmt</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt
   * @generated
   */
  EClass getForAllStmt();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt#getName()
   * @see #getForAllStmt()
   * @generated
   */
  EAttribute getForAllStmt_Name();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt#getNode <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Node</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt#getNode()
   * @see #getForAllStmt()
   * @generated
   */
  EAttribute getForAllStmt_Node();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt#getStmt <em>Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Stmt</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt#getStmt()
   * @see #getForAllStmt()
   * @generated
   */
  EReference getForAllStmt_Stmt();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt <em>Fadnp Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fadnp Stmt</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt
   * @generated
   */
  EClass getFadnpStmt();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt#getNode1 <em>Node1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Node1</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt#getNode1()
   * @see #getFadnpStmt()
   * @generated
   */
  EAttribute getFadnpStmt_Node1();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt#getNode2 <em>Node2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Node2</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt#getNode2()
   * @see #getFadnpStmt()
   * @generated
   */
  EAttribute getFadnpStmt_Node2();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt#getStmt <em>Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Stmt</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt#getStmt()
   * @see #getFadnpStmt()
   * @generated
   */
  EReference getFadnpStmt_Stmt();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr <em>Ternary Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ternary Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr
   * @generated
   */
  EClass getTernaryExpr();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr#getCondition()
   * @see #getTernaryExpr()
   * @generated
   */
  EReference getTernaryExpr_Condition();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr#getThen <em>Then</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr#getThen()
   * @see #getTernaryExpr()
   * @generated
   */
  EReference getTernaryExpr_Then();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr#getElse <em>Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr#getElse()
   * @see #getTernaryExpr()
   * @generated
   */
  EReference getTernaryExpr_Else();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.OrExpr <em>Or Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.OrExpr
   * @generated
   */
  EClass getOrExpr();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.OrExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.OrExpr#getLeft()
   * @see #getOrExpr()
   * @generated
   */
  EReference getOrExpr_Left();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.OrExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.OrExpr#getRight()
   * @see #getOrExpr()
   * @generated
   */
  EReference getOrExpr_Right();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.AndExpr <em>And Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.AndExpr
   * @generated
   */
  EClass getAndExpr();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.AndExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.AndExpr#getLeft()
   * @see #getAndExpr()
   * @generated
   */
  EReference getAndExpr_Left();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.AndExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.AndExpr#getRight()
   * @see #getAndExpr()
   * @generated
   */
  EReference getAndExpr_Right();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.BitwiseOrExpr <em>Bitwise Or Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bitwise Or Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.BitwiseOrExpr
   * @generated
   */
  EClass getBitwiseOrExpr();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.BitwiseOrExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.BitwiseOrExpr#getLeft()
   * @see #getBitwiseOrExpr()
   * @generated
   */
  EReference getBitwiseOrExpr_Left();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.BitwiseOrExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.BitwiseOrExpr#getRight()
   * @see #getBitwiseOrExpr()
   * @generated
   */
  EReference getBitwiseOrExpr_Right();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.XorExpr <em>Xor Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Xor Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.XorExpr
   * @generated
   */
  EClass getXorExpr();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.XorExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.XorExpr#getLeft()
   * @see #getXorExpr()
   * @generated
   */
  EReference getXorExpr_Left();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.XorExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.XorExpr#getRight()
   * @see #getXorExpr()
   * @generated
   */
  EReference getXorExpr_Right();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.BitwiseAndExpr <em>Bitwise And Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bitwise And Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.BitwiseAndExpr
   * @generated
   */
  EClass getBitwiseAndExpr();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.BitwiseAndExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.BitwiseAndExpr#getLeft()
   * @see #getBitwiseAndExpr()
   * @generated
   */
  EReference getBitwiseAndExpr_Left();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.BitwiseAndExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.BitwiseAndExpr#getRight()
   * @see #getBitwiseAndExpr()
   * @generated
   */
  EReference getBitwiseAndExpr_Right();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.EqualityExpr <em>Equality Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.EqualityExpr
   * @generated
   */
  EClass getEqualityExpr();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.EqualityExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.EqualityExpr#getLeft()
   * @see #getEqualityExpr()
   * @generated
   */
  EReference getEqualityExpr_Left();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.EqualityExpr#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.EqualityExpr#getOperator()
   * @see #getEqualityExpr()
   * @generated
   */
  EAttribute getEqualityExpr_Operator();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.EqualityExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.EqualityExpr#getRight()
   * @see #getEqualityExpr()
   * @generated
   */
  EReference getEqualityExpr_Right();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.CompareExpr <em>Compare Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Compare Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.CompareExpr
   * @generated
   */
  EClass getCompareExpr();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.CompareExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.CompareExpr#getLeft()
   * @see #getCompareExpr()
   * @generated
   */
  EReference getCompareExpr_Left();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.CompareExpr#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.CompareExpr#getOperator()
   * @see #getCompareExpr()
   * @generated
   */
  EAttribute getCompareExpr_Operator();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.CompareExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.CompareExpr#getRight()
   * @see #getCompareExpr()
   * @generated
   */
  EReference getCompareExpr_Right();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.ShiftExpr <em>Shift Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Shift Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ShiftExpr
   * @generated
   */
  EClass getShiftExpr();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.ShiftExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ShiftExpr#getLeft()
   * @see #getShiftExpr()
   * @generated
   */
  EReference getShiftExpr_Left();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.ShiftExpr#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ShiftExpr#getOperator()
   * @see #getShiftExpr()
   * @generated
   */
  EAttribute getShiftExpr_Operator();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.ShiftExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ShiftExpr#getRight()
   * @see #getShiftExpr()
   * @generated
   */
  EReference getShiftExpr_Right();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.AdditiveExpr <em>Additive Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Additive Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.AdditiveExpr
   * @generated
   */
  EClass getAdditiveExpr();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.AdditiveExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.AdditiveExpr#getLeft()
   * @see #getAdditiveExpr()
   * @generated
   */
  EReference getAdditiveExpr_Left();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.AdditiveExpr#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.AdditiveExpr#getOperator()
   * @see #getAdditiveExpr()
   * @generated
   */
  EAttribute getAdditiveExpr_Operator();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.AdditiveExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.AdditiveExpr#getRight()
   * @see #getAdditiveExpr()
   * @generated
   */
  EReference getAdditiveExpr_Right();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr <em>Multiplicative Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicative Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr
   * @generated
   */
  EClass getMultiplicativeExpr();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr#getLeft()
   * @see #getMultiplicativeExpr()
   * @generated
   */
  EReference getMultiplicativeExpr_Left();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr#getOperator()
   * @see #getMultiplicativeExpr()
   * @generated
   */
  EAttribute getMultiplicativeExpr_Operator();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr#getRight()
   * @see #getMultiplicativeExpr()
   * @generated
   */
  EReference getMultiplicativeExpr_Right();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.IdExpr <em>Id Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Id Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.IdExpr
   * @generated
   */
  EClass getIdExpr();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.IntExpr <em>Int Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.IntExpr
   * @generated
   */
  EClass getIntExpr();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.IntExpr#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.IntExpr#getValue()
   * @see #getIntExpr()
   * @generated
   */
  EAttribute getIntExpr_Value();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.DoubleExpr <em>Double Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Double Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DoubleExpr
   * @generated
   */
  EClass getDoubleExpr();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.DoubleExpr#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.DoubleExpr#getValue()
   * @see #getDoubleExpr()
   * @generated
   */
  EAttribute getDoubleExpr_Value();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.NodeNumExpr <em>Node Num Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Num Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.NodeNumExpr
   * @generated
   */
  EClass getNodeNumExpr();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.UnaryExpr <em>Unary Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.UnaryExpr
   * @generated
   */
  EClass getUnaryExpr();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.UnaryExpr#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.UnaryExpr#getOperator()
   * @see #getUnaryExpr()
   * @generated
   */
  EAttribute getUnaryExpr_Operator();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.UnaryExpr#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.UnaryExpr#getOperand()
   * @see #getUnaryExpr()
   * @generated
   */
  EReference getUnaryExpr_Operand();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr <em>Built In Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Built In Expr</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr
   * @generated
   */
  EClass getBuiltInExpr();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr#getFunction <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Function</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr#getFunction()
   * @see #getBuiltInExpr()
   * @generated
   */
  EAttribute getBuiltInExpr_Function();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr#getFirstArg <em>First Arg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>First Arg</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr#getFirstArg()
   * @see #getBuiltInExpr()
   * @generated
   */
  EAttribute getBuiltInExpr_FirstArg();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr#getSecondArg <em>Second Arg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Second Arg</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr#getSecondArg()
   * @see #getBuiltInExpr()
   * @generated
   */
  EReference getBuiltInExpr_SecondArg();

  /**
   * Returns the meta object for enum '{@link edu.cmu.sei.annex.dmpl.dmpl.SignEnum <em>Sign Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Sign Enum</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.SignEnum
   * @generated
   */
  EEnum getSignEnum();

  /**
   * Returns the meta object for enum '{@link edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum <em>Simp Type Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Simp Type Enum</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum
   * @generated
   */
  EEnum getSimpTypeEnum();

  /**
   * Returns the meta object for enum '{@link edu.cmu.sei.annex.dmpl.dmpl.SignedEnum <em>Signed Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Signed Enum</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.SignedEnum
   * @generated
   */
  EEnum getSignedEnum();

  /**
   * Returns the meta object for enum '{@link edu.cmu.sei.annex.dmpl.dmpl.SimpleStmtKeywordEnum <em>Simple Stmt Keyword Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Simple Stmt Keyword Enum</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.SimpleStmtKeywordEnum
   * @generated
   */
  EEnum getSimpleStmtKeywordEnum();

  /**
   * Returns the meta object for enum '{@link edu.cmu.sei.annex.dmpl.dmpl.ForAllFunctionEnum <em>For All Function Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>For All Function Enum</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ForAllFunctionEnum
   * @generated
   */
  EEnum getForAllFunctionEnum();

  /**
   * Returns the meta object for enum '{@link edu.cmu.sei.annex.dmpl.dmpl.EqualityOperator <em>Equality Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Equality Operator</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.EqualityOperator
   * @generated
   */
  EEnum getEqualityOperator();

  /**
   * Returns the meta object for enum '{@link edu.cmu.sei.annex.dmpl.dmpl.CompareOperator <em>Compare Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Compare Operator</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.CompareOperator
   * @generated
   */
  EEnum getCompareOperator();

  /**
   * Returns the meta object for enum '{@link edu.cmu.sei.annex.dmpl.dmpl.ShiftOperator <em>Shift Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Shift Operator</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.ShiftOperator
   * @generated
   */
  EEnum getShiftOperator();

  /**
   * Returns the meta object for enum '{@link edu.cmu.sei.annex.dmpl.dmpl.AdditiveOperator <em>Additive Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Additive Operator</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.AdditiveOperator
   * @generated
   */
  EEnum getAdditiveOperator();

  /**
   * Returns the meta object for enum '{@link edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeOperator <em>Multiplicative Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Multiplicative Operator</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeOperator
   * @generated
   */
  EEnum getMultiplicativeOperator();

  /**
   * Returns the meta object for enum '{@link edu.cmu.sei.annex.dmpl.dmpl.UnaryOperator <em>Unary Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Unary Operator</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.UnaryOperator
   * @generated
   */
  EEnum getUnaryOperator();

  /**
   * Returns the meta object for enum '{@link edu.cmu.sei.annex.dmpl.dmpl.BuiltInFunctionEnum <em>Built In Function Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Built In Function Enum</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.BuiltInFunctionEnum
   * @generated
   */
  EEnum getBuiltInFunctionEnum();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DmplFactory getDmplFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProgramImpl <em>Program</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ProgramImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getProgram()
     * @generated
     */
    EClass PROGRAM = eINSTANCE.getProgram();

    /**
     * The meta object literal for the '<em><b>Program Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROGRAM__PROGRAM_ELEMENTS = eINSTANCE.getProgram_ProgramElements();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.DmplSubclauseImpl <em>Subclause</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplSubclauseImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getDmplSubclause()
     * @generated
     */
    EClass DMPL_SUBCLAUSE = eINSTANCE.getDmplSubclause();

    /**
     * The meta object literal for the '<em><b>Program</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DMPL_SUBCLAUSE__PROGRAM = eINSTANCE.getDmplSubclause_Program();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProgramElementImpl <em>Program Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ProgramElementImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getProgramElement()
     * @generated
     */
    EClass PROGRAM_ELEMENT = eINSTANCE.getProgramElement();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ConstantImpl <em>Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ConstantImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getConstant()
     * @generated
     */
    EClass CONSTANT = eINSTANCE.getConstant();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__NAME = eINSTANCE.getConstant_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT__VALUE = eINSTANCE.getConstant_Value();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.NumberConstImpl <em>Number Const</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.NumberConstImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getNumberConst()
     * @generated
     */
    EClass NUMBER_CONST = eINSTANCE.getNumberConst();

    /**
     * The meta object literal for the '<em><b>Sign</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMBER_CONST__SIGN = eINSTANCE.getNumberConst_Sign();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.IntConstImpl <em>Int Const</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.IntConstImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getIntConst()
     * @generated
     */
    EClass INT_CONST = eINSTANCE.getIntConst();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_CONST__VALUE = eINSTANCE.getIntConst_Value();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.DoubleConstImpl <em>Double Const</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DoubleConstImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getDoubleConst()
     * @generated
     */
    EClass DOUBLE_CONST = eINSTANCE.getDoubleConst();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOUBLE_CONST__VALUE = eINSTANCE.getDoubleConst_Value();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.VarInitImpl <em>Var Init</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.VarInitImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getVarInit()
     * @generated
     */
    EClass VAR_INIT = eINSTANCE.getVarInit();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_INIT__TYPE = eINSTANCE.getVarInit_Type();

    /**
     * The meta object literal for the '<em><b>Var Asgns</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_INIT__VAR_ASGNS = eINSTANCE.getVarInit_VarAsgns();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.VarAsgnImpl <em>Var Asgn</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.VarAsgnImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getVarAsgn()
     * @generated
     */
    EClass VAR_ASGN = eINSTANCE.getVarAsgn();

    /**
     * The meta object literal for the '<em><b>Input</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VAR_ASGN__INPUT = eINSTANCE.getVarAsgn_Input();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_ASGN__VAR = eINSTANCE.getVarAsgn_Var();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.VarImpl <em>Var</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.VarImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getVar()
     * @generated
     */
    EClass VAR = eINSTANCE.getVar();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VAR__NAME = eINSTANCE.getVar_Name();

    /**
     * The meta object literal for the '<em><b>Dimensions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR__DIMENSIONS = eINSTANCE.getVar_Dimensions();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.DimensionImpl <em>Dimension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DimensionImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getDimension()
     * @generated
     */
    EClass DIMENSION = eINSTANCE.getDimension();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.TypeImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '<em><b>Signed</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__SIGNED = eINSTANCE.getType_Signed();

    /**
     * The meta object literal for the '<em><b>Simp Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__SIMP_TYPE = eINSTANCE.getType_SimpType();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProcedureImpl <em>Procedure</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ProcedureImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getProcedure()
     * @generated
     */
    EClass PROCEDURE = eINSTANCE.getProcedure();

    /**
     * The meta object literal for the '<em><b>Procedure</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROCEDURE__PROCEDURE = eINSTANCE.getProcedure_Procedure();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ProcNoAttrImpl <em>Proc No Attr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ProcNoAttrImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getProcNoAttr()
     * @generated
     */
    EClass PROC_NO_ATTR = eINSTANCE.getProcNoAttr();

    /**
     * The meta object literal for the '<em><b>Prototype</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROC_NO_ATTR__PROTOTYPE = eINSTANCE.getProcNoAttr_Prototype();

    /**
     * The meta object literal for the '<em><b>Fn Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROC_NO_ATTR__FN_BODY = eINSTANCE.getProcNoAttr_FnBody();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FnBodyImpl <em>Fn Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.FnBodyImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getFnBody()
     * @generated
     */
    EClass FN_BODY = eINSTANCE.getFnBody();

    /**
     * The meta object literal for the '<em><b>Var Init List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FN_BODY__VAR_INIT_LIST = eINSTANCE.getFnBody_VarInitList();

    /**
     * The meta object literal for the '<em><b>Stmt List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FN_BODY__STMT_LIST = eINSTANCE.getFnBody_StmtList();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeImpl <em>Fn Prototype</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getFnPrototype()
     * @generated
     */
    EClass FN_PROTOTYPE = eINSTANCE.getFnPrototype();

    /**
     * The meta object literal for the '<em><b>Extern</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FN_PROTOTYPE__EXTERN = eINSTANCE.getFnPrototype_Extern();

    /**
     * The meta object literal for the '<em><b>Pure</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FN_PROTOTYPE__PURE = eINSTANCE.getFnPrototype_Pure();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FN_PROTOTYPE__NAME = eINSTANCE.getFnPrototype_Name();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ParamImpl <em>Param</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ParamImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getParam()
     * @generated
     */
    EClass PARAM = eINSTANCE.getParam();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAM__TYPE = eINSTANCE.getParam_Type();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAM__VAR = eINSTANCE.getParam_Var();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.VarInitListImpl <em>Var Init List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.VarInitListImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getVarInitList()
     * @generated
     */
    EClass VAR_INIT_LIST = eINSTANCE.getVarInitList();

    /**
     * The meta object literal for the '<em><b>Var Inits</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_INIT_LIST__VAR_INITS = eINSTANCE.getVarInitList_VarInits();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.StmtListImpl <em>Stmt List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.StmtListImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getStmtList()
     * @generated
     */
    EClass STMT_LIST = eINSTANCE.getStmtList();

    /**
     * The meta object literal for the '<em><b>Stmts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT_LIST__STMTS = eINSTANCE.getStmtList_Stmts();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.StmtImpl <em>Stmt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.StmtImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getStmt()
     * @generated
     */
    EClass STMT = eINSTANCE.getStmt();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.LValImpl <em>LVal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.LValImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getLVal()
     * @generated
     */
    EClass LVAL = eINSTANCE.getLVal();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LVAL__NAME = eINSTANCE.getLVal_Name();

    /**
     * The meta object literal for the '<em><b>Indices</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LVAL__INDICES = eINSTANCE.getLVal_Indices();

    /**
     * The meta object literal for the '<em><b>At</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LVAL__AT = eINSTANCE.getLVal_At();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ExprImpl <em>Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getExpr()
     * @generated
     */
    EClass EXPR = eINSTANCE.getExpr();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.CallExprImpl <em>Call Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.CallExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getCallExpr()
     * @generated
     */
    EClass CALL_EXPR = eINSTANCE.getCallExpr();

    /**
     * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CALL_EXPR__NAMESPACE = eINSTANCE.getCallExpr_Namespace();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CALL_EXPR__NAME = eINSTANCE.getCallExpr_Name();

    /**
     * The meta object literal for the '<em><b>Arg List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL_EXPR__ARG_LIST = eINSTANCE.getCallExpr_ArgList();

    /**
     * The meta object literal for the '<em><b>At</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL_EXPR__AT = eINSTANCE.getCallExpr_At();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ArgListImpl <em>Arg List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ArgListImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getArgList()
     * @generated
     */
    EClass ARG_LIST = eINSTANCE.getArgList();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARG_LIST__ARGS = eINSTANCE.getArgList_Args();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ExprVarAsgnImpl <em>Expr Var Asgn</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ExprVarAsgnImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getExprVarAsgn()
     * @generated
     */
    EClass EXPR_VAR_ASGN = eINSTANCE.getExprVarAsgn();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_VAR_ASGN__EXPR = eINSTANCE.getExprVarAsgn_Expr();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FnVarAsgnImpl <em>Fn Var Asgn</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.FnVarAsgnImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getFnVarAsgn()
     * @generated
     */
    EClass FN_VAR_ASGN = eINSTANCE.getFnVarAsgn();

    /**
     * The meta object literal for the '<em><b>Fn Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FN_VAR_ASGN__FN_BODY = eINSTANCE.getFnVarAsgn_FnBody();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.IntDimensionImpl <em>Int Dimension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.IntDimensionImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getIntDimension()
     * @generated
     */
    EClass INT_DIMENSION = eINSTANCE.getIntDimension();

    /**
     * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_DIMENSION__INDEX = eINSTANCE.getIntDimension_Index();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.NodeNumDimensionImpl <em>Node Num Dimension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.NodeNumDimensionImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getNodeNumDimension()
     * @generated
     */
    EClass NODE_NUM_DIMENSION = eINSTANCE.getNodeNumDimension();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.IdDimensionImpl <em>Id Dimension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.IdDimensionImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getIdDimension()
     * @generated
     */
    EClass ID_DIMENSION = eINSTANCE.getIdDimension();

    /**
     * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ID_DIMENSION__INDEX = eINSTANCE.getIdDimension_Index();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ThreadDeclarationImpl <em>Thread Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ThreadDeclarationImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getThreadDeclaration()
     * @generated
     */
    EClass THREAD_DECLARATION = eINSTANCE.getThreadDeclaration();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeDeclarationImpl <em>Fn Prototype Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeDeclarationImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getFnPrototypeDeclaration()
     * @generated
     */
    EClass FN_PROTOTYPE_DECLARATION = eINSTANCE.getFnPrototypeDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FN_PROTOTYPE_DECLARATION__TYPE = eINSTANCE.getFnPrototypeDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FN_PROTOTYPE_DECLARATION__PARAMS = eINSTANCE.getFnPrototypeDeclaration_Params();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.NestedStmtImpl <em>Nested Stmt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.NestedStmtImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getNestedStmt()
     * @generated
     */
    EClass NESTED_STMT = eINSTANCE.getNestedStmt();

    /**
     * The meta object literal for the '<em><b>Stmt List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NESTED_STMT__STMT_LIST = eINSTANCE.getNestedStmt_StmtList();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.AssignmentStmtImpl <em>Assignment Stmt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.AssignmentStmtImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getAssignmentStmt()
     * @generated
     */
    EClass ASSIGNMENT_STMT = eINSTANCE.getAssignmentStmt();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_STMT__VARIABLE = eINSTANCE.getAssignmentStmt_Variable();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_STMT__VALUE = eINSTANCE.getAssignmentStmt_Value();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.WhileStmtImpl <em>While Stmt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.WhileStmtImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getWhileStmt()
     * @generated
     */
    EClass WHILE_STMT = eINSTANCE.getWhileStmt();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_STMT__CONDITION = eINSTANCE.getWhileStmt_Condition();

    /**
     * The meta object literal for the '<em><b>Stmt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_STMT__STMT = eINSTANCE.getWhileStmt_Stmt();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.SimpleStmtImpl <em>Simple Stmt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.SimpleStmtImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSimpleStmt()
     * @generated
     */
    EClass SIMPLE_STMT = eINSTANCE.getSimpleStmt();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_STMT__NAME = eINSTANCE.getSimpleStmt_Name();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ReturnValueStmtImpl <em>Return Value Stmt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ReturnValueStmtImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getReturnValueStmt()
     * @generated
     */
    EClass RETURN_VALUE_STMT = eINSTANCE.getReturnValueStmt();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RETURN_VALUE_STMT__VALUE = eINSTANCE.getReturnValueStmt_Value();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ForAllStmtImpl <em>For All Stmt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ForAllStmtImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getForAllStmt()
     * @generated
     */
    EClass FOR_ALL_STMT = eINSTANCE.getForAllStmt();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOR_ALL_STMT__NAME = eINSTANCE.getForAllStmt_Name();

    /**
     * The meta object literal for the '<em><b>Node</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOR_ALL_STMT__NODE = eINSTANCE.getForAllStmt_Node();

    /**
     * The meta object literal for the '<em><b>Stmt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_ALL_STMT__STMT = eINSTANCE.getForAllStmt_Stmt();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FadnpStmtImpl <em>Fadnp Stmt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.FadnpStmtImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getFadnpStmt()
     * @generated
     */
    EClass FADNP_STMT = eINSTANCE.getFadnpStmt();

    /**
     * The meta object literal for the '<em><b>Node1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FADNP_STMT__NODE1 = eINSTANCE.getFadnpStmt_Node1();

    /**
     * The meta object literal for the '<em><b>Node2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FADNP_STMT__NODE2 = eINSTANCE.getFadnpStmt_Node2();

    /**
     * The meta object literal for the '<em><b>Stmt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FADNP_STMT__STMT = eINSTANCE.getFadnpStmt_Stmt();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.TernaryExprImpl <em>Ternary Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.TernaryExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getTernaryExpr()
     * @generated
     */
    EClass TERNARY_EXPR = eINSTANCE.getTernaryExpr();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TERNARY_EXPR__CONDITION = eINSTANCE.getTernaryExpr_Condition();

    /**
     * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TERNARY_EXPR__THEN = eINSTANCE.getTernaryExpr_Then();

    /**
     * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TERNARY_EXPR__ELSE = eINSTANCE.getTernaryExpr_Else();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.OrExprImpl <em>Or Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.OrExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getOrExpr()
     * @generated
     */
    EClass OR_EXPR = eINSTANCE.getOrExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPR__LEFT = eINSTANCE.getOrExpr_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPR__RIGHT = eINSTANCE.getOrExpr_Right();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.AndExprImpl <em>And Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.AndExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getAndExpr()
     * @generated
     */
    EClass AND_EXPR = eINSTANCE.getAndExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPR__LEFT = eINSTANCE.getAndExpr_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPR__RIGHT = eINSTANCE.getAndExpr_Right();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.BitwiseOrExprImpl <em>Bitwise Or Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.BitwiseOrExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getBitwiseOrExpr()
     * @generated
     */
    EClass BITWISE_OR_EXPR = eINSTANCE.getBitwiseOrExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_OR_EXPR__LEFT = eINSTANCE.getBitwiseOrExpr_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_OR_EXPR__RIGHT = eINSTANCE.getBitwiseOrExpr_Right();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.XorExprImpl <em>Xor Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.XorExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getXorExpr()
     * @generated
     */
    EClass XOR_EXPR = eINSTANCE.getXorExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XOR_EXPR__LEFT = eINSTANCE.getXorExpr_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XOR_EXPR__RIGHT = eINSTANCE.getXorExpr_Right();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.BitwiseAndExprImpl <em>Bitwise And Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.BitwiseAndExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getBitwiseAndExpr()
     * @generated
     */
    EClass BITWISE_AND_EXPR = eINSTANCE.getBitwiseAndExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_AND_EXPR__LEFT = eINSTANCE.getBitwiseAndExpr_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_AND_EXPR__RIGHT = eINSTANCE.getBitwiseAndExpr_Right();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.EqualityExprImpl <em>Equality Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.EqualityExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getEqualityExpr()
     * @generated
     */
    EClass EQUALITY_EXPR = eINSTANCE.getEqualityExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPR__LEFT = eINSTANCE.getEqualityExpr_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EQUALITY_EXPR__OPERATOR = eINSTANCE.getEqualityExpr_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPR__RIGHT = eINSTANCE.getEqualityExpr_Right();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.CompareExprImpl <em>Compare Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.CompareExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getCompareExpr()
     * @generated
     */
    EClass COMPARE_EXPR = eINSTANCE.getCompareExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPARE_EXPR__LEFT = eINSTANCE.getCompareExpr_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPARE_EXPR__OPERATOR = eINSTANCE.getCompareExpr_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPARE_EXPR__RIGHT = eINSTANCE.getCompareExpr_Right();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ShiftExprImpl <em>Shift Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ShiftExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getShiftExpr()
     * @generated
     */
    EClass SHIFT_EXPR = eINSTANCE.getShiftExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHIFT_EXPR__LEFT = eINSTANCE.getShiftExpr_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SHIFT_EXPR__OPERATOR = eINSTANCE.getShiftExpr_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHIFT_EXPR__RIGHT = eINSTANCE.getShiftExpr_Right();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.AdditiveExprImpl <em>Additive Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.AdditiveExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getAdditiveExpr()
     * @generated
     */
    EClass ADDITIVE_EXPR = eINSTANCE.getAdditiveExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPR__LEFT = eINSTANCE.getAdditiveExpr_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADDITIVE_EXPR__OPERATOR = eINSTANCE.getAdditiveExpr_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPR__RIGHT = eINSTANCE.getAdditiveExpr_Right();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.MultiplicativeExprImpl <em>Multiplicative Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.MultiplicativeExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getMultiplicativeExpr()
     * @generated
     */
    EClass MULTIPLICATIVE_EXPR = eINSTANCE.getMultiplicativeExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPR__LEFT = eINSTANCE.getMultiplicativeExpr_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICATIVE_EXPR__OPERATOR = eINSTANCE.getMultiplicativeExpr_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPR__RIGHT = eINSTANCE.getMultiplicativeExpr_Right();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.IdExprImpl <em>Id Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.IdExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getIdExpr()
     * @generated
     */
    EClass ID_EXPR = eINSTANCE.getIdExpr();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.IntExprImpl <em>Int Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.IntExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getIntExpr()
     * @generated
     */
    EClass INT_EXPR = eINSTANCE.getIntExpr();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_EXPR__VALUE = eINSTANCE.getIntExpr_Value();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.DoubleExprImpl <em>Double Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DoubleExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getDoubleExpr()
     * @generated
     */
    EClass DOUBLE_EXPR = eINSTANCE.getDoubleExpr();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOUBLE_EXPR__VALUE = eINSTANCE.getDoubleExpr_Value();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.NodeNumExprImpl <em>Node Num Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.NodeNumExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getNodeNumExpr()
     * @generated
     */
    EClass NODE_NUM_EXPR = eINSTANCE.getNodeNumExpr();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.UnaryExprImpl <em>Unary Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.UnaryExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getUnaryExpr()
     * @generated
     */
    EClass UNARY_EXPR = eINSTANCE.getUnaryExpr();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_EXPR__OPERATOR = eINSTANCE.getUnaryExpr_Operator();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPR__OPERAND = eINSTANCE.getUnaryExpr_Operand();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.BuiltInExprImpl <em>Built In Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.BuiltInExprImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getBuiltInExpr()
     * @generated
     */
    EClass BUILT_IN_EXPR = eINSTANCE.getBuiltInExpr();

    /**
     * The meta object literal for the '<em><b>Function</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BUILT_IN_EXPR__FUNCTION = eINSTANCE.getBuiltInExpr_Function();

    /**
     * The meta object literal for the '<em><b>First Arg</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BUILT_IN_EXPR__FIRST_ARG = eINSTANCE.getBuiltInExpr_FirstArg();

    /**
     * The meta object literal for the '<em><b>Second Arg</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BUILT_IN_EXPR__SECOND_ARG = eINSTANCE.getBuiltInExpr_SecondArg();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.SignEnum <em>Sign Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.SignEnum
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSignEnum()
     * @generated
     */
    EEnum SIGN_ENUM = eINSTANCE.getSignEnum();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum <em>Simp Type Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSimpTypeEnum()
     * @generated
     */
    EEnum SIMP_TYPE_ENUM = eINSTANCE.getSimpTypeEnum();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.SignedEnum <em>Signed Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.SignedEnum
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSignedEnum()
     * @generated
     */
    EEnum SIGNED_ENUM = eINSTANCE.getSignedEnum();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.SimpleStmtKeywordEnum <em>Simple Stmt Keyword Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.SimpleStmtKeywordEnum
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSimpleStmtKeywordEnum()
     * @generated
     */
    EEnum SIMPLE_STMT_KEYWORD_ENUM = eINSTANCE.getSimpleStmtKeywordEnum();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.ForAllFunctionEnum <em>For All Function Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.ForAllFunctionEnum
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getForAllFunctionEnum()
     * @generated
     */
    EEnum FOR_ALL_FUNCTION_ENUM = eINSTANCE.getForAllFunctionEnum();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.EqualityOperator <em>Equality Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.EqualityOperator
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getEqualityOperator()
     * @generated
     */
    EEnum EQUALITY_OPERATOR = eINSTANCE.getEqualityOperator();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.CompareOperator <em>Compare Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.CompareOperator
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getCompareOperator()
     * @generated
     */
    EEnum COMPARE_OPERATOR = eINSTANCE.getCompareOperator();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.ShiftOperator <em>Shift Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.ShiftOperator
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getShiftOperator()
     * @generated
     */
    EEnum SHIFT_OPERATOR = eINSTANCE.getShiftOperator();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.AdditiveOperator <em>Additive Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.AdditiveOperator
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getAdditiveOperator()
     * @generated
     */
    EEnum ADDITIVE_OPERATOR = eINSTANCE.getAdditiveOperator();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeOperator
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getMultiplicativeOperator()
     * @generated
     */
    EEnum MULTIPLICATIVE_OPERATOR = eINSTANCE.getMultiplicativeOperator();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.UnaryOperator <em>Unary Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.UnaryOperator
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getUnaryOperator()
     * @generated
     */
    EEnum UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.BuiltInFunctionEnum <em>Built In Function Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.BuiltInFunctionEnum
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getBuiltInFunctionEnum()
     * @generated
     */
    EEnum BUILT_IN_FUNCTION_ENUM = eINSTANCE.getBuiltInFunctionEnum();

  }

} //DmplPackage
