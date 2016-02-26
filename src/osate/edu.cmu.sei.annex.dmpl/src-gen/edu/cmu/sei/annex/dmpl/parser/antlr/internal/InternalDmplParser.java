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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_TIDENTIFIER", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'const'", "'CONST'", "'='", "';'", "'['", "']'", "'#N'", "'{'", "'}'", "'extern'", "'EXTERN'", "'pure'", "'PURE'", "'thread'", "'('", "','", "')'", "'@'", "'id'", "'::'", "'+'", "'-'", "'bool'", "'_Bool'", "'int'", "'double'", "'void'", "'char'", "'signed'", "'unsigned'", "'exists_other'", "'EXISTS_OTHER'", "'exists_higher'", "'EXISTS_HIGHER'", "'exists_lower'", "'EXISTS_LOWER'", "'NAN'", "'.'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", "'*'", "'/'", "'%'", "'!'", "'~'"
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

                if ( ((LA1_0>=12 && LA1_0<=13)||(LA1_0>=21 && LA1_0<=25)||(LA1_0>=34 && LA1_0<=41)) ) {
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
            else if ( ((LA2_0>=21 && LA2_0<=25)||(LA2_0>=34 && LA2_0<=41)) ) {
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
            case 32:
                {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==48) ) {
                    alt4=2;
                }
                else if ( (LA4_1==RULE_INT) ) {
                    int LA4_3 = input.LA(3);

                    if ( (LA4_3==49) ) {
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
            case 33:
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==RULE_INT) ) {
                    int LA4_3 = input.LA(3);

                    if ( (LA4_3==49) ) {
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
                else if ( (LA4_2==48) ) {
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

                if ( (LA4_3==49) ) {
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
            case 48:
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

            if ( ((LA5_0>=32 && LA5_0<=33)) ) {
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

            if ( ((LA6_0>=32 && LA6_0<=33)) ) {
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:437:1: ruleVarInit returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_varAsgnList_1_0= ruleVarAsgnList ) ) ) ;
    public final EObject ruleVarInit() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        EObject lv_varAsgnList_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:440:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_varAsgnList_1_0= ruleVarAsgnList ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:441:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_varAsgnList_1_0= ruleVarAsgnList ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:441:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_varAsgnList_1_0= ruleVarAsgnList ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:441:2: ( (lv_type_0_0= ruleType ) ) ( (lv_varAsgnList_1_0= ruleVarAsgnList ) )
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

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:459:2: ( (lv_varAsgnList_1_0= ruleVarAsgnList ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:460:1: (lv_varAsgnList_1_0= ruleVarAsgnList )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:460:1: (lv_varAsgnList_1_0= ruleVarAsgnList )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:461:3: lv_varAsgnList_1_0= ruleVarAsgnList
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVarInitAccess().getVarAsgnListVarAsgnListParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVarAsgnList_in_ruleVarInit994);
            lv_varAsgnList_1_0=ruleVarAsgnList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVarInitRule());
              	        }
                     		set(
                     			current, 
                     			"varAsgnList",
                      		lv_varAsgnList_1_0, 
                      		"VarAsgnList");
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
    // $ANTLR end "ruleVarInit"


    // $ANTLR start "entryRuleVarAsgnList"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:485:1: entryRuleVarAsgnList returns [EObject current=null] : iv_ruleVarAsgnList= ruleVarAsgnList EOF ;
    public final EObject entryRuleVarAsgnList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarAsgnList = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:486:2: (iv_ruleVarAsgnList= ruleVarAsgnList EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:487:2: iv_ruleVarAsgnList= ruleVarAsgnList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarAsgnListRule()); 
            }
            pushFollow(FOLLOW_ruleVarAsgnList_in_entryRuleVarAsgnList1030);
            iv_ruleVarAsgnList=ruleVarAsgnList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarAsgnList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarAsgnList1040); if (state.failed) return current;

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
    // $ANTLR end "entryRuleVarAsgnList"


    // $ANTLR start "ruleVarAsgnList"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:494:1: ruleVarAsgnList returns [EObject current=null] : ( ( (lv_var_0_0= ruleVar ) ) | ( (lv_varAsgn_1_0= ruleVarAsgn ) ) ) ;
    public final EObject ruleVarAsgnList() throws RecognitionException {
        EObject current = null;

        EObject lv_var_0_0 = null;

        EObject lv_varAsgn_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:497:28: ( ( ( (lv_var_0_0= ruleVar ) ) | ( (lv_varAsgn_1_0= ruleVarAsgn ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:498:1: ( ( (lv_var_0_0= ruleVar ) ) | ( (lv_varAsgn_1_0= ruleVarAsgn ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:498:1: ( ( (lv_var_0_0= ruleVar ) ) | ( (lv_varAsgn_1_0= ruleVarAsgn ) ) )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:498:2: ( (lv_var_0_0= ruleVar ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:498:2: ( (lv_var_0_0= ruleVar ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:499:1: (lv_var_0_0= ruleVar )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:499:1: (lv_var_0_0= ruleVar )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:500:3: lv_var_0_0= ruleVar
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVarAsgnListAccess().getVarVarParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVar_in_ruleVarAsgnList1086);
                    lv_var_0_0=ruleVar();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVarAsgnListRule());
                      	        }
                             		set(
                             			current, 
                             			"var",
                              		lv_var_0_0, 
                              		"Var");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:517:6: ( (lv_varAsgn_1_0= ruleVarAsgn ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:517:6: ( (lv_varAsgn_1_0= ruleVarAsgn ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:518:1: (lv_varAsgn_1_0= ruleVarAsgn )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:518:1: (lv_varAsgn_1_0= ruleVarAsgn )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:519:3: lv_varAsgn_1_0= ruleVarAsgn
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVarAsgnListAccess().getVarAsgnVarAsgnParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVarAsgn_in_ruleVarAsgnList1113);
                    lv_varAsgn_1_0=ruleVarAsgn();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVarAsgnListRule());
                      	        }
                             		set(
                             			current, 
                             			"varAsgn",
                              		lv_varAsgn_1_0, 
                              		"VarAsgn");
                      	        afterParserOrEnumRuleCall();
                      	    
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
    // $ANTLR end "ruleVarAsgnList"


    // $ANTLR start "entryRuleVarAsgn"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:543:1: entryRuleVarAsgn returns [EObject current=null] : iv_ruleVarAsgn= ruleVarAsgn EOF ;
    public final EObject entryRuleVarAsgn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarAsgn = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:544:2: (iv_ruleVarAsgn= ruleVarAsgn EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:545:2: iv_ruleVarAsgn= ruleVarAsgn EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarAsgnRule()); 
            }
            pushFollow(FOLLOW_ruleVarAsgn_in_entryRuleVarAsgn1149);
            iv_ruleVarAsgn=ruleVarAsgn();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarAsgn; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarAsgn1159); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:552:1: ruleVarAsgn returns [EObject current=null] : ( ( (lv_var_0_0= ruleVar ) ) otherlv_1= '=' ( ( (lv_fnBody_2_0= ruleFnBody ) ) | ( (lv_expr_3_0= ruleExpr ) ) ) ) ;
    public final EObject ruleVarAsgn() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_var_0_0 = null;

        EObject lv_fnBody_2_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:555:28: ( ( ( (lv_var_0_0= ruleVar ) ) otherlv_1= '=' ( ( (lv_fnBody_2_0= ruleFnBody ) ) | ( (lv_expr_3_0= ruleExpr ) ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:556:1: ( ( (lv_var_0_0= ruleVar ) ) otherlv_1= '=' ( ( (lv_fnBody_2_0= ruleFnBody ) ) | ( (lv_expr_3_0= ruleExpr ) ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:556:1: ( ( (lv_var_0_0= ruleVar ) ) otherlv_1= '=' ( ( (lv_fnBody_2_0= ruleFnBody ) ) | ( (lv_expr_3_0= ruleExpr ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:556:2: ( (lv_var_0_0= ruleVar ) ) otherlv_1= '=' ( ( (lv_fnBody_2_0= ruleFnBody ) ) | ( (lv_expr_3_0= ruleExpr ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:556:2: ( (lv_var_0_0= ruleVar ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:557:1: (lv_var_0_0= ruleVar )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:557:1: (lv_var_0_0= ruleVar )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:558:3: lv_var_0_0= ruleVar
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVarAsgnAccess().getVarVarParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVar_in_ruleVarAsgn1205);
            lv_var_0_0=ruleVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVarAsgnRule());
              	        }
                     		set(
                     			current, 
                     			"var",
                      		lv_var_0_0, 
                      		"Var");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleVarAsgn1217); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getVarAsgnAccess().getEqualsSignKeyword_1());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:578:1: ( ( (lv_fnBody_2_0= ruleFnBody ) ) | ( (lv_expr_3_0= ruleExpr ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=RULE_TIDENTIFIER && LA8_0<=RULE_INT)||LA8_0==18||LA8_0==26||LA8_0==30||(LA8_0>=32 && LA8_0<=33)||(LA8_0>=42 && LA8_0<=48)||(LA8_0>=61 && LA8_0<=62)) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:578:2: ( (lv_fnBody_2_0= ruleFnBody ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:578:2: ( (lv_fnBody_2_0= ruleFnBody ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:579:1: (lv_fnBody_2_0= ruleFnBody )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:579:1: (lv_fnBody_2_0= ruleFnBody )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:580:3: lv_fnBody_2_0= ruleFnBody
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVarAsgnAccess().getFnBodyFnBodyParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFnBody_in_ruleVarAsgn1239);
                    lv_fnBody_2_0=ruleFnBody();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVarAsgnRule());
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
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:597:6: ( (lv_expr_3_0= ruleExpr ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:597:6: ( (lv_expr_3_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:598:1: (lv_expr_3_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:598:1: (lv_expr_3_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:599:3: lv_expr_3_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVarAsgnAccess().getExprExprParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleVarAsgn1266);
                    lv_expr_3_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVarAsgnRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_3_0, 
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
    // $ANTLR end "ruleVarAsgn"


    // $ANTLR start "entryRuleVar"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:623:1: entryRuleVar returns [EObject current=null] : iv_ruleVar= ruleVar EOF ;
    public final EObject entryRuleVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVar = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:624:2: (iv_ruleVar= ruleVar EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:625:2: iv_ruleVar= ruleVar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarRule()); 
            }
            pushFollow(FOLLOW_ruleVar_in_entryRuleVar1303);
            iv_ruleVar=ruleVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVar; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVar1313); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:632:1: ruleVar returns [EObject current=null] : ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_dimensions_2_0= ruleDimension ) ) otherlv_3= ']' )* ) ;
    public final EObject ruleVar() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_dimensions_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:635:28: ( ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_dimensions_2_0= ruleDimension ) ) otherlv_3= ']' )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:636:1: ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_dimensions_2_0= ruleDimension ) ) otherlv_3= ']' )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:636:1: ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_dimensions_2_0= ruleDimension ) ) otherlv_3= ']' )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:636:2: ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_dimensions_2_0= ruleDimension ) ) otherlv_3= ']' )*
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:636:2: ( (lv_name_0_0= RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:637:1: (lv_name_0_0= RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:637:1: (lv_name_0_0= RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:638:3: lv_name_0_0= RULE_TIDENTIFIER
            {
            lv_name_0_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleVar1355); if (state.failed) return current;
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

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:654:2: (otherlv_1= '[' ( (lv_dimensions_2_0= ruleDimension ) ) otherlv_3= ']' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==16) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:654:4: otherlv_1= '[' ( (lv_dimensions_2_0= ruleDimension ) ) otherlv_3= ']'
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleVar1373); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getVarAccess().getLeftSquareBracketKeyword_1_0());
            	          
            	    }
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:658:1: ( (lv_dimensions_2_0= ruleDimension ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:659:1: (lv_dimensions_2_0= ruleDimension )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:659:1: (lv_dimensions_2_0= ruleDimension )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:660:3: lv_dimensions_2_0= ruleDimension
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVarAccess().getDimensionsDimensionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDimension_in_ruleVar1394);
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

            	    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleVar1406); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getVarAccess().getRightSquareBracketKeyword_1_2());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:688:1: entryRuleDimension returns [EObject current=null] : iv_ruleDimension= ruleDimension EOF ;
    public final EObject entryRuleDimension() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDimension = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:689:2: (iv_ruleDimension= ruleDimension EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:690:2: iv_ruleDimension= ruleDimension EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDimensionRule()); 
            }
            pushFollow(FOLLOW_ruleDimension_in_entryRuleDimension1444);
            iv_ruleDimension=ruleDimension();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDimension; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDimension1454); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:697:1: ruleDimension returns [EObject current=null] : ( ( () ( (lv_index_1_0= RULE_INT ) ) ) | ( () otherlv_3= '#N' ) | ( () ( (lv_index_5_0= RULE_TIDENTIFIER ) ) ) ) ;
    public final EObject ruleDimension() throws RecognitionException {
        EObject current = null;

        Token lv_index_1_0=null;
        Token otherlv_3=null;
        Token lv_index_5_0=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:700:28: ( ( ( () ( (lv_index_1_0= RULE_INT ) ) ) | ( () otherlv_3= '#N' ) | ( () ( (lv_index_5_0= RULE_TIDENTIFIER ) ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:701:1: ( ( () ( (lv_index_1_0= RULE_INT ) ) ) | ( () otherlv_3= '#N' ) | ( () ( (lv_index_5_0= RULE_TIDENTIFIER ) ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:701:1: ( ( () ( (lv_index_1_0= RULE_INT ) ) ) | ( () otherlv_3= '#N' ) | ( () ( (lv_index_5_0= RULE_TIDENTIFIER ) ) ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt10=1;
                }
                break;
            case 18:
                {
                alt10=2;
                }
                break;
            case RULE_TIDENTIFIER:
                {
                alt10=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:701:2: ( () ( (lv_index_1_0= RULE_INT ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:701:2: ( () ( (lv_index_1_0= RULE_INT ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:701:3: () ( (lv_index_1_0= RULE_INT ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:701:3: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:702:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getDimensionAccess().getIntDimensionAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:707:2: ( (lv_index_1_0= RULE_INT ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:708:1: (lv_index_1_0= RULE_INT )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:708:1: (lv_index_1_0= RULE_INT )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:709:3: lv_index_1_0= RULE_INT
                    {
                    lv_index_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDimension1506); if (state.failed) return current;
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:726:6: ( () otherlv_3= '#N' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:726:6: ( () otherlv_3= '#N' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:726:7: () otherlv_3= '#N'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:726:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:727:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getDimensionAccess().getNodeNumDimensionAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleDimension1540); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getDimensionAccess().getNKeyword_1_1());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:737:6: ( () ( (lv_index_5_0= RULE_TIDENTIFIER ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:737:6: ( () ( (lv_index_5_0= RULE_TIDENTIFIER ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:737:7: () ( (lv_index_5_0= RULE_TIDENTIFIER ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:737:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:738:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getDimensionAccess().getIdDimensionAction_2_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:743:2: ( (lv_index_5_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:744:1: (lv_index_5_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:744:1: (lv_index_5_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:745:3: lv_index_5_0= RULE_TIDENTIFIER
                    {
                    lv_index_5_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleDimension1574); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:769:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:770:2: (iv_ruleType= ruleType EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:771:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType1616);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType1626); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:778:1: ruleType returns [EObject current=null] : ( ( (lv_signed_0_0= ruleSigned ) )? ( (lv_simpType_1_0= ruleSimpType ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_signed_0_0 = null;

        AntlrDatatypeRuleToken lv_simpType_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:781:28: ( ( ( (lv_signed_0_0= ruleSigned ) )? ( (lv_simpType_1_0= ruleSimpType ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:782:1: ( ( (lv_signed_0_0= ruleSigned ) )? ( (lv_simpType_1_0= ruleSimpType ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:782:1: ( ( (lv_signed_0_0= ruleSigned ) )? ( (lv_simpType_1_0= ruleSimpType ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:782:2: ( (lv_signed_0_0= ruleSigned ) )? ( (lv_simpType_1_0= ruleSimpType ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:782:2: ( (lv_signed_0_0= ruleSigned ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=40 && LA11_0<=41)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:783:1: (lv_signed_0_0= ruleSigned )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:783:1: (lv_signed_0_0= ruleSigned )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:784:3: lv_signed_0_0= ruleSigned
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getSignedSignedParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSigned_in_ruleType1672);
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

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:800:3: ( (lv_simpType_1_0= ruleSimpType ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:801:1: (lv_simpType_1_0= ruleSimpType )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:801:1: (lv_simpType_1_0= ruleSimpType )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:802:3: lv_simpType_1_0= ruleSimpType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeAccess().getSimpTypeSimpTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSimpType_in_ruleType1694);
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:826:1: entryRuleProcedure returns [EObject current=null] : iv_ruleProcedure= ruleProcedure EOF ;
    public final EObject entryRuleProcedure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcedure = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:827:2: (iv_ruleProcedure= ruleProcedure EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:828:2: iv_ruleProcedure= ruleProcedure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcedureRule()); 
            }
            pushFollow(FOLLOW_ruleProcedure_in_entryRuleProcedure1730);
            iv_ruleProcedure=ruleProcedure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcedure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcedure1740); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:835:1: ruleProcedure returns [EObject current=null] : ( (lv_procedure_0_0= ruleProcNoAttr ) ) ;
    public final EObject ruleProcedure() throws RecognitionException {
        EObject current = null;

        EObject lv_procedure_0_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:838:28: ( ( (lv_procedure_0_0= ruleProcNoAttr ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:839:1: ( (lv_procedure_0_0= ruleProcNoAttr ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:839:1: ( (lv_procedure_0_0= ruleProcNoAttr ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:840:1: (lv_procedure_0_0= ruleProcNoAttr )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:840:1: (lv_procedure_0_0= ruleProcNoAttr )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:841:3: lv_procedure_0_0= ruleProcNoAttr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProcedureAccess().getProcedureProcNoAttrParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleProcNoAttr_in_ruleProcedure1785);
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:865:1: entryRuleProcNoAttr returns [EObject current=null] : iv_ruleProcNoAttr= ruleProcNoAttr EOF ;
    public final EObject entryRuleProcNoAttr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcNoAttr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:866:2: (iv_ruleProcNoAttr= ruleProcNoAttr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:867:2: iv_ruleProcNoAttr= ruleProcNoAttr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcNoAttrRule()); 
            }
            pushFollow(FOLLOW_ruleProcNoAttr_in_entryRuleProcNoAttr1820);
            iv_ruleProcNoAttr=ruleProcNoAttr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcNoAttr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcNoAttr1830); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:874:1: ruleProcNoAttr returns [EObject current=null] : ( ( (lv_prototype_0_0= ruleFnPrototype ) ) (otherlv_1= ';' | ( (lv_fnBody_2_0= ruleFnBody ) ) ) ) ;
    public final EObject ruleProcNoAttr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_prototype_0_0 = null;

        EObject lv_fnBody_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:877:28: ( ( ( (lv_prototype_0_0= ruleFnPrototype ) ) (otherlv_1= ';' | ( (lv_fnBody_2_0= ruleFnBody ) ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:878:1: ( ( (lv_prototype_0_0= ruleFnPrototype ) ) (otherlv_1= ';' | ( (lv_fnBody_2_0= ruleFnBody ) ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:878:1: ( ( (lv_prototype_0_0= ruleFnPrototype ) ) (otherlv_1= ';' | ( (lv_fnBody_2_0= ruleFnBody ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:878:2: ( (lv_prototype_0_0= ruleFnPrototype ) ) (otherlv_1= ';' | ( (lv_fnBody_2_0= ruleFnBody ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:878:2: ( (lv_prototype_0_0= ruleFnPrototype ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:879:1: (lv_prototype_0_0= ruleFnPrototype )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:879:1: (lv_prototype_0_0= ruleFnPrototype )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:880:3: lv_prototype_0_0= ruleFnPrototype
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProcNoAttrAccess().getPrototypeFnPrototypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFnPrototype_in_ruleProcNoAttr1876);
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

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:896:2: (otherlv_1= ';' | ( (lv_fnBody_2_0= ruleFnBody ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==15) ) {
                alt12=1;
            }
            else if ( (LA12_0==19) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:896:4: otherlv_1= ';'
                    {
                    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleProcNoAttr1889); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getProcNoAttrAccess().getSemicolonKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:901:6: ( (lv_fnBody_2_0= ruleFnBody ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:901:6: ( (lv_fnBody_2_0= ruleFnBody ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:902:1: (lv_fnBody_2_0= ruleFnBody )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:902:1: (lv_fnBody_2_0= ruleFnBody )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:903:3: lv_fnBody_2_0= ruleFnBody
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getProcNoAttrAccess().getFnBodyFnBodyParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFnBody_in_ruleProcNoAttr1916);
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:927:1: entryRuleFnBody returns [EObject current=null] : iv_ruleFnBody= ruleFnBody EOF ;
    public final EObject entryRuleFnBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFnBody = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:928:2: (iv_ruleFnBody= ruleFnBody EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:929:2: iv_ruleFnBody= ruleFnBody EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFnBodyRule()); 
            }
            pushFollow(FOLLOW_ruleFnBody_in_entryRuleFnBody1953);
            iv_ruleFnBody=ruleFnBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFnBody; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFnBody1963); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:936:1: ruleFnBody returns [EObject current=null] : (otherlv_0= '{' ( (lv_varInitList_1_0= ruleVarInitList ) ) otherlv_2= '}' ) ;
    public final EObject ruleFnBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_varInitList_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:939:28: ( (otherlv_0= '{' ( (lv_varInitList_1_0= ruleVarInitList ) ) otherlv_2= '}' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:940:1: (otherlv_0= '{' ( (lv_varInitList_1_0= ruleVarInitList ) ) otherlv_2= '}' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:940:1: (otherlv_0= '{' ( (lv_varInitList_1_0= ruleVarInitList ) ) otherlv_2= '}' )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:940:3: otherlv_0= '{' ( (lv_varInitList_1_0= ruleVarInitList ) ) otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleFnBody2000); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFnBodyAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:944:1: ( (lv_varInitList_1_0= ruleVarInitList ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:945:1: (lv_varInitList_1_0= ruleVarInitList )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:945:1: (lv_varInitList_1_0= ruleVarInitList )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:946:3: lv_varInitList_1_0= ruleVarInitList
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFnBodyAccess().getVarInitListVarInitListParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVarInitList_in_ruleFnBody2021);
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

            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleFnBody2033); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFnBodyAccess().getRightCurlyBracketKeyword_2());
                  
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:974:1: entryRuleFnPrototype returns [EObject current=null] : iv_ruleFnPrototype= ruleFnPrototype EOF ;
    public final EObject entryRuleFnPrototype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFnPrototype = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:975:2: (iv_ruleFnPrototype= ruleFnPrototype EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:976:2: iv_ruleFnPrototype= ruleFnPrototype EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFnPrototypeRule()); 
            }
            pushFollow(FOLLOW_ruleFnPrototype_in_entryRuleFnPrototype2069);
            iv_ruleFnPrototype=ruleFnPrototype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFnPrototype; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFnPrototype2079); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:983:1: ruleFnPrototype returns [EObject current=null] : ( ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) ) | ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' ) ) ;
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
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:986:28: ( ( ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) ) | ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:987:1: ( ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) ) | ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:987:1: ( ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) ) | ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' ) )
            int alt23=2;
            switch ( input.LA(1) ) {
            case 21:
                {
                switch ( input.LA(2) ) {
                case 23:
                    {
                    int LA23_3 = input.LA(3);

                    if ( ((LA23_3>=34 && LA23_3<=41)) ) {
                        alt23=2;
                    }
                    else if ( (LA23_3==25) ) {
                        alt23=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 24:
                    {
                    int LA23_4 = input.LA(3);

                    if ( (LA23_4==25) ) {
                        alt23=1;
                    }
                    else if ( ((LA23_4>=34 && LA23_4<=41)) ) {
                        alt23=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                    {
                    alt23=2;
                    }
                    break;
                case 25:
                    {
                    alt23=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }

                }
                break;
            case 22:
                {
                switch ( input.LA(2) ) {
                case 23:
                    {
                    int LA23_3 = input.LA(3);

                    if ( ((LA23_3>=34 && LA23_3<=41)) ) {
                        alt23=2;
                    }
                    else if ( (LA23_3==25) ) {
                        alt23=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 24:
                    {
                    int LA23_4 = input.LA(3);

                    if ( (LA23_4==25) ) {
                        alt23=1;
                    }
                    else if ( ((LA23_4>=34 && LA23_4<=41)) ) {
                        alt23=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 25:
                    {
                    alt23=1;
                    }
                    break;
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                    {
                    alt23=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 2, input);

                    throw nvae;
                }

                }
                break;
            case 23:
                {
                int LA23_3 = input.LA(2);

                if ( ((LA23_3>=34 && LA23_3<=41)) ) {
                    alt23=2;
                }
                else if ( (LA23_3==25) ) {
                    alt23=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 3, input);

                    throw nvae;
                }
                }
                break;
            case 24:
                {
                int LA23_4 = input.LA(2);

                if ( (LA23_4==25) ) {
                    alt23=1;
                }
                else if ( ((LA23_4>=34 && LA23_4<=41)) ) {
                    alt23=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 4, input);

                    throw nvae;
                }
                }
                break;
            case 25:
                {
                alt23=1;
                }
                break;
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
                {
                alt23=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:987:2: ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:987:2: ( () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:987:3: () ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )? ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )? otherlv_3= 'thread' ( (lv_name_4_0= RULE_TIDENTIFIER ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:987:3: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:988:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getFnPrototypeAccess().getThreadDeclarationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:993:2: ( ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( ((LA14_0>=21 && LA14_0<=22)) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:994:1: ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:994:1: ( (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:995:1: (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:995:1: (lv_extern_1_1= 'extern' | lv_extern_1_2= 'EXTERN' )
                            int alt13=2;
                            int LA13_0 = input.LA(1);

                            if ( (LA13_0==21) ) {
                                alt13=1;
                            }
                            else if ( (LA13_0==22) ) {
                                alt13=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 13, 0, input);

                                throw nvae;
                            }
                            switch (alt13) {
                                case 1 :
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:996:3: lv_extern_1_1= 'extern'
                                    {
                                    lv_extern_1_1=(Token)match(input,21,FOLLOW_21_in_ruleFnPrototype2134); if (state.failed) return current;
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
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1008:8: lv_extern_1_2= 'EXTERN'
                                    {
                                    lv_extern_1_2=(Token)match(input,22,FOLLOW_22_in_ruleFnPrototype2163); if (state.failed) return current;
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

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1023:3: ( ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( ((LA16_0>=23 && LA16_0<=24)) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1024:1: ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1024:1: ( (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1025:1: (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1025:1: (lv_pure_2_1= 'pure' | lv_pure_2_2= 'PURE' )
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0==23) ) {
                                alt15=1;
                            }
                            else if ( (LA15_0==24) ) {
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
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1026:3: lv_pure_2_1= 'pure'
                                    {
                                    lv_pure_2_1=(Token)match(input,23,FOLLOW_23_in_ruleFnPrototype2200); if (state.failed) return current;
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
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1038:8: lv_pure_2_2= 'PURE'
                                    {
                                    lv_pure_2_2=(Token)match(input,24,FOLLOW_24_in_ruleFnPrototype2229); if (state.failed) return current;
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

                    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleFnPrototype2258); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getFnPrototypeAccess().getThreadKeyword_0_3());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1057:1: ( (lv_name_4_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1058:1: (lv_name_4_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1058:1: (lv_name_4_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1059:3: lv_name_4_0= RULE_TIDENTIFIER
                    {
                    lv_name_4_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleFnPrototype2275); if (state.failed) return current;
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1076:6: ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1076:6: ( () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1076:7: () ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )? ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )? ( (lv_type_8_0= ruleType ) ) ( (lv_name_9_0= RULE_TIDENTIFIER ) ) otherlv_10= '(' ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )? otherlv_14= ')'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1076:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1077:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getFnPrototypeAccess().getFnPrototypeDeclarationAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1082:2: ( ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) ) )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( ((LA18_0>=21 && LA18_0<=22)) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1083:1: ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1083:1: ( (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1084:1: (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1084:1: (lv_extern_6_1= 'extern' | lv_extern_6_2= 'EXTERN' )
                            int alt17=2;
                            int LA17_0 = input.LA(1);

                            if ( (LA17_0==21) ) {
                                alt17=1;
                            }
                            else if ( (LA17_0==22) ) {
                                alt17=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 17, 0, input);

                                throw nvae;
                            }
                            switch (alt17) {
                                case 1 :
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1085:3: lv_extern_6_1= 'extern'
                                    {
                                    lv_extern_6_1=(Token)match(input,21,FOLLOW_21_in_ruleFnPrototype2317); if (state.failed) return current;
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
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1097:8: lv_extern_6_2= 'EXTERN'
                                    {
                                    lv_extern_6_2=(Token)match(input,22,FOLLOW_22_in_ruleFnPrototype2346); if (state.failed) return current;
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

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1112:3: ( ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) ) )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( ((LA20_0>=23 && LA20_0<=24)) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1113:1: ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1113:1: ( (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1114:1: (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1114:1: (lv_pure_7_1= 'pure' | lv_pure_7_2= 'PURE' )
                            int alt19=2;
                            int LA19_0 = input.LA(1);

                            if ( (LA19_0==23) ) {
                                alt19=1;
                            }
                            else if ( (LA19_0==24) ) {
                                alt19=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 19, 0, input);

                                throw nvae;
                            }
                            switch (alt19) {
                                case 1 :
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1115:3: lv_pure_7_1= 'pure'
                                    {
                                    lv_pure_7_1=(Token)match(input,23,FOLLOW_23_in_ruleFnPrototype2383); if (state.failed) return current;
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
                                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1127:8: lv_pure_7_2= 'PURE'
                                    {
                                    lv_pure_7_2=(Token)match(input,24,FOLLOW_24_in_ruleFnPrototype2412); if (state.failed) return current;
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

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1142:3: ( (lv_type_8_0= ruleType ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1143:1: (lv_type_8_0= ruleType )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1143:1: (lv_type_8_0= ruleType )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1144:3: lv_type_8_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFnPrototypeAccess().getTypeTypeParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleFnPrototype2450);
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

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1160:2: ( (lv_name_9_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1161:1: (lv_name_9_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1161:1: (lv_name_9_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1162:3: lv_name_9_0= RULE_TIDENTIFIER
                    {
                    lv_name_9_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleFnPrototype2467); if (state.failed) return current;
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

                    otherlv_10=(Token)match(input,26,FOLLOW_26_in_ruleFnPrototype2484); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getFnPrototypeAccess().getLeftParenthesisKeyword_1_5());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1182:1: ( ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )* )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( ((LA22_0>=34 && LA22_0<=41)) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1182:2: ( (lv_params_11_0= ruleParam ) ) (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )*
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1182:2: ( (lv_params_11_0= ruleParam ) )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1183:1: (lv_params_11_0= ruleParam )
                            {
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1183:1: (lv_params_11_0= ruleParam )
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1184:3: lv_params_11_0= ruleParam
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getFnPrototypeAccess().getParamsParamParserRuleCall_1_6_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleParam_in_ruleFnPrototype2506);
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

                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1200:2: (otherlv_12= ',' ( (lv_params_13_0= ruleParam ) ) )*
                            loop21:
                            do {
                                int alt21=2;
                                int LA21_0 = input.LA(1);

                                if ( (LA21_0==27) ) {
                                    alt21=1;
                                }


                                switch (alt21) {
                            	case 1 :
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1200:4: otherlv_12= ',' ( (lv_params_13_0= ruleParam ) )
                            	    {
                            	    otherlv_12=(Token)match(input,27,FOLLOW_27_in_ruleFnPrototype2519); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_12, grammarAccess.getFnPrototypeAccess().getCommaKeyword_1_6_1_0());
                            	          
                            	    }
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1204:1: ( (lv_params_13_0= ruleParam ) )
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1205:1: (lv_params_13_0= ruleParam )
                            	    {
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1205:1: (lv_params_13_0= ruleParam )
                            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1206:3: lv_params_13_0= ruleParam
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getFnPrototypeAccess().getParamsParamParserRuleCall_1_6_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleParam_in_ruleFnPrototype2540);
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
                            	    break loop21;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_14=(Token)match(input,28,FOLLOW_28_in_ruleFnPrototype2556); if (state.failed) return current;
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


    // $ANTLR start "entryRuleParam"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1234:1: entryRuleParam returns [EObject current=null] : iv_ruleParam= ruleParam EOF ;
    public final EObject entryRuleParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParam = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1235:2: (iv_ruleParam= ruleParam EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1236:2: iv_ruleParam= ruleParam EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamRule()); 
            }
            pushFollow(FOLLOW_ruleParam_in_entryRuleParam2593);
            iv_ruleParam=ruleParam();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParam; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParam2603); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1243:1: ruleParam returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_var_1_0= ruleVar ) ) ) ;
    public final EObject ruleParam() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        EObject lv_var_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1246:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_var_1_0= ruleVar ) ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1247:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_var_1_0= ruleVar ) ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1247:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_var_1_0= ruleVar ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1247:2: ( (lv_type_0_0= ruleType ) ) ( (lv_var_1_0= ruleVar ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1247:2: ( (lv_type_0_0= ruleType ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1248:1: (lv_type_0_0= ruleType )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1248:1: (lv_type_0_0= ruleType )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1249:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleParam2649);
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

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1265:2: ( (lv_var_1_0= ruleVar ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1266:1: (lv_var_1_0= ruleVar )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1266:1: (lv_var_1_0= ruleVar )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1267:3: lv_var_1_0= ruleVar
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamAccess().getVarVarParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVar_in_ruleParam2670);
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1291:1: entryRuleVarInitList returns [EObject current=null] : iv_ruleVarInitList= ruleVarInitList EOF ;
    public final EObject entryRuleVarInitList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarInitList = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1292:2: (iv_ruleVarInitList= ruleVarInitList EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1293:2: iv_ruleVarInitList= ruleVarInitList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarInitListRule()); 
            }
            pushFollow(FOLLOW_ruleVarInitList_in_entryRuleVarInitList2706);
            iv_ruleVarInitList=ruleVarInitList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarInitList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarInitList2716); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1300:1: ruleVarInitList returns [EObject current=null] : ( () ( ( (lv_varInits_1_0= ruleVarInit ) ) otherlv_2= ';' )* ) ;
    public final EObject ruleVarInitList() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_varInits_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1303:28: ( ( () ( ( (lv_varInits_1_0= ruleVarInit ) ) otherlv_2= ';' )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1304:1: ( () ( ( (lv_varInits_1_0= ruleVarInit ) ) otherlv_2= ';' )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1304:1: ( () ( ( (lv_varInits_1_0= ruleVarInit ) ) otherlv_2= ';' )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1304:2: () ( ( (lv_varInits_1_0= ruleVarInit ) ) otherlv_2= ';' )*
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1304:2: ()
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1305:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getVarInitListAccess().getVarInitListAction_0(),
                          current);
                  
            }

            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1310:2: ( ( (lv_varInits_1_0= ruleVarInit ) ) otherlv_2= ';' )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=34 && LA24_0<=41)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1310:3: ( (lv_varInits_1_0= ruleVarInit ) ) otherlv_2= ';'
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1310:3: ( (lv_varInits_1_0= ruleVarInit ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1311:1: (lv_varInits_1_0= ruleVarInit )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1311:1: (lv_varInits_1_0= ruleVarInit )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1312:3: lv_varInits_1_0= ruleVarInit
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVarInitListAccess().getVarInitsVarInitParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVarInit_in_ruleVarInitList2772);
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

            	    otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleVarInitList2784); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getVarInitListAccess().getSemicolonKeyword_1_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop24;
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


    // $ANTLR start "entryRuleLVal"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1340:1: entryRuleLVal returns [EObject current=null] : iv_ruleLVal= ruleLVal EOF ;
    public final EObject entryRuleLVal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLVal = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1341:2: (iv_ruleLVal= ruleLVal EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1342:2: iv_ruleLVal= ruleLVal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLValRule()); 
            }
            pushFollow(FOLLOW_ruleLVal_in_entryRuleLVal2822);
            iv_ruleLVal=ruleLVal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLVal; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLVal2832); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1349:1: ruleLVal returns [EObject current=null] : ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )* (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )? ) ;
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
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1352:28: ( ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )* (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )? ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1353:1: ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )* (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )? )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1353:1: ( ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )* (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )? )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1353:2: ( (lv_name_0_0= RULE_TIDENTIFIER ) ) (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )* (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )?
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1353:2: ( (lv_name_0_0= RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1354:1: (lv_name_0_0= RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1354:1: (lv_name_0_0= RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1355:3: lv_name_0_0= RULE_TIDENTIFIER
            {
            lv_name_0_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleLVal2874); if (state.failed) return current;
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

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1371:2: (otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']' )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==16) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1371:4: otherlv_1= '[' ( (lv_indices_2_0= ruleExpr ) ) otherlv_3= ']'
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleLVal2892); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getLValAccess().getLeftSquareBracketKeyword_1_0());
            	          
            	    }
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1375:1: ( (lv_indices_2_0= ruleExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1376:1: (lv_indices_2_0= ruleExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1376:1: (lv_indices_2_0= ruleExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1377:3: lv_indices_2_0= ruleExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLValAccess().getIndicesExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpr_in_ruleLVal2913);
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

            	    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleLVal2925); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getLValAccess().getRightSquareBracketKeyword_1_2());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1397:3: (otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==29) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1397:5: otherlv_4= '@' ( (lv_at_5_0= ruleExpr ) )
                    {
                    otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleLVal2940); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getLValAccess().getCommercialAtKeyword_2_0());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1401:1: ( (lv_at_5_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1402:1: (lv_at_5_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1402:1: (lv_at_5_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1403:3: lv_at_5_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLValAccess().getAtExprParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleLVal2961);
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1427:1: entryRuleExpr returns [EObject current=null] : iv_ruleExpr= ruleExpr EOF ;
    public final EObject entryRuleExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1428:2: (iv_ruleExpr= ruleExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1429:2: iv_ruleExpr= ruleExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExprRule()); 
            }
            pushFollow(FOLLOW_ruleExpr_in_entryRuleExpr2999);
            iv_ruleExpr=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpr3009); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1436:1: ruleExpr returns [EObject current=null] : this_EqualityExpr_0= ruleEqualityExpr ;
    public final EObject ruleExpr() throws RecognitionException {
        EObject current = null;

        EObject this_EqualityExpr_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1439:28: (this_EqualityExpr_0= ruleEqualityExpr )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1441:5: this_EqualityExpr_0= ruleEqualityExpr
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExprAccess().getEqualityExprParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleEqualityExpr_in_ruleExpr3055);
            this_EqualityExpr_0=ruleEqualityExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_EqualityExpr_0; 
                      afterParserOrEnumRuleCall();
                  
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


    // $ANTLR start "entryRuleEqualityExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1457:1: entryRuleEqualityExpr returns [EObject current=null] : iv_ruleEqualityExpr= ruleEqualityExpr EOF ;
    public final EObject entryRuleEqualityExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1458:2: (iv_ruleEqualityExpr= ruleEqualityExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1459:2: iv_ruleEqualityExpr= ruleEqualityExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExprRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpr_in_entryRuleEqualityExpr3089);
            iv_ruleEqualityExpr=ruleEqualityExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpr3099); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1466:1: ruleEqualityExpr returns [EObject current=null] : (this_CompareExpr_0= ruleCompareExpr ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )* ) ;
    public final EObject ruleEqualityExpr() throws RecognitionException {
        EObject current = null;

        EObject this_CompareExpr_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1469:28: ( (this_CompareExpr_0= ruleCompareExpr ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1470:1: (this_CompareExpr_0= ruleCompareExpr ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1470:1: (this_CompareExpr_0= ruleCompareExpr ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1471:5: this_CompareExpr_0= ruleCompareExpr ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEqualityExprAccess().getCompareExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleCompareExpr_in_ruleEqualityExpr3146);
            this_CompareExpr_0=ruleCompareExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_CompareExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1479:1: ( ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==50) ) {
                    int LA27_2 = input.LA(2);

                    if ( (synpred1_InternalDmpl()) ) {
                        alt27=1;
                    }


                }
                else if ( (LA27_0==51) ) {
                    int LA27_3 = input.LA(2);

                    if ( (synpred1_InternalDmpl()) ) {
                        alt27=1;
                    }


                }


                switch (alt27) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1479:2: ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) ) ( (lv_right_3_0= ruleCompareExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1479:2: ( ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1479:3: ( ( () ( ( ruleEqualityOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1484:6: ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1484:7: () ( (lv_operator_2_0= ruleEqualityOperator ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1484:7: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1485:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getEqualityExprAccess().getEqualityExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1490:2: ( (lv_operator_2_0= ruleEqualityOperator ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1491:1: (lv_operator_2_0= ruleEqualityOperator )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1491:1: (lv_operator_2_0= ruleEqualityOperator )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1492:3: lv_operator_2_0= ruleEqualityOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExprAccess().getOperatorEqualityOperatorEnumRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpr3195);
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

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1508:4: ( (lv_right_3_0= ruleCompareExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1509:1: (lv_right_3_0= ruleCompareExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1509:1: (lv_right_3_0= ruleCompareExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1510:3: lv_right_3_0= ruleCompareExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExprAccess().getRightCompareExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCompareExpr_in_ruleEqualityExpr3218);
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
            	    break loop27;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1534:1: entryRuleCompareExpr returns [EObject current=null] : iv_ruleCompareExpr= ruleCompareExpr EOF ;
    public final EObject entryRuleCompareExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompareExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1535:2: (iv_ruleCompareExpr= ruleCompareExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1536:2: iv_ruleCompareExpr= ruleCompareExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompareExprRule()); 
            }
            pushFollow(FOLLOW_ruleCompareExpr_in_entryRuleCompareExpr3256);
            iv_ruleCompareExpr=ruleCompareExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompareExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompareExpr3266); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1543:1: ruleCompareExpr returns [EObject current=null] : (this_ShiftExpr_0= ruleShiftExpr ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )* ) ;
    public final EObject ruleCompareExpr() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpr_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1546:28: ( (this_ShiftExpr_0= ruleShiftExpr ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1547:1: (this_ShiftExpr_0= ruleShiftExpr ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1547:1: (this_ShiftExpr_0= ruleShiftExpr ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1548:5: this_ShiftExpr_0= ruleShiftExpr ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getCompareExprAccess().getShiftExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleShiftExpr_in_ruleCompareExpr3313);
            this_ShiftExpr_0=ruleShiftExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ShiftExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1556:1: ( ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) ) )*
            loop28:
            do {
                int alt28=2;
                switch ( input.LA(1) ) {
                case 52:
                    {
                    int LA28_2 = input.LA(2);

                    if ( (synpred2_InternalDmpl()) ) {
                        alt28=1;
                    }


                    }
                    break;
                case 53:
                    {
                    int LA28_3 = input.LA(2);

                    if ( (synpred2_InternalDmpl()) ) {
                        alt28=1;
                    }


                    }
                    break;
                case 54:
                    {
                    int LA28_4 = input.LA(2);

                    if ( (synpred2_InternalDmpl()) ) {
                        alt28=1;
                    }


                    }
                    break;
                case 55:
                    {
                    int LA28_5 = input.LA(2);

                    if ( (synpred2_InternalDmpl()) ) {
                        alt28=1;
                    }


                    }
                    break;

                }

                switch (alt28) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1556:2: ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) ) ( (lv_right_3_0= ruleShiftExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1556:2: ( ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1556:3: ( ( () ( ( ruleCompareOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleCompareOperator ) ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1561:6: ( () ( (lv_operator_2_0= ruleCompareOperator ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1561:7: () ( (lv_operator_2_0= ruleCompareOperator ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1561:7: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1562:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getCompareExprAccess().getCompareExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1567:2: ( (lv_operator_2_0= ruleCompareOperator ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1568:1: (lv_operator_2_0= ruleCompareOperator )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1568:1: (lv_operator_2_0= ruleCompareOperator )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1569:3: lv_operator_2_0= ruleCompareOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCompareExprAccess().getOperatorCompareOperatorEnumRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCompareOperator_in_ruleCompareExpr3362);
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

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1585:4: ( (lv_right_3_0= ruleShiftExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1586:1: (lv_right_3_0= ruleShiftExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1586:1: (lv_right_3_0= ruleShiftExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1587:3: lv_right_3_0= ruleShiftExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCompareExprAccess().getRightShiftExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleShiftExpr_in_ruleCompareExpr3385);
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
            	    break loop28;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1611:1: entryRuleShiftExpr returns [EObject current=null] : iv_ruleShiftExpr= ruleShiftExpr EOF ;
    public final EObject entryRuleShiftExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1612:2: (iv_ruleShiftExpr= ruleShiftExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1613:2: iv_ruleShiftExpr= ruleShiftExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShiftExprRule()); 
            }
            pushFollow(FOLLOW_ruleShiftExpr_in_entryRuleShiftExpr3423);
            iv_ruleShiftExpr=ruleShiftExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShiftExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleShiftExpr3433); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1620:1: ruleShiftExpr returns [EObject current=null] : (this_AdditiveExpr_0= ruleAdditiveExpr ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )* ) ;
    public final EObject ruleShiftExpr() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpr_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1623:28: ( (this_AdditiveExpr_0= ruleAdditiveExpr ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1624:1: (this_AdditiveExpr_0= ruleAdditiveExpr ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1624:1: (this_AdditiveExpr_0= ruleAdditiveExpr ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1625:5: this_AdditiveExpr_0= ruleAdditiveExpr ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getShiftExprAccess().getAdditiveExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAdditiveExpr_in_ruleShiftExpr3480);
            this_AdditiveExpr_0=ruleAdditiveExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AdditiveExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1633:1: ( ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==56) ) {
                    int LA29_2 = input.LA(2);

                    if ( (synpred3_InternalDmpl()) ) {
                        alt29=1;
                    }


                }
                else if ( (LA29_0==57) ) {
                    int LA29_3 = input.LA(2);

                    if ( (synpred3_InternalDmpl()) ) {
                        alt29=1;
                    }


                }


                switch (alt29) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1633:2: ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) ) ( (lv_right_3_0= ruleAdditiveExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1633:2: ( ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1633:3: ( ( () ( ( ruleShiftOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleShiftOperator ) ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1638:6: ( () ( (lv_operator_2_0= ruleShiftOperator ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1638:7: () ( (lv_operator_2_0= ruleShiftOperator ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1638:7: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1639:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getShiftExprAccess().getShiftExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1644:2: ( (lv_operator_2_0= ruleShiftOperator ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1645:1: (lv_operator_2_0= ruleShiftOperator )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1645:1: (lv_operator_2_0= ruleShiftOperator )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1646:3: lv_operator_2_0= ruleShiftOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExprAccess().getOperatorShiftOperatorEnumRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleShiftOperator_in_ruleShiftExpr3529);
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

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1662:4: ( (lv_right_3_0= ruleAdditiveExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1663:1: (lv_right_3_0= ruleAdditiveExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1663:1: (lv_right_3_0= ruleAdditiveExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1664:3: lv_right_3_0= ruleAdditiveExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExprAccess().getRightAdditiveExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpr_in_ruleShiftExpr3552);
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
            	    break loop29;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1688:1: entryRuleAdditiveExpr returns [EObject current=null] : iv_ruleAdditiveExpr= ruleAdditiveExpr EOF ;
    public final EObject entryRuleAdditiveExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1689:2: (iv_ruleAdditiveExpr= ruleAdditiveExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1690:2: iv_ruleAdditiveExpr= ruleAdditiveExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExprRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpr_in_entryRuleAdditiveExpr3590);
            iv_ruleAdditiveExpr=ruleAdditiveExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpr3600); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1697:1: ruleAdditiveExpr returns [EObject current=null] : (this_MultiplicativeExpr_0= ruleMultiplicativeExpr ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )* ) ;
    public final EObject ruleAdditiveExpr() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpr_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1700:28: ( (this_MultiplicativeExpr_0= ruleMultiplicativeExpr ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1701:1: (this_MultiplicativeExpr_0= ruleMultiplicativeExpr ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1701:1: (this_MultiplicativeExpr_0= ruleMultiplicativeExpr ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1702:5: this_MultiplicativeExpr_0= ruleMultiplicativeExpr ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAdditiveExprAccess().getMultiplicativeExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpr_in_ruleAdditiveExpr3647);
            this_MultiplicativeExpr_0=ruleMultiplicativeExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MultiplicativeExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1710:1: ( ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==32) ) {
                    int LA30_2 = input.LA(2);

                    if ( (synpred4_InternalDmpl()) ) {
                        alt30=1;
                    }


                }
                else if ( (LA30_0==33) ) {
                    int LA30_3 = input.LA(2);

                    if ( (synpred4_InternalDmpl()) ) {
                        alt30=1;
                    }


                }


                switch (alt30) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1710:2: ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1710:2: ( ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1710:3: ( ( () ( ( ruleAdditiveOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1715:6: ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1715:7: () ( (lv_operator_2_0= ruleAdditiveOperator ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1715:7: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1716:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAdditiveExprAccess().getAdditiveExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1721:2: ( (lv_operator_2_0= ruleAdditiveOperator ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1722:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1722:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1723:3: lv_operator_2_0= ruleAdditiveOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExprAccess().getOperatorAdditiveOperatorEnumRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpr3696);
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

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1739:4: ( (lv_right_3_0= ruleMultiplicativeExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1740:1: (lv_right_3_0= ruleMultiplicativeExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1740:1: (lv_right_3_0= ruleMultiplicativeExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1741:3: lv_right_3_0= ruleMultiplicativeExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExprAccess().getRightMultiplicativeExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplicativeExpr_in_ruleAdditiveExpr3719);
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
    // $ANTLR end "ruleAdditiveExpr"


    // $ANTLR start "entryRuleMultiplicativeExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1765:1: entryRuleMultiplicativeExpr returns [EObject current=null] : iv_ruleMultiplicativeExpr= ruleMultiplicativeExpr EOF ;
    public final EObject entryRuleMultiplicativeExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1766:2: (iv_ruleMultiplicativeExpr= ruleMultiplicativeExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1767:2: iv_ruleMultiplicativeExpr= ruleMultiplicativeExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExprRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpr_in_entryRuleMultiplicativeExpr3757);
            iv_ruleMultiplicativeExpr=ruleMultiplicativeExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpr3767); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1774:1: ruleMultiplicativeExpr returns [EObject current=null] : (this_TerminalExpr_0= ruleTerminalExpr ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )* ) ;
    public final EObject ruleMultiplicativeExpr() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalExpr_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1777:28: ( (this_TerminalExpr_0= ruleTerminalExpr ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1778:1: (this_TerminalExpr_0= ruleTerminalExpr ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1778:1: (this_TerminalExpr_0= ruleTerminalExpr ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1779:5: this_TerminalExpr_0= ruleTerminalExpr ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplicativeExprAccess().getTerminalExprParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleTerminalExpr_in_ruleMultiplicativeExpr3814);
            this_TerminalExpr_0=ruleTerminalExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TerminalExpr_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1787:1: ( ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) ) )*
            loop31:
            do {
                int alt31=2;
                switch ( input.LA(1) ) {
                case 58:
                    {
                    int LA31_2 = input.LA(2);

                    if ( (synpred5_InternalDmpl()) ) {
                        alt31=1;
                    }


                    }
                    break;
                case 59:
                    {
                    int LA31_3 = input.LA(2);

                    if ( (synpred5_InternalDmpl()) ) {
                        alt31=1;
                    }


                    }
                    break;
                case 60:
                    {
                    int LA31_4 = input.LA(2);

                    if ( (synpred5_InternalDmpl()) ) {
                        alt31=1;
                    }


                    }
                    break;

                }

                switch (alt31) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1787:2: ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) ) ( (lv_right_3_0= ruleTerminalExpr ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1787:2: ( ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1787:3: ( ( () ( ( ruleMultiplicativeOperator ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1792:6: ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1792:7: () ( (lv_operator_2_0= ruleMultiplicativeOperator ) )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1792:7: ()
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1793:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplicativeExprAccess().getMultiplicativeExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1798:2: ( (lv_operator_2_0= ruleMultiplicativeOperator ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1799:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1799:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1800:3: lv_operator_2_0= ruleMultiplicativeOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExprAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpr3863);
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

            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1816:4: ( (lv_right_3_0= ruleTerminalExpr ) )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1817:1: (lv_right_3_0= ruleTerminalExpr )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1817:1: (lv_right_3_0= ruleTerminalExpr )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1818:3: lv_right_3_0= ruleTerminalExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExprAccess().getRightTerminalExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTerminalExpr_in_ruleMultiplicativeExpr3886);
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
    // $ANTLR end "ruleMultiplicativeExpr"


    // $ANTLR start "entryRuleTerminalExpr"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1842:1: entryRuleTerminalExpr returns [EObject current=null] : iv_ruleTerminalExpr= ruleTerminalExpr EOF ;
    public final EObject entryRuleTerminalExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1843:2: (iv_ruleTerminalExpr= ruleTerminalExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1844:2: iv_ruleTerminalExpr= ruleTerminalExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTerminalExprRule()); 
            }
            pushFollow(FOLLOW_ruleTerminalExpr_in_entryRuleTerminalExpr3924);
            iv_ruleTerminalExpr=ruleTerminalExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerminalExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalExpr3934); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1851:1: ruleTerminalExpr returns [EObject current=null] : (this_LVal_0= ruleLVal | ( () otherlv_2= 'id' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= ruleDouble ) ) ) | ( () otherlv_8= '#N' ) | ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) ) | ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' ) | this_CallExpr_19= ruleCallExpr | (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' ) ) ;
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
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1854:28: ( (this_LVal_0= ruleLVal | ( () otherlv_2= 'id' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= ruleDouble ) ) ) | ( () otherlv_8= '#N' ) | ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) ) | ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' ) | this_CallExpr_19= ruleCallExpr | (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1855:1: (this_LVal_0= ruleLVal | ( () otherlv_2= 'id' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= ruleDouble ) ) ) | ( () otherlv_8= '#N' ) | ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) ) | ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' ) | this_CallExpr_19= ruleCallExpr | (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1855:1: (this_LVal_0= ruleLVal | ( () otherlv_2= 'id' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= ruleDouble ) ) ) | ( () otherlv_8= '#N' ) | ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) ) | ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' ) | this_CallExpr_19= ruleCallExpr | (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' ) )
            int alt32=9;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1856:5: this_LVal_0= ruleLVal
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalExprAccess().getLValParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLVal_in_ruleTerminalExpr3981);
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1865:6: ( () otherlv_2= 'id' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1865:6: ( () otherlv_2= 'id' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1865:7: () otherlv_2= 'id'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1865:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1866:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getIdExprAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleTerminalExpr4008); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTerminalExprAccess().getIdKeyword_1_1());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1876:6: ( () ( (lv_value_4_0= RULE_INT ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1876:6: ( () ( (lv_value_4_0= RULE_INT ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1876:7: () ( (lv_value_4_0= RULE_INT ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1876:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1877:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getIntExprAction_2_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1882:2: ( (lv_value_4_0= RULE_INT ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1883:1: (lv_value_4_0= RULE_INT )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1883:1: (lv_value_4_0= RULE_INT )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1884:3: lv_value_4_0= RULE_INT
                    {
                    lv_value_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTerminalExpr4042); if (state.failed) return current;
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1901:6: ( () ( (lv_value_6_0= ruleDouble ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1901:6: ( () ( (lv_value_6_0= ruleDouble ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1901:7: () ( (lv_value_6_0= ruleDouble ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1901:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1902:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getDoubleExprAction_3_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1907:2: ( (lv_value_6_0= ruleDouble ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1908:1: (lv_value_6_0= ruleDouble )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1908:1: (lv_value_6_0= ruleDouble )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1909:3: lv_value_6_0= ruleDouble
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerminalExprAccess().getValueDoubleParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDouble_in_ruleTerminalExpr4085);
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1926:6: ( () otherlv_8= '#N' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1926:6: ( () otherlv_8= '#N' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1926:7: () otherlv_8= '#N'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1926:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1927:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getNodeNumExprAction_4_0(),
                                  current);
                          
                    }

                    }

                    otherlv_8=(Token)match(input,18,FOLLOW_18_in_ruleTerminalExpr4114); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getTerminalExprAccess().getNKeyword_4_1());
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1937:6: ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1937:6: ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1937:7: () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1937:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1938:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getUnaryExprAction_5_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1943:2: ( (lv_operator_10_0= ruleUnaryOperator ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1944:1: (lv_operator_10_0= ruleUnaryOperator )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1944:1: (lv_operator_10_0= ruleUnaryOperator )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1945:3: lv_operator_10_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerminalExprAccess().getOperatorUnaryOperatorEnumRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleTerminalExpr4152);
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

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1961:2: ( (lv_operand_11_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1962:1: (lv_operand_11_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1962:1: (lv_operand_11_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1963:3: lv_operand_11_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerminalExprAccess().getOperandExprParserRuleCall_5_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleTerminalExpr4173);
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1980:6: ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1980:6: ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1980:7: () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1980:7: ()
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1981:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTerminalExprAccess().getBuiltInExprAction_6_0(),
                                  current);
                          
                    }

                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1986:2: ( (lv_function_13_0= ruleBuiltInFunction ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1987:1: (lv_function_13_0= ruleBuiltInFunction )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1987:1: (lv_function_13_0= ruleBuiltInFunction )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1988:3: lv_function_13_0= ruleBuiltInFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerminalExprAccess().getFunctionBuiltInFunctionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBuiltInFunction_in_ruleTerminalExpr4211);
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

                    otherlv_14=(Token)match(input,26,FOLLOW_26_in_ruleTerminalExpr4223); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getTerminalExprAccess().getLeftParenthesisKeyword_6_2());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2008:1: ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2009:1: (lv_firstArg_15_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2009:1: (lv_firstArg_15_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2010:3: lv_firstArg_15_0= RULE_TIDENTIFIER
                    {
                    lv_firstArg_15_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleTerminalExpr4240); if (state.failed) return current;
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

                    otherlv_16=(Token)match(input,27,FOLLOW_27_in_ruleTerminalExpr4257); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getTerminalExprAccess().getCommaKeyword_6_4());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2030:1: ( (lv_secondArg_17_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2031:1: (lv_secondArg_17_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2031:1: (lv_secondArg_17_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2032:3: lv_secondArg_17_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTerminalExprAccess().getSecondArgExprParserRuleCall_6_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleTerminalExpr4278);
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

                    otherlv_18=(Token)match(input,28,FOLLOW_28_in_ruleTerminalExpr4290); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getTerminalExprAccess().getRightParenthesisKeyword_6_6());
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2054:5: this_CallExpr_19= ruleCallExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalExprAccess().getCallExprParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleCallExpr_in_ruleTerminalExpr4319);
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2063:6: (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2063:6: (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2063:8: otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')'
                    {
                    otherlv_20=(Token)match(input,26,FOLLOW_26_in_ruleTerminalExpr4337); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getTerminalExprAccess().getLeftParenthesisKeyword_8_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTerminalExprAccess().getExprParserRuleCall_8_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleTerminalExpr4359);
                    this_Expr_21=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Expr_21; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_22=(Token)match(input,28,FOLLOW_28_in_ruleTerminalExpr4370); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2088:1: entryRuleCallExpr returns [EObject current=null] : iv_ruleCallExpr= ruleCallExpr EOF ;
    public final EObject entryRuleCallExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallExpr = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2089:2: (iv_ruleCallExpr= ruleCallExpr EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2090:2: iv_ruleCallExpr= ruleCallExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallExprRule()); 
            }
            pushFollow(FOLLOW_ruleCallExpr_in_entryRuleCallExpr4407);
            iv_ruleCallExpr=ruleCallExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCallExpr; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallExpr4417); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2097:1: ruleCallExpr returns [EObject current=null] : ( ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )? ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '(' ( (lv_argList_4_0= ruleArgList ) ) otherlv_5= ')' (otherlv_6= '@' ( (lv_at_7_0= ruleExpr ) ) )? ) ;
    public final EObject ruleCallExpr() throws RecognitionException {
        EObject current = null;

        Token lv_namespace_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_argList_4_0 = null;

        EObject lv_at_7_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2100:28: ( ( ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )? ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '(' ( (lv_argList_4_0= ruleArgList ) ) otherlv_5= ')' (otherlv_6= '@' ( (lv_at_7_0= ruleExpr ) ) )? ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2101:1: ( ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )? ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '(' ( (lv_argList_4_0= ruleArgList ) ) otherlv_5= ')' (otherlv_6= '@' ( (lv_at_7_0= ruleExpr ) ) )? )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2101:1: ( ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )? ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '(' ( (lv_argList_4_0= ruleArgList ) ) otherlv_5= ')' (otherlv_6= '@' ( (lv_at_7_0= ruleExpr ) ) )? )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2101:2: ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )? ( (lv_name_2_0= RULE_TIDENTIFIER ) ) otherlv_3= '(' ( (lv_argList_4_0= ruleArgList ) ) otherlv_5= ')' (otherlv_6= '@' ( (lv_at_7_0= ruleExpr ) ) )?
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2101:2: ( ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_TIDENTIFIER) ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==31) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2101:3: ( (lv_namespace_0_0= RULE_TIDENTIFIER ) ) otherlv_1= '::'
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2101:3: ( (lv_namespace_0_0= RULE_TIDENTIFIER ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2102:1: (lv_namespace_0_0= RULE_TIDENTIFIER )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2102:1: (lv_namespace_0_0= RULE_TIDENTIFIER )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2103:3: lv_namespace_0_0= RULE_TIDENTIFIER
                    {
                    lv_namespace_0_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleCallExpr4460); if (state.failed) return current;
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

                    otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleCallExpr4477); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCallExprAccess().getColonColonKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2123:3: ( (lv_name_2_0= RULE_TIDENTIFIER ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2124:1: (lv_name_2_0= RULE_TIDENTIFIER )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2124:1: (lv_name_2_0= RULE_TIDENTIFIER )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2125:3: lv_name_2_0= RULE_TIDENTIFIER
            {
            lv_name_2_0=(Token)match(input,RULE_TIDENTIFIER,FOLLOW_RULE_TIDENTIFIER_in_ruleCallExpr4496); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleCallExpr4513); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getCallExprAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2145:1: ( (lv_argList_4_0= ruleArgList ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2146:1: (lv_argList_4_0= ruleArgList )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2146:1: (lv_argList_4_0= ruleArgList )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2147:3: lv_argList_4_0= ruleArgList
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCallExprAccess().getArgListArgListParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleArgList_in_ruleCallExpr4534);
            lv_argList_4_0=ruleArgList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCallExprRule());
              	        }
                     		set(
                     			current, 
                     			"argList",
                      		lv_argList_4_0, 
                      		"ArgList");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleCallExpr4546); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getCallExprAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2167:1: (otherlv_6= '@' ( (lv_at_7_0= ruleExpr ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==29) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2167:3: otherlv_6= '@' ( (lv_at_7_0= ruleExpr ) )
                    {
                    otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleCallExpr4559); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getCallExprAccess().getCommercialAtKeyword_5_0());
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2171:1: ( (lv_at_7_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2172:1: (lv_at_7_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2172:1: (lv_at_7_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2173:3: lv_at_7_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallExprAccess().getAtExprParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleCallExpr4580);
                    lv_at_7_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCallExprRule());
                      	        }
                             		set(
                             			current, 
                             			"at",
                              		lv_at_7_0, 
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


    // $ANTLR start "entryRuleArgList"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2197:1: entryRuleArgList returns [EObject current=null] : iv_ruleArgList= ruleArgList EOF ;
    public final EObject entryRuleArgList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgList = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2198:2: (iv_ruleArgList= ruleArgList EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2199:2: iv_ruleArgList= ruleArgList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgListRule()); 
            }
            pushFollow(FOLLOW_ruleArgList_in_entryRuleArgList4618);
            iv_ruleArgList=ruleArgList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgList4628); if (state.failed) return current;

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
    // $ANTLR end "entryRuleArgList"


    // $ANTLR start "ruleArgList"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2206:1: ruleArgList returns [EObject current=null] : ( () ( ( (lv_args_1_0= ruleExpr ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleExpr ) ) )* )? ) ;
    public final EObject ruleArgList() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_args_1_0 = null;

        EObject lv_args_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2209:28: ( ( () ( ( (lv_args_1_0= ruleExpr ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleExpr ) ) )* )? ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2210:1: ( () ( ( (lv_args_1_0= ruleExpr ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleExpr ) ) )* )? )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2210:1: ( () ( ( (lv_args_1_0= ruleExpr ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleExpr ) ) )* )? )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2210:2: () ( ( (lv_args_1_0= ruleExpr ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleExpr ) ) )* )?
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2210:2: ()
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2211:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getArgListAccess().getArgListAction_0(),
                          current);
                  
            }

            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2216:2: ( ( (lv_args_1_0= ruleExpr ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleExpr ) ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_TIDENTIFIER && LA36_0<=RULE_INT)||LA36_0==18||LA36_0==26||LA36_0==30||(LA36_0>=32 && LA36_0<=33)||(LA36_0>=42 && LA36_0<=48)||(LA36_0>=61 && LA36_0<=62)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2216:3: ( (lv_args_1_0= ruleExpr ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleExpr ) ) )*
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2216:3: ( (lv_args_1_0= ruleExpr ) )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2217:1: (lv_args_1_0= ruleExpr )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2217:1: (lv_args_1_0= ruleExpr )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2218:3: lv_args_1_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArgListAccess().getArgsExprParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpr_in_ruleArgList4684);
                    lv_args_1_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArgListRule());
                      	        }
                             		add(
                             			current, 
                             			"args",
                              		lv_args_1_0, 
                              		"Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2234:2: (otherlv_2= ',' ( (lv_args_3_0= ruleExpr ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==27) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2234:4: otherlv_2= ',' ( (lv_args_3_0= ruleExpr ) )
                    	    {
                    	    otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleArgList4697); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getArgListAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2238:1: ( (lv_args_3_0= ruleExpr ) )
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2239:1: (lv_args_3_0= ruleExpr )
                    	    {
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2239:1: (lv_args_3_0= ruleExpr )
                    	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2240:3: lv_args_3_0= ruleExpr
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getArgListAccess().getArgsExprParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExpr_in_ruleArgList4718);
                    	    lv_args_3_0=ruleExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getArgListRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"args",
                    	              		lv_args_3_0, 
                    	              		"Expr");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);


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
    // $ANTLR end "ruleArgList"


    // $ANTLR start "entryRuleSign"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2264:1: entryRuleSign returns [String current=null] : iv_ruleSign= ruleSign EOF ;
    public final String entryRuleSign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSign = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2265:2: (iv_ruleSign= ruleSign EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2266:2: iv_ruleSign= ruleSign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignRule()); 
            }
            pushFollow(FOLLOW_ruleSign_in_entryRuleSign4759);
            iv_ruleSign=ruleSign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSign.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSign4770); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2273:1: ruleSign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleSign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2276:28: ( (kw= '+' | kw= '-' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2277:1: (kw= '+' | kw= '-' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2277:1: (kw= '+' | kw= '-' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==32) ) {
                alt37=1;
            }
            else if ( (LA37_0==33) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2278:2: kw= '+'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleSign4808); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2285:2: kw= '-'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleSign4827); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2298:1: entryRuleSimpType returns [String current=null] : iv_ruleSimpType= ruleSimpType EOF ;
    public final String entryRuleSimpType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSimpType = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2299:2: (iv_ruleSimpType= ruleSimpType EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2300:2: iv_ruleSimpType= ruleSimpType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpTypeRule()); 
            }
            pushFollow(FOLLOW_ruleSimpType_in_entryRuleSimpType4868);
            iv_ruleSimpType=ruleSimpType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpType.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpType4879); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2307:1: ruleSimpType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'bool' | kw= '_Bool' | kw= 'int' | kw= 'double' | kw= 'void' | kw= 'char' ) ;
    public final AntlrDatatypeRuleToken ruleSimpType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2310:28: ( (kw= 'bool' | kw= '_Bool' | kw= 'int' | kw= 'double' | kw= 'void' | kw= 'char' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2311:1: (kw= 'bool' | kw= '_Bool' | kw= 'int' | kw= 'double' | kw= 'void' | kw= 'char' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2311:1: (kw= 'bool' | kw= '_Bool' | kw= 'int' | kw= 'double' | kw= 'void' | kw= 'char' )
            int alt38=6;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt38=1;
                }
                break;
            case 35:
                {
                alt38=2;
                }
                break;
            case 36:
                {
                alt38=3;
                }
                break;
            case 37:
                {
                alt38=4;
                }
                break;
            case 38:
                {
                alt38=5;
                }
                break;
            case 39:
                {
                alt38=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2312:2: kw= 'bool'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleSimpType4917); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpTypeAccess().getBoolKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2319:2: kw= '_Bool'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleSimpType4936); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpTypeAccess().get_BoolKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2326:2: kw= 'int'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleSimpType4955); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpTypeAccess().getIntKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2333:2: kw= 'double'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleSimpType4974); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpTypeAccess().getDoubleKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2340:2: kw= 'void'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleSimpType4993); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSimpTypeAccess().getVoidKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2347:2: kw= 'char'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleSimpType5012); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2360:1: entryRuleSigned returns [String current=null] : iv_ruleSigned= ruleSigned EOF ;
    public final String entryRuleSigned() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSigned = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2361:2: (iv_ruleSigned= ruleSigned EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2362:2: iv_ruleSigned= ruleSigned EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedRule()); 
            }
            pushFollow(FOLLOW_ruleSigned_in_entryRuleSigned5053);
            iv_ruleSigned=ruleSigned();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSigned.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSigned5064); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2369:1: ruleSigned returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'signed' | kw= 'unsigned' ) ;
    public final AntlrDatatypeRuleToken ruleSigned() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2372:28: ( (kw= 'signed' | kw= 'unsigned' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2373:1: (kw= 'signed' | kw= 'unsigned' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2373:1: (kw= 'signed' | kw= 'unsigned' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==40) ) {
                alt39=1;
            }
            else if ( (LA39_0==41) ) {
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
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2374:2: kw= 'signed'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleSigned5102); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedAccess().getSignedKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2381:2: kw= 'unsigned'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleSigned5121); if (state.failed) return current;
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


    // $ANTLR start "entryRuleBuiltInFunction"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2394:1: entryRuleBuiltInFunction returns [String current=null] : iv_ruleBuiltInFunction= ruleBuiltInFunction EOF ;
    public final String entryRuleBuiltInFunction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBuiltInFunction = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2395:2: (iv_ruleBuiltInFunction= ruleBuiltInFunction EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2396:2: iv_ruleBuiltInFunction= ruleBuiltInFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBuiltInFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleBuiltInFunction_in_entryRuleBuiltInFunction5162);
            iv_ruleBuiltInFunction=ruleBuiltInFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBuiltInFunction.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBuiltInFunction5173); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2403:1: ruleBuiltInFunction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'exists_other' | kw= 'EXISTS_OTHER' | kw= 'exists_higher' | kw= 'EXISTS_HIGHER' | kw= 'exists_lower' | kw= 'EXISTS_LOWER' ) ;
    public final AntlrDatatypeRuleToken ruleBuiltInFunction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2406:28: ( (kw= 'exists_other' | kw= 'EXISTS_OTHER' | kw= 'exists_higher' | kw= 'EXISTS_HIGHER' | kw= 'exists_lower' | kw= 'EXISTS_LOWER' ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2407:1: (kw= 'exists_other' | kw= 'EXISTS_OTHER' | kw= 'exists_higher' | kw= 'EXISTS_HIGHER' | kw= 'exists_lower' | kw= 'EXISTS_LOWER' )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2407:1: (kw= 'exists_other' | kw= 'EXISTS_OTHER' | kw= 'exists_higher' | kw= 'EXISTS_HIGHER' | kw= 'exists_lower' | kw= 'EXISTS_LOWER' )
            int alt40=6;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt40=1;
                }
                break;
            case 43:
                {
                alt40=2;
                }
                break;
            case 44:
                {
                alt40=3;
                }
                break;
            case 45:
                {
                alt40=4;
                }
                break;
            case 46:
                {
                alt40=5;
                }
                break;
            case 47:
                {
                alt40=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2408:2: kw= 'exists_other'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleBuiltInFunction5211); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFunctionAccess().getExists_otherKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2415:2: kw= 'EXISTS_OTHER'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleBuiltInFunction5230); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFunctionAccess().getEXISTS_OTHERKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2422:2: kw= 'exists_higher'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleBuiltInFunction5249); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFunctionAccess().getExists_higherKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2429:2: kw= 'EXISTS_HIGHER'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleBuiltInFunction5268); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFunctionAccess().getEXISTS_HIGHERKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2436:2: kw= 'exists_lower'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleBuiltInFunction5287); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFunctionAccess().getExists_lowerKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2443:2: kw= 'EXISTS_LOWER'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleBuiltInFunction5306); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2456:1: entryRuleDouble returns [String current=null] : iv_ruleDouble= ruleDouble EOF ;
    public final String entryRuleDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2457:2: (iv_ruleDouble= ruleDouble EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2458:2: iv_ruleDouble= ruleDouble EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDoubleRule()); 
            }
            pushFollow(FOLLOW_ruleDouble_in_entryRuleDouble5347);
            iv_ruleDouble=ruleDouble();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDouble.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDouble5358); if (state.failed) return current;

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2465:1: ruleDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'NAN' | (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? ) ) ;
    public final AntlrDatatypeRuleToken ruleDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2468:28: ( (kw= 'NAN' | (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2469:1: (kw= 'NAN' | (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2469:1: (kw= 'NAN' | (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==48) ) {
                alt42=1;
            }
            else if ( (LA42_0==RULE_INT) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2470:2: kw= 'NAN'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleDouble5396); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDoubleAccess().getNANKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2476:6: (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2476:6: (this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )? )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2476:11: this_INT_1= RULE_INT kw= '.' (this_INT_3= RULE_INT )?
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDouble5418); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_1, grammarAccess.getDoubleAccess().getINTTerminalRuleCall_1_0()); 
                          
                    }
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleDouble5436); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getDoubleAccess().getFullStopKeyword_1_1()); 
                          
                    }
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2489:1: (this_INT_3= RULE_INT )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==RULE_INT) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2489:6: this_INT_3= RULE_INT
                            {
                            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleDouble5452); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2510:1: ruleEqualityOperator returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) ;
    public final Enumerator ruleEqualityOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2512:28: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2513:1: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2513:1: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==50) ) {
                alt43=1;
            }
            else if ( (LA43_0==51) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2513:2: (enumLiteral_0= '==' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2513:2: (enumLiteral_0= '==' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2513:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_50_in_ruleEqualityOperator5520); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getEqualityOperatorAccess().getEQUALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getEqualityOperatorAccess().getEQUALEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2519:6: (enumLiteral_1= '!=' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2519:6: (enumLiteral_1= '!=' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2519:8: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,51,FOLLOW_51_in_ruleEqualityOperator5537); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2529:1: ruleCompareOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) ) ;
    public final Enumerator ruleCompareOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2531:28: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2532:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2532:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) )
            int alt44=4;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt44=1;
                }
                break;
            case 53:
                {
                alt44=2;
                }
                break;
            case 54:
                {
                alt44=3;
                }
                break;
            case 55:
                {
                alt44=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2532:2: (enumLiteral_0= '<' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2532:2: (enumLiteral_0= '<' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2532:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_52_in_ruleCompareOperator5582); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCompareOperatorAccess().getLESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getCompareOperatorAccess().getLESSEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2538:6: (enumLiteral_1= '<=' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2538:6: (enumLiteral_1= '<=' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2538:8: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_53_in_ruleCompareOperator5599); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCompareOperatorAccess().getLESS_EQUALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getCompareOperatorAccess().getLESS_EQUALEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2544:6: (enumLiteral_2= '>' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2544:6: (enumLiteral_2= '>' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2544:8: enumLiteral_2= '>'
                    {
                    enumLiteral_2=(Token)match(input,54,FOLLOW_54_in_ruleCompareOperator5616); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCompareOperatorAccess().getGREATEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getCompareOperatorAccess().getGREATEREnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2550:6: (enumLiteral_3= '>=' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2550:6: (enumLiteral_3= '>=' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2550:8: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,55,FOLLOW_55_in_ruleCompareOperator5633); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2560:1: ruleShiftOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) ) ;
    public final Enumerator ruleShiftOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2562:28: ( ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2563:1: ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2563:1: ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==56) ) {
                alt45=1;
            }
            else if ( (LA45_0==57) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2563:2: (enumLiteral_0= '<<' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2563:2: (enumLiteral_0= '<<' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2563:4: enumLiteral_0= '<<'
                    {
                    enumLiteral_0=(Token)match(input,56,FOLLOW_56_in_ruleShiftOperator5678); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getShiftOperatorAccess().getLEFTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getShiftOperatorAccess().getLEFTEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2569:6: (enumLiteral_1= '>>' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2569:6: (enumLiteral_1= '>>' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2569:8: enumLiteral_1= '>>'
                    {
                    enumLiteral_1=(Token)match(input,57,FOLLOW_57_in_ruleShiftOperator5695); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2579:1: ruleAdditiveOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2581:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2582:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2582:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==32) ) {
                alt46=1;
            }
            else if ( (LA46_0==33) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2582:2: (enumLiteral_0= '+' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2582:2: (enumLiteral_0= '+' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2582:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,32,FOLLOW_32_in_ruleAdditiveOperator5740); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAdditiveOperatorAccess().getADDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOperatorAccess().getADDEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2588:6: (enumLiteral_1= '-' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2588:6: (enumLiteral_1= '-' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2588:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,33,FOLLOW_33_in_ruleAdditiveOperator5757); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2598:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2600:28: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2601:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2601:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt47=3;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt47=1;
                }
                break;
            case 59:
                {
                alt47=2;
                }
                break;
            case 60:
                {
                alt47=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2601:2: (enumLiteral_0= '*' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2601:2: (enumLiteral_0= '*' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2601:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,58,FOLLOW_58_in_ruleMultiplicativeOperator5802); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMultiplicativeOperatorAccess().getMULTIPLYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOperatorAccess().getMULTIPLYEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2607:6: (enumLiteral_1= '/' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2607:6: (enumLiteral_1= '/' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2607:8: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_59_in_ruleMultiplicativeOperator5819); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMultiplicativeOperatorAccess().getDIVIDEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOperatorAccess().getDIVIDEEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2613:6: (enumLiteral_2= '%' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2613:6: (enumLiteral_2= '%' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2613:8: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,60,FOLLOW_60_in_ruleMultiplicativeOperator5836); if (state.failed) return current;
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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2623:1: ruleUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= '-' ) | (enumLiteral_1= '+' ) | (enumLiteral_2= '!' ) | (enumLiteral_3= '~' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2625:28: ( ( (enumLiteral_0= '-' ) | (enumLiteral_1= '+' ) | (enumLiteral_2= '!' ) | (enumLiteral_3= '~' ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2626:1: ( (enumLiteral_0= '-' ) | (enumLiteral_1= '+' ) | (enumLiteral_2= '!' ) | (enumLiteral_3= '~' ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2626:1: ( (enumLiteral_0= '-' ) | (enumLiteral_1= '+' ) | (enumLiteral_2= '!' ) | (enumLiteral_3= '~' ) )
            int alt48=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt48=1;
                }
                break;
            case 32:
                {
                alt48=2;
                }
                break;
            case 61:
                {
                alt48=3;
                }
                break;
            case 62:
                {
                alt48=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2626:2: (enumLiteral_0= '-' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2626:2: (enumLiteral_0= '-' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2626:4: enumLiteral_0= '-'
                    {
                    enumLiteral_0=(Token)match(input,33,FOLLOW_33_in_ruleUnaryOperator5881); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getMINUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getMINUSEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2632:6: (enumLiteral_1= '+' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2632:6: (enumLiteral_1= '+' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2632:8: enumLiteral_1= '+'
                    {
                    enumLiteral_1=(Token)match(input,32,FOLLOW_32_in_ruleUnaryOperator5898); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getPLUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getUnaryOperatorAccess().getPLUSEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2638:6: (enumLiteral_2= '!' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2638:6: (enumLiteral_2= '!' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2638:8: enumLiteral_2= '!'
                    {
                    enumLiteral_2=(Token)match(input,61,FOLLOW_61_in_ruleUnaryOperator5915); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getUnaryOperatorAccess().getLOGICAL_NOTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getUnaryOperatorAccess().getLOGICAL_NOTEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2644:6: (enumLiteral_3= '~' )
                    {
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2644:6: (enumLiteral_3= '~' )
                    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:2644:8: enumLiteral_3= '~'
                    {
                    enumLiteral_3=(Token)match(input,62,FOLLOW_62_in_ruleUnaryOperator5932); if (state.failed) return current;
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
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1479:3: ( ( () ( ( ruleEqualityOperator ) ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1479:4: ( () ( ( ruleEqualityOperator ) ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1479:4: ( () ( ( ruleEqualityOperator ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1479:5: () ( ( ruleEqualityOperator ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1479:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1480:1: 
        {
        }

        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1480:2: ( ( ruleEqualityOperator ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1481:1: ( ruleEqualityOperator )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1481:1: ( ruleEqualityOperator )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1482:1: ruleEqualityOperator
        {
        pushFollow(FOLLOW_ruleEqualityOperator_in_synpred1_InternalDmpl3165);
        ruleEqualityOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalDmpl

    // $ANTLR start synpred2_InternalDmpl
    public final void synpred2_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1556:3: ( ( () ( ( ruleCompareOperator ) ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1556:4: ( () ( ( ruleCompareOperator ) ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1556:4: ( () ( ( ruleCompareOperator ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1556:5: () ( ( ruleCompareOperator ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1556:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1557:1: 
        {
        }

        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1557:2: ( ( ruleCompareOperator ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1558:1: ( ruleCompareOperator )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1558:1: ( ruleCompareOperator )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1559:1: ruleCompareOperator
        {
        pushFollow(FOLLOW_ruleCompareOperator_in_synpred2_InternalDmpl3332);
        ruleCompareOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalDmpl

    // $ANTLR start synpred3_InternalDmpl
    public final void synpred3_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1633:3: ( ( () ( ( ruleShiftOperator ) ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1633:4: ( () ( ( ruleShiftOperator ) ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1633:4: ( () ( ( ruleShiftOperator ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1633:5: () ( ( ruleShiftOperator ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1633:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1634:1: 
        {
        }

        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1634:2: ( ( ruleShiftOperator ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1635:1: ( ruleShiftOperator )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1635:1: ( ruleShiftOperator )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1636:1: ruleShiftOperator
        {
        pushFollow(FOLLOW_ruleShiftOperator_in_synpred3_InternalDmpl3499);
        ruleShiftOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalDmpl

    // $ANTLR start synpred4_InternalDmpl
    public final void synpred4_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1710:3: ( ( () ( ( ruleAdditiveOperator ) ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1710:4: ( () ( ( ruleAdditiveOperator ) ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1710:4: ( () ( ( ruleAdditiveOperator ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1710:5: () ( ( ruleAdditiveOperator ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1710:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1711:1: 
        {
        }

        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1711:2: ( ( ruleAdditiveOperator ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1712:1: ( ruleAdditiveOperator )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1712:1: ( ruleAdditiveOperator )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1713:1: ruleAdditiveOperator
        {
        pushFollow(FOLLOW_ruleAdditiveOperator_in_synpred4_InternalDmpl3666);
        ruleAdditiveOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalDmpl

    // $ANTLR start synpred5_InternalDmpl
    public final void synpred5_InternalDmpl_fragment() throws RecognitionException {   
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1787:3: ( ( () ( ( ruleMultiplicativeOperator ) ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1787:4: ( () ( ( ruleMultiplicativeOperator ) ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1787:4: ( () ( ( ruleMultiplicativeOperator ) ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1787:5: () ( ( ruleMultiplicativeOperator ) )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1787:5: ()
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1788:1: 
        {
        }

        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1788:2: ( ( ruleMultiplicativeOperator ) )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1789:1: ( ruleMultiplicativeOperator )
        {
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1789:1: ( ruleMultiplicativeOperator )
        // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:1790:1: ruleMultiplicativeOperator
        {
        pushFollow(FOLLOW_ruleMultiplicativeOperator_in_synpred5_InternalDmpl3833);
        ruleMultiplicativeOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalDmpl

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


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA32 dfa32 = new DFA32(this);
    static final String DFA7_eotS =
        "\11\uffff";
    static final String DFA7_eofS =
        "\1\uffff\1\3\6\uffff\1\3";
    static final String DFA7_minS =
        "\1\4\1\16\1\4\2\uffff\3\21\1\16";
    static final String DFA7_maxS =
        "\1\4\1\20\1\22\2\uffff\3\21\1\20";
    static final String DFA7_acceptS =
        "\3\uffff\1\1\1\2\4\uffff";
    static final String DFA7_specialS =
        "\11\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1",
            "\1\4\1\3\1\2",
            "\1\7\1\5\14\uffff\1\6",
            "",
            "",
            "\1\10",
            "\1\10",
            "\1\10",
            "\1\4\1\3\1\2"
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "498:1: ( ( (lv_var_0_0= ruleVar ) ) | ( (lv_varAsgn_1_0= ruleVarAsgn ) ) )";
        }
    }
    static final String DFA32_eotS =
        "\14\uffff";
    static final String DFA32_eofS =
        "\1\uffff\1\12\1\uffff\1\13\10\uffff";
    static final String DFA32_minS =
        "\1\4\1\17\1\uffff\1\17\10\uffff";
    static final String DFA32_maxS =
        "\1\76\1\74\1\uffff\1\74\10\uffff";
    static final String DFA32_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\5\1\6\1\7\1\11\1\10\1\1\1\3";
    static final String DFA32_specialS =
        "\14\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\1\1\3\14\uffff\1\5\7\uffff\1\10\3\uffff\1\2\1\uffff\2\6\10\uffff\6\7\1\4\14\uffff\2\6",
            "\3\12\10\uffff\1\11\3\12\1\uffff\1\11\2\12\20\uffff\13\12",
            "",
            "\1\13\1\uffff\1\13\11\uffff\2\13\3\uffff\2\13\17\uffff\1\4\13\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "1855:1: (this_LVal_0= ruleLVal | ( () otherlv_2= 'id' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= ruleDouble ) ) ) | ( () otherlv_8= '#N' ) | ( () ( (lv_operator_10_0= ruleUnaryOperator ) ) ( (lv_operand_11_0= ruleExpr ) ) ) | ( () ( (lv_function_13_0= ruleBuiltInFunction ) ) otherlv_14= '(' ( (lv_firstArg_15_0= RULE_TIDENTIFIER ) ) otherlv_16= ',' ( (lv_secondArg_17_0= ruleExpr ) ) otherlv_18= ')' ) | this_CallExpr_19= ruleCallExpr | (otherlv_20= '(' this_Expr_21= ruleExpr otherlv_22= ')' ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProgram85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProgramElement_in_ruleProgram140 = new BitSet(new long[]{0x000003FC03E03002L});
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
    public static final BitSet FOLLOW_14_in_ruleConstant500 = new BitSet(new long[]{0x0001000300000020L});
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
    public static final BitSet FOLLOW_ruleSign_in_ruleDoubleConst859 = new BitSet(new long[]{0x0001000300000020L});
    public static final BitSet FOLLOW_ruleDouble_in_ruleDoubleConst881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarInit_in_entryRuleVarInit917 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarInit927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleVarInit973 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVarAsgnList_in_ruleVarInit994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarAsgnList_in_entryRuleVarAsgnList1030 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarAsgnList1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_ruleVarAsgnList1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarAsgn_in_ruleVarAsgnList1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarAsgn_in_entryRuleVarAsgn1149 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarAsgn1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_ruleVarAsgn1205 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVarAsgn1217 = new BitSet(new long[]{0x6001FC03440C0030L});
    public static final BitSet FOLLOW_ruleFnBody_in_ruleVarAsgn1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleVarAsgn1266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVar_in_entryRuleVar1303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVar1313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleVar1355 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleVar1373 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_ruleDimension_in_ruleVar1394 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVar1406 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleDimension_in_entryRuleDimension1444 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDimension1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDimension1506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleDimension1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleDimension1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType1616 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSigned_in_ruleType1672 = new BitSet(new long[]{0x000003FC03E03000L});
    public static final BitSet FOLLOW_ruleSimpType_in_ruleType1694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcedure_in_entryRuleProcedure1730 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcedure1740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcNoAttr_in_ruleProcedure1785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcNoAttr_in_entryRuleProcNoAttr1820 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcNoAttr1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnPrototype_in_ruleProcNoAttr1876 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_15_in_ruleProcNoAttr1889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnBody_in_ruleProcNoAttr1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnBody_in_entryRuleFnBody1953 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFnBody1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleFnBody2000 = new BitSet(new long[]{0x000003FC03F03010L});
    public static final BitSet FOLLOW_ruleVarInitList_in_ruleFnBody2021 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleFnBody2033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFnPrototype_in_entryRuleFnPrototype2069 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFnPrototype2079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleFnPrototype2134 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_22_in_ruleFnPrototype2163 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_23_in_ruleFnPrototype2200 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_24_in_ruleFnPrototype2229 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleFnPrototype2258 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleFnPrototype2275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleFnPrototype2317 = new BitSet(new long[]{0x000003FC03E03010L});
    public static final BitSet FOLLOW_22_in_ruleFnPrototype2346 = new BitSet(new long[]{0x000003FC03E03010L});
    public static final BitSet FOLLOW_23_in_ruleFnPrototype2383 = new BitSet(new long[]{0x000003FC03E03010L});
    public static final BitSet FOLLOW_24_in_ruleFnPrototype2412 = new BitSet(new long[]{0x000003FC03E03010L});
    public static final BitSet FOLLOW_ruleType_in_ruleFnPrototype2450 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleFnPrototype2467 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleFnPrototype2484 = new BitSet(new long[]{0x000003FC13E03010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleFnPrototype2506 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleFnPrototype2519 = new BitSet(new long[]{0x000003FC03E03010L});
    public static final BitSet FOLLOW_ruleParam_in_ruleFnPrototype2540 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_ruleFnPrototype2556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParam_in_entryRuleParam2593 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParam2603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleParam2649 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVar_in_ruleParam2670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarInitList_in_entryRuleVarInitList2706 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarInitList2716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarInit_in_ruleVarInitList2772 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleVarInitList2784 = new BitSet(new long[]{0x000003FC03E03012L});
    public static final BitSet FOLLOW_ruleLVal_in_entryRuleLVal2822 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLVal2832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleLVal2874 = new BitSet(new long[]{0x0000000020010002L});
    public static final BitSet FOLLOW_16_in_ruleLVal2892 = new BitSet(new long[]{0x6001FC03440C0030L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleLVal2913 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleLVal2925 = new BitSet(new long[]{0x0000000020010002L});
    public static final BitSet FOLLOW_29_in_ruleLVal2940 = new BitSet(new long[]{0x6001FC03440C0030L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleLVal2961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_entryRuleExpr2999 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpr3009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpr_in_ruleExpr3055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpr_in_entryRuleEqualityExpr3089 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpr3099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompareExpr_in_ruleEqualityExpr3146 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpr3195 = new BitSet(new long[]{0x6001FC03440C0030L});
    public static final BitSet FOLLOW_ruleCompareExpr_in_ruleEqualityExpr3218 = new BitSet(new long[]{0x000C000000000002L});
    public static final BitSet FOLLOW_ruleCompareExpr_in_entryRuleCompareExpr3256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompareExpr3266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpr_in_ruleCompareExpr3313 = new BitSet(new long[]{0x00F0000000000002L});
    public static final BitSet FOLLOW_ruleCompareOperator_in_ruleCompareExpr3362 = new BitSet(new long[]{0x6001FC03440C0030L});
    public static final BitSet FOLLOW_ruleShiftExpr_in_ruleCompareExpr3385 = new BitSet(new long[]{0x00F0000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpr_in_entryRuleShiftExpr3423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShiftExpr3433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpr_in_ruleShiftExpr3480 = new BitSet(new long[]{0x0300000000000002L});
    public static final BitSet FOLLOW_ruleShiftOperator_in_ruleShiftExpr3529 = new BitSet(new long[]{0x6001FC03440C0030L});
    public static final BitSet FOLLOW_ruleAdditiveExpr_in_ruleShiftExpr3552 = new BitSet(new long[]{0x0300000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpr_in_entryRuleAdditiveExpr3590 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpr3600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpr_in_ruleAdditiveExpr3647 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpr3696 = new BitSet(new long[]{0x6001FC03440C0030L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpr_in_ruleAdditiveExpr3719 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpr_in_entryRuleMultiplicativeExpr3757 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpr3767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpr_in_ruleMultiplicativeExpr3814 = new BitSet(new long[]{0x1C00000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpr3863 = new BitSet(new long[]{0x6001FC03440C0030L});
    public static final BitSet FOLLOW_ruleTerminalExpr_in_ruleMultiplicativeExpr3886 = new BitSet(new long[]{0x1C00000000000002L});
    public static final BitSet FOLLOW_ruleTerminalExpr_in_entryRuleTerminalExpr3924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalExpr3934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLVal_in_ruleTerminalExpr3981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleTerminalExpr4008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTerminalExpr4042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDouble_in_ruleTerminalExpr4085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleTerminalExpr4114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleTerminalExpr4152 = new BitSet(new long[]{0x6001FC03440C0030L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleTerminalExpr4173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltInFunction_in_ruleTerminalExpr4211 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleTerminalExpr4223 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleTerminalExpr4240 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleTerminalExpr4257 = new BitSet(new long[]{0x6001FC03440C0030L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleTerminalExpr4278 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTerminalExpr4290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExpr_in_ruleTerminalExpr4319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleTerminalExpr4337 = new BitSet(new long[]{0x6001FC03440C0030L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleTerminalExpr4359 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTerminalExpr4370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallExpr_in_entryRuleCallExpr4407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallExpr4417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleCallExpr4460 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleCallExpr4477 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_TIDENTIFIER_in_ruleCallExpr4496 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleCallExpr4513 = new BitSet(new long[]{0x6001FC03540C0030L});
    public static final BitSet FOLLOW_ruleArgList_in_ruleCallExpr4534 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleCallExpr4546 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleCallExpr4559 = new BitSet(new long[]{0x6001FC03440C0030L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleCallExpr4580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgList_in_entryRuleArgList4618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgList4628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleArgList4684 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleArgList4697 = new BitSet(new long[]{0x6001FC03440C0030L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleArgList4718 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleSign_in_entryRuleSign4759 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSign4770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleSign4808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleSign4827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpType_in_entryRuleSimpType4868 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpType4879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleSimpType4917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleSimpType4936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleSimpType4955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleSimpType4974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleSimpType4993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleSimpType5012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSigned_in_entryRuleSigned5053 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSigned5064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleSigned5102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleSigned5121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuiltInFunction_in_entryRuleBuiltInFunction5162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBuiltInFunction5173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleBuiltInFunction5211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleBuiltInFunction5230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleBuiltInFunction5249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleBuiltInFunction5268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleBuiltInFunction5287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleBuiltInFunction5306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDouble_in_entryRuleDouble5347 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDouble5358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleDouble5396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDouble5418 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleDouble5436 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleDouble5452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleEqualityOperator5520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleEqualityOperator5537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleCompareOperator5582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleCompareOperator5599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleCompareOperator5616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleCompareOperator5633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleShiftOperator5678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleShiftOperator5695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAdditiveOperator5740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleAdditiveOperator5757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleMultiplicativeOperator5802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleMultiplicativeOperator5819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleMultiplicativeOperator5836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleUnaryOperator5881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleUnaryOperator5898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleUnaryOperator5915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleUnaryOperator5932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_synpred1_InternalDmpl3165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompareOperator_in_synpred2_InternalDmpl3332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftOperator_in_synpred3_InternalDmpl3499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_synpred4_InternalDmpl3666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_synpred5_InternalDmpl3833 = new BitSet(new long[]{0x0000000000000002L});

}