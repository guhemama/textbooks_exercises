#include <iostream>
#include <string>

using namespace std;

struct Pizza
{
  string company;
  double diameter;
  double weight;
};

int main(void)
{
  Pizza p1;

  getline(cin, p1.company);
  cin >> p1.diameter >> p1.weight;

  cout << p1.company << endl;
  cout << p1.diameter << endl;
  cout << p1.weight << endl;

  return 0;
}