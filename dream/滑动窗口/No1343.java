package 滑动窗口;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/27 19:06
 * @description
 * @since 1.0.0
 **/
public class No1343 {

    /**
     * #1343 大小为 K 且平均值大于等于阈值的子数组数目
     *
     * @param arr
     * @param k
     * @param threshold
     * @return
     */
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int sum = 0;
        threshold *= k;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        ans += sum >= threshold ? 1 : 0;
        for (int i = k; i < arr.length; i++) {
            sum -= arr[i - k];
            sum += arr[i];
            ans += sum >= threshold ? 1 : 0;
        }
        return ans;

    }

}
