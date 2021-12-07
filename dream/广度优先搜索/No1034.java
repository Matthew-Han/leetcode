package 广度优先搜索;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/12/7 15:50
 * @since 1.0
 **/
public class No1034 {

    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    Queue<int[]> queue;
    Queue<int[]> pendingQueue;

    /**
     * 边界着色
     *
     * @param grid
     * @param row
     * @param col
     * @param color
     * @return
     */
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.queue = new LinkedList<>();
        this.pendingQueue = new LinkedList<>();
        int oldColor = grid[row][col];
        fuck(grid, row, col, new boolean[grid.length][grid[0].length]);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (check(curr, grid, oldColor)) {
                pendingQueue.offer(new int[]{curr[0], curr[1]});
            }
        }
        while (!pendingQueue.isEmpty()) {
            int[] curr = pendingQueue.poll();
            grid[curr[0]][curr[1]] = color;
        }
        return grid;
    }


    public void fuck(int[][] grid, int row, int col, boolean[][] vis) {
        queue.offer(new int[]{row, col});
        for (int i = 0; i < 4; i++) {
            int newX = row + dx[i];
            int newY = col + dy[i];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && !vis[newX][newY]) {
                vis[newX][newY] = true;
                if (grid[newX][newY] == grid[row][col]) {
                    fuck(grid, newX, newY, vis);
                }
            }
        }
    }

    public boolean check(int[] xy, int[][] grid, int color) {
        for (int i = 0; i < 4; i++) {
            int newX = xy[0] + dx[i];
            int newY = xy[1] + dy[i];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                if (grid[newX][newY] != color) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
