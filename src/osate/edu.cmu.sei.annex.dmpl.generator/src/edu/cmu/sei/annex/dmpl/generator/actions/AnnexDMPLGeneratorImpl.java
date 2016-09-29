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

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Shell;
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
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
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

public class AnnexDMPLGeneratorImpl
{
  @Inject
  ISerializer serializer;

  //-- the shell
  private Shell shell = null;

  //-- getter for shell
  Shell getShell() { return shell; }
  
  public AnnexDMPLGeneratorImpl(Shell _shell)
  {
    shell = _shell;
    Injector injector = DmplActivator.getInstance().getInjector(DmplActivator.EDU_CMU_SEI_ANNEX_DMPL_DMPL);
    injector.injectMembers(this);
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
  /*
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
  */
  
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
  
  protected String getThreadSubannexContainingClassifierName(ComponentInstance thread){
	  String str="";
	  Program prg=null;
	  Classifier classifier = thread.getComponentClassifier();
      if (classifier instanceof ThreadImplementation){
    	  Realization rel = ((ThreadImplementation)classifier).getOwnedRealization();
    	  ComponentType type = rel.getImplemented();
    	  while (type != null && prg == null) {
    		  prg = getAnnexSubclauseProgram(type);
    		  str = type.getName();
    		  type = type.getExtended();
    	  }
      }
      
      // if we could not find the subclause in the implementations try the types
      if (prg==null){
    	  while (classifier != null && prg == null){
    		  prg = getAnnexSubclauseProgram(classifier);
    		  str = classifier.getName();
    		  classifier = classifier.getExtended();
    	  }
      }
	  
	  return str;
  }
  
  protected Program getThreadSubannexProgram(ComponentInstance thread){
	  Program prg=null;
	  
	  // First try to get the program from the implementation hierarchy
	  Classifier classifier = thread.getComponentClassifier();
      if (classifier instanceof ThreadImplementation){
    	  Realization rel = ((ThreadImplementation)classifier).getOwnedRealization();
    	  ComponentType type = rel.getImplemented();
    	  while (type != null && prg == null) {
    		  prg = getAnnexSubclauseProgram(type);
    		  type = type.getExtended();
    	  }
      }
      
      // if we could not find the subclause in the implementations try the types
      if (prg==null){
    	  while (classifier != null && prg == null){
    		  prg = getAnnexSubclauseProgram(classifier);
    		  classifier = classifier.getExtended();
    	  }
      }

	  return prg;
  }

  /*******************************************************************/
  //-- generate DMPL file
  /*******************************************************************/
  protected void generateDmplFile(IProgressMonitor monitor,
                                  final AnalysisErrorReporterManager errManager,
                                  SystemInstance root, SystemOperationMode som,
                                  final String dmplFilename)
  {
    //-- clear global data structures
    printed.clear();
    node2roles.clear();

    try {
      //-- open writer to DMPL file
      final PrintWriter pw = new PrintWriter(dmplFilename);
    
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
        str = "    " + str.trim();
        pw.println("    //----------------------------------------------------------------------");
        pw.println("    //-- begin external stuff");
        pw.println("    //----------------------------------------------------------------------");
        pw.println(str);//replaceAll("\\p{C}", " ").trim());
        pw.println("    //----------------------------------------------------------------------");
        pw.println("    //-- end external stuff");
        pw.println("    //----------------------------------------------------------------------");
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
                                pw.println("    node " +
                                           extendedProcessClassifier.getName().replace('.', '_') + " {");
                                for (NodeBodyElement nbe : n.getElements()){
                                  pw.print(serializer.serialize(nbe));
                                }
                              }
                            } else {
                              pw.print(serializer.serialize(pelem));
                            }
                          }
                          pw.println(" ");
                        }
										
                        final ForAllElement visitThreads0 = new ForAllElement(errManager) {
                            public void process(Element obj) {
                              ComponentInstance thread = (ComponentInstance) obj;
                              double period = GetProperties.getPeriodinMicroSec(thread);
                              Classifier threadClassifier = thread.getComponentClassifier();
                              Classifier extendedThreadClassifier = threadClassifier.getExtended();
                              Program threadPrg = getThreadSubannexProgram(thread);//getThreadAnnexubclauseProgram(threadClassifier);
                              if (extendedThreadClassifier == null) {									   //-- print period				
                                if (period != 0) {
                                  pw.println("    @Period(" + ((int) period) + ");");
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
                                      String tstr="    ";
                                      ThreadDeclaration td = (ThreadDeclaration)pe;
                                      if (td.isOverride())
                                        tstr += "override ";
                                      if (td.isExtern())
                                        tstr +="extern ";
                                      if (td.isPure())
                                        tstr += "pure ";
                                      tstr+= "thread "+threadClassifier.getName() + " " +
                                        serializer.serialize(td.getFnBody());
                                      pw.println(tstr);
                                    } else {
                                      pw.println("    //---------------------------------------------");
                                      pw.println("    //-- begin node-level thread");
                                      pw.println("    //---------------------------------------------");
                                      String str = serializer.serialize(pe);
                                      str = "    " + str.trim();
                                      pw.println(str);
                                      pw.println("    //---------------------------------------------");
                                      pw.println("    //-- end node-level thread");
                                      pw.println("    //---------------------------------------------");
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

                          pw.println("    role " + processClassifier.getName().replace('.', '_') + " {");
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
                                  Classifier extendedThreadClassifier = threadClassifier.getExtended();
                                  if (extendedThreadClassifier == null) {
                                    pw.println("      thread " + getThreadSubannexContainingClassifierName(thread) + ";");
                                  } else {
                                    double period = GetProperties.getPeriodinMicroSec(thread);
                                    if (period != 0) {
                                      pw.println("      @Period(" + ((int) period) + ");");
                                    }
                                    Program threadPrg = getThreadSubannexProgram(thread); 
//                                    if (threadPrg == null){
//                                      threadPrg = getAnnexSubclauseProgram(extendedThreadClassifier);
//                                    }
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
                                          String tstr="    ";
                                          ThreadDeclaration td = (ThreadDeclaration)pe;
                                          if (td.isOverride())
                                            tstr += "override ";
                                          if (td.isExtern())
                                            tstr +="extern ";
                                          if (td.isPure())
                                            tstr += "pure ";
                                          tstr+= "thread " + extendedThreadClassifier.getName() + " " +
                                            serializer.serialize(td.getFnBody());
                                          pw.println(tstr);
                                          pw.println(" ");
                                        } else {
                                          pw.println("      //-------------------------------------------");
                                          pw.println("      //-- begin role-level thread");
                                          pw.println("      //-------------------------------------------");
                                          String str = serializer.serialize(pe);
                                          str = "      " + str.trim();
                                          pw.println(str);
                                          pw.println("      //-------------------------------------------");
                                          pw.println("      //-- end role-level thread");
                                          pw.println("      //-------------------------------------------");
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
                          pw.println("    }\n");
                        }
                        pw.println("    }\n");
                      }
                    }
                  }
                }
              };
            visitProcesses1.processPreOrderComponentInstance(ci, ComponentCategory.PROCESS);

          }
        };
      visitSystems1.processPreOrderComponentInstance(root, ComponentCategory.SYSTEM);

      //-- close writer to DMPL file
      pw.close();

      System.out.println("Annex DMPL Generator Finished ...");
    } catch (FileNotFoundException ex) {
      System.err.println("ERROR: could not open DMPL file " + dmplFilename + "!!");
    }
  }

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

  //-- name of directory in which files are generated, and getter for name
  private String dirStr = null;

  public String getDirStr() { return dirStr; }

  //-- name of AADL instance file, and getter for name
  private String instFile = null;

  public String getInstFile() { return instFile; }
  
  /*******************************************************************/
  //-- the top-level method called from OSATE
  /*******************************************************************/
  protected void generateDARTFiles(IProgressMonitor monitor,
                                   final AnalysisErrorReporterManager errManager,
                                   SystemInstance root, SystemOperationMode som)
  {
    /*
    //-- check whether the mission must be run also after generation
    final AtomicBoolean runMission = new AtomicBoolean(false);
    getShell().getDisplay().syncExec(new Runnable() {
      @Override
      public void run() {
        runMission.set(MessageDialog.openQuestion(getShell(), "Confirm", "Run mission after generating?"));
      }
    });
    */
    
    //-- create the directory where the generated files will be kept
    final IPath dir = OsateResourceUtil.convertToIResource(root.eResource()).getLocation().removeLastSegments(2).append("DART");
    dirStr = dir.toOSString();
    final File dirFile = new File(dirStr);
    dirFile.mkdir();

    //-- get the name of the instance file without the extension
    instFile = OsateResourceUtil.convertToIResource(root.eResource()).getLocation().removeFileExtension().lastSegment();
    if (instFile == null) {
      errManager.error(root, "ERROR: could not get instance file name");
      return;
    }
    
    //-- create DMPL file name
    final String dmplFilename = dirStr + "/" + instFile + ".dmpl";

    //-- create mission file name
    final String missionFilename = dirStr + "/" + instFile + ".mission";

    //-- generate DMPL and mission files
    generateDmplFile(monitor,errManager,root,som,dmplFilename);
    generateMissionFile(monitor,errManager,root,som,instFile,missionFilename);

    //-- refresh so that the DART folder and its contents become visible
    IResource ires = OsateResourceUtil.convertToIResource(root.eResource());
    try {
      ires.getParent().getParent().refreshLocal(IResource.DEPTH_INFINITE, monitor);
    } catch (CoreException e) {
      System.err.println("ERROR: Could not refresh project after creating DART folder");
    }
  }
}

/*********************************************************************/
//-- end of file
/*********************************************************************/
