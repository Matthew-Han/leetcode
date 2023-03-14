package 贪心;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2023/3/14 10:28 14
 * @since 1.0
 **/
public class No1605 {

    /**
     * 给定行和列的和求可行矩阵
     *
     * @param rowSum
     * @param colSum
     * @return
     */
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                int min = Math.min(rowSum[i], colSum[j]);
                ans[i][j] = min;
                rowSum[i] -= min;
                colSum[j] -= min;
            }
        }
        return ans;
    }
}
