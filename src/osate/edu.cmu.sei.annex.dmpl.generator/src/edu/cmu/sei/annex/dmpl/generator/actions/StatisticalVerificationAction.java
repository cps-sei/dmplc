package edu.cmu.sei.annex.dmpl.generator.actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.xtext.serializer.ISerializer;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.ui.actions.AbstractInstanceOrDeclarativeModelReadOnlyAction;
import org.osate.xtext.aadl2.properties.util.AadlProject;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

import com.google.inject.Inject;
import com.google.inject.Injector;

import edu.cmu.sei.annex.dmpl.dmpl.DmplSubclause;
import edu.cmu.sei.annex.dmpl.dmpl.Program;
import edu.cmu.sei.annex.dmpl.ui.internal.DmplActivator;

public class StatisticalVerificationAction extends AbstractInstanceOrDeclarativeModelReadOnlyAction
{
  @Inject
  ISerializer serializer;
	
  public StatisticalVerificationAction()
  {
    Injector injector = DmplActivator.getInstance().getInjector(DmplActivator.EDU_CMU_SEI_ANNEX_DMPL_DMPL);
    injector.injectMembers(this);
  }

  @Override
  protected void analyzeDeclarativeModel(IProgressMonitor monitor,
                                         AnalysisErrorReporterManager errManager,
                                         Element declarativeObject)
  {
    // TODO Auto-generated method stub
  }
  
  /*******************************************************************/
  //-- the top-level method called from OSATE
  /*******************************************************************/
  protected void analyzeInstanceModel(IProgressMonitor monitor,
                                      final AnalysisErrorReporterManager errManager,
                                      SystemInstance root, SystemOperationMode som)
  {
    System.out.println("Statistical Verification Executed!!");

    //-- generate DMPL and .smc files
    AnnexDMPLGeneratorImpl gen = new AnnexDMPLGeneratorImpl(getShell());
    gen.generateDMPLFile(monitor,errManager,root,som);
    gen.generateSmcFile(monitor,errManager,root,som);
  }

  protected String getActionName()
  {
    return "DMPLStatisticalVerification";
  }
}

/*********************************************************************/
//-- end of file
/*********************************************************************/
