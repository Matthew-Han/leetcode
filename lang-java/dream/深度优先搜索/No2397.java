package 深度优先搜索;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @since 2024/1/4 11:20:12
 **/
public class No2397 {

    int ans = 0;

    /**
     * 被列覆盖的最多行数
     *
     * @param matrix
     * @param numSelect
     * @return
     */
    public int maximumRows(int[][] matrix, int numSelect) {
        dfs(numSelect, matrix, 0);
        return ans;
    }

    public void dfs(int numSelect, int[][] matrix, int index) {
        if (numSelect == 0) {
            ans = Math.max(ans, maxRows(matrix));
            return;
        }
        for (int i = index; i < matrix[0].length; i++) {
            f1(matrix, i);
            dfs(numSelect - 1, matrix, i);
            f2(matrix, i);
        }
    }

    public void f1(int[][] matrix, int c) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][c] += 10000;
        }
    }

    public void f2(int[][] matrix, int c) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][c] -= 10000;
        }
    }

    public int maxRows(int[][] matrix) {
        int ans = 0;
        for (int[] ints : matrix) {
            boolean flag = true;
            for (int anInt : ints) {
                flag = flag && anInt != 1;
            }
            ans += flag ? 1 : 0;
        }
        return ans;
    }
}
