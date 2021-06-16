/**
 * @ClassName LcOf05
 * @Description 剑指 Offer #05 替换空格 LCOF
 * @Author MatthewHan
 * @Date 2020/7/17 14:55
 * @Version 1.0
 **/
public class L05 {


    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == ' ') {
                sb.insert(i, "%20");
                sb.delete(i + 3, i + 4);
            }
        }
        System.out.println("sb = " + sb);
        return s.replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(" We are happy . "));
    }
}
