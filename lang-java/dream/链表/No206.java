package 链表;


import 默认模板.ListNode;

/**
 * @ClassName 链表.ReverseLinkedList
 * @Description #206 反转链表
 * @Author MatthewHan
 * @Date 2020/4/27 17:06
 * @Version 1.0
 **/
public class No206 {

    /**
     * 官方题解
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 39.4 MB , 在所有 Java 提交中击败了 5.06% 的用户
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }
        return prev;

    }

    public static void main(String[] args) {
        System.out.println("0 % 3 = " + 6 % 3);
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        reverseList(listNode);
    }
}

