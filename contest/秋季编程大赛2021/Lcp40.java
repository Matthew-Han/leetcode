package 秋季编程大赛2021;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/14 10:23
 * @since 1.0
 **/
public class Lcp40 {


    /**
     * 心算挑战
     *
     * @param cards
     * @param cnt
     * @return
     */
    public int maxmiumScore(int[] cards, int cnt) {
        PriorityQueue<Integer> odd = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        PriorityQueue<Integer> even = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int card : cards) {
            if ((card & 1) == 0) {
                even.offer(card);
            } else {
                odd.offer(card);
            }
        }
        int ans = 0;
        while (cnt > 0) {
            if (cnt == 1) {
                if (even.isEmpty()) {
                    return 0;
                } else {
                    ans += even.poll();
                    return ans;
                }
            }
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            if (even.size() > 1) {
                a = even.poll();
                b = even.poll();
            }
            if (odd.size() > 1) {
                c = odd.poll();
                d = odd.poll();
            }
            if (a == 0 && b == 0 && c == 0 && d == 0) {
                return 0;
            }
            if (a + b > c + d) {
                ans += a;
                if (b > c) {
                    ans += b;
                    cnt--;
                } else {
                    if (b != 0) {
                        even.offer(b);
                    }
                }
                if (c != 0) {
                    odd.offer(c);
                }
                if (d != 0) {
                    odd.offer(d);
                }
                cnt--;
            } else {
                ans += c;
                ans += d;
                if (a != 0) {
                    even.offer(a);
                }
                if (b != 0) {
                    even.offer(b);
                }
                cnt -= 2;
            }
        }
        return ans;
    }
}
