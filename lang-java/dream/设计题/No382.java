package 设计题;

import 默认模板.ListNode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/17 09:19
 * @since 1.0
 **/
public class No382 {
    List<ListNode> all;

    /**
     * 链表随机节点
     *
     * @param head
     */
    public No382(ListNode head) {
        this.all = new ArrayList<>();
        while (head != null) {
            this.all.add(head);
            head = head.next;
        }

    }

    public int getRandom() {
        return all.get(ThreadLocalRandom.current().nextInt(this.all.size())).val;
    }
}
