package 广度优先搜索;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a >
 * @date 2021/6/26 6:24 下午
 * @since 1.0
 **/
public class No773 {

    Set<String> vis;
    int[][] target = new int[][]{{1, 2, 3}, {4, 5, 0}};
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    /**
     * #773 滑动谜题
     *
     * @param board
     * @return
     */
    public int slidingPuzzle(int[][] board) {
        vis = new HashSet<>();
        Queue<int[][]> queue = new LinkedList<>();
        queue.offer(board);
        int depth = 0;
        while (!queue.isEmpty()) {
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                int[][] curr = queue.poll();
                String currStr = build(curr);
                // System.out.println(currStr);
                if (check(curr)) {
                    return depth;
                }
                if (!vis.contains(currStr)) {
                    vis.add(currStr);
                    int[] zero = processor(curr);
                    for (int j = 0; j < 4; j++) {
                        int[] dest = new int[]{zero[0] + dx[j], zero[1] + dy[j]};
                        if (dest[0] < 0 || dest[1] < 0 || dest[0] >= 2 || dest[1] >= 3) {
                            continue;
                        }
                        curr[zero[0]][zero[1]] ^= curr[dest[0]][dest[1]];
                        curr[dest[0]][dest[1]] ^= curr[zero[0]][zero[1]];
                        curr[zero[0]][zero[1]] ^= curr[dest[0]][dest[1]];

                        queue.offer(deepCopy(curr));
                        // 回溯
                        curr[zero[0]][zero[1]] ^= curr[dest[0]][dest[1]];
                        curr[dest[0]][dest[1]] ^= curr[zero[0]][zero[1]];
                        curr[zero[0]][zero[1]] ^= curr[dest[0]][dest[1]];
                    }

                }
            }
            depth++;
        }
        return -1;

    }

    public int[][] deepCopy(int[][] src) {
        int[][] dest = new int[src.length][src[0].length];
        for (int i = 0; i < src.length; i++) {
            int[] tmp = new int[src[0].length];
            System.arraycopy(src[i], 0, tmp, 0, src[i].length);
            dest[i] = tmp;
        }
        return dest;
    }

    public int[] processor(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public boolean check(int[][] src) {
        int cnt = 0;
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[0].length; j++) {
                cnt += src[i][j] == target[i][j] ? 1 : 0;
            }
        }
        return cnt == 6;
    }

    public String build(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] b : board) {
            for (int v : b) {
                sb.append(v);
            }
        }
        return sb.toString();
    }
}
