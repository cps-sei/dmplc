package edu.cmu.sei.annex.dmpl.serializer

import com.google.inject.Inject
import edu.cmu.sei.annex.dmpl.dmpl.DmplSubclause
import edu.cmu.sei.annex.dmpl.services.DmplGrammarAccess
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.serializer.impl.Serializer

class DmplSerializer extends Serializer {
	@Inject DmplGrammarAccess grammarAccess
	
	override protected getContext(EObject semanticObject) {
		if (semanticObject instanceof DmplSubclause) {
			grammarAccess.dmplSubclauseRule
		} else {
			super.getContext(semanticObject)
		}
	}
}