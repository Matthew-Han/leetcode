package 深度优先搜索;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/5 01:35 05
 * @since 1.0
 **/
public class No1219 {
    int ans;
    int[][] dxy;
    int[][] grid;

    /**
     * 黄金矿工
     *
     * @param grid
     * @return
     */
    public int getMaximumGold(int[][] grid) {
        this.ans = 0;
        this.dxy = new int[][]{{0, 0, -1, 1}, {-1, 1, 0, 0}};
        this.grid = grid;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    dfs(i, j, grid[i][j], new boolean[grid.length][grid[0].length]);
                }
            }
        }
        return ans;
    }

    public void dfs(int x, int y, int sum, boolean[][] vis) {
        vis[x][y] = true;
        ans = Math.max(ans, sum);
        for (int i = 0; i < 4; i++) {
            int newX = x + dxy[0][i];
            int newY = y + dxy[1][i];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] > 0 && !vis[newX][newY]) {
                vis[newX][newY] = true;
                dfs(newX, newY, sum + grid[newX][newY], vis);
                vis[newX][newY] = false;
            }
        }
    }
}
