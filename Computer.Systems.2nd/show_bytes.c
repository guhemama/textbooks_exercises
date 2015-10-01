#include <stdio.h>

typedef unsigned char *byte_pointer;

void show_bytes(byte_pointer start, int len)
{
  int i;
  for (i = 0; i < len; i++)
  {
    printf(" %.2x", start[i]);
  }

  printf("\n");
}

void show_int(int x)
{
  show_bytes((byte_pointer) &x, sizeof(int));
}

void show_float(float x)
{
  show_bytes((byte_pointer) &x, sizeof(float));
}

void show_pointer(void *x)
{
  show_bytes((byte_pointer) &x, sizeof(void *));
}

int main(void)
{
  float f = 12345.0;
  int i = 12345;
  int *p = &i;
  
  show_float(f);
  show_int(i);
  show_pointer(p);
  
  return 1;
}
