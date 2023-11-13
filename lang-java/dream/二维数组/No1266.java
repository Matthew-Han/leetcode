package 二维数组;

/**
 * @ClassName MinimumTimeVisitingAllPoints
 * @Description #1266 访问所有点的最小时间
 * @Author MatthewHan
 * @Date 2020/7/8 17:41
 * @Version 1.0
 **/
public class No1266 {


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 97.17% 的用户
     * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param points
     * @return
     */
    public static int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int x = Math.abs(points[i + 1][0] - points[i][0]);
            int y = Math.abs(points[i + 1][1] - points[i][1]);
            sum += Math.max(x, y);
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
