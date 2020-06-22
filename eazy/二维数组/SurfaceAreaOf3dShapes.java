package 二维数组;

/**
 * @ClassName SurfaceAreaOf3dShapes
 * @Description #892 三维形体的表面积
 * @Author MatthewHan
 * @Date 2020/6/22 02:42
 * @Version 1.0
 **/
public class SurfaceAreaOf3dShapes {

    /**
     * 官方题解
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 82.23% 的用户
     * 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param grid
     * @return
     */
    public static int surfaceArea(int[][] grid) {

        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int n = grid.length;
        int ans = 0;

        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                if (grid[r][c] > 0) {
                    ans += 2;
                    for (int k = 0; k < 4; ++k) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        int nv = 0;
                        if (0 <= nr && nr < n && 0 <= nc && nc < n) {
                            nv = grid[nr][nc];
                        }

                        ans += Math.max(grid[r][c] - nv, 0);
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 将模型看成多个「柱子」，先求出柱子的全部表面积，再减去相贴的面积
     * <p>
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 46.39% 的用户
     * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param grid
     * @return
     */
    public static int surfaceAreaPro(int[][] grid) {

        int fucker = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 柱子为0，则整个为0
                fucker += (4 * grid[i][j] == 0 ? -2 : 4 * grid[i][j]) + 2;

                if (i - 1 >= 0 && grid[i - 1][j] != 0 && grid[i][j] != 0) {
                    fucker -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                }
                if (j - 1 >= 0 && grid[i][j - 1] != 0 && grid[i][j] != 0) {
                    fucker -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                }
            }
        }
        System.out.println("fucker = " + fucker);

        return fucker;
    }

    public static void main(String[] args) {
        System.out.println(surfaceAreaPro(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));
        System.out.println(surfaceAreaPro(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
        System.out.println(surfaceAreaPro(new int[][]{{1, 1, 1, 1}, {1, 0, 0, 1}, {1, 1, 1, 1}}));
        System.out.println(surfaceAreaPro(new int[][]{{1, 0, 1}}));
        System.out.println(surfaceAreaPro(new int[][]{{1, 0}, {0, 2}}));
    }
}