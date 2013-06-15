#include <iostream>

using namespace std;

int main(void)
{
    long long world_population
            , country_population;

    cout << "Enter the world population: ";
    cin >> world_population;

    cout << "Enter the country population: ";
    cin >> country_population;

    cout << "The population of the country is "
         << ( country_population / double(world_population) ) * 100
         << "% of the world population."
         << endl;

    return 0;
}