package edu.cmu.sei.annex.dmpl.tests

import com.google.inject.Inject
import edu.cmu.sei.annex.dmpl.DmplInjectorProvider
import edu.cmu.sei.annex.dmpl.dmpl.AndExpr
import edu.cmu.sei.annex.dmpl.dmpl.AssignmentStmt
import edu.cmu.sei.annex.dmpl.dmpl.AtEndSpec
import edu.cmu.sei.annex.dmpl.dmpl.AtLeastSpec
import edu.cmu.sei.annex.dmpl.dmpl.Attributable
import edu.cmu.sei.annex.dmpl.dmpl.AttributableNoRole
import edu.cmu.sei.annex.dmpl.dmpl.AttributableProgramElement
import edu.cmu.sei.annex.dmpl.dmpl.BitwiseAndExpr
import edu.cmu.sei.annex.dmpl.dmpl.BitwiseOrExpr
import edu.cmu.sei.annex.dmpl.dmpl.CallExpr
import edu.cmu.sei.annex.dmpl.dmpl.CompareExpr
import edu.cmu.sei.annex.dmpl.dmpl.CompareOperator
import edu.cmu.sei.annex.dmpl.dmpl.CondStmt
import edu.cmu.sei.annex.dmpl.dmpl.Constant
import edu.cmu.sei.annex.dmpl.dmpl.EqualityExpr
import edu.cmu.sei.annex.dmpl.dmpl.EqualityOperator
import edu.cmu.sei.annex.dmpl.dmpl.ExprVarAsgn
import edu.cmu.sei.annex.dmpl.dmpl.FadnpStmt
import edu.cmu.sei.annex.dmpl.dmpl.FnVarAsgn
import edu.cmu.sei.annex.dmpl.dmpl.ForAllFunctionEnum
import edu.cmu.sei.annex.dmpl.dmpl.ForAllStmt
import edu.cmu.sei.annex.dmpl.dmpl.ForStmt
import edu.cmu.sei.annex.dmpl.dmpl.FunctionDeclaration
import edu.cmu.sei.annex.dmpl.dmpl.IdRole
import edu.cmu.sei.annex.dmpl.dmpl.IntExpr
import edu.cmu.sei.annex.dmpl.dmpl.LVal
import edu.cmu.sei.annex.dmpl.dmpl.NestedStmt
import edu.cmu.sei.annex.dmpl.dmpl.Node
import edu.cmu.sei.annex.dmpl.dmpl.NodeVarScopeEnum
import edu.cmu.sei.annex.dmpl.dmpl.OrExpr
import edu.cmu.sei.annex.dmpl.dmpl.Program
import edu.cmu.sei.annex.dmpl.dmpl.RecordBlock
import edu.cmu.sei.annex.dmpl.dmpl.RequireSpec
import edu.cmu.sei.annex.dmpl.dmpl.ReturnValueStmt
import edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum
import edu.cmu.sei.annex.dmpl.dmpl.SimpleRole
import edu.cmu.sei.annex.dmpl.dmpl.SimpleStmt
import edu.cmu.sei.annex.dmpl.dmpl.SimpleStmtKeywordEnum
import edu.cmu.sei.annex.dmpl.dmpl.Target
import edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr
import edu.cmu.sei.annex.dmpl.dmpl.VarBlock
import edu.cmu.sei.annex.dmpl.dmpl.WhileStmt
import edu.cmu.sei.annex.dmpl.dmpl.XorExpr
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertFalse
import static extension org.junit.Assert.assertNotNull
import static extension org.junit.Assert.assertNull
import static extension org.junit.Assert.assertTrue

@RunWith(XtextRunner)
@InjectWith(DmplInjectorProvider)
class ParserTest2 {
	@Inject
	extension ParseHelper<Program>
	@Inject
	extension ValidationTestHelper
	
