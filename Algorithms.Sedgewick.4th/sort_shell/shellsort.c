#include <stdio.h>

void sort(int* arr, int size);
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
  int h = 1;

  // We could've chosen other increment sequences, but 3n + 1 is good enough
  while (h < size / 3)
  {
    h = 3 * h + 1;
  }

  while (h >= 1)
  {
    for (int i = h; i < size; i++)
    {
      for (int j = i; j >= h; j -= h)
      {
        // Break the iteration if it's already sorted
        if (arr[j] > arr[j - h])
        {
          break;
        }

        swap(arr, j, j - h);
      }
    }

    // Decreases the increment
    h = h / 3;
  }
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
