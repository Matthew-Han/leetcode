package 链表;

/**
 * @ClassName DeleteNodeInALinkedList
 * @Description #237 删除链表中的节点
 * @Author MatthewHan
 * @Date 2020/4/30 17:22
 * @Version 1.0
 **/
public class DeleteNodeInALinkedList {

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        deleteNode(listNode);
    }
}