	@Test
	def void testEqualityExpr() {
		'''
			void f1() {
				int v1 = name1 == name2;
				int v2 = name3 != name4;
				int v3 = name5 == name6 != name7;
				int v4 = name8 == name9 < name10;
				int v5 = name11 < name12 == name13;
			}
		'''.parse => [
			assertNoIssues;
			((elements.head as AttributableProgramElement).element as FunctionDeclaration).fnBody => [
				5.assertEquals(varInits.size)
				varInits.get(0).varAsgns.head as ExprVarAsgn => [
					"v1".assertEquals(^var.name)
					expr as EqualityExpr => [
						"name1".assertEquals((left as LVal).name)
						EqualityOperator.EQUAL.assertEquals(operator)
						"name2".assertEquals((right as LVal).name)
					]
				]
				varInits.get(1).varAsgns.head as ExprVarAsgn => [
					"v2".assertEquals(^var.name)
					expr as EqualityExpr => [
						"name3".assertEquals((left as LVal).name)
						EqualityOperator.NOT_EQUAL.assertEquals(operator)
						"name4".assertEquals((right as LVal).name)
					]
				]
				varInits.get(2).varAsgns.head as ExprVarAsgn => [
					"v3".assertEquals(^var.name)
					expr as EqualityExpr => [
						left as EqualityExpr => [
							"name5".assertEquals((left as LVal).name)
							EqualityOperator.EQUAL.assertEquals(operator)
							"name6".assertEquals((right as LVal).name)
						]
						EqualityOperator.NOT_EQUAL.assertEquals(operator)
						"name7".assertEquals((right as LVal).name)
					]
				]
				varInits.get(3).varAsgns.head as ExprVarAsgn => [
					"v4".assertEquals(^var.name)
					expr as EqualityExpr => [
						"name8".assertEquals((left as LVal).name)
						EqualityOperator.EQUAL.assertEquals(operator)
						right as CompareExpr => [
							"name9".assertEquals((left as LVal).name)
							CompareOperator.LESS.assertEquals(operator)
							"name10".assertEquals((right as LVal).name)
						]
					]
				]
				varInits.get(4).varAsgns.head as ExprVarAsgn => [
					"v5".assertEquals(^var.name)
					expr as EqualityExpr => [
						left as CompareExpr => [
							"name11".assertEquals((left as LVal).name)
							CompareOperator.LESS.assertEquals(operator)
							"name12".assertEquals((right as LVal).name)
						]
						EqualityOperator.EQUAL.assertEquals(operator)
						"name13".assertEquals((right as LVal).name)
					]
				]
			]
		]
	}
	
	@Test
	def void testBitwiseAndExpr() {
		'''
			void f1() {
				int v1 = name1 & name2;
				int v2 = name3 & name4 == name5;
				int v3 = name6 == name7 & name8;
			}
		'''.parse => [
			assertNoIssues;
			((elements.head as AttributableProgramElement).element as FunctionDeclaration).fnBody => [
				3.assertEquals(varInits.size)
				varInits.get(0).varAsgns.head as ExprVarAsgn => [
					"v1".assertEquals(^var.name)
					expr as BitwiseAndExpr => [
						"name1".assertEquals((left as LVal).name)
						"name2".assertEquals((right as LVal).name)
					]
				]
				varInits.get(1).varAsgns.head as ExprVarAsgn => [
					"v2".assertEquals(^var.name)
					expr as BitwiseAndExpr => [
						"name3".assertEquals((left as LVal).name)
						right as EqualityExpr => [
							"name4".assertEquals((left as LVal).name)
							EqualityOperator.EQUAL.assertEquals(operator)
							"name5".assertEquals((right as LVal).name)
						]
					]
				]
				varInits.get(2).varAsgns.head as ExprVarAsgn => [
					"v3".assertEquals(^var.name)
					expr as BitwiseAndExpr => [
						left as EqualityExpr => [
							"name6".assertEquals((left as LVal).name)
							EqualityOperator.EQUAL.assertEquals(operator)
							"name7".assertEquals((right as LVal).name)
						]
						"name8".assertEquals((right as LVal).name)
					]
				]
			]
		]
	}
	
	@Test
	def void testXorExpr() {
		'''
			void f1() {
				int v1 = name1 ^ name2;
				int v2 = name3 ^ name4 & name5;
				int v3 = name6 & name7 ^ name8;
			}
		'''.parse => [
			assertNoIssues;
			((elements.head as AttributableProgramElement).element as FunctionDeclaration).fnBody => [
				3.assertEquals(varInits.size)
				varInits.get(0).varAsgns.head as ExprVarAsgn => [
					"v1".assertEquals(^var.name)
					expr as XorExpr => [
						"name1".assertEquals((left as LVal).name)
						"name2".assertEquals((right as LVal).name)
					]
				]
				varInits.get(1).varAsgns.head as ExprVarAsgn => [
					"v2".assertEquals(^var.name)
					expr as XorExpr => [
						"name3".assertEquals((left as LVal).name)
						right as BitwiseAndExpr => [
							"name4".assertEquals((left as LVal).name)
							"name5".assertEquals((right as LVal).name)
						]
					]
				]
				varInits.get(2).varAsgns.head as ExprVarAsgn => [
					"v3".assertEquals(^var.name)
					expr as XorExpr => [
						left as BitwiseAndExpr => [
							"name6".assertEquals((left as LVal).name)
							"name7".assertEquals((right as LVal).name)
						]
						"name8".assertEquals((right as LVal).name)
					]
				]
			]
		]
	}
	
