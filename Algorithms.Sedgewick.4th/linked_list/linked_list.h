#include <iostream>

using std::nullptr_t;
using std::cout;
using std::endl;

template <class Item>
class LinkedList
{
protected:
  class Node
  {
  protected:
    Item _item;
    Node* _next;
  public:
    Node() : _next(nullptr) {};
    Node* getNext() { return _next; }
    void setNext(Node* node) { _next = node; }
    const Item& getItem() { return _item; }
    void setItem(const Item& item) { _item = item; }
    bool hasNext() { return _next; }
  };

  Node* _first;
  Node* _last;

public:
  LinkedList() : _first(nullptr), _last(nullptr) {};

  Node* getFirst() { return _first; }
  Node* getLast() { return _last; }
  void addFirst(const Item& item);
  void addLast(const Item& item);

  Item remove();

  void print();
};

// Insert at the beginning of the list
template <class Item>
void LinkedList<Item>::addFirst(const Item& item)
{
  Node* n = new Node();
  n->setItem(item);

  if (_first)
  {
    n->setNext(_first);
  }
  else
  {
    _last = n;
  }

  _first = n;
}

// Insert at the end of the list
template <class Item>
void LinkedList<Item>::addLast(const Item& item)
{
  Node* n = new Node();
  n->setItem(item);

  if (_last)
  {
    _last->setNext(n);
  }
  else
  {
    _first = n;
  }

  _last = n;
}

// Removes from the beginning of the list
template <class Item>
Item LinkedList<Item>::remove()
{
  Item i = _first->getItem();
  _first = _first->getNext();
  return i;
}

// Prints the list
template <class Item>
void LinkedList<Item>::print()
{
  Node* n = getFirst();
  while (n)
  {
    cout << n->getItem() << " -> ";
    n = n->getNext();
  }

  cout << endl;
}