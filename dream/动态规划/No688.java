package 动态规划;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/17 10:28 17
 * @since 1.0
 **/
public class No688 {


    /**
     * 骑士在棋盘上的概率
     *
     * @param n
     * @param k
     * @param row
     * @param column
     * @return
     */
    public double knightProbability(int n, int k, int row, int column) {
        int[][] dxy = {{1, 1, -1, -1, 2, 2, -2, -2}, {-2, 2, -2, 2, -1, 1, -1, 1}};
        double[][][] dp = new double[k + 1][n][n];
        dp[0][row][column] = 1;
        for (int o = 1; o <= k; o++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int u = 0; u < 8; u++) {
                        int x = i + dxy[0][u];
                        int y = j + dxy[1][u];
                        if (x >= 0 && y >= 0 && x < n && y < n) {
                            dp[o][x][y] += dp[o - 1][i][j] / 8;
                        }
                    }
                }
            }
        }
        double ans = 0d;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += dp[k][i][j];
            }
        }
        return ans;
    }


}
