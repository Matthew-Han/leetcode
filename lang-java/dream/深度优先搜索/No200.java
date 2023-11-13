package 深度优先搜索;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/1/26 09:40
 **/
public class No200 {

    /**
     * #200 岛屿数量
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 38.14% 的用户
     * 内存消耗： 41.1 MB , 在所有 Java 提交中击败了 14.53% 的用户
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    boolean[][] vis = new boolean[grid.length][grid[0].length];
                    dfs(grid, i, j, vis);
                }
            }
        }
        return ans;

    }

    public void dfs(char[][] grid, int i, int j, boolean[][] vis) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && !vis[i][j]) {
            if (grid[i][j] == '1') {
                vis[i][j] = true;
                grid[i][j] = '2';
                dfs(grid, i - 1, j, vis);
                dfs(grid, i, j - 1, vis);
                dfs(grid, i + 1, j, vis);
                dfs(grid, i, j + 1, vis);
            }
        }
    }
}
