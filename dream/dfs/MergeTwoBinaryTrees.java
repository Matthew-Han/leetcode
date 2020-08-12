package dfs;

import tree.TreeNode;

/**
 * @ClassName MergeTwoBinaryTrees
 * @Description #617 合并二叉树
 * @Author MatthewHan
 * @Date 2020/8/12 15:46
 * @Version 1.0
 **/
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 62.72% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 64.67% 的用户
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode root = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        dfs(t1, t2, root);
        return root;
    }

    public static void dfs(TreeNode node1, TreeNode node2, TreeNode root) {
        if (node1 == null && node2 == null) {
            return;
        }
        int left = 0;
        int right = 0;
        if (node1 != null) {
            left = node1.val;
        }
        if (node2 != null) {
            right = node2.val;
        }
        root.val = (left + right);
        if (node1 != null && node1.left != null || node2 != null && node2.left != null) {
            root.left = new TreeNode(0);
        }
        if (node1 != null && node1.right != null || node2 != null && node2.right != null) {
            root.right = new TreeNode(0);
        }
        dfs(node1 == null ? null : node1.left, node2 == null ? null : node2.left, root.left);
        dfs(node1 == null ? null : node1.right, node2 == null ? null : node2.right, root.right);

    }

}
