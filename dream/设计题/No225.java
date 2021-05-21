package 设计题;

import java.util.*;

/**
 * @ClassName design.ImplementStackUsingQueues
 * @Description #225 用队列实现栈
 * @Author MatthewHan
 * @Date 2020/4/28 16:37
 * @Version 1.0
 **/
public class No225 {

    /**
     * 方法一：Deque 双端队列来做，就是调调 api
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37.7 MB , 在所有 Java 提交中击败了 7.41% 的用户
     */
    Deque<Integer> deque;

    /**
     * 方法二：2个单向队列形成闭环
     * <p>
     * queue 每次只存放新入队的 x，将之前的元素全部出队到 reverseQueue。
     * 2 个单向队列 queue 和 reverseQueue；
     * queue 初次 push 时，判断是否为空，为空直接调用 offer 方法。
     * 当 queue 不为空时，将所有的元素从头部出队，入队到 reverseQueue。queue 入队新的元素；
     * 这时两个队列，queue 只有新的元素在队列中，reverseQueue 拥有 queue 刚刚出队的元素；
     * 再次将 reverseQueue 的元素循环出队到 queue，保证每次调用 push 方法时，该队列是空的；
     * 两个单项队列变成闭环。
     * </p>
     * 内存消耗 : 37.6 MB , 在所有 Java 提交中击败了 7.41% 的用户
     */
    Queue<Integer> queue;
    Queue<Integer> reverseQueue;

    /**
     * 方法三：一个单向队列
     * 不要使用自身的 forEach 方法，根据 size 搞个循环即可
     */
    Queue<Integer> singleQueue;

    /**
     * Initialize your data structure here.
     */
    public No225() {
        deque = new LinkedList<>();
        queue = new LinkedList<>();
        reverseQueue = new LinkedList<>();
        singleQueue = new LinkedList<>();

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        /*
         * deque双向队列，底层双向链表
         */
        deque.offerFirst(x);
        /*
         * 利用两个单向队列
         */
        if (queue.isEmpty()) {
            queue.offer(x);
        } else {
            reverseQueue.addAll(queue);
            queue.clear();
            queue.offer(x);
            queue.addAll(reverseQueue);
            reverseQueue.clear();
        }

        /*
         * 单个单向队列
         */
        singleQueue.add(x);
        for (int i = 0; i < singleQueue.size() - 1; i++) {
            singleQueue.add(singleQueue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        // return deque.remove();
        return queue.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        // return deque.element();
        return queue.element();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        // return deque.isEmpty();
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return "design.ImplementStackUsingQueues{" +
                "deque=" + deque +
                ", queue=" + queue +
                ", reverseQueue=" + reverseQueue +
                ", singleQueue=" + singleQueue +
                '}';
    }

    public static void main(String[] args) {
        No225 queue = new No225();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue);
        System.out.println(queue.pop());
        System.out.println(queue.top());


    }
}
