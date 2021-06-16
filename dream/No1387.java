import javafx.util.Pair;
import java.util.*;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/4 14:36
 **/
public class No1387 {

    /**
     * #1387 将整数按权重排序
     * 执行用时： 30 ms , 在所有 Java 提交中击败了 89.60% 的用户
     * 内存消耗： 38.1 MB , 在所有 Java 提交中击败了 44.36% 的用户
     *
     * @param lo
     * @param hi
     * @param k
     * @return
     */
    public int getKth(int lo, int hi, int k) {
        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if (o1.getValue() < o2.getValue()) {
                    return -1;
                } else if (o1.getValue() > o2.getValue()) {
                    return 1;
                } else {
                    return Integer.compare(o1.getKey(), o2.getKey());
                }
            }
        });

        for (int i = lo; i <= hi; i++) {
            Pair<Integer, Integer> pair = new Pair<>(i, step(i));
            priorityQueue.offer(pair);
        }

        while (k > 1) {
            priorityQueue.poll();
            k--;
        }
        return priorityQueue.poll().getKey();
    }

    public int step(int num) {
        int count = 0;
        while (num != 1) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num = num * 3 + 1;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        No1387 demo = new No1387();
        System.out.println(demo.getKth(10, 20, 5));
    }
}
