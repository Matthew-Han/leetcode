package 广度优先搜索;

import 默认模板.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/5/11 16:10 11
 * @since 1.0
 **/
public class No449 {

    /**
     * 序列化和反序列化二叉搜索树
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int limit = q.size();
            for (int i = 0; i < limit; i++) {
                TreeNode curr = q.poll();
                if (curr == null) {
                    sb.append("null,");
                } else {
                    sb.append(curr.val).append(",");
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }
        }
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        if ("null".equals(arr[0])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        int idx = 1;
        while (idx < arr.length) {
            for (int i = 0; i < q.size(); i++) {
                TreeNode curr = q.poll();
                String left = arr[idx++];
                String right = arr[idx++];
                if (!left.equals("null")) {
                    TreeNode leftNode = new TreeNode(Integer.parseInt(left));
                    curr.left = leftNode;
                    q.offer(leftNode);
                }
                if (!right.equals("null")) {
                    TreeNode rightNode = new TreeNode(Integer.parseInt(right));
                    curr.right = rightNode;
                    q.offer(rightNode);
                }
            }
        }
        return root;
    }
}
