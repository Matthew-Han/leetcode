package 树;

import java.util.*;

/**
 * @ClassName BinaryTreeLevelOrderTraversalII
 * @Description #107 二叉树的层次遍历 II
 * @Author MatthewHan
 * @Date 2020/7/30 22:59
 * @Version 1.0
 **/
public class BinaryTreeLevelOrderTraversalII {


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 98.02% 的用户
     * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 17.95% 的用户
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int limit = queue.size();
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
        Collections.reverse(res);
        return res;

    }

}
