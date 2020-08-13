package dfs;

import java.util.*;

/**
 * @ClassName ShortestBridge
 * @Description #934 最短的桥
 * @Author MatthewHan
 * @Date 2020/8/13 15:56
 * @Version 1.0
 **/
public class ShortestBridge {


    /**
     * 执行用时： 1111 ms , 在所有 Java 提交中击败了 5.13% 的用户
     * 内存消耗： 41 MB , 在所有 Java 提交中击败了 14.64% 的用户
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
     *
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
                // 找到了-1
                if (arr[x][y] == 1) {
                    return len;
                }
                if (x - 1 >= 0 && !visited[x - 1][y]) {
                    queue.offer(new int[]{x - 1, y});
                    visited[x - 1][y] = true;
                }
                if (x + 1 < arr.length && !visited[x + 1][y]) {
                    queue.offer(new int[]{x + 1, y});
                    visited[x + 1][y] = true;
                }
                if (y - 1 >= 0 && !visited[x][y - 1]) {
                    queue.offer(new int[]{x, y - 1});
                    visited[x][y - 1] = true;
                }
                if (y + 1 < arr[0].length && !visited[x][y + 1]) {
                    queue.offer(new int[]{x, y + 1});
                    visited[x][y + 1] = true;
                }
            }
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(shortestBridge(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(shortestBridge(new int[][]{{0, 0, 0, 1}, {1, 1, 1, 0}}));
        System.out.println(shortestBridge(new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}}));
        System.out.println(shortestBridge(new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}}));
    }

}
