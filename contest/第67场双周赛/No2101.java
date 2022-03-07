package 第67场双周赛;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/3/7 15:27 07
 * @since 1.0
 **/
public class No2101 {
    /**
     * 引爆最多的炸弹
     *
     * @param bombs
     * @return
     */
    public int maximumDetonation(int[][] bombs) {
        int ans = 1;
        for (int i = 0; i < bombs.length; i++) {
            Queue<int[]> tmp = new LinkedList<>();
            tmp.offer(bombs[i]);
            boolean[] vis = new boolean[bombs.length];
            vis[i] = true;
            while (!tmp.isEmpty()) {
                int limit = tmp.size();
                while (limit-- > 0) {
                    int[] curr = tmp.poll();
                    for (int j = 0; j < bombs.length; j++) {
                        if (vis[j]) {
                            continue;
                        }
                        if (check(curr, bombs[j])) {
                            tmp.offer(bombs[j]);
                            vis[j] = true;
                        }
                    }
                }
            }

            ans = Math.max(count(vis), ans);
        }
        return ans;
    }

    public int count(boolean[] vis) {
        int ans = 0;
        for (boolean v : vis) {
            ans += v ? 1 : 0;
        }
        return ans;
    }

    public boolean check(int[] b1, int[] b2) {
        double r = Math.pow(b1[2], 2);
        double x = Math.pow(b1[0] - b2[0], 2) + Math.pow(b1[1] - b2[1], 2);
        return r >= x;
    }

}
