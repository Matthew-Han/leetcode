package 双指针;

import 默认模板.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName KthNodeFromEndOfList
 * @Description 面试题 02.02. 返回倒数第 k 个节点
 * @Author MatthewHan
 * @Date 2020/7/23 16:25
 * @Version 1.0
 **/
public class M0202 {

    /**
     * 经典双指针
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.6 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param head
     * @param k
     * @return
     */
    public int kthToLast2(ListNode head, int k) {
        ListNode slow = head;
        while (head != null) {
            head = head.next;
            if (k <= 0) {
                slow = slow.next;
            }
            k--;
        }
        return slow.val;
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 17.61% 的用户
     * 内存消耗： 37.3 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        return list.get(list.size() - k);
    }

}
