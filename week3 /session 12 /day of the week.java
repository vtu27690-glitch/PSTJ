class Solution {
    public String dayOfTheWeek(int day, int month, int year) {

        String[] week = {
            "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"
        };

        int totalDays = 0;

        // Add days for all previous years
        for (int y = 1971; y < year; y++) {
            if (isLeapYear(y)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        // Days in each month
        int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        // Add one extra day for February in a leap year
        if (isLeapYear(year)) {
            days[1] = 29;
        }

        // Add days from previous months
        for (int m = 0; m < month - 1; m++) {
            totalDays += days[m];
        }

        // Add current day - 1
        totalDays += day - 1;

        // January 1, 1971 was Friday
        // Friday is index 5
        int index = (5 + totalDays) % 7;

        return week[index];
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 ||
               (year % 4 == 0 && year % 100 != 0);
    }
}


Input
day =
31
month =
8
year =
2019
Output
"Saturday"
Expected
"Saturday"
