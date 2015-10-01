#include <stdio.h>
#include <stdbool.h>

void sort(int* arr, int size);
bool isSorted(int* arr, int size);
void swap(int* arr, int i, int j);
void print(int* arr, int size);

int main(void)
{
  int arr[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
  int size  = (int) (sizeof(arr) / sizeof(int));

  print(arr, size);
  sort(arr, size);
  print(arr, size);

  return 0;
}

void sort(int* arr, int size)
{
  for (int i = 0; i < size; i++)
  {
    int min = i;

    for (int j = i + 1; j < size; j++)
    {
      if (arr[j] < arr[min])
      {
        min = j;
      }
    }

    swap(arr, i, min);
  }
}

bool isSorted(int* arr, int size)
{
  for (int i = 0; i < size - 2; i++)
  {
    if (arr[i] > arr[i + 1])
    {
      return false;
    }
  }

  return true;
}

void print(int* arr, int size)
{
  for (int i = 0; i < size; i++)
  {
    printf("%d ", arr[i]);
  }

  printf("\n");
}

void swap(int* arr, int i, int j)
{
  int tmp = arr[i];
  arr[i] = arr[j];
  arr[j] = tmp;
}
