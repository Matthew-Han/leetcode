package 第241场周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/18 10:54
 * @description
 * @since 1.0.0
 **/
public class SumOfAllSubsetXorTotals {

    List<Integer> list;

    /**
     * #1863 找出所有子集的异或总和再求和
     *
     * @param nums
     * @return
     */
    public int subsetXORSum(int[] nums) {
        list = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            dfs(nums, 0, 0, i, 0);
        }
        int ans = 0;
        for (int n : list) {
            ans += n;
        }
        return ans;

    }

    public void dfs(int[] nums, int index, int cs, int ts, int curr) {
        if (cs == ts) {
            list.add(curr);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            dfs(nums, i + 1, cs + 1, ts, curr ^ nums[i]);
        }
    }
}
