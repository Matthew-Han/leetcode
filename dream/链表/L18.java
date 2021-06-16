package 链表;

import 默认模板.ListNode;

/**
 * @ClassName LcOf18
 * @Description 剑指 Offer #18 删除链表的节点
 * @Author MatthewHan
 * @Date 2020/7/19 02:52
 * @Version 1.0
 **/
public class L18 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        /*
         * 【注】当头结点是 val 的情况，其实没有删除，只是把头结点的指针指向下一节点，模拟删除，整个链表还是完整的
         */
        if (head.val == val) {
            head = head.next;
            return head;
        }
        /*
         * 需要一个 temp 指针指向 head 节点，为什么呢？因为需要返回删除后的这个链表的从头到尾完整版本，head 在操作之后就指向了被删除的节点的父节点了
         * 【另外】这里 temp = head，仅仅只是指向了 head 指针所在的位置。假如后面有删除操作「head.next = head.next.next」
         * 对 temp 进行遍历，这个链表是少了一个节点的！！
         */
        ListNode temp = head;
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
                break;
            } else {
                head = head.next;
            }

        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        System.out.println("listNode1 = " + listNode);
        System.out.println("deleteNode = " + deleteNode(listNode, 2));
        System.out.println("listNode3 = " + listNode);

    }


}
