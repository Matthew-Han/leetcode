package 深度优先搜索;

import 默认模板.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/1/13 18:09
 **/
public class M1712 {

    Queue<TreeNode> queue;

    /**
     * 面试题 17.12. BiNode
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 21.89% 的用户
     * 内存消耗： 44.5 MB , 在所有 Java 提交中击败了 11.22% 的用户
     *
     * @param root
     * @return
     */
    public TreeNode convertBiNode(TreeNode root) {
        queue = new LinkedList<>();
        dfs(root);
        if (queue.isEmpty()) {
            return null;
        }
        TreeNode prev = queue.poll();
        TreeNode ans = prev;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            prev.left = null;
            prev.right = curr;
            prev = prev.right;
        }
        prev.left = null;
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        queue.offer(node);
        dfs(node.right);
    }
}
