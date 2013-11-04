#include "stack.h"
#include <iostream>

using std::cout;
using std::endl;

int main(void)
{
  Stack* s = new Stack(10);
  s->push("to");
  s->push("be");
  s->push("or");
  s->push("not");
  s->push("to");

  cout << s->pop() << endl;

  s->push("be");

  cout << s->pop() << endl;
  cout << s->pop() << endl;

  s->push("that");

  cout << s->pop() << endl;
  cout << s->pop() << endl;
  cout << s->pop() << endl;

  s->push("is");

  cout << s->getSize() << endl;

  return 0;
}