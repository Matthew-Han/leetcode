package 面试题;

/**
 * @ClassName StringToUrl
 * @Description 面试题 01.03. URL化
 * @Author MatthewHan
 * @Date 2020/7/23 11:25
 * @Version 1.0
 **/
public class StringToUrl {


    /**
     * 执行用时： 39 ms , 在所有 Java 提交中击败了 19.66% 的用户
     * 内存消耗： 49.3 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @param length
     * @return
     */
    public String replaceSpaces2(String s, int length) {
        StringBuilder sb = new StringBuilder();
        // s.length()一定是大于length的
        for (int i = 0; i < length; i++) {
            char temp = s.charAt(i);
            sb.append(temp == ' ' ? "%20" : temp);
        }
        return sb.toString();

    }

    /**
     * 执行用时： 54 ms , 在所有 Java 提交中击败了 9.24% 的用户
     * 内存消耗： 48.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @param length
     * @return
     */
    public String replaceSpaces(String s, int length) {
        return s.substring(0, length).replaceAll(" ", "%20");
    }
}
