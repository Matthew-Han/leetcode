import 默认模板.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/29 15:51
 * @since 1.0
 **/
public class No1104 {
    List<Integer> list;

    boolean flag = false;

    List<Integer> ans;

    TreeNode node;

    /**
     * #1104 二叉树寻路
     *
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree(int label) {
        node = new TreeNode(1);
        list = new ArrayList<>();
        ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(label, 1, 1, 1);
        bfs(list, label);
        dfs(node, label, tmp);
        return ans;

    }

    public void dfs(TreeNode node, int label, List<Integer> tmp) {
        if (flag || node == null || node.val > label) {
            return;
        }
        if (node.val == label) {
            ans.addAll(tmp);
            ans.add(node.val);
            flag = true;
            return;
        }
        tmp.add(node.val);
        dfs(node.left, label, tmp);
        dfs(node.right, label, tmp);
        tmp.remove((Object) node.val);

    }

    public void bfs(List<Integer> list, int label) {
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 1;
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            curr.left = new TreeNode(list.get(index++));
            curr.right = new TreeNode(list.get(index++));
            if (index >= list.size()) {
                break;
            }
            queue.offer(curr.left);
            queue.offer(curr.right);

        }
    }

    public void dfs(int label, int curr, int size, int depth) {

        if ((depth & 1) == 1) {
            for (int i = curr; i < curr + size; i++) {
                list.add(i);
            }
        } else {
            for (int i = curr + size - 1; i >= curr; i--) {
                list.add(i);
            }
        }
        if (curr > label) {
            return;
        }
        dfs(label, curr + size, size + size, depth + 1);

    }
}
