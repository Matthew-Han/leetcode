package design;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/20 12:15
 **/
public class ShuffleAnArray {

    private final int[] zero;
    private final int[] data;
    private final int capacity;
    private final Random random;

    /**
     * #384 打乱数组
     * 执行用时： 90 ms , 在所有 Java 提交中击败了 99.63% 的用户
     * 内存消耗： 46.8 MB , 在所有 Java 提交中击败了 78.86% 的用户
     *
     * @param nums
     */
    public ShuffleAnArray(int[] nums) {
        random = new Random();
        capacity = nums.length;
        data = new int[capacity];
        zero = new int[capacity];
        System.arraycopy(nums, 0, zero, 0, capacity);
        System.arraycopy(nums, 0, data, 0, capacity);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return zero;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < capacity; i++) {
            int x = random.nextInt(capacity);
            int y = random.nextInt(capacity);
            // 这里以后要注意了,用^交换,要保证两个结果不能一致,不然会等于 0
            if (x != y) {
                data[x] ^= data[y];
                data[y] ^= data[x];
                data[x] ^= data[y];
            }
        }
        return data;
    }
}
