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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_TIDENTIFIER", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'const'", "'CONST'", "';'", "'extern'", "'EXTERN'", "'pure'", "'PURE'", "'+'", "'-'", "'bool'", "'_Bool'", "'int'", "'double'", "'void'", "'char'", "'signed'", "'unsigned'", "'exists_other'", "'EXISTS_OTHER'", "'exists_higher'", "'EXISTS_HIGHER'", "'exists_lower'", "'EXISTS_LOWER'", "'NAN'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", "'*'", "'/'", "'%'", "'!'", "'~'", "'='", "'['", "']'", "'#N'", "'{'", "'}'", "'thread'", "'('", "')'", "','", "'@'", "'id'", "'::'", "'.'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_TIDENTIFIER=5;
    public static final int T__60=60;
    public static final int T__61=61;
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
    public static final int T__62=62;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:632:1: ruleExpr : ( ruleEqualityExpr ) ;
    public final void ruleExpr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:636:2: ( ( ruleEqualityExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:637:1: ( ruleEqualityExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:637:1: ( ruleEqualityExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:638:1: ruleEqualityExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExprAccess().getEqualityExprParserRuleCall()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpr_in_ruleExpr1302);
            ruleEqualityExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExprAccess().getEqualityExprParserRuleCall()); 
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


    // $ANTLR start "entryRuleEqualityExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:651:1: entryRuleEqualityExpr : ruleEqualityExpr EOF ;
    public final void entryRuleEqualityExpr() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:652:1: ( ruleEqualityExpr EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:653:1: ruleEqualityExpr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExprRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpr_in_entryRuleEqualityExpr1328);
            ruleEqualityExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExprRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpr1335); if (state.failed) return ;

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
    // $ANTLR end "entryRuleEqualityExpr"


    // $ANTLR start "ruleEqualityExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:660:1: ruleEqualityExpr : ( ( rule__EqualityExpr__Group__0 ) ) ;
    public final void ruleEqualityExpr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:664:2: ( ( ( rule__EqualityExpr__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:665:1: ( ( rule__EqualityExpr__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:665:1: ( ( rule__EqualityExpr__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:666:1: ( rule__EqualityExpr__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExprAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:667:1: ( rule__EqualityExpr__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:667:2: rule__EqualityExpr__Group__0
            {
            pushFollow(FOLLOW_rule__EqualityExpr__Group__0_in_ruleEqualityExpr1361);
            rule__EqualityExpr__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExprAccess().getGroup()); 
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
    // $ANTLR end "ruleEqualityExpr"


    // $ANTLR start "entryRuleCompareExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:679:1: entryRuleCompareExpr : ruleCompareExpr EOF ;
    public final void entryRuleCompareExpr() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:680:1: ( ruleCompareExpr EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:681:1: ruleCompareExpr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompareExprRule()); 
            }
            pushFollow(FOLLOW_ruleCompareExpr_in_entryRuleCompareExpr1388);
            ruleCompareExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompareExprRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompareExpr1395); if (state.failed) return ;

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
    // $ANTLR end "entryRuleCompareExpr"


    // $ANTLR start "ruleCompareExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:688:1: ruleCompareExpr : ( ( rule__CompareExpr__Group__0 ) ) ;
    public final void ruleCompareExpr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:692:2: ( ( ( rule__CompareExpr__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:693:1: ( ( rule__CompareExpr__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:693:1: ( ( rule__CompareExpr__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:694:1: ( rule__CompareExpr__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompareExprAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:695:1: ( rule__CompareExpr__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:695:2: rule__CompareExpr__Group__0
            {
            pushFollow(FOLLOW_rule__CompareExpr__Group__0_in_ruleCompareExpr1421);
            rule__CompareExpr__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompareExprAccess().getGroup()); 
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
    // $ANTLR end "ruleCompareExpr"


    // $ANTLR start "entryRuleShiftExpr"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:707:1: entryRuleShiftExpr : ruleShiftExpr EOF ;
    public final void entryRuleShiftExpr() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:708:1: ( ruleShiftExpr EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:709:1: ruleShiftExpr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprRule()); 
            }
            pushFollow(FOLLOW_ruleShiftExpr_in_entryRuleShiftExpr1448);
            ruleShiftExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getShiftExprRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleShiftExpr1455); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:716:1: ruleShiftExpr : ( ( rule__ShiftExpr__Group__0 ) ) ;
    public final void ruleShiftExpr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:720:2: ( ( ( rule__ShiftExpr__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:721:1: ( ( rule__ShiftExpr__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:721:1: ( ( rule__ShiftExpr__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:722:1: ( rule__ShiftExpr__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:723:1: ( rule__ShiftExpr__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:723:2: rule__ShiftExpr__Group__0
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group__0_in_ruleShiftExpr1481);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:735:1: entryRuleAdditiveExpr : ruleAdditiveExpr EOF ;
    public final void entryRuleAdditiveExpr() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:736:1: ( ruleAdditiveExpr EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:737:1: ruleAdditiveExpr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpr_in_entryRuleAdditiveExpr1508);
            ruleAdditiveExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAdditiveExprRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpr1515); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:744:1: ruleAdditiveExpr : ( ( rule__AdditiveExpr__Group__0 ) ) ;
    public final void ruleAdditiveExpr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:748:2: ( ( ( rule__AdditiveExpr__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:749:1: ( ( rule__AdditiveExpr__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:749:1: ( ( rule__AdditiveExpr__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:750:1: ( rule__AdditiveExpr__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:751:1: ( rule__AdditiveExpr__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:751:2: rule__AdditiveExpr__Group__0
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group__0_in_ruleAdditiveExpr1541);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:763:1: entryRuleMultiplicativeExpr : ruleMultiplicativeExpr EOF ;
    public final void entryRuleMultiplicativeExpr() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:764:1: ( ruleMultiplicativeExpr EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:765:1: ruleMultiplicativeExpr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpr_in_entryRuleMultiplicativeExpr1568);
            ruleMultiplicativeExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicativeExprRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpr1575); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:772:1: ruleMultiplicativeExpr : ( ( rule__MultiplicativeExpr__Group__0 ) ) ;
    public final void ruleMultiplicativeExpr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:776:2: ( ( ( rule__MultiplicativeExpr__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:777:1: ( ( rule__MultiplicativeExpr__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:777:1: ( ( rule__MultiplicativeExpr__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:778:1: ( rule__MultiplicativeExpr__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:779:1: ( rule__MultiplicativeExpr__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:779:2: rule__MultiplicativeExpr__Group__0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group__0_in_ruleMultiplicativeExpr1601);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:791:1: entryRuleTerminalExpr : ruleTerminalExpr EOF ;
    public final void entryRuleTerminalExpr() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:792:1: ( ruleTerminalExpr EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:793:1: ruleTerminalExpr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprRule()); 
            }
            pushFollow(FOLLOW_ruleTerminalExpr_in_entryRuleTerminalExpr1628);
            ruleTerminalExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTerminalExprRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalExpr1635); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:800:1: ruleTerminalExpr : ( ( rule__TerminalExpr__Alternatives ) ) ;
    public final void ruleTerminalExpr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:804:2: ( ( ( rule__TerminalExpr__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:805:1: ( ( rule__TerminalExpr__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:805:1: ( ( rule__TerminalExpr__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:806:1: ( rule__TerminalExpr__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:807:1: ( rule__TerminalExpr__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:807:2: rule__TerminalExpr__Alternatives
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Alternatives_in_ruleTerminalExpr1661);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:819:1: entryRuleCallExpr : ruleCallExpr EOF ;
    public final void entryRuleCallExpr() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:820:1: ( ruleCallExpr EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:821:1: ruleCallExpr EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprRule()); 
            }
            pushFollow(FOLLOW_ruleCallExpr_in_entryRuleCallExpr1688);
            ruleCallExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExprRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallExpr1695); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:828:1: ruleCallExpr : ( ( rule__CallExpr__Group__0 ) ) ;
    public final void ruleCallExpr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:832:2: ( ( ( rule__CallExpr__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:833:1: ( ( rule__CallExpr__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:833:1: ( ( rule__CallExpr__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:834:1: ( rule__CallExpr__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:835:1: ( rule__CallExpr__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:835:2: rule__CallExpr__Group__0
            {
            pushFollow(FOLLOW_rule__CallExpr__Group__0_in_ruleCallExpr1721);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:847:1: entryRuleArgList : ruleArgList EOF ;
    public final void entryRuleArgList() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:848:1: ( ruleArgList EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:849:1: ruleArgList EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListRule()); 
            }
            pushFollow(FOLLOW_ruleArgList_in_entryRuleArgList1748);
            ruleArgList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArgListRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgList1755); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:856:1: ruleArgList : ( ( rule__ArgList__Group__0 ) ) ;
    public final void ruleArgList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:860:2: ( ( ( rule__ArgList__Group__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:861:1: ( ( rule__ArgList__Group__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:861:1: ( ( rule__ArgList__Group__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:862:1: ( rule__ArgList__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getGroup()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:863:1: ( rule__ArgList__Group__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:863:2: rule__ArgList__Group__0
            {
            pushFollow(FOLLOW_rule__ArgList__Group__0_in_ruleArgList1781);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:875:1: entryRuleSign : ruleSign EOF ;
    public final void entryRuleSign() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:876:1: ( ruleSign EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:877:1: ruleSign EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSignRule()); 
            }
            pushFollow(FOLLOW_ruleSign_in_entryRuleSign1808);
            ruleSign();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSignRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSign1815); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:884:1: ruleSign : ( ( rule__Sign__Alternatives ) ) ;
    public final void ruleSign() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:888:2: ( ( ( rule__Sign__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:889:1: ( ( rule__Sign__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:889:1: ( ( rule__Sign__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:890:1: ( rule__Sign__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSignAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:891:1: ( rule__Sign__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:891:2: rule__Sign__Alternatives
            {
            pushFollow(FOLLOW_rule__Sign__Alternatives_in_ruleSign1841);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:903:1: entryRuleSimpType : ruleSimpType EOF ;
    public final void entryRuleSimpType() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:904:1: ( ruleSimpType EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:905:1: ruleSimpType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpTypeRule()); 
            }
            pushFollow(FOLLOW_ruleSimpType_in_entryRuleSimpType1868);
            ruleSimpType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSimpTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpType1875); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:912:1: ruleSimpType : ( ( rule__SimpType__Alternatives ) ) ;
    public final void ruleSimpType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:916:2: ( ( ( rule__SimpType__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:917:1: ( ( rule__SimpType__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:917:1: ( ( rule__SimpType__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:918:1: ( rule__SimpType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSimpTypeAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:919:1: ( rule__SimpType__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:919:2: rule__SimpType__Alternatives
            {
            pushFollow(FOLLOW_rule__SimpType__Alternatives_in_ruleSimpType1901);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:931:1: entryRuleSigned : ruleSigned EOF ;
    public final void entryRuleSigned() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:932:1: ( ruleSigned EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:933:1: ruleSigned EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSignedRule()); 
            }
            pushFollow(FOLLOW_ruleSigned_in_entryRuleSigned1928);
            ruleSigned();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSignedRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSigned1935); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:940:1: ruleSigned : ( ( rule__Signed__Alternatives ) ) ;
    public final void ruleSigned() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:944:2: ( ( ( rule__Signed__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:945:1: ( ( rule__Signed__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:945:1: ( ( rule__Signed__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:946:1: ( rule__Signed__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSignedAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:947:1: ( rule__Signed__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:947:2: rule__Signed__Alternatives
            {
            pushFollow(FOLLOW_rule__Signed__Alternatives_in_ruleSigned1961);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:959:1: entryRuleBuiltInFunction : ruleBuiltInFunction EOF ;
    public final void entryRuleBuiltInFunction() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:960:1: ( ruleBuiltInFunction EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:961:1: ruleBuiltInFunction EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBuiltInFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleBuiltInFunction_in_entryRuleBuiltInFunction1988);
            ruleBuiltInFunction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBuiltInFunctionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBuiltInFunction1995); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:968:1: ruleBuiltInFunction : ( ( rule__BuiltInFunction__Alternatives ) ) ;
    public final void ruleBuiltInFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:972:2: ( ( ( rule__BuiltInFunction__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:973:1: ( ( rule__BuiltInFunction__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:973:1: ( ( rule__BuiltInFunction__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:974:1: ( rule__BuiltInFunction__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBuiltInFunctionAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:975:1: ( rule__BuiltInFunction__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:975:2: rule__BuiltInFunction__Alternatives
            {
            pushFollow(FOLLOW_rule__BuiltInFunction__Alternatives_in_ruleBuiltInFunction2021);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:987:1: entryRuleDouble : ruleDouble EOF ;
    public final void entryRuleDouble() throws RecognitionException {
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:988:1: ( ruleDouble EOF )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:989:1: ruleDouble EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleRule()); 
            }
            pushFollow(FOLLOW_ruleDouble_in_entryRuleDouble2048);
            ruleDouble();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDoubleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDouble2055); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:996:1: ruleDouble : ( ( rule__Double__Alternatives ) ) ;
    public final void ruleDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1000:2: ( ( ( rule__Double__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1001:1: ( ( rule__Double__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1001:1: ( ( rule__Double__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1002:1: ( rule__Double__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1003:1: ( rule__Double__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1003:2: rule__Double__Alternatives
            {
            pushFollow(FOLLOW_rule__Double__Alternatives_in_ruleDouble2081);
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


    // $ANTLR start "ruleEqualityOperator"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1022:1: ruleEqualityOperator : ( ( rule__EqualityOperator__Alternatives ) ) ;
    public final void ruleEqualityOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1026:1: ( ( ( rule__EqualityOperator__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1027:1: ( ( rule__EqualityOperator__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1027:1: ( ( rule__EqualityOperator__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1028:1: ( rule__EqualityOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityOperatorAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1029:1: ( rule__EqualityOperator__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1029:2: rule__EqualityOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__EqualityOperator__Alternatives_in_ruleEqualityOperator2124);
            rule__EqualityOperator__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityOperatorAccess().getAlternatives()); 
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
    // $ANTLR end "ruleEqualityOperator"


    // $ANTLR start "ruleCompareOperator"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1041:1: ruleCompareOperator : ( ( rule__CompareOperator__Alternatives ) ) ;
    public final void ruleCompareOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1045:1: ( ( ( rule__CompareOperator__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1046:1: ( ( rule__CompareOperator__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1046:1: ( ( rule__CompareOperator__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1047:1: ( rule__CompareOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompareOperatorAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1048:1: ( rule__CompareOperator__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1048:2: rule__CompareOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__CompareOperator__Alternatives_in_ruleCompareOperator2160);
            rule__CompareOperator__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompareOperatorAccess().getAlternatives()); 
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
    // $ANTLR end "ruleCompareOperator"


    // $ANTLR start "ruleShiftOperator"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1060:1: ruleShiftOperator : ( ( rule__ShiftOperator__Alternatives ) ) ;
    public final void ruleShiftOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1064:1: ( ( ( rule__ShiftOperator__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1065:1: ( ( rule__ShiftOperator__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1065:1: ( ( rule__ShiftOperator__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1066:1: ( rule__ShiftOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftOperatorAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1067:1: ( rule__ShiftOperator__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1067:2: rule__ShiftOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__ShiftOperator__Alternatives_in_ruleShiftOperator2196);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1079:1: ruleAdditiveOperator : ( ( rule__AdditiveOperator__Alternatives ) ) ;
    public final void ruleAdditiveOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1083:1: ( ( ( rule__AdditiveOperator__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1084:1: ( ( rule__AdditiveOperator__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1084:1: ( ( rule__AdditiveOperator__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1085:1: ( rule__AdditiveOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveOperatorAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1086:1: ( rule__AdditiveOperator__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1086:2: rule__AdditiveOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__AdditiveOperator__Alternatives_in_ruleAdditiveOperator2232);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1098:1: ruleMultiplicativeOperator : ( ( rule__MultiplicativeOperator__Alternatives ) ) ;
    public final void ruleMultiplicativeOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1102:1: ( ( ( rule__MultiplicativeOperator__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1103:1: ( ( rule__MultiplicativeOperator__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1103:1: ( ( rule__MultiplicativeOperator__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1104:1: ( rule__MultiplicativeOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeOperatorAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1105:1: ( rule__MultiplicativeOperator__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1105:2: rule__MultiplicativeOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__MultiplicativeOperator__Alternatives_in_ruleMultiplicativeOperator2268);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1117:1: ruleUnaryOperator : ( ( rule__UnaryOperator__Alternatives ) ) ;
    public final void ruleUnaryOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1121:1: ( ( ( rule__UnaryOperator__Alternatives ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1122:1: ( ( rule__UnaryOperator__Alternatives ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1122:1: ( ( rule__UnaryOperator__Alternatives ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1123:1: ( rule__UnaryOperator__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnaryOperatorAccess().getAlternatives()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1124:1: ( rule__UnaryOperator__Alternatives )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1124:2: rule__UnaryOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__UnaryOperator__Alternatives_in_ruleUnaryOperator2304);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1137:1: rule__ProgramElement__Alternatives : ( ( ruleConstant ) | ( ruleProcedure ) );
    public final void rule__ProgramElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1141:1: ( ( ruleConstant ) | ( ruleProcedure ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=12 && LA1_0<=13)) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=15 && LA1_0<=18)||(LA1_0>=21 && LA1_0<=28)||LA1_0==55) ) {
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1142:1: ( ruleConstant )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1142:1: ( ruleConstant )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1143:1: ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProgramElementAccess().getConstantParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleConstant_in_rule__ProgramElement__Alternatives2341);
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1148:6: ( ruleProcedure )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1148:6: ( ruleProcedure )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1149:1: ruleProcedure
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProgramElementAccess().getProcedureParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleProcedure_in_rule__ProgramElement__Alternatives2358);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1159:1: rule__Constant__Alternatives_0 : ( ( 'const' ) | ( 'CONST' ) );
    public final void rule__Constant__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1163:1: ( ( 'const' ) | ( 'CONST' ) )
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1164:1: ( 'const' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1164:1: ( 'const' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1165:1: 'const'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConstantAccess().getConstKeyword_0_0()); 
                    }
                    match(input,12,FOLLOW_12_in_rule__Constant__Alternatives_02391); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConstantAccess().getConstKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1172:6: ( 'CONST' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1172:6: ( 'CONST' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1173:1: 'CONST'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConstantAccess().getCONSTKeyword_0_1()); 
                    }
                    match(input,13,FOLLOW_13_in_rule__Constant__Alternatives_02411); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1185:1: rule__NumberConst__Alternatives : ( ( ruleIntConst ) | ( ruleDoubleConst ) );
    public final void rule__NumberConst__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1189:1: ( ( ruleIntConst ) | ( ruleDoubleConst ) )
            int alt3=2;
            switch ( input.LA(1) ) {
            case 19:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==35) ) {
                    alt3=2;
                }
                else if ( (LA3_1==RULE_INT) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==EOF||LA3_3==14) ) {
                        alt3=1;
                    }
                    else if ( (LA3_3==62) ) {
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
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==RULE_INT) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==EOF||LA3_3==14) ) {
                        alt3=1;
                    }
                    else if ( (LA3_3==62) ) {
                        alt3=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA3_2==35) ) {
                    alt3=2;
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
                else if ( (LA3_3==62) ) {
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1190:1: ( ruleIntConst )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1190:1: ( ruleIntConst )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1191:1: ruleIntConst
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberConstAccess().getIntConstParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleIntConst_in_rule__NumberConst__Alternatives2445);
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1196:6: ( ruleDoubleConst )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1196:6: ( ruleDoubleConst )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1197:1: ruleDoubleConst
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNumberConstAccess().getDoubleConstParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleDoubleConst_in_rule__NumberConst__Alternatives2462);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1207:1: rule__VarAsgnList__Alternatives : ( ( ( rule__VarAsgnList__VarAssignment_0 ) ) | ( ( rule__VarAsgnList__VarAsgnAssignment_1 ) ) );
    public final void rule__VarAsgnList__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1211:1: ( ( ( rule__VarAsgnList__VarAssignment_0 ) ) | ( ( rule__VarAsgnList__VarAsgnAssignment_1 ) ) )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1212:1: ( ( rule__VarAsgnList__VarAssignment_0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1212:1: ( ( rule__VarAsgnList__VarAssignment_0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1213:1: ( rule__VarAsgnList__VarAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVarAsgnListAccess().getVarAssignment_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1214:1: ( rule__VarAsgnList__VarAssignment_0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1214:2: rule__VarAsgnList__VarAssignment_0
                    {
                    pushFollow(FOLLOW_rule__VarAsgnList__VarAssignment_0_in_rule__VarAsgnList__Alternatives2494);
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1218:6: ( ( rule__VarAsgnList__VarAsgnAssignment_1 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1218:6: ( ( rule__VarAsgnList__VarAsgnAssignment_1 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1219:1: ( rule__VarAsgnList__VarAsgnAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVarAsgnListAccess().getVarAsgnAssignment_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1220:1: ( rule__VarAsgnList__VarAsgnAssignment_1 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1220:2: rule__VarAsgnList__VarAsgnAssignment_1
                    {
                    pushFollow(FOLLOW_rule__VarAsgnList__VarAsgnAssignment_1_in_rule__VarAsgnList__Alternatives2512);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1229:1: rule__VarAsgn__Alternatives_2 : ( ( ( rule__VarAsgn__FnBodyAssignment_2_0 ) ) | ( ( rule__VarAsgn__ExprAssignment_2_1 ) ) );
    public final void rule__VarAsgn__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1233:1: ( ( ( rule__VarAsgn__FnBodyAssignment_2_0 ) ) | ( ( rule__VarAsgn__ExprAssignment_2_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==53) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=RULE_INT && LA5_0<=RULE_TIDENTIFIER)||(LA5_0>=19 && LA5_0<=20)||(LA5_0>=29 && LA5_0<=35)||(LA5_0>=47 && LA5_0<=48)||LA5_0==52||LA5_0==56||LA5_0==60) ) {
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1234:1: ( ( rule__VarAsgn__FnBodyAssignment_2_0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1234:1: ( ( rule__VarAsgn__FnBodyAssignment_2_0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1235:1: ( rule__VarAsgn__FnBodyAssignment_2_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVarAsgnAccess().getFnBodyAssignment_2_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1236:1: ( rule__VarAsgn__FnBodyAssignment_2_0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1236:2: rule__VarAsgn__FnBodyAssignment_2_0
                    {
                    pushFollow(FOLLOW_rule__VarAsgn__FnBodyAssignment_2_0_in_rule__VarAsgn__Alternatives_22545);
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1240:6: ( ( rule__VarAsgn__ExprAssignment_2_1 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1240:6: ( ( rule__VarAsgn__ExprAssignment_2_1 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1241:1: ( rule__VarAsgn__ExprAssignment_2_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVarAsgnAccess().getExprAssignment_2_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1242:1: ( rule__VarAsgn__ExprAssignment_2_1 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1242:2: rule__VarAsgn__ExprAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__VarAsgn__ExprAssignment_2_1_in_rule__VarAsgn__Alternatives_22563);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1251:1: rule__Dimension__Alternatives : ( ( ( rule__Dimension__Group_0__0 ) ) | ( ( rule__Dimension__Group_1__0 ) ) | ( ( rule__Dimension__Group_2__0 ) ) );
    public final void rule__Dimension__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1255:1: ( ( ( rule__Dimension__Group_0__0 ) ) | ( ( rule__Dimension__Group_1__0 ) ) | ( ( rule__Dimension__Group_2__0 ) ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt6=1;
                }
                break;
            case 52:
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1256:1: ( ( rule__Dimension__Group_0__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1256:1: ( ( rule__Dimension__Group_0__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1257:1: ( rule__Dimension__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDimensionAccess().getGroup_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1258:1: ( rule__Dimension__Group_0__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1258:2: rule__Dimension__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Dimension__Group_0__0_in_rule__Dimension__Alternatives2596);
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1262:6: ( ( rule__Dimension__Group_1__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1262:6: ( ( rule__Dimension__Group_1__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1263:1: ( rule__Dimension__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDimensionAccess().getGroup_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1264:1: ( rule__Dimension__Group_1__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1264:2: rule__Dimension__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Dimension__Group_1__0_in_rule__Dimension__Alternatives2614);
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1268:6: ( ( rule__Dimension__Group_2__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1268:6: ( ( rule__Dimension__Group_2__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1269:1: ( rule__Dimension__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDimensionAccess().getGroup_2()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1270:1: ( rule__Dimension__Group_2__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1270:2: rule__Dimension__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Dimension__Group_2__0_in_rule__Dimension__Alternatives2632);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1279:1: rule__ProcNoAttr__Alternatives_1 : ( ( ';' ) | ( ( rule__ProcNoAttr__FnBodyAssignment_1_1 ) ) );
    public final void rule__ProcNoAttr__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1283:1: ( ( ';' ) | ( ( rule__ProcNoAttr__FnBodyAssignment_1_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            else if ( (LA7_0==53) ) {
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1284:1: ( ';' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1284:1: ( ';' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1285:1: ';'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProcNoAttrAccess().getSemicolonKeyword_1_0()); 
                    }
                    match(input,14,FOLLOW_14_in_rule__ProcNoAttr__Alternatives_12666); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getProcNoAttrAccess().getSemicolonKeyword_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1292:6: ( ( rule__ProcNoAttr__FnBodyAssignment_1_1 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1292:6: ( ( rule__ProcNoAttr__FnBodyAssignment_1_1 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1293:1: ( rule__ProcNoAttr__FnBodyAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getProcNoAttrAccess().getFnBodyAssignment_1_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1294:1: ( rule__ProcNoAttr__FnBodyAssignment_1_1 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1294:2: rule__ProcNoAttr__FnBodyAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__ProcNoAttr__FnBodyAssignment_1_1_in_rule__ProcNoAttr__Alternatives_12685);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1303:1: rule__FnPrototype__Alternatives : ( ( ( rule__FnPrototype__Group_0__0 ) ) | ( ( rule__FnPrototype__Group_1__0 ) ) );
    public final void rule__FnPrototype__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1307:1: ( ( ( rule__FnPrototype__Group_0__0 ) ) | ( ( rule__FnPrototype__Group_1__0 ) ) )
            int alt8=2;
            switch ( input.LA(1) ) {
            case 15:
                {
                switch ( input.LA(2) ) {
                case 17:
                    {
                    int LA8_3 = input.LA(3);

                    if ( (LA8_3==55) ) {
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

                    if ( (LA8_4==55) ) {
                        alt8=1;
                    }
                    else if ( ((LA8_4>=21 && LA8_4<=28)) ) {
                        alt8=2;
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
                case 55:
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

                    if ( (LA8_3==55) ) {
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

                    if ( (LA8_4==55) ) {
                        alt8=1;
                    }
                    else if ( ((LA8_4>=21 && LA8_4<=28)) ) {
                        alt8=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 55:
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
                        new NoViableAltException("", 8, 2, input);

                    throw nvae;
                }

                }
                break;
            case 17:
                {
                int LA8_3 = input.LA(2);

                if ( (LA8_3==55) ) {
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

                if ( (LA8_4==55) ) {
                    alt8=1;
                }
                else if ( ((LA8_4>=21 && LA8_4<=28)) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 4, input);

                    throw nvae;
                }
                }
                break;
            case 55:
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1308:1: ( ( rule__FnPrototype__Group_0__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1308:1: ( ( rule__FnPrototype__Group_0__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1309:1: ( rule__FnPrototype__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getGroup_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1310:1: ( rule__FnPrototype__Group_0__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1310:2: rule__FnPrototype__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__Group_0__0_in_rule__FnPrototype__Alternatives2718);
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1314:6: ( ( rule__FnPrototype__Group_1__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1314:6: ( ( rule__FnPrototype__Group_1__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1315:1: ( rule__FnPrototype__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getGroup_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1316:1: ( rule__FnPrototype__Group_1__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1316:2: rule__FnPrototype__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__Group_1__0_in_rule__FnPrototype__Alternatives2736);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1325:1: rule__FnPrototype__ExternAlternatives_0_1_0 : ( ( 'extern' ) | ( 'EXTERN' ) );
    public final void rule__FnPrototype__ExternAlternatives_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1329:1: ( ( 'extern' ) | ( 'EXTERN' ) )
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1330:1: ( 'extern' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1330:1: ( 'extern' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1331:1: 'extern'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getExternExternKeyword_0_1_0_0()); 
                    }
                    match(input,15,FOLLOW_15_in_rule__FnPrototype__ExternAlternatives_0_1_02770); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFnPrototypeAccess().getExternExternKeyword_0_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1338:6: ( 'EXTERN' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1338:6: ( 'EXTERN' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1339:1: 'EXTERN'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getExternEXTERNKeyword_0_1_0_1()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__FnPrototype__ExternAlternatives_0_1_02790); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1351:1: rule__FnPrototype__PureAlternatives_0_2_0 : ( ( 'pure' ) | ( 'PURE' ) );
    public final void rule__FnPrototype__PureAlternatives_0_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1355:1: ( ( 'pure' ) | ( 'PURE' ) )
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1356:1: ( 'pure' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1356:1: ( 'pure' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1357:1: 'pure'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getPurePureKeyword_0_2_0_0()); 
                    }
                    match(input,17,FOLLOW_17_in_rule__FnPrototype__PureAlternatives_0_2_02825); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFnPrototypeAccess().getPurePureKeyword_0_2_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1364:6: ( 'PURE' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1364:6: ( 'PURE' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1365:1: 'PURE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getPurePUREKeyword_0_2_0_1()); 
                    }
                    match(input,18,FOLLOW_18_in_rule__FnPrototype__PureAlternatives_0_2_02845); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1377:1: rule__FnPrototype__ExternAlternatives_1_1_0 : ( ( 'extern' ) | ( 'EXTERN' ) );
    public final void rule__FnPrototype__ExternAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1381:1: ( ( 'extern' ) | ( 'EXTERN' ) )
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1382:1: ( 'extern' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1382:1: ( 'extern' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1383:1: 'extern'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getExternExternKeyword_1_1_0_0()); 
                    }
                    match(input,15,FOLLOW_15_in_rule__FnPrototype__ExternAlternatives_1_1_02880); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFnPrototypeAccess().getExternExternKeyword_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1390:6: ( 'EXTERN' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1390:6: ( 'EXTERN' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1391:1: 'EXTERN'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getExternEXTERNKeyword_1_1_0_1()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__FnPrototype__ExternAlternatives_1_1_02900); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1403:1: rule__FnPrototype__PureAlternatives_1_2_0 : ( ( 'pure' ) | ( 'PURE' ) );
    public final void rule__FnPrototype__PureAlternatives_1_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1407:1: ( ( 'pure' ) | ( 'PURE' ) )
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1408:1: ( 'pure' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1408:1: ( 'pure' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1409:1: 'pure'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getPurePureKeyword_1_2_0_0()); 
                    }
                    match(input,17,FOLLOW_17_in_rule__FnPrototype__PureAlternatives_1_2_02935); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFnPrototypeAccess().getPurePureKeyword_1_2_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1416:6: ( 'PURE' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1416:6: ( 'PURE' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1417:1: 'PURE'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFnPrototypeAccess().getPurePUREKeyword_1_2_0_1()); 
                    }
                    match(input,18,FOLLOW_18_in_rule__FnPrototype__PureAlternatives_1_2_02955); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1429:1: rule__TerminalExpr__Alternatives : ( ( ruleLVal ) | ( ( rule__TerminalExpr__Group_1__0 ) ) | ( ( rule__TerminalExpr__Group_2__0 ) ) | ( ( rule__TerminalExpr__Group_3__0 ) ) | ( ( rule__TerminalExpr__Group_4__0 ) ) | ( ( rule__TerminalExpr__Group_5__0 ) ) | ( ( rule__TerminalExpr__Group_6__0 ) ) | ( ruleCallExpr ) | ( ( rule__TerminalExpr__Group_8__0 ) ) );
    public final void rule__TerminalExpr__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1433:1: ( ( ruleLVal ) | ( ( rule__TerminalExpr__Group_1__0 ) ) | ( ( rule__TerminalExpr__Group_2__0 ) ) | ( ( rule__TerminalExpr__Group_3__0 ) ) | ( ( rule__TerminalExpr__Group_4__0 ) ) | ( ( rule__TerminalExpr__Group_5__0 ) ) | ( ( rule__TerminalExpr__Group_6__0 ) ) | ( ruleCallExpr ) | ( ( rule__TerminalExpr__Group_8__0 ) ) )
            int alt13=9;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1434:1: ( ruleLVal )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1434:1: ( ruleLVal )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1435:1: ruleLVal
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getLValParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleLVal_in_rule__TerminalExpr__Alternatives2989);
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1440:6: ( ( rule__TerminalExpr__Group_1__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1440:6: ( ( rule__TerminalExpr__Group_1__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1441:1: ( rule__TerminalExpr__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getGroup_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1442:1: ( rule__TerminalExpr__Group_1__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1442:2: rule__TerminalExpr__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__TerminalExpr__Group_1__0_in_rule__TerminalExpr__Alternatives3006);
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1446:6: ( ( rule__TerminalExpr__Group_2__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1446:6: ( ( rule__TerminalExpr__Group_2__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1447:1: ( rule__TerminalExpr__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getGroup_2()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1448:1: ( rule__TerminalExpr__Group_2__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1448:2: rule__TerminalExpr__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__TerminalExpr__Group_2__0_in_rule__TerminalExpr__Alternatives3024);
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1452:6: ( ( rule__TerminalExpr__Group_3__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1452:6: ( ( rule__TerminalExpr__Group_3__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1453:1: ( rule__TerminalExpr__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getGroup_3()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1454:1: ( rule__TerminalExpr__Group_3__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1454:2: rule__TerminalExpr__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__TerminalExpr__Group_3__0_in_rule__TerminalExpr__Alternatives3042);
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1458:6: ( ( rule__TerminalExpr__Group_4__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1458:6: ( ( rule__TerminalExpr__Group_4__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1459:1: ( rule__TerminalExpr__Group_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getGroup_4()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1460:1: ( rule__TerminalExpr__Group_4__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1460:2: rule__TerminalExpr__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__TerminalExpr__Group_4__0_in_rule__TerminalExpr__Alternatives3060);
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1464:6: ( ( rule__TerminalExpr__Group_5__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1464:6: ( ( rule__TerminalExpr__Group_5__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1465:1: ( rule__TerminalExpr__Group_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getGroup_5()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1466:1: ( rule__TerminalExpr__Group_5__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1466:2: rule__TerminalExpr__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__TerminalExpr__Group_5__0_in_rule__TerminalExpr__Alternatives3078);
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1470:6: ( ( rule__TerminalExpr__Group_6__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1470:6: ( ( rule__TerminalExpr__Group_6__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1471:1: ( rule__TerminalExpr__Group_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getGroup_6()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1472:1: ( rule__TerminalExpr__Group_6__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1472:2: rule__TerminalExpr__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__TerminalExpr__Group_6__0_in_rule__TerminalExpr__Alternatives3096);
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1476:6: ( ruleCallExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1476:6: ( ruleCallExpr )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1477:1: ruleCallExpr
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getCallExprParserRuleCall_7()); 
                    }
                    pushFollow(FOLLOW_ruleCallExpr_in_rule__TerminalExpr__Alternatives3114);
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1482:6: ( ( rule__TerminalExpr__Group_8__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1482:6: ( ( rule__TerminalExpr__Group_8__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1483:1: ( rule__TerminalExpr__Group_8__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTerminalExprAccess().getGroup_8()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1484:1: ( rule__TerminalExpr__Group_8__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1484:2: rule__TerminalExpr__Group_8__0
                    {
                    pushFollow(FOLLOW_rule__TerminalExpr__Group_8__0_in_rule__TerminalExpr__Alternatives3131);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1493:1: rule__Sign__Alternatives : ( ( '+' ) | ( '-' ) );
    public final void rule__Sign__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1497:1: ( ( '+' ) | ( '-' ) )
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1498:1: ( '+' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1498:1: ( '+' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1499:1: '+'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSignAccess().getPlusSignKeyword_0()); 
                    }
                    match(input,19,FOLLOW_19_in_rule__Sign__Alternatives3165); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSignAccess().getPlusSignKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1506:6: ( '-' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1506:6: ( '-' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1507:1: '-'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSignAccess().getHyphenMinusKeyword_1()); 
                    }
                    match(input,20,FOLLOW_20_in_rule__Sign__Alternatives3185); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1519:1: rule__SimpType__Alternatives : ( ( 'bool' ) | ( '_Bool' ) | ( 'int' ) | ( 'double' ) | ( 'void' ) | ( 'char' ) );
    public final void rule__SimpType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1523:1: ( ( 'bool' ) | ( '_Bool' ) | ( 'int' ) | ( 'double' ) | ( 'void' ) | ( 'char' ) )
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1524:1: ( 'bool' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1524:1: ( 'bool' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1525:1: 'bool'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpTypeAccess().getBoolKeyword_0()); 
                    }
                    match(input,21,FOLLOW_21_in_rule__SimpType__Alternatives3220); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpTypeAccess().getBoolKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1532:6: ( '_Bool' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1532:6: ( '_Bool' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1533:1: '_Bool'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpTypeAccess().get_BoolKeyword_1()); 
                    }
                    match(input,22,FOLLOW_22_in_rule__SimpType__Alternatives3240); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpTypeAccess().get_BoolKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1540:6: ( 'int' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1540:6: ( 'int' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1541:1: 'int'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpTypeAccess().getIntKeyword_2()); 
                    }
                    match(input,23,FOLLOW_23_in_rule__SimpType__Alternatives3260); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpTypeAccess().getIntKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1548:6: ( 'double' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1548:6: ( 'double' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1549:1: 'double'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpTypeAccess().getDoubleKeyword_3()); 
                    }
                    match(input,24,FOLLOW_24_in_rule__SimpType__Alternatives3280); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpTypeAccess().getDoubleKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1556:6: ( 'void' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1556:6: ( 'void' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1557:1: 'void'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpTypeAccess().getVoidKeyword_4()); 
                    }
                    match(input,25,FOLLOW_25_in_rule__SimpType__Alternatives3300); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSimpTypeAccess().getVoidKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1564:6: ( 'char' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1564:6: ( 'char' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1565:1: 'char'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSimpTypeAccess().getCharKeyword_5()); 
                    }
                    match(input,26,FOLLOW_26_in_rule__SimpType__Alternatives3320); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1577:1: rule__Signed__Alternatives : ( ( 'signed' ) | ( 'unsigned' ) );
    public final void rule__Signed__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1581:1: ( ( 'signed' ) | ( 'unsigned' ) )
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1582:1: ( 'signed' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1582:1: ( 'signed' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1583:1: 'signed'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSignedAccess().getSignedKeyword_0()); 
                    }
                    match(input,27,FOLLOW_27_in_rule__Signed__Alternatives3355); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSignedAccess().getSignedKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1590:6: ( 'unsigned' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1590:6: ( 'unsigned' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1591:1: 'unsigned'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSignedAccess().getUnsignedKeyword_1()); 
                    }
                    match(input,28,FOLLOW_28_in_rule__Signed__Alternatives3375); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1603:1: rule__BuiltInFunction__Alternatives : ( ( 'exists_other' ) | ( 'EXISTS_OTHER' ) | ( 'exists_higher' ) | ( 'EXISTS_HIGHER' ) | ( 'exists_lower' ) | ( 'EXISTS_LOWER' ) );
    public final void rule__BuiltInFunction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1607:1: ( ( 'exists_other' ) | ( 'EXISTS_OTHER' ) | ( 'exists_higher' ) | ( 'EXISTS_HIGHER' ) | ( 'exists_lower' ) | ( 'EXISTS_LOWER' ) )
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1608:1: ( 'exists_other' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1608:1: ( 'exists_other' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1609:1: 'exists_other'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBuiltInFunctionAccess().getExists_otherKeyword_0()); 
                    }
                    match(input,29,FOLLOW_29_in_rule__BuiltInFunction__Alternatives3410); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBuiltInFunctionAccess().getExists_otherKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1616:6: ( 'EXISTS_OTHER' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1616:6: ( 'EXISTS_OTHER' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1617:1: 'EXISTS_OTHER'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBuiltInFunctionAccess().getEXISTS_OTHERKeyword_1()); 
                    }
                    match(input,30,FOLLOW_30_in_rule__BuiltInFunction__Alternatives3430); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBuiltInFunctionAccess().getEXISTS_OTHERKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1624:6: ( 'exists_higher' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1624:6: ( 'exists_higher' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1625:1: 'exists_higher'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBuiltInFunctionAccess().getExists_higherKeyword_2()); 
                    }
                    match(input,31,FOLLOW_31_in_rule__BuiltInFunction__Alternatives3450); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBuiltInFunctionAccess().getExists_higherKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1632:6: ( 'EXISTS_HIGHER' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1632:6: ( 'EXISTS_HIGHER' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1633:1: 'EXISTS_HIGHER'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBuiltInFunctionAccess().getEXISTS_HIGHERKeyword_3()); 
                    }
                    match(input,32,FOLLOW_32_in_rule__BuiltInFunction__Alternatives3470); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBuiltInFunctionAccess().getEXISTS_HIGHERKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1640:6: ( 'exists_lower' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1640:6: ( 'exists_lower' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1641:1: 'exists_lower'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBuiltInFunctionAccess().getExists_lowerKeyword_4()); 
                    }
                    match(input,33,FOLLOW_33_in_rule__BuiltInFunction__Alternatives3490); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBuiltInFunctionAccess().getExists_lowerKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1648:6: ( 'EXISTS_LOWER' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1648:6: ( 'EXISTS_LOWER' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1649:1: 'EXISTS_LOWER'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBuiltInFunctionAccess().getEXISTS_LOWERKeyword_5()); 
                    }
                    match(input,34,FOLLOW_34_in_rule__BuiltInFunction__Alternatives3510); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1661:1: rule__Double__Alternatives : ( ( 'NAN' ) | ( ( rule__Double__Group_1__0 ) ) );
    public final void rule__Double__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1665:1: ( ( 'NAN' ) | ( ( rule__Double__Group_1__0 ) ) )
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1666:1: ( 'NAN' )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1666:1: ( 'NAN' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1667:1: 'NAN'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDoubleAccess().getNANKeyword_0()); 
                    }
                    match(input,35,FOLLOW_35_in_rule__Double__Alternatives3545); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDoubleAccess().getNANKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1674:6: ( ( rule__Double__Group_1__0 ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1674:6: ( ( rule__Double__Group_1__0 ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1675:1: ( rule__Double__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDoubleAccess().getGroup_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1676:1: ( rule__Double__Group_1__0 )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1676:2: rule__Double__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Double__Group_1__0_in_rule__Double__Alternatives3564);
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


    // $ANTLR start "rule__EqualityOperator__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1688:1: rule__EqualityOperator__Alternatives : ( ( ( '==' ) ) | ( ( '!=' ) ) );
    public final void rule__EqualityOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1692:1: ( ( ( '==' ) ) | ( ( '!=' ) ) )
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
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1693:1: ( ( '==' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1693:1: ( ( '==' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1694:1: ( '==' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEqualityOperatorAccess().getEQUALEnumLiteralDeclaration_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1695:1: ( '==' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1695:3: '=='
                    {
                    match(input,36,FOLLOW_36_in_rule__EqualityOperator__Alternatives3601); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEqualityOperatorAccess().getEQUALEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1700:6: ( ( '!=' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1700:6: ( ( '!=' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1701:1: ( '!=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEqualityOperatorAccess().getNOT_EQUALEnumLiteralDeclaration_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1702:1: ( '!=' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1702:3: '!='
                    {
                    match(input,37,FOLLOW_37_in_rule__EqualityOperator__Alternatives3622); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEqualityOperatorAccess().getNOT_EQUALEnumLiteralDeclaration_1()); 
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
    // $ANTLR end "rule__EqualityOperator__Alternatives"


    // $ANTLR start "rule__CompareOperator__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1712:1: rule__CompareOperator__Alternatives : ( ( ( '<' ) ) | ( ( '<=' ) ) | ( ( '>' ) ) | ( ( '>=' ) ) );
    public final void rule__CompareOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1716:1: ( ( ( '<' ) ) | ( ( '<=' ) ) | ( ( '>' ) ) | ( ( '>=' ) ) )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt20=1;
                }
                break;
            case 39:
                {
                alt20=2;
                }
                break;
            case 40:
                {
                alt20=3;
                }
                break;
            case 41:
                {
                alt20=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1717:1: ( ( '<' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1717:1: ( ( '<' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1718:1: ( '<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCompareOperatorAccess().getLESSEnumLiteralDeclaration_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1719:1: ( '<' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1719:3: '<'
                    {
                    match(input,38,FOLLOW_38_in_rule__CompareOperator__Alternatives3658); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCompareOperatorAccess().getLESSEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1724:6: ( ( '<=' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1724:6: ( ( '<=' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1725:1: ( '<=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCompareOperatorAccess().getLESS_EQUALEnumLiteralDeclaration_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1726:1: ( '<=' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1726:3: '<='
                    {
                    match(input,39,FOLLOW_39_in_rule__CompareOperator__Alternatives3679); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCompareOperatorAccess().getLESS_EQUALEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1731:6: ( ( '>' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1731:6: ( ( '>' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1732:1: ( '>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCompareOperatorAccess().getGREATEREnumLiteralDeclaration_2()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1733:1: ( '>' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1733:3: '>'
                    {
                    match(input,40,FOLLOW_40_in_rule__CompareOperator__Alternatives3700); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCompareOperatorAccess().getGREATEREnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1738:6: ( ( '>=' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1738:6: ( ( '>=' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1739:1: ( '>=' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCompareOperatorAccess().getGREATER_EQUALEnumLiteralDeclaration_3()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1740:1: ( '>=' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1740:3: '>='
                    {
                    match(input,41,FOLLOW_41_in_rule__CompareOperator__Alternatives3721); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCompareOperatorAccess().getGREATER_EQUALEnumLiteralDeclaration_3()); 
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
    // $ANTLR end "rule__CompareOperator__Alternatives"


    // $ANTLR start "rule__ShiftOperator__Alternatives"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1750:1: rule__ShiftOperator__Alternatives : ( ( ( '<<' ) ) | ( ( '>>' ) ) );
    public final void rule__ShiftOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1754:1: ( ( ( '<<' ) ) | ( ( '>>' ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==42) ) {
                alt21=1;
            }
            else if ( (LA21_0==43) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1755:1: ( ( '<<' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1755:1: ( ( '<<' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1756:1: ( '<<' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getShiftOperatorAccess().getLEFTEnumLiteralDeclaration_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1757:1: ( '<<' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1757:3: '<<'
                    {
                    match(input,42,FOLLOW_42_in_rule__ShiftOperator__Alternatives3757); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getShiftOperatorAccess().getLEFTEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1762:6: ( ( '>>' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1762:6: ( ( '>>' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1763:1: ( '>>' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getShiftOperatorAccess().getRIGHTEnumLiteralDeclaration_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1764:1: ( '>>' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1764:3: '>>'
                    {
                    match(input,43,FOLLOW_43_in_rule__ShiftOperator__Alternatives3778); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1774:1: rule__AdditiveOperator__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AdditiveOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1778:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==19) ) {
                alt22=1;
            }
            else if ( (LA22_0==20) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1779:1: ( ( '+' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1779:1: ( ( '+' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1780:1: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAdditiveOperatorAccess().getADDEnumLiteralDeclaration_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1781:1: ( '+' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1781:3: '+'
                    {
                    match(input,19,FOLLOW_19_in_rule__AdditiveOperator__Alternatives3814); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAdditiveOperatorAccess().getADDEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1786:6: ( ( '-' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1786:6: ( ( '-' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1787:1: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAdditiveOperatorAccess().getSUBTRACTEnumLiteralDeclaration_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1788:1: ( '-' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1788:3: '-'
                    {
                    match(input,20,FOLLOW_20_in_rule__AdditiveOperator__Alternatives3835); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1798:1: rule__MultiplicativeOperator__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultiplicativeOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1802:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt23=1;
                }
                break;
            case 45:
                {
                alt23=2;
                }
                break;
            case 46:
                {
                alt23=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1803:1: ( ( '*' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1803:1: ( ( '*' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1804:1: ( '*' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicativeOperatorAccess().getMULTIPLYEnumLiteralDeclaration_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1805:1: ( '*' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1805:3: '*'
                    {
                    match(input,44,FOLLOW_44_in_rule__MultiplicativeOperator__Alternatives3871); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicativeOperatorAccess().getMULTIPLYEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1810:6: ( ( '/' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1810:6: ( ( '/' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1811:1: ( '/' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicativeOperatorAccess().getDIVIDEEnumLiteralDeclaration_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1812:1: ( '/' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1812:3: '/'
                    {
                    match(input,45,FOLLOW_45_in_rule__MultiplicativeOperator__Alternatives3892); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicativeOperatorAccess().getDIVIDEEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1817:6: ( ( '%' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1817:6: ( ( '%' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1818:1: ( '%' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicativeOperatorAccess().getMODULUSEnumLiteralDeclaration_2()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1819:1: ( '%' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1819:3: '%'
                    {
                    match(input,46,FOLLOW_46_in_rule__MultiplicativeOperator__Alternatives3913); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1829:1: rule__UnaryOperator__Alternatives : ( ( ( '-' ) ) | ( ( '+' ) ) | ( ( '!' ) ) | ( ( '~' ) ) );
    public final void rule__UnaryOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1833:1: ( ( ( '-' ) ) | ( ( '+' ) ) | ( ( '!' ) ) | ( ( '~' ) ) )
            int alt24=4;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt24=1;
                }
                break;
            case 19:
                {
                alt24=2;
                }
                break;
            case 47:
                {
                alt24=3;
                }
                break;
            case 48:
                {
                alt24=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1834:1: ( ( '-' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1834:1: ( ( '-' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1835:1: ( '-' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperatorAccess().getMINUSEnumLiteralDeclaration_0()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1836:1: ( '-' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1836:3: '-'
                    {
                    match(input,20,FOLLOW_20_in_rule__UnaryOperator__Alternatives3949); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUnaryOperatorAccess().getMINUSEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1841:6: ( ( '+' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1841:6: ( ( '+' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1842:1: ( '+' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperatorAccess().getPLUSEnumLiteralDeclaration_1()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1843:1: ( '+' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1843:3: '+'
                    {
                    match(input,19,FOLLOW_19_in_rule__UnaryOperator__Alternatives3970); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUnaryOperatorAccess().getPLUSEnumLiteralDeclaration_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1848:6: ( ( '!' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1848:6: ( ( '!' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1849:1: ( '!' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperatorAccess().getLOGICAL_NOTEnumLiteralDeclaration_2()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1850:1: ( '!' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1850:3: '!'
                    {
                    match(input,47,FOLLOW_47_in_rule__UnaryOperator__Alternatives3991); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getUnaryOperatorAccess().getLOGICAL_NOTEnumLiteralDeclaration_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1855:6: ( ( '~' ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1855:6: ( ( '~' ) )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1856:1: ( '~' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getUnaryOperatorAccess().getBITWISE_NOTEnumLiteralDeclaration_3()); 
                    }
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1857:1: ( '~' )
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1857:3: '~'
                    {
                    match(input,48,FOLLOW_48_in_rule__UnaryOperator__Alternatives4012); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1870:1: rule__Program__Group__0 : rule__Program__Group__0__Impl rule__Program__Group__1 ;
    public final void rule__Program__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1874:1: ( rule__Program__Group__0__Impl rule__Program__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1875:2: rule__Program__Group__0__Impl rule__Program__Group__1
            {
            pushFollow(FOLLOW_rule__Program__Group__0__Impl_in_rule__Program__Group__04046);
            rule__Program__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Program__Group__1_in_rule__Program__Group__04049);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1882:1: rule__Program__Group__0__Impl : ( () ) ;
    public final void rule__Program__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1886:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1887:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1887:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1888:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getProgramAction_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1889:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1891:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1901:1: rule__Program__Group__1 : rule__Program__Group__1__Impl ;
    public final void rule__Program__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1905:1: ( rule__Program__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1906:2: rule__Program__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Program__Group__1__Impl_in_rule__Program__Group__14107);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1912:1: rule__Program__Group__1__Impl : ( ( rule__Program__ProgramElementsAssignment_1 )* ) ;
    public final void rule__Program__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1916:1: ( ( ( rule__Program__ProgramElementsAssignment_1 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1917:1: ( ( rule__Program__ProgramElementsAssignment_1 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1917:1: ( ( rule__Program__ProgramElementsAssignment_1 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1918:1: ( rule__Program__ProgramElementsAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getProgramElementsAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1919:1: ( rule__Program__ProgramElementsAssignment_1 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=12 && LA25_0<=13)||(LA25_0>=15 && LA25_0<=18)||(LA25_0>=21 && LA25_0<=28)||LA25_0==55) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1919:2: rule__Program__ProgramElementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Program__ProgramElementsAssignment_1_in_rule__Program__Group__1__Impl4134);
            	    rule__Program__ProgramElementsAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1933:1: rule__DmplSubclause__Group__0 : rule__DmplSubclause__Group__0__Impl rule__DmplSubclause__Group__1 ;
    public final void rule__DmplSubclause__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1937:1: ( rule__DmplSubclause__Group__0__Impl rule__DmplSubclause__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1938:2: rule__DmplSubclause__Group__0__Impl rule__DmplSubclause__Group__1
            {
            pushFollow(FOLLOW_rule__DmplSubclause__Group__0__Impl_in_rule__DmplSubclause__Group__04169);
            rule__DmplSubclause__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DmplSubclause__Group__1_in_rule__DmplSubclause__Group__04172);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1945:1: rule__DmplSubclause__Group__0__Impl : ( () ) ;
    public final void rule__DmplSubclause__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1949:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1950:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1950:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1951:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDmplSubclauseAccess().getDmplSubclauseAction_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1952:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1954:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1964:1: rule__DmplSubclause__Group__1 : rule__DmplSubclause__Group__1__Impl ;
    public final void rule__DmplSubclause__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1968:1: ( rule__DmplSubclause__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1969:2: rule__DmplSubclause__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DmplSubclause__Group__1__Impl_in_rule__DmplSubclause__Group__14230);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1975:1: rule__DmplSubclause__Group__1__Impl : ( ( rule__DmplSubclause__ProgramAssignment_1 ) ) ;
    public final void rule__DmplSubclause__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1979:1: ( ( ( rule__DmplSubclause__ProgramAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1980:1: ( ( rule__DmplSubclause__ProgramAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1980:1: ( ( rule__DmplSubclause__ProgramAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1981:1: ( rule__DmplSubclause__ProgramAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDmplSubclauseAccess().getProgramAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1982:1: ( rule__DmplSubclause__ProgramAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1982:2: rule__DmplSubclause__ProgramAssignment_1
            {
            pushFollow(FOLLOW_rule__DmplSubclause__ProgramAssignment_1_in_rule__DmplSubclause__Group__1__Impl4257);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:1996:1: rule__Constant__Group__0 : rule__Constant__Group__0__Impl rule__Constant__Group__1 ;
    public final void rule__Constant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2000:1: ( rule__Constant__Group__0__Impl rule__Constant__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2001:2: rule__Constant__Group__0__Impl rule__Constant__Group__1
            {
            pushFollow(FOLLOW_rule__Constant__Group__0__Impl_in_rule__Constant__Group__04291);
            rule__Constant__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Constant__Group__1_in_rule__Constant__Group__04294);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2008:1: rule__Constant__Group__0__Impl : ( ( rule__Constant__Alternatives_0 ) ) ;
    public final void rule__Constant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2012:1: ( ( ( rule__Constant__Alternatives_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2013:1: ( ( rule__Constant__Alternatives_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2013:1: ( ( rule__Constant__Alternatives_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2014:1: ( rule__Constant__Alternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getAlternatives_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2015:1: ( rule__Constant__Alternatives_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2015:2: rule__Constant__Alternatives_0
            {
            pushFollow(FOLLOW_rule__Constant__Alternatives_0_in_rule__Constant__Group__0__Impl4321);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2025:1: rule__Constant__Group__1 : rule__Constant__Group__1__Impl rule__Constant__Group__2 ;
    public final void rule__Constant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2029:1: ( rule__Constant__Group__1__Impl rule__Constant__Group__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2030:2: rule__Constant__Group__1__Impl rule__Constant__Group__2
            {
            pushFollow(FOLLOW_rule__Constant__Group__1__Impl_in_rule__Constant__Group__14351);
            rule__Constant__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Constant__Group__2_in_rule__Constant__Group__14354);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2037:1: rule__Constant__Group__1__Impl : ( ( rule__Constant__NameAssignment_1 ) ) ;
    public final void rule__Constant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2041:1: ( ( ( rule__Constant__NameAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2042:1: ( ( rule__Constant__NameAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2042:1: ( ( rule__Constant__NameAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2043:1: ( rule__Constant__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getNameAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2044:1: ( rule__Constant__NameAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2044:2: rule__Constant__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Constant__NameAssignment_1_in_rule__Constant__Group__1__Impl4381);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2054:1: rule__Constant__Group__2 : rule__Constant__Group__2__Impl rule__Constant__Group__3 ;
    public final void rule__Constant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2058:1: ( rule__Constant__Group__2__Impl rule__Constant__Group__3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2059:2: rule__Constant__Group__2__Impl rule__Constant__Group__3
            {
            pushFollow(FOLLOW_rule__Constant__Group__2__Impl_in_rule__Constant__Group__24411);
            rule__Constant__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Constant__Group__3_in_rule__Constant__Group__24414);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2066:1: rule__Constant__Group__2__Impl : ( '=' ) ;
    public final void rule__Constant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2070:1: ( ( '=' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2071:1: ( '=' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2071:1: ( '=' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2072:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getEqualsSignKeyword_2()); 
            }
            match(input,49,FOLLOW_49_in_rule__Constant__Group__2__Impl4442); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2085:1: rule__Constant__Group__3 : rule__Constant__Group__3__Impl rule__Constant__Group__4 ;
    public final void rule__Constant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2089:1: ( rule__Constant__Group__3__Impl rule__Constant__Group__4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2090:2: rule__Constant__Group__3__Impl rule__Constant__Group__4
            {
            pushFollow(FOLLOW_rule__Constant__Group__3__Impl_in_rule__Constant__Group__34473);
            rule__Constant__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Constant__Group__4_in_rule__Constant__Group__34476);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2097:1: rule__Constant__Group__3__Impl : ( ( rule__Constant__ValueAssignment_3 ) ) ;
    public final void rule__Constant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2101:1: ( ( ( rule__Constant__ValueAssignment_3 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2102:1: ( ( rule__Constant__ValueAssignment_3 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2102:1: ( ( rule__Constant__ValueAssignment_3 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2103:1: ( rule__Constant__ValueAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getValueAssignment_3()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2104:1: ( rule__Constant__ValueAssignment_3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2104:2: rule__Constant__ValueAssignment_3
            {
            pushFollow(FOLLOW_rule__Constant__ValueAssignment_3_in_rule__Constant__Group__3__Impl4503);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2114:1: rule__Constant__Group__4 : rule__Constant__Group__4__Impl ;
    public final void rule__Constant__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2118:1: ( rule__Constant__Group__4__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2119:2: rule__Constant__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Constant__Group__4__Impl_in_rule__Constant__Group__44533);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2125:1: rule__Constant__Group__4__Impl : ( ';' ) ;
    public final void rule__Constant__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2129:1: ( ( ';' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2130:1: ( ';' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2130:1: ( ';' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2131:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getSemicolonKeyword_4()); 
            }
            match(input,14,FOLLOW_14_in_rule__Constant__Group__4__Impl4561); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2154:1: rule__IntConst__Group__0 : rule__IntConst__Group__0__Impl rule__IntConst__Group__1 ;
    public final void rule__IntConst__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2158:1: ( rule__IntConst__Group__0__Impl rule__IntConst__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2159:2: rule__IntConst__Group__0__Impl rule__IntConst__Group__1
            {
            pushFollow(FOLLOW_rule__IntConst__Group__0__Impl_in_rule__IntConst__Group__04602);
            rule__IntConst__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__IntConst__Group__1_in_rule__IntConst__Group__04605);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2166:1: rule__IntConst__Group__0__Impl : ( ( rule__IntConst__SignAssignment_0 )? ) ;
    public final void rule__IntConst__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2170:1: ( ( ( rule__IntConst__SignAssignment_0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2171:1: ( ( rule__IntConst__SignAssignment_0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2171:1: ( ( rule__IntConst__SignAssignment_0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2172:1: ( rule__IntConst__SignAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntConstAccess().getSignAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2173:1: ( rule__IntConst__SignAssignment_0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=19 && LA26_0<=20)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2173:2: rule__IntConst__SignAssignment_0
                    {
                    pushFollow(FOLLOW_rule__IntConst__SignAssignment_0_in_rule__IntConst__Group__0__Impl4632);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2183:1: rule__IntConst__Group__1 : rule__IntConst__Group__1__Impl ;
    public final void rule__IntConst__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2187:1: ( rule__IntConst__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2188:2: rule__IntConst__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IntConst__Group__1__Impl_in_rule__IntConst__Group__14663);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2194:1: rule__IntConst__Group__1__Impl : ( ( rule__IntConst__ValueAssignment_1 ) ) ;
    public final void rule__IntConst__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2198:1: ( ( ( rule__IntConst__ValueAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2199:1: ( ( rule__IntConst__ValueAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2199:1: ( ( rule__IntConst__ValueAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2200:1: ( rule__IntConst__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntConstAccess().getValueAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2201:1: ( rule__IntConst__ValueAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2201:2: rule__IntConst__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__IntConst__ValueAssignment_1_in_rule__IntConst__Group__1__Impl4690);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2215:1: rule__DoubleConst__Group__0 : rule__DoubleConst__Group__0__Impl rule__DoubleConst__Group__1 ;
    public final void rule__DoubleConst__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2219:1: ( rule__DoubleConst__Group__0__Impl rule__DoubleConst__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2220:2: rule__DoubleConst__Group__0__Impl rule__DoubleConst__Group__1
            {
            pushFollow(FOLLOW_rule__DoubleConst__Group__0__Impl_in_rule__DoubleConst__Group__04724);
            rule__DoubleConst__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__DoubleConst__Group__1_in_rule__DoubleConst__Group__04727);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2227:1: rule__DoubleConst__Group__0__Impl : ( ( rule__DoubleConst__SignAssignment_0 )? ) ;
    public final void rule__DoubleConst__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2231:1: ( ( ( rule__DoubleConst__SignAssignment_0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2232:1: ( ( rule__DoubleConst__SignAssignment_0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2232:1: ( ( rule__DoubleConst__SignAssignment_0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2233:1: ( rule__DoubleConst__SignAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleConstAccess().getSignAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2234:1: ( rule__DoubleConst__SignAssignment_0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=19 && LA27_0<=20)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2234:2: rule__DoubleConst__SignAssignment_0
                    {
                    pushFollow(FOLLOW_rule__DoubleConst__SignAssignment_0_in_rule__DoubleConst__Group__0__Impl4754);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2244:1: rule__DoubleConst__Group__1 : rule__DoubleConst__Group__1__Impl ;
    public final void rule__DoubleConst__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2248:1: ( rule__DoubleConst__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2249:2: rule__DoubleConst__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DoubleConst__Group__1__Impl_in_rule__DoubleConst__Group__14785);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2255:1: rule__DoubleConst__Group__1__Impl : ( ( rule__DoubleConst__ValueAssignment_1 ) ) ;
    public final void rule__DoubleConst__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2259:1: ( ( ( rule__DoubleConst__ValueAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2260:1: ( ( rule__DoubleConst__ValueAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2260:1: ( ( rule__DoubleConst__ValueAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2261:1: ( rule__DoubleConst__ValueAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleConstAccess().getValueAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2262:1: ( rule__DoubleConst__ValueAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2262:2: rule__DoubleConst__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__DoubleConst__ValueAssignment_1_in_rule__DoubleConst__Group__1__Impl4812);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2276:1: rule__VarInit__Group__0 : rule__VarInit__Group__0__Impl rule__VarInit__Group__1 ;
    public final void rule__VarInit__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2280:1: ( rule__VarInit__Group__0__Impl rule__VarInit__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2281:2: rule__VarInit__Group__0__Impl rule__VarInit__Group__1
            {
            pushFollow(FOLLOW_rule__VarInit__Group__0__Impl_in_rule__VarInit__Group__04846);
            rule__VarInit__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__VarInit__Group__1_in_rule__VarInit__Group__04849);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2288:1: rule__VarInit__Group__0__Impl : ( ( rule__VarInit__TypeAssignment_0 ) ) ;
    public final void rule__VarInit__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2292:1: ( ( ( rule__VarInit__TypeAssignment_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2293:1: ( ( rule__VarInit__TypeAssignment_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2293:1: ( ( rule__VarInit__TypeAssignment_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2294:1: ( rule__VarInit__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitAccess().getTypeAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2295:1: ( rule__VarInit__TypeAssignment_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2295:2: rule__VarInit__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__VarInit__TypeAssignment_0_in_rule__VarInit__Group__0__Impl4876);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2305:1: rule__VarInit__Group__1 : rule__VarInit__Group__1__Impl ;
    public final void rule__VarInit__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2309:1: ( rule__VarInit__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2310:2: rule__VarInit__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__VarInit__Group__1__Impl_in_rule__VarInit__Group__14906);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2316:1: rule__VarInit__Group__1__Impl : ( ( rule__VarInit__VarAsgnListAssignment_1 ) ) ;
    public final void rule__VarInit__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2320:1: ( ( ( rule__VarInit__VarAsgnListAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2321:1: ( ( rule__VarInit__VarAsgnListAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2321:1: ( ( rule__VarInit__VarAsgnListAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2322:1: ( rule__VarInit__VarAsgnListAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitAccess().getVarAsgnListAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2323:1: ( rule__VarInit__VarAsgnListAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2323:2: rule__VarInit__VarAsgnListAssignment_1
            {
            pushFollow(FOLLOW_rule__VarInit__VarAsgnListAssignment_1_in_rule__VarInit__Group__1__Impl4933);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2337:1: rule__VarAsgn__Group__0 : rule__VarAsgn__Group__0__Impl rule__VarAsgn__Group__1 ;
    public final void rule__VarAsgn__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2341:1: ( rule__VarAsgn__Group__0__Impl rule__VarAsgn__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2342:2: rule__VarAsgn__Group__0__Impl rule__VarAsgn__Group__1
            {
            pushFollow(FOLLOW_rule__VarAsgn__Group__0__Impl_in_rule__VarAsgn__Group__04967);
            rule__VarAsgn__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__VarAsgn__Group__1_in_rule__VarAsgn__Group__04970);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2349:1: rule__VarAsgn__Group__0__Impl : ( ( rule__VarAsgn__VarAssignment_0 ) ) ;
    public final void rule__VarAsgn__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2353:1: ( ( ( rule__VarAsgn__VarAssignment_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2354:1: ( ( rule__VarAsgn__VarAssignment_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2354:1: ( ( rule__VarAsgn__VarAssignment_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2355:1: ( rule__VarAsgn__VarAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnAccess().getVarAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2356:1: ( rule__VarAsgn__VarAssignment_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2356:2: rule__VarAsgn__VarAssignment_0
            {
            pushFollow(FOLLOW_rule__VarAsgn__VarAssignment_0_in_rule__VarAsgn__Group__0__Impl4997);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2366:1: rule__VarAsgn__Group__1 : rule__VarAsgn__Group__1__Impl rule__VarAsgn__Group__2 ;
    public final void rule__VarAsgn__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2370:1: ( rule__VarAsgn__Group__1__Impl rule__VarAsgn__Group__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2371:2: rule__VarAsgn__Group__1__Impl rule__VarAsgn__Group__2
            {
            pushFollow(FOLLOW_rule__VarAsgn__Group__1__Impl_in_rule__VarAsgn__Group__15027);
            rule__VarAsgn__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__VarAsgn__Group__2_in_rule__VarAsgn__Group__15030);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2378:1: rule__VarAsgn__Group__1__Impl : ( '=' ) ;
    public final void rule__VarAsgn__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2382:1: ( ( '=' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2383:1: ( '=' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2383:1: ( '=' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2384:1: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnAccess().getEqualsSignKeyword_1()); 
            }
            match(input,49,FOLLOW_49_in_rule__VarAsgn__Group__1__Impl5058); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2397:1: rule__VarAsgn__Group__2 : rule__VarAsgn__Group__2__Impl ;
    public final void rule__VarAsgn__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2401:1: ( rule__VarAsgn__Group__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2402:2: rule__VarAsgn__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__VarAsgn__Group__2__Impl_in_rule__VarAsgn__Group__25089);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2408:1: rule__VarAsgn__Group__2__Impl : ( ( rule__VarAsgn__Alternatives_2 ) ) ;
    public final void rule__VarAsgn__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2412:1: ( ( ( rule__VarAsgn__Alternatives_2 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2413:1: ( ( rule__VarAsgn__Alternatives_2 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2413:1: ( ( rule__VarAsgn__Alternatives_2 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2414:1: ( rule__VarAsgn__Alternatives_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnAccess().getAlternatives_2()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2415:1: ( rule__VarAsgn__Alternatives_2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2415:2: rule__VarAsgn__Alternatives_2
            {
            pushFollow(FOLLOW_rule__VarAsgn__Alternatives_2_in_rule__VarAsgn__Group__2__Impl5116);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2431:1: rule__Var__Group__0 : rule__Var__Group__0__Impl rule__Var__Group__1 ;
    public final void rule__Var__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2435:1: ( rule__Var__Group__0__Impl rule__Var__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2436:2: rule__Var__Group__0__Impl rule__Var__Group__1
            {
            pushFollow(FOLLOW_rule__Var__Group__0__Impl_in_rule__Var__Group__05152);
            rule__Var__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Var__Group__1_in_rule__Var__Group__05155);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2443:1: rule__Var__Group__0__Impl : ( ( rule__Var__NameAssignment_0 ) ) ;
    public final void rule__Var__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2447:1: ( ( ( rule__Var__NameAssignment_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2448:1: ( ( rule__Var__NameAssignment_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2448:1: ( ( rule__Var__NameAssignment_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2449:1: ( rule__Var__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAccess().getNameAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2450:1: ( rule__Var__NameAssignment_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2450:2: rule__Var__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Var__NameAssignment_0_in_rule__Var__Group__0__Impl5182);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2460:1: rule__Var__Group__1 : rule__Var__Group__1__Impl ;
    public final void rule__Var__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2464:1: ( rule__Var__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2465:2: rule__Var__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Var__Group__1__Impl_in_rule__Var__Group__15212);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2471:1: rule__Var__Group__1__Impl : ( ( rule__Var__Group_1__0 )* ) ;
    public final void rule__Var__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2475:1: ( ( ( rule__Var__Group_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2476:1: ( ( rule__Var__Group_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2476:1: ( ( rule__Var__Group_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2477:1: ( rule__Var__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAccess().getGroup_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2478:1: ( rule__Var__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==50) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2478:2: rule__Var__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Var__Group_1__0_in_rule__Var__Group__1__Impl5239);
            	    rule__Var__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2492:1: rule__Var__Group_1__0 : rule__Var__Group_1__0__Impl rule__Var__Group_1__1 ;
    public final void rule__Var__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2496:1: ( rule__Var__Group_1__0__Impl rule__Var__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2497:2: rule__Var__Group_1__0__Impl rule__Var__Group_1__1
            {
            pushFollow(FOLLOW_rule__Var__Group_1__0__Impl_in_rule__Var__Group_1__05274);
            rule__Var__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Var__Group_1__1_in_rule__Var__Group_1__05277);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2504:1: rule__Var__Group_1__0__Impl : ( '[' ) ;
    public final void rule__Var__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2508:1: ( ( '[' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2509:1: ( '[' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2509:1: ( '[' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2510:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAccess().getLeftSquareBracketKeyword_1_0()); 
            }
            match(input,50,FOLLOW_50_in_rule__Var__Group_1__0__Impl5305); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2523:1: rule__Var__Group_1__1 : rule__Var__Group_1__1__Impl rule__Var__Group_1__2 ;
    public final void rule__Var__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2527:1: ( rule__Var__Group_1__1__Impl rule__Var__Group_1__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2528:2: rule__Var__Group_1__1__Impl rule__Var__Group_1__2
            {
            pushFollow(FOLLOW_rule__Var__Group_1__1__Impl_in_rule__Var__Group_1__15336);
            rule__Var__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Var__Group_1__2_in_rule__Var__Group_1__15339);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2535:1: rule__Var__Group_1__1__Impl : ( ( rule__Var__DimensionsAssignment_1_1 ) ) ;
    public final void rule__Var__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2539:1: ( ( ( rule__Var__DimensionsAssignment_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2540:1: ( ( rule__Var__DimensionsAssignment_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2540:1: ( ( rule__Var__DimensionsAssignment_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2541:1: ( rule__Var__DimensionsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAccess().getDimensionsAssignment_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2542:1: ( rule__Var__DimensionsAssignment_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2542:2: rule__Var__DimensionsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Var__DimensionsAssignment_1_1_in_rule__Var__Group_1__1__Impl5366);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2552:1: rule__Var__Group_1__2 : rule__Var__Group_1__2__Impl ;
    public final void rule__Var__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2556:1: ( rule__Var__Group_1__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2557:2: rule__Var__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Var__Group_1__2__Impl_in_rule__Var__Group_1__25396);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2563:1: rule__Var__Group_1__2__Impl : ( ']' ) ;
    public final void rule__Var__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2567:1: ( ( ']' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2568:1: ( ']' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2568:1: ( ']' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2569:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAccess().getRightSquareBracketKeyword_1_2()); 
            }
            match(input,51,FOLLOW_51_in_rule__Var__Group_1__2__Impl5424); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2588:1: rule__Dimension__Group_0__0 : rule__Dimension__Group_0__0__Impl rule__Dimension__Group_0__1 ;
    public final void rule__Dimension__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2592:1: ( rule__Dimension__Group_0__0__Impl rule__Dimension__Group_0__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2593:2: rule__Dimension__Group_0__0__Impl rule__Dimension__Group_0__1
            {
            pushFollow(FOLLOW_rule__Dimension__Group_0__0__Impl_in_rule__Dimension__Group_0__05461);
            rule__Dimension__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Dimension__Group_0__1_in_rule__Dimension__Group_0__05464);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2600:1: rule__Dimension__Group_0__0__Impl : ( () ) ;
    public final void rule__Dimension__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2604:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2605:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2605:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2606:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getIntDimensionAction_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2607:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2609:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2619:1: rule__Dimension__Group_0__1 : rule__Dimension__Group_0__1__Impl ;
    public final void rule__Dimension__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2623:1: ( rule__Dimension__Group_0__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2624:2: rule__Dimension__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Dimension__Group_0__1__Impl_in_rule__Dimension__Group_0__15522);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2630:1: rule__Dimension__Group_0__1__Impl : ( ( rule__Dimension__IndexAssignment_0_1 ) ) ;
    public final void rule__Dimension__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2634:1: ( ( ( rule__Dimension__IndexAssignment_0_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2635:1: ( ( rule__Dimension__IndexAssignment_0_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2635:1: ( ( rule__Dimension__IndexAssignment_0_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2636:1: ( rule__Dimension__IndexAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getIndexAssignment_0_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2637:1: ( rule__Dimension__IndexAssignment_0_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2637:2: rule__Dimension__IndexAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Dimension__IndexAssignment_0_1_in_rule__Dimension__Group_0__1__Impl5549);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2651:1: rule__Dimension__Group_1__0 : rule__Dimension__Group_1__0__Impl rule__Dimension__Group_1__1 ;
    public final void rule__Dimension__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2655:1: ( rule__Dimension__Group_1__0__Impl rule__Dimension__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2656:2: rule__Dimension__Group_1__0__Impl rule__Dimension__Group_1__1
            {
            pushFollow(FOLLOW_rule__Dimension__Group_1__0__Impl_in_rule__Dimension__Group_1__05583);
            rule__Dimension__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Dimension__Group_1__1_in_rule__Dimension__Group_1__05586);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2663:1: rule__Dimension__Group_1__0__Impl : ( () ) ;
    public final void rule__Dimension__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2667:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2668:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2668:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2669:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getNodeNumDimensionAction_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2670:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2672:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2682:1: rule__Dimension__Group_1__1 : rule__Dimension__Group_1__1__Impl ;
    public final void rule__Dimension__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2686:1: ( rule__Dimension__Group_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2687:2: rule__Dimension__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Dimension__Group_1__1__Impl_in_rule__Dimension__Group_1__15644);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2693:1: rule__Dimension__Group_1__1__Impl : ( '#N' ) ;
    public final void rule__Dimension__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2697:1: ( ( '#N' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2698:1: ( '#N' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2698:1: ( '#N' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2699:1: '#N'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getNKeyword_1_1()); 
            }
            match(input,52,FOLLOW_52_in_rule__Dimension__Group_1__1__Impl5672); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2716:1: rule__Dimension__Group_2__0 : rule__Dimension__Group_2__0__Impl rule__Dimension__Group_2__1 ;
    public final void rule__Dimension__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2720:1: ( rule__Dimension__Group_2__0__Impl rule__Dimension__Group_2__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2721:2: rule__Dimension__Group_2__0__Impl rule__Dimension__Group_2__1
            {
            pushFollow(FOLLOW_rule__Dimension__Group_2__0__Impl_in_rule__Dimension__Group_2__05707);
            rule__Dimension__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Dimension__Group_2__1_in_rule__Dimension__Group_2__05710);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2728:1: rule__Dimension__Group_2__0__Impl : ( () ) ;
    public final void rule__Dimension__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2732:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2733:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2733:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2734:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getIdDimensionAction_2_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2735:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2737:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2747:1: rule__Dimension__Group_2__1 : rule__Dimension__Group_2__1__Impl ;
    public final void rule__Dimension__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2751:1: ( rule__Dimension__Group_2__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2752:2: rule__Dimension__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Dimension__Group_2__1__Impl_in_rule__Dimension__Group_2__15768);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2758:1: rule__Dimension__Group_2__1__Impl : ( ( rule__Dimension__IndexAssignment_2_1 ) ) ;
    public final void rule__Dimension__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2762:1: ( ( ( rule__Dimension__IndexAssignment_2_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2763:1: ( ( rule__Dimension__IndexAssignment_2_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2763:1: ( ( rule__Dimension__IndexAssignment_2_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2764:1: ( rule__Dimension__IndexAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getIndexAssignment_2_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2765:1: ( rule__Dimension__IndexAssignment_2_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2765:2: rule__Dimension__IndexAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Dimension__IndexAssignment_2_1_in_rule__Dimension__Group_2__1__Impl5795);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2779:1: rule__Type__Group__0 : rule__Type__Group__0__Impl rule__Type__Group__1 ;
    public final void rule__Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2783:1: ( rule__Type__Group__0__Impl rule__Type__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2784:2: rule__Type__Group__0__Impl rule__Type__Group__1
            {
            pushFollow(FOLLOW_rule__Type__Group__0__Impl_in_rule__Type__Group__05829);
            rule__Type__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Type__Group__1_in_rule__Type__Group__05832);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2791:1: rule__Type__Group__0__Impl : ( ( rule__Type__SignedAssignment_0 )? ) ;
    public final void rule__Type__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2795:1: ( ( ( rule__Type__SignedAssignment_0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2796:1: ( ( rule__Type__SignedAssignment_0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2796:1: ( ( rule__Type__SignedAssignment_0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2797:1: ( rule__Type__SignedAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getSignedAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2798:1: ( rule__Type__SignedAssignment_0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=27 && LA29_0<=28)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2798:2: rule__Type__SignedAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Type__SignedAssignment_0_in_rule__Type__Group__0__Impl5859);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2808:1: rule__Type__Group__1 : rule__Type__Group__1__Impl ;
    public final void rule__Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2812:1: ( rule__Type__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2813:2: rule__Type__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Type__Group__1__Impl_in_rule__Type__Group__15890);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2819:1: rule__Type__Group__1__Impl : ( ( rule__Type__SimpTypeAssignment_1 ) ) ;
    public final void rule__Type__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2823:1: ( ( ( rule__Type__SimpTypeAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2824:1: ( ( rule__Type__SimpTypeAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2824:1: ( ( rule__Type__SimpTypeAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2825:1: ( rule__Type__SimpTypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getSimpTypeAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2826:1: ( rule__Type__SimpTypeAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2826:2: rule__Type__SimpTypeAssignment_1
            {
            pushFollow(FOLLOW_rule__Type__SimpTypeAssignment_1_in_rule__Type__Group__1__Impl5917);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2840:1: rule__ProcNoAttr__Group__0 : rule__ProcNoAttr__Group__0__Impl rule__ProcNoAttr__Group__1 ;
    public final void rule__ProcNoAttr__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2844:1: ( rule__ProcNoAttr__Group__0__Impl rule__ProcNoAttr__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2845:2: rule__ProcNoAttr__Group__0__Impl rule__ProcNoAttr__Group__1
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__Group__0__Impl_in_rule__ProcNoAttr__Group__05951);
            rule__ProcNoAttr__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ProcNoAttr__Group__1_in_rule__ProcNoAttr__Group__05954);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2852:1: rule__ProcNoAttr__Group__0__Impl : ( ( rule__ProcNoAttr__PrototypeAssignment_0 ) ) ;
    public final void rule__ProcNoAttr__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2856:1: ( ( ( rule__ProcNoAttr__PrototypeAssignment_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2857:1: ( ( rule__ProcNoAttr__PrototypeAssignment_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2857:1: ( ( rule__ProcNoAttr__PrototypeAssignment_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2858:1: ( rule__ProcNoAttr__PrototypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProcNoAttrAccess().getPrototypeAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2859:1: ( rule__ProcNoAttr__PrototypeAssignment_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2859:2: rule__ProcNoAttr__PrototypeAssignment_0
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__PrototypeAssignment_0_in_rule__ProcNoAttr__Group__0__Impl5981);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2869:1: rule__ProcNoAttr__Group__1 : rule__ProcNoAttr__Group__1__Impl ;
    public final void rule__ProcNoAttr__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2873:1: ( rule__ProcNoAttr__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2874:2: rule__ProcNoAttr__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__Group__1__Impl_in_rule__ProcNoAttr__Group__16011);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2880:1: rule__ProcNoAttr__Group__1__Impl : ( ( rule__ProcNoAttr__Alternatives_1 ) ) ;
    public final void rule__ProcNoAttr__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2884:1: ( ( ( rule__ProcNoAttr__Alternatives_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2885:1: ( ( rule__ProcNoAttr__Alternatives_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2885:1: ( ( rule__ProcNoAttr__Alternatives_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2886:1: ( rule__ProcNoAttr__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProcNoAttrAccess().getAlternatives_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2887:1: ( rule__ProcNoAttr__Alternatives_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2887:2: rule__ProcNoAttr__Alternatives_1
            {
            pushFollow(FOLLOW_rule__ProcNoAttr__Alternatives_1_in_rule__ProcNoAttr__Group__1__Impl6038);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2901:1: rule__FnBody__Group__0 : rule__FnBody__Group__0__Impl rule__FnBody__Group__1 ;
    public final void rule__FnBody__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2905:1: ( rule__FnBody__Group__0__Impl rule__FnBody__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2906:2: rule__FnBody__Group__0__Impl rule__FnBody__Group__1
            {
            pushFollow(FOLLOW_rule__FnBody__Group__0__Impl_in_rule__FnBody__Group__06072);
            rule__FnBody__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnBody__Group__1_in_rule__FnBody__Group__06075);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2913:1: rule__FnBody__Group__0__Impl : ( '{' ) ;
    public final void rule__FnBody__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2917:1: ( ( '{' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2918:1: ( '{' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2918:1: ( '{' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2919:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnBodyAccess().getLeftCurlyBracketKeyword_0()); 
            }
            match(input,53,FOLLOW_53_in_rule__FnBody__Group__0__Impl6103); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2932:1: rule__FnBody__Group__1 : rule__FnBody__Group__1__Impl rule__FnBody__Group__2 ;
    public final void rule__FnBody__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2936:1: ( rule__FnBody__Group__1__Impl rule__FnBody__Group__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2937:2: rule__FnBody__Group__1__Impl rule__FnBody__Group__2
            {
            pushFollow(FOLLOW_rule__FnBody__Group__1__Impl_in_rule__FnBody__Group__16134);
            rule__FnBody__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnBody__Group__2_in_rule__FnBody__Group__16137);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2944:1: rule__FnBody__Group__1__Impl : ( ( rule__FnBody__VarInitListAssignment_1 ) ) ;
    public final void rule__FnBody__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2948:1: ( ( ( rule__FnBody__VarInitListAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2949:1: ( ( rule__FnBody__VarInitListAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2949:1: ( ( rule__FnBody__VarInitListAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2950:1: ( rule__FnBody__VarInitListAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnBodyAccess().getVarInitListAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2951:1: ( rule__FnBody__VarInitListAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2951:2: rule__FnBody__VarInitListAssignment_1
            {
            pushFollow(FOLLOW_rule__FnBody__VarInitListAssignment_1_in_rule__FnBody__Group__1__Impl6164);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2961:1: rule__FnBody__Group__2 : rule__FnBody__Group__2__Impl ;
    public final void rule__FnBody__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2965:1: ( rule__FnBody__Group__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2966:2: rule__FnBody__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__FnBody__Group__2__Impl_in_rule__FnBody__Group__26194);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2972:1: rule__FnBody__Group__2__Impl : ( '}' ) ;
    public final void rule__FnBody__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2976:1: ( ( '}' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2977:1: ( '}' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2977:1: ( '}' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2978:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnBodyAccess().getRightCurlyBracketKeyword_2()); 
            }
            match(input,54,FOLLOW_54_in_rule__FnBody__Group__2__Impl6222); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:2997:1: rule__FnPrototype__Group_0__0 : rule__FnPrototype__Group_0__0__Impl rule__FnPrototype__Group_0__1 ;
    public final void rule__FnPrototype__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3001:1: ( rule__FnPrototype__Group_0__0__Impl rule__FnPrototype__Group_0__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3002:2: rule__FnPrototype__Group_0__0__Impl rule__FnPrototype__Group_0__1
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__0__Impl_in_rule__FnPrototype__Group_0__06259);
            rule__FnPrototype__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__1_in_rule__FnPrototype__Group_0__06262);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3009:1: rule__FnPrototype__Group_0__0__Impl : ( () ) ;
    public final void rule__FnPrototype__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3013:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3014:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3014:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3015:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getThreadDeclarationAction_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3016:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3018:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3028:1: rule__FnPrototype__Group_0__1 : rule__FnPrototype__Group_0__1__Impl rule__FnPrototype__Group_0__2 ;
    public final void rule__FnPrototype__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3032:1: ( rule__FnPrototype__Group_0__1__Impl rule__FnPrototype__Group_0__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3033:2: rule__FnPrototype__Group_0__1__Impl rule__FnPrototype__Group_0__2
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__1__Impl_in_rule__FnPrototype__Group_0__16320);
            rule__FnPrototype__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__2_in_rule__FnPrototype__Group_0__16323);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3040:1: rule__FnPrototype__Group_0__1__Impl : ( ( rule__FnPrototype__ExternAssignment_0_1 )? ) ;
    public final void rule__FnPrototype__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3044:1: ( ( ( rule__FnPrototype__ExternAssignment_0_1 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3045:1: ( ( rule__FnPrototype__ExternAssignment_0_1 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3045:1: ( ( rule__FnPrototype__ExternAssignment_0_1 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3046:1: ( rule__FnPrototype__ExternAssignment_0_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getExternAssignment_0_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3047:1: ( rule__FnPrototype__ExternAssignment_0_1 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=15 && LA30_0<=16)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3047:2: rule__FnPrototype__ExternAssignment_0_1
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__ExternAssignment_0_1_in_rule__FnPrototype__Group_0__1__Impl6350);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3057:1: rule__FnPrototype__Group_0__2 : rule__FnPrototype__Group_0__2__Impl rule__FnPrototype__Group_0__3 ;
    public final void rule__FnPrototype__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3061:1: ( rule__FnPrototype__Group_0__2__Impl rule__FnPrototype__Group_0__3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3062:2: rule__FnPrototype__Group_0__2__Impl rule__FnPrototype__Group_0__3
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__2__Impl_in_rule__FnPrototype__Group_0__26381);
            rule__FnPrototype__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__3_in_rule__FnPrototype__Group_0__26384);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3069:1: rule__FnPrototype__Group_0__2__Impl : ( ( rule__FnPrototype__PureAssignment_0_2 )? ) ;
    public final void rule__FnPrototype__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3073:1: ( ( ( rule__FnPrototype__PureAssignment_0_2 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3074:1: ( ( rule__FnPrototype__PureAssignment_0_2 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3074:1: ( ( rule__FnPrototype__PureAssignment_0_2 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3075:1: ( rule__FnPrototype__PureAssignment_0_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getPureAssignment_0_2()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3076:1: ( rule__FnPrototype__PureAssignment_0_2 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=17 && LA31_0<=18)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3076:2: rule__FnPrototype__PureAssignment_0_2
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__PureAssignment_0_2_in_rule__FnPrototype__Group_0__2__Impl6411);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3086:1: rule__FnPrototype__Group_0__3 : rule__FnPrototype__Group_0__3__Impl rule__FnPrototype__Group_0__4 ;
    public final void rule__FnPrototype__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3090:1: ( rule__FnPrototype__Group_0__3__Impl rule__FnPrototype__Group_0__4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3091:2: rule__FnPrototype__Group_0__3__Impl rule__FnPrototype__Group_0__4
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__3__Impl_in_rule__FnPrototype__Group_0__36442);
            rule__FnPrototype__Group_0__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__4_in_rule__FnPrototype__Group_0__36445);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3098:1: rule__FnPrototype__Group_0__3__Impl : ( 'thread' ) ;
    public final void rule__FnPrototype__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3102:1: ( ( 'thread' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3103:1: ( 'thread' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3103:1: ( 'thread' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3104:1: 'thread'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getThreadKeyword_0_3()); 
            }
            match(input,55,FOLLOW_55_in_rule__FnPrototype__Group_0__3__Impl6473); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3117:1: rule__FnPrototype__Group_0__4 : rule__FnPrototype__Group_0__4__Impl ;
    public final void rule__FnPrototype__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3121:1: ( rule__FnPrototype__Group_0__4__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3122:2: rule__FnPrototype__Group_0__4__Impl
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_0__4__Impl_in_rule__FnPrototype__Group_0__46504);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3128:1: rule__FnPrototype__Group_0__4__Impl : ( ( rule__FnPrototype__NameAssignment_0_4 ) ) ;
    public final void rule__FnPrototype__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3132:1: ( ( ( rule__FnPrototype__NameAssignment_0_4 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3133:1: ( ( rule__FnPrototype__NameAssignment_0_4 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3133:1: ( ( rule__FnPrototype__NameAssignment_0_4 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3134:1: ( rule__FnPrototype__NameAssignment_0_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getNameAssignment_0_4()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3135:1: ( rule__FnPrototype__NameAssignment_0_4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3135:2: rule__FnPrototype__NameAssignment_0_4
            {
            pushFollow(FOLLOW_rule__FnPrototype__NameAssignment_0_4_in_rule__FnPrototype__Group_0__4__Impl6531);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3155:1: rule__FnPrototype__Group_1__0 : rule__FnPrototype__Group_1__0__Impl rule__FnPrototype__Group_1__1 ;
    public final void rule__FnPrototype__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3159:1: ( rule__FnPrototype__Group_1__0__Impl rule__FnPrototype__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3160:2: rule__FnPrototype__Group_1__0__Impl rule__FnPrototype__Group_1__1
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__0__Impl_in_rule__FnPrototype__Group_1__06571);
            rule__FnPrototype__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__1_in_rule__FnPrototype__Group_1__06574);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3167:1: rule__FnPrototype__Group_1__0__Impl : ( () ) ;
    public final void rule__FnPrototype__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3171:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3172:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3172:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3173:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getFnPrototypeDeclarationAction_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3174:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3176:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3186:1: rule__FnPrototype__Group_1__1 : rule__FnPrototype__Group_1__1__Impl rule__FnPrototype__Group_1__2 ;
    public final void rule__FnPrototype__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3190:1: ( rule__FnPrototype__Group_1__1__Impl rule__FnPrototype__Group_1__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3191:2: rule__FnPrototype__Group_1__1__Impl rule__FnPrototype__Group_1__2
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__1__Impl_in_rule__FnPrototype__Group_1__16632);
            rule__FnPrototype__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__2_in_rule__FnPrototype__Group_1__16635);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3198:1: rule__FnPrototype__Group_1__1__Impl : ( ( rule__FnPrototype__ExternAssignment_1_1 )? ) ;
    public final void rule__FnPrototype__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3202:1: ( ( ( rule__FnPrototype__ExternAssignment_1_1 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3203:1: ( ( rule__FnPrototype__ExternAssignment_1_1 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3203:1: ( ( rule__FnPrototype__ExternAssignment_1_1 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3204:1: ( rule__FnPrototype__ExternAssignment_1_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getExternAssignment_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3205:1: ( rule__FnPrototype__ExternAssignment_1_1 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=15 && LA32_0<=16)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3205:2: rule__FnPrototype__ExternAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__ExternAssignment_1_1_in_rule__FnPrototype__Group_1__1__Impl6662);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3215:1: rule__FnPrototype__Group_1__2 : rule__FnPrototype__Group_1__2__Impl rule__FnPrototype__Group_1__3 ;
    public final void rule__FnPrototype__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3219:1: ( rule__FnPrototype__Group_1__2__Impl rule__FnPrototype__Group_1__3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3220:2: rule__FnPrototype__Group_1__2__Impl rule__FnPrototype__Group_1__3
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__2__Impl_in_rule__FnPrototype__Group_1__26693);
            rule__FnPrototype__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__3_in_rule__FnPrototype__Group_1__26696);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3227:1: rule__FnPrototype__Group_1__2__Impl : ( ( rule__FnPrototype__PureAssignment_1_2 )? ) ;
    public final void rule__FnPrototype__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3231:1: ( ( ( rule__FnPrototype__PureAssignment_1_2 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3232:1: ( ( rule__FnPrototype__PureAssignment_1_2 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3232:1: ( ( rule__FnPrototype__PureAssignment_1_2 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3233:1: ( rule__FnPrototype__PureAssignment_1_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getPureAssignment_1_2()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3234:1: ( rule__FnPrototype__PureAssignment_1_2 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=17 && LA33_0<=18)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3234:2: rule__FnPrototype__PureAssignment_1_2
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__PureAssignment_1_2_in_rule__FnPrototype__Group_1__2__Impl6723);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3244:1: rule__FnPrototype__Group_1__3 : rule__FnPrototype__Group_1__3__Impl rule__FnPrototype__Group_1__4 ;
    public final void rule__FnPrototype__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3248:1: ( rule__FnPrototype__Group_1__3__Impl rule__FnPrototype__Group_1__4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3249:2: rule__FnPrototype__Group_1__3__Impl rule__FnPrototype__Group_1__4
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__3__Impl_in_rule__FnPrototype__Group_1__36754);
            rule__FnPrototype__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__4_in_rule__FnPrototype__Group_1__36757);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3256:1: rule__FnPrototype__Group_1__3__Impl : ( ( rule__FnPrototype__TypeAssignment_1_3 ) ) ;
    public final void rule__FnPrototype__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3260:1: ( ( ( rule__FnPrototype__TypeAssignment_1_3 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3261:1: ( ( rule__FnPrototype__TypeAssignment_1_3 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3261:1: ( ( rule__FnPrototype__TypeAssignment_1_3 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3262:1: ( rule__FnPrototype__TypeAssignment_1_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getTypeAssignment_1_3()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3263:1: ( rule__FnPrototype__TypeAssignment_1_3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3263:2: rule__FnPrototype__TypeAssignment_1_3
            {
            pushFollow(FOLLOW_rule__FnPrototype__TypeAssignment_1_3_in_rule__FnPrototype__Group_1__3__Impl6784);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3273:1: rule__FnPrototype__Group_1__4 : rule__FnPrototype__Group_1__4__Impl rule__FnPrototype__Group_1__5 ;
    public final void rule__FnPrototype__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3277:1: ( rule__FnPrototype__Group_1__4__Impl rule__FnPrototype__Group_1__5 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3278:2: rule__FnPrototype__Group_1__4__Impl rule__FnPrototype__Group_1__5
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__4__Impl_in_rule__FnPrototype__Group_1__46814);
            rule__FnPrototype__Group_1__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__5_in_rule__FnPrototype__Group_1__46817);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3285:1: rule__FnPrototype__Group_1__4__Impl : ( ( rule__FnPrototype__NameAssignment_1_4 ) ) ;
    public final void rule__FnPrototype__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3289:1: ( ( ( rule__FnPrototype__NameAssignment_1_4 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3290:1: ( ( rule__FnPrototype__NameAssignment_1_4 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3290:1: ( ( rule__FnPrototype__NameAssignment_1_4 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3291:1: ( rule__FnPrototype__NameAssignment_1_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getNameAssignment_1_4()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3292:1: ( rule__FnPrototype__NameAssignment_1_4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3292:2: rule__FnPrototype__NameAssignment_1_4
            {
            pushFollow(FOLLOW_rule__FnPrototype__NameAssignment_1_4_in_rule__FnPrototype__Group_1__4__Impl6844);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3302:1: rule__FnPrototype__Group_1__5 : rule__FnPrototype__Group_1__5__Impl rule__FnPrototype__Group_1__6 ;
    public final void rule__FnPrototype__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3306:1: ( rule__FnPrototype__Group_1__5__Impl rule__FnPrototype__Group_1__6 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3307:2: rule__FnPrototype__Group_1__5__Impl rule__FnPrototype__Group_1__6
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__5__Impl_in_rule__FnPrototype__Group_1__56874);
            rule__FnPrototype__Group_1__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__6_in_rule__FnPrototype__Group_1__56877);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3314:1: rule__FnPrototype__Group_1__5__Impl : ( '(' ) ;
    public final void rule__FnPrototype__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3318:1: ( ( '(' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3319:1: ( '(' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3319:1: ( '(' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3320:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getLeftParenthesisKeyword_1_5()); 
            }
            match(input,56,FOLLOW_56_in_rule__FnPrototype__Group_1__5__Impl6905); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3333:1: rule__FnPrototype__Group_1__6 : rule__FnPrototype__Group_1__6__Impl rule__FnPrototype__Group_1__7 ;
    public final void rule__FnPrototype__Group_1__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3337:1: ( rule__FnPrototype__Group_1__6__Impl rule__FnPrototype__Group_1__7 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3338:2: rule__FnPrototype__Group_1__6__Impl rule__FnPrototype__Group_1__7
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__6__Impl_in_rule__FnPrototype__Group_1__66936);
            rule__FnPrototype__Group_1__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__7_in_rule__FnPrototype__Group_1__66939);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3345:1: rule__FnPrototype__Group_1__6__Impl : ( ( rule__FnPrototype__Group_1_6__0 )? ) ;
    public final void rule__FnPrototype__Group_1__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3349:1: ( ( ( rule__FnPrototype__Group_1_6__0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3350:1: ( ( rule__FnPrototype__Group_1_6__0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3350:1: ( ( rule__FnPrototype__Group_1_6__0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3351:1: ( rule__FnPrototype__Group_1_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getGroup_1_6()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3352:1: ( rule__FnPrototype__Group_1_6__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=21 && LA34_0<=28)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3352:2: rule__FnPrototype__Group_1_6__0
                    {
                    pushFollow(FOLLOW_rule__FnPrototype__Group_1_6__0_in_rule__FnPrototype__Group_1__6__Impl6966);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3362:1: rule__FnPrototype__Group_1__7 : rule__FnPrototype__Group_1__7__Impl ;
    public final void rule__FnPrototype__Group_1__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3366:1: ( rule__FnPrototype__Group_1__7__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3367:2: rule__FnPrototype__Group_1__7__Impl
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1__7__Impl_in_rule__FnPrototype__Group_1__76997);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3373:1: rule__FnPrototype__Group_1__7__Impl : ( ')' ) ;
    public final void rule__FnPrototype__Group_1__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3377:1: ( ( ')' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3378:1: ( ')' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3378:1: ( ')' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3379:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getRightParenthesisKeyword_1_7()); 
            }
            match(input,57,FOLLOW_57_in_rule__FnPrototype__Group_1__7__Impl7025); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3408:1: rule__FnPrototype__Group_1_6__0 : rule__FnPrototype__Group_1_6__0__Impl rule__FnPrototype__Group_1_6__1 ;
    public final void rule__FnPrototype__Group_1_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3412:1: ( rule__FnPrototype__Group_1_6__0__Impl rule__FnPrototype__Group_1_6__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3413:2: rule__FnPrototype__Group_1_6__0__Impl rule__FnPrototype__Group_1_6__1
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1_6__0__Impl_in_rule__FnPrototype__Group_1_6__07072);
            rule__FnPrototype__Group_1_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1_6__1_in_rule__FnPrototype__Group_1_6__07075);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3420:1: rule__FnPrototype__Group_1_6__0__Impl : ( ( rule__FnPrototype__ParamsAssignment_1_6_0 ) ) ;
    public final void rule__FnPrototype__Group_1_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3424:1: ( ( ( rule__FnPrototype__ParamsAssignment_1_6_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3425:1: ( ( rule__FnPrototype__ParamsAssignment_1_6_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3425:1: ( ( rule__FnPrototype__ParamsAssignment_1_6_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3426:1: ( rule__FnPrototype__ParamsAssignment_1_6_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getParamsAssignment_1_6_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3427:1: ( rule__FnPrototype__ParamsAssignment_1_6_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3427:2: rule__FnPrototype__ParamsAssignment_1_6_0
            {
            pushFollow(FOLLOW_rule__FnPrototype__ParamsAssignment_1_6_0_in_rule__FnPrototype__Group_1_6__0__Impl7102);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3437:1: rule__FnPrototype__Group_1_6__1 : rule__FnPrototype__Group_1_6__1__Impl ;
    public final void rule__FnPrototype__Group_1_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3441:1: ( rule__FnPrototype__Group_1_6__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3442:2: rule__FnPrototype__Group_1_6__1__Impl
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1_6__1__Impl_in_rule__FnPrototype__Group_1_6__17132);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3448:1: rule__FnPrototype__Group_1_6__1__Impl : ( ( rule__FnPrototype__Group_1_6_1__0 )* ) ;
    public final void rule__FnPrototype__Group_1_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3452:1: ( ( ( rule__FnPrototype__Group_1_6_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3453:1: ( ( rule__FnPrototype__Group_1_6_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3453:1: ( ( rule__FnPrototype__Group_1_6_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3454:1: ( rule__FnPrototype__Group_1_6_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getGroup_1_6_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3455:1: ( rule__FnPrototype__Group_1_6_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==58) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3455:2: rule__FnPrototype__Group_1_6_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FnPrototype__Group_1_6_1__0_in_rule__FnPrototype__Group_1_6__1__Impl7159);
            	    rule__FnPrototype__Group_1_6_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3469:1: rule__FnPrototype__Group_1_6_1__0 : rule__FnPrototype__Group_1_6_1__0__Impl rule__FnPrototype__Group_1_6_1__1 ;
    public final void rule__FnPrototype__Group_1_6_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3473:1: ( rule__FnPrototype__Group_1_6_1__0__Impl rule__FnPrototype__Group_1_6_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3474:2: rule__FnPrototype__Group_1_6_1__0__Impl rule__FnPrototype__Group_1_6_1__1
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1_6_1__0__Impl_in_rule__FnPrototype__Group_1_6_1__07194);
            rule__FnPrototype__Group_1_6_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__FnPrototype__Group_1_6_1__1_in_rule__FnPrototype__Group_1_6_1__07197);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3481:1: rule__FnPrototype__Group_1_6_1__0__Impl : ( ',' ) ;
    public final void rule__FnPrototype__Group_1_6_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3485:1: ( ( ',' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3486:1: ( ',' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3486:1: ( ',' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3487:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getCommaKeyword_1_6_1_0()); 
            }
            match(input,58,FOLLOW_58_in_rule__FnPrototype__Group_1_6_1__0__Impl7225); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3500:1: rule__FnPrototype__Group_1_6_1__1 : rule__FnPrototype__Group_1_6_1__1__Impl ;
    public final void rule__FnPrototype__Group_1_6_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3504:1: ( rule__FnPrototype__Group_1_6_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3505:2: rule__FnPrototype__Group_1_6_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FnPrototype__Group_1_6_1__1__Impl_in_rule__FnPrototype__Group_1_6_1__17256);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3511:1: rule__FnPrototype__Group_1_6_1__1__Impl : ( ( rule__FnPrototype__ParamsAssignment_1_6_1_1 ) ) ;
    public final void rule__FnPrototype__Group_1_6_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3515:1: ( ( ( rule__FnPrototype__ParamsAssignment_1_6_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3516:1: ( ( rule__FnPrototype__ParamsAssignment_1_6_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3516:1: ( ( rule__FnPrototype__ParamsAssignment_1_6_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3517:1: ( rule__FnPrototype__ParamsAssignment_1_6_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getParamsAssignment_1_6_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3518:1: ( rule__FnPrototype__ParamsAssignment_1_6_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3518:2: rule__FnPrototype__ParamsAssignment_1_6_1_1
            {
            pushFollow(FOLLOW_rule__FnPrototype__ParamsAssignment_1_6_1_1_in_rule__FnPrototype__Group_1_6_1__1__Impl7283);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3532:1: rule__Param__Group__0 : rule__Param__Group__0__Impl rule__Param__Group__1 ;
    public final void rule__Param__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3536:1: ( rule__Param__Group__0__Impl rule__Param__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3537:2: rule__Param__Group__0__Impl rule__Param__Group__1
            {
            pushFollow(FOLLOW_rule__Param__Group__0__Impl_in_rule__Param__Group__07317);
            rule__Param__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Param__Group__1_in_rule__Param__Group__07320);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3544:1: rule__Param__Group__0__Impl : ( ( rule__Param__TypeAssignment_0 ) ) ;
    public final void rule__Param__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3548:1: ( ( ( rule__Param__TypeAssignment_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3549:1: ( ( rule__Param__TypeAssignment_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3549:1: ( ( rule__Param__TypeAssignment_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3550:1: ( rule__Param__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAccess().getTypeAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3551:1: ( rule__Param__TypeAssignment_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3551:2: rule__Param__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__Param__TypeAssignment_0_in_rule__Param__Group__0__Impl7347);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3561:1: rule__Param__Group__1 : rule__Param__Group__1__Impl ;
    public final void rule__Param__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3565:1: ( rule__Param__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3566:2: rule__Param__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Param__Group__1__Impl_in_rule__Param__Group__17377);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3572:1: rule__Param__Group__1__Impl : ( ( rule__Param__VarAssignment_1 ) ) ;
    public final void rule__Param__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3576:1: ( ( ( rule__Param__VarAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3577:1: ( ( rule__Param__VarAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3577:1: ( ( rule__Param__VarAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3578:1: ( rule__Param__VarAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAccess().getVarAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3579:1: ( rule__Param__VarAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3579:2: rule__Param__VarAssignment_1
            {
            pushFollow(FOLLOW_rule__Param__VarAssignment_1_in_rule__Param__Group__1__Impl7404);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3593:1: rule__VarInitList__Group__0 : rule__VarInitList__Group__0__Impl rule__VarInitList__Group__1 ;
    public final void rule__VarInitList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3597:1: ( rule__VarInitList__Group__0__Impl rule__VarInitList__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3598:2: rule__VarInitList__Group__0__Impl rule__VarInitList__Group__1
            {
            pushFollow(FOLLOW_rule__VarInitList__Group__0__Impl_in_rule__VarInitList__Group__07438);
            rule__VarInitList__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__VarInitList__Group__1_in_rule__VarInitList__Group__07441);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3605:1: rule__VarInitList__Group__0__Impl : ( () ) ;
    public final void rule__VarInitList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3609:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3610:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3610:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3611:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitListAccess().getVarInitListAction_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3612:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3614:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3624:1: rule__VarInitList__Group__1 : rule__VarInitList__Group__1__Impl ;
    public final void rule__VarInitList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3628:1: ( rule__VarInitList__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3629:2: rule__VarInitList__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__VarInitList__Group__1__Impl_in_rule__VarInitList__Group__17499);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3635:1: rule__VarInitList__Group__1__Impl : ( ( rule__VarInitList__Group_1__0 )* ) ;
    public final void rule__VarInitList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3639:1: ( ( ( rule__VarInitList__Group_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3640:1: ( ( rule__VarInitList__Group_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3640:1: ( ( rule__VarInitList__Group_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3641:1: ( rule__VarInitList__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitListAccess().getGroup_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3642:1: ( rule__VarInitList__Group_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=21 && LA36_0<=28)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3642:2: rule__VarInitList__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__VarInitList__Group_1__0_in_rule__VarInitList__Group__1__Impl7526);
            	    rule__VarInitList__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop36;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3656:1: rule__VarInitList__Group_1__0 : rule__VarInitList__Group_1__0__Impl rule__VarInitList__Group_1__1 ;
    public final void rule__VarInitList__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3660:1: ( rule__VarInitList__Group_1__0__Impl rule__VarInitList__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3661:2: rule__VarInitList__Group_1__0__Impl rule__VarInitList__Group_1__1
            {
            pushFollow(FOLLOW_rule__VarInitList__Group_1__0__Impl_in_rule__VarInitList__Group_1__07561);
            rule__VarInitList__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__VarInitList__Group_1__1_in_rule__VarInitList__Group_1__07564);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3668:1: rule__VarInitList__Group_1__0__Impl : ( ( rule__VarInitList__VarInitsAssignment_1_0 ) ) ;
    public final void rule__VarInitList__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3672:1: ( ( ( rule__VarInitList__VarInitsAssignment_1_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3673:1: ( ( rule__VarInitList__VarInitsAssignment_1_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3673:1: ( ( rule__VarInitList__VarInitsAssignment_1_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3674:1: ( rule__VarInitList__VarInitsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitListAccess().getVarInitsAssignment_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3675:1: ( rule__VarInitList__VarInitsAssignment_1_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3675:2: rule__VarInitList__VarInitsAssignment_1_0
            {
            pushFollow(FOLLOW_rule__VarInitList__VarInitsAssignment_1_0_in_rule__VarInitList__Group_1__0__Impl7591);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3685:1: rule__VarInitList__Group_1__1 : rule__VarInitList__Group_1__1__Impl ;
    public final void rule__VarInitList__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3689:1: ( rule__VarInitList__Group_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3690:2: rule__VarInitList__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__VarInitList__Group_1__1__Impl_in_rule__VarInitList__Group_1__17621);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3696:1: rule__VarInitList__Group_1__1__Impl : ( ';' ) ;
    public final void rule__VarInitList__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3700:1: ( ( ';' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3701:1: ( ';' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3701:1: ( ';' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3702:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitListAccess().getSemicolonKeyword_1_1()); 
            }
            match(input,14,FOLLOW_14_in_rule__VarInitList__Group_1__1__Impl7649); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3719:1: rule__LVal__Group__0 : rule__LVal__Group__0__Impl rule__LVal__Group__1 ;
    public final void rule__LVal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3723:1: ( rule__LVal__Group__0__Impl rule__LVal__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3724:2: rule__LVal__Group__0__Impl rule__LVal__Group__1
            {
            pushFollow(FOLLOW_rule__LVal__Group__0__Impl_in_rule__LVal__Group__07684);
            rule__LVal__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LVal__Group__1_in_rule__LVal__Group__07687);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3731:1: rule__LVal__Group__0__Impl : ( ( rule__LVal__NameAssignment_0 ) ) ;
    public final void rule__LVal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3735:1: ( ( ( rule__LVal__NameAssignment_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3736:1: ( ( rule__LVal__NameAssignment_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3736:1: ( ( rule__LVal__NameAssignment_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3737:1: ( rule__LVal__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getNameAssignment_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3738:1: ( rule__LVal__NameAssignment_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3738:2: rule__LVal__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__LVal__NameAssignment_0_in_rule__LVal__Group__0__Impl7714);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3748:1: rule__LVal__Group__1 : rule__LVal__Group__1__Impl rule__LVal__Group__2 ;
    public final void rule__LVal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3752:1: ( rule__LVal__Group__1__Impl rule__LVal__Group__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3753:2: rule__LVal__Group__1__Impl rule__LVal__Group__2
            {
            pushFollow(FOLLOW_rule__LVal__Group__1__Impl_in_rule__LVal__Group__17744);
            rule__LVal__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LVal__Group__2_in_rule__LVal__Group__17747);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3760:1: rule__LVal__Group__1__Impl : ( ( rule__LVal__Group_1__0 )* ) ;
    public final void rule__LVal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3764:1: ( ( ( rule__LVal__Group_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3765:1: ( ( rule__LVal__Group_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3765:1: ( ( rule__LVal__Group_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3766:1: ( rule__LVal__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getGroup_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3767:1: ( rule__LVal__Group_1__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==50) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3767:2: rule__LVal__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__LVal__Group_1__0_in_rule__LVal__Group__1__Impl7774);
            	    rule__LVal__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3777:1: rule__LVal__Group__2 : rule__LVal__Group__2__Impl ;
    public final void rule__LVal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3781:1: ( rule__LVal__Group__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3782:2: rule__LVal__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__LVal__Group__2__Impl_in_rule__LVal__Group__27805);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3788:1: rule__LVal__Group__2__Impl : ( ( rule__LVal__Group_2__0 )? ) ;
    public final void rule__LVal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3792:1: ( ( ( rule__LVal__Group_2__0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3793:1: ( ( rule__LVal__Group_2__0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3793:1: ( ( rule__LVal__Group_2__0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3794:1: ( rule__LVal__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getGroup_2()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3795:1: ( rule__LVal__Group_2__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==59) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3795:2: rule__LVal__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__LVal__Group_2__0_in_rule__LVal__Group__2__Impl7832);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3811:1: rule__LVal__Group_1__0 : rule__LVal__Group_1__0__Impl rule__LVal__Group_1__1 ;
    public final void rule__LVal__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3815:1: ( rule__LVal__Group_1__0__Impl rule__LVal__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3816:2: rule__LVal__Group_1__0__Impl rule__LVal__Group_1__1
            {
            pushFollow(FOLLOW_rule__LVal__Group_1__0__Impl_in_rule__LVal__Group_1__07869);
            rule__LVal__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LVal__Group_1__1_in_rule__LVal__Group_1__07872);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3823:1: rule__LVal__Group_1__0__Impl : ( '[' ) ;
    public final void rule__LVal__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3827:1: ( ( '[' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3828:1: ( '[' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3828:1: ( '[' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3829:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getLeftSquareBracketKeyword_1_0()); 
            }
            match(input,50,FOLLOW_50_in_rule__LVal__Group_1__0__Impl7900); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3842:1: rule__LVal__Group_1__1 : rule__LVal__Group_1__1__Impl rule__LVal__Group_1__2 ;
    public final void rule__LVal__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3846:1: ( rule__LVal__Group_1__1__Impl rule__LVal__Group_1__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3847:2: rule__LVal__Group_1__1__Impl rule__LVal__Group_1__2
            {
            pushFollow(FOLLOW_rule__LVal__Group_1__1__Impl_in_rule__LVal__Group_1__17931);
            rule__LVal__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LVal__Group_1__2_in_rule__LVal__Group_1__17934);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3854:1: rule__LVal__Group_1__1__Impl : ( ( rule__LVal__IndicesAssignment_1_1 ) ) ;
    public final void rule__LVal__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3858:1: ( ( ( rule__LVal__IndicesAssignment_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3859:1: ( ( rule__LVal__IndicesAssignment_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3859:1: ( ( rule__LVal__IndicesAssignment_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3860:1: ( rule__LVal__IndicesAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getIndicesAssignment_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3861:1: ( rule__LVal__IndicesAssignment_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3861:2: rule__LVal__IndicesAssignment_1_1
            {
            pushFollow(FOLLOW_rule__LVal__IndicesAssignment_1_1_in_rule__LVal__Group_1__1__Impl7961);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3871:1: rule__LVal__Group_1__2 : rule__LVal__Group_1__2__Impl ;
    public final void rule__LVal__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3875:1: ( rule__LVal__Group_1__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3876:2: rule__LVal__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__LVal__Group_1__2__Impl_in_rule__LVal__Group_1__27991);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3882:1: rule__LVal__Group_1__2__Impl : ( ']' ) ;
    public final void rule__LVal__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3886:1: ( ( ']' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3887:1: ( ']' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3887:1: ( ']' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3888:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getRightSquareBracketKeyword_1_2()); 
            }
            match(input,51,FOLLOW_51_in_rule__LVal__Group_1__2__Impl8019); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3907:1: rule__LVal__Group_2__0 : rule__LVal__Group_2__0__Impl rule__LVal__Group_2__1 ;
    public final void rule__LVal__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3911:1: ( rule__LVal__Group_2__0__Impl rule__LVal__Group_2__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3912:2: rule__LVal__Group_2__0__Impl rule__LVal__Group_2__1
            {
            pushFollow(FOLLOW_rule__LVal__Group_2__0__Impl_in_rule__LVal__Group_2__08056);
            rule__LVal__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__LVal__Group_2__1_in_rule__LVal__Group_2__08059);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3919:1: rule__LVal__Group_2__0__Impl : ( '@' ) ;
    public final void rule__LVal__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3923:1: ( ( '@' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3924:1: ( '@' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3924:1: ( '@' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3925:1: '@'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getCommercialAtKeyword_2_0()); 
            }
            match(input,59,FOLLOW_59_in_rule__LVal__Group_2__0__Impl8087); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3938:1: rule__LVal__Group_2__1 : rule__LVal__Group_2__1__Impl ;
    public final void rule__LVal__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3942:1: ( rule__LVal__Group_2__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3943:2: rule__LVal__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__LVal__Group_2__1__Impl_in_rule__LVal__Group_2__18118);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3949:1: rule__LVal__Group_2__1__Impl : ( ( rule__LVal__AtAssignment_2_1 ) ) ;
    public final void rule__LVal__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3953:1: ( ( ( rule__LVal__AtAssignment_2_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3954:1: ( ( rule__LVal__AtAssignment_2_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3954:1: ( ( rule__LVal__AtAssignment_2_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3955:1: ( rule__LVal__AtAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getAtAssignment_2_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3956:1: ( rule__LVal__AtAssignment_2_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3956:2: rule__LVal__AtAssignment_2_1
            {
            pushFollow(FOLLOW_rule__LVal__AtAssignment_2_1_in_rule__LVal__Group_2__1__Impl8145);
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


    // $ANTLR start "rule__EqualityExpr__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3970:1: rule__EqualityExpr__Group__0 : rule__EqualityExpr__Group__0__Impl rule__EqualityExpr__Group__1 ;
    public final void rule__EqualityExpr__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3974:1: ( rule__EqualityExpr__Group__0__Impl rule__EqualityExpr__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3975:2: rule__EqualityExpr__Group__0__Impl rule__EqualityExpr__Group__1
            {
            pushFollow(FOLLOW_rule__EqualityExpr__Group__0__Impl_in_rule__EqualityExpr__Group__08179);
            rule__EqualityExpr__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__EqualityExpr__Group__1_in_rule__EqualityExpr__Group__08182);
            rule__EqualityExpr__Group__1();

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
    // $ANTLR end "rule__EqualityExpr__Group__0"


    // $ANTLR start "rule__EqualityExpr__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3982:1: rule__EqualityExpr__Group__0__Impl : ( ruleCompareExpr ) ;
    public final void rule__EqualityExpr__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3986:1: ( ( ruleCompareExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3987:1: ( ruleCompareExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3987:1: ( ruleCompareExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3988:1: ruleCompareExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExprAccess().getCompareExprParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleCompareExpr_in_rule__EqualityExpr__Group__0__Impl8209);
            ruleCompareExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExprAccess().getCompareExprParserRuleCall_0()); 
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
    // $ANTLR end "rule__EqualityExpr__Group__0__Impl"


    // $ANTLR start "rule__EqualityExpr__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:3999:1: rule__EqualityExpr__Group__1 : rule__EqualityExpr__Group__1__Impl ;
    public final void rule__EqualityExpr__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4003:1: ( rule__EqualityExpr__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4004:2: rule__EqualityExpr__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EqualityExpr__Group__1__Impl_in_rule__EqualityExpr__Group__18238);
            rule__EqualityExpr__Group__1__Impl();

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
    // $ANTLR end "rule__EqualityExpr__Group__1"


    // $ANTLR start "rule__EqualityExpr__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4010:1: rule__EqualityExpr__Group__1__Impl : ( ( rule__EqualityExpr__Group_1__0 )* ) ;
    public final void rule__EqualityExpr__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4014:1: ( ( ( rule__EqualityExpr__Group_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4015:1: ( ( rule__EqualityExpr__Group_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4015:1: ( ( rule__EqualityExpr__Group_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4016:1: ( rule__EqualityExpr__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExprAccess().getGroup_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4017:1: ( rule__EqualityExpr__Group_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==36) ) {
                    int LA39_2 = input.LA(2);

                    if ( (synpred60_InternalDmpl()) ) {
                        alt39=1;
                    }


                }
                else if ( (LA39_0==37) ) {
                    int LA39_3 = input.LA(2);

                    if ( (synpred60_InternalDmpl()) ) {
                        alt39=1;
                    }


                }


                switch (alt39) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4017:2: rule__EqualityExpr__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__EqualityExpr__Group_1__0_in_rule__EqualityExpr__Group__1__Impl8265);
            	    rule__EqualityExpr__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExprAccess().getGroup_1()); 
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
    // $ANTLR end "rule__EqualityExpr__Group__1__Impl"


    // $ANTLR start "rule__EqualityExpr__Group_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4031:1: rule__EqualityExpr__Group_1__0 : rule__EqualityExpr__Group_1__0__Impl rule__EqualityExpr__Group_1__1 ;
    public final void rule__EqualityExpr__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4035:1: ( rule__EqualityExpr__Group_1__0__Impl rule__EqualityExpr__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4036:2: rule__EqualityExpr__Group_1__0__Impl rule__EqualityExpr__Group_1__1
            {
            pushFollow(FOLLOW_rule__EqualityExpr__Group_1__0__Impl_in_rule__EqualityExpr__Group_1__08300);
            rule__EqualityExpr__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__EqualityExpr__Group_1__1_in_rule__EqualityExpr__Group_1__08303);
            rule__EqualityExpr__Group_1__1();

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
    // $ANTLR end "rule__EqualityExpr__Group_1__0"


    // $ANTLR start "rule__EqualityExpr__Group_1__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4043:1: rule__EqualityExpr__Group_1__0__Impl : ( ( rule__EqualityExpr__Group_1_0__0 ) ) ;
    public final void rule__EqualityExpr__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4047:1: ( ( ( rule__EqualityExpr__Group_1_0__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4048:1: ( ( rule__EqualityExpr__Group_1_0__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4048:1: ( ( rule__EqualityExpr__Group_1_0__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4049:1: ( rule__EqualityExpr__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExprAccess().getGroup_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4050:1: ( rule__EqualityExpr__Group_1_0__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4050:2: rule__EqualityExpr__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__EqualityExpr__Group_1_0__0_in_rule__EqualityExpr__Group_1__0__Impl8330);
            rule__EqualityExpr__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExprAccess().getGroup_1_0()); 
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
    // $ANTLR end "rule__EqualityExpr__Group_1__0__Impl"


    // $ANTLR start "rule__EqualityExpr__Group_1__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4060:1: rule__EqualityExpr__Group_1__1 : rule__EqualityExpr__Group_1__1__Impl ;
    public final void rule__EqualityExpr__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4064:1: ( rule__EqualityExpr__Group_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4065:2: rule__EqualityExpr__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__EqualityExpr__Group_1__1__Impl_in_rule__EqualityExpr__Group_1__18360);
            rule__EqualityExpr__Group_1__1__Impl();

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
    // $ANTLR end "rule__EqualityExpr__Group_1__1"


    // $ANTLR start "rule__EqualityExpr__Group_1__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4071:1: rule__EqualityExpr__Group_1__1__Impl : ( ( rule__EqualityExpr__RightAssignment_1_1 ) ) ;
    public final void rule__EqualityExpr__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4075:1: ( ( ( rule__EqualityExpr__RightAssignment_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4076:1: ( ( rule__EqualityExpr__RightAssignment_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4076:1: ( ( rule__EqualityExpr__RightAssignment_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4077:1: ( rule__EqualityExpr__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExprAccess().getRightAssignment_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4078:1: ( rule__EqualityExpr__RightAssignment_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4078:2: rule__EqualityExpr__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__EqualityExpr__RightAssignment_1_1_in_rule__EqualityExpr__Group_1__1__Impl8387);
            rule__EqualityExpr__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExprAccess().getRightAssignment_1_1()); 
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
    // $ANTLR end "rule__EqualityExpr__Group_1__1__Impl"


    // $ANTLR start "rule__EqualityExpr__Group_1_0__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4092:1: rule__EqualityExpr__Group_1_0__0 : rule__EqualityExpr__Group_1_0__0__Impl ;
    public final void rule__EqualityExpr__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4096:1: ( rule__EqualityExpr__Group_1_0__0__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4097:2: rule__EqualityExpr__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_rule__EqualityExpr__Group_1_0__0__Impl_in_rule__EqualityExpr__Group_1_0__08421);
            rule__EqualityExpr__Group_1_0__0__Impl();

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
    // $ANTLR end "rule__EqualityExpr__Group_1_0__0"


    // $ANTLR start "rule__EqualityExpr__Group_1_0__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4103:1: rule__EqualityExpr__Group_1_0__0__Impl : ( ( rule__EqualityExpr__Group_1_0_0__0 ) ) ;
    public final void rule__EqualityExpr__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4107:1: ( ( ( rule__EqualityExpr__Group_1_0_0__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4108:1: ( ( rule__EqualityExpr__Group_1_0_0__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4108:1: ( ( rule__EqualityExpr__Group_1_0_0__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4109:1: ( rule__EqualityExpr__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExprAccess().getGroup_1_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4110:1: ( rule__EqualityExpr__Group_1_0_0__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4110:2: rule__EqualityExpr__Group_1_0_0__0
            {
            pushFollow(FOLLOW_rule__EqualityExpr__Group_1_0_0__0_in_rule__EqualityExpr__Group_1_0__0__Impl8448);
            rule__EqualityExpr__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExprAccess().getGroup_1_0_0()); 
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
    // $ANTLR end "rule__EqualityExpr__Group_1_0__0__Impl"


    // $ANTLR start "rule__EqualityExpr__Group_1_0_0__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4122:1: rule__EqualityExpr__Group_1_0_0__0 : rule__EqualityExpr__Group_1_0_0__0__Impl rule__EqualityExpr__Group_1_0_0__1 ;
    public final void rule__EqualityExpr__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4126:1: ( rule__EqualityExpr__Group_1_0_0__0__Impl rule__EqualityExpr__Group_1_0_0__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4127:2: rule__EqualityExpr__Group_1_0_0__0__Impl rule__EqualityExpr__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__EqualityExpr__Group_1_0_0__0__Impl_in_rule__EqualityExpr__Group_1_0_0__08480);
            rule__EqualityExpr__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__EqualityExpr__Group_1_0_0__1_in_rule__EqualityExpr__Group_1_0_0__08483);
            rule__EqualityExpr__Group_1_0_0__1();

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
    // $ANTLR end "rule__EqualityExpr__Group_1_0_0__0"


    // $ANTLR start "rule__EqualityExpr__Group_1_0_0__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4134:1: rule__EqualityExpr__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__EqualityExpr__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4138:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4139:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4139:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4140:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExprAccess().getEqualityExprLeftAction_1_0_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4141:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4143:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExprAccess().getEqualityExprLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpr__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__EqualityExpr__Group_1_0_0__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4153:1: rule__EqualityExpr__Group_1_0_0__1 : rule__EqualityExpr__Group_1_0_0__1__Impl ;
    public final void rule__EqualityExpr__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4157:1: ( rule__EqualityExpr__Group_1_0_0__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4158:2: rule__EqualityExpr__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__EqualityExpr__Group_1_0_0__1__Impl_in_rule__EqualityExpr__Group_1_0_0__18541);
            rule__EqualityExpr__Group_1_0_0__1__Impl();

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
    // $ANTLR end "rule__EqualityExpr__Group_1_0_0__1"


    // $ANTLR start "rule__EqualityExpr__Group_1_0_0__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4164:1: rule__EqualityExpr__Group_1_0_0__1__Impl : ( ( rule__EqualityExpr__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__EqualityExpr__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4168:1: ( ( ( rule__EqualityExpr__OperatorAssignment_1_0_0_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4169:1: ( ( rule__EqualityExpr__OperatorAssignment_1_0_0_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4169:1: ( ( rule__EqualityExpr__OperatorAssignment_1_0_0_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4170:1: ( rule__EqualityExpr__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExprAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4171:1: ( rule__EqualityExpr__OperatorAssignment_1_0_0_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4171:2: rule__EqualityExpr__OperatorAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_rule__EqualityExpr__OperatorAssignment_1_0_0_1_in_rule__EqualityExpr__Group_1_0_0__1__Impl8568);
            rule__EqualityExpr__OperatorAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExprAccess().getOperatorAssignment_1_0_0_1()); 
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
    // $ANTLR end "rule__EqualityExpr__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__CompareExpr__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4185:1: rule__CompareExpr__Group__0 : rule__CompareExpr__Group__0__Impl rule__CompareExpr__Group__1 ;
    public final void rule__CompareExpr__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4189:1: ( rule__CompareExpr__Group__0__Impl rule__CompareExpr__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4190:2: rule__CompareExpr__Group__0__Impl rule__CompareExpr__Group__1
            {
            pushFollow(FOLLOW_rule__CompareExpr__Group__0__Impl_in_rule__CompareExpr__Group__08602);
            rule__CompareExpr__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CompareExpr__Group__1_in_rule__CompareExpr__Group__08605);
            rule__CompareExpr__Group__1();

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
    // $ANTLR end "rule__CompareExpr__Group__0"


    // $ANTLR start "rule__CompareExpr__Group__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4197:1: rule__CompareExpr__Group__0__Impl : ( ruleShiftExpr ) ;
    public final void rule__CompareExpr__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4201:1: ( ( ruleShiftExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4202:1: ( ruleShiftExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4202:1: ( ruleShiftExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4203:1: ruleShiftExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompareExprAccess().getShiftExprParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleShiftExpr_in_rule__CompareExpr__Group__0__Impl8632);
            ruleShiftExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompareExprAccess().getShiftExprParserRuleCall_0()); 
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
    // $ANTLR end "rule__CompareExpr__Group__0__Impl"


    // $ANTLR start "rule__CompareExpr__Group__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4214:1: rule__CompareExpr__Group__1 : rule__CompareExpr__Group__1__Impl ;
    public final void rule__CompareExpr__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4218:1: ( rule__CompareExpr__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4219:2: rule__CompareExpr__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__CompareExpr__Group__1__Impl_in_rule__CompareExpr__Group__18661);
            rule__CompareExpr__Group__1__Impl();

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
    // $ANTLR end "rule__CompareExpr__Group__1"


    // $ANTLR start "rule__CompareExpr__Group__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4225:1: rule__CompareExpr__Group__1__Impl : ( ( rule__CompareExpr__Group_1__0 )* ) ;
    public final void rule__CompareExpr__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4229:1: ( ( ( rule__CompareExpr__Group_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4230:1: ( ( rule__CompareExpr__Group_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4230:1: ( ( rule__CompareExpr__Group_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4231:1: ( rule__CompareExpr__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompareExprAccess().getGroup_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4232:1: ( rule__CompareExpr__Group_1__0 )*
            loop40:
            do {
                int alt40=2;
                switch ( input.LA(1) ) {
                case 38:
                    {
                    int LA40_2 = input.LA(2);

                    if ( (synpred61_InternalDmpl()) ) {
                        alt40=1;
                    }


                    }
                    break;
                case 39:
                    {
                    int LA40_3 = input.LA(2);

                    if ( (synpred61_InternalDmpl()) ) {
                        alt40=1;
                    }


                    }
                    break;
                case 40:
                    {
                    int LA40_4 = input.LA(2);

                    if ( (synpred61_InternalDmpl()) ) {
                        alt40=1;
                    }


                    }
                    break;
                case 41:
                    {
                    int LA40_5 = input.LA(2);

                    if ( (synpred61_InternalDmpl()) ) {
                        alt40=1;
                    }


                    }
                    break;

                }

                switch (alt40) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4232:2: rule__CompareExpr__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__CompareExpr__Group_1__0_in_rule__CompareExpr__Group__1__Impl8688);
            	    rule__CompareExpr__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompareExprAccess().getGroup_1()); 
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
    // $ANTLR end "rule__CompareExpr__Group__1__Impl"


    // $ANTLR start "rule__CompareExpr__Group_1__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4246:1: rule__CompareExpr__Group_1__0 : rule__CompareExpr__Group_1__0__Impl rule__CompareExpr__Group_1__1 ;
    public final void rule__CompareExpr__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4250:1: ( rule__CompareExpr__Group_1__0__Impl rule__CompareExpr__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4251:2: rule__CompareExpr__Group_1__0__Impl rule__CompareExpr__Group_1__1
            {
            pushFollow(FOLLOW_rule__CompareExpr__Group_1__0__Impl_in_rule__CompareExpr__Group_1__08723);
            rule__CompareExpr__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CompareExpr__Group_1__1_in_rule__CompareExpr__Group_1__08726);
            rule__CompareExpr__Group_1__1();

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
    // $ANTLR end "rule__CompareExpr__Group_1__0"


    // $ANTLR start "rule__CompareExpr__Group_1__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4258:1: rule__CompareExpr__Group_1__0__Impl : ( ( rule__CompareExpr__Group_1_0__0 ) ) ;
    public final void rule__CompareExpr__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4262:1: ( ( ( rule__CompareExpr__Group_1_0__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4263:1: ( ( rule__CompareExpr__Group_1_0__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4263:1: ( ( rule__CompareExpr__Group_1_0__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4264:1: ( rule__CompareExpr__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompareExprAccess().getGroup_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4265:1: ( rule__CompareExpr__Group_1_0__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4265:2: rule__CompareExpr__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__CompareExpr__Group_1_0__0_in_rule__CompareExpr__Group_1__0__Impl8753);
            rule__CompareExpr__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompareExprAccess().getGroup_1_0()); 
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
    // $ANTLR end "rule__CompareExpr__Group_1__0__Impl"


    // $ANTLR start "rule__CompareExpr__Group_1__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4275:1: rule__CompareExpr__Group_1__1 : rule__CompareExpr__Group_1__1__Impl ;
    public final void rule__CompareExpr__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4279:1: ( rule__CompareExpr__Group_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4280:2: rule__CompareExpr__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__CompareExpr__Group_1__1__Impl_in_rule__CompareExpr__Group_1__18783);
            rule__CompareExpr__Group_1__1__Impl();

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
    // $ANTLR end "rule__CompareExpr__Group_1__1"


    // $ANTLR start "rule__CompareExpr__Group_1__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4286:1: rule__CompareExpr__Group_1__1__Impl : ( ( rule__CompareExpr__RightAssignment_1_1 ) ) ;
    public final void rule__CompareExpr__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4290:1: ( ( ( rule__CompareExpr__RightAssignment_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4291:1: ( ( rule__CompareExpr__RightAssignment_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4291:1: ( ( rule__CompareExpr__RightAssignment_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4292:1: ( rule__CompareExpr__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompareExprAccess().getRightAssignment_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4293:1: ( rule__CompareExpr__RightAssignment_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4293:2: rule__CompareExpr__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__CompareExpr__RightAssignment_1_1_in_rule__CompareExpr__Group_1__1__Impl8810);
            rule__CompareExpr__RightAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompareExprAccess().getRightAssignment_1_1()); 
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
    // $ANTLR end "rule__CompareExpr__Group_1__1__Impl"


    // $ANTLR start "rule__CompareExpr__Group_1_0__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4307:1: rule__CompareExpr__Group_1_0__0 : rule__CompareExpr__Group_1_0__0__Impl ;
    public final void rule__CompareExpr__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4311:1: ( rule__CompareExpr__Group_1_0__0__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4312:2: rule__CompareExpr__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_rule__CompareExpr__Group_1_0__0__Impl_in_rule__CompareExpr__Group_1_0__08844);
            rule__CompareExpr__Group_1_0__0__Impl();

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
    // $ANTLR end "rule__CompareExpr__Group_1_0__0"


    // $ANTLR start "rule__CompareExpr__Group_1_0__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4318:1: rule__CompareExpr__Group_1_0__0__Impl : ( ( rule__CompareExpr__Group_1_0_0__0 ) ) ;
    public final void rule__CompareExpr__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4322:1: ( ( ( rule__CompareExpr__Group_1_0_0__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4323:1: ( ( rule__CompareExpr__Group_1_0_0__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4323:1: ( ( rule__CompareExpr__Group_1_0_0__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4324:1: ( rule__CompareExpr__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompareExprAccess().getGroup_1_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4325:1: ( rule__CompareExpr__Group_1_0_0__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4325:2: rule__CompareExpr__Group_1_0_0__0
            {
            pushFollow(FOLLOW_rule__CompareExpr__Group_1_0_0__0_in_rule__CompareExpr__Group_1_0__0__Impl8871);
            rule__CompareExpr__Group_1_0_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompareExprAccess().getGroup_1_0_0()); 
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
    // $ANTLR end "rule__CompareExpr__Group_1_0__0__Impl"


    // $ANTLR start "rule__CompareExpr__Group_1_0_0__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4337:1: rule__CompareExpr__Group_1_0_0__0 : rule__CompareExpr__Group_1_0_0__0__Impl rule__CompareExpr__Group_1_0_0__1 ;
    public final void rule__CompareExpr__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4341:1: ( rule__CompareExpr__Group_1_0_0__0__Impl rule__CompareExpr__Group_1_0_0__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4342:2: rule__CompareExpr__Group_1_0_0__0__Impl rule__CompareExpr__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__CompareExpr__Group_1_0_0__0__Impl_in_rule__CompareExpr__Group_1_0_0__08903);
            rule__CompareExpr__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CompareExpr__Group_1_0_0__1_in_rule__CompareExpr__Group_1_0_0__08906);
            rule__CompareExpr__Group_1_0_0__1();

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
    // $ANTLR end "rule__CompareExpr__Group_1_0_0__0"


    // $ANTLR start "rule__CompareExpr__Group_1_0_0__0__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4349:1: rule__CompareExpr__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__CompareExpr__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4353:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4354:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4354:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4355:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompareExprAccess().getCompareExprLeftAction_1_0_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4356:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4358:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompareExprAccess().getCompareExprLeftAction_1_0_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompareExpr__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__CompareExpr__Group_1_0_0__1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4368:1: rule__CompareExpr__Group_1_0_0__1 : rule__CompareExpr__Group_1_0_0__1__Impl ;
    public final void rule__CompareExpr__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4372:1: ( rule__CompareExpr__Group_1_0_0__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4373:2: rule__CompareExpr__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__CompareExpr__Group_1_0_0__1__Impl_in_rule__CompareExpr__Group_1_0_0__18964);
            rule__CompareExpr__Group_1_0_0__1__Impl();

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
    // $ANTLR end "rule__CompareExpr__Group_1_0_0__1"


    // $ANTLR start "rule__CompareExpr__Group_1_0_0__1__Impl"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4379:1: rule__CompareExpr__Group_1_0_0__1__Impl : ( ( rule__CompareExpr__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__CompareExpr__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4383:1: ( ( ( rule__CompareExpr__OperatorAssignment_1_0_0_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4384:1: ( ( rule__CompareExpr__OperatorAssignment_1_0_0_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4384:1: ( ( rule__CompareExpr__OperatorAssignment_1_0_0_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4385:1: ( rule__CompareExpr__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompareExprAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4386:1: ( rule__CompareExpr__OperatorAssignment_1_0_0_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4386:2: rule__CompareExpr__OperatorAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_rule__CompareExpr__OperatorAssignment_1_0_0_1_in_rule__CompareExpr__Group_1_0_0__1__Impl8991);
            rule__CompareExpr__OperatorAssignment_1_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompareExprAccess().getOperatorAssignment_1_0_0_1()); 
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
    // $ANTLR end "rule__CompareExpr__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__ShiftExpr__Group__0"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4400:1: rule__ShiftExpr__Group__0 : rule__ShiftExpr__Group__0__Impl rule__ShiftExpr__Group__1 ;
    public final void rule__ShiftExpr__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4404:1: ( rule__ShiftExpr__Group__0__Impl rule__ShiftExpr__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4405:2: rule__ShiftExpr__Group__0__Impl rule__ShiftExpr__Group__1
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group__0__Impl_in_rule__ShiftExpr__Group__09025);
            rule__ShiftExpr__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ShiftExpr__Group__1_in_rule__ShiftExpr__Group__09028);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4412:1: rule__ShiftExpr__Group__0__Impl : ( ruleAdditiveExpr ) ;
    public final void rule__ShiftExpr__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4416:1: ( ( ruleAdditiveExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4417:1: ( ruleAdditiveExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4417:1: ( ruleAdditiveExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4418:1: ruleAdditiveExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getAdditiveExprParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpr_in_rule__ShiftExpr__Group__0__Impl9055);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4429:1: rule__ShiftExpr__Group__1 : rule__ShiftExpr__Group__1__Impl ;
    public final void rule__ShiftExpr__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4433:1: ( rule__ShiftExpr__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4434:2: rule__ShiftExpr__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group__1__Impl_in_rule__ShiftExpr__Group__19084);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4440:1: rule__ShiftExpr__Group__1__Impl : ( ( rule__ShiftExpr__Group_1__0 )* ) ;
    public final void rule__ShiftExpr__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4444:1: ( ( ( rule__ShiftExpr__Group_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4445:1: ( ( rule__ShiftExpr__Group_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4445:1: ( ( rule__ShiftExpr__Group_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4446:1: ( rule__ShiftExpr__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getGroup_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4447:1: ( rule__ShiftExpr__Group_1__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==42) ) {
                    int LA41_2 = input.LA(2);

                    if ( (synpred62_InternalDmpl()) ) {
                        alt41=1;
                    }


                }
                else if ( (LA41_0==43) ) {
                    int LA41_3 = input.LA(2);

                    if ( (synpred62_InternalDmpl()) ) {
                        alt41=1;
                    }


                }


                switch (alt41) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4447:2: rule__ShiftExpr__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ShiftExpr__Group_1__0_in_rule__ShiftExpr__Group__1__Impl9111);
            	    rule__ShiftExpr__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop41;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4461:1: rule__ShiftExpr__Group_1__0 : rule__ShiftExpr__Group_1__0__Impl rule__ShiftExpr__Group_1__1 ;
    public final void rule__ShiftExpr__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4465:1: ( rule__ShiftExpr__Group_1__0__Impl rule__ShiftExpr__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4466:2: rule__ShiftExpr__Group_1__0__Impl rule__ShiftExpr__Group_1__1
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1__0__Impl_in_rule__ShiftExpr__Group_1__09146);
            rule__ShiftExpr__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1__1_in_rule__ShiftExpr__Group_1__09149);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4473:1: rule__ShiftExpr__Group_1__0__Impl : ( ( rule__ShiftExpr__Group_1_0__0 ) ) ;
    public final void rule__ShiftExpr__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4477:1: ( ( ( rule__ShiftExpr__Group_1_0__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4478:1: ( ( rule__ShiftExpr__Group_1_0__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4478:1: ( ( rule__ShiftExpr__Group_1_0__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4479:1: ( rule__ShiftExpr__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getGroup_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4480:1: ( rule__ShiftExpr__Group_1_0__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4480:2: rule__ShiftExpr__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1_0__0_in_rule__ShiftExpr__Group_1__0__Impl9176);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4490:1: rule__ShiftExpr__Group_1__1 : rule__ShiftExpr__Group_1__1__Impl ;
    public final void rule__ShiftExpr__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4494:1: ( rule__ShiftExpr__Group_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4495:2: rule__ShiftExpr__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1__1__Impl_in_rule__ShiftExpr__Group_1__19206);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4501:1: rule__ShiftExpr__Group_1__1__Impl : ( ( rule__ShiftExpr__RightAssignment_1_1 ) ) ;
    public final void rule__ShiftExpr__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4505:1: ( ( ( rule__ShiftExpr__RightAssignment_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4506:1: ( ( rule__ShiftExpr__RightAssignment_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4506:1: ( ( rule__ShiftExpr__RightAssignment_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4507:1: ( rule__ShiftExpr__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getRightAssignment_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4508:1: ( rule__ShiftExpr__RightAssignment_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4508:2: rule__ShiftExpr__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ShiftExpr__RightAssignment_1_1_in_rule__ShiftExpr__Group_1__1__Impl9233);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4522:1: rule__ShiftExpr__Group_1_0__0 : rule__ShiftExpr__Group_1_0__0__Impl ;
    public final void rule__ShiftExpr__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4526:1: ( rule__ShiftExpr__Group_1_0__0__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4527:2: rule__ShiftExpr__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1_0__0__Impl_in_rule__ShiftExpr__Group_1_0__09267);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4533:1: rule__ShiftExpr__Group_1_0__0__Impl : ( ( rule__ShiftExpr__Group_1_0_0__0 ) ) ;
    public final void rule__ShiftExpr__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4537:1: ( ( ( rule__ShiftExpr__Group_1_0_0__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4538:1: ( ( rule__ShiftExpr__Group_1_0_0__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4538:1: ( ( rule__ShiftExpr__Group_1_0_0__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4539:1: ( rule__ShiftExpr__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getGroup_1_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4540:1: ( rule__ShiftExpr__Group_1_0_0__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4540:2: rule__ShiftExpr__Group_1_0_0__0
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1_0_0__0_in_rule__ShiftExpr__Group_1_0__0__Impl9294);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4552:1: rule__ShiftExpr__Group_1_0_0__0 : rule__ShiftExpr__Group_1_0_0__0__Impl rule__ShiftExpr__Group_1_0_0__1 ;
    public final void rule__ShiftExpr__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4556:1: ( rule__ShiftExpr__Group_1_0_0__0__Impl rule__ShiftExpr__Group_1_0_0__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4557:2: rule__ShiftExpr__Group_1_0_0__0__Impl rule__ShiftExpr__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1_0_0__0__Impl_in_rule__ShiftExpr__Group_1_0_0__09326);
            rule__ShiftExpr__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1_0_0__1_in_rule__ShiftExpr__Group_1_0_0__09329);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4564:1: rule__ShiftExpr__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__ShiftExpr__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4568:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4569:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4569:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4570:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getShiftExprLeftAction_1_0_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4571:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4573:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4583:1: rule__ShiftExpr__Group_1_0_0__1 : rule__ShiftExpr__Group_1_0_0__1__Impl ;
    public final void rule__ShiftExpr__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4587:1: ( rule__ShiftExpr__Group_1_0_0__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4588:2: rule__ShiftExpr__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ShiftExpr__Group_1_0_0__1__Impl_in_rule__ShiftExpr__Group_1_0_0__19387);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4594:1: rule__ShiftExpr__Group_1_0_0__1__Impl : ( ( rule__ShiftExpr__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__ShiftExpr__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4598:1: ( ( ( rule__ShiftExpr__OperatorAssignment_1_0_0_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4599:1: ( ( rule__ShiftExpr__OperatorAssignment_1_0_0_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4599:1: ( ( rule__ShiftExpr__OperatorAssignment_1_0_0_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4600:1: ( rule__ShiftExpr__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4601:1: ( rule__ShiftExpr__OperatorAssignment_1_0_0_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4601:2: rule__ShiftExpr__OperatorAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_rule__ShiftExpr__OperatorAssignment_1_0_0_1_in_rule__ShiftExpr__Group_1_0_0__1__Impl9414);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4615:1: rule__AdditiveExpr__Group__0 : rule__AdditiveExpr__Group__0__Impl rule__AdditiveExpr__Group__1 ;
    public final void rule__AdditiveExpr__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4619:1: ( rule__AdditiveExpr__Group__0__Impl rule__AdditiveExpr__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4620:2: rule__AdditiveExpr__Group__0__Impl rule__AdditiveExpr__Group__1
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group__0__Impl_in_rule__AdditiveExpr__Group__09448);
            rule__AdditiveExpr__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AdditiveExpr__Group__1_in_rule__AdditiveExpr__Group__09451);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4627:1: rule__AdditiveExpr__Group__0__Impl : ( ruleMultiplicativeExpr ) ;
    public final void rule__AdditiveExpr__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4631:1: ( ( ruleMultiplicativeExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4632:1: ( ruleMultiplicativeExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4632:1: ( ruleMultiplicativeExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4633:1: ruleMultiplicativeExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getMultiplicativeExprParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpr_in_rule__AdditiveExpr__Group__0__Impl9478);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4644:1: rule__AdditiveExpr__Group__1 : rule__AdditiveExpr__Group__1__Impl ;
    public final void rule__AdditiveExpr__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4648:1: ( rule__AdditiveExpr__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4649:2: rule__AdditiveExpr__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group__1__Impl_in_rule__AdditiveExpr__Group__19507);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4655:1: rule__AdditiveExpr__Group__1__Impl : ( ( rule__AdditiveExpr__Group_1__0 )* ) ;
    public final void rule__AdditiveExpr__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4659:1: ( ( ( rule__AdditiveExpr__Group_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4660:1: ( ( rule__AdditiveExpr__Group_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4660:1: ( ( rule__AdditiveExpr__Group_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4661:1: ( rule__AdditiveExpr__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getGroup_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4662:1: ( rule__AdditiveExpr__Group_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==19) ) {
                    int LA42_2 = input.LA(2);

                    if ( (synpred63_InternalDmpl()) ) {
                        alt42=1;
                    }


                }
                else if ( (LA42_0==20) ) {
                    int LA42_3 = input.LA(2);

                    if ( (synpred63_InternalDmpl()) ) {
                        alt42=1;
                    }


                }


                switch (alt42) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4662:2: rule__AdditiveExpr__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AdditiveExpr__Group_1__0_in_rule__AdditiveExpr__Group__1__Impl9534);
            	    rule__AdditiveExpr__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop42;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4676:1: rule__AdditiveExpr__Group_1__0 : rule__AdditiveExpr__Group_1__0__Impl rule__AdditiveExpr__Group_1__1 ;
    public final void rule__AdditiveExpr__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4680:1: ( rule__AdditiveExpr__Group_1__0__Impl rule__AdditiveExpr__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4681:2: rule__AdditiveExpr__Group_1__0__Impl rule__AdditiveExpr__Group_1__1
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1__0__Impl_in_rule__AdditiveExpr__Group_1__09569);
            rule__AdditiveExpr__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1__1_in_rule__AdditiveExpr__Group_1__09572);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4688:1: rule__AdditiveExpr__Group_1__0__Impl : ( ( rule__AdditiveExpr__Group_1_0__0 ) ) ;
    public final void rule__AdditiveExpr__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4692:1: ( ( ( rule__AdditiveExpr__Group_1_0__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4693:1: ( ( rule__AdditiveExpr__Group_1_0__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4693:1: ( ( rule__AdditiveExpr__Group_1_0__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4694:1: ( rule__AdditiveExpr__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getGroup_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4695:1: ( rule__AdditiveExpr__Group_1_0__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4695:2: rule__AdditiveExpr__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1_0__0_in_rule__AdditiveExpr__Group_1__0__Impl9599);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4705:1: rule__AdditiveExpr__Group_1__1 : rule__AdditiveExpr__Group_1__1__Impl ;
    public final void rule__AdditiveExpr__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4709:1: ( rule__AdditiveExpr__Group_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4710:2: rule__AdditiveExpr__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1__1__Impl_in_rule__AdditiveExpr__Group_1__19629);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4716:1: rule__AdditiveExpr__Group_1__1__Impl : ( ( rule__AdditiveExpr__RightAssignment_1_1 ) ) ;
    public final void rule__AdditiveExpr__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4720:1: ( ( ( rule__AdditiveExpr__RightAssignment_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4721:1: ( ( rule__AdditiveExpr__RightAssignment_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4721:1: ( ( rule__AdditiveExpr__RightAssignment_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4722:1: ( rule__AdditiveExpr__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getRightAssignment_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4723:1: ( rule__AdditiveExpr__RightAssignment_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4723:2: rule__AdditiveExpr__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__RightAssignment_1_1_in_rule__AdditiveExpr__Group_1__1__Impl9656);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4737:1: rule__AdditiveExpr__Group_1_0__0 : rule__AdditiveExpr__Group_1_0__0__Impl ;
    public final void rule__AdditiveExpr__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4741:1: ( rule__AdditiveExpr__Group_1_0__0__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4742:2: rule__AdditiveExpr__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1_0__0__Impl_in_rule__AdditiveExpr__Group_1_0__09690);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4748:1: rule__AdditiveExpr__Group_1_0__0__Impl : ( ( rule__AdditiveExpr__Group_1_0_0__0 ) ) ;
    public final void rule__AdditiveExpr__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4752:1: ( ( ( rule__AdditiveExpr__Group_1_0_0__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4753:1: ( ( rule__AdditiveExpr__Group_1_0_0__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4753:1: ( ( rule__AdditiveExpr__Group_1_0_0__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4754:1: ( rule__AdditiveExpr__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getGroup_1_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4755:1: ( rule__AdditiveExpr__Group_1_0_0__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4755:2: rule__AdditiveExpr__Group_1_0_0__0
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1_0_0__0_in_rule__AdditiveExpr__Group_1_0__0__Impl9717);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4767:1: rule__AdditiveExpr__Group_1_0_0__0 : rule__AdditiveExpr__Group_1_0_0__0__Impl rule__AdditiveExpr__Group_1_0_0__1 ;
    public final void rule__AdditiveExpr__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4771:1: ( rule__AdditiveExpr__Group_1_0_0__0__Impl rule__AdditiveExpr__Group_1_0_0__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4772:2: rule__AdditiveExpr__Group_1_0_0__0__Impl rule__AdditiveExpr__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1_0_0__0__Impl_in_rule__AdditiveExpr__Group_1_0_0__09749);
            rule__AdditiveExpr__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1_0_0__1_in_rule__AdditiveExpr__Group_1_0_0__09752);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4779:1: rule__AdditiveExpr__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__AdditiveExpr__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4783:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4784:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4784:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4785:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getAdditiveExprLeftAction_1_0_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4786:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4788:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4798:1: rule__AdditiveExpr__Group_1_0_0__1 : rule__AdditiveExpr__Group_1_0_0__1__Impl ;
    public final void rule__AdditiveExpr__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4802:1: ( rule__AdditiveExpr__Group_1_0_0__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4803:2: rule__AdditiveExpr__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__Group_1_0_0__1__Impl_in_rule__AdditiveExpr__Group_1_0_0__19810);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4809:1: rule__AdditiveExpr__Group_1_0_0__1__Impl : ( ( rule__AdditiveExpr__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__AdditiveExpr__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4813:1: ( ( ( rule__AdditiveExpr__OperatorAssignment_1_0_0_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4814:1: ( ( rule__AdditiveExpr__OperatorAssignment_1_0_0_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4814:1: ( ( rule__AdditiveExpr__OperatorAssignment_1_0_0_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4815:1: ( rule__AdditiveExpr__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4816:1: ( rule__AdditiveExpr__OperatorAssignment_1_0_0_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4816:2: rule__AdditiveExpr__OperatorAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_rule__AdditiveExpr__OperatorAssignment_1_0_0_1_in_rule__AdditiveExpr__Group_1_0_0__1__Impl9837);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4830:1: rule__MultiplicativeExpr__Group__0 : rule__MultiplicativeExpr__Group__0__Impl rule__MultiplicativeExpr__Group__1 ;
    public final void rule__MultiplicativeExpr__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4834:1: ( rule__MultiplicativeExpr__Group__0__Impl rule__MultiplicativeExpr__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4835:2: rule__MultiplicativeExpr__Group__0__Impl rule__MultiplicativeExpr__Group__1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group__0__Impl_in_rule__MultiplicativeExpr__Group__09871);
            rule__MultiplicativeExpr__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group__1_in_rule__MultiplicativeExpr__Group__09874);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4842:1: rule__MultiplicativeExpr__Group__0__Impl : ( ruleTerminalExpr ) ;
    public final void rule__MultiplicativeExpr__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4846:1: ( ( ruleTerminalExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4847:1: ( ruleTerminalExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4847:1: ( ruleTerminalExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4848:1: ruleTerminalExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getTerminalExprParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleTerminalExpr_in_rule__MultiplicativeExpr__Group__0__Impl9901);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4859:1: rule__MultiplicativeExpr__Group__1 : rule__MultiplicativeExpr__Group__1__Impl ;
    public final void rule__MultiplicativeExpr__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4863:1: ( rule__MultiplicativeExpr__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4864:2: rule__MultiplicativeExpr__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group__1__Impl_in_rule__MultiplicativeExpr__Group__19930);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4870:1: rule__MultiplicativeExpr__Group__1__Impl : ( ( rule__MultiplicativeExpr__Group_1__0 )* ) ;
    public final void rule__MultiplicativeExpr__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4874:1: ( ( ( rule__MultiplicativeExpr__Group_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4875:1: ( ( rule__MultiplicativeExpr__Group_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4875:1: ( ( rule__MultiplicativeExpr__Group_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4876:1: ( rule__MultiplicativeExpr__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getGroup_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4877:1: ( rule__MultiplicativeExpr__Group_1__0 )*
            loop43:
            do {
                int alt43=2;
                switch ( input.LA(1) ) {
                case 44:
                    {
                    int LA43_2 = input.LA(2);

                    if ( (synpred64_InternalDmpl()) ) {
                        alt43=1;
                    }


                    }
                    break;
                case 45:
                    {
                    int LA43_3 = input.LA(2);

                    if ( (synpred64_InternalDmpl()) ) {
                        alt43=1;
                    }


                    }
                    break;
                case 46:
                    {
                    int LA43_4 = input.LA(2);

                    if ( (synpred64_InternalDmpl()) ) {
                        alt43=1;
                    }


                    }
                    break;

                }

                switch (alt43) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4877:2: rule__MultiplicativeExpr__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1__0_in_rule__MultiplicativeExpr__Group__1__Impl9957);
            	    rule__MultiplicativeExpr__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop43;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4891:1: rule__MultiplicativeExpr__Group_1__0 : rule__MultiplicativeExpr__Group_1__0__Impl rule__MultiplicativeExpr__Group_1__1 ;
    public final void rule__MultiplicativeExpr__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4895:1: ( rule__MultiplicativeExpr__Group_1__0__Impl rule__MultiplicativeExpr__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4896:2: rule__MultiplicativeExpr__Group_1__0__Impl rule__MultiplicativeExpr__Group_1__1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1__0__Impl_in_rule__MultiplicativeExpr__Group_1__09992);
            rule__MultiplicativeExpr__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1__1_in_rule__MultiplicativeExpr__Group_1__09995);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4903:1: rule__MultiplicativeExpr__Group_1__0__Impl : ( ( rule__MultiplicativeExpr__Group_1_0__0 ) ) ;
    public final void rule__MultiplicativeExpr__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4907:1: ( ( ( rule__MultiplicativeExpr__Group_1_0__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4908:1: ( ( rule__MultiplicativeExpr__Group_1_0__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4908:1: ( ( rule__MultiplicativeExpr__Group_1_0__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4909:1: ( rule__MultiplicativeExpr__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getGroup_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4910:1: ( rule__MultiplicativeExpr__Group_1_0__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4910:2: rule__MultiplicativeExpr__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1_0__0_in_rule__MultiplicativeExpr__Group_1__0__Impl10022);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4920:1: rule__MultiplicativeExpr__Group_1__1 : rule__MultiplicativeExpr__Group_1__1__Impl ;
    public final void rule__MultiplicativeExpr__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4924:1: ( rule__MultiplicativeExpr__Group_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4925:2: rule__MultiplicativeExpr__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1__1__Impl_in_rule__MultiplicativeExpr__Group_1__110052);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4931:1: rule__MultiplicativeExpr__Group_1__1__Impl : ( ( rule__MultiplicativeExpr__RightAssignment_1_1 ) ) ;
    public final void rule__MultiplicativeExpr__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4935:1: ( ( ( rule__MultiplicativeExpr__RightAssignment_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4936:1: ( ( rule__MultiplicativeExpr__RightAssignment_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4936:1: ( ( rule__MultiplicativeExpr__RightAssignment_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4937:1: ( rule__MultiplicativeExpr__RightAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getRightAssignment_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4938:1: ( rule__MultiplicativeExpr__RightAssignment_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4938:2: rule__MultiplicativeExpr__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__RightAssignment_1_1_in_rule__MultiplicativeExpr__Group_1__1__Impl10079);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4952:1: rule__MultiplicativeExpr__Group_1_0__0 : rule__MultiplicativeExpr__Group_1_0__0__Impl ;
    public final void rule__MultiplicativeExpr__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4956:1: ( rule__MultiplicativeExpr__Group_1_0__0__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4957:2: rule__MultiplicativeExpr__Group_1_0__0__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1_0__0__Impl_in_rule__MultiplicativeExpr__Group_1_0__010113);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4963:1: rule__MultiplicativeExpr__Group_1_0__0__Impl : ( ( rule__MultiplicativeExpr__Group_1_0_0__0 ) ) ;
    public final void rule__MultiplicativeExpr__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4967:1: ( ( ( rule__MultiplicativeExpr__Group_1_0_0__0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4968:1: ( ( rule__MultiplicativeExpr__Group_1_0_0__0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4968:1: ( ( rule__MultiplicativeExpr__Group_1_0_0__0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4969:1: ( rule__MultiplicativeExpr__Group_1_0_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getGroup_1_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4970:1: ( rule__MultiplicativeExpr__Group_1_0_0__0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4970:2: rule__MultiplicativeExpr__Group_1_0_0__0
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1_0_0__0_in_rule__MultiplicativeExpr__Group_1_0__0__Impl10140);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4982:1: rule__MultiplicativeExpr__Group_1_0_0__0 : rule__MultiplicativeExpr__Group_1_0_0__0__Impl rule__MultiplicativeExpr__Group_1_0_0__1 ;
    public final void rule__MultiplicativeExpr__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4986:1: ( rule__MultiplicativeExpr__Group_1_0_0__0__Impl rule__MultiplicativeExpr__Group_1_0_0__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4987:2: rule__MultiplicativeExpr__Group_1_0_0__0__Impl rule__MultiplicativeExpr__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1_0_0__0__Impl_in_rule__MultiplicativeExpr__Group_1_0_0__010172);
            rule__MultiplicativeExpr__Group_1_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1_0_0__1_in_rule__MultiplicativeExpr__Group_1_0_0__010175);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4994:1: rule__MultiplicativeExpr__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__MultiplicativeExpr__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4998:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4999:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4999:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5000:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getMultiplicativeExprLeftAction_1_0_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5001:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5003:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5013:1: rule__MultiplicativeExpr__Group_1_0_0__1 : rule__MultiplicativeExpr__Group_1_0_0__1__Impl ;
    public final void rule__MultiplicativeExpr__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5017:1: ( rule__MultiplicativeExpr__Group_1_0_0__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5018:2: rule__MultiplicativeExpr__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1_0_0__1__Impl_in_rule__MultiplicativeExpr__Group_1_0_0__110233);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5024:1: rule__MultiplicativeExpr__Group_1_0_0__1__Impl : ( ( rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1 ) ) ;
    public final void rule__MultiplicativeExpr__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5028:1: ( ( ( rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5029:1: ( ( rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5029:1: ( ( rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5030:1: ( rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getOperatorAssignment_1_0_0_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5031:1: ( rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5031:2: rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1_in_rule__MultiplicativeExpr__Group_1_0_0__1__Impl10260);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5045:1: rule__TerminalExpr__Group_1__0 : rule__TerminalExpr__Group_1__0__Impl rule__TerminalExpr__Group_1__1 ;
    public final void rule__TerminalExpr__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5049:1: ( rule__TerminalExpr__Group_1__0__Impl rule__TerminalExpr__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5050:2: rule__TerminalExpr__Group_1__0__Impl rule__TerminalExpr__Group_1__1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_1__0__Impl_in_rule__TerminalExpr__Group_1__010294);
            rule__TerminalExpr__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_1__1_in_rule__TerminalExpr__Group_1__010297);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5057:1: rule__TerminalExpr__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalExpr__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5061:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5062:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5062:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5063:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getIdExprAction_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5064:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5066:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5076:1: rule__TerminalExpr__Group_1__1 : rule__TerminalExpr__Group_1__1__Impl ;
    public final void rule__TerminalExpr__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5080:1: ( rule__TerminalExpr__Group_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5081:2: rule__TerminalExpr__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_1__1__Impl_in_rule__TerminalExpr__Group_1__110355);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5087:1: rule__TerminalExpr__Group_1__1__Impl : ( 'id' ) ;
    public final void rule__TerminalExpr__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5091:1: ( ( 'id' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5092:1: ( 'id' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5092:1: ( 'id' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5093:1: 'id'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getIdKeyword_1_1()); 
            }
            match(input,60,FOLLOW_60_in_rule__TerminalExpr__Group_1__1__Impl10383); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5110:1: rule__TerminalExpr__Group_2__0 : rule__TerminalExpr__Group_2__0__Impl rule__TerminalExpr__Group_2__1 ;
    public final void rule__TerminalExpr__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5114:1: ( rule__TerminalExpr__Group_2__0__Impl rule__TerminalExpr__Group_2__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5115:2: rule__TerminalExpr__Group_2__0__Impl rule__TerminalExpr__Group_2__1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_2__0__Impl_in_rule__TerminalExpr__Group_2__010418);
            rule__TerminalExpr__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_2__1_in_rule__TerminalExpr__Group_2__010421);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5122:1: rule__TerminalExpr__Group_2__0__Impl : ( () ) ;
    public final void rule__TerminalExpr__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5126:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5127:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5127:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5128:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getIntExprAction_2_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5129:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5131:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5141:1: rule__TerminalExpr__Group_2__1 : rule__TerminalExpr__Group_2__1__Impl ;
    public final void rule__TerminalExpr__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5145:1: ( rule__TerminalExpr__Group_2__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5146:2: rule__TerminalExpr__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_2__1__Impl_in_rule__TerminalExpr__Group_2__110479);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5152:1: rule__TerminalExpr__Group_2__1__Impl : ( ( rule__TerminalExpr__ValueAssignment_2_1 ) ) ;
    public final void rule__TerminalExpr__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5156:1: ( ( ( rule__TerminalExpr__ValueAssignment_2_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5157:1: ( ( rule__TerminalExpr__ValueAssignment_2_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5157:1: ( ( rule__TerminalExpr__ValueAssignment_2_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5158:1: ( rule__TerminalExpr__ValueAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getValueAssignment_2_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5159:1: ( rule__TerminalExpr__ValueAssignment_2_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5159:2: rule__TerminalExpr__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__ValueAssignment_2_1_in_rule__TerminalExpr__Group_2__1__Impl10506);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5173:1: rule__TerminalExpr__Group_3__0 : rule__TerminalExpr__Group_3__0__Impl rule__TerminalExpr__Group_3__1 ;
    public final void rule__TerminalExpr__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5177:1: ( rule__TerminalExpr__Group_3__0__Impl rule__TerminalExpr__Group_3__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5178:2: rule__TerminalExpr__Group_3__0__Impl rule__TerminalExpr__Group_3__1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_3__0__Impl_in_rule__TerminalExpr__Group_3__010540);
            rule__TerminalExpr__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_3__1_in_rule__TerminalExpr__Group_3__010543);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5185:1: rule__TerminalExpr__Group_3__0__Impl : ( () ) ;
    public final void rule__TerminalExpr__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5189:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5190:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5190:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5191:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getDoubleExprAction_3_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5192:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5194:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5204:1: rule__TerminalExpr__Group_3__1 : rule__TerminalExpr__Group_3__1__Impl ;
    public final void rule__TerminalExpr__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5208:1: ( rule__TerminalExpr__Group_3__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5209:2: rule__TerminalExpr__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_3__1__Impl_in_rule__TerminalExpr__Group_3__110601);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5215:1: rule__TerminalExpr__Group_3__1__Impl : ( ( rule__TerminalExpr__ValueAssignment_3_1 ) ) ;
    public final void rule__TerminalExpr__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5219:1: ( ( ( rule__TerminalExpr__ValueAssignment_3_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5220:1: ( ( rule__TerminalExpr__ValueAssignment_3_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5220:1: ( ( rule__TerminalExpr__ValueAssignment_3_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5221:1: ( rule__TerminalExpr__ValueAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getValueAssignment_3_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5222:1: ( rule__TerminalExpr__ValueAssignment_3_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5222:2: rule__TerminalExpr__ValueAssignment_3_1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__ValueAssignment_3_1_in_rule__TerminalExpr__Group_3__1__Impl10628);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5236:1: rule__TerminalExpr__Group_4__0 : rule__TerminalExpr__Group_4__0__Impl rule__TerminalExpr__Group_4__1 ;
    public final void rule__TerminalExpr__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5240:1: ( rule__TerminalExpr__Group_4__0__Impl rule__TerminalExpr__Group_4__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5241:2: rule__TerminalExpr__Group_4__0__Impl rule__TerminalExpr__Group_4__1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_4__0__Impl_in_rule__TerminalExpr__Group_4__010662);
            rule__TerminalExpr__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_4__1_in_rule__TerminalExpr__Group_4__010665);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5248:1: rule__TerminalExpr__Group_4__0__Impl : ( () ) ;
    public final void rule__TerminalExpr__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5252:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5253:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5253:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5254:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getNodeNumExprAction_4_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5255:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5257:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5267:1: rule__TerminalExpr__Group_4__1 : rule__TerminalExpr__Group_4__1__Impl ;
    public final void rule__TerminalExpr__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5271:1: ( rule__TerminalExpr__Group_4__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5272:2: rule__TerminalExpr__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_4__1__Impl_in_rule__TerminalExpr__Group_4__110723);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5278:1: rule__TerminalExpr__Group_4__1__Impl : ( '#N' ) ;
    public final void rule__TerminalExpr__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5282:1: ( ( '#N' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5283:1: ( '#N' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5283:1: ( '#N' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5284:1: '#N'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getNKeyword_4_1()); 
            }
            match(input,52,FOLLOW_52_in_rule__TerminalExpr__Group_4__1__Impl10751); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5301:1: rule__TerminalExpr__Group_5__0 : rule__TerminalExpr__Group_5__0__Impl rule__TerminalExpr__Group_5__1 ;
    public final void rule__TerminalExpr__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5305:1: ( rule__TerminalExpr__Group_5__0__Impl rule__TerminalExpr__Group_5__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5306:2: rule__TerminalExpr__Group_5__0__Impl rule__TerminalExpr__Group_5__1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_5__0__Impl_in_rule__TerminalExpr__Group_5__010786);
            rule__TerminalExpr__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_5__1_in_rule__TerminalExpr__Group_5__010789);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5313:1: rule__TerminalExpr__Group_5__0__Impl : ( () ) ;
    public final void rule__TerminalExpr__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5317:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5318:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5318:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5319:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getUnaryExprAction_5_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5320:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5322:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5332:1: rule__TerminalExpr__Group_5__1 : rule__TerminalExpr__Group_5__1__Impl rule__TerminalExpr__Group_5__2 ;
    public final void rule__TerminalExpr__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5336:1: ( rule__TerminalExpr__Group_5__1__Impl rule__TerminalExpr__Group_5__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5337:2: rule__TerminalExpr__Group_5__1__Impl rule__TerminalExpr__Group_5__2
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_5__1__Impl_in_rule__TerminalExpr__Group_5__110847);
            rule__TerminalExpr__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_5__2_in_rule__TerminalExpr__Group_5__110850);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5344:1: rule__TerminalExpr__Group_5__1__Impl : ( ( rule__TerminalExpr__OperatorAssignment_5_1 ) ) ;
    public final void rule__TerminalExpr__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5348:1: ( ( ( rule__TerminalExpr__OperatorAssignment_5_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5349:1: ( ( rule__TerminalExpr__OperatorAssignment_5_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5349:1: ( ( rule__TerminalExpr__OperatorAssignment_5_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5350:1: ( rule__TerminalExpr__OperatorAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getOperatorAssignment_5_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5351:1: ( rule__TerminalExpr__OperatorAssignment_5_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5351:2: rule__TerminalExpr__OperatorAssignment_5_1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__OperatorAssignment_5_1_in_rule__TerminalExpr__Group_5__1__Impl10877);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5361:1: rule__TerminalExpr__Group_5__2 : rule__TerminalExpr__Group_5__2__Impl ;
    public final void rule__TerminalExpr__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5365:1: ( rule__TerminalExpr__Group_5__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5366:2: rule__TerminalExpr__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_5__2__Impl_in_rule__TerminalExpr__Group_5__210907);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5372:1: rule__TerminalExpr__Group_5__2__Impl : ( ( rule__TerminalExpr__OperandAssignment_5_2 ) ) ;
    public final void rule__TerminalExpr__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5376:1: ( ( ( rule__TerminalExpr__OperandAssignment_5_2 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5377:1: ( ( rule__TerminalExpr__OperandAssignment_5_2 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5377:1: ( ( rule__TerminalExpr__OperandAssignment_5_2 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5378:1: ( rule__TerminalExpr__OperandAssignment_5_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getOperandAssignment_5_2()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5379:1: ( rule__TerminalExpr__OperandAssignment_5_2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5379:2: rule__TerminalExpr__OperandAssignment_5_2
            {
            pushFollow(FOLLOW_rule__TerminalExpr__OperandAssignment_5_2_in_rule__TerminalExpr__Group_5__2__Impl10934);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5395:1: rule__TerminalExpr__Group_6__0 : rule__TerminalExpr__Group_6__0__Impl rule__TerminalExpr__Group_6__1 ;
    public final void rule__TerminalExpr__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5399:1: ( rule__TerminalExpr__Group_6__0__Impl rule__TerminalExpr__Group_6__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5400:2: rule__TerminalExpr__Group_6__0__Impl rule__TerminalExpr__Group_6__1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__0__Impl_in_rule__TerminalExpr__Group_6__010970);
            rule__TerminalExpr__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__1_in_rule__TerminalExpr__Group_6__010973);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5407:1: rule__TerminalExpr__Group_6__0__Impl : ( () ) ;
    public final void rule__TerminalExpr__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5411:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5412:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5412:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5413:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getBuiltInExprAction_6_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5414:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5416:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5426:1: rule__TerminalExpr__Group_6__1 : rule__TerminalExpr__Group_6__1__Impl rule__TerminalExpr__Group_6__2 ;
    public final void rule__TerminalExpr__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5430:1: ( rule__TerminalExpr__Group_6__1__Impl rule__TerminalExpr__Group_6__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5431:2: rule__TerminalExpr__Group_6__1__Impl rule__TerminalExpr__Group_6__2
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__1__Impl_in_rule__TerminalExpr__Group_6__111031);
            rule__TerminalExpr__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__2_in_rule__TerminalExpr__Group_6__111034);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5438:1: rule__TerminalExpr__Group_6__1__Impl : ( ( rule__TerminalExpr__FunctionAssignment_6_1 ) ) ;
    public final void rule__TerminalExpr__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5442:1: ( ( ( rule__TerminalExpr__FunctionAssignment_6_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5443:1: ( ( rule__TerminalExpr__FunctionAssignment_6_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5443:1: ( ( rule__TerminalExpr__FunctionAssignment_6_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5444:1: ( rule__TerminalExpr__FunctionAssignment_6_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getFunctionAssignment_6_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5445:1: ( rule__TerminalExpr__FunctionAssignment_6_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5445:2: rule__TerminalExpr__FunctionAssignment_6_1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__FunctionAssignment_6_1_in_rule__TerminalExpr__Group_6__1__Impl11061);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5455:1: rule__TerminalExpr__Group_6__2 : rule__TerminalExpr__Group_6__2__Impl rule__TerminalExpr__Group_6__3 ;
    public final void rule__TerminalExpr__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5459:1: ( rule__TerminalExpr__Group_6__2__Impl rule__TerminalExpr__Group_6__3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5460:2: rule__TerminalExpr__Group_6__2__Impl rule__TerminalExpr__Group_6__3
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__2__Impl_in_rule__TerminalExpr__Group_6__211091);
            rule__TerminalExpr__Group_6__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__3_in_rule__TerminalExpr__Group_6__211094);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5467:1: rule__TerminalExpr__Group_6__2__Impl : ( '(' ) ;
    public final void rule__TerminalExpr__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5471:1: ( ( '(' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5472:1: ( '(' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5472:1: ( '(' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5473:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getLeftParenthesisKeyword_6_2()); 
            }
            match(input,56,FOLLOW_56_in_rule__TerminalExpr__Group_6__2__Impl11122); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5486:1: rule__TerminalExpr__Group_6__3 : rule__TerminalExpr__Group_6__3__Impl rule__TerminalExpr__Group_6__4 ;
    public final void rule__TerminalExpr__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5490:1: ( rule__TerminalExpr__Group_6__3__Impl rule__TerminalExpr__Group_6__4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5491:2: rule__TerminalExpr__Group_6__3__Impl rule__TerminalExpr__Group_6__4
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__3__Impl_in_rule__TerminalExpr__Group_6__311153);
            rule__TerminalExpr__Group_6__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__4_in_rule__TerminalExpr__Group_6__311156);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5498:1: rule__TerminalExpr__Group_6__3__Impl : ( ( rule__TerminalExpr__FirstArgAssignment_6_3 ) ) ;
    public final void rule__TerminalExpr__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5502:1: ( ( ( rule__TerminalExpr__FirstArgAssignment_6_3 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5503:1: ( ( rule__TerminalExpr__FirstArgAssignment_6_3 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5503:1: ( ( rule__TerminalExpr__FirstArgAssignment_6_3 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5504:1: ( rule__TerminalExpr__FirstArgAssignment_6_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getFirstArgAssignment_6_3()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5505:1: ( rule__TerminalExpr__FirstArgAssignment_6_3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5505:2: rule__TerminalExpr__FirstArgAssignment_6_3
            {
            pushFollow(FOLLOW_rule__TerminalExpr__FirstArgAssignment_6_3_in_rule__TerminalExpr__Group_6__3__Impl11183);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5515:1: rule__TerminalExpr__Group_6__4 : rule__TerminalExpr__Group_6__4__Impl rule__TerminalExpr__Group_6__5 ;
    public final void rule__TerminalExpr__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5519:1: ( rule__TerminalExpr__Group_6__4__Impl rule__TerminalExpr__Group_6__5 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5520:2: rule__TerminalExpr__Group_6__4__Impl rule__TerminalExpr__Group_6__5
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__4__Impl_in_rule__TerminalExpr__Group_6__411213);
            rule__TerminalExpr__Group_6__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__5_in_rule__TerminalExpr__Group_6__411216);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5527:1: rule__TerminalExpr__Group_6__4__Impl : ( ',' ) ;
    public final void rule__TerminalExpr__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5531:1: ( ( ',' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5532:1: ( ',' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5532:1: ( ',' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5533:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getCommaKeyword_6_4()); 
            }
            match(input,58,FOLLOW_58_in_rule__TerminalExpr__Group_6__4__Impl11244); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5546:1: rule__TerminalExpr__Group_6__5 : rule__TerminalExpr__Group_6__5__Impl rule__TerminalExpr__Group_6__6 ;
    public final void rule__TerminalExpr__Group_6__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5550:1: ( rule__TerminalExpr__Group_6__5__Impl rule__TerminalExpr__Group_6__6 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5551:2: rule__TerminalExpr__Group_6__5__Impl rule__TerminalExpr__Group_6__6
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__5__Impl_in_rule__TerminalExpr__Group_6__511275);
            rule__TerminalExpr__Group_6__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__6_in_rule__TerminalExpr__Group_6__511278);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5558:1: rule__TerminalExpr__Group_6__5__Impl : ( ( rule__TerminalExpr__SecondArgAssignment_6_5 ) ) ;
    public final void rule__TerminalExpr__Group_6__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5562:1: ( ( ( rule__TerminalExpr__SecondArgAssignment_6_5 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5563:1: ( ( rule__TerminalExpr__SecondArgAssignment_6_5 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5563:1: ( ( rule__TerminalExpr__SecondArgAssignment_6_5 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5564:1: ( rule__TerminalExpr__SecondArgAssignment_6_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getSecondArgAssignment_6_5()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5565:1: ( rule__TerminalExpr__SecondArgAssignment_6_5 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5565:2: rule__TerminalExpr__SecondArgAssignment_6_5
            {
            pushFollow(FOLLOW_rule__TerminalExpr__SecondArgAssignment_6_5_in_rule__TerminalExpr__Group_6__5__Impl11305);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5575:1: rule__TerminalExpr__Group_6__6 : rule__TerminalExpr__Group_6__6__Impl ;
    public final void rule__TerminalExpr__Group_6__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5579:1: ( rule__TerminalExpr__Group_6__6__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5580:2: rule__TerminalExpr__Group_6__6__Impl
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_6__6__Impl_in_rule__TerminalExpr__Group_6__611335);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5586:1: rule__TerminalExpr__Group_6__6__Impl : ( ')' ) ;
    public final void rule__TerminalExpr__Group_6__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5590:1: ( ( ')' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5591:1: ( ')' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5591:1: ( ')' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5592:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getRightParenthesisKeyword_6_6()); 
            }
            match(input,57,FOLLOW_57_in_rule__TerminalExpr__Group_6__6__Impl11363); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5619:1: rule__TerminalExpr__Group_8__0 : rule__TerminalExpr__Group_8__0__Impl rule__TerminalExpr__Group_8__1 ;
    public final void rule__TerminalExpr__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5623:1: ( rule__TerminalExpr__Group_8__0__Impl rule__TerminalExpr__Group_8__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5624:2: rule__TerminalExpr__Group_8__0__Impl rule__TerminalExpr__Group_8__1
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_8__0__Impl_in_rule__TerminalExpr__Group_8__011408);
            rule__TerminalExpr__Group_8__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_8__1_in_rule__TerminalExpr__Group_8__011411);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5631:1: rule__TerminalExpr__Group_8__0__Impl : ( '(' ) ;
    public final void rule__TerminalExpr__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5635:1: ( ( '(' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5636:1: ( '(' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5636:1: ( '(' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5637:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getLeftParenthesisKeyword_8_0()); 
            }
            match(input,56,FOLLOW_56_in_rule__TerminalExpr__Group_8__0__Impl11439); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5650:1: rule__TerminalExpr__Group_8__1 : rule__TerminalExpr__Group_8__1__Impl rule__TerminalExpr__Group_8__2 ;
    public final void rule__TerminalExpr__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5654:1: ( rule__TerminalExpr__Group_8__1__Impl rule__TerminalExpr__Group_8__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5655:2: rule__TerminalExpr__Group_8__1__Impl rule__TerminalExpr__Group_8__2
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_8__1__Impl_in_rule__TerminalExpr__Group_8__111470);
            rule__TerminalExpr__Group_8__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TerminalExpr__Group_8__2_in_rule__TerminalExpr__Group_8__111473);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5662:1: rule__TerminalExpr__Group_8__1__Impl : ( ruleExpr ) ;
    public final void rule__TerminalExpr__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5666:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5667:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5667:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5668:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getExprParserRuleCall_8_1()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__TerminalExpr__Group_8__1__Impl11500);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5679:1: rule__TerminalExpr__Group_8__2 : rule__TerminalExpr__Group_8__2__Impl ;
    public final void rule__TerminalExpr__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5683:1: ( rule__TerminalExpr__Group_8__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5684:2: rule__TerminalExpr__Group_8__2__Impl
            {
            pushFollow(FOLLOW_rule__TerminalExpr__Group_8__2__Impl_in_rule__TerminalExpr__Group_8__211529);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5690:1: rule__TerminalExpr__Group_8__2__Impl : ( ')' ) ;
    public final void rule__TerminalExpr__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5694:1: ( ( ')' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5695:1: ( ')' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5695:1: ( ')' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5696:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getRightParenthesisKeyword_8_2()); 
            }
            match(input,57,FOLLOW_57_in_rule__TerminalExpr__Group_8__2__Impl11557); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5715:1: rule__CallExpr__Group__0 : rule__CallExpr__Group__0__Impl rule__CallExpr__Group__1 ;
    public final void rule__CallExpr__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5719:1: ( rule__CallExpr__Group__0__Impl rule__CallExpr__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5720:2: rule__CallExpr__Group__0__Impl rule__CallExpr__Group__1
            {
            pushFollow(FOLLOW_rule__CallExpr__Group__0__Impl_in_rule__CallExpr__Group__011594);
            rule__CallExpr__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CallExpr__Group__1_in_rule__CallExpr__Group__011597);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5727:1: rule__CallExpr__Group__0__Impl : ( ( rule__CallExpr__Group_0__0 )? ) ;
    public final void rule__CallExpr__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5731:1: ( ( ( rule__CallExpr__Group_0__0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5732:1: ( ( rule__CallExpr__Group_0__0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5732:1: ( ( rule__CallExpr__Group_0__0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5733:1: ( rule__CallExpr__Group_0__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getGroup_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5734:1: ( rule__CallExpr__Group_0__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_TIDENTIFIER) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==61) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5734:2: rule__CallExpr__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__CallExpr__Group_0__0_in_rule__CallExpr__Group__0__Impl11624);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5744:1: rule__CallExpr__Group__1 : rule__CallExpr__Group__1__Impl rule__CallExpr__Group__2 ;
    public final void rule__CallExpr__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5748:1: ( rule__CallExpr__Group__1__Impl rule__CallExpr__Group__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5749:2: rule__CallExpr__Group__1__Impl rule__CallExpr__Group__2
            {
            pushFollow(FOLLOW_rule__CallExpr__Group__1__Impl_in_rule__CallExpr__Group__111655);
            rule__CallExpr__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CallExpr__Group__2_in_rule__CallExpr__Group__111658);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5756:1: rule__CallExpr__Group__1__Impl : ( ( rule__CallExpr__NameAssignment_1 ) ) ;
    public final void rule__CallExpr__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5760:1: ( ( ( rule__CallExpr__NameAssignment_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5761:1: ( ( rule__CallExpr__NameAssignment_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5761:1: ( ( rule__CallExpr__NameAssignment_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5762:1: ( rule__CallExpr__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getNameAssignment_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5763:1: ( rule__CallExpr__NameAssignment_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5763:2: rule__CallExpr__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__CallExpr__NameAssignment_1_in_rule__CallExpr__Group__1__Impl11685);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5773:1: rule__CallExpr__Group__2 : rule__CallExpr__Group__2__Impl rule__CallExpr__Group__3 ;
    public final void rule__CallExpr__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5777:1: ( rule__CallExpr__Group__2__Impl rule__CallExpr__Group__3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5778:2: rule__CallExpr__Group__2__Impl rule__CallExpr__Group__3
            {
            pushFollow(FOLLOW_rule__CallExpr__Group__2__Impl_in_rule__CallExpr__Group__211715);
            rule__CallExpr__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CallExpr__Group__3_in_rule__CallExpr__Group__211718);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5785:1: rule__CallExpr__Group__2__Impl : ( '(' ) ;
    public final void rule__CallExpr__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5789:1: ( ( '(' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5790:1: ( '(' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5790:1: ( '(' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5791:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,56,FOLLOW_56_in_rule__CallExpr__Group__2__Impl11746); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5804:1: rule__CallExpr__Group__3 : rule__CallExpr__Group__3__Impl rule__CallExpr__Group__4 ;
    public final void rule__CallExpr__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5808:1: ( rule__CallExpr__Group__3__Impl rule__CallExpr__Group__4 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5809:2: rule__CallExpr__Group__3__Impl rule__CallExpr__Group__4
            {
            pushFollow(FOLLOW_rule__CallExpr__Group__3__Impl_in_rule__CallExpr__Group__311777);
            rule__CallExpr__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CallExpr__Group__4_in_rule__CallExpr__Group__311780);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5816:1: rule__CallExpr__Group__3__Impl : ( ( rule__CallExpr__ArgListAssignment_3 ) ) ;
    public final void rule__CallExpr__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5820:1: ( ( ( rule__CallExpr__ArgListAssignment_3 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5821:1: ( ( rule__CallExpr__ArgListAssignment_3 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5821:1: ( ( rule__CallExpr__ArgListAssignment_3 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5822:1: ( rule__CallExpr__ArgListAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getArgListAssignment_3()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5823:1: ( rule__CallExpr__ArgListAssignment_3 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5823:2: rule__CallExpr__ArgListAssignment_3
            {
            pushFollow(FOLLOW_rule__CallExpr__ArgListAssignment_3_in_rule__CallExpr__Group__3__Impl11807);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5833:1: rule__CallExpr__Group__4 : rule__CallExpr__Group__4__Impl rule__CallExpr__Group__5 ;
    public final void rule__CallExpr__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5837:1: ( rule__CallExpr__Group__4__Impl rule__CallExpr__Group__5 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5838:2: rule__CallExpr__Group__4__Impl rule__CallExpr__Group__5
            {
            pushFollow(FOLLOW_rule__CallExpr__Group__4__Impl_in_rule__CallExpr__Group__411837);
            rule__CallExpr__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CallExpr__Group__5_in_rule__CallExpr__Group__411840);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5845:1: rule__CallExpr__Group__4__Impl : ( ')' ) ;
    public final void rule__CallExpr__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5849:1: ( ( ')' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5850:1: ( ')' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5850:1: ( ')' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5851:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,57,FOLLOW_57_in_rule__CallExpr__Group__4__Impl11868); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5864:1: rule__CallExpr__Group__5 : rule__CallExpr__Group__5__Impl ;
    public final void rule__CallExpr__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5868:1: ( rule__CallExpr__Group__5__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5869:2: rule__CallExpr__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__CallExpr__Group__5__Impl_in_rule__CallExpr__Group__511899);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5875:1: rule__CallExpr__Group__5__Impl : ( ( rule__CallExpr__Group_5__0 )? ) ;
    public final void rule__CallExpr__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5879:1: ( ( ( rule__CallExpr__Group_5__0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5880:1: ( ( rule__CallExpr__Group_5__0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5880:1: ( ( rule__CallExpr__Group_5__0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5881:1: ( rule__CallExpr__Group_5__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getGroup_5()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5882:1: ( rule__CallExpr__Group_5__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==59) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5882:2: rule__CallExpr__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__CallExpr__Group_5__0_in_rule__CallExpr__Group__5__Impl11926);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5904:1: rule__CallExpr__Group_0__0 : rule__CallExpr__Group_0__0__Impl rule__CallExpr__Group_0__1 ;
    public final void rule__CallExpr__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5908:1: ( rule__CallExpr__Group_0__0__Impl rule__CallExpr__Group_0__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5909:2: rule__CallExpr__Group_0__0__Impl rule__CallExpr__Group_0__1
            {
            pushFollow(FOLLOW_rule__CallExpr__Group_0__0__Impl_in_rule__CallExpr__Group_0__011969);
            rule__CallExpr__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CallExpr__Group_0__1_in_rule__CallExpr__Group_0__011972);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5916:1: rule__CallExpr__Group_0__0__Impl : ( ( rule__CallExpr__NamespaceAssignment_0_0 ) ) ;
    public final void rule__CallExpr__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5920:1: ( ( ( rule__CallExpr__NamespaceAssignment_0_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5921:1: ( ( rule__CallExpr__NamespaceAssignment_0_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5921:1: ( ( rule__CallExpr__NamespaceAssignment_0_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5922:1: ( rule__CallExpr__NamespaceAssignment_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getNamespaceAssignment_0_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5923:1: ( rule__CallExpr__NamespaceAssignment_0_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5923:2: rule__CallExpr__NamespaceAssignment_0_0
            {
            pushFollow(FOLLOW_rule__CallExpr__NamespaceAssignment_0_0_in_rule__CallExpr__Group_0__0__Impl11999);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5933:1: rule__CallExpr__Group_0__1 : rule__CallExpr__Group_0__1__Impl ;
    public final void rule__CallExpr__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5937:1: ( rule__CallExpr__Group_0__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5938:2: rule__CallExpr__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__CallExpr__Group_0__1__Impl_in_rule__CallExpr__Group_0__112029);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5944:1: rule__CallExpr__Group_0__1__Impl : ( '::' ) ;
    public final void rule__CallExpr__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5948:1: ( ( '::' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5949:1: ( '::' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5949:1: ( '::' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5950:1: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getColonColonKeyword_0_1()); 
            }
            match(input,61,FOLLOW_61_in_rule__CallExpr__Group_0__1__Impl12057); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5967:1: rule__CallExpr__Group_5__0 : rule__CallExpr__Group_5__0__Impl rule__CallExpr__Group_5__1 ;
    public final void rule__CallExpr__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5971:1: ( rule__CallExpr__Group_5__0__Impl rule__CallExpr__Group_5__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5972:2: rule__CallExpr__Group_5__0__Impl rule__CallExpr__Group_5__1
            {
            pushFollow(FOLLOW_rule__CallExpr__Group_5__0__Impl_in_rule__CallExpr__Group_5__012092);
            rule__CallExpr__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__CallExpr__Group_5__1_in_rule__CallExpr__Group_5__012095);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5979:1: rule__CallExpr__Group_5__0__Impl : ( '@' ) ;
    public final void rule__CallExpr__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5983:1: ( ( '@' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5984:1: ( '@' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5984:1: ( '@' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5985:1: '@'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getCommercialAtKeyword_5_0()); 
            }
            match(input,59,FOLLOW_59_in_rule__CallExpr__Group_5__0__Impl12123); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:5998:1: rule__CallExpr__Group_5__1 : rule__CallExpr__Group_5__1__Impl ;
    public final void rule__CallExpr__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6002:1: ( rule__CallExpr__Group_5__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6003:2: rule__CallExpr__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__CallExpr__Group_5__1__Impl_in_rule__CallExpr__Group_5__112154);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6009:1: rule__CallExpr__Group_5__1__Impl : ( ( rule__CallExpr__AtAssignment_5_1 ) ) ;
    public final void rule__CallExpr__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6013:1: ( ( ( rule__CallExpr__AtAssignment_5_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6014:1: ( ( rule__CallExpr__AtAssignment_5_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6014:1: ( ( rule__CallExpr__AtAssignment_5_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6015:1: ( rule__CallExpr__AtAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getAtAssignment_5_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6016:1: ( rule__CallExpr__AtAssignment_5_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6016:2: rule__CallExpr__AtAssignment_5_1
            {
            pushFollow(FOLLOW_rule__CallExpr__AtAssignment_5_1_in_rule__CallExpr__Group_5__1__Impl12181);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6030:1: rule__ArgList__Group__0 : rule__ArgList__Group__0__Impl rule__ArgList__Group__1 ;
    public final void rule__ArgList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6034:1: ( rule__ArgList__Group__0__Impl rule__ArgList__Group__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6035:2: rule__ArgList__Group__0__Impl rule__ArgList__Group__1
            {
            pushFollow(FOLLOW_rule__ArgList__Group__0__Impl_in_rule__ArgList__Group__012215);
            rule__ArgList__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ArgList__Group__1_in_rule__ArgList__Group__012218);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6042:1: rule__ArgList__Group__0__Impl : ( () ) ;
    public final void rule__ArgList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6046:1: ( ( () ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6047:1: ( () )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6047:1: ( () )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6048:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getArgListAction_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6049:1: ()
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6051:1: 
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6061:1: rule__ArgList__Group__1 : rule__ArgList__Group__1__Impl ;
    public final void rule__ArgList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6065:1: ( rule__ArgList__Group__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6066:2: rule__ArgList__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ArgList__Group__1__Impl_in_rule__ArgList__Group__112276);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6072:1: rule__ArgList__Group__1__Impl : ( ( rule__ArgList__Group_1__0 )? ) ;
    public final void rule__ArgList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6076:1: ( ( ( rule__ArgList__Group_1__0 )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6077:1: ( ( rule__ArgList__Group_1__0 )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6077:1: ( ( rule__ArgList__Group_1__0 )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6078:1: ( rule__ArgList__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getGroup_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6079:1: ( rule__ArgList__Group_1__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_INT && LA46_0<=RULE_TIDENTIFIER)||(LA46_0>=19 && LA46_0<=20)||(LA46_0>=29 && LA46_0<=35)||(LA46_0>=47 && LA46_0<=48)||LA46_0==52||LA46_0==56||LA46_0==60) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6079:2: rule__ArgList__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ArgList__Group_1__0_in_rule__ArgList__Group__1__Impl12303);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6093:1: rule__ArgList__Group_1__0 : rule__ArgList__Group_1__0__Impl rule__ArgList__Group_1__1 ;
    public final void rule__ArgList__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6097:1: ( rule__ArgList__Group_1__0__Impl rule__ArgList__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6098:2: rule__ArgList__Group_1__0__Impl rule__ArgList__Group_1__1
            {
            pushFollow(FOLLOW_rule__ArgList__Group_1__0__Impl_in_rule__ArgList__Group_1__012338);
            rule__ArgList__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ArgList__Group_1__1_in_rule__ArgList__Group_1__012341);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6105:1: rule__ArgList__Group_1__0__Impl : ( ( rule__ArgList__ArgsAssignment_1_0 ) ) ;
    public final void rule__ArgList__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6109:1: ( ( ( rule__ArgList__ArgsAssignment_1_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6110:1: ( ( rule__ArgList__ArgsAssignment_1_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6110:1: ( ( rule__ArgList__ArgsAssignment_1_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6111:1: ( rule__ArgList__ArgsAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getArgsAssignment_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6112:1: ( rule__ArgList__ArgsAssignment_1_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6112:2: rule__ArgList__ArgsAssignment_1_0
            {
            pushFollow(FOLLOW_rule__ArgList__ArgsAssignment_1_0_in_rule__ArgList__Group_1__0__Impl12368);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6122:1: rule__ArgList__Group_1__1 : rule__ArgList__Group_1__1__Impl ;
    public final void rule__ArgList__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6126:1: ( rule__ArgList__Group_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6127:2: rule__ArgList__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ArgList__Group_1__1__Impl_in_rule__ArgList__Group_1__112398);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6133:1: rule__ArgList__Group_1__1__Impl : ( ( rule__ArgList__Group_1_1__0 )* ) ;
    public final void rule__ArgList__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6137:1: ( ( ( rule__ArgList__Group_1_1__0 )* ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6138:1: ( ( rule__ArgList__Group_1_1__0 )* )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6138:1: ( ( rule__ArgList__Group_1_1__0 )* )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6139:1: ( rule__ArgList__Group_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getGroup_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6140:1: ( rule__ArgList__Group_1_1__0 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==58) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6140:2: rule__ArgList__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ArgList__Group_1_1__0_in_rule__ArgList__Group_1__1__Impl12425);
            	    rule__ArgList__Group_1_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop47;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6154:1: rule__ArgList__Group_1_1__0 : rule__ArgList__Group_1_1__0__Impl rule__ArgList__Group_1_1__1 ;
    public final void rule__ArgList__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6158:1: ( rule__ArgList__Group_1_1__0__Impl rule__ArgList__Group_1_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6159:2: rule__ArgList__Group_1_1__0__Impl rule__ArgList__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__ArgList__Group_1_1__0__Impl_in_rule__ArgList__Group_1_1__012460);
            rule__ArgList__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ArgList__Group_1_1__1_in_rule__ArgList__Group_1_1__012463);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6166:1: rule__ArgList__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__ArgList__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6170:1: ( ( ',' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6171:1: ( ',' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6171:1: ( ',' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6172:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getCommaKeyword_1_1_0()); 
            }
            match(input,58,FOLLOW_58_in_rule__ArgList__Group_1_1__0__Impl12491); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6185:1: rule__ArgList__Group_1_1__1 : rule__ArgList__Group_1_1__1__Impl ;
    public final void rule__ArgList__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6189:1: ( rule__ArgList__Group_1_1__1__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6190:2: rule__ArgList__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ArgList__Group_1_1__1__Impl_in_rule__ArgList__Group_1_1__112522);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6196:1: rule__ArgList__Group_1_1__1__Impl : ( ( rule__ArgList__ArgsAssignment_1_1_1 ) ) ;
    public final void rule__ArgList__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6200:1: ( ( ( rule__ArgList__ArgsAssignment_1_1_1 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6201:1: ( ( rule__ArgList__ArgsAssignment_1_1_1 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6201:1: ( ( rule__ArgList__ArgsAssignment_1_1_1 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6202:1: ( rule__ArgList__ArgsAssignment_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getArgsAssignment_1_1_1()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6203:1: ( rule__ArgList__ArgsAssignment_1_1_1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6203:2: rule__ArgList__ArgsAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__ArgList__ArgsAssignment_1_1_1_in_rule__ArgList__Group_1_1__1__Impl12549);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6217:1: rule__Double__Group_1__0 : rule__Double__Group_1__0__Impl rule__Double__Group_1__1 ;
    public final void rule__Double__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6221:1: ( rule__Double__Group_1__0__Impl rule__Double__Group_1__1 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6222:2: rule__Double__Group_1__0__Impl rule__Double__Group_1__1
            {
            pushFollow(FOLLOW_rule__Double__Group_1__0__Impl_in_rule__Double__Group_1__012583);
            rule__Double__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Double__Group_1__1_in_rule__Double__Group_1__012586);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6229:1: rule__Double__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__Double__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6233:1: ( ( RULE_INT ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6234:1: ( RULE_INT )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6234:1: ( RULE_INT )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6235:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Double__Group_1__0__Impl12613); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6246:1: rule__Double__Group_1__1 : rule__Double__Group_1__1__Impl rule__Double__Group_1__2 ;
    public final void rule__Double__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6250:1: ( rule__Double__Group_1__1__Impl rule__Double__Group_1__2 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6251:2: rule__Double__Group_1__1__Impl rule__Double__Group_1__2
            {
            pushFollow(FOLLOW_rule__Double__Group_1__1__Impl_in_rule__Double__Group_1__112642);
            rule__Double__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Double__Group_1__2_in_rule__Double__Group_1__112645);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6258:1: rule__Double__Group_1__1__Impl : ( '.' ) ;
    public final void rule__Double__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6262:1: ( ( '.' ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6263:1: ( '.' )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6263:1: ( '.' )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6264:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleAccess().getFullStopKeyword_1_1()); 
            }
            match(input,62,FOLLOW_62_in_rule__Double__Group_1__1__Impl12673); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6277:1: rule__Double__Group_1__2 : rule__Double__Group_1__2__Impl ;
    public final void rule__Double__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6281:1: ( rule__Double__Group_1__2__Impl )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6282:2: rule__Double__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Double__Group_1__2__Impl_in_rule__Double__Group_1__212704);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6288:1: rule__Double__Group_1__2__Impl : ( ( RULE_INT )? ) ;
    public final void rule__Double__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6292:1: ( ( ( RULE_INT )? ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6293:1: ( ( RULE_INT )? )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6293:1: ( ( RULE_INT )? )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6294:1: ( RULE_INT )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_2()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6295:1: ( RULE_INT )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_INT) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6295:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Double__Group_1__2__Impl12732); if (state.failed) return ;

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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6312:1: rule__Program__ProgramElementsAssignment_1 : ( ruleProgramElement ) ;
    public final void rule__Program__ProgramElementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6316:1: ( ( ruleProgramElement ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6317:1: ( ruleProgramElement )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6317:1: ( ruleProgramElement )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6318:1: ruleProgramElement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProgramAccess().getProgramElementsProgramElementParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleProgramElement_in_rule__Program__ProgramElementsAssignment_112774);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6327:1: rule__DmplSubclause__ProgramAssignment_1 : ( ruleProgram ) ;
    public final void rule__DmplSubclause__ProgramAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6331:1: ( ( ruleProgram ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6332:1: ( ruleProgram )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6332:1: ( ruleProgram )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6333:1: ruleProgram
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDmplSubclauseAccess().getProgramProgramParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleProgram_in_rule__DmplSubclause__ProgramAssignment_112805);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6342:1: rule__Constant__NameAssignment_1 : ( RULE_TIDENTIFIER ) ;
    public final void rule__Constant__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6346:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6347:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6347:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6348:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getNameTIDENTIFIERTerminalRuleCall_1_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__Constant__NameAssignment_112836); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6357:1: rule__Constant__ValueAssignment_3 : ( ruleNumberConst ) ;
    public final void rule__Constant__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6361:1: ( ( ruleNumberConst ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6362:1: ( ruleNumberConst )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6362:1: ( ruleNumberConst )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6363:1: ruleNumberConst
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstantAccess().getValueNumberConstParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleNumberConst_in_rule__Constant__ValueAssignment_312867);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6372:1: rule__IntConst__SignAssignment_0 : ( ruleSign ) ;
    public final void rule__IntConst__SignAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6376:1: ( ( ruleSign ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6377:1: ( ruleSign )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6377:1: ( ruleSign )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6378:1: ruleSign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntConstAccess().getSignSignParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleSign_in_rule__IntConst__SignAssignment_012898);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6387:1: rule__IntConst__ValueAssignment_1 : ( RULE_INT ) ;
    public final void rule__IntConst__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6391:1: ( ( RULE_INT ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6392:1: ( RULE_INT )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6392:1: ( RULE_INT )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6393:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntConstAccess().getValueINTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__IntConst__ValueAssignment_112929); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6402:1: rule__DoubleConst__SignAssignment_0 : ( ruleSign ) ;
    public final void rule__DoubleConst__SignAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6406:1: ( ( ruleSign ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6407:1: ( ruleSign )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6407:1: ( ruleSign )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6408:1: ruleSign
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleConstAccess().getSignSignParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleSign_in_rule__DoubleConst__SignAssignment_012960);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6417:1: rule__DoubleConst__ValueAssignment_1 : ( ruleDouble ) ;
    public final void rule__DoubleConst__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6421:1: ( ( ruleDouble ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6422:1: ( ruleDouble )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6422:1: ( ruleDouble )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6423:1: ruleDouble
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDoubleConstAccess().getValueDoubleParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleDouble_in_rule__DoubleConst__ValueAssignment_112991);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6432:1: rule__VarInit__TypeAssignment_0 : ( ruleType ) ;
    public final void rule__VarInit__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6436:1: ( ( ruleType ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6437:1: ( ruleType )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6437:1: ( ruleType )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6438:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitAccess().getTypeTypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleType_in_rule__VarInit__TypeAssignment_013022);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6447:1: rule__VarInit__VarAsgnListAssignment_1 : ( ruleVarAsgnList ) ;
    public final void rule__VarInit__VarAsgnListAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6451:1: ( ( ruleVarAsgnList ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6452:1: ( ruleVarAsgnList )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6452:1: ( ruleVarAsgnList )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6453:1: ruleVarAsgnList
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitAccess().getVarAsgnListVarAsgnListParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleVarAsgnList_in_rule__VarInit__VarAsgnListAssignment_113053);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6462:1: rule__VarAsgnList__VarAssignment_0 : ( ruleVar ) ;
    public final void rule__VarAsgnList__VarAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6466:1: ( ( ruleVar ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6467:1: ( ruleVar )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6467:1: ( ruleVar )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6468:1: ruleVar
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnListAccess().getVarVarParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleVar_in_rule__VarAsgnList__VarAssignment_013084);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6477:1: rule__VarAsgnList__VarAsgnAssignment_1 : ( ruleVarAsgn ) ;
    public final void rule__VarAsgnList__VarAsgnAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6481:1: ( ( ruleVarAsgn ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6482:1: ( ruleVarAsgn )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6482:1: ( ruleVarAsgn )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6483:1: ruleVarAsgn
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnListAccess().getVarAsgnVarAsgnParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleVarAsgn_in_rule__VarAsgnList__VarAsgnAssignment_113115);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6492:1: rule__VarAsgn__VarAssignment_0 : ( ruleVar ) ;
    public final void rule__VarAsgn__VarAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6496:1: ( ( ruleVar ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6497:1: ( ruleVar )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6497:1: ( ruleVar )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6498:1: ruleVar
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnAccess().getVarVarParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleVar_in_rule__VarAsgn__VarAssignment_013146);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6507:1: rule__VarAsgn__FnBodyAssignment_2_0 : ( ruleFnBody ) ;
    public final void rule__VarAsgn__FnBodyAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6511:1: ( ( ruleFnBody ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6512:1: ( ruleFnBody )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6512:1: ( ruleFnBody )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6513:1: ruleFnBody
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnAccess().getFnBodyFnBodyParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_ruleFnBody_in_rule__VarAsgn__FnBodyAssignment_2_013177);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6522:1: rule__VarAsgn__ExprAssignment_2_1 : ( ruleExpr ) ;
    public final void rule__VarAsgn__ExprAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6526:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6527:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6527:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6528:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAsgnAccess().getExprExprParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__VarAsgn__ExprAssignment_2_113208);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6537:1: rule__Var__NameAssignment_0 : ( RULE_TIDENTIFIER ) ;
    public final void rule__Var__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6541:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6542:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6542:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6543:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAccess().getNameTIDENTIFIERTerminalRuleCall_0_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__Var__NameAssignment_013239); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6552:1: rule__Var__DimensionsAssignment_1_1 : ( ruleDimension ) ;
    public final void rule__Var__DimensionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6556:1: ( ( ruleDimension ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6557:1: ( ruleDimension )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6557:1: ( ruleDimension )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6558:1: ruleDimension
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarAccess().getDimensionsDimensionParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleDimension_in_rule__Var__DimensionsAssignment_1_113270);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6567:1: rule__Dimension__IndexAssignment_0_1 : ( RULE_INT ) ;
    public final void rule__Dimension__IndexAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6571:1: ( ( RULE_INT ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6572:1: ( RULE_INT )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6572:1: ( RULE_INT )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6573:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getIndexINTTerminalRuleCall_0_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Dimension__IndexAssignment_0_113301); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6582:1: rule__Dimension__IndexAssignment_2_1 : ( RULE_TIDENTIFIER ) ;
    public final void rule__Dimension__IndexAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6586:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6587:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6587:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6588:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDimensionAccess().getIndexTIDENTIFIERTerminalRuleCall_2_1_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__Dimension__IndexAssignment_2_113332); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6597:1: rule__Type__SignedAssignment_0 : ( ruleSigned ) ;
    public final void rule__Type__SignedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6601:1: ( ( ruleSigned ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6602:1: ( ruleSigned )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6602:1: ( ruleSigned )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6603:1: ruleSigned
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getSignedSignedParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleSigned_in_rule__Type__SignedAssignment_013363);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6612:1: rule__Type__SimpTypeAssignment_1 : ( ruleSimpType ) ;
    public final void rule__Type__SimpTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6616:1: ( ( ruleSimpType ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6617:1: ( ruleSimpType )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6617:1: ( ruleSimpType )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6618:1: ruleSimpType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAccess().getSimpTypeSimpTypeParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleSimpType_in_rule__Type__SimpTypeAssignment_113394);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6627:1: rule__Procedure__ProcedureAssignment : ( ruleProcNoAttr ) ;
    public final void rule__Procedure__ProcedureAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6631:1: ( ( ruleProcNoAttr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6632:1: ( ruleProcNoAttr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6632:1: ( ruleProcNoAttr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6633:1: ruleProcNoAttr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProcedureAccess().getProcedureProcNoAttrParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleProcNoAttr_in_rule__Procedure__ProcedureAssignment13425);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6642:1: rule__ProcNoAttr__PrototypeAssignment_0 : ( ruleFnPrototype ) ;
    public final void rule__ProcNoAttr__PrototypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6646:1: ( ( ruleFnPrototype ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6647:1: ( ruleFnPrototype )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6647:1: ( ruleFnPrototype )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6648:1: ruleFnPrototype
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProcNoAttrAccess().getPrototypeFnPrototypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleFnPrototype_in_rule__ProcNoAttr__PrototypeAssignment_013456);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6657:1: rule__ProcNoAttr__FnBodyAssignment_1_1 : ( ruleFnBody ) ;
    public final void rule__ProcNoAttr__FnBodyAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6661:1: ( ( ruleFnBody ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6662:1: ( ruleFnBody )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6662:1: ( ruleFnBody )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6663:1: ruleFnBody
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getProcNoAttrAccess().getFnBodyFnBodyParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleFnBody_in_rule__ProcNoAttr__FnBodyAssignment_1_113487);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6672:1: rule__FnBody__VarInitListAssignment_1 : ( ruleVarInitList ) ;
    public final void rule__FnBody__VarInitListAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6676:1: ( ( ruleVarInitList ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6677:1: ( ruleVarInitList )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6677:1: ( ruleVarInitList )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6678:1: ruleVarInitList
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnBodyAccess().getVarInitListVarInitListParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleVarInitList_in_rule__FnBody__VarInitListAssignment_113518);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6687:1: rule__FnPrototype__ExternAssignment_0_1 : ( ( rule__FnPrototype__ExternAlternatives_0_1_0 ) ) ;
    public final void rule__FnPrototype__ExternAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6691:1: ( ( ( rule__FnPrototype__ExternAlternatives_0_1_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6692:1: ( ( rule__FnPrototype__ExternAlternatives_0_1_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6692:1: ( ( rule__FnPrototype__ExternAlternatives_0_1_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6693:1: ( rule__FnPrototype__ExternAlternatives_0_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getExternAlternatives_0_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6694:1: ( rule__FnPrototype__ExternAlternatives_0_1_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6694:2: rule__FnPrototype__ExternAlternatives_0_1_0
            {
            pushFollow(FOLLOW_rule__FnPrototype__ExternAlternatives_0_1_0_in_rule__FnPrototype__ExternAssignment_0_113549);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6703:1: rule__FnPrototype__PureAssignment_0_2 : ( ( rule__FnPrototype__PureAlternatives_0_2_0 ) ) ;
    public final void rule__FnPrototype__PureAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6707:1: ( ( ( rule__FnPrototype__PureAlternatives_0_2_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6708:1: ( ( rule__FnPrototype__PureAlternatives_0_2_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6708:1: ( ( rule__FnPrototype__PureAlternatives_0_2_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6709:1: ( rule__FnPrototype__PureAlternatives_0_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getPureAlternatives_0_2_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6710:1: ( rule__FnPrototype__PureAlternatives_0_2_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6710:2: rule__FnPrototype__PureAlternatives_0_2_0
            {
            pushFollow(FOLLOW_rule__FnPrototype__PureAlternatives_0_2_0_in_rule__FnPrototype__PureAssignment_0_213582);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6719:1: rule__FnPrototype__NameAssignment_0_4 : ( RULE_TIDENTIFIER ) ;
    public final void rule__FnPrototype__NameAssignment_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6723:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6724:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6724:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6725:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getNameTIDENTIFIERTerminalRuleCall_0_4_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__FnPrototype__NameAssignment_0_413615); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6734:1: rule__FnPrototype__ExternAssignment_1_1 : ( ( rule__FnPrototype__ExternAlternatives_1_1_0 ) ) ;
    public final void rule__FnPrototype__ExternAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6738:1: ( ( ( rule__FnPrototype__ExternAlternatives_1_1_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6739:1: ( ( rule__FnPrototype__ExternAlternatives_1_1_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6739:1: ( ( rule__FnPrototype__ExternAlternatives_1_1_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6740:1: ( rule__FnPrototype__ExternAlternatives_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getExternAlternatives_1_1_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6741:1: ( rule__FnPrototype__ExternAlternatives_1_1_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6741:2: rule__FnPrototype__ExternAlternatives_1_1_0
            {
            pushFollow(FOLLOW_rule__FnPrototype__ExternAlternatives_1_1_0_in_rule__FnPrototype__ExternAssignment_1_113646);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6750:1: rule__FnPrototype__PureAssignment_1_2 : ( ( rule__FnPrototype__PureAlternatives_1_2_0 ) ) ;
    public final void rule__FnPrototype__PureAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6754:1: ( ( ( rule__FnPrototype__PureAlternatives_1_2_0 ) ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6755:1: ( ( rule__FnPrototype__PureAlternatives_1_2_0 ) )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6755:1: ( ( rule__FnPrototype__PureAlternatives_1_2_0 ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6756:1: ( rule__FnPrototype__PureAlternatives_1_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getPureAlternatives_1_2_0()); 
            }
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6757:1: ( rule__FnPrototype__PureAlternatives_1_2_0 )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6757:2: rule__FnPrototype__PureAlternatives_1_2_0
            {
            pushFollow(FOLLOW_rule__FnPrototype__PureAlternatives_1_2_0_in_rule__FnPrototype__PureAssignment_1_213679);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6766:1: rule__FnPrototype__TypeAssignment_1_3 : ( ruleType ) ;
    public final void rule__FnPrototype__TypeAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6770:1: ( ( ruleType ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6771:1: ( ruleType )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6771:1: ( ruleType )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6772:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getTypeTypeParserRuleCall_1_3_0()); 
            }
            pushFollow(FOLLOW_ruleType_in_rule__FnPrototype__TypeAssignment_1_313712);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6781:1: rule__FnPrototype__NameAssignment_1_4 : ( RULE_TIDENTIFIER ) ;
    public final void rule__FnPrototype__NameAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6785:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6786:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6786:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6787:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getNameTIDENTIFIERTerminalRuleCall_1_4_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__FnPrototype__NameAssignment_1_413743); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6796:1: rule__FnPrototype__ParamsAssignment_1_6_0 : ( ruleParam ) ;
    public final void rule__FnPrototype__ParamsAssignment_1_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6800:1: ( ( ruleParam ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6801:1: ( ruleParam )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6801:1: ( ruleParam )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6802:1: ruleParam
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getParamsParamParserRuleCall_1_6_0_0()); 
            }
            pushFollow(FOLLOW_ruleParam_in_rule__FnPrototype__ParamsAssignment_1_6_013774);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6811:1: rule__FnPrototype__ParamsAssignment_1_6_1_1 : ( ruleParam ) ;
    public final void rule__FnPrototype__ParamsAssignment_1_6_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6815:1: ( ( ruleParam ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6816:1: ( ruleParam )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6816:1: ( ruleParam )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6817:1: ruleParam
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFnPrototypeAccess().getParamsParamParserRuleCall_1_6_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleParam_in_rule__FnPrototype__ParamsAssignment_1_6_1_113805);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6826:1: rule__Param__TypeAssignment_0 : ( ruleType ) ;
    public final void rule__Param__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6830:1: ( ( ruleType ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6831:1: ( ruleType )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6831:1: ( ruleType )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6832:1: ruleType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAccess().getTypeTypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleType_in_rule__Param__TypeAssignment_013836);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6841:1: rule__Param__VarAssignment_1 : ( ruleVar ) ;
    public final void rule__Param__VarAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6845:1: ( ( ruleVar ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6846:1: ( ruleVar )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6846:1: ( ruleVar )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6847:1: ruleVar
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAccess().getVarVarParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleVar_in_rule__Param__VarAssignment_113867);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6856:1: rule__VarInitList__VarInitsAssignment_1_0 : ( ruleVarInit ) ;
    public final void rule__VarInitList__VarInitsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6860:1: ( ( ruleVarInit ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6861:1: ( ruleVarInit )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6861:1: ( ruleVarInit )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6862:1: ruleVarInit
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVarInitListAccess().getVarInitsVarInitParserRuleCall_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleVarInit_in_rule__VarInitList__VarInitsAssignment_1_013898);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6871:1: rule__LVal__NameAssignment_0 : ( RULE_TIDENTIFIER ) ;
    public final void rule__LVal__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6875:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6876:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6876:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6877:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getNameTIDENTIFIERTerminalRuleCall_0_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__LVal__NameAssignment_013929); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6886:1: rule__LVal__IndicesAssignment_1_1 : ( ruleExpr ) ;
    public final void rule__LVal__IndicesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6890:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6891:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6891:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6892:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getIndicesExprParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__LVal__IndicesAssignment_1_113960);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6901:1: rule__LVal__AtAssignment_2_1 : ( ruleExpr ) ;
    public final void rule__LVal__AtAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6905:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6906:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6906:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6907:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLValAccess().getAtExprParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__LVal__AtAssignment_2_113991);
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


    // $ANTLR start "rule__EqualityExpr__OperatorAssignment_1_0_0_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6916:1: rule__EqualityExpr__OperatorAssignment_1_0_0_1 : ( ruleEqualityOperator ) ;
    public final void rule__EqualityExpr__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6920:1: ( ( ruleEqualityOperator ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6921:1: ( ruleEqualityOperator )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6921:1: ( ruleEqualityOperator )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6922:1: ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExprAccess().getOperatorEqualityOperatorEnumRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_rule__EqualityExpr__OperatorAssignment_1_0_0_114022);
            ruleEqualityOperator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExprAccess().getOperatorEqualityOperatorEnumRuleCall_1_0_0_1_0()); 
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
    // $ANTLR end "rule__EqualityExpr__OperatorAssignment_1_0_0_1"


    // $ANTLR start "rule__EqualityExpr__RightAssignment_1_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6931:1: rule__EqualityExpr__RightAssignment_1_1 : ( ruleCompareExpr ) ;
    public final void rule__EqualityExpr__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6935:1: ( ( ruleCompareExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6936:1: ( ruleCompareExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6936:1: ( ruleCompareExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6937:1: ruleCompareExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExprAccess().getRightCompareExprParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleCompareExpr_in_rule__EqualityExpr__RightAssignment_1_114053);
            ruleCompareExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExprAccess().getRightCompareExprParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__EqualityExpr__RightAssignment_1_1"


    // $ANTLR start "rule__CompareExpr__OperatorAssignment_1_0_0_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6946:1: rule__CompareExpr__OperatorAssignment_1_0_0_1 : ( ruleCompareOperator ) ;
    public final void rule__CompareExpr__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6950:1: ( ( ruleCompareOperator ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6951:1: ( ruleCompareOperator )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6951:1: ( ruleCompareOperator )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6952:1: ruleCompareOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompareExprAccess().getOperatorCompareOperatorEnumRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleCompareOperator_in_rule__CompareExpr__OperatorAssignment_1_0_0_114084);
            ruleCompareOperator();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompareExprAccess().getOperatorCompareOperatorEnumRuleCall_1_0_0_1_0()); 
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
    // $ANTLR end "rule__CompareExpr__OperatorAssignment_1_0_0_1"


    // $ANTLR start "rule__CompareExpr__RightAssignment_1_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6961:1: rule__CompareExpr__RightAssignment_1_1 : ( ruleShiftExpr ) ;
    public final void rule__CompareExpr__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6965:1: ( ( ruleShiftExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6966:1: ( ruleShiftExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6966:1: ( ruleShiftExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6967:1: ruleShiftExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCompareExprAccess().getRightShiftExprParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleShiftExpr_in_rule__CompareExpr__RightAssignment_1_114115);
            ruleShiftExpr();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCompareExprAccess().getRightShiftExprParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__CompareExpr__RightAssignment_1_1"


    // $ANTLR start "rule__ShiftExpr__OperatorAssignment_1_0_0_1"
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6976:1: rule__ShiftExpr__OperatorAssignment_1_0_0_1 : ( ruleShiftOperator ) ;
    public final void rule__ShiftExpr__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6980:1: ( ( ruleShiftOperator ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6981:1: ( ruleShiftOperator )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6981:1: ( ruleShiftOperator )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6982:1: ruleShiftOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getOperatorShiftOperatorEnumRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleShiftOperator_in_rule__ShiftExpr__OperatorAssignment_1_0_0_114146);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6991:1: rule__ShiftExpr__RightAssignment_1_1 : ( ruleAdditiveExpr ) ;
    public final void rule__ShiftExpr__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6995:1: ( ( ruleAdditiveExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6996:1: ( ruleAdditiveExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6996:1: ( ruleAdditiveExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:6997:1: ruleAdditiveExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getShiftExprAccess().getRightAdditiveExprParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpr_in_rule__ShiftExpr__RightAssignment_1_114177);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7006:1: rule__AdditiveExpr__OperatorAssignment_1_0_0_1 : ( ruleAdditiveOperator ) ;
    public final void rule__AdditiveExpr__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7010:1: ( ( ruleAdditiveOperator ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7011:1: ( ruleAdditiveOperator )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7011:1: ( ruleAdditiveOperator )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7012:1: ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getOperatorAdditiveOperatorEnumRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_rule__AdditiveExpr__OperatorAssignment_1_0_0_114208);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7021:1: rule__AdditiveExpr__RightAssignment_1_1 : ( ruleMultiplicativeExpr ) ;
    public final void rule__AdditiveExpr__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7025:1: ( ( ruleMultiplicativeExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7026:1: ( ruleMultiplicativeExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7026:1: ( ruleMultiplicativeExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7027:1: ruleMultiplicativeExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAdditiveExprAccess().getRightMultiplicativeExprParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpr_in_rule__AdditiveExpr__RightAssignment_1_114239);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7036:1: rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1 : ( ruleMultiplicativeOperator ) ;
    public final void rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7040:1: ( ( ruleMultiplicativeOperator ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7041:1: ( ruleMultiplicativeOperator )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7041:1: ( ruleMultiplicativeOperator )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7042:1: ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_rule__MultiplicativeExpr__OperatorAssignment_1_0_0_114270);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7051:1: rule__MultiplicativeExpr__RightAssignment_1_1 : ( ruleTerminalExpr ) ;
    public final void rule__MultiplicativeExpr__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7055:1: ( ( ruleTerminalExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7056:1: ( ruleTerminalExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7056:1: ( ruleTerminalExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7057:1: ruleTerminalExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicativeExprAccess().getRightTerminalExprParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleTerminalExpr_in_rule__MultiplicativeExpr__RightAssignment_1_114301);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7066:1: rule__TerminalExpr__ValueAssignment_2_1 : ( RULE_INT ) ;
    public final void rule__TerminalExpr__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7070:1: ( ( RULE_INT ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7071:1: ( RULE_INT )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7071:1: ( RULE_INT )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7072:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getValueINTTerminalRuleCall_2_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__TerminalExpr__ValueAssignment_2_114332); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7081:1: rule__TerminalExpr__ValueAssignment_3_1 : ( ruleDouble ) ;
    public final void rule__TerminalExpr__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7085:1: ( ( ruleDouble ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7086:1: ( ruleDouble )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7086:1: ( ruleDouble )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7087:1: ruleDouble
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getValueDoubleParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleDouble_in_rule__TerminalExpr__ValueAssignment_3_114363);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7096:1: rule__TerminalExpr__OperatorAssignment_5_1 : ( ruleUnaryOperator ) ;
    public final void rule__TerminalExpr__OperatorAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7100:1: ( ( ruleUnaryOperator ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7101:1: ( ruleUnaryOperator )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7101:1: ( ruleUnaryOperator )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7102:1: ruleUnaryOperator
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getOperatorUnaryOperatorEnumRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_rule__TerminalExpr__OperatorAssignment_5_114394);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7111:1: rule__TerminalExpr__OperandAssignment_5_2 : ( ruleExpr ) ;
    public final void rule__TerminalExpr__OperandAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7115:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7116:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7116:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7117:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getOperandExprParserRuleCall_5_2_0()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__TerminalExpr__OperandAssignment_5_214425);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7126:1: rule__TerminalExpr__FunctionAssignment_6_1 : ( ruleBuiltInFunction ) ;
    public final void rule__TerminalExpr__FunctionAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7130:1: ( ( ruleBuiltInFunction ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7131:1: ( ruleBuiltInFunction )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7131:1: ( ruleBuiltInFunction )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7132:1: ruleBuiltInFunction
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getFunctionBuiltInFunctionParserRuleCall_6_1_0()); 
            }
            pushFollow(FOLLOW_ruleBuiltInFunction_in_rule__TerminalExpr__FunctionAssignment_6_114456);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7141:1: rule__TerminalExpr__FirstArgAssignment_6_3 : ( RULE_TIDENTIFIER ) ;
    public final void rule__TerminalExpr__FirstArgAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7145:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7146:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7146:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7147:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getFirstArgTIDENTIFIERTerminalRuleCall_6_3_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__TerminalExpr__FirstArgAssignment_6_314487); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7156:1: rule__TerminalExpr__SecondArgAssignment_6_5 : ( ruleExpr ) ;
    public final void rule__TerminalExpr__SecondArgAssignment_6_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7160:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7161:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7161:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7162:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTerminalExprAccess().getSecondArgExprParserRuleCall_6_5_0()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__TerminalExpr__SecondArgAssignment_6_514518);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7171:1: rule__CallExpr__NamespaceAssignment_0_0 : ( RULE_TIDENTIFIER ) ;
    public final void rule__CallExpr__NamespaceAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7175:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7176:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7176:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7177:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getNamespaceTIDENTIFIERTerminalRuleCall_0_0_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__CallExpr__NamespaceAssignment_0_014549); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7186:1: rule__CallExpr__NameAssignment_1 : ( RULE_TIDENTIFIER ) ;
    public final void rule__CallExpr__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7190:1: ( ( RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7191:1: ( RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7191:1: ( RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7192:1: RULE_TIDENTIFIER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getNameTIDENTIFIERTerminalRuleCall_1_0()); 
            }
            match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_rule__CallExpr__NameAssignment_114580); if (state.failed) return ;
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7201:1: rule__CallExpr__ArgListAssignment_3 : ( ruleArgList ) ;
    public final void rule__CallExpr__ArgListAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7205:1: ( ( ruleArgList ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7206:1: ( ruleArgList )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7206:1: ( ruleArgList )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7207:1: ruleArgList
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getArgListArgListParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleArgList_in_rule__CallExpr__ArgListAssignment_314611);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7216:1: rule__CallExpr__AtAssignment_5_1 : ( ruleExpr ) ;
    public final void rule__CallExpr__AtAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7220:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7221:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7221:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7222:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExprAccess().getAtExprParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__CallExpr__AtAssignment_5_114642);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7231:1: rule__ArgList__ArgsAssignment_1_0 : ( ruleExpr ) ;
    public final void rule__ArgList__ArgsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7235:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7236:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7236:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7237:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getArgsExprParserRuleCall_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__ArgList__ArgsAssignment_1_014673);
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
    // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7246:1: rule__ArgList__ArgsAssignment_1_1_1 : ( ruleExpr ) ;
    public final void rule__ArgList__ArgsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7250:1: ( ( ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7251:1: ( ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7251:1: ( ruleExpr )
            // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:7252:1: ruleExpr
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArgListAccess().getArgsExprParserRuleCall_1_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_rule__ArgList__ArgsAssignment_1_1_114704);
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

    // $ANTLR start synpred60_InternalDmpl
    public final void synpred60_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4017:2: ( rule__EqualityExpr__Group_1__0 )
        // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4017:2: rule__EqualityExpr__Group_1__0
        {
        pushFollow(FOLLOW_rule__EqualityExpr__Group_1__0_in_synpred60_InternalDmpl8265);
        rule__EqualityExpr__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_InternalDmpl

    // $ANTLR start synpred61_InternalDmpl
    public final void synpred61_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4232:2: ( rule__CompareExpr__Group_1__0 )
        // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4232:2: rule__CompareExpr__Group_1__0
        {
        pushFollow(FOLLOW_rule__CompareExpr__Group_1__0_in_synpred61_InternalDmpl8688);
        rule__CompareExpr__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred61_InternalDmpl

    // $ANTLR start synpred62_InternalDmpl
    public final void synpred62_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4447:2: ( rule__ShiftExpr__Group_1__0 )
        // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4447:2: rule__ShiftExpr__Group_1__0
        {
        pushFollow(FOLLOW_rule__ShiftExpr__Group_1__0_in_synpred62_InternalDmpl9111);
        rule__ShiftExpr__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred62_InternalDmpl

    // $ANTLR start synpred63_InternalDmpl
    public final void synpred63_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4662:2: ( rule__AdditiveExpr__Group_1__0 )
        // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4662:2: rule__AdditiveExpr__Group_1__0
        {
        pushFollow(FOLLOW_rule__AdditiveExpr__Group_1__0_in_synpred63_InternalDmpl9534);
        rule__AdditiveExpr__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred63_InternalDmpl

    // $ANTLR start synpred64_InternalDmpl
    public final void synpred64_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4877:2: ( rule__MultiplicativeExpr__Group_1__0 )
        // ../edu.cmu.sei.annex.dmpl.ui/src-gen/edu/cmu/sei/annex/dmpl/ui/contentassist/antlr/internal/InternalDmpl.g:4877:2: rule__MultiplicativeExpr__Group_1__0
        {
        pushFollow(FOLLOW_rule__MultiplicativeExpr__Group_1__0_in_synpred64_InternalDmpl9957);
        rule__MultiplicativeExpr__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred64_InternalDmpl

    // Delegated rules

    public final boolean synpred64_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred61_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred63_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred63_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred62_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred62_InternalDmpl_fragment(); // can never throw exception
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
        "\1\5\1\16\1\4\2\uffff\3\63\1\16";
    static final String DFA4_maxS =
        "\1\5\1\62\1\64\2\uffff\3\63\1\62";
    static final String DFA4_acceptS =
        "\3\uffff\1\1\1\2\4\uffff";
    static final String DFA4_specialS =
        "\11\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1",
            "\1\3\42\uffff\1\4\1\2",
            "\1\5\1\7\56\uffff\1\6",
            "",
            "",
            "\1\10",
            "\1\10",
            "\1\10",
            "\1\3\42\uffff\1\4\1\2"
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
            return "1207:1: rule__VarAsgnList__Alternatives : ( ( ( rule__VarAsgnList__VarAssignment_0 ) ) | ( ( rule__VarAsgnList__VarAsgnAssignment_1 ) ) );";
        }
    }
    static final String DFA13_eotS =
        "\14\uffff";
    static final String DFA13_eofS =
        "\1\uffff\1\12\1\uffff\1\13\10\uffff";
    static final String DFA13_minS =
        "\1\4\1\16\1\uffff\1\16\10\uffff";
    static final String DFA13_maxS =
        "\1\74\1\75\1\uffff\1\76\10\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\5\1\6\1\7\1\11\1\10\1\1\1\3";
    static final String DFA13_specialS =
        "\14\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\3\1\1\15\uffff\2\6\10\uffff\6\7\1\4\13\uffff\2\6\3\uffff\1\5\3\uffff\1\10\3\uffff\1\2",
            "\1\12\4\uffff\2\12\17\uffff\13\12\3\uffff\2\12\4\uffff\1\11\3\12\1\uffff\1\11",
            "",
            "\1\13\4\uffff\2\13\17\uffff\13\13\4\uffff\1\13\5\uffff\2\13\3\uffff\1\4",
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
            return "1429:1: rule__TerminalExpr__Alternatives : ( ( ruleLVal ) | ( ( rule__TerminalExpr__Group_1__0 ) ) | ( ( rule__TerminalExpr__Group_2__0 ) ) | ( ( rule__TerminalExpr__Group_3__0 ) ) | ( ( rule__TerminalExpr__Group_4__0 ) ) | ( ( rule__TerminalExpr__Group_5__0 ) ) | ( ( rule__TerminalExpr__Group_6__0 ) ) | ( ruleCallExpr ) | ( ( rule__TerminalExpr__Group_8__0 ) ) );";
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
    public static final BitSet FOLLOW_ruleEqualityExpr_in_ruleExpr1302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpr_in_entryRuleEqualityExpr1328 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpr1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpr__Group__0_in_ruleEqualityExpr1361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompareExpr_in_entryRuleCompareExpr1388 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompareExpr1395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompareExpr__Group__0_in_ruleCompareExpr1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpr_in_entryRuleShiftExpr1448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShiftExpr1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group__0_in_ruleShiftExpr1481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpr_in_entryRuleAdditiveExpr1508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpr1515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group__0_in_ruleAdditiveExpr1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpr_in_entryRuleMultiplicativeExpr1568 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpr1575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group__0_in_ruleMultiplicativeExpr1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpr_in_entryRuleTerminalExpr1628 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalExpr1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Alternatives_in_ruleTerminalExpr1661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExpr_in_entryRuleCallExpr1688 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallExpr1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__0_in_ruleCallExpr1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgList_in_entryRuleArgList1748 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgList1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group__0_in_ruleArgList1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSign_in_entryRuleSign1808 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSign1815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Sign__Alternatives_in_ruleSign1841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpType_in_entryRuleSimpType1868 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpType1875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpType__Alternatives_in_ruleSimpType1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSigned_in_entryRuleSigned1928 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSigned1935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Signed__Alternatives_in_ruleSigned1961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltInFunction_in_entryRuleBuiltInFunction1988 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBuiltInFunction1995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BuiltInFunction__Alternatives_in_ruleBuiltInFunction2021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDouble_in_entryRuleDouble2048 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDouble2055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Alternatives_in_ruleDouble2081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityOperator__Alternatives_in_ruleEqualityOperator2124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompareOperator__Alternatives_in_ruleCompareOperator2160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftOperator__Alternatives_in_ruleShiftOperator2196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveOperator__Alternatives_in_ruleAdditiveOperator2232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeOperator__Alternatives_in_ruleMultiplicativeOperator2268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryOperator__Alternatives_in_ruleUnaryOperator2304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_rule__ProgramElement__Alternatives2341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcedure_in_rule__ProgramElement__Alternatives2358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Constant__Alternatives_02391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Constant__Alternatives_02411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntConst_in_rule__NumberConst__Alternatives2445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleConst_in_rule__NumberConst__Alternatives2462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgnList__VarAssignment_0_in_rule__VarAsgnList__Alternatives2494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgnList__VarAsgnAssignment_1_in_rule__VarAsgnList__Alternatives2512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgn__FnBodyAssignment_2_0_in_rule__VarAsgn__Alternatives_22545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgn__ExprAssignment_2_1_in_rule__VarAsgn__Alternatives_22563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_0__0_in_rule__Dimension__Alternatives2596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_1__0_in_rule__Dimension__Alternatives2614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_2__0_in_rule__Dimension__Alternatives2632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ProcNoAttr__Alternatives_12666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__FnBodyAssignment_1_1_in_rule__ProcNoAttr__Alternatives_12685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__0_in_rule__FnPrototype__Alternatives2718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__0_in_rule__FnPrototype__Alternatives2736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__FnPrototype__ExternAlternatives_0_1_02770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__FnPrototype__ExternAlternatives_0_1_02790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__FnPrototype__PureAlternatives_0_2_02825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__FnPrototype__PureAlternatives_0_2_02845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__FnPrototype__ExternAlternatives_1_1_02880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__FnPrototype__ExternAlternatives_1_1_02900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__FnPrototype__PureAlternatives_1_2_02935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__FnPrototype__PureAlternatives_1_2_02955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLVal_in_rule__TerminalExpr__Alternatives2989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_1__0_in_rule__TerminalExpr__Alternatives3006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_2__0_in_rule__TerminalExpr__Alternatives3024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_3__0_in_rule__TerminalExpr__Alternatives3042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_4__0_in_rule__TerminalExpr__Alternatives3060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_5__0_in_rule__TerminalExpr__Alternatives3078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__0_in_rule__TerminalExpr__Alternatives3096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExpr_in_rule__TerminalExpr__Alternatives3114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_8__0_in_rule__TerminalExpr__Alternatives3131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Sign__Alternatives3165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Sign__Alternatives3185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__SimpType__Alternatives3220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__SimpType__Alternatives3240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__SimpType__Alternatives3260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__SimpType__Alternatives3280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__SimpType__Alternatives3300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SimpType__Alternatives3320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Signed__Alternatives3355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Signed__Alternatives3375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__BuiltInFunction__Alternatives3410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__BuiltInFunction__Alternatives3430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__BuiltInFunction__Alternatives3450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__BuiltInFunction__Alternatives3470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__BuiltInFunction__Alternatives3490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__BuiltInFunction__Alternatives3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Double__Alternatives3545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Group_1__0_in_rule__Double__Alternatives3564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__EqualityOperator__Alternatives3601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__EqualityOperator__Alternatives3622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__CompareOperator__Alternatives3658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__CompareOperator__Alternatives3679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__CompareOperator__Alternatives3700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__CompareOperator__Alternatives3721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ShiftOperator__Alternatives3757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ShiftOperator__Alternatives3778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__AdditiveOperator__Alternatives3814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__AdditiveOperator__Alternatives3835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__MultiplicativeOperator__Alternatives3871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__MultiplicativeOperator__Alternatives3892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__MultiplicativeOperator__Alternatives3913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__UnaryOperator__Alternatives3949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__UnaryOperator__Alternatives3970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__UnaryOperator__Alternatives3991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__UnaryOperator__Alternatives4012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__Group__0__Impl_in_rule__Program__Group__04046 = new BitSet(new long[]{0x008000001FE7B000L});
    public static final BitSet FOLLOW_rule__Program__Group__1_in_rule__Program__Group__04049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__Group__1__Impl_in_rule__Program__Group__14107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Program__ProgramElementsAssignment_1_in_rule__Program__Group__1__Impl4134 = new BitSet(new long[]{0x008000001FE7B002L});
    public static final BitSet FOLLOW_rule__DmplSubclause__Group__0__Impl_in_rule__DmplSubclause__Group__04169 = new BitSet(new long[]{0x008000001FE7B000L});
    public static final BitSet FOLLOW_rule__DmplSubclause__Group__1_in_rule__DmplSubclause__Group__04172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DmplSubclause__Group__1__Impl_in_rule__DmplSubclause__Group__14230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DmplSubclause__ProgramAssignment_1_in_rule__DmplSubclause__Group__1__Impl4257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__0__Impl_in_rule__Constant__Group__04291 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Constant__Group__1_in_rule__Constant__Group__04294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Alternatives_0_in_rule__Constant__Group__0__Impl4321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__1__Impl_in_rule__Constant__Group__14351 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__Constant__Group__2_in_rule__Constant__Group__14354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__NameAssignment_1_in_rule__Constant__Group__1__Impl4381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__2__Impl_in_rule__Constant__Group__24411 = new BitSet(new long[]{0x0000000800180010L});
    public static final BitSet FOLLOW_rule__Constant__Group__3_in_rule__Constant__Group__24414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__Constant__Group__2__Impl4442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__3__Impl_in_rule__Constant__Group__34473 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Constant__Group__4_in_rule__Constant__Group__34476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__ValueAssignment_3_in_rule__Constant__Group__3__Impl4503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Constant__Group__4__Impl_in_rule__Constant__Group__44533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Constant__Group__4__Impl4561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__Group__0__Impl_in_rule__IntConst__Group__04602 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_rule__IntConst__Group__1_in_rule__IntConst__Group__04605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__SignAssignment_0_in_rule__IntConst__Group__0__Impl4632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__Group__1__Impl_in_rule__IntConst__Group__14663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntConst__ValueAssignment_1_in_rule__IntConst__Group__1__Impl4690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__Group__0__Impl_in_rule__DoubleConst__Group__04724 = new BitSet(new long[]{0x0000000800180010L});
    public static final BitSet FOLLOW_rule__DoubleConst__Group__1_in_rule__DoubleConst__Group__04727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__SignAssignment_0_in_rule__DoubleConst__Group__0__Impl4754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__Group__1__Impl_in_rule__DoubleConst__Group__14785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleConst__ValueAssignment_1_in_rule__DoubleConst__Group__1__Impl4812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInit__Group__0__Impl_in_rule__VarInit__Group__04846 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VarInit__Group__1_in_rule__VarInit__Group__04849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInit__TypeAssignment_0_in_rule__VarInit__Group__0__Impl4876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInit__Group__1__Impl_in_rule__VarInit__Group__14906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInit__VarAsgnListAssignment_1_in_rule__VarInit__Group__1__Impl4933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgn__Group__0__Impl_in_rule__VarAsgn__Group__04967 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__VarAsgn__Group__1_in_rule__VarAsgn__Group__04970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgn__VarAssignment_0_in_rule__VarAsgn__Group__0__Impl4997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgn__Group__1__Impl_in_rule__VarAsgn__Group__15027 = new BitSet(new long[]{0x1131800FE0180030L});
    public static final BitSet FOLLOW_rule__VarAsgn__Group__2_in_rule__VarAsgn__Group__15030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__VarAsgn__Group__1__Impl5058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgn__Group__2__Impl_in_rule__VarAsgn__Group__25089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarAsgn__Alternatives_2_in_rule__VarAsgn__Group__2__Impl5116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Var__Group__0__Impl_in_rule__Var__Group__05152 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__Var__Group__1_in_rule__Var__Group__05155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Var__NameAssignment_0_in_rule__Var__Group__0__Impl5182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Var__Group__1__Impl_in_rule__Var__Group__15212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Var__Group_1__0_in_rule__Var__Group__1__Impl5239 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_rule__Var__Group_1__0__Impl_in_rule__Var__Group_1__05274 = new BitSet(new long[]{0x0010000000000030L});
    public static final BitSet FOLLOW_rule__Var__Group_1__1_in_rule__Var__Group_1__05277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__Var__Group_1__0__Impl5305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Var__Group_1__1__Impl_in_rule__Var__Group_1__15336 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__Var__Group_1__2_in_rule__Var__Group_1__15339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Var__DimensionsAssignment_1_1_in_rule__Var__Group_1__1__Impl5366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Var__Group_1__2__Impl_in_rule__Var__Group_1__25396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__Var__Group_1__2__Impl5424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_0__0__Impl_in_rule__Dimension__Group_0__05461 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Dimension__Group_0__1_in_rule__Dimension__Group_0__05464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_0__1__Impl_in_rule__Dimension__Group_0__15522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__IndexAssignment_0_1_in_rule__Dimension__Group_0__1__Impl5549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_1__0__Impl_in_rule__Dimension__Group_1__05583 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__Dimension__Group_1__1_in_rule__Dimension__Group_1__05586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_1__1__Impl_in_rule__Dimension__Group_1__15644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__Dimension__Group_1__1__Impl5672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_2__0__Impl_in_rule__Dimension__Group_2__05707 = new BitSet(new long[]{0x0010000000000030L});
    public static final BitSet FOLLOW_rule__Dimension__Group_2__1_in_rule__Dimension__Group_2__05710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__Group_2__1__Impl_in_rule__Dimension__Group_2__15768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Dimension__IndexAssignment_2_1_in_rule__Dimension__Group_2__1__Impl5795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group__0__Impl_in_rule__Type__Group__05829 = new BitSet(new long[]{0x008000001FE7B000L});
    public static final BitSet FOLLOW_rule__Type__Group__1_in_rule__Type__Group__05832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__SignedAssignment_0_in_rule__Type__Group__0__Impl5859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Group__1__Impl_in_rule__Type__Group__15890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__SimpTypeAssignment_1_in_rule__Type__Group__1__Impl5917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Group__0__Impl_in_rule__ProcNoAttr__Group__05951 = new BitSet(new long[]{0x0020000000004000L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Group__1_in_rule__ProcNoAttr__Group__05954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__PrototypeAssignment_0_in_rule__ProcNoAttr__Group__0__Impl5981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Group__1__Impl_in_rule__ProcNoAttr__Group__16011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ProcNoAttr__Alternatives_1_in_rule__ProcNoAttr__Group__1__Impl6038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnBody__Group__0__Impl_in_rule__FnBody__Group__06072 = new BitSet(new long[]{0x008000001FE7B000L});
    public static final BitSet FOLLOW_rule__FnBody__Group__1_in_rule__FnBody__Group__06075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__FnBody__Group__0__Impl6103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnBody__Group__1__Impl_in_rule__FnBody__Group__16134 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_rule__FnBody__Group__2_in_rule__FnBody__Group__16137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnBody__VarInitListAssignment_1_in_rule__FnBody__Group__1__Impl6164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnBody__Group__2__Impl_in_rule__FnBody__Group__26194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__FnBody__Group__2__Impl6222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__0__Impl_in_rule__FnPrototype__Group_0__06259 = new BitSet(new long[]{0x0080000000078000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__1_in_rule__FnPrototype__Group_0__06262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__1__Impl_in_rule__FnPrototype__Group_0__16320 = new BitSet(new long[]{0x0080000000078000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__2_in_rule__FnPrototype__Group_0__16323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__ExternAssignment_0_1_in_rule__FnPrototype__Group_0__1__Impl6350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__2__Impl_in_rule__FnPrototype__Group_0__26381 = new BitSet(new long[]{0x0080000000078000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__3_in_rule__FnPrototype__Group_0__26384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__PureAssignment_0_2_in_rule__FnPrototype__Group_0__2__Impl6411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__3__Impl_in_rule__FnPrototype__Group_0__36442 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__4_in_rule__FnPrototype__Group_0__36445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__FnPrototype__Group_0__3__Impl6473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_0__4__Impl_in_rule__FnPrototype__Group_0__46504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__NameAssignment_0_4_in_rule__FnPrototype__Group_0__4__Impl6531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__0__Impl_in_rule__FnPrototype__Group_1__06571 = new BitSet(new long[]{0x008000001FE7B000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__1_in_rule__FnPrototype__Group_1__06574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__1__Impl_in_rule__FnPrototype__Group_1__16632 = new BitSet(new long[]{0x008000001FE7B000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__2_in_rule__FnPrototype__Group_1__16635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__ExternAssignment_1_1_in_rule__FnPrototype__Group_1__1__Impl6662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__2__Impl_in_rule__FnPrototype__Group_1__26693 = new BitSet(new long[]{0x008000001FE7B000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__3_in_rule__FnPrototype__Group_1__26696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__PureAssignment_1_2_in_rule__FnPrototype__Group_1__2__Impl6723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__3__Impl_in_rule__FnPrototype__Group_1__36754 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__4_in_rule__FnPrototype__Group_1__36757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__TypeAssignment_1_3_in_rule__FnPrototype__Group_1__3__Impl6784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__4__Impl_in_rule__FnPrototype__Group_1__46814 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__5_in_rule__FnPrototype__Group_1__46817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__NameAssignment_1_4_in_rule__FnPrototype__Group_1__4__Impl6844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__5__Impl_in_rule__FnPrototype__Group_1__56874 = new BitSet(new long[]{0x028000001FE7B000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__6_in_rule__FnPrototype__Group_1__56877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__FnPrototype__Group_1__5__Impl6905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__6__Impl_in_rule__FnPrototype__Group_1__66936 = new BitSet(new long[]{0x028000001FE7B000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__7_in_rule__FnPrototype__Group_1__66939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1_6__0_in_rule__FnPrototype__Group_1__6__Impl6966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1__7__Impl_in_rule__FnPrototype__Group_1__76997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_rule__FnPrototype__Group_1__7__Impl7025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1_6__0__Impl_in_rule__FnPrototype__Group_1_6__07072 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1_6__1_in_rule__FnPrototype__Group_1_6__07075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__ParamsAssignment_1_6_0_in_rule__FnPrototype__Group_1_6__0__Impl7102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1_6__1__Impl_in_rule__FnPrototype__Group_1_6__17132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1_6_1__0_in_rule__FnPrototype__Group_1_6__1__Impl7159 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1_6_1__0__Impl_in_rule__FnPrototype__Group_1_6_1__07194 = new BitSet(new long[]{0x008000001FE7B000L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1_6_1__1_in_rule__FnPrototype__Group_1_6_1__07197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_rule__FnPrototype__Group_1_6_1__0__Impl7225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__Group_1_6_1__1__Impl_in_rule__FnPrototype__Group_1_6_1__17256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__ParamsAssignment_1_6_1_1_in_rule__FnPrototype__Group_1_6_1__1__Impl7283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Param__Group__0__Impl_in_rule__Param__Group__07317 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Param__Group__1_in_rule__Param__Group__07320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Param__TypeAssignment_0_in_rule__Param__Group__0__Impl7347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Param__Group__1__Impl_in_rule__Param__Group__17377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Param__VarAssignment_1_in_rule__Param__Group__1__Impl7404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInitList__Group__0__Impl_in_rule__VarInitList__Group__07438 = new BitSet(new long[]{0x008000001FE7B000L});
    public static final BitSet FOLLOW_rule__VarInitList__Group__1_in_rule__VarInitList__Group__07441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInitList__Group__1__Impl_in_rule__VarInitList__Group__17499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInitList__Group_1__0_in_rule__VarInitList__Group__1__Impl7526 = new BitSet(new long[]{0x008000001FE7B002L});
    public static final BitSet FOLLOW_rule__VarInitList__Group_1__0__Impl_in_rule__VarInitList__Group_1__07561 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__VarInitList__Group_1__1_in_rule__VarInitList__Group_1__07564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInitList__VarInitsAssignment_1_0_in_rule__VarInitList__Group_1__0__Impl7591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarInitList__Group_1__1__Impl_in_rule__VarInitList__Group_1__17621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VarInitList__Group_1__1__Impl7649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group__0__Impl_in_rule__LVal__Group__07684 = new BitSet(new long[]{0x0804000000000000L});
    public static final BitSet FOLLOW_rule__LVal__Group__1_in_rule__LVal__Group__07687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__NameAssignment_0_in_rule__LVal__Group__0__Impl7714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group__1__Impl_in_rule__LVal__Group__17744 = new BitSet(new long[]{0x0804000000000000L});
    public static final BitSet FOLLOW_rule__LVal__Group__2_in_rule__LVal__Group__17747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group_1__0_in_rule__LVal__Group__1__Impl7774 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group__2__Impl_in_rule__LVal__Group__27805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group_2__0_in_rule__LVal__Group__2__Impl7832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group_1__0__Impl_in_rule__LVal__Group_1__07869 = new BitSet(new long[]{0x1131800FE0180030L});
    public static final BitSet FOLLOW_rule__LVal__Group_1__1_in_rule__LVal__Group_1__07872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__LVal__Group_1__0__Impl7900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group_1__1__Impl_in_rule__LVal__Group_1__17931 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__LVal__Group_1__2_in_rule__LVal__Group_1__17934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__IndicesAssignment_1_1_in_rule__LVal__Group_1__1__Impl7961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group_1__2__Impl_in_rule__LVal__Group_1__27991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__LVal__Group_1__2__Impl8019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group_2__0__Impl_in_rule__LVal__Group_2__08056 = new BitSet(new long[]{0x1131800FE0180030L});
    public static final BitSet FOLLOW_rule__LVal__Group_2__1_in_rule__LVal__Group_2__08059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_rule__LVal__Group_2__0__Impl8087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__Group_2__1__Impl_in_rule__LVal__Group_2__18118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LVal__AtAssignment_2_1_in_rule__LVal__Group_2__1__Impl8145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpr__Group__0__Impl_in_rule__EqualityExpr__Group__08179 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__EqualityExpr__Group__1_in_rule__EqualityExpr__Group__08182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompareExpr_in_rule__EqualityExpr__Group__0__Impl8209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpr__Group__1__Impl_in_rule__EqualityExpr__Group__18238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpr__Group_1__0_in_rule__EqualityExpr__Group__1__Impl8265 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpr__Group_1__0__Impl_in_rule__EqualityExpr__Group_1__08300 = new BitSet(new long[]{0x1131800FE0180030L});
    public static final BitSet FOLLOW_rule__EqualityExpr__Group_1__1_in_rule__EqualityExpr__Group_1__08303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpr__Group_1_0__0_in_rule__EqualityExpr__Group_1__0__Impl8330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpr__Group_1__1__Impl_in_rule__EqualityExpr__Group_1__18360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpr__RightAssignment_1_1_in_rule__EqualityExpr__Group_1__1__Impl8387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpr__Group_1_0__0__Impl_in_rule__EqualityExpr__Group_1_0__08421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpr__Group_1_0_0__0_in_rule__EqualityExpr__Group_1_0__0__Impl8448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpr__Group_1_0_0__0__Impl_in_rule__EqualityExpr__Group_1_0_0__08480 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__EqualityExpr__Group_1_0_0__1_in_rule__EqualityExpr__Group_1_0_0__08483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpr__Group_1_0_0__1__Impl_in_rule__EqualityExpr__Group_1_0_0__18541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpr__OperatorAssignment_1_0_0_1_in_rule__EqualityExpr__Group_1_0_0__1__Impl8568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompareExpr__Group__0__Impl_in_rule__CompareExpr__Group__08602 = new BitSet(new long[]{0x000003C000000000L});
    public static final BitSet FOLLOW_rule__CompareExpr__Group__1_in_rule__CompareExpr__Group__08605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpr_in_rule__CompareExpr__Group__0__Impl8632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompareExpr__Group__1__Impl_in_rule__CompareExpr__Group__18661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompareExpr__Group_1__0_in_rule__CompareExpr__Group__1__Impl8688 = new BitSet(new long[]{0x000003C000000002L});
    public static final BitSet FOLLOW_rule__CompareExpr__Group_1__0__Impl_in_rule__CompareExpr__Group_1__08723 = new BitSet(new long[]{0x1131800FE0180030L});
    public static final BitSet FOLLOW_rule__CompareExpr__Group_1__1_in_rule__CompareExpr__Group_1__08726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompareExpr__Group_1_0__0_in_rule__CompareExpr__Group_1__0__Impl8753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompareExpr__Group_1__1__Impl_in_rule__CompareExpr__Group_1__18783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompareExpr__RightAssignment_1_1_in_rule__CompareExpr__Group_1__1__Impl8810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompareExpr__Group_1_0__0__Impl_in_rule__CompareExpr__Group_1_0__08844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompareExpr__Group_1_0_0__0_in_rule__CompareExpr__Group_1_0__0__Impl8871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompareExpr__Group_1_0_0__0__Impl_in_rule__CompareExpr__Group_1_0_0__08903 = new BitSet(new long[]{0x000003C000000000L});
    public static final BitSet FOLLOW_rule__CompareExpr__Group_1_0_0__1_in_rule__CompareExpr__Group_1_0_0__08906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompareExpr__Group_1_0_0__1__Impl_in_rule__CompareExpr__Group_1_0_0__18964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompareExpr__OperatorAssignment_1_0_0_1_in_rule__CompareExpr__Group_1_0_0__1__Impl8991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group__0__Impl_in_rule__ShiftExpr__Group__09025 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group__1_in_rule__ShiftExpr__Group__09028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpr_in_rule__ShiftExpr__Group__0__Impl9055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group__1__Impl_in_rule__ShiftExpr__Group__19084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1__0_in_rule__ShiftExpr__Group__1__Impl9111 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1__0__Impl_in_rule__ShiftExpr__Group_1__09146 = new BitSet(new long[]{0x1131800FE0180030L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1__1_in_rule__ShiftExpr__Group_1__09149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1_0__0_in_rule__ShiftExpr__Group_1__0__Impl9176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1__1__Impl_in_rule__ShiftExpr__Group_1__19206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__RightAssignment_1_1_in_rule__ShiftExpr__Group_1__1__Impl9233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1_0__0__Impl_in_rule__ShiftExpr__Group_1_0__09267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1_0_0__0_in_rule__ShiftExpr__Group_1_0__0__Impl9294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1_0_0__0__Impl_in_rule__ShiftExpr__Group_1_0_0__09326 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1_0_0__1_in_rule__ShiftExpr__Group_1_0_0__09329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1_0_0__1__Impl_in_rule__ShiftExpr__Group_1_0_0__19387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__OperatorAssignment_1_0_0_1_in_rule__ShiftExpr__Group_1_0_0__1__Impl9414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group__0__Impl_in_rule__AdditiveExpr__Group__09448 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group__1_in_rule__AdditiveExpr__Group__09451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpr_in_rule__AdditiveExpr__Group__0__Impl9478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group__1__Impl_in_rule__AdditiveExpr__Group__19507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1__0_in_rule__AdditiveExpr__Group__1__Impl9534 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1__0__Impl_in_rule__AdditiveExpr__Group_1__09569 = new BitSet(new long[]{0x1131800FE0180030L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1__1_in_rule__AdditiveExpr__Group_1__09572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1_0__0_in_rule__AdditiveExpr__Group_1__0__Impl9599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1__1__Impl_in_rule__AdditiveExpr__Group_1__19629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__RightAssignment_1_1_in_rule__AdditiveExpr__Group_1__1__Impl9656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1_0__0__Impl_in_rule__AdditiveExpr__Group_1_0__09690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1_0_0__0_in_rule__AdditiveExpr__Group_1_0__0__Impl9717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1_0_0__0__Impl_in_rule__AdditiveExpr__Group_1_0_0__09749 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1_0_0__1_in_rule__AdditiveExpr__Group_1_0_0__09752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1_0_0__1__Impl_in_rule__AdditiveExpr__Group_1_0_0__19810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__OperatorAssignment_1_0_0_1_in_rule__AdditiveExpr__Group_1_0_0__1__Impl9837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group__0__Impl_in_rule__MultiplicativeExpr__Group__09871 = new BitSet(new long[]{0x0000700000000000L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group__1_in_rule__MultiplicativeExpr__Group__09874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpr_in_rule__MultiplicativeExpr__Group__0__Impl9901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group__1__Impl_in_rule__MultiplicativeExpr__Group__19930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1__0_in_rule__MultiplicativeExpr__Group__1__Impl9957 = new BitSet(new long[]{0x0000700000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1__0__Impl_in_rule__MultiplicativeExpr__Group_1__09992 = new BitSet(new long[]{0x1131800FE0180030L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1__1_in_rule__MultiplicativeExpr__Group_1__09995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1_0__0_in_rule__MultiplicativeExpr__Group_1__0__Impl10022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1__1__Impl_in_rule__MultiplicativeExpr__Group_1__110052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__RightAssignment_1_1_in_rule__MultiplicativeExpr__Group_1__1__Impl10079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1_0__0__Impl_in_rule__MultiplicativeExpr__Group_1_0__010113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1_0_0__0_in_rule__MultiplicativeExpr__Group_1_0__0__Impl10140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1_0_0__0__Impl_in_rule__MultiplicativeExpr__Group_1_0_0__010172 = new BitSet(new long[]{0x0000700000000000L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1_0_0__1_in_rule__MultiplicativeExpr__Group_1_0_0__010175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1_0_0__1__Impl_in_rule__MultiplicativeExpr__Group_1_0_0__110233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__OperatorAssignment_1_0_0_1_in_rule__MultiplicativeExpr__Group_1_0_0__1__Impl10260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_1__0__Impl_in_rule__TerminalExpr__Group_1__010294 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_1__1_in_rule__TerminalExpr__Group_1__010297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_1__1__Impl_in_rule__TerminalExpr__Group_1__110355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_rule__TerminalExpr__Group_1__1__Impl10383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_2__0__Impl_in_rule__TerminalExpr__Group_2__010418 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_2__1_in_rule__TerminalExpr__Group_2__010421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_2__1__Impl_in_rule__TerminalExpr__Group_2__110479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__ValueAssignment_2_1_in_rule__TerminalExpr__Group_2__1__Impl10506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_3__0__Impl_in_rule__TerminalExpr__Group_3__010540 = new BitSet(new long[]{0x0000000800180010L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_3__1_in_rule__TerminalExpr__Group_3__010543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_3__1__Impl_in_rule__TerminalExpr__Group_3__110601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__ValueAssignment_3_1_in_rule__TerminalExpr__Group_3__1__Impl10628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_4__0__Impl_in_rule__TerminalExpr__Group_4__010662 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_4__1_in_rule__TerminalExpr__Group_4__010665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_4__1__Impl_in_rule__TerminalExpr__Group_4__110723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__TerminalExpr__Group_4__1__Impl10751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_5__0__Impl_in_rule__TerminalExpr__Group_5__010786 = new BitSet(new long[]{0x0001800000180000L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_5__1_in_rule__TerminalExpr__Group_5__010789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_5__1__Impl_in_rule__TerminalExpr__Group_5__110847 = new BitSet(new long[]{0x1131800FE0180030L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_5__2_in_rule__TerminalExpr__Group_5__110850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__OperatorAssignment_5_1_in_rule__TerminalExpr__Group_5__1__Impl10877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_5__2__Impl_in_rule__TerminalExpr__Group_5__210907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__OperandAssignment_5_2_in_rule__TerminalExpr__Group_5__2__Impl10934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__0__Impl_in_rule__TerminalExpr__Group_6__010970 = new BitSet(new long[]{0x00000007E0000000L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__1_in_rule__TerminalExpr__Group_6__010973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__1__Impl_in_rule__TerminalExpr__Group_6__111031 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__2_in_rule__TerminalExpr__Group_6__111034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__FunctionAssignment_6_1_in_rule__TerminalExpr__Group_6__1__Impl11061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__2__Impl_in_rule__TerminalExpr__Group_6__211091 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__3_in_rule__TerminalExpr__Group_6__211094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__TerminalExpr__Group_6__2__Impl11122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__3__Impl_in_rule__TerminalExpr__Group_6__311153 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__4_in_rule__TerminalExpr__Group_6__311156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__FirstArgAssignment_6_3_in_rule__TerminalExpr__Group_6__3__Impl11183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__4__Impl_in_rule__TerminalExpr__Group_6__411213 = new BitSet(new long[]{0x1131800FE0180030L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__5_in_rule__TerminalExpr__Group_6__411216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_rule__TerminalExpr__Group_6__4__Impl11244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__5__Impl_in_rule__TerminalExpr__Group_6__511275 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__6_in_rule__TerminalExpr__Group_6__511278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__SecondArgAssignment_6_5_in_rule__TerminalExpr__Group_6__5__Impl11305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_6__6__Impl_in_rule__TerminalExpr__Group_6__611335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_rule__TerminalExpr__Group_6__6__Impl11363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_8__0__Impl_in_rule__TerminalExpr__Group_8__011408 = new BitSet(new long[]{0x1131800FE0180030L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_8__1_in_rule__TerminalExpr__Group_8__011411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__TerminalExpr__Group_8__0__Impl11439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_8__1__Impl_in_rule__TerminalExpr__Group_8__111470 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_8__2_in_rule__TerminalExpr__Group_8__111473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__TerminalExpr__Group_8__1__Impl11500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TerminalExpr__Group_8__2__Impl_in_rule__TerminalExpr__Group_8__211529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_rule__TerminalExpr__Group_8__2__Impl11557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__0__Impl_in_rule__CallExpr__Group__011594 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__1_in_rule__CallExpr__Group__011597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group_0__0_in_rule__CallExpr__Group__0__Impl11624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__1__Impl_in_rule__CallExpr__Group__111655 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__2_in_rule__CallExpr__Group__111658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__NameAssignment_1_in_rule__CallExpr__Group__1__Impl11685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__2__Impl_in_rule__CallExpr__Group__211715 = new BitSet(new long[]{0x1131800FE0180030L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__3_in_rule__CallExpr__Group__211718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_rule__CallExpr__Group__2__Impl11746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__3__Impl_in_rule__CallExpr__Group__311777 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__4_in_rule__CallExpr__Group__311780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__ArgListAssignment_3_in_rule__CallExpr__Group__3__Impl11807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__4__Impl_in_rule__CallExpr__Group__411837 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__5_in_rule__CallExpr__Group__411840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_rule__CallExpr__Group__4__Impl11868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group__5__Impl_in_rule__CallExpr__Group__511899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group_5__0_in_rule__CallExpr__Group__5__Impl11926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group_0__0__Impl_in_rule__CallExpr__Group_0__011969 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_rule__CallExpr__Group_0__1_in_rule__CallExpr__Group_0__011972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__NamespaceAssignment_0_0_in_rule__CallExpr__Group_0__0__Impl11999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group_0__1__Impl_in_rule__CallExpr__Group_0__112029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_rule__CallExpr__Group_0__1__Impl12057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group_5__0__Impl_in_rule__CallExpr__Group_5__012092 = new BitSet(new long[]{0x1131800FE0180030L});
    public static final BitSet FOLLOW_rule__CallExpr__Group_5__1_in_rule__CallExpr__Group_5__012095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_rule__CallExpr__Group_5__0__Impl12123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__Group_5__1__Impl_in_rule__CallExpr__Group_5__112154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallExpr__AtAssignment_5_1_in_rule__CallExpr__Group_5__1__Impl12181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group__0__Impl_in_rule__ArgList__Group__012215 = new BitSet(new long[]{0x1131800FE0180030L});
    public static final BitSet FOLLOW_rule__ArgList__Group__1_in_rule__ArgList__Group__012218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group__1__Impl_in_rule__ArgList__Group__112276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group_1__0_in_rule__ArgList__Group__1__Impl12303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group_1__0__Impl_in_rule__ArgList__Group_1__012338 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_rule__ArgList__Group_1__1_in_rule__ArgList__Group_1__012341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__ArgsAssignment_1_0_in_rule__ArgList__Group_1__0__Impl12368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group_1__1__Impl_in_rule__ArgList__Group_1__112398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group_1_1__0_in_rule__ArgList__Group_1__1__Impl12425 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group_1_1__0__Impl_in_rule__ArgList__Group_1_1__012460 = new BitSet(new long[]{0x1131800FE0180030L});
    public static final BitSet FOLLOW_rule__ArgList__Group_1_1__1_in_rule__ArgList__Group_1_1__012463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_rule__ArgList__Group_1_1__0__Impl12491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__Group_1_1__1__Impl_in_rule__ArgList__Group_1_1__112522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArgList__ArgsAssignment_1_1_1_in_rule__ArgList__Group_1_1__1__Impl12549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Group_1__0__Impl_in_rule__Double__Group_1__012583 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_rule__Double__Group_1__1_in_rule__Double__Group_1__012586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Double__Group_1__0__Impl12613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Group_1__1__Impl_in_rule__Double__Group_1__112642 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Double__Group_1__2_in_rule__Double__Group_1__112645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_rule__Double__Group_1__1__Impl12673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Double__Group_1__2__Impl_in_rule__Double__Group_1__212704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Double__Group_1__2__Impl12732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProgramElement_in_rule__Program__ProgramElementsAssignment_112774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProgram_in_rule__DmplSubclause__ProgramAssignment_112805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__Constant__NameAssignment_112836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberConst_in_rule__Constant__ValueAssignment_312867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSign_in_rule__IntConst__SignAssignment_012898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__IntConst__ValueAssignment_112929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSign_in_rule__DoubleConst__SignAssignment_012960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDouble_in_rule__DoubleConst__ValueAssignment_112991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__VarInit__TypeAssignment_013022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarAsgnList_in_rule__VarInit__VarAsgnListAssignment_113053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_rule__VarAsgnList__VarAssignment_013084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarAsgn_in_rule__VarAsgnList__VarAsgnAssignment_113115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_rule__VarAsgn__VarAssignment_013146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnBody_in_rule__VarAsgn__FnBodyAssignment_2_013177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__VarAsgn__ExprAssignment_2_113208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__Var__NameAssignment_013239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDimension_in_rule__Var__DimensionsAssignment_1_113270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Dimension__IndexAssignment_0_113301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__Dimension__IndexAssignment_2_113332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSigned_in_rule__Type__SignedAssignment_013363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpType_in_rule__Type__SimpTypeAssignment_113394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcNoAttr_in_rule__Procedure__ProcedureAssignment13425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnPrototype_in_rule__ProcNoAttr__PrototypeAssignment_013456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnBody_in_rule__ProcNoAttr__FnBodyAssignment_1_113487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarInitList_in_rule__FnBody__VarInitListAssignment_113518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__ExternAlternatives_0_1_0_in_rule__FnPrototype__ExternAssignment_0_113549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__PureAlternatives_0_2_0_in_rule__FnPrototype__PureAssignment_0_213582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__FnPrototype__NameAssignment_0_413615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__ExternAlternatives_1_1_0_in_rule__FnPrototype__ExternAssignment_1_113646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FnPrototype__PureAlternatives_1_2_0_in_rule__FnPrototype__PureAssignment_1_213679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__FnPrototype__TypeAssignment_1_313712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__FnPrototype__NameAssignment_1_413743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParam_in_rule__FnPrototype__ParamsAssignment_1_6_013774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParam_in_rule__FnPrototype__ParamsAssignment_1_6_1_113805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__Param__TypeAssignment_013836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_rule__Param__VarAssignment_113867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarInit_in_rule__VarInitList__VarInitsAssignment_1_013898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__LVal__NameAssignment_013929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__LVal__IndicesAssignment_1_113960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__LVal__AtAssignment_2_113991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_rule__EqualityExpr__OperatorAssignment_1_0_0_114022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompareExpr_in_rule__EqualityExpr__RightAssignment_1_114053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompareOperator_in_rule__CompareExpr__OperatorAssignment_1_0_0_114084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpr_in_rule__CompareExpr__RightAssignment_1_114115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftOperator_in_rule__ShiftExpr__OperatorAssignment_1_0_0_114146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpr_in_rule__ShiftExpr__RightAssignment_1_114177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_rule__AdditiveExpr__OperatorAssignment_1_0_0_114208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpr_in_rule__AdditiveExpr__RightAssignment_1_114239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_rule__MultiplicativeExpr__OperatorAssignment_1_0_0_114270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpr_in_rule__MultiplicativeExpr__RightAssignment_1_114301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__TerminalExpr__ValueAssignment_2_114332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDouble_in_rule__TerminalExpr__ValueAssignment_3_114363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_rule__TerminalExpr__OperatorAssignment_5_114394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__TerminalExpr__OperandAssignment_5_214425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltInFunction_in_rule__TerminalExpr__FunctionAssignment_6_114456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__TerminalExpr__FirstArgAssignment_6_314487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__TerminalExpr__SecondArgAssignment_6_514518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__CallExpr__NamespaceAssignment_0_014549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_rule__CallExpr__NameAssignment_114580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgList_in_rule__CallExpr__ArgListAssignment_314611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__CallExpr__AtAssignment_5_114642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__ArgList__ArgsAssignment_1_014673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_rule__ArgList__ArgsAssignment_1_1_114704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EqualityExpr__Group_1__0_in_synpred60_InternalDmpl8265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompareExpr__Group_1__0_in_synpred61_InternalDmpl8688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ShiftExpr__Group_1__0_in_synpred62_InternalDmpl9111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AdditiveExpr__Group_1__0_in_synpred63_InternalDmpl9534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MultiplicativeExpr__Group_1__0_in_synpred64_InternalDmpl9957 = new BitSet(new long[]{0x0000000000000002L});

}