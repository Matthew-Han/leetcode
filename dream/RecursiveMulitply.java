/**
 * @ClassName RecursiveMulitply
 * @Description 面试题 08.05. 递归乘法
 * @Author MatthewHan
 * @Date 2020/8/21 12:03
 * @Version 1.0
 **/
public class RecursiveMulitply {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.7 MB , 在所有 Java 提交中击败了 5.23% 的用户
     *
     * @param a
     * @param b
     * @return
     */
    public int multiply(int a, int b) {

        // 防止出现(918795921，1)这种需要加超多次的情况，把绝对值的较小值当做「次数」
        if (Math.abs(a) > Math.abs(b)) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        int ans = dfs(Math.abs(a), b, 0);
        if (a < 0) {
            return -ans;
        } else {
            return ans;
        }
    }

    public static int dfs(int a, int b, int sum) {
        if (a > 1) {
            sum += b;
            a--;
            return dfs(a, b, sum);
        } else {
            return sum;
        }

    }

}
