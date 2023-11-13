package 广度优先搜索;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/5/7 09:19 07
 * @since 1.0
 **/
public class No433 {

    /**
     * 最小基因变化
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        int ans = 0;
        boolean[] vis = new boolean[bank.length];
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int limit = q.size();
            for (int i = 0; i < limit; i++) {
                String curr = q.poll();
                if (curr.equals(end)) {
                    return ans;
                }
                for (int j = 0; j < bank.length; j++) {
                    if (!vis[j] && check(curr, bank[j])) {
                        q.offer(bank[j]);
                        vis[j] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    public boolean check(String l, String r) {
        int ans = 0;
        for (int i = 0; i < 8; i++) {
            if (l.charAt(i) != r.charAt(i)) {
                ans++;
            }
        }
        return ans == 1;
    }
}
