package 链表;


import java.util.List;

/**
 * @ClassName RemoveNthNodeFromEndOfList
 * @Description #19 删除链表的倒数第N个节点
 * @Author MatthewHan
 * @Date 2020/8/10 08:50
 * @Version 1.0
 **/
public class RemoveNthNodeFromEndOfList {

    /**
     * 经典快慢双指针
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.8 MB , 在所有 Java 提交中击败了 77.61% 的用户
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 1) {
            if (head.next == null) {
                return null;
            }
        }
        ListNode quick = head;
        ListNode slow = head;
        int index = 1;
        while (quick != null) {
            quick = quick.next;
            if (index >= n + 1) {
                if (quick == null) {
                    slow.next = slow.next.next;
                    break;
                }
                slow = slow.next;
            }
            if (quick == null && index < n + 1) {
                return slow.next;
            }
            index++;
        }
        return head;
    }
}
