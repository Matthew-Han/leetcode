package 二维数组;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/4 12:37
 * @since 1.0
 **/
public class No2022 {

    /**
     * 将一维数组转变成二维数组
     *
     * @param original
     * @param m
     * @param n
     * @return
     */
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[][]{};
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[i * n + j];
            }
        }
        return ans;
    }
}
