package 第56场双周赛;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/10 22:16
 * @since 1.0
 **/
public class No1926 {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    /**
     * 迷宫中离入口最近的出口
     *
     * @param maze
     * @param entrance
     * @return
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        int depth = 0;
        boolean[][] vis = new boolean[maze.length][maze[0].length];
        while (!queue.isEmpty()) {
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                int[] xy = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int[] newXy = new int[]{xy[0] + dx[j], xy[1] + dy[j]};
                    if (newXy[0] < 0 || newXy[0] >= maze.length || newXy[1] < 0 || newXy[1] >= maze[0].length) {
                        continue;
                    }
                    if (vis[newXy[0]][newXy[1]]) {
                        continue;
                    }
                    if (newXy[0] == entrance[0] && newXy[1] == entrance[1]) {
                        continue;
                    }
                    if (maze[newXy[0]][newXy[1]] == '+') {
                        continue;
                    }
                    vis[newXy[0]][newXy[1]] = true;
                    if (newXy[0] == 0 || newXy[0] == maze.length - 1 || newXy[1] == 0 || newXy[1] == maze[0].length - 1) {
                        return depth + 1;
                    }
                    if (maze[newXy[0]][newXy[1]] != '+') {
                        queue.offer(newXy);
                    }
                }

            }
            depth++;
        }
        return -1;
    }


    public static void main(String[] args) {
        No1926 demo = new No1926();
        System.out.println(demo.nearestExit(new char[][]{{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}}, new int[]{1, 0}));
    }
}
