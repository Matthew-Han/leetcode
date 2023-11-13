package 深度优先搜索;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/2 12:39
 **/
public class No1254 {

    boolean[][] hash;

    /**
     * #1254 统计封闭岛屿的数目
     * 执行用时： 13 ms , 在所有 Java 提交中击败了 5.96% 的用户
     * 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 95.21% 的用户
     *
     * @param grid
     * @return
     */
    public int closedIsland(int[][] grid) {
        int ans = 0;
        hash = new boolean[grid.length][grid[0].length];
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (!hash[i][j] && grid[i][j] == 0) {
                    boolean[][] vis = new boolean[grid.length][grid[0].length];
                    ans += dfs(grid, i, j, vis) ? 1 : 0;
                }
            }
        }
        return ans;

    }

    public boolean dfs(int[][] grid, int i, int j, boolean[][] vis) {
        if (i <= 0 || i >= grid.length - 1 || j <= 0 || j >= grid[0].length - 1) {
            return grid[i][j] != 0;
        }
        if (vis[i][j]) {
            return true;
        }
        vis[i][j] = true;
        hash[i][j] = true;
        if (grid[i][j] == 1) {
            return true;
        } else {

            return dfs(grid, i - 1, j, vis) &&
                    dfs(grid, i + 1, j, vis) &&
                    dfs(grid, i, j - 1, vis) &&
                    dfs(grid, i, j + 1, vis);
        }

    }
}
