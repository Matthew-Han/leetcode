package 广度优先搜索;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author MatthewHan
 * @version 1.0
 * @description
 * @date 2020/10/15 09:34
 **/
public class No116 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    /**
     * #116 填充每个节点的下一个右侧节点指针
     * <p>
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 10.14% 的用户
     * 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 96.88% 的用户
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int limit = queue.size();
            Queue<Node> tmp = new LinkedList<>();
            for (int i = 0; i < limit; i++) {
                Node curr = queue.poll();
                tmp.offer(curr);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            if (!tmp.isEmpty()) {
                Node head = tmp.poll();

                while (!tmp.isEmpty()) {
                    Node next = tmp.poll();
                    head.next = next;
                    head = next;
                }
            }
        }
        return root;

    }
}
