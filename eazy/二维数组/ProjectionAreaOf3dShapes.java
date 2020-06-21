package 二维数组;

/**
 * @ClassName ProjectionAreaOf3dShapes
 * @Description #883 三维形体投影面积
 * @Author MatthewHan
 * @Date 2020/6/21 22:52
 * @Version 1.0
 **/
public class ProjectionAreaOf3dShapes {


    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 48.78% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param grid
     * @return
     */
    public static int projectionArea(int[][] grid) {
        int xyArea = 0;
        int xzArea = 0;
        int max = 0;
        for (int[] ints : grid) {
            int maxLine = 0;
            for (int i : ints) {
                maxLine = Math.max(maxLine, i);
                if (i != 0) {
                    xyArea++;
                }
            }
            xzArea += maxLine;
            max = Math.max(max, ints.length);
        }

        int yzArea = 0;
        for (int i = 0; i < max; i++) {
            int maxLine = 0;
            for (int[] ints : grid) {
                if (ints.length >= i) {
                    maxLine = Math.max(maxLine, ints[i]);
                }
            }
            yzArea += maxLine;
        }
        System.out.println("xyArea = " + xyArea);
        System.out.println("xzArea = " + xzArea);
        System.out.println("yzArea = " + yzArea);
        return xyArea + xzArea + yzArea;

    }


    public static void main(String[] args) {
        System.out.println(projectionArea(new int[][]{{1, 1, 1}, {1, 8, 1}, {1, 1, 1}}));
    }
}
