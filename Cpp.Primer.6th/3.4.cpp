#include <iostream>

using namespace std;

int main(void)
{
    const int HOURS_IN_DAY      = 24
            , MINUTES_IN_HOUR   = 60
            , SECONDS_IN_MINUTE = 60;

    long long seconds;
    cout << "Enter the number of seconds: ";
    cin >> seconds;

    long remainder;

    int secs  = seconds % SECONDS_IN_MINUTE;
    remainder = seconds / SECONDS_IN_MINUTE;

    int minutes = remainder % MINUTES_IN_HOUR;
    remainder   = remainder / MINUTES_IN_HOUR;

    int hours = remainder % HOURS_IN_DAY;
    long days = remainder / HOURS_IN_DAY;

    cout << seconds << " seconds = "
         << days << " days, "
         << hours << " hours, "
         << minutes << " minutes, "
         << secs << " seconds."
         << endl;

    return 0;
}