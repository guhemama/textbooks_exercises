#include <iostream>
#include "cow.h"

int main(void)
{
  Cow moo;
  {
    Cow betty("Betty", "eating grass", 201.30);
    betty.showCow();

    moo = betty;

    Cow primose(betty);
    primose.setName("Primose");
    primose.showCow();

    Cow cinnamon = betty;
    cinnamon.setName("Cinnamon");
    cinnamon.showCow();
  }

  moo.setName("Moo");
  moo.showCow();

  return 0;
}