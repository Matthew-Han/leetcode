package 二维数组;

/**
 * @ClassName 二维数组.IslandPerimeter
 * @Description #463 岛屿的周长
 * @Author MatthewHan
 * @Date 2020/5/17 19:20
 * @Version 1.0
 **/
public class IslandPerimeter {

    /**
     * 执行用时 : 7 ms , 在所有 Java 提交中击败了 94.49% 的用户
     * 内存消耗 : 40.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid) {
        int totalPerimeter = 0;
        int y = 0;
        while (y < grid.length) {
            int x = 0;
            while (x < grid[0].length) {
                int currPerimeter = 4;
                if (grid[x][y] == 1) {
                    // 上方格
                    currPerimeter -= x - 1 >= 0 ? grid[x - 1][y] : 0;
                    // 下方格
                    currPerimeter -= x + 1 < grid.length ? grid[x + 1][y] : 0;
                    // 左方格
                    currPerimeter -= y - 1 >= 0 ? grid[x][y - 1] : 0;
                    // 右方格
                    currPerimeter -= y + 1 < grid[0].length ? grid[x][y + 1] : 0;
                    totalPerimeter += currPerimeter;
                    System.out.println("currPerimeter = " + currPerimeter);
                }
                x++;
            }
            y++;
        }
        System.out.println("totalPerimeter = " + totalPerimeter);
        return totalPerimeter;
    }

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}}));
    }
}
