package lcof;

import 链表.ListNode;

/**
 * @ClassName LcOf24
 * @Description 剑指 Offer #24 反转链表 LCOF
 * @Author MatthewHan
 * @Date 2020/7/19 22:26
 * @Version 1.0
 **/
public class LcOf24 {

    /**
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        System.out.println(reverseList(listNode));
        System.out.println(listNode);


    }
}
