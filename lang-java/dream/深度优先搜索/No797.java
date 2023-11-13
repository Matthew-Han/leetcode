package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/4 11:58
 **/
public class No797 {

    List<List<Integer>> ans;
    int[][] path;

    /**
     * #797 所有可能的路径
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 88.31% 的用户
     * 内存消耗： 40.5 MB , 在所有 Java 提交中击败了 13.41% 的用户
     *
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        path = graph;
        dfs(new ArrayList<>(), 0);
        return ans;
    }

    public void dfs(List<Integer> list, int index) {
        list.add(index);
        if (index == path.length - 1) {
            ans.add(list);
        }
        int[] next = path[index];
        for (int n : next) {
            List<Integer> tmp = new ArrayList<>(list);
            dfs(tmp, n);
        }

    }
}
