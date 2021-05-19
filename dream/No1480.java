/**
 * @ClassName RunningSumOf1dArray
 * @Description #1480 一维数组的动态和
 * @Author MatthewHan
 * @Date 2020/7/15 11:23
 * @Version 1.0
 **/
public class No1480 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[i];
            nums[i] = sum;
            sum -= temp;
        }
        return nums;
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public int[] runningSumPro(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i + 1] = nums[i] + nums[i + 1];
        }
        return nums;
    }


}
