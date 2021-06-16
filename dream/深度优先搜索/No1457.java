package 深度优先搜索;

import 默认模板.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PseudoPalindromicPathsInaBinaryTree
 * @Description #1457 二叉树中的伪回文路径
 * @Author MatthewHan
 * @Date 2020/8/12 14:36
 * @Version 1.0
 **/
public class No1457 {


    /**
     * 执行用时： 44 ms , 在所有 Java 提交中击败了 28.10% 的用户
     * 内存消耗： 62 MB , 在所有 Java 提交中击败了 20.00% 的用户
     *
     * @param root
     * @return
     */
    public int pseudoPalindromicPaths(TreeNode root) {
        int count = 0;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans, res);
        for (List<Integer> list : res) {
            if (check(list)) {
                count++;
            }
        }
        return count;

    }

    public static void dfs(TreeNode node, List<Integer> ans, List<List<Integer>> res) {
        if (node != null) {
            List<Integer> tmp = new ArrayList<>(ans);
            tmp.add(node.val);
            if (node.left == null && node.right == null) {
                res.add(tmp);
            }
            dfs(node.left, tmp, res);
            dfs(node.right, tmp, res);
        }
    }

    public static boolean check(List<Integer> ans) {
        int[] bucket = new int[10];
        for (Integer n : ans) {
            bucket[n]++;
        }
        int oddCount = 0;
        for (int i : bucket) {
            if ((i & 1) != 0) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }

}
