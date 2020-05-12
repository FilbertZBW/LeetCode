//Runtime: 0 ms, faster than 100.00% of Java online submissions for Day of the Week.
//Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Day of the Week.


//Of course we can call API of the system, but it takes more runtime.
//We can firstly figure out the starting date of the required range 
//and then use algorithm to find the total day passed, then mod 7.

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

class Solution {
    int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    // 1971-01-01 is Friday
    String[] res = {"Friday", "Saturday", "Sunday", "Monday",
                    "Tuesday", "Wednesday", "Thursday"};
    public String dayOfTheWeek(int day, int month, int year) {       
        // return LocalDate.of(year, month, day).getDayOfWeek().getDisplayName(TextStyle.FULL,  Locale.getDefault());
        
        int days = 0;
        days += daysBeforeYear(year);
        if(isLeap(year)){
            monthDays[2] = 29;
        }
        days += daysBeforeMonth(month);
        days += day - 1;
        
        return res[days % 7];
    }
    
    public int daysBeforeMonth(int mon){
        int resDays = 0;
        for(int m = 1; m < mon; m++){
            resDays += monthDays[m];
        }
        return resDays;
    }
    
    public int daysBeforeYear(int y){
        int sum = 0;
        for(int i = 1971; i < y; i++){
            sum += isLeap(i)? 366:365;
        }
        return sum;
    }
    
    public boolean isLeap(int year){
        if (year % 400 == 0) return true;
        if (year % 4 == 0) return true;
        
        return false;
    }  
}