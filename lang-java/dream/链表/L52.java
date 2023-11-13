package 链表;

import 默认模板.ListNode;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/21 09:32
 * @since 1.0
 **/
public class L52 {

    /**
     * 两个链表的第一个公共节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (tmpA != null || tmpB != null) {
            if (tmpA != null) {
                lenA++;
                tmpA = tmpA.next;
            }
            if (tmpB != null) {
                lenB++;
                tmpB = tmpB.next;
            }
        }
        int d = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            while (headA != null) {
                if (d <= 0) {
                    if (headB == headA) {
                        return headA;
                    }
                    headB = headB != null ? headB.next : null;
                }
                headA = headA.next;
                d--;
            }
        } else {
            while (headB != null) {
                if (d <= 0) {
                    if (headB == headA) {
                        return headA;
                    }
                    headA = headA != null ? headA.next : null;
                }
                headB = headB.next;
                d--;
            }
        }
        return null;
    }
}
