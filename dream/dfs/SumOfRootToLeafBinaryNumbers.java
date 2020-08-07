package dfs;

import tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SumOfRootToLeafBinaryNumbers
 * @Description #1022 从根到叶的二进制数之和
 * @Author MatthewHan
 * @Date 2020/8/6 18:40
 * @Version 1.0
 **/
public class SumOfRootToLeafBinaryNumbers {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 24.57% 的用户
     * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 25.74% 的用户
     *
     * @param root
     * @return
     */
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        dfs(root.left, list, root.val);
        dfs(root.right, list, root.val);
        if (list.size() == 0) {
            return root.val;
        }
        int sum = 0;
        for (Integer n : list) {
            sum += n;
            sum %= 1000000007;
        }
        return sum;
    }

    public static void dfs(TreeNode node, List<Integer> list, int tmp) {
        if (node != null) {
            if (node.val == 0) {
                tmp <<= 1;
            } else {
                tmp <<= 1;
                tmp++;
            }
            tmp %= 1000000007;
            dfs(node.left, list, tmp);
            dfs(node.right, list, tmp);
            if (node.left == null && node.right == null) {
                list.add(tmp);
            }
        }
    }
}
