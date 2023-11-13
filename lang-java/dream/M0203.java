import 默认模板.ListNode;

/**
 * @ClassName DeleteMiddleNode
 * @Description 面试题 02.03. 删除中间节点
 * @Author MatthewHan
 * @Date 2020/7/23 17:43
 * @Version 1.0
 **/
public class M0203 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
