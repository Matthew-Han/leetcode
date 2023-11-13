package 链表;

import 默认模板.ListNode;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/22 10:14
 * @since 1.0
 **/
public class No725 {

    /**
     * 分隔链表
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }
        int m = len % k;
        int subLen = len / k + 1;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        for (int i = 0; i < k; i++) {
            if (head != null) {
                ans[i] = head;
                int max = m > 0 ? subLen : subLen - 1;
                for (int j = 0; j < max; j++) {
                    if (head != null) {
                        head = head.next;
                        prev = prev.next;
                    } else {
                        break;
                    }
                }
                if (prev != null) {
                    prev.next = null;
                    prev = new ListNode(-1);
                    prev.next = head;
                }
            } else {
                ans[i] = null;
            }
            m--;

        }
        return ans;
    }
}
