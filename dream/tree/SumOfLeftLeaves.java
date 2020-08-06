package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName SumOfLeftLeaves
 * @Description #404 左叶子之和
 * @Author MatthewHan
 * @Date 2020/8/6 10:36
 * @Version 1.0
 **/
public class SumOfLeftLeaves {

    /**
     * 递归
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.5 MB , 在所有 Java 提交中击败了 84.50% 的用户
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root != null && root.left == null && root.right == null) {
            return 0;
        }
        return dfs(root, 0, false);
    }

    public static int dfs(TreeNode node, int sum, boolean left) {
        if (node != null) {
            if (left && node.left == null && node.right == null) {
                sum += node.val;
            } else {
                return sum + dfs(node.left, sum, true) + dfs(node.right, sum, false);
            }
        }
        return sum;
    }

    /**
     * 迭代
     * <p>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 8.83% 的用户
     * 内存消耗： 37.8 MB , 在所有 Java 提交中击败了 25.22% 的用户
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    if (curr.left.left == null && curr.left.right == null) {
                        sum += curr.left.val;
                    }
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        System.out.println("[3,9,20,null,null,15,7,null,2,4,52,null,21,123,41,124,124,1424,23,24,null,123,11,23,123]");
        return sum;
    }

}
