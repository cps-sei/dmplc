#ifndef DMPL_LOG_ANALYZER
#define DMPL_LOG_ANALYZER

#include <vector>
#include <string>
#include <fstream>
#include <sstream>

#include "madara/knowledge_engine/Knowledge_Base.h"
#include "madara/knowledge_engine/Knowledge_Record.h"

namespace engine = Madara::Knowledge_Engine;
using Madara::Knowledge_Record;

namespace dmpl
{
  class LogAnalyzer
  {
  protected:
    istream &in;
    engine::Knowledge_Base &kbase;
    long active_frame;
    long cur_frame;

    struct Row
    {
      int frame;
      double time;
      int node;
      std::string var;
      std::string madara_name;
      Knowledge_Record val;
    };

    Row cur_row;

    // Taken from http://stackoverflow.com/a/1120224, licensed under CC-SA
    std::vector<std::string> getNextLineAndSplitIntoTokens(std::istream& str)
    {
        std::vector<std::string> result;
        std::string line;

        if(!std::getline(str,line))
          return result;

        std::stringstream lineStream(line);
        std::string cell;

        while(std::getline(lineStream,cell,','))
        {
            result.push_back(cell);
        }
        return result;
    }

    template<class T>
    T stream_cast(const std::string &s)
    {
      T ret;
      std::stringstream ss(s);
      ss >> ret;
      return ret;
    }

    bool get_next_row()
    {
      std::vector<std::string> row = getNextLineAndSplitIntoTokens(in);
      if(row.size() == 0)
      {
        return false;
      }
      cur_row.frame = stream_cast<int>(row[0]);
      cur_row.time = stream_cast<double>(row[1]);
      cur_row.node = stream_cast<int>(row[2]);
      cur_row.var = row[3];
      cur_row.madara_name = cur_row.var + "." + row[2];
      if(row[4].find('.') == std::string::npos)
        cur_row.val.set_value(stream_cast<Knowledge_Record::Integer>(row[4]));
      else
        cur_row.val.set_value(stream_cast<double>(row[4]));
      return true;
    }

    void get_header()
    {
      std::vector<std::string> row = getNextLineAndSplitIntoTokens(in);
    }

    void update_knowledge(const Row &row)
    {
      //std::cout << "Setting " << row.madara_name << " to " << row.val << std::endl;
      kbase.get_context().set(row.madara_name, row.val);
    }
  public:

    LogAnalyzer(istream &csv_stream, engine::Knowledge_Base &knowledge)
      : in(csv_stream), kbase(knowledge), active_frame(0)
    {
      get_header();
      get_next_row();
      cur_frame = cur_row.frame;
    }

    bool next_step()
    {
      for(;;)
      {
        cur_frame = cur_row.frame;
        std::cout << std::fixed;
        std::cout << cur_row.frame << " " << cur_row.time << " " << cur_row.var << "@" << cur_row.node << ": "
                  << cur_row.val << "  (" << cur_row.val.type() << ")" << std::endl;
        std::cout << std::scientific;
        update_knowledge(cur_row);
        if(!get_next_row())
        {
          std::cout << "END OF FRAME " << active_frame << std::endl;
          std::cout << "END OF FILE" << std::endl;
          return false;
        }
        if(cur_row.frame > active_frame)
        {
          //std::cout << "END OF FRAME " << active_frame << std::endl;
          active_frame = cur_row.frame;
          return true;
        }
        // else, loop for next entry in current frame
      }

    }

    long get_cur_frame() { return cur_frame; }
  };
}
#endif
