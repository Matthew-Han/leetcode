package 树;

import 默认模板.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName BinaryTreeRightSideView
 * @Description #199 二叉树的右视图
 * @Author MatthewHan
 * @Date 2020/7/31 17:42
 * @Version 1.0
 **/
public class No199 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 94.88% 的用户
     * 内存消耗： 38.2 MB , 在所有 Java 提交中击败了 75.91% 的用户
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                TreeNode tmp = queue.poll();
                if (i == 0) {
                    list.add(tmp.val);
                }
                // 先遍历右边
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }

            }
        }
        return list;
    }
}
