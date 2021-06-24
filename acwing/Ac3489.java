import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/24 16:16
 * @since 1.0
 **/
public class Ac3489 {


    /**
     * 星期几
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dayConvert = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[][] monthConvert = {{"January", "31"}, {"February", "28"}, {"March", "31"},
                {"April", "30"}, {"May", "31"}, {"June", "30"}, {"July", "31"}, {"August", "31"},
                {"September", "30"}, {"October", "31"}, {"November", "30"}, {"December", "31"}};
        Map<String, Integer> monthMap = new HashMap<>();
        for (int i = 0; i < monthConvert.length; i++) {
            monthMap.put(monthConvert[i][0], i + 1);
        }

        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(" ");
            int day = Integer.parseInt(s[0]);
            int month = monthMap.get(s[1]);
            int year = Integer.parseInt(s[2]);

            int currDay = 0;
            for (int i = 1; i < year; i++) {
                if (isLeap(i)) {
                    currDay++;
                }
                currDay += 365;
            }
            // 当前年是不是闰年
            boolean isLeap = isLeap(year);
            for (int i = 1; i < month; i++) {
                currDay += i == 2 && isLeap ? Integer.parseInt(monthConvert[i - 1][1]) + 1 : Integer.parseInt(monthConvert[i - 1][1]);
            }
            currDay += day - 1;
            System.out.println(dayConvert[currDay % dayConvert.length]);
        }

    }

    public static boolean isLeap(int year) {
        // 世纪年：2000、1900必须满足能被 100 和 400 整除
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
