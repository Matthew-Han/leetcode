import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/7 12:22 07
 * @since 1.0
 **/
public class No1405 {


    /**
     * 最长快乐字符串
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder ans = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o2[1] - o1[1]));
        if (a > 0) {
            pq.offer(new int[]{0, a});
        }
        if (b > 0) {
            pq.offer(new int[]{1, b});
        }
        if (c > 0) {
            pq.offer(new int[]{2, c});
        }
        while (!pq.isEmpty()) {
            int n = ans.length();
            char prev = n == 0 ? '&' : ans.charAt(n - 1);
            int[] first = pq.poll();
            char firstC = (char) ('a' + first[0]);
            if (firstC == prev) {
                if (pq.isEmpty()) {
                    return ans.toString();
                } else {
                    int[] second = pq.poll();
                    char secondC = (char) ('a' + second[0]);
                    if (second[1] >= first[1]) {
                        int m = Math.min(2, second[1]);
                        for (int i = 0; i < m; i++) {
                            ans.append(secondC);
                            second[1]--;
                        }
                    } else {
                        ans.append(secondC);
                        second[1]--;
                    }
                    if (second[1] > 0) {
                        pq.offer(second);
                    }
                }
            } else {
                int m = Math.min(2, first[1]);
                for (int i = 0; i < m; i++) {
                    ans.append(firstC);
                    first[1]--;
                }
            }
            if (first[1] > 0) {
                pq.offer(first);
            }
        }
        return ans.toString();

    }

}
