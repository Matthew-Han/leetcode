package 深度优先搜索;

import 默认模板.TreeNode;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/12/30 14:37
 **/
public class No236 {

    TreeNode res;
    boolean l = false;
    boolean r = false;

    /**
     * #236 二叉树的最近公共祖先
     * 执行用时： 1555 ms , 在所有 Java 提交中击败了 5.02% 的用户
     * 内存消耗： 40.4 MB , 在所有 Java 提交中击败了 79.81% 的用户
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    public void check(TreeNode curr, TreeNode p, TreeNode q) {
        if (curr == null) {
            return;
        }
        if (curr == p) {
            l = true;
        }
        if (curr == q) {
            r = true;
        }
        check(curr.left, p, q);
        check(curr.right, p, q);
    }

    public void dfs(TreeNode curr, TreeNode p, TreeNode q) {
        if (curr == null) {
            return;
        }
        l = false;
        r = false;
        check(curr, p, q);
        if (l && r) {
            res = curr;
            return;
        }
        dfs(curr.left, p, q);
        dfs(curr.right, p, q);
    }
}
