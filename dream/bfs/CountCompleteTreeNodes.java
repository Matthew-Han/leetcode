package bfs;

import tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName CountCompleteTreeNodes
 * @Description #222 完全二叉树的节点个数
 * @Author MatthewHan
 * @Date 2020/8/14 15:22
 * @Version 1.0
 **/
public class CountCompleteTreeNodes {

    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 11.57% 的用户
     * 内存消耗： 42.5 MB , 在所有 Java 提交中击败了 28.84% 的用户
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        boolean flag = true;
        while (!queue.isEmpty()) {
            int limit = queue.size();
            sum += limit;
            if (flag) {
                for (int i = 0; i < limit; i++) {
                    TreeNode curr = queue.poll();
                    if (curr.right == null) {
                        flag = false;
                    } else {
                        queue.offer(curr.right);
                    }
                    if (curr.left == null) {
                        flag = false;
                    } else {
                        queue.offer(curr.left);
                    }

                }
            } else {
                break;
            }
        }

        return sum;

    }
}
