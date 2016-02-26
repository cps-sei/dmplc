package edu.cmu.sei.annex.dmpl.tests

import com.google.inject.Inject
import edu.cmu.sei.annex.dmpl.DmplInjectorProvider
import edu.cmu.sei.annex.dmpl.dmpl.AndExpr
import edu.cmu.sei.annex.dmpl.dmpl.BitwiseAndExpr
import edu.cmu.sei.annex.dmpl.dmpl.BitwiseOrExpr
import edu.cmu.sei.annex.dmpl.dmpl.CompareExpr
import edu.cmu.sei.annex.dmpl.dmpl.CompareOperator
import edu.cmu.sei.annex.dmpl.dmpl.EqualityExpr
import edu.cmu.sei.annex.dmpl.dmpl.EqualityOperator
import edu.cmu.sei.annex.dmpl.dmpl.ExprVarAsgn
import edu.cmu.sei.annex.dmpl.dmpl.FnVarAsgn
import edu.cmu.sei.annex.dmpl.dmpl.LVal
import edu.cmu.sei.annex.dmpl.dmpl.OrExpr
import edu.cmu.sei.annex.dmpl.dmpl.Procedure
import edu.cmu.sei.annex.dmpl.dmpl.Program
import edu.cmu.sei.annex.dmpl.dmpl.TernaryExpr
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
			(programElements.head as Procedure).procedure.fnBody.varInitList => [
				5.assertEquals(varInits.size)
				varInits.get(0).varAsgnList.varAsgn as ExprVarAsgn => [
					"v1".assertEquals(^var.name)
					expr as EqualityExpr => [
						"name1".assertEquals((left as LVal).name)
						EqualityOperator.EQUAL.assertEquals(operator)
						"name2".assertEquals((right as LVal).name)
					]
				]
				varInits.get(1).varAsgnList.varAsgn as ExprVarAsgn => [
					"v2".assertEquals(^var.name)
					expr as EqualityExpr => [
						"name3".assertEquals((left as LVal).name)
						EqualityOperator.NOT_EQUAL.assertEquals(operator)
						"name4".assertEquals((right as LVal).name)
					]
				]
				varInits.get(2).varAsgnList.varAsgn as ExprVarAsgn => [
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
				varInits.get(3).varAsgnList.varAsgn as ExprVarAsgn => [
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
				varInits.get(4).varAsgnList.varAsgn as ExprVarAsgn => [
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
			(programElements.head as Procedure).procedure.fnBody.varInitList => [
				3.assertEquals(varInits.size)
				varInits.get(0).varAsgnList.varAsgn as ExprVarAsgn => [
					"v1".assertEquals(^var.name)
					expr as BitwiseAndExpr => [
						"name1".assertEquals((left as LVal).name)
						"name2".assertEquals((right as LVal).name)
					]
				]
				varInits.get(1).varAsgnList.varAsgn as ExprVarAsgn => [
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
				varInits.get(2).varAsgnList.varAsgn as ExprVarAsgn => [
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
			(programElements.head as Procedure).procedure.fnBody.varInitList => [
				3.assertEquals(varInits.size)
				varInits.get(0).varAsgnList.varAsgn as ExprVarAsgn => [
					"v1".assertEquals(^var.name)
					expr as XorExpr => [
						"name1".assertEquals((left as LVal).name)
						"name2".assertEquals((right as LVal).name)
					]
				]
				varInits.get(1).varAsgnList.varAsgn as ExprVarAsgn => [
					"v2".assertEquals(^var.name)
					expr as XorExpr => [
						"name3".assertEquals((left as LVal).name)
						right as BitwiseAndExpr => [
							"name4".assertEquals((left as LVal).name)
							"name5".assertEquals((right as LVal).name)
						]
					]
				]
				varInits.get(2).varAsgnList.varAsgn as ExprVarAsgn => [
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
			(programElements.head as Procedure).procedure.fnBody.varInitList => [
				3.assertEquals(varInits.size)
				varInits.get(0).varAsgnList.varAsgn as ExprVarAsgn => [
					"v1".assertEquals(^var.name)
					expr as BitwiseOrExpr => [
						"name1".assertEquals((left as LVal).name)
						"name2".assertEquals((right as LVal).name)
					]
				]
				varInits.get(1).varAsgnList.varAsgn as ExprVarAsgn => [
					"v2".assertEquals(^var.name)
					expr as BitwiseOrExpr => [
						"name3".assertEquals((left as LVal).name)
						right as XorExpr => [
							"name4".assertEquals((left as LVal).name)
							"name5".assertEquals((right as LVal).name)
						]
					]
				]
				varInits.get(2).varAsgnList.varAsgn as ExprVarAsgn => [
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
			(programElements.head as Procedure).procedure.fnBody.varInitList => [
				3.assertEquals(varInits.size)
				varInits.get(0).varAsgnList.varAsgn as ExprVarAsgn => [
					"v1".assertEquals(^var.name)
					expr as AndExpr => [
						"name1".assertEquals((left as LVal).name)
						"name2".assertEquals((right as LVal).name)
					]
				]
				varInits.get(1).varAsgnList.varAsgn as ExprVarAsgn => [
					"v2".assertEquals(^var.name)
					expr as AndExpr => [
						"name3".assertEquals((left as LVal).name)
						right as BitwiseOrExpr => [
							"name4".assertEquals((left as LVal).name)
							"name5".assertEquals((right as LVal).name)
						]
					]
				]
				varInits.get(2).varAsgnList.varAsgn as ExprVarAsgn => [
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
			(programElements.head as Procedure).procedure.fnBody.varInitList => [
				3.assertEquals(varInits.size)
				varInits.get(0).varAsgnList.varAsgn as ExprVarAsgn => [
					"v1".assertEquals(^var.name)
					expr as OrExpr => [
						"name1".assertEquals((left as LVal).name)
						"name2".assertEquals((right as LVal).name)
					]
				]
				varInits.get(1).varAsgnList.varAsgn as ExprVarAsgn => [
					"v2".assertEquals(^var.name)
					expr as OrExpr => [
						"name3".assertEquals((left as LVal).name)
						right as AndExpr => [
							"name4".assertEquals((left as LVal).name)
							"name5".assertEquals((right as LVal).name)
						]
					]
				]
				varInits.get(2).varAsgnList.varAsgn as ExprVarAsgn => [
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
			(programElements.head as Procedure).procedure.fnBody.varInitList => [
				6.assertEquals(varInits.size)
				varInits.get(0).varAsgnList.varAsgn as ExprVarAsgn => [
					"v1".assertEquals(^var.name)
					expr as TernaryExpr => [
						"name1".assertEquals((condition as LVal).name)
						"name2".assertEquals((then as LVal).name)
						"name3".assertEquals((^else as LVal).name)
					]
				]
				varInits.get(1).varAsgnList.varAsgn as ExprVarAsgn => [
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
				varInits.get(2).varAsgnList.varAsgn as ExprVarAsgn => [
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
				varInits.get(3).varAsgnList.varAsgn as ExprVarAsgn => [
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
				varInits.get(4).varAsgnList.varAsgn as ExprVarAsgn => [
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
				varInits.get(5).varAsgnList.varAsgn as ExprVarAsgn => [
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
				int v1 = name1;
				int v2 = {
				};
				int input v3 ~ name2;
				int input v4 ~ {
				};
			}
		'''.parse => [
			assertNoIssues;
			(programElements.head as Procedure).procedure.fnBody.varInitList => [
				4.assertEquals(varInits.size)
				varInits.get(0).varAsgnList.varAsgn as ExprVarAsgn => [
					"v1".assertEquals(^var.name)
					input.assertFalse
					"name1".assertEquals((expr as LVal).name)
				]
				varInits.get(1).varAsgnList.varAsgn as FnVarAsgn => [
					"v2".assertEquals(^var.name)
					input.assertFalse
					fnBody.assertNotNull
				]
				varInits.get(2).varAsgnList.varAsgn as ExprVarAsgn => [
					"v3".assertEquals(^var.name)
					input.assertTrue
					"name2".assertEquals((expr as LVal).name)
				]
				varInits.get(3).varAsgnList.varAsgn as FnVarAsgn => [
					"v4".assertEquals(^var.name)
					input.assertTrue
					fnBody.assertNotNull
				]
			]
		]
	}
}