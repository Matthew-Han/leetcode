package 第210场周赛;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author MatthewHan
 * @version 1.0
 * @description
 * @date 2020/10/11 10:22
 **/
public class No1615 {

    public static class Date20230315 {
        Map<Integer, Set<Integer>> map;

        public int maximalNetworkRank(int n, int[][] roads) {
            int max = 0;
            map = new TreeMap<>();
            for (int[] road : roads) {
                Set<Integer> v1 = map.getOrDefault(road[0], new HashSet<>());
                v1.add(road[1]);
                Set<Integer> v2 = map.getOrDefault(road[1], new HashSet<>());
                v2.add(road[0]);
                max = Math.max(max, Math.max(v1.size(), v2.size()));
                map.put(road[0], v1);
                map.put(road[1], v2);
            }
            int ans = max;
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                int k1 = entry.getKey();
                Set<Integer> v1 = entry.getValue();
                if (v1.size() == max) {
                    for (Map.Entry<Integer, Set<Integer>> entry2 : map.entrySet()) {
                        int k2 = entry2.getKey();
                        Set<Integer> v2 = entry2.getValue();
                        if (k1 != k2) {
                            ans = Math.max(ans, v1.size() + v2.size() - (check(k1, k2) ? 1 : 0));
                        }
                    }
                }
            }
            return ans;
        }

        public boolean check(int o1, int o2) {
            return map.getOrDefault(o1, new HashSet<>()).contains(o2);
        }
    }


    /**
     * #1615 最大网络秩
     *
     * @param n
     * @param roads
     * @return
     */
    public int maximalNetworkRank(int n, int[][] roads) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int curr = length(roads, i) + length(roads, j);
                if (check(roads, i, j)) {
                    curr--;
                }
                max = Math.max(max, curr);
            }
        }
        return max;
    }

    public static int length(int[][] roads, int n) {
        int res = 0;
        for (int[] road : roads) {
            if (road[0] == n || road[1] == n) {
                res++;
            }
        }
        return res;
    }

    public static boolean check(int[][] road, int a, int b) {
        for (int[] ints : road) {
            if ((ints[0] == a && ints[1] == b) || (ints[0] == b && ints[1] == a)) {
                return true;
            }
        }
        return false;
    }

}
