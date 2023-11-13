package 二维数组;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/12/13 10:10
 * @since 1.0
 **/
public class No807 {

    /**
     * 保持城市天际线
     *
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int sum = 0;
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, grid[i][j]);
            }
            row[i] = max;
        }

        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int[] ints : grid) {
                max = Math.max(max, ints[i]);
            }
            col[i] = max;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sum += Math.min(row[j], col[i]) - grid[i][j];
            }
        }
        return sum;
    }

    public static boolean check(int[] bomb1, int[] bomb2) {
        long r = (long) Math.max(bomb1[2], bomb2[2]) * Math.max(bomb1[2], bomb2[2]);
        long x = (long) (bomb1[0] - bomb2[0]) * (bomb1[0] - bomb2[0]) + (long) (bomb1[1] - bomb2[1]) * (bomb1[1] - bomb2[1]);
        return x <= r;
    }

    public static void fuck() {
        String in = "[[56,80,2],[55,9,10],[32,75,2],[87,89,1],[61,94,3],[43,82,9],[17,100,6],[50,6,7],[9,66,7],[98,3,6],[67,50,2],[79,39,5],[92,60,10],[49,9,9],[42,32,10]]";
        System.out.println(in.replace("[[", "{{").replace("],[", "},{").replace("]]", "}}"));
        int[][] ss = new int[][]{{56, 80, 2}, {55, 9, 10}, {32, 75, 2}, {87, 89, 1}, {61, 94, 3}, {43, 82, 9}, {17, 100, 6}, {50, 6, 7}, {9, 66, 7}, {98, 3, 6}, {67, 50, 2}, {79, 39, 5}, {92, 60, 10}, {49, 9, 9}, {42, 32, 10}};
    }

    public static void gg(int[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = i + 1; j < b.length; j++) {
                if (check(b[i], b[j])) {
                    System.out.println(Arrays.toString(b[i]));
                    System.out.println(Arrays.toString(b[j]));
                    System.out.println("------");
                }
            }
        }
    }


    public static void main(String[] args) {

        gg(new int[][]{{56, 80, 2}, {55, 9, 10}, {32, 75, 2}, {87, 89, 1}, {61, 94, 3}, {43, 82, 9}, {17, 100, 6}, {50, 6, 7}, {9, 66, 7}, {98, 3, 6}, {67, 50, 2}, {79, 39, 5}, {92, 60, 10}, {49, 9, 9}, {42, 32, 10}});


    }
}
