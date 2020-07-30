package 动态规划;

/**
 * @ClassName Interview1617
 * @Description 面试题 16.17. 连续数列
 * @Author MatthewHan
 * @Date 2020/7/21 10:13
 * @Version 1.0
 **/
public class Interview1617 {

    /**
     * dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
     * <p>
     * 对于当前的nums[i]
     * 如果dp[i - 1] >= 0 则 dp[i] = dp[i - 1] + nums[i];
     * 否则 dp[i] = nums[i];
     * <p>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 95.01% 的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
