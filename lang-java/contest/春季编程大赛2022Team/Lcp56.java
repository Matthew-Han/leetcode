package 春季编程大赛2022Team;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/24 16:40 24
 * @since 1.0
 **/
public class Lcp56 {


    // left, right, up, bottom
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int[] start;
    int[] end;
    char[][] m;
    Map<String, Integer> cache;


    /**
     * 信物传送
     *
     * @param matrix
     * @param start
     * @param end
     * @return
     */
    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        this.start = start;
        this.end = end;
        this.m = new char[matrix.length][matrix[0].length()];
        this.cache = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            m[i] = matrix[i].toCharArray();
        }
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
                if (m[curr[0]][curr[1]] == '^') {
                    plusOneIdx = 2;
                } else if (m[curr[0]][curr[1]] == 'v') {
                    plusOneIdx = 3;
                } else if (m[curr[0]][curr[1]] == '<') {
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
