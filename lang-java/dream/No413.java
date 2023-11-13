/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/18 17:12
 * @since 1.0
 **/
public class No413 {
    
    int ans;

    /**
     * 等差数列划分
     *
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            dfs(nums, i + 2, nums[i + 1], nums[i + 1] - nums[i]);
        }
        return ans;
    }

    public void dfs(int[] nums, int index, int prev, int d) {
        if (index >= nums.length) {
            return;
        }
        if (nums[index] - prev == d) {
            ans++;
            dfs(nums, index + 1, nums[index], d);
        }

    }
}