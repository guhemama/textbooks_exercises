#include "stack.h"
#include <stdio.h>

int main(void)
{
  Stack* stack = newStack();

  push(stack, "to");
  push(stack, "be");
  push(stack, "or");
  push(stack, "not");
  push(stack, "to");

  printf("Stack size: %d Stack length: %d\n", stack->_size, stack->_length);

  printf("%s\n", pop(stack));

  push(stack, "be");

  printf("Stack size: %d Stack length: %d\n", stack->_size, stack->_length);

  printf("%s\n", pop(stack));
  printf("%s\n", pop(stack));

  push(stack, "that");

  printf("Stack size: %d Stack length: %d\n", stack->_size, stack->_length);

  printf("%s\n", pop(stack));
  printf("%s\n", pop(stack));
  printf("%s\n", pop(stack));

  push(stack, "is");

  printf("Stack size: %d Stack length: %d\n", stack->_size, stack->_length);

  return 0;
}