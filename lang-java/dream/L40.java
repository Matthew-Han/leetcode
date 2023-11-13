import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName LcOf40
 * @Description 剑指 Offer #40 最小的k个数
 * @Author MatthewHan
 * @Date 2020/7/19 23:09
 * @Version 1.0
 **/
public class L40 {

    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 69.51% 的用户
     * 内存消耗： 41.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbersArrays(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        if (k > 0) {
            System.arraycopy(arr, 0, result, 0, k);
        }
        return result;
    }

    /**
     * 大顶堆
     * 执行用时： 31 ms , 在所有 Java 提交中击败了 14.20% 的用户
     * 内存消耗： 40.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int n : arr) {
            priorityQueue.add(n);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int index = 0;
        for (Integer n : priorityQueue) {
            result[index++] = n;
        }
        System.out.println(priorityQueue.poll());
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{1, 2, -1, -11, 3, 4}, 2)));
    }
}
