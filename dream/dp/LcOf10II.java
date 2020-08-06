package dp;

/**
 * @ClassName LcOf10II
 * @Description 剑指 Offer #10- II 青蛙跳台阶问题
 * @Author MatthewHan
 * @Date 2020/8/6 14:50
 * @Version 1.0
 **/
public class LcOf10II {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 95.39% 的用户
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n - 1];
    }
}
