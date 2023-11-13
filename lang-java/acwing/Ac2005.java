import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/7 09:39
 * @since 1.0
 **/
public class Ac2005 {

    static char[][] mat;

    static int[][] dxy = {{0, 0, -1, 1}, {-1, 1, 0, 0}};

    static int ans;

    /**
     * 马蹄铁
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        mat = new char[n][n];
        for (int i = 0; i < n; i++) {
            mat[i] = sc.readLine().toCharArray();
        }
        ans = 0;
        if (mat[0][0] == '(') {
            boolean[][] vis = new boolean[n][n];
            vis[0][0] = true;
            dfs(0, 0, 1, 1, true, vis);
        }

        System.out.println(ans * 2);
    }

    public static void dfs(int x, int y, int cnt, int step, boolean flag, boolean[][] vis) {
        if (!flag && cnt == 0) {
            ans = Math.max(ans, step);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + dxy[0][i];
            int newY = y + dxy[1][i];
            if (newX >= 0 && newY >= 0 && newX < vis.length && newY < vis[0].length && !vis[newX][newY]) {
                // flag == true 还是 ( 阶段
                if (flag && mat[newX][newY] == '(') {
                    vis[newX][newY] = true;
                    dfs(newX, newY, cnt + 1, step + 1, true, vis);
                    vis[newX][newY] = false;
                }
                if (mat[newX][newY] == ')') {
                    vis[newX][newY] = true;
                    dfs(newX, newY, cnt - 1, step, false, vis);
                    vis[newX][newY] = false;
                }
            }
        }
    }
}
