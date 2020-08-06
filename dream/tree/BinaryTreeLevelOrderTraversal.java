package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName BinaryTreeLevelOrderTraversal
 * @Description #102 二叉树的层序遍历
 * @Author MatthewHan
 * @Date 2020/8/3 09:25
 * @Version 1.0
 **/
public class BinaryTreeLevelOrderTraversal {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 91.61% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 41.47% 的用户
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int limit = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < limit; i++) {
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
