package 深度优先搜索;

import 默认模板.TreeNode;

/**
 * @ClassName CountGoodNodesInBinaryTree
 * @Description #1448 统计二叉树中好节点的数目
 * @Author MatthewHan
 * @Date 2020/8/12 09:49
 * @Version 1.0
 **/
public class No1448 {


    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 27.62% 的用户
     * 内存消耗： 48.5 MB , 在所有 Java 提交中击败了 68.29% 的用户
     *
     * @param root
     * @return
     */
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, root.val);


    }

    public static int dfs(TreeNode node, int max) {
        int count = 0;
        if (node == null) {
            return 0;
        }
        if (node.val >= max) {
            count = 1;
            max = node.val;
        }
        return count + dfs(node.left, max) + dfs(node.right, max);
    }
}
