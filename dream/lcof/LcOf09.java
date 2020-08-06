package lcof;

import java.util.Stack;

/**
 * @ClassName LcOf09
 * @Description 剑指 Offer #09 用两个栈实现队列
 * @Author MatthewHan
 * @Date 2020/7/17 16:22
 * @Version 1.0
 **/
public class LcOf09 {

    /**
     * 执行用时： 361 ms , 在所有 Java 提交中击败了 8.08% 的用户
     * 内存消耗： 48 MB , 在所有 Java 提交中击败了 100.00% 的用户
     */
    private Stack<Integer> stack;
    private Stack<Integer> temp;

    public LcOf09() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public void appendTail(int value) {
        while (stack.size() != 0) {
            temp.add(stack.pop());
        }
        stack.add(value);
        while (temp.size() != 0) {
            stack.add(temp.pop());
        }
    }

    public int deleteHead() {
        if (stack.size() == 0) {
            return -1;
        } else {
            return stack.pop();
        }
    }

}
