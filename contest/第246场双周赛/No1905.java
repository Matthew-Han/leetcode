package 第246场双周赛;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/21 09:16
 * @since 1.0
 **/
public class No1905 {


    /**
     * #1905 统计子岛屿
     *
     * @param grid1
     * @param grid2
     * @return
     */
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans = 0;
        // 粗略的初始化
        Map<String, Boolean> cache = new HashMap<>(grid1.length * grid1[0].length * 4 / 3 + 1);
        int m = grid1.length;
        int n = grid1[0].length;
        boolean[][] vis1 = new boolean[m][n];
        boolean[][] vis2 = new boolean[m][n];
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (!vis1[i][j] && grid1[i][j] == 1) {
                    List<int[]> tmp = new ArrayList<>();
                    dfs(grid1, i, j, tmp, vis1);
                    for (int[] xy : tmp) {
                        cache.put(xy[0] + ":" + xy[1], true);
                    }
                }
            }
        }
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (!vis2[i][j] && grid2[i][j] == 1) {
                    List<int[]> tmp = new ArrayList<>();
                    dfs(grid2, i, j, tmp, vis2);
                    int cnt = 0;
                    for (int[] xy : tmp) {
                        cnt += cache.containsKey(xy[0] + ":" + xy[1]) ? 1 : 0;
                    }
                    ans += cnt == tmp.size() ? 1 : 0;
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] grid, int i, int j, List<int[]> tmp, boolean[][] vis) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && !vis[i][j]) {
            if (grid[i][j] == 1) {
                vis[i][j] = true;
                tmp.add(new int[]{i, j});
                dfs(grid, i + 1, j, tmp, vis);
                dfs(grid, i, j + 1, tmp, vis);
                dfs(grid, i, j - 1, tmp, vis);
                dfs(grid, i - 1, j, tmp, vis);

            }
        }
    }
}
