package edu.cmu.sei.annex.dmpl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import edu.cmu.sei.annex.dmpl.services.DmplGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalDmplParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_TIDENTIFIER", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'const'", "'CONST'", "'='", "';'", "','", "'input'", "'~'", "'['", "']'", "'#N'", "'{'", "'}'", "'extern'", "'EXTERN'", "'pure'", "'PURE'", "'thread'", "'('", "')'", "'@'", "'if'", "'else'", "'while'", "'for'", "'return'", "'forall_distinct_node_pair'", "'FORALL_DISTINCT_NODE_PAIR'", "'?'", "':'", "'||'", "'&&'", "'|'", "'^'", "'&'", "'id'", "'::'", "'+'", "'-'", "'bool'", "'_Bool'", "'int'", "'double'", "'void'", "'char'", "'signed'", "'unsigned'", "'break'", "'continue'", "'forall_node'", "'FORALL_NODE'", "'forall_other'", "'FORALL_OTHER'", "'forall_other_lower'", "'FORALL_OTHER_LOWER'", "'forall_other_higher'", "'FORALL_OTHER_HIGHER'", "'exists_other'", "'EXISTS_OTHER'", "'exists_higher'", "'EXISTS_HIGHER'", "'exists_lower'", "'EXISTS_LOWER'", "'NAN'", "'.'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", "'*'", "'/'", "'%'", "'!'"
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
    public static final int RULE_TIDENTIFIER=4;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=6;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__86=86;
    public static final int T__43=43;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalDmplParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDmplParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDmplParser.tokenNames; }
    public String getGrammarFileName() { return "../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g"; }



     	private DmplGrammarAccess grammarAccess;
     	
        public InternalDmplParser(TokenStream input, DmplGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Program";	
       	}
       	
       	@Override
       	protected DmplGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleProgram"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:68:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:69:2: (iv_ruleProgram= ruleProgram EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:70:2: iv_ruleProgram= ruleProgram EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramRule()); 
            }
            pushFollow(FOLLOW_ruleProgram_in_entryRuleProgram75);
            iv_ruleProgram=ruleProgram();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgram; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProgram85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:77:1: ruleProgram returns [EObject current=null] : ( () ( (lv_programElements_1_0= ruleProgramElement ) )* ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        EObject lv_programElements_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:80:28: ( ( () ( (lv_programElements_1_0= ruleProgramElement ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:81:1: ( () ( (lv_programElements_1_0= ruleProgramElement ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:81:1: ( () ( (lv_programElements_1_0= ruleProgramElement ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:81:2: () ( (lv_programElements_1_0= ruleProgramElement ) )*
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:81:2: ()
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:82:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getProgramAccess().getProgramAction_0(),
                          current);
                  
            }

            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:87:2: ( (lv_programElements_1_0= ruleProgramElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=12 && LA1_0<=13)||(LA1_0>=24 && LA1_0<=28)||(LA1_0>=50 && LA1_0<=57)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:88:1: (lv_programElements_1_0= ruleProgramElement )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:88:1: (lv_programElements_1_0= ruleProgramElement )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:89:3: lv_programElements_1_0= ruleProgramElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProgramAccess().getProgramElementsProgramElementParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleProgramElement_in_ruleProgram140);
            	    lv_programElements_1_0=ruleProgramElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"programElements",
            	              		lv_programElements_1_0, 
            	              		"ProgramElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleDmplSubclause"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:115:1: entryRuleDmplSubclause returns [EObject current=null] : iv_ruleDmplSubclause= ruleDmplSubclause EOF ;
    public final EObject entryRuleDmplSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDmplSubclause = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:116:2: (iv_ruleDmplSubclause= ruleDmplSubclause EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:117:2: iv_ruleDmplSubclause= ruleDmplSubclause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDmplSubclauseRule()); 
            }
            pushFollow(FOLLOW_ruleDmplSubclause_in_entryRuleDmplSubclause179);
            iv_ruleDmplSubclause=ruleDmplSubclause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDmplSubclause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDmplSubclause189); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDmplSubclause"


    // $ANTLR start "ruleDmplSubclause"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:124:1: ruleDmplSubclause returns [EObject current=null] : ( () ( (lv_program_1_0= ruleProgram ) ) ) ;
    public final EObject ruleDmplSubclause() throws RecognitionException {
        EObject current = null;

        EObject lv_program_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:127:28: ( ( () ( (lv_program_1_0= ruleProgram ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:128:1: ( () ( (lv_program_1_0= ruleProgram ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:128:1: ( () ( (lv_program_1_0= ruleProgram ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:128:2: () ( (lv_program_1_0= ruleProgram ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:128:2: ()
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:129:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getDmplSubclauseAccess().getDmplSubclauseAction_0(),
                          current);
                  
            }

            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:134:2: ( (lv_program_1_0= ruleProgram ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:135:1: (lv_program_1_0= ruleProgram )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:135:1: (lv_program_1_0= ruleProgram )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:136:3: lv_program_1_0= ruleProgram
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDmplSubclauseAccess().getProgramProgramParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleProgram_in_ruleDmplSubclause244);
            lv_program_1_0=ruleProgram();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDmplSubclauseRule());
              	        }
                     		set(
                     			current, 
                     			"program",
                      		lv_program_1_0, 
                      		"Program");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDmplSubclause"


    // $ANTLR start "entryRuleProgramElement"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:160:1: entryRuleProgramElement returns [EObject current=null] : iv_ruleProgramElement= ruleProgramElement EOF ;
    public final EObject entryRuleProgramElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramElement = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:161:2: (iv_ruleProgramElement= ruleProgramElement EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:162:2: iv_ruleProgramElement= ruleProgramElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramElementRule()); 
            }
            pushFollow(FOLLOW_ruleProgramElement_in_entryRuleProgramElement280);
            iv_ruleProgramElement=ruleProgramElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgramElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProgramElement290); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgramElement"


    // $ANTLR start "ruleProgramElement"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:169:1: ruleProgramElement returns [EObject current=null] : (this_Constant_0= ruleConstant | this_Procedure_1= ruleProcedure ) ;
    public final EObject ruleProgramElement() throws RecognitionException {
        EObject current = null;

        EObject this_Constant_0 = null;

        EObject this_Procedure_1 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:172:28: ( (this_Constant_0= ruleConstant | this_Procedure_1= ruleProcedure ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:173:1: (this_Constant_0= ruleConstant | this_Procedure_1= ruleProcedure )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:173:1: (this_Constant_0= ruleConstant | this_Procedure_1= ruleProcedure )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=12 && LA2_0<=13)) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=24 && LA2_0<=28)||(LA2_0>=50 && LA2_0<=57)) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:174:5: this_Constant_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getProgramElementAccess().getConstantParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleConstant_in_ruleProgramElement337);
                    this_Constant_0=ruleConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Constant_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:184:5: this_Procedure_1= ruleProcedure
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getProgramElementAccess().getProcedureParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleProcedure_in_ruleProgramElement364);
                    this_Procedure_1=ruleProcedure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Procedure_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgramElement"


    // $ANTLR start "entryRuleConstant"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:200:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:201:2: (iv_ruleConstant= ruleConstant EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:202:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant399);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant409); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:209:1: ruleConstant returns [EObject current=null] : ( (otherlv_0= 'const' | otherlv_1= 'CONST' ) ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '=' ( (lv_value_4_0= ruleNumberConst ) ) otherlv_5= ';' ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:212:28: ( ( (otherlv_0= 'const' | otherlv_1= 'CONST' ) ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '=' ( (lv_value_4_0= ruleNumberConst ) ) otherlv_5= ';' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:213:1: ( (otherlv_0= 'const' | otherlv_1= 'CONST' ) ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '=' ( (lv_value_4_0= ruleNumberConst ) ) otherlv_5= ';' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:213:1: ( (otherlv_0= 'const' | otherlv_1= 'CONST' ) ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '=' ( (lv_value_4_0= ruleNumberConst ) ) otherlv_5= ';' )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:213:2: (otherlv_0= 'const' | otherlv_1= 'CONST' ) ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '=' ( (lv_value_4_0= ruleNumberConst ) ) otherlv_5= ';'
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:213:2: (otherlv_0= 'const' | otherlv_1= 'CONST' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            else if ( (LA3_0==13) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:213:4: otherlv_0= 'const'
                    {
                    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleConstant447); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getConstantAccess().getConstKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:218:7: otherlv_1= 'CONST'
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleConstant465); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getConstantAccess().getCONSTKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:222:2: ( (lv_name_2_0= RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:223:1: (lv_name_2_0= RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:223:1: (lv_name_2_0= RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:224:3: lv_name_2_0= RULE_TIDENTIFIER
            {
            lv_name_2_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleConstant483); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getConstantAccess().getNameTIDENTIFIERTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getConstantRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"TIDENTIFIER");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleConstant500); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getConstantAccess().getEqualsSignKeyword_2());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:244:1: ( (lv_value_4_0= ruleNumberConst ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:245:1: (lv_value_4_0= ruleNumberConst )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:245:1: (lv_value_4_0= ruleNumberConst )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:246:3: lv_value_4_0= ruleNumberConst
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstantAccess().getValueNumberConstParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNumberConst_in_ruleConstant521);
            lv_value_4_0=ruleNumberConst();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConstantRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_4_0, 
                      		"NumberConst");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleConstant533); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getConstantAccess().getSemicolonKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleNumberConst"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:274:1: entryRuleNumberConst returns [EObject current=null] : iv_ruleNumberConst= ruleNumberConst EOF ;
    public final EObject entryRuleNumberConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberConst = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:275:2: (iv_ruleNumberConst= ruleNumberConst EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:276:2: iv_ruleNumberConst= ruleNumberConst EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberConstRule()); 
            }
            pushFollow(FOLLOW_ruleNumberConst_in_entryRuleNumberConst569);
            iv_ruleNumberConst=ruleNumberConst();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberConst; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberConst579); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberConst"


    // $ANTLR start "ruleNumberConst"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:283:1: ruleNumberConst returns [EObject current=null] : (this_IntConst_0= ruleIntConst | this_DoubleConst_1= ruleDoubleConst ) ;
    public final EObject ruleNumberConst() throws RecognitionException {
        EObject current = null;

        EObject this_IntConst_0 = null;

        EObject this_DoubleConst_1 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:286:28: ( (this_IntConst_0= ruleIntConst | this_DoubleConst_1= ruleDoubleConst ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:287:1: (this_IntConst_0= ruleIntConst | this_DoubleConst_1= ruleDoubleConst )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:287:1: (this_IntConst_0= ruleIntConst | this_DoubleConst_1= ruleDoubleConst )
            int alt4=2;
            switch ( input.LA(1) ) {
            case 48:
                {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==RULE_INT) ) {
                    int LA4_3 = input.LA(3);

                    if ( (LA4_3==75) ) {
                        alt4=2;
                    }
                    else if ( (LA4_3==EOF||LA4_3==15) ) {
                        alt4=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA4_1==74) ) {
                    alt4=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
                }
                break;
            case 49:
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==74) ) {
                    alt4=2;
                }
                else if ( (LA4_2==RULE_INT) ) {
                    int LA4_3 = input.LA(3);

                    if ( (LA4_3==75) ) {
                        alt4=2;
                    }
                    else if ( (LA4_3==EOF||LA4_3==15) ) {
                        alt4=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA4_3 = input.LA(2);

                if ( (LA4_3==75) ) {
                    alt4=2;
                }
                else if ( (LA4_3==EOF||LA4_3==15) ) {
                    alt4=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 3, input);

                    throw nvae;
                }
                }
                break;
            case 74:
                {
                alt4=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:288:5: this_IntConst_0= ruleIntConst
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumberConstAccess().getIntConstParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntConst_in_ruleNumberConst626);
                    this_IntConst_0=ruleIntConst();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IntConst_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:298:5: this_DoubleConst_1= ruleDoubleConst
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumberConstAccess().getDoubleConstParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDoubleConst_in_ruleNumberConst653);
                    this_DoubleConst_1=ruleDoubleConst();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DoubleConst_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberConst"


    // $ANTLR start "entryRuleIntConst"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:314:1: entryRuleIntConst returns [EObject current=null] : iv_ruleIntConst= ruleIntConst EOF ;
    public final EObject entryRuleIntConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntConst = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:315:2: (iv_ruleIntConst= ruleIntConst EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:316:2: iv_ruleIntConst= ruleIntConst EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntConstRule()); 
            }
            pushFollow(FOLLOW_ruleIntConst_in_entryRuleIntConst688);
            iv_ruleIntConst=ruleIntConst();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntConst; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntConst698); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntConst"


    // $ANTLR start "ruleIntConst"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:323:1: ruleIntConst returns [EObject current=null] : ( ( (lv_sign_0_0= ruleSign ) )? ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleIntConst() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        AntlrDatatypeRuleToken lv_sign_0_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:326:28: ( ( ( (lv_sign_0_0= ruleSign ) )? ( (lv_value_1_0= RULE_INT ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:327:1: ( ( (lv_sign_0_0= ruleSign ) )? ( (lv_value_1_0= RULE_INT ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:327:1: ( ( (lv_sign_0_0= ruleSign ) )? ( (lv_value_1_0= RULE_INT ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:327:2: ( (lv_sign_0_0= ruleSign ) )? ( (lv_value_1_0= RULE_INT ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:327:2: ( (lv_sign_0_0= ruleSign ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=48 && LA5_0<=49)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:328:1: (lv_sign_0_0= ruleSign )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:328:1: (lv_sign_0_0= ruleSign )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:329:3: lv_sign_0_0= ruleSign
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIntConstAccess().getSignSignParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSign_in_ruleIntConst744);
                    lv_sign_0_0=ruleSign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIntConstRule());
                      	        }
                             		set(
                             			current, 
                             			"sign",
                              		lv_sign_0_0, 
                              		"Sign");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:345:3: ( (lv_value_1_0= RULE_INT ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:346:1: (lv_value_1_0= RULE_INT )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:346:1: (lv_value_1_0= RULE_INT )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:347:3: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntConst762); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getIntConstAccess().getValueINTTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIntConstRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"INT");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntConst"


    // $ANTLR start "entryRuleDoubleConst"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:371:1: entryRuleDoubleConst returns [EObject current=null] : iv_ruleDoubleConst= ruleDoubleConst EOF ;
    public final EObject entryRuleDoubleConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleConst = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:372:2: (iv_ruleDoubleConst= ruleDoubleConst EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:373:2: iv_ruleDoubleConst= ruleDoubleConst EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDoubleConstRule()); 
            }
            pushFollow(FOLLOW_ruleDoubleConst_in_entryRuleDoubleConst803);
            iv_ruleDoubleConst=ruleDoubleConst();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDoubleConst; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoubleConst813); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDoubleConst"


    // $ANTLR start "ruleDoubleConst"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:380:1: ruleDoubleConst returns [EObject current=null] : ( ( (lv_sign_0_0= ruleSign ) )? ( (lv_value_1_0= ruleDouble ) ) ) ;
    public final EObject ruleDoubleConst() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_sign_0_0 = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:383:28: ( ( ( (lv_sign_0_0= ruleSign ) )? ( (lv_value_1_0= ruleDouble ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:384:1: ( ( (lv_sign_0_0= ruleSign ) )? ( (lv_value_1_0= ruleDouble ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:384:1: ( ( (lv_sign_0_0= ruleSign ) )? ( (lv_value_1_0= ruleDouble ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:384:2: ( (lv_sign_0_0= ruleSign ) )? ( (lv_value_1_0= ruleDouble ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:384:2: ( (lv_sign_0_0= ruleSign ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=48 && LA6_0<=49)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:385:1: (lv_sign_0_0= ruleSign )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:385:1: (lv_sign_0_0= ruleSign )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:386:3: lv_sign_0_0= ruleSign
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDoubleConstAccess().getSignSignParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSign_in_ruleDoubleConst859);
                    lv_sign_0_0=ruleSign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDoubleConstRule());
                      	        }
                             		set(
                             			current, 
                             			"sign",
                              		lv_sign_0_0, 
                              		"Sign");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:402:3: ( (lv_value_1_0= ruleDouble ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:403:1: (lv_value_1_0= ruleDouble )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:403:1: (lv_value_1_0= ruleDouble )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:404:3: lv_value_1_0= ruleDouble
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDoubleConstAccess().getValueDoubleParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDouble_in_ruleDoubleConst881);
            lv_value_1_0=ruleDouble();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDoubleConstRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"Double");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDoubleConst"


    // $ANTLR start "entryRuleVarInit"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:428:1: entryRuleVarInit returns [EObject current=null] : iv_ruleVarInit= ruleVarInit EOF ;
    public final EObject entryRuleVarInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarInit = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:429:2: (iv_ruleVarInit= ruleVarInit EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:430:2: iv_ruleVarInit= ruleVarInit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarInitRule()); 
            }
            pushFollow(FOLLOW_ruleVarInit_in_entryRuleVarInit917);
            iv_ruleVarInit=ruleVarInit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarInit; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarInit927); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarInit"


    // $ANTLR start "ruleVarInit"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:437:1: ruleVarInit returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_varAsgns_1_0= ruleVarAsgn ) ) (otherlv_2= ',' ( (lv_varAsgns_3_0= ruleVarAsgn ) ) )* ) ;
    public final EObject ruleVarInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        EObject lv_varAsgns_1_0 = null;

        EObject lv_varAsgns_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:440:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_varAsgns_1_0= ruleVarAsgn ) ) (otherlv_2= ',' ( (lv_varAsgns_3_0= ruleVarAsgn ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:441:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_varAsgns_1_0= ruleVarAsgn ) ) (otherlv_2= ',' ( (lv_varAsgns_3_0= ruleVarAsgn ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:441:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_varAsgns_1_0= ruleVarAsgn ) ) (otherlv_2= ',' ( (lv_varAsgns_3_0= ruleVarAsgn ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:441:2: ( (lv_type_0_0= ruleType ) ) ( (lv_varAsgns_1_0= ruleVarAsgn ) ) (otherlv_2= ',' ( (lv_varAsgns_3_0= ruleVarAsgn ) ) )*
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:441:2: ( (lv_type_0_0= ruleType ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:442:1: (lv_type_0_0= ruleType )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:442:1: (lv_type_0_0= ruleType )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:443:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVarInitAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleVarInit973);
            lv_type_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVarInitRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_0_0, 
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:459:2: ( (lv_varAsgns_1_0= ruleVarAsgn ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:460:1: (lv_varAsgns_1_0= ruleVarAsgn )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:460:1: (lv_varAsgns_1_0= ruleVarAsgn )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:461:3: lv_varAsgns_1_0= ruleVarAsgn
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVarInitAccess().getVarAsgnsVarAsgnParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVarAsgn_in_ruleVarInit994);
            lv_varAsgns_1_0=ruleVarAsgn();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVarInitRule());
              	        }
                     		add(
                     			current, 
                     			"varAsgns",
                      		lv_varAsgns_1_0, 
                      		"VarAsgn");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:477:2: (otherlv_2= ',' ( (lv_varAsgns_3_0= ruleVarAsgn ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==16) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:477:4: otherlv_2= ',' ( (lv_varAsgns_3_0= ruleVarAsgn ) )
            	    {
            	    otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleVarInit1007); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getVarInitAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:481:1: ( (lv_varAsgns_3_0= ruleVarAsgn ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:482:1: (lv_varAsgns_3_0= ruleVarAsgn )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:482:1: (lv_varAsgns_3_0= ruleVarAsgn )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:483:3: lv_varAsgns_3_0= ruleVarAsgn
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVarInitAccess().getVarAsgnsVarAsgnParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVarAsgn_in_ruleVarInit1028);
            	    lv_varAsgns_3_0=ruleVarAsgn();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getVarInitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"varAsgns",
            	              		lv_varAsgns_3_0, 
            	              		"VarAsgn");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarInit"


    // $ANTLR start "entryRuleVarAsgn"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:507:1: entryRuleVarAsgn returns [EObject current=null] : iv_ruleVarAsgn= ruleVarAsgn EOF ;
    public final EObject entryRuleVarAsgn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarAsgn = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:508:2: (iv_ruleVarAsgn= ruleVarAsgn EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:509:2: iv_ruleVarAsgn= ruleVarAsgn EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarAsgnRule()); 
            }
            pushFollow(FOLLOW_ruleVarAsgn_in_entryRuleVarAsgn1066);
            iv_ruleVarAsgn=ruleVarAsgn();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarAsgn; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarAsgn1076); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarAsgn"


    // $ANTLR start "ruleVarAsgn"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:516:1: ruleVarAsgn returns [EObject current=null] : ( ( ( (lv_input_0_0= 'input' ) )? ( (lv_var_1_0= ruleVar ) ) ) | ( () ( ( ( (lv_var_3_0= ruleVar ) ) otherlv_4= '=' ) | ( ( (lv_input_5_0= 'input' ) ) ( (lv_var_6_0= ruleVar ) ) otherlv_7= '~' ) ) ( (lv_expr_8_0= ruleExpr ) ) ) | ( () ( ( ( (lv_var_10_0= ruleVar ) ) otherlv_11= '=' ) | ( ( (lv_input_12_0= 'input' ) ) ( (lv_var_13_0= ruleVar ) ) otherlv_14= '~' ) ) ( (lv_fnBody_15_0= ruleFnBody ) ) ) ) ;
    public final EObject ruleVarAsgn() throws RecognitionException {
        EObject current = null;

        Token lv_input_0_0=null;
        Token otherlv_4=null;
        Token lv_input_5_0=null;
        Token otherlv_7=null;
        Token otherlv_11=null;
        Token lv_input_12_0=null;
        Token otherlv_14=null;
        EObject lv_var_1_0 = null;

        EObject lv_var_3_0 = null;

        EObject lv_var_6_0 = null;

        EObject lv_expr_8_0 = null;

        EObject lv_var_10_0 = null;

        EObject lv_var_13_0 = null;

        EObject lv_fnBody_15_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:519:28: ( ( ( ( (lv_input_0_0= 'input' ) )? ( (lv_var_1_0= ruleVar ) ) ) | ( () ( ( ( (lv_var_3_0= ruleVar ) ) otherlv_4= '=' ) | ( ( (lv_input_5_0= 'input' ) ) ( (lv_var_6_0= ruleVar ) ) otherlv_7= '~' ) ) ( (lv_expr_8_0= ruleExpr ) ) ) | ( () ( ( ( (lv_var_10_0= ruleVar ) ) otherlv_11= '=' ) | ( ( (lv_input_12_0= 'input' ) ) ( (lv_var_13_0= ruleVar ) ) otherlv_14= '~' ) ) ( (lv_fnBody_15_0= ruleFnBody ) ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:520:1: ( ( ( (lv_input_0_0= 'input' ) )? ( (lv_var_1_0= ruleVar ) ) ) | ( () ( ( ( (lv_var_3_0= ruleVar ) ) otherlv_4= '=' ) | ( ( (lv_input_5_0= 'input' ) ) ( (lv_var_6_0= ruleVar ) ) otherlv_7= '~' ) ) ( (lv_expr_8_0= ruleExpr ) ) ) | ( () ( ( ( (lv_var_10_0= ruleVar ) ) otherlv_11= '=' ) | ( ( (lv_input_12_0= 'input' ) ) ( (lv_var_13_0= ruleVar ) ) otherlv_14= '~' ) ) ( (lv_fnBody_15_0= ruleFnBody ) ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:520:1: ( ( ( (lv_input_0_0= 'input' ) )? ( (lv_var_1_0= ruleVar ) ) ) | ( () ( ( ( (lv_var_3_0= ruleVar ) ) otherlv_4= '=' ) | ( ( (lv_input_5_0= 'input' ) ) ( (lv_var_6_0= ruleVar ) ) otherlv_7= '~' ) ) ( (lv_expr_8_0= ruleExpr ) ) ) | ( () ( ( ( (lv_var_10_0= ruleVar ) ) otherlv_11= '=' ) | ( ( (lv_input_12_0= 'input' ) ) ( (lv_var_13_0= ruleVar ) ) otherlv_14= '~' ) ) ( (lv_fnBody_15_0= ruleFnBody ) ) ) )
            int alt11=3;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:520:2: ( ( (lv_input_0_0= 'input' ) )? ( (lv_var_1_0= ruleVar ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:520:2: ( ( (lv_input_0_0= 'input' ) )? ( (lv_var_1_0= ruleVar ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:520:3: ( (lv_input_0_0= 'input' ) )? ( (lv_var_1_0= ruleVar ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:520:3: ( (lv_input_0_0= 'input' ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==17) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:521:1: (lv_input_0_0= 'input' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:521:1: (lv_input_0_0= 'input' )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:522:3: lv_input_0_0= 'input'
                            {
                            lv_input_0_0=(Token)match(input,17,FOLLOW_17_in_ruleVarAsgn1120); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_input_0_0, grammarAccess.getVarAsgnAccess().getInputInputKeyword_0_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getVarAsgnRule());
                              	        }
                                     		setWithLastConsumed(current, "input", true, "input");
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:535:3: ( (lv_var_1_0= ruleVar ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:536:1: (lv_var_1_0= ruleVar )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:536:1: (lv_var_1_0= ruleVar )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:537:3: lv_var_1_0= ruleVar
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVarAsgnAccess().getVarVarParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVar_in_ruleVarAsgn1155);
                    lv_var_1_0=ruleVar();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVarAsgnRule());
                      	        }
                             		set(
                             			current, 
                             			"var",
                              		lv_var_1_0, 
                              		"Var");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:554:6: ( () ( ( ( (lv_var_3_0= ruleVar ) ) otherlv_4= '=' ) | ( ( (lv_input_5_0= 'input' ) ) ( (lv_var_6_0= ruleVar ) ) otherlv_7= '~' ) ) ( (lv_expr_8_0= ruleExpr ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:554:6: ( () ( ( ( (lv_var_3_0= ruleVar ) ) otherlv_4= '=' ) | ( ( (lv_input_5_0= 'input' ) ) ( (lv_var_6_0= ruleVar ) ) otherlv_7= '~' ) ) ( (lv_expr_8_0= ruleExpr ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:554:7: () ( ( ( (lv_var_3_0= ruleVar ) ) otherlv_4= '=' ) | ( ( (lv_input_5_0= 'input' ) ) ( (lv_var_6_0= ruleVar ) ) otherlv_7= '~' ) ) ( (lv_expr_8_0= ruleExpr ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:554:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:555:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getVarAsgnAccess().getExprVarAsgnAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:560:2: ( ( ( (lv_var_3_0= ruleVar ) ) otherlv_4= '=' ) | ( ( (lv_input_5_0= 'input' ) ) ( (lv_var_6_0= ruleVar ) ) otherlv_7= '~' ) )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==RULE_TIDENTIFIER) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==17) ) {
                        alt9=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:560:3: ( ( (lv_var_3_0= ruleVar ) ) otherlv_4= '=' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:560:3: ( ( (lv_var_3_0= ruleVar ) ) otherlv_4= '=' )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:560:4: ( (lv_var_3_0= ruleVar ) ) otherlv_4= '='
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:560:4: ( (lv_var_3_0= ruleVar ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:561:1: (lv_var_3_0= ruleVar )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:561:1: (lv_var_3_0= ruleVar )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:562:3: lv_var_3_0= ruleVar
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getVarAsgnAccess().getVarVarParserRuleCall_1_1_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleVar_in_ruleVarAsgn1195);
                            lv_var_3_0=ruleVar();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getVarAsgnRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"var",
                                      		lv_var_3_0, 
                                      		"Var");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleVarAsgn1207); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getVarAsgnAccess().getEqualsSignKeyword_1_1_0_1());
                                  
                            }

                            }


                            }
                            break;
                        case 2 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:583:6: ( ( (lv_input_5_0= 'input' ) ) ( (lv_var_6_0= ruleVar ) ) otherlv_7= '~' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:583:6: ( ( (lv_input_5_0= 'input' ) ) ( (lv_var_6_0= ruleVar ) ) otherlv_7= '~' )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:583:7: ( (lv_input_5_0= 'input' ) ) ( (lv_var_6_0= ruleVar ) ) otherlv_7= '~'
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:583:7: ( (lv_input_5_0= 'input' ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:584:1: (lv_input_5_0= 'input' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:584:1: (lv_input_5_0= 'input' )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:585:3: lv_input_5_0= 'input'
                            {
                            lv_input_5_0=(Token)match(input,17,FOLLOW_17_in_ruleVarAsgn1233); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_input_5_0, grammarAccess.getVarAsgnAccess().getInputInputKeyword_1_1_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getVarAsgnRule());
                              	        }
                                     		setWithLastConsumed(current, "input", true, "input");
                              	    
                            }

                            }


                            }

                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:598:2: ( (lv_var_6_0= ruleVar ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:599:1: (lv_var_6_0= ruleVar )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:599:1: (lv_var_6_0= ruleVar )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:600:3: lv_var_6_0= ruleVar
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getVarAsgnAccess().getVarVarParserRuleCall_1_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleVar_in_ruleVarAsgn1267);
                            lv_var_6_0=ruleVar();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getVarAsgnRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"var",
                                      		lv_var_6_0, 
                                      		"Var");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleVarAsgn1279); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getVarAsgnAccess().getTildeKeyword_1_1_1_2());
                                  
                            }

                            }


                            }
                            break;

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:620:3: ( (lv_expr_8_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:621:1: (lv_expr_8_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:621:1: (lv_expr_8_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:622:3: lv_expr_8_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVarAsgnAccess().getExprExprParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleVarAsgn1302);
                    lv_expr_8_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVarAsgnRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_8_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:639:6: ( () ( ( ( (lv_var_10_0= ruleVar ) ) otherlv_11= '=' ) | ( ( (lv_input_12_0= 'input' ) ) ( (lv_var_13_0= ruleVar ) ) otherlv_14= '~' ) ) ( (lv_fnBody_15_0= ruleFnBody ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:639:6: ( () ( ( ( (lv_var_10_0= ruleVar ) ) otherlv_11= '=' ) | ( ( (lv_input_12_0= 'input' ) ) ( (lv_var_13_0= ruleVar ) ) otherlv_14= '~' ) ) ( (lv_fnBody_15_0= ruleFnBody ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:639:7: () ( ( ( (lv_var_10_0= ruleVar ) ) otherlv_11= '=' ) | ( ( (lv_input_12_0= 'input' ) ) ( (lv_var_13_0= ruleVar ) ) otherlv_14= '~' ) ) ( (lv_fnBody_15_0= ruleFnBody ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:639:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:640:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getVarAsgnAccess().getFnVarAsgnAction_2_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:645:2: ( ( ( (lv_var_10_0= ruleVar ) ) otherlv_11= '=' ) | ( ( (lv_input_12_0= 'input' ) ) ( (lv_var_13_0= ruleVar ) ) otherlv_14= '~' ) )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==RULE_TIDENTIFIER) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==17) ) {
                        alt10=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:645:3: ( ( (lv_var_10_0= ruleVar ) ) otherlv_11= '=' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:645:3: ( ( (lv_var_10_0= ruleVar ) ) otherlv_11= '=' )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:645:4: ( (lv_var_10_0= ruleVar ) ) otherlv_11= '='
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:645:4: ( (lv_var_10_0= ruleVar ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:646:1: (lv_var_10_0= ruleVar )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:646:1: (lv_var_10_0= ruleVar )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:647:3: lv_var_10_0= ruleVar
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getVarAsgnAccess().getVarVarParserRuleCall_2_1_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleVar_in_ruleVarAsgn1342);
                            lv_var_10_0=ruleVar();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getVarAsgnRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"var",
                                      		lv_var_10_0, 
                                      		"Var");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_11=(Token)match(input,14,FOLLOW_14_in_ruleVarAsgn1354); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_11, grammarAccess.getVarAsgnAccess().getEqualsSignKeyword_2_1_0_1());
                                  
                            }

                            }


                            }
                            break;
                        case 2 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:668:6: ( ( (lv_input_12_0= 'input' ) ) ( (lv_var_13_0= ruleVar ) ) otherlv_14= '~' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:668:6: ( ( (lv_input_12_0= 'input' ) ) ( (lv_var_13_0= ruleVar ) ) otherlv_14= '~' )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:668:7: ( (lv_input_12_0= 'input' ) ) ( (lv_var_13_0= ruleVar ) ) otherlv_14= '~'
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:668:7: ( (lv_input_12_0= 'input' ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:669:1: (lv_input_12_0= 'input' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:669:1: (lv_input_12_0= 'input' )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:670:3: lv_input_12_0= 'input'
                            {
                            lv_input_12_0=(Token)match(input,17,FOLLOW_17_in_ruleVarAsgn1380); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_input_12_0, grammarAccess.getVarAsgnAccess().getInputInputKeyword_2_1_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getVarAsgnRule());
                              	        }
                                     		setWithLastConsumed(current, "input", true, "input");
                              	    
                            }

                            }


                            }

                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:683:2: ( (lv_var_13_0= ruleVar ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:684:1: (lv_var_13_0= ruleVar )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:684:1: (lv_var_13_0= ruleVar )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:685:3: lv_var_13_0= ruleVar
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getVarAsgnAccess().getVarVarParserRuleCall_2_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleVar_in_ruleVarAsgn1414);
                            lv_var_13_0=ruleVar();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getVarAsgnRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"var",
                                      		lv_var_13_0, 
                                      		"Var");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_14=(Token)match(input,18,FOLLOW_18_in_ruleVarAsgn1426); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_14, grammarAccess.getVarAsgnAccess().getTildeKeyword_2_1_1_2());
                                  
                            }

                            }


                            }
                            break;

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:705:3: ( (lv_fnBody_15_0= ruleFnBody ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:706:1: (lv_fnBody_15_0= ruleFnBody )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:706:1: (lv_fnBody_15_0= ruleFnBody )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:707:3: lv_fnBody_15_0= ruleFnBody
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVarAsgnAccess().getFnBodyFnBodyParserRuleCall_2_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFnBody_in_ruleVarAsgn1449);
                    lv_fnBody_15_0=ruleFnBody();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVarAsgnRule());
                      	        }
                             		set(
                             			current, 
                             			"fnBody",
                              		lv_fnBody_15_0, 
                              		"FnBody");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarAsgn"


    // $ANTLR start "entryRuleVar"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:731:1: entryRuleVar returns [EObject current=null] : iv_ruleVar= ruleVar EOF ;
    public final EObject entryRuleVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVar = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:732:2: (iv_ruleVar= ruleVar EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:733:2: iv_ruleVar= ruleVar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarRule()); 
            }
            pushFollow(FOLLOW_ruleVar_in_entryRuleVar1486);
            iv_ruleVar=ruleVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVar; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVar1496); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVar"


    // $ANTLR start "ruleVar"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:740:1: ruleVar returns [EObject current=null] : ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_dimensions_2_0= ruleDimension ) ) otherlv_3= ']' )* ) ;
    public final EObject ruleVar() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_dimensions_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:743:28: ( ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_dimensions_2_0= ruleDimension ) ) otherlv_3= ']' )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:744:1: ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_dimensions_2_0= ruleDimension ) ) otherlv_3= ']' )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:744:1: ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_dimensions_2_0= ruleDimension ) ) otherlv_3= ']' )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:744:2: ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_dimensions_2_0= ruleDimension ) ) otherlv_3= ']' )*
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:744:2: ( (lv_name_0_0= RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:745:1: (lv_name_0_0= RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:745:1: (lv_name_0_0= RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:746:3: lv_name_0_0= RULE_TIDENTIFIER
            {
            lv_name_0_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleVar1538); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getVarAccess().getNameTIDENTIFIERTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVarRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"TIDENTIFIER");
              	    
            }

            }


            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:762:2: (otherlv_1= '[' ( (lv_dimensions_2_0= ruleDimension ) ) otherlv_3= ']' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==19) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:762:4: otherlv_1= '[' ( (lv_dimensions_2_0= ruleDimension ) ) otherlv_3= ']'
            	    {
            	    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleVar1556); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getVarAccess().getLeftSquareBracketKeyword_1_0());
            	          
            	    }
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:766:1: ( (lv_dimensions_2_0= ruleDimension ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:767:1: (lv_dimensions_2_0= ruleDimension )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:767:1: (lv_dimensions_2_0= ruleDimension )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:768:3: lv_dimensions_2_0= ruleDimension
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVarAccess().getDimensionsDimensionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDimension_in_ruleVar1577);
            	    lv_dimensions_2_0=ruleDimension();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getVarRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"dimensions",
            	              		lv_dimensions_2_0, 
            	              		"Dimension");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleVar1589); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getVarAccess().getRightSquareBracketKeyword_1_2());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVar"


    // $ANTLR start "entryRuleDimension"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:796:1: entryRuleDimension returns [EObject current=null] : iv_ruleDimension= ruleDimension EOF ;
    public final EObject entryRuleDimension() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDimension = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:797:2: (iv_ruleDimension= ruleDimension EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:798:2: iv_ruleDimension= ruleDimension EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDimensionRule()); 
            }
            pushFollow(FOLLOW_ruleDimension_in_entryRuleDimension1627);
            iv_ruleDimension=ruleDimension();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDimension; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDimension1637); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDimension"


    // $ANTLR start "ruleDimension"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:805:1: ruleDimension returns [EObject current=null] : ( ( () ( (lv_index_1_0= RULE_INT ) ) ) | ( () otherlv_3= '#N' ) | ( () ( (lv_index_5_0= RULE_TIDENTIFIER ) ) ) ) ;
    public final EObject ruleDimension() throws RecognitionException {
        EObject current = null;

        Token lv_index_1_0=null;
        Token otherlv_3=null;
        Token lv_index_5_0=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:808:28: ( ( ( () ( (lv_index_1_0= RULE_INT ) ) ) | ( () otherlv_3= '#N' ) | ( () ( (lv_index_5_0= RULE_TIDENTIFIER ) ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:809:1: ( ( () ( (lv_index_1_0= RULE_INT ) ) ) | ( () otherlv_3= '#N' ) | ( () ( (lv_index_5_0= RULE_TIDENTIFIER ) ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:809:1: ( ( () ( (lv_index_1_0= RULE_INT ) ) ) | ( () otherlv_3= '#N' ) | ( () ( (lv_index_5_0= RULE_TIDENTIFIER ) ) ) )
            int alt13=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt13=1;
                }
                break;
            case 21:
                {
                alt13=2;
                }
                break;
            case RULE_TIDENTIFIER:
                {
                alt13=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:809:2: ( () ( (lv_index_1_0= RULE_INT ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:809:2: ( () ( (lv_index_1_0= RULE_INT ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:809:3: () ( (lv_index_1_0= RULE_INT ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:809:3: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:810:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getDimensionAccess().getIntDimensionAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:815:2: ( (lv_index_1_0= RULE_INT ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:816:1: (lv_index_1_0= RULE_INT )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:816:1: (lv_index_1_0= RULE_INT )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:817:3: lv_index_1_0= RULE_INT
                    {
                    lv_index_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDimension1689); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_index_1_0, grammarAccess.getDimensionAccess().getIndexINTTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDimensionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"index",
                              		lv_index_1_0, 
                              		"INT");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:834:6: ( () otherlv_3= '#N' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:834:6: ( () otherlv_3= '#N' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:834:7: () otherlv_3= '#N'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:834:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:835:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getDimensionAccess().getNodeNumDimensionAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleDimension1723); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getDimensionAccess().getNKeyword_1_1());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:845:6: ( () ( (lv_index_5_0= RULE_TIDENTIFIER ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:845:6: ( () ( (lv_index_5_0= RULE_TIDENTIFIER ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:845:7: () ( (lv_index_5_0= RULE_TIDENTIFIER ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:845:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:846:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getDimensionAccess().getIdDimensionAction_2_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:851:2: ( (lv_index_5_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:852:1: (lv_index_5_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:852:1: (lv_index_5_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:853:3: lv_index_5_0= RULE_TIDENTIFIER
                    {
                    lv_index_5_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleDimension1757); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_index_5_0, grammarAccess.getDimensionAccess().getIndexTIDENTIFIERTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDimensionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"index",
                              		lv_index_5_0, 
                              		"TIDENTIFIER");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDimension"


    // $ANTLR start "entryRuleType"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:877:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:878:2: (iv_ruleType= ruleType EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:879:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType1799);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType1809); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:886:1: ruleType returns [EObject current=null] : ( ( (lv_signed_0_0= ruleSigned ) )? ( (lv_simpType_1_0= ruleSimpType ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_signed_0_0 = null;

        AntlrDatatypeRuleToken lv_simpType_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:889:28: ( ( ( (lv_signed_0_0= ruleSigned ) )? ( (lv_simpType_1_0= ruleSimpType ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:890:1: ( ( (lv_signed_0_0= ruleSigned ) )? ( (lv_simpType_1_0= ruleSimpType ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:890:1: ( ( (lv_signed_0_0= ruleSigned ) )? ( (lv_simpType_1_0= ruleSimpType ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:890:2: ( (lv_signed_0_0= ruleSigned ) )? ( (lv_simpType_1_0= ruleSimpType ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:890:2: ( (lv_signed_0_0= ruleSigned ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=56 && LA14_0<=57)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:891:1: (lv_signed_0_0= ruleSigned )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:891:1: (lv_signed_0_0= ruleSigned )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:892:3: lv_signed_0_0= ruleSigned
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getSignedSignedParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSigned_in_ruleType1855);
                    lv_signed_0_0=ruleSigned();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"signed",
                              		lv_signed_0_0, 
                              		"Signed");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:908:3: ( (lv_simpType_1_0= ruleSimpType ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:909:1: (lv_simpType_1_0= ruleSimpType )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:909:1: (lv_simpType_1_0= ruleSimpType )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:910:3: lv_simpType_1_0= ruleSimpType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeAccess().getSimpTypeSimpTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSimpType_in_ruleType1877);
            lv_simpType_1_0=ruleSimpType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeRule());
              	        }
                     		set(
                     			current, 
                     			"simpType",
                      		lv_simpType_1_0, 
                      		"SimpType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleProcedure"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:934:1: entryRuleProcedure returns [EObject current=null] : iv_ruleProcedure= ruleProcedure EOF ;
    public final EObject entryRuleProcedure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcedure = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:935:2: (iv_ruleProcedure= ruleProcedure EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:936:2: iv_ruleProcedure= ruleProcedure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcedureRule()); 
            }
            pushFollow(FOLLOW_ruleProcedure_in_entryRuleProcedure1913);
            iv_ruleProcedure=ruleProcedure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcedure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcedure1923); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcedure"


    // $ANTLR start "ruleProcedure"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:943:1: ruleProcedure returns [EObject current=null] : ( (lv_procedure_0_0= ruleProcNoAttr ) ) ;
    public final EObject ruleProcedure() throws RecognitionException {
        EObject current = null;

        EObject lv_procedure_0_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:946:28: ( ( (lv_procedure_0_0= ruleProcNoAttr ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:947:1: ( (lv_procedure_0_0= ruleProcNoAttr ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:947:1: ( (lv_procedure_0_0= ruleProcNoAttr ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:948:1: (lv_procedure_0_0= ruleProcNoAttr )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:948:1: (lv_procedure_0_0= ruleProcNoAttr )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:949:3: lv_procedure_0_0= ruleProcNoAttr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProcedureAccess().getProcedureProcNoAttrParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleProcNoAttr_in_ruleProcedure1968);
            lv_procedure_0_0=ruleProcNoAttr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getProcedureRule());
              	        }
                     		set(
                     			current, 
                     			"procedure",
                      		lv_procedure_0_0, 
                      		"ProcNoAttr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcedure"


    // $ANTLR start "entryRuleProcNoAttr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:973:1: entryRuleProcNoAttr returns [EObject current=null] : iv_ruleProcNoAttr= ruleProcNoAttr EOF ;
    public final EObject entryRuleProcNoAttr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcNoAttr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:974:2: (iv_ruleProcNoAttr= ruleProcNoAttr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:975:2: iv_ruleProcNoAttr= ruleProcNoAttr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcNoAttrRule()); 
            }
            pushFollow(FOLLOW_ruleProcNoAttr_in_entryRuleProcNoAttr2003);
            iv_ruleProcNoAttr=ruleProcNoAttr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcNoAttr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcNoAttr2013); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcNoAttr"


    // $ANTLR start "ruleProcNoAttr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:982:1: ruleProcNoAttr returns [EObject current=null] : ( ( (lv_prototype_0_0= ruleFnPrototype ) ) (otherlv_1= ';' | ( (lv_fnBody_2_0= ruleFnBody ) ) ) ) ;
    public final EObject ruleProcNoAttr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_prototype_0_0 = null;

        EObject lv_fnBody_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:985:28: ( ( ( (lv_prototype_0_0= ruleFnPrototype ) ) (otherlv_1= ';' | ( (lv_fnBody_2_0= ruleFnBody ) ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:986:1: ( ( (lv_prototype_0_0= ruleFnPrototype ) ) (otherlv_1= ';' | ( (lv_fnBody_2_0= ruleFnBody ) ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:986:1: ( ( (lv_prototype_0_0= ruleFnPrototype ) ) (otherlv_1= ';' | ( (lv_fnBody_2_0= ruleFnBody ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:986:2: ( (lv_prototype_0_0= ruleFnPrototype ) ) (otherlv_1= ';' | ( (lv_fnBody_2_0= ruleFnBody ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:986:2: ( (lv_prototype_0_0= ruleFnPrototype ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:987:1: (lv_prototype_0_0= ruleFnPrototype )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:987:1: (lv_prototype_0_0= ruleFnPrototype )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:988:3: lv_prototype_0_0= ruleFnPrototype
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProcNoAttrAccess().getPrototypeFnPrototypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFnPrototype_in_ruleProcNoAttr2059);
            lv_prototype_0_0=ruleFnPrototype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getProcNoAttrRule());
              	        }
                     		set(
                     			current, 
                     			"prototype",
                      		lv_prototype_0_0, 
                      		"FnPrototype");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1004:2: (otherlv_1= ';' | ( (lv_fnBody_2_0= ruleFnBody ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==15) ) {
                alt15=1;
            }
            else if ( (LA15_0==22) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1004:4: otherlv_1= ';'
                    {
                    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleProcNoAttr2072); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getProcNoAttrAccess().getSemicolonKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1009:6: ( (lv_fnBody_2_0= ruleFnBody ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1009:6: ( (lv_fnBody_2_0= ruleFnBody ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1010:1: (lv_fnBody_2_0= ruleFnBody )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1010:1: (lv_fnBody_2_0= ruleFnBody )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1011:3: lv_fnBody_2_0= ruleFnBody
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getProcNoAttrAccess().getFnBodyFnBodyParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFnBody_in_ruleProcNoAttr2099);
                    lv_fnBody_2_0=ruleFnBody();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getProcNoAttrRule());
                      	        }
                             		set(
                             			current, 
                             			"fnBody",
                              		lv_fnBody_2_0, 
                              		"FnBody");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcNoAttr"


    // $ANTLR start "entryRuleFnBody"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1035:1: entryRuleFnBody returns [EObject current=null] : iv_ruleFnBody= ruleFnBody EOF ;
    public final EObject entryRuleFnBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFnBody = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1036:2: (iv_ruleFnBody= ruleFnBody EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1037:2: iv_ruleFnBody= ruleFnBody EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFnBodyRule()); 
            }
            pushFollow(FOLLOW_ruleFnBody_in_entryRuleFnBody2136);
            iv_ruleFnBody=ruleFnBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFnBody; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFnBody2146); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFnBody"


    // $ANTLR start "ruleFnBody"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1044:1: ruleFnBody returns [EObject current=null] : (otherlv_0= '{' ( (lv_varInitList_1_0= ruleVarInitList ) ) ( (lv_stmtList_2_0= ruleStmtList ) ) otherlv_3= '}' ) ;
    public final EObject ruleFnBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_varInitList_1_0 = null;

        EObject lv_stmtList_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1047:28: ( (otherlv_0= '{' ( (lv_varInitList_1_0= ruleVarInitList ) ) ( (lv_stmtList_2_0= ruleStmtList ) ) otherlv_3= '}' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1048:1: (otherlv_0= '{' ( (lv_varInitList_1_0= ruleVarInitList ) ) ( (lv_stmtList_2_0= ruleStmtList ) ) otherlv_3= '}' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1048:1: (otherlv_0= '{' ( (lv_varInitList_1_0= ruleVarInitList ) ) ( (lv_stmtList_2_0= ruleStmtList ) ) otherlv_3= '}' )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1048:3: otherlv_0= '{' ( (lv_varInitList_1_0= ruleVarInitList ) ) ( (lv_stmtList_2_0= ruleStmtList ) ) otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleFnBody2183); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFnBodyAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1052:1: ( (lv_varInitList_1_0= ruleVarInitList ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1053:1: (lv_varInitList_1_0= ruleVarInitList )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1053:1: (lv_varInitList_1_0= ruleVarInitList )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1054:3: lv_varInitList_1_0= ruleVarInitList
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFnBodyAccess().getVarInitListVarInitListParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVarInitList_in_ruleFnBody2204);
            lv_varInitList_1_0=ruleVarInitList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFnBodyRule());
              	        }
                     		set(
                     			current, 
                     			"varInitList",
                      		lv_varInitList_1_0, 
                      		"VarInitList");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1070:2: ( (lv_stmtList_2_0= ruleStmtList ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1071:1: (lv_stmtList_2_0= ruleStmtList )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1071:1: (lv_stmtList_2_0= ruleStmtList )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1072:3: lv_stmtList_2_0= ruleStmtList
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFnBodyAccess().getStmtListStmtListParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtList_in_ruleFnBody2225);
            lv_stmtList_2_0=ruleStmtList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFnBodyRule());
              	        }
                     		set(
                     			current, 
                     			"stmtList",
                      		lv_stmtList_2_0, 
                      		"StmtList");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleFnBody2237); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFnBodyAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFnBody"


    // $ANTLR start "entryRuleFnPrototype"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1100:1: entryRuleFnPrototype returns [EObject current=null] : iv_ruleFnPrototype= ruleFnPrototype EOF ;
    public final EObject entryRuleFnPrototype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFnPrototype = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1101:2: (iv_ruleFnPrototype= ruleFnPrototype EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1102:2: iv_ruleFnPrototype= ruleFnPrototype EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFnPrototypeRule()); 
            }
            pushFollow(FOLLOW_ruleFnPrototype_in_entryRuleFnPrototype2273);
            iv_ruleFnPrototype=ruleFnPrototype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFnPrototype; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFnPrototype2283); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFnPrototype"


    // $ANTLR start "ruleFnPrototype"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1109:1: ruleFnPrototype returns [EObject current=null] : ( ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) ) | ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' ) ) ;
    public final EObject ruleFnPrototype() throws RecognitionException {
        EObject current = null;

        Token lv_extern_1_1=null;
        Token lv_extern_1_2=null;
        Token lv_pure_2_1=null;
        Token lv_pure_2_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token lv_extern_6_1=null;
        Token lv_extern_6_2=null;
        Token lv_pure_7_1=null;
        Token lv_pure_7_2=null;
        Token lv_name_9_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_type_8_0 = null;

        EObject lv_params_11_0 = null;

        EObject lv_params_13_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1112:28: ( ( ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) ) | ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1113:1: ( ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) ) | ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1113:1: ( ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) ) | ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' ) )
            int alt26=2;
            switch ( input.LA(1) ) {
            case 24:
                {
                switch ( input.LA(2) ) {
                case 26:
                    {
                    int LA26_3 = input.LA(3);

                    if ( ((LA26_3>=50 && LA26_3<=57)) ) {
                        alt26=2;
                    }
                    else if ( (LA26_3==28) ) {
                        alt26=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 27:
                    {
                    int LA26_4 = input.LA(3);

                    if ( (LA26_4==28) ) {
                        alt26=1;
                    }
                    else if ( ((LA26_4>=50 && LA26_4<=57)) ) {
                        alt26=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    {
                    alt26=2;
                    }
                    break;
                case 28:
                    {
                    alt26=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }

                }
                break;
            case 25:
                {
                switch ( input.LA(2) ) {
                case 26:
                    {
                    int LA26_3 = input.LA(3);

                    if ( ((LA26_3>=50 && LA26_3<=57)) ) {
                        alt26=2;
                    }
                    else if ( (LA26_3==28) ) {
                        alt26=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 27:
                    {
                    int LA26_4 = input.LA(3);

                    if ( (LA26_4==28) ) {
                        alt26=1;
                    }
                    else if ( ((LA26_4>=50 && LA26_4<=57)) ) {
                        alt26=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 28:
                    {
                    alt26=1;
                    }
                    break;
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    {
                    alt26=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 2, input);

                    throw nvae;
                }

                }
                break;
            case 26:
                {
                int LA26_3 = input.LA(2);

                if ( ((LA26_3>=50 && LA26_3<=57)) ) {
                    alt26=2;
                }
                else if ( (LA26_3==28) ) {
                    alt26=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 3, input);

                    throw nvae;
                }
                }
                break;
            case 27:
                {
                int LA26_4 = input.LA(2);

                if ( (LA26_4==28) ) {
                    alt26=1;
                }
                else if ( ((LA26_4>=50 && LA26_4<=57)) ) {
                    alt26=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 4, input);

                    throw nvae;
                }
                }
                break;
            case 28:
                {
                alt26=1;
                }
                break;
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                {
                alt26=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1113:2: ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1113:2: ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1113:3: () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1113:3: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1114:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getFnPrototypeAccess().getThreadDeclarationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1119:2: ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( ((LA17_0>=24 && LA17_0<=25)) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1120:1: ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1120:1: ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1121:1: (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1121:1: (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' )
                            int alt16=2;
                            int LA16_0 = input.LA(1);

                            if ( (LA16_0==24) ) {
                                alt16=1;
                            }
                            else if ( (LA16_0==25) ) {
                                alt16=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 16, 0, input);

                                throw nvae;
                            }
                            switch (alt16) {
                                case 1 :
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1122:3: lv_extern_1_1= 'extern'
                                    {
                                    lv_extern_1_1=(Token)match(input,24,FOLLOW_24_in_ruleFnPrototype2338); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_extern_1_1, grammarAccess.getFnPrototypeAccess().getExternExternKeyword_0_1_0_0());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getFnPrototypeRule());
                                      	        }
                                             		setWithLastConsumed(current, "extern", true, null);
                                      	    
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1134:8: lv_extern_1_2= 'EXTERN'
                                    {
                                    lv_extern_1_2=(Token)match(input,25,FOLLOW_25_in_ruleFnPrototype2367); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_extern_1_2, grammarAccess.getFnPrototypeAccess().getExternEXTERNKeyword_0_1_0_1());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getFnPrototypeRule());
                                      	        }
                                             		setWithLastConsumed(current, "extern", true, null);
                                      	    
                                    }

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1149:3: ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( ((LA19_0>=26 && LA19_0<=27)) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1150:1: ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1150:1: ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1151:1: (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1151:1: (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' )
                            int alt18=2;
                            int LA18_0 = input.LA(1);

                            if ( (LA18_0==26) ) {
                                alt18=1;
                            }
                            else if ( (LA18_0==27) ) {
                                alt18=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 18, 0, input);

                                throw nvae;
                            }
                            switch (alt18) {
                                case 1 :
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1152:3: lv_pure_2_1= 'pure'
                                    {
                                    lv_pure_2_1=(Token)match(input,26,FOLLOW_26_in_ruleFnPrototype2404); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_pure_2_1, grammarAccess.getFnPrototypeAccess().getPurePureKeyword_0_2_0_0());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getFnPrototypeRule());
                                      	        }
                                             		setWithLastConsumed(current, "pure", true, null);
                                      	    
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1164:8: lv_pure_2_2= 'PURE'
                                    {
                                    lv_pure_2_2=(Token)match(input,27,FOLLOW_27_in_ruleFnPrototype2433); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_pure_2_2, grammarAccess.getFnPrototypeAccess().getPurePUREKeyword_0_2_0_1());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getFnPrototypeRule());
                                      	        }
                                             		setWithLastConsumed(current, "pure", true, null);
                                      	    
                                    }

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }

                    otherlv_3=(Token)match(input,28,FOLLOW_28_in_ruleFnPrototype2462); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getFnPrototypeAccess().getThreadKeyword_0_3());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1183:1: ( (lv_name_4_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1184:1: (lv_name_4_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1184:1: (lv_name_4_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1185:3: lv_name_4_0= RULE_TIDENTIFIER
                    {
                    lv_name_4_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleFnPrototype2479); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_4_0, grammarAccess.getFnPrototypeAccess().getNameTIDENTIFIERTerminalRuleCall_0_4_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFnPrototypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"TIDENTIFIER");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1202:6: ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1202:6: ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1202:7: () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1202:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1203:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getFnPrototypeAccess().getFnPrototypeDeclarationAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1208:2: ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( ((LA21_0>=24 && LA21_0<=25)) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1209:1: ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1209:1: ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1210:1: (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1210:1: (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' )
                            int alt20=2;
                            int LA20_0 = input.LA(1);

                            if ( (LA20_0==24) ) {
                                alt20=1;
                            }
                            else if ( (LA20_0==25) ) {
                                alt20=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 20, 0, input);

                                throw nvae;
                            }
                            switch (alt20) {
                                case 1 :
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1211:3: lv_extern_6_1= 'extern'
                                    {
                                    lv_extern_6_1=(Token)match(input,24,FOLLOW_24_in_ruleFnPrototype2521); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_extern_6_1, grammarAccess.getFnPrototypeAccess().getExternExternKeyword_1_1_0_0());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getFnPrototypeRule());
                                      	        }
                                             		setWithLastConsumed(current, "extern", true, null);
                                      	    
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1223:8: lv_extern_6_2= 'EXTERN'
                                    {
                                    lv_extern_6_2=(Token)match(input,25,FOLLOW_25_in_ruleFnPrototype2550); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_extern_6_2, grammarAccess.getFnPrototypeAccess().getExternEXTERNKeyword_1_1_0_1());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getFnPrototypeRule());
                                      	        }
                                             		setWithLastConsumed(current, "extern", true, null);
                                      	    
                                    }

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1238:3: ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( ((LA23_0>=26 && LA23_0<=27)) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1239:1: ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1239:1: ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1240:1: (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1240:1: (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' )
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0==26) ) {
                                alt22=1;
                            }
                            else if ( (LA22_0==27) ) {
                                alt22=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 22, 0, input);

                                throw nvae;
                            }
                            switch (alt22) {
                                case 1 :
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1241:3: lv_pure_7_1= 'pure'
                                    {
                                    lv_pure_7_1=(Token)match(input,26,FOLLOW_26_in_ruleFnPrototype2587); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_pure_7_1, grammarAccess.getFnPrototypeAccess().getPurePureKeyword_1_2_0_0());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getFnPrototypeRule());
                                      	        }
                                             		setWithLastConsumed(current, "pure", true, null);
                                      	    
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1253:8: lv_pure_7_2= 'PURE'
                                    {
                                    lv_pure_7_2=(Token)match(input,27,FOLLOW_27_in_ruleFnPrototype2616); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                              newLeafNode(lv_pure_7_2, grammarAccess.getFnPrototypeAccess().getPurePUREKeyword_1_2_0_1());
                                          
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getFnPrototypeRule());
                                      	        }
                                             		setWithLastConsumed(current, "pure", true, null);
                                      	    
                                    }

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1268:3: ( (lv_type_8_0= ruleType ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1269:1: (lv_type_8_0= ruleType )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1269:1: (lv_type_8_0= ruleType )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1270:3: lv_type_8_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFnPrototypeAccess().getTypeTypeParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleFnPrototype2654);
                    lv_type_8_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFnPrototypeRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_8_0, 
                              		"Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1286:2: ( (lv_name_9_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1287:1: (lv_name_9_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1287:1: (lv_name_9_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1288:3: lv_name_9_0= RULE_TIDENTIFIER
                    {
                    lv_name_9_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleFnPrototype2671); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_9_0, grammarAccess.getFnPrototypeAccess().getNameTIDENTIFIERTerminalRuleCall_1_4_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFnPrototypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_9_0, 
                              		"TIDENTIFIER");
                      	    
                    }

                    }


                    }

                    otherlv_10=(Token)match(input,29,FOLLOW_29_in_ruleFnPrototype2688); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getFnPrototypeAccess().getLeftParenthesisKeyword_1_5());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1308:1: ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( ((LA25_0>=50 && LA25_0<=57)) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1308:2: ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )*
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1308:2: ( (lv_params_11_0= ruleParam ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1309:1: (lv_params_11_0= ruleParam )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1309:1: (lv_params_11_0= ruleParam )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1310:3: lv_params_11_0= ruleParam
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getFnPrototypeAccess().getParamsParamParserRuleCall_1_6_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleParam_in_ruleFnPrototype2710);
                            lv_params_11_0=ruleParam();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getFnPrototypeRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"params",
                                      		lv_params_11_0, 
                                      		"Param");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1326:2: (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )*
                            loop24:
                            do {
                                int alt24=2;
                                int LA24_0 = input.LA(1);

                                if ( (LA24_0==16) ) {
                                    alt24=1;
                                }


                                switch (alt24) {
                            	case 1 :
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1326:4: otherlv_12= ',' ( (lv_params_13_0= ruleParam ) )
                            	    {
                            	    otherlv_12=(Token)match(input,16,FOLLOW_16_in_ruleFnPrototype2723); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_12, grammarAccess.getFnPrototypeAccess().getCommaKeyword_1_6_1_0());
                            	          
                            	    }
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1330:1: ( (lv_params_13_0= ruleParam ) )
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1331:1: (lv_params_13_0= ruleParam )
                            	    {
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1331:1: (lv_params_13_0= ruleParam )
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1332:3: lv_params_13_0= ruleParam
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getFnPrototypeAccess().getParamsParamParserRuleCall_1_6_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleParam_in_ruleFnPrototype2744);
                            	    lv_params_13_0=ruleParam();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getFnPrototypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"params",
                            	              		lv_params_13_0, 
                            	              		"Param");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop24;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_14=(Token)match(input,30,FOLLOW_30_in_ruleFnPrototype2760); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getFnPrototypeAccess().getRightParenthesisKeyword_1_7());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFnPrototype"


    // $ANTLR start "entryRuleAttrList"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1360:1: entryRuleAttrList returns [EObject current=null] : iv_ruleAttrList= ruleAttrList EOF ;
    public final EObject entryRuleAttrList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrList = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1361:2: (iv_ruleAttrList= ruleAttrList EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1362:2: iv_ruleAttrList= ruleAttrList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttrListRule()); 
            }
            pushFollow(FOLLOW_ruleAttrList_in_entryRuleAttrList2797);
            iv_ruleAttrList=ruleAttrList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttrList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttrList2807); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttrList"


    // $ANTLR start "ruleAttrList"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1369:1: ruleAttrList returns [EObject current=null] : ( ( (lv_attrs_0_0= ruleAttr ) ) otherlv_1= ';' )+ ;
    public final EObject ruleAttrList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_attrs_0_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1372:28: ( ( ( (lv_attrs_0_0= ruleAttr ) ) otherlv_1= ';' )+ )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1373:1: ( ( (lv_attrs_0_0= ruleAttr ) ) otherlv_1= ';' )+
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1373:1: ( ( (lv_attrs_0_0= ruleAttr ) ) otherlv_1= ';' )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==31) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1373:2: ( (lv_attrs_0_0= ruleAttr ) ) otherlv_1= ';'
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1373:2: ( (lv_attrs_0_0= ruleAttr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1374:1: (lv_attrs_0_0= ruleAttr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1374:1: (lv_attrs_0_0= ruleAttr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1375:3: lv_attrs_0_0= ruleAttr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrListAccess().getAttrsAttrParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAttr_in_ruleAttrList2853);
            	    lv_attrs_0_0=ruleAttr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAttrListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"attrs",
            	              		lv_attrs_0_0, 
            	              		"Attr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleAttrList2865); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getAttrListAccess().getSemicolonKeyword_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttrList"


    // $ANTLR start "entryRuleAttr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1403:1: entryRuleAttr returns [EObject current=null] : iv_ruleAttr= ruleAttr EOF ;
    public final EObject entryRuleAttr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1404:2: (iv_ruleAttr= ruleAttr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1405:2: iv_ruleAttr= ruleAttr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttrRule()); 
            }
            pushFollow(FOLLOW_ruleAttr_in_entryRuleAttr2902);
            iv_ruleAttr=ruleAttr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttr2912); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttr"


    // $ANTLR start "ruleAttr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1412:1: ruleAttr returns [EObject current=null] : (otherlv_0= '@' ( (lv_name_1_0= RULE_TIDENTIFIER ) ) (otherlv_2= '(' ( (lv_params_3_0= ruleExpr ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) ) )* otherlv_6= ')' )? ) ;
    public final EObject ruleAttr() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1415:28: ( (otherlv_0= '@' ( (lv_name_1_0= RULE_TIDENTIFIER ) ) (otherlv_2= '(' ( (lv_params_3_0= ruleExpr ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) ) )* otherlv_6= ')' )? ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1416:1: (otherlv_0= '@' ( (lv_name_1_0= RULE_TIDENTIFIER ) ) (otherlv_2= '(' ( (lv_params_3_0= ruleExpr ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) ) )* otherlv_6= ')' )? )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1416:1: (otherlv_0= '@' ( (lv_name_1_0= RULE_TIDENTIFIER ) ) (otherlv_2= '(' ( (lv_params_3_0= ruleExpr ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) ) )* otherlv_6= ')' )? )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1416:3: otherlv_0= '@' ( (lv_name_1_0= RULE_TIDENTIFIER ) ) (otherlv_2= '(' ( (lv_params_3_0= ruleExpr ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) ) )* otherlv_6= ')' )?
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleAttr2949); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAttrAccess().getCommercialAtKeyword_0());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1420:1: ( (lv_name_1_0= RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1421:1: (lv_name_1_0= RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1421:1: (lv_name_1_0= RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1422:3: lv_name_1_0= RULE_TIDENTIFIER
            {
            lv_name_1_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleAttr2966); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getAttrAccess().getNameTIDENTIFIERTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAttrRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"TIDENTIFIER");
              	    
            }

            }


            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1438:2: (otherlv_2= '(' ( (lv_params_3_0= ruleExpr ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) ) )* otherlv_6= ')' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==29) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1438:4: otherlv_2= '(' ( (lv_params_3_0= ruleExpr ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleAttr2984); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAttrAccess().getLeftParenthesisKeyword_2_0());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1442:1: ( (lv_params_3_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1443:1: (lv_params_3_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1443:1: (lv_params_3_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1444:3: lv_params_3_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAttrAccess().getParamsExprParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleAttr3005);
                    lv_params_3_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAttrRule());
                      	        }
                             		add(
                             			current, 
                             			"params",
                              		lv_params_3_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1460:2: (otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==16) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1460:4: otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleAttr3018); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getAttrAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1464:1: ( (lv_params_5_0= ruleExpr ) )
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1465:1: (lv_params_5_0= ruleExpr )
                    	    {
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1465:1: (lv_params_5_0= ruleExpr )
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1466:3: lv_params_5_0= ruleExpr
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAttrAccess().getParamsExprParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExpr_in_ruleAttr3039);
                    	    lv_params_5_0=ruleExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAttrRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"params",
                    	              		lv_params_5_0, 
                    	              		"Expr");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,30,FOLLOW_30_in_ruleAttr3053); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getAttrAccess().getRightParenthesisKeyword_2_3());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttr"


    // $ANTLR start "entryRuleParam"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1494:1: entryRuleParam returns [EObject current=null] : iv_ruleParam= ruleParam EOF ;
    public final EObject entryRuleParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParam = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1495:2: (iv_ruleParam= ruleParam EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1496:2: iv_ruleParam= ruleParam EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamRule()); 
            }
            pushFollow(FOLLOW_ruleParam_in_entryRuleParam3091);
            iv_ruleParam=ruleParam();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParam; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParam3101); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParam"


    // $ANTLR start "ruleParam"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1503:1: ruleParam returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_var_1_0= ruleVar ) ) ) ;
    public final EObject ruleParam() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        EObject lv_var_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1506:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_var_1_0= ruleVar ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1507:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_var_1_0= ruleVar ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1507:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_var_1_0= ruleVar ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1507:2: ( (lv_type_0_0= ruleType ) ) ( (lv_var_1_0= ruleVar ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1507:2: ( (lv_type_0_0= ruleType ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1508:1: (lv_type_0_0= ruleType )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1508:1: (lv_type_0_0= ruleType )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1509:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleParam3147);
            lv_type_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParamRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_0_0, 
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1525:2: ( (lv_var_1_0= ruleVar ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1526:1: (lv_var_1_0= ruleVar )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1526:1: (lv_var_1_0= ruleVar )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1527:3: lv_var_1_0= ruleVar
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamAccess().getVarVarParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVar_in_ruleParam3168);
            lv_var_1_0=ruleVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParamRule());
              	        }
                     		set(
                     			current, 
                     			"var",
                      		lv_var_1_0, 
                      		"Var");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParam"


    // $ANTLR start "entryRuleVarInitList"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1551:1: entryRuleVarInitList returns [EObject current=null] : iv_ruleVarInitList= ruleVarInitList EOF ;
    public final EObject entryRuleVarInitList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarInitList = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1552:2: (iv_ruleVarInitList= ruleVarInitList EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1553:2: iv_ruleVarInitList= ruleVarInitList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarInitListRule()); 
            }
            pushFollow(FOLLOW_ruleVarInitList_in_entryRuleVarInitList3204);
            iv_ruleVarInitList=ruleVarInitList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarInitList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarInitList3214); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarInitList"


    // $ANTLR start "ruleVarInitList"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1560:1: ruleVarInitList returns [EObject current=null] : ( () ( ( (lv_varInits_1_0= ruleVarInit ) ) otherlv_2= ';' )* ) ;
    public final EObject ruleVarInitList() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_varInits_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1563:28: ( ( () ( ( (lv_varInits_1_0= ruleVarInit ) ) otherlv_2= ';' )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1564:1: ( () ( ( (lv_varInits_1_0= ruleVarInit ) ) otherlv_2= ';' )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1564:1: ( () ( ( (lv_varInits_1_0= ruleVarInit ) ) otherlv_2= ';' )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1564:2: () ( ( (lv_varInits_1_0= ruleVarInit ) ) otherlv_2= ';' )*
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1564:2: ()
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1565:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getVarInitListAccess().getVarInitListAction_0(),
                          current);
                  
            }

            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1570:2: ( ( (lv_varInits_1_0= ruleVarInit ) ) otherlv_2= ';' )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=50 && LA30_0<=57)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1570:3: ( (lv_varInits_1_0= ruleVarInit ) ) otherlv_2= ';'
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1570:3: ( (lv_varInits_1_0= ruleVarInit ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1571:1: (lv_varInits_1_0= ruleVarInit )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1571:1: (lv_varInits_1_0= ruleVarInit )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1572:3: lv_varInits_1_0= ruleVarInit
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVarInitListAccess().getVarInitsVarInitParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVarInit_in_ruleVarInitList3270);
            	    lv_varInits_1_0=ruleVarInit();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getVarInitListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"varInits",
            	              		lv_varInits_1_0, 
            	              		"VarInit");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleVarInitList3282); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getVarInitListAccess().getSemicolonKeyword_1_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarInitList"


    // $ANTLR start "entryRuleStmtList"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1600:1: entryRuleStmtList returns [EObject current=null] : iv_ruleStmtList= ruleStmtList EOF ;
    public final EObject entryRuleStmtList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStmtList = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1601:2: (iv_ruleStmtList= ruleStmtList EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1602:2: iv_ruleStmtList= ruleStmtList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStmtListRule()); 
            }
            pushFollow(FOLLOW_ruleStmtList_in_entryRuleStmtList3320);
            iv_ruleStmtList=ruleStmtList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStmtList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStmtList3330); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStmtList"


    // $ANTLR start "ruleStmtList"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1609:1: ruleStmtList returns [EObject current=null] : ( () ( (lv_stmts_1_0= ruleStmt ) )* ) ;
    public final EObject ruleStmtList() throws RecognitionException {
        EObject current = null;

        EObject lv_stmts_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1612:28: ( ( () ( (lv_stmts_1_0= ruleStmt ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1613:1: ( () ( (lv_stmts_1_0= ruleStmt ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1613:1: ( () ( (lv_stmts_1_0= ruleStmt ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1613:2: () ( (lv_stmts_1_0= ruleStmt ) )*
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1613:2: ()
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1614:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getStmtListAccess().getStmtListAction_0(),
                          current);
                  
            }

            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1619:2: ( (lv_stmts_1_0= ruleStmt ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_TIDENTIFIER||LA31_0==22||(LA31_0>=31 && LA31_0<=32)||(LA31_0>=34 && LA31_0<=38)||(LA31_0>=58 && LA31_0<=67)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1620:1: (lv_stmts_1_0= ruleStmt )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1620:1: (lv_stmts_1_0= ruleStmt )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1621:3: lv_stmts_1_0= ruleStmt
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStmtListAccess().getStmtsStmtParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStmt_in_ruleStmtList3385);
            	    lv_stmts_1_0=ruleStmt();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getStmtListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"stmts",
            	              		lv_stmts_1_0, 
            	              		"Stmt");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStmtList"


    // $ANTLR start "entryRuleCondStmt"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1645:1: entryRuleCondStmt returns [EObject current=null] : iv_ruleCondStmt= ruleCondStmt EOF ;
    public final EObject entryRuleCondStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondStmt = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1646:2: (iv_ruleCondStmt= ruleCondStmt EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1647:2: iv_ruleCondStmt= ruleCondStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCondStmtRule()); 
            }
            pushFollow(FOLLOW_ruleCondStmt_in_entryRuleCondStmt3422);
            iv_ruleCondStmt=ruleCondStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCondStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCondStmt3432); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondStmt"


    // $ANTLR start "ruleCondStmt"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1654:1: ruleCondStmt returns [EObject current=null] : ( ( (lv_attrList_0_0= ruleAttrList ) )? otherlv_1= 'if' otherlv_2= '(' ( (lv_condition_3_0= ruleExpr ) ) otherlv_4= ')' ( (lv_then_5_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleStmt ) ) )? ) ;
    public final EObject ruleCondStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_attrList_0_0 = null;

        EObject lv_condition_3_0 = null;

        EObject lv_then_5_0 = null;

        EObject lv_else_7_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1657:28: ( ( ( (lv_attrList_0_0= ruleAttrList ) )? otherlv_1= 'if' otherlv_2= '(' ( (lv_condition_3_0= ruleExpr ) ) otherlv_4= ')' ( (lv_then_5_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleStmt ) ) )? ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1658:1: ( ( (lv_attrList_0_0= ruleAttrList ) )? otherlv_1= 'if' otherlv_2= '(' ( (lv_condition_3_0= ruleExpr ) ) otherlv_4= ')' ( (lv_then_5_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleStmt ) ) )? )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1658:1: ( ( (lv_attrList_0_0= ruleAttrList ) )? otherlv_1= 'if' otherlv_2= '(' ( (lv_condition_3_0= ruleExpr ) ) otherlv_4= ')' ( (lv_then_5_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleStmt ) ) )? )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1658:2: ( (lv_attrList_0_0= ruleAttrList ) )? otherlv_1= 'if' otherlv_2= '(' ( (lv_condition_3_0= ruleExpr ) ) otherlv_4= ')' ( (lv_then_5_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleStmt ) ) )?
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1658:2: ( (lv_attrList_0_0= ruleAttrList ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==31) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1659:1: (lv_attrList_0_0= ruleAttrList )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1659:1: (lv_attrList_0_0= ruleAttrList )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1660:3: lv_attrList_0_0= ruleAttrList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCondStmtAccess().getAttrListAttrListParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAttrList_in_ruleCondStmt3478);
                    lv_attrList_0_0=ruleAttrList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCondStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"attrList",
                              		lv_attrList_0_0, 
                              		"AttrList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleCondStmt3491); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCondStmtAccess().getIfKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleCondStmt3503); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCondStmtAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1684:1: ( (lv_condition_3_0= ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1685:1: (lv_condition_3_0= ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1685:1: (lv_condition_3_0= ruleExpr )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1686:3: lv_condition_3_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCondStmtAccess().getConditionExprParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpr_in_ruleCondStmt3524);
            lv_condition_3_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCondStmtRule());
              	        }
                     		set(
                     			current, 
                     			"condition",
                      		lv_condition_3_0, 
                      		"Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,30,FOLLOW_30_in_ruleCondStmt3536); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getCondStmtAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1706:1: ( (lv_then_5_0= ruleStmt ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1707:1: (lv_then_5_0= ruleStmt )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1707:1: (lv_then_5_0= ruleStmt )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1708:3: lv_then_5_0= ruleStmt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCondStmtAccess().getThenStmtParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmt_in_ruleCondStmt3557);
            lv_then_5_0=ruleStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCondStmtRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_5_0, 
                      		"Stmt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1724:2: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleStmt ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==33) ) {
                int LA33_1 = input.LA(2);

                if ( (synpred1_InternalDmpl()) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1724:3: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleStmt ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1724:3: ( ( 'else' )=>otherlv_6= 'else' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1724:4: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,33,FOLLOW_33_in_ruleCondStmt3578); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getCondStmtAccess().getElseKeyword_6_0());
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1729:2: ( (lv_else_7_0= ruleStmt ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1730:1: (lv_else_7_0= ruleStmt )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1730:1: (lv_else_7_0= ruleStmt )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1731:3: lv_else_7_0= ruleStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCondStmtAccess().getElseStmtParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmt_in_ruleCondStmt3600);
                    lv_else_7_0=ruleStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCondStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"else",
                              		lv_else_7_0, 
                              		"Stmt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondStmt"


    // $ANTLR start "entryRuleStmt"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1755:1: entryRuleStmt returns [EObject current=null] : iv_ruleStmt= ruleStmt EOF ;
    public final EObject entryRuleStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStmt = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1756:2: (iv_ruleStmt= ruleStmt EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1757:2: iv_ruleStmt= ruleStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStmtRule()); 
            }
            pushFollow(FOLLOW_ruleStmt_in_entryRuleStmt3638);
            iv_ruleStmt=ruleStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStmt3648); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStmt"


    // $ANTLR start "ruleStmt"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1764:1: ruleStmt returns [EObject current=null] : ( ( () otherlv_1= '{' ( (lv_stmtList_2_0= ruleStmtList ) ) otherlv_3= '}' ) | (this_AssignmentStmt_4= ruleAssignmentStmt otherlv_5= ';' ) | ( () otherlv_7= 'while' otherlv_8= '(' ( (lv_condition_9_0= ruleExpr ) ) otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) ) | ( () otherlv_13= 'for' otherlv_14= '(' ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )? otherlv_18= ';' ( (lv_condition_19_0= ruleExpr ) )? otherlv_20= ';' ( (lv_update_21_0= ruleAssignmentStmt ) )? otherlv_22= ')' ( (lv_stmt_23_0= ruleStmt ) ) ) | this_CondStmt_24= ruleCondStmt | ( () ( (lv_name_26_0= ruleSimpleStmtKeyword ) ) otherlv_27= ';' ) | ( () otherlv_29= 'return' ( (lv_value_30_0= ruleExpr ) ) otherlv_31= ';' ) | (this_CallExpr_32= ruleCallExpr otherlv_33= ';' ) | ( () ( (lv_name_35_0= ruleForAllFunction ) ) otherlv_36= '(' ( (lv_node_37_0= RULE_TIDENTIFIER ) ) otherlv_38= ')' ( (lv_stmt_39_0= ruleStmt ) ) ) | ( () (otherlv_41= 'forall_distinct_node_pair' | otherlv_42= 'FORALL_DISTINCT_NODE_PAIR' ) otherlv_43= '(' ( (lv_node1_44_0= RULE_TIDENTIFIER ) ) otherlv_45= ',' ( (lv_node2_46_0= RULE_TIDENTIFIER ) ) otherlv_47= ')' ( (lv_stmt_48_0= ruleStmt ) ) ) ) ;
    public final EObject ruleStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_36=null;
        Token lv_node_37_0=null;
        Token otherlv_38=null;
        Token otherlv_41=null;
        Token otherlv_42=null;
        Token otherlv_43=null;
        Token lv_node1_44_0=null;
        Token otherlv_45=null;
        Token lv_node2_46_0=null;
        Token otherlv_47=null;
        EObject lv_stmtList_2_0 = null;

        EObject this_AssignmentStmt_4 = null;

        EObject lv_condition_9_0 = null;

        EObject lv_stmt_11_0 = null;

        EObject lv_inits_15_0 = null;

        EObject lv_inits_17_0 = null;

        EObject lv_condition_19_0 = null;

        EObject lv_update_21_0 = null;

        EObject lv_stmt_23_0 = null;

        EObject this_CondStmt_24 = null;

        AntlrDatatypeRuleToken lv_name_26_0 = null;

        EObject lv_value_30_0 = null;

        EObject this_CallExpr_32 = null;

        AntlrDatatypeRuleToken lv_name_35_0 = null;

        EObject lv_stmt_39_0 = null;

        EObject lv_stmt_48_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1767:28: ( ( ( () otherlv_1= '{' ( (lv_stmtList_2_0= ruleStmtList ) ) otherlv_3= '}' ) | (this_AssignmentStmt_4= ruleAssignmentStmt otherlv_5= ';' ) | ( () otherlv_7= 'while' otherlv_8= '(' ( (lv_condition_9_0= ruleExpr ) ) otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) ) | ( () otherlv_13= 'for' otherlv_14= '(' ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )? otherlv_18= ';' ( (lv_condition_19_0= ruleExpr ) )? otherlv_20= ';' ( (lv_update_21_0= ruleAssignmentStmt ) )? otherlv_22= ')' ( (lv_stmt_23_0= ruleStmt ) ) ) | this_CondStmt_24= ruleCondStmt | ( () ( (lv_name_26_0= ruleSimpleStmtKeyword ) ) otherlv_27= ';' ) | ( () otherlv_29= 'return' ( (lv_value_30_0= ruleExpr ) ) otherlv_31= ';' ) | (this_CallExpr_32= ruleCallExpr otherlv_33= ';' ) | ( () ( (lv_name_35_0= ruleForAllFunction ) ) otherlv_36= '(' ( (lv_node_37_0= RULE_TIDENTIFIER ) ) otherlv_38= ')' ( (lv_stmt_39_0= ruleStmt ) ) ) | ( () (otherlv_41= 'forall_distinct_node_pair' | otherlv_42= 'FORALL_DISTINCT_NODE_PAIR' ) otherlv_43= '(' ( (lv_node1_44_0= RULE_TIDENTIFIER ) ) otherlv_45= ',' ( (lv_node2_46_0= RULE_TIDENTIFIER ) ) otherlv_47= ')' ( (lv_stmt_48_0= ruleStmt ) ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1768:1: ( ( () otherlv_1= '{' ( (lv_stmtList_2_0= ruleStmtList ) ) otherlv_3= '}' ) | (this_AssignmentStmt_4= ruleAssignmentStmt otherlv_5= ';' ) | ( () otherlv_7= 'while' otherlv_8= '(' ( (lv_condition_9_0= ruleExpr ) ) otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) ) | ( () otherlv_13= 'for' otherlv_14= '(' ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )? otherlv_18= ';' ( (lv_condition_19_0= ruleExpr ) )? otherlv_20= ';' ( (lv_update_21_0= ruleAssignmentStmt ) )? otherlv_22= ')' ( (lv_stmt_23_0= ruleStmt ) ) ) | this_CondStmt_24= ruleCondStmt | ( () ( (lv_name_26_0= ruleSimpleStmtKeyword ) ) otherlv_27= ';' ) | ( () otherlv_29= 'return' ( (lv_value_30_0= ruleExpr ) ) otherlv_31= ';' ) | (this_CallExpr_32= ruleCallExpr otherlv_33= ';' ) | ( () ( (lv_name_35_0= ruleForAllFunction ) ) otherlv_36= '(' ( (lv_node_37_0= RULE_TIDENTIFIER ) ) otherlv_38= ')' ( (lv_stmt_39_0= ruleStmt ) ) ) | ( () (otherlv_41= 'forall_distinct_node_pair' | otherlv_42= 'FORALL_DISTINCT_NODE_PAIR' ) otherlv_43= '(' ( (lv_node1_44_0= RULE_TIDENTIFIER ) ) otherlv_45= ',' ( (lv_node2_46_0= RULE_TIDENTIFIER ) ) otherlv_47= ')' ( (lv_stmt_48_0= ruleStmt ) ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1768:1: ( ( () otherlv_1= '{' ( (lv_stmtList_2_0= ruleStmtList ) ) otherlv_3= '}' ) | (this_AssignmentStmt_4= ruleAssignmentStmt otherlv_5= ';' ) | ( () otherlv_7= 'while' otherlv_8= '(' ( (lv_condition_9_0= ruleExpr ) ) otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) ) | ( () otherlv_13= 'for' otherlv_14= '(' ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )? otherlv_18= ';' ( (lv_condition_19_0= ruleExpr ) )? otherlv_20= ';' ( (lv_update_21_0= ruleAssignmentStmt ) )? otherlv_22= ')' ( (lv_stmt_23_0= ruleStmt ) ) ) | this_CondStmt_24= ruleCondStmt | ( () ( (lv_name_26_0= ruleSimpleStmtKeyword ) ) otherlv_27= ';' ) | ( () otherlv_29= 'return' ( (lv_value_30_0= ruleExpr ) ) otherlv_31= ';' ) | (this_CallExpr_32= ruleCallExpr otherlv_33= ';' ) | ( () ( (lv_name_35_0= ruleForAllFunction ) ) otherlv_36= '(' ( (lv_node_37_0= RULE_TIDENTIFIER ) ) otherlv_38= ')' ( (lv_stmt_39_0= ruleStmt ) ) ) | ( () (otherlv_41= 'forall_distinct_node_pair' | otherlv_42= 'FORALL_DISTINCT_NODE_PAIR' ) otherlv_43= '(' ( (lv_node1_44_0= RULE_TIDENTIFIER ) ) otherlv_45= ',' ( (lv_node2_46_0= RULE_TIDENTIFIER ) ) otherlv_47= ')' ( (lv_stmt_48_0= ruleStmt ) ) ) )
            int alt39=10;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1768:2: ( () otherlv_1= '{' ( (lv_stmtList_2_0= ruleStmtList ) ) otherlv_3= '}' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1768:2: ( () otherlv_1= '{' ( (lv_stmtList_2_0= ruleStmtList ) ) otherlv_3= '}' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1768:3: () otherlv_1= '{' ( (lv_stmtList_2_0= ruleStmtList ) ) otherlv_3= '}'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1768:3: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1769:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStmtAccess().getNestedStmtAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleStmt3695); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getStmtAccess().getLeftCurlyBracketKeyword_0_1());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1778:1: ( (lv_stmtList_2_0= ruleStmtList ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1779:1: (lv_stmtList_2_0= ruleStmtList )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1779:1: (lv_stmtList_2_0= ruleStmtList )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1780:3: lv_stmtList_2_0= ruleStmtList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getStmtListStmtListParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmtList_in_ruleStmt3716);
                    lv_stmtList_2_0=ruleStmtList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"stmtList",
                              		lv_stmtList_2_0, 
                              		"StmtList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleStmt3728); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getStmtAccess().getRightCurlyBracketKeyword_0_3());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1801:6: (this_AssignmentStmt_4= ruleAssignmentStmt otherlv_5= ';' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1801:6: (this_AssignmentStmt_4= ruleAssignmentStmt otherlv_5= ';' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1802:5: this_AssignmentStmt_4= ruleAssignmentStmt otherlv_5= ';'
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStmtAccess().getAssignmentStmtParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAssignmentStmt_in_ruleStmt3758);
                    this_AssignmentStmt_4=ruleAssignmentStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AssignmentStmt_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleStmt3769); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getStmtAccess().getSemicolonKeyword_1_1());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1815:6: ( () otherlv_7= 'while' otherlv_8= '(' ( (lv_condition_9_0= ruleExpr ) ) otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1815:6: ( () otherlv_7= 'while' otherlv_8= '(' ( (lv_condition_9_0= ruleExpr ) ) otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1815:7: () otherlv_7= 'while' otherlv_8= '(' ( (lv_condition_9_0= ruleExpr ) ) otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1815:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1816:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStmtAccess().getWhileStmtAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_7=(Token)match(input,34,FOLLOW_34_in_ruleStmt3798); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getStmtAccess().getWhileKeyword_2_1());
                          
                    }
                    otherlv_8=(Token)match(input,29,FOLLOW_29_in_ruleStmt3810); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getStmtAccess().getLeftParenthesisKeyword_2_2());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1829:1: ( (lv_condition_9_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1830:1: (lv_condition_9_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1830:1: (lv_condition_9_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1831:3: lv_condition_9_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getConditionExprParserRuleCall_2_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleStmt3831);
                    lv_condition_9_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"condition",
                              		lv_condition_9_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_10=(Token)match(input,30,FOLLOW_30_in_ruleStmt3843); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getStmtAccess().getRightParenthesisKeyword_2_4());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1851:1: ( (lv_stmt_11_0= ruleStmt ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1852:1: (lv_stmt_11_0= ruleStmt )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1852:1: (lv_stmt_11_0= ruleStmt )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1853:3: lv_stmt_11_0= ruleStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getStmtStmtParserRuleCall_2_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmt_in_ruleStmt3864);
                    lv_stmt_11_0=ruleStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"stmt",
                              		lv_stmt_11_0, 
                              		"Stmt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1870:6: ( () otherlv_13= 'for' otherlv_14= '(' ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )? otherlv_18= ';' ( (lv_condition_19_0= ruleExpr ) )? otherlv_20= ';' ( (lv_update_21_0= ruleAssignmentStmt ) )? otherlv_22= ')' ( (lv_stmt_23_0= ruleStmt ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1870:6: ( () otherlv_13= 'for' otherlv_14= '(' ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )? otherlv_18= ';' ( (lv_condition_19_0= ruleExpr ) )? otherlv_20= ';' ( (lv_update_21_0= ruleAssignmentStmt ) )? otherlv_22= ')' ( (lv_stmt_23_0= ruleStmt ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1870:7: () otherlv_13= 'for' otherlv_14= '(' ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )? otherlv_18= ';' ( (lv_condition_19_0= ruleExpr ) )? otherlv_20= ';' ( (lv_update_21_0= ruleAssignmentStmt ) )? otherlv_22= ')' ( (lv_stmt_23_0= ruleStmt ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1870:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1871:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStmtAccess().getForStmtAction_3_0(),
                                  current);
                          
                    }

                    }

                    otherlv_13=(Token)match(input,35,FOLLOW_35_in_ruleStmt3893); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getStmtAccess().getForKeyword_3_1());
                          
                    }
                    otherlv_14=(Token)match(input,29,FOLLOW_29_in_ruleStmt3905); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getStmtAccess().getLeftParenthesisKeyword_3_2());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1884:1: ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==RULE_TIDENTIFIER) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1884:2: ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )*
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1884:2: ( (lv_inits_15_0= ruleAssignmentStmt ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1885:1: (lv_inits_15_0= ruleAssignmentStmt )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1885:1: (lv_inits_15_0= ruleAssignmentStmt )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1886:3: lv_inits_15_0= ruleAssignmentStmt
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getStmtAccess().getInitsAssignmentStmtParserRuleCall_3_3_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleAssignmentStmt_in_ruleStmt3927);
                            lv_inits_15_0=ruleAssignmentStmt();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getStmtRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"inits",
                                      		lv_inits_15_0, 
                                      		"AssignmentStmt");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1902:2: (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )*
                            loop34:
                            do {
                                int alt34=2;
                                int LA34_0 = input.LA(1);

                                if ( (LA34_0==16) ) {
                                    alt34=1;
                                }


                                switch (alt34) {
                            	case 1 :
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1902:4: otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) )
                            	    {
                            	    otherlv_16=(Token)match(input,16,FOLLOW_16_in_ruleStmt3940); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_16, grammarAccess.getStmtAccess().getCommaKeyword_3_3_1_0());
                            	          
                            	    }
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1906:1: ( (lv_inits_17_0= ruleAssignmentStmt ) )
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1907:1: (lv_inits_17_0= ruleAssignmentStmt )
                            	    {
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1907:1: (lv_inits_17_0= ruleAssignmentStmt )
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1908:3: lv_inits_17_0= ruleAssignmentStmt
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getStmtAccess().getInitsAssignmentStmtParserRuleCall_3_3_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleAssignmentStmt_in_ruleStmt3961);
                            	    lv_inits_17_0=ruleAssignmentStmt();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"inits",
                            	              		lv_inits_17_0, 
                            	              		"AssignmentStmt");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop34;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_18=(Token)match(input,15,FOLLOW_15_in_ruleStmt3977); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getStmtAccess().getSemicolonKeyword_3_4());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1928:1: ( (lv_condition_19_0= ruleExpr ) )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( ((LA36_0>=RULE_TIDENTIFIER && LA36_0<=RULE_INT)||LA36_0==18||LA36_0==21||LA36_0==29||LA36_0==46||(LA36_0>=48 && LA36_0<=49)||(LA36_0>=68 && LA36_0<=74)||LA36_0==87) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1929:1: (lv_condition_19_0= ruleExpr )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1929:1: (lv_condition_19_0= ruleExpr )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1930:3: lv_condition_19_0= ruleExpr
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getStmtAccess().getConditionExprParserRuleCall_3_5_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExpr_in_ruleStmt3998);
                            lv_condition_19_0=ruleExpr();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getStmtRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"condition",
                                      		lv_condition_19_0, 
                                      		"Expr");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }

                    otherlv_20=(Token)match(input,15,FOLLOW_15_in_ruleStmt4011); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getStmtAccess().getSemicolonKeyword_3_6());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1950:1: ( (lv_update_21_0= ruleAssignmentStmt ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==RULE_TIDENTIFIER) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1951:1: (lv_update_21_0= ruleAssignmentStmt )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1951:1: (lv_update_21_0= ruleAssignmentStmt )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1952:3: lv_update_21_0= ruleAssignmentStmt
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getStmtAccess().getUpdateAssignmentStmtParserRuleCall_3_7_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleAssignmentStmt_in_ruleStmt4032);
                            lv_update_21_0=ruleAssignmentStmt();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getStmtRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"update",
                                      		lv_update_21_0, 
                                      		"AssignmentStmt");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }

                    otherlv_22=(Token)match(input,30,FOLLOW_30_in_ruleStmt4045); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getStmtAccess().getRightParenthesisKeyword_3_8());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1972:1: ( (lv_stmt_23_0= ruleStmt ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1973:1: (lv_stmt_23_0= ruleStmt )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1973:1: (lv_stmt_23_0= ruleStmt )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1974:3: lv_stmt_23_0= ruleStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getStmtStmtParserRuleCall_3_9_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmt_in_ruleStmt4066);
                    lv_stmt_23_0=ruleStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"stmt",
                              		lv_stmt_23_0, 
                              		"Stmt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1992:5: this_CondStmt_24= ruleCondStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStmtAccess().getCondStmtParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleCondStmt_in_ruleStmt4095);
                    this_CondStmt_24=ruleCondStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CondStmt_24; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2001:6: ( () ( (lv_name_26_0= ruleSimpleStmtKeyword ) ) otherlv_27= ';' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2001:6: ( () ( (lv_name_26_0= ruleSimpleStmtKeyword ) ) otherlv_27= ';' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2001:7: () ( (lv_name_26_0= ruleSimpleStmtKeyword ) ) otherlv_27= ';'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2001:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2002:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStmtAccess().getSimpleStmtAction_5_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2007:2: ( (lv_name_26_0= ruleSimpleStmtKeyword ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2008:1: (lv_name_26_0= ruleSimpleStmtKeyword )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2008:1: (lv_name_26_0= ruleSimpleStmtKeyword )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2009:3: lv_name_26_0= ruleSimpleStmtKeyword
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getNameSimpleStmtKeywordParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSimpleStmtKeyword_in_ruleStmt4131);
                    lv_name_26_0=ruleSimpleStmtKeyword();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_26_0, 
                              		"SimpleStmtKeyword");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_27=(Token)match(input,15,FOLLOW_15_in_ruleStmt4143); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getStmtAccess().getSemicolonKeyword_5_2());
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2030:6: ( () otherlv_29= 'return' ( (lv_value_30_0= ruleExpr ) ) otherlv_31= ';' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2030:6: ( () otherlv_29= 'return' ( (lv_value_30_0= ruleExpr ) ) otherlv_31= ';' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2030:7: () otherlv_29= 'return' ( (lv_value_30_0= ruleExpr ) ) otherlv_31= ';'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2030:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2031:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStmtAccess().getReturnValueStmtAction_6_0(),
                                  current);
                          
                    }

                    }

                    otherlv_29=(Token)match(input,36,FOLLOW_36_in_ruleStmt4172); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_29, grammarAccess.getStmtAccess().getReturnKeyword_6_1());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2040:1: ( (lv_value_30_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2041:1: (lv_value_30_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2041:1: (lv_value_30_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2042:3: lv_value_30_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getValueExprParserRuleCall_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleStmt4193);
                    lv_value_30_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_30_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_31=(Token)match(input,15,FOLLOW_15_in_ruleStmt4205); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_31, grammarAccess.getStmtAccess().getSemicolonKeyword_6_3());
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2063:6: (this_CallExpr_32= ruleCallExpr otherlv_33= ';' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2063:6: (this_CallExpr_32= ruleCallExpr otherlv_33= ';' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2064:5: this_CallExpr_32= ruleCallExpr otherlv_33= ';'
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStmtAccess().getCallExprParserRuleCall_7_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleCallExpr_in_ruleStmt4235);
                    this_CallExpr_32=ruleCallExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CallExpr_32; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_33=(Token)match(input,15,FOLLOW_15_in_ruleStmt4246); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_33, grammarAccess.getStmtAccess().getSemicolonKeyword_7_1());
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2077:6: ( () ( (lv_name_35_0= ruleForAllFunction ) ) otherlv_36= '(' ( (lv_node_37_0= RULE_TIDENTIFIER ) ) otherlv_38= ')' ( (lv_stmt_39_0= ruleStmt ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2077:6: ( () ( (lv_name_35_0= ruleForAllFunction ) ) otherlv_36= '(' ( (lv_node_37_0= RULE_TIDENTIFIER ) ) otherlv_38= ')' ( (lv_stmt_39_0= ruleStmt ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2077:7: () ( (lv_name_35_0= ruleForAllFunction ) ) otherlv_36= '(' ( (lv_node_37_0= RULE_TIDENTIFIER ) ) otherlv_38= ')' ( (lv_stmt_39_0= ruleStmt ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2077:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2078:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStmtAccess().getForAllStmtAction_8_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2083:2: ( (lv_name_35_0= ruleForAllFunction ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2084:1: (lv_name_35_0= ruleForAllFunction )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2084:1: (lv_name_35_0= ruleForAllFunction )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2085:3: lv_name_35_0= ruleForAllFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getNameForAllFunctionParserRuleCall_8_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleForAllFunction_in_ruleStmt4284);
                    lv_name_35_0=ruleForAllFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_35_0, 
                              		"ForAllFunction");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_36=(Token)match(input,29,FOLLOW_29_in_ruleStmt4296); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_36, grammarAccess.getStmtAccess().getLeftParenthesisKeyword_8_2());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2105:1: ( (lv_node_37_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2106:1: (lv_node_37_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2106:1: (lv_node_37_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2107:3: lv_node_37_0= RULE_TIDENTIFIER
                    {
                    lv_node_37_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleStmt4313); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_node_37_0, grammarAccess.getStmtAccess().getNodeTIDENTIFIERTerminalRuleCall_8_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getStmtRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"node",
                              		lv_node_37_0, 
                              		"TIDENTIFIER");
                      	    
                    }

                    }


                    }

                    otherlv_38=(Token)match(input,30,FOLLOW_30_in_ruleStmt4330); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_38, grammarAccess.getStmtAccess().getRightParenthesisKeyword_8_4());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2127:1: ( (lv_stmt_39_0= ruleStmt ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2128:1: (lv_stmt_39_0= ruleStmt )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2128:1: (lv_stmt_39_0= ruleStmt )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2129:3: lv_stmt_39_0= ruleStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getStmtStmtParserRuleCall_8_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmt_in_ruleStmt4351);
                    lv_stmt_39_0=ruleStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"stmt",
                              		lv_stmt_39_0, 
                              		"Stmt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 10 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2146:6: ( () (otherlv_41= 'forall_distinct_node_pair' | otherlv_42= 'FORALL_DISTINCT_NODE_PAIR' ) otherlv_43= '(' ( (lv_node1_44_0= RULE_TIDENTIFIER ) ) otherlv_45= ',' ( (lv_node2_46_0= RULE_TIDENTIFIER ) ) otherlv_47= ')' ( (lv_stmt_48_0= ruleStmt ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2146:6: ( () (otherlv_41= 'forall_distinct_node_pair' | otherlv_42= 'FORALL_DISTINCT_NODE_PAIR' ) otherlv_43= '(' ( (lv_node1_44_0= RULE_TIDENTIFIER ) ) otherlv_45= ',' ( (lv_node2_46_0= RULE_TIDENTIFIER ) ) otherlv_47= ')' ( (lv_stmt_48_0= ruleStmt ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2146:7: () (otherlv_41= 'forall_distinct_node_pair' | otherlv_42= 'FORALL_DISTINCT_NODE_PAIR' ) otherlv_43= '(' ( (lv_node1_44_0= RULE_TIDENTIFIER ) ) otherlv_45= ',' ( (lv_node2_46_0= RULE_TIDENTIFIER ) ) otherlv_47= ')' ( (lv_stmt_48_0= ruleStmt ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2146:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2147:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStmtAccess().getFadnpStmtAction_9_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2152:2: (otherlv_41= 'forall_distinct_node_pair' | otherlv_42= 'FORALL_DISTINCT_NODE_PAIR' )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==37) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==38) ) {
                        alt38=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 0, input);

                        throw nvae;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2152:4: otherlv_41= 'forall_distinct_node_pair'
                            {
                            otherlv_41=(Token)match(input,37,FOLLOW_37_in_ruleStmt4381); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_41, grammarAccess.getStmtAccess().getForall_distinct_node_pairKeyword_9_1_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2157:7: otherlv_42= 'FORALL_DISTINCT_NODE_PAIR'
                            {
                            otherlv_42=(Token)match(input,38,FOLLOW_38_in_ruleStmt4399); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_42, grammarAccess.getStmtAccess().getFORALL_DISTINCT_NODE_PAIRKeyword_9_1_1());
                                  
                            }

                            }
                            break;

                    }

                    otherlv_43=(Token)match(input,29,FOLLOW_29_in_ruleStmt4412); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_43, grammarAccess.getStmtAccess().getLeftParenthesisKeyword_9_2());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2165:1: ( (lv_node1_44_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2166:1: (lv_node1_44_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2166:1: (lv_node1_44_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2167:3: lv_node1_44_0= RULE_TIDENTIFIER
                    {
                    lv_node1_44_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleStmt4429); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_node1_44_0, grammarAccess.getStmtAccess().getNode1TIDENTIFIERTerminalRuleCall_9_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getStmtRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"node1",
                              		lv_node1_44_0, 
                              		"TIDENTIFIER");
                      	    
                    }

                    }


                    }

                    otherlv_45=(Token)match(input,16,FOLLOW_16_in_ruleStmt4446); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_45, grammarAccess.getStmtAccess().getCommaKeyword_9_4());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2187:1: ( (lv_node2_46_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2188:1: (lv_node2_46_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2188:1: (lv_node2_46_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2189:3: lv_node2_46_0= RULE_TIDENTIFIER
                    {
                    lv_node2_46_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleStmt4463); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_node2_46_0, grammarAccess.getStmtAccess().getNode2TIDENTIFIERTerminalRuleCall_9_5_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getStmtRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"node2",
                              		lv_node2_46_0, 
                              		"TIDENTIFIER");
                      	    
                    }

                    }


                    }

                    otherlv_47=(Token)match(input,30,FOLLOW_30_in_ruleStmt4480); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_47, grammarAccess.getStmtAccess().getRightParenthesisKeyword_9_6());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2209:1: ( (lv_stmt_48_0= ruleStmt ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2210:1: (lv_stmt_48_0= ruleStmt )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2210:1: (lv_stmt_48_0= ruleStmt )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2211:3: lv_stmt_48_0= ruleStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getStmtStmtParserRuleCall_9_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmt_in_ruleStmt4501);
                    lv_stmt_48_0=ruleStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"stmt",
                              		lv_stmt_48_0, 
                              		"Stmt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStmt"


    // $ANTLR start "entryRuleAssignmentStmt"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2235:1: entryRuleAssignmentStmt returns [EObject current=null] : iv_ruleAssignmentStmt= ruleAssignmentStmt EOF ;
    public final EObject entryRuleAssignmentStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentStmt = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2236:2: (iv_ruleAssignmentStmt= ruleAssignmentStmt EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2237:2: iv_ruleAssignmentStmt= ruleAssignmentStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentStmtRule()); 
            }
            pushFollow(FOLLOW_ruleAssignmentStmt_in_entryRuleAssignmentStmt4538);
            iv_ruleAssignmentStmt=ruleAssignmentStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentStmt4548); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentStmt"


    // $ANTLR start "ruleAssignmentStmt"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2244:1: ruleAssignmentStmt returns [EObject current=null] : ( ( (lv_variable_0_0= ruleLVal ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpr ) ) ) ;
    public final EObject ruleAssignmentStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_variable_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2247:28: ( ( ( (lv_variable_0_0= ruleLVal ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpr ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2248:1: ( ( (lv_variable_0_0= ruleLVal ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpr ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2248:1: ( ( (lv_variable_0_0= ruleLVal ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpr ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2248:2: ( (lv_variable_0_0= ruleLVal ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpr ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2248:2: ( (lv_variable_0_0= ruleLVal ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2249:1: (lv_variable_0_0= ruleLVal )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2249:1: (lv_variable_0_0= ruleLVal )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2250:3: lv_variable_0_0= ruleLVal
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentStmtAccess().getVariableLValParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLVal_in_ruleAssignmentStmt4594);
            lv_variable_0_0=ruleLVal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssignmentStmtRule());
              	        }
                     		set(
                     			current, 
                     			"variable",
                      		lv_variable_0_0, 
                      		"LVal");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleAssignmentStmt4606); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAssignmentStmtAccess().getEqualsSignKeyword_1());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2270:1: ( (lv_value_2_0= ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2271:1: (lv_value_2_0= ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2271:1: (lv_value_2_0= ruleExpr )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2272:3: lv_value_2_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentStmtAccess().getValueExprParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpr_in_ruleAssignmentStmt4627);
            lv_value_2_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssignmentStmtRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_2_0, 
                      		"Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentStmt"


    // $ANTLR start "entryRuleLVal"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2296:1: entryRuleLVal returns [EObject current=null] : iv_ruleLVal= ruleLVal EOF ;
    public final EObject entryRuleLVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLVal = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2297:2: (iv_ruleLVal= ruleLVal EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2298:2: iv_ruleLVal= ruleLVal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLValRule()); 
            }
            pushFollow(FOLLOW_ruleLVal_in_entryRuleLVal4663);
            iv_ruleLVal=ruleLVal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLVal; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLVal4673); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLVal"


    // $ANTLR start "ruleLVal"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2305:1: ruleLVal returns [EObject current=null] : ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )* (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )? ) ;
    public final EObject ruleLVal() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_indices_2_0 = null;

        EObject lv_at_5_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2308:28: ( ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )* (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )? ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2309:1: ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )* (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )? )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2309:1: ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )* (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )? )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2309:2: ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )* (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )?
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2309:2: ( (lv_name_0_0= RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2310:1: (lv_name_0_0= RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2310:1: (lv_name_0_0= RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2311:3: lv_name_0_0= RULE_TIDENTIFIER
            {
            lv_name_0_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleLVal4715); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getLValAccess().getNameTIDENTIFIERTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getLValRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"TIDENTIFIER");
              	    
            }

            }


            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2327:2: (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==19) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2327:4: otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']'
            	    {
            	    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleLVal4733); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getLValAccess().getLeftSquareBracketKeyword_1_0());
            	          
            	    }
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2331:1: ( (lv_indices_2_0= ruleExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2332:1: (lv_indices_2_0= ruleExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2332:1: (lv_indices_2_0= ruleExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2333:3: lv_indices_2_0= ruleExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLValAccess().getIndicesExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpr_in_ruleLVal4754);
            	    lv_indices_2_0=ruleExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLValRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"indices",
            	              		lv_indices_2_0, 
            	              		"Expr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleLVal4766); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getLValAccess().getRightSquareBracketKeyword_1_2());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2353:3: (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==31) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2353:5: otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) )
                    {
                    otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleLVal4781); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getLValAccess().getCommercialAtKeyword_2_0());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2357:1: ( (lv_at_5_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2358:1: (lv_at_5_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2358:1: (lv_at_5_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2359:3: lv_at_5_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLValAccess().getAtExprParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleLVal4802);
                    lv_at_5_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLValRule());
                      	        }
                             		set(
                             			current, 
                             			"at",
                              		lv_at_5_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLVal"


    // $ANTLR start "entryRuleExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2383:1: entryRuleExpr returns [EObject current=null] : iv_ruleExpr= ruleExpr EOF ;
    public final EObject entryRuleExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2384:2: (iv_ruleExpr= ruleExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2385:2: iv_ruleExpr= ruleExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExprRule()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_entryRuleExpr4840);
            iv_ruleExpr=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpr4850); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpr"


    // $ANTLR start "ruleExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2392:1: ruleExpr returns [EObject current=null] : (this_OrExpr_0= ruleOrExpr ( ( ( ( () '?' ) )=> ( () otherlv_2= '?' ) ) ( (lv_then_3_0= ruleExpr ) ) otherlv_4= ':' ( (lv_else_5_0= ruleExpr ) ) )? ) ;
    public final EObject ruleExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_OrExpr_0 = null;

        EObject lv_then_3_0 = null;

        EObject lv_else_5_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2395:28: ( (this_OrExpr_0= ruleOrExpr ( ( ( ( () '?' ) )=> ( () otherlv_2= '?' ) ) ( (lv_then_3_0= ruleExpr ) ) otherlv_4= ':' ( (lv_else_5_0= ruleExpr ) ) )? ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2396:1: (this_OrExpr_0= ruleOrExpr ( ( ( ( () '?' ) )=> ( () otherlv_2= '?' ) ) ( (lv_then_3_0= ruleExpr ) ) otherlv_4= ':' ( (lv_else_5_0= ruleExpr ) ) )? )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2396:1: (this_OrExpr_0= ruleOrExpr ( ( ( ( () '?' ) )=> ( () otherlv_2= '?' ) ) ( (lv_then_3_0= ruleExpr ) ) otherlv_4= ':' ( (lv_else_5_0= ruleExpr ) ) )? )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2397:5: this_OrExpr_0= ruleOrExpr ( ( ( ( () '?' ) )=> ( () otherlv_2= '?' ) ) ( (lv_then_3_0= ruleExpr ) ) otherlv_4= ':' ( (lv_else_5_0= ruleExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExprAccess().getOrExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleOrExpr_in_ruleExpr4897);
            this_OrExpr_0=ruleOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_OrExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2405:1: ( ( ( ( () '?' ) )=> ( () otherlv_2= '?' ) ) ( (lv_then_3_0= ruleExpr ) ) otherlv_4= ':' ( (lv_else_5_0= ruleExpr ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==39) ) {
                int LA42_1 = input.LA(2);

                if ( (synpred2_InternalDmpl()) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2405:2: ( ( ( () '?' ) )=> ( () otherlv_2= '?' ) ) ( (lv_then_3_0= ruleExpr ) ) otherlv_4= ':' ( (lv_else_5_0= ruleExpr ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2405:2: ( ( ( () '?' ) )=> ( () otherlv_2= '?' ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2405:3: ( ( () '?' ) )=> ( () otherlv_2= '?' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2407:5: ( () otherlv_2= '?' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2407:6: () otherlv_2= '?'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2407:6: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2408:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getExprAccess().getTernaryExprConditionAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleExpr4932); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getExprAccess().getQuestionMarkKeyword_1_0_0_1());
                          
                    }

                    }


                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2417:3: ( (lv_then_3_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2418:1: (lv_then_3_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2418:1: (lv_then_3_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2419:3: lv_then_3_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExprAccess().getThenExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleExpr4955);
                    lv_then_3_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExprRule());
                      	        }
                             		set(
                             			current, 
                             			"then",
                              		lv_then_3_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,40,FOLLOW_40_in_ruleExpr4967); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getExprAccess().getColonKeyword_1_2());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2439:1: ( (lv_else_5_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2440:1: (lv_else_5_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2440:1: (lv_else_5_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2441:3: lv_else_5_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExprAccess().getElseExprParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleExpr4988);
                    lv_else_5_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExprRule());
                      	        }
                             		set(
                             			current, 
                             			"else",
                              		lv_else_5_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpr"


    // $ANTLR start "entryRuleOrExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2465:1: entryRuleOrExpr returns [EObject current=null] : iv_ruleOrExpr= ruleOrExpr EOF ;
    public final EObject entryRuleOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2466:2: (iv_ruleOrExpr= ruleOrExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2467:2: iv_ruleOrExpr= ruleOrExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExprRule()); 
            }
            pushFollow(FOLLOW_ruleOrExpr_in_entryRuleOrExpr5026);
            iv_ruleOrExpr=ruleOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrExpr5036); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpr"


    // $ANTLR start "ruleOrExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2474:1: ruleOrExpr returns [EObject current=null] : (this_AndExpr_0= ruleAndExpr ( ( ( ( () '||' ) )=> ( () otherlv_2= '||' ) ) ( (lv_right_3_0= ruleAndExpr ) ) )* ) ;
    public final EObject ruleOrExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2477:28: ( (this_AndExpr_0= ruleAndExpr ( ( ( ( () '||' ) )=> ( () otherlv_2= '||' ) ) ( (lv_right_3_0= ruleAndExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2478:1: (this_AndExpr_0= ruleAndExpr ( ( ( ( () '||' ) )=> ( () otherlv_2= '||' ) ) ( (lv_right_3_0= ruleAndExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2478:1: (this_AndExpr_0= ruleAndExpr ( ( ( ( () '||' ) )=> ( () otherlv_2= '||' ) ) ( (lv_right_3_0= ruleAndExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2479:5: this_AndExpr_0= ruleAndExpr ( ( ( ( () '||' ) )=> ( () otherlv_2= '||' ) ) ( (lv_right_3_0= ruleAndExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrExprAccess().getAndExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAndExpr_in_ruleOrExpr5083);
            this_AndExpr_0=ruleAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2487:1: ( ( ( ( () '||' ) )=> ( () otherlv_2= '||' ) ) ( (lv_right_3_0= ruleAndExpr ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==41) ) {
                    int LA43_2 = input.LA(2);

                    if ( (synpred3_InternalDmpl()) ) {
                        alt43=1;
                    }


                }


                switch (alt43) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2487:2: ( ( ( () '||' ) )=> ( () otherlv_2= '||' ) ) ( (lv_right_3_0= ruleAndExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2487:2: ( ( ( () '||' ) )=> ( () otherlv_2= '||' ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2487:3: ( ( () '||' ) )=> ( () otherlv_2= '||' )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2489:5: ( () otherlv_2= '||' )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2489:6: () otherlv_2= '||'
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2489:6: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2490:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getOrExprAccess().getOrExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleOrExpr5118); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getOrExprAccess().getVerticalLineVerticalLineKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2499:3: ( (lv_right_3_0= ruleAndExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2500:1: (lv_right_3_0= ruleAndExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2500:1: (lv_right_3_0= ruleAndExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2501:3: lv_right_3_0= ruleAndExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrExprAccess().getRightAndExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndExpr_in_ruleOrExpr5141);
            	    lv_right_3_0=ruleAndExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOrExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"AndExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpr"


    // $ANTLR start "entryRuleAndExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2525:1: entryRuleAndExpr returns [EObject current=null] : iv_ruleAndExpr= ruleAndExpr EOF ;
    public final EObject entryRuleAndExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2526:2: (iv_ruleAndExpr= ruleAndExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2527:2: iv_ruleAndExpr= ruleAndExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExprRule()); 
            }
            pushFollow(FOLLOW_ruleAndExpr_in_entryRuleAndExpr5179);
            iv_ruleAndExpr=ruleAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpr5189); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpr"


    // $ANTLR start "ruleAndExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2534:1: ruleAndExpr returns [EObject current=null] : (this_BitwiseOrExpr_0= ruleBitwiseOrExpr ( ( ( ( () '&&' ) )=> ( () otherlv_2= '&&' ) ) ( (lv_right_3_0= ruleBitwiseOrExpr ) ) )* ) ;
    public final EObject ruleAndExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BitwiseOrExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2537:28: ( (this_BitwiseOrExpr_0= ruleBitwiseOrExpr ( ( ( ( () '&&' ) )=> ( () otherlv_2= '&&' ) ) ( (lv_right_3_0= ruleBitwiseOrExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2538:1: (this_BitwiseOrExpr_0= ruleBitwiseOrExpr ( ( ( ( () '&&' ) )=> ( () otherlv_2= '&&' ) ) ( (lv_right_3_0= ruleBitwiseOrExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2538:1: (this_BitwiseOrExpr_0= ruleBitwiseOrExpr ( ( ( ( () '&&' ) )=> ( () otherlv_2= '&&' ) ) ( (lv_right_3_0= ruleBitwiseOrExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2539:5: this_BitwiseOrExpr_0= ruleBitwiseOrExpr ( ( ( ( () '&&' ) )=> ( () otherlv_2= '&&' ) ) ( (lv_right_3_0= ruleBitwiseOrExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndExprAccess().getBitwiseOrExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleBitwiseOrExpr_in_ruleAndExpr5236);
            this_BitwiseOrExpr_0=ruleBitwiseOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_BitwiseOrExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2547:1: ( ( ( ( () '&&' ) )=> ( () otherlv_2= '&&' ) ) ( (lv_right_3_0= ruleBitwiseOrExpr ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==42) ) {
                    int LA44_2 = input.LA(2);

                    if ( (synpred4_InternalDmpl()) ) {
                        alt44=1;
                    }


                }


                switch (alt44) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2547:2: ( ( ( () '&&' ) )=> ( () otherlv_2= '&&' ) ) ( (lv_right_3_0= ruleBitwiseOrExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2547:2: ( ( ( () '&&' ) )=> ( () otherlv_2= '&&' ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2547:3: ( ( () '&&' ) )=> ( () otherlv_2= '&&' )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2549:5: ( () otherlv_2= '&&' )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2549:6: () otherlv_2= '&&'
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2549:6: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2550:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndExprAccess().getAndExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleAndExpr5271); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getAndExprAccess().getAmpersandAmpersandKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2559:3: ( (lv_right_3_0= ruleBitwiseOrExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2560:1: (lv_right_3_0= ruleBitwiseOrExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2560:1: (lv_right_3_0= ruleBitwiseOrExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2561:3: lv_right_3_0= ruleBitwiseOrExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExprAccess().getRightBitwiseOrExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBitwiseOrExpr_in_ruleAndExpr5294);
            	    lv_right_3_0=ruleBitwiseOrExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAndExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"BitwiseOrExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpr"


    // $ANTLR start "entryRuleBitwiseOrExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2585:1: entryRuleBitwiseOrExpr returns [EObject current=null] : iv_ruleBitwiseOrExpr= ruleBitwiseOrExpr EOF ;
    public final EObject entryRuleBitwiseOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseOrExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2586:2: (iv_ruleBitwiseOrExpr= ruleBitwiseOrExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2587:2: iv_ruleBitwiseOrExpr= ruleBitwiseOrExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseOrExprRule()); 
            }
            pushFollow(FOLLOW_ruleBitwiseOrExpr_in_entryRuleBitwiseOrExpr5332);
            iv_ruleBitwiseOrExpr=ruleBitwiseOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseOrExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseOrExpr5342); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitwiseOrExpr"


    // $ANTLR start "ruleBitwiseOrExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2594:1: ruleBitwiseOrExpr returns [EObject current=null] : (this_XorExpr_0= ruleXorExpr ( ( ( ( () '|' ) )=> ( () otherlv_2= '|' ) ) ( (lv_right_3_0= ruleXorExpr ) ) )* ) ;
    public final EObject ruleBitwiseOrExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XorExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2597:28: ( (this_XorExpr_0= ruleXorExpr ( ( ( ( () '|' ) )=> ( () otherlv_2= '|' ) ) ( (lv_right_3_0= ruleXorExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2598:1: (this_XorExpr_0= ruleXorExpr ( ( ( ( () '|' ) )=> ( () otherlv_2= '|' ) ) ( (lv_right_3_0= ruleXorExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2598:1: (this_XorExpr_0= ruleXorExpr ( ( ( ( () '|' ) )=> ( () otherlv_2= '|' ) ) ( (lv_right_3_0= ruleXorExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2599:5: this_XorExpr_0= ruleXorExpr ( ( ( ( () '|' ) )=> ( () otherlv_2= '|' ) ) ( (lv_right_3_0= ruleXorExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBitwiseOrExprAccess().getXorExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXorExpr_in_ruleBitwiseOrExpr5389);
            this_XorExpr_0=ruleXorExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XorExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2607:1: ( ( ( ( () '|' ) )=> ( () otherlv_2= '|' ) ) ( (lv_right_3_0= ruleXorExpr ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==43) ) {
                    int LA45_2 = input.LA(2);

                    if ( (synpred5_InternalDmpl()) ) {
                        alt45=1;
                    }


                }


                switch (alt45) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2607:2: ( ( ( () '|' ) )=> ( () otherlv_2= '|' ) ) ( (lv_right_3_0= ruleXorExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2607:2: ( ( ( () '|' ) )=> ( () otherlv_2= '|' ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2607:3: ( ( () '|' ) )=> ( () otherlv_2= '|' )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2609:5: ( () otherlv_2= '|' )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2609:6: () otherlv_2= '|'
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2609:6: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2610:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBitwiseOrExprAccess().getBitwiseOrExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleBitwiseOrExpr5424); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getBitwiseOrExprAccess().getVerticalLineKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2619:3: ( (lv_right_3_0= ruleXorExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2620:1: (lv_right_3_0= ruleXorExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2620:1: (lv_right_3_0= ruleXorExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2621:3: lv_right_3_0= ruleXorExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBitwiseOrExprAccess().getRightXorExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXorExpr_in_ruleBitwiseOrExpr5447);
            	    lv_right_3_0=ruleXorExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBitwiseOrExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"XorExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitwiseOrExpr"


    // $ANTLR start "entryRuleXorExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2645:1: entryRuleXorExpr returns [EObject current=null] : iv_ruleXorExpr= ruleXorExpr EOF ;
    public final EObject entryRuleXorExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2646:2: (iv_ruleXorExpr= ruleXorExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2647:2: iv_ruleXorExpr= ruleXorExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXorExprRule()); 
            }
            pushFollow(FOLLOW_ruleXorExpr_in_entryRuleXorExpr5485);
            iv_ruleXorExpr=ruleXorExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXorExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXorExpr5495); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXorExpr"


    // $ANTLR start "ruleXorExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2654:1: ruleXorExpr returns [EObject current=null] : (this_BitwiseAndExpr_0= ruleBitwiseAndExpr ( ( ( ( () '^' ) )=> ( () otherlv_2= '^' ) ) ( (lv_right_3_0= ruleBitwiseAndExpr ) ) )* ) ;
    public final EObject ruleXorExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BitwiseAndExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2657:28: ( (this_BitwiseAndExpr_0= ruleBitwiseAndExpr ( ( ( ( () '^' ) )=> ( () otherlv_2= '^' ) ) ( (lv_right_3_0= ruleBitwiseAndExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2658:1: (this_BitwiseAndExpr_0= ruleBitwiseAndExpr ( ( ( ( () '^' ) )=> ( () otherlv_2= '^' ) ) ( (lv_right_3_0= ruleBitwiseAndExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2658:1: (this_BitwiseAndExpr_0= ruleBitwiseAndExpr ( ( ( ( () '^' ) )=> ( () otherlv_2= '^' ) ) ( (lv_right_3_0= ruleBitwiseAndExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2659:5: this_BitwiseAndExpr_0= ruleBitwiseAndExpr ( ( ( ( () '^' ) )=> ( () otherlv_2= '^' ) ) ( (lv_right_3_0= ruleBitwiseAndExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXorExprAccess().getBitwiseAndExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleBitwiseAndExpr_in_ruleXorExpr5542);
            this_BitwiseAndExpr_0=ruleBitwiseAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_BitwiseAndExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2667:1: ( ( ( ( () '^' ) )=> ( () otherlv_2= '^' ) ) ( (lv_right_3_0= ruleBitwiseAndExpr ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==44) ) {
                    int LA46_2 = input.LA(2);

                    if ( (synpred6_InternalDmpl()) ) {
                        alt46=1;
                    }


                }


                switch (alt46) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2667:2: ( ( ( () '^' ) )=> ( () otherlv_2= '^' ) ) ( (lv_right_3_0= ruleBitwiseAndExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2667:2: ( ( ( () '^' ) )=> ( () otherlv_2= '^' ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2667:3: ( ( () '^' ) )=> ( () otherlv_2= '^' )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2669:5: ( () otherlv_2= '^' )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2669:6: () otherlv_2= '^'
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2669:6: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2670:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXorExprAccess().getXorExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleXorExpr5577); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXorExprAccess().getCircumflexAccentKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2679:3: ( (lv_right_3_0= ruleBitwiseAndExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2680:1: (lv_right_3_0= ruleBitwiseAndExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2680:1: (lv_right_3_0= ruleBitwiseAndExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2681:3: lv_right_3_0= ruleBitwiseAndExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXorExprAccess().getRightBitwiseAndExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBitwiseAndExpr_in_ruleXorExpr5600);
            	    lv_right_3_0=ruleBitwiseAndExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getXorExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"BitwiseAndExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXorExpr"


    // $ANTLR start "entryRuleBitwiseAndExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2705:1: entryRuleBitwiseAndExpr returns [EObject current=null] : iv_ruleBitwiseAndExpr= ruleBitwiseAndExpr EOF ;
    public final EObject entryRuleBitwiseAndExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseAndExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2706:2: (iv_ruleBitwiseAndExpr= ruleBitwiseAndExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2707:2: iv_ruleBitwiseAndExpr= ruleBitwiseAndExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseAndExprRule()); 
            }
            pushFollow(FOLLOW_ruleBitwiseAndExpr_in_entryRuleBitwiseAndExpr5638);
            iv_ruleBitwiseAndExpr=ruleBitwiseAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseAndExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseAndExpr5648); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitwiseAndExpr"


    // $ANTLR start "ruleBitwiseAndExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2714:1: ruleBitwiseAndExpr returns [EObject current=null] : (this_EqualityExpr_0= ruleEqualityExpr ( ( ( ( () '&' ) )=> ( () otherlv_2= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )* ) ;
    public final EObject ruleBitwiseAndExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_EqualityExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2717:28: ( (this_EqualityExpr_0= ruleEqualityExpr ( ( ( ( () '&' ) )=> ( () otherlv_2= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2718:1: (this_EqualityExpr_0= ruleEqualityExpr ( ( ( ( () '&' ) )=> ( () otherlv_2= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2718:1: (this_EqualityExpr_0= ruleEqualityExpr ( ( ( ( () '&' ) )=> ( () otherlv_2= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2719:5: this_EqualityExpr_0= ruleEqualityExpr ( ( ( ( () '&' ) )=> ( () otherlv_2= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBitwiseAndExprAccess().getEqualityExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleEqualityExpr_in_ruleBitwiseAndExpr5695);
            this_EqualityExpr_0=ruleEqualityExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_EqualityExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2727:1: ( ( ( ( () '&' ) )=> ( () otherlv_2= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==45) ) {
                    int LA47_2 = input.LA(2);

                    if ( (synpred7_InternalDmpl()) ) {
                        alt47=1;
                    }


                }


                switch (alt47) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2727:2: ( ( ( () '&' ) )=> ( () otherlv_2= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2727:2: ( ( ( () '&' ) )=> ( () otherlv_2= '&' ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2727:3: ( ( () '&' ) )=> ( () otherlv_2= '&' )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2729:5: ( () otherlv_2= '&' )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2729:6: () otherlv_2= '&'
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2729:6: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2730:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBitwiseAndExprAccess().getBitwiseAndExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,45,FOLLOW_45_in_ruleBitwiseAndExpr5730); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getBitwiseAndExprAccess().getAmpersandKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2739:3: ( (lv_right_3_0= ruleEqualityExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2740:1: (lv_right_3_0= ruleEqualityExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2740:1: (lv_right_3_0= ruleEqualityExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2741:3: lv_right_3_0= ruleEqualityExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBitwiseAndExprAccess().getRightEqualityExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEqualityExpr_in_ruleBitwiseAndExpr5753);
            	    lv_right_3_0=ruleEqualityExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBitwiseAndExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"EqualityExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitwiseAndExpr"


    // $ANTLR start "entryRuleEqualityExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2765:1: entryRuleEqualityExpr returns [EObject current=null] : iv_ruleEqualityExpr= ruleEqualityExpr EOF ;
    public final EObject entryRuleEqualityExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2766:2: (iv_ruleEqualityExpr= ruleEqualityExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2767:2: iv_ruleEqualityExpr= ruleEqualityExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExprRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpr_in_entryRuleEqualityExpr5791);
            iv_ruleEqualityExpr=ruleEqualityExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpr5801); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualityExpr"


    // $ANTLR start "ruleEqualityExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2774:1: ruleEqualityExpr returns [EObject current=null] : (this_CompareExpr_0= ruleCompareExpr ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )* ) ;
    public final EObject ruleEqualityExpr() throws RecognitionException {
        EObject current = null;

        EObject this_CompareExpr_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2777:28: ( (this_CompareExpr_0= ruleCompareExpr ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2778:1: (this_CompareExpr_0= ruleCompareExpr ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2778:1: (this_CompareExpr_0= ruleCompareExpr ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2779:5: this_CompareExpr_0= ruleCompareExpr ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEqualityExprAccess().getCompareExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleCompareExpr_in_ruleEqualityExpr5848);
            this_CompareExpr_0=ruleCompareExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_CompareExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2787:1: ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==76) ) {
                    int LA48_2 = input.LA(2);

                    if ( (synpred8_InternalDmpl()) ) {
                        alt48=1;
                    }


                }
                else if ( (LA48_0==77) ) {
                    int LA48_3 = input.LA(2);

                    if ( (synpred8_InternalDmpl()) ) {
                        alt48=1;
                    }


                }


                switch (alt48) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2787:2: ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2787:2: ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2787:3: ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2792:6: ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2792:7: () ( (lv_operator_2_0= ruleEqualityOperator ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2792:7: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2793:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getEqualityExprAccess().getEqualityExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2798:2: ( (lv_operator_2_0= ruleEqualityOperator ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2799:1: (lv_operator_2_0= ruleEqualityOperator )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2799:1: (lv_operator_2_0= ruleEqualityOperator )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2800:3: lv_operator_2_0= ruleEqualityOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExprAccess().getOperatorEqualityOperatorEnumRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpr5897);
            	    lv_operator_2_0=ruleEqualityOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEqualityExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"EqualityOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2816:4: ( (lv_right_3_0= ruleCompareExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2817:1: (lv_right_3_0= ruleCompareExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2817:1: (lv_right_3_0= ruleCompareExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2818:3: lv_right_3_0= ruleCompareExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExprAccess().getRightCompareExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCompareExpr_in_ruleEqualityExpr5920);
            	    lv_right_3_0=ruleCompareExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEqualityExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"CompareExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityExpr"


    // $ANTLR start "entryRuleCompareExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2842:1: entryRuleCompareExpr returns [EObject current=null] : iv_ruleCompareExpr= ruleCompareExpr EOF ;
    public final EObject entryRuleCompareExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompareExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2843:2: (iv_ruleCompareExpr= ruleCompareExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2844:2: iv_ruleCompareExpr= ruleCompareExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompareExprRule()); 
            }
            pushFollow(FOLLOW_ruleCompareExpr_in_entryRuleCompareExpr5958);
            iv_ruleCompareExpr=ruleCompareExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompareExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompareExpr5968); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompareExpr"


    // $ANTLR start "ruleCompareExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2851:1: ruleCompareExpr returns [EObject current=null] : (this_ShiftExpr_0= ruleShiftExpr ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )* ) ;
    public final EObject ruleCompareExpr() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpr_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2854:28: ( (this_ShiftExpr_0= ruleShiftExpr ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2855:1: (this_ShiftExpr_0= ruleShiftExpr ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2855:1: (this_ShiftExpr_0= ruleShiftExpr ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2856:5: this_ShiftExpr_0= ruleShiftExpr ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getCompareExprAccess().getShiftExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleShiftExpr_in_ruleCompareExpr6015);
            this_ShiftExpr_0=ruleShiftExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ShiftExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2864:1: ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )*
            loop49:
            do {
                int alt49=2;
                switch ( input.LA(1) ) {
                case 78:
                    {
                    int LA49_2 = input.LA(2);

                    if ( (synpred9_InternalDmpl()) ) {
                        alt49=1;
                    }


                    }
                    break;
                case 79:
                    {
                    int LA49_3 = input.LA(2);

                    if ( (synpred9_InternalDmpl()) ) {
                        alt49=1;
                    }


                    }
                    break;
                case 80:
                    {
                    int LA49_4 = input.LA(2);

                    if ( (synpred9_InternalDmpl()) ) {
                        alt49=1;
                    }


                    }
                    break;
                case 81:
                    {
                    int LA49_5 = input.LA(2);

                    if ( (synpred9_InternalDmpl()) ) {
                        alt49=1;
                    }


                    }
                    break;

                }

                switch (alt49) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2864:2: ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2864:2: ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2864:3: ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2869:6: ( () ( (lv_operator_2_0= ruleCompareOperator ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2869:7: () ( (lv_operator_2_0= ruleCompareOperator ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2869:7: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2870:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getCompareExprAccess().getCompareExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2875:2: ( (lv_operator_2_0= ruleCompareOperator ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2876:1: (lv_operator_2_0= ruleCompareOperator )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2876:1: (lv_operator_2_0= ruleCompareOperator )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2877:3: lv_operator_2_0= ruleCompareOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCompareExprAccess().getOperatorCompareOperatorEnumRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCompareOperator_in_ruleCompareExpr6064);
            	    lv_operator_2_0=ruleCompareOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getCompareExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"CompareOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2893:4: ( (lv_right_3_0= ruleShiftExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2894:1: (lv_right_3_0= ruleShiftExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2894:1: (lv_right_3_0= ruleShiftExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2895:3: lv_right_3_0= ruleShiftExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCompareExprAccess().getRightShiftExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleShiftExpr_in_ruleCompareExpr6087);
            	    lv_right_3_0=ruleShiftExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getCompareExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"ShiftExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompareExpr"


    // $ANTLR start "entryRuleShiftExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2919:1: entryRuleShiftExpr returns [EObject current=null] : iv_ruleShiftExpr= ruleShiftExpr EOF ;
    public final EObject entryRuleShiftExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2920:2: (iv_ruleShiftExpr= ruleShiftExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2921:2: iv_ruleShiftExpr= ruleShiftExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShiftExprRule()); 
            }
            pushFollow(FOLLOW_ruleShiftExpr_in_entryRuleShiftExpr6125);
            iv_ruleShiftExpr=ruleShiftExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShiftExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleShiftExpr6135); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShiftExpr"


    // $ANTLR start "ruleShiftExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2928:1: ruleShiftExpr returns [EObject current=null] : (this_AdditiveExpr_0= ruleAdditiveExpr ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )* ) ;
    public final EObject ruleShiftExpr() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpr_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2931:28: ( (this_AdditiveExpr_0= ruleAdditiveExpr ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2932:1: (this_AdditiveExpr_0= ruleAdditiveExpr ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2932:1: (this_AdditiveExpr_0= ruleAdditiveExpr ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2933:5: this_AdditiveExpr_0= ruleAdditiveExpr ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getShiftExprAccess().getAdditiveExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAdditiveExpr_in_ruleShiftExpr6182);
            this_AdditiveExpr_0=ruleAdditiveExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AdditiveExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2941:1: ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==82) ) {
                    int LA50_2 = input.LA(2);

                    if ( (synpred10_InternalDmpl()) ) {
                        alt50=1;
                    }


                }
                else if ( (LA50_0==83) ) {
                    int LA50_3 = input.LA(2);

                    if ( (synpred10_InternalDmpl()) ) {
                        alt50=1;
                    }


                }


                switch (alt50) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2941:2: ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2941:2: ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2941:3: ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2946:6: ( () ( (lv_operator_2_0= ruleShiftOperator ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2946:7: () ( (lv_operator_2_0= ruleShiftOperator ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2946:7: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2947:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getShiftExprAccess().getShiftExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2952:2: ( (lv_operator_2_0= ruleShiftOperator ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2953:1: (lv_operator_2_0= ruleShiftOperator )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2953:1: (lv_operator_2_0= ruleShiftOperator )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2954:3: lv_operator_2_0= ruleShiftOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExprAccess().getOperatorShiftOperatorEnumRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleShiftOperator_in_ruleShiftExpr6231);
            	    lv_operator_2_0=ruleShiftOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getShiftExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"ShiftOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2970:4: ( (lv_right_3_0= ruleAdditiveExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2971:1: (lv_right_3_0= ruleAdditiveExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2971:1: (lv_right_3_0= ruleAdditiveExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2972:3: lv_right_3_0= ruleAdditiveExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExprAccess().getRightAdditiveExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpr_in_ruleShiftExpr6254);
            	    lv_right_3_0=ruleAdditiveExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getShiftExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"AdditiveExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftExpr"


    // $ANTLR start "entryRuleAdditiveExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2996:1: entryRuleAdditiveExpr returns [EObject current=null] : iv_ruleAdditiveExpr= ruleAdditiveExpr EOF ;
    public final EObject entryRuleAdditiveExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2997:2: (iv_ruleAdditiveExpr= ruleAdditiveExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2998:2: iv_ruleAdditiveExpr= ruleAdditiveExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExprRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpr_in_entryRuleAdditiveExpr6292);
            iv_ruleAdditiveExpr=ruleAdditiveExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpr6302); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpr"


    // $ANTLR start "ruleAdditiveExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3005:1: ruleAdditiveExpr returns [EObject current=null] : (this_MultiplicativeExpr_0= ruleMultiplicativeExpr ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )* ) ;
    public final EObject ruleAdditiveExpr() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpr_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3008:28: ( (this_MultiplicativeExpr_0= ruleMultiplicativeExpr ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3009:1: (this_MultiplicativeExpr_0= ruleMultiplicativeExpr ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3009:1: (this_MultiplicativeExpr_0= ruleMultiplicativeExpr ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3010:5: this_MultiplicativeExpr_0= ruleMultiplicativeExpr ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAdditiveExprAccess().getMultiplicativeExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpr_in_ruleAdditiveExpr6349);
            this_MultiplicativeExpr_0=ruleMultiplicativeExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MultiplicativeExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3018:1: ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==48) ) {
                    int LA51_2 = input.LA(2);

                    if ( (synpred11_InternalDmpl()) ) {
                        alt51=1;
                    }


                }
                else if ( (LA51_0==49) ) {
                    int LA51_3 = input.LA(2);

                    if ( (synpred11_InternalDmpl()) ) {
                        alt51=1;
                    }


                }


                switch (alt51) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3018:2: ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3018:2: ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3018:3: ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3023:6: ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3023:7: () ( (lv_operator_2_0= ruleAdditiveOperator ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3023:7: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3024:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAdditiveExprAccess().getAdditiveExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3029:2: ( (lv_operator_2_0= ruleAdditiveOperator ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3030:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3030:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3031:3: lv_operator_2_0= ruleAdditiveOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExprAccess().getOperatorAdditiveOperatorEnumRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpr6398);
            	    lv_operator_2_0=ruleAdditiveOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAdditiveExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"AdditiveOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3047:4: ( (lv_right_3_0= ruleMultiplicativeExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3048:1: (lv_right_3_0= ruleMultiplicativeExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3048:1: (lv_right_3_0= ruleMultiplicativeExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3049:3: lv_right_3_0= ruleMultiplicativeExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExprAccess().getRightMultiplicativeExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplicativeExpr_in_ruleAdditiveExpr6421);
            	    lv_right_3_0=ruleMultiplicativeExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAdditiveExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"MultiplicativeExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpr"


    // $ANTLR start "entryRuleMultiplicativeExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3073:1: entryRuleMultiplicativeExpr returns [EObject current=null] : iv_ruleMultiplicativeExpr= ruleMultiplicativeExpr EOF ;
    public final EObject entryRuleMultiplicativeExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3074:2: (iv_ruleMultiplicativeExpr= ruleMultiplicativeExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3075:2: iv_ruleMultiplicativeExpr= ruleMultiplicativeExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExprRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpr_in_entryRuleMultiplicativeExpr6459);
            iv_ruleMultiplicativeExpr=ruleMultiplicativeExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpr6469); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpr"


    // $ANTLR start "ruleMultiplicativeExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3082:1: ruleMultiplicativeExpr returns [EObject current=null] : (this_TerminalExpr_0= ruleTerminalExpr ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )* ) ;
    public final EObject ruleMultiplicativeExpr() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalExpr_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3085:28: ( (this_TerminalExpr_0= ruleTerminalExpr ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3086:1: (this_TerminalExpr_0= ruleTerminalExpr ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3086:1: (this_TerminalExpr_0= ruleTerminalExpr ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3087:5: this_TerminalExpr_0= ruleTerminalExpr ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplicativeExprAccess().getTerminalExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleTerminalExpr_in_ruleMultiplicativeExpr6516);
            this_TerminalExpr_0=ruleTerminalExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TerminalExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3095:1: ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )*
            loop52:
            do {
                int alt52=2;
                switch ( input.LA(1) ) {
                case 84:
                    {
                    int LA52_2 = input.LA(2);

                    if ( (synpred12_InternalDmpl()) ) {
                        alt52=1;
                    }


                    }
                    break;
                case 85:
                    {
                    int LA52_3 = input.LA(2);

                    if ( (synpred12_InternalDmpl()) ) {
                        alt52=1;
                    }


                    }
                    break;
                case 86:
                    {
                    int LA52_4 = input.LA(2);

                    if ( (synpred12_InternalDmpl()) ) {
                        alt52=1;
                    }


                    }
                    break;

                }

                switch (alt52) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3095:2: ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3095:2: ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3095:3: ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3100:6: ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3100:7: () ( (lv_operator_2_0= ruleMultiplicativeOperator ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3100:7: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3101:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplicativeExprAccess().getMultiplicativeExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3106:2: ( (lv_operator_2_0= ruleMultiplicativeOperator ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3107:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3107:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3108:3: lv_operator_2_0= ruleMultiplicativeOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExprAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpr6565);
            	    lv_operator_2_0=ruleMultiplicativeOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMultiplicativeExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"MultiplicativeOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3124:4: ( (lv_right_3_0= ruleTerminalExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3125:1: (lv_right_3_0= ruleTerminalExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3125:1: (lv_right_3_0= ruleTerminalExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3126:3: lv_right_3_0= ruleTerminalExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExprAccess().getRightTerminalExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTerminalExpr_in_ruleMultiplicativeExpr6588);
            	    lv_right_3_0=ruleTerminalExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMultiplicativeExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"TerminalExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpr"


    // $ANTLR start "entryRuleTerminalExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3150:1: entryRuleTerminalExpr returns [EObject current=null] : iv_ruleTerminalExpr= ruleTerminalExpr EOF ;
    public final EObject entryRuleTerminalExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3151:2: (iv_ruleTerminalExpr= ruleTerminalExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3152:2: iv_ruleTerminalExpr= ruleTerminalExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTerminalExprRule()); 
            }
            pushFollow(FOLLOW_ruleTerminalExpr_in_entryRuleTerminalExpr6626);
            iv_ruleTerminalExpr=ruleTerminalExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerminalExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalExpr6636); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminalExpr"


    // $ANTLR start "ruleTerminalExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3159:1: ruleTerminalExpr returns [EObject current=null] : (this_LVal_0= ruleLVal | ( () otherlv_2= 'id' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= ruleDouble ) ) ) | ( () otherlv_8= '#N' ) | ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) ) | ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' ) | this_CallExpr_19= ruleCallExpr | (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' ) ) ;
    public final EObject ruleTerminalExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_value_4_0=null;
        Token otherlv_8=null;
        Token otherlv_14=null;
        Token lv_firstArg_15_0=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        EObject this_LVal_0 = null;

        AntlrDatatypeRuleToken lv_value_6_0 = null;

        Enumerator lv_operator_10_0 = null;

        EObject lv_operand_11_0 = null;

        AntlrDatatypeRuleToken lv_function_13_0 = null;

        EObject lv_secondArg_17_0 = null;

        EObject this_CallExpr_19 = null;

        EObject this_Expr_21 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3162:28: ( (this_LVal_0= ruleLVal | ( () otherlv_2= 'id' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= ruleDouble ) ) ) | ( () otherlv_8= '#N' ) | ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) ) | ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' ) | this_CallExpr_19= ruleCallExpr | (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3163:1: (this_LVal_0= ruleLVal | ( () otherlv_2= 'id' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= ruleDouble ) ) ) | ( () otherlv_8= '#N' ) | ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) ) | ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' ) | this_CallExpr_19= ruleCallExpr | (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3163:1: (this_LVal_0= ruleLVal | ( () otherlv_2= 'id' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= ruleDouble ) ) ) | ( () otherlv_8= '#N' ) | ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) ) | ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' ) | this_CallExpr_19= ruleCallExpr | (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' ) )
            int alt53=9;
            alt53 = dfa53.predict(input);
            switch (alt53) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3164:5: this_LVal_0= ruleLVal
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalExprAccess().getLValParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLVal_in_ruleTerminalExpr6683);
                    this_LVal_0=ruleLVal();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LVal_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3173:6: ( () otherlv_2= 'id' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3173:6: ( () otherlv_2= 'id' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3173:7: () otherlv_2= 'id'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3173:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3174:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getIdExprAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,46,FOLLOW_46_in_ruleTerminalExpr6710); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTerminalExprAccess().getIdKeyword_1_1());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3184:6: ( () ( (lv_value_4_0= RULE_INT ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3184:6: ( () ( (lv_value_4_0= RULE_INT ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3184:7: () ( (lv_value_4_0= RULE_INT ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3184:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3185:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getIntExprAction_2_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3190:2: ( (lv_value_4_0= RULE_INT ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3191:1: (lv_value_4_0= RULE_INT )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3191:1: (lv_value_4_0= RULE_INT )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3192:3: lv_value_4_0= RULE_INT
                    {
                    lv_value_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTerminalExpr6744); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_4_0, grammarAccess.getTerminalExprAccess().getValueINTTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTerminalExprRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_4_0, 
                              		"INT");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3209:6: ( () ( (lv_value_6_0= ruleDouble ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3209:6: ( () ( (lv_value_6_0= ruleDouble ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3209:7: () ( (lv_value_6_0= ruleDouble ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3209:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3210:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getDoubleExprAction_3_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3215:2: ( (lv_value_6_0= ruleDouble ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3216:1: (lv_value_6_0= ruleDouble )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3216:1: (lv_value_6_0= ruleDouble )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3217:3: lv_value_6_0= ruleDouble
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerminalExprAccess().getValueDoubleParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDouble_in_ruleTerminalExpr6787);
                    lv_value_6_0=ruleDouble();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTerminalExprRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_6_0, 
                              		"Double");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3234:6: ( () otherlv_8= '#N' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3234:6: ( () otherlv_8= '#N' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3234:7: () otherlv_8= '#N'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3234:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3235:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getNodeNumExprAction_4_0(),
                                  current);
                          
                    }

                    }

                    otherlv_8=(Token)match(input,21,FOLLOW_21_in_ruleTerminalExpr6816); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getTerminalExprAccess().getNKeyword_4_1());
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3245:6: ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3245:6: ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3245:7: () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3245:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3246:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getUnaryExprAction_5_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3251:2: ( (lv_operator_10_0= ruleUnaryOperator ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3252:1: (lv_operator_10_0= ruleUnaryOperator )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3252:1: (lv_operator_10_0= ruleUnaryOperator )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3253:3: lv_operator_10_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerminalExprAccess().getOperatorUnaryOperatorEnumRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleTerminalExpr6854);
                    lv_operator_10_0=ruleUnaryOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTerminalExprRule());
                      	        }
                             		set(
                             			current, 
                             			"operator",
                              		lv_operator_10_0, 
                              		"UnaryOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3269:2: ( (lv_operand_11_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3270:1: (lv_operand_11_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3270:1: (lv_operand_11_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3271:3: lv_operand_11_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerminalExprAccess().getOperandExprParserRuleCall_5_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleTerminalExpr6875);
                    lv_operand_11_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTerminalExprRule());
                      	        }
                             		set(
                             			current, 
                             			"operand",
                              		lv_operand_11_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3288:6: ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3288:6: ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3288:7: () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3288:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3289:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getBuiltInExprAction_6_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3294:2: ( (lv_function_13_0= ruleBuiltInFunction ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3295:1: (lv_function_13_0= ruleBuiltInFunction )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3295:1: (lv_function_13_0= ruleBuiltInFunction )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3296:3: lv_function_13_0= ruleBuiltInFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerminalExprAccess().getFunctionBuiltInFunctionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBuiltInFunction_in_ruleTerminalExpr6913);
                    lv_function_13_0=ruleBuiltInFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTerminalExprRule());
                      	        }
                             		set(
                             			current, 
                             			"function",
                              		lv_function_13_0, 
                              		"BuiltInFunction");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_14=(Token)match(input,29,FOLLOW_29_in_ruleTerminalExpr6925); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getTerminalExprAccess().getLeftParenthesisKeyword_6_2());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3316:1: ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3317:1: (lv_firstArg_15_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3317:1: (lv_firstArg_15_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3318:3: lv_firstArg_15_0= RULE_TIDENTIFIER
                    {
                    lv_firstArg_15_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleTerminalExpr6942); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_firstArg_15_0, grammarAccess.getTerminalExprAccess().getFirstArgTIDENTIFIERTerminalRuleCall_6_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTerminalExprRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"firstArg",
                              		lv_firstArg_15_0, 
                              		"TIDENTIFIER");
                      	    
                    }

                    }


                    }

                    otherlv_16=(Token)match(input,16,FOLLOW_16_in_ruleTerminalExpr6959); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getTerminalExprAccess().getCommaKeyword_6_4());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3338:1: ( (lv_secondArg_17_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3339:1: (lv_secondArg_17_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3339:1: (lv_secondArg_17_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3340:3: lv_secondArg_17_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerminalExprAccess().getSecondArgExprParserRuleCall_6_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleTerminalExpr6980);
                    lv_secondArg_17_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTerminalExprRule());
                      	        }
                             		set(
                             			current, 
                             			"secondArg",
                              		lv_secondArg_17_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_18=(Token)match(input,30,FOLLOW_30_in_ruleTerminalExpr6992); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getTerminalExprAccess().getRightParenthesisKeyword_6_6());
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3362:5: this_CallExpr_19= ruleCallExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalExprAccess().getCallExprParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleCallExpr_in_ruleTerminalExpr7021);
                    this_CallExpr_19=ruleCallExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CallExpr_19; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3371:6: (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3371:6: (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3371:8: otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')'
                    {
                    otherlv_20=(Token)match(input,29,FOLLOW_29_in_ruleTerminalExpr7039); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getTerminalExprAccess().getLeftParenthesisKeyword_8_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalExprAccess().getExprParserRuleCall_8_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleTerminalExpr7061);
                    this_Expr_21=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Expr_21; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_22=(Token)match(input,30,FOLLOW_30_in_ruleTerminalExpr7072); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getTerminalExprAccess().getRightParenthesisKeyword_8_2());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminalExpr"


    // $ANTLR start "entryRuleCallExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3396:1: entryRuleCallExpr returns [EObject current=null] : iv_ruleCallExpr= ruleCallExpr EOF ;
    public final EObject entryRuleCallExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3397:2: (iv_ruleCallExpr= ruleCallExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3398:2: iv_ruleCallExpr= ruleCallExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallExprRule()); 
            }
            pushFollow(FOLLOW_ruleCallExpr_in_entryRuleCallExpr7109);
            iv_ruleCallExpr=ruleCallExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCallExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallExpr7119); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCallExpr"


    // $ANTLR start "ruleCallExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3405:1: ruleCallExpr returns [EObject current=null] : ( ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )? ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '(' ( ( (lv_args_4_0= ruleExpr ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) ) )* )? otherlv_7= ')' (otherlv_8= '@' ( (lv_at_9_0= ruleExpr ) ) )? ) ;
    public final EObject ruleCallExpr() throws RecognitionException {
        EObject current = null;

        Token lv_namespace_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_args_4_0 = null;

        EObject lv_args_6_0 = null;

        EObject lv_at_9_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3408:28: ( ( ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )? ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '(' ( ( (lv_args_4_0= ruleExpr ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) ) )* )? otherlv_7= ')' (otherlv_8= '@' ( (lv_at_9_0= ruleExpr ) ) )? ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3409:1: ( ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )? ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '(' ( ( (lv_args_4_0= ruleExpr ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) ) )* )? otherlv_7= ')' (otherlv_8= '@' ( (lv_at_9_0= ruleExpr ) ) )? )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3409:1: ( ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )? ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '(' ( ( (lv_args_4_0= ruleExpr ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) ) )* )? otherlv_7= ')' (otherlv_8= '@' ( (lv_at_9_0= ruleExpr ) ) )? )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3409:2: ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )? ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '(' ( ( (lv_args_4_0= ruleExpr ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) ) )* )? otherlv_7= ')' (otherlv_8= '@' ( (lv_at_9_0= ruleExpr ) ) )?
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3409:2: ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_TIDENTIFIER) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==47) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3409:3: ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3409:3: ( (lv_namespace_0_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3410:1: (lv_namespace_0_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3410:1: (lv_namespace_0_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3411:3: lv_namespace_0_0= RULE_TIDENTIFIER
                    {
                    lv_namespace_0_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleCallExpr7162); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_namespace_0_0, grammarAccess.getCallExprAccess().getNamespaceTIDENTIFIERTerminalRuleCall_0_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCallExprRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"namespace",
                              		lv_namespace_0_0, 
                              		"TIDENTIFIER");
                      	    
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,47,FOLLOW_47_in_ruleCallExpr7179); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCallExprAccess().getColonColonKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3431:3: ( (lv_name_2_0= RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3432:1: (lv_name_2_0= RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3432:1: (lv_name_2_0= RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3433:3: lv_name_2_0= RULE_TIDENTIFIER
            {
            lv_name_2_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleCallExpr7198); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getCallExprAccess().getNameTIDENTIFIERTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getCallExprRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"TIDENTIFIER");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleCallExpr7215); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getCallExprAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3453:1: ( ( (lv_args_4_0= ruleExpr ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=RULE_TIDENTIFIER && LA56_0<=RULE_INT)||LA56_0==18||LA56_0==21||LA56_0==29||LA56_0==46||(LA56_0>=48 && LA56_0<=49)||(LA56_0>=68 && LA56_0<=74)||LA56_0==87) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3453:2: ( (lv_args_4_0= ruleExpr ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) ) )*
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3453:2: ( (lv_args_4_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3454:1: (lv_args_4_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3454:1: (lv_args_4_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3455:3: lv_args_4_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallExprAccess().getArgsExprParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleCallExpr7237);
                    lv_args_4_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCallExprRule());
                      	        }
                             		add(
                             			current, 
                             			"args",
                              		lv_args_4_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3471:2: (otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==16) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3471:4: otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) )
                    	    {
                    	    otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleCallExpr7250); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getCallExprAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3475:1: ( (lv_args_6_0= ruleExpr ) )
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3476:1: (lv_args_6_0= ruleExpr )
                    	    {
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3476:1: (lv_args_6_0= ruleExpr )
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3477:3: lv_args_6_0= ruleExpr
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCallExprAccess().getArgsExprParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExpr_in_ruleCallExpr7271);
                    	    lv_args_6_0=ruleExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCallExprRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"args",
                    	              		lv_args_6_0, 
                    	              		"Expr");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,30,FOLLOW_30_in_ruleCallExpr7287); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getCallExprAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3497:1: (otherlv_8= '@' ( (lv_at_9_0= ruleExpr ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==31) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3497:3: otherlv_8= '@' ( (lv_at_9_0= ruleExpr ) )
                    {
                    otherlv_8=(Token)match(input,31,FOLLOW_31_in_ruleCallExpr7300); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getCallExprAccess().getCommercialAtKeyword_5_0());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3501:1: ( (lv_at_9_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3502:1: (lv_at_9_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3502:1: (lv_at_9_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3503:3: lv_at_9_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallExprAccess().getAtExprParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleCallExpr7321);
                    lv_at_9_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCallExprRule());
                      	        }
                             		set(
                             			current, 
                             			"at",
                              		lv_at_9_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCallExpr"


    // $ANTLR start "entryRuleSign"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3527:1: entryRuleSign returns [String current=null] : iv_ruleSign= ruleSign EOF ;
    public final String entryRuleSign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSign = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3528:2: (iv_ruleSign= ruleSign EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3529:2: iv_ruleSign= ruleSign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignRule()); 
            }
            pushFollow(FOLLOW_ruleSign_in_entryRuleSign7360);
            iv_ruleSign=ruleSign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSign7371); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSign"


    // $ANTLR start "ruleSign"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3536:1: ruleSign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleSign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3539:28: ( (kw= '+' | kw= '-' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3540:1: (kw= '+' | kw= '-' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3540:1: (kw= '+' | kw= '-' )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==48) ) {
                alt58=1;
            }
            else if ( (LA58_0==49) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3541:2: kw= '+'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleSign7409); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3548:2: kw= '-'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleSign7428); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSign"


    // $ANTLR start "entryRuleSimpType"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3561:1: entryRuleSimpType returns [String current=null] : iv_ruleSimpType= ruleSimpType EOF ;
    public final String entryRuleSimpType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSimpType = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3562:2: (iv_ruleSimpType= ruleSimpType EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3563:2: iv_ruleSimpType= ruleSimpType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpTypeRule()); 
            }
            pushFollow(FOLLOW_ruleSimpType_in_entryRuleSimpType7469);
            iv_ruleSimpType=ruleSimpType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpType.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpType7480); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpType"


    // $ANTLR start "ruleSimpType"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3570:1: ruleSimpType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'bool' | kw= '_Bool' | kw= 'int' | kw= 'double' | kw= 'void' | kw= 'char' ) ;
    public final AntlrDatatypeRuleToken ruleSimpType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3573:28: ( (kw= 'bool' | kw= '_Bool' | kw= 'int' | kw= 'double' | kw= 'void' | kw= 'char' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3574:1: (kw= 'bool' | kw= '_Bool' | kw= 'int' | kw= 'double' | kw= 'void' | kw= 'char' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3574:1: (kw= 'bool' | kw= '_Bool' | kw= 'int' | kw= 'double' | kw= 'void' | kw= 'char' )
            int alt59=6;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt59=1;
                }
                break;
            case 51:
                {
                alt59=2;
                }
                break;
            case 52:
                {
                alt59=3;
                }
                break;
            case 53:
                {
                alt59=4;
                }
                break;
            case 54:
                {
                alt59=5;
                }
                break;
            case 55:
                {
                alt59=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3575:2: kw= 'bool'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleSimpType7518); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpTypeAccess().getBoolKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3582:2: kw= '_Bool'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleSimpType7537); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpTypeAccess().get_BoolKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3589:2: kw= 'int'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleSimpType7556); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpTypeAccess().getIntKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3596:2: kw= 'double'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleSimpType7575); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpTypeAccess().getDoubleKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3603:2: kw= 'void'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleSimpType7594); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpTypeAccess().getVoidKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3610:2: kw= 'char'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleSimpType7613); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpTypeAccess().getCharKeyword_5()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpType"


    // $ANTLR start "entryRuleSigned"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3623:1: entryRuleSigned returns [String current=null] : iv_ruleSigned= ruleSigned EOF ;
    public final String entryRuleSigned() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSigned = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3624:2: (iv_ruleSigned= ruleSigned EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3625:2: iv_ruleSigned= ruleSigned EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedRule()); 
            }
            pushFollow(FOLLOW_ruleSigned_in_entryRuleSigned7654);
            iv_ruleSigned=ruleSigned();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSigned.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSigned7665); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSigned"


    // $ANTLR start "ruleSigned"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3632:1: ruleSigned returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'signed' | kw= 'unsigned' ) ;
    public final AntlrDatatypeRuleToken ruleSigned() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3635:28: ( (kw= 'signed' | kw= 'unsigned' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3636:1: (kw= 'signed' | kw= 'unsigned' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3636:1: (kw= 'signed' | kw= 'unsigned' )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==56) ) {
                alt60=1;
            }
            else if ( (LA60_0==57) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3637:2: kw= 'signed'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleSigned7703); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedAccess().getSignedKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3644:2: kw= 'unsigned'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleSigned7722); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedAccess().getUnsignedKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSigned"


    // $ANTLR start "entryRuleSimpleStmtKeyword"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3657:1: entryRuleSimpleStmtKeyword returns [String current=null] : iv_ruleSimpleStmtKeyword= ruleSimpleStmtKeyword EOF ;
    public final String entryRuleSimpleStmtKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSimpleStmtKeyword = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3658:2: (iv_ruleSimpleStmtKeyword= ruleSimpleStmtKeyword EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3659:2: iv_ruleSimpleStmtKeyword= ruleSimpleStmtKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleStmtKeywordRule()); 
            }
            pushFollow(FOLLOW_ruleSimpleStmtKeyword_in_entryRuleSimpleStmtKeyword7763);
            iv_ruleSimpleStmtKeyword=ruleSimpleStmtKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleStmtKeyword.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleStmtKeyword7774); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleStmtKeyword"


    // $ANTLR start "ruleSimpleStmtKeyword"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3666:1: ruleSimpleStmtKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'break' | kw= 'continue' | kw= 'return' ) ;
    public final AntlrDatatypeRuleToken ruleSimpleStmtKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3669:28: ( (kw= 'break' | kw= 'continue' | kw= 'return' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3670:1: (kw= 'break' | kw= 'continue' | kw= 'return' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3670:1: (kw= 'break' | kw= 'continue' | kw= 'return' )
            int alt61=3;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt61=1;
                }
                break;
            case 59:
                {
                alt61=2;
                }
                break;
            case 36:
                {
                alt61=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3671:2: kw= 'break'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleSimpleStmtKeyword7812); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpleStmtKeywordAccess().getBreakKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3678:2: kw= 'continue'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleSimpleStmtKeyword7831); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpleStmtKeywordAccess().getContinueKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3685:2: kw= 'return'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleSimpleStmtKeyword7850); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpleStmtKeywordAccess().getReturnKeyword_2()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleStmtKeyword"


    // $ANTLR start "entryRuleForAllFunction"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3698:1: entryRuleForAllFunction returns [String current=null] : iv_ruleForAllFunction= ruleForAllFunction EOF ;
    public final String entryRuleForAllFunction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleForAllFunction = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3699:2: (iv_ruleForAllFunction= ruleForAllFunction EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3700:2: iv_ruleForAllFunction= ruleForAllFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForAllFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleForAllFunction_in_entryRuleForAllFunction7891);
            iv_ruleForAllFunction=ruleForAllFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForAllFunction.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleForAllFunction7902); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForAllFunction"


    // $ANTLR start "ruleForAllFunction"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3707:1: ruleForAllFunction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'forall_node' | kw= 'FORALL_NODE' | kw= 'forall_other' | kw= 'FORALL_OTHER' | kw= 'forall_other_lower' | kw= 'FORALL_OTHER_LOWER' | kw= 'forall_other_higher' | kw= 'FORALL_OTHER_HIGHER' ) ;
    public final AntlrDatatypeRuleToken ruleForAllFunction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3710:28: ( (kw= 'forall_node' | kw= 'FORALL_NODE' | kw= 'forall_other' | kw= 'FORALL_OTHER' | kw= 'forall_other_lower' | kw= 'FORALL_OTHER_LOWER' | kw= 'forall_other_higher' | kw= 'FORALL_OTHER_HIGHER' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3711:1: (kw= 'forall_node' | kw= 'FORALL_NODE' | kw= 'forall_other' | kw= 'FORALL_OTHER' | kw= 'forall_other_lower' | kw= 'FORALL_OTHER_LOWER' | kw= 'forall_other_higher' | kw= 'FORALL_OTHER_HIGHER' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3711:1: (kw= 'forall_node' | kw= 'FORALL_NODE' | kw= 'forall_other' | kw= 'FORALL_OTHER' | kw= 'forall_other_lower' | kw= 'FORALL_OTHER_LOWER' | kw= 'forall_other_higher' | kw= 'FORALL_OTHER_HIGHER' )
            int alt62=8;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt62=1;
                }
                break;
            case 61:
                {
                alt62=2;
                }
                break;
            case 62:
                {
                alt62=3;
                }
                break;
            case 63:
                {
                alt62=4;
                }
                break;
            case 64:
                {
                alt62=5;
                }
                break;
            case 65:
                {
                alt62=6;
                }
                break;
            case 66:
                {
                alt62=7;
                }
                break;
            case 67:
                {
                alt62=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3712:2: kw= 'forall_node'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleForAllFunction7940); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getForAllFunctionAccess().getForall_nodeKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3719:2: kw= 'FORALL_NODE'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleForAllFunction7959); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getForAllFunctionAccess().getFORALL_NODEKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3726:2: kw= 'forall_other'
                    {
                    kw=(Token)match(input,62,FOLLOW_62_in_ruleForAllFunction7978); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getForAllFunctionAccess().getForall_otherKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3733:2: kw= 'FORALL_OTHER'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleForAllFunction7997); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getForAllFunctionAccess().getFORALL_OTHERKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3740:2: kw= 'forall_other_lower'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleForAllFunction8016); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getForAllFunctionAccess().getForall_other_lowerKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3747:2: kw= 'FORALL_OTHER_LOWER'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleForAllFunction8035); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getForAllFunctionAccess().getFORALL_OTHER_LOWERKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3754:2: kw= 'forall_other_higher'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleForAllFunction8054); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getForAllFunctionAccess().getForall_other_higherKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3761:2: kw= 'FORALL_OTHER_HIGHER'
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleForAllFunction8073); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getForAllFunctionAccess().getFORALL_OTHER_HIGHERKeyword_7()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForAllFunction"


    // $ANTLR start "entryRuleBuiltInFunction"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3774:1: entryRuleBuiltInFunction returns [String current=null] : iv_ruleBuiltInFunction= ruleBuiltInFunction EOF ;
    public final String entryRuleBuiltInFunction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBuiltInFunction = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3775:2: (iv_ruleBuiltInFunction= ruleBuiltInFunction EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3776:2: iv_ruleBuiltInFunction= ruleBuiltInFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBuiltInFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleBuiltInFunction_in_entryRuleBuiltInFunction8114);
            iv_ruleBuiltInFunction=ruleBuiltInFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBuiltInFunction.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBuiltInFunction8125); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBuiltInFunction"


    // $ANTLR start "ruleBuiltInFunction"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3783:1: ruleBuiltInFunction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'exists_other' | kw= 'EXISTS_OTHER' | kw= 'exists_higher' | kw= 'EXISTS_HIGHER' | kw= 'exists_lower' | kw= 'EXISTS_LOWER' ) ;
    public final AntlrDatatypeRuleToken ruleBuiltInFunction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3786:28: ( (kw= 'exists_other' | kw= 'EXISTS_OTHER' | kw= 'exists_higher' | kw= 'EXISTS_HIGHER' | kw= 'exists_lower' | kw= 'EXISTS_LOWER' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3787:1: (kw= 'exists_other' | kw= 'EXISTS_OTHER' | kw= 'exists_higher' | kw= 'EXISTS_HIGHER' | kw= 'exists_lower' | kw= 'EXISTS_LOWER' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3787:1: (kw= 'exists_other' | kw= 'EXISTS_OTHER' | kw= 'exists_higher' | kw= 'EXISTS_HIGHER' | kw= 'exists_lower' | kw= 'EXISTS_LOWER' )
            int alt63=6;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt63=1;
                }
                break;
            case 69:
                {
                alt63=2;
                }
                break;
            case 70:
                {
                alt63=3;
                }
                break;
            case 71:
                {
                alt63=4;
                }
                break;
            case 72:
                {
                alt63=5;
                }
                break;
            case 73:
                {
                alt63=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3788:2: kw= 'exists_other'
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleBuiltInFunction8163); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFunctionAccess().getExists_otherKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3795:2: kw= 'EXISTS_OTHER'
                    {
                    kw=(Token)match(input,69,FOLLOW_69_in_ruleBuiltInFunction8182); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFunctionAccess().getEXISTS_OTHERKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3802:2: kw= 'exists_higher'
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleBuiltInFunction8201); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFunctionAccess().getExists_higherKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3809:2: kw= 'EXISTS_HIGHER'
                    {
                    kw=(Token)match(input,71,FOLLOW_71_in_ruleBuiltInFunction8220); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFunctionAccess().getEXISTS_HIGHERKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3816:2: kw= 'exists_lower'
                    {
                    kw=(Token)match(input,72,FOLLOW_72_in_ruleBuiltInFunction8239); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFunctionAccess().getExists_lowerKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3823:2: kw= 'EXISTS_LOWER'
                    {
                    kw=(Token)match(input,73,FOLLOW_73_in_ruleBuiltInFunction8258); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFunctionAccess().getEXISTS_LOWERKeyword_5()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBuiltInFunction"


    // $ANTLR start "entryRuleDouble"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3836:1: entryRuleDouble returns [String current=null] : iv_ruleDouble= ruleDouble EOF ;
    public final String entryRuleDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3837:2: (iv_ruleDouble= ruleDouble EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3838:2: iv_ruleDouble= ruleDouble EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDoubleRule()); 
            }
            pushFollow(FOLLOW_ruleDouble_in_entryRuleDouble8299);
            iv_ruleDouble=ruleDouble();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDouble.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDouble8310); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDouble"


    // $ANTLR start "ruleDouble"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3845:1: ruleDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'NAN' | (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? ) ) ;
    public final AntlrDatatypeRuleToken ruleDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3848:28: ( (kw= 'NAN' | (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3849:1: (kw= 'NAN' | (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3849:1: (kw= 'NAN' | (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==74) ) {
                alt65=1;
            }
            else if ( (LA65_0==RULE_INT) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3850:2: kw= 'NAN'
                    {
                    kw=(Token)match(input,74,FOLLOW_74_in_ruleDouble8348); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDoubleAccess().getNANKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3856:6: (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3856:6: (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3856:11: this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )?
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDouble8370); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_1, grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_0()); 
                          
                    }
                    kw=(Token)match(input,75,FOLLOW_75_in_ruleDouble8388); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDoubleAccess().getFullStopKeyword_1_1()); 
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3869:1: (this_INT_3= RULE_INT )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==RULE_INT) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3869:6: this_INT_3= RULE_INT
                            {
                            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDouble8404); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		current.merge(this_INT_3);
                                  
                            }
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_INT_3, grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_2()); 
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDouble"


    // $ANTLR start "ruleEqualityOperator"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3894:1: ruleEqualityOperator returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) ;
    public final Enumerator ruleEqualityOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3896:28: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3897:1: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3897:1: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==76) ) {
                alt66=1;
            }
            else if ( (LA66_0==77) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3897:2: (enumLiteral_0= '==' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3897:2: (enumLiteral_0= '==' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3897:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,76,FOLLOW_76_in_ruleEqualityOperator8476); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getEqualityOperatorAccess().getEQUALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getEqualityOperatorAccess().getEQUALEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3903:6: (enumLiteral_1= '!=' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3903:6: (enumLiteral_1= '!=' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3903:8: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,77,FOLLOW_77_in_ruleEqualityOperator8493); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getEqualityOperatorAccess().getNOT_EQUALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getEqualityOperatorAccess().getNOT_EQUALEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityOperator"


    // $ANTLR start "ruleCompareOperator"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3913:1: ruleCompareOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) ) ;
    public final Enumerator ruleCompareOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3915:28: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3916:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3916:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) )
            int alt67=4;
            switch ( input.LA(1) ) {
            case 78:
                {
                alt67=1;
                }
                break;
            case 79:
                {
                alt67=2;
                }
                break;
            case 80:
                {
                alt67=3;
                }
                break;
            case 81:
                {
                alt67=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3916:2: (enumLiteral_0= '<' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3916:2: (enumLiteral_0= '<' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3916:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,78,FOLLOW_78_in_ruleCompareOperator8538); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCompareOperatorAccess().getLESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getCompareOperatorAccess().getLESSEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3922:6: (enumLiteral_1= '<=' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3922:6: (enumLiteral_1= '<=' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3922:8: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,79,FOLLOW_79_in_ruleCompareOperator8555); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCompareOperatorAccess().getLESS_EQUALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getCompareOperatorAccess().getLESS_EQUALEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3928:6: (enumLiteral_2= '>' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3928:6: (enumLiteral_2= '>' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3928:8: enumLiteral_2= '>'
                    {
                    enumLiteral_2=(Token)match(input,80,FOLLOW_80_in_ruleCompareOperator8572); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCompareOperatorAccess().getGREATEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getCompareOperatorAccess().getGREATEREnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3934:6: (enumLiteral_3= '>=' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3934:6: (enumLiteral_3= '>=' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3934:8: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,81,FOLLOW_81_in_ruleCompareOperator8589); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCompareOperatorAccess().getGREATER_EQUALEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getCompareOperatorAccess().getGREATER_EQUALEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompareOperator"


    // $ANTLR start "ruleShiftOperator"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3944:1: ruleShiftOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) ) ;
    public final Enumerator ruleShiftOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3946:28: ( ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3947:1: ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3947:1: ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==82) ) {
                alt68=1;
            }
            else if ( (LA68_0==83) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3947:2: (enumLiteral_0= '<<' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3947:2: (enumLiteral_0= '<<' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3947:4: enumLiteral_0= '<<'
                    {
                    enumLiteral_0=(Token)match(input,82,FOLLOW_82_in_ruleShiftOperator8634); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getShiftOperatorAccess().getLEFTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getShiftOperatorAccess().getLEFTEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3953:6: (enumLiteral_1= '>>' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3953:6: (enumLiteral_1= '>>' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3953:8: enumLiteral_1= '>>'
                    {
                    enumLiteral_1=(Token)match(input,83,FOLLOW_83_in_ruleShiftOperator8651); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getShiftOperatorAccess().getRIGHTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getShiftOperatorAccess().getRIGHTEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftOperator"


    // $ANTLR start "ruleAdditiveOperator"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3963:1: ruleAdditiveOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3965:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3966:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3966:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==48) ) {
                alt69=1;
            }
            else if ( (LA69_0==49) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3966:2: (enumLiteral_0= '+' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3966:2: (enumLiteral_0= '+' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3966:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,48,FOLLOW_48_in_ruleAdditiveOperator8696); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAdditiveOperatorAccess().getADDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOperatorAccess().getADDEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3972:6: (enumLiteral_1= '-' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3972:6: (enumLiteral_1= '-' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3972:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,49,FOLLOW_49_in_ruleAdditiveOperator8713); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAdditiveOperatorAccess().getSUBTRACTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getAdditiveOperatorAccess().getSUBTRACTEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveOperator"


    // $ANTLR start "ruleMultiplicativeOperator"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3982:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3984:28: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3985:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3985:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt70=3;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt70=1;
                }
                break;
            case 85:
                {
                alt70=2;
                }
                break;
            case 86:
                {
                alt70=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3985:2: (enumLiteral_0= '*' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3985:2: (enumLiteral_0= '*' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3985:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,84,FOLLOW_84_in_ruleMultiplicativeOperator8758); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMultiplicativeOperatorAccess().getMULTIPLYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOperatorAccess().getMULTIPLYEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3991:6: (enumLiteral_1= '/' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3991:6: (enumLiteral_1= '/' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3991:8: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,85,FOLLOW_85_in_ruleMultiplicativeOperator8775); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMultiplicativeOperatorAccess().getDIVIDEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOperatorAccess().getDIVIDEEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3997:6: (enumLiteral_2= '%' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3997:6: (enumLiteral_2= '%' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3997:8: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,86,FOLLOW_86_in_ruleMultiplicativeOperator8792); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMultiplicativeOperatorAccess().getMODULUSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getMultiplicativeOperatorAccess().getMODULUSEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeOperator"


    // $ANTLR start "ruleUnaryOperator"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:4007:1: ruleUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= '-' ) | (enumLiteral_1= '+' ) | (enumLiteral_2= '!' ) | (enumLiteral_3= '~' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:4009:28: ( ( (enumLiteral_0= '-' ) | (enumLiteral_1= '+' ) | (enumLiteral_2= '!' ) | (enumLiteral_3= '~' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:4010:1: ( (enumLiteral_0= '-' ) | (enumLiteral_1= '+' ) | (enumLiteral_2= '!' ) | (enumLiteral_3= '~' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:4010:1: ( (enumLiteral_0= '-' ) | (enumLiteral_1= '+' ) | (enumLiteral_2= '!' ) | (enumLiteral_3= '~' ) )
            int alt71=4;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt71=1;
                }
                break;
            case 48:
                {
                alt71=2;
                }
                break;
            case 87:
                {
                alt71=3;
                }
                break;
            case 18:
                {
                alt71=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:4010:2: (enumLiteral_0= '-' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:4010:2: (enumLiteral_0= '-' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:4010:4: enumLiteral_0= '-'
                    {
                    enumLiteral_0=(Token)match(input,49,FOLLOW_49_in_ruleUnaryOperator8837); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getMINUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getMINUSEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:4016:6: (enumLiteral_1= '+' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:4016:6: (enumLiteral_1= '+' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:4016:8: enumLiteral_1= '+'
                    {
                    enumLiteral_1=(Token)match(input,48,FOLLOW_48_in_ruleUnaryOperator8854); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getPLUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getUnaryOperatorAccess().getPLUSEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:4022:6: (enumLiteral_2= '!' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:4022:6: (enumLiteral_2= '!' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:4022:8: enumLiteral_2= '!'
                    {
                    enumLiteral_2=(Token)match(input,87,FOLLOW_87_in_ruleUnaryOperator8871); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getLOGICAL_NOTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getUnaryOperatorAccess().getLOGICAL_NOTEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:4028:6: (enumLiteral_3= '~' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:4028:6: (enumLiteral_3= '~' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:4028:8: enumLiteral_3= '~'
                    {
                    enumLiteral_3=(Token)match(input,18,FOLLOW_18_in_ruleUnaryOperator8888); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getBITWISE_NOTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getUnaryOperatorAccess().getBITWISE_NOTEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperator"

    // $ANTLR start synpred1_InternalDmpl
    public final void synpred1_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1724:4: ( 'else' )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1724:6: 'else'
        {
        match(input,33,FOLLOW_33_in_synpred1_InternalDmpl3570); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalDmpl

    // $ANTLR start synpred2_InternalDmpl
    public final void synpred2_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2405:3: ( ( () '?' ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2405:4: ( () '?' )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2405:4: ( () '?' )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2405:5: () '?'
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2405:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2406:1: 
        {
        }

        match(input,39,FOLLOW_39_in_synpred2_InternalDmpl4913); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalDmpl

    // $ANTLR start synpred3_InternalDmpl
    public final void synpred3_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2487:3: ( ( () '||' ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2487:4: ( () '||' )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2487:4: ( () '||' )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2487:5: () '||'
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2487:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2488:1: 
        {
        }

        match(input,41,FOLLOW_41_in_synpred3_InternalDmpl5099); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalDmpl

    // $ANTLR start synpred4_InternalDmpl
    public final void synpred4_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2547:3: ( ( () '&&' ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2547:4: ( () '&&' )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2547:4: ( () '&&' )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2547:5: () '&&'
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2547:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2548:1: 
        {
        }

        match(input,42,FOLLOW_42_in_synpred4_InternalDmpl5252); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalDmpl

    // $ANTLR start synpred5_InternalDmpl
    public final void synpred5_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2607:3: ( ( () '|' ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2607:4: ( () '|' )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2607:4: ( () '|' )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2607:5: () '|'
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2607:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2608:1: 
        {
        }

        match(input,43,FOLLOW_43_in_synpred5_InternalDmpl5405); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalDmpl

    // $ANTLR start synpred6_InternalDmpl
    public final void synpred6_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2667:3: ( ( () '^' ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2667:4: ( () '^' )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2667:4: ( () '^' )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2667:5: () '^'
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2667:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2668:1: 
        {
        }

        match(input,44,FOLLOW_44_in_synpred6_InternalDmpl5558); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalDmpl

    // $ANTLR start synpred7_InternalDmpl
    public final void synpred7_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2727:3: ( ( () '&' ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2727:4: ( () '&' )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2727:4: ( () '&' )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2727:5: () '&'
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2727:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2728:1: 
        {
        }

        match(input,45,FOLLOW_45_in_synpred7_InternalDmpl5711); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalDmpl

    // $ANTLR start synpred8_InternalDmpl
    public final void synpred8_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2787:3: ( ( () ( ( ruleEqualityOperator ) ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2787:4: ( () ( ( ruleEqualityOperator ) ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2787:4: ( () ( ( ruleEqualityOperator ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2787:5: () ( ( ruleEqualityOperator ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2787:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2788:1: 
        {
        }

        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2788:2: ( ( ruleEqualityOperator ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2789:1: ( ruleEqualityOperator )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2789:1: ( ruleEqualityOperator )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2790:1: ruleEqualityOperator
        {
        pushFollow(FOLLOW_ruleEqualityOperator_in_synpred8_InternalDmpl5867);
        ruleEqualityOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalDmpl

    // $ANTLR start synpred9_InternalDmpl
    public final void synpred9_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2864:3: ( ( () ( ( ruleCompareOperator ) ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2864:4: ( () ( ( ruleCompareOperator ) ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2864:4: ( () ( ( ruleCompareOperator ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2864:5: () ( ( ruleCompareOperator ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2864:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2865:1: 
        {
        }

        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2865:2: ( ( ruleCompareOperator ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2866:1: ( ruleCompareOperator )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2866:1: ( ruleCompareOperator )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2867:1: ruleCompareOperator
        {
        pushFollow(FOLLOW_ruleCompareOperator_in_synpred9_InternalDmpl6034);
        ruleCompareOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalDmpl

    // $ANTLR start synpred10_InternalDmpl
    public final void synpred10_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2941:3: ( ( () ( ( ruleShiftOperator ) ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2941:4: ( () ( ( ruleShiftOperator ) ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2941:4: ( () ( ( ruleShiftOperator ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2941:5: () ( ( ruleShiftOperator ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2941:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2942:1: 
        {
        }

        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2942:2: ( ( ruleShiftOperator ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2943:1: ( ruleShiftOperator )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2943:1: ( ruleShiftOperator )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2944:1: ruleShiftOperator
        {
        pushFollow(FOLLOW_ruleShiftOperator_in_synpred10_InternalDmpl6201);
        ruleShiftOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred10_InternalDmpl

    // $ANTLR start synpred11_InternalDmpl
    public final void synpred11_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3018:3: ( ( () ( ( ruleAdditiveOperator ) ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3018:4: ( () ( ( ruleAdditiveOperator ) ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3018:4: ( () ( ( ruleAdditiveOperator ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3018:5: () ( ( ruleAdditiveOperator ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3018:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3019:1: 
        {
        }

        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3019:2: ( ( ruleAdditiveOperator ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3020:1: ( ruleAdditiveOperator )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3020:1: ( ruleAdditiveOperator )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3021:1: ruleAdditiveOperator
        {
        pushFollow(FOLLOW_ruleAdditiveOperator_in_synpred11_InternalDmpl6368);
        ruleAdditiveOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred11_InternalDmpl

    // $ANTLR start synpred12_InternalDmpl
    public final void synpred12_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3095:3: ( ( () ( ( ruleMultiplicativeOperator ) ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3095:4: ( () ( ( ruleMultiplicativeOperator ) ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3095:4: ( () ( ( ruleMultiplicativeOperator ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3095:5: () ( ( ruleMultiplicativeOperator ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3095:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3096:1: 
        {
        }

        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3096:2: ( ( ruleMultiplicativeOperator ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3097:1: ( ruleMultiplicativeOperator )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3097:1: ( ruleMultiplicativeOperator )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3098:1: ruleMultiplicativeOperator
        {
        pushFollow(FOLLOW_ruleMultiplicativeOperator_in_synpred12_InternalDmpl6535);
        ruleMultiplicativeOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred12_InternalDmpl

    // Delegated rules

    public final boolean synpred3_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalDmpl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalDmpl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA11 dfa11 = new DFA11(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA53 dfa53 = new DFA53(this);
    static final String DFA11_eotS =
        "\23\uffff";
    static final String DFA11_eofS =
        "\2\uffff\2\5\15\uffff\2\5";
    static final String DFA11_minS =
        "\2\4\1\16\1\17\1\4\1\uffff\3\4\3\24\2\uffff\3\24\1\16\1\17";
    static final String DFA11_maxS =
        "\1\21\1\4\2\23\1\25\1\uffff\1\127\1\25\1\127\3\24\2\uffff\3\24\2\23";
    static final String DFA11_acceptS =
        "\5\uffff\1\1\6\uffff\1\2\1\3\5\uffff";
    static final String DFA11_specialS =
        "\23\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\2\14\uffff\1\1",
            "\1\3",
            "\1\6\2\5\2\uffff\1\4",
            "\2\5\1\uffff\1\10\1\7",
            "\1\13\1\11\17\uffff\1\12",
            "",
            "\2\14\14\uffff\1\14\2\uffff\1\14\1\15\6\uffff\1\14\20\uffff\1\14\1\uffff\2\14\22\uffff\7\14\14\uffff\1\14",
            "\1\20\1\16\17\uffff\1\17",
            "\2\14\14\uffff\1\14\2\uffff\1\14\1\15\6\uffff\1\14\20\uffff\1\14\1\uffff\2\14\22\uffff\7\14\14\uffff\1\14",
            "\1\21",
            "\1\21",
            "\1\21",
            "",
            "",
            "\1\22",
            "\1\22",
            "\1\22",
            "\1\6\2\5\2\uffff\1\4",
            "\2\5\1\uffff\1\10\1\7"
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "520:1: ( ( ( (lv_input_0_0= 'input' ) )? ( (lv_var_1_0= ruleVar ) ) ) | ( () ( ( ( (lv_var_3_0= ruleVar ) ) otherlv_4= '=' ) | ( ( (lv_input_5_0= 'input' ) ) ( (lv_var_6_0= ruleVar ) ) otherlv_7= '~' ) ) ( (lv_expr_8_0= ruleExpr ) ) ) | ( () ( ( ( (lv_var_10_0= ruleVar ) ) otherlv_11= '=' ) | ( ( (lv_input_12_0= 'input' ) ) ( (lv_var_13_0= ruleVar ) ) otherlv_14= '~' ) ) ( (lv_fnBody_15_0= ruleFnBody ) ) ) )";
        }
    }
    static final String DFA39_eotS =
        "\15\uffff";
    static final String DFA39_eofS =
        "\15\uffff";
    static final String DFA39_minS =
        "\1\4\1\uffff\1\16\4\uffff\1\4\5\uffff";
    static final String DFA39_maxS =
        "\1\103\1\uffff\1\57\4\uffff\1\127\5\uffff";
    static final String DFA39_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\4\1\5\1\6\1\uffff\1\11\1\12\1\10\1\2\1\7";
    static final String DFA39_specialS =
        "\15\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\2\21\uffff\1\1\10\uffff\2\5\1\uffff\1\3\1\4\1\7\2\11\23\uffff\2\6\10\10",
            "",
            "\1\13\4\uffff\1\13\11\uffff\1\12\1\uffff\1\13\17\uffff\1\12",
            "",
            "",
            "",
            "",
            "\2\14\11\uffff\1\6\2\uffff\1\14\2\uffff\1\14\7\uffff\1\14\20\uffff\1\14\1\uffff\2\14\22\uffff\7\14\14\uffff\1\14",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "1768:1: ( ( () otherlv_1= '{' ( (lv_stmtList_2_0= ruleStmtList ) ) otherlv_3= '}' ) | (this_AssignmentStmt_4= ruleAssignmentStmt otherlv_5= ';' ) | ( () otherlv_7= 'while' otherlv_8= '(' ( (lv_condition_9_0= ruleExpr ) ) otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) ) | ( () otherlv_13= 'for' otherlv_14= '(' ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )? otherlv_18= ';' ( (lv_condition_19_0= ruleExpr ) )? otherlv_20= ';' ( (lv_update_21_0= ruleAssignmentStmt ) )? otherlv_22= ')' ( (lv_stmt_23_0= ruleStmt ) ) ) | this_CondStmt_24= ruleCondStmt | ( () ( (lv_name_26_0= ruleSimpleStmtKeyword ) ) otherlv_27= ';' ) | ( () otherlv_29= 'return' ( (lv_value_30_0= ruleExpr ) ) otherlv_31= ';' ) | (this_CallExpr_32= ruleCallExpr otherlv_33= ';' ) | ( () ( (lv_name_35_0= ruleForAllFunction ) ) otherlv_36= '(' ( (lv_node_37_0= RULE_TIDENTIFIER ) ) otherlv_38= ')' ( (lv_stmt_39_0= ruleStmt ) ) ) | ( () (otherlv_41= 'forall_distinct_node_pair' | otherlv_42= 'FORALL_DISTINCT_NODE_PAIR' ) otherlv_43= '(' ( (lv_node1_44_0= RULE_TIDENTIFIER ) ) otherlv_45= ',' ( (lv_node2_46_0= RULE_TIDENTIFIER ) ) otherlv_47= ')' ( (lv_stmt_48_0= ruleStmt ) ) ) )";
        }
    }
    static final String DFA53_eotS =
        "\14\uffff";
    static final String DFA53_eofS =
        "\1\uffff\1\11\1\uffff\1\13\10\uffff";
    static final String DFA53_minS =
        "\1\4\1\16\1\uffff\1\16\10\uffff";
    static final String DFA53_maxS =
        "\1\127\1\126\1\uffff\1\126\10\uffff";
    static final String DFA53_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\5\1\6\1\7\1\11\1\1\1\10\1\3";
    static final String DFA53_specialS =
        "\14\uffff}>";
    static final String[] DFA53_transitionS = {
            "\1\1\1\3\14\uffff\1\6\2\uffff\1\5\7\uffff\1\10\20\uffff\1\2\1\uffff\2\6\22\uffff\6\7\1\4\14\uffff\1\6",
            "\3\11\2\uffff\2\11\10\uffff\1\12\2\11\7\uffff\7\11\1\uffff\1\12\2\11\32\uffff\13\11",
            "",
            "\3\13\3\uffff\1\13\11\uffff\1\13\10\uffff\7\13\2\uffff\2\13\31\uffff\1\4\13\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA53_eot = DFA.unpackEncodedString(DFA53_eotS);
    static final short[] DFA53_eof = DFA.unpackEncodedString(DFA53_eofS);
    static final char[] DFA53_min = DFA.unpackEncodedStringToUnsignedChars(DFA53_minS);
    static final char[] DFA53_max = DFA.unpackEncodedStringToUnsignedChars(DFA53_maxS);
    static final short[] DFA53_accept = DFA.unpackEncodedString(DFA53_acceptS);
    static final short[] DFA53_special = DFA.unpackEncodedString(DFA53_specialS);
    static final short[][] DFA53_transition;

    static {
        int numStates = DFA53_transitionS.length;
        DFA53_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA53_transition[i] = DFA.unpackEncodedString(DFA53_transitionS[i]);
        }
    }

    class DFA53 extends DFA {

        public DFA53(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 53;
            this.eot = DFA53_eot;
            this.eof = DFA53_eof;
            this.min = DFA53_min;
            this.max = DFA53_max;
            this.accept = DFA53_accept;
            this.special = DFA53_special;
            this.transition = DFA53_transition;
        }
        public String getDescription() {
            return "3163:1: (this_LVal_0= ruleLVal | ( () otherlv_2= 'id' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= ruleDouble ) ) ) | ( () otherlv_8= '#N' ) | ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) ) | ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' ) | this_CallExpr_19= ruleCallExpr | (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProgram85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProgramElement_in_ruleProgram140 = new BitSet(new long[]{0x03FC00001F003002L});
    public static final BitSet FOLLOW_ruleDmplSubclause_in_entryRuleDmplSubclause179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDmplSubclause189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProgram_in_ruleDmplSubclause244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProgramElement_in_entryRuleProgramElement280 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProgramElement290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleProgramElement337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcedure_in_ruleProgramElement364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant399 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleConstant447 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_13_in_ruleConstant465 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleConstant483 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleConstant500 = new BitSet(new long[]{0x0003000000000020L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleNumberConst_in_ruleConstant521 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleConstant533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberConst_in_entryRuleNumberConst569 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberConst579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntConst_in_ruleNumberConst626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleConst_in_ruleNumberConst653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntConst_in_entryRuleIntConst688 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntConst698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSign_in_ruleIntConst744 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntConst762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleConst_in_entryRuleDoubleConst803 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoubleConst813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSign_in_ruleDoubleConst859 = new BitSet(new long[]{0x0003000000000020L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleDouble_in_ruleDoubleConst881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarInit_in_entryRuleVarInit917 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarInit927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleVarInit973 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleVarAsgn_in_ruleVarInit994 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleVarInit1007 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleVarAsgn_in_ruleVarInit1028 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleVarAsgn_in_entryRuleVarAsgn1066 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarAsgn1076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleVarAsgn1120 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleVar_in_ruleVarAsgn1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_ruleVarAsgn1195 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVarAsgn1207 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_17_in_ruleVarAsgn1233 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleVar_in_ruleVarAsgn1267 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleVarAsgn1279 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleVarAsgn1302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_ruleVarAsgn1342 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVarAsgn1354 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_17_in_ruleVarAsgn1380 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleVar_in_ruleVarAsgn1414 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleVarAsgn1426 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleFnBody_in_ruleVarAsgn1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_entryRuleVar1486 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVar1496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleVar1538 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleVar1556 = new BitSet(new long[]{0x0000000000200030L});
    public static final BitSet FOLLOW_ruleDimension_in_ruleVar1577 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleVar1589 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleDimension_in_entryRuleDimension1627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDimension1637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDimension1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleDimension1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleDimension1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType1799 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSigned_in_ruleType1855 = new BitSet(new long[]{0x03FC00001F003000L});
    public static final BitSet FOLLOW_ruleSimpType_in_ruleType1877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcedure_in_entryRuleProcedure1913 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcedure1923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcNoAttr_in_ruleProcedure1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcNoAttr_in_entryRuleProcNoAttr2003 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcNoAttr2013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnPrototype_in_ruleProcNoAttr2059 = new BitSet(new long[]{0x0000000000408000L});
    public static final BitSet FOLLOW_15_in_ruleProcNoAttr2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnBody_in_ruleProcNoAttr2099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnBody_in_entryRuleFnBody2136 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFnBody2146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFnBody2183 = new BitSet(new long[]{0xFFFC007D9FC23010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleVarInitList_in_ruleFnBody2204 = new BitSet(new long[]{0xFC00007D80C00010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleStmtList_in_ruleFnBody2225 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleFnBody2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnPrototype_in_entryRuleFnPrototype2273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFnPrototype2283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleFnPrototype2338 = new BitSet(new long[]{0x000000001C000000L});
    public static final BitSet FOLLOW_25_in_ruleFnPrototype2367 = new BitSet(new long[]{0x000000001C000000L});
    public static final BitSet FOLLOW_26_in_ruleFnPrototype2404 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_27_in_ruleFnPrototype2433 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleFnPrototype2462 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleFnPrototype2479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleFnPrototype2521 = new BitSet(new long[]{0x03FC00001F003010L});
    public static final BitSet FOLLOW_25_in_ruleFnPrototype2550 = new BitSet(new long[]{0x03FC00001F003010L});
    public static final BitSet FOLLOW_26_in_ruleFnPrototype2587 = new BitSet(new long[]{0x03FC00001F003010L});
    public static final BitSet FOLLOW_27_in_ruleFnPrototype2616 = new BitSet(new long[]{0x03FC00001F003010L});
    public static final BitSet FOLLOW_ruleType_in_ruleFnPrototype2654 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleFnPrototype2671 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleFnPrototype2688 = new BitSet(new long[]{0x03FC00005F023010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleFnPrototype2710 = new BitSet(new long[]{0x0000000040010000L});
    public static final BitSet FOLLOW_16_in_ruleFnPrototype2723 = new BitSet(new long[]{0x03FC00001F023010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleFnPrototype2744 = new BitSet(new long[]{0x0000000040010000L});
    public static final BitSet FOLLOW_30_in_ruleFnPrototype2760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrList_in_entryRuleAttrList2797 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttrList2807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttr_in_ruleAttrList2853 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAttrList2865 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_ruleAttr_in_entryRuleAttr2902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttr2912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAttr2949 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleAttr2966 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleAttr2984 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAttr3005 = new BitSet(new long[]{0x0000000040010000L});
    public static final BitSet FOLLOW_16_in_ruleAttr3018 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAttr3039 = new BitSet(new long[]{0x0000000040010000L});
    public static final BitSet FOLLOW_30_in_ruleAttr3053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParam_in_entryRuleParam3091 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParam3101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleParam3147 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleVar_in_ruleParam3168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarInitList_in_entryRuleVarInitList3204 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarInitList3214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarInit_in_ruleVarInitList3270 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleVarInitList3282 = new BitSet(new long[]{0x03FC00001F023012L});
    public static final BitSet FOLLOW_ruleStmtList_in_entryRuleStmtList3320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStmtList3330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmt_in_ruleStmtList3385 = new BitSet(new long[]{0xFC00007D80400012L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleCondStmt_in_entryRuleCondStmt3422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCondStmt3432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrList_in_ruleCondStmt3478 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleCondStmt3491 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleCondStmt3503 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleCondStmt3524 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleCondStmt3536 = new BitSet(new long[]{0xFC00007D80400010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleCondStmt3557 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleCondStmt3578 = new BitSet(new long[]{0xFC00007D80400010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleCondStmt3600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmt_in_entryRuleStmt3638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStmt3648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleStmt3695 = new BitSet(new long[]{0xFC00007D80C00010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleStmtList_in_ruleStmt3716 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleStmt3728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentStmt_in_ruleStmt3758 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStmt3769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleStmt3798 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleStmt3810 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleStmt3831 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleStmt3843 = new BitSet(new long[]{0xFC00007D80400010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleStmt3864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleStmt3893 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleStmt3905 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleAssignmentStmt_in_ruleStmt3927 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleStmt3940 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAssignmentStmt_in_ruleStmt3961 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleStmt3977 = new BitSet(new long[]{0x0003400020248030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleStmt3998 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStmt4011 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_ruleAssignmentStmt_in_ruleStmt4032 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleStmt4045 = new BitSet(new long[]{0xFC00007D80400010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleStmt4066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondStmt_in_ruleStmt4095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleStmtKeyword_in_ruleStmt4131 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStmt4143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleStmt4172 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleStmt4193 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStmt4205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExpr_in_ruleStmt4235 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStmt4246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForAllFunction_in_ruleStmt4284 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleStmt4296 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleStmt4313 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleStmt4330 = new BitSet(new long[]{0xFC00007D80400010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleStmt4351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleStmt4381 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_38_in_ruleStmt4399 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleStmt4412 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleStmt4429 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleStmt4446 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleStmt4463 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleStmt4480 = new BitSet(new long[]{0xFC00007D80400010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleStmt4501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentStmt_in_entryRuleAssignmentStmt4538 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentStmt4548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLVal_in_ruleAssignmentStmt4594 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAssignmentStmt4606 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAssignmentStmt4627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLVal_in_entryRuleLVal4663 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLVal4673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleLVal4715 = new BitSet(new long[]{0x0000000080080002L});
    public static final BitSet FOLLOW_19_in_ruleLVal4733 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleLVal4754 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleLVal4766 = new BitSet(new long[]{0x0000000080080002L});
    public static final BitSet FOLLOW_31_in_ruleLVal4781 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleLVal4802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_entryRuleExpr4840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpr4850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpr_in_ruleExpr4897 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleExpr4932 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleExpr4955 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleExpr4967 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleExpr4988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpr_in_entryRuleOrExpr5026 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrExpr5036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpr_in_ruleOrExpr5083 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleOrExpr5118 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleAndExpr_in_ruleOrExpr5141 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleAndExpr_in_entryRuleAndExpr5179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpr5189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpr_in_ruleAndExpr5236 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleAndExpr5271 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpr_in_ruleAndExpr5294 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpr_in_entryRuleBitwiseOrExpr5332 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseOrExpr5342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXorExpr_in_ruleBitwiseOrExpr5389 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleBitwiseOrExpr5424 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleXorExpr_in_ruleBitwiseOrExpr5447 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleXorExpr_in_entryRuleXorExpr5485 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXorExpr5495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpr_in_ruleXorExpr5542 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_ruleXorExpr5577 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpr_in_ruleXorExpr5600 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpr_in_entryRuleBitwiseAndExpr5638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseAndExpr5648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpr_in_ruleBitwiseAndExpr5695 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleBitwiseAndExpr5730 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleEqualityExpr_in_ruleBitwiseAndExpr5753 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpr_in_entryRuleEqualityExpr5791 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpr5801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompareExpr_in_ruleEqualityExpr5848 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpr5897 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleCompareExpr_in_ruleEqualityExpr5920 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_ruleCompareExpr_in_entryRuleCompareExpr5958 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompareExpr5968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpr_in_ruleCompareExpr6015 = new BitSet(new long[]{0x0000000000000002L,0x000000000003C000L});
    public static final BitSet FOLLOW_ruleCompareOperator_in_ruleCompareExpr6064 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleShiftExpr_in_ruleCompareExpr6087 = new BitSet(new long[]{0x0000000000000002L,0x000000000003C000L});
    public static final BitSet FOLLOW_ruleShiftExpr_in_entryRuleShiftExpr6125 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShiftExpr6135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpr_in_ruleShiftExpr6182 = new BitSet(new long[]{0x0000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_ruleShiftOperator_in_ruleShiftExpr6231 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpr_in_ruleShiftExpr6254 = new BitSet(new long[]{0x0000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_ruleAdditiveExpr_in_entryRuleAdditiveExpr6292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpr6302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpr_in_ruleAdditiveExpr6349 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpr6398 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpr_in_ruleAdditiveExpr6421 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpr_in_entryRuleMultiplicativeExpr6459 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpr6469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpr_in_ruleMultiplicativeExpr6516 = new BitSet(new long[]{0x0000000000000002L,0x0000000000700000L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpr6565 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleTerminalExpr_in_ruleMultiplicativeExpr6588 = new BitSet(new long[]{0x0000000000000002L,0x0000000000700000L});
    public static final BitSet FOLLOW_ruleTerminalExpr_in_entryRuleTerminalExpr6626 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalExpr6636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLVal_in_ruleTerminalExpr6683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleTerminalExpr6710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTerminalExpr6744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDouble_in_ruleTerminalExpr6787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleTerminalExpr6816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleTerminalExpr6854 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleTerminalExpr6875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltInFunction_in_ruleTerminalExpr6913 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleTerminalExpr6925 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleTerminalExpr6942 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTerminalExpr6959 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleTerminalExpr6980 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTerminalExpr6992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExpr_in_ruleTerminalExpr7021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleTerminalExpr7039 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleTerminalExpr7061 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTerminalExpr7072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExpr_in_entryRuleCallExpr7109 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallExpr7119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleCallExpr7162 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleCallExpr7179 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleCallExpr7198 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleCallExpr7215 = new BitSet(new long[]{0x0003400060240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleCallExpr7237 = new BitSet(new long[]{0x0000000040010000L});
    public static final BitSet FOLLOW_16_in_ruleCallExpr7250 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleCallExpr7271 = new BitSet(new long[]{0x0000000040010000L});
    public static final BitSet FOLLOW_30_in_ruleCallExpr7287 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleCallExpr7300 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleCallExpr7321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSign_in_entryRuleSign7360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSign7371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleSign7409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleSign7428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpType_in_entryRuleSimpType7469 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpType7480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleSimpType7518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleSimpType7537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleSimpType7556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleSimpType7575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleSimpType7594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleSimpType7613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSigned_in_entryRuleSigned7654 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSigned7665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleSigned7703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleSigned7722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleStmtKeyword_in_entryRuleSimpleStmtKeyword7763 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleStmtKeyword7774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleSimpleStmtKeyword7812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleSimpleStmtKeyword7831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleSimpleStmtKeyword7850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForAllFunction_in_entryRuleForAllFunction7891 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForAllFunction7902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleForAllFunction7940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleForAllFunction7959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleForAllFunction7978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleForAllFunction7997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleForAllFunction8016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleForAllFunction8035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleForAllFunction8054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleForAllFunction8073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltInFunction_in_entryRuleBuiltInFunction8114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBuiltInFunction8125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleBuiltInFunction8163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleBuiltInFunction8182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleBuiltInFunction8201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleBuiltInFunction8220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleBuiltInFunction8239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleBuiltInFunction8258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDouble_in_entryRuleDouble8299 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDouble8310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleDouble8348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDouble8370 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ruleDouble8388 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDouble8404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleEqualityOperator8476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleEqualityOperator8493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleCompareOperator8538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleCompareOperator8555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleCompareOperator8572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleCompareOperator8589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleShiftOperator8634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleShiftOperator8651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleAdditiveOperator8696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleAdditiveOperator8713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleMultiplicativeOperator8758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleMultiplicativeOperator8775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_ruleMultiplicativeOperator8792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleUnaryOperator8837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleUnaryOperator8854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleUnaryOperator8871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleUnaryOperator8888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_synpred1_InternalDmpl3570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred2_InternalDmpl4913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred3_InternalDmpl5099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred4_InternalDmpl5252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred5_InternalDmpl5405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_synpred6_InternalDmpl5558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred7_InternalDmpl5711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_synpred8_InternalDmpl5867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompareOperator_in_synpred9_InternalDmpl6034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftOperator_in_synpred10_InternalDmpl6201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_synpred11_InternalDmpl6368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_synpred12_InternalDmpl6535 = new BitSet(new long[]{0x0000000000000002L});

}