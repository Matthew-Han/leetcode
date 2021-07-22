package 链表;

import 默认模板.MultiNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/22 10:44
 * @since 1.0
 **/
public class No138 {

    /**
     * 复制带随机指针的链表
     *
     * @param head
     * @return
     */
    public MultiNode copyRandomList(MultiNode head) {
        if (head == null) {
            return null;
        }
        Map<Integer, MultiNode> hash = new HashMap<>();
        Map<Integer, Integer> toward = new HashMap<>();
        Map<MultiNode, Integer> gg = new HashMap<>();
        int index = 0;
        MultiNode root = new MultiNode(head.val);
        MultiNode tmp = root;
        MultiNode ans = root;
        MultiNode headTmp = head;
        hash.put(index, root);
        gg.put(head, index++);
        while (head.next != null) {
            head = head.next;
            root.next = new MultiNode(head.val);
            root = root.next;
            hash.put(index, root);
            gg.put(head, index++);
        }
        index = 0;
        while (headTmp != null) {
            if (headTmp.random == null) {
                toward.put(index++, null);
            } else {
                toward.put(index++, gg.get(headTmp.random));
            }
            headTmp = headTmp.next;

        }
        index = 0;
        while (tmp != null) {
            tmp.random = hash.get(toward.get(index++));
            tmp = tmp.next;
        }

        return ans;
    }
}
