/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/24 16:03
 **/
public class LongestSubarrayOf1sAfterDeletingOneElement {

    /**
     * #1493 删掉一个元素以后全为 1 的最长子数组
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 89.25% 的用户
     * 内存消耗： 47 MB , 在所有 Java 提交中击败了 79.67% 的用户
     *
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int ans = 0;
        int count1 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                ans = Math.max(ans, maxLen(i, nums));
            } else {
                count1++;
            }
        }
        if (count1 == len) {
            return len - 1;
        }
        return ans;
    }

    public int maxLen(int index, int[] nums) {
        int c = 0;
        if (index - 1 >= 0 && nums[index - 1] == 1) {
            for (int i = index - 1; i >= 0; i--) {
                if (nums[i] == 1) {
                    c++;
                } else {
                    break;
                }
            }
        }
        if (index + 1 < nums.length && nums[index + 1] == 1) {
            for (int i = index + 1; i < nums.length; i++) {
                if (nums[i] == 1) {
                    c++;
                } else {
                    break;
                }
            }
        }
        return c;
    }
}
