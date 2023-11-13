package 广度优先搜索;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/28 15:25
 * @since 1.0
 **/
public class No815 {

    /**
     * 该题优化,不 TLE ,存储路线,而不是沾点
     * <p>
     * BFS优化,不要在 <code>queue.poll()</code> 去判断是否访问过
     * 而是在放入 queue 的时候去判断是否访问过
     * <p>
     * #815 公交路线
     *
     * @param routes
     * @param source
     * @param target
     * @return
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        int start = -1;
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (map.containsKey(routes[i][j])) {
                    map.get(routes[i][j]).add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(routes[i][j], list);
                }
                if (source == routes[i][j]) {
                    queue.offer(new int[]{source, i});
                }
            }
        }
        // 这里的的 val 是 routes 的 index
        Set<Integer> vis = new HashSet<>();
        int depth = 0;
        while (!queue.isEmpty()) {
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                int[] tmp = queue.poll();
                int curr = tmp[0];
                if (curr == target) {
                    return depth;
                }
                List<Integer> list = map.get(curr);
                for (Integer l : list) {
                    if (vis.contains(l)) {
                        continue;
                    }
                    for (int j = 0; j < routes[l].length; j++) {
                        queue.offer(new int[]{routes[l][j], l});
                    }
                    vis.add(l);
                }
            }
            depth++;
        }
        return -1;
    }
}
