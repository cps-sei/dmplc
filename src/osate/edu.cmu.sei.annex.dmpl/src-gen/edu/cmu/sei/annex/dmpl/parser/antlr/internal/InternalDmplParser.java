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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_TIDENTIFIER", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'const'", "'CONST'", "'='", "';'", "','", "'input'", "'~'", "'['", "']'", "'#N'", "'{'", "'}'", "'extern'", "'EXTERN'", "'pure'", "'PURE'", "'thread'", "'('", "')'", "'@'", "'while'", "'for'", "'if'", "'else'", "'return'", "'forall_distinct_node_pair'", "'FORALL_DISTINCT_NODE_PAIR'", "'?'", "':'", "'||'", "'&&'", "'|'", "'^'", "'&'", "'id'", "'::'", "'+'", "'-'", "'bool'", "'_Bool'", "'int'", "'double'", "'void'", "'char'", "'signed'", "'unsigned'", "'break'", "'continue'", "'forall_node'", "'FORALL_NODE'", "'forall_other'", "'FORALL_OTHER'", "'forall_other_lower'", "'FORALL_OTHER_LOWER'", "'forall_other_higher'", "'FORALL_OTHER_HIGHER'", "'exists_other'", "'EXISTS_OTHER'", "'exists_higher'", "'EXISTS_HIGHER'", "'exists_lower'", "'EXISTS_LOWER'", "'NAN'", "'.'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", "'*'", "'/'", "'%'", "'!'"
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

                if ( (LA4_1==74) ) {
                    alt4=2;
                }
                else if ( (LA4_1==RULE_INT) ) {
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
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
                }
                break;
            case 49:
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==RULE_INT) ) {
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
                else if ( (LA4_2==74) ) {
                    alt4=2;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1044:1: ruleFnBody returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_varInits_2_0= ruleVarInit ) ) otherlv_3= ';' )* ( (lv_stmts_4_0= ruleStmt ) )* otherlv_5= '}' ) ;
    public final EObject ruleFnBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_varInits_2_0 = null;

        EObject lv_stmts_4_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1047:28: ( ( () otherlv_1= '{' ( ( (lv_varInits_2_0= ruleVarInit ) ) otherlv_3= ';' )* ( (lv_stmts_4_0= ruleStmt ) )* otherlv_5= '}' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1048:1: ( () otherlv_1= '{' ( ( (lv_varInits_2_0= ruleVarInit ) ) otherlv_3= ';' )* ( (lv_stmts_4_0= ruleStmt ) )* otherlv_5= '}' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1048:1: ( () otherlv_1= '{' ( ( (lv_varInits_2_0= ruleVarInit ) ) otherlv_3= ';' )* ( (lv_stmts_4_0= ruleStmt ) )* otherlv_5= '}' )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1048:2: () otherlv_1= '{' ( ( (lv_varInits_2_0= ruleVarInit ) ) otherlv_3= ';' )* ( (lv_stmts_4_0= ruleStmt ) )* otherlv_5= '}'
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1048:2: ()
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1049:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getFnBodyAccess().getFnBodyAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleFnBody2192); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFnBodyAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1058:1: ( ( (lv_varInits_2_0= ruleVarInit ) ) otherlv_3= ';' )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=50 && LA16_0<=57)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1058:2: ( (lv_varInits_2_0= ruleVarInit ) ) otherlv_3= ';'
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1058:2: ( (lv_varInits_2_0= ruleVarInit ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1059:1: (lv_varInits_2_0= ruleVarInit )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1059:1: (lv_varInits_2_0= ruleVarInit )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1060:3: lv_varInits_2_0= ruleVarInit
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFnBodyAccess().getVarInitsVarInitParserRuleCall_2_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVarInit_in_ruleFnBody2214);
            	    lv_varInits_2_0=ruleVarInit();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFnBodyRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"varInits",
            	              		lv_varInits_2_0, 
            	              		"VarInit");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleFnBody2226); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getFnBodyAccess().getSemicolonKeyword_2_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1080:3: ( (lv_stmts_4_0= ruleStmt ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_TIDENTIFIER||LA17_0==22||(LA17_0>=31 && LA17_0<=34)||(LA17_0>=36 && LA17_0<=38)||(LA17_0>=58 && LA17_0<=67)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1081:1: (lv_stmts_4_0= ruleStmt )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1081:1: (lv_stmts_4_0= ruleStmt )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1082:3: lv_stmts_4_0= ruleStmt
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFnBodyAccess().getStmtsStmtParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStmt_in_ruleFnBody2249);
            	    lv_stmts_4_0=ruleStmt();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFnBodyRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"stmts",
            	              		lv_stmts_4_0, 
            	              		"Stmt");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleFnBody2262); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getFnBodyAccess().getRightCurlyBracketKeyword_4());
                  
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1110:1: entryRuleFnPrototype returns [EObject current=null] : iv_ruleFnPrototype= ruleFnPrototype EOF ;
    public final EObject entryRuleFnPrototype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFnPrototype = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1111:2: (iv_ruleFnPrototype= ruleFnPrototype EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1112:2: iv_ruleFnPrototype= ruleFnPrototype EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFnPrototypeRule()); 
            }
            pushFollow(FOLLOW_ruleFnPrototype_in_entryRuleFnPrototype2298);
            iv_ruleFnPrototype=ruleFnPrototype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFnPrototype; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFnPrototype2308); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1119:1: ruleFnPrototype returns [EObject current=null] : ( ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) ) | ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' ) ) ;
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
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1122:28: ( ( ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) ) | ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1123:1: ( ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) ) | ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1123:1: ( ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) ) | ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' ) )
            int alt28=2;
            switch ( input.LA(1) ) {
            case 24:
                {
                switch ( input.LA(2) ) {
                case 26:
                    {
                    int LA28_3 = input.LA(3);

                    if ( (LA28_3==28) ) {
                        alt28=1;
                    }
                    else if ( ((LA28_3>=50 && LA28_3<=57)) ) {
                        alt28=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 27:
                    {
                    int LA28_4 = input.LA(3);

                    if ( (LA28_4==28) ) {
                        alt28=1;
                    }
                    else if ( ((LA28_4>=50 && LA28_4<=57)) ) {
                        alt28=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 4, input);

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
                    alt28=2;
                    }
                    break;
                case 28:
                    {
                    alt28=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }

                }
                break;
            case 25:
                {
                switch ( input.LA(2) ) {
                case 26:
                    {
                    int LA28_3 = input.LA(3);

                    if ( (LA28_3==28) ) {
                        alt28=1;
                    }
                    else if ( ((LA28_3>=50 && LA28_3<=57)) ) {
                        alt28=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 27:
                    {
                    int LA28_4 = input.LA(3);

                    if ( (LA28_4==28) ) {
                        alt28=1;
                    }
                    else if ( ((LA28_4>=50 && LA28_4<=57)) ) {
                        alt28=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 28:
                    {
                    alt28=1;
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
                    alt28=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 2, input);

                    throw nvae;
                }

                }
                break;
            case 26:
                {
                int LA28_3 = input.LA(2);

                if ( (LA28_3==28) ) {
                    alt28=1;
                }
                else if ( ((LA28_3>=50 && LA28_3<=57)) ) {
                    alt28=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 3, input);

                    throw nvae;
                }
                }
                break;
            case 27:
                {
                int LA28_4 = input.LA(2);

                if ( (LA28_4==28) ) {
                    alt28=1;
                }
                else if ( ((LA28_4>=50 && LA28_4<=57)) ) {
                    alt28=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 4, input);

                    throw nvae;
                }
                }
                break;
            case 28:
                {
                alt28=1;
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
                alt28=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1123:2: ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1123:2: ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1123:3: () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1123:3: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1124:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getFnPrototypeAccess().getThreadDeclarationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1129:2: ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( ((LA19_0>=24 && LA19_0<=25)) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1130:1: ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1130:1: ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1131:1: (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1131:1: (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' )
                            int alt18=2;
                            int LA18_0 = input.LA(1);

                            if ( (LA18_0==24) ) {
                                alt18=1;
                            }
                            else if ( (LA18_0==25) ) {
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
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1132:3: lv_extern_1_1= 'extern'
                                    {
                                    lv_extern_1_1=(Token)match(input,24,FOLLOW_24_in_ruleFnPrototype2363); if (state.failed) return current;
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
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1144:8: lv_extern_1_2= 'EXTERN'
                                    {
                                    lv_extern_1_2=(Token)match(input,25,FOLLOW_25_in_ruleFnPrototype2392); if (state.failed) return current;
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

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1159:3: ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( ((LA21_0>=26 && LA21_0<=27)) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1160:1: ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1160:1: ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1161:1: (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1161:1: (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' )
                            int alt20=2;
                            int LA20_0 = input.LA(1);

                            if ( (LA20_0==26) ) {
                                alt20=1;
                            }
                            else if ( (LA20_0==27) ) {
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
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1162:3: lv_pure_2_1= 'pure'
                                    {
                                    lv_pure_2_1=(Token)match(input,26,FOLLOW_26_in_ruleFnPrototype2429); if (state.failed) return current;
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
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1174:8: lv_pure_2_2= 'PURE'
                                    {
                                    lv_pure_2_2=(Token)match(input,27,FOLLOW_27_in_ruleFnPrototype2458); if (state.failed) return current;
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

                    otherlv_3=(Token)match(input,28,FOLLOW_28_in_ruleFnPrototype2487); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getFnPrototypeAccess().getThreadKeyword_0_3());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1193:1: ( (lv_name_4_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1194:1: (lv_name_4_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1194:1: (lv_name_4_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1195:3: lv_name_4_0= RULE_TIDENTIFIER
                    {
                    lv_name_4_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleFnPrototype2504); if (state.failed) return current;
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1212:6: ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1212:6: ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1212:7: () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1212:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1213:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getFnPrototypeAccess().getFnPrototypeDeclarationAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1218:2: ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( ((LA23_0>=24 && LA23_0<=25)) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1219:1: ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1219:1: ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1220:1: (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1220:1: (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' )
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0==24) ) {
                                alt22=1;
                            }
                            else if ( (LA22_0==25) ) {
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
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1221:3: lv_extern_6_1= 'extern'
                                    {
                                    lv_extern_6_1=(Token)match(input,24,FOLLOW_24_in_ruleFnPrototype2546); if (state.failed) return current;
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
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1233:8: lv_extern_6_2= 'EXTERN'
                                    {
                                    lv_extern_6_2=(Token)match(input,25,FOLLOW_25_in_ruleFnPrototype2575); if (state.failed) return current;
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

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1248:3: ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( ((LA25_0>=26 && LA25_0<=27)) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1249:1: ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1249:1: ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1250:1: (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1250:1: (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' )
                            int alt24=2;
                            int LA24_0 = input.LA(1);

                            if ( (LA24_0==26) ) {
                                alt24=1;
                            }
                            else if ( (LA24_0==27) ) {
                                alt24=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 24, 0, input);

                                throw nvae;
                            }
                            switch (alt24) {
                                case 1 :
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1251:3: lv_pure_7_1= 'pure'
                                    {
                                    lv_pure_7_1=(Token)match(input,26,FOLLOW_26_in_ruleFnPrototype2612); if (state.failed) return current;
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
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1263:8: lv_pure_7_2= 'PURE'
                                    {
                                    lv_pure_7_2=(Token)match(input,27,FOLLOW_27_in_ruleFnPrototype2641); if (state.failed) return current;
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

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1278:3: ( (lv_type_8_0= ruleType ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1279:1: (lv_type_8_0= ruleType )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1279:1: (lv_type_8_0= ruleType )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1280:3: lv_type_8_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFnPrototypeAccess().getTypeTypeParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleFnPrototype2679);
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

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1296:2: ( (lv_name_9_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1297:1: (lv_name_9_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1297:1: (lv_name_9_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1298:3: lv_name_9_0= RULE_TIDENTIFIER
                    {
                    lv_name_9_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleFnPrototype2696); if (state.failed) return current;
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

                    otherlv_10=(Token)match(input,29,FOLLOW_29_in_ruleFnPrototype2713); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getFnPrototypeAccess().getLeftParenthesisKeyword_1_5());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1318:1: ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( ((LA27_0>=50 && LA27_0<=57)) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1318:2: ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )*
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1318:2: ( (lv_params_11_0= ruleParam ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1319:1: (lv_params_11_0= ruleParam )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1319:1: (lv_params_11_0= ruleParam )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1320:3: lv_params_11_0= ruleParam
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getFnPrototypeAccess().getParamsParamParserRuleCall_1_6_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleParam_in_ruleFnPrototype2735);
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

                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1336:2: (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )*
                            loop26:
                            do {
                                int alt26=2;
                                int LA26_0 = input.LA(1);

                                if ( (LA26_0==16) ) {
                                    alt26=1;
                                }


                                switch (alt26) {
                            	case 1 :
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1336:4: otherlv_12= ',' ( (lv_params_13_0= ruleParam ) )
                            	    {
                            	    otherlv_12=(Token)match(input,16,FOLLOW_16_in_ruleFnPrototype2748); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_12, grammarAccess.getFnPrototypeAccess().getCommaKeyword_1_6_1_0());
                            	          
                            	    }
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1340:1: ( (lv_params_13_0= ruleParam ) )
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1341:1: (lv_params_13_0= ruleParam )
                            	    {
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1341:1: (lv_params_13_0= ruleParam )
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1342:3: lv_params_13_0= ruleParam
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getFnPrototypeAccess().getParamsParamParserRuleCall_1_6_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleParam_in_ruleFnPrototype2769);
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
                            	    break loop26;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_14=(Token)match(input,30,FOLLOW_30_in_ruleFnPrototype2785); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1370:1: entryRuleAttrList returns [EObject current=null] : iv_ruleAttrList= ruleAttrList EOF ;
    public final EObject entryRuleAttrList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrList = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1371:2: (iv_ruleAttrList= ruleAttrList EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1372:2: iv_ruleAttrList= ruleAttrList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttrListRule()); 
            }
            pushFollow(FOLLOW_ruleAttrList_in_entryRuleAttrList2822);
            iv_ruleAttrList=ruleAttrList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttrList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttrList2832); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1379:1: ruleAttrList returns [EObject current=null] : ( ( (lv_attrs_0_0= ruleAttr ) ) otherlv_1= ';' )+ ;
    public final EObject ruleAttrList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_attrs_0_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1382:28: ( ( ( (lv_attrs_0_0= ruleAttr ) ) otherlv_1= ';' )+ )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1383:1: ( ( (lv_attrs_0_0= ruleAttr ) ) otherlv_1= ';' )+
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1383:1: ( ( (lv_attrs_0_0= ruleAttr ) ) otherlv_1= ';' )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==31) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1383:2: ( (lv_attrs_0_0= ruleAttr ) ) otherlv_1= ';'
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1383:2: ( (lv_attrs_0_0= ruleAttr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1384:1: (lv_attrs_0_0= ruleAttr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1384:1: (lv_attrs_0_0= ruleAttr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1385:3: lv_attrs_0_0= ruleAttr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrListAccess().getAttrsAttrParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAttr_in_ruleAttrList2878);
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

            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleAttrList2890); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getAttrListAccess().getSemicolonKeyword_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1413:1: entryRuleAttr returns [EObject current=null] : iv_ruleAttr= ruleAttr EOF ;
    public final EObject entryRuleAttr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1414:2: (iv_ruleAttr= ruleAttr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1415:2: iv_ruleAttr= ruleAttr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttrRule()); 
            }
            pushFollow(FOLLOW_ruleAttr_in_entryRuleAttr2927);
            iv_ruleAttr=ruleAttr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttr2937); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1422:1: ruleAttr returns [EObject current=null] : (otherlv_0= '@' ( (lv_name_1_0= RULE_TIDENTIFIER ) ) (otherlv_2= '(' ( (lv_params_3_0= ruleExpr ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) ) )* otherlv_6= ')' )? ) ;
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
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1425:28: ( (otherlv_0= '@' ( (lv_name_1_0= RULE_TIDENTIFIER ) ) (otherlv_2= '(' ( (lv_params_3_0= ruleExpr ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) ) )* otherlv_6= ')' )? ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1426:1: (otherlv_0= '@' ( (lv_name_1_0= RULE_TIDENTIFIER ) ) (otherlv_2= '(' ( (lv_params_3_0= ruleExpr ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) ) )* otherlv_6= ')' )? )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1426:1: (otherlv_0= '@' ( (lv_name_1_0= RULE_TIDENTIFIER ) ) (otherlv_2= '(' ( (lv_params_3_0= ruleExpr ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) ) )* otherlv_6= ')' )? )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1426:3: otherlv_0= '@' ( (lv_name_1_0= RULE_TIDENTIFIER ) ) (otherlv_2= '(' ( (lv_params_3_0= ruleExpr ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) ) )* otherlv_6= ')' )?
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleAttr2974); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAttrAccess().getCommercialAtKeyword_0());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1430:1: ( (lv_name_1_0= RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1431:1: (lv_name_1_0= RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1431:1: (lv_name_1_0= RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1432:3: lv_name_1_0= RULE_TIDENTIFIER
            {
            lv_name_1_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleAttr2991); if (state.failed) return current;
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

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1448:2: (otherlv_2= '(' ( (lv_params_3_0= ruleExpr ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) ) )* otherlv_6= ')' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==29) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1448:4: otherlv_2= '(' ( (lv_params_3_0= ruleExpr ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleAttr3009); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAttrAccess().getLeftParenthesisKeyword_2_0());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1452:1: ( (lv_params_3_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1453:1: (lv_params_3_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1453:1: (lv_params_3_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1454:3: lv_params_3_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAttrAccess().getParamsExprParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleAttr3030);
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

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1470:2: (otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==16) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1470:4: otherlv_4= ',' ( (lv_params_5_0= ruleExpr ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleAttr3043); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getAttrAccess().getCommaKeyword_2_2_0());
                    	          
                    	    }
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1474:1: ( (lv_params_5_0= ruleExpr ) )
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1475:1: (lv_params_5_0= ruleExpr )
                    	    {
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1475:1: (lv_params_5_0= ruleExpr )
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1476:3: lv_params_5_0= ruleExpr
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAttrAccess().getParamsExprParserRuleCall_2_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExpr_in_ruleAttr3064);
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
                    	    break loop30;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,30,FOLLOW_30_in_ruleAttr3078); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1504:1: entryRuleParam returns [EObject current=null] : iv_ruleParam= ruleParam EOF ;
    public final EObject entryRuleParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParam = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1505:2: (iv_ruleParam= ruleParam EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1506:2: iv_ruleParam= ruleParam EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamRule()); 
            }
            pushFollow(FOLLOW_ruleParam_in_entryRuleParam3116);
            iv_ruleParam=ruleParam();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParam; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParam3126); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1513:1: ruleParam returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_var_1_0= ruleVar ) ) ) ;
    public final EObject ruleParam() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        EObject lv_var_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1516:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_var_1_0= ruleVar ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1517:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_var_1_0= ruleVar ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1517:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_var_1_0= ruleVar ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1517:2: ( (lv_type_0_0= ruleType ) ) ( (lv_var_1_0= ruleVar ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1517:2: ( (lv_type_0_0= ruleType ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1518:1: (lv_type_0_0= ruleType )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1518:1: (lv_type_0_0= ruleType )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1519:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleParam3172);
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

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1535:2: ( (lv_var_1_0= ruleVar ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1536:1: (lv_var_1_0= ruleVar )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1536:1: (lv_var_1_0= ruleVar )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1537:3: lv_var_1_0= ruleVar
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamAccess().getVarVarParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVar_in_ruleParam3193);
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


    // $ANTLR start "entryRuleStmt"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1561:1: entryRuleStmt returns [EObject current=null] : iv_ruleStmt= ruleStmt EOF ;
    public final EObject entryRuleStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStmt = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1562:2: (iv_ruleStmt= ruleStmt EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1563:2: iv_ruleStmt= ruleStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStmtRule()); 
            }
            pushFollow(FOLLOW_ruleStmt_in_entryRuleStmt3229);
            iv_ruleStmt=ruleStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStmt3239); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1570:1: ruleStmt returns [EObject current=null] : ( ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' ) | (this_AssignmentStmt_4= ruleAssignmentStmt otherlv_5= ';' ) | ( () otherlv_7= 'while' otherlv_8= '(' ( (lv_condition_9_0= ruleExpr ) ) otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) ) | ( () otherlv_13= 'for' otherlv_14= '(' ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )? otherlv_18= ';' ( (lv_condition_19_0= ruleExpr ) )? otherlv_20= ';' ( (lv_update_21_0= ruleAssignmentStmt ) )? otherlv_22= ')' ( (lv_stmt_23_0= ruleStmt ) ) ) | ( () ( (lv_attrList_25_0= ruleAttrList ) )? otherlv_26= 'if' otherlv_27= '(' ( (lv_condition_28_0= ruleExpr ) ) otherlv_29= ')' ( (lv_then_30_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_31= 'else' ) ( (lv_else_32_0= ruleStmt ) ) )? ) | ( () ( (lv_name_34_0= ruleSimpleStmtKeyword ) ) otherlv_35= ';' ) | ( () otherlv_37= 'return' ( (lv_value_38_0= ruleExpr ) ) otherlv_39= ';' ) | (this_CallExpr_40= ruleCallExpr otherlv_41= ';' ) | ( () ( (lv_name_43_0= ruleForAllFunction ) ) otherlv_44= '(' ( (lv_node_45_0= RULE_TIDENTIFIER ) ) otherlv_46= ')' ( (lv_stmt_47_0= ruleStmt ) ) ) | ( () (otherlv_49= 'forall_distinct_node_pair' | otherlv_50= 'FORALL_DISTINCT_NODE_PAIR' ) otherlv_51= '(' ( (lv_node1_52_0= RULE_TIDENTIFIER ) ) otherlv_53= ',' ( (lv_node2_54_0= RULE_TIDENTIFIER ) ) otherlv_55= ')' ( (lv_stmt_56_0= ruleStmt ) ) ) ) ;
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
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        Token otherlv_41=null;
        Token otherlv_44=null;
        Token lv_node_45_0=null;
        Token otherlv_46=null;
        Token otherlv_49=null;
        Token otherlv_50=null;
        Token otherlv_51=null;
        Token lv_node1_52_0=null;
        Token otherlv_53=null;
        Token lv_node2_54_0=null;
        Token otherlv_55=null;
        EObject lv_stmts_2_0 = null;

        EObject this_AssignmentStmt_4 = null;

        EObject lv_condition_9_0 = null;

        EObject lv_stmt_11_0 = null;

        EObject lv_inits_15_0 = null;

        EObject lv_inits_17_0 = null;

        EObject lv_condition_19_0 = null;

        EObject lv_update_21_0 = null;

        EObject lv_stmt_23_0 = null;

        EObject lv_attrList_25_0 = null;

        EObject lv_condition_28_0 = null;

        EObject lv_then_30_0 = null;

        EObject lv_else_32_0 = null;

        AntlrDatatypeRuleToken lv_name_34_0 = null;

        EObject lv_value_38_0 = null;

        EObject this_CallExpr_40 = null;

        AntlrDatatypeRuleToken lv_name_43_0 = null;

        EObject lv_stmt_47_0 = null;

        EObject lv_stmt_56_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1573:28: ( ( ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' ) | (this_AssignmentStmt_4= ruleAssignmentStmt otherlv_5= ';' ) | ( () otherlv_7= 'while' otherlv_8= '(' ( (lv_condition_9_0= ruleExpr ) ) otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) ) | ( () otherlv_13= 'for' otherlv_14= '(' ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )? otherlv_18= ';' ( (lv_condition_19_0= ruleExpr ) )? otherlv_20= ';' ( (lv_update_21_0= ruleAssignmentStmt ) )? otherlv_22= ')' ( (lv_stmt_23_0= ruleStmt ) ) ) | ( () ( (lv_attrList_25_0= ruleAttrList ) )? otherlv_26= 'if' otherlv_27= '(' ( (lv_condition_28_0= ruleExpr ) ) otherlv_29= ')' ( (lv_then_30_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_31= 'else' ) ( (lv_else_32_0= ruleStmt ) ) )? ) | ( () ( (lv_name_34_0= ruleSimpleStmtKeyword ) ) otherlv_35= ';' ) | ( () otherlv_37= 'return' ( (lv_value_38_0= ruleExpr ) ) otherlv_39= ';' ) | (this_CallExpr_40= ruleCallExpr otherlv_41= ';' ) | ( () ( (lv_name_43_0= ruleForAllFunction ) ) otherlv_44= '(' ( (lv_node_45_0= RULE_TIDENTIFIER ) ) otherlv_46= ')' ( (lv_stmt_47_0= ruleStmt ) ) ) | ( () (otherlv_49= 'forall_distinct_node_pair' | otherlv_50= 'FORALL_DISTINCT_NODE_PAIR' ) otherlv_51= '(' ( (lv_node1_52_0= RULE_TIDENTIFIER ) ) otherlv_53= ',' ( (lv_node2_54_0= RULE_TIDENTIFIER ) ) otherlv_55= ')' ( (lv_stmt_56_0= ruleStmt ) ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1574:1: ( ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' ) | (this_AssignmentStmt_4= ruleAssignmentStmt otherlv_5= ';' ) | ( () otherlv_7= 'while' otherlv_8= '(' ( (lv_condition_9_0= ruleExpr ) ) otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) ) | ( () otherlv_13= 'for' otherlv_14= '(' ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )? otherlv_18= ';' ( (lv_condition_19_0= ruleExpr ) )? otherlv_20= ';' ( (lv_update_21_0= ruleAssignmentStmt ) )? otherlv_22= ')' ( (lv_stmt_23_0= ruleStmt ) ) ) | ( () ( (lv_attrList_25_0= ruleAttrList ) )? otherlv_26= 'if' otherlv_27= '(' ( (lv_condition_28_0= ruleExpr ) ) otherlv_29= ')' ( (lv_then_30_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_31= 'else' ) ( (lv_else_32_0= ruleStmt ) ) )? ) | ( () ( (lv_name_34_0= ruleSimpleStmtKeyword ) ) otherlv_35= ';' ) | ( () otherlv_37= 'return' ( (lv_value_38_0= ruleExpr ) ) otherlv_39= ';' ) | (this_CallExpr_40= ruleCallExpr otherlv_41= ';' ) | ( () ( (lv_name_43_0= ruleForAllFunction ) ) otherlv_44= '(' ( (lv_node_45_0= RULE_TIDENTIFIER ) ) otherlv_46= ')' ( (lv_stmt_47_0= ruleStmt ) ) ) | ( () (otherlv_49= 'forall_distinct_node_pair' | otherlv_50= 'FORALL_DISTINCT_NODE_PAIR' ) otherlv_51= '(' ( (lv_node1_52_0= RULE_TIDENTIFIER ) ) otherlv_53= ',' ( (lv_node2_54_0= RULE_TIDENTIFIER ) ) otherlv_55= ')' ( (lv_stmt_56_0= ruleStmt ) ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1574:1: ( ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' ) | (this_AssignmentStmt_4= ruleAssignmentStmt otherlv_5= ';' ) | ( () otherlv_7= 'while' otherlv_8= '(' ( (lv_condition_9_0= ruleExpr ) ) otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) ) | ( () otherlv_13= 'for' otherlv_14= '(' ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )? otherlv_18= ';' ( (lv_condition_19_0= ruleExpr ) )? otherlv_20= ';' ( (lv_update_21_0= ruleAssignmentStmt ) )? otherlv_22= ')' ( (lv_stmt_23_0= ruleStmt ) ) ) | ( () ( (lv_attrList_25_0= ruleAttrList ) )? otherlv_26= 'if' otherlv_27= '(' ( (lv_condition_28_0= ruleExpr ) ) otherlv_29= ')' ( (lv_then_30_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_31= 'else' ) ( (lv_else_32_0= ruleStmt ) ) )? ) | ( () ( (lv_name_34_0= ruleSimpleStmtKeyword ) ) otherlv_35= ';' ) | ( () otherlv_37= 'return' ( (lv_value_38_0= ruleExpr ) ) otherlv_39= ';' ) | (this_CallExpr_40= ruleCallExpr otherlv_41= ';' ) | ( () ( (lv_name_43_0= ruleForAllFunction ) ) otherlv_44= '(' ( (lv_node_45_0= RULE_TIDENTIFIER ) ) otherlv_46= ')' ( (lv_stmt_47_0= ruleStmt ) ) ) | ( () (otherlv_49= 'forall_distinct_node_pair' | otherlv_50= 'FORALL_DISTINCT_NODE_PAIR' ) otherlv_51= '(' ( (lv_node1_52_0= RULE_TIDENTIFIER ) ) otherlv_53= ',' ( (lv_node2_54_0= RULE_TIDENTIFIER ) ) otherlv_55= ')' ( (lv_stmt_56_0= ruleStmt ) ) ) )
            int alt40=10;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1574:2: ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1574:2: ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1574:3: () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1574:3: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1575:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStmtAccess().getNestedStmtAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleStmt3286); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getStmtAccess().getLeftCurlyBracketKeyword_0_1());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1584:1: ( (lv_stmts_2_0= ruleStmt ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==RULE_TIDENTIFIER||LA32_0==22||(LA32_0>=31 && LA32_0<=34)||(LA32_0>=36 && LA32_0<=38)||(LA32_0>=58 && LA32_0<=67)) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1585:1: (lv_stmts_2_0= ruleStmt )
                    	    {
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1585:1: (lv_stmts_2_0= ruleStmt )
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1586:3: lv_stmts_2_0= ruleStmt
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getStmtAccess().getStmtsStmtParserRuleCall_0_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleStmt_in_ruleStmt3307);
                    	    lv_stmts_2_0=ruleStmt();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"stmts",
                    	              		lv_stmts_2_0, 
                    	              		"Stmt");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleStmt3320); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getStmtAccess().getRightCurlyBracketKeyword_0_3());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1607:6: (this_AssignmentStmt_4= ruleAssignmentStmt otherlv_5= ';' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1607:6: (this_AssignmentStmt_4= ruleAssignmentStmt otherlv_5= ';' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1608:5: this_AssignmentStmt_4= ruleAssignmentStmt otherlv_5= ';'
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStmtAccess().getAssignmentStmtParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAssignmentStmt_in_ruleStmt3350);
                    this_AssignmentStmt_4=ruleAssignmentStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AssignmentStmt_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleStmt3361); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getStmtAccess().getSemicolonKeyword_1_1());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1621:6: ( () otherlv_7= 'while' otherlv_8= '(' ( (lv_condition_9_0= ruleExpr ) ) otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1621:6: ( () otherlv_7= 'while' otherlv_8= '(' ( (lv_condition_9_0= ruleExpr ) ) otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1621:7: () otherlv_7= 'while' otherlv_8= '(' ( (lv_condition_9_0= ruleExpr ) ) otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1621:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1622:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStmtAccess().getWhileStmtAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_7=(Token)match(input,32,FOLLOW_32_in_ruleStmt3390); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getStmtAccess().getWhileKeyword_2_1());
                          
                    }
                    otherlv_8=(Token)match(input,29,FOLLOW_29_in_ruleStmt3402); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getStmtAccess().getLeftParenthesisKeyword_2_2());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1635:1: ( (lv_condition_9_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1636:1: (lv_condition_9_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1636:1: (lv_condition_9_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1637:3: lv_condition_9_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getConditionExprParserRuleCall_2_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleStmt3423);
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

                    otherlv_10=(Token)match(input,30,FOLLOW_30_in_ruleStmt3435); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getStmtAccess().getRightParenthesisKeyword_2_4());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1657:1: ( (lv_stmt_11_0= ruleStmt ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1658:1: (lv_stmt_11_0= ruleStmt )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1658:1: (lv_stmt_11_0= ruleStmt )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1659:3: lv_stmt_11_0= ruleStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getStmtStmtParserRuleCall_2_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmt_in_ruleStmt3456);
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1676:6: ( () otherlv_13= 'for' otherlv_14= '(' ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )? otherlv_18= ';' ( (lv_condition_19_0= ruleExpr ) )? otherlv_20= ';' ( (lv_update_21_0= ruleAssignmentStmt ) )? otherlv_22= ')' ( (lv_stmt_23_0= ruleStmt ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1676:6: ( () otherlv_13= 'for' otherlv_14= '(' ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )? otherlv_18= ';' ( (lv_condition_19_0= ruleExpr ) )? otherlv_20= ';' ( (lv_update_21_0= ruleAssignmentStmt ) )? otherlv_22= ')' ( (lv_stmt_23_0= ruleStmt ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1676:7: () otherlv_13= 'for' otherlv_14= '(' ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )? otherlv_18= ';' ( (lv_condition_19_0= ruleExpr ) )? otherlv_20= ';' ( (lv_update_21_0= ruleAssignmentStmt ) )? otherlv_22= ')' ( (lv_stmt_23_0= ruleStmt ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1676:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1677:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStmtAccess().getForStmtAction_3_0(),
                                  current);
                          
                    }

                    }

                    otherlv_13=(Token)match(input,33,FOLLOW_33_in_ruleStmt3485); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getStmtAccess().getForKeyword_3_1());
                          
                    }
                    otherlv_14=(Token)match(input,29,FOLLOW_29_in_ruleStmt3497); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getStmtAccess().getLeftParenthesisKeyword_3_2());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1690:1: ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==RULE_TIDENTIFIER) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1690:2: ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )*
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1690:2: ( (lv_inits_15_0= ruleAssignmentStmt ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1691:1: (lv_inits_15_0= ruleAssignmentStmt )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1691:1: (lv_inits_15_0= ruleAssignmentStmt )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1692:3: lv_inits_15_0= ruleAssignmentStmt
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getStmtAccess().getInitsAssignmentStmtParserRuleCall_3_3_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleAssignmentStmt_in_ruleStmt3519);
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

                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1708:2: (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )*
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( (LA33_0==16) ) {
                                    alt33=1;
                                }


                                switch (alt33) {
                            	case 1 :
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1708:4: otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) )
                            	    {
                            	    otherlv_16=(Token)match(input,16,FOLLOW_16_in_ruleStmt3532); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_16, grammarAccess.getStmtAccess().getCommaKeyword_3_3_1_0());
                            	          
                            	    }
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1712:1: ( (lv_inits_17_0= ruleAssignmentStmt ) )
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1713:1: (lv_inits_17_0= ruleAssignmentStmt )
                            	    {
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1713:1: (lv_inits_17_0= ruleAssignmentStmt )
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1714:3: lv_inits_17_0= ruleAssignmentStmt
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getStmtAccess().getInitsAssignmentStmtParserRuleCall_3_3_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleAssignmentStmt_in_ruleStmt3553);
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
                            	    break loop33;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_18=(Token)match(input,15,FOLLOW_15_in_ruleStmt3569); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getStmtAccess().getSemicolonKeyword_3_4());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1734:1: ( (lv_condition_19_0= ruleExpr ) )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( ((LA35_0>=RULE_TIDENTIFIER && LA35_0<=RULE_INT)||LA35_0==18||LA35_0==21||LA35_0==29||LA35_0==46||(LA35_0>=48 && LA35_0<=49)||(LA35_0>=68 && LA35_0<=74)||LA35_0==87) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1735:1: (lv_condition_19_0= ruleExpr )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1735:1: (lv_condition_19_0= ruleExpr )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1736:3: lv_condition_19_0= ruleExpr
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getStmtAccess().getConditionExprParserRuleCall_3_5_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExpr_in_ruleStmt3590);
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

                    otherlv_20=(Token)match(input,15,FOLLOW_15_in_ruleStmt3603); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getStmtAccess().getSemicolonKeyword_3_6());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1756:1: ( (lv_update_21_0= ruleAssignmentStmt ) )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==RULE_TIDENTIFIER) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1757:1: (lv_update_21_0= ruleAssignmentStmt )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1757:1: (lv_update_21_0= ruleAssignmentStmt )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1758:3: lv_update_21_0= ruleAssignmentStmt
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getStmtAccess().getUpdateAssignmentStmtParserRuleCall_3_7_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleAssignmentStmt_in_ruleStmt3624);
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

                    otherlv_22=(Token)match(input,30,FOLLOW_30_in_ruleStmt3637); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getStmtAccess().getRightParenthesisKeyword_3_8());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1778:1: ( (lv_stmt_23_0= ruleStmt ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1779:1: (lv_stmt_23_0= ruleStmt )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1779:1: (lv_stmt_23_0= ruleStmt )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1780:3: lv_stmt_23_0= ruleStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getStmtStmtParserRuleCall_3_9_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmt_in_ruleStmt3658);
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1797:6: ( () ( (lv_attrList_25_0= ruleAttrList ) )? otherlv_26= 'if' otherlv_27= '(' ( (lv_condition_28_0= ruleExpr ) ) otherlv_29= ')' ( (lv_then_30_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_31= 'else' ) ( (lv_else_32_0= ruleStmt ) ) )? )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1797:6: ( () ( (lv_attrList_25_0= ruleAttrList ) )? otherlv_26= 'if' otherlv_27= '(' ( (lv_condition_28_0= ruleExpr ) ) otherlv_29= ')' ( (lv_then_30_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_31= 'else' ) ( (lv_else_32_0= ruleStmt ) ) )? )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1797:7: () ( (lv_attrList_25_0= ruleAttrList ) )? otherlv_26= 'if' otherlv_27= '(' ( (lv_condition_28_0= ruleExpr ) ) otherlv_29= ')' ( (lv_then_30_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_31= 'else' ) ( (lv_else_32_0= ruleStmt ) ) )?
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1797:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1798:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStmtAccess().getCondStmtAction_4_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1803:2: ( (lv_attrList_25_0= ruleAttrList ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==31) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1804:1: (lv_attrList_25_0= ruleAttrList )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1804:1: (lv_attrList_25_0= ruleAttrList )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1805:3: lv_attrList_25_0= ruleAttrList
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getStmtAccess().getAttrListAttrListParserRuleCall_4_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleAttrList_in_ruleStmt3696);
                            lv_attrList_25_0=ruleAttrList();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getStmtRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"attrList",
                                      		lv_attrList_25_0, 
                                      		"AttrList");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }

                    otherlv_26=(Token)match(input,34,FOLLOW_34_in_ruleStmt3709); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_26, grammarAccess.getStmtAccess().getIfKeyword_4_2());
                          
                    }
                    otherlv_27=(Token)match(input,29,FOLLOW_29_in_ruleStmt3721); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getStmtAccess().getLeftParenthesisKeyword_4_3());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1829:1: ( (lv_condition_28_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1830:1: (lv_condition_28_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1830:1: (lv_condition_28_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1831:3: lv_condition_28_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getConditionExprParserRuleCall_4_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleStmt3742);
                    lv_condition_28_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"condition",
                              		lv_condition_28_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_29=(Token)match(input,30,FOLLOW_30_in_ruleStmt3754); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_29, grammarAccess.getStmtAccess().getRightParenthesisKeyword_4_5());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1851:1: ( (lv_then_30_0= ruleStmt ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1852:1: (lv_then_30_0= ruleStmt )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1852:1: (lv_then_30_0= ruleStmt )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1853:3: lv_then_30_0= ruleStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getThenStmtParserRuleCall_4_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmt_in_ruleStmt3775);
                    lv_then_30_0=ruleStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"then",
                              		lv_then_30_0, 
                              		"Stmt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1869:2: ( ( ( 'else' )=>otherlv_31= 'else' ) ( (lv_else_32_0= ruleStmt ) ) )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==35) ) {
                        int LA38_1 = input.LA(2);

                        if ( (synpred1_InternalDmpl()) ) {
                            alt38=1;
                        }
                    }
                    switch (alt38) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1869:3: ( ( 'else' )=>otherlv_31= 'else' ) ( (lv_else_32_0= ruleStmt ) )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1869:3: ( ( 'else' )=>otherlv_31= 'else' )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1869:4: ( 'else' )=>otherlv_31= 'else'
                            {
                            otherlv_31=(Token)match(input,35,FOLLOW_35_in_ruleStmt3796); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_31, grammarAccess.getStmtAccess().getElseKeyword_4_7_0());
                                  
                            }

                            }

                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1874:2: ( (lv_else_32_0= ruleStmt ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1875:1: (lv_else_32_0= ruleStmt )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1875:1: (lv_else_32_0= ruleStmt )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1876:3: lv_else_32_0= ruleStmt
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getStmtAccess().getElseStmtParserRuleCall_4_7_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleStmt_in_ruleStmt3818);
                            lv_else_32_0=ruleStmt();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getStmtRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"else",
                                      		lv_else_32_0, 
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
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1893:6: ( () ( (lv_name_34_0= ruleSimpleStmtKeyword ) ) otherlv_35= ';' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1893:6: ( () ( (lv_name_34_0= ruleSimpleStmtKeyword ) ) otherlv_35= ';' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1893:7: () ( (lv_name_34_0= ruleSimpleStmtKeyword ) ) otherlv_35= ';'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1893:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1894:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStmtAccess().getSimpleStmtAction_5_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1899:2: ( (lv_name_34_0= ruleSimpleStmtKeyword ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1900:1: (lv_name_34_0= ruleSimpleStmtKeyword )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1900:1: (lv_name_34_0= ruleSimpleStmtKeyword )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1901:3: lv_name_34_0= ruleSimpleStmtKeyword
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getNameSimpleStmtKeywordParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSimpleStmtKeyword_in_ruleStmt3858);
                    lv_name_34_0=ruleSimpleStmtKeyword();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_34_0, 
                              		"SimpleStmtKeyword");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_35=(Token)match(input,15,FOLLOW_15_in_ruleStmt3870); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_35, grammarAccess.getStmtAccess().getSemicolonKeyword_5_2());
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1922:6: ( () otherlv_37= 'return' ( (lv_value_38_0= ruleExpr ) ) otherlv_39= ';' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1922:6: ( () otherlv_37= 'return' ( (lv_value_38_0= ruleExpr ) ) otherlv_39= ';' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1922:7: () otherlv_37= 'return' ( (lv_value_38_0= ruleExpr ) ) otherlv_39= ';'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1922:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1923:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStmtAccess().getReturnValueStmtAction_6_0(),
                                  current);
                          
                    }

                    }

                    otherlv_37=(Token)match(input,36,FOLLOW_36_in_ruleStmt3899); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_37, grammarAccess.getStmtAccess().getReturnKeyword_6_1());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1932:1: ( (lv_value_38_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1933:1: (lv_value_38_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1933:1: (lv_value_38_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1934:3: lv_value_38_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getValueExprParserRuleCall_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleStmt3920);
                    lv_value_38_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_38_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_39=(Token)match(input,15,FOLLOW_15_in_ruleStmt3932); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_39, grammarAccess.getStmtAccess().getSemicolonKeyword_6_3());
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1955:6: (this_CallExpr_40= ruleCallExpr otherlv_41= ';' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1955:6: (this_CallExpr_40= ruleCallExpr otherlv_41= ';' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1956:5: this_CallExpr_40= ruleCallExpr otherlv_41= ';'
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStmtAccess().getCallExprParserRuleCall_7_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleCallExpr_in_ruleStmt3962);
                    this_CallExpr_40=ruleCallExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CallExpr_40; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_41=(Token)match(input,15,FOLLOW_15_in_ruleStmt3973); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_41, grammarAccess.getStmtAccess().getSemicolonKeyword_7_1());
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1969:6: ( () ( (lv_name_43_0= ruleForAllFunction ) ) otherlv_44= '(' ( (lv_node_45_0= RULE_TIDENTIFIER ) ) otherlv_46= ')' ( (lv_stmt_47_0= ruleStmt ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1969:6: ( () ( (lv_name_43_0= ruleForAllFunction ) ) otherlv_44= '(' ( (lv_node_45_0= RULE_TIDENTIFIER ) ) otherlv_46= ')' ( (lv_stmt_47_0= ruleStmt ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1969:7: () ( (lv_name_43_0= ruleForAllFunction ) ) otherlv_44= '(' ( (lv_node_45_0= RULE_TIDENTIFIER ) ) otherlv_46= ')' ( (lv_stmt_47_0= ruleStmt ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1969:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1970:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStmtAccess().getForAllStmtAction_8_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1975:2: ( (lv_name_43_0= ruleForAllFunction ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1976:1: (lv_name_43_0= ruleForAllFunction )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1976:1: (lv_name_43_0= ruleForAllFunction )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1977:3: lv_name_43_0= ruleForAllFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getNameForAllFunctionParserRuleCall_8_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleForAllFunction_in_ruleStmt4011);
                    lv_name_43_0=ruleForAllFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_43_0, 
                              		"ForAllFunction");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_44=(Token)match(input,29,FOLLOW_29_in_ruleStmt4023); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_44, grammarAccess.getStmtAccess().getLeftParenthesisKeyword_8_2());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1997:1: ( (lv_node_45_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1998:1: (lv_node_45_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1998:1: (lv_node_45_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1999:3: lv_node_45_0= RULE_TIDENTIFIER
                    {
                    lv_node_45_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleStmt4040); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_node_45_0, grammarAccess.getStmtAccess().getNodeTIDENTIFIERTerminalRuleCall_8_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getStmtRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"node",
                              		lv_node_45_0, 
                              		"TIDENTIFIER");
                      	    
                    }

                    }


                    }

                    otherlv_46=(Token)match(input,30,FOLLOW_30_in_ruleStmt4057); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_46, grammarAccess.getStmtAccess().getRightParenthesisKeyword_8_4());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2019:1: ( (lv_stmt_47_0= ruleStmt ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2020:1: (lv_stmt_47_0= ruleStmt )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2020:1: (lv_stmt_47_0= ruleStmt )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2021:3: lv_stmt_47_0= ruleStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getStmtStmtParserRuleCall_8_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmt_in_ruleStmt4078);
                    lv_stmt_47_0=ruleStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"stmt",
                              		lv_stmt_47_0, 
                              		"Stmt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 10 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2038:6: ( () (otherlv_49= 'forall_distinct_node_pair' | otherlv_50= 'FORALL_DISTINCT_NODE_PAIR' ) otherlv_51= '(' ( (lv_node1_52_0= RULE_TIDENTIFIER ) ) otherlv_53= ',' ( (lv_node2_54_0= RULE_TIDENTIFIER ) ) otherlv_55= ')' ( (lv_stmt_56_0= ruleStmt ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2038:6: ( () (otherlv_49= 'forall_distinct_node_pair' | otherlv_50= 'FORALL_DISTINCT_NODE_PAIR' ) otherlv_51= '(' ( (lv_node1_52_0= RULE_TIDENTIFIER ) ) otherlv_53= ',' ( (lv_node2_54_0= RULE_TIDENTIFIER ) ) otherlv_55= ')' ( (lv_stmt_56_0= ruleStmt ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2038:7: () (otherlv_49= 'forall_distinct_node_pair' | otherlv_50= 'FORALL_DISTINCT_NODE_PAIR' ) otherlv_51= '(' ( (lv_node1_52_0= RULE_TIDENTIFIER ) ) otherlv_53= ',' ( (lv_node2_54_0= RULE_TIDENTIFIER ) ) otherlv_55= ')' ( (lv_stmt_56_0= ruleStmt ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2038:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2039:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStmtAccess().getFadnpStmtAction_9_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2044:2: (otherlv_49= 'forall_distinct_node_pair' | otherlv_50= 'FORALL_DISTINCT_NODE_PAIR' )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==37) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==38) ) {
                        alt39=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;
                    }
                    switch (alt39) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2044:4: otherlv_49= 'forall_distinct_node_pair'
                            {
                            otherlv_49=(Token)match(input,37,FOLLOW_37_in_ruleStmt4108); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_49, grammarAccess.getStmtAccess().getForall_distinct_node_pairKeyword_9_1_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2049:7: otherlv_50= 'FORALL_DISTINCT_NODE_PAIR'
                            {
                            otherlv_50=(Token)match(input,38,FOLLOW_38_in_ruleStmt4126); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_50, grammarAccess.getStmtAccess().getFORALL_DISTINCT_NODE_PAIRKeyword_9_1_1());
                                  
                            }

                            }
                            break;

                    }

                    otherlv_51=(Token)match(input,29,FOLLOW_29_in_ruleStmt4139); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_51, grammarAccess.getStmtAccess().getLeftParenthesisKeyword_9_2());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2057:1: ( (lv_node1_52_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2058:1: (lv_node1_52_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2058:1: (lv_node1_52_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2059:3: lv_node1_52_0= RULE_TIDENTIFIER
                    {
                    lv_node1_52_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleStmt4156); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_node1_52_0, grammarAccess.getStmtAccess().getNode1TIDENTIFIERTerminalRuleCall_9_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getStmtRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"node1",
                              		lv_node1_52_0, 
                              		"TIDENTIFIER");
                      	    
                    }

                    }


                    }

                    otherlv_53=(Token)match(input,16,FOLLOW_16_in_ruleStmt4173); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_53, grammarAccess.getStmtAccess().getCommaKeyword_9_4());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2079:1: ( (lv_node2_54_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2080:1: (lv_node2_54_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2080:1: (lv_node2_54_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2081:3: lv_node2_54_0= RULE_TIDENTIFIER
                    {
                    lv_node2_54_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleStmt4190); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_node2_54_0, grammarAccess.getStmtAccess().getNode2TIDENTIFIERTerminalRuleCall_9_5_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getStmtRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"node2",
                              		lv_node2_54_0, 
                              		"TIDENTIFIER");
                      	    
                    }

                    }


                    }

                    otherlv_55=(Token)match(input,30,FOLLOW_30_in_ruleStmt4207); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_55, grammarAccess.getStmtAccess().getRightParenthesisKeyword_9_6());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2101:1: ( (lv_stmt_56_0= ruleStmt ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2102:1: (lv_stmt_56_0= ruleStmt )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2102:1: (lv_stmt_56_0= ruleStmt )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2103:3: lv_stmt_56_0= ruleStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getStmtStmtParserRuleCall_9_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmt_in_ruleStmt4228);
                    lv_stmt_56_0=ruleStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"stmt",
                              		lv_stmt_56_0, 
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2127:1: entryRuleAssignmentStmt returns [EObject current=null] : iv_ruleAssignmentStmt= ruleAssignmentStmt EOF ;
    public final EObject entryRuleAssignmentStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentStmt = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2128:2: (iv_ruleAssignmentStmt= ruleAssignmentStmt EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2129:2: iv_ruleAssignmentStmt= ruleAssignmentStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentStmtRule()); 
            }
            pushFollow(FOLLOW_ruleAssignmentStmt_in_entryRuleAssignmentStmt4265);
            iv_ruleAssignmentStmt=ruleAssignmentStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentStmt4275); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2136:1: ruleAssignmentStmt returns [EObject current=null] : ( ( (lv_variable_0_0= ruleLVal ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpr ) ) ) ;
    public final EObject ruleAssignmentStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_variable_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2139:28: ( ( ( (lv_variable_0_0= ruleLVal ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpr ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2140:1: ( ( (lv_variable_0_0= ruleLVal ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpr ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2140:1: ( ( (lv_variable_0_0= ruleLVal ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpr ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2140:2: ( (lv_variable_0_0= ruleLVal ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpr ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2140:2: ( (lv_variable_0_0= ruleLVal ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2141:1: (lv_variable_0_0= ruleLVal )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2141:1: (lv_variable_0_0= ruleLVal )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2142:3: lv_variable_0_0= ruleLVal
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentStmtAccess().getVariableLValParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLVal_in_ruleAssignmentStmt4321);
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

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleAssignmentStmt4333); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAssignmentStmtAccess().getEqualsSignKeyword_1());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2162:1: ( (lv_value_2_0= ruleExpr ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2163:1: (lv_value_2_0= ruleExpr )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2163:1: (lv_value_2_0= ruleExpr )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2164:3: lv_value_2_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentStmtAccess().getValueExprParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpr_in_ruleAssignmentStmt4354);
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2188:1: entryRuleLVal returns [EObject current=null] : iv_ruleLVal= ruleLVal EOF ;
    public final EObject entryRuleLVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLVal = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2189:2: (iv_ruleLVal= ruleLVal EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2190:2: iv_ruleLVal= ruleLVal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLValRule()); 
            }
            pushFollow(FOLLOW_ruleLVal_in_entryRuleLVal4390);
            iv_ruleLVal=ruleLVal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLVal; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLVal4400); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2197:1: ruleLVal returns [EObject current=null] : ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )* (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )? ) ;
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
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2200:28: ( ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )* (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )? ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2201:1: ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )* (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )? )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2201:1: ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )* (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )? )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2201:2: ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )* (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )?
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2201:2: ( (lv_name_0_0= RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2202:1: (lv_name_0_0= RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2202:1: (lv_name_0_0= RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2203:3: lv_name_0_0= RULE_TIDENTIFIER
            {
            lv_name_0_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleLVal4442); if (state.failed) return current;
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

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2219:2: (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==19) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2219:4: otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']'
            	    {
            	    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleLVal4460); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getLValAccess().getLeftSquareBracketKeyword_1_0());
            	          
            	    }
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2223:1: ( (lv_indices_2_0= ruleExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2224:1: (lv_indices_2_0= ruleExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2224:1: (lv_indices_2_0= ruleExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2225:3: lv_indices_2_0= ruleExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLValAccess().getIndicesExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpr_in_ruleLVal4481);
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

            	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleLVal4493); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getLValAccess().getRightSquareBracketKeyword_1_2());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2245:3: (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==31) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2245:5: otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) )
                    {
                    otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleLVal4508); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getLValAccess().getCommercialAtKeyword_2_0());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2249:1: ( (lv_at_5_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2250:1: (lv_at_5_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2250:1: (lv_at_5_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2251:3: lv_at_5_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLValAccess().getAtExprParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleLVal4529);
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2275:1: entryRuleExpr returns [EObject current=null] : iv_ruleExpr= ruleExpr EOF ;
    public final EObject entryRuleExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2276:2: (iv_ruleExpr= ruleExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2277:2: iv_ruleExpr= ruleExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExprRule()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_entryRuleExpr4567);
            iv_ruleExpr=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpr4577); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2284:1: ruleExpr returns [EObject current=null] : (this_OrExpr_0= ruleOrExpr ( ( ( ( () '?' ) )=> ( () otherlv_2= '?' ) ) ( (lv_then_3_0= ruleExpr ) ) otherlv_4= ':' ( (lv_else_5_0= ruleExpr ) ) )? ) ;
    public final EObject ruleExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_OrExpr_0 = null;

        EObject lv_then_3_0 = null;

        EObject lv_else_5_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2287:28: ( (this_OrExpr_0= ruleOrExpr ( ( ( ( () '?' ) )=> ( () otherlv_2= '?' ) ) ( (lv_then_3_0= ruleExpr ) ) otherlv_4= ':' ( (lv_else_5_0= ruleExpr ) ) )? ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2288:1: (this_OrExpr_0= ruleOrExpr ( ( ( ( () '?' ) )=> ( () otherlv_2= '?' ) ) ( (lv_then_3_0= ruleExpr ) ) otherlv_4= ':' ( (lv_else_5_0= ruleExpr ) ) )? )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2288:1: (this_OrExpr_0= ruleOrExpr ( ( ( ( () '?' ) )=> ( () otherlv_2= '?' ) ) ( (lv_then_3_0= ruleExpr ) ) otherlv_4= ':' ( (lv_else_5_0= ruleExpr ) ) )? )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2289:5: this_OrExpr_0= ruleOrExpr ( ( ( ( () '?' ) )=> ( () otherlv_2= '?' ) ) ( (lv_then_3_0= ruleExpr ) ) otherlv_4= ':' ( (lv_else_5_0= ruleExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExprAccess().getOrExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleOrExpr_in_ruleExpr4624);
            this_OrExpr_0=ruleOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_OrExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2297:1: ( ( ( ( () '?' ) )=> ( () otherlv_2= '?' ) ) ( (lv_then_3_0= ruleExpr ) ) otherlv_4= ':' ( (lv_else_5_0= ruleExpr ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==39) ) {
                int LA43_1 = input.LA(2);

                if ( (synpred2_InternalDmpl()) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2297:2: ( ( ( () '?' ) )=> ( () otherlv_2= '?' ) ) ( (lv_then_3_0= ruleExpr ) ) otherlv_4= ':' ( (lv_else_5_0= ruleExpr ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2297:2: ( ( ( () '?' ) )=> ( () otherlv_2= '?' ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2297:3: ( ( () '?' ) )=> ( () otherlv_2= '?' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2299:5: ( () otherlv_2= '?' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2299:6: () otherlv_2= '?'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2299:6: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2300:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getExprAccess().getTernaryExprConditionAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleExpr4659); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getExprAccess().getQuestionMarkKeyword_1_0_0_1());
                          
                    }

                    }


                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2309:3: ( (lv_then_3_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2310:1: (lv_then_3_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2310:1: (lv_then_3_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2311:3: lv_then_3_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExprAccess().getThenExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleExpr4682);
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

                    otherlv_4=(Token)match(input,40,FOLLOW_40_in_ruleExpr4694); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getExprAccess().getColonKeyword_1_2());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2331:1: ( (lv_else_5_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2332:1: (lv_else_5_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2332:1: (lv_else_5_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2333:3: lv_else_5_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExprAccess().getElseExprParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleExpr4715);
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2357:1: entryRuleOrExpr returns [EObject current=null] : iv_ruleOrExpr= ruleOrExpr EOF ;
    public final EObject entryRuleOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2358:2: (iv_ruleOrExpr= ruleOrExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2359:2: iv_ruleOrExpr= ruleOrExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExprRule()); 
            }
            pushFollow(FOLLOW_ruleOrExpr_in_entryRuleOrExpr4753);
            iv_ruleOrExpr=ruleOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrExpr4763); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2366:1: ruleOrExpr returns [EObject current=null] : (this_AndExpr_0= ruleAndExpr ( ( ( ( () '||' ) )=> ( () otherlv_2= '||' ) ) ( (lv_right_3_0= ruleAndExpr ) ) )* ) ;
    public final EObject ruleOrExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2369:28: ( (this_AndExpr_0= ruleAndExpr ( ( ( ( () '||' ) )=> ( () otherlv_2= '||' ) ) ( (lv_right_3_0= ruleAndExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2370:1: (this_AndExpr_0= ruleAndExpr ( ( ( ( () '||' ) )=> ( () otherlv_2= '||' ) ) ( (lv_right_3_0= ruleAndExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2370:1: (this_AndExpr_0= ruleAndExpr ( ( ( ( () '||' ) )=> ( () otherlv_2= '||' ) ) ( (lv_right_3_0= ruleAndExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2371:5: this_AndExpr_0= ruleAndExpr ( ( ( ( () '||' ) )=> ( () otherlv_2= '||' ) ) ( (lv_right_3_0= ruleAndExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrExprAccess().getAndExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAndExpr_in_ruleOrExpr4810);
            this_AndExpr_0=ruleAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2379:1: ( ( ( ( () '||' ) )=> ( () otherlv_2= '||' ) ) ( (lv_right_3_0= ruleAndExpr ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==41) ) {
                    int LA44_2 = input.LA(2);

                    if ( (synpred3_InternalDmpl()) ) {
                        alt44=1;
                    }


                }


                switch (alt44) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2379:2: ( ( ( () '||' ) )=> ( () otherlv_2= '||' ) ) ( (lv_right_3_0= ruleAndExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2379:2: ( ( ( () '||' ) )=> ( () otherlv_2= '||' ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2379:3: ( ( () '||' ) )=> ( () otherlv_2= '||' )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2381:5: ( () otherlv_2= '||' )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2381:6: () otherlv_2= '||'
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2381:6: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2382:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getOrExprAccess().getOrExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleOrExpr4845); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getOrExprAccess().getVerticalLineVerticalLineKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2391:3: ( (lv_right_3_0= ruleAndExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2392:1: (lv_right_3_0= ruleAndExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2392:1: (lv_right_3_0= ruleAndExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2393:3: lv_right_3_0= ruleAndExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrExprAccess().getRightAndExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndExpr_in_ruleOrExpr4868);
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
    // $ANTLR end "ruleOrExpr"


    // $ANTLR start "entryRuleAndExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2417:1: entryRuleAndExpr returns [EObject current=null] : iv_ruleAndExpr= ruleAndExpr EOF ;
    public final EObject entryRuleAndExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2418:2: (iv_ruleAndExpr= ruleAndExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2419:2: iv_ruleAndExpr= ruleAndExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExprRule()); 
            }
            pushFollow(FOLLOW_ruleAndExpr_in_entryRuleAndExpr4906);
            iv_ruleAndExpr=ruleAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpr4916); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2426:1: ruleAndExpr returns [EObject current=null] : (this_BitwiseOrExpr_0= ruleBitwiseOrExpr ( ( ( ( () '&&' ) )=> ( () otherlv_2= '&&' ) ) ( (lv_right_3_0= ruleBitwiseOrExpr ) ) )* ) ;
    public final EObject ruleAndExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BitwiseOrExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2429:28: ( (this_BitwiseOrExpr_0= ruleBitwiseOrExpr ( ( ( ( () '&&' ) )=> ( () otherlv_2= '&&' ) ) ( (lv_right_3_0= ruleBitwiseOrExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2430:1: (this_BitwiseOrExpr_0= ruleBitwiseOrExpr ( ( ( ( () '&&' ) )=> ( () otherlv_2= '&&' ) ) ( (lv_right_3_0= ruleBitwiseOrExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2430:1: (this_BitwiseOrExpr_0= ruleBitwiseOrExpr ( ( ( ( () '&&' ) )=> ( () otherlv_2= '&&' ) ) ( (lv_right_3_0= ruleBitwiseOrExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2431:5: this_BitwiseOrExpr_0= ruleBitwiseOrExpr ( ( ( ( () '&&' ) )=> ( () otherlv_2= '&&' ) ) ( (lv_right_3_0= ruleBitwiseOrExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndExprAccess().getBitwiseOrExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleBitwiseOrExpr_in_ruleAndExpr4963);
            this_BitwiseOrExpr_0=ruleBitwiseOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_BitwiseOrExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2439:1: ( ( ( ( () '&&' ) )=> ( () otherlv_2= '&&' ) ) ( (lv_right_3_0= ruleBitwiseOrExpr ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==42) ) {
                    int LA45_2 = input.LA(2);

                    if ( (synpred4_InternalDmpl()) ) {
                        alt45=1;
                    }


                }


                switch (alt45) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2439:2: ( ( ( () '&&' ) )=> ( () otherlv_2= '&&' ) ) ( (lv_right_3_0= ruleBitwiseOrExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2439:2: ( ( ( () '&&' ) )=> ( () otherlv_2= '&&' ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2439:3: ( ( () '&&' ) )=> ( () otherlv_2= '&&' )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2441:5: ( () otherlv_2= '&&' )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2441:6: () otherlv_2= '&&'
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2441:6: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2442:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndExprAccess().getAndExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleAndExpr4998); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getAndExprAccess().getAmpersandAmpersandKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2451:3: ( (lv_right_3_0= ruleBitwiseOrExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2452:1: (lv_right_3_0= ruleBitwiseOrExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2452:1: (lv_right_3_0= ruleBitwiseOrExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2453:3: lv_right_3_0= ruleBitwiseOrExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExprAccess().getRightBitwiseOrExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBitwiseOrExpr_in_ruleAndExpr5021);
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
    // $ANTLR end "ruleAndExpr"


    // $ANTLR start "entryRuleBitwiseOrExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2477:1: entryRuleBitwiseOrExpr returns [EObject current=null] : iv_ruleBitwiseOrExpr= ruleBitwiseOrExpr EOF ;
    public final EObject entryRuleBitwiseOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseOrExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2478:2: (iv_ruleBitwiseOrExpr= ruleBitwiseOrExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2479:2: iv_ruleBitwiseOrExpr= ruleBitwiseOrExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseOrExprRule()); 
            }
            pushFollow(FOLLOW_ruleBitwiseOrExpr_in_entryRuleBitwiseOrExpr5059);
            iv_ruleBitwiseOrExpr=ruleBitwiseOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseOrExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseOrExpr5069); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2486:1: ruleBitwiseOrExpr returns [EObject current=null] : (this_XorExpr_0= ruleXorExpr ( ( ( ( () '|' ) )=> ( () otherlv_2= '|' ) ) ( (lv_right_3_0= ruleXorExpr ) ) )* ) ;
    public final EObject ruleBitwiseOrExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XorExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2489:28: ( (this_XorExpr_0= ruleXorExpr ( ( ( ( () '|' ) )=> ( () otherlv_2= '|' ) ) ( (lv_right_3_0= ruleXorExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2490:1: (this_XorExpr_0= ruleXorExpr ( ( ( ( () '|' ) )=> ( () otherlv_2= '|' ) ) ( (lv_right_3_0= ruleXorExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2490:1: (this_XorExpr_0= ruleXorExpr ( ( ( ( () '|' ) )=> ( () otherlv_2= '|' ) ) ( (lv_right_3_0= ruleXorExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2491:5: this_XorExpr_0= ruleXorExpr ( ( ( ( () '|' ) )=> ( () otherlv_2= '|' ) ) ( (lv_right_3_0= ruleXorExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBitwiseOrExprAccess().getXorExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleXorExpr_in_ruleBitwiseOrExpr5116);
            this_XorExpr_0=ruleXorExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_XorExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2499:1: ( ( ( ( () '|' ) )=> ( () otherlv_2= '|' ) ) ( (lv_right_3_0= ruleXorExpr ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==43) ) {
                    int LA46_2 = input.LA(2);

                    if ( (synpred5_InternalDmpl()) ) {
                        alt46=1;
                    }


                }


                switch (alt46) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2499:2: ( ( ( () '|' ) )=> ( () otherlv_2= '|' ) ) ( (lv_right_3_0= ruleXorExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2499:2: ( ( ( () '|' ) )=> ( () otherlv_2= '|' ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2499:3: ( ( () '|' ) )=> ( () otherlv_2= '|' )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2501:5: ( () otherlv_2= '|' )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2501:6: () otherlv_2= '|'
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2501:6: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2502:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBitwiseOrExprAccess().getBitwiseOrExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleBitwiseOrExpr5151); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getBitwiseOrExprAccess().getVerticalLineKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2511:3: ( (lv_right_3_0= ruleXorExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2512:1: (lv_right_3_0= ruleXorExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2512:1: (lv_right_3_0= ruleXorExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2513:3: lv_right_3_0= ruleXorExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBitwiseOrExprAccess().getRightXorExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleXorExpr_in_ruleBitwiseOrExpr5174);
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
    // $ANTLR end "ruleBitwiseOrExpr"


    // $ANTLR start "entryRuleXorExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2537:1: entryRuleXorExpr returns [EObject current=null] : iv_ruleXorExpr= ruleXorExpr EOF ;
    public final EObject entryRuleXorExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2538:2: (iv_ruleXorExpr= ruleXorExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2539:2: iv_ruleXorExpr= ruleXorExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXorExprRule()); 
            }
            pushFollow(FOLLOW_ruleXorExpr_in_entryRuleXorExpr5212);
            iv_ruleXorExpr=ruleXorExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXorExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXorExpr5222); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2546:1: ruleXorExpr returns [EObject current=null] : (this_BitwiseAndExpr_0= ruleBitwiseAndExpr ( ( ( ( () '^' ) )=> ( () otherlv_2= '^' ) ) ( (lv_right_3_0= ruleBitwiseAndExpr ) ) )* ) ;
    public final EObject ruleXorExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BitwiseAndExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2549:28: ( (this_BitwiseAndExpr_0= ruleBitwiseAndExpr ( ( ( ( () '^' ) )=> ( () otherlv_2= '^' ) ) ( (lv_right_3_0= ruleBitwiseAndExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2550:1: (this_BitwiseAndExpr_0= ruleBitwiseAndExpr ( ( ( ( () '^' ) )=> ( () otherlv_2= '^' ) ) ( (lv_right_3_0= ruleBitwiseAndExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2550:1: (this_BitwiseAndExpr_0= ruleBitwiseAndExpr ( ( ( ( () '^' ) )=> ( () otherlv_2= '^' ) ) ( (lv_right_3_0= ruleBitwiseAndExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2551:5: this_BitwiseAndExpr_0= ruleBitwiseAndExpr ( ( ( ( () '^' ) )=> ( () otherlv_2= '^' ) ) ( (lv_right_3_0= ruleBitwiseAndExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getXorExprAccess().getBitwiseAndExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleBitwiseAndExpr_in_ruleXorExpr5269);
            this_BitwiseAndExpr_0=ruleBitwiseAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_BitwiseAndExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2559:1: ( ( ( ( () '^' ) )=> ( () otherlv_2= '^' ) ) ( (lv_right_3_0= ruleBitwiseAndExpr ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==44) ) {
                    int LA47_2 = input.LA(2);

                    if ( (synpred6_InternalDmpl()) ) {
                        alt47=1;
                    }


                }


                switch (alt47) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2559:2: ( ( ( () '^' ) )=> ( () otherlv_2= '^' ) ) ( (lv_right_3_0= ruleBitwiseAndExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2559:2: ( ( ( () '^' ) )=> ( () otherlv_2= '^' ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2559:3: ( ( () '^' ) )=> ( () otherlv_2= '^' )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2561:5: ( () otherlv_2= '^' )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2561:6: () otherlv_2= '^'
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2561:6: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2562:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getXorExprAccess().getXorExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleXorExpr5304); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getXorExprAccess().getCircumflexAccentKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2571:3: ( (lv_right_3_0= ruleBitwiseAndExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2572:1: (lv_right_3_0= ruleBitwiseAndExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2572:1: (lv_right_3_0= ruleBitwiseAndExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2573:3: lv_right_3_0= ruleBitwiseAndExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getXorExprAccess().getRightBitwiseAndExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBitwiseAndExpr_in_ruleXorExpr5327);
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
    // $ANTLR end "ruleXorExpr"


    // $ANTLR start "entryRuleBitwiseAndExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2597:1: entryRuleBitwiseAndExpr returns [EObject current=null] : iv_ruleBitwiseAndExpr= ruleBitwiseAndExpr EOF ;
    public final EObject entryRuleBitwiseAndExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseAndExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2598:2: (iv_ruleBitwiseAndExpr= ruleBitwiseAndExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2599:2: iv_ruleBitwiseAndExpr= ruleBitwiseAndExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseAndExprRule()); 
            }
            pushFollow(FOLLOW_ruleBitwiseAndExpr_in_entryRuleBitwiseAndExpr5365);
            iv_ruleBitwiseAndExpr=ruleBitwiseAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseAndExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitwiseAndExpr5375); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2606:1: ruleBitwiseAndExpr returns [EObject current=null] : (this_EqualityExpr_0= ruleEqualityExpr ( ( ( ( () '&' ) )=> ( () otherlv_2= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )* ) ;
    public final EObject ruleBitwiseAndExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_EqualityExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2609:28: ( (this_EqualityExpr_0= ruleEqualityExpr ( ( ( ( () '&' ) )=> ( () otherlv_2= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2610:1: (this_EqualityExpr_0= ruleEqualityExpr ( ( ( ( () '&' ) )=> ( () otherlv_2= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2610:1: (this_EqualityExpr_0= ruleEqualityExpr ( ( ( ( () '&' ) )=> ( () otherlv_2= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2611:5: this_EqualityExpr_0= ruleEqualityExpr ( ( ( ( () '&' ) )=> ( () otherlv_2= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBitwiseAndExprAccess().getEqualityExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleEqualityExpr_in_ruleBitwiseAndExpr5422);
            this_EqualityExpr_0=ruleEqualityExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_EqualityExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2619:1: ( ( ( ( () '&' ) )=> ( () otherlv_2= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==45) ) {
                    int LA48_2 = input.LA(2);

                    if ( (synpred7_InternalDmpl()) ) {
                        alt48=1;
                    }


                }


                switch (alt48) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2619:2: ( ( ( () '&' ) )=> ( () otherlv_2= '&' ) ) ( (lv_right_3_0= ruleEqualityExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2619:2: ( ( ( () '&' ) )=> ( () otherlv_2= '&' ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2619:3: ( ( () '&' ) )=> ( () otherlv_2= '&' )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2621:5: ( () otherlv_2= '&' )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2621:6: () otherlv_2= '&'
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2621:6: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2622:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBitwiseAndExprAccess().getBitwiseAndExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,45,FOLLOW_45_in_ruleBitwiseAndExpr5457); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getBitwiseAndExprAccess().getAmpersandKeyword_1_0_0_1());
            	          
            	    }

            	    }


            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2631:3: ( (lv_right_3_0= ruleEqualityExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2632:1: (lv_right_3_0= ruleEqualityExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2632:1: (lv_right_3_0= ruleEqualityExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2633:3: lv_right_3_0= ruleEqualityExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBitwiseAndExprAccess().getRightEqualityExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEqualityExpr_in_ruleBitwiseAndExpr5480);
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
    // $ANTLR end "ruleBitwiseAndExpr"


    // $ANTLR start "entryRuleEqualityExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2657:1: entryRuleEqualityExpr returns [EObject current=null] : iv_ruleEqualityExpr= ruleEqualityExpr EOF ;
    public final EObject entryRuleEqualityExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2658:2: (iv_ruleEqualityExpr= ruleEqualityExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2659:2: iv_ruleEqualityExpr= ruleEqualityExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExprRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpr_in_entryRuleEqualityExpr5518);
            iv_ruleEqualityExpr=ruleEqualityExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpr5528); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2666:1: ruleEqualityExpr returns [EObject current=null] : (this_CompareExpr_0= ruleCompareExpr ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )* ) ;
    public final EObject ruleEqualityExpr() throws RecognitionException {
        EObject current = null;

        EObject this_CompareExpr_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2669:28: ( (this_CompareExpr_0= ruleCompareExpr ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2670:1: (this_CompareExpr_0= ruleCompareExpr ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2670:1: (this_CompareExpr_0= ruleCompareExpr ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2671:5: this_CompareExpr_0= ruleCompareExpr ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEqualityExprAccess().getCompareExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleCompareExpr_in_ruleEqualityExpr5575);
            this_CompareExpr_0=ruleCompareExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_CompareExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2679:1: ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==76) ) {
                    int LA49_2 = input.LA(2);

                    if ( (synpred8_InternalDmpl()) ) {
                        alt49=1;
                    }


                }
                else if ( (LA49_0==77) ) {
                    int LA49_3 = input.LA(2);

                    if ( (synpred8_InternalDmpl()) ) {
                        alt49=1;
                    }


                }


                switch (alt49) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2679:2: ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2679:2: ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2679:3: ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2684:6: ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2684:7: () ( (lv_operator_2_0= ruleEqualityOperator ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2684:7: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2685:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getEqualityExprAccess().getEqualityExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2690:2: ( (lv_operator_2_0= ruleEqualityOperator ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2691:1: (lv_operator_2_0= ruleEqualityOperator )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2691:1: (lv_operator_2_0= ruleEqualityOperator )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2692:3: lv_operator_2_0= ruleEqualityOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExprAccess().getOperatorEqualityOperatorEnumRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpr5624);
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

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2708:4: ( (lv_right_3_0= ruleCompareExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2709:1: (lv_right_3_0= ruleCompareExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2709:1: (lv_right_3_0= ruleCompareExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2710:3: lv_right_3_0= ruleCompareExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExprAccess().getRightCompareExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCompareExpr_in_ruleEqualityExpr5647);
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
    // $ANTLR end "ruleEqualityExpr"


    // $ANTLR start "entryRuleCompareExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2734:1: entryRuleCompareExpr returns [EObject current=null] : iv_ruleCompareExpr= ruleCompareExpr EOF ;
    public final EObject entryRuleCompareExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompareExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2735:2: (iv_ruleCompareExpr= ruleCompareExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2736:2: iv_ruleCompareExpr= ruleCompareExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompareExprRule()); 
            }
            pushFollow(FOLLOW_ruleCompareExpr_in_entryRuleCompareExpr5685);
            iv_ruleCompareExpr=ruleCompareExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompareExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompareExpr5695); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2743:1: ruleCompareExpr returns [EObject current=null] : (this_ShiftExpr_0= ruleShiftExpr ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )* ) ;
    public final EObject ruleCompareExpr() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpr_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2746:28: ( (this_ShiftExpr_0= ruleShiftExpr ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2747:1: (this_ShiftExpr_0= ruleShiftExpr ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2747:1: (this_ShiftExpr_0= ruleShiftExpr ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2748:5: this_ShiftExpr_0= ruleShiftExpr ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getCompareExprAccess().getShiftExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleShiftExpr_in_ruleCompareExpr5742);
            this_ShiftExpr_0=ruleShiftExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ShiftExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2756:1: ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )*
            loop50:
            do {
                int alt50=2;
                switch ( input.LA(1) ) {
                case 78:
                    {
                    int LA50_2 = input.LA(2);

                    if ( (synpred9_InternalDmpl()) ) {
                        alt50=1;
                    }


                    }
                    break;
                case 79:
                    {
                    int LA50_3 = input.LA(2);

                    if ( (synpred9_InternalDmpl()) ) {
                        alt50=1;
                    }


                    }
                    break;
                case 80:
                    {
                    int LA50_4 = input.LA(2);

                    if ( (synpred9_InternalDmpl()) ) {
                        alt50=1;
                    }


                    }
                    break;
                case 81:
                    {
                    int LA50_5 = input.LA(2);

                    if ( (synpred9_InternalDmpl()) ) {
                        alt50=1;
                    }


                    }
                    break;

                }

                switch (alt50) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2756:2: ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2756:2: ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2756:3: ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2761:6: ( () ( (lv_operator_2_0= ruleCompareOperator ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2761:7: () ( (lv_operator_2_0= ruleCompareOperator ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2761:7: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2762:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getCompareExprAccess().getCompareExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2767:2: ( (lv_operator_2_0= ruleCompareOperator ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2768:1: (lv_operator_2_0= ruleCompareOperator )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2768:1: (lv_operator_2_0= ruleCompareOperator )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2769:3: lv_operator_2_0= ruleCompareOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCompareExprAccess().getOperatorCompareOperatorEnumRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCompareOperator_in_ruleCompareExpr5791);
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

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2785:4: ( (lv_right_3_0= ruleShiftExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2786:1: (lv_right_3_0= ruleShiftExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2786:1: (lv_right_3_0= ruleShiftExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2787:3: lv_right_3_0= ruleShiftExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCompareExprAccess().getRightShiftExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleShiftExpr_in_ruleCompareExpr5814);
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
    // $ANTLR end "ruleCompareExpr"


    // $ANTLR start "entryRuleShiftExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2811:1: entryRuleShiftExpr returns [EObject current=null] : iv_ruleShiftExpr= ruleShiftExpr EOF ;
    public final EObject entryRuleShiftExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2812:2: (iv_ruleShiftExpr= ruleShiftExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2813:2: iv_ruleShiftExpr= ruleShiftExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShiftExprRule()); 
            }
            pushFollow(FOLLOW_ruleShiftExpr_in_entryRuleShiftExpr5852);
            iv_ruleShiftExpr=ruleShiftExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShiftExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleShiftExpr5862); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2820:1: ruleShiftExpr returns [EObject current=null] : (this_AdditiveExpr_0= ruleAdditiveExpr ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )* ) ;
    public final EObject ruleShiftExpr() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpr_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2823:28: ( (this_AdditiveExpr_0= ruleAdditiveExpr ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2824:1: (this_AdditiveExpr_0= ruleAdditiveExpr ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2824:1: (this_AdditiveExpr_0= ruleAdditiveExpr ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2825:5: this_AdditiveExpr_0= ruleAdditiveExpr ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getShiftExprAccess().getAdditiveExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAdditiveExpr_in_ruleShiftExpr5909);
            this_AdditiveExpr_0=ruleAdditiveExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AdditiveExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2833:1: ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==82) ) {
                    int LA51_2 = input.LA(2);

                    if ( (synpred10_InternalDmpl()) ) {
                        alt51=1;
                    }


                }
                else if ( (LA51_0==83) ) {
                    int LA51_3 = input.LA(2);

                    if ( (synpred10_InternalDmpl()) ) {
                        alt51=1;
                    }


                }


                switch (alt51) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2833:2: ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2833:2: ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2833:3: ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2838:6: ( () ( (lv_operator_2_0= ruleShiftOperator ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2838:7: () ( (lv_operator_2_0= ruleShiftOperator ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2838:7: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2839:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getShiftExprAccess().getShiftExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2844:2: ( (lv_operator_2_0= ruleShiftOperator ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2845:1: (lv_operator_2_0= ruleShiftOperator )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2845:1: (lv_operator_2_0= ruleShiftOperator )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2846:3: lv_operator_2_0= ruleShiftOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExprAccess().getOperatorShiftOperatorEnumRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleShiftOperator_in_ruleShiftExpr5958);
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

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2862:4: ( (lv_right_3_0= ruleAdditiveExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2863:1: (lv_right_3_0= ruleAdditiveExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2863:1: (lv_right_3_0= ruleAdditiveExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2864:3: lv_right_3_0= ruleAdditiveExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExprAccess().getRightAdditiveExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpr_in_ruleShiftExpr5981);
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
    // $ANTLR end "ruleShiftExpr"


    // $ANTLR start "entryRuleAdditiveExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2888:1: entryRuleAdditiveExpr returns [EObject current=null] : iv_ruleAdditiveExpr= ruleAdditiveExpr EOF ;
    public final EObject entryRuleAdditiveExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2889:2: (iv_ruleAdditiveExpr= ruleAdditiveExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2890:2: iv_ruleAdditiveExpr= ruleAdditiveExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExprRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpr_in_entryRuleAdditiveExpr6019);
            iv_ruleAdditiveExpr=ruleAdditiveExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpr6029); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2897:1: ruleAdditiveExpr returns [EObject current=null] : (this_MultiplicativeExpr_0= ruleMultiplicativeExpr ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )* ) ;
    public final EObject ruleAdditiveExpr() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpr_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2900:28: ( (this_MultiplicativeExpr_0= ruleMultiplicativeExpr ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2901:1: (this_MultiplicativeExpr_0= ruleMultiplicativeExpr ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2901:1: (this_MultiplicativeExpr_0= ruleMultiplicativeExpr ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2902:5: this_MultiplicativeExpr_0= ruleMultiplicativeExpr ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAdditiveExprAccess().getMultiplicativeExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpr_in_ruleAdditiveExpr6076);
            this_MultiplicativeExpr_0=ruleMultiplicativeExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MultiplicativeExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2910:1: ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==48) ) {
                    int LA52_2 = input.LA(2);

                    if ( (synpred11_InternalDmpl()) ) {
                        alt52=1;
                    }


                }
                else if ( (LA52_0==49) ) {
                    int LA52_3 = input.LA(2);

                    if ( (synpred11_InternalDmpl()) ) {
                        alt52=1;
                    }


                }


                switch (alt52) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2910:2: ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2910:2: ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2910:3: ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2915:6: ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2915:7: () ( (lv_operator_2_0= ruleAdditiveOperator ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2915:7: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2916:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAdditiveExprAccess().getAdditiveExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2921:2: ( (lv_operator_2_0= ruleAdditiveOperator ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2922:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2922:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2923:3: lv_operator_2_0= ruleAdditiveOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExprAccess().getOperatorAdditiveOperatorEnumRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpr6125);
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

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2939:4: ( (lv_right_3_0= ruleMultiplicativeExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2940:1: (lv_right_3_0= ruleMultiplicativeExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2940:1: (lv_right_3_0= ruleMultiplicativeExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2941:3: lv_right_3_0= ruleMultiplicativeExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExprAccess().getRightMultiplicativeExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplicativeExpr_in_ruleAdditiveExpr6148);
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
    // $ANTLR end "ruleAdditiveExpr"


    // $ANTLR start "entryRuleMultiplicativeExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2965:1: entryRuleMultiplicativeExpr returns [EObject current=null] : iv_ruleMultiplicativeExpr= ruleMultiplicativeExpr EOF ;
    public final EObject entryRuleMultiplicativeExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2966:2: (iv_ruleMultiplicativeExpr= ruleMultiplicativeExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2967:2: iv_ruleMultiplicativeExpr= ruleMultiplicativeExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExprRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpr_in_entryRuleMultiplicativeExpr6186);
            iv_ruleMultiplicativeExpr=ruleMultiplicativeExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpr6196); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2974:1: ruleMultiplicativeExpr returns [EObject current=null] : (this_TerminalExpr_0= ruleTerminalExpr ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )* ) ;
    public final EObject ruleMultiplicativeExpr() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalExpr_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2977:28: ( (this_TerminalExpr_0= ruleTerminalExpr ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2978:1: (this_TerminalExpr_0= ruleTerminalExpr ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2978:1: (this_TerminalExpr_0= ruleTerminalExpr ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2979:5: this_TerminalExpr_0= ruleTerminalExpr ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplicativeExprAccess().getTerminalExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleTerminalExpr_in_ruleMultiplicativeExpr6243);
            this_TerminalExpr_0=ruleTerminalExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TerminalExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2987:1: ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )*
            loop53:
            do {
                int alt53=2;
                switch ( input.LA(1) ) {
                case 84:
                    {
                    int LA53_2 = input.LA(2);

                    if ( (synpred12_InternalDmpl()) ) {
                        alt53=1;
                    }


                    }
                    break;
                case 85:
                    {
                    int LA53_3 = input.LA(2);

                    if ( (synpred12_InternalDmpl()) ) {
                        alt53=1;
                    }


                    }
                    break;
                case 86:
                    {
                    int LA53_4 = input.LA(2);

                    if ( (synpred12_InternalDmpl()) ) {
                        alt53=1;
                    }


                    }
                    break;

                }

                switch (alt53) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2987:2: ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2987:2: ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2987:3: ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2992:6: ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2992:7: () ( (lv_operator_2_0= ruleMultiplicativeOperator ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2992:7: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2993:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplicativeExprAccess().getMultiplicativeExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2998:2: ( (lv_operator_2_0= ruleMultiplicativeOperator ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2999:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2999:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3000:3: lv_operator_2_0= ruleMultiplicativeOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExprAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpr6292);
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

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3016:4: ( (lv_right_3_0= ruleTerminalExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3017:1: (lv_right_3_0= ruleTerminalExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3017:1: (lv_right_3_0= ruleTerminalExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3018:3: lv_right_3_0= ruleTerminalExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExprAccess().getRightTerminalExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTerminalExpr_in_ruleMultiplicativeExpr6315);
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
            	    break loop53;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3042:1: entryRuleTerminalExpr returns [EObject current=null] : iv_ruleTerminalExpr= ruleTerminalExpr EOF ;
    public final EObject entryRuleTerminalExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3043:2: (iv_ruleTerminalExpr= ruleTerminalExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3044:2: iv_ruleTerminalExpr= ruleTerminalExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTerminalExprRule()); 
            }
            pushFollow(FOLLOW_ruleTerminalExpr_in_entryRuleTerminalExpr6353);
            iv_ruleTerminalExpr=ruleTerminalExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerminalExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalExpr6363); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3051:1: ruleTerminalExpr returns [EObject current=null] : (this_LVal_0= ruleLVal | ( () otherlv_2= 'id' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= ruleDouble ) ) ) | ( () otherlv_8= '#N' ) | ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) ) | ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' ) | this_CallExpr_19= ruleCallExpr | (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' ) ) ;
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
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3054:28: ( (this_LVal_0= ruleLVal | ( () otherlv_2= 'id' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= ruleDouble ) ) ) | ( () otherlv_8= '#N' ) | ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) ) | ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' ) | this_CallExpr_19= ruleCallExpr | (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3055:1: (this_LVal_0= ruleLVal | ( () otherlv_2= 'id' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= ruleDouble ) ) ) | ( () otherlv_8= '#N' ) | ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) ) | ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' ) | this_CallExpr_19= ruleCallExpr | (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3055:1: (this_LVal_0= ruleLVal | ( () otherlv_2= 'id' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= ruleDouble ) ) ) | ( () otherlv_8= '#N' ) | ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) ) | ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' ) | this_CallExpr_19= ruleCallExpr | (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' ) )
            int alt54=9;
            alt54 = dfa54.predict(input);
            switch (alt54) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3056:5: this_LVal_0= ruleLVal
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalExprAccess().getLValParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLVal_in_ruleTerminalExpr6410);
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3065:6: ( () otherlv_2= 'id' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3065:6: ( () otherlv_2= 'id' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3065:7: () otherlv_2= 'id'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3065:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3066:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getIdExprAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,46,FOLLOW_46_in_ruleTerminalExpr6437); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTerminalExprAccess().getIdKeyword_1_1());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3076:6: ( () ( (lv_value_4_0= RULE_INT ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3076:6: ( () ( (lv_value_4_0= RULE_INT ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3076:7: () ( (lv_value_4_0= RULE_INT ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3076:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3077:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getIntExprAction_2_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3082:2: ( (lv_value_4_0= RULE_INT ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3083:1: (lv_value_4_0= RULE_INT )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3083:1: (lv_value_4_0= RULE_INT )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3084:3: lv_value_4_0= RULE_INT
                    {
                    lv_value_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTerminalExpr6471); if (state.failed) return current;
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3101:6: ( () ( (lv_value_6_0= ruleDouble ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3101:6: ( () ( (lv_value_6_0= ruleDouble ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3101:7: () ( (lv_value_6_0= ruleDouble ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3101:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3102:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getDoubleExprAction_3_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3107:2: ( (lv_value_6_0= ruleDouble ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3108:1: (lv_value_6_0= ruleDouble )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3108:1: (lv_value_6_0= ruleDouble )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3109:3: lv_value_6_0= ruleDouble
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerminalExprAccess().getValueDoubleParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDouble_in_ruleTerminalExpr6514);
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3126:6: ( () otherlv_8= '#N' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3126:6: ( () otherlv_8= '#N' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3126:7: () otherlv_8= '#N'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3126:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3127:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getNodeNumExprAction_4_0(),
                                  current);
                          
                    }

                    }

                    otherlv_8=(Token)match(input,21,FOLLOW_21_in_ruleTerminalExpr6543); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getTerminalExprAccess().getNKeyword_4_1());
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3137:6: ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3137:6: ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3137:7: () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3137:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3138:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getUnaryExprAction_5_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3143:2: ( (lv_operator_10_0= ruleUnaryOperator ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3144:1: (lv_operator_10_0= ruleUnaryOperator )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3144:1: (lv_operator_10_0= ruleUnaryOperator )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3145:3: lv_operator_10_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerminalExprAccess().getOperatorUnaryOperatorEnumRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleTerminalExpr6581);
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

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3161:2: ( (lv_operand_11_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3162:1: (lv_operand_11_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3162:1: (lv_operand_11_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3163:3: lv_operand_11_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerminalExprAccess().getOperandExprParserRuleCall_5_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleTerminalExpr6602);
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3180:6: ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3180:6: ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3180:7: () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3180:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3181:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getBuiltInExprAction_6_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3186:2: ( (lv_function_13_0= ruleBuiltInFunction ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3187:1: (lv_function_13_0= ruleBuiltInFunction )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3187:1: (lv_function_13_0= ruleBuiltInFunction )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3188:3: lv_function_13_0= ruleBuiltInFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerminalExprAccess().getFunctionBuiltInFunctionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBuiltInFunction_in_ruleTerminalExpr6640);
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

                    otherlv_14=(Token)match(input,29,FOLLOW_29_in_ruleTerminalExpr6652); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getTerminalExprAccess().getLeftParenthesisKeyword_6_2());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3208:1: ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3209:1: (lv_firstArg_15_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3209:1: (lv_firstArg_15_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3210:3: lv_firstArg_15_0= RULE_TIDENTIFIER
                    {
                    lv_firstArg_15_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleTerminalExpr6669); if (state.failed) return current;
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

                    otherlv_16=(Token)match(input,16,FOLLOW_16_in_ruleTerminalExpr6686); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getTerminalExprAccess().getCommaKeyword_6_4());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3230:1: ( (lv_secondArg_17_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3231:1: (lv_secondArg_17_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3231:1: (lv_secondArg_17_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3232:3: lv_secondArg_17_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerminalExprAccess().getSecondArgExprParserRuleCall_6_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleTerminalExpr6707);
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

                    otherlv_18=(Token)match(input,30,FOLLOW_30_in_ruleTerminalExpr6719); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getTerminalExprAccess().getRightParenthesisKeyword_6_6());
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3254:5: this_CallExpr_19= ruleCallExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalExprAccess().getCallExprParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleCallExpr_in_ruleTerminalExpr6748);
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3263:6: (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3263:6: (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3263:8: otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')'
                    {
                    otherlv_20=(Token)match(input,29,FOLLOW_29_in_ruleTerminalExpr6766); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getTerminalExprAccess().getLeftParenthesisKeyword_8_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalExprAccess().getExprParserRuleCall_8_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleTerminalExpr6788);
                    this_Expr_21=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Expr_21; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_22=(Token)match(input,30,FOLLOW_30_in_ruleTerminalExpr6799); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3288:1: entryRuleCallExpr returns [EObject current=null] : iv_ruleCallExpr= ruleCallExpr EOF ;
    public final EObject entryRuleCallExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3289:2: (iv_ruleCallExpr= ruleCallExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3290:2: iv_ruleCallExpr= ruleCallExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallExprRule()); 
            }
            pushFollow(FOLLOW_ruleCallExpr_in_entryRuleCallExpr6836);
            iv_ruleCallExpr=ruleCallExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCallExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallExpr6846); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3297:1: ruleCallExpr returns [EObject current=null] : ( ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )? ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '(' ( ( (lv_args_4_0= ruleExpr ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) ) )* )? otherlv_7= ')' (otherlv_8= '@' ( (lv_at_9_0= ruleExpr ) ) )? ) ;
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
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3300:28: ( ( ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )? ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '(' ( ( (lv_args_4_0= ruleExpr ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) ) )* )? otherlv_7= ')' (otherlv_8= '@' ( (lv_at_9_0= ruleExpr ) ) )? ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3301:1: ( ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )? ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '(' ( ( (lv_args_4_0= ruleExpr ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) ) )* )? otherlv_7= ')' (otherlv_8= '@' ( (lv_at_9_0= ruleExpr ) ) )? )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3301:1: ( ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )? ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '(' ( ( (lv_args_4_0= ruleExpr ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) ) )* )? otherlv_7= ')' (otherlv_8= '@' ( (lv_at_9_0= ruleExpr ) ) )? )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3301:2: ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )? ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '(' ( ( (lv_args_4_0= ruleExpr ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) ) )* )? otherlv_7= ')' (otherlv_8= '@' ( (lv_at_9_0= ruleExpr ) ) )?
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3301:2: ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_TIDENTIFIER) ) {
                int LA55_1 = input.LA(2);

                if ( (LA55_1==47) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3301:3: ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3301:3: ( (lv_namespace_0_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3302:1: (lv_namespace_0_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3302:1: (lv_namespace_0_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3303:3: lv_namespace_0_0= RULE_TIDENTIFIER
                    {
                    lv_namespace_0_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleCallExpr6889); if (state.failed) return current;
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

                    otherlv_1=(Token)match(input,47,FOLLOW_47_in_ruleCallExpr6906); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCallExprAccess().getColonColonKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3323:3: ( (lv_name_2_0= RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3324:1: (lv_name_2_0= RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3324:1: (lv_name_2_0= RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3325:3: lv_name_2_0= RULE_TIDENTIFIER
            {
            lv_name_2_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleCallExpr6925); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleCallExpr6942); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getCallExprAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3345:1: ( ( (lv_args_4_0= ruleExpr ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) ) )* )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=RULE_TIDENTIFIER && LA57_0<=RULE_INT)||LA57_0==18||LA57_0==21||LA57_0==29||LA57_0==46||(LA57_0>=48 && LA57_0<=49)||(LA57_0>=68 && LA57_0<=74)||LA57_0==87) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3345:2: ( (lv_args_4_0= ruleExpr ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) ) )*
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3345:2: ( (lv_args_4_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3346:1: (lv_args_4_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3346:1: (lv_args_4_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3347:3: lv_args_4_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallExprAccess().getArgsExprParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleCallExpr6964);
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

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3363:2: (otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==16) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3363:4: otherlv_5= ',' ( (lv_args_6_0= ruleExpr ) )
                    	    {
                    	    otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleCallExpr6977); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getCallExprAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3367:1: ( (lv_args_6_0= ruleExpr ) )
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3368:1: (lv_args_6_0= ruleExpr )
                    	    {
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3368:1: (lv_args_6_0= ruleExpr )
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3369:3: lv_args_6_0= ruleExpr
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCallExprAccess().getArgsExprParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExpr_in_ruleCallExpr6998);
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
                    	    break loop56;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,30,FOLLOW_30_in_ruleCallExpr7014); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getCallExprAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3389:1: (otherlv_8= '@' ( (lv_at_9_0= ruleExpr ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==31) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3389:3: otherlv_8= '@' ( (lv_at_9_0= ruleExpr ) )
                    {
                    otherlv_8=(Token)match(input,31,FOLLOW_31_in_ruleCallExpr7027); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getCallExprAccess().getCommercialAtKeyword_5_0());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3393:1: ( (lv_at_9_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3394:1: (lv_at_9_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3394:1: (lv_at_9_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3395:3: lv_at_9_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallExprAccess().getAtExprParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleCallExpr7048);
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3419:1: entryRuleSign returns [String current=null] : iv_ruleSign= ruleSign EOF ;
    public final String entryRuleSign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSign = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3420:2: (iv_ruleSign= ruleSign EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3421:2: iv_ruleSign= ruleSign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignRule()); 
            }
            pushFollow(FOLLOW_ruleSign_in_entryRuleSign7087);
            iv_ruleSign=ruleSign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSign7098); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3428:1: ruleSign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleSign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3431:28: ( (kw= '+' | kw= '-' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3432:1: (kw= '+' | kw= '-' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3432:1: (kw= '+' | kw= '-' )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==48) ) {
                alt59=1;
            }
            else if ( (LA59_0==49) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3433:2: kw= '+'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleSign7136); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3440:2: kw= '-'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleSign7155); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3453:1: entryRuleSimpType returns [String current=null] : iv_ruleSimpType= ruleSimpType EOF ;
    public final String entryRuleSimpType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSimpType = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3454:2: (iv_ruleSimpType= ruleSimpType EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3455:2: iv_ruleSimpType= ruleSimpType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpTypeRule()); 
            }
            pushFollow(FOLLOW_ruleSimpType_in_entryRuleSimpType7196);
            iv_ruleSimpType=ruleSimpType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpType.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpType7207); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3462:1: ruleSimpType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'bool' | kw= '_Bool' | kw= 'int' | kw= 'double' | kw= 'void' | kw= 'char' ) ;
    public final AntlrDatatypeRuleToken ruleSimpType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3465:28: ( (kw= 'bool' | kw= '_Bool' | kw= 'int' | kw= 'double' | kw= 'void' | kw= 'char' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3466:1: (kw= 'bool' | kw= '_Bool' | kw= 'int' | kw= 'double' | kw= 'void' | kw= 'char' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3466:1: (kw= 'bool' | kw= '_Bool' | kw= 'int' | kw= 'double' | kw= 'void' | kw= 'char' )
            int alt60=6;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt60=1;
                }
                break;
            case 51:
                {
                alt60=2;
                }
                break;
            case 52:
                {
                alt60=3;
                }
                break;
            case 53:
                {
                alt60=4;
                }
                break;
            case 54:
                {
                alt60=5;
                }
                break;
            case 55:
                {
                alt60=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3467:2: kw= 'bool'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleSimpType7245); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpTypeAccess().getBoolKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3474:2: kw= '_Bool'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleSimpType7264); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpTypeAccess().get_BoolKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3481:2: kw= 'int'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleSimpType7283); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpTypeAccess().getIntKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3488:2: kw= 'double'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleSimpType7302); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpTypeAccess().getDoubleKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3495:2: kw= 'void'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleSimpType7321); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpTypeAccess().getVoidKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3502:2: kw= 'char'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleSimpType7340); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3515:1: entryRuleSigned returns [String current=null] : iv_ruleSigned= ruleSigned EOF ;
    public final String entryRuleSigned() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSigned = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3516:2: (iv_ruleSigned= ruleSigned EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3517:2: iv_ruleSigned= ruleSigned EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedRule()); 
            }
            pushFollow(FOLLOW_ruleSigned_in_entryRuleSigned7381);
            iv_ruleSigned=ruleSigned();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSigned.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSigned7392); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3524:1: ruleSigned returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'signed' | kw= 'unsigned' ) ;
    public final AntlrDatatypeRuleToken ruleSigned() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3527:28: ( (kw= 'signed' | kw= 'unsigned' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3528:1: (kw= 'signed' | kw= 'unsigned' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3528:1: (kw= 'signed' | kw= 'unsigned' )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==56) ) {
                alt61=1;
            }
            else if ( (LA61_0==57) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3529:2: kw= 'signed'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleSigned7430); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedAccess().getSignedKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3536:2: kw= 'unsigned'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleSigned7449); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3549:1: entryRuleSimpleStmtKeyword returns [String current=null] : iv_ruleSimpleStmtKeyword= ruleSimpleStmtKeyword EOF ;
    public final String entryRuleSimpleStmtKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSimpleStmtKeyword = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3550:2: (iv_ruleSimpleStmtKeyword= ruleSimpleStmtKeyword EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3551:2: iv_ruleSimpleStmtKeyword= ruleSimpleStmtKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleStmtKeywordRule()); 
            }
            pushFollow(FOLLOW_ruleSimpleStmtKeyword_in_entryRuleSimpleStmtKeyword7490);
            iv_ruleSimpleStmtKeyword=ruleSimpleStmtKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleStmtKeyword.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleStmtKeyword7501); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3558:1: ruleSimpleStmtKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'break' | kw= 'continue' | kw= 'return' ) ;
    public final AntlrDatatypeRuleToken ruleSimpleStmtKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3561:28: ( (kw= 'break' | kw= 'continue' | kw= 'return' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3562:1: (kw= 'break' | kw= 'continue' | kw= 'return' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3562:1: (kw= 'break' | kw= 'continue' | kw= 'return' )
            int alt62=3;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt62=1;
                }
                break;
            case 59:
                {
                alt62=2;
                }
                break;
            case 36:
                {
                alt62=3;
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3563:2: kw= 'break'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleSimpleStmtKeyword7539); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpleStmtKeywordAccess().getBreakKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3570:2: kw= 'continue'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleSimpleStmtKeyword7558); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpleStmtKeywordAccess().getContinueKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3577:2: kw= 'return'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleSimpleStmtKeyword7577); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3590:1: entryRuleForAllFunction returns [String current=null] : iv_ruleForAllFunction= ruleForAllFunction EOF ;
    public final String entryRuleForAllFunction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleForAllFunction = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3591:2: (iv_ruleForAllFunction= ruleForAllFunction EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3592:2: iv_ruleForAllFunction= ruleForAllFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForAllFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleForAllFunction_in_entryRuleForAllFunction7618);
            iv_ruleForAllFunction=ruleForAllFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForAllFunction.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleForAllFunction7629); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3599:1: ruleForAllFunction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'forall_node' | kw= 'FORALL_NODE' | kw= 'forall_other' | kw= 'FORALL_OTHER' | kw= 'forall_other_lower' | kw= 'FORALL_OTHER_LOWER' | kw= 'forall_other_higher' | kw= 'FORALL_OTHER_HIGHER' ) ;
    public final AntlrDatatypeRuleToken ruleForAllFunction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3602:28: ( (kw= 'forall_node' | kw= 'FORALL_NODE' | kw= 'forall_other' | kw= 'FORALL_OTHER' | kw= 'forall_other_lower' | kw= 'FORALL_OTHER_LOWER' | kw= 'forall_other_higher' | kw= 'FORALL_OTHER_HIGHER' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3603:1: (kw= 'forall_node' | kw= 'FORALL_NODE' | kw= 'forall_other' | kw= 'FORALL_OTHER' | kw= 'forall_other_lower' | kw= 'FORALL_OTHER_LOWER' | kw= 'forall_other_higher' | kw= 'FORALL_OTHER_HIGHER' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3603:1: (kw= 'forall_node' | kw= 'FORALL_NODE' | kw= 'forall_other' | kw= 'FORALL_OTHER' | kw= 'forall_other_lower' | kw= 'FORALL_OTHER_LOWER' | kw= 'forall_other_higher' | kw= 'FORALL_OTHER_HIGHER' )
            int alt63=8;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt63=1;
                }
                break;
            case 61:
                {
                alt63=2;
                }
                break;
            case 62:
                {
                alt63=3;
                }
                break;
            case 63:
                {
                alt63=4;
                }
                break;
            case 64:
                {
                alt63=5;
                }
                break;
            case 65:
                {
                alt63=6;
                }
                break;
            case 66:
                {
                alt63=7;
                }
                break;
            case 67:
                {
                alt63=8;
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3604:2: kw= 'forall_node'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleForAllFunction7667); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getForAllFunctionAccess().getForall_nodeKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3611:2: kw= 'FORALL_NODE'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleForAllFunction7686); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getForAllFunctionAccess().getFORALL_NODEKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3618:2: kw= 'forall_other'
                    {
                    kw=(Token)match(input,62,FOLLOW_62_in_ruleForAllFunction7705); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getForAllFunctionAccess().getForall_otherKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3625:2: kw= 'FORALL_OTHER'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleForAllFunction7724); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getForAllFunctionAccess().getFORALL_OTHERKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3632:2: kw= 'forall_other_lower'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleForAllFunction7743); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getForAllFunctionAccess().getForall_other_lowerKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3639:2: kw= 'FORALL_OTHER_LOWER'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleForAllFunction7762); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getForAllFunctionAccess().getFORALL_OTHER_LOWERKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3646:2: kw= 'forall_other_higher'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleForAllFunction7781); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getForAllFunctionAccess().getForall_other_higherKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3653:2: kw= 'FORALL_OTHER_HIGHER'
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleForAllFunction7800); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3666:1: entryRuleBuiltInFunction returns [String current=null] : iv_ruleBuiltInFunction= ruleBuiltInFunction EOF ;
    public final String entryRuleBuiltInFunction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBuiltInFunction = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3667:2: (iv_ruleBuiltInFunction= ruleBuiltInFunction EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3668:2: iv_ruleBuiltInFunction= ruleBuiltInFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBuiltInFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleBuiltInFunction_in_entryRuleBuiltInFunction7841);
            iv_ruleBuiltInFunction=ruleBuiltInFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBuiltInFunction.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBuiltInFunction7852); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3675:1: ruleBuiltInFunction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'exists_other' | kw= 'EXISTS_OTHER' | kw= 'exists_higher' | kw= 'EXISTS_HIGHER' | kw= 'exists_lower' | kw= 'EXISTS_LOWER' ) ;
    public final AntlrDatatypeRuleToken ruleBuiltInFunction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3678:28: ( (kw= 'exists_other' | kw= 'EXISTS_OTHER' | kw= 'exists_higher' | kw= 'EXISTS_HIGHER' | kw= 'exists_lower' | kw= 'EXISTS_LOWER' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3679:1: (kw= 'exists_other' | kw= 'EXISTS_OTHER' | kw= 'exists_higher' | kw= 'EXISTS_HIGHER' | kw= 'exists_lower' | kw= 'EXISTS_LOWER' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3679:1: (kw= 'exists_other' | kw= 'EXISTS_OTHER' | kw= 'exists_higher' | kw= 'EXISTS_HIGHER' | kw= 'exists_lower' | kw= 'EXISTS_LOWER' )
            int alt64=6;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt64=1;
                }
                break;
            case 69:
                {
                alt64=2;
                }
                break;
            case 70:
                {
                alt64=3;
                }
                break;
            case 71:
                {
                alt64=4;
                }
                break;
            case 72:
                {
                alt64=5;
                }
                break;
            case 73:
                {
                alt64=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3680:2: kw= 'exists_other'
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleBuiltInFunction7890); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFunctionAccess().getExists_otherKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3687:2: kw= 'EXISTS_OTHER'
                    {
                    kw=(Token)match(input,69,FOLLOW_69_in_ruleBuiltInFunction7909); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFunctionAccess().getEXISTS_OTHERKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3694:2: kw= 'exists_higher'
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleBuiltInFunction7928); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFunctionAccess().getExists_higherKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3701:2: kw= 'EXISTS_HIGHER'
                    {
                    kw=(Token)match(input,71,FOLLOW_71_in_ruleBuiltInFunction7947); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFunctionAccess().getEXISTS_HIGHERKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3708:2: kw= 'exists_lower'
                    {
                    kw=(Token)match(input,72,FOLLOW_72_in_ruleBuiltInFunction7966); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFunctionAccess().getExists_lowerKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3715:2: kw= 'EXISTS_LOWER'
                    {
                    kw=(Token)match(input,73,FOLLOW_73_in_ruleBuiltInFunction7985); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3728:1: entryRuleDouble returns [String current=null] : iv_ruleDouble= ruleDouble EOF ;
    public final String entryRuleDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3729:2: (iv_ruleDouble= ruleDouble EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3730:2: iv_ruleDouble= ruleDouble EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDoubleRule()); 
            }
            pushFollow(FOLLOW_ruleDouble_in_entryRuleDouble8026);
            iv_ruleDouble=ruleDouble();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDouble.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDouble8037); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3737:1: ruleDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'NAN' | (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? ) ) ;
    public final AntlrDatatypeRuleToken ruleDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3740:28: ( (kw= 'NAN' | (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3741:1: (kw= 'NAN' | (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3741:1: (kw= 'NAN' | (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==74) ) {
                alt66=1;
            }
            else if ( (LA66_0==RULE_INT) ) {
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3742:2: kw= 'NAN'
                    {
                    kw=(Token)match(input,74,FOLLOW_74_in_ruleDouble8075); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDoubleAccess().getNANKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3748:6: (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3748:6: (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3748:11: this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )?
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDouble8097); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_1, grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_0()); 
                          
                    }
                    kw=(Token)match(input,75,FOLLOW_75_in_ruleDouble8115); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDoubleAccess().getFullStopKeyword_1_1()); 
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3761:1: (this_INT_3= RULE_INT )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==RULE_INT) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3761:6: this_INT_3= RULE_INT
                            {
                            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDouble8131); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3786:1: ruleEqualityOperator returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) ;
    public final Enumerator ruleEqualityOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3788:28: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3789:1: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3789:1: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==76) ) {
                alt67=1;
            }
            else if ( (LA67_0==77) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3789:2: (enumLiteral_0= '==' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3789:2: (enumLiteral_0= '==' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3789:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,76,FOLLOW_76_in_ruleEqualityOperator8203); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getEqualityOperatorAccess().getEQUALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getEqualityOperatorAccess().getEQUALEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3795:6: (enumLiteral_1= '!=' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3795:6: (enumLiteral_1= '!=' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3795:8: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,77,FOLLOW_77_in_ruleEqualityOperator8220); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3805:1: ruleCompareOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) ) ;
    public final Enumerator ruleCompareOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3807:28: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3808:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3808:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) )
            int alt68=4;
            switch ( input.LA(1) ) {
            case 78:
                {
                alt68=1;
                }
                break;
            case 79:
                {
                alt68=2;
                }
                break;
            case 80:
                {
                alt68=3;
                }
                break;
            case 81:
                {
                alt68=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3808:2: (enumLiteral_0= '<' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3808:2: (enumLiteral_0= '<' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3808:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,78,FOLLOW_78_in_ruleCompareOperator8265); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCompareOperatorAccess().getLESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getCompareOperatorAccess().getLESSEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3814:6: (enumLiteral_1= '<=' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3814:6: (enumLiteral_1= '<=' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3814:8: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,79,FOLLOW_79_in_ruleCompareOperator8282); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCompareOperatorAccess().getLESS_EQUALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getCompareOperatorAccess().getLESS_EQUALEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3820:6: (enumLiteral_2= '>' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3820:6: (enumLiteral_2= '>' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3820:8: enumLiteral_2= '>'
                    {
                    enumLiteral_2=(Token)match(input,80,FOLLOW_80_in_ruleCompareOperator8299); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCompareOperatorAccess().getGREATEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getCompareOperatorAccess().getGREATEREnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3826:6: (enumLiteral_3= '>=' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3826:6: (enumLiteral_3= '>=' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3826:8: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,81,FOLLOW_81_in_ruleCompareOperator8316); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3836:1: ruleShiftOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) ) ;
    public final Enumerator ruleShiftOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3838:28: ( ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3839:1: ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3839:1: ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==82) ) {
                alt69=1;
            }
            else if ( (LA69_0==83) ) {
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3839:2: (enumLiteral_0= '<<' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3839:2: (enumLiteral_0= '<<' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3839:4: enumLiteral_0= '<<'
                    {
                    enumLiteral_0=(Token)match(input,82,FOLLOW_82_in_ruleShiftOperator8361); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getShiftOperatorAccess().getLEFTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getShiftOperatorAccess().getLEFTEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3845:6: (enumLiteral_1= '>>' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3845:6: (enumLiteral_1= '>>' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3845:8: enumLiteral_1= '>>'
                    {
                    enumLiteral_1=(Token)match(input,83,FOLLOW_83_in_ruleShiftOperator8378); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3855:1: ruleAdditiveOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3857:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3858:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3858:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==48) ) {
                alt70=1;
            }
            else if ( (LA70_0==49) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3858:2: (enumLiteral_0= '+' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3858:2: (enumLiteral_0= '+' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3858:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,48,FOLLOW_48_in_ruleAdditiveOperator8423); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAdditiveOperatorAccess().getADDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOperatorAccess().getADDEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3864:6: (enumLiteral_1= '-' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3864:6: (enumLiteral_1= '-' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3864:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,49,FOLLOW_49_in_ruleAdditiveOperator8440); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3874:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3876:28: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3877:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3877:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt71=3;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt71=1;
                }
                break;
            case 85:
                {
                alt71=2;
                }
                break;
            case 86:
                {
                alt71=3;
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3877:2: (enumLiteral_0= '*' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3877:2: (enumLiteral_0= '*' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3877:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,84,FOLLOW_84_in_ruleMultiplicativeOperator8485); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMultiplicativeOperatorAccess().getMULTIPLYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOperatorAccess().getMULTIPLYEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3883:6: (enumLiteral_1= '/' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3883:6: (enumLiteral_1= '/' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3883:8: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,85,FOLLOW_85_in_ruleMultiplicativeOperator8502); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMultiplicativeOperatorAccess().getDIVIDEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOperatorAccess().getDIVIDEEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3889:6: (enumLiteral_2= '%' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3889:6: (enumLiteral_2= '%' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3889:8: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,86,FOLLOW_86_in_ruleMultiplicativeOperator8519); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3899:1: ruleUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= '-' ) | (enumLiteral_1= '+' ) | (enumLiteral_2= '!' ) | (enumLiteral_3= '~' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3901:28: ( ( (enumLiteral_0= '-' ) | (enumLiteral_1= '+' ) | (enumLiteral_2= '!' ) | (enumLiteral_3= '~' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3902:1: ( (enumLiteral_0= '-' ) | (enumLiteral_1= '+' ) | (enumLiteral_2= '!' ) | (enumLiteral_3= '~' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3902:1: ( (enumLiteral_0= '-' ) | (enumLiteral_1= '+' ) | (enumLiteral_2= '!' ) | (enumLiteral_3= '~' ) )
            int alt72=4;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt72=1;
                }
                break;
            case 48:
                {
                alt72=2;
                }
                break;
            case 87:
                {
                alt72=3;
                }
                break;
            case 18:
                {
                alt72=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3902:2: (enumLiteral_0= '-' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3902:2: (enumLiteral_0= '-' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3902:4: enumLiteral_0= '-'
                    {
                    enumLiteral_0=(Token)match(input,49,FOLLOW_49_in_ruleUnaryOperator8564); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getMINUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getMINUSEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3908:6: (enumLiteral_1= '+' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3908:6: (enumLiteral_1= '+' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3908:8: enumLiteral_1= '+'
                    {
                    enumLiteral_1=(Token)match(input,48,FOLLOW_48_in_ruleUnaryOperator8581); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getPLUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getUnaryOperatorAccess().getPLUSEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3914:6: (enumLiteral_2= '!' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3914:6: (enumLiteral_2= '!' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3914:8: enumLiteral_2= '!'
                    {
                    enumLiteral_2=(Token)match(input,87,FOLLOW_87_in_ruleUnaryOperator8598); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getLOGICAL_NOTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getUnaryOperatorAccess().getLOGICAL_NOTEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3920:6: (enumLiteral_3= '~' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3920:6: (enumLiteral_3= '~' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:3920:8: enumLiteral_3= '~'
                    {
                    enumLiteral_3=(Token)match(input,18,FOLLOW_18_in_ruleUnaryOperator8615); if (state.failed) return current;
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
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1869:4: ( 'else' )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1869:6: 'else'
        {
        match(input,35,FOLLOW_35_in_synpred1_InternalDmpl3788); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalDmpl

    // $ANTLR start synpred2_InternalDmpl
    public final void synpred2_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2297:3: ( ( () '?' ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2297:4: ( () '?' )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2297:4: ( () '?' )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2297:5: () '?'
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2297:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2298:1: 
        {
        }

        match(input,39,FOLLOW_39_in_synpred2_InternalDmpl4640); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalDmpl

    // $ANTLR start synpred3_InternalDmpl
    public final void synpred3_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2379:3: ( ( () '||' ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2379:4: ( () '||' )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2379:4: ( () '||' )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2379:5: () '||'
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2379:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2380:1: 
        {
        }

        match(input,41,FOLLOW_41_in_synpred3_InternalDmpl4826); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalDmpl

    // $ANTLR start synpred4_InternalDmpl
    public final void synpred4_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2439:3: ( ( () '&&' ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2439:4: ( () '&&' )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2439:4: ( () '&&' )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2439:5: () '&&'
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2439:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2440:1: 
        {
        }

        match(input,42,FOLLOW_42_in_synpred4_InternalDmpl4979); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalDmpl

    // $ANTLR start synpred5_InternalDmpl
    public final void synpred5_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2499:3: ( ( () '|' ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2499:4: ( () '|' )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2499:4: ( () '|' )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2499:5: () '|'
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2499:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2500:1: 
        {
        }

        match(input,43,FOLLOW_43_in_synpred5_InternalDmpl5132); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalDmpl

    // $ANTLR start synpred6_InternalDmpl
    public final void synpred6_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2559:3: ( ( () '^' ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2559:4: ( () '^' )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2559:4: ( () '^' )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2559:5: () '^'
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2559:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2560:1: 
        {
        }

        match(input,44,FOLLOW_44_in_synpred6_InternalDmpl5285); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalDmpl

    // $ANTLR start synpred7_InternalDmpl
    public final void synpred7_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2619:3: ( ( () '&' ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2619:4: ( () '&' )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2619:4: ( () '&' )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2619:5: () '&'
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2619:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2620:1: 
        {
        }

        match(input,45,FOLLOW_45_in_synpred7_InternalDmpl5438); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalDmpl

    // $ANTLR start synpred8_InternalDmpl
    public final void synpred8_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2679:3: ( ( () ( ( ruleEqualityOperator ) ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2679:4: ( () ( ( ruleEqualityOperator ) ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2679:4: ( () ( ( ruleEqualityOperator ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2679:5: () ( ( ruleEqualityOperator ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2679:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2680:1: 
        {
        }

        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2680:2: ( ( ruleEqualityOperator ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2681:1: ( ruleEqualityOperator )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2681:1: ( ruleEqualityOperator )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2682:1: ruleEqualityOperator
        {
        pushFollow(FOLLOW_ruleEqualityOperator_in_synpred8_InternalDmpl5594);
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
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2756:3: ( ( () ( ( ruleCompareOperator ) ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2756:4: ( () ( ( ruleCompareOperator ) ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2756:4: ( () ( ( ruleCompareOperator ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2756:5: () ( ( ruleCompareOperator ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2756:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2757:1: 
        {
        }

        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2757:2: ( ( ruleCompareOperator ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2758:1: ( ruleCompareOperator )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2758:1: ( ruleCompareOperator )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2759:1: ruleCompareOperator
        {
        pushFollow(FOLLOW_ruleCompareOperator_in_synpred9_InternalDmpl5761);
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
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2833:3: ( ( () ( ( ruleShiftOperator ) ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2833:4: ( () ( ( ruleShiftOperator ) ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2833:4: ( () ( ( ruleShiftOperator ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2833:5: () ( ( ruleShiftOperator ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2833:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2834:1: 
        {
        }

        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2834:2: ( ( ruleShiftOperator ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2835:1: ( ruleShiftOperator )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2835:1: ( ruleShiftOperator )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2836:1: ruleShiftOperator
        {
        pushFollow(FOLLOW_ruleShiftOperator_in_synpred10_InternalDmpl5928);
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
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2910:3: ( ( () ( ( ruleAdditiveOperator ) ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2910:4: ( () ( ( ruleAdditiveOperator ) ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2910:4: ( () ( ( ruleAdditiveOperator ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2910:5: () ( ( ruleAdditiveOperator ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2910:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2911:1: 
        {
        }

        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2911:2: ( ( ruleAdditiveOperator ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2912:1: ( ruleAdditiveOperator )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2912:1: ( ruleAdditiveOperator )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2913:1: ruleAdditiveOperator
        {
        pushFollow(FOLLOW_ruleAdditiveOperator_in_synpred11_InternalDmpl6095);
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
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2987:3: ( ( () ( ( ruleMultiplicativeOperator ) ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2987:4: ( () ( ( ruleMultiplicativeOperator ) ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2987:4: ( () ( ( ruleMultiplicativeOperator ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2987:5: () ( ( ruleMultiplicativeOperator ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2987:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2988:1: 
        {
        }

        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2988:2: ( ( ruleMultiplicativeOperator ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2989:1: ( ruleMultiplicativeOperator )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2989:1: ( ruleMultiplicativeOperator )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2990:1: ruleMultiplicativeOperator
        {
        pushFollow(FOLLOW_ruleMultiplicativeOperator_in_synpred12_InternalDmpl6262);
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
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA54 dfa54 = new DFA54(this);
    static final String DFA11_eotS =
        "\23\uffff";
    static final String DFA11_eofS =
        "\2\uffff\2\6\15\uffff\2\6";
    static final String DFA11_minS =
        "\2\4\1\16\1\17\2\4\1\uffff\2\4\3\24\2\uffff\3\24\1\16\1\17";
    static final String DFA11_maxS =
        "\1\21\1\4\2\23\1\25\1\127\1\uffff\1\25\1\127\3\24\2\uffff\3\24\2\23";
    static final String DFA11_acceptS =
        "\6\uffff\1\1\5\uffff\1\2\1\3\5\uffff";
    static final String DFA11_specialS =
        "\23\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\2\14\uffff\1\1",
            "\1\3",
            "\1\5\2\6\2\uffff\1\4",
            "\2\6\1\uffff\1\10\1\7",
            "\1\13\1\11\17\uffff\1\12",
            "\2\14\14\uffff\1\14\2\uffff\1\14\1\15\6\uffff\1\14\20\uffff\1\14\1\uffff\2\14\22\uffff\7\14\14\uffff\1\14",
            "",
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
            "\1\5\2\6\2\uffff\1\4",
            "\2\6\1\uffff\1\10\1\7"
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
    static final String DFA40_eotS =
        "\15\uffff";
    static final String DFA40_eofS =
        "\15\uffff";
    static final String DFA40_minS =
        "\1\4\1\uffff\1\16\4\uffff\1\4\5\uffff";
    static final String DFA40_maxS =
        "\1\103\1\uffff\1\57\4\uffff\1\127\5\uffff";
    static final String DFA40_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\4\1\5\1\6\1\uffff\1\11\1\12\1\10\1\2\1\7";
    static final String DFA40_specialS =
        "\15\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\2\21\uffff\1\1\10\uffff\1\5\1\3\1\4\1\5\1\uffff\1\7\2\11\23\uffff\2\6\10\10",
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

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "1574:1: ( ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' ) | (this_AssignmentStmt_4= ruleAssignmentStmt otherlv_5= ';' ) | ( () otherlv_7= 'while' otherlv_8= '(' ( (lv_condition_9_0= ruleExpr ) ) otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) ) | ( () otherlv_13= 'for' otherlv_14= '(' ( ( (lv_inits_15_0= ruleAssignmentStmt ) ) (otherlv_16= ',' ( (lv_inits_17_0= ruleAssignmentStmt ) ) )* )? otherlv_18= ';' ( (lv_condition_19_0= ruleExpr ) )? otherlv_20= ';' ( (lv_update_21_0= ruleAssignmentStmt ) )? otherlv_22= ')' ( (lv_stmt_23_0= ruleStmt ) ) ) | ( () ( (lv_attrList_25_0= ruleAttrList ) )? otherlv_26= 'if' otherlv_27= '(' ( (lv_condition_28_0= ruleExpr ) ) otherlv_29= ')' ( (lv_then_30_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_31= 'else' ) ( (lv_else_32_0= ruleStmt ) ) )? ) | ( () ( (lv_name_34_0= ruleSimpleStmtKeyword ) ) otherlv_35= ';' ) | ( () otherlv_37= 'return' ( (lv_value_38_0= ruleExpr ) ) otherlv_39= ';' ) | (this_CallExpr_40= ruleCallExpr otherlv_41= ';' ) | ( () ( (lv_name_43_0= ruleForAllFunction ) ) otherlv_44= '(' ( (lv_node_45_0= RULE_TIDENTIFIER ) ) otherlv_46= ')' ( (lv_stmt_47_0= ruleStmt ) ) ) | ( () (otherlv_49= 'forall_distinct_node_pair' | otherlv_50= 'FORALL_DISTINCT_NODE_PAIR' ) otherlv_51= '(' ( (lv_node1_52_0= RULE_TIDENTIFIER ) ) otherlv_53= ',' ( (lv_node2_54_0= RULE_TIDENTIFIER ) ) otherlv_55= ')' ( (lv_stmt_56_0= ruleStmt ) ) ) )";
        }
    }
    static final String DFA54_eotS =
        "\14\uffff";
    static final String DFA54_eofS =
        "\1\uffff\1\12\1\uffff\1\13\10\uffff";
    static final String DFA54_minS =
        "\1\4\1\16\1\uffff\1\16\10\uffff";
    static final String DFA54_maxS =
        "\1\127\1\126\1\uffff\1\126\10\uffff";
    static final String DFA54_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\5\1\6\1\7\1\11\1\10\1\1\1\3";
    static final String DFA54_specialS =
        "\14\uffff}>";
    static final String[] DFA54_transitionS = {
            "\1\1\1\3\14\uffff\1\6\2\uffff\1\5\7\uffff\1\10\20\uffff\1\2\1\uffff\2\6\22\uffff\6\7\1\4\14\uffff\1\6",
            "\3\12\2\uffff\2\12\10\uffff\1\11\2\12\7\uffff\7\12\1\uffff\1\11\2\12\32\uffff\13\12",
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

    static final short[] DFA54_eot = DFA.unpackEncodedString(DFA54_eotS);
    static final short[] DFA54_eof = DFA.unpackEncodedString(DFA54_eofS);
    static final char[] DFA54_min = DFA.unpackEncodedStringToUnsignedChars(DFA54_minS);
    static final char[] DFA54_max = DFA.unpackEncodedStringToUnsignedChars(DFA54_maxS);
    static final short[] DFA54_accept = DFA.unpackEncodedString(DFA54_acceptS);
    static final short[] DFA54_special = DFA.unpackEncodedString(DFA54_specialS);
    static final short[][] DFA54_transition;

    static {
        int numStates = DFA54_transitionS.length;
        DFA54_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA54_transition[i] = DFA.unpackEncodedString(DFA54_transitionS[i]);
        }
    }

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = DFA54_eot;
            this.eof = DFA54_eof;
            this.min = DFA54_min;
            this.max = DFA54_max;
            this.accept = DFA54_accept;
            this.special = DFA54_special;
            this.transition = DFA54_transition;
        }
        public String getDescription() {
            return "3055:1: (this_LVal_0= ruleLVal | ( () otherlv_2= 'id' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= ruleDouble ) ) ) | ( () otherlv_8= '#N' ) | ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) ) | ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' ) | this_CallExpr_19= ruleCallExpr | (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' ) )";
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
    public static final BitSet FOLLOW_22_in_ruleFnBody2192 = new BitSet(new long[]{0xFFFC00779FC23010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleVarInit_in_ruleFnBody2214 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFnBody2226 = new BitSet(new long[]{0xFFFC00779FC23010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleFnBody2249 = new BitSet(new long[]{0xFC00007780C00010L,0x000000000000000FL});
    public static final BitSet FOLLOW_23_in_ruleFnBody2262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnPrototype_in_entryRuleFnPrototype2298 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFnPrototype2308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleFnPrototype2363 = new BitSet(new long[]{0x000000001C000000L});
    public static final BitSet FOLLOW_25_in_ruleFnPrototype2392 = new BitSet(new long[]{0x000000001C000000L});
    public static final BitSet FOLLOW_26_in_ruleFnPrototype2429 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_27_in_ruleFnPrototype2458 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleFnPrototype2487 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleFnPrototype2504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleFnPrototype2546 = new BitSet(new long[]{0x03FC00001F003010L});
    public static final BitSet FOLLOW_25_in_ruleFnPrototype2575 = new BitSet(new long[]{0x03FC00001F003010L});
    public static final BitSet FOLLOW_26_in_ruleFnPrototype2612 = new BitSet(new long[]{0x03FC00001F003010L});
    public static final BitSet FOLLOW_27_in_ruleFnPrototype2641 = new BitSet(new long[]{0x03FC00001F003010L});
    public static final BitSet FOLLOW_ruleType_in_ruleFnPrototype2679 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleFnPrototype2696 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleFnPrototype2713 = new BitSet(new long[]{0x03FC00005F023010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleFnPrototype2735 = new BitSet(new long[]{0x0000000040010000L});
    public static final BitSet FOLLOW_16_in_ruleFnPrototype2748 = new BitSet(new long[]{0x03FC00001F023010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleFnPrototype2769 = new BitSet(new long[]{0x0000000040010000L});
    public static final BitSet FOLLOW_30_in_ruleFnPrototype2785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrList_in_entryRuleAttrList2822 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttrList2832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttr_in_ruleAttrList2878 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAttrList2890 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_ruleAttr_in_entryRuleAttr2927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttr2937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAttr2974 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleAttr2991 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleAttr3009 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAttr3030 = new BitSet(new long[]{0x0000000040010000L});
    public static final BitSet FOLLOW_16_in_ruleAttr3043 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAttr3064 = new BitSet(new long[]{0x0000000040010000L});
    public static final BitSet FOLLOW_30_in_ruleAttr3078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParam_in_entryRuleParam3116 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParam3126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleParam3172 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleVar_in_ruleParam3193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmt_in_entryRuleStmt3229 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStmt3239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleStmt3286 = new BitSet(new long[]{0xFC00007780C00010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleStmt3307 = new BitSet(new long[]{0xFC00007780C00010L,0x000000000000000FL});
    public static final BitSet FOLLOW_23_in_ruleStmt3320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentStmt_in_ruleStmt3350 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStmt3361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleStmt3390 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleStmt3402 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleStmt3423 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleStmt3435 = new BitSet(new long[]{0xFC00007780400010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleStmt3456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleStmt3485 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleStmt3497 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleAssignmentStmt_in_ruleStmt3519 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleStmt3532 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAssignmentStmt_in_ruleStmt3553 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleStmt3569 = new BitSet(new long[]{0x0003400020248030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleStmt3590 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStmt3603 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_ruleAssignmentStmt_in_ruleStmt3624 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleStmt3637 = new BitSet(new long[]{0xFC00007780400010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleStmt3658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttrList_in_ruleStmt3696 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleStmt3709 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleStmt3721 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleStmt3742 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleStmt3754 = new BitSet(new long[]{0xFC00007780400010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleStmt3775 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleStmt3796 = new BitSet(new long[]{0xFC00007780400010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleStmt3818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleStmtKeyword_in_ruleStmt3858 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStmt3870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleStmt3899 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleStmt3920 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStmt3932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExpr_in_ruleStmt3962 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStmt3973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForAllFunction_in_ruleStmt4011 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleStmt4023 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleStmt4040 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleStmt4057 = new BitSet(new long[]{0xFC00007780400010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleStmt4078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleStmt4108 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_38_in_ruleStmt4126 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleStmt4139 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleStmt4156 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleStmt4173 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleStmt4190 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleStmt4207 = new BitSet(new long[]{0xFC00007780400010L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleStmt4228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentStmt_in_entryRuleAssignmentStmt4265 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentStmt4275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLVal_in_ruleAssignmentStmt4321 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAssignmentStmt4333 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAssignmentStmt4354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLVal_in_entryRuleLVal4390 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLVal4400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleLVal4442 = new BitSet(new long[]{0x0000000080080002L});
    public static final BitSet FOLLOW_19_in_ruleLVal4460 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleLVal4481 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleLVal4493 = new BitSet(new long[]{0x0000000080080002L});
    public static final BitSet FOLLOW_31_in_ruleLVal4508 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleLVal4529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_entryRuleExpr4567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpr4577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpr_in_ruleExpr4624 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleExpr4659 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleExpr4682 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleExpr4694 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleExpr4715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpr_in_entryRuleOrExpr4753 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrExpr4763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpr_in_ruleOrExpr4810 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleOrExpr4845 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleAndExpr_in_ruleOrExpr4868 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleAndExpr_in_entryRuleAndExpr4906 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpr4916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpr_in_ruleAndExpr4963 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleAndExpr4998 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpr_in_ruleAndExpr5021 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleBitwiseOrExpr_in_entryRuleBitwiseOrExpr5059 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseOrExpr5069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXorExpr_in_ruleBitwiseOrExpr5116 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleBitwiseOrExpr5151 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleXorExpr_in_ruleBitwiseOrExpr5174 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleXorExpr_in_entryRuleXorExpr5212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXorExpr5222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpr_in_ruleXorExpr5269 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_ruleXorExpr5304 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpr_in_ruleXorExpr5327 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_ruleBitwiseAndExpr_in_entryRuleBitwiseAndExpr5365 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitwiseAndExpr5375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpr_in_ruleBitwiseAndExpr5422 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleBitwiseAndExpr5457 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleEqualityExpr_in_ruleBitwiseAndExpr5480 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpr_in_entryRuleEqualityExpr5518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpr5528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompareExpr_in_ruleEqualityExpr5575 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpr5624 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleCompareExpr_in_ruleEqualityExpr5647 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_ruleCompareExpr_in_entryRuleCompareExpr5685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompareExpr5695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpr_in_ruleCompareExpr5742 = new BitSet(new long[]{0x0000000000000002L,0x000000000003C000L});
    public static final BitSet FOLLOW_ruleCompareOperator_in_ruleCompareExpr5791 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleShiftExpr_in_ruleCompareExpr5814 = new BitSet(new long[]{0x0000000000000002L,0x000000000003C000L});
    public static final BitSet FOLLOW_ruleShiftExpr_in_entryRuleShiftExpr5852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShiftExpr5862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpr_in_ruleShiftExpr5909 = new BitSet(new long[]{0x0000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_ruleShiftOperator_in_ruleShiftExpr5958 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpr_in_ruleShiftExpr5981 = new BitSet(new long[]{0x0000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_ruleAdditiveExpr_in_entryRuleAdditiveExpr6019 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpr6029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpr_in_ruleAdditiveExpr6076 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpr6125 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpr_in_ruleAdditiveExpr6148 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpr_in_entryRuleMultiplicativeExpr6186 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpr6196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpr_in_ruleMultiplicativeExpr6243 = new BitSet(new long[]{0x0000000000000002L,0x0000000000700000L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpr6292 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleTerminalExpr_in_ruleMultiplicativeExpr6315 = new BitSet(new long[]{0x0000000000000002L,0x0000000000700000L});
    public static final BitSet FOLLOW_ruleTerminalExpr_in_entryRuleTerminalExpr6353 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalExpr6363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLVal_in_ruleTerminalExpr6410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleTerminalExpr6437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTerminalExpr6471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDouble_in_ruleTerminalExpr6514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleTerminalExpr6543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleTerminalExpr6581 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleTerminalExpr6602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltInFunction_in_ruleTerminalExpr6640 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleTerminalExpr6652 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleTerminalExpr6669 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTerminalExpr6686 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleTerminalExpr6707 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTerminalExpr6719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExpr_in_ruleTerminalExpr6748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleTerminalExpr6766 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleTerminalExpr6788 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTerminalExpr6799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExpr_in_entryRuleCallExpr6836 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallExpr6846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleCallExpr6889 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleCallExpr6906 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleCallExpr6925 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleCallExpr6942 = new BitSet(new long[]{0x0003400060240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleCallExpr6964 = new BitSet(new long[]{0x0000000040010000L});
    public static final BitSet FOLLOW_16_in_ruleCallExpr6977 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleCallExpr6998 = new BitSet(new long[]{0x0000000040010000L});
    public static final BitSet FOLLOW_30_in_ruleCallExpr7014 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleCallExpr7027 = new BitSet(new long[]{0x0003400020240030L,0x00000000008007F0L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleCallExpr7048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSign_in_entryRuleSign7087 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSign7098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleSign7136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleSign7155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpType_in_entryRuleSimpType7196 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpType7207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleSimpType7245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleSimpType7264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleSimpType7283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleSimpType7302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleSimpType7321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleSimpType7340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSigned_in_entryRuleSigned7381 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSigned7392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleSigned7430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleSigned7449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleStmtKeyword_in_entryRuleSimpleStmtKeyword7490 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleStmtKeyword7501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleSimpleStmtKeyword7539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleSimpleStmtKeyword7558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleSimpleStmtKeyword7577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForAllFunction_in_entryRuleForAllFunction7618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForAllFunction7629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleForAllFunction7667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleForAllFunction7686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleForAllFunction7705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleForAllFunction7724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleForAllFunction7743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleForAllFunction7762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleForAllFunction7781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleForAllFunction7800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltInFunction_in_entryRuleBuiltInFunction7841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBuiltInFunction7852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleBuiltInFunction7890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleBuiltInFunction7909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleBuiltInFunction7928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleBuiltInFunction7947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleBuiltInFunction7966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleBuiltInFunction7985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDouble_in_entryRuleDouble8026 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDouble8037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleDouble8075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDouble8097 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ruleDouble8115 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDouble8131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleEqualityOperator8203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleEqualityOperator8220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleCompareOperator8265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleCompareOperator8282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleCompareOperator8299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleCompareOperator8316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleShiftOperator8361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleShiftOperator8378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleAdditiveOperator8423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleAdditiveOperator8440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleMultiplicativeOperator8485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleMultiplicativeOperator8502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_ruleMultiplicativeOperator8519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleUnaryOperator8564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleUnaryOperator8581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleUnaryOperator8598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleUnaryOperator8615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred1_InternalDmpl3788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred2_InternalDmpl4640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_synpred3_InternalDmpl4826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred4_InternalDmpl4979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_synpred5_InternalDmpl5132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_synpred6_InternalDmpl5285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_synpred7_InternalDmpl5438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_synpred8_InternalDmpl5594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompareOperator_in_synpred9_InternalDmpl5761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftOperator_in_synpred10_InternalDmpl5928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_synpred11_InternalDmpl6095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_synpred12_InternalDmpl6262 = new BitSet(new long[]{0x0000000000000002L});

}