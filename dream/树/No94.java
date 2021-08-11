package 树;

import 默认模板.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/11 16:52
 * @since 1.0
 **/
public class No94 {

    /**
     * 二叉树的中序遍历
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
}
