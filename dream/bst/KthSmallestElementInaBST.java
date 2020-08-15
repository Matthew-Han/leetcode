package bst;

import tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName KthSmallestElementInaBST
 * @Description #230 二叉搜索树中第K小的元素
 * @Author MatthewHan
 * @Date 2020/8/14 14:21
 * @Version 1.0
 **/
public class KthSmallestElementInaBST {


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 56.41% 的用户
     * 内存消耗： 41 MB , 在所有 Java 提交中击败了 5.06% 的用户
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        dfs(root, res, k);
        return res.get(k - 1);
    }

    public void dfs(TreeNode node, LinkedList<Integer> res, int k) {
        if (node != null) {
            dfs(node.left, res, k);
            res.add(node.val);
            dfs(node.right, res, k);
        }

    }


}
