package 剑指Offer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName LcOf59
 * @Description 剑指 Offer #59 - I 滑动窗口的最大值
 * @Author MatthewHan
 * @Date 2020/7/20 15:08
 * @Version 1.0
 **/
public class LcOf59 {

    /**
     * 执行用时： 105 ms , 在所有 Java 提交中击败了 5.90% 的用户
     * 内存消耗： 49.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindowDeque(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(priorityQueue);
            if (priorityQueue.size() == k - 1) {
                priorityQueue.add(nums[i]);
                result[index++] = priorityQueue.peek();
            } else if (priorityQueue.size() == k) {
                priorityQueue.remove(nums[i - k]);
                priorityQueue.add(nums[i]);
                result[index++] = priorityQueue.peek();
            } else {
                priorityQueue.add(nums[i]);
            }

        }
        return result;
    }


    /**
     * 执行用时： 28 ms , 在所有 Java 提交中击败了 30.29% 的用户
     * 内存消耗： 47.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        int i = 0;
        int j = i + k;
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        while (j <= nums.length) {
            int max = Integer.MIN_VALUE;
            for (int ii = i; ii < j; ii++) {
                max = Math.max(max, nums[ii]);
            }
            result[index++] = max;
            i++;
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindowDeque(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
