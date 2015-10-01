#include <stdio.h>

void bubble_sort(int* arr, int size)
{
  int i, j, tmp;

  for (i = 0; i < size; i++)
  {
    for (j = 0; j < size - 1; j++)
    {
      if (arr[j] > arr[j + 1])
      {
        tmp        = arr[j];
        arr[j]     = arr[j + 1];
        arr[j + 1] = tmp;
      }
    }
  }
}

void print(int* arr, int size)
{
  int i;

  for (i = 0; i < size; i++)
  {
    printf("%d ", arr[i]);
  }

  printf("\n");
}

int main(void)
{
  int arr[10] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

  print(arr, 10);
  bubble_sort(arr, 10);
  print(arr, 10);

  return 0;
}