package 第53场双周赛;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/29 22:27
 * @description
 * @since 1.0.0
 **/
public class No1878 {

    /**
     * #1878 矩阵中最大的三个菱形和
     * 唉, 比赛差一点就调出来了...可惜时间到了
     *
     * @param grid
     * @return
     */
    public int[] getBiggestThree(int[][] grid) {
        int maxEdge = grid.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int edge = 0; edge <= maxEdge; edge++) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    int curr = sumOfTheBitch(grid, i, j, edge);
                    set.add(curr);
                }
            }
        }
        set.remove(0);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2, o1)));
        for (Integer s : set) {
            priorityQueue.offer(s);
        }
        if (priorityQueue.size() == 1) {
            return new int[]{priorityQueue.poll()};
        } else if (priorityQueue.size() == 2) {
            return new int[]{priorityQueue.poll(), priorityQueue.poll()};
        } else {
            return new int[]{priorityQueue.poll(), priorityQueue.poll(), priorityQueue.poll()};
        }

    }

    public int sumOfTheBitch(int[][] grid, int x, int y, int edge) {
        if (edge == 0) {
            return grid[x][y];
        }
        int currEdge = 1;
        int sum = grid[x][y];
        int leftY = y - 1;
        int rightY = y + 1;
        x++;
        while (currEdge <= edge) {
            if (x >= grid.length || leftY < 0 || rightY >= grid[0].length) {
                return 0;
            }
            sum += grid[x][leftY] + grid[x][rightY];
            x++;
            leftY--;
            rightY++;
            currEdge++;
        }
        leftY += 2;
        rightY -= 2;
        currEdge--;
        while (currEdge > 0) {
            if (x >= grid.length || rightY < 0 || leftY >= grid[0].length) {
                return 0;
            }
            sum += grid[x][leftY] + grid[x][rightY];
            x++;
            leftY++;
            rightY--;
            currEdge--;
        }
        return sum - grid[x - 1][y];
    }
}
