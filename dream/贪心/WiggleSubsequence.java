package 贪心;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/12/14 10:09
 **/
public class WiggleSubsequence {


    /**
     * #376 摆动序列
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36 MB , 在所有 Java 提交中击败了 74.89% 的用户
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int ans = 1;
        // -1 为 rising， 1 反之
        int status = 0;
        int curr = nums[0];
        // 第一次比较是上升还是下降
        boolean isFirst = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > curr) {
                if (status == 1) {
                    status = -1;
                    ans++;
                } else if (isFirst) {
                    isFirst = false;
                    status = -1;
                    ans++;
                }
            } else if (nums[i] < curr) {
                if (status == -1) {
                    status = 1;
                    ans++;
                } else if (isFirst) {
                    isFirst = false;
                    status = 1;
                    ans++;
                }
            }
            curr = nums[i];
        }
        return ans;
    }
}
