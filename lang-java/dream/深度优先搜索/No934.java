package 深度优先搜索;

import java.util.*;

/**
 * @ClassName ShortestBridge
 * @Description #934 最短的桥
 * @Author MatthewHan
 * @Date 2020/8/13 15:56
 * @Version 1.0
 **/
public class No934 {


    /**
     * 执行用时： 258 ms , 在所有 Java 提交中击败了 12.22% 的用户
     * 内存消耗： 41 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param arr
     * @return
     */
    public static int shortestBridge(int[][] arr) {
        List<int[]> firstLand = new ArrayList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (flag) {
                break;
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    dfs(arr, i, j, visited, firstLand);
                    flag = true;
                    break;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int[] xy : firstLand) {
            // 【注意】每次初始化访问标记【注意】
            visited = new boolean[arr.length][arr[0].length];
            ans = Math.min(ans, bfs(arr, xy[0], xy[1], visited));

        }
        return ans;
    }

    /**
     * @param arr
     * @param x
     * @param y
     * @param visited
     * @param firstLand
     */
    public static void dfs(int[][] arr, int x, int y, boolean[][] visited, List<int[]> firstLand) {
        if (x >= 0 && y >= 0 && x < arr.length && y < arr[0].length && !visited[x][y]) {
            visited[x][y] = true;
            if (arr[x][y] == 0) {
                return;
            }
            arr[x][y] = -1;
            firstLand.add(new int[]{x, y});
            // 仅仅只有上下左右
            dfs(arr, x - 1, y, visited, firstLand);
            dfs(arr, x + 1, y, visited, firstLand);
            dfs(arr, x, y - 1, visited, firstLand);
            dfs(arr, x, y + 1, visited, firstLand);
        }
    }


    /**
     * wcnd，写死我了
     *
     * @param arr
     * @param x
     * @param y
     * @param visited
     * @return
     */
    public static int bfs(int[][] arr, int x, int y, boolean[][] visited) {
        // 最后要减一
        int len = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                int[] curr = queue.poll();
                x = curr[0];
                y = curr[1];
                // 找到了1
                if (arr[x][y] == 1) {
                    return len;
                }
                // 如果周围的节点是-1的话，没必要入队
                if (x - 1 >= 0 && !visited[x - 1][y] && arr[x - 1][y] != -1) {
                    queue.offer(new int[]{x - 1, y});
                    visited[x - 1][y] = true;
                }
                if (x + 1 < arr.length && !visited[x + 1][y] && arr[x + 1][y] != -1) {
                    queue.offer(new int[]{x + 1, y});
                    visited[x + 1][y] = true;
                }
                if (y - 1 >= 0 && !visited[x][y - 1] && arr[x][y - 1] != -1) {
                    queue.offer(new int[]{x, y - 1});
                    visited[x][y - 1] = true;
                }
                if (y + 1 < arr[0].length && !visited[x][y + 1] && arr[x][y + 1] != -1) {
                    queue.offer(new int[]{x, y + 1});
                    visited[x][y + 1] = true;
                }
            }
            len++;
        }
        // 一定是可以找到最短路径的，所以这里返回的是错误的
        return Integer.MAX_VALUE;
    }

    /* -------------------------------------------------------------------------------------------------------------- */

    int[][] grid;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int Date20221025(int[][] grid) {
        this.grid = grid;
        go:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fuck(i, j);
                    break go;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == -1) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int step = 0;
        while (!q.isEmpty()) {
            int limit = q.size();
            for (int i = 0; i < limit; i++) {
                int[] curr = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nex = curr[0] + dx[j];
                    int ney = curr[1] + dy[j];
                    if (nex >= 0 && nex < grid.length && ney >= 0 && ney < grid[0].length && grid[nex][ney] != -1 && !vis[nex][ney]) {
                        if (grid[nex][ney] == 1) {
                            return step;
                        }
                        vis[nex][ney] = true;
                        q.offer(new int[]{nex, ney});
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public void fuck(int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
            return;
        }
        grid[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            fuck(x + dx[i], y + dy[i]);
        }
    }

}
