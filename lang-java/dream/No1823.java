import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/5/5 09:31 05
 * @since 1.0
 **/
public class No1823 {

    /**
     * 找出游戏的获胜者
     *
     * @param n
     * @param k
     * @return
     */
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        while (q.size() > 1) {
            for (int i = 0; i < k; i++) {
                int curr = q.poll();
                if (i != k - 1) {
                    q.offer(curr);
                }
            }
        }
        return q.poll();
    }

}
