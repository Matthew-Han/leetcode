package 树;

import 默认模板.TreeNode;
import java.util.Stack;

/**
 * @ClassName BalancedBinaryTree
 * @Description #110 平衡二叉树
 * @Author MatthewHan
 * @Date 2020/8/4 15:11
 * @Version 1.0
 **/
public class No110 {

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 7.92% 的用户
     * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 18.11% 的用户
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int limit = stack.size();
            for (int i = 0; i < limit; i++) {
                TreeNode curr = stack.pop();

                // 平衡二叉树的一个关键点：无论是 BFS、DFS、害是递🐢。每个节点都要判断是否出现左右子树差 2（含）以上
                // 需要将当前节点的左右子树分别 check 一下~

                if (Math.abs(checkNode(curr.left, 0) - checkNode(curr.right, 0)) > 1) {
                    return false;
                }
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }
        }
        return true;

    }

    /**
     * 一般一个当前节点会使用左右子树
     *
     * @param node
     * @return
     */
    public static int checkNode(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        depth++;
        return Math.max(checkNode(node.left, depth), checkNode(node.right, depth));
    }


}