	@Test
	def void testBitwiseOrExpr() {
		'''
			void f1() {
				int v1 = name1 | name2;
				int v2 = name3 | name4 ^ name5;
				int v3 = name6 ^ name7 | name8;
			}
		'''.parse => [
			assertNoIssues;
			((elements.head as AttributableProgramElement).element as FunctionDeclaration).fnBody => [
				3.assertEquals(varInits.size)
				varInits.get(0).varAsgns.head as ExprVarAsgn => [
					"v1".assertEquals(^var.name)
					expr as BitwiseOrExpr => [
						"name1".assertEquals((left as LVal).name)
						"name2".assertEquals((right as LVal).name)
					]
				]
				varInits.get(1).varAsgns.head as ExprVarAsgn => [
					"v2".assertEquals(^var.name)
					expr as BitwiseOrExpr => [
						"name3".assertEquals((left as LVal).name)
						right as XorExpr => [
							"name4".assertEquals((left as LVal).name)
							"name5".assertEquals((right as LVal).name)
						]
					]
				]
				varInits.get(2).varAsgns.head as ExprVarAsgn => [
					"v3".assertEquals(^var.name)
					expr as BitwiseOrExpr => [
						left as XorExpr => [
							"name6".assertEquals((left as LVal).name)
							"name7".assertEquals((right as LVal).name)
						]
						"name8".assertEquals((right as LVal).name)
					]
				]
			]
		]
	}
	
	@Test
	def void testAndExpr() {
		'''
			void f1() {
				int v1 = name1 && name2;
				int v2 = name3 && name4 | name5;
				int v3 = name6 | name7 && name8;
			}
		'''.parse => [
			assertNoIssues;
			((elements.head as AttributableProgramElement).element as FunctionDeclaration).fnBody => [
				3.assertEquals(varInits.size)
				varInits.get(0).varAsgns.head as ExprVarAsgn => [
					"v1".assertEquals(^var.name)
					expr as AndExpr => [
						"name1".assertEquals((left as LVal).name)
						"name2".assertEquals((right as LVal).name)
					]
				]
				varInits.get(1).varAsgns.head as ExprVarAsgn => [
					"v2".assertEquals(^var.name)
					expr as AndExpr => [
						"name3".assertEquals((left as LVal).name)
						right as BitwiseOrExpr => [
							"name4".assertEquals((left as LVal).name)
							"name5".assertEquals((right as LVal).name)
						]
					]
				]
				varInits.get(2).varAsgns.head as ExprVarAsgn => [
					"v3".assertEquals(^var.name)
					expr as AndExpr => [
						left as BitwiseOrExpr => [
							"name6".assertEquals((left as LVal).name)
							"name7".assertEquals((right as LVal).name)
						]
						"name8".assertEquals((right as LVal).name)
					]
				]
			]
		]
	}
	
	@Test
	def void testOrExpr() {
		'''
			void f1() {
				int v1 = name1 || name2;
				int v2 = name3 || name4 && name5;
				int v3 = name6 && name7 || name8;
			}
		'''.parse => [
			assertNoIssues;
			((elements.head as AttributableProgramElement).element as FunctionDeclaration).fnBody => [
				3.assertEquals(varInits.size)
				varInits.get(0).varAsgns.head as ExprVarAsgn => [
					"v1".assertEquals(^var.name)
					expr as OrExpr => [
						"name1".assertEquals((left as LVal).name)
						"name2".assertEquals((right as LVal).name)
					]
				]
				varInits.get(1).varAsgns.head as ExprVarAsgn => [
					"v2".assertEquals(^var.name)
					expr as OrExpr => [
						"name3".assertEquals((left as LVal).name)
						right as AndExpr => [
							"name4".assertEquals((left as LVal).name)
							"name5".assertEquals((right as LVal).name)
						]
					]
				]
				varInits.get(2).varAsgns.head as ExprVarAsgn => [
					"v3".assertEquals(^var.name)
					expr as OrExpr => [
						left as AndExpr => [
							"name6".assertEquals((left as LVal).name)
							"name7".assertEquals((right as LVal).name)
						]
						"name8".assertEquals((right as LVal).name)
					]
				]
			]
		]
	}
	
