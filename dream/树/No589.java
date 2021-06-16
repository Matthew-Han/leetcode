package 树;

import 默认模板.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NaryTreePreorderTraversal
 * @Description #589 N叉树的前序遍历
 * @Author MatthewHan
 * @Date 2020/8/7 16:04
 * @Version 1.0
 **/
public class No589 {

    /**
     * 先序遍历
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 96.31% 的用户
     * 内存消耗： 40.9 MB , 在所有 Java 提交中击败了 18.22% 的用户
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    public static void dfs(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.children != null) {
                for (Node child : root.children) {
                    dfs(child, list);
                }
            }
        }
    }

}
