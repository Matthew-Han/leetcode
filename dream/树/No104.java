package 树;

import 默认模板.TreeNode;

/**
 * @ClassName MaximumDepthOfBinaryTree
 * @Description #104 二叉树的最大深度
 * @Author MatthewHan
 * @Date 2020/7/29 09:01
 * @Version 1.0
 **/
public class No104 {

    public static int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
}
