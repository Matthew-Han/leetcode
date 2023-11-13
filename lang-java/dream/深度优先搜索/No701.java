package 深度优先搜索;

import 默认模板.TreeNode;

/**
 * @author MatthewHan
 * @version 1.0
 * @description
 * @date 2020/9/30 10:07
 **/
public class No701 {

    /**
     * #701 二叉搜索树中的插入操作
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBst(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        build(root, val);
        return root;

    }

    public void build(TreeNode node, int val) {
        if (node.val < val) {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                build(node.right, val);
            }
        } else if (node.val > val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                build(node.left, val);
            }
        }
    }
}
