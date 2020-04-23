/**
 * @ClassName ValidPalindrome
 * @Description #125 验证回文串
 * @Author MatthewHan
 * @Date 2020/4/20 11:29
 * @Version 1.0
 **/
public class ValidPalindrome {
    /**
     * 执行用时 : 30 ms , 在所有 Java 提交中击败了 14.13% 的用户
     * 内存消耗 : 40.8 MB , 在所有 Java 提交中击败了 7.14% 的用户
     * -----------------------------------------------------
     * Java的话还是比较简单的，有现成的api可用，一个是利用正则提取字母 + 数字
     * 再利用StringBuilder的反转字符串和原字符串比较，过滤好的字符串如果是回文字符串怎么反转都和本身一样
     * 大小写只要利用equalsIgnoreCase()方法即可。
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (null == s) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        String reverse = String.valueOf(new StringBuilder(s).reverse());
        return s.equalsIgnoreCase(reverse);

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
