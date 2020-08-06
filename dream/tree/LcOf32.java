package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName LcOf32
 * @Description 剑指 Offer #32 - I 从上到下打印二叉树
 * @Author MatthewHan
 * @Date 2020/7/31 17:34
 * @Version 1.0
 **/
public class LcOf32 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.66% 的用户
     * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 10.16% 的用户
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            list.add(tmp.val);
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
        // 这个lambda方法性能很拉胯
        // return list.stream().mapToInt(Integer::valueOf).toArray();
    }

}
