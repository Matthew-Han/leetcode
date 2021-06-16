package 深度优先搜索;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/1 10:27
 **/
public class No526 {

    int ans;

    /**
     * #526 优美的排列
     * 年轻人的第一次的回溯,不要再 new 一个新的 vis 数组对象了!
     * 这样只需要一个 vis 数组对象!性能 8 错!
     * 执行用时： 100 ms , 在所有 Java 提交中击败了 29.07% 的用户
     * 内存消耗： 35 MB , 在所有 Java 提交中击败了 89.93% 的用户
     *
     * @param n
     * @return
     */
    public int countArrangement(int n) {
        ans = 0;
        for (int i = 1; i <= n; i++) {
            boolean[] vis = new boolean[n];
            vis[i - 1] = true;
            dfs(vis, 2, n);
        }
        return ans;

    }

    public void dfs(boolean[] vis, int index, int n) {
        if (index == n + 1) {
            ans++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!vis[i - 1] && (i % index == 0 || index % i == 0)) {
                vis[i - 1] = true;
                dfs(vis, index + 1, n);
                vis[i - 1] = false;
            }
        }
    }
}
