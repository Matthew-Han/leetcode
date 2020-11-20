package 二维数组;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/20 14:49
 **/
public class RotateImage {

    /**
     * #48 旋转图像
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 80.28% 的用户
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        boolean[][] vis = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (!vis[i][j]) {
                    vis[i][j] = true;
                    vis[j][len - i - 1] = true;
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][len - i - 1];
                    matrix[j][len - i - 1] = tmp;
                }
            }
        }
    }
}
