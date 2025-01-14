import 默认模板.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/15 10:00
 **/
public class L34 {

    List<List<Integer>> ans;

    /**
     * 剑指 Offer 34. 二叉树中和为某一值的路径
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 8.51% 的用户
     * 内存消耗： 41.1 MB , 在所有 Java 提交中击败了 5.00% 的用户
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(list, root, sum);
        return ans;
    }

    public void dfs(List<Integer> list, TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        list.set(0, list.getFirst() + node.val);
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (list.getFirst() == sum) {
                list.removeFirst();
                ans.add(list);
            }
            return;
        }
        dfs(new ArrayList<>(list), node.left, sum);
        dfs(new ArrayList<>(list), node.right, sum);

    }
}
