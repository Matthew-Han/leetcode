package 树;

import 默认模板.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/11 17:14
 * @since 1.0
 **/
public class No145 {

    /**
     * 二叉树的后序遍历
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
