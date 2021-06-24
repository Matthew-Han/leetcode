package 日期计算;

/**
 * @ClassName 日期.DayOfTheWeek
 * @Description #1185 一周中的第几天
 * @Author MatthewHan
 * @Date 2020/7/7 16:36
 * @Version 1.0
 **/
public class No1185 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37 MB , 在所有 Java 提交中击败了 33.33% 的用户
     *
     * @param day
     * @param month
     * @param year
     * @return
     */
    public static String dayOfTheWeek(int day, int month, int year) {
        // 1971.1.1 是周五
        String[] week = new String[]{"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};

        int totalDays = 0;
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        System.out.println("totalDays = " + totalDays);
        int lastYearDay = dayOfCurrYear(year, month, day);
        System.out.println("lastYearDay = " + lastYearDay);
        totalDays += lastYearDay;

        return week[totalDays % 7];

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
        // 闰年，且月份大于 2 月
        if (isLeapYear(year) && month > 2) {
            sum++;
        }
        return sum - 1;
    }


    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(18, 7, 1996));
    }
}
