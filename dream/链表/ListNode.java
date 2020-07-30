package 链表;

/**
 * @ClassName 链表.ListNode
 * @Description 链表公共类
 * @Author MatthewHan
 * @Date 2020/4/30 10:28
 * @Version 1.0
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
