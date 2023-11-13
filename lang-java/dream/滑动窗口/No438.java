package 滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/11/29 14:31
 * @since 1.0
 **/
public class No438 {

    /**
     * 找到字符串中所有字母异位词
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int[] src = new int[26];
        int[] curr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            src[p.charAt(i) - 'a']++;
            curr[s.charAt(i) - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (check(src, curr)) {
                ans.add(i);
            }
            curr[s.charAt(i) - 'a']--;
            curr[s.charAt(i + p.length()) - 'a']++;
        }
        if (check(src, curr)) {
            ans.add(s.length() - p.length());
        }
        return ans;
    }


    public boolean check(int[] src, int[] curr) {
        for (int i = 0; i < 26; i++) {
            if (src[i] != curr[i]) {
                return false;
            }
        }
        return true;
    }
}
