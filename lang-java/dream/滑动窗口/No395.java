package 滑动窗口;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/23 16:39
 **/
public class No395 {

    int ans = 0;

    /**
     * #395 至少有K个重复字符的最长子串
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 78.46% 的用户
     * 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 37.90% 的用户
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        dfs(s, k, 0, s.length());
        return ans;

    }

    public void dfs(String s, int k, int left, int right) {
        int[] bucket = new int[26];
        for (int i = left; i < right; i++) {
            bucket[s.charAt(i) - 'a']++;
        }
        for (int i = left; i < right; i++) {
            int curr = s.charAt(i) - 'a';
            bucket[curr] = bucket[curr] >= k ? 0 : bucket[curr];
        }
        int prev = left;
        boolean flag = true;
        for (int i = left; i < right; i++) {
            if (bucket[s.charAt(i) - 'a'] > 0) {
                flag = false;
                dfs(s, k, prev, i);
                prev = i + 1;
            }
        }
        if (flag) {
            ans = Math.max(ans, right - left);
        } else {
            dfs(s, k, prev, right);
        }
    }


}
