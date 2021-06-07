package 动态规划;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/7 16:33
 * @description
 * @since 1.0.0
 **/
public class No494 {

    int target;
    int ans;

    /**
     * #494 目标和
     * 动态规划还是不会,有空看看背包九讲吧
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        ans = 0;
        dfs(nums, 0, 0);
        return ans;
    }

    public void dfs(int[] nums, int currSum, int index) {
        if (index >= nums.length) {
            ans += currSum == target ? 1 : 0;
            return;
        }
        dfs(nums, currSum + nums[index], index + 1);
        dfs(nums, currSum - nums[index], index + 1);
    }
}
