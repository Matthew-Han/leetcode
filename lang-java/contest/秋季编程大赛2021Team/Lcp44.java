package 秋季编程大赛2021Team;

import 默认模板.TreeNode;
import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/26 11:00
 * @since 1.0
 **/
public class Lcp44 {

    Set<Integer> set;

    /**
     * 开幕式火焰
     *
     * @param root
     * @return
     */
    public int numColor(TreeNode root) {
        set = new HashSet<>();
        dfs(root);
        return set.size();
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}


