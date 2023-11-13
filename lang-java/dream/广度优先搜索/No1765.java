package 广度优先搜索;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/31 13:47 31
 * @since 1.0
 **/
public class No1765 {

    /**
     * 地图中的最高点
     *
     * @param isWater
     * @return
     */
    public int[][] highestPeak(int[][] isWater) {
        int[][] ans = new int[isWater.length][isWater[0].length];
        int[][] dxy = new int[][]{{0, 0, -1, 1}, {-1, 1, 0, 0}};
        boolean[][] vis = new boolean[isWater.length][isWater[0].length];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }
        int step = 0;
        while (!q.isEmpty()) {
            int limit = q.size();
            while (limit-- > 0) {
                int[] curr = q.poll();
                ans[curr[0]][curr[1]] = step;
                for (int i = 0; i < 4; i++) {
                    int newX = curr[0] + dxy[0][i];
                    int newY = curr[1] + dxy[1][i];
                    if (newX >= 0 && newY >= 0 && newX < isWater.length && newY < isWater[0].length && !vis[newX][newY]) {
                        vis[newX][newY] = true;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
            step++;
        }
        return ans;
    }

}
