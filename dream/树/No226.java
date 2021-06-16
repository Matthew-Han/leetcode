package 树;

import 默认模板.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName InvertBinaryTree
 * @Description #226 翻转二叉树
 * @Author MatthewHan
 * @Date 2020/8/4 17:49
 * @Version 1.0
 **/
public class No226 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.3 MB , 在所有 Java 提交中击败了 55.55% 的用户
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                TreeNode curr = queue.poll();
                TreeNode tmp = curr.left;
                curr.left = curr.right;
                curr.right = tmp;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return root;
    }
}
