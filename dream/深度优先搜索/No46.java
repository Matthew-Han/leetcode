package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/12/29 11:13
 **/
public class No46 {


    /**
     * #46 全排列
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 97.81% 的用户
     * 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 86.96% 的用户
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            boolean[] vis = new boolean[nums.length];
            vis[i] = true;
            dfs(nums, list, res, vis);
        }
        return res;
    }

    public void dfs(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] vis) {
        if (list.size() == nums.length) {
            res.add(list);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                boolean[] next = new boolean[nums.length];
                System.arraycopy(vis, 0, next, 0, nums.length);
                next[i] = true;
                int curr = nums[i];
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(curr);
                dfs(nums, tmp, res, next);
            }
        }
    }
}
