package dfs;

import tree.TreeNode;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/1/14 10:17
 **/
public class BinaryTreeTilt {
    int ans = 0;
    int tmp = 0;

    /**
     * #563 二叉树的坡度
     * 执行用时： 15 ms , 在所有 Java 提交中击败了 14.00% 的用户
     * 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 11.47% 的用户
     *
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        c(node.left);
        int next = tmp;
        tmp = 0;
        c(node.right);
        ans += Math.abs(next - tmp);
        tmp = 0;

        dfs(node.left);
        dfs(node.right);

    }

    public void c(TreeNode root) {
        if (root == null) {
            return;
        }
        c(root.left);
        c(root.right);
        tmp += root.val;

    }
}
