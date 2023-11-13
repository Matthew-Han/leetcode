package 深度优先搜索;

import 默认模板.TreeNode;

/**
 * @author MatthewHan
 * @version 1.0
 * @description
 * @date 2020/9/30 16:28
 **/
public class No437 {

    int total;

    /**
     * #437 路径总和 III
     * <p>
     * 执行用时： 30 ms , 在所有 Java 提交中击败了 61.24% 的用户
     * 内存消耗： 38.8 MB , 在所有 Java 提交中击败了 27.42% 的用户
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        gg(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return total;
    }


    public void gg(TreeNode node, int sum, int curr) {
        if (node == null) {
            return;
        }
        if (curr + node.val == sum) {
            total++;
        }
        gg(node.left, sum, curr + node.val);
        gg(node.right, sum, curr + node.val);
    }
}
