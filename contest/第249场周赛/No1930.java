package 第249场周赛;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/12 09:21
 * @since 1.0
 **/
public class No1930 {

    /**
     * 长度为 3 的不同回文子序列
     *
     * @param s
     * @return
     */
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            Set<Character> set = new HashSet<>();
            char target = (char) ('a' + i);
            int l = 0;
            int r = s.length() - 1;
            while (l < s.length() - 2 && s.charAt(l) != target) {
                l++;
            }

            while (r > 1 && s.charAt(r) != target) {
                r--;
            }
            if (s.charAt(l) == target && s.charAt(r) == target) {
                for (int k = l + 1; k < r; k++) {
                    set.add(s.charAt(k));
                }
                ans += set.size();
            }


        }
        return ans;
    }
}
