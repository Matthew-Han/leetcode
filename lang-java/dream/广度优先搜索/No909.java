package 广度优先搜索;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/28 12:36
 * @since 1.0
 **/
public class No909 {

    /**
     * 被 vis 判断重复节点搞死了
     * <p>
     * 出现重复节点会有两种情况：
     * <p>
     * 0. 闪现过来的，不会再使用该节点的闪现技能
     * <p>
     * 1. 走到该节点上，有机会使用闪现技能
     * <p>
     * #909 蛇梯棋
     */
    public int snakesAndLadders(int[][] board) {
        boolean toward = true;
        int prev = 0;
        int num = 1;
        boolean[] vis1 = new boolean[2 << 12];
        boolean[] vis2 = new boolean[2 << 12];
        Map<Integer, int[]> map = new HashMap<>(board.length * board[0].length * 4 / 3 + 1);
        for (int i = board.length - 1; i >= 0; i--) {
            if (prev == 0) {
                for (int j = prev; j < board[0].length; j++) {
                    map.put(num++, new int[]{i, j});
                    prev = j;
                }
            } else {
                for (int j = prev; j >= 0; j--) {
                    map.put(num++, new int[]{i, j});
                    prev = j;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        int depth = 0;
        while (!queue.isEmpty()) {
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                int currNum = queue.poll();
                if ((vis1[currNum] && vis2[currNum]) || (vis1[currNum] && currNum == 1)) {
                    continue;
                }
                vis1[currNum] = true;

                int[] curr = map.get(currNum);
                if (currNum >= board.length * board[0].length) {
                    return depth;
                }
                for (int j = 1; j <= 6; j++) {
                    int[] next = map.get(currNum + j);
                    vis2[currNum + j] = true;
                    if (next != null && board[next[0]][next[1]] != -1) {
                        queue.offer(board[next[0]][next[1]]);
                    } else {
                        queue.offer(currNum + j);
                    }
                }
            }
            depth++;
        }
        return -1;
    }
}
