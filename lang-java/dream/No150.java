import java.util.Stack;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/22 09:46
 **/
public class No150 {

    /**
     * #150 逆波兰表达式求值
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 57.67% 的用户
     * 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 43.80% 的用户
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "*" -> {
                    int prev = stack.pop();
                    int ans = stack.pop() * prev;
                    stack.add(ans);
                }
                case "+" -> {
                    int prev = stack.pop();
                    int ans = prev + stack.pop();
                    stack.add(ans);
                }
                case "-" -> {
                    int prev = stack.pop();
                    int ans = stack.pop() - prev;
                    stack.add(ans);
                }
                case "/" -> {
                    int prev = stack.pop();
                    int ans = stack.pop() / prev;
                    stack.add(ans);
                }
                default -> stack.add(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
