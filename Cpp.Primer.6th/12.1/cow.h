#ifndef COW_H
#define COW_H

#include <iostream>
#include <cstring>

using namespace std;

class Cow
{
  char   name[20];
  char   * hobby;
  double weight;
public:
  Cow();
  Cow(const char * nm, const char * ho, double wt);
  Cow(const Cow & c);
  ~Cow();
  Cow & operator=(const Cow & c);
  void showCow() const;
  void setName(const char * nm) { strcpy(name, nm); }
};

#endif