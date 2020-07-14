import java.util.Arrays;

/**
 * @ClassName MaximumProductOfTwoElementsInAnArray
 * @Description #1464 数组中两元素的最大乘积
 * @Author MatthewHan
 * @Date 2020/7/14 18:34
 * @Version 1.0
 **/
public class MaximumProductOfTwoElementsInAnArray {

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
