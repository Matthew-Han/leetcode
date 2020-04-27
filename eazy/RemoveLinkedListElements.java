import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RemoveLinkedListElements
 * @Description #203 移除链表元素
 * @Author MatthewHan
 * @Date 2020/4/27 10:47
 * @Version 1.0
 **/
public class RemoveLinkedListElements {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.90% 的用户
     * 内存消耗 : 40.7 MB , 在所有 Java 提交中击败了 6.25% 的用户
     * @param head
     * @param val
     * @return
     */
    public static ListNode203 removeElements(ListNode203 head, int val) {

        // 处理头结点为val的情况，知道头节点不是val
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode203 temp = head;

        // 为null的情况
        if (head == null) {
            return null;
        }
        // 利用引用类型传递
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {

        ListNode203 listNode = new ListNode203(1);
        listNode.next = new ListNode203(1);
        listNode.next.next = new ListNode203(2);

        System.out.println(removeElements(listNode, 1));


    }

    public static void foo(String s) {
        s = "ss";
    }

}


class ListNode203 {
    int val;
    ListNode203 next;

    ListNode203(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode203{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
