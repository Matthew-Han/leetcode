package dp;

import java.util.Arrays;

/**
 * @ClassName LcOf42
 * @Description 剑指 Offer #42 连续子数组的最大和
 * @Author MatthewHan
 * @Date 2020/8/6 11:01
 * @Version 1.0
 **/
public class LcOf42 {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 15.18% 的用户
     * 内存消耗： 46.3 MB , 在所有 Java 提交中击败了 82.10% 的用户
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        System.out.println("dp = " + Arrays.toString(dp));
        int max = Integer.MIN_VALUE;
        for (int n : dp) {
            max = Math.max(max, n);
        }
        return max;
    }

    public static void main(String[] args) {
        maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4, -11, 2, 23, -100, 23, 56, 78, 12, -2});
    }

}
