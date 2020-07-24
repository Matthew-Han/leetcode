package 面试题;

import java.util.Stack;

/**
 * @ClassName ImplementQueueUsingStacks
 * @Description 面试题 03.04. 化栈为队
 * @Author MatthewHan
 * @Date 2020/7/24 17:44
 * @Version 1.0
 **/
public class ImplementQueueUsingStacks {

    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    /**
     * 执行用时： 13 ms , 在所有 Java 提交中击败了 45.24% 的用户
     * 内存消耗： 37.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     */
    public ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {

        // 存数据，本来是按队列来的，这里又反了
        while (stack2.size() != 0) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);

        // 所以需要反回来
        while (stack1.size() != 0) {
            stack2.push(stack1.pop());
        }

    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack2.empty();
    }

    @Override
    public String toString() {
        return "ImplementQueueUsingStacks{" +
                "stack=" + stack2 +
                '}';
    }
}
