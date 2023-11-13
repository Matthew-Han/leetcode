/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/3/4 10:09 04
 * @since 1.0
 **/
public class No2104 {

    /**
     * 子数组范围和
     *
     * @param nums
     * @return
     */
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                ans += max - min;
            }
        }
        return ans;
    }
}
