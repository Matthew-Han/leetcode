package 贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName TwoCityScheduling
 * @Description #1029 两地调度
 * @Author MatthewHan
 * @Date 2020/8/31 02:23
 * @Version 1.0
 **/
public class No1029 {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 61.26% 的用户
     * 内存消耗： 38 MB , 在所有 Java 提交中击败了 27.00% 的用户
     *
     * @param costs
     * @return
     */
    public static int twoCitySchedCost(int[][] costs) {
        int ans = 0;
        int aCount = 0;
        int bCount = 0;
        int len = costs.length;
        Arrays.sort(costs, (o1, o2) -> Integer.compare(Math.abs(o2[0] - o2[1]), Math.abs(o1[0] - o1[1])));
        for (int[] cost : costs) {
            if (aCount < len / 2 && bCount < len / 2) {
                if (cost[0] < cost[1]) {
                    ans += cost[0];
                    aCount++;
                } else if (cost[0] > cost[1]) {
                    ans += cost[1];
                    bCount++;
                    // 两数相同的情况，随意选一个就行了，这些是「剩」下来的（因为排过序了，不会影响有差异的。）
                } else {
                    ans += cost[0];
                    aCount++;
                }
            } else {
                if (aCount == len / 2) {
                    ans += cost[1];
                } else {
                    ans += cost[0];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {10, 20}}));
    }
}

