package tree;

import java.util.*;

/**
 * @ClassName AverageOfLevelsInBinaryTree
 * @Description #637 二叉树的层平均值
 * @Author MatthewHan
 * @Date 2020/8/6 18:04
 * @Version 1.0
 **/
public class AverageOfLevelsInBinaryTree {




    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 99.17% 的用户
     * 内存消耗： 41.6 MB , 在所有 Java 提交中击败了 36.96% 的用户
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int limit = queue.size();
            double tmp = 0;
            for (int i = 0; i < limit; i++) {
                TreeNode curr = queue.poll();
                tmp += curr.val;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            res.add(tmp / limit);
        }
        return res;
    }


    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 73.72% 的用户
     * 内存消耗： 41.5 MB , 在所有 Java 提交中击败了 62.69% 的用户
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int limit = queue.size();
            double sum = 0.0;
            for (int i = 0; i < limit; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            sum /= limit;
            res.add(sum);
        }
        return res;
    }
}
