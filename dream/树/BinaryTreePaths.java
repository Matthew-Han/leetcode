package 树;

import java.util.*;

/**
 * @ClassName BinaryTreePaths
 * @Description #257 二叉树的所有路径
 * @Author MatthewHan
 * @Date 2020/8/5 16:56
 * @Version 1.0
 **/
public class BinaryTreePaths {

    /**
     * 执行用时： 11 ms , 在所有 Java 提交中击败了 51.79% 的用户
     * 内存消耗： 40.2 MB , 在所有 Java 提交中击败了 13.03% 的用户
     *
     * @param root
     * @return
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res, "");
        System.out.println("res = " + res);
        return res;
    }

    public static void dfs(TreeNode node, List<String> res, String sb) {
        if (node != null) {
            sb += (node.val);
            if (isLeaf(node)) {
                res.add(sb);
            } else {
                sb += "->";
                dfs(node.left, res, sb);
                dfs(node.right, res, sb);
            }
        }

    }

    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        binaryTreePaths(node1);

    }

}
