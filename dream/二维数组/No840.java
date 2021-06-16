package 二维数组;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @ClassName MagicSquaresInGrid
 * @Description #840 矩阵中的幻方
 * @Author MatthewHan
 * @Date 2020/6/20 15:22
 * @Version 1.0
 **/
public class No840 {

    /**
     * 其实只要判断中心是否为 5，为 5 再进行校验，这里没优化
     * 执行用时 : 5 ms , 在所有 Java 提交中击败了 5.46% 的用户
     * 内存消耗 : 38.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param grid
     * @return
     */
    public static int numMagicSquaresInside(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int left = 0;

        int count = 0;
        while (left < x - 2) {
            int low = 0;
            while (low < y - 2) {

                Integer[] check = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                List<Integer> list = new ArrayList<>(Arrays.asList(check));
                for (int i = left; i < left + 3; i++) {
                    for (int j = low; j < low + 3; j++) {
                        list.remove((Object) grid[i][j]);
                    }
                }
                int point1 = grid[left][low] + grid[left][low + 1] + grid[left][low + 2];
                int point2 = grid[left + 1][low] + grid[left + 1][low + 1] + grid[left + 1][low + 2];
                int point3 = grid[left + 2][low] + grid[left + 2][low + 1] + grid[left + 2][low + 2];

                int point4 = grid[left][low] + grid[left + 1][low] + grid[left + 2][low];
                int point5 = grid[left][low + 1] + grid[left + 1][low + 1] + grid[left + 2][low + 1];
                int point6 = grid[left][low + 2] + grid[left + 1][low + 2] + grid[left + 2][low + 2];

                int point7 = grid[left][low] + grid[left + 1][low + 1] + grid[left + 2][low + 2];
                int point8 = grid[left][low + 2] + grid[left + 1][low + 1] + grid[left + 2][low];

                if (list.size() == 0 && point1 == point2 && point1 == point3 && point1 == point4 && point1 == point5 && point1 == point6 && point1 == point7 && point1 == point8) {
                    count++;
                }

                low++;
            }
            left++;

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numMagicSquaresInside(new int[][]{
                {1, 8, 6},
                {10, 5, 0},
                {4, 2, 9}}));
    }
}
