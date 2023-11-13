package 第197场周赛;

import java.util.Stack;

/**
 * @ClassName 第197场周赛.NumberOfSubstringsWithOnly1s
 * @Description #1513 仅含 1 的子串数
 * @Author MatthewHan
 * @Date 2020/7/12 17:43
 * @Version 1.0
 **/
public class No1513 {

    /**
     * 注意 count 要设置成 long，然后对 int 类型取模
     * <p>
     * 执行用时： 18 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
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

        long count = 0;
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

        return (int) (count % (1000000007));
    }

    public static void main(String[] args) {
        System.out.println(numSub("100010011011110111101"));
    }

}
