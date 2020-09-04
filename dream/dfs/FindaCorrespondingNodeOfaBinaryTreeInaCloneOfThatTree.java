package dfs;

import tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName FindaCorrespondingNodeOfaBinaryTreeInaCloneOfThatTree
 * @Description #1379 找出克隆二叉树中的相同节点
 * @Author MatthewHan
 * @Date 2020/9/4 11:22
 * @Version 1.0
 **/
public class FindaCorrespondingNodeOfaBinaryTreeInaCloneOfThatTree {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(original);
        queue2.offer(cloned);
        while (!queue1.isEmpty()) {
            int limit = queue1.size();
            for (int i = 0; i < limit; i++) {
                TreeNode curr1 = queue1.poll();
                TreeNode curr2 = queue2.poll();
                if (curr1 == target) {
                    return curr2;
                }
                if (curr1.left != null) {
                    queue1.offer(curr1.left);
                    queue2.offer(curr2.left);
                }
                if (curr1.right != null) {
                    queue1.offer(curr1.right);
                    queue2.offer(curr2.right);
                }
            }
        }
        return null;
    }

    public static TreeNode dfs(TreeNode cloned, TreeNode target) {
        if (cloned == target) {
            return cloned;
        } else {
            if (cloned.left != null) {
                return dfs(cloned.left, target);
            }
            if (cloned.right != null) {
                return dfs(cloned.right, target);
            }
            return null;
        }
    }
}