	@Test
	def void testTernaryExpr() {
		'''
			void f1() {
				int v1 = name1 ? name2 : name3;
				int v2 = name4 ? name5 ? name6 : name7 : name8;
				int v3 = name9 ? name10 : name11 ? name12 : name13;
				int v4 = name14 ? name15 : name16 || name17;
				int v5 = name18 ? name19 || name20 : name21;
				int v6 = name22 || name23 ? name24 : name25;
			}
		'''.parse => [
			assertNoIssues;
			((elements.head as AttributableProgramElement).element as FunctionDeclaration).fnBody => [
				6.assertEquals(varInits.size)
				varInits.get(0).varAsgns.head as ExprVarAsgn => [
					"v1".assertEquals(^var.name)
					expr as TernaryExpr => [
						"name1".assertEquals((condition as LVal).name)
						"name2".assertEquals((then as LVal).name)
						"name3".assertEquals((^else as LVal).name)
					]
				]
				varInits.get(1).varAsgns.head as ExprVarAsgn => [
					"v2".assertEquals(^var.name)
					expr as TernaryExpr => [
						"name4".assertEquals((condition as LVal).name)
						then as TernaryExpr => [
							"name5".assertEquals((condition as LVal).name)
							"name6".assertEquals((then as LVal).name)
							"name7".assertEquals((^else as LVal).name)
						]
						"name8".assertEquals((^else as LVal).name)
					]
				]
				varInits.get(2).varAsgns.head as ExprVarAsgn => [
					"v3".assertEquals(^var.name)
					expr as TernaryExpr => [
						"name9".assertEquals((condition as LVal).name)
						"name10".assertEquals((then as LVal).name)
						^else as TernaryExpr => [
							"name11".assertEquals((condition as LVal).name)
							"name12".assertEquals((then as LVal).name)
							"name13".assertEquals((^else as LVal).name)
						]
					]
				]
				varInits.get(3).varAsgns.head as ExprVarAsgn => [
					"v4".assertEquals(^var.name)
					expr as TernaryExpr => [
						"name14".assertEquals((condition as LVal).name)
						"name15".assertEquals((then as LVal).name)
						^else as OrExpr => [
							"name16".assertEquals((left as LVal).name)
							"name17".assertEquals((right as LVal).name)
						]
					]
				]
				varInits.get(4).varAsgns.head as ExprVarAsgn => [
					"v5".assertEquals(^var.name)
					expr as TernaryExpr => [
						"name18".assertEquals((condition as LVal).name)
						then as OrExpr => [
							"name19".assertEquals((left as LVal).name)
							"name20".assertEquals((right as LVal).name)
						]
						"name21".assertEquals((^else as LVal).name)
					]
				]
				varInits.get(5).varAsgns.head as ExprVarAsgn => [
					"v6".assertEquals(^var.name)
					expr as TernaryExpr => [
						condition as OrExpr => [
							"name22".assertEquals((left as LVal).name)
							"name23".assertEquals((right as LVal).name)
						]
						"name24".assertEquals((then as LVal).name)
						"name25".assertEquals((^else as LVal).name)
					]
				]
			]
		]
	}
	
	@Test
	def void testVarAsgn() {
		'''
			void f1() {
				int v1;
				int input v2;
				int v3 = name1;
				int v4 = {
				};
				int input v5 ~ name2;
				int input v6 ~ {
				};
			}
		'''.parse => [
			assertNoIssues;
			((elements.head as AttributableProgramElement).element as FunctionDeclaration).fnBody => [
				6.assertEquals(varInits.size)
				varInits.get(0).varAsgns.head => [
					"v1".assertEquals(^var.name)
					input.assertFalse
				]
				varInits.get(1).varAsgns.head => [
					"v2".assertEquals(^var.name)
					input.assertTrue
				]
				varInits.get(2).varAsgns.head as ExprVarAsgn => [
					"v3".assertEquals(^var.name)
					input.assertFalse
					"name1".assertEquals((expr as LVal).name)
				]
				varInits.get(3).varAsgns.head as FnVarAsgn => [
					"v4".assertEquals(^var.name)
					input.assertFalse
					fnBody.assertNotNull
				]
				varInits.get(4).varAsgns.head as ExprVarAsgn => [
					"v5".assertEquals(^var.name)
					input.assertTrue
					"name2".assertEquals((expr as LVal).name)
				]
				varInits.get(5).varAsgns.head as FnVarAsgn => [
					"v6".assertEquals(^var.name)
					input.assertTrue
					fnBody.assertNotNull
				]
			]
		]
	}
	
	@Test
	def void testVarInit() {
		'''
			void f1() {
				int v1;
				int v2, v3;
				int v4, v5, v6;
			}
		'''.parse => [
			assertNoIssues;
			((elements.head as AttributableProgramElement).element as FunctionDeclaration).fnBody => [
				3.assertEquals(varInits.size)
				varInits.get(0) => [
					SimpTypeEnum.INT.assertEquals(type.simpType)
					1.assertEquals(varAsgns.size)
					"v1".assertEquals(varAsgns.head.^var.name)
				]
				varInits.get(1) => [
					SimpTypeEnum.INT.assertEquals(type.simpType)
					2.assertEquals(varAsgns.size)
					"v2".assertEquals(varAsgns.get(0).^var.name)
					"v3".assertEquals(varAsgns.get(1).^var.name)
				]
				varInits.get(2) => [
					SimpTypeEnum.INT.assertEquals(type.simpType)
					3.assertEquals(varAsgns.size)
					"v4".assertEquals(varAsgns.get(0).^var.name)
					"v5".assertEquals(varAsgns.get(1).^var.name)
					"v6".assertEquals(varAsgns.get(2).^var.name)
				]
			]
		]
	}
	
