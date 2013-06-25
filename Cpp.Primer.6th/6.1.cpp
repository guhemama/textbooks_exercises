#include <iostream>
#include <cctype>
#include <string>

using namespace std;

int main(void)
{
  char input;
  string text;

  while (true)
  {
    cin.get(input);

    if (input == '@')
    {
      break;
    }
    else if (isdigit(input))
    {
      continue;
    }
    else if (islower(input))
    {
      text += toupper(input);
    }
    else if (isupper(input))
    {
      text += tolower(input);
    }
  }

  cout << text << endl;

  return 0;
}