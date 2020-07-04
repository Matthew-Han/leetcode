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
     * 滑动窗口
     * 执行用时： 19 ms , 在所有 Java 提交中击败了 71.23% 的用户
     * 内存消耗： 40.4 MB , 在所有 Java 提交中击败了 7.69% 的用户
     *
     * @param s
     * @return
     */
    public static String removeDuplicatesPro(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = left + 1;
        while (true) {
            int len = s.length();
            while (left < len) {
                char leftNum = s.charAt(left);
                if (right < len && leftNum != s.charAt(right)) {
                    sb.append(leftNum);
                    left++;
                    right = left + 1;
                } else if (left == len - 1) {
                    sb.append(leftNum);
                    left++;
                } else {
                    left += 2;
                    right = left + 1;
                }
            }
            left = 0;
            right = left + 1;
            System.out.println("sb = " + sb);
            if (sb.length() == len) {
                return s;
            } else {
                s = sb.toString();
            }
            sb.delete(0, sb.length());
        }
    }

    /**
     * 执行用时： 29 ms , 在所有 Java 提交中击败了 52.96% 的用户
     * 内存消耗： 40.5 MB , 在所有 Java 提交中击败了 7.69% 的用户
     *
     * @param s
     * @return
     */
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (stack.size() != 0 && stack.peek() == curr) {
                stack.pop();
            } else {
                stack.push(curr);
            }
        }
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("cssaacsafvvs"));
    }

}
