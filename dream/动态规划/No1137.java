package 动态规划;

/**
 * @ClassName NthTribonacciNumber
 * @Description #1137 第 N 个泰波那契数
 * @Author MatthewHan
 * @Date 2020/7/7 09:08
 * @Version 1.0
 **/
public class No1137 {


    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param n
     * @return
     */
    public static int tribonacci(int n) {
        if (n < 3) {
            return n == 0 ? 0 : 1;
        }
        int tmp, x = 0, y = 1, z = 1;
        for (int i = 3; i <= n; ++i) {
            tmp = x + y + z;
            x = y;
            y = z;
            z = tmp;
        }
        return z;

    }

    public static void main(String[] args) {
        System.out.println(tribonacci(5));
    }
}
