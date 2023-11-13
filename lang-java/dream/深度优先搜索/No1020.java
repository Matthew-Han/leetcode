package 深度优先搜索;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/14 11:21 14
 * @since 1.0
 **/
public class No1020 {


    int[][] g;
    int[][] dxy = {{0, 0, -1, 1}, {-1, 1, 0, 0}};
    int m;
    int n;

    /**
     * 飞地数量
     *
     * @param g
     * @return
     */
    public int numEnclaves(int[][] g) {
        this.g = g;
        this.m = g.length;
        this.n = g[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (g[i][0] == 1) {
                dfs(i, 0);
            }
            if (g[i][n - 1] == 1) {
                dfs(i, n - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (g[0][i] == 1) {
                dfs(0, i);
            }
            if (g[m - 1][i] == 1) {
                dfs(m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += g[i][j] == 1 ? 1 : 0;
            }
        }
        return ans;
    }

    public void dfs(int x, int y) {
        g[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            int newX = x + dxy[0][i];
            int newY = y + dxy[1][i];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && g[newX][newY] == 1) {
                dfs(newX, newY);
            }
        }

    }
}
