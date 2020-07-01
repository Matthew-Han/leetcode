/**
 * @ClassName RemoveOutermostParentheses
 * @Description #1021 删除最外层的括号
 * @Author MatthewHan
 * @Date 2020/7/1 21:11
 * @Version 1.0
 **/
public class RemoveOutermostParentheses {

    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                --level;
            }
            if (level >= 1) {
                sb.append(c);
            }
            if (c == '(') {
                ++level;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        removeOuterParentheses("(()())(())(()(()))");
    }
}
