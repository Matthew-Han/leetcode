import java.util.Arrays;

/**
 * @ClassName MaximumProductOfTwoElementsInAnArray
 * @Description #1464 数组中两元素的最大乘积
 * @Author MatthewHan
 * @Date 2020/7/14 18:34
 * @Version 1.0
 **/
public class No1464 {


    /**
     * 找寻第一大和第二大的元素
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 88.97% 的用户
     * 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public int maxProductPro(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : nums) {
            // 这里需要==，出现相同最大元素
            if (max <= num) {
                secondMax = max;
                max = num;
            }
            if (num < max && secondMax < num) {
                secondMax = num;
            }
        }
        return (secondMax - 1) * (max - 1);

    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 67.78% 的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    public static void main(String[] args) {

    }
}
