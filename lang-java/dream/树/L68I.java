package 树;

import 默认模板.TreeNode;

/**
 * @ClassName LcOf68
 * @Description 剑指 Offer #68 - I 二叉搜索树的最近公共祖先
 * @Author MatthewHan
 * @Date 2020/8/7 11:15
 * @Version 1.0
 **/
public class L68I {

    /**
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 17.98% 的用户
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int pv = p.val, qv = q.val;
        if ((root.val - pv) * (root.val - qv) > 0) {
            if (root.val > pv) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return lowestCommonAncestor(root.right, p, q);
            }
        } else {
            return root;
        }
    }
}
