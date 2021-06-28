package 第247场周赛;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/28 14:15
 * @since 1.0
 **/
public class No1913 {

    /**
     * #1913 两个数对之间的最大乘积差
     *
     * @param nums
     * @return
     */
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2] - nums[1] * nums[0];
    }
}
