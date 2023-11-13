package 树;

import 默认模板.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/11 16:51
 * @since 1.0
 **/
public class No144 {

    /**
     * 二叉树的前序遍历
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
}
