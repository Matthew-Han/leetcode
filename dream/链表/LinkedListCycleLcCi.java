package 链表;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/3 15:32
 **/
public class LinkedListCycleLcCi {

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode detectCycleQuickSlow(ListNode head) {
        ListNode s = head;
        ListNode q = head;
        while (q != null && q.next != null) {
            s = s.next;
            q = q.next.next;
            if (s == q) {
                q = head;
                while (s != q) {
                    s = s.next;
                    q = q.next;
                }
                return s;
            }
        }
        return null;
    }

    /**
     * 面试题 02.08. 环路检测
     * 执行用时： 353 ms , 在所有 Java 提交中击败了 6.59% 的用户
     * 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 76.03% 的用户
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode s = head;
        List<ListNode> queue = new LinkedList<>();
        while (s != null) {
            if (queue.contains(s)) {
                return s;
            } else {
                queue.add(s);
            }
            s = s.next;
        }
        return null;
    }
}
