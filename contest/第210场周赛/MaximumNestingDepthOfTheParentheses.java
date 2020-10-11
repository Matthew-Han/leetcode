package 第210场周赛;

/**
 * @author MatthewHan
 * @version 1.0
 * @description
 * @date 2020/10/11 10:21
 **/
public class MaximumNestingDepthOfTheParentheses {


    /**
     * #5535 括号的最大嵌套深度
     *
     * @param s
     * @return
     */
    public int maxDepth(String s) {
        s = filter(s);
        int prev = s.length();
        int i = 0;
        while (s.length() / 2 > 0) {
            i++;
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
            if (s.length() == prev) {
                break;
            }
            prev = s.length();
        }
        return i;
    }

    public static String filter(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == ')') {
                sb.append(curr);
            }
        }
        return sb.toString();
    }

}
