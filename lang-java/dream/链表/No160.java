package 链表;

import 默认模板.ListNode;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/4 10:54
 * @description
 * @since 1.0.0
 **/
public class No160 {

    /**
     * #160 相交链表
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode tmpB = headB;
            while (tmpB != null) {
                if (headA == tmpB) {
                    return headA;
                }
                tmpB = tmpB.next;
            }
            headA = headA.next;

        }
        return null;
    }
}
