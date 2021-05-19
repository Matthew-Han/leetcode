/**
 * @ClassName ReverseStringII
 * @Description #541 反转字符串 II
 * @Author MatthewHan
 * @Date 2020/5/20 14:33
 * @Version 1.0
 **/
public class No541 {

    /**
     * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
     * <p>
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     * <p>
     * 示例:
     * <p>
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     * <p>
     * 执行用时 : 3 ms , 在所有 Java 提交中击败了 25.00% 的用户
     * 内存消耗 : 40 MB , 在所有 Java 提交中击败了 9.09% 的用户
     *
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        int len = s.length();
        int left = 0;
        char[] chars = s.toCharArray();
        while (left < s.length()) {
            // 1. 如果剩余字符少于 k 个，则将剩余字符全部反转。
            if (len < k) {
                // 交换前k
                int j = s.length() - 1;
                for (int i = left; i < j; i++) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    j--;
                }
                break;
            } else {
                // 交换前k
                int f = left + k - 1;
                for (int i = left; i < f; i++) {
                    char temp = chars[i];
                    chars[i] = chars[f];
                    chars[f] = temp;
                    f--;
                }
                left += 2 * k;
                len -= 2 * k;
                System.out.println(chars);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            stringBuilder.append(aChar);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcvfds", 3));
    }
}
