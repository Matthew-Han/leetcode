package 树;

import 默认模板.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName FindLargestValueInEachTreeRow
 * @Description #515 在每个树行中找最大值
 * @Author MatthewHan
 * @Date 2020/8/3 15:08
 * @Version 1.0
 **/
public class No515 {

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 45.08% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 70.68% 的用户
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int limit = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < limit; i++) {
                TreeNode tmp = queue.poll();
                max = Math.max(max, tmp.val);
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
