package 第210场周赛;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MatthewHan
 * @version 1.0
 * @description
 * @date 2020/10/11 10:22
 **/
public class MaximalNetworkRank {


    /**
     * #5536 最大网络秩
     *
     * @param n
     * @param roads
     * @return
     */
    public int maximalNetworkRank(int n, int[][] roads) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int curr = length(roads, i) + length(roads, j);
                if (check(roads, i, j)) {
                    curr--;
                }
                max = Math.max(max, curr);
            }
        }
        return max;
    }

    public static int length(int[][] roads, int n) {
        int res = 0;
        for (int[] road : roads) {
            if (road[0] == n || road[1] == n) {
                res++;
            }
        }
        return res;
    }

    public static boolean check(int[][] road, int a, int b) {
        for (int[] ints : road) {
            if ((ints[0] == a && ints[1] == b) || (ints[0] == b && ints[1] == a)) {
                return true;
            }
        }
        return false;
    }

}
