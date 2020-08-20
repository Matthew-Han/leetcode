package dfs;

import java.util.*;

/**
 * @ClassName DiagonalTraverse
 * @Description #498 对角线遍历
 * @Author MatthewHan
 * @Date 2020/8/20 10:03
 * @Version 1.0
 **/
public class DiagonalTraverse {


    /**
     * 执行用时： 17 ms , 在所有 Java 提交中击败了 11.06% 的用户
     * 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 87.89% 的用户
     *
     * @param matrix
     * @return
     */
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        List<Integer> res = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        queue.offer(new int[]{0, 0});
        boolean d = true;
        while (!queue.isEmpty()) {
            int limit = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < limit; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                tmp.add(matrix[x][y]);
                if (y + 1 < matrix[0].length && !visited[x][y + 1]) {
                    queue.offer(new int[]{x, y + 1});
                    visited[x][y + 1] = true;
                }
                if (x + 1 < matrix.length && !visited[x + 1][y]) {
                    queue.offer(new int[]{x + 1, y});
                    visited[x + 1][y] = true;
                }

            }
            if (d) {
                Collections.reverse(tmp);
            }
            d = !d;
            res.addAll(tmp);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }
}
