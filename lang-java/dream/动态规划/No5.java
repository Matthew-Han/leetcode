package 动态规划;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/3/14 09:51 14
 * @since 1.0
 **/
public class No5 {

    /**
     * 最长回文子串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        String res = sb.toString();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            int l = i - 1;
            int r = i + 1;
            for (int j = i - 1; j >= 0; --j) {
                if (s.charAt(j) == s.charAt(i)) {
                    sb.insert(0, s.charAt(j));
                    l = j - 1;
                } else {
                    l = j;
                    break;
                }
            }
            for (int j = i + 1; j < s.length(); ++j) {
                if (s.charAt(j) == s.charAt(i)) {
                    sb.append(s.charAt(j));
                    r = j + 1;
                } else {
                    r = j;
                    break;
                }
            }
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }
                sb.insert(0, s.charAt(l));
                sb.append(s.charAt(r));
                l--;
                r++;
            }
            if (sb.length() > ans) {
                ans = sb.length();
                res = sb.toString();
            }
            sb = new StringBuilder();
        }
        return res;
    }
}