	@Test
	def void testVarInitList() {
		'''
			void f1() {
			}
			void f2() {
				int v1;
			}
			void f3() {
				int v2;
				int v3;
			}
		'''.parse => [
			assertNoIssues;
			(elements.get(0) as AttributableProgramElement).element as FunctionDeclaration => [
				"f1".assertEquals(name)
				fnBody.varInits.empty.assertTrue
			]
			(elements.get(1) as AttributableProgramElement).element as FunctionDeclaration => [
				"f2".assertEquals(name)
				fnBody => [
					1.assertEquals(varInits.size)
					"v1".assertEquals(varInits.head.varAsgns.head.^var.name)
				]
			]
			(elements.get(2) as AttributableProgramElement).element as FunctionDeclaration => [
				"f3".assertEquals(name)
				fnBody => [
					2.assertEquals(varInits.size)
					"v2".assertEquals(varInits.get(0).varAsgns.head.^var.name)
					"v3".assertEquals(varInits.get(1).varAsgns.head.^var.name)
				]
			]
		]
	}
	
	@Test
	def void testStmt() {
		'''
			void f1() {
				{}
				{
					v1 = 1;
				}
				v2 = 2;
				while (v3)
					v4 = 3;
				while (v5) {
					v6 = 4;
				}
				break;
				continue;
				return 5;
				return;
				f2();
				forall_node(n1)
					v7 = 6;
				FORALL_NODE(n2) {
					v8 = 7;
				}
				forall_distinct_node_pair(n3, n4)
					v9 = 8;
				FORALL_DISTINCT_NODE_PAIR(n5, n6) {
					v10 = 9;
				}
				forall_other(n7)
					v11 = 10;
				FORALL_OTHER(n8) {
					v12 = 11;
				}
				forall_other_lower(n9)
					v13 = 12;
				FORALL_OTHER_LOWER(n10) {
					v14 = 13;
				}
				forall_other_higher(n11)
					v15 = 14;
				FORALL_OTHER_HIGHER(n12) {
					v16 = 15;
				}
			}
		'''.parse => [
			assertNoIssues;
			(elements.head as AttributableProgramElement).element as FunctionDeclaration => [
				"f1".assertEquals(name)
				fnBody => [
					20.assertEquals(stmts.size)
					(stmts.get(0) as NestedStmt).stmts.empty.assertTrue;
					(stmts.get(1) as NestedStmt) => [
						1.assertEquals(stmts.size)
						stmts.head as AssignmentStmt => [
							"v1".assertEquals(variable.name)
							1.assertEquals((value as IntExpr).value)
						]
					]
					stmts.get(2) as AssignmentStmt => [
						"v2".assertEquals(variable.name)
						2.assertEquals((value as IntExpr).value)
					]
					stmts.get(3) as WhileStmt => [
						"v3".assertEquals((condition as LVal).name)
						stmt as AssignmentStmt => [
							"v4".assertEquals(variable.name)
							3.assertEquals((value as IntExpr).value)
						]
					]
					stmts.get(4) as WhileStmt => [
						"v5".assertEquals((condition as LVal).name)
						stmt as NestedStmt => [
							1.assertEquals(stmts.size)
							stmts.head as AssignmentStmt => [
								"v6".assertEquals(variable.name)
								4.assertEquals((value as IntExpr).value)
							]
						]
					]
					SimpleStmtKeywordEnum.BREAK.assertEquals((stmts.get(5) as SimpleStmt).name)
					SimpleStmtKeywordEnum.CONTINUE.assertEquals((stmts.get(6) as SimpleStmt).name)
					5.assertEquals(((stmts.get(7) as ReturnValueStmt).value as IntExpr).value)
					SimpleStmtKeywordEnum.RETURN.assertEquals((stmts.get(8) as SimpleStmt).name)
					"f2".assertEquals((stmts.get(9) as CallExpr).name)
					stmts.get(10) as ForAllStmt => [
						ForAllFunctionEnum.FORALL_NODE.assertEquals(name)
						"n1".assertEquals(node)
						stmt as AssignmentStmt => [
							"v7".assertEquals(variable.name)
							6.assertEquals((value as IntExpr).value)
						]
					]
					stmts.get(11) as ForAllStmt => [
						ForAllFunctionEnum.FORALL_NODE.assertEquals(name)
						"n2".assertEquals(node)
						stmt as NestedStmt => [
							1.assertEquals(stmts.size)
							stmts.head as AssignmentStmt => [
								"v8".assertEquals(variable.name)
								7.assertEquals((value as IntExpr).value)
							]
						]
					]
					stmts.get(12) as FadnpStmt => [
						"n3".assertEquals(node1)
						"n4".assertEquals(node2)
						stmt as AssignmentStmt => [
							"v9".assertEquals(variable.name)
							8.assertEquals((value as IntExpr).value)
						]
					]
					stmts.get(13) as FadnpStmt => [
						"n5".assertEquals(node1)
						"n6".assertEquals(node2)
						stmt as NestedStmt => [
							1.assertEquals(stmts.size)
							stmts.head as AssignmentStmt => [
								"v10".assertEquals(variable.name)
								9.assertEquals((value as IntExpr).value)
							]
						]
					]
					stmts.get(14) as ForAllStmt => [
						ForAllFunctionEnum.FORALL_OTHER.assertEquals(name)
						"n7".assertEquals(node)
						stmt as AssignmentStmt => [
							"v11".assertEquals(variable.name)
							10.assertEquals((value as IntExpr).value)
						]
					]
					stmts.get(15) as ForAllStmt => [
						ForAllFunctionEnum.FORALL_OTHER.assertEquals(name)
						"n8".assertEquals(node)
						stmt as NestedStmt => [
							1.assertEquals(stmts.size)
							stmts.head as AssignmentStmt => [
								"v12".assertEquals(variable.name)
								11.assertEquals((value as IntExpr).value)
							]
						]
					]
					stmts.get(16) as ForAllStmt => [
						ForAllFunctionEnum.FORALL_OTHER_LOWER.assertEquals(name)
						"n9".assertEquals(node)
						stmt as AssignmentStmt => [
							"v13".assertEquals(variable.name)
							12.assertEquals((value as IntExpr).value)
						]
					]
					stmts.get(17) as ForAllStmt => [
						ForAllFunctionEnum.FORALL_OTHER_LOWER.assertEquals(name)
						"n10".assertEquals(node)
						stmt as NestedStmt => [
							1.assertEquals(stmts.size)
							stmts.head as AssignmentStmt => [
								"v14".assertEquals(variable.name)
								13.assertEquals((value as IntExpr).value)
							]
						]
					]
					stmts.get(18) as ForAllStmt => [
						ForAllFunctionEnum.FORALL_OTHER_HIGHER.assertEquals(name)
						"n11".assertEquals(node)
						stmt as AssignmentStmt => [
							"v15".assertEquals(variable.name)
							14.assertEquals((value as IntExpr).value)
						]
					]
					stmts.get(19) as ForAllStmt => [
						ForAllFunctionEnum.FORALL_OTHER_HIGHER.assertEquals(name)
						"n12".assertEquals(node)
						stmt as NestedStmt => [
							1.assertEquals(stmts.size)
							stmts.head as AssignmentStmt => [
								"v16".assertEquals(variable.name)
								15.assertEquals((value as IntExpr).value)
							]
						]
					]
				]
			]
		]
	}
	
