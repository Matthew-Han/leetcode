package 深度优先搜索;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/31 10:00
 **/
public class No90 {

    List<List<Integer>> ans;
    List[] cache;

    /**
     * #90 子集 II
     * 执行用时： 90 ms , 在所有 Java 提交中击败了 5.51% 的用户
     * 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 5.28% 的用户
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        cache = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, i, 0, new ArrayList<>());
        }
        return ans;
    }

    public void dfs(int[] nums, int size, int start, List<Integer> curr) {
        if (curr.size() == size) {
            listProcessor(curr, size);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            dfs(nums, size, i + 1, curr);
            curr.remove((Object) nums[i]);
        }
    }

    public void listProcessor(List<Integer> src, int size) {
        List<List<Integer>> tmp = cache[size];
        if (tmp == null) {
            tmp = new ArrayList<>();
        }
        Collections.sort(src);
        for (List<Integer> c : tmp) {
            if (c.toString().equals(src.toString())) {
                return;
            }
        }
        List<Integer> newData = new ArrayList<>(src);
        tmp.add(newData);
        cache[size] = tmp;
        ans.add(newData);
    }
}
