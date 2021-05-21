package 深度优先搜索;

import 默认模板.TreeNode;
import java.util.Stack;

/**
 * @ClassName DiameterOfBinaryTree
 * @Description #543 二叉树的直径
 * @Author MatthewHan
 * @Date 2020/8/12 16:25
 * @Version 1.0
 **/
public class No543 {


    /**
     * 执行用时： 15 ms , 在所有 Java 提交中击败了 10.38% 的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 89.57% 的用户
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int limit = stack.size();
            for (int i = 0; i < limit; i++) {
                TreeNode curr = stack.pop();
                // 核心一句
                max = Math.max(max, (dfs(curr.left) + dfs(curr.right)));
                if (curr.left != null) {
                    stack.push(curr.left);
                }
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            }
        }
        return max;
    }


    public static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(dfs(node.left), dfs(node.right));
    }

}
