package 设计题;

import java.util.Stack;

/**
 * @ClassName design.ImplementQueueUsingStacks
 * @Description #232 用栈实现队列
 * @Author MatthewHan
 * @Date 2020/4/29 17:29
 * @Version 1.0
 **/
public class No232 {

    Stack<Integer> stack;
    Stack<Integer> reverseStack;
    int front;

    public No232() {
        stack = new Stack<>();
        reverseStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stack.empty()) {
            front = x;
        }
        while (!stack.isEmpty()) {
            reverseStack.push(stack.pop());
        }
        stack.push(x);
        while (!reverseStack.isEmpty()) {
            stack.push(reverseStack.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {

        return stack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.empty();
    }

    @Override
    public String toString() {
        return "design.ImplementQueueUsingStacks{" +
                "stack=" + stack +
                ", reverseStack=" + reverseStack +
                '}';
    }

    public static void main(String[] args) {

        No232 stack = new No232();
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}
