package 广度优先搜索;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/22 09:15 22
 * @since 1.0
 **/
public class No838 {

    /**
     * 推多米诺
     *
     * @param dominoes
     * @return
     */
    public String pushDominoes(String dominoes) {
        Queue<int[]> q = new LinkedList<>();
        char[] arr = dominoes.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '.') {
                q.offer(new int[]{arr[i] == 'L' ? -1 : 1, i});
            }
        }
        Set<Integer> vis = new HashSet<>();
        while (!q.isEmpty()) {
            int limit = q.size();
            Map<Integer, Integer> tmp = new HashMap<>();
            for (int i = 0; i < limit; i++) {
                int[] curr = q.poll();
                vis.add(curr[1]);
                if (curr[0] == -1) {
                    if (curr[1] >= 1 && arr[curr[1] - 1] == '.') {
                        tmp.put(curr[1] - 1, tmp.getOrDefault(curr[1] - 1, 0) + curr[0]);
                    }
                } else {
                    if (curr[1] < arr.length - 1 && arr[curr[1] + 1] == '.') {
                        tmp.put(curr[1] + 1, tmp.getOrDefault(curr[1] + 1, 0) + curr[0]);
                    }
                }
            }
            for (Map.Entry<Integer, Integer> e : tmp.entrySet()) {
                if (e.getValue() < 0) {
                    arr[e.getKey()] = 'L';
                    if (!vis.contains(e.getKey())) {
                        q.offer(new int[]{-1, e.getKey()});
                    }

                } else if (e.getValue() > 0) {
                    arr[e.getKey()] = 'R';
                    if (!vis.contains(e.getKey())) {
                        q.offer(new int[]{1, e.getKey()});
                    }
                }
            }
        }
        return new String(arr);
    }
}
