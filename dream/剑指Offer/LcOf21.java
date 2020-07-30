package 剑指Offer;

import java.util.Arrays;

/**
 * @ClassName LcOf21
 * @Description 剑指 Offer #21 调整数组顺序使奇数位于偶数前面
 * @Author MatthewHan
 * @Date 2020/7/19 03:43
 * @Version 1.0
 **/
public class LcOf21 {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 99.80% 的用户
     * 内存消耗： 47.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while ((nums[left] & 1) != 0) {
                left++;
                if (left == nums.length - 1) {
                    break;
                }
            }
            while ((nums[right] & 1) == 0) {
                right--;
                if (right == 0) {
                    break;
                }
            }
            if (left < right) {
                nums[left] = nums[left] ^ nums[right];
                nums[right] = nums[left] ^ nums[right];
                nums[left] = nums[left] ^ nums[right];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{3, 2, 3, 2, 3})));
    }
}
