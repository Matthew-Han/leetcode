import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2023/5/15 16:48 15
 * @since 1.0
 **/
public class No1072 {

    /**
     * 按列翻转得到最大值等行数
     *
     * @param matrix
     * @return
     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int[] counter = new int[matrix.length];
        Arrays.fill(counter, 1);
        int ans = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                counter[i] += check(matrix, i, j) ? 1 : 0;
                counter[j] += check(matrix, i, j) ? 1 : 0;
            }
            ans = Math.max(ans, counter[i]);
        }
        return ans;
    }

    public boolean check(int[][] matrix, int x, int y) {
        int len = matrix[x].length;
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            flag = flag & ((matrix[x][i] ^ matrix[y][i]) == 1 ? true : false);
        }
        return flag || Arrays.equals(matrix[x], matrix[y]);
    }
}
