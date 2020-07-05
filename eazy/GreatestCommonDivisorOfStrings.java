/**
 * @ClassName GreatestCommonDivisorOfStrings
 * @Description #1071 字符串的最大公因子
 * @Author MatthewHan
 * @Date 2020/7/5 22:56
 * @Version 1.0
 **/
public class GreatestCommonDivisorOfStrings {

    /**
     * 执行用时： 17 ms , 在所有 Java 提交中击败了 8.65% 的用户
     * 内存消耗： 40.4 MB , 在所有 Java 提交中击败了 100.00% 的用户 炫耀一下:
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String gcdOfStrings(String str1, String str2) {
        int min;
        String temp;
        if (str1.length() <= str2.length()) {
            min = str1.length();
            temp = str1;
        } else {
            min = str2.length();
            temp = str2;
        }

        StringBuilder sb = new StringBuilder();
        String result = "";
        for (int i = 0; i < min; i++) {
            sb.append(temp.charAt(i));
            if (isSonOfaBitch(sb.toString(), str1) && isSonOfaBitch(sb.toString(), str2)) {

                result = sb.toString();
            }
        }
        return result;

    }

    public static boolean isSonOfaBitch(String son, String bitch) {
        int multiple = bitch.length() / son.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < multiple; i++) {
            sb.append(son);
        }
        return bitch.contentEquals(sb);
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABABAB", "AB"));
    }
}
