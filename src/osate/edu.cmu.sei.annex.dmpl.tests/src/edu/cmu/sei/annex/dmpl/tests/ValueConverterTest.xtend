package edu.cmu.sei.annex.dmpl.tests

import com.google.inject.Inject
import edu.cmu.sei.annex.dmpl.DmplInjectorProvider
import edu.cmu.sei.annex.dmpl.dmpl.BuiltInFunctionEnum
import edu.cmu.sei.annex.dmpl.dmpl.ForAllFunctionEnum
import edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum
import edu.cmu.sei.annex.dmpl.services.DmplGrammarAccess
import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(DmplInjectorProvider)
class ValueConverterTest {
	@Inject
	IValueConverterService valueConverter
	@Inject
	DmplGrammarAccess grammarAccess
	
	@Test
	def void testDoubleRule() {
		//toValue
		12.34.assertEquals(valueConverter.toValue("12.34", grammarAccess.doubleRule.name, null))
		Double.NaN.assertEquals(valueConverter.toValue("NAN", grammarAccess.doubleRule.name, null))
		
		//toString
		"12.34".assertEquals(valueConverter.toString(12.34, grammarAccess.doubleRule.name))
		"NAN".assertEquals(valueConverter.toString(Double.NaN, grammarAccess.doubleRule.name))
	}
	
	@Test
	def void testSimpType() {
		//toValue
		SimpTypeEnum.BOOL.assertEquals(valueConverter.toValue("bool", grammarAccess.simpTypeRule.name, null))
		SimpTypeEnum.BOOL.assertEquals(valueConverter.toValue("_Bool", grammarAccess.simpTypeRule.name, null))
		SimpTypeEnum.INT.assertEquals(valueConverter.toValue("int", grammarAccess.simpTypeRule.name, null))
		SimpTypeEnum.DOUBLE.assertEquals(valueConverter.toValue("double", grammarAccess.simpTypeRule.name, null))
		SimpTypeEnum.VOID.assertEquals(valueConverter.toValue("void", grammarAccess.simpTypeRule.name, null))
		SimpTypeEnum.CHAR.assertEquals(valueConverter.toValue("char", grammarAccess.simpTypeRule.name, null))
		
		//toString
		"bool".assertEquals(valueConverter.toString(SimpTypeEnum.BOOL, grammarAccess.simpTypeRule.name))
		"int".assertEquals(valueConverter.toString(SimpTypeEnum.INT, grammarAccess.simpTypeRule.name))
		"double".assertEquals(valueConverter.toString(SimpTypeEnum.DOUBLE, grammarAccess.simpTypeRule.name))
		"void".assertEquals(valueConverter.toString(SimpTypeEnum.VOID, grammarAccess.simpTypeRule.name))
		"char".assertEquals(valueConverter.toString(SimpTypeEnum.CHAR, grammarAccess.simpTypeRule.name))
	}
	
	@Test
	def void testBuiltInFunction() {
		//toValue
		BuiltInFunctionEnum.EXISTS_OTHER.assertEquals(valueConverter.toValue("exists_other", grammarAccess.builtInFunctionRule.name, null))
		BuiltInFunctionEnum.EXISTS_OTHER.assertEquals(valueConverter.toValue("EXISTS_OTHER", grammarAccess.builtInFunctionRule.name, null))
		BuiltInFunctionEnum.EXISTS_HIGHER.assertEquals(valueConverter.toValue("exists_higher", grammarAccess.builtInFunctionRule.name, null))
		BuiltInFunctionEnum.EXISTS_HIGHER.assertEquals(valueConverter.toValue("EXISTS_HIGHER", grammarAccess.builtInFunctionRule.name, null))
		BuiltInFunctionEnum.EXISTS_LOWER.assertEquals(valueConverter.toValue("exists_lower", grammarAccess.builtInFunctionRule.name, null))
		BuiltInFunctionEnum.EXISTS_LOWER.assertEquals(valueConverter.toValue("EXISTS_LOWER", grammarAccess.builtInFunctionRule.name, null))
		
		//toString
		"exists_other".assertEquals(valueConverter.toString(BuiltInFunctionEnum.EXISTS_OTHER, grammarAccess.builtInFunctionRule.name))
		"exists_higher".assertEquals(valueConverter.toString(BuiltInFunctionEnum.EXISTS_HIGHER, grammarAccess.builtInFunctionRule.name))
		"exists_lower".assertEquals(valueConverter.toString(BuiltInFunctionEnum.EXISTS_LOWER, grammarAccess.builtInFunctionRule.name))
	}
	
	@Test
	def void testForAllFunction() {
		//toValue
		ForAllFunctionEnum.FORALL_NODE.assertEquals(valueConverter.toValue("forall_node", grammarAccess.forAllFunctionRule.name, null))
		ForAllFunctionEnum.FORALL_NODE.assertEquals(valueConverter.toValue("FORALL_NODE", grammarAccess.forAllFunctionRule.name, null))
		ForAllFunctionEnum.FORALL_OTHER.assertEquals(valueConverter.toValue("forall_other", grammarAccess.forAllFunctionRule.name, null))
		ForAllFunctionEnum.FORALL_OTHER.assertEquals(valueConverter.toValue("FORALL_OTHER", grammarAccess.forAllFunctionRule.name, null))
		ForAllFunctionEnum.FORALL_OTHER_LOWER.assertEquals(valueConverter.toValue("forall_other_lower", grammarAccess.forAllFunctionRule.name, null))
		ForAllFunctionEnum.FORALL_OTHER_LOWER.assertEquals(valueConverter.toValue("FORALL_OTHER_LOWER", grammarAccess.forAllFunctionRule.name, null))
		ForAllFunctionEnum.FORALL_OTHER_HIGHER.assertEquals(valueConverter.toValue("forall_other_higher", grammarAccess.forAllFunctionRule.name, null))
		ForAllFunctionEnum.FORALL_OTHER_HIGHER.assertEquals(valueConverter.toValue("FORALL_OTHER_HIGHER", grammarAccess.forAllFunctionRule.name, null))
		
		//toString
		"forall_node".assertEquals(valueConverter.toString(ForAllFunctionEnum.FORALL_NODE, grammarAccess.forAllFunctionRule.name))
		"forall_other".assertEquals(valueConverter.toString(ForAllFunctionEnum.FORALL_OTHER, grammarAccess.forAllFunctionRule.name))
		"forall_other_lower".assertEquals(valueConverter.toString(ForAllFunctionEnum.FORALL_OTHER_LOWER, grammarAccess.forAllFunctionRule.name))
		"forall_other_higher".assertEquals(valueConverter.toString(ForAllFunctionEnum.FORALL_OTHER_HIGHER, grammarAccess.forAllFunctionRule.name))
	}
}