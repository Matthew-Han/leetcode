package 深度优先搜索;

/**
 * @ClassName MaxAreaOfIsland
 * @Description #695 岛屿的最大面积
 * @Author MatthewHan
 * @Date 2020/8/12 15:13
 * @Version 1.0
 **/
public class No695 {


    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 67.21% 的用户
     * 内存消耗： 40.4 MB , 在所有 Java 提交中击败了 14.56% 的用户
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j, visited));
            }
        }
        return maxArea;
    }

    public static int dfs(int[][] gird, int x, int y, boolean[][] visited) {
        if (x >= 0 && y >= 0 && x < gird.length && y < gird[0].length && !visited[x][y]) {
            visited[x][y] = true;
            if (gird[x][y] == 0) {
                return 0;
            } else {
                return 1 + dfs(gird, x - 1, y, visited)
                        + dfs(gird, x + 1, y, visited)
                        + dfs(gird, x, y - 1, visited)
                        + dfs(gird, x, y + 1, visited);
            }
        } else {
            return 0;
        }
    }

}
