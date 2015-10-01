#include <iostream>
#include <cctype>
#include <string>

using namespace std;

int main(void)
{
  cout << "Enter words (q to quit): ";
  string input;

  int vowels = 0
    , consonants = 0
    , others = 0;

  while (true)
  {
    cin >> input;

    if (input.size() == 1 && input[0] == 'q')
    {
      break;
    }
    
    if (isalpha(input[0]))
    {
      switch (tolower(input[0]))
      {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
          vowels += 1;
          break;
        default:
          consonants += 1;
      }
    }
    else
    {
      others += 1;
    }
  }

  cout << vowels << " words beginning with voewls" << endl;
  cout << consonants << " word beginning with consonants" << endl;
  cout << others << " others" << endl;

  return 0;
}