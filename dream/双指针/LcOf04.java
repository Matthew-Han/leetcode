package 双指针;

import java.util.Arrays;

/**
 * @ClassName LcOf04
 * @Description 剑指 Offer #04 二维数组中的查找
 * @Author MatthewHan
 * @Date 2020/7/16 16:52
 * @Version 1.0
 **/
public class LcOf04 {

    boolean flag = false;

    /**
     * 当成二叉搜索树来做
     * <p>
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 45.5 MB , 在所有 Java 提交中击败了 65.46% 的用户
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        dfs(matrix, matrix.length - 1, 0, target);
        return flag;
    }

    public void dfs(int[][] matrix, int i, int j, int target) {
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                flag = true;
                return;
            } else if (matrix[i][j] < target) {
                dfs(matrix, i, j + 1, target);
            } else {
                dfs(matrix, i - 1, j, target);
            }
        }
    }


}