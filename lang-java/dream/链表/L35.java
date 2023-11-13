package 链表;

import 默认模板.RandomNode;
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
    public static RandomNode copyRandomList(RandomNode head) {
        if (head == null) {
            return head;
        }
        // map 中存的是(原节点，拷贝节点)的一个映射
        Map<RandomNode, RandomNode> map = new HashMap<>();
        for (RandomNode cur = head; cur != null; cur = cur.next) {
            map.put(cur, new RandomNode(cur.val));
        }
        // 将拷贝的新的节点组织成一个链表
        for (RandomNode cur = head; cur != null; cur = cur.next) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        RandomNode node = new RandomNode(7);
        RandomNode node2 = new RandomNode(2);
        node.next = node2;
        node.random = node2;
        node2.next = null;
        node2.random = null;

        System.out.println("head = " + node);
        //System.out.println(copyRandomList(head));
    }
}
