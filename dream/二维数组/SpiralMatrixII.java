package 二维数组;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/16 10:41
 **/
public class SpiralMatrixII {

    int[][] matrix;
    boolean[][] vis;

    /**
     * #59 螺旋矩阵 II
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 94.96% 的用户
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        matrix = new int[n][n];
        vis = new boolean[n][n];
        dfs(0, 0, 1, 0);
        return matrix;
    }

    public void dfs(int i, int j, int x, int toWard) {
        if (i > matrix.length - 1 || j > matrix[0].length - 1 || i < 0 || j < 0 || vis[i][j]) {
            return;
        }
        matrix[i][j] = x;
        vis[i][j] = true;
        x++;
        if (toWard == 0) {
            if (j == matrix[0].length - 1 || vis[i][j + 1]) {
                dfs(i + 1, j, x, 1);
            } else {
                dfs(i, j + 1, x, 0);
            }
        } else if (toWard == 1) {
            if (i == matrix.length - 1 || vis[i + 1][j]) {
                dfs(i, j - 1, x, 2);
            } else {
                dfs(i + 1, j, x, 1);
            }
        } else if (toWard == 2) {
            if (j == 0 || vis[i][j - 1]) {
                dfs(i - 1, j, x, 3);
            } else {
                dfs(i, j - 1, x, 2);
            }
        } else {
            if (i == 0 || vis[i - 1][j]) {
                dfs(i, j + 1, x, 0);
            } else {
                dfs(i - 1, j, x, 3);
            }
        }
    }
}
