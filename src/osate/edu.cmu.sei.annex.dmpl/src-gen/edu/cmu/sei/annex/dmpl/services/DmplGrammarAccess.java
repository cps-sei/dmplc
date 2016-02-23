/*
 * generated by Xtext
 */
package edu.cmu.sei.annex.dmpl.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class DmplGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class ProgramElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Program");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cProgramAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cProgramElementsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cProgramElementsProgramElementParserRuleCall_1_0 = (RuleCall)cProgramElementsAssignment_1.eContents().get(0);
		
		//Program:
		//	{Program} programElements+=ProgramElement*;
		@Override public ParserRule getRule() { return rule; }

		//{Program} programElements+=ProgramElement*
		public Group getGroup() { return cGroup; }

		//{Program}
		public Action getProgramAction_0() { return cProgramAction_0; }

		//programElements+=ProgramElement*
		public Assignment getProgramElementsAssignment_1() { return cProgramElementsAssignment_1; }

		//ProgramElement
		public RuleCall getProgramElementsProgramElementParserRuleCall_1_0() { return cProgramElementsProgramElementParserRuleCall_1_0; }
	}

	public class AnnexSubclauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AnnexSubclause");
		private final RuleCall cDmplSubclauseParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//AnnexSubclause returns aadl2::AnnexSubclause:
		//	DmplSubclause;
		@Override public ParserRule getRule() { return rule; }

		//DmplSubclause
		public RuleCall getDmplSubclauseParserRuleCall() { return cDmplSubclauseParserRuleCall; }
	}

	public class DmplSubclauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DmplSubclause");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cDmplSubclauseAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cProgramAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cProgramProgramParserRuleCall_1_0 = (RuleCall)cProgramAssignment_1.eContents().get(0);
		
		//DmplSubclause:
		//	{DmplSubclause} program=Program;
		@Override public ParserRule getRule() { return rule; }

		//{DmplSubclause} program=Program
		public Group getGroup() { return cGroup; }

		//{DmplSubclause}
		public Action getDmplSubclauseAction_0() { return cDmplSubclauseAction_0; }

		//program=Program
		public Assignment getProgramAssignment_1() { return cProgramAssignment_1; }

		//Program
		public RuleCall getProgramProgramParserRuleCall_1_0() { return cProgramProgramParserRuleCall_1_0; }
	}

	public class ProgramElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ProgramElement");
		private final RuleCall cConstantParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//ProgramElement: //TODO: target, node, procedure
		//	Constant;
		@Override public ParserRule getRule() { return rule; }

		////TODO: target, node, procedure
		//Constant
		public RuleCall getConstantParserRuleCall() { return cConstantParserRuleCall; }
	}

	public class ConstantElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Constant");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cConstKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Keyword cCONSTKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameTIDENTIFIERTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cValueNumberConstParserRuleCall_3_0 = (RuleCall)cValueAssignment_3.eContents().get(0);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//Constant:
		//	("const" | "CONST") name=TIDENTIFIER "=" value=NumberConst ";";
		@Override public ParserRule getRule() { return rule; }

		//("const" | "CONST") name=TIDENTIFIER "=" value=NumberConst ";"
		public Group getGroup() { return cGroup; }

		//"const" | "CONST"
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//"const"
		public Keyword getConstKeyword_0_0() { return cConstKeyword_0_0; }

		//"CONST"
		public Keyword getCONSTKeyword_0_1() { return cCONSTKeyword_0_1; }

		//name=TIDENTIFIER
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//TIDENTIFIER
		public RuleCall getNameTIDENTIFIERTerminalRuleCall_1_0() { return cNameTIDENTIFIERTerminalRuleCall_1_0; }

		//"="
		public Keyword getEqualsSignKeyword_2() { return cEqualsSignKeyword_2; }

		//value=NumberConst
		public Assignment getValueAssignment_3() { return cValueAssignment_3; }

		//NumberConst
		public RuleCall getValueNumberConstParserRuleCall_3_0() { return cValueNumberConstParserRuleCall_3_0; }

		//";"
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}

	public class NumberConstElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NumberConst");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIntConstParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cDoubleConstParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//NumberConst:
		//	IntConst | DoubleConst;
		@Override public ParserRule getRule() { return rule; }

		//IntConst | DoubleConst
		public Alternatives getAlternatives() { return cAlternatives; }

		//IntConst
		public RuleCall getIntConstParserRuleCall_0() { return cIntConstParserRuleCall_0; }

		//DoubleConst
		public RuleCall getDoubleConstParserRuleCall_1() { return cDoubleConstParserRuleCall_1; }
	}

	public class IntConstElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IntConst");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSignAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Alternatives cSignAlternatives_0_0 = (Alternatives)cSignAssignment_0.eContents().get(0);
		private final Keyword cSignPlusSignKeyword_0_0_0 = (Keyword)cSignAlternatives_0_0.eContents().get(0);
		private final Keyword cSignHyphenMinusKeyword_0_0_1 = (Keyword)cSignAlternatives_0_0.eContents().get(1);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueINTTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//IntConst:
		//	sign=("+" | "-")? value=INT;
		@Override public ParserRule getRule() { return rule; }

		//sign=("+" | "-")? value=INT
		public Group getGroup() { return cGroup; }

		//sign=("+" | "-")?
		public Assignment getSignAssignment_0() { return cSignAssignment_0; }

		//"+" | "-"
		public Alternatives getSignAlternatives_0_0() { return cSignAlternatives_0_0; }

		//"+"
		public Keyword getSignPlusSignKeyword_0_0_0() { return cSignPlusSignKeyword_0_0_0; }

		//"-"
		public Keyword getSignHyphenMinusKeyword_0_0_1() { return cSignHyphenMinusKeyword_0_0_1; }

		//value=INT
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//INT
		public RuleCall getValueINTTerminalRuleCall_1_0() { return cValueINTTerminalRuleCall_1_0; }
	}

	public class DoubleConstElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DoubleConst");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSignAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Alternatives cSignAlternatives_0_0 = (Alternatives)cSignAssignment_0.eContents().get(0);
		private final Keyword cSignPlusSignKeyword_0_0_0 = (Keyword)cSignAlternatives_0_0.eContents().get(0);
		private final Keyword cSignHyphenMinusKeyword_0_0_1 = (Keyword)cSignAlternatives_0_0.eContents().get(1);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueDoubleParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//DoubleConst:
		//	sign=("+" | "-")? value=Double;
		@Override public ParserRule getRule() { return rule; }

		//sign=("+" | "-")? value=Double
		public Group getGroup() { return cGroup; }

		//sign=("+" | "-")?
		public Assignment getSignAssignment_0() { return cSignAssignment_0; }

		//"+" | "-"
		public Alternatives getSignAlternatives_0_0() { return cSignAlternatives_0_0; }

		//"+"
		public Keyword getSignPlusSignKeyword_0_0_0() { return cSignPlusSignKeyword_0_0_0; }

		//"-"
		public Keyword getSignHyphenMinusKeyword_0_0_1() { return cSignHyphenMinusKeyword_0_0_1; }

		//value=Double
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//Double
		public RuleCall getValueDoubleParserRuleCall_1_0() { return cValueDoubleParserRuleCall_1_0; }
	}

	public class DoubleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Double");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cNANKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_1_0 = (RuleCall)cGroup_1.eContents().get(0);
		private final Keyword cFullStopKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final RuleCall cINTTerminalRuleCall_1_2 = (RuleCall)cGroup_1.eContents().get(2);
		
		//Double returns ecore::EDouble:
		//	"NAN" | INT "." INT?;
		@Override public ParserRule getRule() { return rule; }

		//"NAN" | INT "." INT?
		public Alternatives getAlternatives() { return cAlternatives; }

		//"NAN"
		public Keyword getNANKeyword_0() { return cNANKeyword_0; }

		//INT "." INT?
		public Group getGroup_1() { return cGroup_1; }

		//INT
		public RuleCall getINTTerminalRuleCall_1_0() { return cINTTerminalRuleCall_1_0; }

		//"."
		public Keyword getFullStopKeyword_1_1() { return cFullStopKeyword_1_1; }

		//INT?
		public RuleCall getINTTerminalRuleCall_1_2() { return cINTTerminalRuleCall_1_2; }
	}
	
	
	private final ProgramElements pProgram;
	private final AnnexSubclauseElements pAnnexSubclause;
	private final DmplSubclauseElements pDmplSubclause;
	private final ProgramElementElements pProgramElement;
	private final ConstantElements pConstant;
	private final NumberConstElements pNumberConst;
	private final IntConstElements pIntConst;
	private final DoubleConstElements pDoubleConst;
	private final DoubleElements pDouble;
	private final TerminalRule tTIDENTIFIER;
	
	private final Grammar grammar;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public DmplGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pProgram = new ProgramElements();
		this.pAnnexSubclause = new AnnexSubclauseElements();
		this.pDmplSubclause = new DmplSubclauseElements();
		this.pProgramElement = new ProgramElementElements();
		this.pConstant = new ConstantElements();
		this.pNumberConst = new NumberConstElements();
		this.pIntConst = new IntConstElements();
		this.pDoubleConst = new DoubleConstElements();
		this.pDouble = new DoubleElements();
		this.tTIDENTIFIER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "TIDENTIFIER");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("edu.cmu.sei.annex.dmpl.Dmpl".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Program:
	//	{Program} programElements+=ProgramElement*;
	public ProgramElements getProgramAccess() {
		return pProgram;
	}
	
	public ParserRule getProgramRule() {
		return getProgramAccess().getRule();
	}

	//AnnexSubclause returns aadl2::AnnexSubclause:
	//	DmplSubclause;
	public AnnexSubclauseElements getAnnexSubclauseAccess() {
		return pAnnexSubclause;
	}
	
	public ParserRule getAnnexSubclauseRule() {
		return getAnnexSubclauseAccess().getRule();
	}

	//DmplSubclause:
	//	{DmplSubclause} program=Program;
	public DmplSubclauseElements getDmplSubclauseAccess() {
		return pDmplSubclause;
	}
	
	public ParserRule getDmplSubclauseRule() {
		return getDmplSubclauseAccess().getRule();
	}

	//ProgramElement: //TODO: target, node, procedure
	//	Constant;
	public ProgramElementElements getProgramElementAccess() {
		return pProgramElement;
	}
	
	public ParserRule getProgramElementRule() {
		return getProgramElementAccess().getRule();
	}

	//Constant:
	//	("const" | "CONST") name=TIDENTIFIER "=" value=NumberConst ";";
	public ConstantElements getConstantAccess() {
		return pConstant;
	}
	
	public ParserRule getConstantRule() {
		return getConstantAccess().getRule();
	}

	//NumberConst:
	//	IntConst | DoubleConst;
	public NumberConstElements getNumberConstAccess() {
		return pNumberConst;
	}
	
	public ParserRule getNumberConstRule() {
		return getNumberConstAccess().getRule();
	}

	//IntConst:
	//	sign=("+" | "-")? value=INT;
	public IntConstElements getIntConstAccess() {
		return pIntConst;
	}
	
	public ParserRule getIntConstRule() {
		return getIntConstAccess().getRule();
	}

	//DoubleConst:
	//	sign=("+" | "-")? value=Double;
	public DoubleConstElements getDoubleConstAccess() {
		return pDoubleConst;
	}
	
	public ParserRule getDoubleConstRule() {
		return getDoubleConstAccess().getRule();
	}

	//Double returns ecore::EDouble:
	//	"NAN" | INT "." INT?;
	public DoubleElements getDoubleAccess() {
		return pDouble;
	}
	
	public ParserRule getDoubleRule() {
		return getDoubleAccess().getRule();
	}

	//terminal TIDENTIFIER:
	//	("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getTIDENTIFIERRule() {
		return tTIDENTIFIER;
	} 

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" . / * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\""))* "\"" | "\'" ("\\" .
	//	/ * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
