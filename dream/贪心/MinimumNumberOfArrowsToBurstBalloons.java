package 贪心;

import java.util.Arrays;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/23 09:50
 **/
public class MinimumNumberOfArrowsToBurstBalloons {

    /**
     * #452 用最少数量的箭引爆气球
     * <p>
     * 执行用时： 24 ms , 在所有 Java 提交中击败了 35.02% 的用户
     * 内存消耗： 46.1 MB , 在所有 Java 提交中击败了 72.93% 的用户
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        int ans = 1;
        // 这里排序不要用o1 - o2, 因为在坐标系里有 Integer.MAX_VALUE 和 integer.MIN_VALUE会溢出
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int len = points.length;
        int prev = points[0][1];
        for (int i = 1; i < len; i++) {
            if (points[i][0] > prev) {
                prev = points[i][1];
                ans++;
            }
        }
        return ans;
    }
}
