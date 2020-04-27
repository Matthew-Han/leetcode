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
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *
     * @param head
     * @return
     */
    public static ListNode206 reverseList(ListNode206 head) {

        if (head == null) {
            return null;
        }
        ListNode206 temp = head;
        ListNode206 reverse = new ListNode206(0);
        while (true) {

            if (temp.next == null) {
                reverse.next = temp;
                break;
            }
            temp = temp.next;
        }
        System.out.println(head);
        return null;
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
