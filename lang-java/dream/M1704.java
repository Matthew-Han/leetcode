import java.util.Arrays;

/**
 * @ClassName MissingNumber
 * @Description 面试题 17.04. 消失的数字
 * @Author MatthewHan
 * @Date 2020/7/29 10:23
 * @Version 1.0
 **/
public class M1704 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 44.45% 的用户
     * 内存消耗： 40.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += i;
            sum -= nums[i];
        }
        sum += nums.length;
        return sum;
    }

    /**
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 6.66% 的用户
     * 内存消耗： 40.6 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] - nums[i - 1] != 1) {
                return i;
            }
        }
        return nums[0] == 0 ? nums.length : 0;
    }
}
