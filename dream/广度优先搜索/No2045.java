package 广度优先搜索;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/24 10:15 24
 * @since 1.0
 **/
public class No2045 {

    int currSec;
    Map<Integer, int[]> vis;
    Map<Integer, PriorityQueue<Integer>> map;


    /**
     * 到达目的地的第二短时间
     *
     * @param n
     * @param edges
     * @param time
     * @param change
     * @return
     */
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        this.currSec = 0;
        this.vis = new HashMap<>();
        this.map = new HashMap<>();
        for (int[] edge : edges) {
            // key1
            map.put(edge[0], map.getOrDefault(edge[0], new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1))));
            PriorityQueue<Integer> v1 = map.get(edge[0]);
            v1.offer(edge[1]);

            // key2
            map.put(edge[1], map.getOrDefault(edge[1], new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1))));
            PriorityQueue<Integer> v2 = map.get(edge[1]);
            v2.offer(edge[0]);
        }
        for (int i = 1; i <= n; i++) {
            vis.put(i, new int[]{0x3f3f3f3f, 0x3f3f3f3f});
        }
        return bfs(time, change, n);

    }

    public int bfs(int time, int change, int n) {
        int min = -1;
        // 当前时间
        int currTime = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int prev = change;
        int step = 1;
        while (!q.isEmpty()) {
            int[] xy = fuck(currTime, change, prev);
            currTime = xy[0];
            prev = xy[1];
            currTime += time;

            int limit = q.size();
            for (int i = 0; i < limit; i++) {
                int curr = q.poll();
                int[] visSub = vis.get(curr);
                if (visSub[0] >= step) {
                    visSub[0] = step;
                } else if (visSub[1] > step) {
                    visSub[1] = step;
                } else {
                    continue;
                }
                PriorityQueue<Integer> sub = map.get(curr);
                PriorityQueue<Integer> backup = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
                while (!sub.isEmpty()) {
                    int s = sub.poll();

                    if (s == n) {
                        if (min == -1) {
                            min = currTime;
                        } else {
                            if (min != currTime) {
                                return currTime;
                            }
                        }
                    }
                    backup.offer(s);
                    q.offer(s);

                }
                sub = backup;
                map.put(curr, sub);
            }
            step++;

        }
        return min;

    }

    public int[] fuck(int currTime, int change, int prev) {
        while (prev <= currTime - 2 * change) {
            prev += 2 * change;
        }
        if (prev <= currTime && prev + change >= currTime) {
            return new int[]{prev + change, prev};
        }
        return new int[]{currTime, prev};
    }

}
