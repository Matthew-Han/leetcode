package 树;

import 默认模板.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName LcOf32II
 * @Description 剑指 Offer #32 - II 从上到下打印二叉树 II
 * @Author MatthewHan
 * @Date 2020/7/29 18:55
 * @Version 1.0
 **/
public class L32II {


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 93.37% 的用户
     * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 11.36% 的用户
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int limit = queue.size();
            for (int i = limit; i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
            System.out.println("=======");
        }
        return res;


    }

    public static void bfs(TreeNode root, List<Integer> list) {

        if (root != null) {
            list.add(root.val);
            bfs(root.left, list);
            bfs(root.right, list);

        }

    }

}
