package 第57场双周赛;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/26 09:55
 * @since 1.0
 **/
public class No1942 {

    /**
     * 最小未被占据椅子的编号
     *
     * @param times
     * @param targetFriend
     * @return
     */
    public int smallestChair(int[][] times, int targetFriend) {
        int[] targetTime = times[targetFriend];
        Arrays.sort(times, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int start = targetTime[0];
        boolean[] bucket = new boolean[times.length + 1];
        PriorityQueue<int[]> queue1 = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        PriorityQueue<int[]> queue2 = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
        for (int[] time : times) {
            queue2.offer(time);
        }
        int ans = 0;
        for (int i = 0; i <= start; i++) {
            int limit = queue1.size();
            for (int j = 0; j < limit; j++) {
                int[] curr = queue1.poll();
                if (curr[1] <= i) {
                    bucket[curr[2]] = false;
                } else {
                    queue1.offer(curr);
                    break;
                }
            }
            limit = queue2.size();
            for (int j = 0; j < limit; j++) {
                int[] curr = queue2.poll();
                if (curr[0] == i) {
                    int[] x = new int[3];
                    x[0] = curr[0];
                    x[1] = curr[1];
                    for (int k = 0; k < bucket.length; k++) {
                        if (!bucket[k]) {
                            x[2] = k;
                            bucket[k] = true;
                            ans = k;
                            break;
                        }
                    }
                    queue1.offer(x);
                } else {
                    queue2.offer(curr);
                    break;
                }
            }
        }
        return ans;
    }
}
