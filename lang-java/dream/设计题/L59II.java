package 设计题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/3 16:36
 **/
public class L59II {
    int[] data;
    int point;
    Queue<Integer> queue;

    /**
     * 剑指 Offer #59 - II 队列的最大值
     * 执行用时： 99 ms , 在所有 Java 提交中击败了 5.79% 的用户
     * 内存消耗： 46.3 MB , 在所有 Java 提交中击败了 53.24% 的用户
     */
    public L59II() {
        point = -1;
        queue = new LinkedList<>();
        data = new int[10000];
    }

    public int maxValue() {
        return point;
    }

    public void pushBack(int value) {
        data[value]++;
        queue.offer(value);
    }

    public int popFront() {
        int v = queue.poll();
        data[v]--;
        for (int i = point; i >= 0; i--) {
            if (data[i] > 0) {
                point = i;
                break;
            }
        }

        return v;
    }
}
