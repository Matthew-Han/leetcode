package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/2 17:11
 **/
public class No51 {

    List<List<String>> list;


    /**
     * #51 N 皇后
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 27.27% 的用户
     * 内存消耗： 39.2 MB , 在所有 Java 提交中击败了 23.53% 的用户
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        list = new ArrayList<>();
        int[][] vis = new int[n][n];
        dfs(0, vis);
        return list;
    }

    public void dfs(int row, int[][] vis) {
        // System.out.println("hmc: " + Arrays.deepToString(vis));
        if (row == vis.length) {
            for (int[] vi : vis) {
                if (vi[row - 1] == 1) {
                    list.add(listBuilder(vis));
                    return;
                }
            }
            return;
        }

        for (int j = 0; j < vis.length; j++) {
            if (vis[row][j] != -1) {
                int[][] next = deepFuck(vis);
                next[row][j] = 1;
                fuck(next, row, j);
                dfs(row + 1, next);
            }
        }
    }

    public List<String> listBuilder(int[][] vis) {
        List<String> ans = new ArrayList<>();
        for (int[] vi : vis) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < vis.length; j++) {
                sb.append(vi[j] == 1 ? "Q" : ".");
            }
            ans.add(sb.toString());
        }
        return ans;
    }

    public int[][] deepFuck(int[][] vis) {
        int[][] res = new int[vis.length][vis.length];
        for (int i = 0; i < vis.length; i++) {
            System.arraycopy(vis[i], 0, res[i], 0, vis[i].length);
        }
        return res;
    }

    public void fuck(int[][] vis, int i, int j) {
        int ti = i + 1;
        int tj = j - 1;

        while (ti < vis.length && tj >= 0) {
            vis[ti++][tj--] = -1;
        }

        ti = i + 1;
        tj = j + 1;

        while (ti < vis.length && tj < vis.length) {
            vis[ti++][tj++] = -1;

        }
        i++;

        for (; i < vis.length; i++) {
            vis[i][j] = -1;
        }
    }
}
