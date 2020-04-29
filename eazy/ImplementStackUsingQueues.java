import java.util.*;

/**
 * @ClassName ImplementStackUsingQueues
 * @Description #225 用队列实现栈
 * @Author MatthewHan
 * @Date 2020/4/28 16:37
 * @Version 1.0
 **/
public class ImplementStackUsingQueues {

    /**
     * 方法一：Deque双端队列来做，就是调调api
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37.7 MB , 在所有 Java 提交中击败了 7.41% 的用户
     */
    Deque<Integer> deque;

    /**
     * 方法二：2个单向队列形成闭环
     * <p>
     * queue每次只存放新入队的x，将之前的元素全部出队到reverseQueue。
     * 2个单向队列queue和reverseQueue；
     * queue初次push时，判断是否为空，为空直接调用offer方法。
     * 当queue不为空时，将所有的元素从头部出队，入队到reverseQueue。queue入队新的元素；
     * 这时两个队列，queue只有新的元素在队列中，reverseQueue拥有queue刚刚出队的元素；
     * 再次将reverseQueue的元素循环出队到queue，保证每次调用push方法时，该队列是空的；
     * 两个单项队列变成闭环。
     * </p>
     * 内存消耗 : 37.6 MB , 在所有 Java 提交中击败了 7.41% 的用户
     */
    Queue<Integer> queue;
    Queue<Integer> reverseQueue;

    /**
     * Initialize your data structure here.
     */
    public ImplementStackUsingQueues() {
        deque = new LinkedList<>();
        queue = new LinkedList<>();
        reverseQueue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        // deque.offerFirst(x);
        /*
         * 利用两个单向队列
         */
        if (queue.isEmpty()) {
            queue.offer(x);
        } else {
            while (!queue.isEmpty()) {
                reverseQueue.offer(queue.poll());
            }
            ;
            queue.offer(x);
            while (!reverseQueue.isEmpty()) {
                queue.offer(reverseQueue.poll());
            }
            ;
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
        return "ImplementStackUsingQueues{" +
                "deque=" + deque +
                ", queue=" + queue +
                ", reverseQueue=" + reverseQueue +
                '}';
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues queue = new ImplementStackUsingQueues();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue);
        System.out.println(queue.pop());
        System.out.println(queue.top());


    }
}
