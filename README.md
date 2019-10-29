# Day
The Day class encapsulates a particular day.
The state of a day can be defined simply with year, month and day.
There are also additional functions that:
  Counts how many days are there between now and another specified day.
  Counts what day is after a specified number of days.
Some Condition: 
April, June, September, and November have 30 days.
February has 28 days, except in leap years, when it has 29 days.
All other months have 31 days.
Leap years are years that are divisible by 4, except after 1582, when years that are divisible by 100 but not 400 are not leap years.
There is no year 0; year 1 is preceded by year -1.
In the switchover to the Gregorian calendar, 10 days were dropped so that October 15, 1582, followed immediately after October 4.

Furthermore, in implementing this class:

Splited complex functions using helper functions
Avoid breaking the encapsulation

Added Preconditions and Postconditions per each method/constructor.
Assertions or exceptions (based on which one is more suitable for that specific case)
Added a companion class for Unit testing where each method is individually tested by a proper  test method.
 
