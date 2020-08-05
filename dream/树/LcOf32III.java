package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName LcOf32III
 * @Description 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * @Author MatthewHan
 * @Date 2020/8/3 17:33
 * @Version 1.0
 **/
public class LcOf32III {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.69% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 56.34% 的用户
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        boolean depth = false;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int limit = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < limit; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
                if (depth) {
                    list.add(0, tmp.val);
                } else {
                    list.add(tmp.val);
                }

            }
            depth = !depth;
            res.add(list);
        }

        return res;
    }
}
