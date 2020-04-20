package xyz.yuanmo;

import java.util.Stack;

/**
 * @ClassName MinStack
 * @Description #155 最小栈
 * @Author MatthewHan
 * @Date 2020/4/20 16:14
 * @Version 1.0
 **/
public class MinStack {

    int min = Integer.MAX_VALUE;

    private Stack<Integer> stack;

    /**
     * 执行用时 : 6 ms , 在所有 Java 提交中击败了 97.91% 的用户
     * 内存消耗 : 41.7 MB , 在所有 Java 提交中击败了 14.46% 的用户
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (x <= min) {
            stack.add(min);
            min = x;
        }
        stack.add(x);
    }

    public void pop() {
        if (min == stack.pop()) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(-3);
        minStack.push(99);
        minStack.push(-7777);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());


    }


}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
