package edu.cmu.sei.annex.dmpl.conversion

import edu.cmu.sei.annex.dmpl.dmpl.BuiltInFunctionEnum
import edu.cmu.sei.annex.dmpl.dmpl.DmplPackage
import edu.cmu.sei.annex.dmpl.dmpl.ForAllFunctionEnum
import edu.cmu.sei.annex.dmpl.dmpl.NodeVarScopeEnum
import edu.cmu.sei.annex.dmpl.dmpl.SimpTypeEnum
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
				if (string?.trim == "NAN") {
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
	
	@ValueConverter(rule = "SimpType")
	def IValueConverter<SimpTypeEnum> SimpType() {
		new IValueConverter<SimpTypeEnum> {
			val simpTypeEnumConverter = new EFactoryValueConverter(DmplPackage.eINSTANCE.simpTypeEnum)
			
			override toValue(String string, INode node) throws ValueConverterException {
				if (string?.trim == "_Bool") {
					SimpTypeEnum.BOOL
				} else {
					simpTypeEnumConverter.toValue(string, node) as SimpTypeEnum
				}
			}
			
			override toString(SimpTypeEnum value) throws ValueConverterException {
				simpTypeEnumConverter.toString(value)
			}
		}
	}
	
	@ValueConverter(rule = "BuiltInFunction")
	def IValueConverter<BuiltInFunctionEnum> BuiltInFunction() {
		new IValueConverter<BuiltInFunctionEnum> {
			val builtInFunctionEnumConverter = new EFactoryValueConverter(DmplPackage.eINSTANCE.builtInFunctionEnum)
			
			override toValue(String string, INode node) throws ValueConverterException {
				switch string?.trim {
					case "EXISTS_OTHER": BuiltInFunctionEnum.EXISTS_OTHER
					case "EXISTS_HIGHER": BuiltInFunctionEnum.EXISTS_HIGHER
					case "EXISTS_LOWER": BuiltInFunctionEnum.EXISTS_LOWER
					default: builtInFunctionEnumConverter.toValue(string, node) as BuiltInFunctionEnum
				}
			}
			
			override toString(BuiltInFunctionEnum value) throws ValueConverterException {
				builtInFunctionEnumConverter.toString(value)
			}
		}
	}
	
	@ValueConverter(rule = "ForAllFunction")
	def IValueConverter<ForAllFunctionEnum> ForAllFunction() {
		new IValueConverter<ForAllFunctionEnum> {
			val forAllFunctionEnumConverter = new EFactoryValueConverter(DmplPackage.eINSTANCE.forAllFunctionEnum)
			
			override toValue(String string, INode node) throws ValueConverterException {
				switch string?.trim {
					case "FORALL_NODE": ForAllFunctionEnum.FORALL_NODE
					case "FORALL_OTHER": ForAllFunctionEnum.FORALL_OTHER
					case "FORALL_OTHER_LOWER": ForAllFunctionEnum.FORALL_OTHER_LOWER
					case "FORALL_OTHER_HIGHER": ForAllFunctionEnum.FORALL_OTHER_HIGHER
					default: forAllFunctionEnumConverter.toValue(string, node) as ForAllFunctionEnum
				}
			}
			
			override toString(ForAllFunctionEnum value) throws ValueConverterException {
				forAllFunctionEnumConverter.toString(value)
			}
		}
	}
	
	@ValueConverter(rule = "NodeVarScope")
	def IValueConverter<NodeVarScopeEnum> NodeVarScope() {
		new IValueConverter<NodeVarScopeEnum> {
			val nodeVarScopeEnumConverter = new EFactoryValueConverter(DmplPackage.eINSTANCE.nodeVarScopeEnum)
			
			override toValue(String string, INode node) throws ValueConverterException {
				switch string?.trim {
					case "GLOBAL": NodeVarScopeEnum.GLOBAL
					case "LOCAL": NodeVarScopeEnum.LOCAL
					default: nodeVarScopeEnumConverter.toValue(string, node) as NodeVarScopeEnum
				}
			}
			
			override toString(NodeVarScopeEnum value) throws ValueConverterException {
				nodeVarScopeEnumConverter.toString(value)
			}
		}
	}
}