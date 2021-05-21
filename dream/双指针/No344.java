package 双指针;

/**
 * @ClassName 双指针.ReverseString
 * @Description #344 反转字符串
 * @Author MatthewHan
 * @Date 2020/5/9 09:42
 * @Version 1.0
 **/
public class No344 {

    /**
     * 空间复杂度 O(1)
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.96% 的用户
     * 内存消耗 : 46.6 MB , 在所有 Java 提交中击败了 94.55% 的用户
     *
     * @param s
     */
    public static void reverseString(char[] s) {
        int lengthHalf = s.length / 2;
        int len = s.length;
        for (int i = 0; i < lengthHalf; i++) {
            char temp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = temp;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        reverseString(new char[]{'h', ' ', ',', 'e', 'l', 'O'});
    }
}
