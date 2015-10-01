#include <iostream>
#include <ostream>

using namespace std;

class Complex
{
protected:
    double _real;
    double _imaginary;

public:
    Complex(double r, double i);
    ~Complex();

    friend const Complex operator+(const Complex & c1, const Complex & c2);
    friend const Complex operator*(const Complex & c1, const Complex & c2);
    friend const Complex operator*(const Complex & c, const double n);
    friend const Complex operator*(const double n, const Complex & c);
    friend const Complex operator-(const Complex & c1, const Complex & c2);
    friend const Complex operator~(const Complex & c);

    friend ostream & operator<<(ostream & os, const Complex & c);
};