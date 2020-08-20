package dfs;

import tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName LongestUniValuePath
 * @Description #687 最长同值路径
 * @Author MatthewHan
 * @Date 2020/8/20 16:53
 * @Version 1.0
 **/
public class LongestUniValuePath {

    int max = Integer.MIN_VALUE;

    /**
     * 执行用时： 15 ms , 在所有 Java 提交中击败了 7.10% 的用户
     * 内存消耗： 42.3 MB , 在所有 Java 提交中击败了 91.92% 的用户 炫耀一下:
     *
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            max = Math.max(max, bfs(root));
            dfs(root.left);
            dfs(root.right);
        }
    }

    public int bfs(TreeNode root) {
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        int count = 0;
        int leftCount = 0;
        int rightCount = 0;
        if (root.left != null && root.val == root.left.val) {
            count++;
            leftQueue.offer(root.left);
        }
        if (root.right != null && root.val == root.right.val) {
            count++;
            rightQueue.offer(root.right);
        }

        while (!leftQueue.isEmpty()) {
            int limit = leftQueue.size();
            for (int i = 0; i < limit; i++) {
                TreeNode curr = leftQueue.poll();
                if (curr.left != null && curr.val == curr.left.val) {
                    leftQueue.add(curr.left);
                }
                if (curr.right != null && curr.val == curr.right.val) {
                    leftQueue.add(curr.right);
                }
            }
            leftCount++;
        }
        while (!rightQueue.isEmpty()) {
            int limit = rightQueue.size();
            for (int i = 0; i < limit; i++) {
                TreeNode curr = rightQueue.poll();
                if (curr.left != null && curr.val == curr.left.val) {
                    rightQueue.add(curr.left);
                }
                if (curr.right != null && curr.val == curr.right.val) {
                    rightQueue.add(curr.right);
                }
            }
            rightCount++;
        }
        // 如果leftCount != 0 说明左/右边有「子树」了，求的是边，不是高度，所以要-1
        return count + (leftCount == 0 ? 0 : leftCount - 1) + (rightCount == 0 ? 0 : rightCount - 1);
    }
}
