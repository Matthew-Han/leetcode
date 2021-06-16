package 第54场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 15:16
 * @description
 * @since 1.0.0
 **/
public class No1895 {


    /**
     * #1895 最大的幻方
     *
     * @param grid
     * @return
     */
    public int largestMagicSquare(int[][] grid) {
        int ans = 1;
        // 前缀和
        long[][][] cache = new long[grid.length][grid[0].length][4];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                long[] v = new long[4];
                long val = 0;
                // 上
                if (i - 1 >= 0) {
                    val = cache[i - 1][j][0];
                }
                v[0] = val + grid[i][j];
                val = 0;
                // 左上
                if (i - 1 >= 0 && j - 1 >= 0) {
                    val = cache[i - 1][j - 1][1];
                }
                v[1] = val + grid[i][j];
                val = 0;
                // 左
                if (j - 1 >= 0) {
                    val = cache[i][j - 1][2];
                }
                v[2] = val + grid[i][j];
                val = 0;
                // 右上
                if (i - 1 >= 0 && j + 1 < grid[0].length) {
                    val = cache[i - 1][j + 1][3];
                }
                v[3] = val + grid[i][j];

                cache[i][j] = v;
            }
        }
        int min = Math.min(grid.length, grid[0].length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                for (int k = 1; k < min; k++) {
                    if (i + k >= grid.length || j + k >= grid[0].length) {
                        break;
                    }
                    boolean flag1 = true;
                    boolean flag2 = true;
                    // 检测 rows
                    long tmp1 = cache[i][j + k][2] - cache[i][j][2] + grid[i][j];
                    for (int a = i; a < i + k; a++) {
                        long currRow = cache[a][j + k][2] - cache[a][j][2] + grid[a][j];
                        if (tmp1 != currRow) {
                            flag1 = false;
                            break;
                        }
                        tmp1 = currRow;
                    }
                    // 检测 column
                    long tmp2 = cache[i + k][j][0] - cache[i][j][0] + grid[i][j];
                    for (int b = j; b < j + k; b++) {
                        long currColumn = cache[i + k][b][0] - cache[i][b][0] + grid[i][b];
                        if (tmp2 != currColumn) {
                            flag2 = false;
                            break;
                        }
                        tmp2 = currColumn;
                    }
                    // 检测对角线
                    long tmp3 = cache[i + k][j + k][1] - cache[i][j][1] + grid[i][j];
                    long tmp4 = cache[i + k][j][3] - cache[i][j + k][3] + grid[i][j + k];

                    if (flag1 && flag2 && tmp1 == tmp2 && tmp1 == tmp3 && tmp1 == tmp4) {
                        ans = Math.max(ans, k + 1);
                    }
                }
            }
        }
        return ans;
    }

}
