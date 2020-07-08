package 二维数组;

import java.util.Arrays;

/**
 * @ClassName CellsWithOddValuesInaMatrix
 * @Description #1252 奇数值单元格的数目
 * @Author MatthewHan
 * @Date 2020/7/8 16:45
 * @Version 1.0
 **/
public class CellsWithOddValuesInaMatrix {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 48.09% 的用户
     * 内存消耗： 37.8 MB , 在所有 Java 提交中击败了 33.33% 的用户
     *
     * @param n
     * @param m
     * @param indices
     * @return
     */
    public static int oddCells(int n, int m, int[][] indices) {
        int[][] result = new int[n][m];
        for (int j = 0; j < result[0].length; j++) {
            for (int[] index : indices) {
                result[index[0]][j]++;
            }

        }
        for (int j = 0; j < result.length; j++) {
            for (int[] index : indices) {
                result[j][index[1]]++;
            }
        }
        System.out.println("result = " + Arrays.deepToString(result));
        int count = 0;
        for (int[] ints : result) {
            for (int anInt : ints) {
                if ((anInt & 1) != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
    }
}
