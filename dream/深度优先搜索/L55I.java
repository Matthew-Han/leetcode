package 深度优先搜索;

import 默认模板.TreeNode;

/**
 * @ClassName LcOf55
 * @Description 剑指 Offer #55 - I 二叉树的深度
 * @Author MatthewHan
 * @Date 2020/8/11 10:28
 * @Version 1.0
 **/
public class L55I {


    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max((dfs(root.left) + 1), dfs(root.right) + 1);
    }


}
