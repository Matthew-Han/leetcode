import 默认模板.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName RemoveDuplicateNode
 * @Description 面试题 02.01. 移除重复节点
 * @Author MatthewHan
 * @Date 2020/7/23 15:51
 * @Version 1.0
 **/
public class M0201 {

    /**
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 73.63% 的用户
     * 内存消耗： 41.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        while (head != null) {
            while (head.next != null && set.contains(head.next.val)) {
                // 删除节点
                head.next = head.next.next;
            }
            head = head.next;
            if (head != null) {
                set.add(head.val);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        System.out.println(removeDuplicateNodes(head));
    }
}
