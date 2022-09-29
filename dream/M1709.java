import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/9/29 15:54 29
 * @since 1.0
 **/
public class M1709 {

    /**
     * 第 k 个数
     *
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {
        int[] t = {3, 5, 7};
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        Set<Long> vis = new HashSet<>();
        vis.add(1L);
        while (true) {
            long p = pq.poll();
            for (int n : t) {
                if (!vis.contains(p * n)) {
                    vis.add(p * n);
                    pq.offer(p * n);
                }
            }
            k--;
            if (k == 0) {
                return (int) p;
            }
        }
    }
}
