package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/19 17:36
 **/
public class M0802 {

    boolean flag = false;

    List<List<Integer>> ans = new ArrayList<>();

    /**
     * 面试题 08.02. 迷路的机器人
     *
     * @param obstacleGrid
     * @return
     */
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        boolean[][] vis = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        List<List<Integer>> list = new ArrayList<>();
        dfs(obstacleGrid, 0, 0, vis, list);
        return ans;

    }

    public void dfs(int[][] obstacleGrid, int x, int y, boolean[][] vis, List<List<Integer>> list) {
        if (!flag && x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1 && obstacleGrid[x][y] == 0) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(x);
            tmp.add(y);
            list.add(tmp);
            ans = list;
            flag = true;
            // System.out.println(list);
            return;
        }
        if (!flag && !vis[x][y] && obstacleGrid[x][y] == 0) {
            vis[x][y] = true;
            List<Integer> tmp = new ArrayList<>();
            tmp.add(x);
            tmp.add(y);
            List<List<Integer>> next = new ArrayList<>(list);
            next.add(tmp);
            if (x + 1 < obstacleGrid.length) {
                if (obstacleGrid[x + 1][y] != 1) {
                    dfs(obstacleGrid, x + 1, y, vis(vis, obstacleGrid.length, obstacleGrid[0].length), next);
                }
            }
            if (y + 1 < obstacleGrid[0].length) {
                if (obstacleGrid[x][y + 1] != 1) {
                    dfs(obstacleGrid, x, y + 1, vis(vis, obstacleGrid.length, obstacleGrid[0].length), next);
                }
            }
        }
    }

    public boolean[][] vis(boolean[][] vis, int m, int n) {
        boolean[][] res = new boolean[m][n];
        for (int i = 0; i < vis.length; i++) {
            System.arraycopy(vis[i], 0, res[i], 0, vis[i].length);
        }
        return res;
    }
}
