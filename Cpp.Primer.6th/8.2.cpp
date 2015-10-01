#include <iostream>
#include <string>

using namespace std;

struct CandyBar {
  const char * name;
  double weight;
  int calories;
};

void craft_candy(CandyBar * cb, const char * name, double weight, int calories);

int main(void)
{
  CandyBar snickers;
  craft_candy(&snickers, "Snickers", 52.00, 320);

  cout << snickers.name << endl;
  cout << snickers.weight << "g" << endl;
  cout << snickers.calories << " calories" << endl;

  return 0;
}

void craft_candy(CandyBar * cb, const char * name, double weight, int calories)
{
  cb->name     = name;
  cb->weight   = weight;
  cb->calories = calories;
}