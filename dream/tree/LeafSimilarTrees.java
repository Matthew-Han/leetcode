package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeafSimilarTrees
 * @Description #872 叶子相似的树
 * @Author MatthewHan
 * @Date 2020/8/7 16:49
 * @Version 1.0
 **/
public class LeafSimilarTrees {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.4 MB , 在所有 Java 提交中击败了 77.19% 的用户
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> sum1 = new ArrayList<>();
        List<Integer> sum2 = new ArrayList<>();
        dfs(root1, sum1);
        dfs(root2, sum2);
        return sum1.equals(sum2);
    }

    public static void dfs(TreeNode root, List<Integer> sum) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                sum.add(root.val);
            }
            System.out.println("sum = " + sum);
            dfs(root.left, sum);
            dfs(root.right, sum);
        }
    }

}
