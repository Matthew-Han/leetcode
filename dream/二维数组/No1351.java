package 二维数组;

/**
 * @ClassName CountNegativeNumbersInaSortedMatrix
 * @Description #1351 统计有序矩阵中的负数
 * @Author MatthewHan
 * @Date 2020/7/11 00:49
 * @Version 1.0
 **/
public class No1351 {


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 46.46% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param grid
     * @return
     */
    public static int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int k = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= k; j--) {
                if (grid[i][j] >= 0) {
                    k = j - 1;
                    break;
                }
                count++;

            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
