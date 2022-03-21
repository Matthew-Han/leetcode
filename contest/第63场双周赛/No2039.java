package 第63场双周赛;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/10/18 14:49
 * @since 1.0
 **/
public class No2039 {

    public static class Date20220321 {
        Map<Integer, Integer> best = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        public int networkBecomesIdle(int[][] edges, int[] patience) {
            init(edges);
            bfs();
            int max = 0xc0c0c0c0;
            for (Map.Entry<Integer, Integer> e : best.entrySet()) {
                int curr = e.getKey();
                if (curr == 0) {
                    continue;
                }
                int size = e.getValue();
                int reset = patience[e.getKey()];
                int m = Math.max(0, size * 2 % reset == 0 ? size * 2 / reset - 1 : size * 2 / reset);
                max = Math.max(max, reset * m + size * 2);
            }
            return max + 1;
        }

        public void init(int[][] edges) {
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
        }

        public void bfs() {
            HashSet<Integer> vis = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            vis.add(0);
            int step = 0;
            while (!q.isEmpty()) {
                int limit = q.size();
                for (int i = 0; i < limit; i++) {
                    int curr = q.poll();
                    best.put(curr, step);
                    List<Integer> nxt = map.get(curr);
                    if (nxt.isEmpty()) {
                        continue;
                    }
                    for (int n : nxt) {
                        if (vis.contains(n)) {
                            continue;
                        }
                        q.offer(n);
                        vis.add(n);
                    }
                }
                step++;
            }
        }
    }

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
