package 深度优先搜索;

import 默认模板.TreeNode;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName SecondMinimumNodeInaBinaryTree
 * @Description #671 二叉树中第二小的节点
 * @Author MatthewHan
 * @Date 2020/8/6 18:22
 * @Version 1.0
 **/
public class No671 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 11.29% 的用户
     * 内存消耗： 37.1 MB , 在所有 Java 提交中击败了 23.71% 的用户
     *
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        dfs(set, root);
        int index = 0;
        for (Integer ans : set) {
            if (index == 1) {
                return ans;
            }
            index++;
        }
        return -1;
    }

    public static void dfs(Set<Integer> set, TreeNode node) {
        if (node != null) {
            set.add(node.val);
            dfs(set, node.left);
            dfs(set, node.right);
        }
    }
}