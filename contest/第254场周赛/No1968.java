package 第254场周赛;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/16 10:42
 * @since 1.0
 **/
public class No1968 {

    /**
     * 构造元素不等于两相邻元素平均值的数组
     *
     * @param nums
     * @return
     */
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans[i] = nums[index++];
        }
        for (int i = 1; i < nums.length; i += 2) {
            ans[i] = nums[index++];
        }
        return ans;
    }
}