	@Test
	def void testForStmt() {
		'''
			void f1() {
				for (;;)
					v1 = 1;
				for (v2 = 2, v3 = 3, v4 = 4;;)
					v5 = 5;
				for (v6 = 6; v7; v8 = 7)
					v9 = 8;
			}
		'''.parse => [
			assertNoIssues;
			(elements.head as AttributableProgramElement).element as FunctionDeclaration => [
				"f1".assertEquals(name)
				fnBody => [
					3.assertEquals(stmts.size)
					stmts.get(0) as ForStmt => [
						inits.empty.assertTrue
						condition.assertNull
						update.assertNull
						stmt as AssignmentStmt => [
							"v1".assertEquals(variable.name)
							1.assertEquals((value as IntExpr).value)
						]
					]
					stmts.get(1) as ForStmt => [
						3.assertEquals(inits.size)
						inits.get(0) => [
							"v2".assertEquals(variable.name)
							2.assertEquals((value as IntExpr).value)
						]
						inits.get(1) => [
							"v3".assertEquals(variable.name)
							3.assertEquals((value as IntExpr).value)
						]
						inits.get(2) => [
							"v4".assertEquals(variable.name)
							4.assertEquals((value as IntExpr).value)
						]
						condition.assertNull
						update.assertNull
						stmt as AssignmentStmt => [
							"v5".assertEquals(variable.name)
							5.assertEquals((value as IntExpr).value)
						]
					]
					stmts.get(2) as ForStmt => [
						1.assertEquals(inits.size)
						inits.head => [
							"v6".assertEquals(variable.name)
							6.assertEquals((value as IntExpr).value)
						]
						"v7".assertEquals((condition as LVal).name)
						update as AssignmentStmt => [
							"v8".assertEquals(variable.name)
							7.assertEquals((value as IntExpr).value)
						]
						stmt as AssignmentStmt => [
							"v9".assertEquals(variable.name)
							8.assertEquals((value as IntExpr).value)
						]
					]
				]
			]
		]
	}
	
	@Test
	def void testCondStmt() {
		'''
			void f1() {
				if (v1)
					v2 = 1;
				else if (v3)
					v4 = 2;
			}
		'''.parse => [
			assertNoIssues;
			(elements.head as AttributableProgramElement).element as FunctionDeclaration => [
				"f1".assertEquals(name)
				fnBody => [
					1.assertEquals(stmts.size)
					stmts.head as CondStmt => [
						"v1".assertEquals((condition as LVal).name)
						then as AssignmentStmt => [
							"v2".assertEquals(variable.name)
							1.assertEquals((value as IntExpr).value)
						]
						^else as CondStmt => [
							"v3".assertEquals((condition as LVal).name)
							then as AssignmentStmt => [
								"v4".assertEquals(variable.name)
								2.assertEquals((value as IntExpr).value)
							]
							^else.assertNull
						]
					]
				]
			]
		]
	}
	
