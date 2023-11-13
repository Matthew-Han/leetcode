package 二维数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Shift2dGrid
 * @Description #1260 二维网格迁移
 * @Author MatthewHan
 * @Date 2020/7/8 17:08
 * @Version 1.0
 **/
public class No1260 {


    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 70.35% 的用户
     * 内存消耗： 40.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param grid
     * @param k
     * @return
     */
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for (int i = 0; i < k; i++) {
            fuck(grid);
        }
        List<List<Integer>> list = new ArrayList<>(grid.length);
        for (int[] ints : grid) {
            List<Integer> temp = new ArrayList<>(grid[0].length);
            for (int anInt : ints) {
                temp.add(anInt);
            }
            list.add(temp);
        }
        return list;
    }

    public static void fuck(int[][] grid) {
        int n = grid[0].length;
        int temp = grid[grid.length - 1][n - 1];
        for (int i = grid.length - 1; i > 0; i--) {
            grid[i][n - 1] = grid[i - 1][n - 1];
        }
        grid[0][n - 1] = temp;

        for (int[] ints : grid) {
            temp = ints[ints.length - 1];
            System.arraycopy(ints, 0, ints, 1, ints.length - 1);
            ints[0] = temp;
        }
        System.out.println(Arrays.deepToString(grid));
    }

    public static void main(String[] args) {
        System.out.println(shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 4));
    }
}
