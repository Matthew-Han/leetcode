/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/12/30 09:58
 **/
public class ProductOfArrayExceptSelf {

    /**
     * #238 除自身以外数组的乘积
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 56.16% 的用户
     * 内存消耗： 51.6 MB , 在所有 Java 提交中击败了 12.01% 的用户
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            left[i] = 1;
            right[i] = 1;
        }
        int leftSum = 1;
        for (int i = 1; i < res.length; i++) {
            leftSum *= nums[i - 1];
            left[i] *= leftSum;
        }
        int rightSum = 1;
        for (int i = res.length - 2; i >= 0; i--) {
            rightSum *= nums[i + 1];
            left[i] *= rightSum;
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

}