	@Test
	def void testAttr() {
		'''
			void f1() {
				@attr1; @attr2; @attr3; if (v1)
					v2 = 1;
				@attr4(2); if (v3)
					v4 = 3;
				@attr5(4, 5, 6); if (v5)
					v6 = 7;
			}
		'''.parse => [
			assertNoIssues;
			(elements.head as AttributableProgramElement).element as FunctionDeclaration => [
				"f1".assertEquals(name)
				fnBody => [
					3.assertEquals(stmts.size)
					stmts.get(0) as CondStmt => [
						3.assertEquals(attrs.size)
						"attr1".assertEquals(attrs.get(0).name)
						"attr2".assertEquals(attrs.get(1).name)
						"attr3".assertEquals(attrs.get(2).name)
					]
					stmts.get(1) as CondStmt => [
						1.assertEquals(attrs.size)
						attrs.head => [
							"attr4".assertEquals(name)
							1.assertEquals(params.size)
							2.assertEquals((params.get(0) as IntExpr).value)
						]
					]
					stmts.get(2) as CondStmt => [
						1.assertEquals(attrs.size)
						attrs.head => [
							"attr5".assertEquals(name)
							3.assertEquals(params.size)
							4.assertEquals((params.get(0) as IntExpr).value)
							5.assertEquals((params.get(1) as IntExpr).value)
							6.assertEquals((params.get(2) as IntExpr).value)
						]
					]
				]
			]
		]
	}
	
	@Test
	def void testProcedure() {
		'''
			void f1();
			override void f2();
			@attr1; void f3() {
			}
			@attr2; @attr3; @attr4; override void f4() {
			}
		'''.parse => [
			assertNoIssues
			4.assertEquals(elements.size)
			elements.get(0) as AttributableProgramElement => [
				attrs.empty.assertTrue
				element as FunctionDeclaration => [
					"f1".assertEquals(name)
					override.assertFalse
					fnBody.assertNull
				]
			]
			elements.get(1) as AttributableProgramElement => [
				attrs.empty.assertTrue
				element as FunctionDeclaration => [
					"f2".assertEquals(name)
					override.assertTrue
					fnBody.assertNull
				]
			]
			elements.get(2) as AttributableProgramElement => [
				1.assertEquals(attrs.size)
				"attr1".assertEquals(attrs.head.name)
				element as FunctionDeclaration => [
					"f3".assertEquals(name)
					override.assertFalse
					fnBody.assertNotNull
				]
			]
			elements.get(3) as AttributableProgramElement => [
				3.assertEquals(attrs.size)
				"attr2".assertEquals(attrs.get(0).name)
				"attr3".assertEquals(attrs.get(1).name)
				"attr4".assertEquals(attrs.get(2).name)
				element as FunctionDeclaration => [
					"f4".assertEquals(name)
					override.assertTrue
					fnBody.assertNotNull
				]
			]
		]
	}
	
