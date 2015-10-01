#include "stack.h"
#include <stdlib.h>

Stack* newStack()
{
  Stack* s = malloc(sizeof(Stack));
  s->_size = 1;
  s->_items  = malloc(s->_length * sizeof(char*));
}

void push(Stack* s, char* str)
{
  if (s->_length == s->_size)
  {
    resize(s, 2);
  }

  s->_items[s->_length++] = str;
}

char* pop(Stack* s)
{
  char* str = s->_items[--s->_length];

  if (s->_length > 0 && s->_length == s->_size / 4)
  {
    resize(s, 0.5);
  }

  return str;
}

void* resize(Stack* s, double ratio)
{
  s->_size *= ratio;
  return realloc(s->_items, s->_size * sizeof(char*));
}