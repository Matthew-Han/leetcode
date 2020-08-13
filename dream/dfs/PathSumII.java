package dfs;

import tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PathSumII
 * @Description #113 路径总和 II
 * @Author MatthewHan
 * @Date 2020/8/13 11:07
 * @Version 1.0
 **/
public class PathSumII {


    /**
     * 用回溯法比较快，这里是拷贝
     * dfs切记对象拷贝问题
     * <p>
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 16.57% 的用户
     * 内存消耗： 42.8 MB , 在所有 Java 提交中击败了 5.01% 的用户
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int curr = 0;
        dfs(root, sum, res, curr, tmp);
        return res;

    }

    public static void dfs(TreeNode node, int sum, List<List<Integer>> res, int curr, List<Integer> tmp) {
        if (node == null) {
            return;
        }
        // 切记这里new一个新的对象
        tmp = new ArrayList<>(tmp);
        tmp.add(node.val);
        // 切记这里new一个新的对象
        int newCurr = curr + node.val;
        if (node.left == null && node.right == null && newCurr == sum) {
            res.add(tmp);
        }
        dfs(node.left, sum, res, newCurr, tmp);
        dfs(node.right, sum, res, newCurr, tmp);


    }

}
