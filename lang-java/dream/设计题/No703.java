package 设计题;

import java.util.PriorityQueue;

/**
 * @ClassName KthLargestElementInaStream
 * @Description #703 数据流中的第K大元素
 * @Author MatthewHan
 * @Date 2020/5/29 16:47
 * @Version 1.0
 **/
public class No703 {

    // 小顶堆
    private final PriorityQueue<Integer> q;

    private final int k;

    /**
     * 执行用时 : 22 ms , 在所有 Java 提交中击败了 63.20% 的用户
     * 内存消耗 : 43.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param k
     * @param nums
     */
    public No703(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<Integer>(k);
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (q.size() < this.k) {
            q.offer(val);

        } else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }

    public static void main(String[] args) {
        No703 kth = new No703(3, new int[]{4, 5, 8, 2});
        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
        System.out.println(kth.add(10));
        System.out.println(kth.add(9));
        System.out.println(kth.add(4));

        PriorityQueue<Integer> queue = new PriorityQueue<>(1);
        queue.add(8);
        queue.add(5);
        queue.add(4);
        queue.add(12);
        queue.add(3);
        queue.add(1);
        System.out.println("queue = " + queue);
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue);

    }
}
