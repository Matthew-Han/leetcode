import java.util.Arrays;

/**
 * @ClassName FindTheDifference
 * @Description #389 找不同
 * @Author MatthewHan
 * @Date 2020/5/12 10:49
 * @Version 1.0
 **/
public class No389 {

    /**
     * 执行用时 : 47 ms , 在所有 Java 提交中击败了 5.08% 的用户
     * 内存消耗 : 40.6 MB , 在所有 Java 提交中击败了 25.00% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        String[] s1 = s.split("");
        String[] t1 = t.split("");
        Arrays.sort(s1);
        Arrays.sort(t1);
        // 以短的字符串长度作为循环，遍历不同的元素（已排序后）
        for (int i = 0; i < s.length(); i++) {
            if (!s1[i].equals(t1[i])) {
                return t1[i].charAt(0);
            }
        }
        // 如果上述没找到和s字符串相同而元素，那一定是在末尾
        return t1[t.length() - 1].charAt(0);
    }

    /**
     * 利用2个字符串ascii码的差值求出那个差
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 78.39% 的用户
     * 内存消耗 : 37.6 MB , 在所有 Java 提交中击败了 25.00% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifferencePro(String s, String t) {
        char num1 = 0;
        char num2 = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            num1 += s.charAt(i);
            num2 += t.charAt(i);
        }
        num2 += t.charAt(len);
        return (char) (num2 - num1);
    }
}
