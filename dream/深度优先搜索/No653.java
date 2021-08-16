package 深度优先搜索;

import 默认模板.TreeNode;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/16 09:47
 * @since 1.0
 **/
public class No653 {

    Set<Integer> vis = new HashSet<>();

    /**
     * 两数之和 IV - 输入 BST
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (vis.contains(k - root.val)) {
            return true;
        } else {
            vis.add(root.val);
            return findTarget(root.left, k) || findTarget(root.right, k);
        }
    }
}
