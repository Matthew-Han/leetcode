package dfs;

import tree.TreeNode;

/**
 * @ClassName MinimumAbsoluteDifferenceInBst
 * @Description #530 二叉搜索树的最小绝对差
 * @Author MatthewHan
 * @Date 2020/8/20 16:43
 * @Version 1.0
 **/
public class MinimumAbsoluteDifferenceInBst {

    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        helper(root, new TreeNode(min));
        return min;
    }

    public TreeNode helper(TreeNode curr, TreeNode prev) {
        if (curr != null) {
            prev = helper(curr.left, prev);
            min = Math.min(Math.abs(prev.val - curr.val), min);
            prev = helper(curr.right, curr);
        }
        return prev;
    }
}
