package 动态规划;


/**
 * @ClassName TheMasseuse
 * @Description 面试题 17.16. 按摩师
 * @Author MatthewHan
 * @Date 2020/7/29 15:33
 * @Version 1.0
 **/
public class M1716 {

    public static int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];

    }


}
