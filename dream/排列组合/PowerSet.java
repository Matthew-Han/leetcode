package 排列组合;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName PowerSet
 * @Description 面试题 08.04. 幂集
 * @Author MatthewHan
 * @Date 2020/9/4 17:40
 * @Version 1.0
 **/
public class PowerSet {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 31.40% 的用户
     * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 30.22% 的用户
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            dfs(res, list, nums, i);
        }
        res.add(new ArrayList<>());
        return new ArrayList<>(res);
    }

    public static void dfs(Set<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        if (list.size() == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            List<Integer> next = new ArrayList<>(list);
            next.add(nums[i]);
            res.add(next);
            dfs(res, next, nums, i + 1);
        }
    }
}
