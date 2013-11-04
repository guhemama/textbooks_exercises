#include <string>

using std::string;

template <class Item>
class Stack
{
protected:
  int _size;
  Item* _items;

public:
  Stack(int size);
  ~Stack();
  void push(const Item& item);
  const Item& pop();
  int getSize() const { return _size; }
  bool isEmpty() { return _size == 0; }
};

template <class Item>
Stack<Item>::Stack(int size)
{
  _size = 0;
  _items = new Item[size];
}

template <class Item>
Stack<Item>::~Stack()
{
  delete[] _items;
}

template <class Item>
void Stack<Item>::push(const Item& item)
{
  _items[_size] = item;
  _size += 1;
}

template <class Item>
const Item& Stack<Item>::pop()
{
  _size -= 1;
  return _items[_size];
}