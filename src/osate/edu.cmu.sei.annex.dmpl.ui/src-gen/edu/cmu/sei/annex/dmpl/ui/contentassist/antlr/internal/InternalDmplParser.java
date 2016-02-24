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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_TIDENTIFIER", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'const'", "'CONST'", "'extern'", "'EXTERN'", "'pure'", "'PURE'", "'+'", "'-'", "'bool'", "'_Bool'", "'int'", "'double'", "'void'", "'char'", "'signed'", "'unsigned'", "'NAN'", "'='", "';'", "'thread'", "'('", "')'", "'.'"
    };
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:267:1: ruleType : ( ( rule__Type__Group__0 ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:271:2: ( ( ( rule__Type__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:272:1: ( ( rule__Type__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:272:1: ( ( rule__Type__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:273:1: ( rule__Type__Group__0 )
            {
             before(grammarAccess.getTypeAccess().getGroup()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:274:1: ( rule__Type__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:274:2: rule__Type__Group__0
            {
            pushFollow(FOLLOW_rule__Type__Group__0_in_ruleType516);
            rule__Type__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getGroup()); 

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


    // $ANTLR start "entryRuleProcedure"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:286:1: entryRuleProcedure : ruleProcedure EOF ;
    public final void entryRuleProcedure() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:287:1: ( ruleProcedure EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:288:1: ruleProcedure EOF
            {
             before(grammarAccess.getProcedureRule()); 
            pushFollow(FOLLOW_ruleProcedure_in_entryRuleProcedure543);
            ruleProcedure();

            state._fsp--;

             after(grammarAccess.getProcedureRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcedure550); 

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:295:1: ruleProcedure : ( ( rule__Procedure__ProcedureAssignment ) ) ;
    public final void ruleProcedure() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:299:2: ( ( ( rule__Procedure__ProcedureAssignment ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:300:1: ( ( rule__Procedure__ProcedureAssignment ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:300:1: ( ( rule__Procedure__ProcedureAssignment ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:301:1: ( rule__Procedure__ProcedureAssignment )
            {
             before(grammarAccess.getProcedureAccess().getProcedureAssignment()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:302:1: ( rule__Procedure__ProcedureAssignment )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:302:2: rule__Procedure__ProcedureAssignment
            {
            pushFollow(FOLLOW_rule__Procedure__ProcedureAssignment_in_ruleProcedure576);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:314:1: entryRuleProcNoAttr : ruleProcNoAttr EOF ;
    public final void entryRuleProcNoAttr() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:315:1: ( ruleProcNoAttr EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:316:1: ruleProcNoAttr EOF
            {
             before(grammarAccess.getProcNoAttrRule()); 
            pushFollow(FOLLOW_ruleProcNoAttr_in_entryRuleProcNoAttr603);
            ruleProcNoAttr();

            state._fsp--;

             after(grammarAccess.getProcNoAttrRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcNoAttr610); 

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:323:1: ruleProcNoAttr : ( ( rule__ProcNoAttr__Group__0 ) ) ;
    public final void ruleProcNoAttr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:327:2: ( ( ( rule__ProcNoAttr__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:328:1: ( ( rule__ProcNoAttr__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:328:1: ( ( rule__ProcNoAttr__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:329:1: ( rule__ProcNoAttr__Group__0 )
            {
             before(grammarAccess.getProcNoAttrAccess().getGroup()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:330:1: ( rule__ProcNoAttr__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:330:2: rule__ProcNoAttr__Group__0
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__Group__0_in_ruleProcNoAttr636);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:342:1: entryRuleFnPrototype : ruleFnPrototype EOF ;
    public final void entryRuleFnPrototype() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:343:1: ( ruleFnPrototype EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:344:1: ruleFnPrototype EOF
            {
             before(grammarAccess.getFnPrototypeRule()); 
            pushFollow(FOLLOW_ruleFnPrototype_in_entryRuleFnPrototype663);
            ruleFnPrototype();

            state._fsp--;

             after(grammarAccess.getFnPrototypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFnPrototype670); 

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:351:1: ruleFnPrototype : ( ( rule__FnPrototype__Group__0 ) ) ;
    public final void ruleFnPrototype() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:355:2: ( ( ( rule__FnPrototype__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:356:1: ( ( rule__FnPrototype__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:356:1: ( ( rule__FnPrototype__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:357:1: ( rule__FnPrototype__Group__0 )
            {
             before(grammarAccess.getFnPrototypeAccess().getGroup()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:358:1: ( rule__FnPrototype__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:358:2: rule__FnPrototype__Group__0
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group__0_in_ruleFnPrototype696);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:370:1: entryRuleFnPrototypeNoDecors : ruleFnPrototypeNoDecors EOF ;
    public final void entryRuleFnPrototypeNoDecors() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:371:1: ( ruleFnPrototypeNoDecors EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:372:1: ruleFnPrototypeNoDecors EOF
            {
             before(grammarAccess.getFnPrototypeNoDecorsRule()); 
            pushFollow(FOLLOW_ruleFnPrototypeNoDecors_in_entryRuleFnPrototypeNoDecors723);
            ruleFnPrototypeNoDecors();

            state._fsp--;

             after(grammarAccess.getFnPrototypeNoDecorsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFnPrototypeNoDecors730); 

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:379:1: ruleFnPrototypeNoDecors : ( ( rule__FnPrototypeNoDecors__Alternatives ) ) ;
    public final void ruleFnPrototypeNoDecors() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:383:2: ( ( ( rule__FnPrototypeNoDecors__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:384:1: ( ( rule__FnPrototypeNoDecors__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:384:1: ( ( rule__FnPrototypeNoDecors__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:385:1: ( rule__FnPrototypeNoDecors__Alternatives )
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getAlternatives()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:386:1: ( rule__FnPrototypeNoDecors__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:386:2: rule__FnPrototypeNoDecors__Alternatives
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Alternatives_in_ruleFnPrototypeNoDecors756);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:398:1: entryRuleSign : ruleSign EOF ;
    public final void entryRuleSign() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:399:1: ( ruleSign EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:400:1: ruleSign EOF
            {
             before(grammarAccess.getSignRule()); 
            pushFollow(FOLLOW_ruleSign_in_entryRuleSign783);
            ruleSign();

            state._fsp--;

             after(grammarAccess.getSignRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSign790); 

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:407:1: ruleSign : ( ( rule__Sign__Alternatives ) ) ;
    public final void ruleSign() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:411:2: ( ( ( rule__Sign__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:412:1: ( ( rule__Sign__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:412:1: ( ( rule__Sign__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:413:1: ( rule__Sign__Alternatives )
            {
             before(grammarAccess.getSignAccess().getAlternatives()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:414:1: ( rule__Sign__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:414:2: rule__Sign__Alternatives
            {
            pushFollow(FOLLOW_rule__Sign__Alternatives_in_ruleSign816);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:426:1: entryRuleSimpType : ruleSimpType EOF ;
    public final void entryRuleSimpType() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:427:1: ( ruleSimpType EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:428:1: ruleSimpType EOF
            {
             before(grammarAccess.getSimpTypeRule()); 
            pushFollow(FOLLOW_ruleSimpType_in_entryRuleSimpType843);
            ruleSimpType();

            state._fsp--;

             after(grammarAccess.getSimpTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpType850); 

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:435:1: ruleSimpType : ( ( rule__SimpType__Alternatives ) ) ;
    public final void ruleSimpType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:439:2: ( ( ( rule__SimpType__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:440:1: ( ( rule__SimpType__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:440:1: ( ( rule__SimpType__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:441:1: ( rule__SimpType__Alternatives )
            {
             before(grammarAccess.getSimpTypeAccess().getAlternatives()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:442:1: ( rule__SimpType__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:442:2: rule__SimpType__Alternatives
            {
            pushFollow(FOLLOW_rule__SimpType__Alternatives_in_ruleSimpType876);
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


    // $ANTLR start "entryRuleSigned"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:454:1: entryRuleSigned : ruleSigned EOF ;
    public final void entryRuleSigned() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:455:1: ( ruleSigned EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:456:1: ruleSigned EOF
            {
             before(grammarAccess.getSignedRule()); 
            pushFollow(FOLLOW_ruleSigned_in_entryRuleSigned903);
            ruleSigned();

            state._fsp--;

             after(grammarAccess.getSignedRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSigned910); 

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
    // $ANTLR end "entryRuleSigned"


    // $ANTLR start "ruleSigned"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:463:1: ruleSigned : ( ( rule__Signed__Alternatives ) ) ;
    public final void ruleSigned() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:467:2: ( ( ( rule__Signed__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:468:1: ( ( rule__Signed__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:468:1: ( ( rule__Signed__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:469:1: ( rule__Signed__Alternatives )
            {
             before(grammarAccess.getSignedAccess().getAlternatives()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:470:1: ( rule__Signed__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:470:2: rule__Signed__Alternatives
            {
            pushFollow(FOLLOW_rule__Signed__Alternatives_in_ruleSigned936);
            rule__Signed__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSignedAccess().getAlternatives()); 

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
    // $ANTLR end "ruleSigned"


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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:516:1: rule__ProgramElement__Alternatives : ( ( ruleConstant ) | ( ruleProcedure ) );
    public final void rule__ProgramElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:520:1: ( ( ruleConstant ) | ( ruleProcedure ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=12 && LA1_0<=13)) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=14 && LA1_0<=17)||(LA1_0>=20 && LA1_0<=27)||LA1_0==31) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:521:1: ( ruleConstant )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:521:1: ( ruleConstant )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:522:1: ruleConstant
                    {
                     before(grammarAccess.getProgramElementAccess().getConstantParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleConstant_in_rule__ProgramElement__Alternatives1038);
                    ruleConstant();

                    state._fsp--;

                     after(grammarAccess.getProgramElementAccess().getConstantParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:527:6: ( ruleProcedure )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:527:6: ( ruleProcedure )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:528:1: ruleProcedure
                    {
                     before(grammarAccess.getProgramElementAccess().getProcedureParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleProcedure_in_rule__ProgramElement__Alternatives1055);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:538:1: rule__Constant__Alternatives_0 : ( ( 'const' ) | ( 'CONST' ) );
    public final void rule__Constant__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:542:1: ( ( 'const' ) | ( 'CONST' ) )
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:543:1: ( 'const' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:543:1: ( 'const' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:544:1: 'const'
                    {
                     before(grammarAccess.getConstantAccess().getConstKeyword_0_0()); 
                    match(input,12,FOLLOW_12_in_rule__Constant__Alternatives_01088); 
                     after(grammarAccess.getConstantAccess().getConstKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:551:6: ( 'CONST' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:551:6: ( 'CONST' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:552:1: 'CONST'
                    {
                     before(grammarAccess.getConstantAccess().getCONSTKeyword_0_1()); 
                    match(input,13,FOLLOW_13_in_rule__Constant__Alternatives_01108); 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:564:1: rule__NumberConst__Alternatives : ( ( ruleIntConst ) | ( ruleDoubleConst ) );
    public final void rule__NumberConst__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:568:1: ( ( ruleIntConst ) | ( ruleDoubleConst ) )
            int alt3=2;
            switch ( input.LA(1) ) {
            case 18:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==RULE_INT) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==34) ) {
                        alt3=2;
                    }
                    else if ( (LA3_3==EOF||LA3_3==30) ) {
                        alt3=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA3_1==28) ) {
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

                if ( (LA3_2==RULE_INT) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==34) ) {
                        alt3=2;
                    }
                    else if ( (LA3_3==EOF||LA3_3==30) ) {
                        alt3=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA3_2==28) ) {
                    alt3=2;
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

                if ( (LA3_3==34) ) {
                    alt3=2;
                }
                else if ( (LA3_3==EOF||LA3_3==30) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 3, input);

                    throw nvae;
                }
                }
                break;
            case 28:
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:569:1: ( ruleIntConst )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:569:1: ( ruleIntConst )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:570:1: ruleIntConst
                    {
                     before(grammarAccess.getNumberConstAccess().getIntConstParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIntConst_in_rule__NumberConst__Alternatives1142);
                    ruleIntConst();

                    state._fsp--;

                     after(grammarAccess.getNumberConstAccess().getIntConstParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:575:6: ( ruleDoubleConst )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:575:6: ( ruleDoubleConst )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:576:1: ruleDoubleConst
                    {
                     before(grammarAccess.getNumberConstAccess().getDoubleConstParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDoubleConst_in_rule__NumberConst__Alternatives1159);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:586:1: rule__FnPrototype__ExternAlternatives_0_0 : ( ( 'extern' ) | ( 'EXTERN' ) );
    public final void rule__FnPrototype__ExternAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:590:1: ( ( 'extern' ) | ( 'EXTERN' ) )
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:591:1: ( 'extern' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:591:1: ( 'extern' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:592:1: 'extern'
                    {
                     before(grammarAccess.getFnPrototypeAccess().getExternExternKeyword_0_0_0()); 
                    match(input,14,FOLLOW_14_in_rule__FnPrototype__ExternAlternatives_0_01192); 
                     after(grammarAccess.getFnPrototypeAccess().getExternExternKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:599:6: ( 'EXTERN' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:599:6: ( 'EXTERN' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:600:1: 'EXTERN'
                    {
                     before(grammarAccess.getFnPrototypeAccess().getExternEXTERNKeyword_0_0_1()); 
                    match(input,15,FOLLOW_15_in_rule__FnPrototype__ExternAlternatives_0_01212); 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:612:1: rule__FnPrototype__PureAlternatives_1_0 : ( ( 'pure' ) | ( 'PURE' ) );
    public final void rule__FnPrototype__PureAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:616:1: ( ( 'pure' ) | ( 'PURE' ) )
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:617:1: ( 'pure' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:617:1: ( 'pure' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:618:1: 'pure'
                    {
                     before(grammarAccess.getFnPrototypeAccess().getPurePureKeyword_1_0_0()); 
                    match(input,16,FOLLOW_16_in_rule__FnPrototype__PureAlternatives_1_01247); 
                     after(grammarAccess.getFnPrototypeAccess().getPurePureKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:625:6: ( 'PURE' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:625:6: ( 'PURE' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:626:1: 'PURE'
                    {
                     before(grammarAccess.getFnPrototypeAccess().getPurePUREKeyword_1_0_1()); 
                    match(input,17,FOLLOW_17_in_rule__FnPrototype__PureAlternatives_1_01267); 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:638:1: rule__FnPrototypeNoDecors__Alternatives : ( ( ( rule__FnPrototypeNoDecors__Group_0__0 ) ) | ( ( rule__FnPrototypeNoDecors__Group_1__0 ) ) );
    public final void rule__FnPrototypeNoDecors__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:642:1: ( ( ( rule__FnPrototypeNoDecors__Group_0__0 ) ) | ( ( rule__FnPrototypeNoDecors__Group_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==31) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=20 && LA6_0<=27)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:643:1: ( ( rule__FnPrototypeNoDecors__Group_0__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:643:1: ( ( rule__FnPrototypeNoDecors__Group_0__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:644:1: ( rule__FnPrototypeNoDecors__Group_0__0 )
                    {
                     before(grammarAccess.getFnPrototypeNoDecorsAccess().getGroup_0()); 
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:645:1: ( rule__FnPrototypeNoDecors__Group_0__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:645:2: rule__FnPrototypeNoDecors__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_0__0_in_rule__FnPrototypeNoDecors__Alternatives1301);
                    rule__FnPrototypeNoDecors__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFnPrototypeNoDecorsAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:649:6: ( ( rule__FnPrototypeNoDecors__Group_1__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:649:6: ( ( rule__FnPrototypeNoDecors__Group_1__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:650:1: ( rule__FnPrototypeNoDecors__Group_1__0 )
                    {
                     before(grammarAccess.getFnPrototypeNoDecorsAccess().getGroup_1()); 
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:651:1: ( rule__FnPrototypeNoDecors__Group_1__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:651:2: rule__FnPrototypeNoDecors__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__0_in_rule__FnPrototypeNoDecors__Alternatives1319);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:660:1: rule__Sign__Alternatives : ( ( '+' ) | ( '-' ) );
    public final void rule__Sign__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:664:1: ( ( '+' ) | ( '-' ) )
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:665:1: ( '+' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:665:1: ( '+' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:666:1: '+'
                    {
                     before(grammarAccess.getSignAccess().getPlusSignKeyword_0()); 
                    match(input,18,FOLLOW_18_in_rule__Sign__Alternatives1353); 
                     after(grammarAccess.getSignAccess().getPlusSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:673:6: ( '-' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:673:6: ( '-' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:674:1: '-'
                    {
                     before(grammarAccess.getSignAccess().getHyphenMinusKeyword_1()); 
                    match(input,19,FOLLOW_19_in_rule__Sign__Alternatives1373); 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:686:1: rule__SimpType__Alternatives : ( ( 'bool' ) | ( '_Bool' ) | ( 'int' ) | ( 'double' ) | ( 'void' ) | ( 'char' ) );
    public final void rule__SimpType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:690:1: ( ( 'bool' ) | ( '_Bool' ) | ( 'int' ) | ( 'double' ) | ( 'void' ) | ( 'char' ) )
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:691:1: ( 'bool' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:691:1: ( 'bool' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:692:1: 'bool'
                    {
                     before(grammarAccess.getSimpTypeAccess().getBoolKeyword_0()); 
                    match(input,20,FOLLOW_20_in_rule__SimpType__Alternatives1408); 
                     after(grammarAccess.getSimpTypeAccess().getBoolKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:699:6: ( '_Bool' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:699:6: ( '_Bool' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:700:1: '_Bool'
                    {
                     before(grammarAccess.getSimpTypeAccess().get_BoolKeyword_1()); 
                    match(input,21,FOLLOW_21_in_rule__SimpType__Alternatives1428); 
                     after(grammarAccess.getSimpTypeAccess().get_BoolKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:707:6: ( 'int' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:707:6: ( 'int' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:708:1: 'int'
                    {
                     before(grammarAccess.getSimpTypeAccess().getIntKeyword_2()); 
                    match(input,22,FOLLOW_22_in_rule__SimpType__Alternatives1448); 
                     after(grammarAccess.getSimpTypeAccess().getIntKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:715:6: ( 'double' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:715:6: ( 'double' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:716:1: 'double'
                    {
                     before(grammarAccess.getSimpTypeAccess().getDoubleKeyword_3()); 
                    match(input,23,FOLLOW_23_in_rule__SimpType__Alternatives1468); 
                     after(grammarAccess.getSimpTypeAccess().getDoubleKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:723:6: ( 'void' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:723:6: ( 'void' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:724:1: 'void'
                    {
                     before(grammarAccess.getSimpTypeAccess().getVoidKeyword_4()); 
                    match(input,24,FOLLOW_24_in_rule__SimpType__Alternatives1488); 
                     after(grammarAccess.getSimpTypeAccess().getVoidKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:731:6: ( 'char' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:731:6: ( 'char' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:732:1: 'char'
                    {
                     before(grammarAccess.getSimpTypeAccess().getCharKeyword_5()); 
                    match(input,25,FOLLOW_25_in_rule__SimpType__Alternatives1508); 
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


    // $ANTLR start "rule__Signed__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:744:1: rule__Signed__Alternatives : ( ( 'signed' ) | ( 'unsigned' ) );
    public final void rule__Signed__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:748:1: ( ( 'signed' ) | ( 'unsigned' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==26) ) {
                alt9=1;
            }
            else if ( (LA9_0==27) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:749:1: ( 'signed' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:749:1: ( 'signed' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:750:1: 'signed'
                    {
                     before(grammarAccess.getSignedAccess().getSignedKeyword_0()); 
                    match(input,26,FOLLOW_26_in_rule__Signed__Alternatives1543); 
                     after(grammarAccess.getSignedAccess().getSignedKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:757:6: ( 'unsigned' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:757:6: ( 'unsigned' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:758:1: 'unsigned'
                    {
                     before(grammarAccess.getSignedAccess().getUnsignedKeyword_1()); 
                    match(input,27,FOLLOW_27_in_rule__Signed__Alternatives1563); 
                     after(grammarAccess.getSignedAccess().getUnsignedKeyword_1()); 

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
    // $ANTLR end "rule__Signed__Alternatives"


    // $ANTLR start "rule__Double__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:770:1: rule__Double__Alternatives : ( ( 'NAN' ) | ( ( rule__Double__Group_1__0 ) ) );
    public final void rule__Double__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:774:1: ( ( 'NAN' ) | ( ( rule__Double__Group_1__0 ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==28) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_INT) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:775:1: ( 'NAN' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:775:1: ( 'NAN' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:776:1: 'NAN'
                    {
                     before(grammarAccess.getDoubleAccess().getNANKeyword_0()); 
                    match(input,28,FOLLOW_28_in_rule__Double__Alternatives1598); 
                     after(grammarAccess.getDoubleAccess().getNANKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:783:6: ( ( rule__Double__Group_1__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:783:6: ( ( rule__Double__Group_1__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:784:1: ( rule__Double__Group_1__0 )
                    {
                     before(grammarAccess.getDoubleAccess().getGroup_1()); 
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:785:1: ( rule__Double__Group_1__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:785:2: rule__Double__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Double__Group_1__0_in_rule__Double__Alternatives1617);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:799:1: rule__Program__Group__0 : rule__Program__Group__0__Impl rule__Program__Group__1 ;
    public final void rule__Program__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:803:1: ( rule__Program__Group__0__Impl rule__Program__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:804:2: rule__Program__Group__0__Impl rule__Program__Group__1
            {
            pushFollow(FOLLOW_rule__Program__Group__0__Impl_in_rule__Program__Group__01651);
            rule__Program__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Program__Group__1_in_rule__Program__Group__01654);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:811:1: rule__Program__Group__0__Impl : ( () ) ;
    public final void rule__Program__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:815:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:816:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:816:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:817:1: ()
            {
             before(grammarAccess.getProgramAccess().getProgramAction_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:818:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:820:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:830:1: rule__Program__Group__1 : rule__Program__Group__1__Impl ;
    public final void rule__Program__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:834:1: ( rule__Program__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:835:2: rule__Program__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Program__Group__1__Impl_in_rule__Program__Group__11712);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:841:1: rule__Program__Group__1__Impl : ( ( rule__Program__ProgramElementsAssignment_1 )* ) ;
    public final void rule__Program__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:845:1: ( ( ( rule__Program__ProgramElementsAssignment_1 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:846:1: ( ( rule__Program__ProgramElementsAssignment_1 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:846:1: ( ( rule__Program__ProgramElementsAssignment_1 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:847:1: ( rule__Program__ProgramElementsAssignment_1 )*
            {
             before(grammarAccess.getProgramAccess().getProgramElementsAssignment_1()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:848:1: ( rule__Program__ProgramElementsAssignment_1 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=12 && LA11_0<=17)||(LA11_0>=20 && LA11_0<=27)||LA11_0==31) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:848:2: rule__Program__ProgramElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Program__ProgramElementsAssignment_1_in_rule__Program__Group__1__Impl1739);
            	    rule__Program__ProgramElementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:862:1: rule__DmplSubclause__Group__0 : rule__DmplSubclause__Group__0__Impl rule__DmplSubclause__Group__1 ;
    public final void rule__DmplSubclause__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:866:1: ( rule__DmplSubclause__Group__0__Impl rule__DmplSubclause__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:867:2: rule__DmplSubclause__Group__0__Impl rule__DmplSubclause__Group__1
            {
            pushFollow(FOLLOW_rule__DmplSubclause__Group__0__Impl_in_rule__DmplSubclause__Group__01774);
            rule__DmplSubclause__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DmplSubclause__Group__1_in_rule__DmplSubclause__Group__01777);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:874:1: rule__DmplSubclause__Group__0__Impl : ( () ) ;
    public final void rule__DmplSubclause__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:878:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:879:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:879:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:880:1: ()
            {
             before(grammarAccess.getDmplSubclauseAccess().getDmplSubclauseAction_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:881:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:883:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:893:1: rule__DmplSubclause__Group__1 : rule__DmplSubclause__Group__1__Impl ;
    public final void rule__DmplSubclause__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:897:1: ( rule__DmplSubclause__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:898:2: rule__DmplSubclause__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DmplSubclause__Group__1__Impl_in_rule__DmplSubclause__Group__11835);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:904:1: rule__DmplSubclause__Group__1__Impl : ( ( rule__DmplSubclause__ProgramAssignment_1 ) ) ;
    public final void rule__DmplSubclause__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:908:1: ( ( ( rule__DmplSubclause__ProgramAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:909:1: ( ( rule__DmplSubclause__ProgramAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:909:1: ( ( rule__DmplSubclause__ProgramAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:910:1: ( rule__DmplSubclause__ProgramAssignment_1 )
            {
             before(grammarAccess.getDmplSubclauseAccess().getProgramAssignment_1()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:911:1: ( rule__DmplSubclause__ProgramAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:911:2: rule__DmplSubclause__ProgramAssignment_1
            {
            pushFollow(FOLLOW_rule__DmplSubclause__ProgramAssignment_1_in_rule__DmplSubclause__Group__1__Impl1862);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:925:1: rule__Constant__Group__0 : rule__Constant__Group__0__Impl rule__Constant__Group__1 ;
    public final void rule__Constant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:929:1: ( rule__Constant__Group__0__Impl rule__Constant__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:930:2: rule__Constant__Group__0__Impl rule__Constant__Group__1
            {
            pushFollow(FOLLOW_rule__Constant__Group__0__Impl_in_rule__Constant__Group__01896);
            rule__Constant__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constant__Group__1_in_rule__Constant__Group__01899);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:937:1: rule__Constant__Group__0__Impl : ( ( rule__Constant__Alternatives_0 ) ) ;
    public final void rule__Constant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:941:1: ( ( ( rule__Constant__Alternatives_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:942:1: ( ( rule__Constant__Alternatives_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:942:1: ( ( rule__Constant__Alternatives_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:943:1: ( rule__Constant__Alternatives_0 )
            {
             before(grammarAccess.getConstantAccess().getAlternatives_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:944:1: ( rule__Constant__Alternatives_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:944:2: rule__Constant__Alternatives_0
            {
            pushFollow(FOLLOW_rule__Constant__Alternatives_0_in_rule__Constant__Group__0__Impl1926);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:954:1: rule__Constant__Group__1 : rule__Constant__Group__1__Impl rule__Constant__Group__2 ;
    public final void rule__Constant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:958:1: ( rule__Constant__Group__1__Impl rule__Constant__Group__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:959:2: rule__Constant__Group__1__Impl rule__Constant__Group__2
            {
            pushFollow(FOLLOW_rule__Constant__Group__1__Impl_in_rule__Constant__Group__11956);
            rule__Constant__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constant__Group__2_in_rule__Constant__Group__11959);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:966:1: rule__Constant__Group__1__Impl : ( ( rule__Constant__NameAssignment_1 ) ) ;
    public final void rule__Constant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:970:1: ( ( ( rule__Constant__NameAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:971:1: ( ( rule__Constant__NameAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:971:1: ( ( rule__Constant__NameAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:972:1: ( rule__Constant__NameAssignment_1 )
            {
             before(grammarAccess.getConstantAccess().getNameAssignment_1()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:973:1: ( rule__Constant__NameAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:973:2: rule__Constant__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Constant__NameAssignment_1_in_rule__Constant__Group__1__Impl1986);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:983:1: rule__Constant__Group__2 : rule__Constant__Group__2__Impl rule__Constant__Group__3 ;
    public final void rule__Constant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:987:1: ( rule__Constant__Group__2__Impl rule__Constant__Group__3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:988:2: rule__Constant__Group__2__Impl rule__Constant__Group__3
            {
            pushFollow(FOLLOW_rule__Constant__Group__2__Impl_in_rule__Constant__Group__22016);
            rule__Constant__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constant__Group__3_in_rule__Constant__Group__22019);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:995:1: rule__Constant__Group__2__Impl : ( '=' ) ;
    public final void rule__Constant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:999:1: ( ( '=' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1000:1: ( '=' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1000:1: ( '=' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1001:1: '='
            {
             before(grammarAccess.getConstantAccess().getEqualsSignKeyword_2()); 
            match(input,29,FOLLOW_29_in_rule__Constant__Group__2__Impl2047); 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1014:1: rule__Constant__Group__3 : rule__Constant__Group__3__Impl rule__Constant__Group__4 ;
    public final void rule__Constant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1018:1: ( rule__Constant__Group__3__Impl rule__Constant__Group__4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1019:2: rule__Constant__Group__3__Impl rule__Constant__Group__4
            {
            pushFollow(FOLLOW_rule__Constant__Group__3__Impl_in_rule__Constant__Group__32078);
            rule__Constant__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Constant__Group__4_in_rule__Constant__Group__32081);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1026:1: rule__Constant__Group__3__Impl : ( ( rule__Constant__ValueAssignment_3 ) ) ;
    public final void rule__Constant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1030:1: ( ( ( rule__Constant__ValueAssignment_3 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1031:1: ( ( rule__Constant__ValueAssignment_3 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1031:1: ( ( rule__Constant__ValueAssignment_3 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1032:1: ( rule__Constant__ValueAssignment_3 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_3()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1033:1: ( rule__Constant__ValueAssignment_3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1033:2: rule__Constant__ValueAssignment_3
            {
            pushFollow(FOLLOW_rule__Constant__ValueAssignment_3_in_rule__Constant__Group__3__Impl2108);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1043:1: rule__Constant__Group__4 : rule__Constant__Group__4__Impl ;
    public final void rule__Constant__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1047:1: ( rule__Constant__Group__4__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1048:2: rule__Constant__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Constant__Group__4__Impl_in_rule__Constant__Group__42138);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1054:1: rule__Constant__Group__4__Impl : ( ';' ) ;
    public final void rule__Constant__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1058:1: ( ( ';' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1059:1: ( ';' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1059:1: ( ';' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1060:1: ';'
            {
             before(grammarAccess.getConstantAccess().getSemicolonKeyword_4()); 
            match(input,30,FOLLOW_30_in_rule__Constant__Group__4__Impl2166); 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1083:1: rule__IntConst__Group__0 : rule__IntConst__Group__0__Impl rule__IntConst__Group__1 ;
    public final void rule__IntConst__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1087:1: ( rule__IntConst__Group__0__Impl rule__IntConst__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1088:2: rule__IntConst__Group__0__Impl rule__IntConst__Group__1
            {
            pushFollow(FOLLOW_rule__IntConst__Group__0__Impl_in_rule__IntConst__Group__02207);
            rule__IntConst__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IntConst__Group__1_in_rule__IntConst__Group__02210);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1095:1: rule__IntConst__Group__0__Impl : ( ( rule__IntConst__SignAssignment_0 )? ) ;
    public final void rule__IntConst__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1099:1: ( ( ( rule__IntConst__SignAssignment_0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1100:1: ( ( rule__IntConst__SignAssignment_0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1100:1: ( ( rule__IntConst__SignAssignment_0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1101:1: ( rule__IntConst__SignAssignment_0 )?
            {
             before(grammarAccess.getIntConstAccess().getSignAssignment_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1102:1: ( rule__IntConst__SignAssignment_0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=18 && LA12_0<=19)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1102:2: rule__IntConst__SignAssignment_0
                    {
                    pushFollow(FOLLOW_rule__IntConst__SignAssignment_0_in_rule__IntConst__Group__0__Impl2237);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1112:1: rule__IntConst__Group__1 : rule__IntConst__Group__1__Impl ;
    public final void rule__IntConst__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1116:1: ( rule__IntConst__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1117:2: rule__IntConst__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntConst__Group__1__Impl_in_rule__IntConst__Group__12268);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1123:1: rule__IntConst__Group__1__Impl : ( ( rule__IntConst__ValueAssignment_1 ) ) ;
    public final void rule__IntConst__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1127:1: ( ( ( rule__IntConst__ValueAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1128:1: ( ( rule__IntConst__ValueAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1128:1: ( ( rule__IntConst__ValueAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1129:1: ( rule__IntConst__ValueAssignment_1 )
            {
             before(grammarAccess.getIntConstAccess().getValueAssignment_1()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1130:1: ( rule__IntConst__ValueAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1130:2: rule__IntConst__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__IntConst__ValueAssignment_1_in_rule__IntConst__Group__1__Impl2295);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1144:1: rule__DoubleConst__Group__0 : rule__DoubleConst__Group__0__Impl rule__DoubleConst__Group__1 ;
    public final void rule__DoubleConst__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1148:1: ( rule__DoubleConst__Group__0__Impl rule__DoubleConst__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1149:2: rule__DoubleConst__Group__0__Impl rule__DoubleConst__Group__1
            {
            pushFollow(FOLLOW_rule__DoubleConst__Group__0__Impl_in_rule__DoubleConst__Group__02329);
            rule__DoubleConst__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DoubleConst__Group__1_in_rule__DoubleConst__Group__02332);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1156:1: rule__DoubleConst__Group__0__Impl : ( ( rule__DoubleConst__SignAssignment_0 )? ) ;
    public final void rule__DoubleConst__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1160:1: ( ( ( rule__DoubleConst__SignAssignment_0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1161:1: ( ( rule__DoubleConst__SignAssignment_0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1161:1: ( ( rule__DoubleConst__SignAssignment_0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1162:1: ( rule__DoubleConst__SignAssignment_0 )?
            {
             before(grammarAccess.getDoubleConstAccess().getSignAssignment_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1163:1: ( rule__DoubleConst__SignAssignment_0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=18 && LA13_0<=19)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1163:2: rule__DoubleConst__SignAssignment_0
                    {
                    pushFollow(FOLLOW_rule__DoubleConst__SignAssignment_0_in_rule__DoubleConst__Group__0__Impl2359);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1173:1: rule__DoubleConst__Group__1 : rule__DoubleConst__Group__1__Impl ;
    public final void rule__DoubleConst__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1177:1: ( rule__DoubleConst__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1178:2: rule__DoubleConst__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DoubleConst__Group__1__Impl_in_rule__DoubleConst__Group__12390);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1184:1: rule__DoubleConst__Group__1__Impl : ( ( rule__DoubleConst__ValueAssignment_1 ) ) ;
    public final void rule__DoubleConst__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1188:1: ( ( ( rule__DoubleConst__ValueAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1189:1: ( ( rule__DoubleConst__ValueAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1189:1: ( ( rule__DoubleConst__ValueAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1190:1: ( rule__DoubleConst__ValueAssignment_1 )
            {
             before(grammarAccess.getDoubleConstAccess().getValueAssignment_1()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1191:1: ( rule__DoubleConst__ValueAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1191:2: rule__DoubleConst__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__DoubleConst__ValueAssignment_1_in_rule__DoubleConst__Group__1__Impl2417);
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


    // $ANTLR start "rule__Type__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1205:1: rule__Type__Group__0 : rule__Type__Group__0__Impl rule__Type__Group__1 ;
    public final void rule__Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1209:1: ( rule__Type__Group__0__Impl rule__Type__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1210:2: rule__Type__Group__0__Impl rule__Type__Group__1
            {
            pushFollow(FOLLOW_rule__Type__Group__0__Impl_in_rule__Type__Group__02451);
            rule__Type__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Type__Group__1_in_rule__Type__Group__02454);
            rule__Type__Group__1();

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
    // $ANTLR end "rule__Type__Group__0"


    // $ANTLR start "rule__Type__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1217:1: rule__Type__Group__0__Impl : ( ( rule__Type__SignedAssignment_0 )? ) ;
    public final void rule__Type__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1221:1: ( ( ( rule__Type__SignedAssignment_0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1222:1: ( ( rule__Type__SignedAssignment_0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1222:1: ( ( rule__Type__SignedAssignment_0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1223:1: ( rule__Type__SignedAssignment_0 )?
            {
             before(grammarAccess.getTypeAccess().getSignedAssignment_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1224:1: ( rule__Type__SignedAssignment_0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=26 && LA14_0<=27)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1224:2: rule__Type__SignedAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Type__SignedAssignment_0_in_rule__Type__Group__0__Impl2481);
                    rule__Type__SignedAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeAccess().getSignedAssignment_0()); 

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
    // $ANTLR end "rule__Type__Group__0__Impl"


    // $ANTLR start "rule__Type__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1234:1: rule__Type__Group__1 : rule__Type__Group__1__Impl ;
    public final void rule__Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1238:1: ( rule__Type__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1239:2: rule__Type__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Type__Group__1__Impl_in_rule__Type__Group__12512);
            rule__Type__Group__1__Impl();

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
    // $ANTLR end "rule__Type__Group__1"


    // $ANTLR start "rule__Type__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1245:1: rule__Type__Group__1__Impl : ( ( rule__Type__SimpTypeAssignment_1 ) ) ;
    public final void rule__Type__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1249:1: ( ( ( rule__Type__SimpTypeAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1250:1: ( ( rule__Type__SimpTypeAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1250:1: ( ( rule__Type__SimpTypeAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1251:1: ( rule__Type__SimpTypeAssignment_1 )
            {
             before(grammarAccess.getTypeAccess().getSimpTypeAssignment_1()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1252:1: ( rule__Type__SimpTypeAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1252:2: rule__Type__SimpTypeAssignment_1
            {
            pushFollow(FOLLOW_rule__Type__SimpTypeAssignment_1_in_rule__Type__Group__1__Impl2539);
            rule__Type__SimpTypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getSimpTypeAssignment_1()); 

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
    // $ANTLR end "rule__Type__Group__1__Impl"


    // $ANTLR start "rule__ProcNoAttr__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1266:1: rule__ProcNoAttr__Group__0 : rule__ProcNoAttr__Group__0__Impl rule__ProcNoAttr__Group__1 ;
    public final void rule__ProcNoAttr__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1270:1: ( rule__ProcNoAttr__Group__0__Impl rule__ProcNoAttr__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1271:2: rule__ProcNoAttr__Group__0__Impl rule__ProcNoAttr__Group__1
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__Group__0__Impl_in_rule__ProcNoAttr__Group__02573);
            rule__ProcNoAttr__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ProcNoAttr__Group__1_in_rule__ProcNoAttr__Group__02576);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1278:1: rule__ProcNoAttr__Group__0__Impl : ( ( rule__ProcNoAttr__PrototypeAssignment_0 ) ) ;
    public final void rule__ProcNoAttr__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1282:1: ( ( ( rule__ProcNoAttr__PrototypeAssignment_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1283:1: ( ( rule__ProcNoAttr__PrototypeAssignment_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1283:1: ( ( rule__ProcNoAttr__PrototypeAssignment_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1284:1: ( rule__ProcNoAttr__PrototypeAssignment_0 )
            {
             before(grammarAccess.getProcNoAttrAccess().getPrototypeAssignment_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1285:1: ( rule__ProcNoAttr__PrototypeAssignment_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1285:2: rule__ProcNoAttr__PrototypeAssignment_0
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__PrototypeAssignment_0_in_rule__ProcNoAttr__Group__0__Impl2603);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1295:1: rule__ProcNoAttr__Group__1 : rule__ProcNoAttr__Group__1__Impl ;
    public final void rule__ProcNoAttr__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1299:1: ( rule__ProcNoAttr__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1300:2: rule__ProcNoAttr__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__Group__1__Impl_in_rule__ProcNoAttr__Group__12633);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1306:1: rule__ProcNoAttr__Group__1__Impl : ( ';' ) ;
    public final void rule__ProcNoAttr__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1310:1: ( ( ';' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1311:1: ( ';' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1311:1: ( ';' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1312:1: ';'
            {
             before(grammarAccess.getProcNoAttrAccess().getSemicolonKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__ProcNoAttr__Group__1__Impl2661); 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1329:1: rule__FnPrototype__Group__0 : rule__FnPrototype__Group__0__Impl rule__FnPrototype__Group__1 ;
    public final void rule__FnPrototype__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1333:1: ( rule__FnPrototype__Group__0__Impl rule__FnPrototype__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1334:2: rule__FnPrototype__Group__0__Impl rule__FnPrototype__Group__1
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group__0__Impl_in_rule__FnPrototype__Group__02696);
            rule__FnPrototype__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FnPrototype__Group__1_in_rule__FnPrototype__Group__02699);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1341:1: rule__FnPrototype__Group__0__Impl : ( ( rule__FnPrototype__ExternAssignment_0 )? ) ;
    public final void rule__FnPrototype__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1345:1: ( ( ( rule__FnPrototype__ExternAssignment_0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1346:1: ( ( rule__FnPrototype__ExternAssignment_0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1346:1: ( ( rule__FnPrototype__ExternAssignment_0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1347:1: ( rule__FnPrototype__ExternAssignment_0 )?
            {
             before(grammarAccess.getFnPrototypeAccess().getExternAssignment_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1348:1: ( rule__FnPrototype__ExternAssignment_0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=14 && LA15_0<=15)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1348:2: rule__FnPrototype__ExternAssignment_0
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__ExternAssignment_0_in_rule__FnPrototype__Group__0__Impl2726);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1358:1: rule__FnPrototype__Group__1 : rule__FnPrototype__Group__1__Impl rule__FnPrototype__Group__2 ;
    public final void rule__FnPrototype__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1362:1: ( rule__FnPrototype__Group__1__Impl rule__FnPrototype__Group__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1363:2: rule__FnPrototype__Group__1__Impl rule__FnPrototype__Group__2
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group__1__Impl_in_rule__FnPrototype__Group__12757);
            rule__FnPrototype__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FnPrototype__Group__2_in_rule__FnPrototype__Group__12760);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1370:1: rule__FnPrototype__Group__1__Impl : ( ( rule__FnPrototype__PureAssignment_1 )? ) ;
    public final void rule__FnPrototype__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1374:1: ( ( ( rule__FnPrototype__PureAssignment_1 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1375:1: ( ( rule__FnPrototype__PureAssignment_1 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1375:1: ( ( rule__FnPrototype__PureAssignment_1 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1376:1: ( rule__FnPrototype__PureAssignment_1 )?
            {
             before(grammarAccess.getFnPrototypeAccess().getPureAssignment_1()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1377:1: ( rule__FnPrototype__PureAssignment_1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=16 && LA16_0<=17)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1377:2: rule__FnPrototype__PureAssignment_1
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__PureAssignment_1_in_rule__FnPrototype__Group__1__Impl2787);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1387:1: rule__FnPrototype__Group__2 : rule__FnPrototype__Group__2__Impl ;
    public final void rule__FnPrototype__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1391:1: ( rule__FnPrototype__Group__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1392:2: rule__FnPrototype__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group__2__Impl_in_rule__FnPrototype__Group__22818);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1398:1: rule__FnPrototype__Group__2__Impl : ( ( rule__FnPrototype__PrototypeAssignment_2 ) ) ;
    public final void rule__FnPrototype__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1402:1: ( ( ( rule__FnPrototype__PrototypeAssignment_2 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1403:1: ( ( rule__FnPrototype__PrototypeAssignment_2 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1403:1: ( ( rule__FnPrototype__PrototypeAssignment_2 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1404:1: ( rule__FnPrototype__PrototypeAssignment_2 )
            {
             before(grammarAccess.getFnPrototypeAccess().getPrototypeAssignment_2()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1405:1: ( rule__FnPrototype__PrototypeAssignment_2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1405:2: rule__FnPrototype__PrototypeAssignment_2
            {
            pushFollow(FOLLOW_rule__FnPrototype__PrototypeAssignment_2_in_rule__FnPrototype__Group__2__Impl2845);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1421:1: rule__FnPrototypeNoDecors__Group_0__0 : rule__FnPrototypeNoDecors__Group_0__0__Impl rule__FnPrototypeNoDecors__Group_0__1 ;
    public final void rule__FnPrototypeNoDecors__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1425:1: ( rule__FnPrototypeNoDecors__Group_0__0__Impl rule__FnPrototypeNoDecors__Group_0__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1426:2: rule__FnPrototypeNoDecors__Group_0__0__Impl rule__FnPrototypeNoDecors__Group_0__1
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_0__0__Impl_in_rule__FnPrototypeNoDecors__Group_0__02881);
            rule__FnPrototypeNoDecors__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_0__1_in_rule__FnPrototypeNoDecors__Group_0__02884);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1433:1: rule__FnPrototypeNoDecors__Group_0__0__Impl : ( () ) ;
    public final void rule__FnPrototypeNoDecors__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1437:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1438:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1438:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1439:1: ()
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getThreadDeclarationAction_0_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1440:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1442:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1452:1: rule__FnPrototypeNoDecors__Group_0__1 : rule__FnPrototypeNoDecors__Group_0__1__Impl rule__FnPrototypeNoDecors__Group_0__2 ;
    public final void rule__FnPrototypeNoDecors__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1456:1: ( rule__FnPrototypeNoDecors__Group_0__1__Impl rule__FnPrototypeNoDecors__Group_0__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1457:2: rule__FnPrototypeNoDecors__Group_0__1__Impl rule__FnPrototypeNoDecors__Group_0__2
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_0__1__Impl_in_rule__FnPrototypeNoDecors__Group_0__12942);
            rule__FnPrototypeNoDecors__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_0__2_in_rule__FnPrototypeNoDecors__Group_0__12945);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1464:1: rule__FnPrototypeNoDecors__Group_0__1__Impl : ( 'thread' ) ;
    public final void rule__FnPrototypeNoDecors__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1468:1: ( ( 'thread' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1469:1: ( 'thread' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1469:1: ( 'thread' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1470:1: 'thread'
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getThreadKeyword_0_1()); 
            match(input,31,FOLLOW_31_in_rule__FnPrototypeNoDecors__Group_0__1__Impl2973); 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1483:1: rule__FnPrototypeNoDecors__Group_0__2 : rule__FnPrototypeNoDecors__Group_0__2__Impl ;
    public final void rule__FnPrototypeNoDecors__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1487:1: ( rule__FnPrototypeNoDecors__Group_0__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1488:2: rule__FnPrototypeNoDecors__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_0__2__Impl_in_rule__FnPrototypeNoDecors__Group_0__23004);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1494:1: rule__FnPrototypeNoDecors__Group_0__2__Impl : ( ( rule__FnPrototypeNoDecors__NameAssignment_0_2 ) ) ;
    public final void rule__FnPrototypeNoDecors__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1498:1: ( ( ( rule__FnPrototypeNoDecors__NameAssignment_0_2 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1499:1: ( ( rule__FnPrototypeNoDecors__NameAssignment_0_2 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1499:1: ( ( rule__FnPrototypeNoDecors__NameAssignment_0_2 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1500:1: ( rule__FnPrototypeNoDecors__NameAssignment_0_2 )
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getNameAssignment_0_2()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1501:1: ( rule__FnPrototypeNoDecors__NameAssignment_0_2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1501:2: rule__FnPrototypeNoDecors__NameAssignment_0_2
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__NameAssignment_0_2_in_rule__FnPrototypeNoDecors__Group_0__2__Impl3031);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1517:1: rule__FnPrototypeNoDecors__Group_1__0 : rule__FnPrototypeNoDecors__Group_1__0__Impl rule__FnPrototypeNoDecors__Group_1__1 ;
    public final void rule__FnPrototypeNoDecors__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1521:1: ( rule__FnPrototypeNoDecors__Group_1__0__Impl rule__FnPrototypeNoDecors__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1522:2: rule__FnPrototypeNoDecors__Group_1__0__Impl rule__FnPrototypeNoDecors__Group_1__1
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__0__Impl_in_rule__FnPrototypeNoDecors__Group_1__03067);
            rule__FnPrototypeNoDecors__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__1_in_rule__FnPrototypeNoDecors__Group_1__03070);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1529:1: rule__FnPrototypeNoDecors__Group_1__0__Impl : ( () ) ;
    public final void rule__FnPrototypeNoDecors__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1533:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1534:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1534:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1535:1: ()
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getFnPrototypeDeclarationAction_1_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1536:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1538:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1548:1: rule__FnPrototypeNoDecors__Group_1__1 : rule__FnPrototypeNoDecors__Group_1__1__Impl rule__FnPrototypeNoDecors__Group_1__2 ;
    public final void rule__FnPrototypeNoDecors__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1552:1: ( rule__FnPrototypeNoDecors__Group_1__1__Impl rule__FnPrototypeNoDecors__Group_1__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1553:2: rule__FnPrototypeNoDecors__Group_1__1__Impl rule__FnPrototypeNoDecors__Group_1__2
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__1__Impl_in_rule__FnPrototypeNoDecors__Group_1__13128);
            rule__FnPrototypeNoDecors__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__2_in_rule__FnPrototypeNoDecors__Group_1__13131);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1560:1: rule__FnPrototypeNoDecors__Group_1__1__Impl : ( ( rule__FnPrototypeNoDecors__TypeAssignment_1_1 ) ) ;
    public final void rule__FnPrototypeNoDecors__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1564:1: ( ( ( rule__FnPrototypeNoDecors__TypeAssignment_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1565:1: ( ( rule__FnPrototypeNoDecors__TypeAssignment_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1565:1: ( ( rule__FnPrototypeNoDecors__TypeAssignment_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1566:1: ( rule__FnPrototypeNoDecors__TypeAssignment_1_1 )
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getTypeAssignment_1_1()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1567:1: ( rule__FnPrototypeNoDecors__TypeAssignment_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1567:2: rule__FnPrototypeNoDecors__TypeAssignment_1_1
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__TypeAssignment_1_1_in_rule__FnPrototypeNoDecors__Group_1__1__Impl3158);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1577:1: rule__FnPrototypeNoDecors__Group_1__2 : rule__FnPrototypeNoDecors__Group_1__2__Impl rule__FnPrototypeNoDecors__Group_1__3 ;
    public final void rule__FnPrototypeNoDecors__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1581:1: ( rule__FnPrototypeNoDecors__Group_1__2__Impl rule__FnPrototypeNoDecors__Group_1__3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1582:2: rule__FnPrototypeNoDecors__Group_1__2__Impl rule__FnPrototypeNoDecors__Group_1__3
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__2__Impl_in_rule__FnPrototypeNoDecors__Group_1__23188);
            rule__FnPrototypeNoDecors__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__3_in_rule__FnPrototypeNoDecors__Group_1__23191);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1589:1: rule__FnPrototypeNoDecors__Group_1__2__Impl : ( ( rule__FnPrototypeNoDecors__NameAssignment_1_2 ) ) ;
    public final void rule__FnPrototypeNoDecors__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1593:1: ( ( ( rule__FnPrototypeNoDecors__NameAssignment_1_2 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1594:1: ( ( rule__FnPrototypeNoDecors__NameAssignment_1_2 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1594:1: ( ( rule__FnPrototypeNoDecors__NameAssignment_1_2 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1595:1: ( rule__FnPrototypeNoDecors__NameAssignment_1_2 )
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getNameAssignment_1_2()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1596:1: ( rule__FnPrototypeNoDecors__NameAssignment_1_2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1596:2: rule__FnPrototypeNoDecors__NameAssignment_1_2
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__NameAssignment_1_2_in_rule__FnPrototypeNoDecors__Group_1__2__Impl3218);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1606:1: rule__FnPrototypeNoDecors__Group_1__3 : rule__FnPrototypeNoDecors__Group_1__3__Impl rule__FnPrototypeNoDecors__Group_1__4 ;
    public final void rule__FnPrototypeNoDecors__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1610:1: ( rule__FnPrototypeNoDecors__Group_1__3__Impl rule__FnPrototypeNoDecors__Group_1__4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1611:2: rule__FnPrototypeNoDecors__Group_1__3__Impl rule__FnPrototypeNoDecors__Group_1__4
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__3__Impl_in_rule__FnPrototypeNoDecors__Group_1__33248);
            rule__FnPrototypeNoDecors__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__4_in_rule__FnPrototypeNoDecors__Group_1__33251);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1618:1: rule__FnPrototypeNoDecors__Group_1__3__Impl : ( '(' ) ;
    public final void rule__FnPrototypeNoDecors__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1622:1: ( ( '(' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1623:1: ( '(' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1623:1: ( '(' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1624:1: '('
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getLeftParenthesisKeyword_1_3()); 
            match(input,32,FOLLOW_32_in_rule__FnPrototypeNoDecors__Group_1__3__Impl3279); 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1637:1: rule__FnPrototypeNoDecors__Group_1__4 : rule__FnPrototypeNoDecors__Group_1__4__Impl ;
    public final void rule__FnPrototypeNoDecors__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1641:1: ( rule__FnPrototypeNoDecors__Group_1__4__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1642:2: rule__FnPrototypeNoDecors__Group_1__4__Impl
            {
            pushFollow(FOLLOW_rule__FnPrototypeNoDecors__Group_1__4__Impl_in_rule__FnPrototypeNoDecors__Group_1__43310);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1648:1: rule__FnPrototypeNoDecors__Group_1__4__Impl : ( ')' ) ;
    public final void rule__FnPrototypeNoDecors__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1652:1: ( ( ')' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1653:1: ( ')' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1653:1: ( ')' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1654:1: ')'
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getRightParenthesisKeyword_1_4()); 
            match(input,33,FOLLOW_33_in_rule__FnPrototypeNoDecors__Group_1__4__Impl3338); 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1677:1: rule__Double__Group_1__0 : rule__Double__Group_1__0__Impl rule__Double__Group_1__1 ;
    public final void rule__Double__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1681:1: ( rule__Double__Group_1__0__Impl rule__Double__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1682:2: rule__Double__Group_1__0__Impl rule__Double__Group_1__1
            {
            pushFollow(FOLLOW_rule__Double__Group_1__0__Impl_in_rule__Double__Group_1__03379);
            rule__Double__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Double__Group_1__1_in_rule__Double__Group_1__03382);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1689:1: rule__Double__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__Double__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1693:1: ( ( RULE_INT ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1694:1: ( RULE_INT )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1694:1: ( RULE_INT )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1695:1: RULE_INT
            {
             before(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Double__Group_1__0__Impl3409); 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1706:1: rule__Double__Group_1__1 : rule__Double__Group_1__1__Impl rule__Double__Group_1__2 ;
    public final void rule__Double__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1710:1: ( rule__Double__Group_1__1__Impl rule__Double__Group_1__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1711:2: rule__Double__Group_1__1__Impl rule__Double__Group_1__2
            {
            pushFollow(FOLLOW_rule__Double__Group_1__1__Impl_in_rule__Double__Group_1__13438);
            rule__Double__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Double__Group_1__2_in_rule__Double__Group_1__13441);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1718:1: rule__Double__Group_1__1__Impl : ( '.' ) ;
    public final void rule__Double__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1722:1: ( ( '.' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1723:1: ( '.' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1723:1: ( '.' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1724:1: '.'
            {
             before(grammarAccess.getDoubleAccess().getFullStopKeyword_1_1()); 
            match(input,34,FOLLOW_34_in_rule__Double__Group_1__1__Impl3469); 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1737:1: rule__Double__Group_1__2 : rule__Double__Group_1__2__Impl ;
    public final void rule__Double__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1741:1: ( rule__Double__Group_1__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1742:2: rule__Double__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Double__Group_1__2__Impl_in_rule__Double__Group_1__23500);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1748:1: rule__Double__Group_1__2__Impl : ( ( RULE_INT )? ) ;
    public final void rule__Double__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1752:1: ( ( ( RULE_INT )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1753:1: ( ( RULE_INT )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1753:1: ( ( RULE_INT )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1754:1: ( RULE_INT )?
            {
             before(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_2()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1755:1: ( RULE_INT )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_INT) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1755:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Double__Group_1__2__Impl3528); 

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1772:1: rule__Program__ProgramElementsAssignment_1 : ( ruleProgramElement ) ;
    public final void rule__Program__ProgramElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1776:1: ( ( ruleProgramElement ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1777:1: ( ruleProgramElement )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1777:1: ( ruleProgramElement )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1778:1: ruleProgramElement
            {
             before(grammarAccess.getProgramAccess().getProgramElementsProgramElementParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleProgramElement_in_rule__Program__ProgramElementsAssignment_13570);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1787:1: rule__DmplSubclause__ProgramAssignment_1 : ( ruleProgram ) ;
    public final void rule__DmplSubclause__ProgramAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1791:1: ( ( ruleProgram ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1792:1: ( ruleProgram )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1792:1: ( ruleProgram )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1793:1: ruleProgram
            {
             before(grammarAccess.getDmplSubclauseAccess().getProgramProgramParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleProgram_in_rule__DmplSubclause__ProgramAssignment_13601);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1802:1: rule__Constant__NameAssignment_1 : ( RULE_TIDENTIFIER ) ;
    public final void rule__Constant__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1806:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1807:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1807:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1808:1: RULE_TIDENTIFIER
            {
             before(grammarAccess.getConstantAccess().getNameTIDENTIFIERTerminalRuleCall_1_0()); 
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__Constant__NameAssignment_13632); 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1817:1: rule__Constant__ValueAssignment_3 : ( ruleNumberConst ) ;
    public final void rule__Constant__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1821:1: ( ( ruleNumberConst ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1822:1: ( ruleNumberConst )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1822:1: ( ruleNumberConst )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1823:1: ruleNumberConst
            {
             before(grammarAccess.getConstantAccess().getValueNumberConstParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleNumberConst_in_rule__Constant__ValueAssignment_33663);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1832:1: rule__IntConst__SignAssignment_0 : ( ruleSign ) ;
    public final void rule__IntConst__SignAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1836:1: ( ( ruleSign ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1837:1: ( ruleSign )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1837:1: ( ruleSign )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1838:1: ruleSign
            {
             before(grammarAccess.getIntConstAccess().getSignSignParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleSign_in_rule__IntConst__SignAssignment_03694);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1847:1: rule__IntConst__ValueAssignment_1 : ( RULE_INT ) ;
    public final void rule__IntConst__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1851:1: ( ( RULE_INT ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1852:1: ( RULE_INT )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1852:1: ( RULE_INT )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1853:1: RULE_INT
            {
             before(grammarAccess.getIntConstAccess().getValueINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__IntConst__ValueAssignment_13725); 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1862:1: rule__DoubleConst__SignAssignment_0 : ( ruleSign ) ;
    public final void rule__DoubleConst__SignAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1866:1: ( ( ruleSign ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1867:1: ( ruleSign )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1867:1: ( ruleSign )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1868:1: ruleSign
            {
             before(grammarAccess.getDoubleConstAccess().getSignSignParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleSign_in_rule__DoubleConst__SignAssignment_03756);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1877:1: rule__DoubleConst__ValueAssignment_1 : ( ruleDouble ) ;
    public final void rule__DoubleConst__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1881:1: ( ( ruleDouble ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1882:1: ( ruleDouble )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1882:1: ( ruleDouble )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1883:1: ruleDouble
            {
             before(grammarAccess.getDoubleConstAccess().getValueDoubleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDouble_in_rule__DoubleConst__ValueAssignment_13787);
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


    // $ANTLR start "rule__Type__SignedAssignment_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1892:1: rule__Type__SignedAssignment_0 : ( ruleSigned ) ;
    public final void rule__Type__SignedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1896:1: ( ( ruleSigned ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1897:1: ( ruleSigned )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1897:1: ( ruleSigned )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1898:1: ruleSigned
            {
             before(grammarAccess.getTypeAccess().getSignedSignedParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleSigned_in_rule__Type__SignedAssignment_03818);
            ruleSigned();

            state._fsp--;

             after(grammarAccess.getTypeAccess().getSignedSignedParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__Type__SignedAssignment_0"


    // $ANTLR start "rule__Type__SimpTypeAssignment_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1907:1: rule__Type__SimpTypeAssignment_1 : ( ruleSimpType ) ;
    public final void rule__Type__SimpTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1911:1: ( ( ruleSimpType ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1912:1: ( ruleSimpType )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1912:1: ( ruleSimpType )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1913:1: ruleSimpType
            {
             before(grammarAccess.getTypeAccess().getSimpTypeSimpTypeParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleSimpType_in_rule__Type__SimpTypeAssignment_13849);
            ruleSimpType();

            state._fsp--;

             after(grammarAccess.getTypeAccess().getSimpTypeSimpTypeParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__Type__SimpTypeAssignment_1"


    // $ANTLR start "rule__Procedure__ProcedureAssignment"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1922:1: rule__Procedure__ProcedureAssignment : ( ruleProcNoAttr ) ;
    public final void rule__Procedure__ProcedureAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1926:1: ( ( ruleProcNoAttr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1927:1: ( ruleProcNoAttr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1927:1: ( ruleProcNoAttr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1928:1: ruleProcNoAttr
            {
             before(grammarAccess.getProcedureAccess().getProcedureProcNoAttrParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleProcNoAttr_in_rule__Procedure__ProcedureAssignment3880);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1937:1: rule__ProcNoAttr__PrototypeAssignment_0 : ( ruleFnPrototype ) ;
    public final void rule__ProcNoAttr__PrototypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1941:1: ( ( ruleFnPrototype ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1942:1: ( ruleFnPrototype )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1942:1: ( ruleFnPrototype )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1943:1: ruleFnPrototype
            {
             before(grammarAccess.getProcNoAttrAccess().getPrototypeFnPrototypeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleFnPrototype_in_rule__ProcNoAttr__PrototypeAssignment_03911);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1952:1: rule__FnPrototype__ExternAssignment_0 : ( ( rule__FnPrototype__ExternAlternatives_0_0 ) ) ;
    public final void rule__FnPrototype__ExternAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1956:1: ( ( ( rule__FnPrototype__ExternAlternatives_0_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1957:1: ( ( rule__FnPrototype__ExternAlternatives_0_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1957:1: ( ( rule__FnPrototype__ExternAlternatives_0_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1958:1: ( rule__FnPrototype__ExternAlternatives_0_0 )
            {
             before(grammarAccess.getFnPrototypeAccess().getExternAlternatives_0_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1959:1: ( rule__FnPrototype__ExternAlternatives_0_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1959:2: rule__FnPrototype__ExternAlternatives_0_0
            {
            pushFollow(FOLLOW_rule__FnPrototype__ExternAlternatives_0_0_in_rule__FnPrototype__ExternAssignment_03942);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1968:1: rule__FnPrototype__PureAssignment_1 : ( ( rule__FnPrototype__PureAlternatives_1_0 ) ) ;
    public final void rule__FnPrototype__PureAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1972:1: ( ( ( rule__FnPrototype__PureAlternatives_1_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1973:1: ( ( rule__FnPrototype__PureAlternatives_1_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1973:1: ( ( rule__FnPrototype__PureAlternatives_1_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1974:1: ( rule__FnPrototype__PureAlternatives_1_0 )
            {
             before(grammarAccess.getFnPrototypeAccess().getPureAlternatives_1_0()); 
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1975:1: ( rule__FnPrototype__PureAlternatives_1_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1975:2: rule__FnPrototype__PureAlternatives_1_0
            {
            pushFollow(FOLLOW_rule__FnPrototype__PureAlternatives_1_0_in_rule__FnPrototype__PureAssignment_13975);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1984:1: rule__FnPrototype__PrototypeAssignment_2 : ( ruleFnPrototypeNoDecors ) ;
    public final void rule__FnPrototype__PrototypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1988:1: ( ( ruleFnPrototypeNoDecors ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1989:1: ( ruleFnPrototypeNoDecors )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1989:1: ( ruleFnPrototypeNoDecors )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1990:1: ruleFnPrototypeNoDecors
            {
             before(grammarAccess.getFnPrototypeAccess().getPrototypeFnPrototypeNoDecorsParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleFnPrototypeNoDecors_in_rule__FnPrototype__PrototypeAssignment_24008);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1999:1: rule__FnPrototypeNoDecors__NameAssignment_0_2 : ( RULE_TIDENTIFIER ) ;
    public final void rule__FnPrototypeNoDecors__NameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2003:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2004:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2004:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2005:1: RULE_TIDENTIFIER
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getNameTIDENTIFIERTerminalRuleCall_0_2_0()); 
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__FnPrototypeNoDecors__NameAssignment_0_24039); 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2014:1: rule__FnPrototypeNoDecors__TypeAssignment_1_1 : ( ruleType ) ;
    public final void rule__FnPrototypeNoDecors__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2018:1: ( ( ruleType ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2019:1: ( ruleType )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2019:1: ( ruleType )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2020:1: ruleType
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getTypeTypeParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleType_in_rule__FnPrototypeNoDecors__TypeAssignment_1_14070);
            ruleType();

            state._fsp--;

             after(grammarAccess.getFnPrototypeNoDecorsAccess().getTypeTypeParserRuleCall_1_1_0()); 

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2029:1: rule__FnPrototypeNoDecors__NameAssignment_1_2 : ( RULE_TIDENTIFIER ) ;
    public final void rule__FnPrototypeNoDecors__NameAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2033:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2034:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2034:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2035:1: RULE_TIDENTIFIER
            {
             before(grammarAccess.getFnPrototypeNoDecorsAccess().getNameTIDENTIFIERTerminalRuleCall_1_2_0()); 
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__FnPrototypeNoDecors__NameAssignment_1_24101); 
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
    public static final BitSet FOLLOW_rule__Type__Group__0_in_ruleType516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcedure_in_entryRuleProcedure543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcedure550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Procedure__ProcedureAssignment_in_ruleProcedure576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcNoAttr_in_entryRuleProcNoAttr603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcNoAttr610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Group__0_in_ruleProcNoAttr636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnPrototype_in_entryRuleFnPrototype663 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFnPrototype670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group__0_in_ruleFnPrototype696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnPrototypeNoDecors_in_entryRuleFnPrototypeNoDecors723 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFnPrototypeNoDecors730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Alternatives_in_ruleFnPrototypeNoDecors756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSign_in_entryRuleSign783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSign790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sign__Alternatives_in_ruleSign816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpType_in_entryRuleSimpType843 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpType850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpType__Alternatives_in_ruleSimpType876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSigned_in_entryRuleSigned903 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSigned910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signed__Alternatives_in_ruleSigned936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDouble_in_entryRuleDouble963 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDouble970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Alternatives_in_ruleDouble996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_rule__ProgramElement__Alternatives1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcedure_in_rule__ProgramElement__Alternatives1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Constant__Alternatives_01088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Constant__Alternatives_01108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntConst_in_rule__NumberConst__Alternatives1142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleConst_in_rule__NumberConst__Alternatives1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__FnPrototype__ExternAlternatives_0_01192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__FnPrototype__ExternAlternatives_0_01212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__FnPrototype__PureAlternatives_1_01247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__FnPrototype__PureAlternatives_1_01267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_0__0_in_rule__FnPrototypeNoDecors__Alternatives1301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__0_in_rule__FnPrototypeNoDecors__Alternatives1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Sign__Alternatives1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Sign__Alternatives1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__SimpType__Alternatives1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__SimpType__Alternatives1428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__SimpType__Alternatives1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__SimpType__Alternatives1468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__SimpType__Alternatives1488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__SimpType__Alternatives1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Signed__Alternatives1543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Signed__Alternatives1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Double__Alternatives1598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Group_1__0_in_rule__Double__Alternatives1617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__Group__0__Impl_in_rule__Program__Group__01651 = new BitSet(new long[]{0x000000008FF3F000L});
    public static final BitSet FOLLOW_rule__Program__Group__1_in_rule__Program__Group__01654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__Group__1__Impl_in_rule__Program__Group__11712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__ProgramElementsAssignment_1_in_rule__Program__Group__1__Impl1739 = new BitSet(new long[]{0x000000008FF3F002L});
    public static final BitSet FOLLOW_rule__DmplSubclause__Group__0__Impl_in_rule__DmplSubclause__Group__01774 = new BitSet(new long[]{0x000000008FF3F000L});
    public static final BitSet FOLLOW_rule__DmplSubclause__Group__1_in_rule__DmplSubclause__Group__01777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DmplSubclause__Group__1__Impl_in_rule__DmplSubclause__Group__11835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DmplSubclause__ProgramAssignment_1_in_rule__DmplSubclause__Group__1__Impl1862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__0__Impl_in_rule__Constant__Group__01896 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Constant__Group__1_in_rule__Constant__Group__01899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Alternatives_0_in_rule__Constant__Group__0__Impl1926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__1__Impl_in_rule__Constant__Group__11956 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Constant__Group__2_in_rule__Constant__Group__11959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__NameAssignment_1_in_rule__Constant__Group__1__Impl1986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__2__Impl_in_rule__Constant__Group__22016 = new BitSet(new long[]{0x00000000100C0010L});
    public static final BitSet FOLLOW_rule__Constant__Group__3_in_rule__Constant__Group__22019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Constant__Group__2__Impl2047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__3__Impl_in_rule__Constant__Group__32078 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__Constant__Group__4_in_rule__Constant__Group__32081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__ValueAssignment_3_in_rule__Constant__Group__3__Impl2108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__4__Impl_in_rule__Constant__Group__42138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Constant__Group__4__Impl2166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__Group__0__Impl_in_rule__IntConst__Group__02207 = new BitSet(new long[]{0x00000000000C0010L});
    public static final BitSet FOLLOW_rule__IntConst__Group__1_in_rule__IntConst__Group__02210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__SignAssignment_0_in_rule__IntConst__Group__0__Impl2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__Group__1__Impl_in_rule__IntConst__Group__12268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__ValueAssignment_1_in_rule__IntConst__Group__1__Impl2295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__Group__0__Impl_in_rule__DoubleConst__Group__02329 = new BitSet(new long[]{0x00000000100C0010L});
    public static final BitSet FOLLOW_rule__DoubleConst__Group__1_in_rule__DoubleConst__Group__02332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__SignAssignment_0_in_rule__DoubleConst__Group__0__Impl2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__Group__1__Impl_in_rule__DoubleConst__Group__12390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__ValueAssignment_1_in_rule__DoubleConst__Group__1__Impl2417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group__0__Impl_in_rule__Type__Group__02451 = new BitSet(new long[]{0x000000008FF3F000L});
    public static final BitSet FOLLOW_rule__Type__Group__1_in_rule__Type__Group__02454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__SignedAssignment_0_in_rule__Type__Group__0__Impl2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group__1__Impl_in_rule__Type__Group__12512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__SimpTypeAssignment_1_in_rule__Type__Group__1__Impl2539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Group__0__Impl_in_rule__ProcNoAttr__Group__02573 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Group__1_in_rule__ProcNoAttr__Group__02576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__PrototypeAssignment_0_in_rule__ProcNoAttr__Group__0__Impl2603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Group__1__Impl_in_rule__ProcNoAttr__Group__12633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ProcNoAttr__Group__1__Impl2661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group__0__Impl_in_rule__FnPrototype__Group__02696 = new BitSet(new long[]{0x000000008FF3F000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group__1_in_rule__FnPrototype__Group__02699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__ExternAssignment_0_in_rule__FnPrototype__Group__0__Impl2726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group__1__Impl_in_rule__FnPrototype__Group__12757 = new BitSet(new long[]{0x000000008FF3F000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group__2_in_rule__FnPrototype__Group__12760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__PureAssignment_1_in_rule__FnPrototype__Group__1__Impl2787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group__2__Impl_in_rule__FnPrototype__Group__22818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__PrototypeAssignment_2_in_rule__FnPrototype__Group__2__Impl2845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_0__0__Impl_in_rule__FnPrototypeNoDecors__Group_0__02881 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_0__1_in_rule__FnPrototypeNoDecors__Group_0__02884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_0__1__Impl_in_rule__FnPrototypeNoDecors__Group_0__12942 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_0__2_in_rule__FnPrototypeNoDecors__Group_0__12945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__FnPrototypeNoDecors__Group_0__1__Impl2973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_0__2__Impl_in_rule__FnPrototypeNoDecors__Group_0__23004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__NameAssignment_0_2_in_rule__FnPrototypeNoDecors__Group_0__2__Impl3031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__0__Impl_in_rule__FnPrototypeNoDecors__Group_1__03067 = new BitSet(new long[]{0x000000008FF3F000L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__1_in_rule__FnPrototypeNoDecors__Group_1__03070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__1__Impl_in_rule__FnPrototypeNoDecors__Group_1__13128 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__2_in_rule__FnPrototypeNoDecors__Group_1__13131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__TypeAssignment_1_1_in_rule__FnPrototypeNoDecors__Group_1__1__Impl3158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__2__Impl_in_rule__FnPrototypeNoDecors__Group_1__23188 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__3_in_rule__FnPrototypeNoDecors__Group_1__23191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__NameAssignment_1_2_in_rule__FnPrototypeNoDecors__Group_1__2__Impl3218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__3__Impl_in_rule__FnPrototypeNoDecors__Group_1__33248 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__4_in_rule__FnPrototypeNoDecors__Group_1__33251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__FnPrototypeNoDecors__Group_1__3__Impl3279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototypeNoDecors__Group_1__4__Impl_in_rule__FnPrototypeNoDecors__Group_1__43310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__FnPrototypeNoDecors__Group_1__4__Impl3338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Group_1__0__Impl_in_rule__Double__Group_1__03379 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Double__Group_1__1_in_rule__Double__Group_1__03382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Double__Group_1__0__Impl3409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Group_1__1__Impl_in_rule__Double__Group_1__13438 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Double__Group_1__2_in_rule__Double__Group_1__13441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Double__Group_1__1__Impl3469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Group_1__2__Impl_in_rule__Double__Group_1__23500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Double__Group_1__2__Impl3528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProgramElement_in_rule__Program__ProgramElementsAssignment_13570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProgram_in_rule__DmplSubclause__ProgramAssignment_13601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__Constant__NameAssignment_13632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberConst_in_rule__Constant__ValueAssignment_33663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSign_in_rule__IntConst__SignAssignment_03694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__IntConst__ValueAssignment_13725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSign_in_rule__DoubleConst__SignAssignment_03756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDouble_in_rule__DoubleConst__ValueAssignment_13787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSigned_in_rule__Type__SignedAssignment_03818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpType_in_rule__Type__SimpTypeAssignment_13849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcNoAttr_in_rule__Procedure__ProcedureAssignment3880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnPrototype_in_rule__ProcNoAttr__PrototypeAssignment_03911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__ExternAlternatives_0_0_in_rule__FnPrototype__ExternAssignment_03942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__PureAlternatives_1_0_in_rule__FnPrototype__PureAssignment_13975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnPrototypeNoDecors_in_rule__FnPrototype__PrototypeAssignment_24008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__FnPrototypeNoDecors__NameAssignment_0_24039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__FnPrototypeNoDecors__TypeAssignment_1_14070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__FnPrototypeNoDecors__NameAssignment_1_24101 = new BitSet(new long[]{0x0000000000000002L});

}