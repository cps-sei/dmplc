/*
 * generated by Xtext
 */
package edu.cmu.sei.annex.dmpl.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import edu.cmu.sei.annex.dmpl.services.DmplGrammarAccess;

public class DmplParser extends AbstractContentAssistParser {
	
	@Inject
	private DmplGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected edu.cmu.sei.annex.dmpl.ui.contentassist.antlr.internal.InternalDmplParser createParser() {
		edu.cmu.sei.annex.dmpl.ui.contentassist.antlr.internal.InternalDmplParser result = new edu.cmu.sei.annex.dmpl.ui.contentassist.antlr.internal.InternalDmplParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getProgramElementAccess().getAlternatives(), "rule__ProgramElement__Alternatives");
					put(grammarAccess.getConstantAccess().getAlternatives_0(), "rule__Constant__Alternatives_0");
					put(grammarAccess.getNumberConstAccess().getAlternatives(), "rule__NumberConst__Alternatives");
					put(grammarAccess.getVarAsgnAccess().getAlternatives(), "rule__VarAsgn__Alternatives");
					put(grammarAccess.getVarAsgnAccess().getAlternatives_1_1(), "rule__VarAsgn__Alternatives_1_1");
					put(grammarAccess.getVarAsgnAccess().getAlternatives_2_1(), "rule__VarAsgn__Alternatives_2_1");
					put(grammarAccess.getDimensionAccess().getAlternatives(), "rule__Dimension__Alternatives");
					put(grammarAccess.getProcNoAttrAccess().getAlternatives_1(), "rule__ProcNoAttr__Alternatives_1");
					put(grammarAccess.getFnPrototypeAccess().getAlternatives(), "rule__FnPrototype__Alternatives");
					put(grammarAccess.getFnPrototypeAccess().getExternAlternatives_0_1_0(), "rule__FnPrototype__ExternAlternatives_0_1_0");
					put(grammarAccess.getFnPrototypeAccess().getPureAlternatives_0_2_0(), "rule__FnPrototype__PureAlternatives_0_2_0");
					put(grammarAccess.getFnPrototypeAccess().getExternAlternatives_1_1_0(), "rule__FnPrototype__ExternAlternatives_1_1_0");
					put(grammarAccess.getFnPrototypeAccess().getPureAlternatives_1_2_0(), "rule__FnPrototype__PureAlternatives_1_2_0");
					put(grammarAccess.getTerminalExprAccess().getAlternatives(), "rule__TerminalExpr__Alternatives");
					put(grammarAccess.getSignAccess().getAlternatives(), "rule__Sign__Alternatives");
					put(grammarAccess.getSimpTypeAccess().getAlternatives(), "rule__SimpType__Alternatives");
					put(grammarAccess.getSignedAccess().getAlternatives(), "rule__Signed__Alternatives");
					put(grammarAccess.getBuiltInFunctionAccess().getAlternatives(), "rule__BuiltInFunction__Alternatives");
					put(grammarAccess.getDoubleAccess().getAlternatives(), "rule__Double__Alternatives");
					put(grammarAccess.getSignEnumAccess().getAlternatives(), "rule__SignEnum__Alternatives");
					put(grammarAccess.getSimpTypeEnumAccess().getAlternatives(), "rule__SimpTypeEnum__Alternatives");
					put(grammarAccess.getSignedEnumAccess().getAlternatives(), "rule__SignedEnum__Alternatives");
					put(grammarAccess.getEqualityOperatorAccess().getAlternatives(), "rule__EqualityOperator__Alternatives");
					put(grammarAccess.getCompareOperatorAccess().getAlternatives(), "rule__CompareOperator__Alternatives");
					put(grammarAccess.getShiftOperatorAccess().getAlternatives(), "rule__ShiftOperator__Alternatives");
					put(grammarAccess.getAdditiveOperatorAccess().getAlternatives(), "rule__AdditiveOperator__Alternatives");
					put(grammarAccess.getMultiplicativeOperatorAccess().getAlternatives(), "rule__MultiplicativeOperator__Alternatives");
					put(grammarAccess.getUnaryOperatorAccess().getAlternatives(), "rule__UnaryOperator__Alternatives");
					put(grammarAccess.getBuiltInFunctionEnumAccess().getAlternatives(), "rule__BuiltInFunctionEnum__Alternatives");
					put(grammarAccess.getProgramAccess().getGroup(), "rule__Program__Group__0");
					put(grammarAccess.getDmplSubclauseAccess().getGroup(), "rule__DmplSubclause__Group__0");
					put(grammarAccess.getConstantAccess().getGroup(), "rule__Constant__Group__0");
					put(grammarAccess.getIntConstAccess().getGroup(), "rule__IntConst__Group__0");
					put(grammarAccess.getDoubleConstAccess().getGroup(), "rule__DoubleConst__Group__0");
					put(grammarAccess.getVarInitAccess().getGroup(), "rule__VarInit__Group__0");
					put(grammarAccess.getVarInitAccess().getGroup_2(), "rule__VarInit__Group_2__0");
					put(grammarAccess.getVarAsgnAccess().getGroup_0(), "rule__VarAsgn__Group_0__0");
					put(grammarAccess.getVarAsgnAccess().getGroup_1(), "rule__VarAsgn__Group_1__0");
					put(grammarAccess.getVarAsgnAccess().getGroup_1_1_0(), "rule__VarAsgn__Group_1_1_0__0");
					put(grammarAccess.getVarAsgnAccess().getGroup_1_1_1(), "rule__VarAsgn__Group_1_1_1__0");
					put(grammarAccess.getVarAsgnAccess().getGroup_2(), "rule__VarAsgn__Group_2__0");
					put(grammarAccess.getVarAsgnAccess().getGroup_2_1_0(), "rule__VarAsgn__Group_2_1_0__0");
					put(grammarAccess.getVarAsgnAccess().getGroup_2_1_1(), "rule__VarAsgn__Group_2_1_1__0");
					put(grammarAccess.getVarAccess().getGroup(), "rule__Var__Group__0");
					put(grammarAccess.getVarAccess().getGroup_1(), "rule__Var__Group_1__0");
					put(grammarAccess.getDimensionAccess().getGroup_0(), "rule__Dimension__Group_0__0");
					put(grammarAccess.getDimensionAccess().getGroup_1(), "rule__Dimension__Group_1__0");
					put(grammarAccess.getDimensionAccess().getGroup_2(), "rule__Dimension__Group_2__0");
					put(grammarAccess.getTypeAccess().getGroup(), "rule__Type__Group__0");
					put(grammarAccess.getProcNoAttrAccess().getGroup(), "rule__ProcNoAttr__Group__0");
					put(grammarAccess.getFnBodyAccess().getGroup(), "rule__FnBody__Group__0");
					put(grammarAccess.getFnPrototypeAccess().getGroup_0(), "rule__FnPrototype__Group_0__0");
					put(grammarAccess.getFnPrototypeAccess().getGroup_1(), "rule__FnPrototype__Group_1__0");
					put(grammarAccess.getFnPrototypeAccess().getGroup_1_6(), "rule__FnPrototype__Group_1_6__0");
					put(grammarAccess.getFnPrototypeAccess().getGroup_1_6_1(), "rule__FnPrototype__Group_1_6_1__0");
					put(grammarAccess.getParamAccess().getGroup(), "rule__Param__Group__0");
					put(grammarAccess.getVarInitListAccess().getGroup(), "rule__VarInitList__Group__0");
					put(grammarAccess.getVarInitListAccess().getGroup_1(), "rule__VarInitList__Group_1__0");
					put(grammarAccess.getLValAccess().getGroup(), "rule__LVal__Group__0");
					put(grammarAccess.getLValAccess().getGroup_1(), "rule__LVal__Group_1__0");
					put(grammarAccess.getLValAccess().getGroup_2(), "rule__LVal__Group_2__0");
					put(grammarAccess.getExprAccess().getGroup(), "rule__Expr__Group__0");
					put(grammarAccess.getExprAccess().getGroup_1(), "rule__Expr__Group_1__0");
					put(grammarAccess.getExprAccess().getGroup_1_0(), "rule__Expr__Group_1_0__0");
					put(grammarAccess.getExprAccess().getGroup_1_0_0(), "rule__Expr__Group_1_0_0__0");
					put(grammarAccess.getOrExprAccess().getGroup(), "rule__OrExpr__Group__0");
					put(grammarAccess.getOrExprAccess().getGroup_1(), "rule__OrExpr__Group_1__0");
					put(grammarAccess.getOrExprAccess().getGroup_1_0(), "rule__OrExpr__Group_1_0__0");
					put(grammarAccess.getOrExprAccess().getGroup_1_0_0(), "rule__OrExpr__Group_1_0_0__0");
					put(grammarAccess.getAndExprAccess().getGroup(), "rule__AndExpr__Group__0");
					put(grammarAccess.getAndExprAccess().getGroup_1(), "rule__AndExpr__Group_1__0");
					put(grammarAccess.getAndExprAccess().getGroup_1_0(), "rule__AndExpr__Group_1_0__0");
					put(grammarAccess.getAndExprAccess().getGroup_1_0_0(), "rule__AndExpr__Group_1_0_0__0");
					put(grammarAccess.getBitwiseOrExprAccess().getGroup(), "rule__BitwiseOrExpr__Group__0");
					put(grammarAccess.getBitwiseOrExprAccess().getGroup_1(), "rule__BitwiseOrExpr__Group_1__0");
					put(grammarAccess.getBitwiseOrExprAccess().getGroup_1_0(), "rule__BitwiseOrExpr__Group_1_0__0");
					put(grammarAccess.getBitwiseOrExprAccess().getGroup_1_0_0(), "rule__BitwiseOrExpr__Group_1_0_0__0");
					put(grammarAccess.getXorExprAccess().getGroup(), "rule__XorExpr__Group__0");
					put(grammarAccess.getXorExprAccess().getGroup_1(), "rule__XorExpr__Group_1__0");
					put(grammarAccess.getXorExprAccess().getGroup_1_0(), "rule__XorExpr__Group_1_0__0");
					put(grammarAccess.getXorExprAccess().getGroup_1_0_0(), "rule__XorExpr__Group_1_0_0__0");
					put(grammarAccess.getBitwiseAndExprAccess().getGroup(), "rule__BitwiseAndExpr__Group__0");
					put(grammarAccess.getBitwiseAndExprAccess().getGroup_1(), "rule__BitwiseAndExpr__Group_1__0");
					put(grammarAccess.getBitwiseAndExprAccess().getGroup_1_0(), "rule__BitwiseAndExpr__Group_1_0__0");
					put(grammarAccess.getBitwiseAndExprAccess().getGroup_1_0_0(), "rule__BitwiseAndExpr__Group_1_0_0__0");
					put(grammarAccess.getEqualityExprAccess().getGroup(), "rule__EqualityExpr__Group__0");
					put(grammarAccess.getEqualityExprAccess().getGroup_1(), "rule__EqualityExpr__Group_1__0");
					put(grammarAccess.getEqualityExprAccess().getGroup_1_0(), "rule__EqualityExpr__Group_1_0__0");
					put(grammarAccess.getEqualityExprAccess().getGroup_1_0_0(), "rule__EqualityExpr__Group_1_0_0__0");
					put(grammarAccess.getCompareExprAccess().getGroup(), "rule__CompareExpr__Group__0");
					put(grammarAccess.getCompareExprAccess().getGroup_1(), "rule__CompareExpr__Group_1__0");
					put(grammarAccess.getCompareExprAccess().getGroup_1_0(), "rule__CompareExpr__Group_1_0__0");
					put(grammarAccess.getCompareExprAccess().getGroup_1_0_0(), "rule__CompareExpr__Group_1_0_0__0");
					put(grammarAccess.getShiftExprAccess().getGroup(), "rule__ShiftExpr__Group__0");
					put(grammarAccess.getShiftExprAccess().getGroup_1(), "rule__ShiftExpr__Group_1__0");
					put(grammarAccess.getShiftExprAccess().getGroup_1_0(), "rule__ShiftExpr__Group_1_0__0");
					put(grammarAccess.getShiftExprAccess().getGroup_1_0_0(), "rule__ShiftExpr__Group_1_0_0__0");
					put(grammarAccess.getAdditiveExprAccess().getGroup(), "rule__AdditiveExpr__Group__0");
					put(grammarAccess.getAdditiveExprAccess().getGroup_1(), "rule__AdditiveExpr__Group_1__0");
					put(grammarAccess.getAdditiveExprAccess().getGroup_1_0(), "rule__AdditiveExpr__Group_1_0__0");
					put(grammarAccess.getAdditiveExprAccess().getGroup_1_0_0(), "rule__AdditiveExpr__Group_1_0_0__0");
					put(grammarAccess.getMultiplicativeExprAccess().getGroup(), "rule__MultiplicativeExpr__Group__0");
					put(grammarAccess.getMultiplicativeExprAccess().getGroup_1(), "rule__MultiplicativeExpr__Group_1__0");
					put(grammarAccess.getMultiplicativeExprAccess().getGroup_1_0(), "rule__MultiplicativeExpr__Group_1_0__0");
					put(grammarAccess.getMultiplicativeExprAccess().getGroup_1_0_0(), "rule__MultiplicativeExpr__Group_1_0_0__0");
					put(grammarAccess.getTerminalExprAccess().getGroup_1(), "rule__TerminalExpr__Group_1__0");
					put(grammarAccess.getTerminalExprAccess().getGroup_2(), "rule__TerminalExpr__Group_2__0");
					put(grammarAccess.getTerminalExprAccess().getGroup_3(), "rule__TerminalExpr__Group_3__0");
					put(grammarAccess.getTerminalExprAccess().getGroup_4(), "rule__TerminalExpr__Group_4__0");
					put(grammarAccess.getTerminalExprAccess().getGroup_5(), "rule__TerminalExpr__Group_5__0");
					put(grammarAccess.getTerminalExprAccess().getGroup_6(), "rule__TerminalExpr__Group_6__0");
					put(grammarAccess.getTerminalExprAccess().getGroup_8(), "rule__TerminalExpr__Group_8__0");
					put(grammarAccess.getCallExprAccess().getGroup(), "rule__CallExpr__Group__0");
					put(grammarAccess.getCallExprAccess().getGroup_0(), "rule__CallExpr__Group_0__0");
					put(grammarAccess.getCallExprAccess().getGroup_5(), "rule__CallExpr__Group_5__0");
					put(grammarAccess.getArgListAccess().getGroup(), "rule__ArgList__Group__0");
					put(grammarAccess.getArgListAccess().getGroup_1(), "rule__ArgList__Group_1__0");
					put(grammarAccess.getArgListAccess().getGroup_1_1(), "rule__ArgList__Group_1_1__0");
					put(grammarAccess.getDoubleAccess().getGroup_1(), "rule__Double__Group_1__0");
					put(grammarAccess.getProgramAccess().getProgramElementsAssignment_1(), "rule__Program__ProgramElementsAssignment_1");
					put(grammarAccess.getDmplSubclauseAccess().getProgramAssignment_1(), "rule__DmplSubclause__ProgramAssignment_1");
					put(grammarAccess.getConstantAccess().getNameAssignment_1(), "rule__Constant__NameAssignment_1");
					put(grammarAccess.getConstantAccess().getValueAssignment_3(), "rule__Constant__ValueAssignment_3");
					put(grammarAccess.getIntConstAccess().getSignAssignment_0(), "rule__IntConst__SignAssignment_0");
					put(grammarAccess.getIntConstAccess().getValueAssignment_1(), "rule__IntConst__ValueAssignment_1");
					put(grammarAccess.getDoubleConstAccess().getSignAssignment_0(), "rule__DoubleConst__SignAssignment_0");
					put(grammarAccess.getDoubleConstAccess().getValueAssignment_1(), "rule__DoubleConst__ValueAssignment_1");
					put(grammarAccess.getVarInitAccess().getTypeAssignment_0(), "rule__VarInit__TypeAssignment_0");
					put(grammarAccess.getVarInitAccess().getVarInitItemsAssignment_1(), "rule__VarInit__VarInitItemsAssignment_1");
					put(grammarAccess.getVarInitAccess().getVarInitItemsAssignment_2_1(), "rule__VarInit__VarInitItemsAssignment_2_1");
					put(grammarAccess.getVarAsgnAccess().getInputAssignment_0_0(), "rule__VarAsgn__InputAssignment_0_0");
					put(grammarAccess.getVarAsgnAccess().getVarAssignment_0_1(), "rule__VarAsgn__VarAssignment_0_1");
					put(grammarAccess.getVarAsgnAccess().getVarAssignment_1_1_0_0(), "rule__VarAsgn__VarAssignment_1_1_0_0");
					put(grammarAccess.getVarAsgnAccess().getInputAssignment_1_1_1_0(), "rule__VarAsgn__InputAssignment_1_1_1_0");
					put(grammarAccess.getVarAsgnAccess().getVarAssignment_1_1_1_1(), "rule__VarAsgn__VarAssignment_1_1_1_1");
					put(grammarAccess.getVarAsgnAccess().getExprAssignment_1_2(), "rule__VarAsgn__ExprAssignment_1_2");
					put(grammarAccess.getVarAsgnAccess().getVarAssignment_2_1_0_0(), "rule__VarAsgn__VarAssignment_2_1_0_0");
					put(grammarAccess.getVarAsgnAccess().getInputAssignment_2_1_1_0(), "rule__VarAsgn__InputAssignment_2_1_1_0");
					put(grammarAccess.getVarAsgnAccess().getVarAssignment_2_1_1_1(), "rule__VarAsgn__VarAssignment_2_1_1_1");
					put(grammarAccess.getVarAsgnAccess().getFnBodyAssignment_2_2(), "rule__VarAsgn__FnBodyAssignment_2_2");
					put(grammarAccess.getVarAccess().getNameAssignment_0(), "rule__Var__NameAssignment_0");
					put(grammarAccess.getVarAccess().getDimensionsAssignment_1_1(), "rule__Var__DimensionsAssignment_1_1");
					put(grammarAccess.getDimensionAccess().getIndexAssignment_0_1(), "rule__Dimension__IndexAssignment_0_1");
					put(grammarAccess.getDimensionAccess().getIndexAssignment_2_1(), "rule__Dimension__IndexAssignment_2_1");
					put(grammarAccess.getTypeAccess().getSignedAssignment_0(), "rule__Type__SignedAssignment_0");
					put(grammarAccess.getTypeAccess().getSimpTypeAssignment_1(), "rule__Type__SimpTypeAssignment_1");
					put(grammarAccess.getProcedureAccess().getProcedureAssignment(), "rule__Procedure__ProcedureAssignment");
					put(grammarAccess.getProcNoAttrAccess().getPrototypeAssignment_0(), "rule__ProcNoAttr__PrototypeAssignment_0");
					put(grammarAccess.getProcNoAttrAccess().getFnBodyAssignment_1_1(), "rule__ProcNoAttr__FnBodyAssignment_1_1");
					put(grammarAccess.getFnBodyAccess().getVarInitListAssignment_1(), "rule__FnBody__VarInitListAssignment_1");
					put(grammarAccess.getFnPrototypeAccess().getExternAssignment_0_1(), "rule__FnPrototype__ExternAssignment_0_1");
					put(grammarAccess.getFnPrototypeAccess().getPureAssignment_0_2(), "rule__FnPrototype__PureAssignment_0_2");
					put(grammarAccess.getFnPrototypeAccess().getNameAssignment_0_4(), "rule__FnPrototype__NameAssignment_0_4");
					put(grammarAccess.getFnPrototypeAccess().getExternAssignment_1_1(), "rule__FnPrototype__ExternAssignment_1_1");
					put(grammarAccess.getFnPrototypeAccess().getPureAssignment_1_2(), "rule__FnPrototype__PureAssignment_1_2");
					put(grammarAccess.getFnPrototypeAccess().getTypeAssignment_1_3(), "rule__FnPrototype__TypeAssignment_1_3");
					put(grammarAccess.getFnPrototypeAccess().getNameAssignment_1_4(), "rule__FnPrototype__NameAssignment_1_4");
					put(grammarAccess.getFnPrototypeAccess().getParamsAssignment_1_6_0(), "rule__FnPrototype__ParamsAssignment_1_6_0");
					put(grammarAccess.getFnPrototypeAccess().getParamsAssignment_1_6_1_1(), "rule__FnPrototype__ParamsAssignment_1_6_1_1");
					put(grammarAccess.getParamAccess().getTypeAssignment_0(), "rule__Param__TypeAssignment_0");
					put(grammarAccess.getParamAccess().getVarAssignment_1(), "rule__Param__VarAssignment_1");
					put(grammarAccess.getVarInitListAccess().getVarInitsAssignment_1_0(), "rule__VarInitList__VarInitsAssignment_1_0");
					put(grammarAccess.getLValAccess().getNameAssignment_0(), "rule__LVal__NameAssignment_0");
					put(grammarAccess.getLValAccess().getIndicesAssignment_1_1(), "rule__LVal__IndicesAssignment_1_1");
					put(grammarAccess.getLValAccess().getAtAssignment_2_1(), "rule__LVal__AtAssignment_2_1");
					put(grammarAccess.getExprAccess().getThenAssignment_1_1(), "rule__Expr__ThenAssignment_1_1");
					put(grammarAccess.getExprAccess().getElseAssignment_1_3(), "rule__Expr__ElseAssignment_1_3");
					put(grammarAccess.getOrExprAccess().getRightAssignment_1_1(), "rule__OrExpr__RightAssignment_1_1");
					put(grammarAccess.getAndExprAccess().getRightAssignment_1_1(), "rule__AndExpr__RightAssignment_1_1");
					put(grammarAccess.getBitwiseOrExprAccess().getRightAssignment_1_1(), "rule__BitwiseOrExpr__RightAssignment_1_1");
					put(grammarAccess.getXorExprAccess().getRightAssignment_1_1(), "rule__XorExpr__RightAssignment_1_1");
					put(grammarAccess.getBitwiseAndExprAccess().getRightAssignment_1_1(), "rule__BitwiseAndExpr__RightAssignment_1_1");
					put(grammarAccess.getEqualityExprAccess().getOperatorAssignment_1_0_0_1(), "rule__EqualityExpr__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getEqualityExprAccess().getRightAssignment_1_1(), "rule__EqualityExpr__RightAssignment_1_1");
					put(grammarAccess.getCompareExprAccess().getOperatorAssignment_1_0_0_1(), "rule__CompareExpr__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getCompareExprAccess().getRightAssignment_1_1(), "rule__CompareExpr__RightAssignment_1_1");
					put(grammarAccess.getShiftExprAccess().getOperatorAssignment_1_0_0_1(), "rule__ShiftExpr__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getShiftExprAccess().getRightAssignment_1_1(), "rule__ShiftExpr__RightAssignment_1_1");
					put(grammarAccess.getAdditiveExprAccess().getOperatorAssignment_1_0_0_1(), "rule__AdditiveExpr__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getAdditiveExprAccess().getRightAssignment_1_1(), "rule__AdditiveExpr__RightAssignment_1_1");
					put(grammarAccess.getMultiplicativeExprAccess().getOperatorAssignment_1_0_0_1(), "rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getMultiplicativeExprAccess().getRightAssignment_1_1(), "rule__MultiplicativeExpr__RightAssignment_1_1");
					put(grammarAccess.getTerminalExprAccess().getValueAssignment_2_1(), "rule__TerminalExpr__ValueAssignment_2_1");
					put(grammarAccess.getTerminalExprAccess().getValueAssignment_3_1(), "rule__TerminalExpr__ValueAssignment_3_1");
					put(grammarAccess.getTerminalExprAccess().getOperatorAssignment_5_1(), "rule__TerminalExpr__OperatorAssignment_5_1");
					put(grammarAccess.getTerminalExprAccess().getOperandAssignment_5_2(), "rule__TerminalExpr__OperandAssignment_5_2");
					put(grammarAccess.getTerminalExprAccess().getFunctionAssignment_6_1(), "rule__TerminalExpr__FunctionAssignment_6_1");
					put(grammarAccess.getTerminalExprAccess().getFirstArgAssignment_6_3(), "rule__TerminalExpr__FirstArgAssignment_6_3");
					put(grammarAccess.getTerminalExprAccess().getSecondArgAssignment_6_5(), "rule__TerminalExpr__SecondArgAssignment_6_5");
					put(grammarAccess.getCallExprAccess().getNamespaceAssignment_0_0(), "rule__CallExpr__NamespaceAssignment_0_0");
					put(grammarAccess.getCallExprAccess().getNameAssignment_1(), "rule__CallExpr__NameAssignment_1");
					put(grammarAccess.getCallExprAccess().getArgListAssignment_3(), "rule__CallExpr__ArgListAssignment_3");
					put(grammarAccess.getCallExprAccess().getAtAssignment_5_1(), "rule__CallExpr__AtAssignment_5_1");
					put(grammarAccess.getArgListAccess().getArgsAssignment_1_0(), "rule__ArgList__ArgsAssignment_1_0");
					put(grammarAccess.getArgListAccess().getArgsAssignment_1_1_1(), "rule__ArgList__ArgsAssignment_1_1_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			edu.cmu.sei.annex.dmpl.ui.contentassist.antlr.internal.InternalDmplParser typedParser = (edu.cmu.sei.annex.dmpl.ui.contentassist.antlr.internal.InternalDmplParser) parser;
			typedParser.entryRuleProgram();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public DmplGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(DmplGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
