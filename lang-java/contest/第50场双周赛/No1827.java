package 第50场双周赛;

/**
 * @author Matthew Han
 * @description
 * @date 2021/4/17 22:27
 * @since 1.0.0
 **/
public class No1827 {


    /**
     * #1827 最少操作使数组递增
     * @param nums
     * @return
     */
    public int minOperations(int[] nums) {
        int ans = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= prev) {
                ans += prev - nums[i] + 1;
                nums[i] = prev + 1;
            }
            prev = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
