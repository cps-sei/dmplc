/**
 */
package edu.cmu.sei.annex.dmpl.dmpl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.cmu.sei.annex.dmpl.dmpl.DmplPackage
 * @generated
 */
public interface DmplFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DmplFactory eINSTANCE = edu.cmu.sei.annex.dmpl.dmpl.impl.DmplFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Program</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Program</em>'.
   * @generated
   */
  Program createProgram();

  /**
   * Returns a new object of class '<em>Subclause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subclause</em>'.
   * @generated
   */
  DmplSubclause createDmplSubclause();

  /**
   * Returns a new object of class '<em>Program Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Program Element</em>'.
   * @generated
   */
  ProgramElement createProgramElement();

  /**
   * Returns a new object of class '<em>Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant</em>'.
   * @generated
   */
  Constant createConstant();

  /**
   * Returns a new object of class '<em>Number Const</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Number Const</em>'.
   * @generated
   */
  NumberConst createNumberConst();

  /**
   * Returns a new object of class '<em>Int Const</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Int Const</em>'.
   * @generated
   */
  IntConst createIntConst();

  /**
   * Returns a new object of class '<em>Double Const</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Double Const</em>'.
   * @generated
   */
  DoubleConst createDoubleConst();

  /**
   * Returns a new object of class '<em>Var Init</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var Init</em>'.
   * @generated
   */
  VarInit createVarInit();

  /**
   * Returns a new object of class '<em>Var Asgn</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var Asgn</em>'.
   * @generated
   */
  VarAsgn createVarAsgn();

  /**
   * Returns a new object of class '<em>Var</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var</em>'.
   * @generated
   */
  Var createVar();

  /**
   * Returns a new object of class '<em>Dimension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dimension</em>'.
   * @generated
   */
  Dimension createDimension();

  /**
   * Returns a new object of class '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type</em>'.
   * @generated
   */
  Type createType();

  /**
   * Returns a new object of class '<em>Procedure</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Procedure</em>'.
   * @generated
   */
  Procedure createProcedure();

  /**
   * Returns a new object of class '<em>Proc No Attr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Proc No Attr</em>'.
   * @generated
   */
  ProcNoAttr createProcNoAttr();

  /**
   * Returns a new object of class '<em>Fn Body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fn Body</em>'.
   * @generated
   */
  FnBody createFnBody();

  /**
   * Returns a new object of class '<em>Fn Prototype</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fn Prototype</em>'.
   * @generated
   */
  FnPrototype createFnPrototype();

  /**
   * Returns a new object of class '<em>Param</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Param</em>'.
   * @generated
   */
  Param createParam();

  /**
   * Returns a new object of class '<em>Var Init List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var Init List</em>'.
   * @generated
   */
  VarInitList createVarInitList();

  /**
   * Returns a new object of class '<em>Stmt List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stmt List</em>'.
   * @generated
   */
  StmtList createStmtList();

  /**
   * Returns a new object of class '<em>Cond Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cond Stmt</em>'.
   * @generated
   */
  CondStmt createCondStmt();

  /**
   * Returns a new object of class '<em>Cond Stmt No Attr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cond Stmt No Attr</em>'.
   * @generated
   */
  CondStmtNoAttr createCondStmtNoAttr();

  /**
   * Returns a new object of class '<em>Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stmt</em>'.
   * @generated
   */
  Stmt createStmt();

  /**
   * Returns a new object of class '<em>Assignment Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment Stmt</em>'.
   * @generated
   */
  AssignmentStmt createAssignmentStmt();

  /**
   * Returns a new object of class '<em>LVal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LVal</em>'.
   * @generated
   */
  LVal createLVal();

  /**
   * Returns a new object of class '<em>Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expr</em>'.
   * @generated
   */
  Expr createExpr();

  /**
   * Returns a new object of class '<em>Call Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Call Expr</em>'.
   * @generated
   */
  CallExpr createCallExpr();

  /**
   * Returns a new object of class '<em>Arg List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Arg List</em>'.
   * @generated
   */
  ArgList createArgList();

  /**
   * Returns a new object of class '<em>Expr Var Asgn</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expr Var Asgn</em>'.
   * @generated
   */
  ExprVarAsgn createExprVarAsgn();

  /**
   * Returns a new object of class '<em>Fn Var Asgn</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fn Var Asgn</em>'.
   * @generated
   */
  FnVarAsgn createFnVarAsgn();

  /**
   * Returns a new object of class '<em>Int Dimension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Int Dimension</em>'.
   * @generated
   */
  IntDimension createIntDimension();

  /**
   * Returns a new object of class '<em>Node Num Dimension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node Num Dimension</em>'.
   * @generated
   */
  NodeNumDimension createNodeNumDimension();

  /**
   * Returns a new object of class '<em>Id Dimension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Id Dimension</em>'.
   * @generated
   */
  IdDimension createIdDimension();

  /**
   * Returns a new object of class '<em>Thread Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Thread Declaration</em>'.
   * @generated
   */
  ThreadDeclaration createThreadDeclaration();

  /**
   * Returns a new object of class '<em>Fn Prototype Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fn Prototype Declaration</em>'.
   * @generated
   */
  FnPrototypeDeclaration createFnPrototypeDeclaration();

  /**
   * Returns a new object of class '<em>Nested Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Nested Stmt</em>'.
   * @generated
   */
  NestedStmt createNestedStmt();

  /**
   * Returns a new object of class '<em>While Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>While Stmt</em>'.
   * @generated
   */
  WhileStmt createWhileStmt();

  /**
   * Returns a new object of class '<em>For Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>For Stmt</em>'.
   * @generated
   */
  ForStmt createForStmt();

  /**
   * Returns a new object of class '<em>Simple Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Stmt</em>'.
   * @generated
   */
  SimpleStmt createSimpleStmt();

  /**
   * Returns a new object of class '<em>Return Value Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Return Value Stmt</em>'.
   * @generated
   */
  ReturnValueStmt createReturnValueStmt();

  /**
   * Returns a new object of class '<em>For All Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>For All Stmt</em>'.
   * @generated
   */
  ForAllStmt createForAllStmt();

  /**
   * Returns a new object of class '<em>Fadnp Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fadnp Stmt</em>'.
   * @generated
   */
  FadnpStmt createFadnpStmt();

  /**
   * Returns a new object of class '<em>Ternary Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ternary Expr</em>'.
   * @generated
   */
  TernaryExpr createTernaryExpr();

  /**
   * Returns a new object of class '<em>Or Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or Expr</em>'.
   * @generated
   */
  OrExpr createOrExpr();

  /**
   * Returns a new object of class '<em>And Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Expr</em>'.
   * @generated
   */
  AndExpr createAndExpr();

  /**
   * Returns a new object of class '<em>Bitwise Or Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bitwise Or Expr</em>'.
   * @generated
   */
  BitwiseOrExpr createBitwiseOrExpr();

  /**
   * Returns a new object of class '<em>Xor Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Xor Expr</em>'.
   * @generated
   */
  XorExpr createXorExpr();

  /**
   * Returns a new object of class '<em>Bitwise And Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bitwise And Expr</em>'.
   * @generated
   */
  BitwiseAndExpr createBitwiseAndExpr();

  /**
   * Returns a new object of class '<em>Equality Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equality Expr</em>'.
   * @generated
   */
  EqualityExpr createEqualityExpr();

  /**
   * Returns a new object of class '<em>Compare Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Compare Expr</em>'.
   * @generated
   */
  CompareExpr createCompareExpr();

  /**
   * Returns a new object of class '<em>Shift Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Shift Expr</em>'.
   * @generated
   */
  ShiftExpr createShiftExpr();

  /**
   * Returns a new object of class '<em>Additive Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Additive Expr</em>'.
   * @generated
   */
  AdditiveExpr createAdditiveExpr();

  /**
   * Returns a new object of class '<em>Multiplicative Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicative Expr</em>'.
   * @generated
   */
  MultiplicativeExpr createMultiplicativeExpr();

  /**
   * Returns a new object of class '<em>Id Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Id Expr</em>'.
   * @generated
   */
  IdExpr createIdExpr();

  /**
   * Returns a new object of class '<em>Int Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Int Expr</em>'.
   * @generated
   */
  IntExpr createIntExpr();

  /**
   * Returns a new object of class '<em>Double Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Double Expr</em>'.
   * @generated
   */
  DoubleExpr createDoubleExpr();

  /**
   * Returns a new object of class '<em>Node Num Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node Num Expr</em>'.
   * @generated
   */
  NodeNumExpr createNodeNumExpr();

  /**
   * Returns a new object of class '<em>Unary Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Expr</em>'.
   * @generated
   */
  UnaryExpr createUnaryExpr();

  /**
   * Returns a new object of class '<em>Built In Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Built In Expr</em>'.
   * @generated
   */
  BuiltInExpr createBuiltInExpr();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  DmplPackage getDmplPackage();

} //DmplFactory
