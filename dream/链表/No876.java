package 链表;

import 默认模板.ListNode;

/**
 * @ClassName MiddleOfTheLinkedList
 * @Description #876 链表的中间结点
 * @Author MatthewHan
 * @Date 2020/6/21 19:16
 * @Version 1.0
 **/
public class No876 {

    /**
     * 快慢双指针法
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.9 MB , 在所有 Java 提交中击败了 6.25% 的用户
     *
     * @param head
     * @return
     */
    public static ListNode middleNodeBySlowQuick(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while (true) {
            if (quick == null || quick.next == null) {
                return slow;
            } else {
                slow = slow.next;
                quick = quick.next.next;
            }
        }
    }


    /**
     * 设置双头指针法
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.1 MB , 在所有 Java 提交中击败了 6.25% 的用户
     *
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        int len = 1;
        int go = 1;
        ListNode temp = head;
        while (true) {
            if (head.next != null) {
                head = head.next;
                len++;
            } else {
                break;
            }
        }
        System.out.println("head = " + head);
        int middle = len / 2 + 1;
        while (true) {
            if (go == middle) {
                return temp;
            }
            if (temp.next != null) {
                temp = temp.next;
                go++;
            } else {
                break;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(6);
        listNode5.next = listNode6;

        System.out.println("listNode1 = " + listNode1);

        System.out.println(middleNodeBySlowQuick(listNode1));

    }
}
