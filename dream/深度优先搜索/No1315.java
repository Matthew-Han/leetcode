package 深度优先搜索;

import 默认模板.TreeNode;

/**
 * @ClassName SumOfNodesWithEvenValuedGrandparent
 * @Description #1315 祖父节点值为偶数的节点和
 * @Author MatthewHan
 * @Date 2020/8/11 11:26
 * @Version 1.0
 **/
public class No1315 {


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.8 MB , 在所有 Java 提交中击败了 70.68% 的用户
     *
     * @param root
     * @return
     */
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if ((root.val & 1) == 0) {
            if (root.left != null && root.left.left != null) {
                sum += root.left.left.val;
            }
            if (root.left != null && root.left.right != null) {
                sum += root.left.right.val;
            }
            if (root.right != null && root.right.left != null) {
                sum += root.right.left.val;
            }
            if (root.right != null && root.right.right != null) {
                sum += root.right.right.val;
            }
        }
        return sum + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);

    }
}
