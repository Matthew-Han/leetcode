package dp;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/30 15:26
 **/
public class LcOf47 {
    /**
     * 剑指 Offer #47 礼物的最大价值
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 82.31% 的用户
     * 内存消耗： 41.1 MB , 在所有 Java 提交中击败了 66.15% 的用户
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j] + Math.max(i - 1 >= 0 ? dp[i - 1][j] : 0, j - 1 >= 0 ? dp[i][j - 1] : 0);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
