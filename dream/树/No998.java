package 树;

import 默认模板.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/8/30 16:30 30
 * @since 1.0
 **/
public class No998 {

    List<Integer> list;

    /**
     * 最大二叉树 II
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        list = dfs(root);
        list.add(val);
        TreeNode dummy = new TreeNode();
        build(dummy, 0, list.size());
        return dummy;
    }

    public void build(TreeNode root, int l, int r) {
        int idx = find(l, r);
        if (idx == -1) {
            return;
        }
        if (root == null) {
            root = new TreeNode(list.get(idx));
        } else {
            root.val = list.get(idx);
        }
        if (idx > l) {
            root.left = new TreeNode();
            build(root.left, l, idx);
        }
        if (idx + 1 < r) {
            root.right = new TreeNode();
            build(root.right, idx + 1, r);
        }
    }

    public int find(int l, int r) {
        if (l == r) {
            return -1;
        }
        int max = 0xc0c0c0c0;
        int idx = 0;
        for (int i = l; i < r; i++) {
            if (max <= list.get(i)) {
                max = list.get(i);
                idx = i;
            }
        }
        return idx;
    }

    public List<Integer> dfs(TreeNode root) {
        List<Integer> curr = new ArrayList<>();
        if (root != null) {
            curr.addAll(dfs(root.left));
            curr.add(root.val);
            curr.addAll(dfs(root.right));
        }
        return curr;
    }
}
