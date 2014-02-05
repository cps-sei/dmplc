#include <iostream>
#include <boost/foreach.hpp>
#include "Node.h"
#include "Program.h"

void
daig::Program::print (std::ostream &os,unsigned int indent)
{
  std::string spacer (indent, ' ');

  //print MOC
  os << spacer << moc.to_string_type () << ";\n\n";

  //print CONST definitions
  BOOST_FOREACH(ConstDef::value_type &cd,constDef)
    os << spacer << "CONST(" << cd.first << "," << cd.second << ");\n";
  os << '\n';

  //print nodes
  for (daig::Nodes::iterator i = nodes.begin (); i != nodes.end (); ++i)
    i->second.print (os,indent);

  //print program definition
  os << spacer << "PROGRAM = ";
  size_t count = 0;
  BOOST_FOREACH(const Process &p,processes) {
    if(count) os << " || ";
    os << p.getNode() << '(' << p.getId() << ")";
    ++count;
  }
  os << ";\n\n";

  //print functions like INIT and safety
  for (daig::Functions::iterator i = funcs.begin (); i != funcs.end (); ++i)
    i->second.print (os,indent);
}
