package 链表;

import java.util.Stack;

/**
 * @ClassName LcOf24
 * @Description 剑指 Offer #24 反转链表
 * @Author MatthewHan
 * @Date 2020/8/6 11:15
 * @Version 1.0
 **/
public class LcOf24 {


    public ListNode reverseList2(ListNode head) {
        ListNode pre = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 6.97% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 19.35% 的用户
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode first = stack.pop();
        ListNode res = first;
        while (!stack.isEmpty()) {
            ListNode curr = stack.pop();
            first.next = curr;
            first = first.next;
        }
        first.next = null;
        return res;
    }

    public static void main(String[] args) {

    }
}
