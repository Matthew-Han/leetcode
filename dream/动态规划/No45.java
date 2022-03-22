package 动态规划;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/3/22 11:13 22
 * @since 1.0
 **/
public class No45 {
    /**
     * 跳跃游戏 II
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}

