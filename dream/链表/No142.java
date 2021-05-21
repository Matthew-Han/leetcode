package 链表;

import 默认模板.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MatthewHan
 * @version 1.0
 * @description
 * @date 2020/10/11 12:21
 **/
public class No142 {

    /**
     * #142 环形链表 II
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode root = head;
        ListNode res = null;
        while (root != null) {
            if (list.contains(root)) {
                res = root;
                break;
            }
            list.add(root);
            root = root.next;
        }
        if (res == null) {
            return null;
        }
        while (head != null) {
            if (head == res) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
