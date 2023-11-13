package 第67场双周赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/12/13 15:29
 * @since 1.0
 **/
public class No2099 {

    /**
     * 找到和最大的长度为 K 的子序列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSubsequence(int[] nums, int k) {
        int[] xx = nums.clone();
        int[] ans = new int[k];
        Arrays.sort(xx);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(xx[xx.length - 1 - i]);
        }
        int index = 0;
        for (int num : nums) {
            if (list.contains(num)) {
                ans[index++] = num;
                list.remove((Object) num);
            }
        }
        return ans;
    }
}
