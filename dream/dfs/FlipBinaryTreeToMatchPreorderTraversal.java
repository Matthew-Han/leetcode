package dfs;

import tree.TreeNode;
import java.util.List;

/**
 * @ClassName FlipBinaryTreeToMatchPreorderTraversal
 * @Description #971 翻转二叉树以匹配先序遍历
 * @Author MatthewHan
 * @Date 2020/8/27 16:38
 * @Version 1.0
 **/
public class FlipBinaryTreeToMatchPreorderTraversal {

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return null;
    }

    public static void dfs(TreeNode root1, TreeNode root2) {
        if (root1 == root2 && root1 == null) {
            return;
        } else if (root1 == null || root2 != null) {
            return;
        }
    }

}
