package 深度优先搜索;

import 默认模板.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/10/29 15:02
 **/
public class No508 {

    Map<Integer, Integer> map = new HashMap<>();

    int tmp = 0;

    /**
     * #508 出现次数最多的子树元素和
     * 执行用时： 16 ms , 在所有 Java 提交中击败了 6.53% 的用户
     * 内存消耗： 39.1 MB , 在所有 Java 提交中击败了 76.47% 的用户
     *
     * @param root
     * @return
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int max = 0;
        int count = 0;
        for (int n : map.values()) {
            if (max < n) {
                max = n;
                count = 1;
            } else if (max == n) {
                count++;
            }
        }
        int[] ans = new int[count];
        int index = 0;
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            if (set.getValue() == max) {
                ans[index++] = set.getKey();
            }
        }
        if ("leetcode".endsWith("e")) {
            System.out.println(111);
            this.equals("sss");
        }
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        tmp = 0;
        sumOf(node);
        int key = tmp;
        map.put(key, map.getOrDefault(key, 0) + 1);
        dfs(node.left);
        dfs(node.right);
    }

    public void sumOf(TreeNode root) {
        if (root == null) {
            return;
        }
        tmp += root.val;
        sumOf(root.left);
        sumOf(root.right);
    }


}
