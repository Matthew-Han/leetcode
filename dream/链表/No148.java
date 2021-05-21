package 链表;

import 默认模板.ListNode;
import java.util.PriorityQueue;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/19 18:33
 **/
public class No148 {

    /**
     * #148 排序链表
     * 执行用时： 22 ms , 在所有 Java 提交中击败了 11.67% 的用户
     * 内存消耗： 47.9 MB , 在所有 Java 提交中击败了 5.04% 的用户
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        ListNode tmp = head;
        while (tmp != null) {
            pq.offer(tmp);
            tmp = tmp.next;
        }

        ListNode ans = new ListNode(pq.poll().val);
        System.out.println("ans.val = " + ans.val);
        while (pq.size() > 0) {
            ans.next = pq.poll();
        }
        ans.next = null;
        return ans;

    }

}
