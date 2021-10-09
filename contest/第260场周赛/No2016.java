package 第260场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/30 16:52
 * @since 1.0
 **/
public class No2016 {

    /**
     * 增量元素之间的最大差值
     *
     * @param nums
     * @return
     */
    public int maximumDifference(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    max = Math.max(max, nums[j] - nums[i]);
                }
            }
        }
        return max == 0 ? -1 : max;
    }
}
