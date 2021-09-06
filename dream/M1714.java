import java.util.PriorityQueue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/6 09:38
 * @since 1.0
 **/
public class M1714 {

    /**
     * 最小K个数
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int a : arr) {
            if (pq.size() < k) {
                pq.offer(a);
            } else {
                if (pq.peek() > a) {
                    pq.poll();
                    pq.offer(a);
                }
            }

        }
        int[] ans = new int[pq.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
