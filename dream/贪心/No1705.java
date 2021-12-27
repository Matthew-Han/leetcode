package 贪心;

import java.util.PriorityQueue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/12/27 10:13
 * @since 1.0
 **/
public class No1705 {

    /**
     * 吃苹果的最大数目
     * <p>
     * 贪心 + 分类讨论
     *
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {
        int len = apples.length;
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[2], o2[2]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        for (int i = 0; i < len; i++) {
            if (apples[i] != 0) {
                int[] sub = new int[]{i, i + days[i], apples[i]};
                pq.offer(sub);
                if (!pq.isEmpty()) {
                    int[] curr = pq.poll();
                    curr[2]--;
                    ans++;
                    if (curr[2] > 0) {
                        pq.offer(curr);
                    }
                }
            } else {
                while (!pq.isEmpty()) {
                    int[] curr = pq.poll();
                    if (curr[1] > i) {
                        curr[2]--;
                        ans++;
                        if (curr[2] > 0) {
                            pq.offer(curr);
                        }
                        break;
                    }
                }
            }

        }
        long index = len;
        while (!pq.isEmpty()) {
            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                if (curr[1] > index) {
                    curr[2]--;
                    ans++;
                    if (curr[2] > 0) {
                        pq.offer(curr);
                    }
                    break;
                }
            }
            index++;
        }
        return ans;

    }
}
