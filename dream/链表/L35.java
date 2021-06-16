package 链表;

import 默认模板.MultiNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LcOf35
 * @Description 剑指 Offer #35 复杂链表的复制
 * @Author MatthewHan
 * @Date 2020/8/24 09:33
 * @Version 1.0
 **/
public class L35 {

    /**
     * 为什么要用 map，因为这里的 next 和 random 需要的指向的是复制后的链表 copy
     * 你 new 一个对象是不对的，map 可以不用按顺序来，就可以做到 random 指向的那个对象了
     *
     * @param head
     * @return
     */
    public static MultiNode copyRandomList(MultiNode head) {
        if (head == null) {
            return head;
        }
        // map 中存的是(原节点，拷贝节点)的一个映射
        Map<MultiNode, MultiNode> map = new HashMap<>();
        for (MultiNode cur = head; cur != null; cur = cur.next) {
            map.put(cur, new MultiNode(cur.val));
        }
        // 将拷贝的新的节点组织成一个链表
        for (MultiNode cur = head; cur != null; cur = cur.next) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        MultiNode node = new MultiNode(7);
        MultiNode node2 = new MultiNode(2);
        node.next = node2;
        node.random = node2;
        node2.next = null;
        node2.random = null;

        System.out.println("head = " + node);
        //System.out.println(copyRandomList(head));
    }
}
