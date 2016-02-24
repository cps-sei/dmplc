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
   * The feature id for the '<em><b>Var Asgn List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_INIT__VAR_ASGN_LIST = 1;

  /**
   * The number of structural features of the '<em>Var Init</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_INIT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.VarAsgnListImpl <em>Var Asgn List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.VarAsgnListImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getVarAsgnList()
   * @generated
   */
  int VAR_ASGN_LIST = 8;

  /**
   * The feature id for the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_ASGN_LIST__VAR = 0;

  /**
   * The number of structural features of the '<em>Var Asgn List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_ASGN_LIST_FEATURE_COUNT = 1;

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
   * The number of structural features of the '<em>Fn Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_BODY_FEATURE_COUNT = 1;

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
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.IntDimensionImpl <em>Int Dimension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.IntDimensionImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getIntDimension()
   * @generated
   */
  int INT_DIMENSION = 18;

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
  int NODE_NUM_DIMENSION = 19;

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
  int ID_DIMENSION = 20;

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
  int THREAD_DECLARATION = 21;

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
  int FN_PROTOTYPE_DECLARATION = 22;

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
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.SignEnum <em>Sign Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.SignEnum
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSignEnum()
   * @generated
   */
  int SIGN_ENUM = 23;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum <em>Simp Type Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSimpTypeEnum()
   * @generated
   */
  int SIMP_TYPE_ENUM = 24;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.SignedEnum <em>Signed Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.SignedEnum
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSignedEnum()
   * @generated
   */
  int SIGNED_ENUM = 25;


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
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.VarInit#getVarAsgnList <em>Var Asgn List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var Asgn List</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.VarInit#getVarAsgnList()
   * @see #getVarInit()
   * @generated
   */
  EReference getVarInit_VarAsgnList();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgnList <em>Var Asgn List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Asgn List</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.VarAsgnList
   * @generated
   */
  EClass getVarAsgnList();

  /**
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.VarAsgnList#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.VarAsgnList#getVar()
   * @see #getVarAsgnList()
   * @generated
   */
  EReference getVarAsgnList_Var();

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
     * The meta object literal for the '<em><b>Var Asgn List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_INIT__VAR_ASGN_LIST = eINSTANCE.getVarInit_VarAsgnList();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.VarAsgnListImpl <em>Var Asgn List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.VarAsgnListImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getVarAsgnList()
     * @generated
     */
    EClass VAR_ASGN_LIST = eINSTANCE.getVarAsgnList();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_ASGN_LIST__VAR = eINSTANCE.getVarAsgnList_Var();

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

  }

} //DmplPackage
