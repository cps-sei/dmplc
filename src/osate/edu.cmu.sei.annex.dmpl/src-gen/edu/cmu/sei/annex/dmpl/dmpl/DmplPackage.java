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
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.TypeImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getType()
   * @generated
   */
  int TYPE = 7;

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
  int PROCEDURE = 8;

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
  int PROC_NO_ATTR = 9;

  /**
   * The feature id for the '<em><b>Prototype</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROC_NO_ATTR__PROTOTYPE = 0;

  /**
   * The number of structural features of the '<em>Proc No Attr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROC_NO_ATTR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeImpl <em>Fn Prototype</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getFnPrototype()
   * @generated
   */
  int FN_PROTOTYPE = 10;

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
   * The feature id for the '<em><b>Prototype</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE__PROTOTYPE = 2;

  /**
   * The number of structural features of the '<em>Fn Prototype</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeNoDecorsImpl <em>Fn Prototype No Decors</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeNoDecorsImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getFnPrototypeNoDecors()
   * @generated
   */
  int FN_PROTOTYPE_NO_DECORS = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE_NO_DECORS__NAME = 0;

  /**
   * The number of structural features of the '<em>Fn Prototype No Decors</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE_NO_DECORS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.ThreadDeclarationImpl <em>Thread Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.ThreadDeclarationImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getThreadDeclaration()
   * @generated
   */
  int THREAD_DECLARATION = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAD_DECLARATION__NAME = FN_PROTOTYPE_NO_DECORS__NAME;

  /**
   * The number of structural features of the '<em>Thread Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THREAD_DECLARATION_FEATURE_COUNT = FN_PROTOTYPE_NO_DECORS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeDeclarationImpl <em>Fn Prototype Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeDeclarationImpl
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getFnPrototypeDeclaration()
   * @generated
   */
  int FN_PROTOTYPE_DECLARATION = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE_DECLARATION__NAME = FN_PROTOTYPE_NO_DECORS__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE_DECLARATION__TYPE = FN_PROTOTYPE_NO_DECORS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Fn Prototype Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_PROTOTYPE_DECLARATION_FEATURE_COUNT = FN_PROTOTYPE_NO_DECORS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.SignEnum <em>Sign Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.SignEnum
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSignEnum()
   * @generated
   */
  int SIGN_ENUM = 14;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum <em>Simp Type Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSimpTypeEnum()
   * @generated
   */
  int SIMP_TYPE_ENUM = 15;

  /**
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.SignedEnum <em>Signed Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.SignedEnum
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSignedEnum()
   * @generated
   */
  int SIGNED_ENUM = 16;


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
   * Returns the meta object for the containment reference '{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototype#getPrototype <em>Prototype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Prototype</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnPrototype#getPrototype()
   * @see #getFnPrototype()
   * @generated
   */
  EReference getFnPrototype_Prototype();

  /**
   * Returns the meta object for class '{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeNoDecors <em>Fn Prototype No Decors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fn Prototype No Decors</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeNoDecors
   * @generated
   */
  EClass getFnPrototypeNoDecors();

  /**
   * Returns the meta object for the attribute '{@link edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeNoDecors#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeNoDecors#getName()
   * @see #getFnPrototypeNoDecors()
   * @generated
   */
  EAttribute getFnPrototypeNoDecors_Name();

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
     * The meta object literal for the '<em><b>Prototype</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FN_PROTOTYPE__PROTOTYPE = eINSTANCE.getFnPrototype_Prototype();

    /**
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeNoDecorsImpl <em>Fn Prototype No Decors</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.FnPrototypeNoDecorsImpl
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getFnPrototypeNoDecors()
     * @generated
     */
    EClass FN_PROTOTYPE_NO_DECORS = eINSTANCE.getFnPrototypeNoDecors();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FN_PROTOTYPE_NO_DECORS__NAME = eINSTANCE.getFnPrototypeNoDecors_Name();

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
