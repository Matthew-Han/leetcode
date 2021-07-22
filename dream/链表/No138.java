package 链表;

import 默认模板.RandomNode;
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
    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) {
            return null;
        }
        Map<Integer, RandomNode> hash = new HashMap<>();
        Map<RandomNode, Integer> hash2 = new HashMap<>();
        Map<Integer, Integer> hash3 = new HashMap<>();
        int index = 0;
        RandomNode root = new RandomNode(head.val);
        RandomNode tmp = root;
        RandomNode ans = root;
        RandomNode headTmp = head;
        hash.put(index, root);
        hash2.put(head, index++);
        while (head.next != null) {
            head = head.next;
            root.next = new RandomNode(head.val);
            root = root.next;
            hash.put(index, root);
            hash2.put(head, index++);
        }
        index = 0;
        while (headTmp != null) {
            if (headTmp.random == null) {
                hash3.put(index++, null);
            } else {
                hash3.put(index++, hash2.get(headTmp.random));
            }
            headTmp = headTmp.next;

        }
        index = 0;
        while (tmp != null) {
            tmp.random = hash.get(hash3.get(index++));
            tmp = tmp.next;
        }

        return ans;
    }
}
