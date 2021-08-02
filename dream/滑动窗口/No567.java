package 滑动窗口;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/2 09:48
 * @since 1.0
 **/
public class No567 {

    /**
     * 字符串的排列
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] bucket1 = new int[26];
        int[] bucket2 = new int[26];
        for (char a : s1.toCharArray()) {
            bucket1[a - 'a']++;
        }
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            bucket2[s2.charAt(i) - 'a']++;
        }
        if (check(bucket1, bucket2)) {
            return true;
        }
        for (int i = 1; i <= s2.length() - len; i++) {
            bucket2[s2.charAt(i - 1) - 'a']--;
            bucket2[s2.charAt(i + len - 1) - 'a']++;
            if (check(bucket1, bucket2)) {
                return true;
            }
        }
        return false;
    }

    public boolean check(int[] b1, int[] b2) {
        for (int i = 0; i < 26; i++) {
            if (b1[i] != b2[i]) {
                return false;
            }
        }
        return true;
    }
}
