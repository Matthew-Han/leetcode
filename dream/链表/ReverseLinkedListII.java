package 链表;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/18 09:35
 **/
public class ReverseLinkedListII {

    /**
     * #92 反转链表 II
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 41.08% 的用户
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        while (left <= right) {
            ListNode tmp = list.get(left - 1);
            list.set(left - 1, list.get(right - 1));
            list.set(right - 1, tmp);
            left++;
            right--;
        }
        ListNode first = list.get(0);
        ListNode ans = first;
        for (int i = 1; i < list.size(); i++) {
            first.next = list.get(i);
            first = first.next;
        }
        first.next = null;
        return ans;

    }
}
