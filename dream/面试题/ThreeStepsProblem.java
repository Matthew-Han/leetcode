package 面试题;

/**
 * @ClassName ThreeStepsProblem
 * @Description 面试题 08.01. 三步问题
 * @Author MatthewHan
 * @Date 2020/7/27 17:35
 * @Version 1.0
 **/
public class ThreeStepsProblem {

    /**
     * 执行用时： 33 ms , 在所有 Java 提交中击败了 60.19% 的用户
     * 内存消耗： 45.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @return
     */
    public static int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        long[] dp = new long[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 4; i < n; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1000000007;
        }
        return (int) dp[dp.length - 1] % 1000000007;
    }

    public static void main(String[] args) {
        System.out.println(waysToStep(3));
    }
}
