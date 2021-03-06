/**
 * Copyright (c) 2015 Carnegie Mellon University. All Rights Reserved.

 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:

 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following acknowledgments
 * and disclaimers.

 * 2. Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution.

 * 3. The names "Carnegie Mellon University," "SEI" and/or "Software
 * Engineering Institute" shall not be used to endorse or promote
 * products derived from this software without prior written
 * permission. For written permission, please contact
 * permission@sei.cmu.edu.

 * 4. Products derived from this software may not be called "SEI" nor
 * may "SEI" appear in their names without prior written permission of
 * permission@sei.cmu.edu.

 * 5. Redistributions of any form whatsoever must retain the following
 * acknowledgment:

 * This material is based upon work funded and supported by the
 * Department of Defense under Contract No. FA8721-05-C-0003 with
 * Carnegie Mellon University for the operation of the Software
 * Engineering Institute, a federally funded research and development
 * center.

 * Any opinions, findings and conclusions or recommendations expressed
 * in this material are those of the author(s) and do not necessarily
 * reflect the views of the United States Department of Defense.

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE
 * ENGINEERING INSTITUTE MATERIAL IS FURNISHED ON AN "AS-IS"
 * BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND,
 * EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT
 * LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE
 * MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH
 * RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT
 * INFRINGEMENT.

 * This material has been approved for public release and unlimited
 * distribution.

 * DM-0002494
**/

#include <iostream>
#include <boost/foreach.hpp>
#include "Node.h"
#include "CProgram.h"
#include "Program.h"

/*********************************************************************/
//print the program to an output stream with proper indentation
/*********************************************************************/
void
dmpl::CProgram::print (std::ostream &os,unsigned int indent)
{
  std::string spacer (indent, ' ');

  //print headers
  for(const std::string &h : headers) os << h;
  os << '\n';
  
  //print external function declarations
  os << spacer << "/************************ external functions **********************/\n";
  BOOST_FOREACH(dmpl::Funcs::value_type &v, externalFuncs) {
    os << spacer << "extern";
    v.second->printDecl(os, 1);
  }
  os << '\n';

  //print constants
  os << spacer << "/**************************** constants ***************************/\n";
  BOOST_FOREACH(dmpl::Program::ConstDef::value_type &cd, constDef) {
    os << spacer << "#define " << cd.first << " " << cd.second << "\n";
  }
  os << '\n';
  
  //print global variables
  os << spacer << "/************************ global variables ************************/\n";
  for (dmpl::Vars::iterator i = globVars.begin (); i != globVars.end (); ++i) {
    i->second->printC (os,indent);
    os << ";\n";
  }
  os << '\n';

  //print function declarations
  os << spacer << "/********************** function declarations *********************/\n";
  for (dmpl::Funcs::iterator i = funcs.begin (); i != funcs.end (); ++i)
    i->second->printDecl (os,indent);
  os << '\n';

  //print functions
  os << spacer << "/********************** function definitions **********************/\n";
  for (dmpl::Funcs::iterator i = funcs.begin (); i != funcs.end (); ++i)
    i->second->print (os,indent);

  //print footers
  os << '\n';
  for(const std::string &f : footers) os << f;
}

/*********************************************************************/
//end of file
/*********************************************************************/
