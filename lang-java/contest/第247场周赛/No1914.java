package 第247场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/28 14:16
 * @since 1.0
 **/
public class No1914 {

    /**
     * #1914 循环轮转矩阵
     *
     * @param grid
     * @param k
     * @return
     */
    public int[][] rotateGrid(int[][] grid, int k) {
        int x = grid.length;
        int y = grid[0].length;
        // size: 有几个圈
        int size = Math.min(x, y) / 2;
        int start = 0;
        int sum = 2 * (x + y) - 4;
        while (size-- > 0) {
            int tmp = k;
            // tmp: 旋转次数
            tmp %= sum;
            while (tmp-- > 0) {
                // step0
                int tmp0 = grid[x - start - 1][start];
                for (int i = x - 1 - start; i > start; i--) {
                    grid[i][start] = grid[i - 1][start];
                }
                // step1
                int tmp1 = grid[x - start - 1][y - start - 1];
                for (int i = y - 1 - start; i > start; i--) {
                    grid[x - start - 1][i] = grid[x - start - 1][i - 1];
                }
                // 处理边角
                grid[x - start - 1][start + 1] = tmp0;

                // step2
                int tmp2 = grid[start][y - start - 1];
                for (int i = start; i < x - start - 1; i++) {
                    grid[i][y - start - 1] = grid[i + 1][y - start - 1];
                }
                grid[x - start - 2][y - start - 1] = tmp1;
                // step3
                for (int i = start; i < y - start - 1; i++) {
                    grid[start][i] = grid[start][i + 1];
                }
                grid[start][y - start - 2] = tmp2;

            }
            start++;
            sum = 2 * (x + y - start * 4) - 4;
            if (sum <= 0) {
                break;
            }
        }
        return grid;

    }
}
