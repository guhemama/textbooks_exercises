#include <string>
#include <iostream>
#include "linked_list.h"

using std::string;
using std::cout;
using std::endl;

int main(void)
{
  LinkedList<string> l;
  l.addFirst("foo");
  l.addFirst("bar");
  l.addLast("baz");
  l.addFirst("fiz");
  l.addFirst("bir");
  l.addLast("biz");

  l.print();

  cout << "Removido: " << l.remove() << endl;
  cout << "Removido: " << l.remove() << endl;

  l.print();

  return 0;
}