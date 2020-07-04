import java.util.Stack;

/**
 * @ClassName RemoveAllAdjacentDuplicatesInString
 * @Description #1047 删除字符串中的所有相邻重复项
 * @Author MatthewHan
 * @Date 2020/7/5 01:43
 * @Version 1.0
 **/
public class RemoveAllAdjacentDuplicatesInString {


    /**
     * 执行用时： 50 ms , 在所有 Java 提交中击败了 25.58% 的用户
     * 内存消耗： 40.5 MB , 在所有 Java 提交中击败了 7.69% 的用户
     *
     * @param s
     * @return
     */
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            int len = sb.length();
            stack.removeAllElements();
            for (int i = 0; i < sb.length(); i++) {
                char curr = sb.charAt(i);
                if (stack.size() != 0 && stack.peek() == curr) {
                    stack.pop();
                } else {
                    stack.push(curr);
                }
            }
            sb.delete(0, sb.length());
            for (Character character : stack) {
                sb.append(character);
            }
            if (len == sb.length()) {
                return sb.toString();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("cssaacsafvvs"));
    }

}
