package 第53场双周赛;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/29 22:27
 * @description
 * @since 1.0.0
 **/
public class No1877 {


    /**
     * #1877 数组中最大数对和的最小值
     *
     * @param nums
     * @return
     */
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0xc0c0c0c0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            ans = Math.max(nums[i] + nums[j], ans);
            i++;
            j--;
        }
        return ans;
    }

}
