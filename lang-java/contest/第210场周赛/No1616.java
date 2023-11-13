package 第210场周赛;

/**
 * @author MatthewHan
 * @version 1.0
 * @description
 * @date 2020/10/11 10:22
 **/
public class No1616 {


    /**
     * #1616 分割两个字符串得到回文串
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean checkPalindromeFormation(String a, String b) {
        if (check(a) || check(b)) {
            return true;
        }
        String reverseA = new StringBuilder(a).reverse().toString();
        String reveresB = new StringBuilder(b).reverse().toString();
        int len = a.length();
        int count1 = maxLength(a, reveresB);
        String newA1 = a.substring(0, count1) + b.substring(count1);
        String newA2 = a.substring(0, len - count1) + b.substring(len - count1);
        int count2 = maxLength(b, reverseA);
        String newB1 = b.substring(0, count2) + a.substring(count2);
        String newB2 = b.substring(0, len - count2) + a.substring(len - count2);
        return check(newA1) || check(newA2) || check(newB1) || check(newB2);
    }

    public static boolean check(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString().equals(str);
    }

    public static int maxLength(String str, String reverseStr) {
        int len = str.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if ((str.charAt(i) != reverseStr.charAt(i))) {
                break;
            }
            if (str.charAt(i) == reverseStr.charAt(i)) {
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(checkPalindromeFormation("ulaAcfd", "jizBalu"));
    }
}
