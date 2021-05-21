package 链表;

import 默认模板.ListNode;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/1/5 10:01
 **/
public class No86 {


    /**
     * #86 分隔链表
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 13.09% 的用户
     * 内存消耗： 37.8 MB , 在所有 Java 提交中击败了 49.21% 的用户
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        Queue<ListNode> queue = new LinkedList<>();
        Queue<ListNode> queue2 = new LinkedList<>();
        while (head != null) {
            if (head.val < x) {
                queue.offer(head);
            } else {
                queue2.offer(head);
            }
            head = head.next;
        }
        ListNode t;
        if (!queue.isEmpty()) {
            t = queue.poll();
        } else if (!queue2.isEmpty()) {
            t = queue2.poll();
        } else {
            return null;
        }
        ListNode ans = t;
        while (!queue.isEmpty()) {
            t.next = queue.poll();
            t = t.next;
        }
        while (!queue2.isEmpty()) {
            t.next = queue2.poll();
            t = t.next;
        }
        // 去掉最后
        if (t != null) {
            t.next = null;
        }
        return ans;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        System.out.println("priorityQueue.poll() = " + priorityQueue.poll());
        for (Integer n : priorityQueue) {
            System.out.println("n = " + n);
        }
    }
}
