package 第34场双周赛;

/**
 * @ClassName MatrixDiagonalSum
 * @Description #1572 矩阵对角线元素的和
 * @Author MatthewHan
 * @Date 2020/9/5 19:52
 * @Version 1.0
 **/
public class MatrixDiagonalSum {
    int ans;

    public int diagonalSum(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        dfs1(mat, 0, 0, visited);
        dfs2(mat, 0, mat[0].length - 1, visited);
        return ans;
    }

    public void dfs1(int[][] mat, int x, int y, boolean[][] visited) {
        if (x >= 0 && y >= 0 && x < mat.length && y < mat[0].length) {
            if (!visited[x][y]) {
                ans += mat[x][y];
            }
            visited[x][y] = true;
            dfs1(mat, x + 1, y + 1, visited);

        }
    }

    public void dfs2(int[][] mat, int x, int y, boolean[][] visited) {
        if (x >= 0 && y >= 0 && x < mat.length && y < mat[0].length) {
            if (!visited[x][y]) {
                ans += mat[x][y];
            }
            visited[x][y] = true;
            dfs2(mat, x + 1, y - 1, visited);

        }
    }

    public static void main(String[] args) {

    }
}
