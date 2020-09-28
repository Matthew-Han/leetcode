package 链表;

/**
 * @author MatthewHan
 * @version 1.0
 * @description
 * @date 2020/9/28 16:57
 **/
public class AddTwoNumbers {

    /**
     * #2 两数相加
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 99.89% 的用户
     * 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 56.60% 的用户
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0;
        int len2 = 0;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        while (tmp1 != null) {
            len1++;
            tmp1 = tmp1.next;
        }
        while (tmp2 != null) {
            len2++;
            tmp2 = tmp2.next;
        }
        int max = Math.max(len1, len2);
        if (len1 < len2) {
            ListNode tmp = new ListNode(0);
            tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        ListNode tmp3 = l1;
        while (l2 != null) {
            l1.val += l2.val;
            l1 = l1.next;
            l2 = l2.next;
        }
        int step = 0;
        int finalNum;
        boolean carry = false;
        ListNode res = tmp3;
        while (tmp3 != null) {
            step++;
            if (carry) {
                tmp3.val++;
            }
            finalNum = tmp3.val;
            carry = tmp3.val > 9;
            tmp3.val %= 10;
            if (step == max && finalNum > 9) {
                tmp3.next = new ListNode(1);
                return res;
            }
            tmp3 = tmp3.next;
        }
        return res;
    }
}
