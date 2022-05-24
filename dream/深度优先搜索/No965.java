package 深度优先搜索;

import 默认模板.TreeNode;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/5/24 10:00 24
 * @since 1.0
 **/
public class No965 {

    /**
     * 单值二叉树
     *
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        return root == null || ((root.left == null || root.val == root.left.val && isUnivalTree(root.left)) && (root.right == null || root.val == root.right.val && isUnivalTree(root.right)));
    }
}
