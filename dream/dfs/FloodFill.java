package dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName FloodFill
 * @Description #733 图像渲染
 * @Author MatthewHan
 * @Date 2020/6/5 22:48
 * @Version 1.0
 **/
public class FloodFill {

    /**
     * bfs迭代
     * 执行用时： 16 ms , 在所有 Java 提交中击败了 9.99% 的用户
     * 内存消耗： 40.4 MB , 在所有 Java 提交中击败了 95.57% 的用户
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFillBfs(int[][] image, int sr, int sc, int newColor) {

        int oldColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[image.length][image[0].length];
        queue.offer(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                int[] curr = queue.poll();
                sr = curr[0];
                sc = curr[1];
                if (!visited[sr][sc] && image[sr][sc] == oldColor) {
                    visited[sr][sc] = true;
                    image[sr][sc] = newColor;
                    if (sr - 1 >= 0) {
                        queue.offer(new int[]{sr - 1, sc});
                    }
                    if (sr + 1 < image.length) {
                        queue.offer(new int[]{sr + 1, sc});
                    }
                    if (sc - 1 >= 0) {
                        queue.offer(new int[]{sr, sc - 1});
                    }
                    if (sc + 1 < image[0].length) {
                        queue.offer(new int[]{sr, sc + 1});
                    }
                }
            }
        }
        return image;
    }


    /**
     * 经典dfs
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 97.06% 的用户
     * 内存消耗： 40.9 MB , 在所有 Java 提交中击败了 23.01% 的用户
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        dfs(image, new boolean[image.length][image[0].length], sr, sc, image[sr][sc], newColor);
        return image;
    }

    /**
     *
     * @param image
     * @param visited
     * @param sr
     * @param sc
     * @param oldColor
     * @param newColor
     */
    public static void dfs(int[][] image, boolean[][] visited, int sr, int sc, int oldColor, int newColor) {
        boolean flag = (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length);
        if (flag && !visited[sr][sc] && image[sr][sc] == oldColor) {
            visited[sr][sc] = true;
            image[sr][sc] = newColor;

            dfs(image, visited, sr - 1, sc, oldColor, newColor);
            dfs(image, visited, sr + 1, sc, oldColor, newColor);
            dfs(image, visited, sr, sc - 1, oldColor, newColor);
            dfs(image, visited, sr, sc + 1, oldColor, newColor);
        }
    }


}
