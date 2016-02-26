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
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalDmplParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_TIDENTIFIER", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'const'", "'CONST'", "';'", "'extern'", "'EXTERN'", "'pure'", "'PURE'", "'+'", "'-'", "'bool'", "'_Bool'", "'int'", "'double'", "'void'", "'char'", "'signed'", "'unsigned'", "'exists_other'", "'EXISTS_OTHER'", "'exists_higher'", "'EXISTS_HIGHER'", "'exists_lower'", "'EXISTS_LOWER'", "'NAN'", "'<<'", "'>>'", "'*'", "'/'", "'%'", "'!'", "'~'", "'='", "'['", "']'", "'#N'", "'{'", "'}'", "'thread'", "'('", "')'", "','", "'@'", "'id'", "'::'", "'.'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_TIDENTIFIER=5;
    public static final int RULE_ID=6;
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
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:61:1: entryRuleProgram : ruleProgram EOF ;
    public final void entryRuleProgram() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:62:1: ( ruleProgram EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:63:1: ruleProgram EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramRule()); 
            }
            pushFollow(FOLLOW_ruleProgram_in_entryRuleProgram67);
            ruleProgram();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProgram74); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:70:1: ruleProgram : ( ( rule__Program__Group__0 ) ) ;
    public final void ruleProgram() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:74:2: ( ( ( rule__Program__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:75:1: ( ( rule__Program__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:75:1: ( ( rule__Program__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:76:1: ( rule__Program__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:77:1: ( rule__Program__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:77:2: rule__Program__Group__0
            {
            pushFollow(FOLLOW_rule__Program__Group__0_in_ruleProgram100);
            rule__Program__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getGroup()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:91:1: entryRuleDmplSubclause : ruleDmplSubclause EOF ;
    public final void entryRuleDmplSubclause() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:92:1: ( ruleDmplSubclause EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:93:1: ruleDmplSubclause EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDmplSubclauseRule()); 
            }
            pushFollow(FOLLOW_ruleDmplSubclause_in_entryRuleDmplSubclause129);
            ruleDmplSubclause();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDmplSubclauseRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDmplSubclause136); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:100:1: ruleDmplSubclause : ( ( rule__DmplSubclause__Group__0 ) ) ;
    public final void ruleDmplSubclause() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:104:2: ( ( ( rule__DmplSubclause__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:105:1: ( ( rule__DmplSubclause__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:105:1: ( ( rule__DmplSubclause__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:106:1: ( rule__DmplSubclause__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDmplSubclauseAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:107:1: ( rule__DmplSubclause__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:107:2: rule__DmplSubclause__Group__0
            {
            pushFollow(FOLLOW_rule__DmplSubclause__Group__0_in_ruleDmplSubclause162);
            rule__DmplSubclause__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDmplSubclauseAccess().getGroup()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:119:1: entryRuleProgramElement : ruleProgramElement EOF ;
    public final void entryRuleProgramElement() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:120:1: ( ruleProgramElement EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:121:1: ruleProgramElement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramElementRule()); 
            }
            pushFollow(FOLLOW_ruleProgramElement_in_entryRuleProgramElement189);
            ruleProgramElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramElementRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProgramElement196); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:128:1: ruleProgramElement : ( ( rule__ProgramElement__Alternatives ) ) ;
    public final void ruleProgramElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:132:2: ( ( ( rule__ProgramElement__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:133:1: ( ( rule__ProgramElement__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:133:1: ( ( rule__ProgramElement__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:134:1: ( rule__ProgramElement__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramElementAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:135:1: ( rule__ProgramElement__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:135:2: rule__ProgramElement__Alternatives
            {
            pushFollow(FOLLOW_rule__ProgramElement__Alternatives_in_ruleProgramElement222);
            rule__ProgramElement__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramElementAccess().getAlternatives()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:147:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:148:1: ( ruleConstant EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:149:1: ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant249);
            ruleConstant();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant256); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:156:1: ruleConstant : ( ( rule__Constant__Group__0 ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:160:2: ( ( ( rule__Constant__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:161:1: ( ( rule__Constant__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:161:1: ( ( rule__Constant__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:162:1: ( rule__Constant__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:163:1: ( rule__Constant__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:163:2: rule__Constant__Group__0
            {
            pushFollow(FOLLOW_rule__Constant__Group__0_in_ruleConstant282);
            rule__Constant__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantAccess().getGroup()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:175:1: entryRuleNumberConst : ruleNumberConst EOF ;
    public final void entryRuleNumberConst() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:176:1: ( ruleNumberConst EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:177:1: ruleNumberConst EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberConstRule()); 
            }
            pushFollow(FOLLOW_ruleNumberConst_in_entryRuleNumberConst309);
            ruleNumberConst();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumberConstRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberConst316); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:184:1: ruleNumberConst : ( ( rule__NumberConst__Alternatives ) ) ;
    public final void ruleNumberConst() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:188:2: ( ( ( rule__NumberConst__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:189:1: ( ( rule__NumberConst__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:189:1: ( ( rule__NumberConst__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:190:1: ( rule__NumberConst__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNumberConstAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:191:1: ( rule__NumberConst__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:191:2: rule__NumberConst__Alternatives
            {
            pushFollow(FOLLOW_rule__NumberConst__Alternatives_in_ruleNumberConst342);
            rule__NumberConst__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNumberConstAccess().getAlternatives()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:203:1: entryRuleIntConst : ruleIntConst EOF ;
    public final void entryRuleIntConst() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:204:1: ( ruleIntConst EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:205:1: ruleIntConst EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntConstRule()); 
            }
            pushFollow(FOLLOW_ruleIntConst_in_entryRuleIntConst369);
            ruleIntConst();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntConstRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntConst376); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:212:1: ruleIntConst : ( ( rule__IntConst__Group__0 ) ) ;
    public final void ruleIntConst() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:216:2: ( ( ( rule__IntConst__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:217:1: ( ( rule__IntConst__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:217:1: ( ( rule__IntConst__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:218:1: ( rule__IntConst__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntConstAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:219:1: ( rule__IntConst__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:219:2: rule__IntConst__Group__0
            {
            pushFollow(FOLLOW_rule__IntConst__Group__0_in_ruleIntConst402);
            rule__IntConst__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntConstAccess().getGroup()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:231:1: entryRuleDoubleConst : ruleDoubleConst EOF ;
    public final void entryRuleDoubleConst() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:232:1: ( ruleDoubleConst EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:233:1: ruleDoubleConst EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleConstRule()); 
            }
            pushFollow(FOLLOW_ruleDoubleConst_in_entryRuleDoubleConst429);
            ruleDoubleConst();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleConstRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoubleConst436); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:240:1: ruleDoubleConst : ( ( rule__DoubleConst__Group__0 ) ) ;
    public final void ruleDoubleConst() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:244:2: ( ( ( rule__DoubleConst__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:245:1: ( ( rule__DoubleConst__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:245:1: ( ( rule__DoubleConst__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:246:1: ( rule__DoubleConst__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleConstAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:247:1: ( rule__DoubleConst__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:247:2: rule__DoubleConst__Group__0
            {
            pushFollow(FOLLOW_rule__DoubleConst__Group__0_in_ruleDoubleConst462);
            rule__DoubleConst__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleConstAccess().getGroup()); 
            }

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


    // $ANTLR start "entryRuleVarInit"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:259:1: entryRuleVarInit : ruleVarInit EOF ;
    public final void entryRuleVarInit() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:260:1: ( ruleVarInit EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:261:1: ruleVarInit EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitRule()); 
            }
            pushFollow(FOLLOW_ruleVarInit_in_entryRuleVarInit489);
            ruleVarInit();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarInitRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarInit496); if (state.failed) return ;

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
    // $ANTLR end "entryRuleVarInit"


    // $ANTLR start "ruleVarInit"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:268:1: ruleVarInit : ( ( rule__VarInit__Group__0 ) ) ;
    public final void ruleVarInit() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:272:2: ( ( ( rule__VarInit__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:273:1: ( ( rule__VarInit__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:273:1: ( ( rule__VarInit__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:274:1: ( rule__VarInit__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:275:1: ( rule__VarInit__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:275:2: rule__VarInit__Group__0
            {
            pushFollow(FOLLOW_rule__VarInit__Group__0_in_ruleVarInit522);
            rule__VarInit__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarInitAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleVarInit"


    // $ANTLR start "entryRuleVarAsgnList"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:287:1: entryRuleVarAsgnList : ruleVarAsgnList EOF ;
    public final void entryRuleVarAsgnList() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:288:1: ( ruleVarAsgnList EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:289:1: ruleVarAsgnList EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnListRule()); 
            }
            pushFollow(FOLLOW_ruleVarAsgnList_in_entryRuleVarAsgnList549);
            ruleVarAsgnList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAsgnListRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarAsgnList556); if (state.failed) return ;

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
    // $ANTLR end "entryRuleVarAsgnList"


    // $ANTLR start "ruleVarAsgnList"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:296:1: ruleVarAsgnList : ( ( rule__VarAsgnList__Alternatives ) ) ;
    public final void ruleVarAsgnList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:300:2: ( ( ( rule__VarAsgnList__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:301:1: ( ( rule__VarAsgnList__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:301:1: ( ( rule__VarAsgnList__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:302:1: ( rule__VarAsgnList__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnListAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:303:1: ( rule__VarAsgnList__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:303:2: rule__VarAsgnList__Alternatives
            {
            pushFollow(FOLLOW_rule__VarAsgnList__Alternatives_in_ruleVarAsgnList582);
            rule__VarAsgnList__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAsgnListAccess().getAlternatives()); 
            }

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
    // $ANTLR end "ruleVarAsgnList"


    // $ANTLR start "entryRuleVarAsgn"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:315:1: entryRuleVarAsgn : ruleVarAsgn EOF ;
    public final void entryRuleVarAsgn() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:316:1: ( ruleVarAsgn EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:317:1: ruleVarAsgn EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnRule()); 
            }
            pushFollow(FOLLOW_ruleVarAsgn_in_entryRuleVarAsgn609);
            ruleVarAsgn();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAsgnRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarAsgn616); if (state.failed) return ;

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
    // $ANTLR end "entryRuleVarAsgn"


    // $ANTLR start "ruleVarAsgn"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:324:1: ruleVarAsgn : ( ( rule__VarAsgn__Group__0 ) ) ;
    public final void ruleVarAsgn() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:328:2: ( ( ( rule__VarAsgn__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:329:1: ( ( rule__VarAsgn__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:329:1: ( ( rule__VarAsgn__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:330:1: ( rule__VarAsgn__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:331:1: ( rule__VarAsgn__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:331:2: rule__VarAsgn__Group__0
            {
            pushFollow(FOLLOW_rule__VarAsgn__Group__0_in_ruleVarAsgn642);
            rule__VarAsgn__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAsgnAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleVarAsgn"


    // $ANTLR start "entryRuleVar"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:343:1: entryRuleVar : ruleVar EOF ;
    public final void entryRuleVar() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:344:1: ( ruleVar EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:345:1: ruleVar EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarRule()); 
            }
            pushFollow(FOLLOW_ruleVar_in_entryRuleVar669);
            ruleVar();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVar676); if (state.failed) return ;

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
    // $ANTLR end "entryRuleVar"


    // $ANTLR start "ruleVar"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:352:1: ruleVar : ( ( rule__Var__Group__0 ) ) ;
    public final void ruleVar() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:356:2: ( ( ( rule__Var__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:357:1: ( ( rule__Var__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:357:1: ( ( rule__Var__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:358:1: ( rule__Var__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:359:1: ( rule__Var__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:359:2: rule__Var__Group__0
            {
            pushFollow(FOLLOW_rule__Var__Group__0_in_ruleVar702);
            rule__Var__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleVar"


    // $ANTLR start "entryRuleDimension"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:371:1: entryRuleDimension : ruleDimension EOF ;
    public final void entryRuleDimension() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:372:1: ( ruleDimension EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:373:1: ruleDimension EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionRule()); 
            }
            pushFollow(FOLLOW_ruleDimension_in_entryRuleDimension729);
            ruleDimension();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDimensionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDimension736); if (state.failed) return ;

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
    // $ANTLR end "entryRuleDimension"


    // $ANTLR start "ruleDimension"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:380:1: ruleDimension : ( ( rule__Dimension__Alternatives ) ) ;
    public final void ruleDimension() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:384:2: ( ( ( rule__Dimension__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:385:1: ( ( rule__Dimension__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:385:1: ( ( rule__Dimension__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:386:1: ( rule__Dimension__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:387:1: ( rule__Dimension__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:387:2: rule__Dimension__Alternatives
            {
            pushFollow(FOLLOW_rule__Dimension__Alternatives_in_ruleDimension762);
            rule__Dimension__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDimensionAccess().getAlternatives()); 
            }

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
    // $ANTLR end "ruleDimension"


    // $ANTLR start "entryRuleType"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:399:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:400:1: ( ruleType EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:401:1: ruleType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType789);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType796); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:408:1: ruleType : ( ( rule__Type__Group__0 ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:412:2: ( ( ( rule__Type__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:413:1: ( ( rule__Type__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:413:1: ( ( rule__Type__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:414:1: ( rule__Type__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:415:1: ( rule__Type__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:415:2: rule__Type__Group__0
            {
            pushFollow(FOLLOW_rule__Type__Group__0_in_ruleType822);
            rule__Type__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAccess().getGroup()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:427:1: entryRuleProcedure : ruleProcedure EOF ;
    public final void entryRuleProcedure() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:428:1: ( ruleProcedure EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:429:1: ruleProcedure EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProcedureRule()); 
            }
            pushFollow(FOLLOW_ruleProcedure_in_entryRuleProcedure849);
            ruleProcedure();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProcedureRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcedure856); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:436:1: ruleProcedure : ( ( rule__Procedure__ProcedureAssignment ) ) ;
    public final void ruleProcedure() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:440:2: ( ( ( rule__Procedure__ProcedureAssignment ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:441:1: ( ( rule__Procedure__ProcedureAssignment ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:441:1: ( ( rule__Procedure__ProcedureAssignment ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:442:1: ( rule__Procedure__ProcedureAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProcedureAccess().getProcedureAssignment()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:443:1: ( rule__Procedure__ProcedureAssignment )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:443:2: rule__Procedure__ProcedureAssignment
            {
            pushFollow(FOLLOW_rule__Procedure__ProcedureAssignment_in_ruleProcedure882);
            rule__Procedure__ProcedureAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProcedureAccess().getProcedureAssignment()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:455:1: entryRuleProcNoAttr : ruleProcNoAttr EOF ;
    public final void entryRuleProcNoAttr() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:456:1: ( ruleProcNoAttr EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:457:1: ruleProcNoAttr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProcNoAttrRule()); 
            }
            pushFollow(FOLLOW_ruleProcNoAttr_in_entryRuleProcNoAttr909);
            ruleProcNoAttr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProcNoAttrRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcNoAttr916); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:464:1: ruleProcNoAttr : ( ( rule__ProcNoAttr__Group__0 ) ) ;
    public final void ruleProcNoAttr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:468:2: ( ( ( rule__ProcNoAttr__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:469:1: ( ( rule__ProcNoAttr__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:469:1: ( ( rule__ProcNoAttr__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:470:1: ( rule__ProcNoAttr__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProcNoAttrAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:471:1: ( rule__ProcNoAttr__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:471:2: rule__ProcNoAttr__Group__0
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__Group__0_in_ruleProcNoAttr942);
            rule__ProcNoAttr__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProcNoAttrAccess().getGroup()); 
            }

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


    // $ANTLR start "entryRuleFnBody"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:483:1: entryRuleFnBody : ruleFnBody EOF ;
    public final void entryRuleFnBody() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:484:1: ( ruleFnBody EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:485:1: ruleFnBody EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnBodyRule()); 
            }
            pushFollow(FOLLOW_ruleFnBody_in_entryRuleFnBody969);
            ruleFnBody();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnBodyRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFnBody976); if (state.failed) return ;

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
    // $ANTLR end "entryRuleFnBody"


    // $ANTLR start "ruleFnBody"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:492:1: ruleFnBody : ( ( rule__FnBody__Group__0 ) ) ;
    public final void ruleFnBody() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:496:2: ( ( ( rule__FnBody__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:497:1: ( ( rule__FnBody__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:497:1: ( ( rule__FnBody__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:498:1: ( rule__FnBody__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnBodyAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:499:1: ( rule__FnBody__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:499:2: rule__FnBody__Group__0
            {
            pushFollow(FOLLOW_rule__FnBody__Group__0_in_ruleFnBody1002);
            rule__FnBody__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnBodyAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleFnBody"


    // $ANTLR start "entryRuleFnPrototype"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:511:1: entryRuleFnPrototype : ruleFnPrototype EOF ;
    public final void entryRuleFnPrototype() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:512:1: ( ruleFnPrototype EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:513:1: ruleFnPrototype EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeRule()); 
            }
            pushFollow(FOLLOW_ruleFnPrototype_in_entryRuleFnPrototype1029);
            ruleFnPrototype();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFnPrototype1036); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:520:1: ruleFnPrototype : ( ( rule__FnPrototype__Alternatives ) ) ;
    public final void ruleFnPrototype() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:524:2: ( ( ( rule__FnPrototype__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:525:1: ( ( rule__FnPrototype__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:525:1: ( ( rule__FnPrototype__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:526:1: ( rule__FnPrototype__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:527:1: ( rule__FnPrototype__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:527:2: rule__FnPrototype__Alternatives
            {
            pushFollow(FOLLOW_rule__FnPrototype__Alternatives_in_ruleFnPrototype1062);
            rule__FnPrototype__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getAlternatives()); 
            }

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


    // $ANTLR start "entryRuleParam"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:539:1: entryRuleParam : ruleParam EOF ;
    public final void entryRuleParam() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:540:1: ( ruleParam EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:541:1: ruleParam EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamRule()); 
            }
            pushFollow(FOLLOW_ruleParam_in_entryRuleParam1089);
            ruleParam();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParam1096); if (state.failed) return ;

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
    // $ANTLR end "entryRuleParam"


    // $ANTLR start "ruleParam"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:548:1: ruleParam : ( ( rule__Param__Group__0 ) ) ;
    public final void ruleParam() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:552:2: ( ( ( rule__Param__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:553:1: ( ( rule__Param__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:553:1: ( ( rule__Param__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:554:1: ( rule__Param__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:555:1: ( rule__Param__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:555:2: rule__Param__Group__0
            {
            pushFollow(FOLLOW_rule__Param__Group__0_in_ruleParam1122);
            rule__Param__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleParam"


    // $ANTLR start "entryRuleVarInitList"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:567:1: entryRuleVarInitList : ruleVarInitList EOF ;
    public final void entryRuleVarInitList() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:568:1: ( ruleVarInitList EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:569:1: ruleVarInitList EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitListRule()); 
            }
            pushFollow(FOLLOW_ruleVarInitList_in_entryRuleVarInitList1149);
            ruleVarInitList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarInitListRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarInitList1156); if (state.failed) return ;

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
    // $ANTLR end "entryRuleVarInitList"


    // $ANTLR start "ruleVarInitList"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:576:1: ruleVarInitList : ( ( rule__VarInitList__Group__0 ) ) ;
    public final void ruleVarInitList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:580:2: ( ( ( rule__VarInitList__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:581:1: ( ( rule__VarInitList__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:581:1: ( ( rule__VarInitList__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:582:1: ( rule__VarInitList__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitListAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:583:1: ( rule__VarInitList__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:583:2: rule__VarInitList__Group__0
            {
            pushFollow(FOLLOW_rule__VarInitList__Group__0_in_ruleVarInitList1182);
            rule__VarInitList__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarInitListAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleVarInitList"


    // $ANTLR start "entryRuleLVal"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:595:1: entryRuleLVal : ruleLVal EOF ;
    public final void entryRuleLVal() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:596:1: ( ruleLVal EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:597:1: ruleLVal EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValRule()); 
            }
            pushFollow(FOLLOW_ruleLVal_in_entryRuleLVal1209);
            ruleLVal();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLValRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLVal1216); if (state.failed) return ;

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
    // $ANTLR end "entryRuleLVal"


    // $ANTLR start "ruleLVal"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:604:1: ruleLVal : ( ( rule__LVal__Group__0 ) ) ;
    public final void ruleLVal() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:608:2: ( ( ( rule__LVal__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:609:1: ( ( rule__LVal__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:609:1: ( ( rule__LVal__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:610:1: ( rule__LVal__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:611:1: ( rule__LVal__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:611:2: rule__LVal__Group__0
            {
            pushFollow(FOLLOW_rule__LVal__Group__0_in_ruleLVal1242);
            rule__LVal__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLValAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleLVal"


    // $ANTLR start "entryRuleExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:623:1: entryRuleExpr : ruleExpr EOF ;
    public final void entryRuleExpr() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:624:1: ( ruleExpr EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:625:1: ruleExpr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprRule()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_entryRuleExpr1269);
            ruleExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpr1276); if (state.failed) return ;

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
    // $ANTLR end "entryRuleExpr"


    // $ANTLR start "ruleExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:632:1: ruleExpr : ( ruleShiftExpr ) ;
    public final void ruleExpr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:636:2: ( ( ruleShiftExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:637:1: ( ruleShiftExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:637:1: ( ruleShiftExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:638:1: ruleShiftExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprAccess().getShiftExprParserRuleCall()); 
            }
            pushFollow(FOLLOW_ruleShiftExpr_in_ruleExpr1302);
            ruleShiftExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprAccess().getShiftExprParserRuleCall()); 
            }

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
    // $ANTLR end "ruleExpr"


    // $ANTLR start "entryRuleShiftExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:651:1: entryRuleShiftExpr : ruleShiftExpr EOF ;
    public final void entryRuleShiftExpr() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:652:1: ( ruleShiftExpr EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:653:1: ruleShiftExpr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprRule()); 
            }
            pushFollow(FOLLOW_ruleShiftExpr_in_entryRuleShiftExpr1328);
            ruleShiftExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExprRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleShiftExpr1335); if (state.failed) return ;

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
    // $ANTLR end "entryRuleShiftExpr"


    // $ANTLR start "ruleShiftExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:660:1: ruleShiftExpr : ( ( rule__ShiftExpr__Group__0 ) ) ;
    public final void ruleShiftExpr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:664:2: ( ( ( rule__ShiftExpr__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:665:1: ( ( rule__ShiftExpr__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:665:1: ( ( rule__ShiftExpr__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:666:1: ( rule__ShiftExpr__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:667:1: ( rule__ShiftExpr__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:667:2: rule__ShiftExpr__Group__0
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group__0_in_ruleShiftExpr1361);
            rule__ShiftExpr__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExprAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleShiftExpr"


    // $ANTLR start "entryRuleAdditiveExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:679:1: entryRuleAdditiveExpr : ruleAdditiveExpr EOF ;
    public final void entryRuleAdditiveExpr() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:680:1: ( ruleAdditiveExpr EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:681:1: ruleAdditiveExpr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpr_in_entryRuleAdditiveExpr1388);
            ruleAdditiveExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExprRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpr1395); if (state.failed) return ;

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
    // $ANTLR end "entryRuleAdditiveExpr"


    // $ANTLR start "ruleAdditiveExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:688:1: ruleAdditiveExpr : ( ( rule__AdditiveExpr__Group__0 ) ) ;
    public final void ruleAdditiveExpr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:692:2: ( ( ( rule__AdditiveExpr__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:693:1: ( ( rule__AdditiveExpr__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:693:1: ( ( rule__AdditiveExpr__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:694:1: ( rule__AdditiveExpr__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:695:1: ( rule__AdditiveExpr__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:695:2: rule__AdditiveExpr__Group__0
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group__0_in_ruleAdditiveExpr1421);
            rule__AdditiveExpr__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExprAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleAdditiveExpr"


    // $ANTLR start "entryRuleMultiplicativeExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:707:1: entryRuleMultiplicativeExpr : ruleMultiplicativeExpr EOF ;
    public final void entryRuleMultiplicativeExpr() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:708:1: ( ruleMultiplicativeExpr EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:709:1: ruleMultiplicativeExpr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpr_in_entryRuleMultiplicativeExpr1448);
            ruleMultiplicativeExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExprRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpr1455); if (state.failed) return ;

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
    // $ANTLR end "entryRuleMultiplicativeExpr"


    // $ANTLR start "ruleMultiplicativeExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:716:1: ruleMultiplicativeExpr : ( ( rule__MultiplicativeExpr__Group__0 ) ) ;
    public final void ruleMultiplicativeExpr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:720:2: ( ( ( rule__MultiplicativeExpr__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:721:1: ( ( rule__MultiplicativeExpr__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:721:1: ( ( rule__MultiplicativeExpr__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:722:1: ( rule__MultiplicativeExpr__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:723:1: ( rule__MultiplicativeExpr__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:723:2: rule__MultiplicativeExpr__Group__0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group__0_in_ruleMultiplicativeExpr1481);
            rule__MultiplicativeExpr__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExprAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleMultiplicativeExpr"


    // $ANTLR start "entryRuleTerminalExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:735:1: entryRuleTerminalExpr : ruleTerminalExpr EOF ;
    public final void entryRuleTerminalExpr() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:736:1: ( ruleTerminalExpr EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:737:1: ruleTerminalExpr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprRule()); 
            }
            pushFollow(FOLLOW_ruleTerminalExpr_in_entryRuleTerminalExpr1508);
            ruleTerminalExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalExpr1515); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTerminalExpr"


    // $ANTLR start "ruleTerminalExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:744:1: ruleTerminalExpr : ( ( rule__TerminalExpr__Alternatives ) ) ;
    public final void ruleTerminalExpr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:748:2: ( ( ( rule__TerminalExpr__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:749:1: ( ( rule__TerminalExpr__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:749:1: ( ( rule__TerminalExpr__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:750:1: ( rule__TerminalExpr__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:751:1: ( rule__TerminalExpr__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:751:2: rule__TerminalExpr__Alternatives
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Alternatives_in_ruleTerminalExpr1541);
            rule__TerminalExpr__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getAlternatives()); 
            }

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
    // $ANTLR end "ruleTerminalExpr"


    // $ANTLR start "entryRuleCallExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:763:1: entryRuleCallExpr : ruleCallExpr EOF ;
    public final void entryRuleCallExpr() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:764:1: ( ruleCallExpr EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:765:1: ruleCallExpr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprRule()); 
            }
            pushFollow(FOLLOW_ruleCallExpr_in_entryRuleCallExpr1568);
            ruleCallExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallExpr1575); if (state.failed) return ;

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
    // $ANTLR end "entryRuleCallExpr"


    // $ANTLR start "ruleCallExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:772:1: ruleCallExpr : ( ( rule__CallExpr__Group__0 ) ) ;
    public final void ruleCallExpr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:776:2: ( ( ( rule__CallExpr__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:777:1: ( ( rule__CallExpr__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:777:1: ( ( rule__CallExpr__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:778:1: ( rule__CallExpr__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:779:1: ( rule__CallExpr__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:779:2: rule__CallExpr__Group__0
            {
            pushFollow(FOLLOW_rule__CallExpr__Group__0_in_ruleCallExpr1601);
            rule__CallExpr__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleCallExpr"


    // $ANTLR start "entryRuleArgList"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:791:1: entryRuleArgList : ruleArgList EOF ;
    public final void entryRuleArgList() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:792:1: ( ruleArgList EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:793:1: ruleArgList EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListRule()); 
            }
            pushFollow(FOLLOW_ruleArgList_in_entryRuleArgList1628);
            ruleArgList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArgListRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgList1635); if (state.failed) return ;

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
    // $ANTLR end "entryRuleArgList"


    // $ANTLR start "ruleArgList"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:800:1: ruleArgList : ( ( rule__ArgList__Group__0 ) ) ;
    public final void ruleArgList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:804:2: ( ( ( rule__ArgList__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:805:1: ( ( rule__ArgList__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:805:1: ( ( rule__ArgList__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:806:1: ( rule__ArgList__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:807:1: ( rule__ArgList__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:807:2: rule__ArgList__Group__0
            {
            pushFollow(FOLLOW_rule__ArgList__Group__0_in_ruleArgList1661);
            rule__ArgList__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArgListAccess().getGroup()); 
            }

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
    // $ANTLR end "ruleArgList"


    // $ANTLR start "entryRuleSign"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:819:1: entryRuleSign : ruleSign EOF ;
    public final void entryRuleSign() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:820:1: ( ruleSign EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:821:1: ruleSign EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSignRule()); 
            }
            pushFollow(FOLLOW_ruleSign_in_entryRuleSign1688);
            ruleSign();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSignRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSign1695); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:828:1: ruleSign : ( ( rule__Sign__Alternatives ) ) ;
    public final void ruleSign() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:832:2: ( ( ( rule__Sign__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:833:1: ( ( rule__Sign__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:833:1: ( ( rule__Sign__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:834:1: ( rule__Sign__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSignAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:835:1: ( rule__Sign__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:835:2: rule__Sign__Alternatives
            {
            pushFollow(FOLLOW_rule__Sign__Alternatives_in_ruleSign1721);
            rule__Sign__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSignAccess().getAlternatives()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:847:1: entryRuleSimpType : ruleSimpType EOF ;
    public final void entryRuleSimpType() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:848:1: ( ruleSimpType EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:849:1: ruleSimpType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpTypeRule()); 
            }
            pushFollow(FOLLOW_ruleSimpType_in_entryRuleSimpType1748);
            ruleSimpType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpType1755); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:856:1: ruleSimpType : ( ( rule__SimpType__Alternatives ) ) ;
    public final void ruleSimpType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:860:2: ( ( ( rule__SimpType__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:861:1: ( ( rule__SimpType__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:861:1: ( ( rule__SimpType__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:862:1: ( rule__SimpType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpTypeAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:863:1: ( rule__SimpType__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:863:2: rule__SimpType__Alternatives
            {
            pushFollow(FOLLOW_rule__SimpType__Alternatives_in_ruleSimpType1781);
            rule__SimpType__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpTypeAccess().getAlternatives()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:875:1: entryRuleSigned : ruleSigned EOF ;
    public final void entryRuleSigned() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:876:1: ( ruleSigned EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:877:1: ruleSigned EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSignedRule()); 
            }
            pushFollow(FOLLOW_ruleSigned_in_entryRuleSigned1808);
            ruleSigned();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSignedRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSigned1815); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:884:1: ruleSigned : ( ( rule__Signed__Alternatives ) ) ;
    public final void ruleSigned() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:888:2: ( ( ( rule__Signed__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:889:1: ( ( rule__Signed__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:889:1: ( ( rule__Signed__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:890:1: ( rule__Signed__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSignedAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:891:1: ( rule__Signed__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:891:2: rule__Signed__Alternatives
            {
            pushFollow(FOLLOW_rule__Signed__Alternatives_in_ruleSigned1841);
            rule__Signed__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSignedAccess().getAlternatives()); 
            }

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


    // $ANTLR start "entryRuleBuiltInFunction"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:903:1: entryRuleBuiltInFunction : ruleBuiltInFunction EOF ;
    public final void entryRuleBuiltInFunction() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:904:1: ( ruleBuiltInFunction EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:905:1: ruleBuiltInFunction EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBuiltInFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleBuiltInFunction_in_entryRuleBuiltInFunction1868);
            ruleBuiltInFunction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBuiltInFunctionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBuiltInFunction1875); if (state.failed) return ;

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
    // $ANTLR end "entryRuleBuiltInFunction"


    // $ANTLR start "ruleBuiltInFunction"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:912:1: ruleBuiltInFunction : ( ( rule__BuiltInFunction__Alternatives ) ) ;
    public final void ruleBuiltInFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:916:2: ( ( ( rule__BuiltInFunction__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:917:1: ( ( rule__BuiltInFunction__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:917:1: ( ( rule__BuiltInFunction__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:918:1: ( rule__BuiltInFunction__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBuiltInFunctionAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:919:1: ( rule__BuiltInFunction__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:919:2: rule__BuiltInFunction__Alternatives
            {
            pushFollow(FOLLOW_rule__BuiltInFunction__Alternatives_in_ruleBuiltInFunction1901);
            rule__BuiltInFunction__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBuiltInFunctionAccess().getAlternatives()); 
            }

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
    // $ANTLR end "ruleBuiltInFunction"


    // $ANTLR start "entryRuleDouble"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:931:1: entryRuleDouble : ruleDouble EOF ;
    public final void entryRuleDouble() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:932:1: ( ruleDouble EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:933:1: ruleDouble EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleRule()); 
            }
            pushFollow(FOLLOW_ruleDouble_in_entryRuleDouble1928);
            ruleDouble();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDouble1935); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:940:1: ruleDouble : ( ( rule__Double__Alternatives ) ) ;
    public final void ruleDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:944:2: ( ( ( rule__Double__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:945:1: ( ( rule__Double__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:945:1: ( ( rule__Double__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:946:1: ( rule__Double__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:947:1: ( rule__Double__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:947:2: rule__Double__Alternatives
            {
            pushFollow(FOLLOW_rule__Double__Alternatives_in_ruleDouble1961);
            rule__Double__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleAccess().getAlternatives()); 
            }

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


    // $ANTLR start "ruleShiftOperator"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:966:1: ruleShiftOperator : ( ( rule__ShiftOperator__Alternatives ) ) ;
    public final void ruleShiftOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:970:1: ( ( ( rule__ShiftOperator__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:971:1: ( ( rule__ShiftOperator__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:971:1: ( ( rule__ShiftOperator__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:972:1: ( rule__ShiftOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftOperatorAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:973:1: ( rule__ShiftOperator__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:973:2: rule__ShiftOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__ShiftOperator__Alternatives_in_ruleShiftOperator2004);
            rule__ShiftOperator__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftOperatorAccess().getAlternatives()); 
            }

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
    // $ANTLR end "ruleShiftOperator"


    // $ANTLR start "ruleAdditiveOperator"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:985:1: ruleAdditiveOperator : ( ( rule__AdditiveOperator__Alternatives ) ) ;
    public final void ruleAdditiveOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:989:1: ( ( ( rule__AdditiveOperator__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:990:1: ( ( rule__AdditiveOperator__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:990:1: ( ( rule__AdditiveOperator__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:991:1: ( rule__AdditiveOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveOperatorAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:992:1: ( rule__AdditiveOperator__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:992:2: rule__AdditiveOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__AdditiveOperator__Alternatives_in_ruleAdditiveOperator2040);
            rule__AdditiveOperator__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveOperatorAccess().getAlternatives()); 
            }

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
    // $ANTLR end "ruleAdditiveOperator"


    // $ANTLR start "ruleMultiplicativeOperator"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1004:1: ruleMultiplicativeOperator : ( ( rule__MultiplicativeOperator__Alternatives ) ) ;
    public final void ruleMultiplicativeOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1008:1: ( ( ( rule__MultiplicativeOperator__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1009:1: ( ( rule__MultiplicativeOperator__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1009:1: ( ( rule__MultiplicativeOperator__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1010:1: ( rule__MultiplicativeOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeOperatorAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1011:1: ( rule__MultiplicativeOperator__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1011:2: rule__MultiplicativeOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__MultiplicativeOperator__Alternatives_in_ruleMultiplicativeOperator2076);
            rule__MultiplicativeOperator__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeOperatorAccess().getAlternatives()); 
            }

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
    // $ANTLR end "ruleMultiplicativeOperator"


    // $ANTLR start "ruleUnaryOperator"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1023:1: ruleUnaryOperator : ( ( rule__UnaryOperator__Alternatives ) ) ;
    public final void ruleUnaryOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1027:1: ( ( ( rule__UnaryOperator__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1028:1: ( ( rule__UnaryOperator__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1028:1: ( ( rule__UnaryOperator__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1029:1: ( rule__UnaryOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryOperatorAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1030:1: ( rule__UnaryOperator__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1030:2: rule__UnaryOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__UnaryOperator__Alternatives_in_ruleUnaryOperator2112);
            rule__UnaryOperator__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnaryOperatorAccess().getAlternatives()); 
            }

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
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "rule__ProgramElement__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1043:1: rule__ProgramElement__Alternatives : ( ( ruleConstant ) | ( ruleProcedure ) );
    public final void rule__ProgramElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1047:1: ( ( ruleConstant ) | ( ruleProcedure ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=12 && LA1_0<=13)) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=15 && LA1_0<=18)||(LA1_0>=21 && LA1_0<=28)||LA1_0==49) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1048:1: ( ruleConstant )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1048:1: ( ruleConstant )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1049:1: ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProgramElementAccess().getConstantParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleConstant_in_rule__ProgramElement__Alternatives2149);
                    ruleConstant();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getProgramElementAccess().getConstantParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1054:6: ( ruleProcedure )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1054:6: ( ruleProcedure )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1055:1: ruleProcedure
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProgramElementAccess().getProcedureParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleProcedure_in_rule__ProgramElement__Alternatives2166);
                    ruleProcedure();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getProgramElementAccess().getProcedureParserRuleCall_1()); 
                    }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1065:1: rule__Constant__Alternatives_0 : ( ( 'const' ) | ( 'CONST' ) );
    public final void rule__Constant__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1069:1: ( ( 'const' ) | ( 'CONST' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1070:1: ( 'const' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1070:1: ( 'const' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1071:1: 'const'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConstantAccess().getConstKeyword_0_0()); 
                    }
                    match(input,12,FOLLOW_12_in_rule__Constant__Alternatives_02199); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConstantAccess().getConstKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1078:6: ( 'CONST' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1078:6: ( 'CONST' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1079:1: 'CONST'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConstantAccess().getCONSTKeyword_0_1()); 
                    }
                    match(input,13,FOLLOW_13_in_rule__Constant__Alternatives_02219); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConstantAccess().getCONSTKeyword_0_1()); 
                    }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1091:1: rule__NumberConst__Alternatives : ( ( ruleIntConst ) | ( ruleDoubleConst ) );
    public final void rule__NumberConst__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1095:1: ( ( ruleIntConst ) | ( ruleDoubleConst ) )
            int alt3=2;
            switch ( input.LA(1) ) {
            case 19:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==RULE_INT) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==EOF||LA3_3==14) ) {
                        alt3=1;
                    }
                    else if ( (LA3_3==56) ) {
                        alt3=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA3_1==35) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==35) ) {
                    alt3=2;
                }
                else if ( (LA3_2==RULE_INT) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==EOF||LA3_3==14) ) {
                        alt3=1;
                    }
                    else if ( (LA3_3==56) ) {
                        alt3=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA3_3 = input.LA(2);

                if ( (LA3_3==EOF||LA3_3==14) ) {
                    alt3=1;
                }
                else if ( (LA3_3==56) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 3, input);

                    throw nvae;
                }
                }
                break;
            case 35:
                {
                alt3=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1096:1: ( ruleIntConst )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1096:1: ( ruleIntConst )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1097:1: ruleIntConst
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberConstAccess().getIntConstParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleIntConst_in_rule__NumberConst__Alternatives2253);
                    ruleIntConst();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumberConstAccess().getIntConstParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1102:6: ( ruleDoubleConst )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1102:6: ( ruleDoubleConst )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1103:1: ruleDoubleConst
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberConstAccess().getDoubleConstParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleDoubleConst_in_rule__NumberConst__Alternatives2270);
                    ruleDoubleConst();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNumberConstAccess().getDoubleConstParserRuleCall_1()); 
                    }

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


    // $ANTLR start "rule__VarAsgnList__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1113:1: rule__VarAsgnList__Alternatives : ( ( ( rule__VarAsgnList__VarAssignment_0 ) ) | ( ( rule__VarAsgnList__VarAsgnAssignment_1 ) ) );
    public final void rule__VarAsgnList__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1117:1: ( ( ( rule__VarAsgnList__VarAssignment_0 ) ) | ( ( rule__VarAsgnList__VarAsgnAssignment_1 ) ) )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1118:1: ( ( rule__VarAsgnList__VarAssignment_0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1118:1: ( ( rule__VarAsgnList__VarAssignment_0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1119:1: ( rule__VarAsgnList__VarAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVarAsgnListAccess().getVarAssignment_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1120:1: ( rule__VarAsgnList__VarAssignment_0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1120:2: rule__VarAsgnList__VarAssignment_0
                    {
                    pushFollow(FOLLOW_rule__VarAsgnList__VarAssignment_0_in_rule__VarAsgnList__Alternatives2302);
                    rule__VarAsgnList__VarAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVarAsgnListAccess().getVarAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1124:6: ( ( rule__VarAsgnList__VarAsgnAssignment_1 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1124:6: ( ( rule__VarAsgnList__VarAsgnAssignment_1 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1125:1: ( rule__VarAsgnList__VarAsgnAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVarAsgnListAccess().getVarAsgnAssignment_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1126:1: ( rule__VarAsgnList__VarAsgnAssignment_1 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1126:2: rule__VarAsgnList__VarAsgnAssignment_1
                    {
                    pushFollow(FOLLOW_rule__VarAsgnList__VarAsgnAssignment_1_in_rule__VarAsgnList__Alternatives2320);
                    rule__VarAsgnList__VarAsgnAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVarAsgnListAccess().getVarAsgnAssignment_1()); 
                    }

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
    // $ANTLR end "rule__VarAsgnList__Alternatives"


    // $ANTLR start "rule__VarAsgn__Alternatives_2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1135:1: rule__VarAsgn__Alternatives_2 : ( ( ( rule__VarAsgn__FnBodyAssignment_2_0 ) ) | ( ( rule__VarAsgn__ExprAssignment_2_1 ) ) );
    public final void rule__VarAsgn__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1139:1: ( ( ( rule__VarAsgn__FnBodyAssignment_2_0 ) ) | ( ( rule__VarAsgn__ExprAssignment_2_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==47) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=RULE_INT && LA5_0<=RULE_TIDENTIFIER)||(LA5_0>=19 && LA5_0<=20)||(LA5_0>=29 && LA5_0<=35)||(LA5_0>=41 && LA5_0<=42)||LA5_0==46||LA5_0==50||LA5_0==54) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1140:1: ( ( rule__VarAsgn__FnBodyAssignment_2_0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1140:1: ( ( rule__VarAsgn__FnBodyAssignment_2_0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1141:1: ( rule__VarAsgn__FnBodyAssignment_2_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVarAsgnAccess().getFnBodyAssignment_2_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1142:1: ( rule__VarAsgn__FnBodyAssignment_2_0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1142:2: rule__VarAsgn__FnBodyAssignment_2_0
                    {
                    pushFollow(FOLLOW_rule__VarAsgn__FnBodyAssignment_2_0_in_rule__VarAsgn__Alternatives_22353);
                    rule__VarAsgn__FnBodyAssignment_2_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVarAsgnAccess().getFnBodyAssignment_2_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1146:6: ( ( rule__VarAsgn__ExprAssignment_2_1 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1146:6: ( ( rule__VarAsgn__ExprAssignment_2_1 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1147:1: ( rule__VarAsgn__ExprAssignment_2_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVarAsgnAccess().getExprAssignment_2_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1148:1: ( rule__VarAsgn__ExprAssignment_2_1 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1148:2: rule__VarAsgn__ExprAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__VarAsgn__ExprAssignment_2_1_in_rule__VarAsgn__Alternatives_22371);
                    rule__VarAsgn__ExprAssignment_2_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVarAsgnAccess().getExprAssignment_2_1()); 
                    }

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
    // $ANTLR end "rule__VarAsgn__Alternatives_2"


    // $ANTLR start "rule__Dimension__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1157:1: rule__Dimension__Alternatives : ( ( ( rule__Dimension__Group_0__0 ) ) | ( ( rule__Dimension__Group_1__0 ) ) | ( ( rule__Dimension__Group_2__0 ) ) );
    public final void rule__Dimension__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1161:1: ( ( ( rule__Dimension__Group_0__0 ) ) | ( ( rule__Dimension__Group_1__0 ) ) | ( ( rule__Dimension__Group_2__0 ) ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt6=1;
                }
                break;
            case 46:
                {
                alt6=2;
                }
                break;
            case RULE_TIDENTIFIER:
                {
                alt6=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1162:1: ( ( rule__Dimension__Group_0__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1162:1: ( ( rule__Dimension__Group_0__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1163:1: ( rule__Dimension__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDimensionAccess().getGroup_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1164:1: ( rule__Dimension__Group_0__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1164:2: rule__Dimension__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Dimension__Group_0__0_in_rule__Dimension__Alternatives2404);
                    rule__Dimension__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDimensionAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1168:6: ( ( rule__Dimension__Group_1__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1168:6: ( ( rule__Dimension__Group_1__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1169:1: ( rule__Dimension__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDimensionAccess().getGroup_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1170:1: ( rule__Dimension__Group_1__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1170:2: rule__Dimension__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Dimension__Group_1__0_in_rule__Dimension__Alternatives2422);
                    rule__Dimension__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDimensionAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1174:6: ( ( rule__Dimension__Group_2__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1174:6: ( ( rule__Dimension__Group_2__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1175:1: ( rule__Dimension__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDimensionAccess().getGroup_2()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1176:1: ( rule__Dimension__Group_2__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1176:2: rule__Dimension__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Dimension__Group_2__0_in_rule__Dimension__Alternatives2440);
                    rule__Dimension__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDimensionAccess().getGroup_2()); 
                    }

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
    // $ANTLR end "rule__Dimension__Alternatives"


    // $ANTLR start "rule__ProcNoAttr__Alternatives_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1185:1: rule__ProcNoAttr__Alternatives_1 : ( ( ';' ) | ( ( rule__ProcNoAttr__FnBodyAssignment_1_1 ) ) );
    public final void rule__ProcNoAttr__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1189:1: ( ( ';' ) | ( ( rule__ProcNoAttr__FnBodyAssignment_1_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            else if ( (LA7_0==47) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1190:1: ( ';' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1190:1: ( ';' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1191:1: ';'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProcNoAttrAccess().getSemicolonKeyword_1_0()); 
                    }
                    match(input,14,FOLLOW_14_in_rule__ProcNoAttr__Alternatives_12474); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getProcNoAttrAccess().getSemicolonKeyword_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1198:6: ( ( rule__ProcNoAttr__FnBodyAssignment_1_1 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1198:6: ( ( rule__ProcNoAttr__FnBodyAssignment_1_1 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1199:1: ( rule__ProcNoAttr__FnBodyAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProcNoAttrAccess().getFnBodyAssignment_1_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1200:1: ( rule__ProcNoAttr__FnBodyAssignment_1_1 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1200:2: rule__ProcNoAttr__FnBodyAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__ProcNoAttr__FnBodyAssignment_1_1_in_rule__ProcNoAttr__Alternatives_12493);
                    rule__ProcNoAttr__FnBodyAssignment_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getProcNoAttrAccess().getFnBodyAssignment_1_1()); 
                    }

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
    // $ANTLR end "rule__ProcNoAttr__Alternatives_1"


    // $ANTLR start "rule__FnPrototype__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1209:1: rule__FnPrototype__Alternatives : ( ( ( rule__FnPrototype__Group_0__0 ) ) | ( ( rule__FnPrototype__Group_1__0 ) ) );
    public final void rule__FnPrototype__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1213:1: ( ( ( rule__FnPrototype__Group_0__0 ) ) | ( ( rule__FnPrototype__Group_1__0 ) ) )
            int alt8=2;
            switch ( input.LA(1) ) {
            case 15:
                {
                switch ( input.LA(2) ) {
                case 17:
                    {
                    int LA8_3 = input.LA(3);

                    if ( (LA8_3==49) ) {
                        alt8=1;
                    }
                    else if ( ((LA8_3>=21 && LA8_3<=28)) ) {
                        alt8=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 18:
                    {
                    int LA8_4 = input.LA(3);

                    if ( ((LA8_4>=21 && LA8_4<=28)) ) {
                        alt8=2;
                    }
                    else if ( (LA8_4==49) ) {
                        alt8=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                    {
                    alt8=2;
                    }
                    break;
                case 49:
                    {
                    alt8=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }

                }
                break;
            case 16:
                {
                switch ( input.LA(2) ) {
                case 17:
                    {
                    int LA8_3 = input.LA(3);

                    if ( (LA8_3==49) ) {
                        alt8=1;
                    }
                    else if ( ((LA8_3>=21 && LA8_3<=28)) ) {
                        alt8=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 18:
                    {
                    int LA8_4 = input.LA(3);

                    if ( ((LA8_4>=21 && LA8_4<=28)) ) {
                        alt8=2;
                    }
                    else if ( (LA8_4==49) ) {
                        alt8=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                    {
                    alt8=2;
                    }
                    break;
                case 49:
                    {
                    alt8=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 2, input);

                    throw nvae;
                }

                }
                break;
            case 17:
                {
                int LA8_3 = input.LA(2);

                if ( (LA8_3==49) ) {
                    alt8=1;
                }
                else if ( ((LA8_3>=21 && LA8_3<=28)) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 3, input);

                    throw nvae;
                }
                }
                break;
            case 18:
                {
                int LA8_4 = input.LA(2);

                if ( ((LA8_4>=21 && LA8_4<=28)) ) {
                    alt8=2;
                }
                else if ( (LA8_4==49) ) {
                    alt8=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 4, input);

                    throw nvae;
                }
                }
                break;
            case 49:
                {
                alt8=1;
                }
                break;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
                {
                alt8=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1214:1: ( ( rule__FnPrototype__Group_0__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1214:1: ( ( rule__FnPrototype__Group_0__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1215:1: ( rule__FnPrototype__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getGroup_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1216:1: ( rule__FnPrototype__Group_0__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1216:2: rule__FnPrototype__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__Group_0__0_in_rule__FnPrototype__Alternatives2526);
                    rule__FnPrototype__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFnPrototypeAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1220:6: ( ( rule__FnPrototype__Group_1__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1220:6: ( ( rule__FnPrototype__Group_1__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1221:1: ( rule__FnPrototype__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getGroup_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1222:1: ( rule__FnPrototype__Group_1__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1222:2: rule__FnPrototype__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__Group_1__0_in_rule__FnPrototype__Alternatives2544);
                    rule__FnPrototype__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFnPrototypeAccess().getGroup_1()); 
                    }

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
    // $ANTLR end "rule__FnPrototype__Alternatives"


    // $ANTLR start "rule__FnPrototype__ExternAlternatives_0_1_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1231:1: rule__FnPrototype__ExternAlternatives_0_1_0 : ( ( 'extern' ) | ( 'EXTERN' ) );
    public final void rule__FnPrototype__ExternAlternatives_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1235:1: ( ( 'extern' ) | ( 'EXTERN' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            else if ( (LA9_0==16) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1236:1: ( 'extern' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1236:1: ( 'extern' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1237:1: 'extern'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getExternExternKeyword_0_1_0_0()); 
                    }
                    match(input,15,FOLLOW_15_in_rule__FnPrototype__ExternAlternatives_0_1_02578); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFnPrototypeAccess().getExternExternKeyword_0_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1244:6: ( 'EXTERN' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1244:6: ( 'EXTERN' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1245:1: 'EXTERN'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getExternEXTERNKeyword_0_1_0_1()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__FnPrototype__ExternAlternatives_0_1_02598); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFnPrototypeAccess().getExternEXTERNKeyword_0_1_0_1()); 
                    }

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
    // $ANTLR end "rule__FnPrototype__ExternAlternatives_0_1_0"


    // $ANTLR start "rule__FnPrototype__PureAlternatives_0_2_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1257:1: rule__FnPrototype__PureAlternatives_0_2_0 : ( ( 'pure' ) | ( 'PURE' ) );
    public final void rule__FnPrototype__PureAlternatives_0_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1261:1: ( ( 'pure' ) | ( 'PURE' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==17) ) {
                alt10=1;
            }
            else if ( (LA10_0==18) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1262:1: ( 'pure' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1262:1: ( 'pure' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1263:1: 'pure'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getPurePureKeyword_0_2_0_0()); 
                    }
                    match(input,17,FOLLOW_17_in_rule__FnPrototype__PureAlternatives_0_2_02633); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFnPrototypeAccess().getPurePureKeyword_0_2_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1270:6: ( 'PURE' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1270:6: ( 'PURE' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1271:1: 'PURE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getPurePUREKeyword_0_2_0_1()); 
                    }
                    match(input,18,FOLLOW_18_in_rule__FnPrototype__PureAlternatives_0_2_02653); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFnPrototypeAccess().getPurePUREKeyword_0_2_0_1()); 
                    }

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
    // $ANTLR end "rule__FnPrototype__PureAlternatives_0_2_0"


    // $ANTLR start "rule__FnPrototype__ExternAlternatives_1_1_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1283:1: rule__FnPrototype__ExternAlternatives_1_1_0 : ( ( 'extern' ) | ( 'EXTERN' ) );
    public final void rule__FnPrototype__ExternAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1287:1: ( ( 'extern' ) | ( 'EXTERN' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==15) ) {
                alt11=1;
            }
            else if ( (LA11_0==16) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1288:1: ( 'extern' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1288:1: ( 'extern' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1289:1: 'extern'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getExternExternKeyword_1_1_0_0()); 
                    }
                    match(input,15,FOLLOW_15_in_rule__FnPrototype__ExternAlternatives_1_1_02688); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFnPrototypeAccess().getExternExternKeyword_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1296:6: ( 'EXTERN' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1296:6: ( 'EXTERN' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1297:1: 'EXTERN'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getExternEXTERNKeyword_1_1_0_1()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__FnPrototype__ExternAlternatives_1_1_02708); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFnPrototypeAccess().getExternEXTERNKeyword_1_1_0_1()); 
                    }

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
    // $ANTLR end "rule__FnPrototype__ExternAlternatives_1_1_0"


    // $ANTLR start "rule__FnPrototype__PureAlternatives_1_2_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1309:1: rule__FnPrototype__PureAlternatives_1_2_0 : ( ( 'pure' ) | ( 'PURE' ) );
    public final void rule__FnPrototype__PureAlternatives_1_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1313:1: ( ( 'pure' ) | ( 'PURE' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            else if ( (LA12_0==18) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1314:1: ( 'pure' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1314:1: ( 'pure' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1315:1: 'pure'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getPurePureKeyword_1_2_0_0()); 
                    }
                    match(input,17,FOLLOW_17_in_rule__FnPrototype__PureAlternatives_1_2_02743); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFnPrototypeAccess().getPurePureKeyword_1_2_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1322:6: ( 'PURE' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1322:6: ( 'PURE' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1323:1: 'PURE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getPurePUREKeyword_1_2_0_1()); 
                    }
                    match(input,18,FOLLOW_18_in_rule__FnPrototype__PureAlternatives_1_2_02763); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFnPrototypeAccess().getPurePUREKeyword_1_2_0_1()); 
                    }

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
    // $ANTLR end "rule__FnPrototype__PureAlternatives_1_2_0"


    // $ANTLR start "rule__TerminalExpr__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1335:1: rule__TerminalExpr__Alternatives : ( ( ruleLVal ) | ( ( rule__TerminalExpr__Group_1__0 ) ) | ( ( rule__TerminalExpr__Group_2__0 ) ) | ( ( rule__TerminalExpr__Group_3__0 ) ) | ( ( rule__TerminalExpr__Group_4__0 ) ) | ( ( rule__TerminalExpr__Group_5__0 ) ) | ( ( rule__TerminalExpr__Group_6__0 ) ) | ( ruleCallExpr ) | ( ( rule__TerminalExpr__Group_8__0 ) ) );
    public final void rule__TerminalExpr__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1339:1: ( ( ruleLVal ) | ( ( rule__TerminalExpr__Group_1__0 ) ) | ( ( rule__TerminalExpr__Group_2__0 ) ) | ( ( rule__TerminalExpr__Group_3__0 ) ) | ( ( rule__TerminalExpr__Group_4__0 ) ) | ( ( rule__TerminalExpr__Group_5__0 ) ) | ( ( rule__TerminalExpr__Group_6__0 ) ) | ( ruleCallExpr ) | ( ( rule__TerminalExpr__Group_8__0 ) ) )
            int alt13=9;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1340:1: ( ruleLVal )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1340:1: ( ruleLVal )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1341:1: ruleLVal
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getLValParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleLVal_in_rule__TerminalExpr__Alternatives2797);
                    ruleLVal();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExprAccess().getLValParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1346:6: ( ( rule__TerminalExpr__Group_1__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1346:6: ( ( rule__TerminalExpr__Group_1__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1347:1: ( rule__TerminalExpr__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getGroup_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1348:1: ( rule__TerminalExpr__Group_1__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1348:2: rule__TerminalExpr__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__TerminalExpr__Group_1__0_in_rule__TerminalExpr__Alternatives2814);
                    rule__TerminalExpr__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExprAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1352:6: ( ( rule__TerminalExpr__Group_2__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1352:6: ( ( rule__TerminalExpr__Group_2__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1353:1: ( rule__TerminalExpr__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getGroup_2()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1354:1: ( rule__TerminalExpr__Group_2__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1354:2: rule__TerminalExpr__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__TerminalExpr__Group_2__0_in_rule__TerminalExpr__Alternatives2832);
                    rule__TerminalExpr__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExprAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1358:6: ( ( rule__TerminalExpr__Group_3__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1358:6: ( ( rule__TerminalExpr__Group_3__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1359:1: ( rule__TerminalExpr__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getGroup_3()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1360:1: ( rule__TerminalExpr__Group_3__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1360:2: rule__TerminalExpr__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__TerminalExpr__Group_3__0_in_rule__TerminalExpr__Alternatives2850);
                    rule__TerminalExpr__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExprAccess().getGroup_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1364:6: ( ( rule__TerminalExpr__Group_4__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1364:6: ( ( rule__TerminalExpr__Group_4__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1365:1: ( rule__TerminalExpr__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getGroup_4()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1366:1: ( rule__TerminalExpr__Group_4__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1366:2: rule__TerminalExpr__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__TerminalExpr__Group_4__0_in_rule__TerminalExpr__Alternatives2868);
                    rule__TerminalExpr__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExprAccess().getGroup_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1370:6: ( ( rule__TerminalExpr__Group_5__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1370:6: ( ( rule__TerminalExpr__Group_5__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1371:1: ( rule__TerminalExpr__Group_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getGroup_5()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1372:1: ( rule__TerminalExpr__Group_5__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1372:2: rule__TerminalExpr__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__TerminalExpr__Group_5__0_in_rule__TerminalExpr__Alternatives2886);
                    rule__TerminalExpr__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExprAccess().getGroup_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1376:6: ( ( rule__TerminalExpr__Group_6__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1376:6: ( ( rule__TerminalExpr__Group_6__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1377:1: ( rule__TerminalExpr__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getGroup_6()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1378:1: ( rule__TerminalExpr__Group_6__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1378:2: rule__TerminalExpr__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__TerminalExpr__Group_6__0_in_rule__TerminalExpr__Alternatives2904);
                    rule__TerminalExpr__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExprAccess().getGroup_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1382:6: ( ruleCallExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1382:6: ( ruleCallExpr )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1383:1: ruleCallExpr
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getCallExprParserRuleCall_7()); 
                    }
                    pushFollow(FOLLOW_ruleCallExpr_in_rule__TerminalExpr__Alternatives2922);
                    ruleCallExpr();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExprAccess().getCallExprParserRuleCall_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1388:6: ( ( rule__TerminalExpr__Group_8__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1388:6: ( ( rule__TerminalExpr__Group_8__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1389:1: ( rule__TerminalExpr__Group_8__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getGroup_8()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1390:1: ( rule__TerminalExpr__Group_8__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1390:2: rule__TerminalExpr__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__TerminalExpr__Group_8__0_in_rule__TerminalExpr__Alternatives2939);
                    rule__TerminalExpr__Group_8__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTerminalExprAccess().getGroup_8()); 
                    }

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
    // $ANTLR end "rule__TerminalExpr__Alternatives"


    // $ANTLR start "rule__Sign__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1399:1: rule__Sign__Alternatives : ( ( '+' ) | ( '-' ) );
    public final void rule__Sign__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1403:1: ( ( '+' ) | ( '-' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==19) ) {
                alt14=1;
            }
            else if ( (LA14_0==20) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1404:1: ( '+' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1404:1: ( '+' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1405:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSignAccess().getPlusSignKeyword_0()); 
                    }
                    match(input,19,FOLLOW_19_in_rule__Sign__Alternatives2973); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSignAccess().getPlusSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1412:6: ( '-' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1412:6: ( '-' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1413:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSignAccess().getHyphenMinusKeyword_1()); 
                    }
                    match(input,20,FOLLOW_20_in_rule__Sign__Alternatives2993); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSignAccess().getHyphenMinusKeyword_1()); 
                    }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1425:1: rule__SimpType__Alternatives : ( ( 'bool' ) | ( '_Bool' ) | ( 'int' ) | ( 'double' ) | ( 'void' ) | ( 'char' ) );
    public final void rule__SimpType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1429:1: ( ( 'bool' ) | ( '_Bool' ) | ( 'int' ) | ( 'double' ) | ( 'void' ) | ( 'char' ) )
            int alt15=6;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt15=1;
                }
                break;
            case 22:
                {
                alt15=2;
                }
                break;
            case 23:
                {
                alt15=3;
                }
                break;
            case 24:
                {
                alt15=4;
                }
                break;
            case 25:
                {
                alt15=5;
                }
                break;
            case 26:
                {
                alt15=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1430:1: ( 'bool' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1430:1: ( 'bool' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1431:1: 'bool'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpTypeAccess().getBoolKeyword_0()); 
                    }
                    match(input,21,FOLLOW_21_in_rule__SimpType__Alternatives3028); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpTypeAccess().getBoolKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1438:6: ( '_Bool' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1438:6: ( '_Bool' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1439:1: '_Bool'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpTypeAccess().get_BoolKeyword_1()); 
                    }
                    match(input,22,FOLLOW_22_in_rule__SimpType__Alternatives3048); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpTypeAccess().get_BoolKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1446:6: ( 'int' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1446:6: ( 'int' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1447:1: 'int'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpTypeAccess().getIntKeyword_2()); 
                    }
                    match(input,23,FOLLOW_23_in_rule__SimpType__Alternatives3068); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpTypeAccess().getIntKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1454:6: ( 'double' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1454:6: ( 'double' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1455:1: 'double'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpTypeAccess().getDoubleKeyword_3()); 
                    }
                    match(input,24,FOLLOW_24_in_rule__SimpType__Alternatives3088); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpTypeAccess().getDoubleKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1462:6: ( 'void' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1462:6: ( 'void' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1463:1: 'void'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpTypeAccess().getVoidKeyword_4()); 
                    }
                    match(input,25,FOLLOW_25_in_rule__SimpType__Alternatives3108); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpTypeAccess().getVoidKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1470:6: ( 'char' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1470:6: ( 'char' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1471:1: 'char'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpTypeAccess().getCharKeyword_5()); 
                    }
                    match(input,26,FOLLOW_26_in_rule__SimpType__Alternatives3128); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpTypeAccess().getCharKeyword_5()); 
                    }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1483:1: rule__Signed__Alternatives : ( ( 'signed' ) | ( 'unsigned' ) );
    public final void rule__Signed__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1487:1: ( ( 'signed' ) | ( 'unsigned' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            else if ( (LA16_0==28) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1488:1: ( 'signed' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1488:1: ( 'signed' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1489:1: 'signed'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSignedAccess().getSignedKeyword_0()); 
                    }
                    match(input,27,FOLLOW_27_in_rule__Signed__Alternatives3163); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSignedAccess().getSignedKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1496:6: ( 'unsigned' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1496:6: ( 'unsigned' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1497:1: 'unsigned'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSignedAccess().getUnsignedKeyword_1()); 
                    }
                    match(input,28,FOLLOW_28_in_rule__Signed__Alternatives3183); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSignedAccess().getUnsignedKeyword_1()); 
                    }

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


    // $ANTLR start "rule__BuiltInFunction__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1509:1: rule__BuiltInFunction__Alternatives : ( ( 'exists_other' ) | ( 'EXISTS_OTHER' ) | ( 'exists_higher' ) | ( 'EXISTS_HIGHER' ) | ( 'exists_lower' ) | ( 'EXISTS_LOWER' ) );
    public final void rule__BuiltInFunction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1513:1: ( ( 'exists_other' ) | ( 'EXISTS_OTHER' ) | ( 'exists_higher' ) | ( 'EXISTS_HIGHER' ) | ( 'exists_lower' ) | ( 'EXISTS_LOWER' ) )
            int alt17=6;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt17=1;
                }
                break;
            case 30:
                {
                alt17=2;
                }
                break;
            case 31:
                {
                alt17=3;
                }
                break;
            case 32:
                {
                alt17=4;
                }
                break;
            case 33:
                {
                alt17=5;
                }
                break;
            case 34:
                {
                alt17=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1514:1: ( 'exists_other' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1514:1: ( 'exists_other' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1515:1: 'exists_other'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBuiltInFunctionAccess().getExists_otherKeyword_0()); 
                    }
                    match(input,29,FOLLOW_29_in_rule__BuiltInFunction__Alternatives3218); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBuiltInFunctionAccess().getExists_otherKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1522:6: ( 'EXISTS_OTHER' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1522:6: ( 'EXISTS_OTHER' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1523:1: 'EXISTS_OTHER'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBuiltInFunctionAccess().getEXISTS_OTHERKeyword_1()); 
                    }
                    match(input,30,FOLLOW_30_in_rule__BuiltInFunction__Alternatives3238); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBuiltInFunctionAccess().getEXISTS_OTHERKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1530:6: ( 'exists_higher' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1530:6: ( 'exists_higher' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1531:1: 'exists_higher'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBuiltInFunctionAccess().getExists_higherKeyword_2()); 
                    }
                    match(input,31,FOLLOW_31_in_rule__BuiltInFunction__Alternatives3258); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBuiltInFunctionAccess().getExists_higherKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1538:6: ( 'EXISTS_HIGHER' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1538:6: ( 'EXISTS_HIGHER' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1539:1: 'EXISTS_HIGHER'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBuiltInFunctionAccess().getEXISTS_HIGHERKeyword_3()); 
                    }
                    match(input,32,FOLLOW_32_in_rule__BuiltInFunction__Alternatives3278); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBuiltInFunctionAccess().getEXISTS_HIGHERKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1546:6: ( 'exists_lower' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1546:6: ( 'exists_lower' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1547:1: 'exists_lower'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBuiltInFunctionAccess().getExists_lowerKeyword_4()); 
                    }
                    match(input,33,FOLLOW_33_in_rule__BuiltInFunction__Alternatives3298); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBuiltInFunctionAccess().getExists_lowerKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1554:6: ( 'EXISTS_LOWER' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1554:6: ( 'EXISTS_LOWER' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1555:1: 'EXISTS_LOWER'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBuiltInFunctionAccess().getEXISTS_LOWERKeyword_5()); 
                    }
                    match(input,34,FOLLOW_34_in_rule__BuiltInFunction__Alternatives3318); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBuiltInFunctionAccess().getEXISTS_LOWERKeyword_5()); 
                    }

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
    // $ANTLR end "rule__BuiltInFunction__Alternatives"


    // $ANTLR start "rule__Double__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1567:1: rule__Double__Alternatives : ( ( 'NAN' ) | ( ( rule__Double__Group_1__0 ) ) );
    public final void rule__Double__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1571:1: ( ( 'NAN' ) | ( ( rule__Double__Group_1__0 ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==35) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_INT) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1572:1: ( 'NAN' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1572:1: ( 'NAN' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1573:1: 'NAN'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDoubleAccess().getNANKeyword_0()); 
                    }
                    match(input,35,FOLLOW_35_in_rule__Double__Alternatives3353); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDoubleAccess().getNANKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1580:6: ( ( rule__Double__Group_1__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1580:6: ( ( rule__Double__Group_1__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1581:1: ( rule__Double__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDoubleAccess().getGroup_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1582:1: ( rule__Double__Group_1__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1582:2: rule__Double__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Double__Group_1__0_in_rule__Double__Alternatives3372);
                    rule__Double__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDoubleAccess().getGroup_1()); 
                    }

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


    // $ANTLR start "rule__ShiftOperator__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1594:1: rule__ShiftOperator__Alternatives : ( ( ( '<<' ) ) | ( ( '>>' ) ) );
    public final void rule__ShiftOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1598:1: ( ( ( '<<' ) ) | ( ( '>>' ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==36) ) {
                alt19=1;
            }
            else if ( (LA19_0==37) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1599:1: ( ( '<<' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1599:1: ( ( '<<' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1600:1: ( '<<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getShiftOperatorAccess().getLEFTEnumLiteralDeclaration_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1601:1: ( '<<' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1601:3: '<<'
                    {
                    match(input,36,FOLLOW_36_in_rule__ShiftOperator__Alternatives3409); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getShiftOperatorAccess().getLEFTEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1606:6: ( ( '>>' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1606:6: ( ( '>>' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1607:1: ( '>>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getShiftOperatorAccess().getRIGHTEnumLiteralDeclaration_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1608:1: ( '>>' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1608:3: '>>'
                    {
                    match(input,37,FOLLOW_37_in_rule__ShiftOperator__Alternatives3430); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getShiftOperatorAccess().getRIGHTEnumLiteralDeclaration_1()); 
                    }

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
    // $ANTLR end "rule__ShiftOperator__Alternatives"


    // $ANTLR start "rule__AdditiveOperator__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1618:1: rule__AdditiveOperator__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AdditiveOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1622:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==19) ) {
                alt20=1;
            }
            else if ( (LA20_0==20) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1623:1: ( ( '+' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1623:1: ( ( '+' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1624:1: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAdditiveOperatorAccess().getADDEnumLiteralDeclaration_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1625:1: ( '+' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1625:3: '+'
                    {
                    match(input,19,FOLLOW_19_in_rule__AdditiveOperator__Alternatives3466); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAdditiveOperatorAccess().getADDEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1630:6: ( ( '-' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1630:6: ( ( '-' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1631:1: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAdditiveOperatorAccess().getSUBTRACTEnumLiteralDeclaration_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1632:1: ( '-' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1632:3: '-'
                    {
                    match(input,20,FOLLOW_20_in_rule__AdditiveOperator__Alternatives3487); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAdditiveOperatorAccess().getSUBTRACTEnumLiteralDeclaration_1()); 
                    }

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
    // $ANTLR end "rule__AdditiveOperator__Alternatives"


    // $ANTLR start "rule__MultiplicativeOperator__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1642:1: rule__MultiplicativeOperator__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplicativeOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1646:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt21=1;
                }
                break;
            case 39:
                {
                alt21=2;
                }
                break;
            case 40:
                {
                alt21=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1647:1: ( ( '*' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1647:1: ( ( '*' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1648:1: ( '*' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicativeOperatorAccess().getMULTIPLYEnumLiteralDeclaration_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1649:1: ( '*' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1649:3: '*'
                    {
                    match(input,38,FOLLOW_38_in_rule__MultiplicativeOperator__Alternatives3523); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicativeOperatorAccess().getMULTIPLYEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1654:6: ( ( '/' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1654:6: ( ( '/' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1655:1: ( '/' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicativeOperatorAccess().getDIVIDEEnumLiteralDeclaration_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1656:1: ( '/' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1656:3: '/'
                    {
                    match(input,39,FOLLOW_39_in_rule__MultiplicativeOperator__Alternatives3544); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicativeOperatorAccess().getDIVIDEEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1661:6: ( ( '%' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1661:6: ( ( '%' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1662:1: ( '%' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicativeOperatorAccess().getMODULUSEnumLiteralDeclaration_2()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1663:1: ( '%' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1663:3: '%'
                    {
                    match(input,40,FOLLOW_40_in_rule__MultiplicativeOperator__Alternatives3565); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicativeOperatorAccess().getMODULUSEnumLiteralDeclaration_2()); 
                    }

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
    // $ANTLR end "rule__MultiplicativeOperator__Alternatives"


    // $ANTLR start "rule__UnaryOperator__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1673:1: rule__UnaryOperator__Alternatives : ( ( ( '-' ) ) | ( ( '+' ) ) | ( ( '!' ) ) | ( ( '~' ) ) );
    public final void rule__UnaryOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1677:1: ( ( ( '-' ) ) | ( ( '+' ) ) | ( ( '!' ) ) | ( ( '~' ) ) )
            int alt22=4;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt22=1;
                }
                break;
            case 19:
                {
                alt22=2;
                }
                break;
            case 41:
                {
                alt22=3;
                }
                break;
            case 42:
                {
                alt22=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1678:1: ( ( '-' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1678:1: ( ( '-' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1679:1: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperatorAccess().getMINUSEnumLiteralDeclaration_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1680:1: ( '-' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1680:3: '-'
                    {
                    match(input,20,FOLLOW_20_in_rule__UnaryOperator__Alternatives3601); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUnaryOperatorAccess().getMINUSEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1685:6: ( ( '+' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1685:6: ( ( '+' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1686:1: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperatorAccess().getPLUSEnumLiteralDeclaration_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1687:1: ( '+' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1687:3: '+'
                    {
                    match(input,19,FOLLOW_19_in_rule__UnaryOperator__Alternatives3622); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUnaryOperatorAccess().getPLUSEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1692:6: ( ( '!' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1692:6: ( ( '!' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1693:1: ( '!' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperatorAccess().getLOGICAL_NOTEnumLiteralDeclaration_2()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1694:1: ( '!' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1694:3: '!'
                    {
                    match(input,41,FOLLOW_41_in_rule__UnaryOperator__Alternatives3643); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUnaryOperatorAccess().getLOGICAL_NOTEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1699:6: ( ( '~' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1699:6: ( ( '~' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1700:1: ( '~' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperatorAccess().getBITWISE_NOTEnumLiteralDeclaration_3()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1701:1: ( '~' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1701:3: '~'
                    {
                    match(input,42,FOLLOW_42_in_rule__UnaryOperator__Alternatives3664); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUnaryOperatorAccess().getBITWISE_NOTEnumLiteralDeclaration_3()); 
                    }

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
    // $ANTLR end "rule__UnaryOperator__Alternatives"


    // $ANTLR start "rule__Program__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1714:1: rule__Program__Group__0 : rule__Program__Group__0__Impl rule__Program__Group__1 ;
    public final void rule__Program__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1718:1: ( rule__Program__Group__0__Impl rule__Program__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1719:2: rule__Program__Group__0__Impl rule__Program__Group__1
            {
            pushFollow(FOLLOW_rule__Program__Group__0__Impl_in_rule__Program__Group__03698);
            rule__Program__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Program__Group__1_in_rule__Program__Group__03701);
            rule__Program__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1726:1: rule__Program__Group__0__Impl : ( () ) ;
    public final void rule__Program__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1730:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1731:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1731:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1732:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getProgramAction_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1733:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1735:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getProgramAction_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1745:1: rule__Program__Group__1 : rule__Program__Group__1__Impl ;
    public final void rule__Program__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1749:1: ( rule__Program__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1750:2: rule__Program__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Program__Group__1__Impl_in_rule__Program__Group__13759);
            rule__Program__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1756:1: rule__Program__Group__1__Impl : ( ( rule__Program__ProgramElementsAssignment_1 )* ) ;
    public final void rule__Program__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1760:1: ( ( ( rule__Program__ProgramElementsAssignment_1 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1761:1: ( ( rule__Program__ProgramElementsAssignment_1 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1761:1: ( ( rule__Program__ProgramElementsAssignment_1 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1762:1: ( rule__Program__ProgramElementsAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getProgramElementsAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1763:1: ( rule__Program__ProgramElementsAssignment_1 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=12 && LA23_0<=13)||(LA23_0>=15 && LA23_0<=18)||(LA23_0>=21 && LA23_0<=28)||LA23_0==49) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1763:2: rule__Program__ProgramElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Program__ProgramElementsAssignment_1_in_rule__Program__Group__1__Impl3786);
            	    rule__Program__ProgramElementsAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getProgramElementsAssignment_1()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1777:1: rule__DmplSubclause__Group__0 : rule__DmplSubclause__Group__0__Impl rule__DmplSubclause__Group__1 ;
    public final void rule__DmplSubclause__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1781:1: ( rule__DmplSubclause__Group__0__Impl rule__DmplSubclause__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1782:2: rule__DmplSubclause__Group__0__Impl rule__DmplSubclause__Group__1
            {
            pushFollow(FOLLOW_rule__DmplSubclause__Group__0__Impl_in_rule__DmplSubclause__Group__03821);
            rule__DmplSubclause__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DmplSubclause__Group__1_in_rule__DmplSubclause__Group__03824);
            rule__DmplSubclause__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1789:1: rule__DmplSubclause__Group__0__Impl : ( () ) ;
    public final void rule__DmplSubclause__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1793:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1794:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1794:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1795:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDmplSubclauseAccess().getDmplSubclauseAction_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1796:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1798:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDmplSubclauseAccess().getDmplSubclauseAction_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1808:1: rule__DmplSubclause__Group__1 : rule__DmplSubclause__Group__1__Impl ;
    public final void rule__DmplSubclause__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1812:1: ( rule__DmplSubclause__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1813:2: rule__DmplSubclause__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DmplSubclause__Group__1__Impl_in_rule__DmplSubclause__Group__13882);
            rule__DmplSubclause__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1819:1: rule__DmplSubclause__Group__1__Impl : ( ( rule__DmplSubclause__ProgramAssignment_1 ) ) ;
    public final void rule__DmplSubclause__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1823:1: ( ( ( rule__DmplSubclause__ProgramAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1824:1: ( ( rule__DmplSubclause__ProgramAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1824:1: ( ( rule__DmplSubclause__ProgramAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1825:1: ( rule__DmplSubclause__ProgramAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDmplSubclauseAccess().getProgramAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1826:1: ( rule__DmplSubclause__ProgramAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1826:2: rule__DmplSubclause__ProgramAssignment_1
            {
            pushFollow(FOLLOW_rule__DmplSubclause__ProgramAssignment_1_in_rule__DmplSubclause__Group__1__Impl3909);
            rule__DmplSubclause__ProgramAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDmplSubclauseAccess().getProgramAssignment_1()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1840:1: rule__Constant__Group__0 : rule__Constant__Group__0__Impl rule__Constant__Group__1 ;
    public final void rule__Constant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1844:1: ( rule__Constant__Group__0__Impl rule__Constant__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1845:2: rule__Constant__Group__0__Impl rule__Constant__Group__1
            {
            pushFollow(FOLLOW_rule__Constant__Group__0__Impl_in_rule__Constant__Group__03943);
            rule__Constant__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Constant__Group__1_in_rule__Constant__Group__03946);
            rule__Constant__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1852:1: rule__Constant__Group__0__Impl : ( ( rule__Constant__Alternatives_0 ) ) ;
    public final void rule__Constant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1856:1: ( ( ( rule__Constant__Alternatives_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1857:1: ( ( rule__Constant__Alternatives_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1857:1: ( ( rule__Constant__Alternatives_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1858:1: ( rule__Constant__Alternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getAlternatives_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1859:1: ( rule__Constant__Alternatives_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1859:2: rule__Constant__Alternatives_0
            {
            pushFollow(FOLLOW_rule__Constant__Alternatives_0_in_rule__Constant__Group__0__Impl3973);
            rule__Constant__Alternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantAccess().getAlternatives_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1869:1: rule__Constant__Group__1 : rule__Constant__Group__1__Impl rule__Constant__Group__2 ;
    public final void rule__Constant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1873:1: ( rule__Constant__Group__1__Impl rule__Constant__Group__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1874:2: rule__Constant__Group__1__Impl rule__Constant__Group__2
            {
            pushFollow(FOLLOW_rule__Constant__Group__1__Impl_in_rule__Constant__Group__14003);
            rule__Constant__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Constant__Group__2_in_rule__Constant__Group__14006);
            rule__Constant__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1881:1: rule__Constant__Group__1__Impl : ( ( rule__Constant__NameAssignment_1 ) ) ;
    public final void rule__Constant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1885:1: ( ( ( rule__Constant__NameAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1886:1: ( ( rule__Constant__NameAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1886:1: ( ( rule__Constant__NameAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1887:1: ( rule__Constant__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getNameAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1888:1: ( rule__Constant__NameAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1888:2: rule__Constant__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Constant__NameAssignment_1_in_rule__Constant__Group__1__Impl4033);
            rule__Constant__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantAccess().getNameAssignment_1()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1898:1: rule__Constant__Group__2 : rule__Constant__Group__2__Impl rule__Constant__Group__3 ;
    public final void rule__Constant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1902:1: ( rule__Constant__Group__2__Impl rule__Constant__Group__3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1903:2: rule__Constant__Group__2__Impl rule__Constant__Group__3
            {
            pushFollow(FOLLOW_rule__Constant__Group__2__Impl_in_rule__Constant__Group__24063);
            rule__Constant__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Constant__Group__3_in_rule__Constant__Group__24066);
            rule__Constant__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1910:1: rule__Constant__Group__2__Impl : ( '=' ) ;
    public final void rule__Constant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1914:1: ( ( '=' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1915:1: ( '=' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1915:1: ( '=' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1916:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getEqualsSignKeyword_2()); 
            }
            match(input,43,FOLLOW_43_in_rule__Constant__Group__2__Impl4094); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantAccess().getEqualsSignKeyword_2()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1929:1: rule__Constant__Group__3 : rule__Constant__Group__3__Impl rule__Constant__Group__4 ;
    public final void rule__Constant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1933:1: ( rule__Constant__Group__3__Impl rule__Constant__Group__4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1934:2: rule__Constant__Group__3__Impl rule__Constant__Group__4
            {
            pushFollow(FOLLOW_rule__Constant__Group__3__Impl_in_rule__Constant__Group__34125);
            rule__Constant__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Constant__Group__4_in_rule__Constant__Group__34128);
            rule__Constant__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1941:1: rule__Constant__Group__3__Impl : ( ( rule__Constant__ValueAssignment_3 ) ) ;
    public final void rule__Constant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1945:1: ( ( ( rule__Constant__ValueAssignment_3 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1946:1: ( ( rule__Constant__ValueAssignment_3 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1946:1: ( ( rule__Constant__ValueAssignment_3 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1947:1: ( rule__Constant__ValueAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getValueAssignment_3()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1948:1: ( rule__Constant__ValueAssignment_3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1948:2: rule__Constant__ValueAssignment_3
            {
            pushFollow(FOLLOW_rule__Constant__ValueAssignment_3_in_rule__Constant__Group__3__Impl4155);
            rule__Constant__ValueAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantAccess().getValueAssignment_3()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1958:1: rule__Constant__Group__4 : rule__Constant__Group__4__Impl ;
    public final void rule__Constant__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1962:1: ( rule__Constant__Group__4__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1963:2: rule__Constant__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Constant__Group__4__Impl_in_rule__Constant__Group__44185);
            rule__Constant__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1969:1: rule__Constant__Group__4__Impl : ( ';' ) ;
    public final void rule__Constant__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1973:1: ( ( ';' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1974:1: ( ';' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1974:1: ( ';' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1975:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getSemicolonKeyword_4()); 
            }
            match(input,14,FOLLOW_14_in_rule__Constant__Group__4__Impl4213); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantAccess().getSemicolonKeyword_4()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1998:1: rule__IntConst__Group__0 : rule__IntConst__Group__0__Impl rule__IntConst__Group__1 ;
    public final void rule__IntConst__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2002:1: ( rule__IntConst__Group__0__Impl rule__IntConst__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2003:2: rule__IntConst__Group__0__Impl rule__IntConst__Group__1
            {
            pushFollow(FOLLOW_rule__IntConst__Group__0__Impl_in_rule__IntConst__Group__04254);
            rule__IntConst__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__IntConst__Group__1_in_rule__IntConst__Group__04257);
            rule__IntConst__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2010:1: rule__IntConst__Group__0__Impl : ( ( rule__IntConst__SignAssignment_0 )? ) ;
    public final void rule__IntConst__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2014:1: ( ( ( rule__IntConst__SignAssignment_0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2015:1: ( ( rule__IntConst__SignAssignment_0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2015:1: ( ( rule__IntConst__SignAssignment_0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2016:1: ( rule__IntConst__SignAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntConstAccess().getSignAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2017:1: ( rule__IntConst__SignAssignment_0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=19 && LA24_0<=20)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2017:2: rule__IntConst__SignAssignment_0
                    {
                    pushFollow(FOLLOW_rule__IntConst__SignAssignment_0_in_rule__IntConst__Group__0__Impl4284);
                    rule__IntConst__SignAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntConstAccess().getSignAssignment_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2027:1: rule__IntConst__Group__1 : rule__IntConst__Group__1__Impl ;
    public final void rule__IntConst__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2031:1: ( rule__IntConst__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2032:2: rule__IntConst__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntConst__Group__1__Impl_in_rule__IntConst__Group__14315);
            rule__IntConst__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2038:1: rule__IntConst__Group__1__Impl : ( ( rule__IntConst__ValueAssignment_1 ) ) ;
    public final void rule__IntConst__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2042:1: ( ( ( rule__IntConst__ValueAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2043:1: ( ( rule__IntConst__ValueAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2043:1: ( ( rule__IntConst__ValueAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2044:1: ( rule__IntConst__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntConstAccess().getValueAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2045:1: ( rule__IntConst__ValueAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2045:2: rule__IntConst__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__IntConst__ValueAssignment_1_in_rule__IntConst__Group__1__Impl4342);
            rule__IntConst__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntConstAccess().getValueAssignment_1()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2059:1: rule__DoubleConst__Group__0 : rule__DoubleConst__Group__0__Impl rule__DoubleConst__Group__1 ;
    public final void rule__DoubleConst__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2063:1: ( rule__DoubleConst__Group__0__Impl rule__DoubleConst__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2064:2: rule__DoubleConst__Group__0__Impl rule__DoubleConst__Group__1
            {
            pushFollow(FOLLOW_rule__DoubleConst__Group__0__Impl_in_rule__DoubleConst__Group__04376);
            rule__DoubleConst__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DoubleConst__Group__1_in_rule__DoubleConst__Group__04379);
            rule__DoubleConst__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2071:1: rule__DoubleConst__Group__0__Impl : ( ( rule__DoubleConst__SignAssignment_0 )? ) ;
    public final void rule__DoubleConst__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2075:1: ( ( ( rule__DoubleConst__SignAssignment_0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2076:1: ( ( rule__DoubleConst__SignAssignment_0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2076:1: ( ( rule__DoubleConst__SignAssignment_0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2077:1: ( rule__DoubleConst__SignAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleConstAccess().getSignAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2078:1: ( rule__DoubleConst__SignAssignment_0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=19 && LA25_0<=20)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2078:2: rule__DoubleConst__SignAssignment_0
                    {
                    pushFollow(FOLLOW_rule__DoubleConst__SignAssignment_0_in_rule__DoubleConst__Group__0__Impl4406);
                    rule__DoubleConst__SignAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleConstAccess().getSignAssignment_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2088:1: rule__DoubleConst__Group__1 : rule__DoubleConst__Group__1__Impl ;
    public final void rule__DoubleConst__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2092:1: ( rule__DoubleConst__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2093:2: rule__DoubleConst__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DoubleConst__Group__1__Impl_in_rule__DoubleConst__Group__14437);
            rule__DoubleConst__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2099:1: rule__DoubleConst__Group__1__Impl : ( ( rule__DoubleConst__ValueAssignment_1 ) ) ;
    public final void rule__DoubleConst__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2103:1: ( ( ( rule__DoubleConst__ValueAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2104:1: ( ( rule__DoubleConst__ValueAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2104:1: ( ( rule__DoubleConst__ValueAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2105:1: ( rule__DoubleConst__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleConstAccess().getValueAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2106:1: ( rule__DoubleConst__ValueAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2106:2: rule__DoubleConst__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__DoubleConst__ValueAssignment_1_in_rule__DoubleConst__Group__1__Impl4464);
            rule__DoubleConst__ValueAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleConstAccess().getValueAssignment_1()); 
            }

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


    // $ANTLR start "rule__VarInit__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2120:1: rule__VarInit__Group__0 : rule__VarInit__Group__0__Impl rule__VarInit__Group__1 ;
    public final void rule__VarInit__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2124:1: ( rule__VarInit__Group__0__Impl rule__VarInit__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2125:2: rule__VarInit__Group__0__Impl rule__VarInit__Group__1
            {
            pushFollow(FOLLOW_rule__VarInit__Group__0__Impl_in_rule__VarInit__Group__04498);
            rule__VarInit__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__VarInit__Group__1_in_rule__VarInit__Group__04501);
            rule__VarInit__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__VarInit__Group__0"


    // $ANTLR start "rule__VarInit__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2132:1: rule__VarInit__Group__0__Impl : ( ( rule__VarInit__TypeAssignment_0 ) ) ;
    public final void rule__VarInit__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2136:1: ( ( ( rule__VarInit__TypeAssignment_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2137:1: ( ( rule__VarInit__TypeAssignment_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2137:1: ( ( rule__VarInit__TypeAssignment_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2138:1: ( rule__VarInit__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitAccess().getTypeAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2139:1: ( rule__VarInit__TypeAssignment_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2139:2: rule__VarInit__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__VarInit__TypeAssignment_0_in_rule__VarInit__Group__0__Impl4528);
            rule__VarInit__TypeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarInitAccess().getTypeAssignment_0()); 
            }

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
    // $ANTLR end "rule__VarInit__Group__0__Impl"


    // $ANTLR start "rule__VarInit__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2149:1: rule__VarInit__Group__1 : rule__VarInit__Group__1__Impl ;
    public final void rule__VarInit__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2153:1: ( rule__VarInit__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2154:2: rule__VarInit__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__VarInit__Group__1__Impl_in_rule__VarInit__Group__14558);
            rule__VarInit__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__VarInit__Group__1"


    // $ANTLR start "rule__VarInit__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2160:1: rule__VarInit__Group__1__Impl : ( ( rule__VarInit__VarAsgnListAssignment_1 ) ) ;
    public final void rule__VarInit__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2164:1: ( ( ( rule__VarInit__VarAsgnListAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2165:1: ( ( rule__VarInit__VarAsgnListAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2165:1: ( ( rule__VarInit__VarAsgnListAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2166:1: ( rule__VarInit__VarAsgnListAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitAccess().getVarAsgnListAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2167:1: ( rule__VarInit__VarAsgnListAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2167:2: rule__VarInit__VarAsgnListAssignment_1
            {
            pushFollow(FOLLOW_rule__VarInit__VarAsgnListAssignment_1_in_rule__VarInit__Group__1__Impl4585);
            rule__VarInit__VarAsgnListAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarInitAccess().getVarAsgnListAssignment_1()); 
            }

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
    // $ANTLR end "rule__VarInit__Group__1__Impl"


    // $ANTLR start "rule__VarAsgn__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2181:1: rule__VarAsgn__Group__0 : rule__VarAsgn__Group__0__Impl rule__VarAsgn__Group__1 ;
    public final void rule__VarAsgn__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2185:1: ( rule__VarAsgn__Group__0__Impl rule__VarAsgn__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2186:2: rule__VarAsgn__Group__0__Impl rule__VarAsgn__Group__1
            {
            pushFollow(FOLLOW_rule__VarAsgn__Group__0__Impl_in_rule__VarAsgn__Group__04619);
            rule__VarAsgn__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__VarAsgn__Group__1_in_rule__VarAsgn__Group__04622);
            rule__VarAsgn__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__VarAsgn__Group__0"


    // $ANTLR start "rule__VarAsgn__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2193:1: rule__VarAsgn__Group__0__Impl : ( ( rule__VarAsgn__VarAssignment_0 ) ) ;
    public final void rule__VarAsgn__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2197:1: ( ( ( rule__VarAsgn__VarAssignment_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2198:1: ( ( rule__VarAsgn__VarAssignment_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2198:1: ( ( rule__VarAsgn__VarAssignment_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2199:1: ( rule__VarAsgn__VarAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnAccess().getVarAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2200:1: ( rule__VarAsgn__VarAssignment_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2200:2: rule__VarAsgn__VarAssignment_0
            {
            pushFollow(FOLLOW_rule__VarAsgn__VarAssignment_0_in_rule__VarAsgn__Group__0__Impl4649);
            rule__VarAsgn__VarAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAsgnAccess().getVarAssignment_0()); 
            }

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
    // $ANTLR end "rule__VarAsgn__Group__0__Impl"


    // $ANTLR start "rule__VarAsgn__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2210:1: rule__VarAsgn__Group__1 : rule__VarAsgn__Group__1__Impl rule__VarAsgn__Group__2 ;
    public final void rule__VarAsgn__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2214:1: ( rule__VarAsgn__Group__1__Impl rule__VarAsgn__Group__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2215:2: rule__VarAsgn__Group__1__Impl rule__VarAsgn__Group__2
            {
            pushFollow(FOLLOW_rule__VarAsgn__Group__1__Impl_in_rule__VarAsgn__Group__14679);
            rule__VarAsgn__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__VarAsgn__Group__2_in_rule__VarAsgn__Group__14682);
            rule__VarAsgn__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__VarAsgn__Group__1"


    // $ANTLR start "rule__VarAsgn__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2222:1: rule__VarAsgn__Group__1__Impl : ( '=' ) ;
    public final void rule__VarAsgn__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2226:1: ( ( '=' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2227:1: ( '=' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2227:1: ( '=' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2228:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnAccess().getEqualsSignKeyword_1()); 
            }
            match(input,43,FOLLOW_43_in_rule__VarAsgn__Group__1__Impl4710); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAsgnAccess().getEqualsSignKeyword_1()); 
            }

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
    // $ANTLR end "rule__VarAsgn__Group__1__Impl"


    // $ANTLR start "rule__VarAsgn__Group__2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2241:1: rule__VarAsgn__Group__2 : rule__VarAsgn__Group__2__Impl ;
    public final void rule__VarAsgn__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2245:1: ( rule__VarAsgn__Group__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2246:2: rule__VarAsgn__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__VarAsgn__Group__2__Impl_in_rule__VarAsgn__Group__24741);
            rule__VarAsgn__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__VarAsgn__Group__2"


    // $ANTLR start "rule__VarAsgn__Group__2__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2252:1: rule__VarAsgn__Group__2__Impl : ( ( rule__VarAsgn__Alternatives_2 ) ) ;
    public final void rule__VarAsgn__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2256:1: ( ( ( rule__VarAsgn__Alternatives_2 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2257:1: ( ( rule__VarAsgn__Alternatives_2 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2257:1: ( ( rule__VarAsgn__Alternatives_2 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2258:1: ( rule__VarAsgn__Alternatives_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnAccess().getAlternatives_2()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2259:1: ( rule__VarAsgn__Alternatives_2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2259:2: rule__VarAsgn__Alternatives_2
            {
            pushFollow(FOLLOW_rule__VarAsgn__Alternatives_2_in_rule__VarAsgn__Group__2__Impl4768);
            rule__VarAsgn__Alternatives_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAsgnAccess().getAlternatives_2()); 
            }

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
    // $ANTLR end "rule__VarAsgn__Group__2__Impl"


    // $ANTLR start "rule__Var__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2275:1: rule__Var__Group__0 : rule__Var__Group__0__Impl rule__Var__Group__1 ;
    public final void rule__Var__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2279:1: ( rule__Var__Group__0__Impl rule__Var__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2280:2: rule__Var__Group__0__Impl rule__Var__Group__1
            {
            pushFollow(FOLLOW_rule__Var__Group__0__Impl_in_rule__Var__Group__04804);
            rule__Var__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Var__Group__1_in_rule__Var__Group__04807);
            rule__Var__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Var__Group__0"


    // $ANTLR start "rule__Var__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2287:1: rule__Var__Group__0__Impl : ( ( rule__Var__NameAssignment_0 ) ) ;
    public final void rule__Var__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2291:1: ( ( ( rule__Var__NameAssignment_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2292:1: ( ( rule__Var__NameAssignment_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2292:1: ( ( rule__Var__NameAssignment_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2293:1: ( rule__Var__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAccess().getNameAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2294:1: ( rule__Var__NameAssignment_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2294:2: rule__Var__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Var__NameAssignment_0_in_rule__Var__Group__0__Impl4834);
            rule__Var__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAccess().getNameAssignment_0()); 
            }

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
    // $ANTLR end "rule__Var__Group__0__Impl"


    // $ANTLR start "rule__Var__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2304:1: rule__Var__Group__1 : rule__Var__Group__1__Impl ;
    public final void rule__Var__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2308:1: ( rule__Var__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2309:2: rule__Var__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Var__Group__1__Impl_in_rule__Var__Group__14864);
            rule__Var__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Var__Group__1"


    // $ANTLR start "rule__Var__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2315:1: rule__Var__Group__1__Impl : ( ( rule__Var__Group_1__0 )* ) ;
    public final void rule__Var__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2319:1: ( ( ( rule__Var__Group_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2320:1: ( ( rule__Var__Group_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2320:1: ( ( rule__Var__Group_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2321:1: ( rule__Var__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAccess().getGroup_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2322:1: ( rule__Var__Group_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==44) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2322:2: rule__Var__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Var__Group_1__0_in_rule__Var__Group__1__Impl4891);
            	    rule__Var__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAccess().getGroup_1()); 
            }

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
    // $ANTLR end "rule__Var__Group__1__Impl"


    // $ANTLR start "rule__Var__Group_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2336:1: rule__Var__Group_1__0 : rule__Var__Group_1__0__Impl rule__Var__Group_1__1 ;
    public final void rule__Var__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2340:1: ( rule__Var__Group_1__0__Impl rule__Var__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2341:2: rule__Var__Group_1__0__Impl rule__Var__Group_1__1
            {
            pushFollow(FOLLOW_rule__Var__Group_1__0__Impl_in_rule__Var__Group_1__04926);
            rule__Var__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Var__Group_1__1_in_rule__Var__Group_1__04929);
            rule__Var__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Var__Group_1__0"


    // $ANTLR start "rule__Var__Group_1__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2348:1: rule__Var__Group_1__0__Impl : ( '[' ) ;
    public final void rule__Var__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2352:1: ( ( '[' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2353:1: ( '[' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2353:1: ( '[' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2354:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAccess().getLeftSquareBracketKeyword_1_0()); 
            }
            match(input,44,FOLLOW_44_in_rule__Var__Group_1__0__Impl4957); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAccess().getLeftSquareBracketKeyword_1_0()); 
            }

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
    // $ANTLR end "rule__Var__Group_1__0__Impl"


    // $ANTLR start "rule__Var__Group_1__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2367:1: rule__Var__Group_1__1 : rule__Var__Group_1__1__Impl rule__Var__Group_1__2 ;
    public final void rule__Var__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2371:1: ( rule__Var__Group_1__1__Impl rule__Var__Group_1__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2372:2: rule__Var__Group_1__1__Impl rule__Var__Group_1__2
            {
            pushFollow(FOLLOW_rule__Var__Group_1__1__Impl_in_rule__Var__Group_1__14988);
            rule__Var__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Var__Group_1__2_in_rule__Var__Group_1__14991);
            rule__Var__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Var__Group_1__1"


    // $ANTLR start "rule__Var__Group_1__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2379:1: rule__Var__Group_1__1__Impl : ( ( rule__Var__DimensionsAssignment_1_1 ) ) ;
    public final void rule__Var__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2383:1: ( ( ( rule__Var__DimensionsAssignment_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2384:1: ( ( rule__Var__DimensionsAssignment_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2384:1: ( ( rule__Var__DimensionsAssignment_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2385:1: ( rule__Var__DimensionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAccess().getDimensionsAssignment_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2386:1: ( rule__Var__DimensionsAssignment_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2386:2: rule__Var__DimensionsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Var__DimensionsAssignment_1_1_in_rule__Var__Group_1__1__Impl5018);
            rule__Var__DimensionsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAccess().getDimensionsAssignment_1_1()); 
            }

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
    // $ANTLR end "rule__Var__Group_1__1__Impl"


    // $ANTLR start "rule__Var__Group_1__2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2396:1: rule__Var__Group_1__2 : rule__Var__Group_1__2__Impl ;
    public final void rule__Var__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2400:1: ( rule__Var__Group_1__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2401:2: rule__Var__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Var__Group_1__2__Impl_in_rule__Var__Group_1__25048);
            rule__Var__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Var__Group_1__2"


    // $ANTLR start "rule__Var__Group_1__2__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2407:1: rule__Var__Group_1__2__Impl : ( ']' ) ;
    public final void rule__Var__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2411:1: ( ( ']' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2412:1: ( ']' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2412:1: ( ']' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2413:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAccess().getRightSquareBracketKeyword_1_2()); 
            }
            match(input,45,FOLLOW_45_in_rule__Var__Group_1__2__Impl5076); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAccess().getRightSquareBracketKeyword_1_2()); 
            }

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
    // $ANTLR end "rule__Var__Group_1__2__Impl"


    // $ANTLR start "rule__Dimension__Group_0__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2432:1: rule__Dimension__Group_0__0 : rule__Dimension__Group_0__0__Impl rule__Dimension__Group_0__1 ;
    public final void rule__Dimension__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2436:1: ( rule__Dimension__Group_0__0__Impl rule__Dimension__Group_0__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2437:2: rule__Dimension__Group_0__0__Impl rule__Dimension__Group_0__1
            {
            pushFollow(FOLLOW_rule__Dimension__Group_0__0__Impl_in_rule__Dimension__Group_0__05113);
            rule__Dimension__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Dimension__Group_0__1_in_rule__Dimension__Group_0__05116);
            rule__Dimension__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Dimension__Group_0__0"


    // $ANTLR start "rule__Dimension__Group_0__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2444:1: rule__Dimension__Group_0__0__Impl : ( () ) ;
    public final void rule__Dimension__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2448:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2449:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2449:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2450:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getIntDimensionAction_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2451:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2453:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDimensionAccess().getIntDimensionAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dimension__Group_0__0__Impl"


    // $ANTLR start "rule__Dimension__Group_0__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2463:1: rule__Dimension__Group_0__1 : rule__Dimension__Group_0__1__Impl ;
    public final void rule__Dimension__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2467:1: ( rule__Dimension__Group_0__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2468:2: rule__Dimension__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Dimension__Group_0__1__Impl_in_rule__Dimension__Group_0__15174);
            rule__Dimension__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Dimension__Group_0__1"


    // $ANTLR start "rule__Dimension__Group_0__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2474:1: rule__Dimension__Group_0__1__Impl : ( ( rule__Dimension__IndexAssignment_0_1 ) ) ;
    public final void rule__Dimension__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2478:1: ( ( ( rule__Dimension__IndexAssignment_0_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2479:1: ( ( rule__Dimension__IndexAssignment_0_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2479:1: ( ( rule__Dimension__IndexAssignment_0_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2480:1: ( rule__Dimension__IndexAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getIndexAssignment_0_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2481:1: ( rule__Dimension__IndexAssignment_0_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2481:2: rule__Dimension__IndexAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Dimension__IndexAssignment_0_1_in_rule__Dimension__Group_0__1__Impl5201);
            rule__Dimension__IndexAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDimensionAccess().getIndexAssignment_0_1()); 
            }

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
    // $ANTLR end "rule__Dimension__Group_0__1__Impl"


    // $ANTLR start "rule__Dimension__Group_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2495:1: rule__Dimension__Group_1__0 : rule__Dimension__Group_1__0__Impl rule__Dimension__Group_1__1 ;
    public final void rule__Dimension__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2499:1: ( rule__Dimension__Group_1__0__Impl rule__Dimension__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2500:2: rule__Dimension__Group_1__0__Impl rule__Dimension__Group_1__1
            {
            pushFollow(FOLLOW_rule__Dimension__Group_1__0__Impl_in_rule__Dimension__Group_1__05235);
            rule__Dimension__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Dimension__Group_1__1_in_rule__Dimension__Group_1__05238);
            rule__Dimension__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Dimension__Group_1__0"


    // $ANTLR start "rule__Dimension__Group_1__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2507:1: rule__Dimension__Group_1__0__Impl : ( () ) ;
    public final void rule__Dimension__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2511:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2512:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2512:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2513:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getNodeNumDimensionAction_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2514:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2516:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDimensionAccess().getNodeNumDimensionAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dimension__Group_1__0__Impl"


    // $ANTLR start "rule__Dimension__Group_1__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2526:1: rule__Dimension__Group_1__1 : rule__Dimension__Group_1__1__Impl ;
    public final void rule__Dimension__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2530:1: ( rule__Dimension__Group_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2531:2: rule__Dimension__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Dimension__Group_1__1__Impl_in_rule__Dimension__Group_1__15296);
            rule__Dimension__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Dimension__Group_1__1"


    // $ANTLR start "rule__Dimension__Group_1__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2537:1: rule__Dimension__Group_1__1__Impl : ( '#N' ) ;
    public final void rule__Dimension__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2541:1: ( ( '#N' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2542:1: ( '#N' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2542:1: ( '#N' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2543:1: '#N'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getNKeyword_1_1()); 
            }
            match(input,46,FOLLOW_46_in_rule__Dimension__Group_1__1__Impl5324); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDimensionAccess().getNKeyword_1_1()); 
            }

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
    // $ANTLR end "rule__Dimension__Group_1__1__Impl"


    // $ANTLR start "rule__Dimension__Group_2__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2560:1: rule__Dimension__Group_2__0 : rule__Dimension__Group_2__0__Impl rule__Dimension__Group_2__1 ;
    public final void rule__Dimension__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2564:1: ( rule__Dimension__Group_2__0__Impl rule__Dimension__Group_2__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2565:2: rule__Dimension__Group_2__0__Impl rule__Dimension__Group_2__1
            {
            pushFollow(FOLLOW_rule__Dimension__Group_2__0__Impl_in_rule__Dimension__Group_2__05359);
            rule__Dimension__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Dimension__Group_2__1_in_rule__Dimension__Group_2__05362);
            rule__Dimension__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Dimension__Group_2__0"


    // $ANTLR start "rule__Dimension__Group_2__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2572:1: rule__Dimension__Group_2__0__Impl : ( () ) ;
    public final void rule__Dimension__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2576:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2577:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2577:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2578:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getIdDimensionAction_2_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2579:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2581:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDimensionAccess().getIdDimensionAction_2_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Dimension__Group_2__0__Impl"


    // $ANTLR start "rule__Dimension__Group_2__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2591:1: rule__Dimension__Group_2__1 : rule__Dimension__Group_2__1__Impl ;
    public final void rule__Dimension__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2595:1: ( rule__Dimension__Group_2__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2596:2: rule__Dimension__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Dimension__Group_2__1__Impl_in_rule__Dimension__Group_2__15420);
            rule__Dimension__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Dimension__Group_2__1"


    // $ANTLR start "rule__Dimension__Group_2__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2602:1: rule__Dimension__Group_2__1__Impl : ( ( rule__Dimension__IndexAssignment_2_1 ) ) ;
    public final void rule__Dimension__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2606:1: ( ( ( rule__Dimension__IndexAssignment_2_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2607:1: ( ( rule__Dimension__IndexAssignment_2_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2607:1: ( ( rule__Dimension__IndexAssignment_2_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2608:1: ( rule__Dimension__IndexAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getIndexAssignment_2_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2609:1: ( rule__Dimension__IndexAssignment_2_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2609:2: rule__Dimension__IndexAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Dimension__IndexAssignment_2_1_in_rule__Dimension__Group_2__1__Impl5447);
            rule__Dimension__IndexAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDimensionAccess().getIndexAssignment_2_1()); 
            }

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
    // $ANTLR end "rule__Dimension__Group_2__1__Impl"


    // $ANTLR start "rule__Type__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2623:1: rule__Type__Group__0 : rule__Type__Group__0__Impl rule__Type__Group__1 ;
    public final void rule__Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2627:1: ( rule__Type__Group__0__Impl rule__Type__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2628:2: rule__Type__Group__0__Impl rule__Type__Group__1
            {
            pushFollow(FOLLOW_rule__Type__Group__0__Impl_in_rule__Type__Group__05481);
            rule__Type__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Type__Group__1_in_rule__Type__Group__05484);
            rule__Type__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2635:1: rule__Type__Group__0__Impl : ( ( rule__Type__SignedAssignment_0 )? ) ;
    public final void rule__Type__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2639:1: ( ( ( rule__Type__SignedAssignment_0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2640:1: ( ( rule__Type__SignedAssignment_0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2640:1: ( ( rule__Type__SignedAssignment_0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2641:1: ( rule__Type__SignedAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getSignedAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2642:1: ( rule__Type__SignedAssignment_0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=27 && LA27_0<=28)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2642:2: rule__Type__SignedAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Type__SignedAssignment_0_in_rule__Type__Group__0__Impl5511);
                    rule__Type__SignedAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAccess().getSignedAssignment_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2652:1: rule__Type__Group__1 : rule__Type__Group__1__Impl ;
    public final void rule__Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2656:1: ( rule__Type__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2657:2: rule__Type__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Type__Group__1__Impl_in_rule__Type__Group__15542);
            rule__Type__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2663:1: rule__Type__Group__1__Impl : ( ( rule__Type__SimpTypeAssignment_1 ) ) ;
    public final void rule__Type__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2667:1: ( ( ( rule__Type__SimpTypeAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2668:1: ( ( rule__Type__SimpTypeAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2668:1: ( ( rule__Type__SimpTypeAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2669:1: ( rule__Type__SimpTypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getSimpTypeAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2670:1: ( rule__Type__SimpTypeAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2670:2: rule__Type__SimpTypeAssignment_1
            {
            pushFollow(FOLLOW_rule__Type__SimpTypeAssignment_1_in_rule__Type__Group__1__Impl5569);
            rule__Type__SimpTypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAccess().getSimpTypeAssignment_1()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2684:1: rule__ProcNoAttr__Group__0 : rule__ProcNoAttr__Group__0__Impl rule__ProcNoAttr__Group__1 ;
    public final void rule__ProcNoAttr__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2688:1: ( rule__ProcNoAttr__Group__0__Impl rule__ProcNoAttr__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2689:2: rule__ProcNoAttr__Group__0__Impl rule__ProcNoAttr__Group__1
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__Group__0__Impl_in_rule__ProcNoAttr__Group__05603);
            rule__ProcNoAttr__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ProcNoAttr__Group__1_in_rule__ProcNoAttr__Group__05606);
            rule__ProcNoAttr__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2696:1: rule__ProcNoAttr__Group__0__Impl : ( ( rule__ProcNoAttr__PrototypeAssignment_0 ) ) ;
    public final void rule__ProcNoAttr__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2700:1: ( ( ( rule__ProcNoAttr__PrototypeAssignment_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2701:1: ( ( rule__ProcNoAttr__PrototypeAssignment_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2701:1: ( ( rule__ProcNoAttr__PrototypeAssignment_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2702:1: ( rule__ProcNoAttr__PrototypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProcNoAttrAccess().getPrototypeAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2703:1: ( rule__ProcNoAttr__PrototypeAssignment_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2703:2: rule__ProcNoAttr__PrototypeAssignment_0
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__PrototypeAssignment_0_in_rule__ProcNoAttr__Group__0__Impl5633);
            rule__ProcNoAttr__PrototypeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProcNoAttrAccess().getPrototypeAssignment_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2713:1: rule__ProcNoAttr__Group__1 : rule__ProcNoAttr__Group__1__Impl ;
    public final void rule__ProcNoAttr__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2717:1: ( rule__ProcNoAttr__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2718:2: rule__ProcNoAttr__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__Group__1__Impl_in_rule__ProcNoAttr__Group__15663);
            rule__ProcNoAttr__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2724:1: rule__ProcNoAttr__Group__1__Impl : ( ( rule__ProcNoAttr__Alternatives_1 ) ) ;
    public final void rule__ProcNoAttr__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2728:1: ( ( ( rule__ProcNoAttr__Alternatives_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2729:1: ( ( rule__ProcNoAttr__Alternatives_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2729:1: ( ( rule__ProcNoAttr__Alternatives_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2730:1: ( rule__ProcNoAttr__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProcNoAttrAccess().getAlternatives_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2731:1: ( rule__ProcNoAttr__Alternatives_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2731:2: rule__ProcNoAttr__Alternatives_1
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__Alternatives_1_in_rule__ProcNoAttr__Group__1__Impl5690);
            rule__ProcNoAttr__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getProcNoAttrAccess().getAlternatives_1()); 
            }

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


    // $ANTLR start "rule__FnBody__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2745:1: rule__FnBody__Group__0 : rule__FnBody__Group__0__Impl rule__FnBody__Group__1 ;
    public final void rule__FnBody__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2749:1: ( rule__FnBody__Group__0__Impl rule__FnBody__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2750:2: rule__FnBody__Group__0__Impl rule__FnBody__Group__1
            {
            pushFollow(FOLLOW_rule__FnBody__Group__0__Impl_in_rule__FnBody__Group__05724);
            rule__FnBody__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnBody__Group__1_in_rule__FnBody__Group__05727);
            rule__FnBody__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnBody__Group__0"


    // $ANTLR start "rule__FnBody__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2757:1: rule__FnBody__Group__0__Impl : ( '{' ) ;
    public final void rule__FnBody__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2761:1: ( ( '{' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2762:1: ( '{' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2762:1: ( '{' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2763:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnBodyAccess().getLeftCurlyBracketKeyword_0()); 
            }
            match(input,47,FOLLOW_47_in_rule__FnBody__Group__0__Impl5755); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnBodyAccess().getLeftCurlyBracketKeyword_0()); 
            }

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
    // $ANTLR end "rule__FnBody__Group__0__Impl"


    // $ANTLR start "rule__FnBody__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2776:1: rule__FnBody__Group__1 : rule__FnBody__Group__1__Impl rule__FnBody__Group__2 ;
    public final void rule__FnBody__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2780:1: ( rule__FnBody__Group__1__Impl rule__FnBody__Group__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2781:2: rule__FnBody__Group__1__Impl rule__FnBody__Group__2
            {
            pushFollow(FOLLOW_rule__FnBody__Group__1__Impl_in_rule__FnBody__Group__15786);
            rule__FnBody__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnBody__Group__2_in_rule__FnBody__Group__15789);
            rule__FnBody__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnBody__Group__1"


    // $ANTLR start "rule__FnBody__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2788:1: rule__FnBody__Group__1__Impl : ( ( rule__FnBody__VarInitListAssignment_1 ) ) ;
    public final void rule__FnBody__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2792:1: ( ( ( rule__FnBody__VarInitListAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2793:1: ( ( rule__FnBody__VarInitListAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2793:1: ( ( rule__FnBody__VarInitListAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2794:1: ( rule__FnBody__VarInitListAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnBodyAccess().getVarInitListAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2795:1: ( rule__FnBody__VarInitListAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2795:2: rule__FnBody__VarInitListAssignment_1
            {
            pushFollow(FOLLOW_rule__FnBody__VarInitListAssignment_1_in_rule__FnBody__Group__1__Impl5816);
            rule__FnBody__VarInitListAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnBodyAccess().getVarInitListAssignment_1()); 
            }

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
    // $ANTLR end "rule__FnBody__Group__1__Impl"


    // $ANTLR start "rule__FnBody__Group__2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2805:1: rule__FnBody__Group__2 : rule__FnBody__Group__2__Impl ;
    public final void rule__FnBody__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2809:1: ( rule__FnBody__Group__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2810:2: rule__FnBody__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__FnBody__Group__2__Impl_in_rule__FnBody__Group__25846);
            rule__FnBody__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnBody__Group__2"


    // $ANTLR start "rule__FnBody__Group__2__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2816:1: rule__FnBody__Group__2__Impl : ( '}' ) ;
    public final void rule__FnBody__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2820:1: ( ( '}' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2821:1: ( '}' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2821:1: ( '}' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2822:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnBodyAccess().getRightCurlyBracketKeyword_2()); 
            }
            match(input,48,FOLLOW_48_in_rule__FnBody__Group__2__Impl5874); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnBodyAccess().getRightCurlyBracketKeyword_2()); 
            }

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
    // $ANTLR end "rule__FnBody__Group__2__Impl"


    // $ANTLR start "rule__FnPrototype__Group_0__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2841:1: rule__FnPrototype__Group_0__0 : rule__FnPrototype__Group_0__0__Impl rule__FnPrototype__Group_0__1 ;
    public final void rule__FnPrototype__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2845:1: ( rule__FnPrototype__Group_0__0__Impl rule__FnPrototype__Group_0__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2846:2: rule__FnPrototype__Group_0__0__Impl rule__FnPrototype__Group_0__1
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__0__Impl_in_rule__FnPrototype__Group_0__05911);
            rule__FnPrototype__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__1_in_rule__FnPrototype__Group_0__05914);
            rule__FnPrototype__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_0__0"


    // $ANTLR start "rule__FnPrototype__Group_0__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2853:1: rule__FnPrototype__Group_0__0__Impl : ( () ) ;
    public final void rule__FnPrototype__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2857:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2858:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2858:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2859:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getThreadDeclarationAction_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2860:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2862:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getThreadDeclarationAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototype__Group_0__0__Impl"


    // $ANTLR start "rule__FnPrototype__Group_0__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2872:1: rule__FnPrototype__Group_0__1 : rule__FnPrototype__Group_0__1__Impl rule__FnPrototype__Group_0__2 ;
    public final void rule__FnPrototype__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2876:1: ( rule__FnPrototype__Group_0__1__Impl rule__FnPrototype__Group_0__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2877:2: rule__FnPrototype__Group_0__1__Impl rule__FnPrototype__Group_0__2
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__1__Impl_in_rule__FnPrototype__Group_0__15972);
            rule__FnPrototype__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__2_in_rule__FnPrototype__Group_0__15975);
            rule__FnPrototype__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_0__1"


    // $ANTLR start "rule__FnPrototype__Group_0__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2884:1: rule__FnPrototype__Group_0__1__Impl : ( ( rule__FnPrototype__ExternAssignment_0_1 )? ) ;
    public final void rule__FnPrototype__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2888:1: ( ( ( rule__FnPrototype__ExternAssignment_0_1 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2889:1: ( ( rule__FnPrototype__ExternAssignment_0_1 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2889:1: ( ( rule__FnPrototype__ExternAssignment_0_1 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2890:1: ( rule__FnPrototype__ExternAssignment_0_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getExternAssignment_0_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2891:1: ( rule__FnPrototype__ExternAssignment_0_1 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=15 && LA28_0<=16)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2891:2: rule__FnPrototype__ExternAssignment_0_1
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__ExternAssignment_0_1_in_rule__FnPrototype__Group_0__1__Impl6002);
                    rule__FnPrototype__ExternAssignment_0_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getExternAssignment_0_1()); 
            }

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
    // $ANTLR end "rule__FnPrototype__Group_0__1__Impl"


    // $ANTLR start "rule__FnPrototype__Group_0__2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2901:1: rule__FnPrototype__Group_0__2 : rule__FnPrototype__Group_0__2__Impl rule__FnPrototype__Group_0__3 ;
    public final void rule__FnPrototype__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2905:1: ( rule__FnPrototype__Group_0__2__Impl rule__FnPrototype__Group_0__3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2906:2: rule__FnPrototype__Group_0__2__Impl rule__FnPrototype__Group_0__3
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__2__Impl_in_rule__FnPrototype__Group_0__26033);
            rule__FnPrototype__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__3_in_rule__FnPrototype__Group_0__26036);
            rule__FnPrototype__Group_0__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_0__2"


    // $ANTLR start "rule__FnPrototype__Group_0__2__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2913:1: rule__FnPrototype__Group_0__2__Impl : ( ( rule__FnPrototype__PureAssignment_0_2 )? ) ;
    public final void rule__FnPrototype__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2917:1: ( ( ( rule__FnPrototype__PureAssignment_0_2 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2918:1: ( ( rule__FnPrototype__PureAssignment_0_2 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2918:1: ( ( rule__FnPrototype__PureAssignment_0_2 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2919:1: ( rule__FnPrototype__PureAssignment_0_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getPureAssignment_0_2()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2920:1: ( rule__FnPrototype__PureAssignment_0_2 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=17 && LA29_0<=18)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2920:2: rule__FnPrototype__PureAssignment_0_2
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__PureAssignment_0_2_in_rule__FnPrototype__Group_0__2__Impl6063);
                    rule__FnPrototype__PureAssignment_0_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getPureAssignment_0_2()); 
            }

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
    // $ANTLR end "rule__FnPrototype__Group_0__2__Impl"


    // $ANTLR start "rule__FnPrototype__Group_0__3"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2930:1: rule__FnPrototype__Group_0__3 : rule__FnPrototype__Group_0__3__Impl rule__FnPrototype__Group_0__4 ;
    public final void rule__FnPrototype__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2934:1: ( rule__FnPrototype__Group_0__3__Impl rule__FnPrototype__Group_0__4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2935:2: rule__FnPrototype__Group_0__3__Impl rule__FnPrototype__Group_0__4
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__3__Impl_in_rule__FnPrototype__Group_0__36094);
            rule__FnPrototype__Group_0__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__4_in_rule__FnPrototype__Group_0__36097);
            rule__FnPrototype__Group_0__4();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_0__3"


    // $ANTLR start "rule__FnPrototype__Group_0__3__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2942:1: rule__FnPrototype__Group_0__3__Impl : ( 'thread' ) ;
    public final void rule__FnPrototype__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2946:1: ( ( 'thread' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2947:1: ( 'thread' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2947:1: ( 'thread' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2948:1: 'thread'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getThreadKeyword_0_3()); 
            }
            match(input,49,FOLLOW_49_in_rule__FnPrototype__Group_0__3__Impl6125); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getThreadKeyword_0_3()); 
            }

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
    // $ANTLR end "rule__FnPrototype__Group_0__3__Impl"


    // $ANTLR start "rule__FnPrototype__Group_0__4"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2961:1: rule__FnPrototype__Group_0__4 : rule__FnPrototype__Group_0__4__Impl ;
    public final void rule__FnPrototype__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2965:1: ( rule__FnPrototype__Group_0__4__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2966:2: rule__FnPrototype__Group_0__4__Impl
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__4__Impl_in_rule__FnPrototype__Group_0__46156);
            rule__FnPrototype__Group_0__4__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_0__4"


    // $ANTLR start "rule__FnPrototype__Group_0__4__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2972:1: rule__FnPrototype__Group_0__4__Impl : ( ( rule__FnPrototype__NameAssignment_0_4 ) ) ;
    public final void rule__FnPrototype__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2976:1: ( ( ( rule__FnPrototype__NameAssignment_0_4 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2977:1: ( ( rule__FnPrototype__NameAssignment_0_4 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2977:1: ( ( rule__FnPrototype__NameAssignment_0_4 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2978:1: ( rule__FnPrototype__NameAssignment_0_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getNameAssignment_0_4()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2979:1: ( rule__FnPrototype__NameAssignment_0_4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2979:2: rule__FnPrototype__NameAssignment_0_4
            {
            pushFollow(FOLLOW_rule__FnPrototype__NameAssignment_0_4_in_rule__FnPrototype__Group_0__4__Impl6183);
            rule__FnPrototype__NameAssignment_0_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getNameAssignment_0_4()); 
            }

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
    // $ANTLR end "rule__FnPrototype__Group_0__4__Impl"


    // $ANTLR start "rule__FnPrototype__Group_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2999:1: rule__FnPrototype__Group_1__0 : rule__FnPrototype__Group_1__0__Impl rule__FnPrototype__Group_1__1 ;
    public final void rule__FnPrototype__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3003:1: ( rule__FnPrototype__Group_1__0__Impl rule__FnPrototype__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3004:2: rule__FnPrototype__Group_1__0__Impl rule__FnPrototype__Group_1__1
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__0__Impl_in_rule__FnPrototype__Group_1__06223);
            rule__FnPrototype__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__1_in_rule__FnPrototype__Group_1__06226);
            rule__FnPrototype__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_1__0"


    // $ANTLR start "rule__FnPrototype__Group_1__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3011:1: rule__FnPrototype__Group_1__0__Impl : ( () ) ;
    public final void rule__FnPrototype__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3015:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3016:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3016:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3017:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getFnPrototypeDeclarationAction_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3018:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3020:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getFnPrototypeDeclarationAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FnPrototype__Group_1__0__Impl"


    // $ANTLR start "rule__FnPrototype__Group_1__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3030:1: rule__FnPrototype__Group_1__1 : rule__FnPrototype__Group_1__1__Impl rule__FnPrototype__Group_1__2 ;
    public final void rule__FnPrototype__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3034:1: ( rule__FnPrototype__Group_1__1__Impl rule__FnPrototype__Group_1__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3035:2: rule__FnPrototype__Group_1__1__Impl rule__FnPrototype__Group_1__2
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__1__Impl_in_rule__FnPrototype__Group_1__16284);
            rule__FnPrototype__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__2_in_rule__FnPrototype__Group_1__16287);
            rule__FnPrototype__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_1__1"


    // $ANTLR start "rule__FnPrototype__Group_1__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3042:1: rule__FnPrototype__Group_1__1__Impl : ( ( rule__FnPrototype__ExternAssignment_1_1 )? ) ;
    public final void rule__FnPrototype__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3046:1: ( ( ( rule__FnPrototype__ExternAssignment_1_1 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3047:1: ( ( rule__FnPrototype__ExternAssignment_1_1 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3047:1: ( ( rule__FnPrototype__ExternAssignment_1_1 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3048:1: ( rule__FnPrototype__ExternAssignment_1_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getExternAssignment_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3049:1: ( rule__FnPrototype__ExternAssignment_1_1 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=15 && LA30_0<=16)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3049:2: rule__FnPrototype__ExternAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__ExternAssignment_1_1_in_rule__FnPrototype__Group_1__1__Impl6314);
                    rule__FnPrototype__ExternAssignment_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getExternAssignment_1_1()); 
            }

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
    // $ANTLR end "rule__FnPrototype__Group_1__1__Impl"


    // $ANTLR start "rule__FnPrototype__Group_1__2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3059:1: rule__FnPrototype__Group_1__2 : rule__FnPrototype__Group_1__2__Impl rule__FnPrototype__Group_1__3 ;
    public final void rule__FnPrototype__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3063:1: ( rule__FnPrototype__Group_1__2__Impl rule__FnPrototype__Group_1__3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3064:2: rule__FnPrototype__Group_1__2__Impl rule__FnPrototype__Group_1__3
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__2__Impl_in_rule__FnPrototype__Group_1__26345);
            rule__FnPrototype__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__3_in_rule__FnPrototype__Group_1__26348);
            rule__FnPrototype__Group_1__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_1__2"


    // $ANTLR start "rule__FnPrototype__Group_1__2__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3071:1: rule__FnPrototype__Group_1__2__Impl : ( ( rule__FnPrototype__PureAssignment_1_2 )? ) ;
    public final void rule__FnPrototype__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3075:1: ( ( ( rule__FnPrototype__PureAssignment_1_2 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3076:1: ( ( rule__FnPrototype__PureAssignment_1_2 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3076:1: ( ( rule__FnPrototype__PureAssignment_1_2 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3077:1: ( rule__FnPrototype__PureAssignment_1_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getPureAssignment_1_2()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3078:1: ( rule__FnPrototype__PureAssignment_1_2 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=17 && LA31_0<=18)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3078:2: rule__FnPrototype__PureAssignment_1_2
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__PureAssignment_1_2_in_rule__FnPrototype__Group_1__2__Impl6375);
                    rule__FnPrototype__PureAssignment_1_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getPureAssignment_1_2()); 
            }

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
    // $ANTLR end "rule__FnPrototype__Group_1__2__Impl"


    // $ANTLR start "rule__FnPrototype__Group_1__3"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3088:1: rule__FnPrototype__Group_1__3 : rule__FnPrototype__Group_1__3__Impl rule__FnPrototype__Group_1__4 ;
    public final void rule__FnPrototype__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3092:1: ( rule__FnPrototype__Group_1__3__Impl rule__FnPrototype__Group_1__4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3093:2: rule__FnPrototype__Group_1__3__Impl rule__FnPrototype__Group_1__4
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__3__Impl_in_rule__FnPrototype__Group_1__36406);
            rule__FnPrototype__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__4_in_rule__FnPrototype__Group_1__36409);
            rule__FnPrototype__Group_1__4();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_1__3"


    // $ANTLR start "rule__FnPrototype__Group_1__3__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3100:1: rule__FnPrototype__Group_1__3__Impl : ( ( rule__FnPrototype__TypeAssignment_1_3 ) ) ;
    public final void rule__FnPrototype__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3104:1: ( ( ( rule__FnPrototype__TypeAssignment_1_3 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3105:1: ( ( rule__FnPrototype__TypeAssignment_1_3 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3105:1: ( ( rule__FnPrototype__TypeAssignment_1_3 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3106:1: ( rule__FnPrototype__TypeAssignment_1_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getTypeAssignment_1_3()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3107:1: ( rule__FnPrototype__TypeAssignment_1_3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3107:2: rule__FnPrototype__TypeAssignment_1_3
            {
            pushFollow(FOLLOW_rule__FnPrototype__TypeAssignment_1_3_in_rule__FnPrototype__Group_1__3__Impl6436);
            rule__FnPrototype__TypeAssignment_1_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getTypeAssignment_1_3()); 
            }

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
    // $ANTLR end "rule__FnPrototype__Group_1__3__Impl"


    // $ANTLR start "rule__FnPrototype__Group_1__4"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3117:1: rule__FnPrototype__Group_1__4 : rule__FnPrototype__Group_1__4__Impl rule__FnPrototype__Group_1__5 ;
    public final void rule__FnPrototype__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3121:1: ( rule__FnPrototype__Group_1__4__Impl rule__FnPrototype__Group_1__5 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3122:2: rule__FnPrototype__Group_1__4__Impl rule__FnPrototype__Group_1__5
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__4__Impl_in_rule__FnPrototype__Group_1__46466);
            rule__FnPrototype__Group_1__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__5_in_rule__FnPrototype__Group_1__46469);
            rule__FnPrototype__Group_1__5();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_1__4"


    // $ANTLR start "rule__FnPrototype__Group_1__4__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3129:1: rule__FnPrototype__Group_1__4__Impl : ( ( rule__FnPrototype__NameAssignment_1_4 ) ) ;
    public final void rule__FnPrototype__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3133:1: ( ( ( rule__FnPrototype__NameAssignment_1_4 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3134:1: ( ( rule__FnPrototype__NameAssignment_1_4 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3134:1: ( ( rule__FnPrototype__NameAssignment_1_4 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3135:1: ( rule__FnPrototype__NameAssignment_1_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getNameAssignment_1_4()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3136:1: ( rule__FnPrototype__NameAssignment_1_4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3136:2: rule__FnPrototype__NameAssignment_1_4
            {
            pushFollow(FOLLOW_rule__FnPrototype__NameAssignment_1_4_in_rule__FnPrototype__Group_1__4__Impl6496);
            rule__FnPrototype__NameAssignment_1_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getNameAssignment_1_4()); 
            }

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
    // $ANTLR end "rule__FnPrototype__Group_1__4__Impl"


    // $ANTLR start "rule__FnPrototype__Group_1__5"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3146:1: rule__FnPrototype__Group_1__5 : rule__FnPrototype__Group_1__5__Impl rule__FnPrototype__Group_1__6 ;
    public final void rule__FnPrototype__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3150:1: ( rule__FnPrototype__Group_1__5__Impl rule__FnPrototype__Group_1__6 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3151:2: rule__FnPrototype__Group_1__5__Impl rule__FnPrototype__Group_1__6
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__5__Impl_in_rule__FnPrototype__Group_1__56526);
            rule__FnPrototype__Group_1__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__6_in_rule__FnPrototype__Group_1__56529);
            rule__FnPrototype__Group_1__6();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_1__5"


    // $ANTLR start "rule__FnPrototype__Group_1__5__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3158:1: rule__FnPrototype__Group_1__5__Impl : ( '(' ) ;
    public final void rule__FnPrototype__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3162:1: ( ( '(' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3163:1: ( '(' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3163:1: ( '(' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3164:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getLeftParenthesisKeyword_1_5()); 
            }
            match(input,50,FOLLOW_50_in_rule__FnPrototype__Group_1__5__Impl6557); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getLeftParenthesisKeyword_1_5()); 
            }

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
    // $ANTLR end "rule__FnPrototype__Group_1__5__Impl"


    // $ANTLR start "rule__FnPrototype__Group_1__6"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3177:1: rule__FnPrototype__Group_1__6 : rule__FnPrototype__Group_1__6__Impl rule__FnPrototype__Group_1__7 ;
    public final void rule__FnPrototype__Group_1__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3181:1: ( rule__FnPrototype__Group_1__6__Impl rule__FnPrototype__Group_1__7 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3182:2: rule__FnPrototype__Group_1__6__Impl rule__FnPrototype__Group_1__7
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__6__Impl_in_rule__FnPrototype__Group_1__66588);
            rule__FnPrototype__Group_1__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__7_in_rule__FnPrototype__Group_1__66591);
            rule__FnPrototype__Group_1__7();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_1__6"


    // $ANTLR start "rule__FnPrototype__Group_1__6__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3189:1: rule__FnPrototype__Group_1__6__Impl : ( ( rule__FnPrototype__Group_1_6__0 )? ) ;
    public final void rule__FnPrototype__Group_1__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3193:1: ( ( ( rule__FnPrototype__Group_1_6__0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3194:1: ( ( rule__FnPrototype__Group_1_6__0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3194:1: ( ( rule__FnPrototype__Group_1_6__0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3195:1: ( rule__FnPrototype__Group_1_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getGroup_1_6()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3196:1: ( rule__FnPrototype__Group_1_6__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=21 && LA32_0<=28)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3196:2: rule__FnPrototype__Group_1_6__0
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__Group_1_6__0_in_rule__FnPrototype__Group_1__6__Impl6618);
                    rule__FnPrototype__Group_1_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getGroup_1_6()); 
            }

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
    // $ANTLR end "rule__FnPrototype__Group_1__6__Impl"


    // $ANTLR start "rule__FnPrototype__Group_1__7"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3206:1: rule__FnPrototype__Group_1__7 : rule__FnPrototype__Group_1__7__Impl ;
    public final void rule__FnPrototype__Group_1__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3210:1: ( rule__FnPrototype__Group_1__7__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3211:2: rule__FnPrototype__Group_1__7__Impl
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__7__Impl_in_rule__FnPrototype__Group_1__76649);
            rule__FnPrototype__Group_1__7__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_1__7"


    // $ANTLR start "rule__FnPrototype__Group_1__7__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3217:1: rule__FnPrototype__Group_1__7__Impl : ( ')' ) ;
    public final void rule__FnPrototype__Group_1__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3221:1: ( ( ')' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3222:1: ( ')' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3222:1: ( ')' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3223:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getRightParenthesisKeyword_1_7()); 
            }
            match(input,51,FOLLOW_51_in_rule__FnPrototype__Group_1__7__Impl6677); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getRightParenthesisKeyword_1_7()); 
            }

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
    // $ANTLR end "rule__FnPrototype__Group_1__7__Impl"


    // $ANTLR start "rule__FnPrototype__Group_1_6__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3252:1: rule__FnPrototype__Group_1_6__0 : rule__FnPrototype__Group_1_6__0__Impl rule__FnPrototype__Group_1_6__1 ;
    public final void rule__FnPrototype__Group_1_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3256:1: ( rule__FnPrototype__Group_1_6__0__Impl rule__FnPrototype__Group_1_6__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3257:2: rule__FnPrototype__Group_1_6__0__Impl rule__FnPrototype__Group_1_6__1
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1_6__0__Impl_in_rule__FnPrototype__Group_1_6__06724);
            rule__FnPrototype__Group_1_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1_6__1_in_rule__FnPrototype__Group_1_6__06727);
            rule__FnPrototype__Group_1_6__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_1_6__0"


    // $ANTLR start "rule__FnPrototype__Group_1_6__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3264:1: rule__FnPrototype__Group_1_6__0__Impl : ( ( rule__FnPrototype__ParamsAssignment_1_6_0 ) ) ;
    public final void rule__FnPrototype__Group_1_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3268:1: ( ( ( rule__FnPrototype__ParamsAssignment_1_6_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3269:1: ( ( rule__FnPrototype__ParamsAssignment_1_6_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3269:1: ( ( rule__FnPrototype__ParamsAssignment_1_6_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3270:1: ( rule__FnPrototype__ParamsAssignment_1_6_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getParamsAssignment_1_6_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3271:1: ( rule__FnPrototype__ParamsAssignment_1_6_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3271:2: rule__FnPrototype__ParamsAssignment_1_6_0
            {
            pushFollow(FOLLOW_rule__FnPrototype__ParamsAssignment_1_6_0_in_rule__FnPrototype__Group_1_6__0__Impl6754);
            rule__FnPrototype__ParamsAssignment_1_6_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getParamsAssignment_1_6_0()); 
            }

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
    // $ANTLR end "rule__FnPrototype__Group_1_6__0__Impl"


    // $ANTLR start "rule__FnPrototype__Group_1_6__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3281:1: rule__FnPrototype__Group_1_6__1 : rule__FnPrototype__Group_1_6__1__Impl ;
    public final void rule__FnPrototype__Group_1_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3285:1: ( rule__FnPrototype__Group_1_6__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3286:2: rule__FnPrototype__Group_1_6__1__Impl
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1_6__1__Impl_in_rule__FnPrototype__Group_1_6__16784);
            rule__FnPrototype__Group_1_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_1_6__1"


    // $ANTLR start "rule__FnPrototype__Group_1_6__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3292:1: rule__FnPrototype__Group_1_6__1__Impl : ( ( rule__FnPrototype__Group_1_6_1__0 )* ) ;
    public final void rule__FnPrototype__Group_1_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3296:1: ( ( ( rule__FnPrototype__Group_1_6_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3297:1: ( ( rule__FnPrototype__Group_1_6_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3297:1: ( ( rule__FnPrototype__Group_1_6_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3298:1: ( rule__FnPrototype__Group_1_6_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getGroup_1_6_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3299:1: ( rule__FnPrototype__Group_1_6_1__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==52) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3299:2: rule__FnPrototype__Group_1_6_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FnPrototype__Group_1_6_1__0_in_rule__FnPrototype__Group_1_6__1__Impl6811);
            	    rule__FnPrototype__Group_1_6_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getGroup_1_6_1()); 
            }

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
    // $ANTLR end "rule__FnPrototype__Group_1_6__1__Impl"


    // $ANTLR start "rule__FnPrototype__Group_1_6_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3313:1: rule__FnPrototype__Group_1_6_1__0 : rule__FnPrototype__Group_1_6_1__0__Impl rule__FnPrototype__Group_1_6_1__1 ;
    public final void rule__FnPrototype__Group_1_6_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3317:1: ( rule__FnPrototype__Group_1_6_1__0__Impl rule__FnPrototype__Group_1_6_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3318:2: rule__FnPrototype__Group_1_6_1__0__Impl rule__FnPrototype__Group_1_6_1__1
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1_6_1__0__Impl_in_rule__FnPrototype__Group_1_6_1__06846);
            rule__FnPrototype__Group_1_6_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1_6_1__1_in_rule__FnPrototype__Group_1_6_1__06849);
            rule__FnPrototype__Group_1_6_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_1_6_1__0"


    // $ANTLR start "rule__FnPrototype__Group_1_6_1__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3325:1: rule__FnPrototype__Group_1_6_1__0__Impl : ( ',' ) ;
    public final void rule__FnPrototype__Group_1_6_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3329:1: ( ( ',' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3330:1: ( ',' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3330:1: ( ',' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3331:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getCommaKeyword_1_6_1_0()); 
            }
            match(input,52,FOLLOW_52_in_rule__FnPrototype__Group_1_6_1__0__Impl6877); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getCommaKeyword_1_6_1_0()); 
            }

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
    // $ANTLR end "rule__FnPrototype__Group_1_6_1__0__Impl"


    // $ANTLR start "rule__FnPrototype__Group_1_6_1__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3344:1: rule__FnPrototype__Group_1_6_1__1 : rule__FnPrototype__Group_1_6_1__1__Impl ;
    public final void rule__FnPrototype__Group_1_6_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3348:1: ( rule__FnPrototype__Group_1_6_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3349:2: rule__FnPrototype__Group_1_6_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1_6_1__1__Impl_in_rule__FnPrototype__Group_1_6_1__16908);
            rule__FnPrototype__Group_1_6_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__FnPrototype__Group_1_6_1__1"


    // $ANTLR start "rule__FnPrototype__Group_1_6_1__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3355:1: rule__FnPrototype__Group_1_6_1__1__Impl : ( ( rule__FnPrototype__ParamsAssignment_1_6_1_1 ) ) ;
    public final void rule__FnPrototype__Group_1_6_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3359:1: ( ( ( rule__FnPrototype__ParamsAssignment_1_6_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3360:1: ( ( rule__FnPrototype__ParamsAssignment_1_6_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3360:1: ( ( rule__FnPrototype__ParamsAssignment_1_6_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3361:1: ( rule__FnPrototype__ParamsAssignment_1_6_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getParamsAssignment_1_6_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3362:1: ( rule__FnPrototype__ParamsAssignment_1_6_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3362:2: rule__FnPrototype__ParamsAssignment_1_6_1_1
            {
            pushFollow(FOLLOW_rule__FnPrototype__ParamsAssignment_1_6_1_1_in_rule__FnPrototype__Group_1_6_1__1__Impl6935);
            rule__FnPrototype__ParamsAssignment_1_6_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getParamsAssignment_1_6_1_1()); 
            }

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
    // $ANTLR end "rule__FnPrototype__Group_1_6_1__1__Impl"


    // $ANTLR start "rule__Param__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3376:1: rule__Param__Group__0 : rule__Param__Group__0__Impl rule__Param__Group__1 ;
    public final void rule__Param__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3380:1: ( rule__Param__Group__0__Impl rule__Param__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3381:2: rule__Param__Group__0__Impl rule__Param__Group__1
            {
            pushFollow(FOLLOW_rule__Param__Group__0__Impl_in_rule__Param__Group__06969);
            rule__Param__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Param__Group__1_in_rule__Param__Group__06972);
            rule__Param__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Param__Group__0"


    // $ANTLR start "rule__Param__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3388:1: rule__Param__Group__0__Impl : ( ( rule__Param__TypeAssignment_0 ) ) ;
    public final void rule__Param__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3392:1: ( ( ( rule__Param__TypeAssignment_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3393:1: ( ( rule__Param__TypeAssignment_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3393:1: ( ( rule__Param__TypeAssignment_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3394:1: ( rule__Param__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAccess().getTypeAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3395:1: ( rule__Param__TypeAssignment_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3395:2: rule__Param__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__Param__TypeAssignment_0_in_rule__Param__Group__0__Impl6999);
            rule__Param__TypeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamAccess().getTypeAssignment_0()); 
            }

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
    // $ANTLR end "rule__Param__Group__0__Impl"


    // $ANTLR start "rule__Param__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3405:1: rule__Param__Group__1 : rule__Param__Group__1__Impl ;
    public final void rule__Param__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3409:1: ( rule__Param__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3410:2: rule__Param__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Param__Group__1__Impl_in_rule__Param__Group__17029);
            rule__Param__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Param__Group__1"


    // $ANTLR start "rule__Param__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3416:1: rule__Param__Group__1__Impl : ( ( rule__Param__VarAssignment_1 ) ) ;
    public final void rule__Param__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3420:1: ( ( ( rule__Param__VarAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3421:1: ( ( rule__Param__VarAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3421:1: ( ( rule__Param__VarAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3422:1: ( rule__Param__VarAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAccess().getVarAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3423:1: ( rule__Param__VarAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3423:2: rule__Param__VarAssignment_1
            {
            pushFollow(FOLLOW_rule__Param__VarAssignment_1_in_rule__Param__Group__1__Impl7056);
            rule__Param__VarAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamAccess().getVarAssignment_1()); 
            }

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
    // $ANTLR end "rule__Param__Group__1__Impl"


    // $ANTLR start "rule__VarInitList__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3437:1: rule__VarInitList__Group__0 : rule__VarInitList__Group__0__Impl rule__VarInitList__Group__1 ;
    public final void rule__VarInitList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3441:1: ( rule__VarInitList__Group__0__Impl rule__VarInitList__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3442:2: rule__VarInitList__Group__0__Impl rule__VarInitList__Group__1
            {
            pushFollow(FOLLOW_rule__VarInitList__Group__0__Impl_in_rule__VarInitList__Group__07090);
            rule__VarInitList__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__VarInitList__Group__1_in_rule__VarInitList__Group__07093);
            rule__VarInitList__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__VarInitList__Group__0"


    // $ANTLR start "rule__VarInitList__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3449:1: rule__VarInitList__Group__0__Impl : ( () ) ;
    public final void rule__VarInitList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3453:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3454:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3454:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3455:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitListAccess().getVarInitListAction_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3456:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3458:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarInitListAccess().getVarInitListAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarInitList__Group__0__Impl"


    // $ANTLR start "rule__VarInitList__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3468:1: rule__VarInitList__Group__1 : rule__VarInitList__Group__1__Impl ;
    public final void rule__VarInitList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3472:1: ( rule__VarInitList__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3473:2: rule__VarInitList__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__VarInitList__Group__1__Impl_in_rule__VarInitList__Group__17151);
            rule__VarInitList__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__VarInitList__Group__1"


    // $ANTLR start "rule__VarInitList__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3479:1: rule__VarInitList__Group__1__Impl : ( ( rule__VarInitList__Group_1__0 )* ) ;
    public final void rule__VarInitList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3483:1: ( ( ( rule__VarInitList__Group_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3484:1: ( ( rule__VarInitList__Group_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3484:1: ( ( rule__VarInitList__Group_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3485:1: ( rule__VarInitList__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitListAccess().getGroup_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3486:1: ( rule__VarInitList__Group_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=21 && LA34_0<=28)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3486:2: rule__VarInitList__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__VarInitList__Group_1__0_in_rule__VarInitList__Group__1__Impl7178);
            	    rule__VarInitList__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarInitListAccess().getGroup_1()); 
            }

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
    // $ANTLR end "rule__VarInitList__Group__1__Impl"


    // $ANTLR start "rule__VarInitList__Group_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3500:1: rule__VarInitList__Group_1__0 : rule__VarInitList__Group_1__0__Impl rule__VarInitList__Group_1__1 ;
    public final void rule__VarInitList__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3504:1: ( rule__VarInitList__Group_1__0__Impl rule__VarInitList__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3505:2: rule__VarInitList__Group_1__0__Impl rule__VarInitList__Group_1__1
            {
            pushFollow(FOLLOW_rule__VarInitList__Group_1__0__Impl_in_rule__VarInitList__Group_1__07213);
            rule__VarInitList__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__VarInitList__Group_1__1_in_rule__VarInitList__Group_1__07216);
            rule__VarInitList__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__VarInitList__Group_1__0"


    // $ANTLR start "rule__VarInitList__Group_1__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3512:1: rule__VarInitList__Group_1__0__Impl : ( ( rule__VarInitList__VarInitsAssignment_1_0 ) ) ;
    public final void rule__VarInitList__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3516:1: ( ( ( rule__VarInitList__VarInitsAssignment_1_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3517:1: ( ( rule__VarInitList__VarInitsAssignment_1_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3517:1: ( ( rule__VarInitList__VarInitsAssignment_1_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3518:1: ( rule__VarInitList__VarInitsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitListAccess().getVarInitsAssignment_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3519:1: ( rule__VarInitList__VarInitsAssignment_1_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3519:2: rule__VarInitList__VarInitsAssignment_1_0
            {
            pushFollow(FOLLOW_rule__VarInitList__VarInitsAssignment_1_0_in_rule__VarInitList__Group_1__0__Impl7243);
            rule__VarInitList__VarInitsAssignment_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarInitListAccess().getVarInitsAssignment_1_0()); 
            }

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
    // $ANTLR end "rule__VarInitList__Group_1__0__Impl"


    // $ANTLR start "rule__VarInitList__Group_1__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3529:1: rule__VarInitList__Group_1__1 : rule__VarInitList__Group_1__1__Impl ;
    public final void rule__VarInitList__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3533:1: ( rule__VarInitList__Group_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3534:2: rule__VarInitList__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__VarInitList__Group_1__1__Impl_in_rule__VarInitList__Group_1__17273);
            rule__VarInitList__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__VarInitList__Group_1__1"


    // $ANTLR start "rule__VarInitList__Group_1__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3540:1: rule__VarInitList__Group_1__1__Impl : ( ';' ) ;
    public final void rule__VarInitList__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3544:1: ( ( ';' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3545:1: ( ';' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3545:1: ( ';' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3546:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitListAccess().getSemicolonKeyword_1_1()); 
            }
            match(input,14,FOLLOW_14_in_rule__VarInitList__Group_1__1__Impl7301); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarInitListAccess().getSemicolonKeyword_1_1()); 
            }

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
    // $ANTLR end "rule__VarInitList__Group_1__1__Impl"


    // $ANTLR start "rule__LVal__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3563:1: rule__LVal__Group__0 : rule__LVal__Group__0__Impl rule__LVal__Group__1 ;
    public final void rule__LVal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3567:1: ( rule__LVal__Group__0__Impl rule__LVal__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3568:2: rule__LVal__Group__0__Impl rule__LVal__Group__1
            {
            pushFollow(FOLLOW_rule__LVal__Group__0__Impl_in_rule__LVal__Group__07336);
            rule__LVal__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LVal__Group__1_in_rule__LVal__Group__07339);
            rule__LVal__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__LVal__Group__0"


    // $ANTLR start "rule__LVal__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3575:1: rule__LVal__Group__0__Impl : ( ( rule__LVal__NameAssignment_0 ) ) ;
    public final void rule__LVal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3579:1: ( ( ( rule__LVal__NameAssignment_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3580:1: ( ( rule__LVal__NameAssignment_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3580:1: ( ( rule__LVal__NameAssignment_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3581:1: ( rule__LVal__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getNameAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3582:1: ( rule__LVal__NameAssignment_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3582:2: rule__LVal__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__LVal__NameAssignment_0_in_rule__LVal__Group__0__Impl7366);
            rule__LVal__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLValAccess().getNameAssignment_0()); 
            }

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
    // $ANTLR end "rule__LVal__Group__0__Impl"


    // $ANTLR start "rule__LVal__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3592:1: rule__LVal__Group__1 : rule__LVal__Group__1__Impl rule__LVal__Group__2 ;
    public final void rule__LVal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3596:1: ( rule__LVal__Group__1__Impl rule__LVal__Group__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3597:2: rule__LVal__Group__1__Impl rule__LVal__Group__2
            {
            pushFollow(FOLLOW_rule__LVal__Group__1__Impl_in_rule__LVal__Group__17396);
            rule__LVal__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LVal__Group__2_in_rule__LVal__Group__17399);
            rule__LVal__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__LVal__Group__1"


    // $ANTLR start "rule__LVal__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3604:1: rule__LVal__Group__1__Impl : ( ( rule__LVal__Group_1__0 )* ) ;
    public final void rule__LVal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3608:1: ( ( ( rule__LVal__Group_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3609:1: ( ( rule__LVal__Group_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3609:1: ( ( rule__LVal__Group_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3610:1: ( rule__LVal__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getGroup_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3611:1: ( rule__LVal__Group_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==44) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3611:2: rule__LVal__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__LVal__Group_1__0_in_rule__LVal__Group__1__Impl7426);
            	    rule__LVal__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLValAccess().getGroup_1()); 
            }

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
    // $ANTLR end "rule__LVal__Group__1__Impl"


    // $ANTLR start "rule__LVal__Group__2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3621:1: rule__LVal__Group__2 : rule__LVal__Group__2__Impl ;
    public final void rule__LVal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3625:1: ( rule__LVal__Group__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3626:2: rule__LVal__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__LVal__Group__2__Impl_in_rule__LVal__Group__27457);
            rule__LVal__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__LVal__Group__2"


    // $ANTLR start "rule__LVal__Group__2__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3632:1: rule__LVal__Group__2__Impl : ( ( rule__LVal__Group_2__0 )? ) ;
    public final void rule__LVal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3636:1: ( ( ( rule__LVal__Group_2__0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3637:1: ( ( rule__LVal__Group_2__0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3637:1: ( ( rule__LVal__Group_2__0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3638:1: ( rule__LVal__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getGroup_2()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3639:1: ( rule__LVal__Group_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==53) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3639:2: rule__LVal__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__LVal__Group_2__0_in_rule__LVal__Group__2__Impl7484);
                    rule__LVal__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLValAccess().getGroup_2()); 
            }

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
    // $ANTLR end "rule__LVal__Group__2__Impl"


    // $ANTLR start "rule__LVal__Group_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3655:1: rule__LVal__Group_1__0 : rule__LVal__Group_1__0__Impl rule__LVal__Group_1__1 ;
    public final void rule__LVal__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3659:1: ( rule__LVal__Group_1__0__Impl rule__LVal__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3660:2: rule__LVal__Group_1__0__Impl rule__LVal__Group_1__1
            {
            pushFollow(FOLLOW_rule__LVal__Group_1__0__Impl_in_rule__LVal__Group_1__07521);
            rule__LVal__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LVal__Group_1__1_in_rule__LVal__Group_1__07524);
            rule__LVal__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__LVal__Group_1__0"


    // $ANTLR start "rule__LVal__Group_1__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3667:1: rule__LVal__Group_1__0__Impl : ( '[' ) ;
    public final void rule__LVal__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3671:1: ( ( '[' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3672:1: ( '[' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3672:1: ( '[' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3673:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getLeftSquareBracketKeyword_1_0()); 
            }
            match(input,44,FOLLOW_44_in_rule__LVal__Group_1__0__Impl7552); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLValAccess().getLeftSquareBracketKeyword_1_0()); 
            }

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
    // $ANTLR end "rule__LVal__Group_1__0__Impl"


    // $ANTLR start "rule__LVal__Group_1__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3686:1: rule__LVal__Group_1__1 : rule__LVal__Group_1__1__Impl rule__LVal__Group_1__2 ;
    public final void rule__LVal__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3690:1: ( rule__LVal__Group_1__1__Impl rule__LVal__Group_1__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3691:2: rule__LVal__Group_1__1__Impl rule__LVal__Group_1__2
            {
            pushFollow(FOLLOW_rule__LVal__Group_1__1__Impl_in_rule__LVal__Group_1__17583);
            rule__LVal__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LVal__Group_1__2_in_rule__LVal__Group_1__17586);
            rule__LVal__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__LVal__Group_1__1"


    // $ANTLR start "rule__LVal__Group_1__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3698:1: rule__LVal__Group_1__1__Impl : ( ( rule__LVal__IndicesAssignment_1_1 ) ) ;
    public final void rule__LVal__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3702:1: ( ( ( rule__LVal__IndicesAssignment_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3703:1: ( ( rule__LVal__IndicesAssignment_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3703:1: ( ( rule__LVal__IndicesAssignment_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3704:1: ( rule__LVal__IndicesAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getIndicesAssignment_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3705:1: ( rule__LVal__IndicesAssignment_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3705:2: rule__LVal__IndicesAssignment_1_1
            {
            pushFollow(FOLLOW_rule__LVal__IndicesAssignment_1_1_in_rule__LVal__Group_1__1__Impl7613);
            rule__LVal__IndicesAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLValAccess().getIndicesAssignment_1_1()); 
            }

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
    // $ANTLR end "rule__LVal__Group_1__1__Impl"


    // $ANTLR start "rule__LVal__Group_1__2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3715:1: rule__LVal__Group_1__2 : rule__LVal__Group_1__2__Impl ;
    public final void rule__LVal__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3719:1: ( rule__LVal__Group_1__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3720:2: rule__LVal__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__LVal__Group_1__2__Impl_in_rule__LVal__Group_1__27643);
            rule__LVal__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__LVal__Group_1__2"


    // $ANTLR start "rule__LVal__Group_1__2__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3726:1: rule__LVal__Group_1__2__Impl : ( ']' ) ;
    public final void rule__LVal__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3730:1: ( ( ']' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3731:1: ( ']' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3731:1: ( ']' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3732:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getRightSquareBracketKeyword_1_2()); 
            }
            match(input,45,FOLLOW_45_in_rule__LVal__Group_1__2__Impl7671); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLValAccess().getRightSquareBracketKeyword_1_2()); 
            }

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
    // $ANTLR end "rule__LVal__Group_1__2__Impl"


    // $ANTLR start "rule__LVal__Group_2__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3751:1: rule__LVal__Group_2__0 : rule__LVal__Group_2__0__Impl rule__LVal__Group_2__1 ;
    public final void rule__LVal__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3755:1: ( rule__LVal__Group_2__0__Impl rule__LVal__Group_2__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3756:2: rule__LVal__Group_2__0__Impl rule__LVal__Group_2__1
            {
            pushFollow(FOLLOW_rule__LVal__Group_2__0__Impl_in_rule__LVal__Group_2__07708);
            rule__LVal__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LVal__Group_2__1_in_rule__LVal__Group_2__07711);
            rule__LVal__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__LVal__Group_2__0"


    // $ANTLR start "rule__LVal__Group_2__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3763:1: rule__LVal__Group_2__0__Impl : ( '@' ) ;
    public final void rule__LVal__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3767:1: ( ( '@' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3768:1: ( '@' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3768:1: ( '@' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3769:1: '@'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getCommercialAtKeyword_2_0()); 
            }
            match(input,53,FOLLOW_53_in_rule__LVal__Group_2__0__Impl7739); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLValAccess().getCommercialAtKeyword_2_0()); 
            }

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
    // $ANTLR end "rule__LVal__Group_2__0__Impl"


    // $ANTLR start "rule__LVal__Group_2__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3782:1: rule__LVal__Group_2__1 : rule__LVal__Group_2__1__Impl ;
    public final void rule__LVal__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3786:1: ( rule__LVal__Group_2__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3787:2: rule__LVal__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__LVal__Group_2__1__Impl_in_rule__LVal__Group_2__17770);
            rule__LVal__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__LVal__Group_2__1"


    // $ANTLR start "rule__LVal__Group_2__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3793:1: rule__LVal__Group_2__1__Impl : ( ( rule__LVal__AtAssignment_2_1 ) ) ;
    public final void rule__LVal__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3797:1: ( ( ( rule__LVal__AtAssignment_2_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3798:1: ( ( rule__LVal__AtAssignment_2_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3798:1: ( ( rule__LVal__AtAssignment_2_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3799:1: ( rule__LVal__AtAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getAtAssignment_2_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3800:1: ( rule__LVal__AtAssignment_2_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3800:2: rule__LVal__AtAssignment_2_1
            {
            pushFollow(FOLLOW_rule__LVal__AtAssignment_2_1_in_rule__LVal__Group_2__1__Impl7797);
            rule__LVal__AtAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLValAccess().getAtAssignment_2_1()); 
            }

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
    // $ANTLR end "rule__LVal__Group_2__1__Impl"


    // $ANTLR start "rule__ShiftExpr__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3814:1: rule__ShiftExpr__Group__0 : rule__ShiftExpr__Group__0__Impl rule__ShiftExpr__Group__1 ;
    public final void rule__ShiftExpr__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3818:1: ( rule__ShiftExpr__Group__0__Impl rule__ShiftExpr__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3819:2: rule__ShiftExpr__Group__0__Impl rule__ShiftExpr__Group__1
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group__0__Impl_in_rule__ShiftExpr__Group__07831);
            rule__ShiftExpr__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ShiftExpr__Group__1_in_rule__ShiftExpr__Group__07834);
            rule__ShiftExpr__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ShiftExpr__Group__0"


    // $ANTLR start "rule__ShiftExpr__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3826:1: rule__ShiftExpr__Group__0__Impl : ( ruleAdditiveExpr ) ;
    public final void rule__ShiftExpr__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3830:1: ( ( ruleAdditiveExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3831:1: ( ruleAdditiveExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3831:1: ( ruleAdditiveExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3832:1: ruleAdditiveExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getAdditiveExprParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpr_in_rule__ShiftExpr__Group__0__Impl7861);
            ruleAdditiveExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExprAccess().getAdditiveExprParserRuleCall_0()); 
            }

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
    // $ANTLR end "rule__ShiftExpr__Group__0__Impl"


    // $ANTLR start "rule__ShiftExpr__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3843:1: rule__ShiftExpr__Group__1 : rule__ShiftExpr__Group__1__Impl ;
    public final void rule__ShiftExpr__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3847:1: ( rule__ShiftExpr__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3848:2: rule__ShiftExpr__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group__1__Impl_in_rule__ShiftExpr__Group__17890);
            rule__ShiftExpr__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ShiftExpr__Group__1"


    // $ANTLR start "rule__ShiftExpr__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3854:1: rule__ShiftExpr__Group__1__Impl : ( ( rule__ShiftExpr__Group_1__0 )* ) ;
    public final void rule__ShiftExpr__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3858:1: ( ( ( rule__ShiftExpr__Group_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3859:1: ( ( rule__ShiftExpr__Group_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3859:1: ( ( rule__ShiftExpr__Group_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3860:1: ( rule__ShiftExpr__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getGroup_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3861:1: ( rule__ShiftExpr__Group_1__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==36) ) {
                    int LA37_2 = input.LA(2);

                    if ( (synpred56_InternalDmpl()) ) {
                        alt37=1;
                    }


                }
                else if ( (LA37_0==37) ) {
                    int LA37_3 = input.LA(2);

                    if ( (synpred56_InternalDmpl()) ) {
                        alt37=1;
                    }


                }


                switch (alt37) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3861:2: rule__ShiftExpr__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ShiftExpr__Group_1__0_in_rule__ShiftExpr__Group__1__Impl7917);
            	    rule__ShiftExpr__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExprAccess().getGroup_1()); 
            }

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
    // $ANTLR end "rule__ShiftExpr__Group__1__Impl"


    // $ANTLR start "rule__ShiftExpr__Group_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3875:1: rule__ShiftExpr__Group_1__0 : rule__ShiftExpr__Group_1__0__Impl rule__ShiftExpr__Group_1__1 ;
    public final void rule__ShiftExpr__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3879:1: ( rule__ShiftExpr__Group_1__0__Impl rule__ShiftExpr__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3880:2: rule__ShiftExpr__Group_1__0__Impl rule__ShiftExpr__Group_1__1
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1__0__Impl_in_rule__ShiftExpr__Group_1__07952);
            rule__ShiftExpr__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1__1_in_rule__ShiftExpr__Group_1__07955);
            rule__ShiftExpr__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ShiftExpr__Group_1__0"


    // $ANTLR start "rule__ShiftExpr__Group_1__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3887:1: rule__ShiftExpr__Group_1__0__Impl : ( ( rule__ShiftExpr__Group_1_0__0 ) ) ;
    public final void rule__ShiftExpr__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3891:1: ( ( ( rule__ShiftExpr__Group_1_0__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3892:1: ( ( rule__ShiftExpr__Group_1_0__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3892:1: ( ( rule__ShiftExpr__Group_1_0__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3893:1: ( rule__ShiftExpr__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getGroup_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3894:1: ( rule__ShiftExpr__Group_1_0__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3894:2: rule__ShiftExpr__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1_0__0_in_rule__ShiftExpr__Group_1__0__Impl7982);
            rule__ShiftExpr__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExprAccess().getGroup_1_0()); 
            }

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
    // $ANTLR end "rule__ShiftExpr__Group_1__0__Impl"


    // $ANTLR start "rule__ShiftExpr__Group_1__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3904:1: rule__ShiftExpr__Group_1__1 : rule__ShiftExpr__Group_1__1__Impl ;
    public final void rule__ShiftExpr__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3908:1: ( rule__ShiftExpr__Group_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3909:2: rule__ShiftExpr__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1__1__Impl_in_rule__ShiftExpr__Group_1__18012);
            rule__ShiftExpr__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ShiftExpr__Group_1__1"


    // $ANTLR start "rule__ShiftExpr__Group_1__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3915:1: rule__ShiftExpr__Group_1__1__Impl : ( ( rule__ShiftExpr__RightAssignment_1_1 ) ) ;
    public final void rule__ShiftExpr__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3919:1: ( ( ( rule__ShiftExpr__RightAssignment_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3920:1: ( ( rule__ShiftExpr__RightAssignment_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3920:1: ( ( rule__ShiftExpr__RightAssignment_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3921:1: ( rule__ShiftExpr__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getRightAssignment_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3922:1: ( rule__ShiftExpr__RightAssignment_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3922:2: rule__ShiftExpr__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ShiftExpr__RightAssignment_1_1_in_rule__ShiftExpr__Group_1__1__Impl8039);
            rule__ShiftExpr__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExprAccess().getRightAssignment_1_1()); 
            }

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
    // $ANTLR end "rule__ShiftExpr__Group_1__1__Impl"


    // $ANTLR start "rule__ShiftExpr__Group_1_0__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3936:1: rule__ShiftExpr__Group_1_0__0 : rule__ShiftExpr__Group_1_0__0__Impl ;
    public final void rule__ShiftExpr__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3940:1: ( rule__ShiftExpr__Group_1_0__0__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3941:2: rule__ShiftExpr__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1_0__0__Impl_in_rule__ShiftExpr__Group_1_0__08073);
            rule__ShiftExpr__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ShiftExpr__Group_1_0__0"


    // $ANTLR start "rule__ShiftExpr__Group_1_0__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3947:1: rule__ShiftExpr__Group_1_0__0__Impl : ( ( rule__ShiftExpr__Group_1_0_0__0 ) ) ;
    public final void rule__ShiftExpr__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3951:1: ( ( ( rule__ShiftExpr__Group_1_0_0__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3952:1: ( ( rule__ShiftExpr__Group_1_0_0__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3952:1: ( ( rule__ShiftExpr__Group_1_0_0__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3953:1: ( rule__ShiftExpr__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getGroup_1_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3954:1: ( rule__ShiftExpr__Group_1_0_0__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3954:2: rule__ShiftExpr__Group_1_0_0__0
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1_0_0__0_in_rule__ShiftExpr__Group_1_0__0__Impl8100);
            rule__ShiftExpr__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExprAccess().getGroup_1_0_0()); 
            }

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
    // $ANTLR end "rule__ShiftExpr__Group_1_0__0__Impl"


    // $ANTLR start "rule__ShiftExpr__Group_1_0_0__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3966:1: rule__ShiftExpr__Group_1_0_0__0 : rule__ShiftExpr__Group_1_0_0__0__Impl rule__ShiftExpr__Group_1_0_0__1 ;
    public final void rule__ShiftExpr__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3970:1: ( rule__ShiftExpr__Group_1_0_0__0__Impl rule__ShiftExpr__Group_1_0_0__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3971:2: rule__ShiftExpr__Group_1_0_0__0__Impl rule__ShiftExpr__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1_0_0__0__Impl_in_rule__ShiftExpr__Group_1_0_0__08132);
            rule__ShiftExpr__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1_0_0__1_in_rule__ShiftExpr__Group_1_0_0__08135);
            rule__ShiftExpr__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ShiftExpr__Group_1_0_0__0"


    // $ANTLR start "rule__ShiftExpr__Group_1_0_0__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3978:1: rule__ShiftExpr__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__ShiftExpr__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3982:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3983:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3983:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3984:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getShiftExprLeftAction_1_0_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3985:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3987:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExprAccess().getShiftExprLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShiftExpr__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__ShiftExpr__Group_1_0_0__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3997:1: rule__ShiftExpr__Group_1_0_0__1 : rule__ShiftExpr__Group_1_0_0__1__Impl ;
    public final void rule__ShiftExpr__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4001:1: ( rule__ShiftExpr__Group_1_0_0__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4002:2: rule__ShiftExpr__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1_0_0__1__Impl_in_rule__ShiftExpr__Group_1_0_0__18193);
            rule__ShiftExpr__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ShiftExpr__Group_1_0_0__1"


    // $ANTLR start "rule__ShiftExpr__Group_1_0_0__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4008:1: rule__ShiftExpr__Group_1_0_0__1__Impl : ( ( rule__ShiftExpr__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__ShiftExpr__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4012:1: ( ( ( rule__ShiftExpr__OperatorAssignment_1_0_0_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4013:1: ( ( rule__ShiftExpr__OperatorAssignment_1_0_0_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4013:1: ( ( rule__ShiftExpr__OperatorAssignment_1_0_0_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4014:1: ( rule__ShiftExpr__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4015:1: ( rule__ShiftExpr__OperatorAssignment_1_0_0_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4015:2: rule__ShiftExpr__OperatorAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_rule__ShiftExpr__OperatorAssignment_1_0_0_1_in_rule__ShiftExpr__Group_1_0_0__1__Impl8220);
            rule__ShiftExpr__OperatorAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExprAccess().getOperatorAssignment_1_0_0_1()); 
            }

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
    // $ANTLR end "rule__ShiftExpr__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__AdditiveExpr__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4029:1: rule__AdditiveExpr__Group__0 : rule__AdditiveExpr__Group__0__Impl rule__AdditiveExpr__Group__1 ;
    public final void rule__AdditiveExpr__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4033:1: ( rule__AdditiveExpr__Group__0__Impl rule__AdditiveExpr__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4034:2: rule__AdditiveExpr__Group__0__Impl rule__AdditiveExpr__Group__1
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group__0__Impl_in_rule__AdditiveExpr__Group__08254);
            rule__AdditiveExpr__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AdditiveExpr__Group__1_in_rule__AdditiveExpr__Group__08257);
            rule__AdditiveExpr__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AdditiveExpr__Group__0"


    // $ANTLR start "rule__AdditiveExpr__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4041:1: rule__AdditiveExpr__Group__0__Impl : ( ruleMultiplicativeExpr ) ;
    public final void rule__AdditiveExpr__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4045:1: ( ( ruleMultiplicativeExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4046:1: ( ruleMultiplicativeExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4046:1: ( ruleMultiplicativeExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4047:1: ruleMultiplicativeExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getMultiplicativeExprParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpr_in_rule__AdditiveExpr__Group__0__Impl8284);
            ruleMultiplicativeExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExprAccess().getMultiplicativeExprParserRuleCall_0()); 
            }

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
    // $ANTLR end "rule__AdditiveExpr__Group__0__Impl"


    // $ANTLR start "rule__AdditiveExpr__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4058:1: rule__AdditiveExpr__Group__1 : rule__AdditiveExpr__Group__1__Impl ;
    public final void rule__AdditiveExpr__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4062:1: ( rule__AdditiveExpr__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4063:2: rule__AdditiveExpr__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group__1__Impl_in_rule__AdditiveExpr__Group__18313);
            rule__AdditiveExpr__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AdditiveExpr__Group__1"


    // $ANTLR start "rule__AdditiveExpr__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4069:1: rule__AdditiveExpr__Group__1__Impl : ( ( rule__AdditiveExpr__Group_1__0 )* ) ;
    public final void rule__AdditiveExpr__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4073:1: ( ( ( rule__AdditiveExpr__Group_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4074:1: ( ( rule__AdditiveExpr__Group_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4074:1: ( ( rule__AdditiveExpr__Group_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4075:1: ( rule__AdditiveExpr__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getGroup_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4076:1: ( rule__AdditiveExpr__Group_1__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==19) ) {
                    int LA38_2 = input.LA(2);

                    if ( (synpred57_InternalDmpl()) ) {
                        alt38=1;
                    }


                }
                else if ( (LA38_0==20) ) {
                    int LA38_3 = input.LA(2);

                    if ( (synpred57_InternalDmpl()) ) {
                        alt38=1;
                    }


                }


                switch (alt38) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4076:2: rule__AdditiveExpr__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AdditiveExpr__Group_1__0_in_rule__AdditiveExpr__Group__1__Impl8340);
            	    rule__AdditiveExpr__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExprAccess().getGroup_1()); 
            }

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
    // $ANTLR end "rule__AdditiveExpr__Group__1__Impl"


    // $ANTLR start "rule__AdditiveExpr__Group_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4090:1: rule__AdditiveExpr__Group_1__0 : rule__AdditiveExpr__Group_1__0__Impl rule__AdditiveExpr__Group_1__1 ;
    public final void rule__AdditiveExpr__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4094:1: ( rule__AdditiveExpr__Group_1__0__Impl rule__AdditiveExpr__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4095:2: rule__AdditiveExpr__Group_1__0__Impl rule__AdditiveExpr__Group_1__1
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1__0__Impl_in_rule__AdditiveExpr__Group_1__08375);
            rule__AdditiveExpr__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1__1_in_rule__AdditiveExpr__Group_1__08378);
            rule__AdditiveExpr__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AdditiveExpr__Group_1__0"


    // $ANTLR start "rule__AdditiveExpr__Group_1__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4102:1: rule__AdditiveExpr__Group_1__0__Impl : ( ( rule__AdditiveExpr__Group_1_0__0 ) ) ;
    public final void rule__AdditiveExpr__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4106:1: ( ( ( rule__AdditiveExpr__Group_1_0__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4107:1: ( ( rule__AdditiveExpr__Group_1_0__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4107:1: ( ( rule__AdditiveExpr__Group_1_0__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4108:1: ( rule__AdditiveExpr__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getGroup_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4109:1: ( rule__AdditiveExpr__Group_1_0__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4109:2: rule__AdditiveExpr__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1_0__0_in_rule__AdditiveExpr__Group_1__0__Impl8405);
            rule__AdditiveExpr__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExprAccess().getGroup_1_0()); 
            }

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
    // $ANTLR end "rule__AdditiveExpr__Group_1__0__Impl"


    // $ANTLR start "rule__AdditiveExpr__Group_1__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4119:1: rule__AdditiveExpr__Group_1__1 : rule__AdditiveExpr__Group_1__1__Impl ;
    public final void rule__AdditiveExpr__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4123:1: ( rule__AdditiveExpr__Group_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4124:2: rule__AdditiveExpr__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1__1__Impl_in_rule__AdditiveExpr__Group_1__18435);
            rule__AdditiveExpr__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AdditiveExpr__Group_1__1"


    // $ANTLR start "rule__AdditiveExpr__Group_1__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4130:1: rule__AdditiveExpr__Group_1__1__Impl : ( ( rule__AdditiveExpr__RightAssignment_1_1 ) ) ;
    public final void rule__AdditiveExpr__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4134:1: ( ( ( rule__AdditiveExpr__RightAssignment_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4135:1: ( ( rule__AdditiveExpr__RightAssignment_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4135:1: ( ( rule__AdditiveExpr__RightAssignment_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4136:1: ( rule__AdditiveExpr__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getRightAssignment_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4137:1: ( rule__AdditiveExpr__RightAssignment_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4137:2: rule__AdditiveExpr__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__RightAssignment_1_1_in_rule__AdditiveExpr__Group_1__1__Impl8462);
            rule__AdditiveExpr__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExprAccess().getRightAssignment_1_1()); 
            }

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
    // $ANTLR end "rule__AdditiveExpr__Group_1__1__Impl"


    // $ANTLR start "rule__AdditiveExpr__Group_1_0__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4151:1: rule__AdditiveExpr__Group_1_0__0 : rule__AdditiveExpr__Group_1_0__0__Impl ;
    public final void rule__AdditiveExpr__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4155:1: ( rule__AdditiveExpr__Group_1_0__0__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4156:2: rule__AdditiveExpr__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1_0__0__Impl_in_rule__AdditiveExpr__Group_1_0__08496);
            rule__AdditiveExpr__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AdditiveExpr__Group_1_0__0"


    // $ANTLR start "rule__AdditiveExpr__Group_1_0__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4162:1: rule__AdditiveExpr__Group_1_0__0__Impl : ( ( rule__AdditiveExpr__Group_1_0_0__0 ) ) ;
    public final void rule__AdditiveExpr__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4166:1: ( ( ( rule__AdditiveExpr__Group_1_0_0__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4167:1: ( ( rule__AdditiveExpr__Group_1_0_0__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4167:1: ( ( rule__AdditiveExpr__Group_1_0_0__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4168:1: ( rule__AdditiveExpr__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getGroup_1_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4169:1: ( rule__AdditiveExpr__Group_1_0_0__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4169:2: rule__AdditiveExpr__Group_1_0_0__0
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1_0_0__0_in_rule__AdditiveExpr__Group_1_0__0__Impl8523);
            rule__AdditiveExpr__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExprAccess().getGroup_1_0_0()); 
            }

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
    // $ANTLR end "rule__AdditiveExpr__Group_1_0__0__Impl"


    // $ANTLR start "rule__AdditiveExpr__Group_1_0_0__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4181:1: rule__AdditiveExpr__Group_1_0_0__0 : rule__AdditiveExpr__Group_1_0_0__0__Impl rule__AdditiveExpr__Group_1_0_0__1 ;
    public final void rule__AdditiveExpr__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4185:1: ( rule__AdditiveExpr__Group_1_0_0__0__Impl rule__AdditiveExpr__Group_1_0_0__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4186:2: rule__AdditiveExpr__Group_1_0_0__0__Impl rule__AdditiveExpr__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1_0_0__0__Impl_in_rule__AdditiveExpr__Group_1_0_0__08555);
            rule__AdditiveExpr__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1_0_0__1_in_rule__AdditiveExpr__Group_1_0_0__08558);
            rule__AdditiveExpr__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AdditiveExpr__Group_1_0_0__0"


    // $ANTLR start "rule__AdditiveExpr__Group_1_0_0__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4193:1: rule__AdditiveExpr__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__AdditiveExpr__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4197:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4198:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4198:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4199:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getAdditiveExprLeftAction_1_0_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4200:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4202:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExprAccess().getAdditiveExprLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditiveExpr__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__AdditiveExpr__Group_1_0_0__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4212:1: rule__AdditiveExpr__Group_1_0_0__1 : rule__AdditiveExpr__Group_1_0_0__1__Impl ;
    public final void rule__AdditiveExpr__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4216:1: ( rule__AdditiveExpr__Group_1_0_0__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4217:2: rule__AdditiveExpr__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1_0_0__1__Impl_in_rule__AdditiveExpr__Group_1_0_0__18616);
            rule__AdditiveExpr__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__AdditiveExpr__Group_1_0_0__1"


    // $ANTLR start "rule__AdditiveExpr__Group_1_0_0__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4223:1: rule__AdditiveExpr__Group_1_0_0__1__Impl : ( ( rule__AdditiveExpr__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__AdditiveExpr__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4227:1: ( ( ( rule__AdditiveExpr__OperatorAssignment_1_0_0_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4228:1: ( ( rule__AdditiveExpr__OperatorAssignment_1_0_0_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4228:1: ( ( rule__AdditiveExpr__OperatorAssignment_1_0_0_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4229:1: ( rule__AdditiveExpr__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4230:1: ( rule__AdditiveExpr__OperatorAssignment_1_0_0_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4230:2: rule__AdditiveExpr__OperatorAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__OperatorAssignment_1_0_0_1_in_rule__AdditiveExpr__Group_1_0_0__1__Impl8643);
            rule__AdditiveExpr__OperatorAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExprAccess().getOperatorAssignment_1_0_0_1()); 
            }

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
    // $ANTLR end "rule__AdditiveExpr__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__MultiplicativeExpr__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4244:1: rule__MultiplicativeExpr__Group__0 : rule__MultiplicativeExpr__Group__0__Impl rule__MultiplicativeExpr__Group__1 ;
    public final void rule__MultiplicativeExpr__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4248:1: ( rule__MultiplicativeExpr__Group__0__Impl rule__MultiplicativeExpr__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4249:2: rule__MultiplicativeExpr__Group__0__Impl rule__MultiplicativeExpr__Group__1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group__0__Impl_in_rule__MultiplicativeExpr__Group__08677);
            rule__MultiplicativeExpr__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group__1_in_rule__MultiplicativeExpr__Group__08680);
            rule__MultiplicativeExpr__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__MultiplicativeExpr__Group__0"


    // $ANTLR start "rule__MultiplicativeExpr__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4256:1: rule__MultiplicativeExpr__Group__0__Impl : ( ruleTerminalExpr ) ;
    public final void rule__MultiplicativeExpr__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4260:1: ( ( ruleTerminalExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4261:1: ( ruleTerminalExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4261:1: ( ruleTerminalExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4262:1: ruleTerminalExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getTerminalExprParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleTerminalExpr_in_rule__MultiplicativeExpr__Group__0__Impl8707);
            ruleTerminalExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExprAccess().getTerminalExprParserRuleCall_0()); 
            }

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
    // $ANTLR end "rule__MultiplicativeExpr__Group__0__Impl"


    // $ANTLR start "rule__MultiplicativeExpr__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4273:1: rule__MultiplicativeExpr__Group__1 : rule__MultiplicativeExpr__Group__1__Impl ;
    public final void rule__MultiplicativeExpr__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4277:1: ( rule__MultiplicativeExpr__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4278:2: rule__MultiplicativeExpr__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group__1__Impl_in_rule__MultiplicativeExpr__Group__18736);
            rule__MultiplicativeExpr__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__MultiplicativeExpr__Group__1"


    // $ANTLR start "rule__MultiplicativeExpr__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4284:1: rule__MultiplicativeExpr__Group__1__Impl : ( ( rule__MultiplicativeExpr__Group_1__0 )* ) ;
    public final void rule__MultiplicativeExpr__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4288:1: ( ( ( rule__MultiplicativeExpr__Group_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4289:1: ( ( rule__MultiplicativeExpr__Group_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4289:1: ( ( rule__MultiplicativeExpr__Group_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4290:1: ( rule__MultiplicativeExpr__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getGroup_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4291:1: ( rule__MultiplicativeExpr__Group_1__0 )*
            loop39:
            do {
                int alt39=2;
                switch ( input.LA(1) ) {
                case 38:
                    {
                    int LA39_2 = input.LA(2);

                    if ( (synpred58_InternalDmpl()) ) {
                        alt39=1;
                    }


                    }
                    break;
                case 39:
                    {
                    int LA39_3 = input.LA(2);

                    if ( (synpred58_InternalDmpl()) ) {
                        alt39=1;
                    }


                    }
                    break;
                case 40:
                    {
                    int LA39_4 = input.LA(2);

                    if ( (synpred58_InternalDmpl()) ) {
                        alt39=1;
                    }


                    }
                    break;

                }

                switch (alt39) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4291:2: rule__MultiplicativeExpr__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1__0_in_rule__MultiplicativeExpr__Group__1__Impl8763);
            	    rule__MultiplicativeExpr__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExprAccess().getGroup_1()); 
            }

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
    // $ANTLR end "rule__MultiplicativeExpr__Group__1__Impl"


    // $ANTLR start "rule__MultiplicativeExpr__Group_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4305:1: rule__MultiplicativeExpr__Group_1__0 : rule__MultiplicativeExpr__Group_1__0__Impl rule__MultiplicativeExpr__Group_1__1 ;
    public final void rule__MultiplicativeExpr__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4309:1: ( rule__MultiplicativeExpr__Group_1__0__Impl rule__MultiplicativeExpr__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4310:2: rule__MultiplicativeExpr__Group_1__0__Impl rule__MultiplicativeExpr__Group_1__1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1__0__Impl_in_rule__MultiplicativeExpr__Group_1__08798);
            rule__MultiplicativeExpr__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1__1_in_rule__MultiplicativeExpr__Group_1__08801);
            rule__MultiplicativeExpr__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__MultiplicativeExpr__Group_1__0"


    // $ANTLR start "rule__MultiplicativeExpr__Group_1__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4317:1: rule__MultiplicativeExpr__Group_1__0__Impl : ( ( rule__MultiplicativeExpr__Group_1_0__0 ) ) ;
    public final void rule__MultiplicativeExpr__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4321:1: ( ( ( rule__MultiplicativeExpr__Group_1_0__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4322:1: ( ( rule__MultiplicativeExpr__Group_1_0__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4322:1: ( ( rule__MultiplicativeExpr__Group_1_0__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4323:1: ( rule__MultiplicativeExpr__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getGroup_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4324:1: ( rule__MultiplicativeExpr__Group_1_0__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4324:2: rule__MultiplicativeExpr__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1_0__0_in_rule__MultiplicativeExpr__Group_1__0__Impl8828);
            rule__MultiplicativeExpr__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExprAccess().getGroup_1_0()); 
            }

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
    // $ANTLR end "rule__MultiplicativeExpr__Group_1__0__Impl"


    // $ANTLR start "rule__MultiplicativeExpr__Group_1__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4334:1: rule__MultiplicativeExpr__Group_1__1 : rule__MultiplicativeExpr__Group_1__1__Impl ;
    public final void rule__MultiplicativeExpr__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4338:1: ( rule__MultiplicativeExpr__Group_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4339:2: rule__MultiplicativeExpr__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1__1__Impl_in_rule__MultiplicativeExpr__Group_1__18858);
            rule__MultiplicativeExpr__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__MultiplicativeExpr__Group_1__1"


    // $ANTLR start "rule__MultiplicativeExpr__Group_1__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4345:1: rule__MultiplicativeExpr__Group_1__1__Impl : ( ( rule__MultiplicativeExpr__RightAssignment_1_1 ) ) ;
    public final void rule__MultiplicativeExpr__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4349:1: ( ( ( rule__MultiplicativeExpr__RightAssignment_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4350:1: ( ( rule__MultiplicativeExpr__RightAssignment_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4350:1: ( ( rule__MultiplicativeExpr__RightAssignment_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4351:1: ( rule__MultiplicativeExpr__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getRightAssignment_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4352:1: ( rule__MultiplicativeExpr__RightAssignment_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4352:2: rule__MultiplicativeExpr__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__RightAssignment_1_1_in_rule__MultiplicativeExpr__Group_1__1__Impl8885);
            rule__MultiplicativeExpr__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExprAccess().getRightAssignment_1_1()); 
            }

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
    // $ANTLR end "rule__MultiplicativeExpr__Group_1__1__Impl"


    // $ANTLR start "rule__MultiplicativeExpr__Group_1_0__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4366:1: rule__MultiplicativeExpr__Group_1_0__0 : rule__MultiplicativeExpr__Group_1_0__0__Impl ;
    public final void rule__MultiplicativeExpr__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4370:1: ( rule__MultiplicativeExpr__Group_1_0__0__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4371:2: rule__MultiplicativeExpr__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1_0__0__Impl_in_rule__MultiplicativeExpr__Group_1_0__08919);
            rule__MultiplicativeExpr__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__MultiplicativeExpr__Group_1_0__0"


    // $ANTLR start "rule__MultiplicativeExpr__Group_1_0__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4377:1: rule__MultiplicativeExpr__Group_1_0__0__Impl : ( ( rule__MultiplicativeExpr__Group_1_0_0__0 ) ) ;
    public final void rule__MultiplicativeExpr__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4381:1: ( ( ( rule__MultiplicativeExpr__Group_1_0_0__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4382:1: ( ( rule__MultiplicativeExpr__Group_1_0_0__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4382:1: ( ( rule__MultiplicativeExpr__Group_1_0_0__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4383:1: ( rule__MultiplicativeExpr__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getGroup_1_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4384:1: ( rule__MultiplicativeExpr__Group_1_0_0__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4384:2: rule__MultiplicativeExpr__Group_1_0_0__0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1_0_0__0_in_rule__MultiplicativeExpr__Group_1_0__0__Impl8946);
            rule__MultiplicativeExpr__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExprAccess().getGroup_1_0_0()); 
            }

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
    // $ANTLR end "rule__MultiplicativeExpr__Group_1_0__0__Impl"


    // $ANTLR start "rule__MultiplicativeExpr__Group_1_0_0__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4396:1: rule__MultiplicativeExpr__Group_1_0_0__0 : rule__MultiplicativeExpr__Group_1_0_0__0__Impl rule__MultiplicativeExpr__Group_1_0_0__1 ;
    public final void rule__MultiplicativeExpr__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4400:1: ( rule__MultiplicativeExpr__Group_1_0_0__0__Impl rule__MultiplicativeExpr__Group_1_0_0__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4401:2: rule__MultiplicativeExpr__Group_1_0_0__0__Impl rule__MultiplicativeExpr__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1_0_0__0__Impl_in_rule__MultiplicativeExpr__Group_1_0_0__08978);
            rule__MultiplicativeExpr__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1_0_0__1_in_rule__MultiplicativeExpr__Group_1_0_0__08981);
            rule__MultiplicativeExpr__Group_1_0_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__MultiplicativeExpr__Group_1_0_0__0"


    // $ANTLR start "rule__MultiplicativeExpr__Group_1_0_0__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4408:1: rule__MultiplicativeExpr__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__MultiplicativeExpr__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4412:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4413:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4413:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4414:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getMultiplicativeExprLeftAction_1_0_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4415:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4417:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExprAccess().getMultiplicativeExprLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicativeExpr__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__MultiplicativeExpr__Group_1_0_0__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4427:1: rule__MultiplicativeExpr__Group_1_0_0__1 : rule__MultiplicativeExpr__Group_1_0_0__1__Impl ;
    public final void rule__MultiplicativeExpr__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4431:1: ( rule__MultiplicativeExpr__Group_1_0_0__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4432:2: rule__MultiplicativeExpr__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1_0_0__1__Impl_in_rule__MultiplicativeExpr__Group_1_0_0__19039);
            rule__MultiplicativeExpr__Group_1_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__MultiplicativeExpr__Group_1_0_0__1"


    // $ANTLR start "rule__MultiplicativeExpr__Group_1_0_0__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4438:1: rule__MultiplicativeExpr__Group_1_0_0__1__Impl : ( ( rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__MultiplicativeExpr__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4442:1: ( ( ( rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4443:1: ( ( rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4443:1: ( ( rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4444:1: ( rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4445:1: ( rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4445:2: rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1_in_rule__MultiplicativeExpr__Group_1_0_0__1__Impl9066);
            rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExprAccess().getOperatorAssignment_1_0_0_1()); 
            }

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
    // $ANTLR end "rule__MultiplicativeExpr__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4459:1: rule__TerminalExpr__Group_1__0 : rule__TerminalExpr__Group_1__0__Impl rule__TerminalExpr__Group_1__1 ;
    public final void rule__TerminalExpr__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4463:1: ( rule__TerminalExpr__Group_1__0__Impl rule__TerminalExpr__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4464:2: rule__TerminalExpr__Group_1__0__Impl rule__TerminalExpr__Group_1__1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_1__0__Impl_in_rule__TerminalExpr__Group_1__09100);
            rule__TerminalExpr__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_1__1_in_rule__TerminalExpr__Group_1__09103);
            rule__TerminalExpr__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_1__0"


    // $ANTLR start "rule__TerminalExpr__Group_1__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4471:1: rule__TerminalExpr__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalExpr__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4475:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4476:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4476:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4477:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getIdExprAction_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4478:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4480:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getIdExprAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpr__Group_1__0__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_1__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4490:1: rule__TerminalExpr__Group_1__1 : rule__TerminalExpr__Group_1__1__Impl ;
    public final void rule__TerminalExpr__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4494:1: ( rule__TerminalExpr__Group_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4495:2: rule__TerminalExpr__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_1__1__Impl_in_rule__TerminalExpr__Group_1__19161);
            rule__TerminalExpr__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_1__1"


    // $ANTLR start "rule__TerminalExpr__Group_1__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4501:1: rule__TerminalExpr__Group_1__1__Impl : ( 'id' ) ;
    public final void rule__TerminalExpr__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4505:1: ( ( 'id' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4506:1: ( 'id' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4506:1: ( 'id' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4507:1: 'id'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getIdKeyword_1_1()); 
            }
            match(input,54,FOLLOW_54_in_rule__TerminalExpr__Group_1__1__Impl9189); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getIdKeyword_1_1()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__Group_1__1__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_2__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4524:1: rule__TerminalExpr__Group_2__0 : rule__TerminalExpr__Group_2__0__Impl rule__TerminalExpr__Group_2__1 ;
    public final void rule__TerminalExpr__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4528:1: ( rule__TerminalExpr__Group_2__0__Impl rule__TerminalExpr__Group_2__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4529:2: rule__TerminalExpr__Group_2__0__Impl rule__TerminalExpr__Group_2__1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_2__0__Impl_in_rule__TerminalExpr__Group_2__09224);
            rule__TerminalExpr__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_2__1_in_rule__TerminalExpr__Group_2__09227);
            rule__TerminalExpr__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_2__0"


    // $ANTLR start "rule__TerminalExpr__Group_2__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4536:1: rule__TerminalExpr__Group_2__0__Impl : ( () ) ;
    public final void rule__TerminalExpr__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4540:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4541:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4541:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4542:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getIntExprAction_2_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4543:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4545:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getIntExprAction_2_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpr__Group_2__0__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_2__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4555:1: rule__TerminalExpr__Group_2__1 : rule__TerminalExpr__Group_2__1__Impl ;
    public final void rule__TerminalExpr__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4559:1: ( rule__TerminalExpr__Group_2__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4560:2: rule__TerminalExpr__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_2__1__Impl_in_rule__TerminalExpr__Group_2__19285);
            rule__TerminalExpr__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_2__1"


    // $ANTLR start "rule__TerminalExpr__Group_2__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4566:1: rule__TerminalExpr__Group_2__1__Impl : ( ( rule__TerminalExpr__ValueAssignment_2_1 ) ) ;
    public final void rule__TerminalExpr__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4570:1: ( ( ( rule__TerminalExpr__ValueAssignment_2_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4571:1: ( ( rule__TerminalExpr__ValueAssignment_2_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4571:1: ( ( rule__TerminalExpr__ValueAssignment_2_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4572:1: ( rule__TerminalExpr__ValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getValueAssignment_2_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4573:1: ( rule__TerminalExpr__ValueAssignment_2_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4573:2: rule__TerminalExpr__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__ValueAssignment_2_1_in_rule__TerminalExpr__Group_2__1__Impl9312);
            rule__TerminalExpr__ValueAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getValueAssignment_2_1()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__Group_2__1__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_3__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4587:1: rule__TerminalExpr__Group_3__0 : rule__TerminalExpr__Group_3__0__Impl rule__TerminalExpr__Group_3__1 ;
    public final void rule__TerminalExpr__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4591:1: ( rule__TerminalExpr__Group_3__0__Impl rule__TerminalExpr__Group_3__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4592:2: rule__TerminalExpr__Group_3__0__Impl rule__TerminalExpr__Group_3__1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_3__0__Impl_in_rule__TerminalExpr__Group_3__09346);
            rule__TerminalExpr__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_3__1_in_rule__TerminalExpr__Group_3__09349);
            rule__TerminalExpr__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_3__0"


    // $ANTLR start "rule__TerminalExpr__Group_3__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4599:1: rule__TerminalExpr__Group_3__0__Impl : ( () ) ;
    public final void rule__TerminalExpr__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4603:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4604:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4604:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4605:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getDoubleExprAction_3_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4606:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4608:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getDoubleExprAction_3_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpr__Group_3__0__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_3__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4618:1: rule__TerminalExpr__Group_3__1 : rule__TerminalExpr__Group_3__1__Impl ;
    public final void rule__TerminalExpr__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4622:1: ( rule__TerminalExpr__Group_3__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4623:2: rule__TerminalExpr__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_3__1__Impl_in_rule__TerminalExpr__Group_3__19407);
            rule__TerminalExpr__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_3__1"


    // $ANTLR start "rule__TerminalExpr__Group_3__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4629:1: rule__TerminalExpr__Group_3__1__Impl : ( ( rule__TerminalExpr__ValueAssignment_3_1 ) ) ;
    public final void rule__TerminalExpr__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4633:1: ( ( ( rule__TerminalExpr__ValueAssignment_3_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4634:1: ( ( rule__TerminalExpr__ValueAssignment_3_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4634:1: ( ( rule__TerminalExpr__ValueAssignment_3_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4635:1: ( rule__TerminalExpr__ValueAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getValueAssignment_3_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4636:1: ( rule__TerminalExpr__ValueAssignment_3_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4636:2: rule__TerminalExpr__ValueAssignment_3_1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__ValueAssignment_3_1_in_rule__TerminalExpr__Group_3__1__Impl9434);
            rule__TerminalExpr__ValueAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getValueAssignment_3_1()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__Group_3__1__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_4__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4650:1: rule__TerminalExpr__Group_4__0 : rule__TerminalExpr__Group_4__0__Impl rule__TerminalExpr__Group_4__1 ;
    public final void rule__TerminalExpr__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4654:1: ( rule__TerminalExpr__Group_4__0__Impl rule__TerminalExpr__Group_4__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4655:2: rule__TerminalExpr__Group_4__0__Impl rule__TerminalExpr__Group_4__1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_4__0__Impl_in_rule__TerminalExpr__Group_4__09468);
            rule__TerminalExpr__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_4__1_in_rule__TerminalExpr__Group_4__09471);
            rule__TerminalExpr__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_4__0"


    // $ANTLR start "rule__TerminalExpr__Group_4__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4662:1: rule__TerminalExpr__Group_4__0__Impl : ( () ) ;
    public final void rule__TerminalExpr__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4666:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4667:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4667:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4668:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getNodeNumExprAction_4_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4669:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4671:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getNodeNumExprAction_4_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpr__Group_4__0__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_4__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4681:1: rule__TerminalExpr__Group_4__1 : rule__TerminalExpr__Group_4__1__Impl ;
    public final void rule__TerminalExpr__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4685:1: ( rule__TerminalExpr__Group_4__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4686:2: rule__TerminalExpr__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_4__1__Impl_in_rule__TerminalExpr__Group_4__19529);
            rule__TerminalExpr__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_4__1"


    // $ANTLR start "rule__TerminalExpr__Group_4__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4692:1: rule__TerminalExpr__Group_4__1__Impl : ( '#N' ) ;
    public final void rule__TerminalExpr__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4696:1: ( ( '#N' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4697:1: ( '#N' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4697:1: ( '#N' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4698:1: '#N'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getNKeyword_4_1()); 
            }
            match(input,46,FOLLOW_46_in_rule__TerminalExpr__Group_4__1__Impl9557); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getNKeyword_4_1()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__Group_4__1__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_5__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4715:1: rule__TerminalExpr__Group_5__0 : rule__TerminalExpr__Group_5__0__Impl rule__TerminalExpr__Group_5__1 ;
    public final void rule__TerminalExpr__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4719:1: ( rule__TerminalExpr__Group_5__0__Impl rule__TerminalExpr__Group_5__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4720:2: rule__TerminalExpr__Group_5__0__Impl rule__TerminalExpr__Group_5__1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_5__0__Impl_in_rule__TerminalExpr__Group_5__09592);
            rule__TerminalExpr__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_5__1_in_rule__TerminalExpr__Group_5__09595);
            rule__TerminalExpr__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_5__0"


    // $ANTLR start "rule__TerminalExpr__Group_5__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4727:1: rule__TerminalExpr__Group_5__0__Impl : ( () ) ;
    public final void rule__TerminalExpr__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4731:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4732:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4732:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4733:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getUnaryExprAction_5_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4734:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4736:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getUnaryExprAction_5_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpr__Group_5__0__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_5__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4746:1: rule__TerminalExpr__Group_5__1 : rule__TerminalExpr__Group_5__1__Impl rule__TerminalExpr__Group_5__2 ;
    public final void rule__TerminalExpr__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4750:1: ( rule__TerminalExpr__Group_5__1__Impl rule__TerminalExpr__Group_5__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4751:2: rule__TerminalExpr__Group_5__1__Impl rule__TerminalExpr__Group_5__2
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_5__1__Impl_in_rule__TerminalExpr__Group_5__19653);
            rule__TerminalExpr__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_5__2_in_rule__TerminalExpr__Group_5__19656);
            rule__TerminalExpr__Group_5__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_5__1"


    // $ANTLR start "rule__TerminalExpr__Group_5__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4758:1: rule__TerminalExpr__Group_5__1__Impl : ( ( rule__TerminalExpr__OperatorAssignment_5_1 ) ) ;
    public final void rule__TerminalExpr__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4762:1: ( ( ( rule__TerminalExpr__OperatorAssignment_5_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4763:1: ( ( rule__TerminalExpr__OperatorAssignment_5_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4763:1: ( ( rule__TerminalExpr__OperatorAssignment_5_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4764:1: ( rule__TerminalExpr__OperatorAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getOperatorAssignment_5_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4765:1: ( rule__TerminalExpr__OperatorAssignment_5_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4765:2: rule__TerminalExpr__OperatorAssignment_5_1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__OperatorAssignment_5_1_in_rule__TerminalExpr__Group_5__1__Impl9683);
            rule__TerminalExpr__OperatorAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getOperatorAssignment_5_1()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__Group_5__1__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_5__2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4775:1: rule__TerminalExpr__Group_5__2 : rule__TerminalExpr__Group_5__2__Impl ;
    public final void rule__TerminalExpr__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4779:1: ( rule__TerminalExpr__Group_5__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4780:2: rule__TerminalExpr__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_5__2__Impl_in_rule__TerminalExpr__Group_5__29713);
            rule__TerminalExpr__Group_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_5__2"


    // $ANTLR start "rule__TerminalExpr__Group_5__2__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4786:1: rule__TerminalExpr__Group_5__2__Impl : ( ( rule__TerminalExpr__OperandAssignment_5_2 ) ) ;
    public final void rule__TerminalExpr__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4790:1: ( ( ( rule__TerminalExpr__OperandAssignment_5_2 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4791:1: ( ( rule__TerminalExpr__OperandAssignment_5_2 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4791:1: ( ( rule__TerminalExpr__OperandAssignment_5_2 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4792:1: ( rule__TerminalExpr__OperandAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getOperandAssignment_5_2()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4793:1: ( rule__TerminalExpr__OperandAssignment_5_2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4793:2: rule__TerminalExpr__OperandAssignment_5_2
            {
            pushFollow(FOLLOW_rule__TerminalExpr__OperandAssignment_5_2_in_rule__TerminalExpr__Group_5__2__Impl9740);
            rule__TerminalExpr__OperandAssignment_5_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getOperandAssignment_5_2()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__Group_5__2__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_6__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4809:1: rule__TerminalExpr__Group_6__0 : rule__TerminalExpr__Group_6__0__Impl rule__TerminalExpr__Group_6__1 ;
    public final void rule__TerminalExpr__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4813:1: ( rule__TerminalExpr__Group_6__0__Impl rule__TerminalExpr__Group_6__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4814:2: rule__TerminalExpr__Group_6__0__Impl rule__TerminalExpr__Group_6__1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__0__Impl_in_rule__TerminalExpr__Group_6__09776);
            rule__TerminalExpr__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__1_in_rule__TerminalExpr__Group_6__09779);
            rule__TerminalExpr__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_6__0"


    // $ANTLR start "rule__TerminalExpr__Group_6__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4821:1: rule__TerminalExpr__Group_6__0__Impl : ( () ) ;
    public final void rule__TerminalExpr__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4825:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4826:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4826:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4827:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getBuiltInExprAction_6_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4828:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4830:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getBuiltInExprAction_6_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalExpr__Group_6__0__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_6__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4840:1: rule__TerminalExpr__Group_6__1 : rule__TerminalExpr__Group_6__1__Impl rule__TerminalExpr__Group_6__2 ;
    public final void rule__TerminalExpr__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4844:1: ( rule__TerminalExpr__Group_6__1__Impl rule__TerminalExpr__Group_6__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4845:2: rule__TerminalExpr__Group_6__1__Impl rule__TerminalExpr__Group_6__2
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__1__Impl_in_rule__TerminalExpr__Group_6__19837);
            rule__TerminalExpr__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__2_in_rule__TerminalExpr__Group_6__19840);
            rule__TerminalExpr__Group_6__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_6__1"


    // $ANTLR start "rule__TerminalExpr__Group_6__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4852:1: rule__TerminalExpr__Group_6__1__Impl : ( ( rule__TerminalExpr__FunctionAssignment_6_1 ) ) ;
    public final void rule__TerminalExpr__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4856:1: ( ( ( rule__TerminalExpr__FunctionAssignment_6_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4857:1: ( ( rule__TerminalExpr__FunctionAssignment_6_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4857:1: ( ( rule__TerminalExpr__FunctionAssignment_6_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4858:1: ( rule__TerminalExpr__FunctionAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getFunctionAssignment_6_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4859:1: ( rule__TerminalExpr__FunctionAssignment_6_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4859:2: rule__TerminalExpr__FunctionAssignment_6_1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__FunctionAssignment_6_1_in_rule__TerminalExpr__Group_6__1__Impl9867);
            rule__TerminalExpr__FunctionAssignment_6_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getFunctionAssignment_6_1()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__Group_6__1__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_6__2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4869:1: rule__TerminalExpr__Group_6__2 : rule__TerminalExpr__Group_6__2__Impl rule__TerminalExpr__Group_6__3 ;
    public final void rule__TerminalExpr__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4873:1: ( rule__TerminalExpr__Group_6__2__Impl rule__TerminalExpr__Group_6__3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4874:2: rule__TerminalExpr__Group_6__2__Impl rule__TerminalExpr__Group_6__3
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__2__Impl_in_rule__TerminalExpr__Group_6__29897);
            rule__TerminalExpr__Group_6__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__3_in_rule__TerminalExpr__Group_6__29900);
            rule__TerminalExpr__Group_6__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_6__2"


    // $ANTLR start "rule__TerminalExpr__Group_6__2__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4881:1: rule__TerminalExpr__Group_6__2__Impl : ( '(' ) ;
    public final void rule__TerminalExpr__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4885:1: ( ( '(' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4886:1: ( '(' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4886:1: ( '(' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4887:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getLeftParenthesisKeyword_6_2()); 
            }
            match(input,50,FOLLOW_50_in_rule__TerminalExpr__Group_6__2__Impl9928); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getLeftParenthesisKeyword_6_2()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__Group_6__2__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_6__3"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4900:1: rule__TerminalExpr__Group_6__3 : rule__TerminalExpr__Group_6__3__Impl rule__TerminalExpr__Group_6__4 ;
    public final void rule__TerminalExpr__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4904:1: ( rule__TerminalExpr__Group_6__3__Impl rule__TerminalExpr__Group_6__4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4905:2: rule__TerminalExpr__Group_6__3__Impl rule__TerminalExpr__Group_6__4
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__3__Impl_in_rule__TerminalExpr__Group_6__39959);
            rule__TerminalExpr__Group_6__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__4_in_rule__TerminalExpr__Group_6__39962);
            rule__TerminalExpr__Group_6__4();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_6__3"


    // $ANTLR start "rule__TerminalExpr__Group_6__3__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4912:1: rule__TerminalExpr__Group_6__3__Impl : ( ( rule__TerminalExpr__FirstArgAssignment_6_3 ) ) ;
    public final void rule__TerminalExpr__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4916:1: ( ( ( rule__TerminalExpr__FirstArgAssignment_6_3 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4917:1: ( ( rule__TerminalExpr__FirstArgAssignment_6_3 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4917:1: ( ( rule__TerminalExpr__FirstArgAssignment_6_3 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4918:1: ( rule__TerminalExpr__FirstArgAssignment_6_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getFirstArgAssignment_6_3()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4919:1: ( rule__TerminalExpr__FirstArgAssignment_6_3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4919:2: rule__TerminalExpr__FirstArgAssignment_6_3
            {
            pushFollow(FOLLOW_rule__TerminalExpr__FirstArgAssignment_6_3_in_rule__TerminalExpr__Group_6__3__Impl9989);
            rule__TerminalExpr__FirstArgAssignment_6_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getFirstArgAssignment_6_3()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__Group_6__3__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_6__4"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4929:1: rule__TerminalExpr__Group_6__4 : rule__TerminalExpr__Group_6__4__Impl rule__TerminalExpr__Group_6__5 ;
    public final void rule__TerminalExpr__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4933:1: ( rule__TerminalExpr__Group_6__4__Impl rule__TerminalExpr__Group_6__5 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4934:2: rule__TerminalExpr__Group_6__4__Impl rule__TerminalExpr__Group_6__5
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__4__Impl_in_rule__TerminalExpr__Group_6__410019);
            rule__TerminalExpr__Group_6__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__5_in_rule__TerminalExpr__Group_6__410022);
            rule__TerminalExpr__Group_6__5();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_6__4"


    // $ANTLR start "rule__TerminalExpr__Group_6__4__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4941:1: rule__TerminalExpr__Group_6__4__Impl : ( ',' ) ;
    public final void rule__TerminalExpr__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4945:1: ( ( ',' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4946:1: ( ',' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4946:1: ( ',' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4947:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getCommaKeyword_6_4()); 
            }
            match(input,52,FOLLOW_52_in_rule__TerminalExpr__Group_6__4__Impl10050); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getCommaKeyword_6_4()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__Group_6__4__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_6__5"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4960:1: rule__TerminalExpr__Group_6__5 : rule__TerminalExpr__Group_6__5__Impl rule__TerminalExpr__Group_6__6 ;
    public final void rule__TerminalExpr__Group_6__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4964:1: ( rule__TerminalExpr__Group_6__5__Impl rule__TerminalExpr__Group_6__6 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4965:2: rule__TerminalExpr__Group_6__5__Impl rule__TerminalExpr__Group_6__6
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__5__Impl_in_rule__TerminalExpr__Group_6__510081);
            rule__TerminalExpr__Group_6__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__6_in_rule__TerminalExpr__Group_6__510084);
            rule__TerminalExpr__Group_6__6();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_6__5"


    // $ANTLR start "rule__TerminalExpr__Group_6__5__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4972:1: rule__TerminalExpr__Group_6__5__Impl : ( ( rule__TerminalExpr__SecondArgAssignment_6_5 ) ) ;
    public final void rule__TerminalExpr__Group_6__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4976:1: ( ( ( rule__TerminalExpr__SecondArgAssignment_6_5 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4977:1: ( ( rule__TerminalExpr__SecondArgAssignment_6_5 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4977:1: ( ( rule__TerminalExpr__SecondArgAssignment_6_5 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4978:1: ( rule__TerminalExpr__SecondArgAssignment_6_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getSecondArgAssignment_6_5()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4979:1: ( rule__TerminalExpr__SecondArgAssignment_6_5 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4979:2: rule__TerminalExpr__SecondArgAssignment_6_5
            {
            pushFollow(FOLLOW_rule__TerminalExpr__SecondArgAssignment_6_5_in_rule__TerminalExpr__Group_6__5__Impl10111);
            rule__TerminalExpr__SecondArgAssignment_6_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getSecondArgAssignment_6_5()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__Group_6__5__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_6__6"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4989:1: rule__TerminalExpr__Group_6__6 : rule__TerminalExpr__Group_6__6__Impl ;
    public final void rule__TerminalExpr__Group_6__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4993:1: ( rule__TerminalExpr__Group_6__6__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4994:2: rule__TerminalExpr__Group_6__6__Impl
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__6__Impl_in_rule__TerminalExpr__Group_6__610141);
            rule__TerminalExpr__Group_6__6__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_6__6"


    // $ANTLR start "rule__TerminalExpr__Group_6__6__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5000:1: rule__TerminalExpr__Group_6__6__Impl : ( ')' ) ;
    public final void rule__TerminalExpr__Group_6__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5004:1: ( ( ')' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5005:1: ( ')' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5005:1: ( ')' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5006:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getRightParenthesisKeyword_6_6()); 
            }
            match(input,51,FOLLOW_51_in_rule__TerminalExpr__Group_6__6__Impl10169); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getRightParenthesisKeyword_6_6()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__Group_6__6__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_8__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5033:1: rule__TerminalExpr__Group_8__0 : rule__TerminalExpr__Group_8__0__Impl rule__TerminalExpr__Group_8__1 ;
    public final void rule__TerminalExpr__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5037:1: ( rule__TerminalExpr__Group_8__0__Impl rule__TerminalExpr__Group_8__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5038:2: rule__TerminalExpr__Group_8__0__Impl rule__TerminalExpr__Group_8__1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_8__0__Impl_in_rule__TerminalExpr__Group_8__010214);
            rule__TerminalExpr__Group_8__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_8__1_in_rule__TerminalExpr__Group_8__010217);
            rule__TerminalExpr__Group_8__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_8__0"


    // $ANTLR start "rule__TerminalExpr__Group_8__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5045:1: rule__TerminalExpr__Group_8__0__Impl : ( '(' ) ;
    public final void rule__TerminalExpr__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5049:1: ( ( '(' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5050:1: ( '(' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5050:1: ( '(' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5051:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getLeftParenthesisKeyword_8_0()); 
            }
            match(input,50,FOLLOW_50_in_rule__TerminalExpr__Group_8__0__Impl10245); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getLeftParenthesisKeyword_8_0()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__Group_8__0__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_8__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5064:1: rule__TerminalExpr__Group_8__1 : rule__TerminalExpr__Group_8__1__Impl rule__TerminalExpr__Group_8__2 ;
    public final void rule__TerminalExpr__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5068:1: ( rule__TerminalExpr__Group_8__1__Impl rule__TerminalExpr__Group_8__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5069:2: rule__TerminalExpr__Group_8__1__Impl rule__TerminalExpr__Group_8__2
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_8__1__Impl_in_rule__TerminalExpr__Group_8__110276);
            rule__TerminalExpr__Group_8__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_8__2_in_rule__TerminalExpr__Group_8__110279);
            rule__TerminalExpr__Group_8__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_8__1"


    // $ANTLR start "rule__TerminalExpr__Group_8__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5076:1: rule__TerminalExpr__Group_8__1__Impl : ( ruleExpr ) ;
    public final void rule__TerminalExpr__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5080:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5081:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5081:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5082:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getExprParserRuleCall_8_1()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__TerminalExpr__Group_8__1__Impl10306);
            ruleExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getExprParserRuleCall_8_1()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__Group_8__1__Impl"


    // $ANTLR start "rule__TerminalExpr__Group_8__2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5093:1: rule__TerminalExpr__Group_8__2 : rule__TerminalExpr__Group_8__2__Impl ;
    public final void rule__TerminalExpr__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5097:1: ( rule__TerminalExpr__Group_8__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5098:2: rule__TerminalExpr__Group_8__2__Impl
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_8__2__Impl_in_rule__TerminalExpr__Group_8__210335);
            rule__TerminalExpr__Group_8__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TerminalExpr__Group_8__2"


    // $ANTLR start "rule__TerminalExpr__Group_8__2__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5104:1: rule__TerminalExpr__Group_8__2__Impl : ( ')' ) ;
    public final void rule__TerminalExpr__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5108:1: ( ( ')' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5109:1: ( ')' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5109:1: ( ')' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5110:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getRightParenthesisKeyword_8_2()); 
            }
            match(input,51,FOLLOW_51_in_rule__TerminalExpr__Group_8__2__Impl10363); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getRightParenthesisKeyword_8_2()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__Group_8__2__Impl"


    // $ANTLR start "rule__CallExpr__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5129:1: rule__CallExpr__Group__0 : rule__CallExpr__Group__0__Impl rule__CallExpr__Group__1 ;
    public final void rule__CallExpr__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5133:1: ( rule__CallExpr__Group__0__Impl rule__CallExpr__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5134:2: rule__CallExpr__Group__0__Impl rule__CallExpr__Group__1
            {
            pushFollow(FOLLOW_rule__CallExpr__Group__0__Impl_in_rule__CallExpr__Group__010400);
            rule__CallExpr__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CallExpr__Group__1_in_rule__CallExpr__Group__010403);
            rule__CallExpr__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__CallExpr__Group__0"


    // $ANTLR start "rule__CallExpr__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5141:1: rule__CallExpr__Group__0__Impl : ( ( rule__CallExpr__Group_0__0 )? ) ;
    public final void rule__CallExpr__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5145:1: ( ( ( rule__CallExpr__Group_0__0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5146:1: ( ( rule__CallExpr__Group_0__0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5146:1: ( ( rule__CallExpr__Group_0__0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5147:1: ( rule__CallExpr__Group_0__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getGroup_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5148:1: ( rule__CallExpr__Group_0__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_TIDENTIFIER) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==55) ) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5148:2: rule__CallExpr__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__CallExpr__Group_0__0_in_rule__CallExpr__Group__0__Impl10430);
                    rule__CallExpr__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprAccess().getGroup_0()); 
            }

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
    // $ANTLR end "rule__CallExpr__Group__0__Impl"


    // $ANTLR start "rule__CallExpr__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5158:1: rule__CallExpr__Group__1 : rule__CallExpr__Group__1__Impl rule__CallExpr__Group__2 ;
    public final void rule__CallExpr__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5162:1: ( rule__CallExpr__Group__1__Impl rule__CallExpr__Group__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5163:2: rule__CallExpr__Group__1__Impl rule__CallExpr__Group__2
            {
            pushFollow(FOLLOW_rule__CallExpr__Group__1__Impl_in_rule__CallExpr__Group__110461);
            rule__CallExpr__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CallExpr__Group__2_in_rule__CallExpr__Group__110464);
            rule__CallExpr__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__CallExpr__Group__1"


    // $ANTLR start "rule__CallExpr__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5170:1: rule__CallExpr__Group__1__Impl : ( ( rule__CallExpr__NameAssignment_1 ) ) ;
    public final void rule__CallExpr__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5174:1: ( ( ( rule__CallExpr__NameAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5175:1: ( ( rule__CallExpr__NameAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5175:1: ( ( rule__CallExpr__NameAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5176:1: ( rule__CallExpr__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getNameAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5177:1: ( rule__CallExpr__NameAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5177:2: rule__CallExpr__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__CallExpr__NameAssignment_1_in_rule__CallExpr__Group__1__Impl10491);
            rule__CallExpr__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprAccess().getNameAssignment_1()); 
            }

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
    // $ANTLR end "rule__CallExpr__Group__1__Impl"


    // $ANTLR start "rule__CallExpr__Group__2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5187:1: rule__CallExpr__Group__2 : rule__CallExpr__Group__2__Impl rule__CallExpr__Group__3 ;
    public final void rule__CallExpr__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5191:1: ( rule__CallExpr__Group__2__Impl rule__CallExpr__Group__3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5192:2: rule__CallExpr__Group__2__Impl rule__CallExpr__Group__3
            {
            pushFollow(FOLLOW_rule__CallExpr__Group__2__Impl_in_rule__CallExpr__Group__210521);
            rule__CallExpr__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CallExpr__Group__3_in_rule__CallExpr__Group__210524);
            rule__CallExpr__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__CallExpr__Group__2"


    // $ANTLR start "rule__CallExpr__Group__2__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5199:1: rule__CallExpr__Group__2__Impl : ( '(' ) ;
    public final void rule__CallExpr__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5203:1: ( ( '(' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5204:1: ( '(' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5204:1: ( '(' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5205:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,50,FOLLOW_50_in_rule__CallExpr__Group__2__Impl10552); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprAccess().getLeftParenthesisKeyword_2()); 
            }

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
    // $ANTLR end "rule__CallExpr__Group__2__Impl"


    // $ANTLR start "rule__CallExpr__Group__3"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5218:1: rule__CallExpr__Group__3 : rule__CallExpr__Group__3__Impl rule__CallExpr__Group__4 ;
    public final void rule__CallExpr__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5222:1: ( rule__CallExpr__Group__3__Impl rule__CallExpr__Group__4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5223:2: rule__CallExpr__Group__3__Impl rule__CallExpr__Group__4
            {
            pushFollow(FOLLOW_rule__CallExpr__Group__3__Impl_in_rule__CallExpr__Group__310583);
            rule__CallExpr__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CallExpr__Group__4_in_rule__CallExpr__Group__310586);
            rule__CallExpr__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__CallExpr__Group__3"


    // $ANTLR start "rule__CallExpr__Group__3__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5230:1: rule__CallExpr__Group__3__Impl : ( ( rule__CallExpr__ArgListAssignment_3 ) ) ;
    public final void rule__CallExpr__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5234:1: ( ( ( rule__CallExpr__ArgListAssignment_3 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5235:1: ( ( rule__CallExpr__ArgListAssignment_3 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5235:1: ( ( rule__CallExpr__ArgListAssignment_3 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5236:1: ( rule__CallExpr__ArgListAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getArgListAssignment_3()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5237:1: ( rule__CallExpr__ArgListAssignment_3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5237:2: rule__CallExpr__ArgListAssignment_3
            {
            pushFollow(FOLLOW_rule__CallExpr__ArgListAssignment_3_in_rule__CallExpr__Group__3__Impl10613);
            rule__CallExpr__ArgListAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprAccess().getArgListAssignment_3()); 
            }

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
    // $ANTLR end "rule__CallExpr__Group__3__Impl"


    // $ANTLR start "rule__CallExpr__Group__4"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5247:1: rule__CallExpr__Group__4 : rule__CallExpr__Group__4__Impl rule__CallExpr__Group__5 ;
    public final void rule__CallExpr__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5251:1: ( rule__CallExpr__Group__4__Impl rule__CallExpr__Group__5 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5252:2: rule__CallExpr__Group__4__Impl rule__CallExpr__Group__5
            {
            pushFollow(FOLLOW_rule__CallExpr__Group__4__Impl_in_rule__CallExpr__Group__410643);
            rule__CallExpr__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CallExpr__Group__5_in_rule__CallExpr__Group__410646);
            rule__CallExpr__Group__5();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__CallExpr__Group__4"


    // $ANTLR start "rule__CallExpr__Group__4__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5259:1: rule__CallExpr__Group__4__Impl : ( ')' ) ;
    public final void rule__CallExpr__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5263:1: ( ( ')' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5264:1: ( ')' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5264:1: ( ')' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5265:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,51,FOLLOW_51_in_rule__CallExpr__Group__4__Impl10674); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprAccess().getRightParenthesisKeyword_4()); 
            }

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
    // $ANTLR end "rule__CallExpr__Group__4__Impl"


    // $ANTLR start "rule__CallExpr__Group__5"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5278:1: rule__CallExpr__Group__5 : rule__CallExpr__Group__5__Impl ;
    public final void rule__CallExpr__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5282:1: ( rule__CallExpr__Group__5__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5283:2: rule__CallExpr__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__CallExpr__Group__5__Impl_in_rule__CallExpr__Group__510705);
            rule__CallExpr__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__CallExpr__Group__5"


    // $ANTLR start "rule__CallExpr__Group__5__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5289:1: rule__CallExpr__Group__5__Impl : ( ( rule__CallExpr__Group_5__0 )? ) ;
    public final void rule__CallExpr__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5293:1: ( ( ( rule__CallExpr__Group_5__0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5294:1: ( ( rule__CallExpr__Group_5__0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5294:1: ( ( rule__CallExpr__Group_5__0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5295:1: ( rule__CallExpr__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getGroup_5()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5296:1: ( rule__CallExpr__Group_5__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==53) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5296:2: rule__CallExpr__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__CallExpr__Group_5__0_in_rule__CallExpr__Group__5__Impl10732);
                    rule__CallExpr__Group_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprAccess().getGroup_5()); 
            }

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
    // $ANTLR end "rule__CallExpr__Group__5__Impl"


    // $ANTLR start "rule__CallExpr__Group_0__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5318:1: rule__CallExpr__Group_0__0 : rule__CallExpr__Group_0__0__Impl rule__CallExpr__Group_0__1 ;
    public final void rule__CallExpr__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5322:1: ( rule__CallExpr__Group_0__0__Impl rule__CallExpr__Group_0__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5323:2: rule__CallExpr__Group_0__0__Impl rule__CallExpr__Group_0__1
            {
            pushFollow(FOLLOW_rule__CallExpr__Group_0__0__Impl_in_rule__CallExpr__Group_0__010775);
            rule__CallExpr__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CallExpr__Group_0__1_in_rule__CallExpr__Group_0__010778);
            rule__CallExpr__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__CallExpr__Group_0__0"


    // $ANTLR start "rule__CallExpr__Group_0__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5330:1: rule__CallExpr__Group_0__0__Impl : ( ( rule__CallExpr__NamespaceAssignment_0_0 ) ) ;
    public final void rule__CallExpr__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5334:1: ( ( ( rule__CallExpr__NamespaceAssignment_0_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5335:1: ( ( rule__CallExpr__NamespaceAssignment_0_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5335:1: ( ( rule__CallExpr__NamespaceAssignment_0_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5336:1: ( rule__CallExpr__NamespaceAssignment_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getNamespaceAssignment_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5337:1: ( rule__CallExpr__NamespaceAssignment_0_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5337:2: rule__CallExpr__NamespaceAssignment_0_0
            {
            pushFollow(FOLLOW_rule__CallExpr__NamespaceAssignment_0_0_in_rule__CallExpr__Group_0__0__Impl10805);
            rule__CallExpr__NamespaceAssignment_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprAccess().getNamespaceAssignment_0_0()); 
            }

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
    // $ANTLR end "rule__CallExpr__Group_0__0__Impl"


    // $ANTLR start "rule__CallExpr__Group_0__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5347:1: rule__CallExpr__Group_0__1 : rule__CallExpr__Group_0__1__Impl ;
    public final void rule__CallExpr__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5351:1: ( rule__CallExpr__Group_0__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5352:2: rule__CallExpr__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__CallExpr__Group_0__1__Impl_in_rule__CallExpr__Group_0__110835);
            rule__CallExpr__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__CallExpr__Group_0__1"


    // $ANTLR start "rule__CallExpr__Group_0__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5358:1: rule__CallExpr__Group_0__1__Impl : ( '::' ) ;
    public final void rule__CallExpr__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5362:1: ( ( '::' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5363:1: ( '::' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5363:1: ( '::' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5364:1: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getColonColonKeyword_0_1()); 
            }
            match(input,55,FOLLOW_55_in_rule__CallExpr__Group_0__1__Impl10863); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprAccess().getColonColonKeyword_0_1()); 
            }

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
    // $ANTLR end "rule__CallExpr__Group_0__1__Impl"


    // $ANTLR start "rule__CallExpr__Group_5__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5381:1: rule__CallExpr__Group_5__0 : rule__CallExpr__Group_5__0__Impl rule__CallExpr__Group_5__1 ;
    public final void rule__CallExpr__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5385:1: ( rule__CallExpr__Group_5__0__Impl rule__CallExpr__Group_5__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5386:2: rule__CallExpr__Group_5__0__Impl rule__CallExpr__Group_5__1
            {
            pushFollow(FOLLOW_rule__CallExpr__Group_5__0__Impl_in_rule__CallExpr__Group_5__010898);
            rule__CallExpr__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CallExpr__Group_5__1_in_rule__CallExpr__Group_5__010901);
            rule__CallExpr__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__CallExpr__Group_5__0"


    // $ANTLR start "rule__CallExpr__Group_5__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5393:1: rule__CallExpr__Group_5__0__Impl : ( '@' ) ;
    public final void rule__CallExpr__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5397:1: ( ( '@' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5398:1: ( '@' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5398:1: ( '@' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5399:1: '@'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getCommercialAtKeyword_5_0()); 
            }
            match(input,53,FOLLOW_53_in_rule__CallExpr__Group_5__0__Impl10929); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprAccess().getCommercialAtKeyword_5_0()); 
            }

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
    // $ANTLR end "rule__CallExpr__Group_5__0__Impl"


    // $ANTLR start "rule__CallExpr__Group_5__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5412:1: rule__CallExpr__Group_5__1 : rule__CallExpr__Group_5__1__Impl ;
    public final void rule__CallExpr__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5416:1: ( rule__CallExpr__Group_5__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5417:2: rule__CallExpr__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__CallExpr__Group_5__1__Impl_in_rule__CallExpr__Group_5__110960);
            rule__CallExpr__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__CallExpr__Group_5__1"


    // $ANTLR start "rule__CallExpr__Group_5__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5423:1: rule__CallExpr__Group_5__1__Impl : ( ( rule__CallExpr__AtAssignment_5_1 ) ) ;
    public final void rule__CallExpr__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5427:1: ( ( ( rule__CallExpr__AtAssignment_5_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5428:1: ( ( rule__CallExpr__AtAssignment_5_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5428:1: ( ( rule__CallExpr__AtAssignment_5_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5429:1: ( rule__CallExpr__AtAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getAtAssignment_5_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5430:1: ( rule__CallExpr__AtAssignment_5_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5430:2: rule__CallExpr__AtAssignment_5_1
            {
            pushFollow(FOLLOW_rule__CallExpr__AtAssignment_5_1_in_rule__CallExpr__Group_5__1__Impl10987);
            rule__CallExpr__AtAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprAccess().getAtAssignment_5_1()); 
            }

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
    // $ANTLR end "rule__CallExpr__Group_5__1__Impl"


    // $ANTLR start "rule__ArgList__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5444:1: rule__ArgList__Group__0 : rule__ArgList__Group__0__Impl rule__ArgList__Group__1 ;
    public final void rule__ArgList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5448:1: ( rule__ArgList__Group__0__Impl rule__ArgList__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5449:2: rule__ArgList__Group__0__Impl rule__ArgList__Group__1
            {
            pushFollow(FOLLOW_rule__ArgList__Group__0__Impl_in_rule__ArgList__Group__011021);
            rule__ArgList__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ArgList__Group__1_in_rule__ArgList__Group__011024);
            rule__ArgList__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ArgList__Group__0"


    // $ANTLR start "rule__ArgList__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5456:1: rule__ArgList__Group__0__Impl : ( () ) ;
    public final void rule__ArgList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5460:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5461:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5461:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5462:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getArgListAction_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5463:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5465:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArgListAccess().getArgListAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgList__Group__0__Impl"


    // $ANTLR start "rule__ArgList__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5475:1: rule__ArgList__Group__1 : rule__ArgList__Group__1__Impl ;
    public final void rule__ArgList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5479:1: ( rule__ArgList__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5480:2: rule__ArgList__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ArgList__Group__1__Impl_in_rule__ArgList__Group__111082);
            rule__ArgList__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ArgList__Group__1"


    // $ANTLR start "rule__ArgList__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5486:1: rule__ArgList__Group__1__Impl : ( ( rule__ArgList__Group_1__0 )? ) ;
    public final void rule__ArgList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5490:1: ( ( ( rule__ArgList__Group_1__0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5491:1: ( ( rule__ArgList__Group_1__0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5491:1: ( ( rule__ArgList__Group_1__0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5492:1: ( rule__ArgList__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getGroup_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5493:1: ( rule__ArgList__Group_1__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=RULE_INT && LA42_0<=RULE_TIDENTIFIER)||(LA42_0>=19 && LA42_0<=20)||(LA42_0>=29 && LA42_0<=35)||(LA42_0>=41 && LA42_0<=42)||LA42_0==46||LA42_0==50||LA42_0==54) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5493:2: rule__ArgList__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ArgList__Group_1__0_in_rule__ArgList__Group__1__Impl11109);
                    rule__ArgList__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArgListAccess().getGroup_1()); 
            }

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
    // $ANTLR end "rule__ArgList__Group__1__Impl"


    // $ANTLR start "rule__ArgList__Group_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5507:1: rule__ArgList__Group_1__0 : rule__ArgList__Group_1__0__Impl rule__ArgList__Group_1__1 ;
    public final void rule__ArgList__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5511:1: ( rule__ArgList__Group_1__0__Impl rule__ArgList__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5512:2: rule__ArgList__Group_1__0__Impl rule__ArgList__Group_1__1
            {
            pushFollow(FOLLOW_rule__ArgList__Group_1__0__Impl_in_rule__ArgList__Group_1__011144);
            rule__ArgList__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ArgList__Group_1__1_in_rule__ArgList__Group_1__011147);
            rule__ArgList__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ArgList__Group_1__0"


    // $ANTLR start "rule__ArgList__Group_1__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5519:1: rule__ArgList__Group_1__0__Impl : ( ( rule__ArgList__ArgsAssignment_1_0 ) ) ;
    public final void rule__ArgList__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5523:1: ( ( ( rule__ArgList__ArgsAssignment_1_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5524:1: ( ( rule__ArgList__ArgsAssignment_1_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5524:1: ( ( rule__ArgList__ArgsAssignment_1_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5525:1: ( rule__ArgList__ArgsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getArgsAssignment_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5526:1: ( rule__ArgList__ArgsAssignment_1_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5526:2: rule__ArgList__ArgsAssignment_1_0
            {
            pushFollow(FOLLOW_rule__ArgList__ArgsAssignment_1_0_in_rule__ArgList__Group_1__0__Impl11174);
            rule__ArgList__ArgsAssignment_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArgListAccess().getArgsAssignment_1_0()); 
            }

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
    // $ANTLR end "rule__ArgList__Group_1__0__Impl"


    // $ANTLR start "rule__ArgList__Group_1__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5536:1: rule__ArgList__Group_1__1 : rule__ArgList__Group_1__1__Impl ;
    public final void rule__ArgList__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5540:1: ( rule__ArgList__Group_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5541:2: rule__ArgList__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ArgList__Group_1__1__Impl_in_rule__ArgList__Group_1__111204);
            rule__ArgList__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ArgList__Group_1__1"


    // $ANTLR start "rule__ArgList__Group_1__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5547:1: rule__ArgList__Group_1__1__Impl : ( ( rule__ArgList__Group_1_1__0 )* ) ;
    public final void rule__ArgList__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5551:1: ( ( ( rule__ArgList__Group_1_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5552:1: ( ( rule__ArgList__Group_1_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5552:1: ( ( rule__ArgList__Group_1_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5553:1: ( rule__ArgList__Group_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getGroup_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5554:1: ( rule__ArgList__Group_1_1__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==52) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5554:2: rule__ArgList__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ArgList__Group_1_1__0_in_rule__ArgList__Group_1__1__Impl11231);
            	    rule__ArgList__Group_1_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArgListAccess().getGroup_1_1()); 
            }

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
    // $ANTLR end "rule__ArgList__Group_1__1__Impl"


    // $ANTLR start "rule__ArgList__Group_1_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5568:1: rule__ArgList__Group_1_1__0 : rule__ArgList__Group_1_1__0__Impl rule__ArgList__Group_1_1__1 ;
    public final void rule__ArgList__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5572:1: ( rule__ArgList__Group_1_1__0__Impl rule__ArgList__Group_1_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5573:2: rule__ArgList__Group_1_1__0__Impl rule__ArgList__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__ArgList__Group_1_1__0__Impl_in_rule__ArgList__Group_1_1__011266);
            rule__ArgList__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ArgList__Group_1_1__1_in_rule__ArgList__Group_1_1__011269);
            rule__ArgList__Group_1_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ArgList__Group_1_1__0"


    // $ANTLR start "rule__ArgList__Group_1_1__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5580:1: rule__ArgList__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__ArgList__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5584:1: ( ( ',' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5585:1: ( ',' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5585:1: ( ',' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5586:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getCommaKeyword_1_1_0()); 
            }
            match(input,52,FOLLOW_52_in_rule__ArgList__Group_1_1__0__Impl11297); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArgListAccess().getCommaKeyword_1_1_0()); 
            }

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
    // $ANTLR end "rule__ArgList__Group_1_1__0__Impl"


    // $ANTLR start "rule__ArgList__Group_1_1__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5599:1: rule__ArgList__Group_1_1__1 : rule__ArgList__Group_1_1__1__Impl ;
    public final void rule__ArgList__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5603:1: ( rule__ArgList__Group_1_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5604:2: rule__ArgList__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ArgList__Group_1_1__1__Impl_in_rule__ArgList__Group_1_1__111328);
            rule__ArgList__Group_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ArgList__Group_1_1__1"


    // $ANTLR start "rule__ArgList__Group_1_1__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5610:1: rule__ArgList__Group_1_1__1__Impl : ( ( rule__ArgList__ArgsAssignment_1_1_1 ) ) ;
    public final void rule__ArgList__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5614:1: ( ( ( rule__ArgList__ArgsAssignment_1_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5615:1: ( ( rule__ArgList__ArgsAssignment_1_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5615:1: ( ( rule__ArgList__ArgsAssignment_1_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5616:1: ( rule__ArgList__ArgsAssignment_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getArgsAssignment_1_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5617:1: ( rule__ArgList__ArgsAssignment_1_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5617:2: rule__ArgList__ArgsAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__ArgList__ArgsAssignment_1_1_1_in_rule__ArgList__Group_1_1__1__Impl11355);
            rule__ArgList__ArgsAssignment_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArgListAccess().getArgsAssignment_1_1_1()); 
            }

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
    // $ANTLR end "rule__ArgList__Group_1_1__1__Impl"


    // $ANTLR start "rule__Double__Group_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5631:1: rule__Double__Group_1__0 : rule__Double__Group_1__0__Impl rule__Double__Group_1__1 ;
    public final void rule__Double__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5635:1: ( rule__Double__Group_1__0__Impl rule__Double__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5636:2: rule__Double__Group_1__0__Impl rule__Double__Group_1__1
            {
            pushFollow(FOLLOW_rule__Double__Group_1__0__Impl_in_rule__Double__Group_1__011389);
            rule__Double__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Double__Group_1__1_in_rule__Double__Group_1__011392);
            rule__Double__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5643:1: rule__Double__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__Double__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5647:1: ( ( RULE_INT ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5648:1: ( RULE_INT )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5648:1: ( RULE_INT )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5649:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Double__Group_1__0__Impl11419); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5660:1: rule__Double__Group_1__1 : rule__Double__Group_1__1__Impl rule__Double__Group_1__2 ;
    public final void rule__Double__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5664:1: ( rule__Double__Group_1__1__Impl rule__Double__Group_1__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5665:2: rule__Double__Group_1__1__Impl rule__Double__Group_1__2
            {
            pushFollow(FOLLOW_rule__Double__Group_1__1__Impl_in_rule__Double__Group_1__111448);
            rule__Double__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Double__Group_1__2_in_rule__Double__Group_1__111451);
            rule__Double__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5672:1: rule__Double__Group_1__1__Impl : ( '.' ) ;
    public final void rule__Double__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5676:1: ( ( '.' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5677:1: ( '.' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5677:1: ( '.' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5678:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleAccess().getFullStopKeyword_1_1()); 
            }
            match(input,56,FOLLOW_56_in_rule__Double__Group_1__1__Impl11479); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleAccess().getFullStopKeyword_1_1()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5691:1: rule__Double__Group_1__2 : rule__Double__Group_1__2__Impl ;
    public final void rule__Double__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5695:1: ( rule__Double__Group_1__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5696:2: rule__Double__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Double__Group_1__2__Impl_in_rule__Double__Group_1__211510);
            rule__Double__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5702:1: rule__Double__Group_1__2__Impl : ( ( RULE_INT )? ) ;
    public final void rule__Double__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5706:1: ( ( ( RULE_INT )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5707:1: ( ( RULE_INT )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5707:1: ( ( RULE_INT )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5708:1: ( RULE_INT )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_2()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5709:1: ( RULE_INT )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_INT) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5709:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Double__Group_1__2__Impl11538); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_2()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5726:1: rule__Program__ProgramElementsAssignment_1 : ( ruleProgramElement ) ;
    public final void rule__Program__ProgramElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5730:1: ( ( ruleProgramElement ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5731:1: ( ruleProgramElement )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5731:1: ( ruleProgramElement )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5732:1: ruleProgramElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getProgramElementsProgramElementParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleProgramElement_in_rule__Program__ProgramElementsAssignment_111580);
            ruleProgramElement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProgramAccess().getProgramElementsProgramElementParserRuleCall_1_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5741:1: rule__DmplSubclause__ProgramAssignment_1 : ( ruleProgram ) ;
    public final void rule__DmplSubclause__ProgramAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5745:1: ( ( ruleProgram ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5746:1: ( ruleProgram )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5746:1: ( ruleProgram )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5747:1: ruleProgram
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDmplSubclauseAccess().getProgramProgramParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleProgram_in_rule__DmplSubclause__ProgramAssignment_111611);
            ruleProgram();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDmplSubclauseAccess().getProgramProgramParserRuleCall_1_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5756:1: rule__Constant__NameAssignment_1 : ( RULE_TIDENTIFIER ) ;
    public final void rule__Constant__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5760:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5761:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5761:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5762:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getNameTIDENTIFIERTerminalRuleCall_1_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__Constant__NameAssignment_111642); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantAccess().getNameTIDENTIFIERTerminalRuleCall_1_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5771:1: rule__Constant__ValueAssignment_3 : ( ruleNumberConst ) ;
    public final void rule__Constant__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5775:1: ( ( ruleNumberConst ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5776:1: ( ruleNumberConst )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5776:1: ( ruleNumberConst )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5777:1: ruleNumberConst
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getValueNumberConstParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleNumberConst_in_rule__Constant__ValueAssignment_311673);
            ruleNumberConst();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstantAccess().getValueNumberConstParserRuleCall_3_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5786:1: rule__IntConst__SignAssignment_0 : ( ruleSign ) ;
    public final void rule__IntConst__SignAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5790:1: ( ( ruleSign ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5791:1: ( ruleSign )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5791:1: ( ruleSign )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5792:1: ruleSign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntConstAccess().getSignSignParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleSign_in_rule__IntConst__SignAssignment_011704);
            ruleSign();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntConstAccess().getSignSignParserRuleCall_0_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5801:1: rule__IntConst__ValueAssignment_1 : ( RULE_INT ) ;
    public final void rule__IntConst__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5805:1: ( ( RULE_INT ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5806:1: ( RULE_INT )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5806:1: ( RULE_INT )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5807:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntConstAccess().getValueINTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__IntConst__ValueAssignment_111735); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntConstAccess().getValueINTTerminalRuleCall_1_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5816:1: rule__DoubleConst__SignAssignment_0 : ( ruleSign ) ;
    public final void rule__DoubleConst__SignAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5820:1: ( ( ruleSign ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5821:1: ( ruleSign )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5821:1: ( ruleSign )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5822:1: ruleSign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleConstAccess().getSignSignParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleSign_in_rule__DoubleConst__SignAssignment_011766);
            ruleSign();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleConstAccess().getSignSignParserRuleCall_0_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5831:1: rule__DoubleConst__ValueAssignment_1 : ( ruleDouble ) ;
    public final void rule__DoubleConst__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5835:1: ( ( ruleDouble ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5836:1: ( ruleDouble )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5836:1: ( ruleDouble )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5837:1: ruleDouble
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleConstAccess().getValueDoubleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleDouble_in_rule__DoubleConst__ValueAssignment_111797);
            ruleDouble();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleConstAccess().getValueDoubleParserRuleCall_1_0()); 
            }

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


    // $ANTLR start "rule__VarInit__TypeAssignment_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5846:1: rule__VarInit__TypeAssignment_0 : ( ruleType ) ;
    public final void rule__VarInit__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5850:1: ( ( ruleType ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5851:1: ( ruleType )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5851:1: ( ruleType )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5852:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitAccess().getTypeTypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleType_in_rule__VarInit__TypeAssignment_011828);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarInitAccess().getTypeTypeParserRuleCall_0_0()); 
            }

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
    // $ANTLR end "rule__VarInit__TypeAssignment_0"


    // $ANTLR start "rule__VarInit__VarAsgnListAssignment_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5861:1: rule__VarInit__VarAsgnListAssignment_1 : ( ruleVarAsgnList ) ;
    public final void rule__VarInit__VarAsgnListAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5865:1: ( ( ruleVarAsgnList ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5866:1: ( ruleVarAsgnList )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5866:1: ( ruleVarAsgnList )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5867:1: ruleVarAsgnList
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitAccess().getVarAsgnListVarAsgnListParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleVarAsgnList_in_rule__VarInit__VarAsgnListAssignment_111859);
            ruleVarAsgnList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarInitAccess().getVarAsgnListVarAsgnListParserRuleCall_1_0()); 
            }

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
    // $ANTLR end "rule__VarInit__VarAsgnListAssignment_1"


    // $ANTLR start "rule__VarAsgnList__VarAssignment_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5876:1: rule__VarAsgnList__VarAssignment_0 : ( ruleVar ) ;
    public final void rule__VarAsgnList__VarAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5880:1: ( ( ruleVar ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5881:1: ( ruleVar )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5881:1: ( ruleVar )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5882:1: ruleVar
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnListAccess().getVarVarParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleVar_in_rule__VarAsgnList__VarAssignment_011890);
            ruleVar();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAsgnListAccess().getVarVarParserRuleCall_0_0()); 
            }

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
    // $ANTLR end "rule__VarAsgnList__VarAssignment_0"


    // $ANTLR start "rule__VarAsgnList__VarAsgnAssignment_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5891:1: rule__VarAsgnList__VarAsgnAssignment_1 : ( ruleVarAsgn ) ;
    public final void rule__VarAsgnList__VarAsgnAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5895:1: ( ( ruleVarAsgn ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5896:1: ( ruleVarAsgn )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5896:1: ( ruleVarAsgn )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5897:1: ruleVarAsgn
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnListAccess().getVarAsgnVarAsgnParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleVarAsgn_in_rule__VarAsgnList__VarAsgnAssignment_111921);
            ruleVarAsgn();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAsgnListAccess().getVarAsgnVarAsgnParserRuleCall_1_0()); 
            }

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
    // $ANTLR end "rule__VarAsgnList__VarAsgnAssignment_1"


    // $ANTLR start "rule__VarAsgn__VarAssignment_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5906:1: rule__VarAsgn__VarAssignment_0 : ( ruleVar ) ;
    public final void rule__VarAsgn__VarAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5910:1: ( ( ruleVar ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5911:1: ( ruleVar )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5911:1: ( ruleVar )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5912:1: ruleVar
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnAccess().getVarVarParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleVar_in_rule__VarAsgn__VarAssignment_011952);
            ruleVar();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAsgnAccess().getVarVarParserRuleCall_0_0()); 
            }

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
    // $ANTLR end "rule__VarAsgn__VarAssignment_0"


    // $ANTLR start "rule__VarAsgn__FnBodyAssignment_2_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5921:1: rule__VarAsgn__FnBodyAssignment_2_0 : ( ruleFnBody ) ;
    public final void rule__VarAsgn__FnBodyAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5925:1: ( ( ruleFnBody ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5926:1: ( ruleFnBody )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5926:1: ( ruleFnBody )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5927:1: ruleFnBody
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnAccess().getFnBodyFnBodyParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_ruleFnBody_in_rule__VarAsgn__FnBodyAssignment_2_011983);
            ruleFnBody();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAsgnAccess().getFnBodyFnBodyParserRuleCall_2_0_0()); 
            }

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
    // $ANTLR end "rule__VarAsgn__FnBodyAssignment_2_0"


    // $ANTLR start "rule__VarAsgn__ExprAssignment_2_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5936:1: rule__VarAsgn__ExprAssignment_2_1 : ( ruleExpr ) ;
    public final void rule__VarAsgn__ExprAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5940:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5941:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5941:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5942:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnAccess().getExprExprParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__VarAsgn__ExprAssignment_2_112014);
            ruleExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAsgnAccess().getExprExprParserRuleCall_2_1_0()); 
            }

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
    // $ANTLR end "rule__VarAsgn__ExprAssignment_2_1"


    // $ANTLR start "rule__Var__NameAssignment_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5951:1: rule__Var__NameAssignment_0 : ( RULE_TIDENTIFIER ) ;
    public final void rule__Var__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5955:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5956:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5956:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5957:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAccess().getNameTIDENTIFIERTerminalRuleCall_0_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__Var__NameAssignment_012045); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAccess().getNameTIDENTIFIERTerminalRuleCall_0_0()); 
            }

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
    // $ANTLR end "rule__Var__NameAssignment_0"


    // $ANTLR start "rule__Var__DimensionsAssignment_1_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5966:1: rule__Var__DimensionsAssignment_1_1 : ( ruleDimension ) ;
    public final void rule__Var__DimensionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5970:1: ( ( ruleDimension ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5971:1: ( ruleDimension )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5971:1: ( ruleDimension )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5972:1: ruleDimension
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAccess().getDimensionsDimensionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleDimension_in_rule__Var__DimensionsAssignment_1_112076);
            ruleDimension();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarAccess().getDimensionsDimensionParserRuleCall_1_1_0()); 
            }

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
    // $ANTLR end "rule__Var__DimensionsAssignment_1_1"


    // $ANTLR start "rule__Dimension__IndexAssignment_0_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5981:1: rule__Dimension__IndexAssignment_0_1 : ( RULE_INT ) ;
    public final void rule__Dimension__IndexAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5985:1: ( ( RULE_INT ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5986:1: ( RULE_INT )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5986:1: ( RULE_INT )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5987:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getIndexINTTerminalRuleCall_0_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Dimension__IndexAssignment_0_112107); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDimensionAccess().getIndexINTTerminalRuleCall_0_1_0()); 
            }

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
    // $ANTLR end "rule__Dimension__IndexAssignment_0_1"


    // $ANTLR start "rule__Dimension__IndexAssignment_2_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5996:1: rule__Dimension__IndexAssignment_2_1 : ( RULE_TIDENTIFIER ) ;
    public final void rule__Dimension__IndexAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6000:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6001:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6001:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6002:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getIndexTIDENTIFIERTerminalRuleCall_2_1_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__Dimension__IndexAssignment_2_112138); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDimensionAccess().getIndexTIDENTIFIERTerminalRuleCall_2_1_0()); 
            }

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
    // $ANTLR end "rule__Dimension__IndexAssignment_2_1"


    // $ANTLR start "rule__Type__SignedAssignment_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6011:1: rule__Type__SignedAssignment_0 : ( ruleSigned ) ;
    public final void rule__Type__SignedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6015:1: ( ( ruleSigned ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6016:1: ( ruleSigned )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6016:1: ( ruleSigned )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6017:1: ruleSigned
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getSignedSignedParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleSigned_in_rule__Type__SignedAssignment_012169);
            ruleSigned();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAccess().getSignedSignedParserRuleCall_0_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6026:1: rule__Type__SimpTypeAssignment_1 : ( ruleSimpType ) ;
    public final void rule__Type__SimpTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6030:1: ( ( ruleSimpType ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6031:1: ( ruleSimpType )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6031:1: ( ruleSimpType )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6032:1: ruleSimpType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getSimpTypeSimpTypeParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleSimpType_in_rule__Type__SimpTypeAssignment_112200);
            ruleSimpType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAccess().getSimpTypeSimpTypeParserRuleCall_1_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6041:1: rule__Procedure__ProcedureAssignment : ( ruleProcNoAttr ) ;
    public final void rule__Procedure__ProcedureAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6045:1: ( ( ruleProcNoAttr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6046:1: ( ruleProcNoAttr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6046:1: ( ruleProcNoAttr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6047:1: ruleProcNoAttr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProcedureAccess().getProcedureProcNoAttrParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleProcNoAttr_in_rule__Procedure__ProcedureAssignment12231);
            ruleProcNoAttr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProcedureAccess().getProcedureProcNoAttrParserRuleCall_0()); 
            }

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6056:1: rule__ProcNoAttr__PrototypeAssignment_0 : ( ruleFnPrototype ) ;
    public final void rule__ProcNoAttr__PrototypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6060:1: ( ( ruleFnPrototype ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6061:1: ( ruleFnPrototype )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6061:1: ( ruleFnPrototype )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6062:1: ruleFnPrototype
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProcNoAttrAccess().getPrototypeFnPrototypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleFnPrototype_in_rule__ProcNoAttr__PrototypeAssignment_012262);
            ruleFnPrototype();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProcNoAttrAccess().getPrototypeFnPrototypeParserRuleCall_0_0()); 
            }

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


    // $ANTLR start "rule__ProcNoAttr__FnBodyAssignment_1_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6071:1: rule__ProcNoAttr__FnBodyAssignment_1_1 : ( ruleFnBody ) ;
    public final void rule__ProcNoAttr__FnBodyAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6075:1: ( ( ruleFnBody ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6076:1: ( ruleFnBody )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6076:1: ( ruleFnBody )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6077:1: ruleFnBody
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProcNoAttrAccess().getFnBodyFnBodyParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleFnBody_in_rule__ProcNoAttr__FnBodyAssignment_1_112293);
            ruleFnBody();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getProcNoAttrAccess().getFnBodyFnBodyParserRuleCall_1_1_0()); 
            }

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
    // $ANTLR end "rule__ProcNoAttr__FnBodyAssignment_1_1"


    // $ANTLR start "rule__FnBody__VarInitListAssignment_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6086:1: rule__FnBody__VarInitListAssignment_1 : ( ruleVarInitList ) ;
    public final void rule__FnBody__VarInitListAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6090:1: ( ( ruleVarInitList ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6091:1: ( ruleVarInitList )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6091:1: ( ruleVarInitList )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6092:1: ruleVarInitList
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnBodyAccess().getVarInitListVarInitListParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleVarInitList_in_rule__FnBody__VarInitListAssignment_112324);
            ruleVarInitList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnBodyAccess().getVarInitListVarInitListParserRuleCall_1_0()); 
            }

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
    // $ANTLR end "rule__FnBody__VarInitListAssignment_1"


    // $ANTLR start "rule__FnPrototype__ExternAssignment_0_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6101:1: rule__FnPrototype__ExternAssignment_0_1 : ( ( rule__FnPrototype__ExternAlternatives_0_1_0 ) ) ;
    public final void rule__FnPrototype__ExternAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6105:1: ( ( ( rule__FnPrototype__ExternAlternatives_0_1_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6106:1: ( ( rule__FnPrototype__ExternAlternatives_0_1_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6106:1: ( ( rule__FnPrototype__ExternAlternatives_0_1_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6107:1: ( rule__FnPrototype__ExternAlternatives_0_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getExternAlternatives_0_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6108:1: ( rule__FnPrototype__ExternAlternatives_0_1_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6108:2: rule__FnPrototype__ExternAlternatives_0_1_0
            {
            pushFollow(FOLLOW_rule__FnPrototype__ExternAlternatives_0_1_0_in_rule__FnPrototype__ExternAssignment_0_112355);
            rule__FnPrototype__ExternAlternatives_0_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getExternAlternatives_0_1_0()); 
            }

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
    // $ANTLR end "rule__FnPrototype__ExternAssignment_0_1"


    // $ANTLR start "rule__FnPrototype__PureAssignment_0_2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6117:1: rule__FnPrototype__PureAssignment_0_2 : ( ( rule__FnPrototype__PureAlternatives_0_2_0 ) ) ;
    public final void rule__FnPrototype__PureAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6121:1: ( ( ( rule__FnPrototype__PureAlternatives_0_2_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6122:1: ( ( rule__FnPrototype__PureAlternatives_0_2_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6122:1: ( ( rule__FnPrototype__PureAlternatives_0_2_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6123:1: ( rule__FnPrototype__PureAlternatives_0_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getPureAlternatives_0_2_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6124:1: ( rule__FnPrototype__PureAlternatives_0_2_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6124:2: rule__FnPrototype__PureAlternatives_0_2_0
            {
            pushFollow(FOLLOW_rule__FnPrototype__PureAlternatives_0_2_0_in_rule__FnPrototype__PureAssignment_0_212388);
            rule__FnPrototype__PureAlternatives_0_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getPureAlternatives_0_2_0()); 
            }

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
    // $ANTLR end "rule__FnPrototype__PureAssignment_0_2"


    // $ANTLR start "rule__FnPrototype__NameAssignment_0_4"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6133:1: rule__FnPrototype__NameAssignment_0_4 : ( RULE_TIDENTIFIER ) ;
    public final void rule__FnPrototype__NameAssignment_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6137:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6138:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6138:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6139:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getNameTIDENTIFIERTerminalRuleCall_0_4_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__FnPrototype__NameAssignment_0_412421); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getNameTIDENTIFIERTerminalRuleCall_0_4_0()); 
            }

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
    // $ANTLR end "rule__FnPrototype__NameAssignment_0_4"


    // $ANTLR start "rule__FnPrototype__ExternAssignment_1_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6148:1: rule__FnPrototype__ExternAssignment_1_1 : ( ( rule__FnPrototype__ExternAlternatives_1_1_0 ) ) ;
    public final void rule__FnPrototype__ExternAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6152:1: ( ( ( rule__FnPrototype__ExternAlternatives_1_1_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6153:1: ( ( rule__FnPrototype__ExternAlternatives_1_1_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6153:1: ( ( rule__FnPrototype__ExternAlternatives_1_1_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6154:1: ( rule__FnPrototype__ExternAlternatives_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getExternAlternatives_1_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6155:1: ( rule__FnPrototype__ExternAlternatives_1_1_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6155:2: rule__FnPrototype__ExternAlternatives_1_1_0
            {
            pushFollow(FOLLOW_rule__FnPrototype__ExternAlternatives_1_1_0_in_rule__FnPrototype__ExternAssignment_1_112452);
            rule__FnPrototype__ExternAlternatives_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getExternAlternatives_1_1_0()); 
            }

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
    // $ANTLR end "rule__FnPrototype__ExternAssignment_1_1"


    // $ANTLR start "rule__FnPrototype__PureAssignment_1_2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6164:1: rule__FnPrototype__PureAssignment_1_2 : ( ( rule__FnPrototype__PureAlternatives_1_2_0 ) ) ;
    public final void rule__FnPrototype__PureAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6168:1: ( ( ( rule__FnPrototype__PureAlternatives_1_2_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6169:1: ( ( rule__FnPrototype__PureAlternatives_1_2_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6169:1: ( ( rule__FnPrototype__PureAlternatives_1_2_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6170:1: ( rule__FnPrototype__PureAlternatives_1_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getPureAlternatives_1_2_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6171:1: ( rule__FnPrototype__PureAlternatives_1_2_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6171:2: rule__FnPrototype__PureAlternatives_1_2_0
            {
            pushFollow(FOLLOW_rule__FnPrototype__PureAlternatives_1_2_0_in_rule__FnPrototype__PureAssignment_1_212485);
            rule__FnPrototype__PureAlternatives_1_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getPureAlternatives_1_2_0()); 
            }

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
    // $ANTLR end "rule__FnPrototype__PureAssignment_1_2"


    // $ANTLR start "rule__FnPrototype__TypeAssignment_1_3"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6180:1: rule__FnPrototype__TypeAssignment_1_3 : ( ruleType ) ;
    public final void rule__FnPrototype__TypeAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6184:1: ( ( ruleType ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6185:1: ( ruleType )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6185:1: ( ruleType )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6186:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getTypeTypeParserRuleCall_1_3_0()); 
            }
            pushFollow(FOLLOW_ruleType_in_rule__FnPrototype__TypeAssignment_1_312518);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getTypeTypeParserRuleCall_1_3_0()); 
            }

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
    // $ANTLR end "rule__FnPrototype__TypeAssignment_1_3"


    // $ANTLR start "rule__FnPrototype__NameAssignment_1_4"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6195:1: rule__FnPrototype__NameAssignment_1_4 : ( RULE_TIDENTIFIER ) ;
    public final void rule__FnPrototype__NameAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6199:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6200:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6200:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6201:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getNameTIDENTIFIERTerminalRuleCall_1_4_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__FnPrototype__NameAssignment_1_412549); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getNameTIDENTIFIERTerminalRuleCall_1_4_0()); 
            }

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
    // $ANTLR end "rule__FnPrototype__NameAssignment_1_4"


    // $ANTLR start "rule__FnPrototype__ParamsAssignment_1_6_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6210:1: rule__FnPrototype__ParamsAssignment_1_6_0 : ( ruleParam ) ;
    public final void rule__FnPrototype__ParamsAssignment_1_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6214:1: ( ( ruleParam ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6215:1: ( ruleParam )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6215:1: ( ruleParam )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6216:1: ruleParam
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getParamsParamParserRuleCall_1_6_0_0()); 
            }
            pushFollow(FOLLOW_ruleParam_in_rule__FnPrototype__ParamsAssignment_1_6_012580);
            ruleParam();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getParamsParamParserRuleCall_1_6_0_0()); 
            }

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
    // $ANTLR end "rule__FnPrototype__ParamsAssignment_1_6_0"


    // $ANTLR start "rule__FnPrototype__ParamsAssignment_1_6_1_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6225:1: rule__FnPrototype__ParamsAssignment_1_6_1_1 : ( ruleParam ) ;
    public final void rule__FnPrototype__ParamsAssignment_1_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6229:1: ( ( ruleParam ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6230:1: ( ruleParam )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6230:1: ( ruleParam )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6231:1: ruleParam
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getParamsParamParserRuleCall_1_6_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleParam_in_rule__FnPrototype__ParamsAssignment_1_6_1_112611);
            ruleParam();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFnPrototypeAccess().getParamsParamParserRuleCall_1_6_1_1_0()); 
            }

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
    // $ANTLR end "rule__FnPrototype__ParamsAssignment_1_6_1_1"


    // $ANTLR start "rule__Param__TypeAssignment_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6240:1: rule__Param__TypeAssignment_0 : ( ruleType ) ;
    public final void rule__Param__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6244:1: ( ( ruleType ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6245:1: ( ruleType )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6245:1: ( ruleType )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6246:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAccess().getTypeTypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleType_in_rule__Param__TypeAssignment_012642);
            ruleType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamAccess().getTypeTypeParserRuleCall_0_0()); 
            }

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
    // $ANTLR end "rule__Param__TypeAssignment_0"


    // $ANTLR start "rule__Param__VarAssignment_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6255:1: rule__Param__VarAssignment_1 : ( ruleVar ) ;
    public final void rule__Param__VarAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6259:1: ( ( ruleVar ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6260:1: ( ruleVar )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6260:1: ( ruleVar )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6261:1: ruleVar
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAccess().getVarVarParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleVar_in_rule__Param__VarAssignment_112673);
            ruleVar();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamAccess().getVarVarParserRuleCall_1_0()); 
            }

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
    // $ANTLR end "rule__Param__VarAssignment_1"


    // $ANTLR start "rule__VarInitList__VarInitsAssignment_1_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6270:1: rule__VarInitList__VarInitsAssignment_1_0 : ( ruleVarInit ) ;
    public final void rule__VarInitList__VarInitsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6274:1: ( ( ruleVarInit ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6275:1: ( ruleVarInit )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6275:1: ( ruleVarInit )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6276:1: ruleVarInit
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitListAccess().getVarInitsVarInitParserRuleCall_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleVarInit_in_rule__VarInitList__VarInitsAssignment_1_012704);
            ruleVarInit();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVarInitListAccess().getVarInitsVarInitParserRuleCall_1_0_0()); 
            }

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
    // $ANTLR end "rule__VarInitList__VarInitsAssignment_1_0"


    // $ANTLR start "rule__LVal__NameAssignment_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6285:1: rule__LVal__NameAssignment_0 : ( RULE_TIDENTIFIER ) ;
    public final void rule__LVal__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6289:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6290:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6290:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6291:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getNameTIDENTIFIERTerminalRuleCall_0_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__LVal__NameAssignment_012735); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLValAccess().getNameTIDENTIFIERTerminalRuleCall_0_0()); 
            }

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
    // $ANTLR end "rule__LVal__NameAssignment_0"


    // $ANTLR start "rule__LVal__IndicesAssignment_1_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6300:1: rule__LVal__IndicesAssignment_1_1 : ( ruleExpr ) ;
    public final void rule__LVal__IndicesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6304:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6305:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6305:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6306:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getIndicesExprParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__LVal__IndicesAssignment_1_112766);
            ruleExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLValAccess().getIndicesExprParserRuleCall_1_1_0()); 
            }

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
    // $ANTLR end "rule__LVal__IndicesAssignment_1_1"


    // $ANTLR start "rule__LVal__AtAssignment_2_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6315:1: rule__LVal__AtAssignment_2_1 : ( ruleExpr ) ;
    public final void rule__LVal__AtAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6319:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6320:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6320:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6321:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getAtExprParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__LVal__AtAssignment_2_112797);
            ruleExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLValAccess().getAtExprParserRuleCall_2_1_0()); 
            }

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
    // $ANTLR end "rule__LVal__AtAssignment_2_1"


    // $ANTLR start "rule__ShiftExpr__OperatorAssignment_1_0_0_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6330:1: rule__ShiftExpr__OperatorAssignment_1_0_0_1 : ( ruleShiftOperator ) ;
    public final void rule__ShiftExpr__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6334:1: ( ( ruleShiftOperator ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6335:1: ( ruleShiftOperator )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6335:1: ( ruleShiftOperator )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6336:1: ruleShiftOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getOperatorShiftOperatorEnumRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleShiftOperator_in_rule__ShiftExpr__OperatorAssignment_1_0_0_112828);
            ruleShiftOperator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExprAccess().getOperatorShiftOperatorEnumRuleCall_1_0_0_1_0()); 
            }

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
    // $ANTLR end "rule__ShiftExpr__OperatorAssignment_1_0_0_1"


    // $ANTLR start "rule__ShiftExpr__RightAssignment_1_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6345:1: rule__ShiftExpr__RightAssignment_1_1 : ( ruleAdditiveExpr ) ;
    public final void rule__ShiftExpr__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6349:1: ( ( ruleAdditiveExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6350:1: ( ruleAdditiveExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6350:1: ( ruleAdditiveExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6351:1: ruleAdditiveExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getRightAdditiveExprParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpr_in_rule__ShiftExpr__RightAssignment_1_112859);
            ruleAdditiveExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExprAccess().getRightAdditiveExprParserRuleCall_1_1_0()); 
            }

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
    // $ANTLR end "rule__ShiftExpr__RightAssignment_1_1"


    // $ANTLR start "rule__AdditiveExpr__OperatorAssignment_1_0_0_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6360:1: rule__AdditiveExpr__OperatorAssignment_1_0_0_1 : ( ruleAdditiveOperator ) ;
    public final void rule__AdditiveExpr__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6364:1: ( ( ruleAdditiveOperator ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6365:1: ( ruleAdditiveOperator )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6365:1: ( ruleAdditiveOperator )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6366:1: ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getOperatorAdditiveOperatorEnumRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_rule__AdditiveExpr__OperatorAssignment_1_0_0_112890);
            ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExprAccess().getOperatorAdditiveOperatorEnumRuleCall_1_0_0_1_0()); 
            }

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
    // $ANTLR end "rule__AdditiveExpr__OperatorAssignment_1_0_0_1"


    // $ANTLR start "rule__AdditiveExpr__RightAssignment_1_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6375:1: rule__AdditiveExpr__RightAssignment_1_1 : ( ruleMultiplicativeExpr ) ;
    public final void rule__AdditiveExpr__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6379:1: ( ( ruleMultiplicativeExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6380:1: ( ruleMultiplicativeExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6380:1: ( ruleMultiplicativeExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6381:1: ruleMultiplicativeExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getRightMultiplicativeExprParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpr_in_rule__AdditiveExpr__RightAssignment_1_112921);
            ruleMultiplicativeExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExprAccess().getRightMultiplicativeExprParserRuleCall_1_1_0()); 
            }

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
    // $ANTLR end "rule__AdditiveExpr__RightAssignment_1_1"


    // $ANTLR start "rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6390:1: rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1 : ( ruleMultiplicativeOperator ) ;
    public final void rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6394:1: ( ( ruleMultiplicativeOperator ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6395:1: ( ruleMultiplicativeOperator )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6395:1: ( ruleMultiplicativeOperator )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6396:1: ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_rule__MultiplicativeExpr__OperatorAssignment_1_0_0_112952);
            ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExprAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_0_0_1_0()); 
            }

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
    // $ANTLR end "rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1"


    // $ANTLR start "rule__MultiplicativeExpr__RightAssignment_1_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6405:1: rule__MultiplicativeExpr__RightAssignment_1_1 : ( ruleTerminalExpr ) ;
    public final void rule__MultiplicativeExpr__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6409:1: ( ( ruleTerminalExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6410:1: ( ruleTerminalExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6410:1: ( ruleTerminalExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6411:1: ruleTerminalExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getRightTerminalExprParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleTerminalExpr_in_rule__MultiplicativeExpr__RightAssignment_1_112983);
            ruleTerminalExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExprAccess().getRightTerminalExprParserRuleCall_1_1_0()); 
            }

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
    // $ANTLR end "rule__MultiplicativeExpr__RightAssignment_1_1"


    // $ANTLR start "rule__TerminalExpr__ValueAssignment_2_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6420:1: rule__TerminalExpr__ValueAssignment_2_1 : ( RULE_INT ) ;
    public final void rule__TerminalExpr__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6424:1: ( ( RULE_INT ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6425:1: ( RULE_INT )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6425:1: ( RULE_INT )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6426:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getValueINTTerminalRuleCall_2_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TerminalExpr__ValueAssignment_2_113014); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getValueINTTerminalRuleCall_2_1_0()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__ValueAssignment_2_1"


    // $ANTLR start "rule__TerminalExpr__ValueAssignment_3_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6435:1: rule__TerminalExpr__ValueAssignment_3_1 : ( ruleDouble ) ;
    public final void rule__TerminalExpr__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6439:1: ( ( ruleDouble ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6440:1: ( ruleDouble )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6440:1: ( ruleDouble )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6441:1: ruleDouble
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getValueDoubleParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleDouble_in_rule__TerminalExpr__ValueAssignment_3_113045);
            ruleDouble();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getValueDoubleParserRuleCall_3_1_0()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__ValueAssignment_3_1"


    // $ANTLR start "rule__TerminalExpr__OperatorAssignment_5_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6450:1: rule__TerminalExpr__OperatorAssignment_5_1 : ( ruleUnaryOperator ) ;
    public final void rule__TerminalExpr__OperatorAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6454:1: ( ( ruleUnaryOperator ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6455:1: ( ruleUnaryOperator )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6455:1: ( ruleUnaryOperator )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6456:1: ruleUnaryOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getOperatorUnaryOperatorEnumRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_rule__TerminalExpr__OperatorAssignment_5_113076);
            ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getOperatorUnaryOperatorEnumRuleCall_5_1_0()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__OperatorAssignment_5_1"


    // $ANTLR start "rule__TerminalExpr__OperandAssignment_5_2"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6465:1: rule__TerminalExpr__OperandAssignment_5_2 : ( ruleExpr ) ;
    public final void rule__TerminalExpr__OperandAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6469:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6470:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6470:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6471:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getOperandExprParserRuleCall_5_2_0()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__TerminalExpr__OperandAssignment_5_213107);
            ruleExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getOperandExprParserRuleCall_5_2_0()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__OperandAssignment_5_2"


    // $ANTLR start "rule__TerminalExpr__FunctionAssignment_6_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6480:1: rule__TerminalExpr__FunctionAssignment_6_1 : ( ruleBuiltInFunction ) ;
    public final void rule__TerminalExpr__FunctionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6484:1: ( ( ruleBuiltInFunction ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6485:1: ( ruleBuiltInFunction )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6485:1: ( ruleBuiltInFunction )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6486:1: ruleBuiltInFunction
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getFunctionBuiltInFunctionParserRuleCall_6_1_0()); 
            }
            pushFollow(FOLLOW_ruleBuiltInFunction_in_rule__TerminalExpr__FunctionAssignment_6_113138);
            ruleBuiltInFunction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getFunctionBuiltInFunctionParserRuleCall_6_1_0()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__FunctionAssignment_6_1"


    // $ANTLR start "rule__TerminalExpr__FirstArgAssignment_6_3"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6495:1: rule__TerminalExpr__FirstArgAssignment_6_3 : ( RULE_TIDENTIFIER ) ;
    public final void rule__TerminalExpr__FirstArgAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6499:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6500:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6500:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6501:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getFirstArgTIDENTIFIERTerminalRuleCall_6_3_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__TerminalExpr__FirstArgAssignment_6_313169); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getFirstArgTIDENTIFIERTerminalRuleCall_6_3_0()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__FirstArgAssignment_6_3"


    // $ANTLR start "rule__TerminalExpr__SecondArgAssignment_6_5"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6510:1: rule__TerminalExpr__SecondArgAssignment_6_5 : ( ruleExpr ) ;
    public final void rule__TerminalExpr__SecondArgAssignment_6_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6514:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6515:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6515:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6516:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getSecondArgExprParserRuleCall_6_5_0()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__TerminalExpr__SecondArgAssignment_6_513200);
            ruleExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprAccess().getSecondArgExprParserRuleCall_6_5_0()); 
            }

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
    // $ANTLR end "rule__TerminalExpr__SecondArgAssignment_6_5"


    // $ANTLR start "rule__CallExpr__NamespaceAssignment_0_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6525:1: rule__CallExpr__NamespaceAssignment_0_0 : ( RULE_TIDENTIFIER ) ;
    public final void rule__CallExpr__NamespaceAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6529:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6530:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6530:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6531:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getNamespaceTIDENTIFIERTerminalRuleCall_0_0_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__CallExpr__NamespaceAssignment_0_013231); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprAccess().getNamespaceTIDENTIFIERTerminalRuleCall_0_0_0()); 
            }

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
    // $ANTLR end "rule__CallExpr__NamespaceAssignment_0_0"


    // $ANTLR start "rule__CallExpr__NameAssignment_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6540:1: rule__CallExpr__NameAssignment_1 : ( RULE_TIDENTIFIER ) ;
    public final void rule__CallExpr__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6544:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6545:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6545:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6546:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getNameTIDENTIFIERTerminalRuleCall_1_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__CallExpr__NameAssignment_113262); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprAccess().getNameTIDENTIFIERTerminalRuleCall_1_0()); 
            }

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
    // $ANTLR end "rule__CallExpr__NameAssignment_1"


    // $ANTLR start "rule__CallExpr__ArgListAssignment_3"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6555:1: rule__CallExpr__ArgListAssignment_3 : ( ruleArgList ) ;
    public final void rule__CallExpr__ArgListAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6559:1: ( ( ruleArgList ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6560:1: ( ruleArgList )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6560:1: ( ruleArgList )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6561:1: ruleArgList
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getArgListArgListParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleArgList_in_rule__CallExpr__ArgListAssignment_313293);
            ruleArgList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprAccess().getArgListArgListParserRuleCall_3_0()); 
            }

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
    // $ANTLR end "rule__CallExpr__ArgListAssignment_3"


    // $ANTLR start "rule__CallExpr__AtAssignment_5_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6570:1: rule__CallExpr__AtAssignment_5_1 : ( ruleExpr ) ;
    public final void rule__CallExpr__AtAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6574:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6575:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6575:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6576:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getAtExprParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__CallExpr__AtAssignment_5_113324);
            ruleExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprAccess().getAtExprParserRuleCall_5_1_0()); 
            }

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
    // $ANTLR end "rule__CallExpr__AtAssignment_5_1"


    // $ANTLR start "rule__ArgList__ArgsAssignment_1_0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6585:1: rule__ArgList__ArgsAssignment_1_0 : ( ruleExpr ) ;
    public final void rule__ArgList__ArgsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6589:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6590:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6590:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6591:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getArgsExprParserRuleCall_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__ArgList__ArgsAssignment_1_013355);
            ruleExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArgListAccess().getArgsExprParserRuleCall_1_0_0()); 
            }

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
    // $ANTLR end "rule__ArgList__ArgsAssignment_1_0"


    // $ANTLR start "rule__ArgList__ArgsAssignment_1_1_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6600:1: rule__ArgList__ArgsAssignment_1_1_1 : ( ruleExpr ) ;
    public final void rule__ArgList__ArgsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6604:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6605:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6605:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6606:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getArgsExprParserRuleCall_1_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__ArgList__ArgsAssignment_1_1_113386);
            ruleExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArgListAccess().getArgsExprParserRuleCall_1_1_1_0()); 
            }

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
    // $ANTLR end "rule__ArgList__ArgsAssignment_1_1_1"

    // $ANTLR start synpred56_InternalDmpl
    public final void synpred56_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3861:2: ( rule__ShiftExpr__Group_1__0 )
        // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3861:2: rule__ShiftExpr__Group_1__0
        {
        pushFollow(FOLLOW_rule__ShiftExpr__Group_1__0_in_synpred56_InternalDmpl7917);
        rule__ShiftExpr__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_InternalDmpl

    // $ANTLR start synpred57_InternalDmpl
    public final void synpred57_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4076:2: ( rule__AdditiveExpr__Group_1__0 )
        // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4076:2: rule__AdditiveExpr__Group_1__0
        {
        pushFollow(FOLLOW_rule__AdditiveExpr__Group_1__0_in_synpred57_InternalDmpl8340);
        rule__AdditiveExpr__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_InternalDmpl

    // $ANTLR start synpred58_InternalDmpl
    public final void synpred58_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4291:2: ( rule__MultiplicativeExpr__Group_1__0 )
        // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4291:2: rule__MultiplicativeExpr__Group_1__0
        {
        pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1__0_in_synpred58_InternalDmpl8763);
        rule__MultiplicativeExpr__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_InternalDmpl

    // Delegated rules

    public final boolean synpred56_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA4_eotS =
        "\11\uffff";
    static final String DFA4_eofS =
        "\1\uffff\1\3\6\uffff\1\3";
    static final String DFA4_minS =
        "\1\5\1\16\1\4\2\uffff\3\55\1\16";
    static final String DFA4_maxS =
        "\1\5\1\54\1\56\2\uffff\3\55\1\54";
    static final String DFA4_acceptS =
        "\3\uffff\1\1\1\2\4\uffff";
    static final String DFA4_specialS =
        "\11\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1",
            "\1\3\34\uffff\1\4\1\2",
            "\1\5\1\7\50\uffff\1\6",
            "",
            "",
            "\1\10",
            "\1\10",
            "\1\10",
            "\1\3\34\uffff\1\4\1\2"
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "1113:1: rule__VarAsgnList__Alternatives : ( ( ( rule__VarAsgnList__VarAssignment_0 ) ) | ( ( rule__VarAsgnList__VarAsgnAssignment_1 ) ) );";
        }
    }
    static final String DFA13_eotS =
        "\14\uffff";
    static final String DFA13_eofS =
        "\1\uffff\1\12\1\uffff\1\13\10\uffff";
    static final String DFA13_minS =
        "\1\4\1\16\1\uffff\1\16\10\uffff";
    static final String DFA13_maxS =
        "\1\66\1\67\1\uffff\1\70\10\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\5\1\6\1\7\1\11\1\10\1\1\1\3";
    static final String DFA13_specialS =
        "\14\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\3\1\1\15\uffff\2\6\10\uffff\6\7\1\4\5\uffff\2\6\3\uffff\1\5\3\uffff\1\10\3\uffff\1\2",
            "\1\12\4\uffff\2\12\17\uffff\5\12\3\uffff\2\12\4\uffff\1\11\3\12\1\uffff\1\11",
            "",
            "\1\13\4\uffff\2\13\17\uffff\5\13\4\uffff\1\13\5\uffff\2\13\3\uffff\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1335:1: rule__TerminalExpr__Alternatives : ( ( ruleLVal ) | ( ( rule__TerminalExpr__Group_1__0 ) ) | ( ( rule__TerminalExpr__Group_2__0 ) ) | ( ( rule__TerminalExpr__Group_3__0 ) ) | ( ( rule__TerminalExpr__Group_4__0 ) ) | ( ( rule__TerminalExpr__Group_5__0 ) ) | ( ( rule__TerminalExpr__Group_6__0 ) ) | ( ruleCallExpr ) | ( ( rule__TerminalExpr__Group_8__0 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProgram74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__Group__0_in_ruleProgram100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDmplSubclause_in_entryRuleDmplSubclause129 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDmplSubclause136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DmplSubclause__Group__0_in_ruleDmplSubclause162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProgramElement_in_entryRuleProgramElement189 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProgramElement196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProgramElement__Alternatives_in_ruleProgramElement222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant249 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__0_in_ruleConstant282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberConst_in_entryRuleNumberConst309 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberConst316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumberConst__Alternatives_in_ruleNumberConst342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntConst_in_entryRuleIntConst369 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntConst376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__Group__0_in_ruleIntConst402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleConst_in_entryRuleDoubleConst429 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoubleConst436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__Group__0_in_ruleDoubleConst462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarInit_in_entryRuleVarInit489 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarInit496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInit__Group__0_in_ruleVarInit522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarAsgnList_in_entryRuleVarAsgnList549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarAsgnList556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgnList__Alternatives_in_ruleVarAsgnList582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarAsgn_in_entryRuleVarAsgn609 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarAsgn616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgn__Group__0_in_ruleVarAsgn642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_entryRuleVar669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVar676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Var__Group__0_in_ruleVar702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDimension_in_entryRuleDimension729 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDimension736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Alternatives_in_ruleDimension762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType789 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group__0_in_ruleType822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcedure_in_entryRuleProcedure849 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcedure856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Procedure__ProcedureAssignment_in_ruleProcedure882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcNoAttr_in_entryRuleProcNoAttr909 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcNoAttr916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Group__0_in_ruleProcNoAttr942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnBody_in_entryRuleFnBody969 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFnBody976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnBody__Group__0_in_ruleFnBody1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnPrototype_in_entryRuleFnPrototype1029 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFnPrototype1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Alternatives_in_ruleFnPrototype1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParam_in_entryRuleParam1089 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParam1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Param__Group__0_in_ruleParam1122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarInitList_in_entryRuleVarInitList1149 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarInitList1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInitList__Group__0_in_ruleVarInitList1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLVal_in_entryRuleLVal1209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLVal1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group__0_in_ruleLVal1242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_entryRuleExpr1269 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpr1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpr_in_ruleExpr1302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpr_in_entryRuleShiftExpr1328 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShiftExpr1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group__0_in_ruleShiftExpr1361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpr_in_entryRuleAdditiveExpr1388 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpr1395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group__0_in_ruleAdditiveExpr1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpr_in_entryRuleMultiplicativeExpr1448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpr1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group__0_in_ruleMultiplicativeExpr1481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpr_in_entryRuleTerminalExpr1508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalExpr1515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Alternatives_in_ruleTerminalExpr1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExpr_in_entryRuleCallExpr1568 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallExpr1575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__0_in_ruleCallExpr1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgList_in_entryRuleArgList1628 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgList1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group__0_in_ruleArgList1661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSign_in_entryRuleSign1688 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSign1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sign__Alternatives_in_ruleSign1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpType_in_entryRuleSimpType1748 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpType1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpType__Alternatives_in_ruleSimpType1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSigned_in_entryRuleSigned1808 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSigned1815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signed__Alternatives_in_ruleSigned1841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltInFunction_in_entryRuleBuiltInFunction1868 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBuiltInFunction1875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuiltInFunction__Alternatives_in_ruleBuiltInFunction1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDouble_in_entryRuleDouble1928 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDouble1935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Alternatives_in_ruleDouble1961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftOperator__Alternatives_in_ruleShiftOperator2004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveOperator__Alternatives_in_ruleAdditiveOperator2040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeOperator__Alternatives_in_ruleMultiplicativeOperator2076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryOperator__Alternatives_in_ruleUnaryOperator2112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_rule__ProgramElement__Alternatives2149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcedure_in_rule__ProgramElement__Alternatives2166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Constant__Alternatives_02199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Constant__Alternatives_02219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntConst_in_rule__NumberConst__Alternatives2253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleConst_in_rule__NumberConst__Alternatives2270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgnList__VarAssignment_0_in_rule__VarAsgnList__Alternatives2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgnList__VarAsgnAssignment_1_in_rule__VarAsgnList__Alternatives2320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgn__FnBodyAssignment_2_0_in_rule__VarAsgn__Alternatives_22353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgn__ExprAssignment_2_1_in_rule__VarAsgn__Alternatives_22371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_0__0_in_rule__Dimension__Alternatives2404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_1__0_in_rule__Dimension__Alternatives2422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_2__0_in_rule__Dimension__Alternatives2440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ProcNoAttr__Alternatives_12474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__FnBodyAssignment_1_1_in_rule__ProcNoAttr__Alternatives_12493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__0_in_rule__FnPrototype__Alternatives2526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__0_in_rule__FnPrototype__Alternatives2544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__FnPrototype__ExternAlternatives_0_1_02578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__FnPrototype__ExternAlternatives_0_1_02598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__FnPrototype__PureAlternatives_0_2_02633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__FnPrototype__PureAlternatives_0_2_02653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__FnPrototype__ExternAlternatives_1_1_02688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__FnPrototype__ExternAlternatives_1_1_02708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__FnPrototype__PureAlternatives_1_2_02743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__FnPrototype__PureAlternatives_1_2_02763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLVal_in_rule__TerminalExpr__Alternatives2797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_1__0_in_rule__TerminalExpr__Alternatives2814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_2__0_in_rule__TerminalExpr__Alternatives2832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_3__0_in_rule__TerminalExpr__Alternatives2850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_4__0_in_rule__TerminalExpr__Alternatives2868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_5__0_in_rule__TerminalExpr__Alternatives2886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__0_in_rule__TerminalExpr__Alternatives2904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExpr_in_rule__TerminalExpr__Alternatives2922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_8__0_in_rule__TerminalExpr__Alternatives2939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Sign__Alternatives2973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Sign__Alternatives2993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__SimpType__Alternatives3028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__SimpType__Alternatives3048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__SimpType__Alternatives3068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__SimpType__Alternatives3088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__SimpType__Alternatives3108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SimpType__Alternatives3128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Signed__Alternatives3163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Signed__Alternatives3183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__BuiltInFunction__Alternatives3218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__BuiltInFunction__Alternatives3238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__BuiltInFunction__Alternatives3258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__BuiltInFunction__Alternatives3278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__BuiltInFunction__Alternatives3298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__BuiltInFunction__Alternatives3318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Double__Alternatives3353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Group_1__0_in_rule__Double__Alternatives3372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ShiftOperator__Alternatives3409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ShiftOperator__Alternatives3430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__AdditiveOperator__Alternatives3466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__AdditiveOperator__Alternatives3487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__MultiplicativeOperator__Alternatives3523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__MultiplicativeOperator__Alternatives3544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__MultiplicativeOperator__Alternatives3565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__UnaryOperator__Alternatives3601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__UnaryOperator__Alternatives3622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__UnaryOperator__Alternatives3643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__UnaryOperator__Alternatives3664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__Group__0__Impl_in_rule__Program__Group__03698 = new BitSet(new long[]{0x000200001FE7B000L});
    public static final BitSet FOLLOW_rule__Program__Group__1_in_rule__Program__Group__03701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__Group__1__Impl_in_rule__Program__Group__13759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__ProgramElementsAssignment_1_in_rule__Program__Group__1__Impl3786 = new BitSet(new long[]{0x000200001FE7B002L});
    public static final BitSet FOLLOW_rule__DmplSubclause__Group__0__Impl_in_rule__DmplSubclause__Group__03821 = new BitSet(new long[]{0x000200001FE7B000L});
    public static final BitSet FOLLOW_rule__DmplSubclause__Group__1_in_rule__DmplSubclause__Group__03824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DmplSubclause__Group__1__Impl_in_rule__DmplSubclause__Group__13882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DmplSubclause__ProgramAssignment_1_in_rule__DmplSubclause__Group__1__Impl3909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__0__Impl_in_rule__Constant__Group__03943 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Constant__Group__1_in_rule__Constant__Group__03946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Alternatives_0_in_rule__Constant__Group__0__Impl3973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__1__Impl_in_rule__Constant__Group__14003 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__Constant__Group__2_in_rule__Constant__Group__14006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__NameAssignment_1_in_rule__Constant__Group__1__Impl4033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__2__Impl_in_rule__Constant__Group__24063 = new BitSet(new long[]{0x0000000800180010L});
    public static final BitSet FOLLOW_rule__Constant__Group__3_in_rule__Constant__Group__24066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__Constant__Group__2__Impl4094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__3__Impl_in_rule__Constant__Group__34125 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Constant__Group__4_in_rule__Constant__Group__34128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__ValueAssignment_3_in_rule__Constant__Group__3__Impl4155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__4__Impl_in_rule__Constant__Group__44185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Constant__Group__4__Impl4213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__Group__0__Impl_in_rule__IntConst__Group__04254 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_rule__IntConst__Group__1_in_rule__IntConst__Group__04257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__SignAssignment_0_in_rule__IntConst__Group__0__Impl4284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__Group__1__Impl_in_rule__IntConst__Group__14315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__ValueAssignment_1_in_rule__IntConst__Group__1__Impl4342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__Group__0__Impl_in_rule__DoubleConst__Group__04376 = new BitSet(new long[]{0x0000000800180010L});
    public static final BitSet FOLLOW_rule__DoubleConst__Group__1_in_rule__DoubleConst__Group__04379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__SignAssignment_0_in_rule__DoubleConst__Group__0__Impl4406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__Group__1__Impl_in_rule__DoubleConst__Group__14437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__ValueAssignment_1_in_rule__DoubleConst__Group__1__Impl4464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInit__Group__0__Impl_in_rule__VarInit__Group__04498 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VarInit__Group__1_in_rule__VarInit__Group__04501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInit__TypeAssignment_0_in_rule__VarInit__Group__0__Impl4528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInit__Group__1__Impl_in_rule__VarInit__Group__14558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInit__VarAsgnListAssignment_1_in_rule__VarInit__Group__1__Impl4585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgn__Group__0__Impl_in_rule__VarAsgn__Group__04619 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__VarAsgn__Group__1_in_rule__VarAsgn__Group__04622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgn__VarAssignment_0_in_rule__VarAsgn__Group__0__Impl4649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgn__Group__1__Impl_in_rule__VarAsgn__Group__14679 = new BitSet(new long[]{0x0044C60FE0180030L});
    public static final BitSet FOLLOW_rule__VarAsgn__Group__2_in_rule__VarAsgn__Group__14682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__VarAsgn__Group__1__Impl4710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgn__Group__2__Impl_in_rule__VarAsgn__Group__24741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgn__Alternatives_2_in_rule__VarAsgn__Group__2__Impl4768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Var__Group__0__Impl_in_rule__Var__Group__04804 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__Var__Group__1_in_rule__Var__Group__04807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Var__NameAssignment_0_in_rule__Var__Group__0__Impl4834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Var__Group__1__Impl_in_rule__Var__Group__14864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Var__Group_1__0_in_rule__Var__Group__1__Impl4891 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_rule__Var__Group_1__0__Impl_in_rule__Var__Group_1__04926 = new BitSet(new long[]{0x0000400000000030L});
    public static final BitSet FOLLOW_rule__Var__Group_1__1_in_rule__Var__Group_1__04929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__Var__Group_1__0__Impl4957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Var__Group_1__1__Impl_in_rule__Var__Group_1__14988 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__Var__Group_1__2_in_rule__Var__Group_1__14991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Var__DimensionsAssignment_1_1_in_rule__Var__Group_1__1__Impl5018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Var__Group_1__2__Impl_in_rule__Var__Group_1__25048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__Var__Group_1__2__Impl5076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_0__0__Impl_in_rule__Dimension__Group_0__05113 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Dimension__Group_0__1_in_rule__Dimension__Group_0__05116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_0__1__Impl_in_rule__Dimension__Group_0__15174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__IndexAssignment_0_1_in_rule__Dimension__Group_0__1__Impl5201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_1__0__Impl_in_rule__Dimension__Group_1__05235 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__Dimension__Group_1__1_in_rule__Dimension__Group_1__05238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_1__1__Impl_in_rule__Dimension__Group_1__15296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Dimension__Group_1__1__Impl5324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_2__0__Impl_in_rule__Dimension__Group_2__05359 = new BitSet(new long[]{0x0000400000000030L});
    public static final BitSet FOLLOW_rule__Dimension__Group_2__1_in_rule__Dimension__Group_2__05362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_2__1__Impl_in_rule__Dimension__Group_2__15420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__IndexAssignment_2_1_in_rule__Dimension__Group_2__1__Impl5447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group__0__Impl_in_rule__Type__Group__05481 = new BitSet(new long[]{0x000200001FE7B000L});
    public static final BitSet FOLLOW_rule__Type__Group__1_in_rule__Type__Group__05484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__SignedAssignment_0_in_rule__Type__Group__0__Impl5511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group__1__Impl_in_rule__Type__Group__15542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__SimpTypeAssignment_1_in_rule__Type__Group__1__Impl5569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Group__0__Impl_in_rule__ProcNoAttr__Group__05603 = new BitSet(new long[]{0x0000800000004000L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Group__1_in_rule__ProcNoAttr__Group__05606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__PrototypeAssignment_0_in_rule__ProcNoAttr__Group__0__Impl5633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Group__1__Impl_in_rule__ProcNoAttr__Group__15663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Alternatives_1_in_rule__ProcNoAttr__Group__1__Impl5690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnBody__Group__0__Impl_in_rule__FnBody__Group__05724 = new BitSet(new long[]{0x000200001FE7B000L});
    public static final BitSet FOLLOW_rule__FnBody__Group__1_in_rule__FnBody__Group__05727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__FnBody__Group__0__Impl5755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnBody__Group__1__Impl_in_rule__FnBody__Group__15786 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__FnBody__Group__2_in_rule__FnBody__Group__15789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnBody__VarInitListAssignment_1_in_rule__FnBody__Group__1__Impl5816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnBody__Group__2__Impl_in_rule__FnBody__Group__25846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__FnBody__Group__2__Impl5874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__0__Impl_in_rule__FnPrototype__Group_0__05911 = new BitSet(new long[]{0x0002000000078000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__1_in_rule__FnPrototype__Group_0__05914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__1__Impl_in_rule__FnPrototype__Group_0__15972 = new BitSet(new long[]{0x0002000000078000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__2_in_rule__FnPrototype__Group_0__15975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__ExternAssignment_0_1_in_rule__FnPrototype__Group_0__1__Impl6002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__2__Impl_in_rule__FnPrototype__Group_0__26033 = new BitSet(new long[]{0x0002000000078000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__3_in_rule__FnPrototype__Group_0__26036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__PureAssignment_0_2_in_rule__FnPrototype__Group_0__2__Impl6063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__3__Impl_in_rule__FnPrototype__Group_0__36094 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__4_in_rule__FnPrototype__Group_0__36097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__FnPrototype__Group_0__3__Impl6125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__4__Impl_in_rule__FnPrototype__Group_0__46156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__NameAssignment_0_4_in_rule__FnPrototype__Group_0__4__Impl6183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__0__Impl_in_rule__FnPrototype__Group_1__06223 = new BitSet(new long[]{0x000200001FE7B000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__1_in_rule__FnPrototype__Group_1__06226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__1__Impl_in_rule__FnPrototype__Group_1__16284 = new BitSet(new long[]{0x000200001FE7B000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__2_in_rule__FnPrototype__Group_1__16287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__ExternAssignment_1_1_in_rule__FnPrototype__Group_1__1__Impl6314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__2__Impl_in_rule__FnPrototype__Group_1__26345 = new BitSet(new long[]{0x000200001FE7B000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__3_in_rule__FnPrototype__Group_1__26348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__PureAssignment_1_2_in_rule__FnPrototype__Group_1__2__Impl6375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__3__Impl_in_rule__FnPrototype__Group_1__36406 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__4_in_rule__FnPrototype__Group_1__36409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__TypeAssignment_1_3_in_rule__FnPrototype__Group_1__3__Impl6436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__4__Impl_in_rule__FnPrototype__Group_1__46466 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__5_in_rule__FnPrototype__Group_1__46469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__NameAssignment_1_4_in_rule__FnPrototype__Group_1__4__Impl6496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__5__Impl_in_rule__FnPrototype__Group_1__56526 = new BitSet(new long[]{0x000A00001FE7B000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__6_in_rule__FnPrototype__Group_1__56529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__FnPrototype__Group_1__5__Impl6557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__6__Impl_in_rule__FnPrototype__Group_1__66588 = new BitSet(new long[]{0x000A00001FE7B000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__7_in_rule__FnPrototype__Group_1__66591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1_6__0_in_rule__FnPrototype__Group_1__6__Impl6618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__7__Impl_in_rule__FnPrototype__Group_1__76649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__FnPrototype__Group_1__7__Impl6677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1_6__0__Impl_in_rule__FnPrototype__Group_1_6__06724 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1_6__1_in_rule__FnPrototype__Group_1_6__06727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__ParamsAssignment_1_6_0_in_rule__FnPrototype__Group_1_6__0__Impl6754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1_6__1__Impl_in_rule__FnPrototype__Group_1_6__16784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1_6_1__0_in_rule__FnPrototype__Group_1_6__1__Impl6811 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1_6_1__0__Impl_in_rule__FnPrototype__Group_1_6_1__06846 = new BitSet(new long[]{0x000200001FE7B000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1_6_1__1_in_rule__FnPrototype__Group_1_6_1__06849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__FnPrototype__Group_1_6_1__0__Impl6877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1_6_1__1__Impl_in_rule__FnPrototype__Group_1_6_1__16908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__ParamsAssignment_1_6_1_1_in_rule__FnPrototype__Group_1_6_1__1__Impl6935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Param__Group__0__Impl_in_rule__Param__Group__06969 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Param__Group__1_in_rule__Param__Group__06972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Param__TypeAssignment_0_in_rule__Param__Group__0__Impl6999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Param__Group__1__Impl_in_rule__Param__Group__17029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Param__VarAssignment_1_in_rule__Param__Group__1__Impl7056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInitList__Group__0__Impl_in_rule__VarInitList__Group__07090 = new BitSet(new long[]{0x000200001FE7B000L});
    public static final BitSet FOLLOW_rule__VarInitList__Group__1_in_rule__VarInitList__Group__07093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInitList__Group__1__Impl_in_rule__VarInitList__Group__17151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInitList__Group_1__0_in_rule__VarInitList__Group__1__Impl7178 = new BitSet(new long[]{0x000200001FE7B002L});
    public static final BitSet FOLLOW_rule__VarInitList__Group_1__0__Impl_in_rule__VarInitList__Group_1__07213 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__VarInitList__Group_1__1_in_rule__VarInitList__Group_1__07216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInitList__VarInitsAssignment_1_0_in_rule__VarInitList__Group_1__0__Impl7243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInitList__Group_1__1__Impl_in_rule__VarInitList__Group_1__17273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VarInitList__Group_1__1__Impl7301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group__0__Impl_in_rule__LVal__Group__07336 = new BitSet(new long[]{0x0020100000000000L});
    public static final BitSet FOLLOW_rule__LVal__Group__1_in_rule__LVal__Group__07339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__NameAssignment_0_in_rule__LVal__Group__0__Impl7366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group__1__Impl_in_rule__LVal__Group__17396 = new BitSet(new long[]{0x0020100000000000L});
    public static final BitSet FOLLOW_rule__LVal__Group__2_in_rule__LVal__Group__17399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group_1__0_in_rule__LVal__Group__1__Impl7426 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group__2__Impl_in_rule__LVal__Group__27457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group_2__0_in_rule__LVal__Group__2__Impl7484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group_1__0__Impl_in_rule__LVal__Group_1__07521 = new BitSet(new long[]{0x0044C60FE0180030L});
    public static final BitSet FOLLOW_rule__LVal__Group_1__1_in_rule__LVal__Group_1__07524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__LVal__Group_1__0__Impl7552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group_1__1__Impl_in_rule__LVal__Group_1__17583 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__LVal__Group_1__2_in_rule__LVal__Group_1__17586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__IndicesAssignment_1_1_in_rule__LVal__Group_1__1__Impl7613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group_1__2__Impl_in_rule__LVal__Group_1__27643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__LVal__Group_1__2__Impl7671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group_2__0__Impl_in_rule__LVal__Group_2__07708 = new BitSet(new long[]{0x0044C60FE0180030L});
    public static final BitSet FOLLOW_rule__LVal__Group_2__1_in_rule__LVal__Group_2__07711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__LVal__Group_2__0__Impl7739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group_2__1__Impl_in_rule__LVal__Group_2__17770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__AtAssignment_2_1_in_rule__LVal__Group_2__1__Impl7797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group__0__Impl_in_rule__ShiftExpr__Group__07831 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group__1_in_rule__ShiftExpr__Group__07834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpr_in_rule__ShiftExpr__Group__0__Impl7861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group__1__Impl_in_rule__ShiftExpr__Group__17890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1__0_in_rule__ShiftExpr__Group__1__Impl7917 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1__0__Impl_in_rule__ShiftExpr__Group_1__07952 = new BitSet(new long[]{0x0044C60FE0180030L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1__1_in_rule__ShiftExpr__Group_1__07955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1_0__0_in_rule__ShiftExpr__Group_1__0__Impl7982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1__1__Impl_in_rule__ShiftExpr__Group_1__18012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__RightAssignment_1_1_in_rule__ShiftExpr__Group_1__1__Impl8039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1_0__0__Impl_in_rule__ShiftExpr__Group_1_0__08073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1_0_0__0_in_rule__ShiftExpr__Group_1_0__0__Impl8100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1_0_0__0__Impl_in_rule__ShiftExpr__Group_1_0_0__08132 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1_0_0__1_in_rule__ShiftExpr__Group_1_0_0__08135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1_0_0__1__Impl_in_rule__ShiftExpr__Group_1_0_0__18193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__OperatorAssignment_1_0_0_1_in_rule__ShiftExpr__Group_1_0_0__1__Impl8220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group__0__Impl_in_rule__AdditiveExpr__Group__08254 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group__1_in_rule__AdditiveExpr__Group__08257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpr_in_rule__AdditiveExpr__Group__0__Impl8284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group__1__Impl_in_rule__AdditiveExpr__Group__18313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1__0_in_rule__AdditiveExpr__Group__1__Impl8340 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1__0__Impl_in_rule__AdditiveExpr__Group_1__08375 = new BitSet(new long[]{0x0044C60FE0180030L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1__1_in_rule__AdditiveExpr__Group_1__08378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1_0__0_in_rule__AdditiveExpr__Group_1__0__Impl8405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1__1__Impl_in_rule__AdditiveExpr__Group_1__18435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__RightAssignment_1_1_in_rule__AdditiveExpr__Group_1__1__Impl8462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1_0__0__Impl_in_rule__AdditiveExpr__Group_1_0__08496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1_0_0__0_in_rule__AdditiveExpr__Group_1_0__0__Impl8523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1_0_0__0__Impl_in_rule__AdditiveExpr__Group_1_0_0__08555 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1_0_0__1_in_rule__AdditiveExpr__Group_1_0_0__08558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1_0_0__1__Impl_in_rule__AdditiveExpr__Group_1_0_0__18616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__OperatorAssignment_1_0_0_1_in_rule__AdditiveExpr__Group_1_0_0__1__Impl8643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group__0__Impl_in_rule__MultiplicativeExpr__Group__08677 = new BitSet(new long[]{0x000001C000000000L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group__1_in_rule__MultiplicativeExpr__Group__08680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpr_in_rule__MultiplicativeExpr__Group__0__Impl8707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group__1__Impl_in_rule__MultiplicativeExpr__Group__18736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1__0_in_rule__MultiplicativeExpr__Group__1__Impl8763 = new BitSet(new long[]{0x000001C000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1__0__Impl_in_rule__MultiplicativeExpr__Group_1__08798 = new BitSet(new long[]{0x0044C60FE0180030L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1__1_in_rule__MultiplicativeExpr__Group_1__08801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1_0__0_in_rule__MultiplicativeExpr__Group_1__0__Impl8828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1__1__Impl_in_rule__MultiplicativeExpr__Group_1__18858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__RightAssignment_1_1_in_rule__MultiplicativeExpr__Group_1__1__Impl8885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1_0__0__Impl_in_rule__MultiplicativeExpr__Group_1_0__08919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1_0_0__0_in_rule__MultiplicativeExpr__Group_1_0__0__Impl8946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1_0_0__0__Impl_in_rule__MultiplicativeExpr__Group_1_0_0__08978 = new BitSet(new long[]{0x000001C000000000L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1_0_0__1_in_rule__MultiplicativeExpr__Group_1_0_0__08981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1_0_0__1__Impl_in_rule__MultiplicativeExpr__Group_1_0_0__19039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1_in_rule__MultiplicativeExpr__Group_1_0_0__1__Impl9066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_1__0__Impl_in_rule__TerminalExpr__Group_1__09100 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_1__1_in_rule__TerminalExpr__Group_1__09103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_1__1__Impl_in_rule__TerminalExpr__Group_1__19161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__TerminalExpr__Group_1__1__Impl9189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_2__0__Impl_in_rule__TerminalExpr__Group_2__09224 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_2__1_in_rule__TerminalExpr__Group_2__09227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_2__1__Impl_in_rule__TerminalExpr__Group_2__19285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__ValueAssignment_2_1_in_rule__TerminalExpr__Group_2__1__Impl9312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_3__0__Impl_in_rule__TerminalExpr__Group_3__09346 = new BitSet(new long[]{0x0000000800180010L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_3__1_in_rule__TerminalExpr__Group_3__09349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_3__1__Impl_in_rule__TerminalExpr__Group_3__19407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__ValueAssignment_3_1_in_rule__TerminalExpr__Group_3__1__Impl9434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_4__0__Impl_in_rule__TerminalExpr__Group_4__09468 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_4__1_in_rule__TerminalExpr__Group_4__09471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_4__1__Impl_in_rule__TerminalExpr__Group_4__19529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__TerminalExpr__Group_4__1__Impl9557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_5__0__Impl_in_rule__TerminalExpr__Group_5__09592 = new BitSet(new long[]{0x0000060000180000L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_5__1_in_rule__TerminalExpr__Group_5__09595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_5__1__Impl_in_rule__TerminalExpr__Group_5__19653 = new BitSet(new long[]{0x0044C60FE0180030L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_5__2_in_rule__TerminalExpr__Group_5__19656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__OperatorAssignment_5_1_in_rule__TerminalExpr__Group_5__1__Impl9683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_5__2__Impl_in_rule__TerminalExpr__Group_5__29713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__OperandAssignment_5_2_in_rule__TerminalExpr__Group_5__2__Impl9740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__0__Impl_in_rule__TerminalExpr__Group_6__09776 = new BitSet(new long[]{0x00000007E0000000L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__1_in_rule__TerminalExpr__Group_6__09779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__1__Impl_in_rule__TerminalExpr__Group_6__19837 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__2_in_rule__TerminalExpr__Group_6__19840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__FunctionAssignment_6_1_in_rule__TerminalExpr__Group_6__1__Impl9867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__2__Impl_in_rule__TerminalExpr__Group_6__29897 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__3_in_rule__TerminalExpr__Group_6__29900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__TerminalExpr__Group_6__2__Impl9928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__3__Impl_in_rule__TerminalExpr__Group_6__39959 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__4_in_rule__TerminalExpr__Group_6__39962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__FirstArgAssignment_6_3_in_rule__TerminalExpr__Group_6__3__Impl9989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__4__Impl_in_rule__TerminalExpr__Group_6__410019 = new BitSet(new long[]{0x0044C60FE0180030L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__5_in_rule__TerminalExpr__Group_6__410022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__TerminalExpr__Group_6__4__Impl10050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__5__Impl_in_rule__TerminalExpr__Group_6__510081 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__6_in_rule__TerminalExpr__Group_6__510084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__SecondArgAssignment_6_5_in_rule__TerminalExpr__Group_6__5__Impl10111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__6__Impl_in_rule__TerminalExpr__Group_6__610141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__TerminalExpr__Group_6__6__Impl10169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_8__0__Impl_in_rule__TerminalExpr__Group_8__010214 = new BitSet(new long[]{0x0044C60FE0180030L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_8__1_in_rule__TerminalExpr__Group_8__010217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__TerminalExpr__Group_8__0__Impl10245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_8__1__Impl_in_rule__TerminalExpr__Group_8__110276 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_8__2_in_rule__TerminalExpr__Group_8__110279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__TerminalExpr__Group_8__1__Impl10306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_8__2__Impl_in_rule__TerminalExpr__Group_8__210335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__TerminalExpr__Group_8__2__Impl10363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__0__Impl_in_rule__CallExpr__Group__010400 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__1_in_rule__CallExpr__Group__010403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group_0__0_in_rule__CallExpr__Group__0__Impl10430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__1__Impl_in_rule__CallExpr__Group__110461 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__2_in_rule__CallExpr__Group__110464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__NameAssignment_1_in_rule__CallExpr__Group__1__Impl10491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__2__Impl_in_rule__CallExpr__Group__210521 = new BitSet(new long[]{0x0044C60FE0180030L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__3_in_rule__CallExpr__Group__210524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__CallExpr__Group__2__Impl10552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__3__Impl_in_rule__CallExpr__Group__310583 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__4_in_rule__CallExpr__Group__310586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__ArgListAssignment_3_in_rule__CallExpr__Group__3__Impl10613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__4__Impl_in_rule__CallExpr__Group__410643 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__5_in_rule__CallExpr__Group__410646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__CallExpr__Group__4__Impl10674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__5__Impl_in_rule__CallExpr__Group__510705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group_5__0_in_rule__CallExpr__Group__5__Impl10732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group_0__0__Impl_in_rule__CallExpr__Group_0__010775 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_rule__CallExpr__Group_0__1_in_rule__CallExpr__Group_0__010778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__NamespaceAssignment_0_0_in_rule__CallExpr__Group_0__0__Impl10805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group_0__1__Impl_in_rule__CallExpr__Group_0__110835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__CallExpr__Group_0__1__Impl10863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group_5__0__Impl_in_rule__CallExpr__Group_5__010898 = new BitSet(new long[]{0x0044C60FE0180030L});
    public static final BitSet FOLLOW_rule__CallExpr__Group_5__1_in_rule__CallExpr__Group_5__010901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__CallExpr__Group_5__0__Impl10929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group_5__1__Impl_in_rule__CallExpr__Group_5__110960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__AtAssignment_5_1_in_rule__CallExpr__Group_5__1__Impl10987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group__0__Impl_in_rule__ArgList__Group__011021 = new BitSet(new long[]{0x0044C60FE0180030L});
    public static final BitSet FOLLOW_rule__ArgList__Group__1_in_rule__ArgList__Group__011024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group__1__Impl_in_rule__ArgList__Group__111082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group_1__0_in_rule__ArgList__Group__1__Impl11109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group_1__0__Impl_in_rule__ArgList__Group_1__011144 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__ArgList__Group_1__1_in_rule__ArgList__Group_1__011147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__ArgsAssignment_1_0_in_rule__ArgList__Group_1__0__Impl11174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group_1__1__Impl_in_rule__ArgList__Group_1__111204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group_1_1__0_in_rule__ArgList__Group_1__1__Impl11231 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group_1_1__0__Impl_in_rule__ArgList__Group_1_1__011266 = new BitSet(new long[]{0x0044C60FE0180030L});
    public static final BitSet FOLLOW_rule__ArgList__Group_1_1__1_in_rule__ArgList__Group_1_1__011269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__ArgList__Group_1_1__0__Impl11297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group_1_1__1__Impl_in_rule__ArgList__Group_1_1__111328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__ArgsAssignment_1_1_1_in_rule__ArgList__Group_1_1__1__Impl11355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Group_1__0__Impl_in_rule__Double__Group_1__011389 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_rule__Double__Group_1__1_in_rule__Double__Group_1__011392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Double__Group_1__0__Impl11419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Group_1__1__Impl_in_rule__Double__Group_1__111448 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Double__Group_1__2_in_rule__Double__Group_1__111451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__Double__Group_1__1__Impl11479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Group_1__2__Impl_in_rule__Double__Group_1__211510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Double__Group_1__2__Impl11538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProgramElement_in_rule__Program__ProgramElementsAssignment_111580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProgram_in_rule__DmplSubclause__ProgramAssignment_111611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__Constant__NameAssignment_111642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberConst_in_rule__Constant__ValueAssignment_311673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSign_in_rule__IntConst__SignAssignment_011704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__IntConst__ValueAssignment_111735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSign_in_rule__DoubleConst__SignAssignment_011766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDouble_in_rule__DoubleConst__ValueAssignment_111797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__VarInit__TypeAssignment_011828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarAsgnList_in_rule__VarInit__VarAsgnListAssignment_111859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_rule__VarAsgnList__VarAssignment_011890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarAsgn_in_rule__VarAsgnList__VarAsgnAssignment_111921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_rule__VarAsgn__VarAssignment_011952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnBody_in_rule__VarAsgn__FnBodyAssignment_2_011983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__VarAsgn__ExprAssignment_2_112014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__Var__NameAssignment_012045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDimension_in_rule__Var__DimensionsAssignment_1_112076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Dimension__IndexAssignment_0_112107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__Dimension__IndexAssignment_2_112138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSigned_in_rule__Type__SignedAssignment_012169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpType_in_rule__Type__SimpTypeAssignment_112200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcNoAttr_in_rule__Procedure__ProcedureAssignment12231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnPrototype_in_rule__ProcNoAttr__PrototypeAssignment_012262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnBody_in_rule__ProcNoAttr__FnBodyAssignment_1_112293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarInitList_in_rule__FnBody__VarInitListAssignment_112324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__ExternAlternatives_0_1_0_in_rule__FnPrototype__ExternAssignment_0_112355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__PureAlternatives_0_2_0_in_rule__FnPrototype__PureAssignment_0_212388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__FnPrototype__NameAssignment_0_412421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__ExternAlternatives_1_1_0_in_rule__FnPrototype__ExternAssignment_1_112452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__PureAlternatives_1_2_0_in_rule__FnPrototype__PureAssignment_1_212485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__FnPrototype__TypeAssignment_1_312518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__FnPrototype__NameAssignment_1_412549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParam_in_rule__FnPrototype__ParamsAssignment_1_6_012580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParam_in_rule__FnPrototype__ParamsAssignment_1_6_1_112611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__Param__TypeAssignment_012642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_rule__Param__VarAssignment_112673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarInit_in_rule__VarInitList__VarInitsAssignment_1_012704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__LVal__NameAssignment_012735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__LVal__IndicesAssignment_1_112766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__LVal__AtAssignment_2_112797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftOperator_in_rule__ShiftExpr__OperatorAssignment_1_0_0_112828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpr_in_rule__ShiftExpr__RightAssignment_1_112859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_rule__AdditiveExpr__OperatorAssignment_1_0_0_112890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpr_in_rule__AdditiveExpr__RightAssignment_1_112921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_rule__MultiplicativeExpr__OperatorAssignment_1_0_0_112952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpr_in_rule__MultiplicativeExpr__RightAssignment_1_112983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TerminalExpr__ValueAssignment_2_113014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDouble_in_rule__TerminalExpr__ValueAssignment_3_113045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_rule__TerminalExpr__OperatorAssignment_5_113076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__TerminalExpr__OperandAssignment_5_213107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltInFunction_in_rule__TerminalExpr__FunctionAssignment_6_113138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__TerminalExpr__FirstArgAssignment_6_313169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__TerminalExpr__SecondArgAssignment_6_513200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__CallExpr__NamespaceAssignment_0_013231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__CallExpr__NameAssignment_113262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgList_in_rule__CallExpr__ArgListAssignment_313293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__CallExpr__AtAssignment_5_113324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__ArgList__ArgsAssignment_1_013355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__ArgList__ArgsAssignment_1_1_113386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1__0_in_synpred56_InternalDmpl7917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1__0_in_synpred57_InternalDmpl8340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1__0_in_synpred58_InternalDmpl8763 = new BitSet(new long[]{0x0000000000000002L});

}