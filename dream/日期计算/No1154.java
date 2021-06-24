package 日期计算;

/**
 * @ClassName 日期.DayOfTheYear
 * @Description #1154 一年中的第几天
 * @Author MatthewHan
 * @Date 2020/7/7 10:29
 * @Version 1.0
 **/
public class No1154 {


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 50.00% 的用户
     *
     * @param date
     * @return
     */
    public static int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int[] days = new int[]{0, 31, 28 + 31, 28 + 31 + 31, 28 + 31 + 31 + 30, 28 + 31 + 31 + 30 + 31, 28 + 31 + 31 + 30 + 31 + 30, 365 - 31 - 30 - 31 - 30 - 31, 365 - 31 - 30 - 31 - 30, 365 - 31 - 30 - 31, 365 - 31 - 30, 365 - 31};
        int sum = days[month - 1] + day;
        // 闰年，且月份大于2月
        if (isLeap(year) && month > 2) {
            sum++;
        }
        return sum;
    }

    public static boolean isLeap(int year) {
        // 世纪年：2000、1900 必须满足能被 100 和 400 整除
        if (year % 100 == 0 && year % 400 == 0) {
            return true;
        } else {
            // 普通年必须满足不能被 100 整除但被 4 整数
            return year % 4 == 0 && year % 100 != 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(dayOfYear("1900-03-01"));

    }
}
