package 动态规划;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/25 09:57
 * @since 1.0
 **/
public class No322 {


    /**
     * 零钱兑换
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        boolean[] mem = new boolean[10001];
        if (amount == 0) {
            return 0;
        }
        Queue<Long> queue = new LinkedList<>();
        for (int coin : coins) {
            queue.offer((long) coin);
        }
        int ans = 1;
        while (!queue.isEmpty()) {
            int limit = queue.size();
            while (limit-- > 0) {
                long curr = queue.poll();
                if (curr == amount) {
                    return ans;
                }
                for (int coin : coins) {
                    if (coin + curr <= amount && !mem[coin + (int) curr]) {
                        queue.offer(coin + curr);
                        mem[coin + (int) curr] = true;
                    }

                }
            }
            ans++;
        }
        return -1;

    }
}
