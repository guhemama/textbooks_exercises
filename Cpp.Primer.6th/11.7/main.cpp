#include <iostream>
#include "complex.h"

using namespace std;

int main(void)
{
    Complex a(3.0, 4.0);
    Complex b(9.0, 2.0);

    cout << "a is " << a << endl;
    cout << "b is " << b << endl;
    cout << "complex conjugate is " << ~a << endl;
    cout << "a + b is " << a + b << endl;
    cout << "a - b is " << a - b << endl;
    cout << "a * b is " << a * b << endl;
    cout << "2 * b is " << 2 * b << endl;
    cout << "a * 2 is " << a * 2 << endl;

    return 0;
}