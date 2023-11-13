package 深度优先搜索;

import 默认模板.TreeNode;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/1/14 10:17
 **/
public class No563 {

    /**
     * @param root
     * @return
     * @date 2021.11.18
     */
    public int date20211118(TreeNode root) {
        fuck(root);
        return fuck2(root);
    }

    public void fuck(TreeNode node) {
        if (node == null) {
            return;
        }
        fuck(node.left);
        fuck(node.right);
        node.val += (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0);
    }

    public Character[] toCharArray(String word) {
        Character[] res = new Character[word.length()];
        for (int i = 0; i < word.length(); i++) {
            res[i] = word.charAt(i);
        }
        return res;
    }

    public int fuck2(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return Math.abs((node.left != null ? node.left.val : 0) - (node.right != null ? node.right.val : 0)) + fuck2(node.left) + fuck2(node.right);
        }
    }


    int ans = 0;
    int tmp = 0;

    /**
     * #563 二叉树的坡度
     * 执行用时： 15 ms , 在所有 Java 提交中击败了 14.00% 的用户
     * 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 11.47% 的用户
     *
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        c(node.left);
        int next = tmp;
        tmp = 0;
        c(node.right);
        ans += Math.abs(next - tmp);
        tmp = 0;

        dfs(node.left);
        dfs(node.right);
    }

    public void c(TreeNode root) {
        if (root == null) {
            return;
        }
        c(root.left);
        c(root.right);
        tmp += root.val;
    }

}
