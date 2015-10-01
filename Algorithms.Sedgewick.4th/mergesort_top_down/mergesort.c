#include <stdio.h>
#include <stdlib.h>

int* merge(int* left, int lenLeft, int* right, int lenRight);
void print(int* arr, int len);
int* split(int* arr, int start, int end);
int* sort(int* arr, int len);

int main(void)
{
  int arr[8] = {8, 7, 6, 5, 4, 3, 2, 1};

  //print(arr, 10);
  print(sort(arr, 0, 10), 10);

  return 0;
}

int* sort(int* arr, int len)
{
  

  return merge(left, mid, right, mid);
}


int* split(int* arr, int start, int end)
{
  int* newArr = malloc(sizeof(int) * (end - start + 1));
  int i, idx = 0;

  for (i = start; i < end; i++)
  {
    newArr[idx++] = arr[i];
  }

  return newArr;
}

int* merge(int* left, int lenLeft, int* right, int lenRight)
{
  int i = 0
    , j = 0;

  int* result = malloc(sizeof(int) * (lenLeft + lenRight));

  while (i < lenLeft || j < lenRight)
  {
    int idx = i + j;

    if (i == lenLeft)
    {
      result[idx] = right[j++];
    }
    else if (j == lenRight)
    {
      result[idx] = left[i++];
    }
    else if (left[i] > right[j])
    {
      result[idx] = right[j++];
    }
    else
    {
      result[idx] = left[i++];
    }
  }

  return result;
}

void print(int* arr, int len)
{
  int i;

  for (i = 0; i < len; i++)
  {
    printf("%d ", arr[i]);
  }

  printf("\n");
}
