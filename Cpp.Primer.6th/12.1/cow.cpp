#include "cow.h"

Cow::Cow() {}

Cow::Cow(const char * nm, const char * ho, double wt)
{
  strcpy(name, nm);

  hobby = new char[strlen(ho) + 1];
  strcpy(hobby, ho);

  weight = wt;
}

Cow::Cow(const Cow & c)
{
  strcpy(name, c.name);
  
  hobby = new char[strlen(c.hobby) + 1];
  strcpy(hobby, c.hobby);

  weight = c.weight;
}

Cow::~Cow()
{
  delete [] hobby;
}

Cow & Cow::operator=(const Cow & c)
{
  strcpy(name, c.name);

  hobby = new char[strlen(c.hobby) + 1];
  strcpy(hobby, c.hobby);

  weight = c.weight;

  return *this;
}

void Cow::showCow() const
{
  cout << "Cow name is " << name;
  cout << ", she weights " << weight << " kilos";
  cout << " and her hobby is " << hobby;
  cout << endl;
}
