package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/20 10:56 20
 * @since 1.0
 **/
public class No386 {

    List<Integer> ans;

    /**
     * 字典序排数
     *
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        this.ans = new ArrayList<>(n);
        for (int i = 1; i < 10; i++) {
            dfs(i, n);
        }

        return ans;
    }

    public void dfs(int curr, int n) {
        if (curr > n) {
            return;
        }
        ans.add(curr);
        for (int i = 0; i < 10; i++) {
            dfs(curr * 10 + i, n);
        }
    }

}
