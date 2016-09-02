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
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.xtext.serializer.ISerializer;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.Realization;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.impl.SystemImplementationImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.impl.ComponentInstanceImpl;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ui.actions.AbstractInstanceOrDeclarativeModelReadOnlyAction;
import org.osate.xtext.aadl2.properties.util.AadlProject;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

import com.google.inject.Inject;
import com.google.inject.Injector;

import edu.cmu.sei.annex.dmpl.dmpl.Attr;
import edu.cmu.sei.annex.dmpl.dmpl.AttributableProgramElement;
import edu.cmu.sei.annex.dmpl.dmpl.DmplSubclause;
import edu.cmu.sei.annex.dmpl.dmpl.Expr;
import edu.cmu.sei.annex.dmpl.dmpl.Node;
import edu.cmu.sei.annex.dmpl.dmpl.NodeBodyElement;
import edu.cmu.sei.annex.dmpl.dmpl.Program;
import edu.cmu.sei.annex.dmpl.dmpl.ProgramElement;
import edu.cmu.sei.annex.dmpl.dmpl.ThreadDeclaration;
import edu.cmu.sei.annex.dmpl.ui.internal.DmplActivator;

public class LogicalVerificationAction extends AbstractInstanceOrDeclarativeModelReadOnlyAction
{
  @Inject
  ISerializer serializer;
	
  public LogicalVerificationAction()
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

  //-- strip the annex markers, \n and \r characters from the
  //-- beginning and end of a string.
  protected String trimSource(String source)
  {
    source = source.substring(source.indexOf("{**") + "{**".length());
    source = source.substring(0, source.lastIndexOf("**}"));
    source = source.trim();
    while (source.charAt(0) == '\n' || source.charAt(0) == '\r') {
      source = source.substring(1);
    }
    if (source.length() > 0) {
      while (source.charAt(source.length() - 1) == '\n' || source.charAt(source.length() - 1) == '\r') {
        source = source.substring(0, source.length() - 2);
      }
    }
    return source;
  }

  protected Program getAnnexSubclauseProgram(Classifier classifier)
  {
    Program program=null;
    AnnexSubclause othersc=null;
    DmplSubclause subclause=null;
    List<AnnexSubclause> subcs = classifier.getOwnedAnnexSubclauses();
    for (AnnexSubclause sc : subcs) {
      // String subcname = sc.getName();
      //if (subcname.equalsIgnoreCase("DMPL")) {
      DefaultAnnexSubclause dsc = (DefaultAnnexSubclause) sc;
      if (dsc.getParsedAnnexSubclause() instanceof DmplSubclause){
        subclause = (DmplSubclause) dsc.getParsedAnnexSubclause();
        program = subclause.getProgram();
        break; // assume only one subclause per classifier
      } else {
        othersc=sc;
      }
    }
		
    if (program == null && othersc != null){
      System.out.println("WARNING:  no DMPL subclause for Classifier(" +
                         classifier.getName() +
                         ") but found other "+ othersc +
                         " and dmplsubclause is "+ subclause);
    }
		
    return program;
  }
	
  protected String getAnnexSubclause(Classifier classifier)
  {
    String str = "";

    List<AnnexSubclause> subcs = classifier.getOwnedAnnexSubclauses();
    for (AnnexSubclause sc : subcs) {
      String subcname = sc.getName();
      if (subcname.equalsIgnoreCase("DMPL")) {
        DefaultAnnexSubclause dsc = (DefaultAnnexSubclause) sc;
        String source = dsc.getSourceText();
        source = trimSource(source);
        str += source;
      }
    }
    return str;
  }

