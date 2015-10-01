#include "stack.h"
#include <iostream>

using std::cout;
using std::endl;

int main(void)
{
  Stack<string> s(10);
  s.push("to");
  s.push("be");
  s.push("or");
  s.push("not");
  s.push("to");
  cout << s.getSize() << endl;

  cout << s.pop() << endl;

  s.push("be");
  cout << s.getSize() << endl;

  cout << s.pop() << endl;
  cout << s.pop() << endl;

  s.push("that");
  cout << s.getSize() << endl;

  cout << s.pop() << endl;
  cout << s.pop() << endl;
  cout << s.pop() << endl;

  s.push("is");
  cout << s.getSize() << endl;

  return 0;
}