package edu.cmu.sei.annex.dmpl.tests

import com.google.inject.Inject
import edu.cmu.sei.annex.dmpl.DmplInjectorProvider
import edu.cmu.sei.annex.dmpl.dmpl.Constant
import edu.cmu.sei.annex.dmpl.dmpl.DoubleConst
import edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeDeclaration
import edu.cmu.sei.annex.dmpl.dmpl.IntConst
import edu.cmu.sei.annex.dmpl.dmpl.Procedure
import edu.cmu.sei.annex.dmpl.dmpl.Program
import edu.cmu.sei.annex.dmpl.dmpl.SignEnum
import edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum
import edu.cmu.sei.annex.dmpl.dmpl.ThreadDeclaration
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertFalse
import static extension org.junit.Assert.assertTrue

@RunWith(XtextRunner)
@InjectWith(DmplInjectorProvider)
class ParserTest {
	@Inject
	extension ParseHelper<Program>
	@Inject
	extension ValidationTestHelper
	
	@Test
	def void testEmptyProgram() {
		"".parse => [
			programElements.empty.assertTrue
		]
	}
	
	@Test
	def void testConst() {
		'''
			const c1 = 1;
			CONST c2 = +2;
			CONST c3 = -3;
			const c4 = 4.5;
			const c5 = +6.7;
			const c6 = -8.9;
			const c7 = NAN;
			const c8 = +NAN;
			const c9 = -NAN;
		'''.parse => [
			assertNoIssues
			9.assertEquals(programElements.size)
			programElements.get(0) as Constant => [
				"c1".assertEquals(name)
				value as IntConst => [
					SignEnum.UNSET.assertEquals(sign)
					1.assertEquals(value)
				]
			]
			programElements.get(1) as Constant => [
				"c2".assertEquals(name)
				value as IntConst => [
					SignEnum.PLUS.assertEquals(sign)
					2.assertEquals(value)
				]
			]
			programElements.get(2) as Constant => [
				"c3".assertEquals(name)
				value as IntConst => [
					SignEnum.MINUS.assertEquals(sign)
					3.assertEquals(value)
				]
			]
			programElements.get(3) as Constant => [
				"c4".assertEquals(name)
				value as DoubleConst => [
					SignEnum.UNSET.assertEquals(sign)
					4.5.assertEquals(value, 0)
				]
			]
			programElements.get(4) as Constant => [
				"c5".assertEquals(name)
				value as DoubleConst => [
					SignEnum.PLUS.assertEquals(sign)
					6.7.assertEquals(value, 0)
				]
			]
			programElements.get(5) as Constant => [
				"c6".assertEquals(name)
				value as DoubleConst => [
					SignEnum.MINUS.assertEquals(sign)
					8.9.assertEquals(value, 0)
				]
			]
			programElements.get(6) as Constant => [
				"c7".assertEquals(name)
				value as DoubleConst => [
					SignEnum.UNSET.assertEquals(sign)
					Double.NaN.assertEquals(value, 0)
				]
			]
			programElements.get(7) as Constant => [
				"c8".assertEquals(name)
				value as DoubleConst => [
					SignEnum.PLUS.assertEquals(sign)
					Double.NaN.assertEquals(value, 0)
				]
			]
			programElements.get(8) as Constant => [
				"c9".assertEquals(name)
				value as DoubleConst => [
					SignEnum.MINUS.assertEquals(sign)
					Double.NaN.assertEquals(value, 0)
				]
			]
		]
	}
	
	@Test
	def void testFnPrototypeThread() {
		'''
			thread t1;
			pure thread t2;
			PURE thread t3;
			extern thread t4;
			EXTERN thread t5;
			extern pure thread t6;
			EXTERN PURE thread t7;
		'''.parse => [
			assertNoIssues
			7.assertEquals(programElements.size)
			(programElements.get(0) as Procedure).procedure.prototype => [
				pure.assertFalse
				extern.assertFalse
				prototype as ThreadDeclaration => [
					"t1".assertEquals(name)
				]
			]
			(programElements.get(1) as Procedure).procedure.prototype => [
				pure.assertTrue
				extern.assertFalse
				prototype as ThreadDeclaration => [
					"t2".assertEquals(name)
				]
			]
			(programElements.get(2) as Procedure).procedure.prototype => [
				pure.assertTrue
				extern.assertFalse
				prototype as ThreadDeclaration => [
					"t3".assertEquals(name)
				]
			]
			(programElements.get(3) as Procedure).procedure.prototype => [
				pure.assertFalse
				extern.assertTrue
				prototype as ThreadDeclaration => [
					"t4".assertEquals(name)
				]
			]
			(programElements.get(4) as Procedure).procedure.prototype => [
				pure.assertFalse
				extern.assertTrue
				prototype as ThreadDeclaration => [
					"t5".assertEquals(name)
				]
			]
			(programElements.get(5) as Procedure).procedure.prototype => [
				pure.assertTrue
				extern.assertTrue
				prototype as ThreadDeclaration => [
					"t6".assertEquals(name)
				]
			]
			(programElements.get(6) as Procedure).procedure.prototype => [
				pure.assertTrue
				extern.assertTrue
				prototype as ThreadDeclaration => [
					"t7".assertEquals(name)
				]
			]
		]
	}
	
	@Test
	def void testSimpType() {
		'''
			bool f1();
			_Bool f2();
			int f3();
			double f4();
			void f5();
			char f6();
		'''.parse => [
			assertNoIssues
			6.assertEquals(programElements.size)
			(programElements.get(0) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f1".assertEquals(name)
				SimpTypeEnum.BOOL.assertEquals(type.type.simpType)
			]
			(programElements.get(1) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f2".assertEquals(name)
				SimpTypeEnum.BOOL.assertEquals(type.type.simpType)
			]
			(programElements.get(2) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f3".assertEquals(name)
				SimpTypeEnum.INT.assertEquals(type.type.simpType)
			]
			(programElements.get(3) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f4".assertEquals(name)
				SimpTypeEnum.DOUBLE.assertEquals(type.type.simpType)
			]
			(programElements.get(4) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f5".assertEquals(name)
				SimpTypeEnum.VOID.assertEquals(type.type.simpType)
			]
			(programElements.get(5) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f6".assertEquals(name)
				SimpTypeEnum.CHAR.assertEquals(type.type.simpType)
			]
		]
	}
}