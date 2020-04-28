import java.util.List;

/**
 * @ClassName ReverseLinkedList
 * @Description #206 反转链表
 * @Author MatthewHan
 * @Date 2020/4/27 17:06
 * @Version 1.0
 **/
public class ReverseLinkedList {

    /**
     * 官方题解
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 39.4 MB , 在所有 Java 提交中击败了 5.06% 的用户
     *
     * @param head
     * @return
     */
    public static ListNode206 reverseList(ListNode206 head) {

        ListNode206 prev = null;
        ListNode206 curr = head;
        while (curr != null) {
            ListNode206 nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        System.out.println(prev);
        return prev;

    }

    public static void main(String[] args) {
        ListNode206 listNode = new ListNode206(1);
        listNode.next = new ListNode206(2);
        listNode.next.next = new ListNode206(3);
        listNode.next.next.next = new ListNode206(4);
        listNode.next.next.next.next = new ListNode206(5);

        reverseList(listNode);
    }
}

class ListNode206 {
    int val;
    ListNode206 next;

    ListNode206(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode206{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
