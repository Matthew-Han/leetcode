package dfs;

import tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MinimumDistanceBetweenBstNodes
 * @Description #783 二叉搜索树节点最小距离
 * @Author MatthewHan
 * @Date 2020/8/20 16:29
 * @Version 1.0
 **/
public class MinimumDistanceBetweenBstNodes {


    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.5 MB , 在所有 Java 提交中击败了 27.91% 的用户
     *
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        int min = Integer.MAX_VALUE;
        for (int i = res.size() - 1; i > 0; i--) {
            min = Math.min(min, res.get(i) - res.get(i - 1));
        }
        return min;
    }

    public static void dfs(TreeNode node, List<Integer> list) {
        if (node != null) {
            dfs(node.left, list);
            list.add(node.val);
            dfs(node.right, list);
        }
    }

}
