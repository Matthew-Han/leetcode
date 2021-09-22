package 动态规划;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/22 10:44
 * @since 1.0
 **/
public class No650 {

    /**
     * 只有两个键的键盘
     *
     * @param n
     * @return
     */
    public int minSteps(int n) {
        int ans = 0;
        while (n > 1) {
            for (int q = 2; q <= n; q++) {
                if (n % q == 0) {
                    n /= q;
                    ans += q;
                    break;
                }
            }
        }
        return ans;
    }
}
