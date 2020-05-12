/**
 * @ClassName IsSubsequence
 * @Description #392 判断子序列
 * @Author MatthewHan
 * @Date 2020/5/12 14:47
 * @Version 1.0
 **/
public class IsSubsequence {

    /**
     * 第一次内存占用打败100%😂
     * 执行用时 : 220 ms , 在所有 Java 提交中击败了 6.89% 的用户
     * 内存消耗 : 43.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        int k = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int i1 = k; i1 < t.length(); i1++) {
                System.out.println("i = " + i);
                System.out.println("i1 = " + i1);
                System.out.println("count = " + count);
                if (s.charAt(i) == t.charAt(i1)) {
                    count++;
                    k = i1 + 1;
                    break;
                }
            }
        }
        System.out.println(count);
        return s.length() == count;
    }

    /**
     * 双指针方法
     * 执行用时 : 13 ms , 在所有 Java 提交中击败了 40.63% 的用户
     * 内存消耗 : 43 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequencePro(String s, String t) {
        int i = 0;
        int k = 0;
        int count = 0;
        while (i < s.length()) {
            if (k < t.length() && s.charAt(i) == t.charAt(k)) {
                count++;
                i++;
            }
            k++;
        }
        return s.length() == count;
    }


    public static void main(String[] args) {
        System.out.println(isSubsequence("leeetcode", "letcode"));
    }
}
