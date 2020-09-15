package dp;

/**
 * @ClassName MinimumPathSum
 * @Description #64 最小路径和
 * @Author MatthewHan
 * @Date 2020/9/12 23:43
 * @Version 1.0
 **/
public class MinimumPathSum {

    int min = Integer.MAX_VALUE;

    /**
     * dfs超时
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        dfs(grid, 0, 0, 0, 0);
        return min;
    }

    public void dfs(int[][] grid, int i, int j, Integer sum, int size) {
        if (size == (grid.length + grid[0].length - 1)) {
            min = Math.min(min, sum);
        }
        if (i < grid.length && j < grid[0].length) {
            sum += grid[i][j];
            dfs(grid, i + 1, j, sum, size + 1);
            dfs(grid, i, j + 1, sum, size + 1);

        }
    }


    /**
     * dp可解
     *
     * @param grid
     * @return
     */
    public int minPathSumDp(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] += grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] += grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                int curr = grid[i][j];
                dp[i][j] = curr + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        minimumPathSum.minPathSum(new int[][]{{3, 2, 1}, {0, 1, 2}});
    }

}
