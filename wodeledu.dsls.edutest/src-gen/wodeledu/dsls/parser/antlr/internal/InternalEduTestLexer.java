package wodeledu.dsls.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEduTestLexer extends Lexer {
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
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
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__44=44;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators

    public InternalEduTestLexer() {;} 
    public InternalEduTestLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalEduTestLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalEduTest.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:11:7: ( 'AlternativeResponse' )
            // InternalEduTest.g:11:9: 'AlternativeResponse'
            {
            match("AlternativeResponse"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:12:7: ( ',' )
            // InternalEduTest.g:12:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:13:7: ( '{' )
            // InternalEduTest.g:13:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:14:7: ( '}' )
            // InternalEduTest.g:14:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:15:7: ( 'MultiChoiceDiagram' )
            // InternalEduTest.g:15:9: 'MultiChoiceDiagram'
            {
            match("MultiChoiceDiagram"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:16:7: ( 'MultiChoiceEmendation' )
            // InternalEduTest.g:16:9: 'MultiChoiceEmendation'
            {
            match("MultiChoiceEmendation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:17:7: ( 'MatchPairs' )
            // InternalEduTest.g:17:9: 'MatchPairs'
            {
            match("MatchPairs"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:18:7: ( 'MissingWords' )
            // InternalEduTest.g:18:9: 'MissingWords'
            {
            match("MissingWords"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:19:7: ( 'navigation' )
            // InternalEduTest.g:19:9: 'navigation'
            {
            match("navigation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:20:7: ( '=' )
            // InternalEduTest.g:20:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:21:7: ( 'retry' )
            // InternalEduTest.g:21:9: 'retry'
            {
            match("retry"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:22:7: ( 'yes' )
            // InternalEduTest.g:22:9: 'yes'
            {
            match("yes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:23:7: ( 'no' )
            // InternalEduTest.g:23:9: 'no'
            {
            match("no"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:24:7: ( 'weighted' )
            // InternalEduTest.g:24:9: 'weighted'
            {
            match("weighted"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:25:7: ( 'penalty' )
            // InternalEduTest.g:25:9: 'penalty'
            {
            match("penalty"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:26:7: ( 'order' )
            // InternalEduTest.g:26:9: 'order'
            {
            match("order"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:27:7: ( 'mode' )
            // InternalEduTest.g:27:9: 'mode'
            {
            match("mode"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:28:7: ( 'description' )
            // InternalEduTest.g:28:9: 'description'
            {
            match("description"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:29:7: ( 'for' )
            // InternalEduTest.g:29:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:30:7: ( '%text' )
            // InternalEduTest.g:30:9: '%text'
            {
            match("%text"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:31:7: ( '(' )
            // InternalEduTest.g:31:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:32:7: ( ')' )
            // InternalEduTest.g:32:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:33:7: ( '-' )
            // InternalEduTest.g:33:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:34:7: ( '.' )
            // InternalEduTest.g:34:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:35:7: ( 'E' )
            // InternalEduTest.g:35:9: 'E'
            {
            match('E'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:36:7: ( 'e' )
            // InternalEduTest.g:36:9: 'e'
            {
            match('e'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:37:7: ( 'fixed' )
            // InternalEduTest.g:37:9: 'fixed'
            {
            match("fixed"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:38:7: ( 'random' )
            // InternalEduTest.g:38:9: 'random'
            {
            match("random"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:39:7: ( 'options-ascending' )
            // InternalEduTest.g:39:9: 'options-ascending'
            {
            match("options-ascending"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:40:7: ( 'options-descending' )
            // InternalEduTest.g:40:9: 'options-descending'
            {
            match("options-descending"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:41:7: ( 'radiobutton' )
            // InternalEduTest.g:41:9: 'radiobutton'
            {
            match("radiobutton"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:42:7: ( 'checkbox' )
            // InternalEduTest.g:42:9: 'checkbox'
            {
            match("checkbox"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:43:7: ( 'free' )
            // InternalEduTest.g:43:9: 'free'
            {
            match("free"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:44:7: ( 'locked' )
            // InternalEduTest.g:44:9: 'locked'
            {
            match("locked"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:1327:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalEduTest.g:1327:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalEduTest.g:1327:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalEduTest.g:1327:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalEduTest.g:1327:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalEduTest.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:1329:10: ( ( '0' .. '9' )+ )
            // InternalEduTest.g:1329:12: ( '0' .. '9' )+
            {
            // InternalEduTest.g:1329:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalEduTest.g:1329:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:1331:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalEduTest.g:1331:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalEduTest.g:1331:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalEduTest.g:1331:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalEduTest.g:1331:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalEduTest.g:1331:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalEduTest.g:1331:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalEduTest.g:1331:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalEduTest.g:1331:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalEduTest.g:1331:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalEduTest.g:1331:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:1333:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalEduTest.g:1333:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalEduTest.g:1333:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalEduTest.g:1333:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:1335:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalEduTest.g:1335:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalEduTest.g:1335:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalEduTest.g:1335:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalEduTest.g:1335:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalEduTest.g:1335:41: ( '\\r' )? '\\n'
                    {
                    // InternalEduTest.g:1335:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalEduTest.g:1335:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:1337:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalEduTest.g:1337:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalEduTest.g:1337:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalEduTest.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalEduTest.g:1339:16: ( . )
            // InternalEduTest.g:1339:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalEduTest.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=41;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalEduTest.g:1:10: T__11
                {
                mT__11(); 

                }
                break;
            case 2 :
                // InternalEduTest.g:1:16: T__12
                {
                mT__12(); 

                }
                break;
            case 3 :
                // InternalEduTest.g:1:22: T__13
                {
                mT__13(); 

                }
                break;
            case 4 :
                // InternalEduTest.g:1:28: T__14
                {
                mT__14(); 

                }
                break;
            case 5 :
                // InternalEduTest.g:1:34: T__15
                {
                mT__15(); 

                }
                break;
            case 6 :
                // InternalEduTest.g:1:40: T__16
                {
                mT__16(); 

                }
                break;
            case 7 :
                // InternalEduTest.g:1:46: T__17
                {
                mT__17(); 

                }
                break;
            case 8 :
                // InternalEduTest.g:1:52: T__18
                {
                mT__18(); 

                }
                break;
            case 9 :
                // InternalEduTest.g:1:58: T__19
                {
                mT__19(); 

                }
                break;
            case 10 :
                // InternalEduTest.g:1:64: T__20
                {
                mT__20(); 

                }
                break;
            case 11 :
                // InternalEduTest.g:1:70: T__21
                {
                mT__21(); 

                }
                break;
            case 12 :
                // InternalEduTest.g:1:76: T__22
                {
                mT__22(); 

                }
                break;
            case 13 :
                // InternalEduTest.g:1:82: T__23
                {
                mT__23(); 

                }
                break;
            case 14 :
                // InternalEduTest.g:1:88: T__24
                {
                mT__24(); 

                }
                break;
            case 15 :
                // InternalEduTest.g:1:94: T__25
                {
                mT__25(); 

                }
                break;
            case 16 :
                // InternalEduTest.g:1:100: T__26
                {
                mT__26(); 

                }
                break;
            case 17 :
                // InternalEduTest.g:1:106: T__27
                {
                mT__27(); 

                }
                break;
            case 18 :
                // InternalEduTest.g:1:112: T__28
                {
                mT__28(); 

                }
                break;
            case 19 :
                // InternalEduTest.g:1:118: T__29
                {
                mT__29(); 

                }
                break;
            case 20 :
                // InternalEduTest.g:1:124: T__30
                {
                mT__30(); 

                }
                break;
            case 21 :
                // InternalEduTest.g:1:130: T__31
                {
                mT__31(); 

                }
                break;
            case 22 :
                // InternalEduTest.g:1:136: T__32
                {
                mT__32(); 

                }
                break;
            case 23 :
                // InternalEduTest.g:1:142: T__33
                {
                mT__33(); 

                }
                break;
            case 24 :
                // InternalEduTest.g:1:148: T__34
                {
                mT__34(); 

                }
                break;
            case 25 :
                // InternalEduTest.g:1:154: T__35
                {
                mT__35(); 

                }
                break;
            case 26 :
                // InternalEduTest.g:1:160: T__36
                {
                mT__36(); 

                }
                break;
            case 27 :
                // InternalEduTest.g:1:166: T__37
                {
                mT__37(); 

                }
                break;
            case 28 :
                // InternalEduTest.g:1:172: T__38
                {
                mT__38(); 

                }
                break;
            case 29 :
                // InternalEduTest.g:1:178: T__39
                {
                mT__39(); 

                }
                break;
            case 30 :
                // InternalEduTest.g:1:184: T__40
                {
                mT__40(); 

                }
                break;
            case 31 :
                // InternalEduTest.g:1:190: T__41
                {
                mT__41(); 

                }
                break;
            case 32 :
                // InternalEduTest.g:1:196: T__42
                {
                mT__42(); 

                }
                break;
            case 33 :
                // InternalEduTest.g:1:202: T__43
                {
                mT__43(); 

                }
                break;
            case 34 :
                // InternalEduTest.g:1:208: T__44
                {
                mT__44(); 

                }
                break;
            case 35 :
                // InternalEduTest.g:1:214: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 36 :
                // InternalEduTest.g:1:222: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 37 :
                // InternalEduTest.g:1:231: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 38 :
                // InternalEduTest.g:1:243: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 39 :
                // InternalEduTest.g:1:259: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 40 :
                // InternalEduTest.g:1:275: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 41 :
                // InternalEduTest.g:1:283: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\42\3\uffff\2\42\1\uffff\10\42\1\40\4\uffff\1\75\1\76\2\42\1\40\2\uffff\3\40\2\uffff\1\42\4\uffff\4\42\1\113\1\uffff\14\42\7\uffff\2\42\5\uffff\5\42\1\uffff\3\42\1\143\6\42\1\152\14\42\1\uffff\4\42\1\173\1\42\1\uffff\1\42\1\176\7\42\1\u0086\4\42\1\u008b\1\42\1\uffff\1\42\1\u008e\1\uffff\7\42\1\uffff\1\u0096\3\42\1\uffff\2\42\1\uffff\1\42\1\u009d\5\42\1\uffff\2\42\1\u00a5\3\42\1\uffff\6\42\1\u00af\2\uffff\1\42\1\u00b3\6\42\3\uffff\1\42\1\uffff\2\42\1\u00bd\1\42\1\u00bf\4\42\1\uffff\1\42\1\uffff\1\u00c6\1\u00c7\3\42\1\u00cb\2\uffff\3\42\1\uffff\15\42\1\u00dc\1\42\1\u00de\1\uffff\1\42\1\uffff\1\42\1\u00e1\1\uffff";
    static final String DFA12_eofS =
        "\u00e2\uffff";
    static final String DFA12_minS =
        "\1\0\1\154\3\uffff\2\141\1\uffff\1\141\3\145\1\160\1\157\1\145\1\151\1\164\4\uffff\2\60\1\150\1\157\1\101\2\uffff\2\0\1\52\2\uffff\1\164\4\uffff\1\154\1\164\1\163\1\166\1\60\1\uffff\1\164\1\144\1\163\1\151\1\156\1\144\1\164\1\144\1\163\1\162\1\170\1\145\7\uffff\1\145\1\143\5\uffff\1\145\1\164\1\143\1\163\1\151\1\uffff\1\162\1\144\1\151\1\60\1\147\1\141\1\145\1\151\1\145\1\143\1\60\2\145\1\143\1\153\1\162\1\151\1\150\1\151\1\147\1\171\2\157\1\uffff\1\150\1\154\1\162\1\157\1\60\1\162\1\uffff\1\144\1\60\1\153\1\145\1\156\1\103\1\120\1\156\1\141\1\60\1\155\1\142\2\164\1\60\1\156\1\uffff\1\151\1\60\1\uffff\1\142\1\144\1\141\1\150\1\141\1\147\1\164\1\uffff\1\60\1\165\1\145\1\171\1\uffff\1\163\1\160\1\uffff\1\157\1\60\1\164\1\157\1\151\1\127\1\151\1\uffff\1\164\1\144\1\60\1\55\1\164\1\170\1\uffff\2\151\1\162\2\157\1\164\1\60\1\uffff\1\141\1\151\1\60\1\166\1\143\1\163\1\162\1\156\1\157\3\uffff\1\157\1\uffff\2\145\1\60\1\144\1\60\2\156\1\122\1\104\1\uffff\1\163\1\uffff\2\60\1\145\1\151\1\155\1\60\2\uffff\1\163\1\141\1\145\1\uffff\1\160\1\147\1\156\1\157\1\162\1\144\1\156\2\141\1\163\1\155\1\164\1\145\1\60\1\151\1\60\1\uffff\1\157\1\uffff\1\156\1\60\1\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\154\3\uffff\1\165\1\157\1\uffff\4\145\1\162\1\157\1\145\1\162\1\164\4\uffff\2\172\1\150\1\157\1\172\2\uffff\2\uffff\1\57\2\uffff\1\164\4\uffff\1\154\1\164\1\163\1\166\1\172\1\uffff\1\164\1\156\1\163\1\151\1\156\1\144\1\164\1\144\1\163\1\162\1\170\1\145\7\uffff\1\145\1\143\5\uffff\1\145\1\164\1\143\1\163\1\151\1\uffff\1\162\1\144\1\151\1\172\1\147\1\141\1\145\1\151\1\145\1\143\1\172\2\145\1\143\1\153\1\162\1\151\1\150\1\151\1\147\1\171\2\157\1\uffff\1\150\1\154\1\162\1\157\1\172\1\162\1\uffff\1\144\1\172\1\153\1\145\1\156\1\103\1\120\1\156\1\141\1\172\1\155\1\142\2\164\1\172\1\156\1\uffff\1\151\1\172\1\uffff\1\142\1\144\1\141\1\150\1\141\1\147\1\164\1\uffff\1\172\1\165\1\145\1\171\1\uffff\1\163\1\160\1\uffff\1\157\1\172\1\164\1\157\1\151\1\127\1\151\1\uffff\1\164\1\144\1\172\1\55\1\164\1\170\1\uffff\2\151\1\162\2\157\1\164\1\172\1\uffff\1\144\1\151\1\172\1\166\1\143\1\163\1\162\1\156\1\157\3\uffff\1\157\1\uffff\2\145\1\172\1\144\1\172\2\156\1\122\1\105\1\uffff\1\163\1\uffff\2\172\1\145\1\151\1\155\1\172\2\uffff\1\163\1\141\1\145\1\uffff\1\160\1\147\1\156\1\157\1\162\1\144\1\156\2\141\1\163\1\155\1\164\1\145\1\172\1\151\1\172\1\uffff\1\157\1\uffff\1\156\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\1\3\1\4\2\uffff\1\12\11\uffff\1\25\1\26\1\27\1\30\5\uffff\1\43\1\44\3\uffff\1\50\1\51\1\uffff\1\43\1\2\1\3\1\4\5\uffff\1\12\14\uffff\1\24\1\25\1\26\1\27\1\30\1\31\1\32\2\uffff\1\44\1\45\1\46\1\47\1\50\5\uffff\1\15\27\uffff\1\14\6\uffff\1\23\20\uffff\1\21\2\uffff\1\41\7\uffff\1\13\4\uffff\1\20\2\uffff\1\33\7\uffff\1\34\6\uffff\1\42\7\uffff\1\17\11\uffff\1\16\1\35\1\36\1\uffff\1\40\11\uffff\1\7\1\uffff\1\11\6\uffff\1\37\1\22\3\uffff\1\10\20\uffff\1\5\1\uffff\1\1\2\uffff\1\6";
    static final String DFA12_specialS =
        "\1\0\33\uffff\1\2\1\1\u00c4\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\40\2\37\2\40\1\37\22\40\1\37\1\40\1\34\2\40\1\20\1\40\1\35\1\21\1\22\2\40\1\2\1\23\1\24\1\36\12\33\3\40\1\7\3\40\1\1\3\32\1\25\7\32\1\5\15\32\3\40\1\31\1\32\1\40\2\32\1\27\1\16\1\26\1\17\5\32\1\30\1\15\1\6\1\14\1\13\1\32\1\10\4\32\1\12\1\32\1\11\1\32\1\3\1\40\1\4\uff82\40",
            "\1\41",
            "",
            "",
            "",
            "\1\47\7\uffff\1\50\13\uffff\1\46",
            "\1\51\15\uffff\1\52",
            "",
            "\1\55\3\uffff\1\54",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\62\1\uffff\1\61",
            "\1\63",
            "\1\64",
            "\1\66\5\uffff\1\65\2\uffff\1\67",
            "\1\70",
            "",
            "",
            "",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\77",
            "\1\100",
            "\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "",
            "\0\102",
            "\0\102",
            "\1\103\4\uffff\1\104",
            "",
            "",
            "\1\106",
            "",
            "",
            "",
            "",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\114",
            "\1\116\11\uffff\1\115",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\131",
            "\1\132",
            "",
            "",
            "",
            "",
            "",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "",
            "\1\140",
            "\1\141",
            "\1\142",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\174",
            "",
            "\1\175",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u008c",
            "",
            "\1\u008d",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "",
            "\1\u009a",
            "\1\u009b",
            "",
            "\1\u009c",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "",
            "\1\u00a3",
            "\1\u00a4",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\u00b0\2\uffff\1\u00b1",
            "\1\u00b2",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "",
            "",
            "",
            "\1\u00ba",
            "",
            "\1\u00bb",
            "\1\u00bc",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00be",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3\1\u00c4",
            "",
            "\1\u00c5",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00dd",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\u00df",
            "",
            "\1\u00e0",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='A') ) {s = 1;}

                        else if ( (LA12_0==',') ) {s = 2;}

                        else if ( (LA12_0=='{') ) {s = 3;}

                        else if ( (LA12_0=='}') ) {s = 4;}

                        else if ( (LA12_0=='M') ) {s = 5;}

                        else if ( (LA12_0=='n') ) {s = 6;}

                        else if ( (LA12_0=='=') ) {s = 7;}

                        else if ( (LA12_0=='r') ) {s = 8;}

                        else if ( (LA12_0=='y') ) {s = 9;}

                        else if ( (LA12_0=='w') ) {s = 10;}

                        else if ( (LA12_0=='p') ) {s = 11;}

                        else if ( (LA12_0=='o') ) {s = 12;}

                        else if ( (LA12_0=='m') ) {s = 13;}

                        else if ( (LA12_0=='d') ) {s = 14;}

                        else if ( (LA12_0=='f') ) {s = 15;}

                        else if ( (LA12_0=='%') ) {s = 16;}

                        else if ( (LA12_0=='(') ) {s = 17;}

                        else if ( (LA12_0==')') ) {s = 18;}

                        else if ( (LA12_0=='-') ) {s = 19;}

                        else if ( (LA12_0=='.') ) {s = 20;}

                        else if ( (LA12_0=='E') ) {s = 21;}

                        else if ( (LA12_0=='e') ) {s = 22;}

                        else if ( (LA12_0=='c') ) {s = 23;}

                        else if ( (LA12_0=='l') ) {s = 24;}

                        else if ( (LA12_0=='^') ) {s = 25;}

                        else if ( ((LA12_0>='B' && LA12_0<='D')||(LA12_0>='F' && LA12_0<='L')||(LA12_0>='N' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='b')||(LA12_0>='g' && LA12_0<='k')||LA12_0=='q'||(LA12_0>='s' && LA12_0<='v')||LA12_0=='x'||LA12_0=='z') ) {s = 26;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 27;}

                        else if ( (LA12_0=='\"') ) {s = 28;}

                        else if ( (LA12_0=='\'') ) {s = 29;}

                        else if ( (LA12_0=='/') ) {s = 30;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 31;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='$')||LA12_0=='&'||(LA12_0>='*' && LA12_0<='+')||(LA12_0>=':' && LA12_0<='<')||(LA12_0>='>' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||LA12_0=='|'||(LA12_0>='~' && LA12_0<='\uFFFF')) ) {s = 32;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_29 = input.LA(1);

                        s = -1;
                        if ( ((LA12_29>='\u0000' && LA12_29<='\uFFFF')) ) {s = 66;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_28 = input.LA(1);

                        s = -1;
                        if ( ((LA12_28>='\u0000' && LA12_28<='\uFFFF')) ) {s = 66;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}