	@Test
	def void testNode() {
		'''
			node n1;
			NODE n2 {
				void f1();
				
				global int v1;
				GLOBAL int v2;
				local int v3;
				override LOCAL int v4;
				override group int v5;
				
				record r1 {
					global int v6;
					global int v7;
					global int v8;
				}
				
				record r2 {
					global int v9;
				} = {
					proc1();
				}
				
				override record r3 {
					global int v10;
				} ~ {
					proc2();
				}
				
				override record r4 {
					global int v11;
				} = {
					proc3();
				} ~ {
					proc4();
				}
				
				expect s1: at_end => f2;
				expect s2: at_least 3.14 => f3;
				@attr1;
				@attr2;
				@attr3;
				require s3 => f4;
				
				role role1 {
					global int v12;
					record r5 {
						global int v13;
					}
					void f5();
					@attr4;
					@attr5;
					@attr6;
					require s4 => f6;
				}
				role role2 id 42 {
				}
			}
		'''.parse => [
			assertNoIssues
			2.assertEquals(elements.size)
			"n1".assertEquals(((elements.get(0) as AttributableProgramElement).element as Node).name)
			(elements.get(1) as AttributableProgramElement).element as Node => [
				"n2".assertEquals(name)
				15.assertEquals(elements.size)
				"f1".assertEquals(((elements.get(0) as Attributable).element as FunctionDeclaration).name)
				elements.get(1) as VarBlock => [
					override.assertFalse
					^var => [
						NodeVarScopeEnum.GLOBAL.assertEquals(scope)
						"v1".assertEquals(^var.varAsgns.head.^var.name)
					]
				]
				elements.get(2) as VarBlock => [
					override.assertFalse
					^var => [
						NodeVarScopeEnum.GLOBAL.assertEquals(scope)
						"v2".assertEquals(^var.varAsgns.head.^var.name)
					]
				]
				elements.get(3) as VarBlock => [
					override.assertFalse
					^var => [
						NodeVarScopeEnum.LOCAL.assertEquals(scope)
						"v3".assertEquals(^var.varAsgns.head.^var.name)
					]
				]
				elements.get(4) as VarBlock => [
					override.assertTrue
					^var => [
						NodeVarScopeEnum.LOCAL.assertEquals(scope)
						"v4".assertEquals(^var.varAsgns.head.^var.name)
					]
				]
				elements.get(5) as VarBlock => [
					override.assertTrue
					^var => [
						NodeVarScopeEnum.GROUP.assertEquals(scope)
						"v5".assertEquals(^var.varAsgns.head.^var.name)
					]
				]
				elements.get(6) as RecordBlock => [
					override.assertFalse
					"r1".assertEquals(name)
					3.assertEquals(vars.size)
					"v6".assertEquals(vars.get(0).^var.varAsgns.head.^var.name)
					"v7".assertEquals(vars.get(1).^var.varAsgns.head.^var.name)
					"v8".assertEquals(vars.get(2).^var.varAsgns.head.^var.name)
					equalsBody.assertNull
					complementBody.assertNull
				]
				elements.get(7) as RecordBlock => [
					override.assertFalse
					"r2".assertEquals(name)
					"v9".assertEquals(vars.head.^var.varAsgns.head.^var.name)
					"proc1".assertEquals((equalsBody.stmts.head as CallExpr).name)
					complementBody.assertNull
				]
				elements.get(8) as RecordBlock => [
					override.assertTrue
					"r3".assertEquals(name)
					"v10".assertEquals(vars.head.^var.varAsgns.head.^var.name)
					equalsBody.assertNull
					"proc2".assertEquals((complementBody.stmts.head as CallExpr).name)
				]
				elements.get(9) as RecordBlock => [
					override.assertTrue
					"r4".assertEquals(name)
					"v11".assertEquals(vars.head.^var.varAsgns.head.^var.name)
					"proc3".assertEquals((equalsBody.stmts.head as CallExpr).name)
					"proc4".assertEquals((complementBody.stmts.head as CallExpr).name)
				]
				elements.get(10) as Attributable => [
					attrs.empty.assertTrue
					element as AtEndSpec => [
						"s1".assertEquals(name)
						"f2".assertEquals(function)
					]
				]
				elements.get(11) as Attributable => [
					attrs.empty.assertTrue
					element as AtLeastSpec => [
						"s2".assertEquals(name)
						3.14.assertEquals(threshold.value, 0.0)
						"f3".assertEquals(function)
					]
				]
				elements.get(12) as Attributable => [
					3.assertEquals(attrs.size)
					"attr1".assertEquals(attrs.get(0).name)
					"attr2".assertEquals(attrs.get(1).name)
					"attr3".assertEquals(attrs.get(2).name)
					element as RequireSpec => [
						"s3".assertEquals(name)
						"f4".assertEquals(function)
					]
				]
				(elements.get(13) as Attributable).element as SimpleRole => [
					"role1".assertEquals(name)
					4.assertEquals(elements.size)
					"v12".assertEquals((elements.get(0) as VarBlock).^var.^var.varAsgns.head.^var.name)
					"r5".assertEquals((elements.get(1) as RecordBlock).name)
					elements.get(2) as AttributableNoRole => [
						attrs.empty.assertTrue
						"f5".assertEquals((element as FunctionDeclaration).name)
					]
					elements.get(3) as AttributableNoRole => [
						3.assertEquals(attrs.size)
						"attr4".assertEquals(attrs.get(0).name)
						"attr5".assertEquals(attrs.get(1).name)
						"attr6".assertEquals(attrs.get(2).name)
						"s4".assertEquals((element as RequireSpec).name)
					]
				]
				(elements.get(14) as Attributable).element as IdRole => [
					"role2".assertEquals(name)
					42.assertEquals(id)
					elements.empty.assertTrue
				]
			]
		]
	}
	
	@Test
	def void testTarget() {
		'''
			target t1 %%{
			%%}
			TARGET t2, t3, t4 %%{
				const c1 = 1;
				const c2 = 2;
				const c3 = 3;
			%%}
		'''.parse => [
			assertNoIssues
			2.assertEquals(elements.size)
			elements.get(0) as Target => [
				1.assertEquals(names.size)
				"t1".assertEquals(names.head)
//				elements.empty.assertTrue
			]
			elements.get(1) as Target => [
				3.assertEquals(names.size)
				"t2".assertEquals(names.get(0))
				"t3".assertEquals(names.get(1))
				"t4".assertEquals(names.get(2))
//				3.assertEquals(elements.size)
//				"c1".assertEquals((elements.get(0) as Constant).name)
//				"c2".assertEquals((elements.get(1) as Constant).name)
//				"c3".assertEquals((elements.get(2) as Constant).name)
			]
		]
	}
}