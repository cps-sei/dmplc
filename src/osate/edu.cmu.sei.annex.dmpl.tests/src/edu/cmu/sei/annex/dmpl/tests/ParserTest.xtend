package edu.cmu.sei.annex.dmpl.tests

import com.google.inject.Inject
import edu.cmu.sei.annex.dmpl.DmplInjectorProvider
import edu.cmu.sei.annex.dmpl.dmpl.Constant
import edu.cmu.sei.annex.dmpl.dmpl.DoubleConst
import edu.cmu.sei.annex.dmpl.dmpl.FnPrototypeDeclaration
import edu.cmu.sei.annex.dmpl.dmpl.IdDimension
import edu.cmu.sei.annex.dmpl.dmpl.IntConst
import edu.cmu.sei.annex.dmpl.dmpl.IntDimension
import edu.cmu.sei.annex.dmpl.dmpl.NodeNumDimension
import edu.cmu.sei.annex.dmpl.dmpl.Procedure
import edu.cmu.sei.annex.dmpl.dmpl.Program
import edu.cmu.sei.annex.dmpl.dmpl.SignEnum
import edu.cmu.sei.annex.dmpl.dmpl.SignedEnum
import edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum
import edu.cmu.sei.annex.dmpl.dmpl.ThreadDeclaration
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertFalse
import static extension org.junit.Assert.assertNull
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
		"".parse.programElements.empty.assertTrue
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
				"t1".assertEquals((prototype as ThreadDeclaration).name)
			]
			(programElements.get(1) as Procedure).procedure.prototype => [
				pure.assertTrue
				extern.assertFalse
				"t2".assertEquals((prototype as ThreadDeclaration).name)
			]
			(programElements.get(2) as Procedure).procedure.prototype => [
				pure.assertTrue
				extern.assertFalse
				"t3".assertEquals((prototype as ThreadDeclaration).name)
			]
			(programElements.get(3) as Procedure).procedure.prototype => [
				pure.assertFalse
				extern.assertTrue
				"t4".assertEquals((prototype as ThreadDeclaration).name)
			]
			(programElements.get(4) as Procedure).procedure.prototype => [
				pure.assertFalse
				extern.assertTrue
				"t5".assertEquals((prototype as ThreadDeclaration).name)
			]
			(programElements.get(5) as Procedure).procedure.prototype => [
				pure.assertTrue
				extern.assertTrue
				"t6".assertEquals((prototype as ThreadDeclaration).name)
			]
			(programElements.get(6) as Procedure).procedure.prototype => [
				pure.assertTrue
				extern.assertTrue
				"t7".assertEquals((prototype as ThreadDeclaration).name)
			]
		]
	}
	
	@Test
	def void testType() {
		'''
			bool f1();
			_Bool f2();
			int f3();
			double f4();
			void f5();
			char f6();
			signed int f7();
			unsigned int f8();
		'''.parse => [
			assertNoIssues
			8.assertEquals(programElements.size)
			(programElements.get(0) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f1".assertEquals(name)
				type => [
					SignedEnum.UNSET.assertEquals(signed)
					SimpTypeEnum.BOOL.assertEquals(simpType)
				]
			]
			(programElements.get(1) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f2".assertEquals(name)
				type => [
					SignedEnum.UNSET.assertEquals(signed)
					SimpTypeEnum.BOOL.assertEquals(simpType)
				]
			]
			(programElements.get(2) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f3".assertEquals(name)
				type => [
					SignedEnum.UNSET.assertEquals(signed)
					SimpTypeEnum.INT.assertEquals(simpType)
				]
			]
			(programElements.get(3) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f4".assertEquals(name)
				type => [
					SignedEnum.UNSET.assertEquals(signed)
					SimpTypeEnum.DOUBLE.assertEquals(simpType)
				]
			]
			(programElements.get(4) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f5".assertEquals(name)
				type => [
					SignedEnum.UNSET.assertEquals(signed)
					SimpTypeEnum.VOID.assertEquals(simpType)
				]
			]
			(programElements.get(5) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f6".assertEquals(name)
				type => [
					SignedEnum.UNSET.assertEquals(signed)
					SimpTypeEnum.CHAR.assertEquals(simpType)
				]
			]
			(programElements.get(6) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f7".assertEquals(name)
				type => [
					SignedEnum.SIGNED.assertEquals(signed)
					SimpTypeEnum.INT.assertEquals(simpType)
				]
			]
			(programElements.get(7) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f8".assertEquals(name)
				type => [
					SignedEnum.UNSIGNED.assertEquals(signed)
					SimpTypeEnum.INT.assertEquals(simpType)
				]
			]
		]
	}
	
	@Test
	def void testParamList() {
		'''
			int f1();
			int f2(int p1);
			int f3(int p1, int p2);
			int f4(int p1, int p2, int p3);
		'''.parse => [
			assertNoIssues
			4.assertEquals(programElements.size)
			(programElements.get(0) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f1".assertEquals(name)
				paramList.params.empty.assertTrue
			]
			(programElements.get(1) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f2".assertEquals(name)
				paramList => [
					1.assertEquals(params.size)
					params.head => [
						type => [
							SignedEnum.UNSET.assertEquals(signed)
							SimpTypeEnum.INT.assertEquals(simpType)
						]
						"p1".assertEquals(^var.name)
					]
				]
			]
			(programElements.get(2) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f3".assertEquals(name)
				paramList => [
					2.assertEquals(params.size)
					params.get(0) => [
						type => [
							SignedEnum.UNSET.assertEquals(signed)
							SimpTypeEnum.INT.assertEquals(simpType)
						]
						"p1".assertEquals(^var.name)
					]
					params.get(1) => [
						type => [
							SignedEnum.UNSET.assertEquals(signed)
							SimpTypeEnum.INT.assertEquals(simpType)
						]
						"p2".assertEquals(^var.name)
					]
				]
			]
			(programElements.get(3) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f4".assertEquals(name)
				paramList => [
					3.assertEquals(params.size)
					params.get(0) => [
						type => [
							SignedEnum.UNSET.assertEquals(signed)
							SimpTypeEnum.INT.assertEquals(simpType)
						]
						"p1".assertEquals(^var.name)
					]
					params.get(1) => [
						type => [
							SignedEnum.UNSET.assertEquals(signed)
							SimpTypeEnum.INT.assertEquals(simpType)
						]
						"p2".assertEquals(^var.name)
					]
					params.get(2) => [
						type => [
							SignedEnum.UNSET.assertEquals(signed)
							SimpTypeEnum.INT.assertEquals(simpType)
						]
						"p3".assertEquals(^var.name)
					]
				]
			]
		]
	}
	
	@Test
	def void testDimension() {
		'''
			int f1(int p1, int p2[0], int p3[1][2], int p4[3][4][5]);
			int f2(int p1[0], int p2[#N], int p3[a]);
		'''.parse => [
			assertNoIssues
			2.assertEquals(programElements.size)
			(programElements.get(0) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f1".assertEquals(name)
				paramList => [
					4.assertEquals(params.size)
					params.get(0).^var => [
						"p1".assertEquals(name)
						dimensions.empty.assertTrue
					]
					params.get(1).^var => [
						"p2".assertEquals(name)
						1.assertEquals(dimensions.size)
						0.assertEquals((dimensions.head as IntDimension).index)
					]
					params.get(2).^var => [
						"p3".assertEquals(name)
						2.assertEquals(dimensions.size)
						1.assertEquals((dimensions.get(0) as IntDimension).index)
						2.assertEquals((dimensions.get(1) as IntDimension).index)
					]
					params.get(3).^var => [
						"p4".assertEquals(name)
						3.assertEquals(dimensions.size)
						3.assertEquals((dimensions.get(0) as IntDimension).index)
						4.assertEquals((dimensions.get(1) as IntDimension).index)
						5.assertEquals((dimensions.get(2) as IntDimension).index)
					]
				]
			]
			(programElements.get(1) as Procedure).procedure.prototype.prototype as FnPrototypeDeclaration => [
				"f2".assertEquals(name)
				paramList => [
					3.assertEquals(params.size)
					params.get(0).^var => [
						"p1".assertEquals(name)
						1.assertEquals(dimensions.size)
						0.assertEquals((dimensions.head as IntDimension).index)
					]
					params.get(1).^var => [
						"p2".assertEquals(name)
						1.assertEquals(dimensions.size)
						Assert.assertTrue(dimensions.head instanceof NodeNumDimension)
					]
					params.get(2).^var => [
						"p3".assertEquals(name)
						1.assertEquals(dimensions.size)
						"a".assertEquals((dimensions.head as IdDimension).index)
					]
				]
			]
		]
	}
}