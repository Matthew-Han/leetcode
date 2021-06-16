package 第238场周赛;

import java.util.Stack;

/**
 * @author Matthew Han
 * @description
 * @date 2021/4/25 16:19
 * @since 1.0.0
 **/
public class No1839 {

    /**
     * #1839 所有元音按顺序排布的最长子字符串
     *
     * @param word
     * @return
     */
    public int longestBeautifulSubstring(String word) {
        int ans = 0;
        char[] w = word.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : w) {
            if (stack.isEmpty() && c == 'a') {
                stack.add(c);
                continue;
            }
            if (!stack.isEmpty()) {
                if (stack.peek() > c) {
                    if (stack.peek() == 'u') {
                        ans = Math.max(ans, stack.size());
                    }
                    stack.clear();
                    if (c == 'a') {
                        stack.add(c);
                    }
                } else if (stack.peek() == c) {
                    stack.add(c);
                } else {
                    if (stack.peek() == 'a' && c == 'e') {
                        stack.add(c);
                        continue;
                    }
                    if (stack.peek() == 'e' && c == 'i') {
                        stack.add(c);
                        continue;
                    }
                    if (stack.peek() == 'i' && c == 'o') {
                        stack.add(c);
                        continue;
                    }
                    if (stack.peek() == 'o' && c == 'u') {
                        stack.add(c);
                        continue;
                    }
                    stack.clear();
                    if (c == 'a') {
                        stack.add(c);
                    }
                }
            }
        }
        if (!stack.isEmpty() && stack.peek() == 'u') {
            ans = Math.max(ans, stack.size());
        }
        return ans;
    }
}
