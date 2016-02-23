package edu.cmu.sei.annex.dmpl.tests

import com.google.inject.Inject
import edu.cmu.sei.annex.dmpl.DmplInjectorProvider
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
	def void testToValue() {
		12.34.assertEquals(valueConverter.toValue("12.34", grammarAccess.doubleRule.name, null))
		Double.NaN.assertEquals(valueConverter.toValue("NAN", grammarAccess.doubleRule.name, null))
	}
	
	@Test
	def void testToString() {
		"12.34".assertEquals(valueConverter.toString(12.34, grammarAccess.doubleRule.name))
		"NAN".assertEquals(valueConverter.toString(Double.NaN, grammarAccess.doubleRule.name))
	}
}