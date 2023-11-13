package 树;

import 默认模板.TreeNode;
import java.util.*;

/**
 * @author Matthew Han
 * @description
 * @date 2021/4/27 10:24
 * @since 1.0.0
 **/
public class No297 {


    public static void main(String[] args) {
        No297 demo = new No297();
        //demo.deserialize("5,4,8,11,null,13,4,7,2,null,null,5,1");
        demo.deserialize("1,2,3,null,null,4,5");
        //demo.deserialize("5,2,3,null,null,2,4,3,1,1");
    }

    /**
     * #297 二叉树的序列化与反序列化
     * deserialize 不知道为什么 leetcode 那边序列化有点问题
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        List<List<Integer>> list = buildList(data);
        TreeNode root = new TreeNode(list.get(0).get(0));
        dfs(list, 0, 0, root);
        return root;
    }

    public void dfs(List<List<Integer>> list, int depth, int index, TreeNode node) {
        if (depth >= list.size() - 1) {
            return;
        }
        if (list.get(depth + 1).get(index * 2) != null) {
            node.left = new TreeNode(list.get(depth + 1).get(index * 2));
            dfs(list, depth + 1, index * 2, node.left);
        }
        if (list.get(depth + 1).get(index * 2 + 1) != null) {
            node.right = new TreeNode(list.get(depth + 1).get(index * 2 + 1));
            dfs(list, depth + 1, index * 2 + 1, node.right);
        }
    }

    public List<List<Integer>> buildList(String data) {
        int power = 0;
        int index = 0;
        String[] d = data.split(",");
        if ("null".equals(d[0])) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>(data.length());
        list.add(Collections.singletonList(Integer.valueOf(d[index++])));
        do {
            int currLen = (int) Math.pow(2, power);
            List<Integer> sub = new ArrayList<>(currLen);
            List<Integer> prevList = list.get(list.size() - 1);
            for (Integer integer : prevList) {
                if (integer == null) {
                    sub.add(null);
                    sub.add(null);
                } else {
                    if (index < d.length) {
                        sub.add("null".equals(d[index]) ? null : Integer.parseInt(d[index]));
                        index++;
                    } else {
                        sub.add(null);
                    }

                    if (index < d.length) {
                        sub.add("null".equals(d[index]) ? null : Integer.parseInt(d[index]));
                        index++;
                    } else {
                        sub.add(null);
                    }

                }
            }
            list.add(sub);
        } while (index < d.length);
        return list;
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                TreeNode curr = queue.poll();
                sb.append(curr == null ? "null" : curr.val).append(",");
                if (curr != null) {
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


}
