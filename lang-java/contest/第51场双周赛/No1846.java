package 第51场双周赛;

import java.util.Arrays;

/**
 * @author Matthew Han
 * @description
 * @date 2021/5/2 20:46
 * @since 1.0.0
 **/
public class No1846 {

    /**
     * #1846 减小和重新排列数组后的最大元素
     *
     * @param arr
     * @return
     */
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if (arr[0] != 1) {
            arr[0] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }
}
