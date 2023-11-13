package 广度优先搜索;

import java.util.*;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/12/28 15:51
 **/
public class No310 {

    /**
     * #310 最小高度树
     * <p>
     * Floyd 超时了
     *
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>(n);
        if (n == 1) {
            res.add(0);
            return res;
        }
        // 类似邻接表
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            // key1
            map.put(edge[0], map.getOrDefault(edge[0], new ArrayList<>()));
            List<Integer> v1 = map.get(edge[0]);
            v1.add(edge[1]);

            // key2
            map.put(edge[1], map.getOrDefault(edge[1], new ArrayList<>()));
            List<Integer> v2 = map.get(edge[1]);
            v2.add(edge[0]);

        }
        // System.out.println(map);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            int depth = 0;
            boolean[] vis = new boolean[n];
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int curr = queue.poll();
                    if (!vis[curr]) {
                        vis[curr] = true;
                        List<Integer> v = map.get(curr);
                        if (null != v) {
                            for (Integer e : v) {
                                queue.offer(e);
                            }
                        }
                    }
                }
                depth++;
                if (depth > min) {
                    break;
                }
            }
            if (depth == min) {
                res.add(i);
            } else if (depth < min) {
                min = depth;
                res.clear();
                res.add(i);
            }
        }
        return res;

    }
}
