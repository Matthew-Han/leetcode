package 贪心;

/**
 * @ClassName MinimumAddToMakeParenthesesValid
 * @Description #921 使括号有效的最少添加
 * @Author MatthewHan
 * @Date 2020/8/30 01:27
 * @Version 1.0
 **/
public class MinimumAddToMakeParenthesesValid {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 63.44% 的用户
     * 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 39.53% 的用户
     *
     * @param s
     * @return
     */
    public int minAddToMakeValid(String s) {
        int prev = s.length();
        while (prev > 0) {
            s = s.replace("()", "");
            if (prev == s.length()) {
                return s.length();
            }
            prev = s.length();
        }

        return 0;
    }

}
