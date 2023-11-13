package 设计题;

import java.util.PriorityQueue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/27 11:12
 * @since 1.0
 **/
public class No295 {

    PriorityQueue<Integer> minPq;
    PriorityQueue<Integer> maxPq;

    /**
     * 数据流的中位数
     */
    public No295() {
        minPq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        maxPq = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 初始化单独处理
        if (minPq.isEmpty()) {
            minPq.offer(num);
            return;
        } else if (maxPq.isEmpty()) {
            if (minPq.peek() > num) {
                maxPq.offer(minPq.poll());
                minPq.offer(num);
            } else {
                maxPq.offer(num);
            }
            return;
        }
        // 常规情况
        if (minPq.size() <= maxPq.size()) {
            if (maxPq.peek() < num) {
                minPq.offer(maxPq.poll());
                maxPq.offer(num);
            } else {
                minPq.offer(num);
            }
        } else {
            if (minPq.peek() > num) {
                maxPq.offer(minPq.poll());
                minPq.offer(num);
            } else {
                maxPq.offer(num);
            }
        }
    }

    public double findMedian() {
        if (((maxPq.size() + minPq.size()) & 1) == 1) {
            if (minPq.size() < maxPq.size()) {
                return maxPq.peek();
            } else {
                return minPq.peek();
            }
        } else {
            return (double) (minPq.peek() + maxPq.peek()) / 2;
        }
    }
}
