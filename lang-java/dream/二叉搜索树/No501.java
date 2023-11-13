package 二叉搜索树;

import 默认模板.TreeNode;
import java.util.*;

/**
 * @ClassName FindModeInBinarySearchTree
 * @Description #501 二叉搜索树中的众数
 * @Author MatthewHan
 * @Date 2020/8/7 10:29
 * @Version 1.0
 **/
public class No501 {

    /**
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 13.49% 的用户
     * 内存消耗： 41.9 MB , 在所有 Java 提交中击败了 5.47% 的用户
     *
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);

        int maxCount = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxCount = Math.max(maxCount, entry.getValue());

        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node != null) {
            System.out.println(node.val);
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            dfs(node.left, map);
            dfs(node.right, map);
        }
    }


}

