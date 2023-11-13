package 树;

import 默认模板.Pair;
import 默认模板.TreeNode;
import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/2 09:44
 * @since 1.0
 **/
public class No987 {

    /**
     * 二叉树的垂序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<Pair<TreeNode, int[]>> q = new LinkedList<>();
        q.offer(new Pair<>(root, new int[]{0, 0}));

        int depth = 0;
        while (!q.isEmpty()) {
            int limit = q.size();
            for (int i = 0; i < limit; i++) {
                Pair<TreeNode, int[]> p = q.poll();
                TreeNode node = p.getKey();
                int[] xy = p.getValue();
                map.put(xy[1], map.getOrDefault(xy[1], new ArrayList<>()));
                map.get(xy[1]).add(new int[]{xy[0], node.val});
                if (node.left != null) {
                    q.offer(new Pair<>(node.left, new int[]{depth, xy[1] - 1}));
                }
                if (node.right != null) {
                    q.offer(new Pair<>(node.right, new int[]{depth, xy[1] + 1}));
                }
            }
            depth++;
        }
        for (Map.Entry<Integer, List<int[]>> e : map.entrySet()) {
            List<Integer> sub = new ArrayList<>();
            e.getValue().sort((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            });
            for (int[] arr : e.getValue()) {
                sub.add(arr[1]);
            }
            ans.add(sub);
        }
        return ans;
    }
}
