package 链表;

import 默认模板.MultiNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/24 10:41
 * @since 1.0
 **/
public class No430 {

    List<MultiNode> ans;

    /**
     * 扁平化多级双向链表
     *
     * @param head
     * @return
     */
    public MultiNode flatten(MultiNode head) {
        ans = new ArrayList<>();
        dfs(head);
        if (ans.size() == 0 || ans.size() == 1) {
            return head;
        }
        ans.get(0).prev = null;
        ans.get(0).next = ans.get(1);
        ans.get(0).child = null;

        for (int i = 1; i < ans.size() - 1; i++) {
            ans.get(i).prev = ans.get(i - 1);
            ans.get(i).next = ans.get(i + 1);
            ans.get(i).child = null;
        }

        ans.get(ans.size() - 1).prev = ans.get(ans.size() - 2);
        ans.get(ans.size() - 1).next = null;
        ans.get(ans.size() - 1).child = null;

        return head;
    }

    public void dfs(MultiNode curr) {
        if (curr == null) {
            return;
        }
        ans.add(curr);
        if (curr.child != null) {
            dfs(curr.child);
        }
        dfs(curr.next);

    }
}
