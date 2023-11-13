package 第61场双周赛;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/22 09:12
 * @since 1.0
 **/
public class No2008 {

    /**
     * 出租车的最大盈利
     *
     * @param n
     * @param rides
     * @return
     */
    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] dp = new long[rides.length];
        Arrays.sort(rides, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        dp[0] = rides[0][1] - rides[0][0] + rides[0][2];
        for (int i = 1; i < rides.length; i++) {
            dp[i] = rides[i][1] - rides[i][0] + rides[i][2];
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int mid = (left + right + 1) >> 1;
                if (rides[mid][1] <= rides[i][0]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            if (rides[left][1] <= rides[i][0]) {
                dp[i] += dp[left];
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
