import java.util.PriorityQueue;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @date 2020/10/20 15:24
 **/
public class No215 {


    /**
     * #215 数组中的第K个最大元素
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 62.09% 的用户
     * 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 99.33% 的用户
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int num : nums) {
            if (pq.size() < k) {
                pq.add(num);
            } else if (pq.peek() < num) {
                pq.poll();
                pq.add(num);
            }
        }
        return pq.peek();
    }
}
