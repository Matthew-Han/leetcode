package bfs;

import java.util.*;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/12/28 15:51
 **/
public class MinimumHeightTrees {

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
            int key1 = edge[0];
            int key2 = edge[1];

            // key1
            List<Integer> v1 = map.get(key1);
            if (null == v1) {
                v1 = new ArrayList<>();
            }
            v1.add(key2);
            map.put(key1, v1);

            // key2
            List<Integer> v2 = map.get(key2);
            if (null == v2) {
                v2 = new ArrayList<>();
            }
            v2.add(key1);
            map.put(key2, v2);

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
