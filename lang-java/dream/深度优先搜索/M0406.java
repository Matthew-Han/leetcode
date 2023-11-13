package 深度优先搜索;

import 默认模板.TreeNode;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/5/16 10:22 16
 * @since 1.0
 **/
public class M0406 {


    boolean flag = false;
    TreeNode ans = null;

    /**
     * 后继者
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return ans;
    }

    public void dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        dfs(root.left, p);
        if (flag) {
            ans = root;
            flag = false;
            return;
        }
        if (root == p) {
            flag = true;
        }
        dfs(root.right, p);
    }
}
