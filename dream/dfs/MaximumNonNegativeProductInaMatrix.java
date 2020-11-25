package dfs;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/25 12:53
 **/
public class MaximumNonNegativeProductInaMatrix {

    long max = -1;

    long mod = 1000000000 + 7;

    /**
     * #1594 矩阵的最大非负积
     * 执行用时： 378 ms , 在所有 Java 提交中击败了 10.43% 的用户
     * 内存消耗： 37.6 MB , 在所有 Java 提交中击败了 96.92% 的用户
     *
     * @param grid
     * @return
     */
    public int maxProductPath(int[][] grid) {
        dfs(grid, 0, 0, 1);
        return (int) (max % mod);
    }

    public void dfs(int[][] grid, int x, int y, long xy) {
        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
            if (grid[x][y] == 0) {
                max = Math.max(max, 0);
                return;
            }

            xy = xy * grid[x][y];
            if (x == grid.length - 1 && y == grid[0].length - 1) {
                if (xy >= 0) {
                    max = Math.max(max, xy);

                }
                return;
            }
            dfs(grid, x + 1, y, xy);
            dfs(grid, x, y + 1, xy);
        }
    }
}
