#include "complex.h"

Complex::Complex(double r, double i)
{
    _real = r;
    _imaginary = i;
}

Complex::~Complex()
{

}

const Complex operator+(const Complex & c1, const Complex & c2)
{
    return Complex(c1._real + c2._real, c1._imaginary + c2._imaginary);
}

const Complex operator~(const Complex & c)
{
    return Complex(c._real, -c._imaginary);
}

const Complex operator*(const Complex & c1, const Complex & c2)
{
    return Complex(c1._real * c2._real - c1._imaginary * c2._imaginary,
                   c1._real * c2._imaginary + c2._real * c1._imaginary);
}

const Complex operator*(const Complex & c, const double n)
{
    return Complex(c._real * n, c._imaginary * n);
}

const Complex operator*(const double n, const Complex & c)
{
    return c * n;
}

const Complex operator-(const Complex & c1, const Complex & c2)
{
    return Complex(c1._real - c2._real, c1._imaginary - c2._imaginary);
}

ostream & operator<<(ostream & os, const Complex & c)
{
    cout << c._real << "+" << c._imaginary << + "i";
    return os;
}