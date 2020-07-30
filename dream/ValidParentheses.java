import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName ValidParentheses
 * @Description #20 有效的括号
 * @Author MatthewHan
 * @Date 2020/7/29 16:42
 * @Version 1.0
 **/
public class ValidParentheses {

    /**
     * 执行用时： 38 ms , 在所有 Java 提交中击败了 5.31% 的用户
     * 内存消耗： 40.2 MB , 在所有 Java 提交中击败了 5.48% 的用户
     *
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        if ((s.length() & 1) != 0) {
            return false;
        }
        int prev = s.length();
        while (s.length() / 2 > 0) {
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
            if (s.length() == prev) {
                return false;
            }
            prev = s.length();
        }
        return s.isEmpty();
    }

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 30.17% 的用户
     * 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 5.48% 的用户
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>(16);
        map.put('{', -1);
        map.put('}', 1);
        map.put('(', -2);
        map.put(')', 2);
        map.put('[', -3);
        map.put(']', 3);
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(temp);
            } else {
                int left = map.get(stack.peek());
                int right = map.get(temp);
                // 一正一负的话，必须加起来合为0；全负、全正就直接入栈
                boolean flag = ((left > 0 && right < 0) || (left < 0 && right > 0))
                        && left + right != 0;
                if (left + right == 0) {
                    stack.pop();
                } else if (flag) {
                    return false;
                } else {
                    stack.push(temp);
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
