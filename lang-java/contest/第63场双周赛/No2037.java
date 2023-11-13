package 第63场双周赛;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/10/18 14:47
 * @since 1.0
 **/
public class No2037 {

    /**
     * 使每位学生都有座位的最少移动次数
     *
     * @param seats
     * @param students
     * @return
     */
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for (int i = 0; i < seats.length; i++) {
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }
}
