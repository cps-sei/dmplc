package edu.cmu.sei.annex.dmpl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import edu.cmu.sei.annex.dmpl.services.DmplGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDmplParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=7;
    public static final int EOF=-1;

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
        	return "AnnexSubclause";	
       	}
       	
       	@Override
       	protected DmplGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleAnnexSubclause"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:67:1: entryRuleAnnexSubclause returns [EObject current=null] : iv_ruleAnnexSubclause= ruleAnnexSubclause EOF ;
    public final EObject entryRuleAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnexSubclause = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:68:2: (iv_ruleAnnexSubclause= ruleAnnexSubclause EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:69:2: iv_ruleAnnexSubclause= ruleAnnexSubclause EOF
            {
             newCompositeNode(grammarAccess.getAnnexSubclauseRule()); 
            pushFollow(FOLLOW_ruleAnnexSubclause_in_entryRuleAnnexSubclause75);
            iv_ruleAnnexSubclause=ruleAnnexSubclause();

            state._fsp--;

             current =iv_ruleAnnexSubclause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnexSubclause85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnexSubclause"


    // $ANTLR start "ruleAnnexSubclause"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:76:1: ruleAnnexSubclause returns [EObject current=null] : this_DmplSubclause_0= ruleDmplSubclause ;
    public final EObject ruleAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject this_DmplSubclause_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:79:28: (this_DmplSubclause_0= ruleDmplSubclause )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:81:5: this_DmplSubclause_0= ruleDmplSubclause
            {
             
                    newCompositeNode(grammarAccess.getAnnexSubclauseAccess().getDmplSubclauseParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleDmplSubclause_in_ruleAnnexSubclause131);
            this_DmplSubclause_0=ruleDmplSubclause();

            state._fsp--;

             
                    current = this_DmplSubclause_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnexSubclause"


    // $ANTLR start "entryRuleDmplSubclause"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:97:1: entryRuleDmplSubclause returns [EObject current=null] : iv_ruleDmplSubclause= ruleDmplSubclause EOF ;
    public final EObject entryRuleDmplSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDmplSubclause = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:98:2: (iv_ruleDmplSubclause= ruleDmplSubclause EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:99:2: iv_ruleDmplSubclause= ruleDmplSubclause EOF
            {
             newCompositeNode(grammarAccess.getDmplSubclauseRule()); 
            pushFollow(FOLLOW_ruleDmplSubclause_in_entryRuleDmplSubclause165);
            iv_ruleDmplSubclause=ruleDmplSubclause();

            state._fsp--;

             current =iv_ruleDmplSubclause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDmplSubclause175); 

            }

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
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:106:1: ruleDmplSubclause returns [EObject current=null] : ( () ( (lv_functionCalls_1_0= ruleFunctionCall ) )* ) ;
    public final EObject ruleDmplSubclause() throws RecognitionException {
        EObject current = null;

        EObject lv_functionCalls_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:109:28: ( ( () ( (lv_functionCalls_1_0= ruleFunctionCall ) )* ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:110:1: ( () ( (lv_functionCalls_1_0= ruleFunctionCall ) )* )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:110:1: ( () ( (lv_functionCalls_1_0= ruleFunctionCall ) )* )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:110:2: () ( (lv_functionCalls_1_0= ruleFunctionCall ) )*
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:110:2: ()
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:111:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDmplSubclauseAccess().getDmplSubclauseAction_0(),
                        current);
                

            }

            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:116:2: ( (lv_functionCalls_1_0= ruleFunctionCall ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:117:1: (lv_functionCalls_1_0= ruleFunctionCall )
            	    {
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:117:1: (lv_functionCalls_1_0= ruleFunctionCall )
            	    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:118:3: lv_functionCalls_1_0= ruleFunctionCall
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDmplSubclauseAccess().getFunctionCallsFunctionCallParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFunctionCall_in_ruleDmplSubclause230);
            	    lv_functionCalls_1_0=ruleFunctionCall();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDmplSubclauseRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"functionCalls",
            	            		lv_functionCalls_1_0, 
            	            		"FunctionCall");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleFunctionCall"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:142:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:143:2: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:144:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getFunctionCallRule()); 
            pushFollow(FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall267);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;

             current =iv_ruleFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionCall277); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:151:1: ruleFunctionCall returns [EObject current=null] : ( (lv_functionName_0_0= RULE_ID ) ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        Token lv_functionName_0_0=null;

         enterRule(); 
            
        try {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:154:28: ( ( (lv_functionName_0_0= RULE_ID ) ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:155:1: ( (lv_functionName_0_0= RULE_ID ) )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:155:1: ( (lv_functionName_0_0= RULE_ID ) )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:156:1: (lv_functionName_0_0= RULE_ID )
            {
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:156:1: (lv_functionName_0_0= RULE_ID )
            // ../edu.cmu.sei.annex.dmpl/src-gen/edu/cmu/sei/annex/dmpl/parser/antlr/internal/InternalDmpl.g:157:3: lv_functionName_0_0= RULE_ID
            {
            lv_functionName_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunctionCall318); 

            			newLeafNode(lv_functionName_0_0, grammarAccess.getFunctionCallAccess().getFunctionNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFunctionCallRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"functionName",
                    		lv_functionName_0_0, 
                    		"ID");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionCall"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleAnnexSubclause_in_entryRuleAnnexSubclause75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnexSubclause85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDmplSubclause_in_ruleAnnexSubclause131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDmplSubclause_in_entryRuleDmplSubclause165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDmplSubclause175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_ruleDmplSubclause230 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionCall277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunctionCall318 = new BitSet(new long[]{0x0000000000000002L});

}