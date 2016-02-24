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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDmplParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_TIDENTIFIER", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'const'", "'CONST'", "'extern'", "'EXTERN'", "'pure'", "'PURE'", "'+'", "'-'", "'bool'", "'_Bool'", "'int'", "'double'", "'void'", "'char'", "'NAN'", "'='", "';'", "'thread'", "'('", "')'", "'.'"
    };
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_TIDENTIFIER=5;
    public static final int RULE_ID=6;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalDmplParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDmplParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDmplParser.tokenNames; }
    public String getGrammarFileName() { return "../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g"; }


     
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




    // $ANTLR start "entryRuleProgram"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:60:1: entryRuleProgram : ruleProgram EOF ;
    public final void entryRuleProgram() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:61:1: ( ruleProgram EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:62:1: ruleProgram EOF
            {
             before(grammarAccess.getProgramRule()); 
            pushFollow(FOLLOW_ruleProgram_in_entryRuleProgram61);
            ruleProgram();

            state._fsp--;

             after(grammarAccess.getProgramRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProgram68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:69:1: ruleProgram : ( ( rule__Program__Group__0 ) ) ;
    public final void ruleProgram() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:73:2: ( ( ( rule__Program__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:74:1: ( ( rule__Program__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:74:1: ( ( rule__Program__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:75:1: ( rule__Program__Group__0 )
            {
             before(grammarAccess.getProgramAccess().getGroup()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:76:1: ( rule__Program__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:76:2: rule__Program__Group__0
            {
            pushFollow(FOLLOW_rule__Program__Group__0_in_ruleProgram94);
            rule__Program__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProgramAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleDmplSubclause"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:90:1: entryRuleDmplSubclause : ruleDmplSubclause EOF ;
    public final void entryRuleDmplSubclause() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:91:1: ( ruleDmplSubclause EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:92:1: ruleDmplSubclause EOF
            {
             before(grammarAccess.getDmplSubclauseRule()); 
            pushFollow(FOLLOW_ruleDmplSubclause_in_entryRuleDmplSubclause123);
            ruleDmplSubclause();

            state._fsp--;

             after(grammarAccess.getDmplSubclauseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDmplSubclause130); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDmplSubclause"


    // $ANTLR start "ruleDmplSubclause"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:99:1: ruleDmplSubclause : ( ( rule__DmplSubclause__Group__0 ) ) ;
    public final void ruleDmplSubclause() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:103:2: ( ( ( rule__DmplSubclause__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:104:1: ( ( rule__DmplSubclause__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:104:1: ( ( rule__DmplSubclause__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:105:1: ( rule__DmplSubclause__Group__0 )
            {
             before(grammarAccess.getDmplSubclauseAccess().getGroup()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:106:1: ( rule__DmplSubclause__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:106:2: rule__DmplSubclause__Group__0
            {
            pushFollow(FOLLOW_rule__DmplSubclause__Group__0_in_ruleDmplSubclause156);
            rule__DmplSubclause__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDmplSubclauseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDmplSubclause"


    // $ANTLR start "entryRuleProgramElement"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:118:1: entryRuleProgramElement : ruleProgramElement EOF ;
    public final void entryRuleProgramElement() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:119:1: ( ruleProgramElement EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:120:1: ruleProgramElement EOF
            {
             before(grammarAccess.getProgramElementRule()); 
            pushFollow(FOLLOW_ruleProgramElement_in_entryRuleProgramElement183);
            ruleProgramElement();

            state._fsp--;

             after(grammarAccess.getProgramElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProgramElement190); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProgramElement"


    // $ANTLR start "ruleProgramElement"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:127:1: ruleProgramElement : ( ( rule__ProgramElement__Alternatives ) ) ;
    public final void ruleProgramElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:131:2: ( ( ( rule__ProgramElement__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:132:1: ( ( rule__ProgramElement__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:132:1: ( ( rule__ProgramElement__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:133:1: ( rule__ProgramElement__Alternatives )
            {
             before(grammarAccess.getProgramElementAccess().getAlternatives()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:134:1: ( rule__ProgramElement__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:134:2: rule__ProgramElement__Alternatives
            {
            pushFollow(FOLLOW_rule__ProgramElement__Alternatives_in_ruleProgramElement216);
            rule__ProgramElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getProgramElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProgramElement"


    // $ANTLR start "entryRuleConstant"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:146:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:147:1: ( ruleConstant EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:148:1: ruleConstant EOF
            {
             before(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant243);
            ruleConstant();

            state._fsp--;

             after(grammarAccess.getConstantRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant250); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:155:1: ruleConstant : ( ( rule__Constant__Group__0 ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:159:2: ( ( ( rule__Constant__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:160:1: ( ( rule__Constant__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:160:1: ( ( rule__Constant__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:161:1: ( rule__Constant__Group__0 )
            {
             before(grammarAccess.getConstantAccess().getGroup()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:162:1: ( rule__Constant__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:162:2: rule__Constant__Group__0
            {
            pushFollow(FOLLOW_rule__Constant__Group__0_in_ruleConstant276);
            rule__Constant__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleNumberConst"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:174:1: entryRuleNumberConst : ruleNumberConst EOF ;
    public final void entryRuleNumberConst() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:175:1: ( ruleNumberConst EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:176:1: ruleNumberConst EOF
            {
             before(grammarAccess.getNumberConstRule()); 
            pushFollow(FOLLOW_ruleNumberConst_in_entryRuleNumberConst303);
            ruleNumberConst();

            state._fsp--;

             after(grammarAccess.getNumberConstRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberConst310); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNumberConst"


    // $ANTLR start "ruleNumberConst"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:183:1: ruleNumberConst : ( ( rule__NumberConst__Alternatives ) ) ;
    public final void ruleNumberConst() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:187:2: ( ( ( rule__NumberConst__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:188:1: ( ( rule__NumberConst__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:188:1: ( ( rule__NumberConst__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:189:1: ( rule__NumberConst__Alternatives )
            {
             before(grammarAccess.getNumberConstAccess().getAlternatives()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:190:1: ( rule__NumberConst__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:190:2: rule__NumberConst__Alternatives
            {
            pushFollow(FOLLOW_rule__NumberConst__Alternatives_in_ruleNumberConst336);
            rule__NumberConst__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNumberConstAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumberConst"


    // $ANTLR start "entryRuleIntConst"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:202:1: entryRuleIntConst : ruleIntConst EOF ;
    public final void entryRuleIntConst() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:203:1: ( ruleIntConst EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:204:1: ruleIntConst EOF
            {
             before(grammarAccess.getIntConstRule()); 
            pushFollow(FOLLOW_ruleIntConst_in_entryRuleIntConst363);
            ruleIntConst();

            state._fsp--;

             after(grammarAccess.getIntConstRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntConst370); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntConst"


    // $ANTLR start "ruleIntConst"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:211:1: ruleIntConst : ( ( rule__IntConst__Group__0 ) ) ;
    public final void ruleIntConst() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:215:2: ( ( ( rule__IntConst__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:216:1: ( ( rule__IntConst__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:216:1: ( ( rule__IntConst__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:217:1: ( rule__IntConst__Group__0 )
            {
             before(grammarAccess.getIntConstAccess().getGroup()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:218:1: ( rule__IntConst__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:218:2: rule__IntConst__Group__0
            {
            pushFollow(FOLLOW_rule__IntConst__Group__0_in_ruleIntConst396);
            rule__IntConst__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntConstAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntConst"


    // $ANTLR start "entryRuleDoubleConst"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:230:1: entryRuleDoubleConst : ruleDoubleConst EOF ;
    public final void entryRuleDoubleConst() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:231:1: ( ruleDoubleConst EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:232:1: ruleDoubleConst EOF
            {
             before(grammarAccess.getDoubleConstRule()); 
            pushFollow(FOLLOW_ruleDoubleConst_in_entryRuleDoubleConst423);
            ruleDoubleConst();

            state._fsp--;

             after(grammarAccess.getDoubleConstRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoubleConst430); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDoubleConst"


    // $ANTLR start "ruleDoubleConst"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:239:1: ruleDoubleConst : ( ( rule__DoubleConst__Group__0 ) ) ;
    public final void ruleDoubleConst() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:243:2: ( ( ( rule__DoubleConst__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:244:1: ( ( rule__DoubleConst__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:244:1: ( ( rule__DoubleConst__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:245:1: ( rule__DoubleConst__Group__0 )
            {
             before(grammarAccess.getDoubleConstAccess().getGroup()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:246:1: ( rule__DoubleConst__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:246:2: rule__DoubleConst__Group__0
            {
            pushFollow(FOLLOW_rule__DoubleConst__Group__0_in_ruleDoubleConst456);
            rule__DoubleConst__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDoubleConstAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDoubleConst"


    // $ANTLR start "entryRuleType"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:258:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:259:1: ( ruleType EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:260:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType483);
            ruleType();

            state._fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType490); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:267:1: ruleType : ( ( rule__Type__SimpTypeAssignment ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:271:2: ( ( ( rule__Type__SimpTypeAssignment ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:272:1: ( ( rule__Type__SimpTypeAssignment ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:272:1: ( ( rule__Type__SimpTypeAssignment ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:273:1: ( rule__Type__SimpTypeAssignment )
            {
             before(grammarAccess.getTypeAccess().getSimpTypeAssignment()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:274:1: ( rule__Type__SimpTypeAssignment )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:274:2: rule__Type__SimpTypeAssignment
            {
            pushFollow(FOLLOW_rule__Type__SimpTypeAssignment_in_ruleType516);
            rule__Type__SimpTypeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getSimpTypeAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleFnType"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:286:1: entryRuleFnType : ruleFnType EOF ;
    public final void entryRuleFnType() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:287:1: ( ruleFnType EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:288:1: ruleFnType EOF
            {
             before(grammarAccess.getFnTypeRule()); 
            pushFollow(FOLLOW_ruleFnType_in_entryRuleFnType543);
            ruleFnType();

            state._fsp--;

             after(grammarAccess.getFnTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFnType550); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFnType"


    // $ANTLR start "ruleFnType"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:295:1: ruleFnType : ( ( rule__FnType__TypeAssignment ) ) ;
    public final void ruleFnType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:299:2: ( ( ( rule__FnType__TypeAssignment ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:300:1: ( ( rule__FnType__TypeAssignment ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:300:1: ( ( rule__FnType__TypeAssignment ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:301:1: ( rule__FnType__TypeAssignment )
            {
             before(grammarAccess.getFnTypeAccess().getTypeAssignment()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:302:1: ( rule__FnType__TypeAssignment )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:302:2: rule__FnType__TypeAssignment
            {
            pushFollow(FOLLOW_rule__FnType__TypeAssignment_in_ruleFnType576);
            rule__FnType__TypeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getFnTypeAccess().getTypeAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFnType"


    // $ANTLR start "entryRuleProcedure"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:314:1: entryRuleProcedure : ruleProcedure EOF ;
    public final void entryRuleProcedure() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:315:1: ( ruleProcedure EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:316:1: ruleProcedure EOF
            {
             before(grammarAccess.getProcedureRule()); 
            pushFollow(FOLLOW_ruleProcedure_in_entryRuleProcedure603);
            ruleProcedure();

            state._fsp--;

             after(grammarAccess.getProcedureRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcedure610); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProcedure"


    // $ANTLR start "ruleProcedure"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:323:1: ruleProcedure : ( ( rule__Procedure__ProcedureAssignment ) ) ;
    public final void ruleProcedure() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:327:2: ( ( ( rule__Procedure__ProcedureAssignment ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:328:1: ( ( rule__Procedure__ProcedureAssignment ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:328:1: ( ( rule__Procedure__ProcedureAssignment ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:329:1: ( rule__Procedure__ProcedureAssignment )
            {
             before(grammarAccess.getProcedureAccess().getProcedureAssignment()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:330:1: ( rule__Procedure__ProcedureAssignment )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:330:2: rule__Procedure__ProcedureAssignment
            {
            pushFollow(FOLLOW_rule__Procedure__ProcedureAssignment_in_ruleProcedure636);
            rule__Procedure__ProcedureAssignment();

            state._fsp--;


            }

             after(grammarAccess.getProcedureAccess().getProcedureAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProcedure"


    // $ANTLR start "entryRuleProcNoAttr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:342:1: entryRuleProcNoAttr : ruleProcNoAttr EOF ;
    public final void entryRuleProcNoAttr() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:343:1: ( ruleProcNoAttr EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:344:1: ruleProcNoAttr EOF
            {
             before(grammarAccess.getProcNoAttrRule()); 
            pushFollow(FOLLOW_ruleProcNoAttr_in_entryRuleProcNoAttr663);
            ruleProcNoAttr();

            state._fsp--;

             after(grammarAccess.getProcNoAttrRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcNoAttr670); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProcNoAttr"


    // $ANTLR start "ruleProcNoAttr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:351:1: ruleProcNoAttr : ( ( rule__ProcNoAttr__Group__0 ) ) ;
    public final void ruleProcNoAttr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:355:2: ( ( ( rule__ProcNoAttr__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:356:1: ( ( rule__ProcNoAttr__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:356:1: ( ( rule__ProcNoAttr__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:357:1: ( rule__ProcNoAttr__Group__0 )
            {
             before(grammarAccess.getProcNoAttrAccess().getGroup()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:358:1: ( rule__ProcNoAttr__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:358:2: rule__ProcNoAttr__Group__0
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__Group__0_in_ruleProcNoAttr696);
            rule__ProcNoAttr__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProcNoAttrAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProcNoAttr"


    // $ANTLR start "entryRuleFnPrototype"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:370:1: entryRuleFnPrototype : ruleFnPrototype EOF ;
    public final void entryRuleFnPrototype() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:371:1: ( ruleFnPrototype EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:372:1: ruleFnPrototype EOF
            {
             before(grammarAccess.getFnPrototypeRule()); 
            pushFollow(FOLLOW_ruleFnPrototype_in_entryRuleFnPrototype723);
            ruleFnPrototype();

            state._fsp--;

             after(grammarAccess.getFnPrototypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFnPrototype730); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFnPrototype"


    // $ANTLR start "ruleFnPrototype"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:379:1: ruleFnPrototype : ( ( rule__FnPrototype__Group__0 ) ) ;
    public final void ruleFnPrototype() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:383:2: ( ( ( rule__FnPrototype__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:384:1: ( ( rule__FnPrototype__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:384:1: ( ( rule__FnPrototype__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:385:1: ( rule__FnPrototype__Group__0 )
            {
             before(grammarAccess.getFnPrototypeAccess().getGroup()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:386:1: ( rule__FnPrototype__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:386:2: rule__FnPrototype__Group__0
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group__0_in_ruleFnPrototype756);
            rule__FnPrototype__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFnPrototypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFnPrototype"


    // $ANTLR start "entryRuleFnPrototypeNoDecors"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:398:1: entryRuleFnPrototypeNoDecors : ruleFnPrototypeNoDecors EOF ;
    public final void entryRuleFnPrototypeNoDecors() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:399:1: ( ruleFnPrototypeNoDecors EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:400:1: ruleFnPrototypeNoDecors EOF
            {
             before(grammarAccess.getFnPrototypeNoDecorsRule()); 
            pushFollow(FOLLOW_ruleFnPrototypeNoDecors_in_entryRuleFnPrototypeNoDecors783);
            ruleFnPrototypeNoDecors();

            state._fsp--;

             after(grammarAccess.getFnPrototypeNoDecorsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFnPrototypeNoDecors790); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFnPrototypeNoDecors"


    // $ANTLR start "ruleFnPrototypeNoDecors"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:407:1: ruleFnPrototypeNoDecors : ( ( rule__FnPrototypeNoDecors__Alternatives ) ) ;
    public final void ruleFnPrototypeNoDecors() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:411:2: ( ( ( rule__FnPrototypeNoDecors__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:412:1: ( ( rule__FnPrototypeNoDecors__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:412:1: ( ( rule__FnPrototypeNoDecors__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:413:1: ( rule__FnPrototypeNoDecors__Alternatives )
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getAlternatives()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:414:1: ( rule__FnPrototypeNoDecors__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:414:2: rule__FnPrototypeNoDecors__Alternatives
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Alternatives_in_ruleFnPrototypeNoDecors816);
            rule__FnPrototypeNoDecors__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFnPrototypeNoDecorsAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFnPrototypeNoDecors"


    // $ANTLR start "entryRuleSign"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:426:1: entryRuleSign : ruleSign EOF ;
    public final void entryRuleSign() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:427:1: ( ruleSign EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:428:1: ruleSign EOF
            {
             before(grammarAccess.getSignRule()); 
            pushFollow(FOLLOW_ruleSign_in_entryRuleSign843);
            ruleSign();

            state._fsp--;

             after(grammarAccess.getSignRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSign850); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSign"


    // $ANTLR start "ruleSign"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:435:1: ruleSign : ( ( rule__Sign__Alternatives ) ) ;
    public final void ruleSign() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:439:2: ( ( ( rule__Sign__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:440:1: ( ( rule__Sign__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:440:1: ( ( rule__Sign__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:441:1: ( rule__Sign__Alternatives )
            {
             before(grammarAccess.getSignAccess().getAlternatives()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:442:1: ( rule__Sign__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:442:2: rule__Sign__Alternatives
            {
            pushFollow(FOLLOW_rule__Sign__Alternatives_in_ruleSign876);
            rule__Sign__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSignAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSign"


    // $ANTLR start "entryRuleSimpType"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:454:1: entryRuleSimpType : ruleSimpType EOF ;
    public final void entryRuleSimpType() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:455:1: ( ruleSimpType EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:456:1: ruleSimpType EOF
            {
             before(grammarAccess.getSimpTypeRule()); 
            pushFollow(FOLLOW_ruleSimpType_in_entryRuleSimpType903);
            ruleSimpType();

            state._fsp--;

             after(grammarAccess.getSimpTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpType910); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSimpType"


    // $ANTLR start "ruleSimpType"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:463:1: ruleSimpType : ( ( rule__SimpType__Alternatives ) ) ;
    public final void ruleSimpType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:467:2: ( ( ( rule__SimpType__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:468:1: ( ( rule__SimpType__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:468:1: ( ( rule__SimpType__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:469:1: ( rule__SimpType__Alternatives )
            {
             before(grammarAccess.getSimpTypeAccess().getAlternatives()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:470:1: ( rule__SimpType__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:470:2: rule__SimpType__Alternatives
            {
            pushFollow(FOLLOW_rule__SimpType__Alternatives_in_ruleSimpType936);
            rule__SimpType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSimpTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpType"


    // $ANTLR start "entryRuleDouble"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:482:1: entryRuleDouble : ruleDouble EOF ;
    public final void entryRuleDouble() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:483:1: ( ruleDouble EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:484:1: ruleDouble EOF
            {
             before(grammarAccess.getDoubleRule()); 
            pushFollow(FOLLOW_ruleDouble_in_entryRuleDouble963);
            ruleDouble();

            state._fsp--;

             after(grammarAccess.getDoubleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDouble970); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDouble"


    // $ANTLR start "ruleDouble"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:491:1: ruleDouble : ( ( rule__Double__Alternatives ) ) ;
    public final void ruleDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:495:2: ( ( ( rule__Double__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:496:1: ( ( rule__Double__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:496:1: ( ( rule__Double__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:497:1: ( rule__Double__Alternatives )
            {
             before(grammarAccess.getDoubleAccess().getAlternatives()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:498:1: ( rule__Double__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:498:2: rule__Double__Alternatives
            {
            pushFollow(FOLLOW_rule__Double__Alternatives_in_ruleDouble996);
            rule__Double__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDoubleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDouble"


    // $ANTLR start "rule__ProgramElement__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:514:1: rule__ProgramElement__Alternatives : ( ( ruleConstant ) | ( ruleProcedure ) );
    public final void rule__ProgramElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:518:1: ( ( ruleConstant ) | ( ruleProcedure ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=12 && LA1_0<=13)) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=14 && LA1_0<=17)||(LA1_0>=20 && LA1_0<=25)||LA1_0==29) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:519:1: ( ruleConstant )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:519:1: ( ruleConstant )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:520:1: ruleConstant
                    {
                     before(grammarAccess.getProgramElementAccess().getConstantParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleConstant_in_rule__ProgramElement__Alternatives1036);
                    ruleConstant();

                    state._fsp--;

                     after(grammarAccess.getProgramElementAccess().getConstantParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:525:6: ( ruleProcedure )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:525:6: ( ruleProcedure )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:526:1: ruleProcedure
                    {
                     before(grammarAccess.getProgramElementAccess().getProcedureParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleProcedure_in_rule__ProgramElement__Alternatives1053);
                    ruleProcedure();

                    state._fsp--;

                     after(grammarAccess.getProgramElementAccess().getProcedureParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProgramElement__Alternatives"


    // $ANTLR start "rule__Constant__Alternatives_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:536:1: rule__Constant__Alternatives_0 : ( ( 'const' ) | ( 'CONST' ) );
    public final void rule__Constant__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:540:1: ( ( 'const' ) | ( 'CONST' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:541:1: ( 'const' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:541:1: ( 'const' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:542:1: 'const'
                    {
                     before(grammarAccess.getConstantAccess().getConstKeyword_0_0()); 
                    match(input,12,FOLLOW_12_in_rule__Constant__Alternatives_01086); 
                     after(grammarAccess.getConstantAccess().getConstKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:549:6: ( 'CONST' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:549:6: ( 'CONST' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:550:1: 'CONST'
                    {
                     before(grammarAccess.getConstantAccess().getCONSTKeyword_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__Constant__Alternatives_01106); 
                     after(grammarAccess.getConstantAccess().getCONSTKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Alternatives_0"


    // $ANTLR start "rule__NumberConst__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:562:1: rule__NumberConst__Alternatives : ( ( ruleIntConst ) | ( ruleDoubleConst ) );
    public final void rule__NumberConst__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:566:1: ( ( ruleIntConst ) | ( ruleDoubleConst ) )
            int alt3=2;
            switch ( input.LA(1) ) {
            case 18:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==RULE_INT) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==32) ) {
                        alt3=2;
                    }
                    else if ( (LA3_3==EOF||LA3_3==28) ) {
                        alt3=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA3_1==26) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
                }
                break;
            case 19:
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==26) ) {
                    alt3=2;
                }
                else if ( (LA3_2==RULE_INT) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==32) ) {
                        alt3=2;
                    }
                    else if ( (LA3_3==EOF||LA3_3==28) ) {
                        alt3=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA3_3 = input.LA(2);

                if ( (LA3_3==32) ) {
                    alt3=2;
                }
                else if ( (LA3_3==EOF||LA3_3==28) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 3, input);

                    throw nvae;
                }
                }
                break;
            case 26:
                {
                alt3=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:567:1: ( ruleIntConst )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:567:1: ( ruleIntConst )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:568:1: ruleIntConst
                    {
                     before(grammarAccess.getNumberConstAccess().getIntConstParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIntConst_in_rule__NumberConst__Alternatives1140);
                    ruleIntConst();

                    state._fsp--;

                     after(grammarAccess.getNumberConstAccess().getIntConstParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:573:6: ( ruleDoubleConst )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:573:6: ( ruleDoubleConst )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:574:1: ruleDoubleConst
                    {
                     before(grammarAccess.getNumberConstAccess().getDoubleConstParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDoubleConst_in_rule__NumberConst__Alternatives1157);
                    ruleDoubleConst();

                    state._fsp--;

                     after(grammarAccess.getNumberConstAccess().getDoubleConstParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberConst__Alternatives"


    // $ANTLR start "rule__FnPrototype__ExternAlternatives_0_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:584:1: rule__FnPrototype__ExternAlternatives_0_0 : ( ( 'extern' ) | ( 'EXTERN' ) );
    public final void rule__FnPrototype__ExternAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:588:1: ( ( 'extern' ) | ( 'EXTERN' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:589:1: ( 'extern' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:589:1: ( 'extern' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:590:1: 'extern'
                    {
                     before(grammarAccess.getFnPrototypeAccess().getExternExternKeyword_0_0_0()); 
                    match(input,14,FOLLOW_14_in_rule__FnPrototype__ExternAlternatives_0_01190); 
                     after(grammarAccess.getFnPrototypeAccess().getExternExternKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:597:6: ( 'EXTERN' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:597:6: ( 'EXTERN' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:598:1: 'EXTERN'
                    {
                     before(grammarAccess.getFnPrototypeAccess().getExternEXTERNKeyword_0_0_1()); 
                    match(input,15,FOLLOW_15_in_rule__FnPrototype__ExternAlternatives_0_01210); 
                     after(grammarAccess.getFnPrototypeAccess().getExternEXTERNKeyword_0_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototype__ExternAlternatives_0_0"


    // $ANTLR start "rule__FnPrototype__PureAlternatives_1_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:610:1: rule__FnPrototype__PureAlternatives_1_0 : ( ( 'pure' ) | ( 'PURE' ) );
    public final void rule__FnPrototype__PureAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:614:1: ( ( 'pure' ) | ( 'PURE' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            else if ( (LA5_0==17) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:615:1: ( 'pure' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:615:1: ( 'pure' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:616:1: 'pure'
                    {
                     before(grammarAccess.getFnPrototypeAccess().getPurePureKeyword_1_0_0()); 
                    match(input,16,FOLLOW_16_in_rule__FnPrototype__PureAlternatives_1_01245); 
                     after(grammarAccess.getFnPrototypeAccess().getPurePureKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:623:6: ( 'PURE' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:623:6: ( 'PURE' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:624:1: 'PURE'
                    {
                     before(grammarAccess.getFnPrototypeAccess().getPurePUREKeyword_1_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__FnPrototype__PureAlternatives_1_01265); 
                     after(grammarAccess.getFnPrototypeAccess().getPurePUREKeyword_1_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototype__PureAlternatives_1_0"


    // $ANTLR start "rule__FnPrototypeNoDecors__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:636:1: rule__FnPrototypeNoDecors__Alternatives : ( ( ( rule__FnPrototypeNoDecors__Group_0__0 ) ) | ( ( rule__FnPrototypeNoDecors__Group_1__0 ) ) );
    public final void rule__FnPrototypeNoDecors__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:640:1: ( ( ( rule__FnPrototypeNoDecors__Group_0__0 ) ) | ( ( rule__FnPrototypeNoDecors__Group_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==29) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=20 && LA6_0<=25)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:641:1: ( ( rule__FnPrototypeNoDecors__Group_0__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:641:1: ( ( rule__FnPrototypeNoDecors__Group_0__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:642:1: ( rule__FnPrototypeNoDecors__Group_0__0 )
                    {
                     before(grammarAccess.getFnPrototypeNoDecorsAccess().getGroup_0()); 
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:643:1: ( rule__FnPrototypeNoDecors__Group_0__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:643:2: rule__FnPrototypeNoDecors__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_0__0_in_rule__FnPrototypeNoDecors__Alternatives1299);
                    rule__FnPrototypeNoDecors__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFnPrototypeNoDecorsAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:647:6: ( ( rule__FnPrototypeNoDecors__Group_1__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:647:6: ( ( rule__FnPrototypeNoDecors__Group_1__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:648:1: ( rule__FnPrototypeNoDecors__Group_1__0 )
                    {
                     before(grammarAccess.getFnPrototypeNoDecorsAccess().getGroup_1()); 
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:649:1: ( rule__FnPrototypeNoDecors__Group_1__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:649:2: rule__FnPrototypeNoDecors__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__0_in_rule__FnPrototypeNoDecors__Alternatives1317);
                    rule__FnPrototypeNoDecors__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFnPrototypeNoDecorsAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Alternatives"


    // $ANTLR start "rule__Sign__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:658:1: rule__Sign__Alternatives : ( ( '+' ) | ( '-' ) );
    public final void rule__Sign__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:662:1: ( ( '+' ) | ( '-' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            else if ( (LA7_0==19) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:663:1: ( '+' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:663:1: ( '+' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:664:1: '+'
                    {
                     before(grammarAccess.getSignAccess().getPlusSignKeyword_0()); 
                    match(input,18,FOLLOW_18_in_rule__Sign__Alternatives1351); 
                     after(grammarAccess.getSignAccess().getPlusSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:671:6: ( '-' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:671:6: ( '-' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:672:1: '-'
                    {
                     before(grammarAccess.getSignAccess().getHyphenMinusKeyword_1()); 
                    match(input,19,FOLLOW_19_in_rule__Sign__Alternatives1371); 
                     after(grammarAccess.getSignAccess().getHyphenMinusKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sign__Alternatives"


    // $ANTLR start "rule__SimpType__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:684:1: rule__SimpType__Alternatives : ( ( 'bool' ) | ( '_Bool' ) | ( 'int' ) | ( 'double' ) | ( 'void' ) | ( 'char' ) );
    public final void rule__SimpType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:688:1: ( ( 'bool' ) | ( '_Bool' ) | ( 'int' ) | ( 'double' ) | ( 'void' ) | ( 'char' ) )
            int alt8=6;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt8=1;
                }
                break;
            case 21:
                {
                alt8=2;
                }
                break;
            case 22:
                {
                alt8=3;
                }
                break;
            case 23:
                {
                alt8=4;
                }
                break;
            case 24:
                {
                alt8=5;
                }
                break;
            case 25:
                {
                alt8=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:689:1: ( 'bool' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:689:1: ( 'bool' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:690:1: 'bool'
                    {
                     before(grammarAccess.getSimpTypeAccess().getBoolKeyword_0()); 
                    match(input,20,FOLLOW_20_in_rule__SimpType__Alternatives1406); 
                     after(grammarAccess.getSimpTypeAccess().getBoolKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:697:6: ( '_Bool' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:697:6: ( '_Bool' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:698:1: '_Bool'
                    {
                     before(grammarAccess.getSimpTypeAccess().get_BoolKeyword_1()); 
                    match(input,21,FOLLOW_21_in_rule__SimpType__Alternatives1426); 
                     after(grammarAccess.getSimpTypeAccess().get_BoolKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:705:6: ( 'int' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:705:6: ( 'int' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:706:1: 'int'
                    {
                     before(grammarAccess.getSimpTypeAccess().getIntKeyword_2()); 
                    match(input,22,FOLLOW_22_in_rule__SimpType__Alternatives1446); 
                     after(grammarAccess.getSimpTypeAccess().getIntKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:713:6: ( 'double' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:713:6: ( 'double' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:714:1: 'double'
                    {
                     before(grammarAccess.getSimpTypeAccess().getDoubleKeyword_3()); 
                    match(input,23,FOLLOW_23_in_rule__SimpType__Alternatives1466); 
                     after(grammarAccess.getSimpTypeAccess().getDoubleKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:721:6: ( 'void' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:721:6: ( 'void' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:722:1: 'void'
                    {
                     before(grammarAccess.getSimpTypeAccess().getVoidKeyword_4()); 
                    match(input,24,FOLLOW_24_in_rule__SimpType__Alternatives1486); 
                     after(grammarAccess.getSimpTypeAccess().getVoidKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:729:6: ( 'char' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:729:6: ( 'char' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:730:1: 'char'
                    {
                     before(grammarAccess.getSimpTypeAccess().getCharKeyword_5()); 
                    match(input,25,FOLLOW_25_in_rule__SimpType__Alternatives1506); 
                     after(grammarAccess.getSimpTypeAccess().getCharKeyword_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpType__Alternatives"


    // $ANTLR start "rule__Double__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:742:1: rule__Double__Alternatives : ( ( 'NAN' ) | ( ( rule__Double__Group_1__0 ) ) );
    public final void rule__Double__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:746:1: ( ( 'NAN' ) | ( ( rule__Double__Group_1__0 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==26) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_INT) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:747:1: ( 'NAN' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:747:1: ( 'NAN' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:748:1: 'NAN'
                    {
                     before(grammarAccess.getDoubleAccess().getNANKeyword_0()); 
                    match(input,26,FOLLOW_26_in_rule__Double__Alternatives1541); 
                     after(grammarAccess.getDoubleAccess().getNANKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:755:6: ( ( rule__Double__Group_1__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:755:6: ( ( rule__Double__Group_1__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:756:1: ( rule__Double__Group_1__0 )
                    {
                     before(grammarAccess.getDoubleAccess().getGroup_1()); 
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:757:1: ( rule__Double__Group_1__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:757:2: rule__Double__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Double__Group_1__0_in_rule__Double__Alternatives1560);
                    rule__Double__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDoubleAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Double__Alternatives"


    // $ANTLR start "rule__Program__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:770:1: rule__Program__Group__0 : rule__Program__Group__0__Impl rule__Program__Group__1 ;
    public final void rule__Program__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:774:1: ( rule__Program__Group__0__Impl rule__Program__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:775:2: rule__Program__Group__0__Impl rule__Program__Group__1
            {
            pushFollow(FOLLOW_rule__Program__Group__0__Impl_in_rule__Program__Group__01593);
            rule__Program__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Program__Group__1_in_rule__Program__Group__01596);
            rule__Program__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__0"


    // $ANTLR start "rule__Program__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:782:1: rule__Program__Group__0__Impl : ( () ) ;
    public final void rule__Program__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:786:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:787:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:787:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:788:1: ()
            {
             before(grammarAccess.getProgramAccess().getProgramAction_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:789:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:791:1: 
            {
            }

             after(grammarAccess.getProgramAccess().getProgramAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__0__Impl"


    // $ANTLR start "rule__Program__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:801:1: rule__Program__Group__1 : rule__Program__Group__1__Impl ;
    public final void rule__Program__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:805:1: ( rule__Program__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:806:2: rule__Program__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Program__Group__1__Impl_in_rule__Program__Group__11654);
            rule__Program__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__1"


    // $ANTLR start "rule__Program__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:812:1: rule__Program__Group__1__Impl : ( ( rule__Program__ProgramElementsAssignment_1 )* ) ;
    public final void rule__Program__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:816:1: ( ( ( rule__Program__ProgramElementsAssignment_1 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:817:1: ( ( rule__Program__ProgramElementsAssignment_1 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:817:1: ( ( rule__Program__ProgramElementsAssignment_1 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:818:1: ( rule__Program__ProgramElementsAssignment_1 )*
            {
             before(grammarAccess.getProgramAccess().getProgramElementsAssignment_1()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:819:1: ( rule__Program__ProgramElementsAssignment_1 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=12 && LA10_0<=17)||(LA10_0>=20 && LA10_0<=25)||LA10_0==29) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:819:2: rule__Program__ProgramElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Program__ProgramElementsAssignment_1_in_rule__Program__Group__1__Impl1681);
            	    rule__Program__ProgramElementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getProgramAccess().getProgramElementsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__1__Impl"


    // $ANTLR start "rule__DmplSubclause__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:833:1: rule__DmplSubclause__Group__0 : rule__DmplSubclause__Group__0__Impl rule__DmplSubclause__Group__1 ;
    public final void rule__DmplSubclause__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:837:1: ( rule__DmplSubclause__Group__0__Impl rule__DmplSubclause__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:838:2: rule__DmplSubclause__Group__0__Impl rule__DmplSubclause__Group__1
            {
            pushFollow(FOLLOW_rule__DmplSubclause__Group__0__Impl_in_rule__DmplSubclause__Group__01716);
            rule__DmplSubclause__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DmplSubclause__Group__1_in_rule__DmplSubclause__Group__01719);
            rule__DmplSubclause__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DmplSubclause__Group__0"


    // $ANTLR start "rule__DmplSubclause__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:845:1: rule__DmplSubclause__Group__0__Impl : ( () ) ;
    public final void rule__DmplSubclause__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:849:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:850:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:850:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:851:1: ()
            {
             before(grammarAccess.getDmplSubclauseAccess().getDmplSubclauseAction_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:852:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:854:1: 
            {
            }

             after(grammarAccess.getDmplSubclauseAccess().getDmplSubclauseAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DmplSubclause__Group__0__Impl"


    // $ANTLR start "rule__DmplSubclause__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:864:1: rule__DmplSubclause__Group__1 : rule__DmplSubclause__Group__1__Impl ;
    public final void rule__DmplSubclause__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:868:1: ( rule__DmplSubclause__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:869:2: rule__DmplSubclause__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DmplSubclause__Group__1__Impl_in_rule__DmplSubclause__Group__11777);
            rule__DmplSubclause__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DmplSubclause__Group__1"


    // $ANTLR start "rule__DmplSubclause__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:875:1: rule__DmplSubclause__Group__1__Impl : ( ( rule__DmplSubclause__ProgramAssignment_1 ) ) ;
    public final void rule__DmplSubclause__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:879:1: ( ( ( rule__DmplSubclause__ProgramAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:880:1: ( ( rule__DmplSubclause__ProgramAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:880:1: ( ( rule__DmplSubclause__ProgramAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:881:1: ( rule__DmplSubclause__ProgramAssignment_1 )
            {
             before(grammarAccess.getDmplSubclauseAccess().getProgramAssignment_1()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:882:1: ( rule__DmplSubclause__ProgramAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:882:2: rule__DmplSubclause__ProgramAssignment_1
            {
            pushFollow(FOLLOW_rule__DmplSubclause__ProgramAssignment_1_in_rule__DmplSubclause__Group__1__Impl1804);
            rule__DmplSubclause__ProgramAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDmplSubclauseAccess().getProgramAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DmplSubclause__Group__1__Impl"


    // $ANTLR start "rule__Constant__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:896:1: rule__Constant__Group__0 : rule__Constant__Group__0__Impl rule__Constant__Group__1 ;
    public final void rule__Constant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:900:1: ( rule__Constant__Group__0__Impl rule__Constant__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:901:2: rule__Constant__Group__0__Impl rule__Constant__Group__1
            {
            pushFollow(FOLLOW_rule__Constant__Group__0__Impl_in_rule__Constant__Group__01838);
            rule__Constant__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constant__Group__1_in_rule__Constant__Group__01841);
            rule__Constant__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__0"


    // $ANTLR start "rule__Constant__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:908:1: rule__Constant__Group__0__Impl : ( ( rule__Constant__Alternatives_0 ) ) ;
    public final void rule__Constant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:912:1: ( ( ( rule__Constant__Alternatives_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:913:1: ( ( rule__Constant__Alternatives_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:913:1: ( ( rule__Constant__Alternatives_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:914:1: ( rule__Constant__Alternatives_0 )
            {
             before(grammarAccess.getConstantAccess().getAlternatives_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:915:1: ( rule__Constant__Alternatives_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:915:2: rule__Constant__Alternatives_0
            {
            pushFollow(FOLLOW_rule__Constant__Alternatives_0_in_rule__Constant__Group__0__Impl1868);
            rule__Constant__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__0__Impl"


    // $ANTLR start "rule__Constant__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:925:1: rule__Constant__Group__1 : rule__Constant__Group__1__Impl rule__Constant__Group__2 ;
    public final void rule__Constant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:929:1: ( rule__Constant__Group__1__Impl rule__Constant__Group__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:930:2: rule__Constant__Group__1__Impl rule__Constant__Group__2
            {
            pushFollow(FOLLOW_rule__Constant__Group__1__Impl_in_rule__Constant__Group__11898);
            rule__Constant__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constant__Group__2_in_rule__Constant__Group__11901);
            rule__Constant__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__1"


    // $ANTLR start "rule__Constant__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:937:1: rule__Constant__Group__1__Impl : ( ( rule__Constant__NameAssignment_1 ) ) ;
    public final void rule__Constant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:941:1: ( ( ( rule__Constant__NameAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:942:1: ( ( rule__Constant__NameAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:942:1: ( ( rule__Constant__NameAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:943:1: ( rule__Constant__NameAssignment_1 )
            {
             before(grammarAccess.getConstantAccess().getNameAssignment_1()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:944:1: ( rule__Constant__NameAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:944:2: rule__Constant__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Constant__NameAssignment_1_in_rule__Constant__Group__1__Impl1928);
            rule__Constant__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__1__Impl"


    // $ANTLR start "rule__Constant__Group__2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:954:1: rule__Constant__Group__2 : rule__Constant__Group__2__Impl rule__Constant__Group__3 ;
    public final void rule__Constant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:958:1: ( rule__Constant__Group__2__Impl rule__Constant__Group__3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:959:2: rule__Constant__Group__2__Impl rule__Constant__Group__3
            {
            pushFollow(FOLLOW_rule__Constant__Group__2__Impl_in_rule__Constant__Group__21958);
            rule__Constant__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constant__Group__3_in_rule__Constant__Group__21961);
            rule__Constant__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__2"


    // $ANTLR start "rule__Constant__Group__2__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:966:1: rule__Constant__Group__2__Impl : ( '=' ) ;
    public final void rule__Constant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:970:1: ( ( '=' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:971:1: ( '=' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:971:1: ( '=' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:972:1: '='
            {
             before(grammarAccess.getConstantAccess().getEqualsSignKeyword_2()); 
            match(input,27,FOLLOW_27_in_rule__Constant__Group__2__Impl1989); 
             after(grammarAccess.getConstantAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__2__Impl"


    // $ANTLR start "rule__Constant__Group__3"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:985:1: rule__Constant__Group__3 : rule__Constant__Group__3__Impl rule__Constant__Group__4 ;
    public final void rule__Constant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:989:1: ( rule__Constant__Group__3__Impl rule__Constant__Group__4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:990:2: rule__Constant__Group__3__Impl rule__Constant__Group__4
            {
            pushFollow(FOLLOW_rule__Constant__Group__3__Impl_in_rule__Constant__Group__32020);
            rule__Constant__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constant__Group__4_in_rule__Constant__Group__32023);
            rule__Constant__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__3"


    // $ANTLR start "rule__Constant__Group__3__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:997:1: rule__Constant__Group__3__Impl : ( ( rule__Constant__ValueAssignment_3 ) ) ;
    public final void rule__Constant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1001:1: ( ( ( rule__Constant__ValueAssignment_3 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1002:1: ( ( rule__Constant__ValueAssignment_3 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1002:1: ( ( rule__Constant__ValueAssignment_3 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1003:1: ( rule__Constant__ValueAssignment_3 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_3()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1004:1: ( rule__Constant__ValueAssignment_3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1004:2: rule__Constant__ValueAssignment_3
            {
            pushFollow(FOLLOW_rule__Constant__ValueAssignment_3_in_rule__Constant__Group__3__Impl2050);
            rule__Constant__ValueAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getValueAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__3__Impl"


    // $ANTLR start "rule__Constant__Group__4"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1014:1: rule__Constant__Group__4 : rule__Constant__Group__4__Impl ;
    public final void rule__Constant__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1018:1: ( rule__Constant__Group__4__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1019:2: rule__Constant__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Constant__Group__4__Impl_in_rule__Constant__Group__42080);
            rule__Constant__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__4"


    // $ANTLR start "rule__Constant__Group__4__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1025:1: rule__Constant__Group__4__Impl : ( ';' ) ;
    public final void rule__Constant__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1029:1: ( ( ';' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1030:1: ( ';' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1030:1: ( ';' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1031:1: ';'
            {
             before(grammarAccess.getConstantAccess().getSemicolonKeyword_4()); 
            match(input,28,FOLLOW_28_in_rule__Constant__Group__4__Impl2108); 
             after(grammarAccess.getConstantAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__4__Impl"


    // $ANTLR start "rule__IntConst__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1054:1: rule__IntConst__Group__0 : rule__IntConst__Group__0__Impl rule__IntConst__Group__1 ;
    public final void rule__IntConst__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1058:1: ( rule__IntConst__Group__0__Impl rule__IntConst__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1059:2: rule__IntConst__Group__0__Impl rule__IntConst__Group__1
            {
            pushFollow(FOLLOW_rule__IntConst__Group__0__Impl_in_rule__IntConst__Group__02149);
            rule__IntConst__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IntConst__Group__1_in_rule__IntConst__Group__02152);
            rule__IntConst__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntConst__Group__0"


    // $ANTLR start "rule__IntConst__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1066:1: rule__IntConst__Group__0__Impl : ( ( rule__IntConst__SignAssignment_0 )? ) ;
    public final void rule__IntConst__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1070:1: ( ( ( rule__IntConst__SignAssignment_0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1071:1: ( ( rule__IntConst__SignAssignment_0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1071:1: ( ( rule__IntConst__SignAssignment_0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1072:1: ( rule__IntConst__SignAssignment_0 )?
            {
             before(grammarAccess.getIntConstAccess().getSignAssignment_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1073:1: ( rule__IntConst__SignAssignment_0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=18 && LA11_0<=19)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1073:2: rule__IntConst__SignAssignment_0
                    {
                    pushFollow(FOLLOW_rule__IntConst__SignAssignment_0_in_rule__IntConst__Group__0__Impl2179);
                    rule__IntConst__SignAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntConstAccess().getSignAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntConst__Group__0__Impl"


    // $ANTLR start "rule__IntConst__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1083:1: rule__IntConst__Group__1 : rule__IntConst__Group__1__Impl ;
    public final void rule__IntConst__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1087:1: ( rule__IntConst__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1088:2: rule__IntConst__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntConst__Group__1__Impl_in_rule__IntConst__Group__12210);
            rule__IntConst__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntConst__Group__1"


    // $ANTLR start "rule__IntConst__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1094:1: rule__IntConst__Group__1__Impl : ( ( rule__IntConst__ValueAssignment_1 ) ) ;
    public final void rule__IntConst__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1098:1: ( ( ( rule__IntConst__ValueAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1099:1: ( ( rule__IntConst__ValueAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1099:1: ( ( rule__IntConst__ValueAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1100:1: ( rule__IntConst__ValueAssignment_1 )
            {
             before(grammarAccess.getIntConstAccess().getValueAssignment_1()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1101:1: ( rule__IntConst__ValueAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1101:2: rule__IntConst__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__IntConst__ValueAssignment_1_in_rule__IntConst__Group__1__Impl2237);
            rule__IntConst__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIntConstAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntConst__Group__1__Impl"


    // $ANTLR start "rule__DoubleConst__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1115:1: rule__DoubleConst__Group__0 : rule__DoubleConst__Group__0__Impl rule__DoubleConst__Group__1 ;
    public final void rule__DoubleConst__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1119:1: ( rule__DoubleConst__Group__0__Impl rule__DoubleConst__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1120:2: rule__DoubleConst__Group__0__Impl rule__DoubleConst__Group__1
            {
            pushFollow(FOLLOW_rule__DoubleConst__Group__0__Impl_in_rule__DoubleConst__Group__02271);
            rule__DoubleConst__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DoubleConst__Group__1_in_rule__DoubleConst__Group__02274);
            rule__DoubleConst__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DoubleConst__Group__0"


    // $ANTLR start "rule__DoubleConst__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1127:1: rule__DoubleConst__Group__0__Impl : ( ( rule__DoubleConst__SignAssignment_0 )? ) ;
    public final void rule__DoubleConst__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1131:1: ( ( ( rule__DoubleConst__SignAssignment_0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1132:1: ( ( rule__DoubleConst__SignAssignment_0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1132:1: ( ( rule__DoubleConst__SignAssignment_0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1133:1: ( rule__DoubleConst__SignAssignment_0 )?
            {
             before(grammarAccess.getDoubleConstAccess().getSignAssignment_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1134:1: ( rule__DoubleConst__SignAssignment_0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=18 && LA12_0<=19)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1134:2: rule__DoubleConst__SignAssignment_0
                    {
                    pushFollow(FOLLOW_rule__DoubleConst__SignAssignment_0_in_rule__DoubleConst__Group__0__Impl2301);
                    rule__DoubleConst__SignAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDoubleConstAccess().getSignAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DoubleConst__Group__0__Impl"


    // $ANTLR start "rule__DoubleConst__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1144:1: rule__DoubleConst__Group__1 : rule__DoubleConst__Group__1__Impl ;
    public final void rule__DoubleConst__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1148:1: ( rule__DoubleConst__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1149:2: rule__DoubleConst__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DoubleConst__Group__1__Impl_in_rule__DoubleConst__Group__12332);
            rule__DoubleConst__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DoubleConst__Group__1"


    // $ANTLR start "rule__DoubleConst__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1155:1: rule__DoubleConst__Group__1__Impl : ( ( rule__DoubleConst__ValueAssignment_1 ) ) ;
    public final void rule__DoubleConst__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1159:1: ( ( ( rule__DoubleConst__ValueAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1160:1: ( ( rule__DoubleConst__ValueAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1160:1: ( ( rule__DoubleConst__ValueAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1161:1: ( rule__DoubleConst__ValueAssignment_1 )
            {
             before(grammarAccess.getDoubleConstAccess().getValueAssignment_1()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1162:1: ( rule__DoubleConst__ValueAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1162:2: rule__DoubleConst__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__DoubleConst__ValueAssignment_1_in_rule__DoubleConst__Group__1__Impl2359);
            rule__DoubleConst__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDoubleConstAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DoubleConst__Group__1__Impl"


    // $ANTLR start "rule__ProcNoAttr__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1176:1: rule__ProcNoAttr__Group__0 : rule__ProcNoAttr__Group__0__Impl rule__ProcNoAttr__Group__1 ;
    public final void rule__ProcNoAttr__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1180:1: ( rule__ProcNoAttr__Group__0__Impl rule__ProcNoAttr__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1181:2: rule__ProcNoAttr__Group__0__Impl rule__ProcNoAttr__Group__1
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__Group__0__Impl_in_rule__ProcNoAttr__Group__02393);
            rule__ProcNoAttr__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ProcNoAttr__Group__1_in_rule__ProcNoAttr__Group__02396);
            rule__ProcNoAttr__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProcNoAttr__Group__0"


    // $ANTLR start "rule__ProcNoAttr__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1188:1: rule__ProcNoAttr__Group__0__Impl : ( ( rule__ProcNoAttr__PrototypeAssignment_0 ) ) ;
    public final void rule__ProcNoAttr__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1192:1: ( ( ( rule__ProcNoAttr__PrototypeAssignment_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1193:1: ( ( rule__ProcNoAttr__PrototypeAssignment_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1193:1: ( ( rule__ProcNoAttr__PrototypeAssignment_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1194:1: ( rule__ProcNoAttr__PrototypeAssignment_0 )
            {
             before(grammarAccess.getProcNoAttrAccess().getPrototypeAssignment_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1195:1: ( rule__ProcNoAttr__PrototypeAssignment_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1195:2: rule__ProcNoAttr__PrototypeAssignment_0
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__PrototypeAssignment_0_in_rule__ProcNoAttr__Group__0__Impl2423);
            rule__ProcNoAttr__PrototypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getProcNoAttrAccess().getPrototypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProcNoAttr__Group__0__Impl"


    // $ANTLR start "rule__ProcNoAttr__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1205:1: rule__ProcNoAttr__Group__1 : rule__ProcNoAttr__Group__1__Impl ;
    public final void rule__ProcNoAttr__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1209:1: ( rule__ProcNoAttr__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1210:2: rule__ProcNoAttr__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__Group__1__Impl_in_rule__ProcNoAttr__Group__12453);
            rule__ProcNoAttr__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProcNoAttr__Group__1"


    // $ANTLR start "rule__ProcNoAttr__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1216:1: rule__ProcNoAttr__Group__1__Impl : ( ';' ) ;
    public final void rule__ProcNoAttr__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1220:1: ( ( ';' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1221:1: ( ';' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1221:1: ( ';' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1222:1: ';'
            {
             before(grammarAccess.getProcNoAttrAccess().getSemicolonKeyword_1()); 
            match(input,28,FOLLOW_28_in_rule__ProcNoAttr__Group__1__Impl2481); 
             after(grammarAccess.getProcNoAttrAccess().getSemicolonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProcNoAttr__Group__1__Impl"


    // $ANTLR start "rule__FnPrototype__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1239:1: rule__FnPrototype__Group__0 : rule__FnPrototype__Group__0__Impl rule__FnPrototype__Group__1 ;
    public final void rule__FnPrototype__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1243:1: ( rule__FnPrototype__Group__0__Impl rule__FnPrototype__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1244:2: rule__FnPrototype__Group__0__Impl rule__FnPrototype__Group__1
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group__0__Impl_in_rule__FnPrototype__Group__02516);
            rule__FnPrototype__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FnPrototype__Group__1_in_rule__FnPrototype__Group__02519);
            rule__FnPrototype__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototype__Group__0"


    // $ANTLR start "rule__FnPrototype__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1251:1: rule__FnPrototype__Group__0__Impl : ( ( rule__FnPrototype__ExternAssignment_0 )? ) ;
    public final void rule__FnPrototype__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1255:1: ( ( ( rule__FnPrototype__ExternAssignment_0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1256:1: ( ( rule__FnPrototype__ExternAssignment_0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1256:1: ( ( rule__FnPrototype__ExternAssignment_0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1257:1: ( rule__FnPrototype__ExternAssignment_0 )?
            {
             before(grammarAccess.getFnPrototypeAccess().getExternAssignment_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1258:1: ( rule__FnPrototype__ExternAssignment_0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=14 && LA13_0<=15)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1258:2: rule__FnPrototype__ExternAssignment_0
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__ExternAssignment_0_in_rule__FnPrototype__Group__0__Impl2546);
                    rule__FnPrototype__ExternAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFnPrototypeAccess().getExternAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototype__Group__0__Impl"


    // $ANTLR start "rule__FnPrototype__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1268:1: rule__FnPrototype__Group__1 : rule__FnPrototype__Group__1__Impl rule__FnPrototype__Group__2 ;
    public final void rule__FnPrototype__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1272:1: ( rule__FnPrototype__Group__1__Impl rule__FnPrototype__Group__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1273:2: rule__FnPrototype__Group__1__Impl rule__FnPrototype__Group__2
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group__1__Impl_in_rule__FnPrototype__Group__12577);
            rule__FnPrototype__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FnPrototype__Group__2_in_rule__FnPrototype__Group__12580);
            rule__FnPrototype__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototype__Group__1"


    // $ANTLR start "rule__FnPrototype__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1280:1: rule__FnPrototype__Group__1__Impl : ( ( rule__FnPrototype__PureAssignment_1 )? ) ;
    public final void rule__FnPrototype__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1284:1: ( ( ( rule__FnPrototype__PureAssignment_1 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1285:1: ( ( rule__FnPrototype__PureAssignment_1 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1285:1: ( ( rule__FnPrototype__PureAssignment_1 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1286:1: ( rule__FnPrototype__PureAssignment_1 )?
            {
             before(grammarAccess.getFnPrototypeAccess().getPureAssignment_1()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1287:1: ( rule__FnPrototype__PureAssignment_1 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=16 && LA14_0<=17)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1287:2: rule__FnPrototype__PureAssignment_1
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__PureAssignment_1_in_rule__FnPrototype__Group__1__Impl2607);
                    rule__FnPrototype__PureAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFnPrototypeAccess().getPureAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototype__Group__1__Impl"


    // $ANTLR start "rule__FnPrototype__Group__2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1297:1: rule__FnPrototype__Group__2 : rule__FnPrototype__Group__2__Impl ;
    public final void rule__FnPrototype__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1301:1: ( rule__FnPrototype__Group__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1302:2: rule__FnPrototype__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group__2__Impl_in_rule__FnPrototype__Group__22638);
            rule__FnPrototype__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototype__Group__2"


    // $ANTLR start "rule__FnPrototype__Group__2__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1308:1: rule__FnPrototype__Group__2__Impl : ( ( rule__FnPrototype__PrototypeAssignment_2 ) ) ;
    public final void rule__FnPrototype__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1312:1: ( ( ( rule__FnPrototype__PrototypeAssignment_2 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1313:1: ( ( rule__FnPrototype__PrototypeAssignment_2 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1313:1: ( ( rule__FnPrototype__PrototypeAssignment_2 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1314:1: ( rule__FnPrototype__PrototypeAssignment_2 )
            {
             before(grammarAccess.getFnPrototypeAccess().getPrototypeAssignment_2()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1315:1: ( rule__FnPrototype__PrototypeAssignment_2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1315:2: rule__FnPrototype__PrototypeAssignment_2
            {
            pushFollow(FOLLOW_rule__FnPrototype__PrototypeAssignment_2_in_rule__FnPrototype__Group__2__Impl2665);
            rule__FnPrototype__PrototypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFnPrototypeAccess().getPrototypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototype__Group__2__Impl"


    // $ANTLR start "rule__FnPrototypeNoDecors__Group_0__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1331:1: rule__FnPrototypeNoDecors__Group_0__0 : rule__FnPrototypeNoDecors__Group_0__0__Impl rule__FnPrototypeNoDecors__Group_0__1 ;
    public final void rule__FnPrototypeNoDecors__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1335:1: ( rule__FnPrototypeNoDecors__Group_0__0__Impl rule__FnPrototypeNoDecors__Group_0__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1336:2: rule__FnPrototypeNoDecors__Group_0__0__Impl rule__FnPrototypeNoDecors__Group_0__1
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_0__0__Impl_in_rule__FnPrototypeNoDecors__Group_0__02701);
            rule__FnPrototypeNoDecors__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_0__1_in_rule__FnPrototypeNoDecors__Group_0__02704);
            rule__FnPrototypeNoDecors__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Group_0__0"


    // $ANTLR start "rule__FnPrototypeNoDecors__Group_0__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1343:1: rule__FnPrototypeNoDecors__Group_0__0__Impl : ( () ) ;
    public final void rule__FnPrototypeNoDecors__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1347:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1348:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1348:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1349:1: ()
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getThreadDeclarationAction_0_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1350:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1352:1: 
            {
            }

             after(grammarAccess.getFnPrototypeNoDecorsAccess().getThreadDeclarationAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Group_0__0__Impl"


    // $ANTLR start "rule__FnPrototypeNoDecors__Group_0__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1362:1: rule__FnPrototypeNoDecors__Group_0__1 : rule__FnPrototypeNoDecors__Group_0__1__Impl rule__FnPrototypeNoDecors__Group_0__2 ;
    public final void rule__FnPrototypeNoDecors__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1366:1: ( rule__FnPrototypeNoDecors__Group_0__1__Impl rule__FnPrototypeNoDecors__Group_0__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1367:2: rule__FnPrototypeNoDecors__Group_0__1__Impl rule__FnPrototypeNoDecors__Group_0__2
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_0__1__Impl_in_rule__FnPrototypeNoDecors__Group_0__12762);
            rule__FnPrototypeNoDecors__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_0__2_in_rule__FnPrototypeNoDecors__Group_0__12765);
            rule__FnPrototypeNoDecors__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Group_0__1"


    // $ANTLR start "rule__FnPrototypeNoDecors__Group_0__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1374:1: rule__FnPrototypeNoDecors__Group_0__1__Impl : ( 'thread' ) ;
    public final void rule__FnPrototypeNoDecors__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1378:1: ( ( 'thread' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1379:1: ( 'thread' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1379:1: ( 'thread' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1380:1: 'thread'
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getThreadKeyword_0_1()); 
            match(input,29,FOLLOW_29_in_rule__FnPrototypeNoDecors__Group_0__1__Impl2793); 
             after(grammarAccess.getFnPrototypeNoDecorsAccess().getThreadKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Group_0__1__Impl"


    // $ANTLR start "rule__FnPrototypeNoDecors__Group_0__2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1393:1: rule__FnPrototypeNoDecors__Group_0__2 : rule__FnPrototypeNoDecors__Group_0__2__Impl ;
    public final void rule__FnPrototypeNoDecors__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1397:1: ( rule__FnPrototypeNoDecors__Group_0__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1398:2: rule__FnPrototypeNoDecors__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_0__2__Impl_in_rule__FnPrototypeNoDecors__Group_0__22824);
            rule__FnPrototypeNoDecors__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Group_0__2"


    // $ANTLR start "rule__FnPrototypeNoDecors__Group_0__2__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1404:1: rule__FnPrototypeNoDecors__Group_0__2__Impl : ( ( rule__FnPrototypeNoDecors__NameAssignment_0_2 ) ) ;
    public final void rule__FnPrototypeNoDecors__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1408:1: ( ( ( rule__FnPrototypeNoDecors__NameAssignment_0_2 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1409:1: ( ( rule__FnPrototypeNoDecors__NameAssignment_0_2 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1409:1: ( ( rule__FnPrototypeNoDecors__NameAssignment_0_2 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1410:1: ( rule__FnPrototypeNoDecors__NameAssignment_0_2 )
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getNameAssignment_0_2()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1411:1: ( rule__FnPrototypeNoDecors__NameAssignment_0_2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1411:2: rule__FnPrototypeNoDecors__NameAssignment_0_2
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__NameAssignment_0_2_in_rule__FnPrototypeNoDecors__Group_0__2__Impl2851);
            rule__FnPrototypeNoDecors__NameAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getFnPrototypeNoDecorsAccess().getNameAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Group_0__2__Impl"


    // $ANTLR start "rule__FnPrototypeNoDecors__Group_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1427:1: rule__FnPrototypeNoDecors__Group_1__0 : rule__FnPrototypeNoDecors__Group_1__0__Impl rule__FnPrototypeNoDecors__Group_1__1 ;
    public final void rule__FnPrototypeNoDecors__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1431:1: ( rule__FnPrototypeNoDecors__Group_1__0__Impl rule__FnPrototypeNoDecors__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1432:2: rule__FnPrototypeNoDecors__Group_1__0__Impl rule__FnPrototypeNoDecors__Group_1__1
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__0__Impl_in_rule__FnPrototypeNoDecors__Group_1__02887);
            rule__FnPrototypeNoDecors__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__1_in_rule__FnPrototypeNoDecors__Group_1__02890);
            rule__FnPrototypeNoDecors__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Group_1__0"


    // $ANTLR start "rule__FnPrototypeNoDecors__Group_1__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1439:1: rule__FnPrototypeNoDecors__Group_1__0__Impl : ( () ) ;
    public final void rule__FnPrototypeNoDecors__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1443:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1444:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1444:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1445:1: ()
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getFnPrototypeDeclarationAction_1_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1446:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1448:1: 
            {
            }

             after(grammarAccess.getFnPrototypeNoDecorsAccess().getFnPrototypeDeclarationAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Group_1__0__Impl"


    // $ANTLR start "rule__FnPrototypeNoDecors__Group_1__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1458:1: rule__FnPrototypeNoDecors__Group_1__1 : rule__FnPrototypeNoDecors__Group_1__1__Impl rule__FnPrototypeNoDecors__Group_1__2 ;
    public final void rule__FnPrototypeNoDecors__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1462:1: ( rule__FnPrototypeNoDecors__Group_1__1__Impl rule__FnPrototypeNoDecors__Group_1__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1463:2: rule__FnPrototypeNoDecors__Group_1__1__Impl rule__FnPrototypeNoDecors__Group_1__2
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__1__Impl_in_rule__FnPrototypeNoDecors__Group_1__12948);
            rule__FnPrototypeNoDecors__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__2_in_rule__FnPrototypeNoDecors__Group_1__12951);
            rule__FnPrototypeNoDecors__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Group_1__1"


    // $ANTLR start "rule__FnPrototypeNoDecors__Group_1__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1470:1: rule__FnPrototypeNoDecors__Group_1__1__Impl : ( ( rule__FnPrototypeNoDecors__TypeAssignment_1_1 ) ) ;
    public final void rule__FnPrototypeNoDecors__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1474:1: ( ( ( rule__FnPrototypeNoDecors__TypeAssignment_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1475:1: ( ( rule__FnPrototypeNoDecors__TypeAssignment_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1475:1: ( ( rule__FnPrototypeNoDecors__TypeAssignment_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1476:1: ( rule__FnPrototypeNoDecors__TypeAssignment_1_1 )
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getTypeAssignment_1_1()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1477:1: ( rule__FnPrototypeNoDecors__TypeAssignment_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1477:2: rule__FnPrototypeNoDecors__TypeAssignment_1_1
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__TypeAssignment_1_1_in_rule__FnPrototypeNoDecors__Group_1__1__Impl2978);
            rule__FnPrototypeNoDecors__TypeAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getFnPrototypeNoDecorsAccess().getTypeAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Group_1__1__Impl"


    // $ANTLR start "rule__FnPrototypeNoDecors__Group_1__2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1487:1: rule__FnPrototypeNoDecors__Group_1__2 : rule__FnPrototypeNoDecors__Group_1__2__Impl rule__FnPrototypeNoDecors__Group_1__3 ;
    public final void rule__FnPrototypeNoDecors__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1491:1: ( rule__FnPrototypeNoDecors__Group_1__2__Impl rule__FnPrototypeNoDecors__Group_1__3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1492:2: rule__FnPrototypeNoDecors__Group_1__2__Impl rule__FnPrototypeNoDecors__Group_1__3
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__2__Impl_in_rule__FnPrototypeNoDecors__Group_1__23008);
            rule__FnPrototypeNoDecors__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__3_in_rule__FnPrototypeNoDecors__Group_1__23011);
            rule__FnPrototypeNoDecors__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Group_1__2"


    // $ANTLR start "rule__FnPrototypeNoDecors__Group_1__2__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1499:1: rule__FnPrototypeNoDecors__Group_1__2__Impl : ( ( rule__FnPrototypeNoDecors__NameAssignment_1_2 ) ) ;
    public final void rule__FnPrototypeNoDecors__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1503:1: ( ( ( rule__FnPrototypeNoDecors__NameAssignment_1_2 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1504:1: ( ( rule__FnPrototypeNoDecors__NameAssignment_1_2 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1504:1: ( ( rule__FnPrototypeNoDecors__NameAssignment_1_2 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1505:1: ( rule__FnPrototypeNoDecors__NameAssignment_1_2 )
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getNameAssignment_1_2()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1506:1: ( rule__FnPrototypeNoDecors__NameAssignment_1_2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1506:2: rule__FnPrototypeNoDecors__NameAssignment_1_2
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__NameAssignment_1_2_in_rule__FnPrototypeNoDecors__Group_1__2__Impl3038);
            rule__FnPrototypeNoDecors__NameAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getFnPrototypeNoDecorsAccess().getNameAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Group_1__2__Impl"


    // $ANTLR start "rule__FnPrototypeNoDecors__Group_1__3"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1516:1: rule__FnPrototypeNoDecors__Group_1__3 : rule__FnPrototypeNoDecors__Group_1__3__Impl rule__FnPrototypeNoDecors__Group_1__4 ;
    public final void rule__FnPrototypeNoDecors__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1520:1: ( rule__FnPrototypeNoDecors__Group_1__3__Impl rule__FnPrototypeNoDecors__Group_1__4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1521:2: rule__FnPrototypeNoDecors__Group_1__3__Impl rule__FnPrototypeNoDecors__Group_1__4
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__3__Impl_in_rule__FnPrototypeNoDecors__Group_1__33068);
            rule__FnPrototypeNoDecors__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__4_in_rule__FnPrototypeNoDecors__Group_1__33071);
            rule__FnPrototypeNoDecors__Group_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Group_1__3"


    // $ANTLR start "rule__FnPrototypeNoDecors__Group_1__3__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1528:1: rule__FnPrototypeNoDecors__Group_1__3__Impl : ( '(' ) ;
    public final void rule__FnPrototypeNoDecors__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1532:1: ( ( '(' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1533:1: ( '(' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1533:1: ( '(' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1534:1: '('
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getLeftParenthesisKeyword_1_3()); 
            match(input,30,FOLLOW_30_in_rule__FnPrototypeNoDecors__Group_1__3__Impl3099); 
             after(grammarAccess.getFnPrototypeNoDecorsAccess().getLeftParenthesisKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Group_1__3__Impl"


    // $ANTLR start "rule__FnPrototypeNoDecors__Group_1__4"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1547:1: rule__FnPrototypeNoDecors__Group_1__4 : rule__FnPrototypeNoDecors__Group_1__4__Impl ;
    public final void rule__FnPrototypeNoDecors__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1551:1: ( rule__FnPrototypeNoDecors__Group_1__4__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1552:2: rule__FnPrototypeNoDecors__Group_1__4__Impl
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__4__Impl_in_rule__FnPrototypeNoDecors__Group_1__43130);
            rule__FnPrototypeNoDecors__Group_1__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Group_1__4"


    // $ANTLR start "rule__FnPrototypeNoDecors__Group_1__4__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1558:1: rule__FnPrototypeNoDecors__Group_1__4__Impl : ( ')' ) ;
    public final void rule__FnPrototypeNoDecors__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1562:1: ( ( ')' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1563:1: ( ')' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1563:1: ( ')' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1564:1: ')'
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getRightParenthesisKeyword_1_4()); 
            match(input,31,FOLLOW_31_in_rule__FnPrototypeNoDecors__Group_1__4__Impl3158); 
             after(grammarAccess.getFnPrototypeNoDecorsAccess().getRightParenthesisKeyword_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__Group_1__4__Impl"


    // $ANTLR start "rule__Double__Group_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1587:1: rule__Double__Group_1__0 : rule__Double__Group_1__0__Impl rule__Double__Group_1__1 ;
    public final void rule__Double__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1591:1: ( rule__Double__Group_1__0__Impl rule__Double__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1592:2: rule__Double__Group_1__0__Impl rule__Double__Group_1__1
            {
            pushFollow(FOLLOW_rule__Double__Group_1__0__Impl_in_rule__Double__Group_1__03199);
            rule__Double__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Double__Group_1__1_in_rule__Double__Group_1__03202);
            rule__Double__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Double__Group_1__0"


    // $ANTLR start "rule__Double__Group_1__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1599:1: rule__Double__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__Double__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1603:1: ( ( RULE_INT ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1604:1: ( RULE_INT )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1604:1: ( RULE_INT )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1605:1: RULE_INT
            {
             before(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Double__Group_1__0__Impl3229); 
             after(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Double__Group_1__0__Impl"


    // $ANTLR start "rule__Double__Group_1__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1616:1: rule__Double__Group_1__1 : rule__Double__Group_1__1__Impl rule__Double__Group_1__2 ;
    public final void rule__Double__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1620:1: ( rule__Double__Group_1__1__Impl rule__Double__Group_1__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1621:2: rule__Double__Group_1__1__Impl rule__Double__Group_1__2
            {
            pushFollow(FOLLOW_rule__Double__Group_1__1__Impl_in_rule__Double__Group_1__13258);
            rule__Double__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Double__Group_1__2_in_rule__Double__Group_1__13261);
            rule__Double__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Double__Group_1__1"


    // $ANTLR start "rule__Double__Group_1__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1628:1: rule__Double__Group_1__1__Impl : ( '.' ) ;
    public final void rule__Double__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1632:1: ( ( '.' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1633:1: ( '.' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1633:1: ( '.' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1634:1: '.'
            {
             before(grammarAccess.getDoubleAccess().getFullStopKeyword_1_1()); 
            match(input,32,FOLLOW_32_in_rule__Double__Group_1__1__Impl3289); 
             after(grammarAccess.getDoubleAccess().getFullStopKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Double__Group_1__1__Impl"


    // $ANTLR start "rule__Double__Group_1__2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1647:1: rule__Double__Group_1__2 : rule__Double__Group_1__2__Impl ;
    public final void rule__Double__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1651:1: ( rule__Double__Group_1__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1652:2: rule__Double__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Double__Group_1__2__Impl_in_rule__Double__Group_1__23320);
            rule__Double__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Double__Group_1__2"


    // $ANTLR start "rule__Double__Group_1__2__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1658:1: rule__Double__Group_1__2__Impl : ( ( RULE_INT )? ) ;
    public final void rule__Double__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1662:1: ( ( ( RULE_INT )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1663:1: ( ( RULE_INT )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1663:1: ( ( RULE_INT )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1664:1: ( RULE_INT )?
            {
             before(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_2()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1665:1: ( RULE_INT )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_INT) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1665:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Double__Group_1__2__Impl3348); 

                    }
                    break;

            }

             after(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Double__Group_1__2__Impl"


    // $ANTLR start "rule__Program__ProgramElementsAssignment_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1682:1: rule__Program__ProgramElementsAssignment_1 : ( ruleProgramElement ) ;
    public final void rule__Program__ProgramElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1686:1: ( ( ruleProgramElement ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1687:1: ( ruleProgramElement )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1687:1: ( ruleProgramElement )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1688:1: ruleProgramElement
            {
             before(grammarAccess.getProgramAccess().getProgramElementsProgramElementParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleProgramElement_in_rule__Program__ProgramElementsAssignment_13390);
            ruleProgramElement();

            state._fsp--;

             after(grammarAccess.getProgramAccess().getProgramElementsProgramElementParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__ProgramElementsAssignment_1"


    // $ANTLR start "rule__DmplSubclause__ProgramAssignment_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1697:1: rule__DmplSubclause__ProgramAssignment_1 : ( ruleProgram ) ;
    public final void rule__DmplSubclause__ProgramAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1701:1: ( ( ruleProgram ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1702:1: ( ruleProgram )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1702:1: ( ruleProgram )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1703:1: ruleProgram
            {
             before(grammarAccess.getDmplSubclauseAccess().getProgramProgramParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleProgram_in_rule__DmplSubclause__ProgramAssignment_13421);
            ruleProgram();

            state._fsp--;

             after(grammarAccess.getDmplSubclauseAccess().getProgramProgramParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DmplSubclause__ProgramAssignment_1"


    // $ANTLR start "rule__Constant__NameAssignment_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1712:1: rule__Constant__NameAssignment_1 : ( RULE_TIDENTIFIER ) ;
    public final void rule__Constant__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1716:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1717:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1717:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1718:1: RULE_TIDENTIFIER
            {
             before(grammarAccess.getConstantAccess().getNameTIDENTIFIERTerminalRuleCall_1_0()); 
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__Constant__NameAssignment_13452); 
             after(grammarAccess.getConstantAccess().getNameTIDENTIFIERTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__NameAssignment_1"


    // $ANTLR start "rule__Constant__ValueAssignment_3"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1727:1: rule__Constant__ValueAssignment_3 : ( ruleNumberConst ) ;
    public final void rule__Constant__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1731:1: ( ( ruleNumberConst ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1732:1: ( ruleNumberConst )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1732:1: ( ruleNumberConst )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1733:1: ruleNumberConst
            {
             before(grammarAccess.getConstantAccess().getValueNumberConstParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleNumberConst_in_rule__Constant__ValueAssignment_33483);
            ruleNumberConst();

            state._fsp--;

             after(grammarAccess.getConstantAccess().getValueNumberConstParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__ValueAssignment_3"


    // $ANTLR start "rule__IntConst__SignAssignment_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1742:1: rule__IntConst__SignAssignment_0 : ( ruleSign ) ;
    public final void rule__IntConst__SignAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1746:1: ( ( ruleSign ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1747:1: ( ruleSign )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1747:1: ( ruleSign )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1748:1: ruleSign
            {
             before(grammarAccess.getIntConstAccess().getSignSignParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleSign_in_rule__IntConst__SignAssignment_03514);
            ruleSign();

            state._fsp--;

             after(grammarAccess.getIntConstAccess().getSignSignParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntConst__SignAssignment_0"


    // $ANTLR start "rule__IntConst__ValueAssignment_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1757:1: rule__IntConst__ValueAssignment_1 : ( RULE_INT ) ;
    public final void rule__IntConst__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1761:1: ( ( RULE_INT ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1762:1: ( RULE_INT )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1762:1: ( RULE_INT )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1763:1: RULE_INT
            {
             before(grammarAccess.getIntConstAccess().getValueINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__IntConst__ValueAssignment_13545); 
             after(grammarAccess.getIntConstAccess().getValueINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntConst__ValueAssignment_1"


    // $ANTLR start "rule__DoubleConst__SignAssignment_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1772:1: rule__DoubleConst__SignAssignment_0 : ( ruleSign ) ;
    public final void rule__DoubleConst__SignAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1776:1: ( ( ruleSign ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1777:1: ( ruleSign )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1777:1: ( ruleSign )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1778:1: ruleSign
            {
             before(grammarAccess.getDoubleConstAccess().getSignSignParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleSign_in_rule__DoubleConst__SignAssignment_03576);
            ruleSign();

            state._fsp--;

             after(grammarAccess.getDoubleConstAccess().getSignSignParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DoubleConst__SignAssignment_0"


    // $ANTLR start "rule__DoubleConst__ValueAssignment_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1787:1: rule__DoubleConst__ValueAssignment_1 : ( ruleDouble ) ;
    public final void rule__DoubleConst__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1791:1: ( ( ruleDouble ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1792:1: ( ruleDouble )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1792:1: ( ruleDouble )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1793:1: ruleDouble
            {
             before(grammarAccess.getDoubleConstAccess().getValueDoubleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDouble_in_rule__DoubleConst__ValueAssignment_13607);
            ruleDouble();

            state._fsp--;

             after(grammarAccess.getDoubleConstAccess().getValueDoubleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DoubleConst__ValueAssignment_1"


    // $ANTLR start "rule__Type__SimpTypeAssignment"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1802:1: rule__Type__SimpTypeAssignment : ( ruleSimpType ) ;
    public final void rule__Type__SimpTypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1806:1: ( ( ruleSimpType ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1807:1: ( ruleSimpType )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1807:1: ( ruleSimpType )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1808:1: ruleSimpType
            {
             before(grammarAccess.getTypeAccess().getSimpTypeSimpTypeParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleSimpType_in_rule__Type__SimpTypeAssignment3638);
            ruleSimpType();

            state._fsp--;

             after(grammarAccess.getTypeAccess().getSimpTypeSimpTypeParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__SimpTypeAssignment"


    // $ANTLR start "rule__FnType__TypeAssignment"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1817:1: rule__FnType__TypeAssignment : ( ruleType ) ;
    public final void rule__FnType__TypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1821:1: ( ( ruleType ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1822:1: ( ruleType )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1822:1: ( ruleType )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1823:1: ruleType
            {
             before(grammarAccess.getFnTypeAccess().getTypeTypeParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleType_in_rule__FnType__TypeAssignment3669);
            ruleType();

            state._fsp--;

             after(grammarAccess.getFnTypeAccess().getTypeTypeParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnType__TypeAssignment"


    // $ANTLR start "rule__Procedure__ProcedureAssignment"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1832:1: rule__Procedure__ProcedureAssignment : ( ruleProcNoAttr ) ;
    public final void rule__Procedure__ProcedureAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1836:1: ( ( ruleProcNoAttr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1837:1: ( ruleProcNoAttr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1837:1: ( ruleProcNoAttr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1838:1: ruleProcNoAttr
            {
             before(grammarAccess.getProcedureAccess().getProcedureProcNoAttrParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleProcNoAttr_in_rule__Procedure__ProcedureAssignment3700);
            ruleProcNoAttr();

            state._fsp--;

             after(grammarAccess.getProcedureAccess().getProcedureProcNoAttrParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Procedure__ProcedureAssignment"


    // $ANTLR start "rule__ProcNoAttr__PrototypeAssignment_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1847:1: rule__ProcNoAttr__PrototypeAssignment_0 : ( ruleFnPrototype ) ;
    public final void rule__ProcNoAttr__PrototypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1851:1: ( ( ruleFnPrototype ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1852:1: ( ruleFnPrototype )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1852:1: ( ruleFnPrototype )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1853:1: ruleFnPrototype
            {
             before(grammarAccess.getProcNoAttrAccess().getPrototypeFnPrototypeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleFnPrototype_in_rule__ProcNoAttr__PrototypeAssignment_03731);
            ruleFnPrototype();

            state._fsp--;

             after(grammarAccess.getProcNoAttrAccess().getPrototypeFnPrototypeParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProcNoAttr__PrototypeAssignment_0"


    // $ANTLR start "rule__FnPrototype__ExternAssignment_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1862:1: rule__FnPrototype__ExternAssignment_0 : ( ( rule__FnPrototype__ExternAlternatives_0_0 ) ) ;
    public final void rule__FnPrototype__ExternAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1866:1: ( ( ( rule__FnPrototype__ExternAlternatives_0_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1867:1: ( ( rule__FnPrototype__ExternAlternatives_0_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1867:1: ( ( rule__FnPrototype__ExternAlternatives_0_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1868:1: ( rule__FnPrototype__ExternAlternatives_0_0 )
            {
             before(grammarAccess.getFnPrototypeAccess().getExternAlternatives_0_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1869:1: ( rule__FnPrototype__ExternAlternatives_0_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1869:2: rule__FnPrototype__ExternAlternatives_0_0
            {
            pushFollow(FOLLOW_rule__FnPrototype__ExternAlternatives_0_0_in_rule__FnPrototype__ExternAssignment_03762);
            rule__FnPrototype__ExternAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getFnPrototypeAccess().getExternAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototype__ExternAssignment_0"


    // $ANTLR start "rule__FnPrototype__PureAssignment_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1878:1: rule__FnPrototype__PureAssignment_1 : ( ( rule__FnPrototype__PureAlternatives_1_0 ) ) ;
    public final void rule__FnPrototype__PureAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1882:1: ( ( ( rule__FnPrototype__PureAlternatives_1_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1883:1: ( ( rule__FnPrototype__PureAlternatives_1_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1883:1: ( ( rule__FnPrototype__PureAlternatives_1_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1884:1: ( rule__FnPrototype__PureAlternatives_1_0 )
            {
             before(grammarAccess.getFnPrototypeAccess().getPureAlternatives_1_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1885:1: ( rule__FnPrototype__PureAlternatives_1_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1885:2: rule__FnPrototype__PureAlternatives_1_0
            {
            pushFollow(FOLLOW_rule__FnPrototype__PureAlternatives_1_0_in_rule__FnPrototype__PureAssignment_13795);
            rule__FnPrototype__PureAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getFnPrototypeAccess().getPureAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototype__PureAssignment_1"


    // $ANTLR start "rule__FnPrototype__PrototypeAssignment_2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1894:1: rule__FnPrototype__PrototypeAssignment_2 : ( ruleFnPrototypeNoDecors ) ;
    public final void rule__FnPrototype__PrototypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1898:1: ( ( ruleFnPrototypeNoDecors ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1899:1: ( ruleFnPrototypeNoDecors )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1899:1: ( ruleFnPrototypeNoDecors )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1900:1: ruleFnPrototypeNoDecors
            {
             before(grammarAccess.getFnPrototypeAccess().getPrototypeFnPrototypeNoDecorsParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleFnPrototypeNoDecors_in_rule__FnPrototype__PrototypeAssignment_23828);
            ruleFnPrototypeNoDecors();

            state._fsp--;

             after(grammarAccess.getFnPrototypeAccess().getPrototypeFnPrototypeNoDecorsParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototype__PrototypeAssignment_2"


    // $ANTLR start "rule__FnPrototypeNoDecors__NameAssignment_0_2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1909:1: rule__FnPrototypeNoDecors__NameAssignment_0_2 : ( RULE_TIDENTIFIER ) ;
    public final void rule__FnPrototypeNoDecors__NameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1913:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1914:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1914:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1915:1: RULE_TIDENTIFIER
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getNameTIDENTIFIERTerminalRuleCall_0_2_0()); 
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__FnPrototypeNoDecors__NameAssignment_0_23859); 
             after(grammarAccess.getFnPrototypeNoDecorsAccess().getNameTIDENTIFIERTerminalRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__NameAssignment_0_2"


    // $ANTLR start "rule__FnPrototypeNoDecors__TypeAssignment_1_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1924:1: rule__FnPrototypeNoDecors__TypeAssignment_1_1 : ( ruleFnType ) ;
    public final void rule__FnPrototypeNoDecors__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1928:1: ( ( ruleFnType ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1929:1: ( ruleFnType )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1929:1: ( ruleFnType )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1930:1: ruleFnType
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getTypeFnTypeParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleFnType_in_rule__FnPrototypeNoDecors__TypeAssignment_1_13890);
            ruleFnType();

            state._fsp--;

             after(grammarAccess.getFnPrototypeNoDecorsAccess().getTypeFnTypeParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__TypeAssignment_1_1"


    // $ANTLR start "rule__FnPrototypeNoDecors__NameAssignment_1_2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1939:1: rule__FnPrototypeNoDecors__NameAssignment_1_2 : ( RULE_TIDENTIFIER ) ;
    public final void rule__FnPrototypeNoDecors__NameAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1943:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1944:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1944:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1945:1: RULE_TIDENTIFIER
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getNameTIDENTIFIERTerminalRuleCall_1_2_0()); 
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__FnPrototypeNoDecors__NameAssignment_1_23921); 
             after(grammarAccess.getFnPrototypeNoDecorsAccess().getNameTIDENTIFIERTerminalRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototypeNoDecors__NameAssignment_1_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProgram68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__Group__0_in_ruleProgram94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDmplSubclause_in_entryRuleDmplSubclause123 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDmplSubclause130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DmplSubclause__Group__0_in_ruleDmplSubclause156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProgramElement_in_entryRuleProgramElement183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProgramElement190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProgramElement__Alternatives_in_ruleProgramElement216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant243 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__0_in_ruleConstant276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberConst_in_entryRuleNumberConst303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberConst310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumberConst__Alternatives_in_ruleNumberConst336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntConst_in_entryRuleIntConst363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntConst370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__Group__0_in_ruleIntConst396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleConst_in_entryRuleDoubleConst423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoubleConst430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__Group__0_in_ruleDoubleConst456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__SimpTypeAssignment_in_ruleType516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnType_in_entryRuleFnType543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFnType550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnType__TypeAssignment_in_ruleFnType576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcedure_in_entryRuleProcedure603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcedure610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Procedure__ProcedureAssignment_in_ruleProcedure636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcNoAttr_in_entryRuleProcNoAttr663 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcNoAttr670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Group__0_in_ruleProcNoAttr696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnPrototype_in_entryRuleFnPrototype723 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFnPrototype730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group__0_in_ruleFnPrototype756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnPrototypeNoDecors_in_entryRuleFnPrototypeNoDecors783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFnPrototypeNoDecors790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Alternatives_in_ruleFnPrototypeNoDecors816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSign_in_entryRuleSign843 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSign850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sign__Alternatives_in_ruleSign876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpType_in_entryRuleSimpType903 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpType910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpType__Alternatives_in_ruleSimpType936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDouble_in_entryRuleDouble963 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDouble970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Alternatives_in_ruleDouble996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_rule__ProgramElement__Alternatives1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcedure_in_rule__ProgramElement__Alternatives1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Constant__Alternatives_01086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Constant__Alternatives_01106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntConst_in_rule__NumberConst__Alternatives1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleConst_in_rule__NumberConst__Alternatives1157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__FnPrototype__ExternAlternatives_0_01190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__FnPrototype__ExternAlternatives_0_01210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__FnPrototype__PureAlternatives_1_01245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__FnPrototype__PureAlternatives_1_01265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_0__0_in_rule__FnPrototypeNoDecors__Alternatives1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__0_in_rule__FnPrototypeNoDecors__Alternatives1317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Sign__Alternatives1351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Sign__Alternatives1371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__SimpType__Alternatives1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__SimpType__Alternatives1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__SimpType__Alternatives1446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__SimpType__Alternatives1466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__SimpType__Alternatives1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__SimpType__Alternatives1506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Double__Alternatives1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Group_1__0_in_rule__Double__Alternatives1560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__Group__0__Impl_in_rule__Program__Group__01593 = new BitSet(new long[]{0x0000000023F3F000L});
    public static final BitSet FOLLOW_rule__Program__Group__1_in_rule__Program__Group__01596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__Group__1__Impl_in_rule__Program__Group__11654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__ProgramElementsAssignment_1_in_rule__Program__Group__1__Impl1681 = new BitSet(new long[]{0x0000000023F3F002L});
    public static final BitSet FOLLOW_rule__DmplSubclause__Group__0__Impl_in_rule__DmplSubclause__Group__01716 = new BitSet(new long[]{0x0000000023F3F000L});
    public static final BitSet FOLLOW_rule__DmplSubclause__Group__1_in_rule__DmplSubclause__Group__01719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DmplSubclause__Group__1__Impl_in_rule__DmplSubclause__Group__11777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DmplSubclause__ProgramAssignment_1_in_rule__DmplSubclause__Group__1__Impl1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__0__Impl_in_rule__Constant__Group__01838 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Constant__Group__1_in_rule__Constant__Group__01841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Alternatives_0_in_rule__Constant__Group__0__Impl1868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__1__Impl_in_rule__Constant__Group__11898 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Constant__Group__2_in_rule__Constant__Group__11901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__NameAssignment_1_in_rule__Constant__Group__1__Impl1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__2__Impl_in_rule__Constant__Group__21958 = new BitSet(new long[]{0x00000000040C0010L});
    public static final BitSet FOLLOW_rule__Constant__Group__3_in_rule__Constant__Group__21961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Constant__Group__2__Impl1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__3__Impl_in_rule__Constant__Group__32020 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Constant__Group__4_in_rule__Constant__Group__32023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__ValueAssignment_3_in_rule__Constant__Group__3__Impl2050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__4__Impl_in_rule__Constant__Group__42080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Constant__Group__4__Impl2108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__Group__0__Impl_in_rule__IntConst__Group__02149 = new BitSet(new long[]{0x00000000000C0010L});
    public static final BitSet FOLLOW_rule__IntConst__Group__1_in_rule__IntConst__Group__02152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__SignAssignment_0_in_rule__IntConst__Group__0__Impl2179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__Group__1__Impl_in_rule__IntConst__Group__12210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__ValueAssignment_1_in_rule__IntConst__Group__1__Impl2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__Group__0__Impl_in_rule__DoubleConst__Group__02271 = new BitSet(new long[]{0x00000000040C0010L});
    public static final BitSet FOLLOW_rule__DoubleConst__Group__1_in_rule__DoubleConst__Group__02274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__SignAssignment_0_in_rule__DoubleConst__Group__0__Impl2301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__Group__1__Impl_in_rule__DoubleConst__Group__12332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__ValueAssignment_1_in_rule__DoubleConst__Group__1__Impl2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Group__0__Impl_in_rule__ProcNoAttr__Group__02393 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Group__1_in_rule__ProcNoAttr__Group__02396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__PrototypeAssignment_0_in_rule__ProcNoAttr__Group__0__Impl2423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Group__1__Impl_in_rule__ProcNoAttr__Group__12453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ProcNoAttr__Group__1__Impl2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group__0__Impl_in_rule__FnPrototype__Group__02516 = new BitSet(new long[]{0x0000000023F3F000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group__1_in_rule__FnPrototype__Group__02519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__ExternAssignment_0_in_rule__FnPrototype__Group__0__Impl2546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group__1__Impl_in_rule__FnPrototype__Group__12577 = new BitSet(new long[]{0x0000000023F3F000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group__2_in_rule__FnPrototype__Group__12580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__PureAssignment_1_in_rule__FnPrototype__Group__1__Impl2607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group__2__Impl_in_rule__FnPrototype__Group__22638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__PrototypeAssignment_2_in_rule__FnPrototype__Group__2__Impl2665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_0__0__Impl_in_rule__FnPrototypeNoDecors__Group_0__02701 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_0__1_in_rule__FnPrototypeNoDecors__Group_0__02704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_0__1__Impl_in_rule__FnPrototypeNoDecors__Group_0__12762 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_0__2_in_rule__FnPrototypeNoDecors__Group_0__12765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__FnPrototypeNoDecors__Group_0__1__Impl2793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_0__2__Impl_in_rule__FnPrototypeNoDecors__Group_0__22824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__NameAssignment_0_2_in_rule__FnPrototypeNoDecors__Group_0__2__Impl2851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__0__Impl_in_rule__FnPrototypeNoDecors__Group_1__02887 = new BitSet(new long[]{0x0000000023F3F000L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__1_in_rule__FnPrototypeNoDecors__Group_1__02890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__1__Impl_in_rule__FnPrototypeNoDecors__Group_1__12948 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__2_in_rule__FnPrototypeNoDecors__Group_1__12951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__TypeAssignment_1_1_in_rule__FnPrototypeNoDecors__Group_1__1__Impl2978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__2__Impl_in_rule__FnPrototypeNoDecors__Group_1__23008 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__3_in_rule__FnPrototypeNoDecors__Group_1__23011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__NameAssignment_1_2_in_rule__FnPrototypeNoDecors__Group_1__2__Impl3038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__3__Impl_in_rule__FnPrototypeNoDecors__Group_1__33068 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__4_in_rule__FnPrototypeNoDecors__Group_1__33071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__FnPrototypeNoDecors__Group_1__3__Impl3099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__4__Impl_in_rule__FnPrototypeNoDecors__Group_1__43130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__FnPrototypeNoDecors__Group_1__4__Impl3158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Group_1__0__Impl_in_rule__Double__Group_1__03199 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Double__Group_1__1_in_rule__Double__Group_1__03202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Double__Group_1__0__Impl3229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Group_1__1__Impl_in_rule__Double__Group_1__13258 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Double__Group_1__2_in_rule__Double__Group_1__13261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Double__Group_1__1__Impl3289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Group_1__2__Impl_in_rule__Double__Group_1__23320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Double__Group_1__2__Impl3348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProgramElement_in_rule__Program__ProgramElementsAssignment_13390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProgram_in_rule__DmplSubclause__ProgramAssignment_13421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__Constant__NameAssignment_13452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberConst_in_rule__Constant__ValueAssignment_33483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSign_in_rule__IntConst__SignAssignment_03514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__IntConst__ValueAssignment_13545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSign_in_rule__DoubleConst__SignAssignment_03576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDouble_in_rule__DoubleConst__ValueAssignment_13607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpType_in_rule__Type__SimpTypeAssignment3638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__FnType__TypeAssignment3669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcNoAttr_in_rule__Procedure__ProcedureAssignment3700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnPrototype_in_rule__ProcNoAttr__PrototypeAssignment_03731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__ExternAlternatives_0_0_in_rule__FnPrototype__ExternAssignment_03762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__PureAlternatives_1_0_in_rule__FnPrototype__PureAssignment_13795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnPrototypeNoDecors_in_rule__FnPrototype__PrototypeAssignment_23828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__FnPrototypeNoDecors__NameAssignment_0_23859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnType_in_rule__FnPrototypeNoDecors__TypeAssignment_1_13890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__FnPrototypeNoDecors__NameAssignment_1_23921 = new BitSet(new long[]{0x0000000000000002L});

}