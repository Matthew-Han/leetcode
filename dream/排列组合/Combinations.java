package 排列组合;

import java.util.*;

/**
 * @ClassName Combinations
 * @Description #77 组合
 * @Author MatthewHan
 * @Date 2020/9/8 09:19
 * @Version 1.0
 **/
public class Combinations {

    /**
     * 执行用时： 70 ms , 在所有 Java 提交中击败了 9.87% 的用户
     * 内存消耗： 41.1 MB , 在所有 Java 提交中击败了 55.85% 的用户
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0) {
            return new ArrayList<>(Collections.singleton(new ArrayList<>()));
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            dfs(n, k, list, res);
        }
        return res;

    }

    public static void dfs(int n, int k, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(list);
        }
        int start = list.get(list.size() - 1);
        for (int j = start + 1; j <= n; j++) {
            List<Integer> tmp = new ArrayList<>(list);
            tmp.add(j);
            dfs(n, k, tmp, res);
        }
    }

    /**
     * 回溯法案例，有空回来学学
     */
    private List<List<Integer>>  res = new LinkedList<>();
    public List<List<Integer>> huisu(int n, int k) {
        // 边界值
        if (n < k) {
            return res;
        }
        helper(n, k, new LinkedList(),1);
        return res;
    }
    private void helper(int n, int k, LinkedList<Integer> curr, int index){
        // 递归结束条件
        if (curr.size() == k){
            res.add(new LinkedList<>(curr));
            return;
        }
        // 开始递归
        for (int i = index ; i <= n; ++i){
            // 添加一个数
            curr.add(i);
            // i + 1 是从下一个开始，要不就重复了
            helper(n, k , curr, i + 1);
            // 回溯，长度够了，删掉最后一个，再次循环，找下一个满足的组合
            curr.removeLast();
        }
    }
}
