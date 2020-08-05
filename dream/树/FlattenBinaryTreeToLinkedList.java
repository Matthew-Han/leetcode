package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName FlattenBinaryTreeToLinkedList
 * @Description #114 二叉树展开为链表
 * @Author MatthewHan
 * @Date 2020/8/3 09:29
 * @Version 1.0
 **/
public class FlattenBinaryTreeToLinkedList {


    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 9.97% 的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 55.74% 的用户
     *
     * @param root
     */
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
            list.add(tmp);
        }
        if (list.size() == 1) {
            return;
        }
        for (TreeNode treeNode : list) {
            root.right = treeNode;
            root.left = null;
            root = root.right;
        }
        System.out.println("list = " + list);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(-111);
        treeNode.right.right = new TreeNode(6);

        flatten(treeNode);
    }

}
