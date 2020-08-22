package 第33场双周赛;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Test2
 * @Description #5480 可以到达所有点的最少点数目
 * @Author MatthewHan
 * @Date 2020/8/22 22:18
 * @Version 1.0
 **/
public class MinimumNumberOfVerticesToReachAllNodes {

    /**
     * 执行用时： 43 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 79.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set = new HashSet<>();
        for (List<Integer> edge : edges) {
            set.add(edge.get(0));

        }
        for (List<Integer> edge : edges) {
            set.remove(edge.get(1));
        }
        return new ArrayList<>(set);
    }
}
