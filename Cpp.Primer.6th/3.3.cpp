#include <iostream>

using namespace std;

int main(void)
{
    double degrees
         , minutes
         , seconds;

    const short int ARC_MINUTE = 60
                  , ARC_DEGREE = 60;

    cout << "Enter a latitude in degrees, minutes and seconds:" << endl;
    
    cout << "First, enter the degrees: ";
    cin >> degrees;

    cout << "Next, enter the minutes of the arc: ";
    cin >> minutes;

    cout << "Finally, enter the seconds of arc: ";
    cin >> seconds;

    double decimal_arc;

    decimal_arc = degrees + (minutes + (seconds / ARC_MINUTE)) / ARC_DEGREE;

    cout << degrees << " degrees, "
         << minutes << " minutes, "
         << seconds << " seconds = "
         << decimal_arc << " degrees"
         << endl;

    return 0;
}