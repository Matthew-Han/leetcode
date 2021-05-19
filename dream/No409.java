import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LongestPalindrome
 * @Description #409 最长回文串
 * @Author MatthewHan
 * @Date 2020/5/14 14:22
 * @Version 1.0
 **/
public class No409 {

    /**
     * 执行用时 : 12 ms , 在所有 Java 提交中击败了 16.45% 的用户
     * 内存消耗 : 39.5 MB , 在所有 Java 提交中击败了 5.00% 的用户
     *
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length() * 4 / 3 + 1);
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int len = 0;
        System.out.println(map);
        boolean isContainsOdd = false;
        for (Integer value : map.values()) {
            if (value % 2 != 0) {
                isContainsOdd = true;
            }
            value /= 2;
            len += value * 2;
        }
        return isContainsOdd ? len + 1 : len;

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("asdsAkjnahsAJbJBkjsaLKASJLk"));
    }
}
