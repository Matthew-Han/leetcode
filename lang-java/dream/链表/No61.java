package 链表;

import 默认模板.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/29 09:02
 **/
public class No61 {

    List<ListNode> tmp;


    /**
     * #61 旋转链表
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 51.22% 的用户
     * 内存消耗： 37.7 MB , 在所有 Java 提交中击败了 83.65% 的用户
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        tmp = new ArrayList<>();
        ListNode l = head;
        int len = length(l);
        if (head == null) {
            return head;
        }
        k %= len;
        if (k == 0) {
            return head;
        }
        tmp.get(tmp.size() - 1).next = tmp.get(0);
        tmp.get(tmp.size() - 1 - k).next = null;
        head = tmp.get(tmp.size() - k);
        return head;

    }

    public int length(ListNode node) {
        if (node == null) {
            return 0;
        }
        tmp.add(node);
        return 1 + length(node.next);
    }
}
