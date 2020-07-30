package 面试题;

import java.util.Stack;

/**
 * @ClassName MinStack
 * @Description 面试题 03.02. 栈的最小值
 * @Author MatthewHan
 * @Date 2020/7/24 17:07
 * @Version 1.0
 **/
public class MinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        // 先将 x 压入数据栈
        dataStack.push(x);
        // 如果 x 是当前的最小值，则也需要将 x 压入辅助栈
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        // 先删除数据栈的栈顶元素 x
        int x = dataStack.pop();
        // 若 x 是当前的最小值，则也需要删除辅助栈的栈顶元素
        if (x == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
