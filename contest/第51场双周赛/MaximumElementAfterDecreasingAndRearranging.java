package 第51场双周赛;

import java.util.Arrays;

/**
 * @author Matthew Han
 * @description
 * @date 2021/5/2 20:46
 * @since 1.0.0
 **/
public class MaximumElementAfterDecreasingAndRearranging {

    /**
     * #5732 减小和重新排列数组后的最大元素
     *
     * @param arr
     * @return
     */
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int prev = 1;
        int ans = prev;
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(prev - arr[i]) > 1) {
                arr[i] = prev + 1;

            }
            ans = Math.max(ans, arr[i]);
            prev = arr[i];
        }
        return ans;
    }
}
