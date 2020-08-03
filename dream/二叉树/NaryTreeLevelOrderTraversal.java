package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName NaryTreeLevelOrderTraversal
 * @Description #429 N叉树的层序遍历
 * @Author MatthewHan
 * @Date 2020/7/31 17:08
 * @Version 1.0
 **/
public class NaryTreeLevelOrderTraversal {

    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 55.23% 的用户
     * 内存消耗： 40.5 MB , 在所有 Java 提交中击败了 81.33% 的用户
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int limit = queue.size();
            List<Integer> list = new ArrayList<>(limit);
            for (int i = 0; i < limit; i++) {
                Node tmp = queue.poll();
                list.add(tmp.val);
                List<Node> childNode = tmp.children;
                if (childNode != null) {
                    for (Node node : childNode) {
                        if (node != null) {
                            queue.offer(node);
                        }
                    }
                }
            }
            res.add(list);

        }
        return res;

    }

}
