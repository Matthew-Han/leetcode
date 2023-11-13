/**
 * @ClassName GreatestCommonDivisorOfStrings
 * @Description #1071 字符串的最大公因子
 * @Author MatthewHan
 * @Date 2020/7/5 22:56
 * @Version 1.0
 **/
public class No1071 {

    /**
     * 执行用时： 10 ms , 在所有 Java 提交中击败了 12.29% 的用户
     * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String gcdOfStrings(String str1, String str2) {
        int min;
        StringBuilder sb;
        if (str1.length() <= str2.length()) {
            min = str1.length();
            sb = new StringBuilder(str1);
        } else {
            min = str2.length();
            sb = new StringBuilder(str2);
        }
        for (int i = 0; i < min; i++) {
            // 最长的情况应该是较短或者相同的那个字符串，所以倒序
            if (!isSonOfaBitch(sb.toString(), str1) || !isSonOfaBitch(sb.toString(), str2)) {
                sb.delete(sb.length() - 1, sb.length());
            } else {
                return sb.toString();
            }
        }
        return "";

    }

    public static boolean isSonOfaBitch(String son, String bitch) {
        int multiple = bitch.length() / son.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < multiple; i++) {
            sb.append(son);
        }
        return bitch.equals(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABABAB", "ABAB"));
    }
}
