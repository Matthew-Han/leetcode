import java.util.Stack;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/11 09:49
 **/
public class No227 {

    /**
     * #227 基本计算器 II
     * 执行用时： 26 ms , 在所有 Java 提交中击败了 21.86% 的用户
     * 内存消耗： 40.8 MB , 在所有 Java 提交中击败了 34.43% 的用户
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Object> stack = new Stack<>();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr >= '0' && curr <= '9') {
                tmp.append(curr);
            } else {
                if (curr == '+' || curr == '-') {
                    if (!tmp.isEmpty()) {
                        stack.push(Integer.parseInt(tmp.toString()));
                        tmp.setLength(0);
                    }
                    stack.push(curr);
                } else {
                    i++;
                    int prev;
                    if (!tmp.isEmpty()) {
                        prev = Integer.parseInt(tmp.toString());
                    } else {
                        prev = (Integer) stack.pop();
                    }
                    tmp.setLength(0);
                    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        tmp.append(s.charAt(i));
                        i++;
                    }
                    if (curr == '*') {
                        stack.push(prev * Integer.parseInt(tmp.toString()));
                    }
                    if (curr == '/') {
                        stack.push(prev / Integer.parseInt(tmp.toString()));
                    }
                    tmp.setLength(0);
                    i--;
                }
            }
            if (i == s.length() - 1) {
                if (!tmp.isEmpty()) {
                    stack.push(Integer.parseInt(tmp.toString()));
                }
            }

        }
        int ans = 0;
        char prev = 0;
        for (Object o : stack) {
            if (o.getClass() == Integer.class) {
                if (prev == '-') {
                    ans -= (Integer) o;
                } else {
                    ans += (Integer) o;
                }
            } else {
                prev = (Character) o;
            }
        }
        return ans;
    }

}
