package 排列组合;

import java.util.*;

/**
 * @author MatthewHan
 * @description #47 全排列
 * @version 1.0
 * @description
 * @date 2020/9/18 14:14
 **/
public class PermutationsII {


    /**
     * 执行用时： 107 ms , 在所有 Java 提交中击败了 8.92% 的用户
     * 内存消耗： 39.2 MB , 在所有 Java 提交中击败了 95.90% 的用户
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            boolean[] vis = new boolean[nums.length];
            vis[i] = true;
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            dfs(nums, list, res, vis);
        }
        return new ArrayList<>(res);
    }

    public static void dfs(int[] nums, List<Integer> tmp, Set<List<Integer>> res, boolean[] vis) {
        if (tmp.size() == nums.length) {
            res.add(tmp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                boolean[] newVis = vis.clone();
                newVis[i] = true;
                List<Integer> next = new ArrayList<>(tmp);
                next.add(nums[i]);
                dfs(nums, next, res, newVis);
            }
        }
    }
}