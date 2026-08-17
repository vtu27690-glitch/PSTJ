class Solution {
    public int dayOfYear(String date) {
        // Parse year, month, and day from the string
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        
        // Days in each month for a non-leap year
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // Check if the year is a leap year
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        if (isLeap) {
            daysInMonths[1] = 29; // February gets 29 days
        }
        
        // Sum the days of the preceding months and add the current day
        int totalDays = 0;
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonths[i];
        }
        totalDays += day;
        
        return totalDays;
    }
}

Input
date =
"2019-01-09"
Output
9
Expected
9
