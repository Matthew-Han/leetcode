/**
 * @ClassName LinkedListCycle
 * @Description #141 环形链表
 * @Author MatthewHan
 * @Date 2020/4/20 16:04
 * @Version 1.0
 **/
public class LinkedListCycle {

    /**
     * 快慢双指针
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 40.1 MB , 在所有 Java 提交中击败了 5.49% 的用户
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {

        ListNode quick = head;
        ListNode slow = head;

        while (slow != null && quick.next != null) {
            if (null != quick.next.next) {
                quick = quick.next.next;
                slow = slow.next;
            } else {
                return false;
            }
            if (slow.val == quick.val) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = listNode.next.next.next;

        System.out.println(hasCycle(listNode));
    }


}

