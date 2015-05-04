#ifndef _MADARA_KNOWLEDGE_CAST_HPP
#define _MADARA_KNOWLEDGE_CAST_HPP

#include <string>
#include <stdbool.h>

namespace Madara
{

/// By default, call constructor of target class;
/// for other semantics, define specializations
template<class O>
O knowledge_cast(const Knowledge_Record &in)
{
  return O(in);
}

template<>
float knowledge_cast<float>(const Knowledge_Record &in)
{
  return static_cast<float>(in.to_double());
}

template<>
double knowledge_cast<double>(const Knowledge_Record &in)
{
  return static_cast<double>(in.to_double());
}

template<>
long double knowledge_cast<long double>(const Knowledge_Record &in)
{
  return static_cast<long double>(in.to_double());
}

template<>
bool knowledge_cast<bool>(const Knowledge_Record &in)
{
  return in.to_integer() ? true : false;
}

template<>
char knowledge_cast<char>(const Knowledge_Record &in)
{
  return static_cast<char>(in.to_integer());
}

template<>
unsigned char knowledge_cast<unsigned char>(const Knowledge_Record &in)
{
  return static_cast<unsigned char>(in.to_integer());
}

template<>
short knowledge_cast<short>(const Knowledge_Record &in)
{
  return static_cast<short>(in.to_integer());
}

template<>
unsigned short knowledge_cast<unsigned short>(const Knowledge_Record &in)
{
  return static_cast<unsigned short>(in.to_integer());
}

template<>
int knowledge_cast<int>(const Knowledge_Record &in)
{
  return static_cast<int>(in.to_integer());
}

template<>
unsigned int knowledge_cast<unsigned int>(const Knowledge_Record &in)
{
  return static_cast<unsigned int>(in.to_integer());
}

template<>
long int knowledge_cast<long int>(const Knowledge_Record &in)
{
  return static_cast<long int>(in.to_integer());
}

template<>
unsigned long int knowledge_cast<unsigned long int>(const Knowledge_Record &in)
{
  return static_cast<unsigned long int>(in.to_integer());
}

#if __STDC_VERSION__ >= 199901L

template<>
long long int knowledge_cast<long long int>(const Knowledge_Record &in)
{
  return static_cast<long long int>(in.to_integer());
}

template<>
unsigned long long int knowledge_cast<unsigned long long int>(const Knowledge_Record &in)
{
  return static_cast<unsigned long long int>(in.to_integer());
}

#endif

template<>
std::string knowledge_cast<std::string>(const Knowledge_Record &in)
{
  return in.to_string();
}

template<>
Knowledge_Record knowledge_cast<Knowledge_Record>(const Knowledge_Record &in)
{
  return in;
}

Knowledge_Record knowledge_cast(const int &in)
{
  return Knowledge_Record(Knowledge_Record::Integer(in));
}

Knowledge_Record knowledge_cast(const unsigned int &in)
{
  return Knowledge_Record(Knowledge_Record::Integer(in));
}

Knowledge_Record knowledge_cast(const long int &in)
{
  return Knowledge_Record(Knowledge_Record::Integer(in));
}

Knowledge_Record knowledge_cast(const unsigned long int &in)
{
  return Knowledge_Record(Knowledge_Record::Integer(in));
}

#if __STDC_VERSION__ >= 199901L

Knowledge_Record knowledge_cast(const long long int &in)
{
  return Knowledge_Record(Knowledge_Record::Integer(in));
}

Knowledge_Record knowledge_cast(const unsigned long long int &in)
{
  return Knowledge_Record(Knowledge_Record::Integer(in));
}

#endif

Knowledge_Record knowledge_cast(const short &in)
{
  return Knowledge_Record(Knowledge_Record::Integer(in));
}

Knowledge_Record knowledge_cast(const unsigned short &in)
{
  return Knowledge_Record(Knowledge_Record::Integer(in));
}

Knowledge_Record knowledge_cast(const char &in)
{
  return Knowledge_Record(Knowledge_Record::Integer(in));
}

Knowledge_Record knowledge_cast(const unsigned char &in)
{
  return Knowledge_Record(Knowledge_Record::Integer(in));
}

Knowledge_Record knowledge_cast(const bool &in)
{
  return Knowledge_Record(Knowledge_Record::Integer(in ? 1 : 0));
}

Knowledge_Record knowledge_cast(const float &in)
{
  return Knowledge_Record(static_cast<double>(in));
}

Knowledge_Record knowledge_cast(const double &in)
{
  return Knowledge_Record(in);
}

Knowledge_Record knowledge_cast(const long double &in)
{
  return Knowledge_Record(static_cast<double>(in));
}

Knowledge_Record &knowledge_cast(Knowledge_Record &in)
{
  return in;
}

const Knowledge_Record &knowledge_cast(const Knowledge_Record &in)
{
  return in;
}

}

#endif
