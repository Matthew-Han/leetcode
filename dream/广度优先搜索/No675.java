package 广度优先搜索;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/5/23 16:49 23
 * @since 1.0
 **/
public class No675 {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    TreeMap<Integer, int[]> map = new TreeMap<>();

    /**
     * 为高尔夫比赛砍树
     *
     * @param forest
     * @return
     */
    public int cutOffTree(List<List<Integer>> forest) {
        int ans = 0;
        find(forest);
        int[] src = new int[]{0, 0};
        for (Map.Entry<Integer, int[]> e : map.entrySet()) {
            int k = e.getKey();
            int[] v = e.getValue();
            int step = 润(forest, src, v);
            if (step == -1) {
                return -1;
            } else {
                ans += step;
            }
            src = v;
        }
        return ans;
    }

    public int 润(List<List<Integer>> forest, int[] src, int[] dest) {
        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src[0], src[1]});
        boolean[][] vis = new boolean[forest.size()][forest.get(0).size()];
        while (!q.isEmpty()) {
            int limit = q.size();
            for (int j = 0; j < limit; j++) {
                int[] curr = q.poll();
                if (curr[0] == dest[0] && curr[1] == dest[1]) {
                    return ans;
                }
                for (int i = 0; i < 4; i++) {
                    int newX = curr[0] + dx[i];
                    int newY = curr[1] + dy[i];
                    if (newX < forest.size() && newX >= 0 && newY < forest.get(0).size() && newY >= 0 && !vis[newX][newY] && forest.get(newX).get(newY) != 0) {
                        vis[newX][newY] = true;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    public void find(List<List<Integer>> forest) {
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                int curr = forest.get(i).get(j);
                if (curr != 0 && curr != 1) {
                    map.put(curr, new int[]{i, j});
                }
            }
        }
    }
}
