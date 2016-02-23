package edu.cmu.sei.annex.dmpl.conversion

import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.xtext.common.services.DefaultTerminalConverters
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.ValueConverter
import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.conversion.impl.EFactoryValueConverter
import org.eclipse.xtext.nodemodel.INode

class DmplValueConverterService extends DefaultTerminalConverters {
	@ValueConverter(rule = "Double")
	def IValueConverter<Double> DoubleRule() {
		new IValueConverter<Double> {
			val eDoubleConverter = new EFactoryValueConverter(EcorePackage.eINSTANCE.EDouble)
			
			override toValue(String string, INode node) throws ValueConverterException {
				if (string.trim == "NAN") {
					Double.NaN
				} else {
					eDoubleConverter.toValue(string, node) as Double
				}
			}
			
			override toString(Double value) throws ValueConverterException {
				if (value.naN) {
					"NAN"
				} else {
					eDoubleConverter.toString(value)
				}
			}
		}
	}
}