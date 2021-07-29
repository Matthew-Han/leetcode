package 树;

import 默认模板.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/29 10:34
 * @since 1.0
 **/
public class No863 {

    List<Integer> ans;

    /**
     * 二叉树中所有距离为 K 的结点
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, map);
        dfs(map, new boolean[501][501], target.val, k, 0);
        return ans;

    }

    public void dfs(TreeNode node, Map<Integer, List<Integer>> map) {
        if (node == null) {
            return;
        }
        map.put(node.val, map.getOrDefault(node.val, new ArrayList<>()));
        if (node.left != null) {
            map.get(node.val).add(node.left.val);

            map.put(node.left.val, map.getOrDefault(node.left.val, new ArrayList<>()));
            map.get(node.left.val).add(node.val);
        }
        if (node.right != null) {
            map.get(node.val).add(node.right.val);

            map.put(node.right.val, map.getOrDefault(node.right.val, new ArrayList<>()));
            map.get(node.right.val).add(node.val);
        }
        dfs(node.left, map);
        dfs(node.right, map);

    }

    public void dfs(Map<Integer, List<Integer>> map, boolean[][] vis, int n, int k, int cnt) {
        if (cnt == k) {
            ans.add(n);
            return;
        }
        List<Integer> next = map.get(n);
        for (int i : next) {
            if (!vis[i][n] && !vis[n][i]) {
                vis[i][n] = true;
                vis[n][i] = true;
                dfs(map, vis, i, k, cnt + 1);
                vis[i][n] = false;
                vis[n][i] = false;
            }
        }
    }
}
