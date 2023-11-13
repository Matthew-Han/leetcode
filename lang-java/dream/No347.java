import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName TopKFrequentElements
 * @Description #347 前 K 个高频元素
 * @Author MatthewHan
 * @Date 2020/9/7 00:19
 * @Version 1.0
 **/
public class No347 {

    /**
     * 大顶堆，peek 和 poll 的是最大值！
     * 执行用时： 15 ms , 在所有 Java 提交中击败了 87.76% 的用户
     * 内存消耗： 42.4 MB , 在所有 Java 提交中击败了 54.80% 的用户
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        priorityQueue.addAll(map.entrySet());
        // priorityQueue的长度一定大于k
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll().getKey();
        }

        return res;
    }

    public static void main(String[] args) {
        topKFrequent(new int[]{1, 1, 1, 1, 2, 2, 3, 4, 5, 5}, 2);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        priorityQueue.add(1);
        priorityQueue.add(4);
        priorityQueue.add(2);
        System.out.println("priorityQueue = " + priorityQueue);
        System.out.println("priorityQueue = " + priorityQueue.peek());
        System.out.println("priorityQueue = " + priorityQueue.poll());
    }

}
