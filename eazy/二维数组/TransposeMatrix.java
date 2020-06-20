package 二维数组;

import java.util.Arrays;

/**
 * @ClassName TransposeMatrix
 * @Description #867 转置矩阵
 * @Author MatthewHan
 * @Date 2020/6/20 23:21
 * @Version 1.0
 **/
public class TransposeMatrix {

    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 40.9 MB , 在所有 Java 提交中击败了 20.00% 的用户
     *
     * @param arr
     * @return
     */
    public static int[][] transpose(int[][] arr) {
        int x = arr.length;
        int y = arr[0].length;
        int[][] fucker = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                fucker[i][j] = arr[j][i];
            }
        }
        System.out.println("fucker = " + Arrays.deepToString(fucker));
        return fucker;
    }

    public static void main(String[] args) {
        transpose(new int[][]{
                {1, 2, 3}
        });
    }
}
