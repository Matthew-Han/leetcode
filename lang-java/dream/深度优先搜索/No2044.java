package 深度优先搜索;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/3/18 12:19 18
 * @since 1.0
 **/
public class No2044 {


    /**
     * 统计按位或能得到最大值的子集数目
     *
     * @param nums
     * @return
     */
    public int countMaxOrSubsets(int[] nums) {
        int max = Arrays.stream(nums).reduce((x, y) -> x | y).orElse(0);
        return dfs(nums, max, 0, 0);
    }

    public int dfs(int[] nums, int max, int curr, int prev) {
        if (curr < nums.length) {
            return dfs(nums, max, curr + 1, prev | nums[curr]) + dfs(nums, max, curr + 1, prev);
        } else {
            return prev == max ? 1 : 0;
        }
    }

}
