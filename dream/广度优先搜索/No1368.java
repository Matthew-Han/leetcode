package 广度优先搜索;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/24 16:46 24
 * @since 1.0
 **/
public class No1368 {


    // left, right, up, bottom
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int[] start = {0, 0};
    int[] end;
    int[][] m;
    Map<String, Integer> cache;

    /**
     * 使网格图至少有一条有效路径的最小代价
     *
     * @param matrix
     * @return
     */
    public int minCost(int[][] matrix) {
        this.end = new int[]{matrix.length - 1, matrix[0].length - 1};
        this.m = matrix;
        this.cache = new HashMap<>();
        return bfs();
    }

    public int bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[3] == o2[3]) {
                return Integer.compare(o1[2], o2[2]);
            } else {
                return Integer.compare(o1[3], o2[3]);
            }
        });
        pq.offer(new int[]{start[0], start[1], distance(start, end), 0});
        cache.put(start[0] + " " + start[1], 0);
        while (!pq.isEmpty()) {
            int limit = pq.size();
            for (int i = 0; i < limit; i++) {
                int[] curr = pq.poll();
                if (curr[0] == end[0] && curr[1] == end[1]) {
                    return curr[3];
                }
                int plusOneIdx;
                if (m[curr[0]][curr[1]] == 4) {
                    plusOneIdx = 2;
                } else if (m[curr[0]][curr[1]] == 3) {
                    plusOneIdx = 3;
                } else if (m[curr[0]][curr[1]] == 2) {
                    plusOneIdx = 0;
                } else {
                    plusOneIdx = 1;
                }
                for (int j = 0; j < 4; j++) {
                    int nxtX = curr[0] + dx[j];
                    int nxtY = curr[1] + dy[j];
                    if (nxtX < 0 || nxtX >= m.length || nxtY < 0 || nxtY >= m[0].length) {
                        continue;
                    }
                    String k = nxtX + " " + nxtY;
                    // 剪枝
                    if (cache.containsKey(k) && cache.get(k) <= curr[3]) {
                        continue;
                    }
                    int nxtCost = curr[3] + (plusOneIdx == j ? 0 : 1);
                    cache.put(k, nxtCost);

                    pq.offer(new int[]{nxtX, nxtY, distance(new int[]{nxtX, nxtY}, end), nxtCost});
                }
            }
        }
        return -1;
    }

    public int distance(int[] curr, int[] end) {
        return Math.abs(curr[0] - end[0]) + Math.abs(curr[1] - end[1]);
    }

}
