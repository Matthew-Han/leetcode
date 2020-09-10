package dfs;

import tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName AllElementsInTwoBinarySearchTrees
 * @Description #1305 两棵二叉搜索树中的所有元素
 * @Author MatthewHan
 * @Date 2020/9/10 19:29
 * @Version 1.0
 **/
public class AllElementsInTwoBinarySearchTrees {

    /**
     * 执行用时： 24 ms , 在所有 Java 提交中击败了 54.82% 的用户
     * 内存消耗： 41.9 MB , 在所有 Java 提交中击败了 97.73% 的用户
     *
     * @param root1
     * @param root2
     * @return
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> list = new ArrayList<>();
        dfs(root1, list);
        dfs(root2, list);
        Collections.sort(list);
        return list;
    }

    public static void dfs(TreeNode node, List<Integer> list) {
        if (node != null) {
            dfs(node.left, list);
            list.add(node.val);
            dfs(node.right, list);
        }
    }


}
