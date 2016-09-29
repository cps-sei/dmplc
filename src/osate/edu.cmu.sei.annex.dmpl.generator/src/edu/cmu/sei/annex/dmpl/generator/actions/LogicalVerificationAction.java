package edu.cmu.sei.annex.dmpl.generator.actions;

import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.ui.actions.AbstractInstanceOrDeclarativeModelReadOnlyAction;

public class LogicalVerificationAction extends AbstractInstanceOrDeclarativeModelReadOnlyAction
{
  public LogicalVerificationAction() {}

  @Override
  protected void analyzeDeclarativeModel(IProgressMonitor monitor,
                                         AnalysisErrorReporterManager errManager,
                                         Element declarativeObject)
  {
    // TODO Auto-generated method stub
  }
  
  /*******************************************************************/
  //-- do logical verification
  /*******************************************************************/
  protected void verify(final String dirStr,final String instFile)
  {
    try {
      System.out.println("running mission file " + instFile + ".mission in dir " + dirStr);
      ProcessBuilder pb = new ProcessBuilder("dmpl-sim.sh", instFile + ".mission");
      pb.directory(new File(dirStr));
      Process p = pb.start();
      
      //-- open a dialog to terminate the mission
      getShell().getDisplay().syncExec(new Runnable() {
        @Override
        public void run() {
          MessageDialog.openInformation(getShell(), "StopMission", "Press OK to abort mission");
        }
      });
      p.destroy();
    } catch(Exception ex) {
      System.err.println("ERROR: could not execute mission " + instFile + ".mission !!");
    }
  }
  
  /*******************************************************************/
  //-- the top-level method called from OSATE
  /*******************************************************************/
  protected void analyzeInstanceModel(IProgressMonitor monitor,
                                      final AnalysisErrorReporterManager errManager,
                                      SystemInstance root, SystemOperationMode som)
  {
    System.out.println("VREP Simulation Executed!!");

    //-- generate DMPL and mission files
    AnnexDMPLGeneratorImpl gen = new AnnexDMPLGeneratorImpl(getShell());
    gen.generateDARTFiles(monitor,errManager,root,som);

    //-- do logical verification
    verify(gen.getDirStr(), gen.getInstFile());
  }

  protected String getActionName()
  {
    return "DMPLLogicalVerification";
  }
}

/*********************************************************************/
//-- end of file
/*********************************************************************/
