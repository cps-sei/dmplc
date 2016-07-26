package edu.cmu.sei.annex.dmpl.generator.actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
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
import org.osate.aadl2.impl.SystemImplementationImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
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

public class AnnexDMPLGeneratorAction extends AbstractInstanceOrDeclarativeModelReadOnlyAction
{
  @Inject
  ISerializer serializer;
	
  public AnnexDMPLGeneratorAction()
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

  String targetFileName = null;

  public void setTargetFileName(String f)
  {
    targetFileName = f;
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

  HashMap<Classifier, ArrayList<ComponentInstance>> node2roles =
    new HashMap<Classifier, ArrayList<ComponentInstance>>();

  // HashMap<Classifier, Classifier> overwrites = new HashMap<Classifier, Classifier>();

  protected void analyzeInstanceModel(IProgressMonitor monitor,
                                      final AnalysisErrorReporterManager errManager,
                                      SystemInstance root, SystemOperationMode som)
  {
    printed.clear();
    node2roles.clear();

    //-- create the directory where the generated files will be kept
    IPath dir = OsateResourceUtil.convertToIResource(root.eResource()).getLocation().removeLastSegments(2).append("DART");
    String dirStr = dir.toOSString();
    File dirFile = new File(dirStr);
    dirFile.mkdir();

    //-- get the name of the instance file without the extension
    String instFile = OsateResourceUtil.convertToIResource(root.eResource()).getLocation().removeFileExtension().lastSegment();
    
    //-- create DMPL file name
    final String targetFilename = dirStr + "/" + instFile + ".dmpl";
    if (targetFilename == null) {
      errManager.error(root, "ERROR: could not create DMPL file name");
      return;
    }

    //-- create mission file name
    final String missionFilename = dirStr + "/" + instFile + ".mission";
    if (missionFilename == null) {
      errManager.error(root, "ERROR: could not create mission file name");
      return;
    }
    
    //-- various filenames and other constants
    final String mapName = getStringPropertyValue(root, "DMPLProperties", "Map_Name");
    final long gridSize = getIntegerPropertyValue(root, "DMPLProperties", "Grid_Size");
    final String platform = getStringPropertyValue(root, "DMPLProperties", "Platform");
    final double expectLogPeriod = getRealPropertyValue(root, "DMPLProperties", "Expect_Log_Period");
    final double missionTime = getTimePropertyValue(root, "DMPLProperties", "Mission_Time", AadlProject.SEC_LITERAL);

    try {

      final PrintWriter pw = new PrintWriter(targetFilename);

      //-- visitor to create map from nodes to roles
      final ForAllElement visitSystems0 = new ForAllElement(errManager) {

          public void process(Element obj)
          {
            ComponentInstance ci = (ComponentInstance) obj;
            containNodes = false;
            Classifier sysClassifier = ci.getComponentClassifier();
            final ForAllElement visitProcesses1 = new ForAllElement(errManager) {
                public void process(Element obj) {
                  ComponentInstance process = (ComponentInstance) obj;
                  // Classifier processClassifier = process.getComponentClassifier();
                  Classifier extendedProcessClassifier = process.getComponentClassifier().getExtended();
                  if (extendedProcessClassifier != null) {
                    ArrayList<ComponentInstance> roles = node2roles.get(extendedProcessClassifier);
                    if (roles == null) {
                      roles = new ArrayList<ComponentInstance>();
                      node2roles.put(extendedProcessClassifier, roles);
                    }
                    if (!roles.contains(process))
                      roles.add(process);
                    containNodes = true;
                  }
                }
              };
            visitProcesses1.processPreOrderComponentInstance(ci, ComponentCategory.PROCESS);
            if (containNodes)
              systemClassifier = sysClassifier;
          }
        };

      //-- create the map from nodes to roles
      visitSystems0.processPreOrderComponentInstance(root, ComponentCategory.SYSTEM);

      //-- debug output. print map from nodes to roles
      for (Entry<Classifier, ArrayList<ComponentInstance>> roles : node2roles.entrySet()) {
        System.out.println("node: " + roles.getKey().getName());
        for (ComponentInstance ci : roles.getValue()) {
          System.out.println("\t role: " + ci.getName());
        }
      }

      // print the annex in the root type. this is usually the extern
      // thunk, constant definitions, and extern function declarations.
      Classifier rootClassifier = root.getComponentClassifier();

      // traverse first the "extended" hierarchy
      Program prg = this.getAnnexSubclauseProgram(rootClassifier);
      String sc = getAnnexSubclause(rootClassifier);
      while (rootClassifier != null && sc.length() == 0) {
        System.out.println("Extended: rootClassifier: " + rootClassifier);
        rootClassifier = rootClassifier.getExtended();
        if (rootClassifier != null) {
          prg = getAnnexSubclauseProgram(rootClassifier);
          sc = getAnnexSubclause(rootClassifier);
        }
      }
			
      // Warning! this may interfere with the sc search in the next if
      if (prg == null) {
        rootClassifier = root.getComponentClassifier();
        if (rootClassifier instanceof SystemImplementationImpl) {
          Realization rel = ((SystemImplementationImpl) rootClassifier).getOwnedRealization();
          System.out.println("root Realization: " + rel);
          if (rel != null) {
            ComponentType type = rel.getImplemented();
            while (type != null && prg == null) {
              System.out.println("Implemented: rootClassifier: " + type);
              prg = getAnnexSubclauseProgram(type);
              type = type.getExtended();
            }
          }
        }				
      }
			
      // if no annex yet traverse the "implemented" hierarchy
      //if (sc.length() == 0) {
      //rootClassifier = root.getComponentClassifier();
      //if (rootClassifier instanceof SystemImplementationImpl) {
      //Realization rel = ((SystemImplementationImpl) rootClassifier).getOwnedRealization();
      //System.out.println("root Realization: " + rel);
      //if (rel != null) {
      //ComponentType type = rel.getImplemented();
      //while (type != null && sc.length() == 0) {
      //System.out.println("Implemented: rootClassifier: " + type);
      //sc = getAnnexSubclause(type);
      //type = type.getExtended();
      //}
      //}
      //}
      //}

      if (prg!= null){
        String str = serializer.serialize(prg);
        pw.println(str.trim());//replaceAll("\\p{C}", " ").trim());
      }
			
      //if (sc.length() != 0) {
      //pw.println(sc);
      //}

      printed.clear();
      
      final ForAllElement visitSystems1 = new ForAllElement(errManager) {
          public void process(Element obj) {
            ComponentInstance ci = (ComponentInstance) obj;
            final ForAllElement visitProcesses1 = new ForAllElement(errManager) {
                public void process(Element obj) {
                  ComponentInstance process = (ComponentInstance) obj;
                  Classifier processClassifier = process.getComponentClassifier();
                  if (!printed.contains(processClassifier)) {
                    printed.add(processClassifier);
                    Classifier extendedProcessClassifier = process.getComponentClassifier().getExtended();
                    if (extendedProcessClassifier != null) {
                      if (!printed.contains(extendedProcessClassifier)) {
                        printed.add(extendedProcessClassifier);
                        //pw.println("node " + extendedProcessClassifier.getName().replace('.', '_')
                        //+ " {");
                        //pw.println(getAnnexSubclause(extendedProcessClassifier));
										
                        Program prg = getAnnexSubclauseProgram(extendedProcessClassifier);
                        if (prg == null){
                          //fall back to extended?
                          prg = getAnnexSubclauseProgram(processClassifier);
                        }
                        if (prg != null){
                          for (ProgramElement pelem : prg.getElements()){
                            if (pelem instanceof AttributableProgramElement){
                              AttributableProgramElement ae = (AttributableProgramElement) pelem;
                              if (ae.getElement() instanceof Node){
                                Node n = (Node)ae.getElement();
                                pw.println("node " +
                                           extendedProcessClassifier.getName().replace('.', '_') + "{");
                                for (NodeBodyElement nbe : n.getElements()){
                                  pw.print(serializer.serialize(nbe));
                                }
                              }
                            } else {
                              pw.print(serializer.serialize(pelem).trim());
                            }
                          }
                          pw.println(" ");
                        }
										
                        final ForAllElement visitThreads0 = new ForAllElement(errManager) {
                            public void process(Element obj) {
                              ComponentInstance thread = (ComponentInstance) obj;
                              double period = GetProperties.getPeriodinMS(thread);
                              ArrayList<String> directives = getDirectives(thread);
                              Classifier threadClassifier = thread.getComponentClassifier();
                              Classifier extendedThreadClassifier = threadClassifier.getExtended();
                              Program threadPrg = getAnnexSubclauseProgram(threadClassifier);
                              if (extendedThreadClassifier == null) {									   //-- print period				
                                if (period != 0) {
                                  pw.println("@Period(" + ((int) period) + ");");
                                }
                                
                                // print directives
                                if (threadPrg != null){
                                  for (ProgramElement pe: threadPrg.getElements()){
                                    if (pe instanceof AttributableProgramElement && pe instanceof ThreadDeclaration){
                                      AttributableProgramElement ape = (AttributableProgramElement)pe;
                                      for (Attr a:ape.getAttrs()){
                                        String name = a.getName();

                                        //-- skip period attributes
                                        if (name.equalsIgnoreCase("PERIOD")) continue;

                                        //-- empty parameter list
                                        if(a.getParams().isEmpty()) {
                                          pw.println("@" + name + ";");
                                          continue;
                                        }
                                        
                                        String params = "";
                                        String sep = "";
                                        for (Expr p:a.getParams()){
                                          params += sep+serializer.serialize(p);
                                          sep=", ";
                                        }
                                        pw.println("@" + name + "(" + params + ");");
                                      }
                                    }
                                  }
                                }
                                //for (String dir : directives) {
                                //pw.println(dir + ";");
                                //}
                                //pw.println("thread " + threadClassifier.getName() + "{");
                                //pw.println(getAnnexSubclause(threadClassifier));
                                if (threadPrg != null){
                                  for (ProgramElement pe:threadPrg.getElements()){
                                    if (pe instanceof ThreadDeclaration){
                                      String tstr="";
                                      ThreadDeclaration td = (ThreadDeclaration)pe;
                                      if (td.isOverride())
                                        tstr += "override ";
                                      if (td.isExtern())
                                        tstr +="extern ";
                                      if (td.isPure())
                                        tstr += "pure ";
                                      tstr+= "thread "+threadClassifier.getName() + " " +
                                        serializer.serialize(td.getFnBody()).trim();
                                      pw.print(tstr);
                                    } else {
                                      pw.print(serializer.serialize(pe).trim());
                                    }
                                  }
                                  pw.println(" ");
                                } else {
                                  pw.println("DEBUG: threadPrg == null");
                                }
                                //pw.println("}");
                              }
                            }
                          };
                        visitThreads0.processPreOrderComponentInstance(process,
                                                                       ComponentCategory.THREAD);

                        ArrayList<Classifier> rolesProcessed = new ArrayList<Classifier>();
                        ArrayList<ComponentInstance> roles = node2roles.get(extendedProcessClassifier);
                        for (ComponentInstance proc : roles) {
                          processClassifier = proc.getComponentClassifier();

                          // do not print more than one the classifier
                          if (rolesProcessed.contains(processClassifier))
                            continue;
                          rolesProcessed.add(processClassifier);

                          pw.println("role " + processClassifier.getName().replace('.', '_') + " {");
                          // not expecting a subclause here
                          //String sc = getAnnexSubclause(processClassifier);
                          //if (sc.length() != 0) {
                          //pw.println(sc);
                          //}
                          final ForAllElement visitThreads1 = new ForAllElement(errManager) {
                              public void process(Element obj) {
                                ComponentInstance thread = (ComponentInstance) obj;
                                Classifier threadClassifier = thread.getComponentClassifier();
                                if (!printed.contains(threadClassifier)) {
                                  Classifier extendedThreadClassifier = threadClassifier
                                    .getExtended();
                                  if (extendedThreadClassifier == null) {
                                    pw.println("thread " + threadClassifier.getName() + ";");
                                  } else {
                                    double period = GetProperties.getPeriodinMS(thread);
                                    if (period != 0) {
                                      pw.println("@Period(" + ((int) period) + ");");
                                    }
                                    Program threadPrg = getAnnexSubclauseProgram(threadClassifier);
                                    if (threadPrg == null){
                                      threadPrg = getAnnexSubclauseProgram(extendedThreadClassifier);
                                    }
                                    if (threadPrg != null){
                                      for (ProgramElement pe: threadPrg.getElements()){
                                        if (pe instanceof AttributableProgramElement){
                                          AttributableProgramElement ape = (AttributableProgramElement)pe;
                                          for (Attr a:ape.getAttrs()){
                                            String name = a.getName();

                                            //-- skip period attributes
                                            if (name.equalsIgnoreCase("PERIOD")) continue;

                                            //-- empty parameter list
                                            if(a.getParams().isEmpty()) {
                                              pw.println("@" + name + ";");
                                              continue;
                                            }
                                            
                                            String params = "";
                                            String sep = "";
                                            for (Expr p:a.getParams()){
                                              params += sep+serializer.serialize(p);
                                              sep=", ";
                                            }
                                            pw.println("@" + name + "(" + params + ");");
                                          }
                                        }
                                        if (pe instanceof ThreadDeclaration){
                                          String tstr="";
                                          ThreadDeclaration td = (ThreadDeclaration)pe;
                                          if (td.isOverride())
                                            tstr += "override ";
                                          if (td.isExtern())
                                            tstr +="extern ";
                                          if (td.isPure())
                                            tstr += "pure ";
                                          tstr+= "thread " + extendedThreadClassifier.getName() + " " +
                                            serializer.serialize(td.getFnBody()).trim();
                                          pw.print(tstr);
                                          pw.println(" ");
                                        } else {
                                          pw.print(serializer.serialize(pe).trim());
                                        }

                                      }
                                      pw.println(" ");
                                    }
                                    //ArrayList<String> directives = getDirectives(thread);
                                    //// print directives
                                    //for (String dir : directives) {
                                    //pw.println(dir + ";");
                                    //}
                                    //pw.println("override thread "
                                    //+ extendedThreadClassifier.getName() + "{");
                                    //pw.println(getAnnexSubclause(threadClassifier));
                                    //if (threadPrg != null){
                                    //for (ProgramElement pe:threadPrg.getElements()){
                                    //pw.print(serializer.serialize(pe).trim());
                                    //}
                                    //} else {
                                    //pw.println("DEBUG: threadPrg == null");
                                    //}
                                    //pw.println("}");
                                    printed.add(threadClassifier);
                                  }
                                }
                              }
                            };
                          visitThreads1.processPreOrderComponentInstance(proc,
                                                                         ComponentCategory.THREAD);
                          pw.println("}\n");
                        }
                        pw.println("}\n");
                      }
                    }
                  }
                }
              };
            visitProcesses1.processPreOrderComponentInstance(ci, ComponentCategory.PROCESS);

          }
        };
      visitSystems1.processPreOrderComponentInstance(root, ComponentCategory.SYSTEM);

      //-- printer for the mission file
      final PrintWriter missionWriter = new PrintWriter(missionFilename);

      // generate mission file
      missionWriter.println("#!/bin/bash");
      missionWriter.println("");
      missionWriter.println("DMPL=\"" + targetFilename + "\"");
      missionWriter.println("BIN=" + targetFilename.substring(0, targetFilename.indexOf(".")) + "");
      missionWriter.println("");
      missionWriter.println("OUTDIR=");
      missionWriter.println("MAPNAME=" + mapName);
      missionWriter.println("GRIDSIZE=" + gridSize);

      String roledesc = "";
      String nodesep = "";
      for (Entry<Classifier, ArrayList<ComponentInstance>> entry : node2roles.entrySet()) {
        String node = entry.getKey().getName();
        node = node.replace('.', '_');
        HashMap<Classifier, Integer> categoryCounter = new HashMap<Classifier, Integer>();
        for (ComponentInstance role : entry.getValue()) {
          Integer count = categoryCounter.get(role.getComponentClassifier());
          if (count == null) {
            count = new Integer(0);
            categoryCounter.put(role.getComponentClassifier(), count);
          }
          count = count + 1;
          categoryCounter.put(role.getComponentClassifier(), count);
        }
        for (Entry<Classifier, Integer> ccount : categoryCounter.entrySet()) {
          String rolename = ccount.getKey().getName();
          rolename = rolename.replace('.', '_');
          int count = ccount.getValue();
          roledesc += nodesep + node + ":" + rolename + ":" + count;
          nodesep = ":";
        }
      }

      missionWriter.println("ROLEDESC=" + roledesc);
      missionWriter.println("");
      missionWriter.println("PLATFORM=" + platform);
      missionWriter.println("EXPECT_LOG_PERIOD=" + expectLogPeriod);
      missionWriter.println("");
      missionWriter.println("MISSION_TIME=" + (long) missionTime);
      missionWriter.println("");
      missionWriter.println("");
      for (Entry<Classifier, ArrayList<ComponentInstance>> entry : node2roles.entrySet()) {
        String nodename = entry.getKey().getName();
        for (ComponentInstance ci : entry.getValue()) {
          ArrayList<String> vars = getStringPropertyValueList(ci, "DMPLProperties",
                                                              "Initial_Parameter_Values");
          String varstring = "";
          String varname = null;
          for (String var : vars) {
            if (varname == null) {
              varname = var;
            } else {
              varstring += "--var_" + varname + " " + var;
              varname = null;
            }
          }

          missionWriter.println("echo --node " + nodename + " --role "
                                + ci.getComponentClassifier().getName().replace(".", "_") +
                                " " + varstring);
        }
      }
      pw.close();
      missionWriter.close();

      //-- refresh so that the DART folder and its contents become visible
      IResource ires = OsateResourceUtil.convertToIResource(root.eResource());
      try {
        ires.getParent().getParent().refreshLocal(IResource.DEPTH_INFINITE, monitor);
      } catch (CoreException e) {
        System.err.println("ERROR: Could not refresh project after creating DART folder");
      }
      
      System.out.println("Annex DMPL Generator Finished");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  protected String getActionName()
  {
    return "AnnexDMPLGenerator";
  }
}

/*********************************************************************/
//-- end of file
/*********************************************************************/
