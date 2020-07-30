package 二维数组;

/**
 * @ClassName ToeplitzMatrix
 * @Description #766 托普利茨矩阵
 * @Author MatthewHan
 * @Date 2020/6/16 14:59
 * @Version 1.0
 **/
public class ToeplitzMatrix {


    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 40 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param matrix
     * @return
     */
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int x = matrix.length - 1;
        int y = matrix[0].length - 1;
        for (int i = 0; i < x; i++) {
            int j = 0;
            int temp = matrix[i][j];
            int a = i;
            int b = j;
            while (a <= x && b <= y) {
                if (temp != matrix[a][b]) {
                    return false;
                }
                a++;
                b++;
            }
        }
        for (int j = 0; j < y; j++) {
            int i = 0;
            int temp = matrix[i][j];
            int a = i;
            int b = j;
            while (a <= x && b <= y) {
                if (temp != matrix[a][b]) {
                    return false;
                }
                a++;
                b++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{{11, 74, 0, 9}, {40, 11, 74, 7}}));
    }
}
