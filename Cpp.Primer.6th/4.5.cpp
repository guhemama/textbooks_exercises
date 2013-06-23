#include <iostream>
#include <string>

using namespace std;

struct CandyBar
{
  string brand;
  double weight;
  int calories;
};

int main(void)
{
  CandyBar snack = {
    "Mocha Munch",
    2.3,
    350
  };

  cout << snack.brand << endl;
  cout << snack.weight << "g" << endl;
  cout << snack.calories << " calories" << endl;

  return 0;
}