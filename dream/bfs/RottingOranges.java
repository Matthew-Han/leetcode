package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName RottingOranges
 * @Description #994 腐烂的橘子
 * @Author MatthewHan
 * @Date 2020/8/26 10:08
 * @Version 1.0
 **/
public class RottingOranges {


    /**
     * 这题主要是一个新鲜橘子会被多个「源」传染，所以「最短路径」需要取最小的，也就是每个新鲜橘子被感染的是最近的烂橘子，
     * 最后只要找出网格中最大的最短路径就行了。
     *
     * 1. 先找出所有的烂橘子（val = 2），每个烂橘子bfs遍历
     * 2. 每个烂橘子bfs遍历能到达（传染）的所有新鲜橘子（val = 1）给他们赋路径值（负数用于区分），这批新鲜的橘子就变成「伪 - 新鲜橘子」
     * 3. 「伪 - 新鲜橘子」被赋值后可能还会被「最近的烂橘子」感染，所以这里需要比较最近的烂橘子（最短路径），更新最短路径
     * 4. 比较所有网格的新鲜橘子的val，理论上取一个最大值，因为赋值的是负值，所以是取最小值。
     *
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 9.65% 的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 36.73% 的用户
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    bfs(grid, i, j);
                }
            }
        }
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    return -1;
                }
            }
        }
        int min = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                min = Math.min(min, anInt);
            }
        }
        return -min;
    }

    public void bfs(int[][] grid, int i, int j) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        int depth = -1;
        while (!queue.isEmpty()) {
            int limit = queue.size();
            depth++;
            for (int k = 0; k < limit; k++) {
                int[] xy = queue.poll();
                int x = xy[0];
                int y = xy[1];
                visited[x][y] = true;
                // 当橘子是好的，或者已经腐烂的（为负数）改成腐烂时间
                // 如果已有腐烂时间的橘子，这判断更新（因为是负数，所以是max）
                if (grid[x][y] < 0) {
                    grid[x][y] = Math.max(grid[x][y], -depth);
                } else if (grid[x][y] == 1) {
                    grid[x][y] = -depth;
                }

                if (x - 1 >= 0 && !visited[x - 1][y] && grid[x - 1][y] != 2 && grid[x - 1][y] != 0) {
                    queue.add(new int[]{x - 1, y});
                }
                if (x + 1 < grid.length && !visited[x + 1][y] && grid[x + 1][y] != 2 && grid[x + 1][y] != 0) {
                    queue.add(new int[]{x + 1, y});
                }
                if (y - 1 >= 0 && !visited[x][y - 1] && grid[x][y - 1] != 2 && grid[x][y - 1] != 0) {
                    queue.add(new int[]{x, y - 1});
                }
                if (y + 1 < grid[0].length && !visited[x][y + 1] && grid[x][y + 1] != 2 && grid[x][y + 1] != 0) {
                    queue.add(new int[]{x, y + 1});
                }
            }

        }
    }
}
