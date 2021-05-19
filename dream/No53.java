import java.util.Arrays;

/**
 * @ClassName MaximumSubarray
 * @Description #53 最大子序和
 * @Author MatthewHan
 * @Date 2020/4/14 10:52
 * @Version 1.0
 **/
public class No53 {

    /**
     * 前和小于 0，丢掉，取当前值存入 dp，前和 = dp[i]
     * 前和大于 0，无论当前值是什么，加上当前值存入 dp，然后前和 = dp[i]
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 95.23% 的用户
     * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 40.45% 的用户
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prev < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = prev + nums[i];
                prev += dp[i];
            }
            System.out.println("dp = " + Arrays.toString(dp));
        }
        int max = Integer.MIN_VALUE;
        for (int n : dp) {
            max = Math.max(max, n);
        }
        return max;
    }

    /**
     * 超出时间限制
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        while (j < nums.length) {
            i = 0;
            while (i + j < nums.length) {
                int sum = 0;
                for (int k = i; k <= i + j; k++) {
                    sum += nums[k];
                }
                max = Math.max(max, sum);
                i++;
            }
            j++;
        }
        return max;
    }


    public static void main(String[] args) {

    }
}
