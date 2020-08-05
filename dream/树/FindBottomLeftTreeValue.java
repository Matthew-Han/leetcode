package 树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName FindBottomLeftTreeValue
 * @Description #513 找树左下角的值
 * @Author MatthewHan
 * @Date 2020/7/31 16:46
 * @Version 1.0
 **/
public class FindBottomLeftTreeValue {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 74.45% 的用户
     * 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 14.08% 的用户
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                TreeNode tmp = queue.poll();
                if (i == 0) {
                    res = tmp.val;
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }
        return res;
    }

}
