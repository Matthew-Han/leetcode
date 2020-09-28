package bfs;

import tree.FuckingNode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author MatthewHan
 * @version 1.0
 * @description
 * @date 2020/9/28 09:38
 **/
public class PopulatingNextRightPointersInEachNodeII {

    /**
     * #117 填充每个节点的下一个右侧节点指针 II
     * <p>
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 45.77% 的用户
     * 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 31.58% 的用户
     *
     * @param root
     * @return
     */
    public FuckingNode connect(FuckingNode root) {
        if (root == null) {
            return null;
        }
        Deque<FuckingNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            FuckingNode prev = queue.getFirst();
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                FuckingNode curr = queue.poll();
                if (i > 0) {
                    prev.next = curr;
                    prev = curr;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            prev.next = null;
        }
        return root;
    }

}
