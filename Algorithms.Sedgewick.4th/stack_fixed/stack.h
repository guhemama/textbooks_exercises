#include <string>

using std::string;

class Stack
{
protected:
  int _size;
  string* _items;

public:
  Stack(int size);
  ~Stack();
  void push(string s);
  string pop();
  inline int getSize() const { return _size; }
  bool isEmpty() { return _size == 0; }
};