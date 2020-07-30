/**
 * @ClassName CheckIfItIsaStraightLine
 * @Description #1232 缀点成线
 * @Author MatthewHan
 * @Date 2020/7/8 11:29
 * @Version 1.0
 **/
public class CheckIfItIsaStraightLine {

    /**
     * 求斜率
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 87.50% 的用户
     *
     * @param points
     * @return
     */
    public static boolean checkStraightLine(int[][] points) {

        for (int i = 0; i < points.length - 2; i++) {
            int x1 = points[i][0] - points[i + 1][0];
            int y1 = points[i][1] - points[i + 1][1];

            int x2 = points[i][0] - points[i + 2][0];
            int y2 = points[i][1] - points[i + 2][1];
            if (x1 * y2 != x2 * y1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][]{{0, 0}, {1, 1}, {7, 1}}));
    }
}
