package edu.cmu.sei.annex.dmpl.generator.actions;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.ui.actions.AbstractInstanceOrDeclarativeModelReadOnlyAction;

public class AnnexDMPLGeneratorAction extends AbstractInstanceOrDeclarativeModelReadOnlyAction
{
  public AnnexDMPLGeneratorAction() {}

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
    new AnnexDMPLGeneratorImpl(getShell()).generateDARTFiles(monitor,errManager,root,som);
  }

  protected String getActionName()
  {
    return "AnnexDMPLGenerator";
  }
}

/*********************************************************************/
//-- end of file
/*********************************************************************/
