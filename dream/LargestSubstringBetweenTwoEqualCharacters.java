/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/4 16:00
 **/
public class LargestSubstringBetweenTwoEqualCharacters {

    /**
     * #1624 两个相同字符之间的最长子字符串
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 64.44% 的用户
     *
     * @param s
     * @return
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        int i = 0;
        while (i < s.length()) {
            char curr = s.charAt(i);
            int j = s.lastIndexOf(String.valueOf(curr));
            // 提前 break
            if (ans >= s.length() - i) {
                return ans - 1;
            }
            ans = Math.max(ans, j - i);
            i++;
        }
        return ans - 1;
    }

}
