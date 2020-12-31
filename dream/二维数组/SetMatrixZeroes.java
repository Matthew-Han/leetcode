package 二维数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/12/30 14:54
 **/
public class SetMatrixZeroes {

    /**
     * #73 矩阵置零
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.74% 的用户
     * 内存消耗： 40.2 MB , 在所有 Java 提交中击败了 35.44% 的用户
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        List<int[]> bucket = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    bucket.add(new int[]{i, j});
                }
            }
        }
        for (int[] xy : bucket) {
            tintage(matrix, xy[0], xy[1]);
        }
    }


    public void tintage(int[][] matrix, int x, int y) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][y] = 0;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[x][j] = 0;
        }

    }
}
