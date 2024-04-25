/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @since 2024/3/14 15:35:46
 **/
public class No2789 {

    /**
     * 合并后数组中的最大元素
     *
     * @param nums
     * @return
     */
    public long maxArrayValue(int[] nums) {
        long ans = nums[0];
        long tmp = nums[nums.length - 1];
        for (int r = nums.length - 1; r > 0; r--) {
            tmp = nums[r - 1] <= tmp ? tmp + nums[r - 1] : nums[r - 1];
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}
