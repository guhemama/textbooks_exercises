#include <iostream>

using namespace std;

int main(void)
{
    int inches
      , feet;

    const short int FACTOR = 12;

    cout << "Type your height in inches: ___\b\b\b";
    cin >> inches;

    feet    = inches / FACTOR;
    inches %= FACTOR;

    cout << "Your height is " << feet << "' and " << inches << "\"" << endl;

    return 0;
}