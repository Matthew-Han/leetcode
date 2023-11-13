package 第55场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/28 14:14
 * @since 1.0
 **/
public class No1911 {

    /**
     * #1911 最大子序列交替和
     *
     * @param nums
     * @return
     */
    public long maxAlternatingSum(int[] nums) {
        long ans = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                if (i + 1 < nums.length && nums[i] >= nums[i + 1]) {
                    ans += nums[i];
                    cnt++;
                }
            } else if (cnt == 1) {
                if (i + 1 < nums.length && nums[i] <= nums[i + 1]) {
                    ans -= nums[i];
                    cnt++;
                }
            } else if (cnt == 2) {
                if (i + 1 < nums.length && nums[i] >= nums[i + 1]) {
                    ans += nums[i];
                    cnt = 1;
                    continue;
                }
                if (i == nums.length - 1) {
                    ans += nums[i];
                }
            }
        }
        for (int n : nums) {
            ans = Math.max(ans, n);
        }

        return ans;
    }
}
