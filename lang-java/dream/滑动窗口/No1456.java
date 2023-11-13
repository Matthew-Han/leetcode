package 滑动窗口;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/3 16:01
 **/
public class No1456 {


    /**
     * #1456 定长子串中元音的最大数目
     * 执行用时： 12 ms , 在所有 Java 提交中击败了 81.08% 的用户
     * 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 5.02% 的用户
     *
     * @param s
     * @param k
     * @return
     */
    public int maxVowels(String s, int k) {
        boolean[] map = new boolean[26];
        map[0] = true;
        map['e' - 'a'] = true;
        map['i' - 'a'] = true;
        map['o' - 'a'] = true;
        map['u' - 'a'] = true;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            if (map[s.charAt(i) - 'a']) {
                ans++;
            }
        }
        int left = 0;
        int right = k;
        int tmp = ans;
        while (right < s.length()) {
            tmp -= map[s.charAt(left++) - 'a'] ? 1 : 0;
            tmp += map[s.charAt(right++) - 'a'] ? 1 : 0;
            if (tmp >= k) {
                return tmp;
            }
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}
