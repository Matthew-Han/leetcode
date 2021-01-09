import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/1/10 01:08
 **/
public class SummaryRanges {


    /**
     * #228 汇总区间
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.2 MB , 在所有 Java 提交中击败了 99.49% 的用户
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (null == nums || 0 == nums.length) {
            return ans;
        }
        String pattern = "->";
        int prev = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                if (prev == nums[i]) {
                    ans.add(String.valueOf(prev));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(prev).append(pattern).append(nums[i]);
                    ans.add(sb.toString());
                }
                break;
            }
            if (nums[i] + 1 != nums[i + 1]) {
                if (prev == nums[i]) {
                    ans.add(String.valueOf(prev));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(prev).append(pattern).append(nums[i]);
                    ans.add(sb.toString());
                }
                if (i + 1 < nums.length) {
                    prev = nums[i + 1];
                }
            }

        }
        return ans;
    }
}
