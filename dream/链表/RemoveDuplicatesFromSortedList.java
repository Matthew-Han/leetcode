package 链表;

import java.util.List;

/**
 * @ClassName RemoveDuplicatesFromSortedList
 * @Description #83 删除排序链表中的重复元素
 * @Author MatthewHan
 * @Date 2020/8/4 10:42
 * @Version 1.0
 **/
public class RemoveDuplicatesFromSortedList {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 72.12% 的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 40.02% 的用户
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode quick = head;
        ListNode low = head;
        while (low.next != null) {
            while (quick.next != null && quick.val == quick.next.val) {
                quick = quick.next;
            }
            if (quick.next == null) {
                low.next = null;
            } else {
                low.next = quick.next;
                low = low.next;
            }
            quick = quick.next;
        }
        return head;
    }
}
