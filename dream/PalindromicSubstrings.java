/**
 * @ClassName PalindromicSubstrings
 * @Description #647 回文子串
 * @Author MatthewHan
 * @Date 2020/8/19 16:44
 * @Version 1.0
 **/
public class PalindromicSubstrings {


    int num = 0;

    /**
     * 高赞题解，中心扩张法，遇到不对的直接break了，不用算接下来更长的。
     *
     * @param s
     * @return
     */
    public int countSubstringsCenter(String s) {
        for (int i = 0; i < s.length(); i++) {
            // 回文串长度为奇数
            count(s, i, i);
            // 回文串长度为偶数
            count(s, i, i + 1);
        }
        return num;
    }

    public void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            num++;
            start--;
            end++;
        }
    }

    /**
     * 递归
     * 执行用时： 181 ms , 在所有 Java 提交中击败了 9.79% 的用户
     * 内存消耗： 92.4 MB , 在所有 Java 提交中击败了 5.01% 的用户
     *
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        if ("".equals(s) || null == s) {
            return 0;
        }
        int count = s.length();
        char[] chars = s.toCharArray();
        return count + dfs(chars, 0, s.length());
    }

    public static int dfs(char[] chars, int start, int size) {
        if (size == 1) {
            return 0;
        }
        int tmp = 0;
        if (check(chars, start, size)) {
            tmp++;
        }

        if (start + size == chars.length) {
            start = -1;
            size--;

        }
        start++;
        return tmp + dfs(chars, start, size);
    }

    public static boolean check(char[] chars, int start, int size) {
        int left = start;
        int right = start + size - 1;
        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("qqqwwqqq"));

    }

}
