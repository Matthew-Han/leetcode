package 剑指Offer;

import 链表.ListNode;
import java.util.*;

/**
 * @ClassName LcOf06
 * @Description 剑指 Offer #06 从尾到头打印链表
 * @Author MatthewHan
 * @Date 2020/7/17 15:01
 * @Version 1.0
 **/
public class LcOf06 {

    /**
     * 双端队列
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 46.80% 的用户
     * 内存消耗： 40.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param head
     * @return
     */
    public static int[] reversePrint2(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        while (head != null) {
            deque.push(head.val);
            head = head.next;
        }
        int[] result = new int[deque.size()];
        int index = 0;
        while (deque.size() > 0) {
            result[index] = deque.pollFirst();
            index++;
        }
        System.out.println("result = " + Arrays.toString(result));
        return result;
    }

    /**
     * 新的头结点
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 76.29% 的用户
     * 内存消耗： 40.6 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param head
     * @return
     */
    public int[] reversePrintPro(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        int[] result = new int[count];
        int index = 0;
        while (temp != null) {
            result[index] = temp.val;
            index++;
            temp = temp.next;
        }
        int i = 0;
        int j = result.length - 1;
        while (i < j) {
            result[i] = result[i] ^ result[j];
            result[j] = result[i] ^ result[j];
            result[i] = result[i] ^ result[j];
            i++;
            j--;
        }
        return result;
    }

    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 6.66% 的用户
     * 内存消耗： 40.6 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(0, head.val);
            head = head.next;
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        reversePrint2(listNode);
    }
}
