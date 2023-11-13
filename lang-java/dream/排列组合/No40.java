package 排列组合;

import java.util.*;

/**
 * @ClassName CombinationSumII
 * @Description #40 组合总和 II
 * @Author MatthewHan
 * @Date 2020/9/10 00:22
 * @Version 1.0
 **/
public class No40 {
    Set<List<Integer>> res;

    /**
     * 执行用时： 46 ms , 在所有 Java 提交中击败了 5.25% 的用户
     * 内存消耗： 40.5 MB , 在所有 Java 提交中击败了 5.01% 的用户
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new HashSet<>();
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(candidates[i]);
            tmp.add(candidates[i]);
            dfs(candidates, target, i + 1, tmp);
        }
        return new ArrayList<>(res);
    }

    public void dfs(int[] candidates, int target, int start, List<Integer> tmp) {
        if (tmp.get(0) == target) {
            tmp.remove(0);
            res.add(tmp);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] == candidates[i - 1]) {
                continue;
            }
            List<Integer> next = new ArrayList<>(tmp);
            int curr = next.get(0) + candidates[i];
            if (curr == target) {
                next.remove(0);
                next.add(candidates[i]);
                res.add(next);
            } else if (curr < target) {
                next.set(0, curr);
                next.add(candidates[i]);
                dfs(candidates, target, i + 1, next);
            }
        }
    }

}
