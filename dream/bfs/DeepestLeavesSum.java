package bfs;

import tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName DeepestLeavesSum
 * @Description #1302 层数最深叶子节点的和
 * @Author MatthewHan
 * @Date 2020/8/11 15:03
 * @Version 1.0
 **/
public class DeepestLeavesSum {


    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 50.16% 的用户
     * 内存消耗： 40.5 MB , 在所有 Java 提交中击败了 96.95% 的用户
     *
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int limit = queue.size();
            int sum = 0;
            for (int i = 0; i < limit; i++) {
                TreeNode tmp = queue.poll();
                sum += tmp.val;
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            ans = sum;
        }
        return ans;
    }
}
