/**
 */
package edu.cmu.sei.annex.dmpl.dmpl.impl;

import edu.cmu.sei.annex.dmpl.dmpl.AdditiveExpr;
import edu.cmu.sei.annex.dmpl.dmpl.AdditiveOperator;
import edu.cmu.sei.annex.dmpl.dmpl.AndExpr;
import edu.cmu.sei.annex.dmpl.dmpl.AssignmentStmt;
import edu.cmu.sei.annex.dmpl.dmpl.AtEndSpec;
import edu.cmu.sei.annex.dmpl.dmpl.AtLeastSpec;
import edu.cmu.sei.annex.dmpl.dmpl.Attr;
import edu.cmu.sei.annex.dmpl.dmpl.AttrList;
import edu.cmu.sei.annex.dmpl.dmpl.Attributable;
import edu.cmu.sei.annex.dmpl.dmpl.AttributableElement;
import edu.cmu.sei.annex.dmpl.dmpl.AttributableNoRole;
import edu.cmu.sei.annex.dmpl.dmpl.AttributableNoRoleElement;
import edu.cmu.sei.annex.dmpl.dmpl.BitwiseAndExpr;
import edu.cmu.sei.annex.dmpl.dmpl.BitwiseOrExpr;
import edu.cmu.sei.annex.dmpl.dmpl.BuiltInExpr;
import edu.cmu.sei.annex.dmpl.dmpl.BuiltInFunctionEnum;
import edu.cmu.sei.annex.dmpl.dmpl.CallExpr;
import edu.cmu.sei.annex.dmpl.dmpl.CompareExpr;
import edu.cmu.sei.annex.dmpl.dmpl.CompareOperator;
import edu.cmu.sei.annex.dmpl.dmpl.CondStmt;
import edu.cmu.sei.annex.dmpl.dmpl.Constant;
import edu.cmu.sei.annex.dmpl.dmpl.Dimension;
import edu.cmu.sei.annex.dmpl.dmpl.DmplFactory;
import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage;
import edu.cmu.sei.annex.dmpl.dmpl.DmplSubclause;
import edu.cmu.sei.annex.dmpl.dmpl.DoubleConst;
import edu.cmu.sei.annex.dmpl.dmpl.DoubleExpr;
import edu.cmu.sei.annex.dmpl.dmpl.EqualityExpr;
import edu.cmu.sei.annex.dmpl.dmpl.EqualityOperator;
import edu.cmu.sei.annex.dmpl.dmpl.Expr;
import edu.cmu.sei.annex.dmpl.dmpl.ExprVarAsgn;
import edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt;
import edu.cmu.sei.annex.dmpl.dmpl.FnBody;
import edu.cmu.sei.annex.dmpl.dmpl.FnPrototype;
import edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeDeclaration;
import edu.cmu.sei.annex.dmpl.dmpl.FnVarAsgn;
import edu.cmu.sei.annex.dmpl.dmpl.ForAllFunctionEnum;
import edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt;
import edu.cmu.sei.annex.dmpl.dmpl.ForStmt;
import edu.cmu.sei.annex.dmpl.dmpl.IdDimension;
import edu.cmu.sei.annex.dmpl.dmpl.IdExpr;
import edu.cmu.sei.annex.dmpl.dmpl.IdRole;
import edu.cmu.sei.annex.dmpl.dmpl.IntConst;
import edu.cmu.sei.annex.dmpl.dmpl.IntDimension;
import edu.cmu.sei.annex.dmpl.dmpl.IntExpr;
import edu.cmu.sei.annex.dmpl.dmpl.LVal;
import edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeExpr;
import edu.cmu.sei.annex.dmpl.dmpl.MultiplicativeOperator;
import edu.cmu.sei.annex.dmpl.dmpl.NestedStmt;
import edu.cmu.sei.annex.dmpl.dmpl.Node;
import edu.cmu.sei.annex.dmpl.dmpl.NodeBody;
import edu.cmu.sei.annex.dmpl.dmpl.NodeBodyElement;
import edu.cmu.sei.annex.dmpl.dmpl.NodeNoAttr;
import edu.cmu.sei.annex.dmpl.dmpl.NodeNumDimension;
import edu.cmu.sei.annex.dmpl.dmpl.NodeNumExpr;
import edu.cmu.sei.annex.dmpl.dmpl.NodeVarInit;
import edu.cmu.sei.annex.dmpl.dmpl.NodeVarScopeEnum;
import edu.cmu.sei.annex.dmpl.dmpl.NumberConst;
import edu.cmu.sei.annex.dmpl.dmpl.OrExpr;
import edu.cmu.sei.annex.dmpl.dmpl.Param;
import edu.cmu.sei.annex.dmpl.dmpl.ProcNoAttr;
import edu.cmu.sei.annex.dmpl.dmpl.Procedure;
import edu.cmu.sei.annex.dmpl.dmpl.Program;
import edu.cmu.sei.annex.dmpl.dmpl.ProgramElement;
import edu.cmu.sei.annex.dmpl.dmpl.RecordBlock;
import edu.cmu.sei.annex.dmpl.dmpl.RequireSpec;
import edu.cmu.sei.annex.dmpl.dmpl.ReturnValueStmt;
import edu.cmu.sei.annex.dmpl.dmpl.RoleBodyElement;
import edu.cmu.sei.annex.dmpl.dmpl.ShiftExpr;
import edu.cmu.sei.annex.dmpl.dmpl.ShiftOperator;
import edu.cmu.sei.annex.dmpl.dmpl.SignEnum;
import edu.cmu.sei.annex.dmpl.dmpl.SignedEnum;
import edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum;
import edu.cmu.sei.annex.dmpl.dmpl.SimpleRole;
import edu.cmu.sei.annex.dmpl.dmpl.SimpleStmt;
import edu.cmu.sei.annex.dmpl.dmpl.SimpleStmtKeywordEnum;
import edu.cmu.sei.annex.dmpl.dmpl.SpecNoAttr;
import edu.cmu.sei.annex.dmpl.dmpl.Stmt;
import edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr;
import edu.cmu.sei.annex.dmpl.dmpl.ThreadDeclaration;
import edu.cmu.sei.annex.dmpl.dmpl.Type;
import edu.cmu.sei.annex.dmpl.dmpl.UnaryExpr;
import edu.cmu.sei.annex.dmpl.dmpl.UnaryOperator;
import edu.cmu.sei.annex.dmpl.dmpl.Var;
import edu.cmu.sei.annex.dmpl.dmpl.VarAsgn;
import edu.cmu.sei.annex.dmpl.dmpl.VarBlock;
import edu.cmu.sei.annex.dmpl.dmpl.VarInit;
import edu.cmu.sei.annex.dmpl.dmpl.WhileStmt;
import edu.cmu.sei.annex.dmpl.dmpl.XorExpr;

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
  private EClass nodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nodeNoAttrEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass specNoAttrEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nodeBodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nodeBodyElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributableElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass roleBodyElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributableNoRoleElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass varBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nodeVarInitEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass varInitEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass varAsgnEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass varEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dimensionEClass = null;

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
  private EClass fnBodyEClass = null;

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
  private EClass attrListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attrEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass paramEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stmtEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignmentStmtEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lValEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass callExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass atEndSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass atLeastSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass requireSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleRoleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass idRoleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributableNoRoleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exprVarAsgnEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fnVarAsgnEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass intDimensionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nodeNumDimensionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass idDimensionEClass = null;

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
  private EClass nestedStmtEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass whileStmtEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forStmtEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass condStmtEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleStmtEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass returnValueStmtEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forAllStmtEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fadnpStmtEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ternaryExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass andExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bitwiseOrExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xorExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bitwiseAndExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass equalityExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass compareExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass shiftExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass additiveExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicativeExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass idExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass intExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass doubleExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nodeNumExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unaryExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass builtInExprEClass = null;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum simpleStmtKeywordEnumEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum forAllFunctionEnumEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum nodeVarScopeEnumEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum equalityOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum compareOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum shiftOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum additiveOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum multiplicativeOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum unaryOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum builtInFunctionEnumEEnum = null;

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
  public EClass getNode()
  {
    return nodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNode_Node()
  {
    return (EReference)nodeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNodeNoAttr()
  {
    return nodeNoAttrEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNodeNoAttr_Name()
  {
    return (EAttribute)nodeNoAttrEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeNoAttr_Body()
  {
    return (EReference)nodeNoAttrEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpecNoAttr()
  {
    return specNoAttrEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpecNoAttr_Name()
  {
    return (EAttribute)specNoAttrEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpecNoAttr_Function()
  {
    return (EAttribute)specNoAttrEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNodeBody()
  {
    return nodeBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeBody_Elements()
  {
    return (EReference)nodeBodyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNodeBodyElement()
  {
    return nodeBodyElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributableElement()
  {
    return attributableElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoleBodyElement()
  {
    return roleBodyElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributableNoRoleElement()
  {
    return attributableNoRoleElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVarBlock()
  {
    return varBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVarBlock_Override()
  {
    return (EAttribute)varBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVarBlock_Var()
  {
    return (EReference)varBlockEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordBlock()
  {
    return recordBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecordBlock_Override()
  {
    return (EAttribute)recordBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecordBlock_Name()
  {
    return (EAttribute)recordBlockEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordBlock_Vars()
  {
    return (EReference)recordBlockEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordBlock_EqualsBody()
  {
    return (EReference)recordBlockEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordBlock_ComplementBody()
  {
    return (EReference)recordBlockEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNodeVarInit()
  {
    return nodeVarInitEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNodeVarInit_Scope()
  {
    return (EAttribute)nodeVarInitEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeVarInit_Var()
  {
    return (EReference)nodeVarInitEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVarInit()
  {
    return varInitEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVarInit_Type()
  {
    return (EReference)varInitEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVarInit_VarAsgns()
  {
    return (EReference)varInitEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVarAsgn()
  {
    return varAsgnEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVarAsgn_Input()
  {
    return (EAttribute)varAsgnEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVarAsgn_Var()
  {
    return (EReference)varAsgnEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVar()
  {
    return varEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVar_Name()
  {
    return (EAttribute)varEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVar_Dimensions()
  {
    return (EReference)varEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDimension()
  {
    return dimensionEClass;
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
  public EClass getProcedure()
  {
    return procedureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProcedure_AttrList()
  {
    return (EReference)procedureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProcedure_Proc()
  {
    return (EReference)procedureEClass.getEStructuralFeatures().get(1);
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
  public EAttribute getProcNoAttr_Override()
  {
    return (EAttribute)procNoAttrEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProcNoAttr_Prototype()
  {
    return (EReference)procNoAttrEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProcNoAttr_FnBody()
  {
    return (EReference)procNoAttrEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFnBody()
  {
    return fnBodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFnBody_VarInits()
  {
    return (EReference)fnBodyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFnBody_Stmts()
  {
    return (EReference)fnBodyEClass.getEStructuralFeatures().get(1);
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
  public EAttribute getFnPrototype_Name()
  {
    return (EAttribute)fnPrototypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttrList()
  {
    return attrListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttrList_Attrs()
  {
    return (EReference)attrListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttr()
  {
    return attrEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttr_Name()
  {
    return (EAttribute)attrEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttr_Params()
  {
    return (EReference)attrEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParam()
  {
    return paramEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParam_Type()
  {
    return (EReference)paramEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParam_Var()
  {
    return (EReference)paramEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStmt()
  {
    return stmtEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssignmentStmt()
  {
    return assignmentStmtEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignmentStmt_Variable()
  {
    return (EReference)assignmentStmtEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignmentStmt_Value()
  {
    return (EReference)assignmentStmtEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLVal()
  {
    return lValEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLVal_Name()
  {
    return (EAttribute)lValEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLVal_Indices()
  {
    return (EReference)lValEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLVal_At()
  {
    return (EReference)lValEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpr()
  {
    return exprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCallExpr()
  {
    return callExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCallExpr_Namespace()
  {
    return (EAttribute)callExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCallExpr_Name()
  {
    return (EAttribute)callExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCallExpr_Args()
  {
    return (EReference)callExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCallExpr_At()
  {
    return (EReference)callExprEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAtEndSpec()
  {
    return atEndSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAtLeastSpec()
  {
    return atLeastSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAtLeastSpec_Threshold()
  {
    return (EReference)atLeastSpecEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRequireSpec()
  {
    return requireSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributable()
  {
    return attributableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributable_AttrList()
  {
    return (EReference)attributableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributable_Element()
  {
    return (EReference)attributableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleRole()
  {
    return simpleRoleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleRole_Name()
  {
    return (EAttribute)simpleRoleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSimpleRole_Elements()
  {
    return (EReference)simpleRoleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIdRole()
  {
    return idRoleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIdRole_Name()
  {
    return (EAttribute)idRoleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIdRole_Id()
  {
    return (EAttribute)idRoleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIdRole_Elements()
  {
    return (EReference)idRoleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributableNoRole()
  {
    return attributableNoRoleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributableNoRole_AttrList()
  {
    return (EReference)attributableNoRoleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributableNoRole_Element()
  {
    return (EReference)attributableNoRoleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExprVarAsgn()
  {
    return exprVarAsgnEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExprVarAsgn_Expr()
  {
    return (EReference)exprVarAsgnEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFnVarAsgn()
  {
    return fnVarAsgnEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFnVarAsgn_FnBody()
  {
    return (EReference)fnVarAsgnEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntDimension()
  {
    return intDimensionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIntDimension_Index()
  {
    return (EAttribute)intDimensionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNodeNumDimension()
  {
    return nodeNumDimensionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIdDimension()
  {
    return idDimensionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIdDimension_Index()
  {
    return (EAttribute)idDimensionEClass.getEStructuralFeatures().get(0);
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
  public EReference getFnPrototypeDeclaration_Params()
  {
    return (EReference)fnPrototypeDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedStmt()
  {
    return nestedStmtEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNestedStmt_Stmts()
  {
    return (EReference)nestedStmtEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWhileStmt()
  {
    return whileStmtEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWhileStmt_Condition()
  {
    return (EReference)whileStmtEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWhileStmt_Stmt()
  {
    return (EReference)whileStmtEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForStmt()
  {
    return forStmtEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForStmt_Inits()
  {
    return (EReference)forStmtEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForStmt_Condition()
  {
    return (EReference)forStmtEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForStmt_Update()
  {
    return (EReference)forStmtEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForStmt_Stmt()
  {
    return (EReference)forStmtEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCondStmt()
  {
    return condStmtEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCondStmt_AttrList()
  {
    return (EReference)condStmtEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCondStmt_Condition()
  {
    return (EReference)condStmtEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCondStmt_Then()
  {
    return (EReference)condStmtEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCondStmt_Else()
  {
    return (EReference)condStmtEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleStmt()
  {
    return simpleStmtEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleStmt_Name()
  {
    return (EAttribute)simpleStmtEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReturnValueStmt()
  {
    return returnValueStmtEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReturnValueStmt_Value()
  {
    return (EReference)returnValueStmtEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForAllStmt()
  {
    return forAllStmtEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getForAllStmt_Name()
  {
    return (EAttribute)forAllStmtEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getForAllStmt_Node()
  {
    return (EAttribute)forAllStmtEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForAllStmt_Stmt()
  {
    return (EReference)forAllStmtEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFadnpStmt()
  {
    return fadnpStmtEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFadnpStmt_Node1()
  {
    return (EAttribute)fadnpStmtEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFadnpStmt_Node2()
  {
    return (EAttribute)fadnpStmtEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFadnpStmt_Stmt()
  {
    return (EReference)fadnpStmtEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTernaryExpr()
  {
    return ternaryExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTernaryExpr_Condition()
  {
    return (EReference)ternaryExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTernaryExpr_Then()
  {
    return (EReference)ternaryExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTernaryExpr_Else()
  {
    return (EReference)ternaryExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrExpr()
  {
    return orExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrExpr_Left()
  {
    return (EReference)orExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrExpr_Right()
  {
    return (EReference)orExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndExpr()
  {
    return andExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpr_Left()
  {
    return (EReference)andExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpr_Right()
  {
    return (EReference)andExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBitwiseOrExpr()
  {
    return bitwiseOrExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseOrExpr_Left()
  {
    return (EReference)bitwiseOrExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseOrExpr_Right()
  {
    return (EReference)bitwiseOrExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXorExpr()
  {
    return xorExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXorExpr_Left()
  {
    return (EReference)xorExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXorExpr_Right()
  {
    return (EReference)xorExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBitwiseAndExpr()
  {
    return bitwiseAndExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseAndExpr_Left()
  {
    return (EReference)bitwiseAndExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseAndExpr_Right()
  {
    return (EReference)bitwiseAndExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEqualityExpr()
  {
    return equalityExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityExpr_Left()
  {
    return (EReference)equalityExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEqualityExpr_Operator()
  {
    return (EAttribute)equalityExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityExpr_Right()
  {
    return (EReference)equalityExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCompareExpr()
  {
    return compareExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompareExpr_Left()
  {
    return (EReference)compareExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCompareExpr_Operator()
  {
    return (EAttribute)compareExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompareExpr_Right()
  {
    return (EReference)compareExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShiftExpr()
  {
    return shiftExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShiftExpr_Left()
  {
    return (EReference)shiftExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShiftExpr_Operator()
  {
    return (EAttribute)shiftExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShiftExpr_Right()
  {
    return (EReference)shiftExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAdditiveExpr()
  {
    return additiveExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdditiveExpr_Left()
  {
    return (EReference)additiveExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAdditiveExpr_Operator()
  {
    return (EAttribute)additiveExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAdditiveExpr_Right()
  {
    return (EReference)additiveExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicativeExpr()
  {
    return multiplicativeExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplicativeExpr_Left()
  {
    return (EReference)multiplicativeExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicativeExpr_Operator()
  {
    return (EAttribute)multiplicativeExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplicativeExpr_Right()
  {
    return (EReference)multiplicativeExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIdExpr()
  {
    return idExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntExpr()
  {
    return intExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIntExpr_Value()
  {
    return (EAttribute)intExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDoubleExpr()
  {
    return doubleExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDoubleExpr_Value()
  {
    return (EAttribute)doubleExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNodeNumExpr()
  {
    return nodeNumExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnaryExpr()
  {
    return unaryExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnaryExpr_Operator()
  {
    return (EAttribute)unaryExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnaryExpr_Operand()
  {
    return (EReference)unaryExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBuiltInExpr()
  {
    return builtInExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBuiltInExpr_Function()
  {
    return (EAttribute)builtInExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBuiltInExpr_FirstArg()
  {
    return (EAttribute)builtInExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBuiltInExpr_SecondArg()
  {
    return (EReference)builtInExprEClass.getEStructuralFeatures().get(2);
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
  public EEnum getSimpleStmtKeywordEnum()
  {
    return simpleStmtKeywordEnumEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getForAllFunctionEnum()
  {
    return forAllFunctionEnumEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getNodeVarScopeEnum()
  {
    return nodeVarScopeEnumEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getEqualityOperator()
  {
    return equalityOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getCompareOperator()
  {
    return compareOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getShiftOperator()
  {
    return shiftOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAdditiveOperator()
  {
    return additiveOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getMultiplicativeOperator()
  {
    return multiplicativeOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getUnaryOperator()
  {
    return unaryOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getBuiltInFunctionEnum()
  {
    return builtInFunctionEnumEEnum;
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

    nodeEClass = createEClass(NODE);
    createEReference(nodeEClass, NODE__NODE);

    nodeNoAttrEClass = createEClass(NODE_NO_ATTR);
    createEAttribute(nodeNoAttrEClass, NODE_NO_ATTR__NAME);
    createEReference(nodeNoAttrEClass, NODE_NO_ATTR__BODY);

    specNoAttrEClass = createEClass(SPEC_NO_ATTR);
    createEAttribute(specNoAttrEClass, SPEC_NO_ATTR__NAME);
    createEAttribute(specNoAttrEClass, SPEC_NO_ATTR__FUNCTION);

    nodeBodyEClass = createEClass(NODE_BODY);
    createEReference(nodeBodyEClass, NODE_BODY__ELEMENTS);

    nodeBodyElementEClass = createEClass(NODE_BODY_ELEMENT);

    attributableElementEClass = createEClass(ATTRIBUTABLE_ELEMENT);

    roleBodyElementEClass = createEClass(ROLE_BODY_ELEMENT);

    attributableNoRoleElementEClass = createEClass(ATTRIBUTABLE_NO_ROLE_ELEMENT);

    varBlockEClass = createEClass(VAR_BLOCK);
    createEAttribute(varBlockEClass, VAR_BLOCK__OVERRIDE);
    createEReference(varBlockEClass, VAR_BLOCK__VAR);

    recordBlockEClass = createEClass(RECORD_BLOCK);
    createEAttribute(recordBlockEClass, RECORD_BLOCK__OVERRIDE);
    createEAttribute(recordBlockEClass, RECORD_BLOCK__NAME);
    createEReference(recordBlockEClass, RECORD_BLOCK__VARS);
    createEReference(recordBlockEClass, RECORD_BLOCK__EQUALS_BODY);
    createEReference(recordBlockEClass, RECORD_BLOCK__COMPLEMENT_BODY);

    nodeVarInitEClass = createEClass(NODE_VAR_INIT);
    createEAttribute(nodeVarInitEClass, NODE_VAR_INIT__SCOPE);
    createEReference(nodeVarInitEClass, NODE_VAR_INIT__VAR);

    varInitEClass = createEClass(VAR_INIT);
    createEReference(varInitEClass, VAR_INIT__TYPE);
    createEReference(varInitEClass, VAR_INIT__VAR_ASGNS);

    varAsgnEClass = createEClass(VAR_ASGN);
    createEAttribute(varAsgnEClass, VAR_ASGN__INPUT);
    createEReference(varAsgnEClass, VAR_ASGN__VAR);

    varEClass = createEClass(VAR);
    createEAttribute(varEClass, VAR__NAME);
    createEReference(varEClass, VAR__DIMENSIONS);

    dimensionEClass = createEClass(DIMENSION);

    typeEClass = createEClass(TYPE);
    createEAttribute(typeEClass, TYPE__SIGNED);
    createEAttribute(typeEClass, TYPE__SIMP_TYPE);

    procedureEClass = createEClass(PROCEDURE);
    createEReference(procedureEClass, PROCEDURE__ATTR_LIST);
    createEReference(procedureEClass, PROCEDURE__PROC);

    procNoAttrEClass = createEClass(PROC_NO_ATTR);
    createEAttribute(procNoAttrEClass, PROC_NO_ATTR__OVERRIDE);
    createEReference(procNoAttrEClass, PROC_NO_ATTR__PROTOTYPE);
    createEReference(procNoAttrEClass, PROC_NO_ATTR__FN_BODY);

    fnBodyEClass = createEClass(FN_BODY);
    createEReference(fnBodyEClass, FN_BODY__VAR_INITS);
    createEReference(fnBodyEClass, FN_BODY__STMTS);

    fnPrototypeEClass = createEClass(FN_PROTOTYPE);
    createEAttribute(fnPrototypeEClass, FN_PROTOTYPE__EXTERN);
    createEAttribute(fnPrototypeEClass, FN_PROTOTYPE__PURE);
    createEAttribute(fnPrototypeEClass, FN_PROTOTYPE__NAME);

    attrListEClass = createEClass(ATTR_LIST);
    createEReference(attrListEClass, ATTR_LIST__ATTRS);

    attrEClass = createEClass(ATTR);
    createEAttribute(attrEClass, ATTR__NAME);
    createEReference(attrEClass, ATTR__PARAMS);

    paramEClass = createEClass(PARAM);
    createEReference(paramEClass, PARAM__TYPE);
    createEReference(paramEClass, PARAM__VAR);

    stmtEClass = createEClass(STMT);

    assignmentStmtEClass = createEClass(ASSIGNMENT_STMT);
    createEReference(assignmentStmtEClass, ASSIGNMENT_STMT__VARIABLE);
    createEReference(assignmentStmtEClass, ASSIGNMENT_STMT__VALUE);

    lValEClass = createEClass(LVAL);
    createEAttribute(lValEClass, LVAL__NAME);
    createEReference(lValEClass, LVAL__INDICES);
    createEReference(lValEClass, LVAL__AT);

    exprEClass = createEClass(EXPR);

    callExprEClass = createEClass(CALL_EXPR);
    createEAttribute(callExprEClass, CALL_EXPR__NAMESPACE);
    createEAttribute(callExprEClass, CALL_EXPR__NAME);
    createEReference(callExprEClass, CALL_EXPR__ARGS);
    createEReference(callExprEClass, CALL_EXPR__AT);

    atEndSpecEClass = createEClass(AT_END_SPEC);

    atLeastSpecEClass = createEClass(AT_LEAST_SPEC);
    createEReference(atLeastSpecEClass, AT_LEAST_SPEC__THRESHOLD);

    requireSpecEClass = createEClass(REQUIRE_SPEC);

    attributableEClass = createEClass(ATTRIBUTABLE);
    createEReference(attributableEClass, ATTRIBUTABLE__ATTR_LIST);
    createEReference(attributableEClass, ATTRIBUTABLE__ELEMENT);

    simpleRoleEClass = createEClass(SIMPLE_ROLE);
    createEAttribute(simpleRoleEClass, SIMPLE_ROLE__NAME);
    createEReference(simpleRoleEClass, SIMPLE_ROLE__ELEMENTS);

    idRoleEClass = createEClass(ID_ROLE);
    createEAttribute(idRoleEClass, ID_ROLE__NAME);
    createEAttribute(idRoleEClass, ID_ROLE__ID);
    createEReference(idRoleEClass, ID_ROLE__ELEMENTS);

    attributableNoRoleEClass = createEClass(ATTRIBUTABLE_NO_ROLE);
    createEReference(attributableNoRoleEClass, ATTRIBUTABLE_NO_ROLE__ATTR_LIST);
    createEReference(attributableNoRoleEClass, ATTRIBUTABLE_NO_ROLE__ELEMENT);

    exprVarAsgnEClass = createEClass(EXPR_VAR_ASGN);
    createEReference(exprVarAsgnEClass, EXPR_VAR_ASGN__EXPR);

    fnVarAsgnEClass = createEClass(FN_VAR_ASGN);
    createEReference(fnVarAsgnEClass, FN_VAR_ASGN__FN_BODY);

    intDimensionEClass = createEClass(INT_DIMENSION);
    createEAttribute(intDimensionEClass, INT_DIMENSION__INDEX);

    nodeNumDimensionEClass = createEClass(NODE_NUM_DIMENSION);

    idDimensionEClass = createEClass(ID_DIMENSION);
    createEAttribute(idDimensionEClass, ID_DIMENSION__INDEX);

    threadDeclarationEClass = createEClass(THREAD_DECLARATION);

    fnPrototypeDeclarationEClass = createEClass(FN_PROTOTYPE_DECLARATION);
    createEReference(fnPrototypeDeclarationEClass, FN_PROTOTYPE_DECLARATION__TYPE);
    createEReference(fnPrototypeDeclarationEClass, FN_PROTOTYPE_DECLARATION__PARAMS);

    nestedStmtEClass = createEClass(NESTED_STMT);
    createEReference(nestedStmtEClass, NESTED_STMT__STMTS);

    whileStmtEClass = createEClass(WHILE_STMT);
    createEReference(whileStmtEClass, WHILE_STMT__CONDITION);
    createEReference(whileStmtEClass, WHILE_STMT__STMT);

    forStmtEClass = createEClass(FOR_STMT);
    createEReference(forStmtEClass, FOR_STMT__INITS);
    createEReference(forStmtEClass, FOR_STMT__CONDITION);
    createEReference(forStmtEClass, FOR_STMT__UPDATE);
    createEReference(forStmtEClass, FOR_STMT__STMT);

    condStmtEClass = createEClass(COND_STMT);
    createEReference(condStmtEClass, COND_STMT__ATTR_LIST);
    createEReference(condStmtEClass, COND_STMT__CONDITION);
    createEReference(condStmtEClass, COND_STMT__THEN);
    createEReference(condStmtEClass, COND_STMT__ELSE);

    simpleStmtEClass = createEClass(SIMPLE_STMT);
    createEAttribute(simpleStmtEClass, SIMPLE_STMT__NAME);

    returnValueStmtEClass = createEClass(RETURN_VALUE_STMT);
    createEReference(returnValueStmtEClass, RETURN_VALUE_STMT__VALUE);

    forAllStmtEClass = createEClass(FOR_ALL_STMT);
    createEAttribute(forAllStmtEClass, FOR_ALL_STMT__NAME);
    createEAttribute(forAllStmtEClass, FOR_ALL_STMT__NODE);
    createEReference(forAllStmtEClass, FOR_ALL_STMT__STMT);

    fadnpStmtEClass = createEClass(FADNP_STMT);
    createEAttribute(fadnpStmtEClass, FADNP_STMT__NODE1);
    createEAttribute(fadnpStmtEClass, FADNP_STMT__NODE2);
    createEReference(fadnpStmtEClass, FADNP_STMT__STMT);

    ternaryExprEClass = createEClass(TERNARY_EXPR);
    createEReference(ternaryExprEClass, TERNARY_EXPR__CONDITION);
    createEReference(ternaryExprEClass, TERNARY_EXPR__THEN);
    createEReference(ternaryExprEClass, TERNARY_EXPR__ELSE);

    orExprEClass = createEClass(OR_EXPR);
    createEReference(orExprEClass, OR_EXPR__LEFT);
    createEReference(orExprEClass, OR_EXPR__RIGHT);

    andExprEClass = createEClass(AND_EXPR);
    createEReference(andExprEClass, AND_EXPR__LEFT);
    createEReference(andExprEClass, AND_EXPR__RIGHT);

    bitwiseOrExprEClass = createEClass(BITWISE_OR_EXPR);
    createEReference(bitwiseOrExprEClass, BITWISE_OR_EXPR__LEFT);
    createEReference(bitwiseOrExprEClass, BITWISE_OR_EXPR__RIGHT);

    xorExprEClass = createEClass(XOR_EXPR);
    createEReference(xorExprEClass, XOR_EXPR__LEFT);
    createEReference(xorExprEClass, XOR_EXPR__RIGHT);

    bitwiseAndExprEClass = createEClass(BITWISE_AND_EXPR);
    createEReference(bitwiseAndExprEClass, BITWISE_AND_EXPR__LEFT);
    createEReference(bitwiseAndExprEClass, BITWISE_AND_EXPR__RIGHT);

    equalityExprEClass = createEClass(EQUALITY_EXPR);
    createEReference(equalityExprEClass, EQUALITY_EXPR__LEFT);
    createEAttribute(equalityExprEClass, EQUALITY_EXPR__OPERATOR);
    createEReference(equalityExprEClass, EQUALITY_EXPR__RIGHT);

    compareExprEClass = createEClass(COMPARE_EXPR);
    createEReference(compareExprEClass, COMPARE_EXPR__LEFT);
    createEAttribute(compareExprEClass, COMPARE_EXPR__OPERATOR);
    createEReference(compareExprEClass, COMPARE_EXPR__RIGHT);

    shiftExprEClass = createEClass(SHIFT_EXPR);
    createEReference(shiftExprEClass, SHIFT_EXPR__LEFT);
    createEAttribute(shiftExprEClass, SHIFT_EXPR__OPERATOR);
    createEReference(shiftExprEClass, SHIFT_EXPR__RIGHT);

    additiveExprEClass = createEClass(ADDITIVE_EXPR);
    createEReference(additiveExprEClass, ADDITIVE_EXPR__LEFT);
    createEAttribute(additiveExprEClass, ADDITIVE_EXPR__OPERATOR);
    createEReference(additiveExprEClass, ADDITIVE_EXPR__RIGHT);

    multiplicativeExprEClass = createEClass(MULTIPLICATIVE_EXPR);
    createEReference(multiplicativeExprEClass, MULTIPLICATIVE_EXPR__LEFT);
    createEAttribute(multiplicativeExprEClass, MULTIPLICATIVE_EXPR__OPERATOR);
    createEReference(multiplicativeExprEClass, MULTIPLICATIVE_EXPR__RIGHT);

    idExprEClass = createEClass(ID_EXPR);

    intExprEClass = createEClass(INT_EXPR);
    createEAttribute(intExprEClass, INT_EXPR__VALUE);

    doubleExprEClass = createEClass(DOUBLE_EXPR);
    createEAttribute(doubleExprEClass, DOUBLE_EXPR__VALUE);

    nodeNumExprEClass = createEClass(NODE_NUM_EXPR);

    unaryExprEClass = createEClass(UNARY_EXPR);
    createEAttribute(unaryExprEClass, UNARY_EXPR__OPERATOR);
    createEReference(unaryExprEClass, UNARY_EXPR__OPERAND);

    builtInExprEClass = createEClass(BUILT_IN_EXPR);
    createEAttribute(builtInExprEClass, BUILT_IN_EXPR__FUNCTION);
    createEAttribute(builtInExprEClass, BUILT_IN_EXPR__FIRST_ARG);
    createEReference(builtInExprEClass, BUILT_IN_EXPR__SECOND_ARG);

    // Create enums
    signEnumEEnum = createEEnum(SIGN_ENUM);
    simpTypeEnumEEnum = createEEnum(SIMP_TYPE_ENUM);
    signedEnumEEnum = createEEnum(SIGNED_ENUM);
    simpleStmtKeywordEnumEEnum = createEEnum(SIMPLE_STMT_KEYWORD_ENUM);
    forAllFunctionEnumEEnum = createEEnum(FOR_ALL_FUNCTION_ENUM);
    nodeVarScopeEnumEEnum = createEEnum(NODE_VAR_SCOPE_ENUM);
    equalityOperatorEEnum = createEEnum(EQUALITY_OPERATOR);
    compareOperatorEEnum = createEEnum(COMPARE_OPERATOR);
    shiftOperatorEEnum = createEEnum(SHIFT_OPERATOR);
    additiveOperatorEEnum = createEEnum(ADDITIVE_OPERATOR);
    multiplicativeOperatorEEnum = createEEnum(MULTIPLICATIVE_OPERATOR);
    unaryOperatorEEnum = createEEnum(UNARY_OPERATOR);
    builtInFunctionEnumEEnum = createEEnum(BUILT_IN_FUNCTION_ENUM);
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
    nodeEClass.getESuperTypes().add(this.getProgramElement());
    specNoAttrEClass.getESuperTypes().add(this.getAttributableElement());
    specNoAttrEClass.getESuperTypes().add(this.getAttributableNoRoleElement());
    varBlockEClass.getESuperTypes().add(this.getNodeBodyElement());
    varBlockEClass.getESuperTypes().add(this.getRoleBodyElement());
    recordBlockEClass.getESuperTypes().add(this.getNodeBodyElement());
    recordBlockEClass.getESuperTypes().add(this.getRoleBodyElement());
    procedureEClass.getESuperTypes().add(this.getProgramElement());
    procNoAttrEClass.getESuperTypes().add(this.getAttributableElement());
    procNoAttrEClass.getESuperTypes().add(this.getAttributableNoRoleElement());
    assignmentStmtEClass.getESuperTypes().add(this.getStmt());
    lValEClass.getESuperTypes().add(this.getExpr());
    callExprEClass.getESuperTypes().add(this.getStmt());
    callExprEClass.getESuperTypes().add(this.getExpr());
    atEndSpecEClass.getESuperTypes().add(this.getSpecNoAttr());
    atLeastSpecEClass.getESuperTypes().add(this.getSpecNoAttr());
    requireSpecEClass.getESuperTypes().add(this.getSpecNoAttr());
    attributableEClass.getESuperTypes().add(this.getNodeBodyElement());
    simpleRoleEClass.getESuperTypes().add(this.getAttributableElement());
    idRoleEClass.getESuperTypes().add(this.getAttributableElement());
    attributableNoRoleEClass.getESuperTypes().add(this.getRoleBodyElement());
    exprVarAsgnEClass.getESuperTypes().add(this.getVarAsgn());
    fnVarAsgnEClass.getESuperTypes().add(this.getVarAsgn());
    intDimensionEClass.getESuperTypes().add(this.getDimension());
    nodeNumDimensionEClass.getESuperTypes().add(this.getDimension());
    idDimensionEClass.getESuperTypes().add(this.getDimension());
    threadDeclarationEClass.getESuperTypes().add(this.getFnPrototype());
    fnPrototypeDeclarationEClass.getESuperTypes().add(this.getFnPrototype());
    nestedStmtEClass.getESuperTypes().add(this.getStmt());
    whileStmtEClass.getESuperTypes().add(this.getStmt());
    forStmtEClass.getESuperTypes().add(this.getStmt());
    condStmtEClass.getESuperTypes().add(this.getStmt());
    simpleStmtEClass.getESuperTypes().add(this.getStmt());
    returnValueStmtEClass.getESuperTypes().add(this.getStmt());
    forAllStmtEClass.getESuperTypes().add(this.getStmt());
    fadnpStmtEClass.getESuperTypes().add(this.getStmt());
    ternaryExprEClass.getESuperTypes().add(this.getExpr());
    orExprEClass.getESuperTypes().add(this.getExpr());
    andExprEClass.getESuperTypes().add(this.getExpr());
    bitwiseOrExprEClass.getESuperTypes().add(this.getExpr());
    xorExprEClass.getESuperTypes().add(this.getExpr());
    bitwiseAndExprEClass.getESuperTypes().add(this.getExpr());
    equalityExprEClass.getESuperTypes().add(this.getExpr());
    compareExprEClass.getESuperTypes().add(this.getExpr());
    shiftExprEClass.getESuperTypes().add(this.getExpr());
    additiveExprEClass.getESuperTypes().add(this.getExpr());
    multiplicativeExprEClass.getESuperTypes().add(this.getExpr());
    idExprEClass.getESuperTypes().add(this.getExpr());
    intExprEClass.getESuperTypes().add(this.getExpr());
    doubleExprEClass.getESuperTypes().add(this.getExpr());
    nodeNumExprEClass.getESuperTypes().add(this.getExpr());
    unaryExprEClass.getESuperTypes().add(this.getExpr());
    builtInExprEClass.getESuperTypes().add(this.getExpr());

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

    initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNode_Node(), this.getNodeNoAttr(), null, "node", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodeNoAttrEClass, NodeNoAttr.class, "NodeNoAttr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNodeNoAttr_Name(), ecorePackage.getEString(), "name", null, 0, 1, NodeNoAttr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeNoAttr_Body(), this.getNodeBody(), null, "body", null, 0, 1, NodeNoAttr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(specNoAttrEClass, SpecNoAttr.class, "SpecNoAttr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSpecNoAttr_Name(), ecorePackage.getEString(), "name", null, 0, 1, SpecNoAttr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSpecNoAttr_Function(), ecorePackage.getEString(), "function", null, 0, 1, SpecNoAttr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodeBodyEClass, NodeBody.class, "NodeBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNodeBody_Elements(), this.getNodeBodyElement(), null, "elements", null, 0, -1, NodeBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodeBodyElementEClass, NodeBodyElement.class, "NodeBodyElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(attributableElementEClass, AttributableElement.class, "AttributableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(roleBodyElementEClass, RoleBodyElement.class, "RoleBodyElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(attributableNoRoleElementEClass, AttributableNoRoleElement.class, "AttributableNoRoleElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(varBlockEClass, VarBlock.class, "VarBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVarBlock_Override(), ecorePackage.getEBoolean(), "override", null, 0, 1, VarBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVarBlock_Var(), this.getNodeVarInit(), null, "var", null, 0, 1, VarBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recordBlockEClass, RecordBlock.class, "RecordBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRecordBlock_Override(), ecorePackage.getEBoolean(), "override", null, 0, 1, RecordBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRecordBlock_Name(), ecorePackage.getEString(), "name", null, 0, 1, RecordBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordBlock_Vars(), this.getNodeVarInit(), null, "vars", null, 0, -1, RecordBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordBlock_EqualsBody(), this.getFnBody(), null, "equalsBody", null, 0, 1, RecordBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordBlock_ComplementBody(), this.getFnBody(), null, "complementBody", null, 0, 1, RecordBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodeVarInitEClass, NodeVarInit.class, "NodeVarInit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNodeVarInit_Scope(), this.getNodeVarScopeEnum(), "scope", null, 0, 1, NodeVarInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeVarInit_Var(), this.getVarInit(), null, "var", null, 0, 1, NodeVarInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(varInitEClass, VarInit.class, "VarInit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVarInit_Type(), this.getType(), null, "type", null, 0, 1, VarInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVarInit_VarAsgns(), this.getVarAsgn(), null, "varAsgns", null, 0, -1, VarInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(varAsgnEClass, VarAsgn.class, "VarAsgn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVarAsgn_Input(), ecorePackage.getEBoolean(), "input", null, 0, 1, VarAsgn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVarAsgn_Var(), this.getVar(), null, "var", null, 0, 1, VarAsgn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(varEClass, Var.class, "Var", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVar_Name(), ecorePackage.getEString(), "name", null, 0, 1, Var.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVar_Dimensions(), this.getDimension(), null, "dimensions", null, 0, -1, Var.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dimensionEClass, Dimension.class, "Dimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getType_Signed(), this.getSignedEnum(), "signed", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getType_SimpType(), this.getSimpTypeEnum(), "simpType", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(procedureEClass, Procedure.class, "Procedure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProcedure_AttrList(), this.getAttrList(), null, "attrList", null, 0, 1, Procedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProcedure_Proc(), this.getProcNoAttr(), null, "proc", null, 0, 1, Procedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(procNoAttrEClass, ProcNoAttr.class, "ProcNoAttr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getProcNoAttr_Override(), ecorePackage.getEBoolean(), "override", null, 0, 1, ProcNoAttr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProcNoAttr_Prototype(), this.getFnPrototype(), null, "prototype", null, 0, 1, ProcNoAttr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProcNoAttr_FnBody(), this.getFnBody(), null, "fnBody", null, 0, 1, ProcNoAttr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fnBodyEClass, FnBody.class, "FnBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFnBody_VarInits(), this.getVarInit(), null, "varInits", null, 0, -1, FnBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFnBody_Stmts(), this.getStmt(), null, "stmts", null, 0, -1, FnBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fnPrototypeEClass, FnPrototype.class, "FnPrototype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFnPrototype_Extern(), ecorePackage.getEBoolean(), "extern", null, 0, 1, FnPrototype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFnPrototype_Pure(), ecorePackage.getEBoolean(), "pure", null, 0, 1, FnPrototype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFnPrototype_Name(), ecorePackage.getEString(), "name", null, 0, 1, FnPrototype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attrListEClass, AttrList.class, "AttrList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAttrList_Attrs(), this.getAttr(), null, "attrs", null, 0, -1, AttrList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attrEClass, Attr.class, "Attr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAttr_Name(), ecorePackage.getEString(), "name", null, 0, 1, Attr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttr_Params(), this.getExpr(), null, "params", null, 0, -1, Attr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(paramEClass, Param.class, "Param", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParam_Type(), this.getType(), null, "type", null, 0, 1, Param.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParam_Var(), this.getVar(), null, "var", null, 0, 1, Param.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stmtEClass, Stmt.class, "Stmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(assignmentStmtEClass, AssignmentStmt.class, "AssignmentStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssignmentStmt_Variable(), this.getLVal(), null, "variable", null, 0, 1, AssignmentStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignmentStmt_Value(), this.getExpr(), null, "value", null, 0, 1, AssignmentStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lValEClass, LVal.class, "LVal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLVal_Name(), ecorePackage.getEString(), "name", null, 0, 1, LVal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLVal_Indices(), this.getExpr(), null, "indices", null, 0, -1, LVal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLVal_At(), this.getExpr(), null, "at", null, 0, 1, LVal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(exprEClass, Expr.class, "Expr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(callExprEClass, CallExpr.class, "CallExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCallExpr_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, CallExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCallExpr_Name(), ecorePackage.getEString(), "name", null, 0, 1, CallExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCallExpr_Args(), this.getExpr(), null, "args", null, 0, -1, CallExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCallExpr_At(), this.getExpr(), null, "at", null, 0, 1, CallExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(atEndSpecEClass, AtEndSpec.class, "AtEndSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(atLeastSpecEClass, AtLeastSpec.class, "AtLeastSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAtLeastSpec_Threshold(), this.getDoubleConst(), null, "threshold", null, 0, 1, AtLeastSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(requireSpecEClass, RequireSpec.class, "RequireSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(attributableEClass, Attributable.class, "Attributable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAttributable_AttrList(), this.getAttrList(), null, "attrList", null, 0, 1, Attributable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttributable_Element(), this.getAttributableElement(), null, "element", null, 0, 1, Attributable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleRoleEClass, SimpleRole.class, "SimpleRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleRole_Name(), ecorePackage.getEString(), "name", null, 0, 1, SimpleRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSimpleRole_Elements(), this.getRoleBodyElement(), null, "elements", null, 0, -1, SimpleRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(idRoleEClass, IdRole.class, "IdRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIdRole_Name(), ecorePackage.getEString(), "name", null, 0, 1, IdRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIdRole_Id(), ecorePackage.getEInt(), "id", null, 0, 1, IdRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIdRole_Elements(), this.getRoleBodyElement(), null, "elements", null, 0, -1, IdRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributableNoRoleEClass, AttributableNoRole.class, "AttributableNoRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAttributableNoRole_AttrList(), this.getAttrList(), null, "attrList", null, 0, 1, AttributableNoRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttributableNoRole_Element(), this.getAttributableNoRoleElement(), null, "element", null, 0, 1, AttributableNoRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(exprVarAsgnEClass, ExprVarAsgn.class, "ExprVarAsgn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExprVarAsgn_Expr(), this.getExpr(), null, "expr", null, 0, 1, ExprVarAsgn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fnVarAsgnEClass, FnVarAsgn.class, "FnVarAsgn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFnVarAsgn_FnBody(), this.getFnBody(), null, "fnBody", null, 0, 1, FnVarAsgn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(intDimensionEClass, IntDimension.class, "IntDimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIntDimension_Index(), ecorePackage.getEInt(), "index", null, 0, 1, IntDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodeNumDimensionEClass, NodeNumDimension.class, "NodeNumDimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(idDimensionEClass, IdDimension.class, "IdDimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIdDimension_Index(), ecorePackage.getEString(), "index", null, 0, 1, IdDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(threadDeclarationEClass, ThreadDeclaration.class, "ThreadDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(fnPrototypeDeclarationEClass, FnPrototypeDeclaration.class, "FnPrototypeDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFnPrototypeDeclaration_Type(), this.getType(), null, "type", null, 0, 1, FnPrototypeDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFnPrototypeDeclaration_Params(), this.getParam(), null, "params", null, 0, -1, FnPrototypeDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nestedStmtEClass, NestedStmt.class, "NestedStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNestedStmt_Stmts(), this.getStmt(), null, "stmts", null, 0, -1, NestedStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(whileStmtEClass, WhileStmt.class, "WhileStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWhileStmt_Condition(), this.getExpr(), null, "condition", null, 0, 1, WhileStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWhileStmt_Stmt(), this.getStmt(), null, "stmt", null, 0, 1, WhileStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(forStmtEClass, ForStmt.class, "ForStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getForStmt_Inits(), this.getAssignmentStmt(), null, "inits", null, 0, -1, ForStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForStmt_Condition(), this.getExpr(), null, "condition", null, 0, 1, ForStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForStmt_Update(), this.getAssignmentStmt(), null, "update", null, 0, 1, ForStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForStmt_Stmt(), this.getStmt(), null, "stmt", null, 0, 1, ForStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(condStmtEClass, CondStmt.class, "CondStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCondStmt_AttrList(), this.getAttrList(), null, "attrList", null, 0, 1, CondStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCondStmt_Condition(), this.getExpr(), null, "condition", null, 0, 1, CondStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCondStmt_Then(), this.getStmt(), null, "then", null, 0, 1, CondStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCondStmt_Else(), this.getStmt(), null, "else", null, 0, 1, CondStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleStmtEClass, SimpleStmt.class, "SimpleStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleStmt_Name(), this.getSimpleStmtKeywordEnum(), "name", null, 0, 1, SimpleStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(returnValueStmtEClass, ReturnValueStmt.class, "ReturnValueStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReturnValueStmt_Value(), this.getExpr(), null, "value", null, 0, 1, ReturnValueStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(forAllStmtEClass, ForAllStmt.class, "ForAllStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getForAllStmt_Name(), this.getForAllFunctionEnum(), "name", null, 0, 1, ForAllStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getForAllStmt_Node(), ecorePackage.getEString(), "node", null, 0, 1, ForAllStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForAllStmt_Stmt(), this.getStmt(), null, "stmt", null, 0, 1, ForAllStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fadnpStmtEClass, FadnpStmt.class, "FadnpStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFadnpStmt_Node1(), ecorePackage.getEString(), "node1", null, 0, 1, FadnpStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFadnpStmt_Node2(), ecorePackage.getEString(), "node2", null, 0, 1, FadnpStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFadnpStmt_Stmt(), this.getStmt(), null, "stmt", null, 0, 1, FadnpStmt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ternaryExprEClass, TernaryExpr.class, "TernaryExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTernaryExpr_Condition(), this.getExpr(), null, "condition", null, 0, 1, TernaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTernaryExpr_Then(), this.getExpr(), null, "then", null, 0, 1, TernaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTernaryExpr_Else(), this.getExpr(), null, "else", null, 0, 1, TernaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(orExprEClass, OrExpr.class, "OrExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOrExpr_Left(), this.getExpr(), null, "left", null, 0, 1, OrExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOrExpr_Right(), this.getExpr(), null, "right", null, 0, 1, OrExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(andExprEClass, AndExpr.class, "AndExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAndExpr_Left(), this.getExpr(), null, "left", null, 0, 1, AndExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAndExpr_Right(), this.getExpr(), null, "right", null, 0, 1, AndExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bitwiseOrExprEClass, BitwiseOrExpr.class, "BitwiseOrExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBitwiseOrExpr_Left(), this.getExpr(), null, "left", null, 0, 1, BitwiseOrExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBitwiseOrExpr_Right(), this.getExpr(), null, "right", null, 0, 1, BitwiseOrExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xorExprEClass, XorExpr.class, "XorExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXorExpr_Left(), this.getExpr(), null, "left", null, 0, 1, XorExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXorExpr_Right(), this.getExpr(), null, "right", null, 0, 1, XorExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bitwiseAndExprEClass, BitwiseAndExpr.class, "BitwiseAndExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBitwiseAndExpr_Left(), this.getExpr(), null, "left", null, 0, 1, BitwiseAndExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBitwiseAndExpr_Right(), this.getExpr(), null, "right", null, 0, 1, BitwiseAndExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(equalityExprEClass, EqualityExpr.class, "EqualityExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEqualityExpr_Left(), this.getExpr(), null, "left", null, 0, 1, EqualityExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEqualityExpr_Operator(), this.getEqualityOperator(), "operator", null, 0, 1, EqualityExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEqualityExpr_Right(), this.getExpr(), null, "right", null, 0, 1, EqualityExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(compareExprEClass, CompareExpr.class, "CompareExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCompareExpr_Left(), this.getExpr(), null, "left", null, 0, 1, CompareExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCompareExpr_Operator(), this.getCompareOperator(), "operator", null, 0, 1, CompareExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCompareExpr_Right(), this.getExpr(), null, "right", null, 0, 1, CompareExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(shiftExprEClass, ShiftExpr.class, "ShiftExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getShiftExpr_Left(), this.getExpr(), null, "left", null, 0, 1, ShiftExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getShiftExpr_Operator(), this.getShiftOperator(), "operator", null, 0, 1, ShiftExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getShiftExpr_Right(), this.getExpr(), null, "right", null, 0, 1, ShiftExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(additiveExprEClass, AdditiveExpr.class, "AdditiveExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAdditiveExpr_Left(), this.getExpr(), null, "left", null, 0, 1, AdditiveExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAdditiveExpr_Operator(), this.getAdditiveOperator(), "operator", null, 0, 1, AdditiveExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAdditiveExpr_Right(), this.getExpr(), null, "right", null, 0, 1, AdditiveExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiplicativeExprEClass, MultiplicativeExpr.class, "MultiplicativeExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMultiplicativeExpr_Left(), this.getExpr(), null, "left", null, 0, 1, MultiplicativeExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMultiplicativeExpr_Operator(), this.getMultiplicativeOperator(), "operator", null, 0, 1, MultiplicativeExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMultiplicativeExpr_Right(), this.getExpr(), null, "right", null, 0, 1, MultiplicativeExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(idExprEClass, IdExpr.class, "IdExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(intExprEClass, IntExpr.class, "IntExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIntExpr_Value(), ecorePackage.getEInt(), "value", null, 0, 1, IntExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(doubleExprEClass, DoubleExpr.class, "DoubleExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDoubleExpr_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, DoubleExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodeNumExprEClass, NodeNumExpr.class, "NodeNumExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unaryExprEClass, UnaryExpr.class, "UnaryExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnaryExpr_Operator(), this.getUnaryOperator(), "operator", null, 0, 1, UnaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnaryExpr_Operand(), this.getExpr(), null, "operand", null, 0, 1, UnaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(builtInExprEClass, BuiltInExpr.class, "BuiltInExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBuiltInExpr_Function(), this.getBuiltInFunctionEnum(), "function", null, 0, 1, BuiltInExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBuiltInExpr_FirstArg(), ecorePackage.getEString(), "firstArg", null, 0, 1, BuiltInExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBuiltInExpr_SecondArg(), this.getExpr(), null, "secondArg", null, 0, 1, BuiltInExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

    initEEnum(simpleStmtKeywordEnumEEnum, SimpleStmtKeywordEnum.class, "SimpleStmtKeywordEnum");
    addEEnumLiteral(simpleStmtKeywordEnumEEnum, SimpleStmtKeywordEnum.BREAK);
    addEEnumLiteral(simpleStmtKeywordEnumEEnum, SimpleStmtKeywordEnum.CONTINUE);
    addEEnumLiteral(simpleStmtKeywordEnumEEnum, SimpleStmtKeywordEnum.RETURN);

    initEEnum(forAllFunctionEnumEEnum, ForAllFunctionEnum.class, "ForAllFunctionEnum");
    addEEnumLiteral(forAllFunctionEnumEEnum, ForAllFunctionEnum.FORALL_NODE);
    addEEnumLiteral(forAllFunctionEnumEEnum, ForAllFunctionEnum.FORALL_OTHER);
    addEEnumLiteral(forAllFunctionEnumEEnum, ForAllFunctionEnum.FORALL_OTHER_LOWER);
    addEEnumLiteral(forAllFunctionEnumEEnum, ForAllFunctionEnum.FORALL_OTHER_HIGHER);

    initEEnum(nodeVarScopeEnumEEnum, NodeVarScopeEnum.class, "NodeVarScopeEnum");
    addEEnumLiteral(nodeVarScopeEnumEEnum, NodeVarScopeEnum.GLOBAL);
    addEEnumLiteral(nodeVarScopeEnumEEnum, NodeVarScopeEnum.LOCAL);
    addEEnumLiteral(nodeVarScopeEnumEEnum, NodeVarScopeEnum.GROUP);

    initEEnum(equalityOperatorEEnum, EqualityOperator.class, "EqualityOperator");
    addEEnumLiteral(equalityOperatorEEnum, EqualityOperator.EQUAL);
    addEEnumLiteral(equalityOperatorEEnum, EqualityOperator.NOT_EQUAL);

    initEEnum(compareOperatorEEnum, CompareOperator.class, "CompareOperator");
    addEEnumLiteral(compareOperatorEEnum, CompareOperator.LESS);
    addEEnumLiteral(compareOperatorEEnum, CompareOperator.LESS_EQUAL);
    addEEnumLiteral(compareOperatorEEnum, CompareOperator.GREATER);
    addEEnumLiteral(compareOperatorEEnum, CompareOperator.GREATER_EQUAL);

    initEEnum(shiftOperatorEEnum, ShiftOperator.class, "ShiftOperator");
    addEEnumLiteral(shiftOperatorEEnum, ShiftOperator.LEFT);
    addEEnumLiteral(shiftOperatorEEnum, ShiftOperator.RIGHT);

    initEEnum(additiveOperatorEEnum, AdditiveOperator.class, "AdditiveOperator");
    addEEnumLiteral(additiveOperatorEEnum, AdditiveOperator.ADD);
    addEEnumLiteral(additiveOperatorEEnum, AdditiveOperator.SUBTRACT);

    initEEnum(multiplicativeOperatorEEnum, MultiplicativeOperator.class, "MultiplicativeOperator");
    addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.MULTIPLY);
    addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.DIVIDE);
    addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.MODULUS);

    initEEnum(unaryOperatorEEnum, UnaryOperator.class, "UnaryOperator");
    addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.MINUS);
    addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.PLUS);
    addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.LOGICAL_NOT);
    addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.BITWISE_NOT);

    initEEnum(builtInFunctionEnumEEnum, BuiltInFunctionEnum.class, "BuiltInFunctionEnum");
    addEEnumLiteral(builtInFunctionEnumEEnum, BuiltInFunctionEnum.EXISTS_OTHER);
    addEEnumLiteral(builtInFunctionEnumEEnum, BuiltInFunctionEnum.EXISTS_HIGHER);
    addEEnumLiteral(builtInFunctionEnumEEnum, BuiltInFunctionEnum.EXISTS_LOWER);

    // Create resource
    createResource(eNS_URI);
  }

} //DmplPackageImpl
