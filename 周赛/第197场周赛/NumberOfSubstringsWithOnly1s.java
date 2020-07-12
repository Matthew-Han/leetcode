package 第197场周赛;

import java.util.Stack;

/**
 * @ClassName 第197场周赛.NumberOfSubstringsWithOnly1s
 * @Description #5461 仅含 1 的子串数
 * @Author MatthewHan
 * @Date 2020/7/12 17:43
 * @Version 1.0
 **/
public class NumberOfSubstringsWithOnly1s {

    /**
     * 注意count要设置成long，然后对int类型取模
     * 执行用时： 37 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 42.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @return
     */
    public static int numSub(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('-');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                stack.add(s.charAt(i));
            }
            if (s.charAt(i) == '0' && stack.peek() == '1') {
                stack.push('-');
            }
        }

        System.out.println("stack = " + stack);
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);

        }
        String[] result = sb.toString().split("-");
        long count = 0;
        for (String value : result) {
            for (int j = 1; j <= value.length(); j++) {
                count += j;
            }
        }

        return (int) (count % (1000000007));
    }

    public static void main(String[] args) {
        System.out.println(numSub("100010011011110111101"));
        /*
        int count = 0;
        int curr = 0;
        for (int i = 0; i < stack.size(); i++) {
            char temp = stack.get(i);
            if (temp == '-') {
                for (int j = curr; j > 0; j--) {
                    count += j;
                }
                curr = 0;
            } else if (i == stack.size() - 1 && temp == '1') {
                for (int j = curr + 1; j > 0; j--) {
                    count += j;
                }
                curr = 0;
            } else {
                curr++;
            }
            System.out.println("count = " + count);
        }
         */
    }

}
