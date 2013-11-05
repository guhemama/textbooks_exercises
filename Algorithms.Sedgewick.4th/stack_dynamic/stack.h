#include <string.h>

typedef struct Stack {
  int _size;
  int _length;
  char** _items;
} Stack;

Stack* newStack();
void push(Stack* s, char* str);
char* pop(Stack* s);
void* resize(Stack* s, double ratio);
int size(Stack* s);