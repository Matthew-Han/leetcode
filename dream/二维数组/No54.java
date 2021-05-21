package 二维数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/15 01:17
 **/
public class No54 {

    boolean[][] vis;
    List<Integer> ans;

    /**
     * #54 螺旋矩阵
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.6 MB , 在所有 Java 提交中击败了 67.52% 的用户
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        vis = new boolean[matrix.length][matrix[0].length];
        ans = new ArrayList<>(matrix.length * matrix[0].length);
        /*
         * 0: 向右
         * 1: 向下
         * 2: 向左
         * 3: 向上
         */
        dfs(matrix, 0, 0, 0);
        return ans;


    }

    public void dfs(int[][] matrix, int i, int j, int t) {
        if (i >= matrix.length || i < 0 || j < 0 || j >= matrix[0].length || vis[i][j]) {
            return;
        }
        // System.out.println(matrix[i][j]);
        ans.add(matrix[i][j]);
        vis[i][j] = true;
        if (t == 0) {
            if (j == matrix[0].length - 1 || vis[i][j + 1]) {
                dfs(matrix, i + 1, j, 1);
            } else {
                dfs(matrix, i, j + 1, 0);
            }

        } else if (t == 1) {
            if (i == matrix.length - 1 || vis[i + 1][j]) {
                dfs(matrix, i, j - 1, 2);
            } else {
                dfs(matrix, i + 1, j, 1);
            }
        } else if (t == 2) {
            if (j == 0 || vis[i][j - 1]) {
                dfs(matrix, i - 1, j, 3);
            } else {
                dfs(matrix, i, j - 1, 2);
            }
        } else {
            if (i == 0 || vis[i - 1][j]) {
                dfs(matrix, i, j + 1, 0);
            } else {
                dfs(matrix, i - 1, j, 3);
            }

        }

    }
}
