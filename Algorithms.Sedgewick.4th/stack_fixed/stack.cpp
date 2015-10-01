#include "stack.h"

Stack::Stack(int size)
{
  _size = 0;
  _items = new string[size];
}

Stack::~Stack()
{
  delete[] _items;
}

void Stack::push(string s)
{
  _items[_size] = s;
  _size += 1;
}

string Stack::pop()
{
  _size -= 1;
  return _items[_size];
}