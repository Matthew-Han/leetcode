/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/4/4 01:12
 **/
public class RabbitsInForest {

    /**
     * #781 森林中的兔子
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 97.00% 的用户
     * 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 52.06% 的用户
     *
     * @param answers
     * @return
     */
    public int numRabbits(int[] answers) {
        int[] vis = new int[1000];
        int ans = 0;
        for (int answer : answers) {
            vis[answer]++;
        }
        for (int i = 0; i < vis.length; i++) {
            ans += (vis[i] + i) / (i + 1) * (i + 1);
        }
        return ans;
    }
}
