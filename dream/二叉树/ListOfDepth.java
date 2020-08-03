package 二叉树;

import 链表.ListNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName ListOfDepth
 * @Description 面试题 04.03. 特定深度节点链表
 * @Author MatthewHan
 * @Date 2020/7/31 16:02
 * @Version 1.0
 **/
public class ListOfDepth {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.06% 的用户
     * 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 62.50% 的用户
     *
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[]{};
        }
        List<ListNode> listNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.peek();
            int limit = queue.size();

            ListNode depthNode = new ListNode(tmp.val);
            // back指针指向头指针
            ListNode back = depthNode;
            for (int i = 0; i < limit; i++) {
                TreeNode tmp2 = queue.poll();
                // 头指针不需要next
                if (i != 0) {
                    depthNode.next = new ListNode(tmp2.val);
                    depthNode = depthNode.next;
                }

                if (tmp2.left != null) {
                    queue.offer(tmp2.left);
                }
                if (tmp2.right != null) {
                    queue.offer(tmp2.right);
                }

            }
            listNodes.add(back);
        }
        return listNodes.toArray(new ListNode[]{});
    }
}
