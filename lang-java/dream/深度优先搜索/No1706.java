package 深度优先搜索;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/3/1 12:34 01
 * @since 1.0
 **/
public class No1706 {

    /**
     * 球会落何处
     *
     * @param g
     * @return
     */
    public int[] findBall(int[][] g) {
        int m = g.length;
        int n = g[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = dfs(g, 0, i);
        }
        return ans;
    }

    public int dfs(int[][] g, int x, int y) {
        if (x >= g.length) {
            return y;
        }
        if (g[x][y] == 1) {
            if (y + 1 < g[0].length && g[x][y + 1] != -1) {
                return dfs(g, x + 1, y + 1);
            } else {
                return -1;
            }
        } else {
            if (y - 1 >= 0 && g[x][y - 1] != 1) {
                return dfs(g, x + 1, y - 1);
            } else {
                return -1;
            }
        }
    }
}
