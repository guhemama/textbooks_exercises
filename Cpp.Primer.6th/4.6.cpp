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
  CandyBar candies [3] = {
    { "Mocha Munch", 2.3, 350 },
    { "Nestlé", 32.54, 210 },
    { "Wonka", 50.5, 800 }
  };

  int i;
  for (i = 0; i < 3; i++)
  {
    cout << candies[i].brand << endl;
    cout << candies[i].weight << "g" << endl;
    cout << candies[i].calories << " calories" << endl;
  }
  return 0;
}