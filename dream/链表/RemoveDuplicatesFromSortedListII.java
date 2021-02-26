package 链表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/26 15:08
 **/
public class RemoveDuplicatesFromSortedListII {

    /**
     * #82 删除排序链表中的重复元素 II
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 7.94% 的用户
     * 内存消耗： 38 MB , 在所有 Java 提交中击败了 30.54% 的用户
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        Map<Integer, Integer> map = new HashMap<>();
        while (tmp != null) {
            list.add(tmp);
            map.put(tmp.val, map.getOrDefault(tmp.val, 0) + 1);
            tmp = tmp.next;
        }
        ListNode ans = new ListNode(0);
        ListNode res = ans;
        for (ListNode node : list) {
            if (map.get(node.val) > 1) {
                node.next = null;
            } else {
                ans.next = node;
                ans = ans.next;
            }
        }
        ans.next = null;
        ListNode gg = res.next;
        res.next = null;
        return gg;
    }


}
