#include <stdio.h>
#include <stdbool.h>
#include <time.h>
#include <stdlib.h>

void exch(int* arr, int i, int j);
int partition(int* arr, int size, int lo, int hi);
int sort(int* arr, int size, int lo, int hi);
void print(int* arr, int size);
void shuffle(int* arr, int size);

int main(void)
{
  int arr[10] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

  print(arr, 10);
  shuffle(arr, 10);
  sort(arr, 10, 0, 9);
  print(arr, 10);

  return 0;
}

void shuffle(int* arr, int size)
{
  int i, j, tmp;

  for (i = 0; i < size - 1; i++)
  {
    j = i + rand() / (RAND_MAX / (size - i) + 1);
    tmp = arr[j];
    arr[j] = arr[i];
    arr[i] = tmp;
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

int sort(int* arr, int size, int lo, int hi)
{
  if (hi <= lo) return;

  int lt = lo
    , i  = lo + 1
    , gt = hi
    , v  = arr[lo];

  while (i <= gt)
  {
    if (arr[i] < v)
    {
      exch(arr, lt++, i++);
    }
    else if (arr[i] > v)
    {
      exch(arr, i, gt--);
    }
    else
    {
      i++;
    }
  }

  sort(arr, size, lo, lt - 1);
  sort(arr, size, gt + 1, hi);
}

int partition(int* arr, int size, int lo, int hi)
{
  int i = lo
    , j = hi + 1;

  int v = arr[lo];

  while (true)
  {
    while (arr[++i] < v) if (i == hi) break;
    while (v < arr[--j]) if (j == lo) break;
    if (i >= j) break;
    exch(arr, i, j);
  }
  exch(arr, lo, j);

  return j;
}

void exch(int* arr, int i, int j)
{
  int tmp = arr[i];
  arr[i]  = arr[j];
  arr[j]  = tmp;
}
