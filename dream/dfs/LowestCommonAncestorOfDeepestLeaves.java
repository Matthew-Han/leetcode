package dfs;

import tree.TreeNode;

/**
 * @ClassName LowestCommonAncestorOfDeepestLeaves
 * @Description #1123 最深叶节点的最近公共祖先
 * @Author MatthewHan
 * @Date 2020/8/12 11:24
 * @Version 1.0
 **/
public class LowestCommonAncestorOfDeepestLeaves {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == right) {
            return root;
        } else if (left < right) {
            return lcaDeepestLeaves(root.right);
        } else {
            return lcaDeepestLeaves(root.left);
        }
    }

    public static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(depth(node.left), depth(node.right));
    }

}
