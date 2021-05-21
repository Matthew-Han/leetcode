package 树;

import 默认模板.TreeNode;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/29 09:09
 **/
public class No173 {


    TreeNode list = null;

    /**
     * #173 二叉搜索树迭代器
     * 执行用时： 23 ms , 在所有 Java 提交中击败了 62.72% 的用户
     * 内存消耗： 42.4 MB , 在所有 Java 提交中击败了 5.19% 的用户
     *
     * @param root
     */
    public No173(TreeNode root) {
        parseTree(root);
    }

    private void parseTree(TreeNode node) {
        if (node.right != null) {
            parseTree(node.right);
        }
        node.right = list;
        list = node;
        if (node.left != null) {
            parseTree(node.left);
        }
    }

    public int next() {
        int val = list.val;
        list = list.right;
        return val;
    }

    public boolean hasNext() {
        return list != null;
    }
}
