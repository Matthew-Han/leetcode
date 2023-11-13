package 贪心;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/12/30 09:20
 * @since 1.0
 **/
public class No846 {

    /**
     * 一手顺子
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean isNStraightHand(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(new int[]{e.getKey(), e.getValue()});
        }
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int prev = curr[0];
            int min = curr[1];
            List<int[]> t = new LinkedList<>();
            for (int i = 1; i < k; i++) {
                while (true) {
                    if (pq.isEmpty()) {
                        return false;
                    }
                    int[] nxt = pq.poll();
                    if (nxt[0] == prev + 1 && nxt[1] >= min) {
                        nxt[1] -= min;
                        if (nxt[1] > 0) {
                            t.add(nxt);
                        }
                        prev++;
                        break;
                    } else if (nxt[0] != prev + 1 && nxt[1] >= min) {
                        t.add(nxt);
                    } else {
                        return false;
                    }
                }
            }
            pq.addAll(t);

        }
        return true;
    }
}
