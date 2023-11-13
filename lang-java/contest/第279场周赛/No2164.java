package 第279场周赛;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/6 13:49 06
 * @since 1.0
 **/
public class No2164 {

    /**
     * 对奇偶下标分别排序
     *
     * @param nums
     * @return
     */
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        Integer[] odd = new Integer[n / 2];
        Integer[] even = new Integer[n / 2 + (n % 2)];
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                even[i / 2] = nums[i];
            } else {
                odd[i / 2] = nums[i];
            }
        }
        Arrays.sort(even);
        Arrays.sort(odd, (o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++) {
            nums[i] = ((i & 1) == 0) ? even[i / 2] : odd[i / 2];
        }
        return nums;
    }
}
