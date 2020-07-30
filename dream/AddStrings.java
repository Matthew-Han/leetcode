import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName AddStrings
 * @Description #415 字符串相加
 * @Author MatthewHan
 * @Date 2020/5/14 15:48
 * @Version 1.0
 **/
public class AddStrings {

    /**
     * 执行用时 : 3 ms , 在所有 Java 提交中击败了 82.32% 的用户
     * 内存消耗 : 39.4 MB , 在所有 Java 提交中击败了 8.33% 的用户
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int maxLen = Math.max(num1.length(), num2.length());
        int[] fucker = new int[maxLen];
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (maxLen > 0) {
            int ss = (i >= 0 ? (char1[i] - 48) : 0) + (j >= 0 ? (char2[j] - 48) : 0);
            fucker[maxLen - 1] = ss;
            maxLen--;
            i--;
            j--;
        }
        int[] fucker2 = new int[fucker.length + 1];
        int f = 1;
        for (int value : fucker) {
            fucker2[f] = value;
            f++;
        }
        for (int k = fucker2.length - 1; k >= 0; k--) {
            if (fucker2[k] > 9) {
                fucker2[k] = fucker2[k] - 10;
                fucker2[k - 1]++;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i1 = 0; i1 < fucker2.length; i1++) {
            if (i1 != 0 || fucker2[i1] != 0) {
                stringBuilder.append(fucker2[i1]);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("0", "0"));
        System.out.println((int) '9');
    }
}
