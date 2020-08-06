package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName BinaryTreeZigzagLevelOrderTraversal
 * @Description #103 二叉树的锯齿形层次遍历
 * @Author MatthewHan
 * @Date 2020/8/4 10:34
 * @Version 1.0
 **/
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int limit = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < limit; i++) {
                TreeNode tmp = queue.poll();
                if (flag) {
                    list.add(tmp.val);
                } else {
                    list.add(0, tmp.val);
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            res.add(list);
            flag = !flag;
        }
        return res;

    }

}
