package 第60场双周赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/6 17:51
 * @since 1.0
 **/
public class No1992 {

    /**
     * 找到所有的农场组
     *
     * @param land
     * @return
     */
    public int[][] findFarmland(int[][] land) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean flag = false;
        boolean[][] vis = new boolean[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (!vis[i][j] && land[i][j] == 1) {
                    vis[i][j] = true;
                    int[] t = fuck(land, i, j);
                    for (int k = i; k <= t[0]; k++) {
                        for (int k1 = j; k1 <= t[1]; k1++) {
                            vis[k][k1] = true;
                        }
                    }
                    ans.add(Arrays.asList(i, j, t[0], t[1]));

                }
            }
        }
        int[][] res = new int[ans.size()][4];
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                res[i][j] = ans.get(i).get(j);
            }
        }
        return res;

    }

    public int[] fuck(int[][] land, int x, int y) {
        int row = x;
        int col = y;
        for (int i = x + 1; i < land.length; i++) {
            if (land[i][y] != 1) {
                row = i - 1;
                break;
            }
            if (i == land.length - 1 && land[i][y] == 1) {
                row = i;
            }
        }
        for (int i = y + 1; i < land[x].length; i++) {
            if (land[x][i] != 1) {
                col = i - 1;
                break;
            }
            if (i == land[x].length - 1 && land[x][i] == 1) {
                col = i;
            }
        }
        return new int[]{row, col};
    }

}
