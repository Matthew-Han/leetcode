/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/31 10:11
 * @since 1.0
 **/
public class No1588 {

    /**
     * 所有奇数长度子数组的和
     *
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        for (int size = 1; size <= arr.length; size += 2) {
            for (int i = 0; i <= arr.length - size; i++) {
                for (int start = i; start < i + size; start++) {
                    ans += arr[start];
                }
            }
        }
        return ans;

    }
}
