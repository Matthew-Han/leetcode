import java.util.*;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/26 10:00
 **/
public class MaximumGap {

    /**
     * #164 最大间距
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 99.72% 的用户
     * 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 78.87% 的用户
     *
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        int ans = 0;
        if (nums.length < 2) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            ans = Math.max(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }

}
