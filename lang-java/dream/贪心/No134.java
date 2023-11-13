package 贪心;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/18 11:02
 **/
public class No134 {

    int ans = -1;
    int pivot;

    /**
     * #134 加油站
     * <p>
     * 执行用时： 492 ms , 在所有 Java 提交中击败了 5.79% 的用户
     * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 5.10% 的用户
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            pivot = i;
            dfs(i, i + 1, gas[i], gas, cost);
            if (ans != -1) {
                return ans;
            }
        }
        return -1;

    }

    public void dfs(int start, int next, int surplus, int[] gas, int[] cost) {
        int len = gas.length;
        next %= len;
        surplus -= cost[start];
        // 油不够
        if (surplus < 0) {
            return;
        }
        // 刚好回到起点
        if (next == pivot) {
            ans = pivot;
            return;
        }
        surplus += gas[next];
        start++;
        next++;
        start %= len;
        next %= len;
        dfs(start, next, surplus, gas, cost);
    }
}
