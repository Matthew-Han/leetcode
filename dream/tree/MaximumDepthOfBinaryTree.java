package tree;

/**
 * @ClassName MaximumDepthOfBinaryTree
 * @Description #104 二叉树的最大深度
 * @Author MatthewHan
 * @Date 2020/7/29 09:01
 * @Version 1.0
 **/
public class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        return bfs(root);
    }

    public static int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(bfs(root.left), bfs(root.right));
    }
}
