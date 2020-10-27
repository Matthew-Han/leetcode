package dfs;

import tree.TreeNode;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/10/27 16:46
 **/
public class BinaryTreePruning {

    /**
     * #814 二叉树剪枝
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35.5 MB , 在所有 Java 提交中击败了 99.83% 的用户
     *
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        dfs(root);
        // 判断头结点为0的二叉树
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (check(node.left)) {
            node.left = null;
        }
        if (check(node.right)) {
            node.right = null;
        }
        dfs(node.left);
        dfs(node.right);
    }

    public boolean check(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (node.val == 0) {
            return check(node.left) && check(node.right);
        } else {
            return false;
        }
    }
}
