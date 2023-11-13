package 春季编程大赛2022Team;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/24 16:08 24
 * @since 1.0
 **/
public class Lcp55 {

    /**
     * 采集果实
     *
     * @param time
     * @param fruits
     * @param limit
     * @return
     */
    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int ans = 0;
        for (int[] fruit : fruits) {
            int cnt = (fruit[1] % limit == 0 ? fruit[1] / limit : fruit[1] / limit + 1) * time[fruit[0]];
            ans += cnt;
        }
        return ans;
    }
}
