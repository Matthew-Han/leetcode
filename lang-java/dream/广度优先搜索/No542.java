package 广度优先搜索;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/4 10:54
 * @since 1.0
 **/
public class No542 {

    /**
     * 01 矩阵
     *
     * @param mat
     * @return
     */
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int[][] ans = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int color = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            ans[curr[0]][curr[1]] = bfs(curr, mat, --color);
        }
        return ans;
    }

    public int bfs(int[] xy, int[][] mat, int color) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(xy);
        int depth = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            int limit = q.size();
            while (limit-- > 0) {
                int[] curr = q.poll();
                if (mat[curr[0]][curr[1]] == 0) {
                    return depth;
                }
                mat[curr[0]][curr[1]] = color;
                for (int i = 0; i < 4; i++) {
                    int newX = curr[0] + dx[i];
                    int newY = curr[1] + dy[i];
                    if (newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[0].length && mat[newX][newY] != color) {
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
            depth++;
        }
        return 0;
    }
}
