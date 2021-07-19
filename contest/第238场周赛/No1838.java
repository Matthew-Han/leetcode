package 第238场周赛;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/19 10:27
 * @since 1.0
 **/
public class No1838 {

    /**
     * 最高频元素的频数
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int tmp = 1;
            int d = k;
            if (i < ans) {
                break;
            }
            for (int j = i - 1; j >= 0; j--) {
                int diff = nums[i] - nums[j];
                if (d >= diff) {
                    d -= diff;
                    tmp++;
                } else {
                    break;
                }
            }
            ans = Math.max(ans, tmp);
        }
        return ans;

    }
}
