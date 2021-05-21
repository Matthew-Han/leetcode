package 链表;

import 默认模板.ListNode;

/**
 * @ClassName 链表.RemoveLinkedListElements
 * @Description #203 移除链表元素
 * @Author MatthewHan
 * @Date 2020/4/27 10:47
 * @Version 1.0
 **/
public class No203 {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.90% 的用户
     * 内存消耗 : 40.7 MB , 在所有 Java 提交中击败了 6.25% 的用户
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        // 处理头结点为val的情况，知道头节点不是val
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode temp = head;
        // 为null的情况
        if (head == null) {
            return null;
        }
        // 利用引用类型传递
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                break;
            } else {
                temp = temp.next;
            }
        }
        //System.out.println("temp = " + temp);
        //System.out.println("head = " + head);
        return head;
    }


    public static void main(String[] args) {

        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);

        System.out.println(listNode);
        System.out.println(removeElements(listNode, 3));
        System.out.println(listNode);

    }

}


