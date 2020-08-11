package dfs;

import javafx.util.Pair;
import tree.TreeNode;
import 双指针.KdiffPairsInAnArray;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName LcOf55
 * @Description 剑指 Offer #55 - I 二叉树的深度
 * @Author MatthewHan
 * @Date 2020/8/11 10:28
 * @Version 1.0
 **/
public class LcOf55 {


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
