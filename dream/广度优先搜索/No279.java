package 广度优先搜索;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/11 09:24
 * @description
 * @since 1.0.0
 **/
public class No279 {

    /**
     * #279 完全平方数
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int max = (int) Math.sqrt(n);
        Queue<Integer> queue = new LinkedList<>();
        // set 去重优化
        // 记住: 以后 dfs | bfs 优化剪枝之类可以考虑下去重!!!
        Set<Integer> set = new HashSet<>();
        queue.offer(n);
        int depth = 0;
        while (!queue.isEmpty()) {
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                int curr = queue.poll();
                if (set.contains(curr)) {
                    continue;
                }
                set.add(curr);
                if (curr == 0) {
                    return depth;
                }
                for (int j = 1; j <= max; j++) {
                    int next = j * j;
                    if (curr - next >= 0) {
                        queue.offer(curr - next);
                    } else {
                        break;
                    }
                }
            }
            depth++;

        }
        return n;
    }
}
