import java.util.Stack;

/**
 * @ClassName SplitaStringInBalancedStrings
 * @Description #1221 分割平衡字符串
 * @Author MatthewHan
 * @Date 2020/7/8 10:45
 * @Version 1.0
 **/
public class SplitaStringInBalancedStrings {

    /**
     * 主要是大家都是计数，占比太高了，所以显得时间效率低
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 13.09% 的用户
     * 内存消耗： 37.6 MB , 在所有 Java 提交中击败了 5.00% 的用户
     *
     * @param s
     * @return
     */
    public static int balancedStringSplit(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (stack.size() == 0 || stack.peek() == temp) {
                stack.push(temp);
            } else {
                stack.pop();
            }
            if (stack.size() == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRRLLRLRLL"));
    }
}
