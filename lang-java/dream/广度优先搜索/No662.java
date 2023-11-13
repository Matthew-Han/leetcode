package 广度优先搜索;

import 默认模板.Pair;
import 默认模板.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/8/29 17:55 29
 * @since 1.0
 **/
public class No662 {

    /**
     * 二叉树最大宽度
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Long>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0L));
        int ans = 1;
        while (!q.isEmpty()) {
            int limit = q.size();
            long left = Long.MAX_VALUE;
            long right = Long.MIN_VALUE;
            for (int i = 0; i < limit; i++) {
                Pair<TreeNode, Long> curr = q.poll();
                TreeNode node = curr.getKey();
                Long idx = curr.getValue();
                left = Math.min(left, idx);
                right = Math.max(right, idx);
                if (node.left != null) {
                    q.offer(new Pair<>(node.left, 2 * idx));
                }
                if (node.right != null) {
                    q.offer(new Pair<>(node.right, 2 * idx + 1));
                }
            }
            ans = Math.max(ans, (int) (right - left + 1));
        }
        return ans;
    }

}
