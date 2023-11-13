package 树;

import 默认模板.TreeNode;
import java.util.Stack;

/**
 * @ClassName PathSum
 * @Description #112 路径总和
 * @Author MatthewHan
 * @Date 2020/8/4 15:54
 * @Version 1.0
 **/
public class No112 {

    public boolean hasPathSum2(TreeNode root, int sum) {
        return false;
    }

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 11.30% 的用户
     * 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 45.38% 的用户
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> path = new Stack<>();
        stack.push(root);
        path.push(root.val);
        while (!stack.isEmpty()) {
            int limit = stack.size();
            for (int i = 0; i < limit; i++) {
                TreeNode curr = stack.pop();
                int val = path.pop();
                if (isLeaf(curr) && val == sum) {
                    return true;
                }
                if (curr.right != null) {
                    stack.push(curr.right);
                    path.push(curr.right.val + val);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                    path.push(curr.left.val + val);
                }
                System.out.println("path = " + path);
            }
        }
        return false;
    }

    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
