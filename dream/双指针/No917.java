package 双指针;

import java.util.Arrays;

/**
 * @ClassName 双指针.ReverseOnlyLetters
 * @Description #917 仅仅反转字母
 * @Author MatthewHan
 * @Date 2020/6/23 14:10
 * @Version 1.0
 **/
public class No917 {

    /**
     * 原地双指针
     * 元素交换有以下三种方式
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 78.75% 的用户
     * 内存消耗： 37.4 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param s
     * @return
     */
    public static String reverseOnlyLettersByDoublePointer(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;


        // 方式 1
        while (i <= j) {
            char left = chars[i];
            char right = chars[j];
            if (Character.isLetter(left) && Character.isLetter(right)) {
                chars[i] = right;
                chars[j] = left;
                i++;
                j--;
            }
            if (!Character.isLetter(left)) {
                i++;
            }
            if (!Character.isLetter(right)) {
                j--;
            }
        }

        // 方式 2
        while (i <= j) {
            if (!Character.isLetter(chars[i])) {
                i++;
                /*
                 * continue 跳出当前循环一次
                 * 因为下面的 chars[i] 指针指向的元素变了会出现可能数组下标越界
                 *
                 */
                continue;
            }
            if (!Character.isLetter(chars[j])) {
                j--;
                continue;
            }
            if (Character.isLetter(chars[i]) && Character.isLetter(chars[j])) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }

        }

        // 方式3
        while (i <= j) {
            if (!Character.isLetter(chars[i])) {
                i++;
            }
            if (!Character.isLetter(chars[j])) {
                j--;
            }
            /*
             * 因为上面 i, j 指针变了，所以这里需要加判断条件
             */
            if (j >= 0 && i <= j && Character.isLetter(chars[i]) && Character.isLetter(chars[j])) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }

        }


        // 这里这样写和下面的 for 循环 append 方法其内核其实是一样的
        return String.valueOf(chars);
    }

    public static boolean isEnglishLetter(char n) {
        return 'a' <= n && n <= 'z' || 'A' <= n && n <= 'Z';
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 78.75% 的用户
     * 内存消耗： 38 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param s
     * @return
     */
    public static String reverseOnlyLetters(String s) {
        char[] fucker = new char[s.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z' || 'A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                sb.append(s.charAt(i));
            } else {
                fucker[i] = s.charAt(i);
            }
        }
        String temp = sb.reverse().toString();

        int t = 0;
        for (int i = 0; i < fucker.length; i++) {
            if (fucker[i] == 0) {
                fucker[i] = temp.charAt(t);
                t++;
            }
        }
        sb.delete(0, sb.length());
        for (char c : fucker) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLettersByDoublePointer("Test1ng-Leet=code-Q!"));
        System.out.println(reverseOnlyLettersByDoublePointer("Qedo1ct-eeLg=ntse-T!"));
        System.out.println(reverseOnlyLettersByDoublePointer("!ab"));
        String[] fuck1 = "fuck".split("");
        char[] fuck2 = "fuck".toCharArray();
        System.out.println(Arrays.toString(fuck1));
        System.out.println(String.valueOf(fuck2));


    }
}
