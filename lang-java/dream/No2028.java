import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/3/29 09:08 29
 * @since 1.0
 **/
public class No2028 {

    /**
     * 找出缺失的观测数据
     *
     * @param rolls
     * @param mean
     * @param n
     * @return
     */
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length + n;
        int total = m * mean;
        int[] ans = new int[n];
        int sum = Arrays.stream(rolls).sum();
        int diff = total - sum;
        int avg = diff / n;
        if (diff > 6 * n || diff < n) {
            return new int[0];
        }
        int remainder = diff % n;
        for (int i = 0; i < n; i++) {
            ans[i] = remainder-- > 0 ? avg + 1 : avg;
        }
        return ans;
    }
}
