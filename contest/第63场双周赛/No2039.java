package 第63场双周赛;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/10/18 14:49
 * @since 1.0
 **/
public class No2039 {

    List<Integer> minPath;

    /**
     * 网络空闲的时刻
     *
     * @param edges
     * @param patience
     * @return
     */
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        minPath = new ArrayList<>();
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
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            minPath.add(entry.getKey());
        }
        Collections.fill(minPath, 0x3f3f3f3f);

        dfs(0, map, 1, new HashSet<>());
        minPath.set(0, 0);
        for (int i = 0; i < minPath.size(); i++) {
            minPath.set(i, minPath.get(i) * 2);
        }
        int max = 0;
        for (int i = 0; i < minPath.size(); i++) {
            max = Math.max(maxSec(minPath.get(i), patience[i]) + 1, max);
        }
        return max;
    }


    public int maxSec(int p, int q) {
        if (p > q) {
            int a = p % q == 0 ? Math.max(p / q - 1, 1) : p / q;
            return a * q + p;
        }
        return p;
    }

    public void dfs(int curr, Map<Integer, List<Integer>> map, int path, Set<String> vis) {
        List<Integer> list = map.get(curr);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer l : list) {
            if (vis.contains(l + "-" + curr) || vis.contains(curr + "-" + l)) {
                continue;
            }
            minPath.set(l, Math.min(minPath.get(l), path));
            vis.add(curr + "-" + l);
            dfs(l, map, path + 1, vis);
            vis.remove(curr + "-" + l);
        }
    }
}
