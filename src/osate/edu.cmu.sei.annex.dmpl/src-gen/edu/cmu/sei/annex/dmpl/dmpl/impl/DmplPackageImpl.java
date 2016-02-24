/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.Constant;
import edu.cmu.sei.annex.dmpl.dmpl.DmplFactory;
import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.DmplSubclause;
import edu.cmu.sei.annex.dmpl.dmpl.DoubleConst;
import edu.cmu.sei.annex.dmpl.dmpl.FnPrototype;
import edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeDeclaration;
import edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeNoDecors;
import edu.cmu.sei.annex.dmpl.dmpl.FnType;
import edu.cmu.sei.annex.dmpl.dmpl.IntConst;
import edu.cmu.sei.annex.dmpl.dmpl.NumberConst;
import edu.cmu.sei.annex.dmpl.dmpl.ProcNoAttr;
import edu.cmu.sei.annex.dmpl.dmpl.Procedure;
import edu.cmu.sei.annex.dmpl.dmpl.Program;
import edu.cmu.sei.annex.dmpl.dmpl.ProgramElement;
import edu.cmu.sei.annex.dmpl.dmpl.SignEnum;
import edu.cmu.sei.annex.dmpl.dmpl.SignedEnum;
import edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum;
import edu.cmu.sei.annex.dmpl.dmpl.ThreadDeclaration;
import edu.cmu.sei.annex.dmpl.dmpl.Type;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DmplPackageImpl extends EPackageImpl implements DmplPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass programEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dmplSubclauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass programElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numberConstEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass intConstEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass doubleConstEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fnTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass procedureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass procNoAttrEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fnPrototypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fnPrototypeNoDecorsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass threadDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fnPrototypeDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum signEnumEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum simpTypeEnumEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum signedEnumEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private DmplPackageImpl()
  {
    super(eNS_URI, DmplFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link DmplPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static DmplPackage init()
  {
    if (isInited) return (DmplPackage)EPackage.Registry.INSTANCE.getEPackage(DmplPackage.eNS_URI);

    // Obtain or create and register package
    DmplPackageImpl theDmplPackage = (DmplPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DmplPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DmplPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    Aadl2Package.eINSTANCE.eClass();

    // Create package meta-data objects
    theDmplPackage.createPackageContents();

    // Initialize created meta-data
    theDmplPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theDmplPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(DmplPackage.eNS_URI, theDmplPackage);
    return theDmplPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProgram()
  {
    return programEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProgram_ProgramElements()
  {
    return (EReference)programEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDmplSubclause()
  {
    return dmplSubclauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDmplSubclause_Program()
  {
    return (EReference)dmplSubclauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProgramElement()
  {
    return programElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstant()
  {
    return constantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstant_Name()
  {
    return (EAttribute)constantEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstant_Value()
  {
    return (EReference)constantEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumberConst()
  {
    return numberConstEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNumberConst_Sign()
  {
    return (EAttribute)numberConstEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntConst()
  {
    return intConstEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIntConst_Value()
  {
    return (EAttribute)intConstEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDoubleConst()
  {
    return doubleConstEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDoubleConst_Value()
  {
    return (EAttribute)doubleConstEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType()
  {
    return typeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getType_Signed()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getType_SimpType()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFnType()
  {
    return fnTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFnType_Type()
  {
    return (EReference)fnTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProcedure()
  {
    return procedureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProcedure_Procedure()
  {
    return (EReference)procedureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProcNoAttr()
  {
    return procNoAttrEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProcNoAttr_Prototype()
  {
    return (EReference)procNoAttrEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFnPrototype()
  {
    return fnPrototypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFnPrototype_Extern()
  {
    return (EAttribute)fnPrototypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFnPrototype_Pure()
  {
    return (EAttribute)fnPrototypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFnPrototype_Prototype()
  {
    return (EReference)fnPrototypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFnPrototypeNoDecors()
  {
    return fnPrototypeNoDecorsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFnPrototypeNoDecors_Name()
  {
    return (EAttribute)fnPrototypeNoDecorsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThreadDeclaration()
  {
    return threadDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFnPrototypeDeclaration()
  {
    return fnPrototypeDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFnPrototypeDeclaration_Type()
  {
    return (EReference)fnPrototypeDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getSignEnum()
  {
    return signEnumEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getSimpTypeEnum()
  {
    return simpTypeEnumEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getSignedEnum()
  {
    return signedEnumEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DmplFactory getDmplFactory()
  {
    return (DmplFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    programEClass = createEClass(PROGRAM);
    createEReference(programEClass, PROGRAM__PROGRAM_ELEMENTS);

    dmplSubclauseEClass = createEClass(DMPL_SUBCLAUSE);
    createEReference(dmplSubclauseEClass, DMPL_SUBCLAUSE__PROGRAM);

    programElementEClass = createEClass(PROGRAM_ELEMENT);

    constantEClass = createEClass(CONSTANT);
    createEAttribute(constantEClass, CONSTANT__NAME);
    createEReference(constantEClass, CONSTANT__VALUE);

    numberConstEClass = createEClass(NUMBER_CONST);
    createEAttribute(numberConstEClass, NUMBER_CONST__SIGN);

    intConstEClass = createEClass(INT_CONST);
    createEAttribute(intConstEClass, INT_CONST__VALUE);

    doubleConstEClass = createEClass(DOUBLE_CONST);
    createEAttribute(doubleConstEClass, DOUBLE_CONST__VALUE);

    typeEClass = createEClass(TYPE);
    createEAttribute(typeEClass, TYPE__SIGNED);
    createEAttribute(typeEClass, TYPE__SIMP_TYPE);

    fnTypeEClass = createEClass(FN_TYPE);
    createEReference(fnTypeEClass, FN_TYPE__TYPE);

    procedureEClass = createEClass(PROCEDURE);
    createEReference(procedureEClass, PROCEDURE__PROCEDURE);

    procNoAttrEClass = createEClass(PROC_NO_ATTR);
    createEReference(procNoAttrEClass, PROC_NO_ATTR__PROTOTYPE);

    fnPrototypeEClass = createEClass(FN_PROTOTYPE);
    createEAttribute(fnPrototypeEClass, FN_PROTOTYPE__EXTERN);
    createEAttribute(fnPrototypeEClass, FN_PROTOTYPE__PURE);
    createEReference(fnPrototypeEClass, FN_PROTOTYPE__PROTOTYPE);

    fnPrototypeNoDecorsEClass = createEClass(FN_PROTOTYPE_NO_DECORS);
    createEAttribute(fnPrototypeNoDecorsEClass, FN_PROTOTYPE_NO_DECORS__NAME);

    threadDeclarationEClass = createEClass(THREAD_DECLARATION);

    fnPrototypeDeclarationEClass = createEClass(FN_PROTOTYPE_DECLARATION);
    createEReference(fnPrototypeDeclarationEClass, FN_PROTOTYPE_DECLARATION__TYPE);

    // Create enums
    signEnumEEnum = createEEnum(SIGN_ENUM);
    simpTypeEnumEEnum = createEEnum(SIMP_TYPE_ENUM);
    signedEnumEEnum = createEEnum(SIGNED_ENUM);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    dmplSubclauseEClass.getESuperTypes().add(theAadl2Package.getAnnexSubclause());
    constantEClass.getESuperTypes().add(this.getProgramElement());
    intConstEClass.getESuperTypes().add(this.getNumberConst());
    doubleConstEClass.getESuperTypes().add(this.getNumberConst());
    procedureEClass.getESuperTypes().add(this.getProgramElement());
    threadDeclarationEClass.getESuperTypes().add(this.getFnPrototypeNoDecors());
    fnPrototypeDeclarationEClass.getESuperTypes().add(this.getFnPrototypeNoDecors());

    // Initialize classes and features; add operations and parameters
    initEClass(programEClass, Program.class, "Program", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProgram_ProgramElements(), this.getProgramElement(), null, "programElements", null, 0, -1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dmplSubclauseEClass, DmplSubclause.class, "DmplSubclause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDmplSubclause_Program(), this.getProgram(), null, "program", null, 0, 1, DmplSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(programElementEClass, ProgramElement.class, "ProgramElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(constantEClass, Constant.class, "Constant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getConstant_Name(), ecorePackage.getEString(), "name", null, 0, 1, Constant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstant_Value(), this.getNumberConst(), null, "value", null, 0, 1, Constant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(numberConstEClass, NumberConst.class, "NumberConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNumberConst_Sign(), this.getSignEnum(), "sign", null, 0, 1, NumberConst.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(intConstEClass, IntConst.class, "IntConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIntConst_Value(), ecorePackage.getEInt(), "value", null, 0, 1, IntConst.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(doubleConstEClass, DoubleConst.class, "DoubleConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDoubleConst_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, DoubleConst.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getType_Signed(), this.getSignedEnum(), "signed", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getType_SimpType(), this.getSimpTypeEnum(), "simpType", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fnTypeEClass, FnType.class, "FnType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFnType_Type(), this.getType(), null, "type", null, 0, 1, FnType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(procedureEClass, Procedure.class, "Procedure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProcedure_Procedure(), this.getProcNoAttr(), null, "procedure", null, 0, 1, Procedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(procNoAttrEClass, ProcNoAttr.class, "ProcNoAttr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProcNoAttr_Prototype(), this.getFnPrototype(), null, "prototype", null, 0, 1, ProcNoAttr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fnPrototypeEClass, FnPrototype.class, "FnPrototype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFnPrototype_Extern(), ecorePackage.getEBoolean(), "extern", null, 0, 1, FnPrototype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFnPrototype_Pure(), ecorePackage.getEBoolean(), "pure", null, 0, 1, FnPrototype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFnPrototype_Prototype(), this.getFnPrototypeNoDecors(), null, "prototype", null, 0, 1, FnPrototype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fnPrototypeNoDecorsEClass, FnPrototypeNoDecors.class, "FnPrototypeNoDecors", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFnPrototypeNoDecors_Name(), ecorePackage.getEString(), "name", null, 0, 1, FnPrototypeNoDecors.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(threadDeclarationEClass, ThreadDeclaration.class, "ThreadDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(fnPrototypeDeclarationEClass, FnPrototypeDeclaration.class, "FnPrototypeDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFnPrototypeDeclaration_Type(), this.getFnType(), null, "type", null, 0, 1, FnPrototypeDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(signEnumEEnum, SignEnum.class, "SignEnum");
    addEEnumLiteral(signEnumEEnum, SignEnum.UNSET);
    addEEnumLiteral(signEnumEEnum, SignEnum.PLUS);
    addEEnumLiteral(signEnumEEnum, SignEnum.MINUS);

    initEEnum(simpTypeEnumEEnum, SimpTypeEnum.class, "SimpTypeEnum");
    addEEnumLiteral(simpTypeEnumEEnum, SimpTypeEnum.BOOL);
    addEEnumLiteral(simpTypeEnumEEnum, SimpTypeEnum.INT);
    addEEnumLiteral(simpTypeEnumEEnum, SimpTypeEnum.DOUBLE);
    addEEnumLiteral(simpTypeEnumEEnum, SimpTypeEnum.VOID);
    addEEnumLiteral(simpTypeEnumEEnum, SimpTypeEnum.CHAR);

    initEEnum(signedEnumEEnum, SignedEnum.class, "SignedEnum");
    addEEnumLiteral(signedEnumEEnum, SignedEnum.UNSET);
    addEEnumLiteral(signedEnumEEnum, SignedEnum.SIGNED);
    addEEnumLiteral(signedEnumEEnum, SignedEnum.UNSIGNED);

    // Create resource
    createResource(eNS_URI);
  }

} //DmplPackageImpl
