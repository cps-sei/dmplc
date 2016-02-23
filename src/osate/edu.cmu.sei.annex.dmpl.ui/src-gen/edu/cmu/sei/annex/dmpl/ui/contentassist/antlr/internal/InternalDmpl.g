/*
 * generated by Xtext
 */
grammar InternalDmpl;

options {
	superClass=AbstractInternalContentAssistParser;
	
}

@lexer::header {
package edu.cmu.sei.annex.dmpl.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package edu.cmu.sei.annex.dmpl.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import edu.cmu.sei.annex.dmpl.services.DmplGrammarAccess;

}

@parser::members {
 
 	private DmplGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(DmplGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }
    
    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuleProgram
entryRuleProgram 
:
{ before(grammarAccess.getProgramRule()); }
	 ruleProgram
{ after(grammarAccess.getProgramRule()); } 
	 EOF 
;

// Rule Program
ruleProgram
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getProgramAccess().getGroup()); }
(rule__Program__Group__0)
{ after(grammarAccess.getProgramAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}





// Entry rule entryRuleDmplSubclause
entryRuleDmplSubclause 
:
{ before(grammarAccess.getDmplSubclauseRule()); }
	 ruleDmplSubclause
{ after(grammarAccess.getDmplSubclauseRule()); } 
	 EOF 
;

// Rule DmplSubclause
ruleDmplSubclause
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDmplSubclauseAccess().getGroup()); }
(rule__DmplSubclause__Group__0)
{ after(grammarAccess.getDmplSubclauseAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleProgramElement
entryRuleProgramElement 
:
{ before(grammarAccess.getProgramElementRule()); }
	 ruleProgramElement
{ after(grammarAccess.getProgramElementRule()); } 
	 EOF 
;

// Rule ProgramElement
ruleProgramElement
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getProgramElementAccess().getConstantParserRuleCall()); }
	ruleConstant
{ after(grammarAccess.getProgramElementAccess().getConstantParserRuleCall()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleConstant
entryRuleConstant 
:
{ before(grammarAccess.getConstantRule()); }
	 ruleConstant
{ after(grammarAccess.getConstantRule()); } 
	 EOF 
;

// Rule Constant
ruleConstant
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getConstantAccess().getGroup()); }
(rule__Constant__Group__0)
{ after(grammarAccess.getConstantAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleNumberConst
entryRuleNumberConst 
:
{ before(grammarAccess.getNumberConstRule()); }
	 ruleNumberConst
{ after(grammarAccess.getNumberConstRule()); } 
	 EOF 
;

// Rule NumberConst
ruleNumberConst
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getNumberConstAccess().getAlternatives()); }
(rule__NumberConst__Alternatives)
{ after(grammarAccess.getNumberConstAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleIntConst
entryRuleIntConst 
:
{ before(grammarAccess.getIntConstRule()); }
	 ruleIntConst
{ after(grammarAccess.getIntConstRule()); } 
	 EOF 
;

// Rule IntConst
ruleIntConst
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getIntConstAccess().getGroup()); }
(rule__IntConst__Group__0)
{ after(grammarAccess.getIntConstAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDoubleConst
entryRuleDoubleConst 
:
{ before(grammarAccess.getDoubleConstRule()); }
	 ruleDoubleConst
{ after(grammarAccess.getDoubleConstRule()); } 
	 EOF 
;

// Rule DoubleConst
ruleDoubleConst
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDoubleConstAccess().getGroup()); }
(rule__DoubleConst__Group__0)
{ after(grammarAccess.getDoubleConstAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleDouble
entryRuleDouble 
:
{ before(grammarAccess.getDoubleRule()); }
	 ruleDouble
{ after(grammarAccess.getDoubleRule()); } 
	 EOF 
;

// Rule Double
ruleDouble
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getDoubleAccess().getAlternatives()); }
(rule__Double__Alternatives)
{ after(grammarAccess.getDoubleAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__Constant__Alternatives_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConstantAccess().getConstKeyword_0_0()); }

	'const' 

