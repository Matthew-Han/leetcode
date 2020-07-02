import java.util.Arrays;

/**
 * @ClassName ValidBoomerang
 * @Description #1037 有效的回旋镖
 * @Author MatthewHan
 * @Date 2020/7/2 18:00
 * @Version 1.0
 **/
public class ValidBoomerang {


    /**
     * 求斜率
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.2 MB , 在所有 Java 提交中击败了 50.00% 的用户
     *
     * @param points
     * @return
     */
    public static boolean isBoomerangPro(int[][] points) {
        int x1 = points[0][0];
        int y1 = points[0][1];

        int x2 = points[1][0];
        int y2 = points[1][1];

        int x3 = points[2][0];
        int y3 = points[2][1];

        return (y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1);
    }


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 10.03% 的用户
     * 内存消耗： 37.4 MB , 在所有 Java 提交中击败了 50.00% 的用户
     *
     * @param points
     * @return
     */
    public static boolean isBoomerang(int[][] points) {
        if (Arrays.equals(points[0], points[1]) || Arrays.equals(points[1], points[2]) || Arrays.equals(points[0], points[2])) {
            return false;
        }
        if (points[0][0] == points[1][0] && points[0][0] == points[2][0]) {
            System.out.println(1);
            return false;
        }
        if (points[0][1] == points[1][1] && points[0][1] == points[2][1]) {
            System.out.println(2);
            return false;
        }
        if (points[1][0] - points[0][0] == points[1][1] - points[0][1] && points[2][0] - points[1][0] == points[2][1] - points[1][1]) {
            System.out.println(3);
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isBoomerang(new int[][]{{0, 0}, {2, 1}, {2, 1}}));
    }
}
