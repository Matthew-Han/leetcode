package 广度优先搜索;

import 默认模板.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/30 10:06
 * @since 1.0
 **/
public class No297 {

    /**
     * #297 二叉树的序列化与反序列化
     *
     * @param node
     * @return
     */
    public String serialize(TreeNode node) {
        List<Integer> str = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (node == null) {
            return "";
        }
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                str.add(curr.val);
                queue.offer(curr.left);
                queue.offer(curr.right);
            } else {
                str.add(null);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer n : str) {
            sb.append(n).append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();

    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if ("null".equals(arr[0]) || "".equals(data)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int index = 1;
        while (index < arr.length) {
            TreeNode curr = queue.poll();
            if (!"null".equals(arr[index])) {
                curr.left = new TreeNode(Integer.parseInt(arr[index]));
                queue.offer(curr.left);
            }
            index++;
            if (!"null".equals(arr[index])) {
                curr.right = new TreeNode(Integer.parseInt(arr[index]));
                queue.offer(curr.right);
            }
            index++;
        }
        return node;
    }
}
