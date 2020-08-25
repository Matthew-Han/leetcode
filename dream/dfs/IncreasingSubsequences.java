package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName IncreasingSubsequences
 * @Description #491 递增子序列
 * @Author MatthewHan
 * @Date 2020/8/25 15:51
 * @Version 1.0
 **/
public class IncreasingSubsequences {

    /**
     * 排列组合的dfs
     * 执行用时： 16 ms , 在所有 Java 提交中击败了 37.45% 的用户
     * 内存消耗： 48.2 MB , 在所有 Java 提交中击败了 11.50% 的用户
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> tmp = new ArrayList<>(nums.length);
            tmp.add(nums[i]);
            dfs(res, tmp, nums, i + 1);
        }
        return new ArrayList<>(res);
    }

    public static void dfs(Set<List<Integer>> res, List<Integer> tmp, int[] nums, int limit) {
        if (limit == nums.length) {
            return;
        }
        for (int i = limit; i < nums.length; i++) {
            if (tmp.get(tmp.size() - 1) <= nums[i]) {
                List<Integer> next = new ArrayList<>(tmp);
                next.add(nums[i]);
                res.add(next);
                dfs(res, next, nums, i + 1);
            }
        }
    }


    public static void main(String[] args) {
        findSubsequences(new int[]{4, 6, 7, 7});
    }
}
