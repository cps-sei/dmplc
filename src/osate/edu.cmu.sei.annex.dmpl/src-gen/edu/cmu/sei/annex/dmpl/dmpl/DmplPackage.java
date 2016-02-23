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
   * The meta object id for the '{@link edu.cmu.sei.annex.dmpl.dmpl.SignEnum <em>Sign Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.cmu.sei.annex.dmpl.dmpl.SignEnum
   * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSignEnum()
   * @generated
   */
  int SIGN_ENUM = 7;


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
   * Returns the meta object for enum '{@link edu.cmu.sei.annex.dmpl.dmpl.SignEnum <em>Sign Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Sign Enum</em>'.
   * @see edu.cmu.sei.annex.dmpl.dmpl.SignEnum
   * @generated
   */
  EEnum getSignEnum();

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
     * The meta object literal for the '{@link edu.cmu.sei.annex.dmpl.dmpl.SignEnum <em>Sign Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.cmu.sei.annex.dmpl.dmpl.SignEnum
     * @see edu.cmu.sei.annex.dmpl.dmpl.impl.DmplPackageImpl#getSignEnum()
     * @generated
     */
    EEnum SIGN_ENUM = eINSTANCE.getSignEnum();

  }

} //DmplPackage
