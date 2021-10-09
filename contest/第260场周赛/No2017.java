package 第260场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/30 16:46
 * @since 1.0
 **/
public class No2017 {

    /**
     * 网格游戏
     *
     * @param grid
     * @return
     */
    public long gridGame(int[][] grid) {
        long ans = Long.MAX_VALUE;
        long left = 0L;
        long right = 0L;
        for (int i = 1; i < grid[0].length; i++) {
            right += grid[0][i];
        }
        ans = Math.min(ans, Math.max(left, right));
        for (int i = 1; i < grid[0].length; i++) {
            left += grid[1][i - 1];
            right -= grid[0][i];
            ans = Math.min(ans, Math.max(left, right));
        }
        return ans;
    }
}
