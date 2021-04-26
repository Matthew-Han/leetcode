package 第238场周赛;

import java.util.Queue;
import java.util.Stack;

/**
 * @author Matthew Han
 * @description
 * @date 2021/4/25 16:19
 * @since 1.0.0
 **/
public class LongestSubstringOfAllVowelsInOrder {

    /**
     * #5740 所有元音按顺序排布的最长子字符串
     *
     * @param word
     * @return
     */
    public int longestBeautifulSubstring(String word) {
        int ans = 0;
        char[] w = word.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < w.length; i++) {
            if (stack.isEmpty() && w[i] == 'a') {
                stack.add(w[i]);
                continue;
            }
            if (!stack.isEmpty()) {
                if (stack.peek() > w[i]) {
                    if (stack.peek() == 'u') {
                        ans = Math.max(ans, stack.size());
                    }
                    stack.clear();
                    i--;
                } else if (stack.peek() == w[i]) {
                    stack.add(w[i]);

                } else {
                    if (stack.peek() == 'a' && w[i] == 'e') {
                        stack.add(w[i]);
                        continue;
                    }
                    if (stack.peek() == 'e' && w[i] == 'i') {
                        stack.add(w[i]);
                        continue;
                    }
                    if (stack.peek() == 'i' && w[i] == 'o') {
                        stack.add(w[i]);
                        continue;
                    }
                    if (stack.peek() == 'o' && w[i] == 'u') {
                        stack.add(w[i]);
                        continue;
                    }
                    stack.clear();
                    i--;

                }

            }
            System.out.println("stack = " + stack);

        }
        if (!stack.isEmpty() && stack.peek() == 'u') {
            ans = Math.max(ans, stack.size());
        }
        return ans;
    }

}
