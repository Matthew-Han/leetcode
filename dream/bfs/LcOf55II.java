package bfs;

import tree.TreeNode;

/**
 * @ClassName LcOf55II
 * @Description 剑指 Offer #55 - II 平衡二叉树
 * @Author MatthewHan
 * @Date 2020/8/11 11:09
 * @Version 1.0
 **/
public class LcOf55II {


    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHigh(root.left) - getHigh(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    private int getHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHigh(root.left), getHigh(root.right)) + 1;
    }

}
