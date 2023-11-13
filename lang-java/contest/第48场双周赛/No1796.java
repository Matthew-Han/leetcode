package 第48场双周赛;

import java.util.PriorityQueue;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/22 09:48
 **/
public class No1796 {

    /**
     * #1796 字符串中第二大的数字
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 49.00% 的用户
     * 内存消耗： 37 MB , 在所有 Java 提交中击败了 83.47% 的用户
     *
     * @param s
     * @return
     */
    public int secondHighest(String s) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                if (!pq.contains(s.charAt(i) - '0')) {
                    pq.offer(s.charAt(i) - '0');
                }
            }
        }
        if (pq.size() <= 1) {
            return -1;
        }
        pq.poll();
        return pq.peek();
    }
}
