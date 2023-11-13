package 贪心;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/2 16:59
 * @since 1.0
 **/
public class No1833 {

    /**
     * #1833 雪糕的最大数量
     *
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream(int[] costs, int coins) {
        int cnt = 0;
        Arrays.sort(costs);
        for (int n : costs) {
            coins -= n;
            if (coins >= 0) {
                cnt++;
            } else {
                return cnt;
            }
        }
        return cnt;
    }
}