{ after(grammarAccess.getConstantAccess().getConstKeyword_0_0()); }
)

    |(
{ before(grammarAccess.getConstantAccess().getCONSTKeyword_0_1()); }

	'CONST' 

{ after(grammarAccess.getConstantAccess().getCONSTKeyword_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__NumberConst__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getNumberConstAccess().getIntConstParserRuleCall_0()); }
	ruleIntConst
{ after(grammarAccess.getNumberConstAccess().getIntConstParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getNumberConstAccess().getDoubleConstParserRuleCall_1()); }
	ruleDoubleConst
{ after(grammarAccess.getNumberConstAccess().getDoubleConstParserRuleCall_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IntConst__SignAlternatives_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIntConstAccess().getSignPlusSignKeyword_0_0_0()); }

	'+' 

{ after(grammarAccess.getIntConstAccess().getSignPlusSignKeyword_0_0_0()); }
)

    |(
{ before(grammarAccess.getIntConstAccess().getSignHyphenMinusKeyword_0_0_1()); }

	'-' 

{ after(grammarAccess.getIntConstAccess().getSignHyphenMinusKeyword_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DoubleConst__SignAlternatives_0_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDoubleConstAccess().getSignPlusSignKeyword_0_0_0()); }

	'+' 

{ after(grammarAccess.getDoubleConstAccess().getSignPlusSignKeyword_0_0_0()); }
)

    |(
{ before(grammarAccess.getDoubleConstAccess().getSignHyphenMinusKeyword_0_0_1()); }

	'-' 

{ after(grammarAccess.getDoubleConstAccess().getSignHyphenMinusKeyword_0_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Double__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDoubleAccess().getNANKeyword_0()); }

	'NAN' 

{ after(grammarAccess.getDoubleAccess().getNANKeyword_0()); }
)

    |(
{ before(grammarAccess.getDoubleAccess().getGroup_1()); }
(rule__Double__Group_1__0)
{ after(grammarAccess.getDoubleAccess().getGroup_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__Program__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Program__Group__0__Impl
	rule__Program__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Program__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getProgramAccess().getProgramAction_0()); }
(

)
{ after(grammarAccess.getProgramAccess().getProgramAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Program__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Program__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Program__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getProgramAccess().getProgramElementsAssignment_1()); }
(rule__Program__ProgramElementsAssignment_1)*
{ after(grammarAccess.getProgramAccess().getProgramElementsAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DmplSubclause__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DmplSubclause__Group__0__Impl
	rule__DmplSubclause__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DmplSubclause__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDmplSubclauseAccess().getDmplSubclauseAction_0()); }
(

)
{ after(grammarAccess.getDmplSubclauseAccess().getDmplSubclauseAction_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DmplSubclause__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DmplSubclause__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DmplSubclause__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDmplSubclauseAccess().getProgramAssignment_1()); }
(rule__DmplSubclause__ProgramAssignment_1)
{ after(grammarAccess.getDmplSubclauseAccess().getProgramAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Constant__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Constant__Group__0__Impl
	rule__Constant__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Constant__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConstantAccess().getAlternatives_0()); }
(rule__Constant__Alternatives_0)
{ after(grammarAccess.getConstantAccess().getAlternatives_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Constant__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Constant__Group__1__Impl
	rule__Constant__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Constant__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConstantAccess().getNameAssignment_1()); }
(rule__Constant__NameAssignment_1)
{ after(grammarAccess.getConstantAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Constant__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Constant__Group__2__Impl
	rule__Constant__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Constant__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConstantAccess().getEqualsSignKeyword_2()); }

	'=' 

{ after(grammarAccess.getConstantAccess().getEqualsSignKeyword_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Constant__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Constant__Group__3__Impl
	rule__Constant__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Constant__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConstantAccess().getValueAssignment_3()); }
(rule__Constant__ValueAssignment_3)
{ after(grammarAccess.getConstantAccess().getValueAssignment_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Constant__Group__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Constant__Group__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Constant__Group__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConstantAccess().getSemicolonKeyword_4()); }

	';' 

{ after(grammarAccess.getConstantAccess().getSemicolonKeyword_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__IntConst__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IntConst__Group__0__Impl
	rule__IntConst__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__IntConst__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIntConstAccess().getSignAssignment_0()); }
(rule__IntConst__SignAssignment_0)?
{ after(grammarAccess.getIntConstAccess().getSignAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__IntConst__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__IntConst__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__IntConst__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIntConstAccess().getValueAssignment_1()); }
(rule__IntConst__ValueAssignment_1)
{ after(grammarAccess.getIntConstAccess().getValueAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__DoubleConst__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DoubleConst__Group__0__Impl
	rule__DoubleConst__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__DoubleConst__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDoubleConstAccess().getSignAssignment_0()); }
(rule__DoubleConst__SignAssignment_0)?
{ after(grammarAccess.getDoubleConstAccess().getSignAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__DoubleConst__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__DoubleConst__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__DoubleConst__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDoubleConstAccess().getValueAssignment_1()); }
(rule__DoubleConst__ValueAssignment_1)
{ after(grammarAccess.getDoubleConstAccess().getValueAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Double__Group_1__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Double__Group_1__0__Impl
	rule__Double__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Double__Group_1__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_0()); }
	RULE_INT
{ after(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Double__Group_1__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Double__Group_1__1__Impl
	rule__Double__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Double__Group_1__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDoubleAccess().getFullStopKeyword_1_1()); }

	'.' 

{ after(grammarAccess.getDoubleAccess().getFullStopKeyword_1_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Double__Group_1__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Double__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Double__Group_1__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_2()); }
(	RULE_INT)?
{ after(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}









rule__Program__ProgramElementsAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getProgramAccess().getProgramElementsProgramElementParserRuleCall_1_0()); }
	ruleProgramElement{ after(grammarAccess.getProgramAccess().getProgramElementsProgramElementParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DmplSubclause__ProgramAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDmplSubclauseAccess().getProgramProgramParserRuleCall_1_0()); }
	ruleProgram{ after(grammarAccess.getDmplSubclauseAccess().getProgramProgramParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Constant__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConstantAccess().getNameTIDENTIFIERTerminalRuleCall_1_0()); }
	RULE_TIDENTIFIER{ after(grammarAccess.getConstantAccess().getNameTIDENTIFIERTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Constant__ValueAssignment_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getConstantAccess().getValueNumberConstParserRuleCall_3_0()); }
	ruleNumberConst{ after(grammarAccess.getConstantAccess().getValueNumberConstParserRuleCall_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IntConst__SignAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIntConstAccess().getSignAlternatives_0_0()); }
(rule__IntConst__SignAlternatives_0_0)
{ after(grammarAccess.getIntConstAccess().getSignAlternatives_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__IntConst__ValueAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getIntConstAccess().getValueINTTerminalRuleCall_1_0()); }
	RULE_INT{ after(grammarAccess.getIntConstAccess().getValueINTTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DoubleConst__SignAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDoubleConstAccess().getSignAlternatives_0_0()); }
(rule__DoubleConst__SignAlternatives_0_0)
{ after(grammarAccess.getDoubleConstAccess().getSignAlternatives_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__DoubleConst__ValueAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getDoubleConstAccess().getValueDoubleParserRuleCall_1_0()); }
	ruleDouble{ after(grammarAccess.getDoubleConstAccess().getValueDoubleParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_TIDENTIFIER : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


