package edu.cmu.sei.annex.dmpl.serializer

import edu.cmu.sei.annex.dmpl.dmpl.DmplSubclause
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService
import org.osate.aadl2.Aadl2Package

class DmplTransientValueService extends DefaultTransientValueService {
	override isTransient(EObject owner, EStructuralFeature feature, int index) {
		(owner instanceof DmplSubclause && feature == Aadl2Package.eINSTANCE.namedElement_Name) || super.isTransient(owner, feature, index)
	}
}