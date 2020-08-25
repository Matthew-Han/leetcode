package dfs;

import tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName ConvertBstToGreaterTree
 * @Description #538 把二叉搜索树转换为累加树
 * @Author MatthewHan
 * @Date 2020/8/25 15:09
 * @Version 1.0
 **/
public class ConvertBstToGreaterTree {

    int sum = 0;

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 98.35% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 41.43% 的用户
     *
     * @param root
     * @return
     */
    public TreeNode convertBST2(TreeNode root) {
        dfs3(root);
        return root;
    }

    public void dfs3(TreeNode node) {
        if (node != null) {
            dfs3(node.right);
            node.val += sum;
            sum = node.val;
            System.out.println("sum = " + sum);
            dfs3(node.left);
        }
    }


    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 11.24% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 74.63% 的用户
     *
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        Stack<Integer> tmp = new Stack<>();
        dfs(root, tmp);
        dfs2(root, tmp);
        return root;
    }

    public static void dfs(TreeNode node, Stack<Integer> tmp) {
        if (node != null) {
            dfs(node.right, tmp);
            int temp = node.val;
            if (!tmp.isEmpty()) {
                temp += tmp.peek();
            }
            tmp.push(temp);
            dfs(node.left, tmp);
        }
    }

    public static void dfs2(TreeNode node, Stack<Integer> tmp) {
        if (node != null) {
            dfs(node.left, tmp);
            node.val = tmp.pop();
            dfs(node.right, tmp);
        }
    }
}
