package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MinimumDepthOfBinaryTree
 * @Description #111 二叉树的最小深度
 * @Author MatthewHan
 * @Date 2020/7/31 02:08
 * @Version 1.0
 **/
public class MinimumDepthOfBinaryTree {

    /**
     * comment里中级的递归技巧：
     * <p>
     * 写出结束条件
     * 不要把树复杂化，就当做树是三个节点，根节点，左子节点，右子节点
     * 只考虑当前做什么，不用考虑下次应该做什么
     * 每次调用应该返回什么
     * <p>
     * 注意：最小深度定义为到最近叶子节点的深度,当左右子树都为空，最小深度才为1，所以[1, 2]最小深度是2，不是1
     * <p>
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 82.81% 的用户
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        if (root == null) {
            return 0;
        } else {
            queue.offer(root);
            depth++;
            while (!queue.isEmpty()) {
                int limit = queue.size();
                for (int i = 0; i < limit; i++) {
                    TreeNode tmp = queue.poll();
                    if (tmp.left == null && tmp.right == null) {
                        return depth;
                    }
                    if (tmp.left != null) {
                        queue.offer(tmp.left);
                    }
                    if (tmp.right != null) {
                        queue.offer(tmp.right);
                    }
                }
                depth++;
            }
            return depth;
        }
    }

}
