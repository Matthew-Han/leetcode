package 链表;

import 默认模板.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/26 13:59
 **/
public class No1721 {

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 51.11% 的用户
     * 内存消耗： 64 MB , 在所有 Java 提交中击败了 31.54% 的用户
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode swapNodesPro(ListNode head, int k) {
        ListNode quick = head;
        ListNode slow = head;
        for (int i = 1; i < k; i++) {
            quick = quick.next;
        }
        ListNode tmp = quick;
        while (quick.next != null) {
            quick = quick.next;
            slow = slow.next;
        }

        int temp = tmp.val;
        tmp.val = slow.val;
        slow.val = temp;

        return head;
    }

    /**
     * #1721 交换链表中的节点
     * 执行用时： 11 ms , 在所有 Java 提交中击败了 8.62% 的用户
     * 内存消耗： 56.3 MB , 在所有 Java 提交中击败了 91.49% 的用户
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode tmp = head;
        ListNode gg = head;
        List<Integer> list = new ArrayList<>();
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        int index = 1;
        while (gg != null) {
            if (index == k) {
                gg.val = list.get(list.size() - k);
            }
            if (index == list.size() - k + 1) {
                gg.val = list.get(k - 1);
            }
            index++;
            gg = gg.next;
        }
        return head;

    }
}
