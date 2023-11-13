package 链表;

import 默认模板.ListNode;

/**
 * @ClassName ConvertBinaryNumberInaLinkedListToInteger
 * @Description #1290 二进制链表转整数
 * @Author MatthewHan
 * @Date 2020/7/9 11:14
 * @Version 1.0
 **/
public class No1290 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 17.39% 的用户
     * 内存消耗： 37.5 MB , 在所有 Java 提交中击败了 5.00% 的用户
     *
     * @param head
     * @return
     */
    public static int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
