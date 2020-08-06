package dp;


/**
 * @ClassName 动态规划.FibonacciNumber
 * @Description #509 斐波那契数
 * @Author MatthewHan
 * @Date 2020/5/19 14:52
 * @Version 1.0
 **/
public class FibonacciNumber {

    /**
     * 状态方程 f(n) = f(n - 1) + f(n - 2)
     *
     * @param n
     * @return
     */
    public static int fibDp(int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[dp.length - 1];
    }

    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 36.6 MB , 在所有 Java 提交中击败了 5.26% 的用户
     *
     * @param N
     * @return
     */
    public static int fib(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        int last = 0;
        int curr = 1;
        while (N > 1) {
            int next = curr + last;
            last = curr;
            curr = next;
            N--;
        }
        return curr;
    }

    /**
     * 执行用时 : 9 ms , 在所有 Java 提交中击败了 24.98% 的用户
     * 内存消耗 : 36.4 MB , 在所有 Java 提交中击败了 5.26% 的用户
     *
     * @param N
     * @return
     */
    public static int fibPro(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        return fibPro(N - 1) + fibPro(N - 2);
    }


    public static void main(String[] args) {
        System.out.println(fibDp(7));
    }
}
