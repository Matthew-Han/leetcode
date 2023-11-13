package 双指针;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/8 10:02
 * @since 1.0
 **/
public class No930 {

    /**
     * 和相同的二元子数组
     *
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                if (sum + nums[j] == goal) {
                    ans++;
                } else if (sum > goal) {
                    break;
                }
                sum += nums[j];
            }
        }
        return ans;
    }

}
