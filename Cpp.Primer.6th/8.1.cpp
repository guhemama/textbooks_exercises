#include <iostream>
#include <string>

using namespace std;

// Omg it was not overloaded, lulz
template <typename T>
void iquote(T var)
{
  cout << "\"" << var << "\"\n";
}

int main(void)
{
  int    int_arg    = 10;
  double double_arg = 20.32;
  string string_arg = "Hello word!";

  iquote(int_arg);
  iquote(double_arg);
  iquote(string_arg);

  return 0;
}