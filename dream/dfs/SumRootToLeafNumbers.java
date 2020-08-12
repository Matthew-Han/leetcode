package dfs;

import tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SumRootToLeafNumbers
 * @Description #129 求根到叶子节点数字之和
 * @Author MatthewHan
 * @Date 2020/8/12 11:29
 * @Version 1.0
 **/
public class SumRootToLeafNumbers {


    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.4 MB , 在所有 Java 提交中击败了 78.94% 的用户
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    public static int dfs(TreeNode node, int tmp) {
        if (node == null) {
            return 0;
        }
        tmp *= 10;
        tmp += node.val;
        int sum = 0;
        if (node.left == null && node.right == null) {
            sum = tmp;
        }
        return sum + dfs(node.left, tmp) + dfs(node.right, tmp);
    }

}
