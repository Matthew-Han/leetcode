import 默认模板.ListNode;

/**
 * @ClassName PalindromeLinkedList
 * @Description 面试题 02.06. 回文链表
 * @Author MatthewHan
 * @Date 2020/7/23 19:06
 * @Version 1.0
 **/
public class M0206 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.92% 的用户
     * 内存消耗： 41.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int[] arr = new int[len];
        int index = 0;
        while (head != null) {
            arr[index++] = head.val;
            head = head.next;
        }
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (arr[i++] != arr[j--]) {
                return false;
            }
        }
        return true;

    }
}
