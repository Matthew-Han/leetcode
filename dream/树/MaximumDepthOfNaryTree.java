package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MaximumDepthOfNaryTree
 * @Description #559 N叉树的最大深度
 * @Author MatthewHan
 * @Date 2020/7/31 10:17
 * @Version 1.0
 **/
public class MaximumDepthOfNaryTree {

    public int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, dfs(child));
        }
        return max + 1;

    }


    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 19.61% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 68.96% 的用户
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {

        int depth = 0;
        if (root == null) {
            return 0;
        } else {
            Queue<Node> queue = new LinkedList<>();
            depth++;
            queue.offer(root);
            while (!queue.isEmpty()) {
                int limit = queue.size();
                boolean existed = false;
                for (int i = 0; i < limit; i++) {
                    Node tmp = queue.poll();
                    for (int j = 0; j < tmp.children.size(); j++) {
                        Node child = tmp.children.get(j);
                        if (child != null) {
                            queue.offer(child);
                            existed = true;
                        }
                    }
                }
                if (existed) {
                    depth++;
                }
            }
        }
        return depth;
    }

}
