package 链表;

import 默认模板.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/6/20 10:57 20
 * @since 1.0
 **/
public class L29 {

    /**
     * 排序的循环链表
     *
     * @param head
     * @param insertVal
     * @return
     */
    public ListNode insert(ListNode head, int insertVal) {
        ListNode nxtNode = new ListNode(insertVal);
        if (head == null) {
            nxtNode.next = nxtNode;
            return nxtNode;
        }
        ListNode curr = head.next;
        ListNode minNode = head;
        ListNode maxNode = head;
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        while (curr != head) {
            list.add(curr);
            minNode = curr.val < minNode.val ? curr : minNode;
            maxNode = curr.val >= maxNode.val ? curr : maxNode;
            curr = curr.next;
        }
        if (minNode.val > insertVal || maxNode.val < insertVal) {
            maxNode.next = nxtNode;
            nxtNode.next = minNode;
            return head;
        }
        for (int i = 0; i < list.size(); i++) {
            int nxtIdx = (i + 1) % list.size();
            if (nxtIdx == i || (list.get(i).val <= insertVal && list.get(nxtIdx).val >= insertVal)) {
                list.get(i).next = nxtNode;
                nxtNode.next = list.get(nxtIdx);
                break;
            }
        }
        return head;
    }
}
