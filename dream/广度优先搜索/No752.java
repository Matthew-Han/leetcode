package 广度优先搜索;

import java.util.*;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/23 18:30
 **/
public class No752 {

    Map<String, Boolean> vis;
    Map<String, Integer> counter;
    int ans;

    /**
     * #752 打开转盘锁
     * 执行用时： 333 ms , 在所有 Java 提交中击败了 6.01% 的用户
     * 内存消耗： 46.9 MB , 在所有 Java 提交中击败了 5.00% 的用户
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        ans = 0;
        vis = new HashMap<>();
        counter = new HashMap<>();
        char[] src = new char[]{'0', '0', '0', '0'};
        for (String d : deadends) {
            vis.put(d, true);
        }
        counter.put(new String(src), 0);
        Queue<char[]> queue = new LinkedList<>();
        queue.offer(src);
        while (!queue.isEmpty()) {
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                char[] curr = queue.poll();
                String key = new String(curr);

                if (!vis.containsKey(key)) {
                    System.out.println(vis.containsKey(key) + " : " + key);
                    if (target.equals(key)) {
                        return counter.get(key);
                    }
                    // 边界处理
                    fuck(curr, queue);
                }
            }
        }

        return -1;


    }

    public void fuck(char[] curr, Queue<char[]> queue) {
        for (int i = 0; i < 4; i++) {
            vis.put(new String(curr), true);
            int count = counter.get(new String(curr));
            if (curr[i] - '0' == 0) {
                char[] char1 = curr.clone();
                char[] char2 = curr.clone();
                char1[i] = '1';
                char2[i] = '9';

                processor(char1, char2, count, queue);

            } else if (curr[i] - '0' == 9) {
                char[] char1 = curr.clone();
                char[] char2 = curr.clone();
                char1[i] = '0';
                char2[i] = '8';

                processor(char1, char2, count, queue);
            } else {
                char[] char1 = curr.clone();
                char[] char2 = curr.clone();
                char1[i] -= 1;
                char2[i] += 1;

                processor(char1, char2, count, queue);
            }

        }

    }

    public void processor(char[] char1, char[] char2, int count, Queue<char[]> queue) {
        String key1 = new String(char1);
        String key2 = new String(char2);
        if (!vis.containsKey(key1)) {
            counter.put(key1, Math.min(count + 1, counter.get(key1) == null ? Integer.MAX_VALUE : counter.get(key1)));
            queue.offer(char1);
        }
        if (!vis.containsKey(key2)) {
            counter.put(key2, Math.min(count + 1, counter.get(key2) == null ? Integer.MAX_VALUE : counter.get(key2)));
            queue.offer(char2);
        }
    }

    public static void main(String[] args) {
        No752 demo = new No752();
        System.out.println(demo.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
    }
}
