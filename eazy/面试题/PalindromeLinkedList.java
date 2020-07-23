package 面试题;

import 链表.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PalindromeLinkedList
 * @Description 面试题 02.06. 回文链表
 * @Author MatthewHan
 * @Date 2020/7/23 19:06
 * @Version 1.0
 **/
public class PalindromeLinkedList {

    /**
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 8.12% 的用户
     * 内存消耗： 43.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (!list.get(i--).equals(list.get(j--))) {
                return false;
            }
        }
        return true;

    }
}
