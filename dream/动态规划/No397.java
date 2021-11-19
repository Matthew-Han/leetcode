package 动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/11/19 13:49
 * @since 1.0
 **/
public class No397 {

    Map<Long, Integer> mem;
    int ans;

    /**
     * 整数替换
     *
     * @param n
     * @return
     */
    public int integerReplacement(int n) {
        this.ans = Integer.MAX_VALUE;
        this.mem = new HashMap<>();
        dfs(n, 0);
        return ans;
    }

    public void dfs(long val, int step) {
        mem.put(val, step);
        if (val == 1) {
            ans = Math.min(ans, step);
            return;
        }

        if ((val % 2) == 0) {
            if (mem.containsKey(val / 2) && mem.get(val / 2) <= step) {
                return;
            }
            dfs(val / 2, step + 1);
        } else {
            if (mem.containsKey(val - 1) && mem.get(val - 1) <= step) {
                return;
            }
            dfs(val - 1, step + 1);
            if (mem.containsKey(val + 1) && mem.get(val + 1) <= step) {
                return;
            }
            dfs(val + 1, step + 1);
        }
    }

}
