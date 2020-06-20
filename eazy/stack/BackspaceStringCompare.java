package stack;

import java.util.Stack;

/**
 * @ClassName stack.BackspaceStringCompare
 * @Description #844 比较含退格的字符串
 * @Author MatthewHan
 * @Date 2020/6/20 16:50
 * @Version 1.0
 **/
public class BackspaceStringCompare {

    /**
     * 执行用时 : 3 ms , 在所有 Java 提交中击败了 57.36% 的用户
     * 内存消耗 : 38.3 MB , 在所有 Java 提交中击败了 33.33% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack1.empty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(s.charAt(i));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                stack2.pop();
            } else {
                stack2.push(t.charAt(i));
            }
        }
        System.out.println("stack1 = " + stack1);
        System.out.println("stack2 = " + stack2);
        return stack1.equals(stack2);
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("#ss#v", "ss#s"));

    }
}
