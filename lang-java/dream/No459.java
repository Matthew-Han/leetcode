/**
 * @ClassName RepeatedSubstringPattern
 * @Description #459 重复的子字符串
 * @Author MatthewHan
 * @Date 2020/5/16 23:49
 * @Version 1.0
 **/
public class No459 {

    /**
     * 执行用时： 48 ms , 在所有 Java 提交中击败了 71.99% 的用户
     * 内存消耗： 40.3 MB , 在所有 Java 提交中击败了 43.66% 的用户
     *
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern2(String s) {
        if (s.length() == 1) {
            return false;
        }
        int len = s.length();
        for (int i = 1; i < len; i++) {
            // 这个sub长度一定是可以除得尽的
            if (len % i == 0 && check(s, i)) {
                return true;
            }
        }
        return false;

    }

    public static boolean check(String s, int size) {
        char[] tmp = new char[size];
        for (int i = 0; i < size; i++) {
            tmp[i] = s.charAt(i);
        }
        String sub = new String(tmp);
        StringBuilder res = new StringBuilder();
        int count = s.length() / size;
        res.append(sub.repeat(count));
        return res.toString().equals(s);
    }


    /**
     * 执行用时 : 281 ms , 在所有 Java 提交中击败了 7.05% 的用户
     * 内存消耗 : 40.5 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {
        int sonLen = 1;
        while (sonLen <= s.length()) {
            String window = s.substring(0, sonLen);
            boolean result = false;
            int start = window.length();
            int end;
            while (start < s.length()) {
                end = Math.min((start + sonLen), s.length());
                if (window.equals(s.substring(start, end))) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
                start += sonLen;
            }
            if (result) {
                return true;
            }
            sonLen++;
        }
        return false;
    }

    /**
     * 就知道是数学题！
     * 假如字符串S有N个字符串s组成，那么2个S组成的字符串应该是由2N个s字符串组成
     * 将原字符串给出拷贝一遍组成新字符串
     * 掐头去尾留中间
     * 如果还包含原字符串，则满足题意
     *
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPatternPro(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }


}
