/**
 * @ClassName ValidPalindromeII
 * @Description #680 验证回文字符串 Ⅱ
 * @Author MatthewHan
 * @Date 2020/5/24 00:21
 * @Version 1.0
 **/
public class No680 {


    /**
     * 1. s.charAt(i)，比chars[i]（char[] chars = s.toCharArray(); ）快，toCharArray()方法还要拷贝到一个新的char类型的数组中。
     * 2. 使用贪心算法的过程中，对于第一个flag加一个判断是否为true（如果为true的情况较多，测试用例是这样的）应该能更快一点。
     * <p>
     * 执行用时 : 8 ms , 在所有 Java 提交中击败了 76.75% 的用户
     * 内存消耗 : 40.1 MB , 在所有 Java 提交中击败了 6.67% 的用户
     *
     * @param s
     * @return
     */
    public static boolean validPalindromePro(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] charArray = s.toCharArray();
        s.charAt(1);
        while (i < j) {

            if (charArray[i] != charArray[j]) {
                boolean condition = true;
                int left = i + 1;
                int right = j;
                // i这边：
                while (left < right) {
                    if (charArray[left] != charArray[right]) {
                        condition = false;
                        break;
                    }
                    left++;
                    right--;
                }
                // 加个这个应该会更快
                if (condition) {
                    return true;
                }

                boolean condition2 = true;
                left = i;
                right = j - 1;
                // j这边：
                while (left < right) {
                    if (charArray[left] != charArray[right]) {
                        condition2 = false;
                        break;
                    }
                    left++;
                    right--;

                }
                return condition2;
            }
            i++;
            j--;

        }
        return true;

    }

    /**
     * 超出时间限制
     *
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder(s);
        if (stringBuilder.reverse().toString().equals(s)) {
            return true;
        }
        stringBuilder.reverse();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (chars[i] != chars[j]) {
                StringBuilder sb1 = new StringBuilder(stringBuilder.delete(i, i + 1).toString());
                stringBuilder.insert(i, chars[i]);
                System.out.println("sb1 = " + sb1);

                StringBuilder sb2 = new StringBuilder(stringBuilder.delete(j, j + 1).toString());
                stringBuilder.insert(j, chars[j]);
                System.out.println("sb2 = " + sb2);
                if (sb1.toString().equals(sb1.reverse().toString())) {
                    return true;
                }
                if (sb2.toString().equals(sb2.reverse().toString())) {
                    return true;
                }
            }
            i++;
            j--;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validPalindromePro("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
