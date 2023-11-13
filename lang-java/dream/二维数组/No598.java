package 二维数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName 二维数组.RangeAdditionII
 * @Description #598 范围求和 II
 * @Author MatthewHan
 * @Date 2020/5/21 16:51
 * @Version 1.0
 **/
public class No598 {

    /**
     * 超出内存限制
     *
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public static int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        int[][] fucker = new int[m][n];
        Map<Integer, Integer> map = new HashMap<>(m * n * 4 / 3 + 1);
        for (int[] o : ops) {
            // 当二维数组的子数组不是2个元素
            if (o.length < 2) {
                return 0;
            }
            int x = o[0];
            int y = o[1];
            for (int i = 0; i < Math.min(x, m); i++) {
                for (int j = 0; j < Math.min(y, n); j++) {
                    fucker[i][j]++;
                }
            }
        }
        int max = 0;
        int sum = 0;
        for (int[] ints : fucker) {
            for (int j : ints) {
                if (j > max) {
                    max = j;
                    sum = 1;
                } else if (j == max) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        maxCount(39999, 39999, new int[][]{{19999, 19999}});
        int[][] xy = new int[1][3];
        xy[0][1] = 1;
        System.out.println(Arrays.deepToString(xy));
    }

    /**
     * 2021.11.08
     *
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public int date20211108(int m, int n, int[][] ops) {
        int ans = 0;
        int[] max = {0x3f3f3f3f, 0x3f3f3f3f};
        for (int[] o : ops) {
            max[0] = Math.min(max[0], o[0]);
            max[1] = Math.min(max[1], o[1]);
        }
        return ops.length > 0 ? max[0] * max[1] : m * n;
    }
}
