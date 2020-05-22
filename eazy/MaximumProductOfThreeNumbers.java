import java.util.*;

/**
 * @ClassName MaximumProductOfThreeNumbers
 * @Description #628 三个数的最大乘积
 * @Author MatthewHan
 * @Date 2020/5/22 16:48
 * @Version 1.0
 **/
public class MaximumProductOfThreeNumbers {


    /**
     * 就是分类，其实就两种情况。
     * 当负整数（包含0）的数量大于2时，需要计算排序完的数组，【最左边的2个数字】的乘积和最右边的【左边2个数】的乘积谁大。
     * 因为在该情况下，一定是必乘以一个正整数的，所以那个正整数一定是最右边的最大的正整数。
     * [-5, -4, 0, 1, 5, 6]
     * [-5, -4, 0, 5, 5, 6]
     * 其他情况你会发现怎么算都是从右向左的三个数相乘是最大结果。
     * <p>
     * 执行用时 : 13 ms , 在所有 Java 提交中击败了 29.03% 的用户
     * 内存消耗 : 41.5 MB , 在所有 Java 提交中击败了 7.69% 的用户
     *
     * @param nums
     * @return
     */
    public static int maximumProduct(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        // 0也在负数里面
        int negative = 0;
        int i = 0;
        while (nums[i] <= 0 && i < len - 1) {
            negative++;
            i++;
        }
        if (negative >= 2) {
            return Math.max(nums[0] * nums[1], nums[len - 2] * nums[len - 3]) * nums[len - 1];
        } else {
            return nums[len - 1] * nums[len - 2] * nums[len - 3];
        }

    }

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{-1, -2, -3}));
    }
}
