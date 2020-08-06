package lcof;

import 链表.ListNode;

/**
 * @ClassName LcOf22
 * @Description 剑指 Offer #22 链表中倒数第k个节点
 * @Author MatthewHan
 * @Date 2020/7/19 22:04
 * @Version 1.0
 **/
public class LcOf22 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEndQuick(ListNode head, int k) {
        ListNode quick = head;
        int step = 0;
        while (quick != null && head != null) {
            if (step != k) {
                quick = quick.next;
                step++;
            } else {
                quick = quick.next;
                head = head.next;
            }
        }
        return head;
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode temp = head;
        int len = -1;
        while (temp != null) {
            len = temp.val;
            temp = temp.next;
        }
        len -= k - 1;
        int count = 0;
        while (head != null) {
            if (count == len) {
                return head;
            } else {
                count++;
                head = head.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
