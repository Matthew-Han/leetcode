import java.util.PriorityQueue;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/1/5 10:56
 **/
public class SlidingWindowMaximum {

    /**
     * #239 滑动窗口最大值
     * 执行用时： 779 ms , 在所有 Java 提交中击败了 5.00% 的用户
     * 内存消耗： 59.7 MB , 在所有 Java 提交中击败了 5.39% 的用户
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (nums[i] >= max) {
                maxIndex = i;
                max = nums[i];
            }
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = max;
        int index = 1;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] >= max) {
                res[index++] = nums[i];
                max = nums[i];
                maxIndex = i;
            } else {
                // 注意 max 多个的情况
                if (maxIndex == i - k) {
                    maxIndex = getIndex(nums, i - k + 1, k);
                    max = nums[maxIndex];
                }
                res[index++] = max;
            }
        }
        return res;
    }

    public int getIndex(int[] nums, int start, int size) {
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = start; i < start + size; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
