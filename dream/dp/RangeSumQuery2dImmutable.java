package dp;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/1/7 17:08
 **/
public class RangeSumQuery2dImmutable {

    private final int[][] matrix;

    /**
     * 执行用时： 144 ms , 在所有 Java 提交中击败了 5.29% 的用户
     * 内存消耗： 44.3 MB , 在所有 Java 提交中击败了 20.64% 的用户
     *
     * @param matrix
     */
    public RangeSumQuery2dImmutable(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                ans += matrix[i][j];
            }
        }
        return ans;
    }





}
