package 排列组合;

import java.util.*;

/**
 * @ClassName CombinationSum
 * @Description #39 组合总和
 * @Author MatthewHan
 * @Date 2020/9/9 01:05
 * @Version 1.0
 **/
public class No39 {


    /**
     * 执行用时： 83 ms , 在所有 Java 提交中击败了 5.02% 的用户
     * 内存消耗： 40.6 MB , 在所有 Java 提交中击败了 5.11% 的用户
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> pg1 = new HashSet<>();
        // 排序才能回溯
        Arrays.sort(candidates);
        for (int candidate : candidates) {
            // 头指针是记录总数
            List<Integer> tmp = new ArrayList<>();
            tmp.add(candidate);
            tmp.add(candidate);
            dfs(pg1, candidates, target, tmp);
        }

        return new ArrayList<>(pg1);
    }


    public static void dfs(Set<List<Integer>> res, int[] candidates, int target, List<Integer> list) {
        System.out.println("list = " + list);
        if (list.get(0) == target) {
            list.remove(0);
            /**
             * 排序为了结果[2,2,3]和[2,3,2]都等于7的情况
             */
            list.sort(Integer::compare);
            res.add(list);
            return;
        }
        for (int candidate : candidates) {
            List<Integer> tmp = new ArrayList<>(list);
            int curr = tmp.get(0) + candidate;
            if (curr == target) {
                tmp.add(candidate);
                tmp.remove(0);
                /**
                 * 排序为了结果[2,2,3]和[2,3,2]都等于7的情况
                 */
                tmp.sort(Integer::compare);
                res.add(tmp);
            } else if (curr < target) {
                tmp.add(candidate);
                tmp.set(0, curr);
                dfs(res, candidates, target, tmp);
            }
        }

    }

}
