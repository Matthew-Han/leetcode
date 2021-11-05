package 动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/11/5 11:09
 * @since 1.0
 **/
public class No1218 {

    /**
     * 最长定差子序列
     *
     * @param arr
     * @param difference
     * @return
     */
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i - difference, 0) + 1);
            ans = Math.max(ans, map.get(i));
        }
        return ans;
    }
}