  //-- return the list of DMPL directives associated with a component,
  //-- e.g., @period associated with a thread
  ArrayList<String> getDirectives(ComponentInstance ci)
  {
    ArrayList<String> dirs = new ArrayList<String>();
    Property property = GetProperties.lookupPropertyDefinition(ci, "DMPLProperties", "Directives");
    List<? extends PropertyExpression> propertyValues = ci.getPropertyValueList(property);
    for (PropertyExpression propertyExpression : propertyValues) {
      dirs.add(((StringLiteral) propertyExpression).getValue());
    }
    return dirs;
  }

  ArrayList<String> getStringPropertyValueList(ComponentInstance ci, String propSet, String propName)
  {
    ArrayList<String> dirs = new ArrayList<String>();
    Property property = GetProperties.lookupPropertyDefinition(ci, propSet, propName);
    List<? extends PropertyExpression> propertyValues = ci.getPropertyValueList(property);
    for (PropertyExpression propertyExpression : propertyValues) {
      dirs.add(((StringLiteral) propertyExpression).getValue());
    }
    return dirs;
  }

  protected String getAnnexSubclause(ComponentInstance ci)
  {
    String str = "";
    // str = "Component Name(" + ci.getName() + ")\n";
    ComponentClassifier cc = ci.getComponentClassifier();
    List<AnnexSubclause> subcs = cc.getOwnedAnnexSubclauses();
    for (AnnexSubclause sc : subcs) {
      String subcname = sc.getName();
      if (subcname.equalsIgnoreCase("DMPL")) {
        DefaultAnnexSubclause dsc = (DefaultAnnexSubclause) sc;
        String source = dsc.getSourceText();
        source = trimSource(source);
        str += source;
      }
    }
    return str;
  }

  public long getIntegerPropertyValue(ComponentInstance ci, String propSet, String propName)
  {
    long val = 0;
    Property pd = GetProperties.lookupPropertyDefinition(ci, propSet, propName);
    if (pd != null) {
      val = PropertyUtils.getIntegerValue(ci, pd);
    }
    return val;
  }

  public double getRealPropertyValue(ComponentInstance ci, String propSet, String propName)
  {
    double val = 0;
    Property pd = GetProperties.lookupPropertyDefinition(ci, propSet, propName);
    if (pd != null) {
      val = PropertyUtils.getRealValue(ci, pd);
    }
    return val;
  }

  public double getTimePropertyValue(ComponentInstance ci, String propSet, String propName,
                                     String unitLiteral)
  {
    double val = 0;
    Property pd = GetProperties.lookupPropertyDefinition(ci, propSet, propName);
    if (pd != null) {
      val = PropertyUtils.getScaledNumberValue(ci, pd, GetProperties.findUnitLiteral(pd, unitLiteral), 0.0);
    }
    return val;
  }

  public String getStringPropertyValue(SystemInstance root, String propSet, String propName)
  {
    Property pd = GetProperties.lookupPropertyDefinition(root, propSet, propName);
    String fn = null;

    if (pd != null) {
      fn = PropertyUtils.getStringValue(root, pd);
      if (fn.length() == 0) {
        return null;
      }
    } else {
      return null;
    }
    return fn;
  }

  ArrayList<Classifier> printed = new ArrayList<Classifier>();
  String prefix, postfix;
  boolean containNodes;
  Classifier systemClassifier;

  //-- global map from nodes to roles in the instantiated system
  HashMap<Classifier, ArrayList<ComponentInstance>> node2roles =
    new HashMap<Classifier, ArrayList<ComponentInstance>>();

  // HashMap<Classifier, Classifier> overwrites = new HashMap<Classifier, Classifier>();
  

