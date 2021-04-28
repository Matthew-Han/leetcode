package bst;

import tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RangeSumOfBst
 * @Description #938 二叉搜索树的范围和
 * @Author MatthewHan
 * @Date 2020/8/7 11:50
 * @Version 1.0
 **/
public class RangeSumOfBst {

    /**
     * <date>2020/4/27</date>
     * 利用了 BST 的性质做优化
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 46.6 MB , 在所有 Java 提交中击败了 25.91% 的用户
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root != null) {
            // 利用 BST 的特性
            if (root.val > high) {
                return rangeSumBST(root.left, low, high);
            }
            if (root.val < low) {
                return rangeSumBST(root.right, low, high);
            }
            return root.val
                    + rangeSumBST(root.left, low, high)
                    + rangeSumBST(root.right, low, high);
        } else {
            return 0;
        }
    }

    /**
     * 当前节点的val比r大，只需要遍历左边
     * 当前节点的val比l小，只需要遍历右边
     * <p>
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 21.44% 的用户
     * 内存消耗： 46.9 MB , 在所有 Java 提交中击败了 97.98% 的用户
     *
     * @param root
     * @param l
     * @param r
     * @return
     */
    public int rangeSumBst(TreeNode root, int l, int r) {
        List<Integer> list = new ArrayList<>();
        dfs(list, l, r, root);
        int sum = 0;
        for (Integer n : list) {
            sum += n;
        }
        return sum;
    }

    public static void dfs(List<Integer> sum, int l, int r, TreeNode node) {
        if (node != null) {
            if (node.val >= l && node.val <= r) {
                System.out.println("node.val = " + node.val);
                sum.add(node.val);
                dfs(sum, l, r, node.left);
                dfs(sum, l, r, node.right);
            } else if (node.val > r) {
                dfs(sum, l, r, node.left);
            } else if (node.val < l) {
                dfs(sum, l, r, node.right);
            } else {
                dfs(sum, l, r, node.left);
                dfs(sum, l, r, node.right);
            }
        }

    }
}
