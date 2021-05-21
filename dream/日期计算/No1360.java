package 日期计算;

/**
 * @ClassName NumberOfDaysBetweenTwoDates
 * @Description #1360 日期之间隔几天
 * @Author MatthewHan
 * @Date 2020/7/11 02:13
 * @Version 1.0
 **/
public class No1360 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param date1
     * @param date2
     * @return
     */
    public int daysBetweenDates(String date1, String date2) {
        int year1 = Integer.parseInt(date1.substring(0, 4));
        int month1 = Integer.parseInt(date1.substring(5, 7));
        int day1 = Integer.parseInt(date1.substring(8, 10));

        int year2 = Integer.parseInt(date2.substring(0, 4));
        int month2 = Integer.parseInt(date2.substring(5, 7));
        int day2 = Integer.parseInt(date2.substring(8, 10));

        return Math.abs(totalDays(year2, month2, day2) - totalDays(year1, month1, day1));
    }

    public static int totalDays(int year, int month, int day) {
        int totalDays = 0;
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }
        int lastYearDay1 = dayOfCurrYear(year, month, day);
        totalDays += lastYearDay1;
        return totalDays;
    }

    public static boolean isLeapYear(int year) {
        // 世纪年：2000、1900 必须满足能被 100 和 400 整除
        if (year % 100 == 0 && year % 400 == 0) {
            return true;
        } else {
            // 普通年必须满足不能被 100 整除但被 4 整数
            return year % 4 == 0 && year % 100 != 0;
        }
    }

    public static int dayOfCurrYear(int year, int month, int day) {
        int[] days = new int[]{0, 31, 28 + 31, 28 + 31 + 31, 28 + 31 + 31 + 30, 28 + 31 + 31 + 30 + 31, 28 + 31 + 31 + 30 + 31 + 30, 365 - 31 - 30 - 31 - 30 - 31, 365 - 31 - 30 - 31 - 30, 365 - 31 - 30 - 31, 365 - 31 - 30, 365 - 31};
        int sum = days[month - 1] + day;
        // 闰年，且月份大于2月
        if (isLeapYear(year) && month > 2) {
            sum++;
        }
        return sum - 1;
    }
}