  /*******************************************************************/
  //-- generate mission file
  /*******************************************************************/
  protected void generateMissionFile(IProgressMonitor monitor,
                                     final AnalysisErrorReporterManager errManager,
                                     SystemInstance root, SystemOperationMode som,
                                     final String instFile,
                                     final String missionFilename)
  {
    try {      
      //-- printer for the mission file
      final PrintWriter missionWriter = new PrintWriter(missionFilename);

      // generate mission file
      missionWriter.println("#!/bin/bash");
      missionWriter.println("");
      missionWriter.println("DMPL=\"" + instFile + ".dmpl\"");
      missionWriter.println("BIN=\"" + instFile + "\"");
      missionWriter.println("");
      missionWriter.println("OUTDIR=" + getStringPropertyValue(root, "DMPLProperties", "Output_Dir"));
      missionWriter.println("MAPNAME=" + getStringPropertyValue(root, "DMPLProperties", "Map_Name"));
      missionWriter.println("REC_CAM_POS=\"" + getStringPropertyValue(root, "DMPLProperties", "Record_Camera_Pos") + "\"");
      missionWriter.println("GRIDSIZE=" + getIntegerPropertyValue(root, "DMPLProperties", "Grid_Size"));

      //-- create the role description, and the arguments to the nodes
      String roledesc = "";
      String nodesep = "";
      LinkedList<Entry<Classifier,Integer>> roleCounts = new LinkedList<Entry<Classifier,Integer>>();
      List<String> nodeArgs = new LinkedList<String>();
      for (Entry<Classifier, ArrayList<ComponentInstance>> entry : node2roles.entrySet()) {
        String node = entry.getKey().getName();
        node = node.replace('.', '_');
        
        for (ComponentInstance role : entry.getValue()) {
          //-- update role count
          Classifier cc = role.getComponentClassifier();
          if(roleCounts.isEmpty() || !roleCounts.peekLast().getKey().equals(cc)) {
            roleCounts.add(new AbstractMap.SimpleEntry<Classifier,Integer>(cc,1));
          } else {
            Entry<Classifier,Integer> e = roleCounts.removeLast();
            e.setValue(e.getValue()+1);
            roleCounts.addLast(e);
          }
          
          //-- generate the node argument
          ArrayList<String> vars = getStringPropertyValueList(role, "DMPLProperties",
              "Initial_Parameter_Values");
          String varstring = "";
          String varname = null;
          for (String var : vars) {
            if (varname == null) {
              varname = var;
            } else {
              varstring += " --var_" + varname + " " + var;
              varname = null;
            }
          }
          nodeArgs.add(varstring);
        }
        
        for (Entry<Classifier, Integer> ccount : roleCounts) {
          String rolename = ccount.getKey().getName();
          rolename = rolename.replace('.', '_');
          int count = ccount.getValue();
          roledesc += nodesep + node + ":" + rolename + ":" + count;
          nodesep = ":";
        }
      }

      missionWriter.println("ROLEDESC=" + roledesc);
      missionWriter.println("");
      missionWriter.println("PLATFORM=" + getStringPropertyValue(root, "DMPLProperties", "Platform"));
      missionWriter.println("EXPECT_LOG_PERIOD=" +
                            getRealPropertyValue(root, "DMPLProperties", "Expect_Log_Period"));
      missionWriter.println("");
      missionWriter.println("MISSION_TIME=" +
                            (long) getTimePropertyValue(root, "DMPLProperties", "Mission_Time",
                                                        AadlProject.SEC_LITERAL));
      missionWriter.println("");
      missionWriter.println("");

      //-- print the node arguments
      int nodeId = 0;
      for(String na : nodeArgs) {
        missionWriter.println("ARGS_" + nodeId + "=\"" + na + "\"");
        ++nodeId;
      }

      //-- close printer for mission file
      missionWriter.close();

      System.out.println("Annex Mission Generator Finished ...");
    } catch (FileNotFoundException ex) {
      System.err.println("ERROR: could not open mission file " + missionFilename + "!!");
    }
  }
  
  /*******************************************************************/
  //-- execute a mission file
  /*******************************************************************/
  protected void executeMission(final String dirStr,final String instFile)
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
    System.out.println("Logical Verification Executed!!");
  }

  protected String getActionName()
  {
    return "AnnexDMPLGenerator";
  }
}

/*********************************************************************/
//-- end of file
/*********************************************************************/
