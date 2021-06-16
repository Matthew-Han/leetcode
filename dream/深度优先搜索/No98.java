package 深度优先搜索;

import 默认模板.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ValidateBinarySearchTree
 * @Description #98 验证二叉搜索树
 * @Author MatthewHan
 * @Date 2020/8/28 16:28
 * @Version 1.0
 **/
public class No98 {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 32.09% 的用户
     * 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 90.52% 的用户
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);

        return check(res);
    }


    public static void dfs(TreeNode node, List<Integer> res) {
        if (node != null) {
            dfs(node.left, res);
            res.add(node.val);
            dfs(node.right, res);
        }
    }

    public static boolean check(List<Integer> res) {
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(check(Arrays.asList(1, 2, 2, 3, 4)));
    }
}
