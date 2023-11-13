package 第61场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/22 09:10
 * @since 1.0
 **/
public class No2006 {

    /**
     * 差的绝对值为 K 的数对数目
     *
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
