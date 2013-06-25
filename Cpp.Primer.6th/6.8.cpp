#include <iostream>
#include <fstream>

using namespace std;

int main(void)
{
  int char_count = 0;
  char input;

  ifstream fin;
  fin.open("6.8.txt");

  while (fin.good())
  {
    fin.get(input);
    char_count += 1;
  }

  cout << "The char count is " << char_count << endl;

  return 0;
}