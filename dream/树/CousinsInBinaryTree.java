package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName CousinsInBinaryTree
 * @Description #993 二叉树的堂兄弟节点
 * @Author MatthewHan
 * @Date 2020/7/31 14:44
 * @Version 1.0
 **/
public class CousinsInBinaryTree {

    /**
     * 堂兄弟节点：同一层，不同父节点
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 60.15% 的用户
     * 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 19.35% 的用户
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        } else {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int limit = queue.size();
                for (int i = 0; i < limit; i++) {
                    TreeNode tmp = queue.poll();
                    // 筛选掉同父节点的情况
                    if (tmp.left != null && tmp.right != null) {
                        if ((tmp.left.val == x && tmp.right.val == y) || (tmp.left.val == y && tmp.right.val == x)) {
                            return false;
                        }
                    }
                    list.add(tmp.val);
                    if (tmp.left != null) {
                        queue.offer(tmp.left);
                    }
                    if (tmp.right != null) {
                        queue.offer(tmp.right);
                    }
                }
                if (list.contains(x) && list.contains(y)) {
                    return true;
                }

            }
            return false;
        }
    }
}
