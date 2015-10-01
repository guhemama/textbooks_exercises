#include <iostream>
#include <string>

using namespace std;

template <typename T>
T maxn(T arr[], int itens);

int main(void)
{
  int    int_arr[6]  = { 1, 2, 7, 4, 3, 6 };
  double dou_arr [4] = { 0.5, 2.7, 0.8, 2.5 };

  cout << maxn(int_arr, 6) << endl;
  cout << maxn(dou_arr, 4) << endl;

  return 0;
}

template <typename T>
T maxn(T arr[], int itens)
{
  T largest = '\0';

  for (int i = 0; i < itens; i++)
  {
    if (largest == '\0')
    {
      largest = arr[i];
    }    
    else if (arr[i] > largest)
    {
      largest = arr[i];
    }
  }

  return largest;
}