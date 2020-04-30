package 链表;


import com.sun.org.apache.bcel.internal.generic.NEW;
import 链表.ListNode;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName 链表.PalindromeLinkedList
 * @Description #234 回文链表
 * @Author MatthewHan
 * @Date 2020/4/30 10:27
 * @Version 1.0
 **/
public class PalindromeLinkedList {

    /**
     * 执行用时 : 8 ms , 在所有 Java 提交中击败了 5.77% 的用户
     * 内存消耗 : 43.6 MB , 在所有 Java 提交中击败了 5.41% 的用户
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        List<Integer> reverseList = new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            reverseList.add(temp.val);
            temp = temp.next;
        }
        Collections.reverse(reverseList);
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(reverseList.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static ListNode reverseNode(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(22);
        listNode.next = new ListNode(24);
        listNode.next.next = new ListNode(22);

        System.out.println(isPalindrome(listNode));

        String[] a = new String[] {"9","9","6"};
        String[] b = a;
        String[] c = a;
        b[1] = "a.length";
        c[0] = "10";
        System.out.println(Arrays.toString(a));
    }
}
