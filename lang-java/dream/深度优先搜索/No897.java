package 深度优先搜索;

import 默认模板.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IncreasingOrderSearchTree
 * @Description #897 递增顺序查找树
 * @Author MatthewHan
 * @Date 2020/8/11 10:58
 * @Version 1.0
 **/
public class No897 {


    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.6 MB , 在所有 Java 提交中击败了 21.59% 的用户
     *
     * @param root
     * @return
     */
    public TreeNode increasingBst(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        TreeNode node = new TreeNode(list.get(0));
        TreeNode res = node;
        for (int i = 1; i < list.size(); i++) {
            TreeNode sub = new TreeNode(list.get(i));
            node.left = null;
            node.right = sub;
            node = sub;
        }
        return res;
    }

    public static void dfs(TreeNode node, List<Integer> tmp) {
        if (node == null) {
            return;
        }
        dfs(node.left, tmp);
        tmp.add(node.val);
        dfs(node.right, tmp);
    }

}
