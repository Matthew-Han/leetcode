package 滑动窗口;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/5/5 10:34 05
 * @since 1.0
 **/
public class No713 {

    public int preSum(int[] nums, int k) {
        int ans = 0;
        int limit = 0;
        int prev = 1;
        for (int i = 0; i < nums.length; i++) {
            prev /= i - 1 >= 0 ? nums[i - 1] : 1;
            for (int j = Math.max(i, limit); j < nums.length; j++) {
                prev *= nums[j];
                if (prev >= k) {
                    limit = j;
                    prev /= j == i ? 1 : nums[j];
                    break;
                }
                if (j == nums.length - 1) {
                    limit = j + 1;
                    break;
                }
            }
            ans += Math.max(0, limit - i);
        }
        return ans;
    }

    /**
     * 乘积小于 K 的子数组
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = 1;
            for (int j = i; j < nums.length; j++) {
                start *= nums[j];
                if (start >= k) {
                    ans += j - i;
                    break;
                }
                if (j == nums.length - 1) {
                    ans += j - i + 1;
                    break;
                }
            }
        }
        return ans;
    }


    public int sum(int size) {
        int ans = 0;
        long factorial = 1;
        for (int i = 1; i <= size; i++) {
            factorial *= i;
        }
        int b = 1;
        long c = factorial;
        for (int i = 1; i <= size; i++) {
            b *= i;
            c /= (size - i + 1);
            ans += factorial / (b * c);
        }

        return ans;
    }
}
