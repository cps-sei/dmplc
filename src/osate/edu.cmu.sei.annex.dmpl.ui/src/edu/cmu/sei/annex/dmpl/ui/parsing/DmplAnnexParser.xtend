package edu.cmu.sei.annex.dmpl.ui.parsing

import antlr.RecognitionException
import com.google.inject.Inject
import edu.cmu.sei.annex.dmpl.parser.antlr.DmplParser
import edu.cmu.sei.annex.dmpl.services.DmplGrammarAccess
import org.eclipse.xtext.ParserRule
import org.osate.aadl2.AnnexSubclause
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter
import org.osate.annexsupport.AnnexParseUtil
import org.osate.annexsupport.DefaultAnnexParser

class DmplAnnexParser extends DefaultAnnexParser {
	val DmplParser parser
	val ParserRule subclauseRule
	
	@Inject
	new(DmplParser parser, DmplGrammarAccess grammarAccess) {
		this.parser = parser
		subclauseRule = grammarAccess.dmplSubclauseRule
	}
	
	override parseAnnexSubclause(String annexName, String source, String filename, int line, int column,
		ParseErrorReporter errReporter
	) throws RecognitionException {
		AnnexParseUtil.parse(parser, source, subclauseRule, filename, line, column, errReporter) as AnnexSubclause
	}
}