package 默认模板;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName TreeNode
 * @Description 二叉树公共类
 * @Author MatthewHan
 * @Date 2020/7/29 09:00
 * @Version 1.0
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    /**
     * 先序遍历迭代模板({中}, 左, 右)
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr != null) {
                ans.add(curr.val);
                if (curr.right != null) {
                    stack.add(curr.right);
                }
                if (curr.left != null) {
                    stack.add(curr.left);
                }
            }
        }
        return ans;
    }

    /**
     * 中序遍历迭代模板(左, {中}, 右)
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }

    /**
     * 后序遍历迭代模板(左, 右, {中})
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr != null) {
                ans.add(curr.val);
                if (curr.left != null) {
                    stack.add(curr.left);
                }
                if (curr.right != null) {
                    stack.add(curr.right);
                }
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
