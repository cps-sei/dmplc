package edu.cmu.sei.annex.dmpl.ui.parsing

import com.google.inject.Inject
import org.eclipse.xtext.serializer.ISerializer
import org.osate.aadl2.AnnexSubclause
import org.osate.annexsupport.DefaultAnnexUnparser

class DmplAnnexUnparser extends DefaultAnnexUnparser {
	val ISerializer serializer
	
	@Inject
	new(ISerializer serializer) {
		this.serializer = serializer
	}
	
	override unparseAnnexSubclause(AnnexSubclause subclause, String indent) {
		serializer.serialize(subclause)
	}
}