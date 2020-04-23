import java.util.*;

/**
 * @ClassName LongestCommonPrefix
 * @Description #14 最长公共前缀
 * @Author MatthewHan
 * @Date 2019/8/5 17:28
 * @Version 1.0
 **/
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"acaa", "cbsaa"};
        System.out.println(lcp.longestCommonPrefix(strs));
    }

    /**
     * 自己写的垃圾解法
     *
     * @param strs
     * @return
     */
    private String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        /**
         * 最小长度字符串
         */
        String minLengthStr = strs[0];
        for (String str : strs) {
            if (str.length() < minLengthStr.length()) {
                minLengthStr = str;
            }
        }
        String[] args = minLengthStr.split("");
        List<String[]> lists = new ArrayList<>(16);
        for (String str : strs) {
            if (!str.equals(minLengthStr)) {
                lists.add(str.split(""));
            }
        }
        for (int i = 0; i < minLengthStr.length(); i++) {
            for (String[] list : lists) {
                /* 相同下标位置的元素进行对比 */
                if (list[i].equals(args[i])) {
                    count++;
                }
                /* 长度至少是一位，若第一位就不相等，直接return ""。*/
                if (!list[0].equals(args[0])) {
                    return "";
                }
            }
            /* 累计数与集合长度一致时表示一次遍历，相同下标位置的元素都相等 */
            if (count == lists.size()) {
                sb.append(args[i]);
            }
            count = 0;
        }

        return sb.toString();
    }

    /**
     * LeetCode官方的解法
     *
     * @param strs
     * @return
     */
    private String longestCommonPrefix2(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if ("".equals(ans)) {
                return ans;
            }
        }
        return ans;
    }
}
