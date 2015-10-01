#include <iostream>
#include <string>

using namespace std;

void uppercase(string str);

int main(void)
{
  string str = "Lorem ipsum dolum";
  uppercase(str);

  return 0;
}

void uppercase(string str)
{
  for (char chr : str)
  {
    cout << (char) toupper(chr);
  }

  cout << endl;
}