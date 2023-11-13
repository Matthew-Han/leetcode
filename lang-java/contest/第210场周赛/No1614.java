package 第210场周赛;

import java.util.Stack;

/**
 * @author MatthewHan
 * @version 1.0
 * @description
 * @date 2020/10/11 10:21
 **/
public class No1614 {

    public int date20220107(String s) {
        int ans = 0;
        int t = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(s.charAt(i));
                t++;
                ans = Math.max(ans, t);
            } else if (s.charAt(i) == ')' && !stack.isEmpty()) {
                stack.pop();
                t--;
            }
        }
        return ans;

    }


    /**
     * #1614 括号的最大嵌套深度
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
