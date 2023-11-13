/**
 * @ClassName MinimumOperationsToMakeArrayEqual
 * @Description #1551 使数组中所有元素相等的最小操作数
 * @Author MatthewHan
 * @Date 2020/9/4 15:59
 * @Version 1.0
 **/
public class No1551 {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 68.74% 的用户
     * 内存消耗： 36.5 MB , 在所有 Java 提交中击败了 75.50% 的用户
     *
     * @param n
     * @return
     */
    public int minOperations(int n) {
        if (n == 1) {
            return 0;
        }
        int num = (2 * (n - 1)) + 2;
        int count = 0;
        int tmp = num / 2;
        // num为偶数，说明奇数个
        if ((n & 1) == 0) {
            for (int i = 1; i < tmp; i += 2) {
                count += tmp - i;
            }
            return count;
        } else {
            return (2 * (n - 1)) / tmp;
        }
    }
}
