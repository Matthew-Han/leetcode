package 深度优先搜索;

import 默认模板.TreeNode;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/6/2 11:10 02
 * @since 1.0
 **/
public class No450 {


    /**
     * 删除二叉搜索树中的节点
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy = new TreeNode(0x3f3f3f3f);
        dummy.left = root;
        dfs(dummy, key);
        return dummy.left;
    }

    public void dfs(TreeNode curr, int key) {
        if (curr == null) {
            return;
        }
        if (curr.left != null && curr.left.val == key) {
            ass(curr, curr.left.left, curr.left.right, true);

        } else if (curr.right != null && curr.right.val == key) {
            ass(curr, curr.right.left, curr.right.right, false);
        }
        if (curr.val <= key) {
            dfs(curr.right, key);
        } else {
            dfs(curr.left, key);
        }
    }

    public void ass(TreeNode curr, TreeNode l, TreeNode r, boolean flag) {
        if (l != null && r != null) {
            ass(r, l);
            if (flag) {
                curr.left = r;
            } else {
                curr.right = r;
            }
        } else if (l == null && r != null) {
            if (flag) {
                curr.left = r;
            } else {
                curr.right = r;
            }
        } else if (l != null) {
            if (flag) {
                curr.left = l;
            } else {
                curr.right = l;
            }
        } else {
            if (flag) {
                curr.left = null;
            } else {
                curr.right = null;
            }
        }
    }

    public void ass(TreeNode curr, TreeNode dest) {
        if (curr.left != null) {
            ass(curr.left, dest);
        } else {
            curr.left = dest;
        }
    }

}
