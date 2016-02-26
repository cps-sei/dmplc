package edu.cmu.sei.annex.dmpl.tests

import com.google.inject.Inject
import edu.cmu.sei.annex.dmpl.DmplInjectorProvider
import edu.cmu.sei.annex.dmpl.dmpl.CompareExpr
import edu.cmu.sei.annex.dmpl.dmpl.CompareOperator
import edu.cmu.sei.annex.dmpl.dmpl.EqualityExpr
import edu.cmu.sei.annex.dmpl.dmpl.EqualityOperator
import edu.cmu.sei.annex.dmpl.dmpl.LVal
import edu.cmu.sei.annex.dmpl.dmpl.Procedure
import edu.cmu.sei.annex.dmpl.dmpl.Program
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.assertEquals

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
				varInits.get(0).varAsgnList.varAsgn => [
					"v1".assertEquals(^var.name)
					expr as EqualityExpr => [
						"name1".assertEquals((left as LVal).name)
						EqualityOperator.EQUAL.assertEquals(operator)
						"name2".assertEquals((right as LVal).name)
					]
				]
				varInits.get(1).varAsgnList.varAsgn => [
					"v2".assertEquals(^var.name)
					expr as EqualityExpr => [
						"name3".assertEquals((left as LVal).name)
						EqualityOperator.NOT_EQUAL.assertEquals(operator)
						"name4".assertEquals((right as LVal).name)
					]
				]
				varInits.get(2).varAsgnList.varAsgn => [
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
				varInits.get(3).varAsgnList.varAsgn => [
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
				varInits.get(4).varAsgnList.varAsgn => [
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
}