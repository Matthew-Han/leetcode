import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName MatrixCellsInDistanceOrder
 * @Description #1030 距离顺序排列矩阵单元格
 * @Author MatthewHan
 * @Date 2020/8/6 16:45
 * @Version 1.0
 **/
public class No1030 {

    /**
     * 执行用时： 22 ms , 在所有 Java 提交中击败了 19.39% 的用户
     * 内存消耗： 42 MB , 在所有 Java 提交中击败了 36.84% 的用户
     *
     * @param r
     * @param c
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder(int r, int c, int r0, int c0) {
        int[][] tmp = new int[r * c][3];
        int[][] data = new int[r][c];
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int distance = manhattanDistance(i, r0, j, c0);
                tmp[index++] = new int[]{i, j, distance};
            }
        }
        Arrays.sort(tmp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
        int[][] res = new int[r * c][2];
        for (int i = 0; i < tmp.length; i++) {
            res[i] = new int[]{tmp[i][0], tmp[i][1]};
        }

        return res;
    }

    public static int manhattanDistance(int r1, int r2, int c1, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
